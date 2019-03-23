/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import web.Kategorije;
import web.Korisnici;
import web.Oglas;
import web.OglasPolje;
import web.TipKorisnika;


/**
 *
 * @author WinPC
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<Oglas> findByKat(int id) {
        Kategorije k = (Kategorije) getEntityManager().createNamedQuery("Kategorije.findById").setParameter("id", id).getSingleResult();
        List<Oglas> oglasi = getEntityManager().createNamedQuery("Oglas.findByIdPodPodKat").setParameter("id", k).getResultList();
        return oglasi;
    }
    public String login(String email, String lozinka) throws Exception{
        Korisnici korisnik = (Korisnici) getEntityManager().createNamedQuery("Korisnici.login").setParameter("email", email).setParameter("lozinka", lozinka).getSingleResult(); 
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("lozinka", lozinka);
        String jwtString = null;
        if(korisnik != null){
            try{
                jwtString = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "secret".getBytes("UTF-8")).setIssuedAt(new Date()).compact();
               
            }catch(Exception e){
                 e.printStackTrace();
                 throw new Exception("Fail to create JWT");
            }
        }
        return jwtString;
    }
    public String register(String ime, String prezime, String email, String lozinka){
        TipKorisnika tip = (TipKorisnika) getEntityManager().createNamedQuery("TipKorisnika.findById").setParameter("id", 1).getSingleResult();
        
        getEntityManager().createNativeQuery("INSERT INTO Korisnici (ime, prezime, email, lozinka, idTip) values (?, ?, ?, ?, ?)").setParameter(1, ime)
                                                                             .setParameter(2, prezime)
                                                                             .setParameter(3, email)
                                                                             .setParameter(4, lozinka)
                                                                             .setParameter(5, tip.getId())
                                                                             .executeUpdate();
        Korisnici k = (Korisnici)getEntityManager().createNamedQuery("Korisnici.findByEmail").setParameter("email", email).getSingleResult();
        getEntityManager().persist(k);
        getEntityManager().flush();
        return "";
    }

}
