/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import JSONObjects.KategorijeJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import web.Kategorije;
import web.Oglas;
import web.OglasPolje;

/**
 *
 * @author WinPC
 */
@Stateless
@Path("web.kategorije")
public class KategorijeFacadeREST extends AbstractFacade<Kategorije> {

    @PersistenceContext(unitName = "RentijerBackendPU")
    private EntityManager em;

    public KategorijeFacadeREST() {
        super(Kategorije.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Kategorije entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Kategorije entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Kategorije find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Kategorije> findAll() {
        return super.findAll();
    }

    @GET
    @Path("kategorija/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Oglas> kategorije(@PathParam("id") Integer id) {
        return super.findByKat(id);
    }

    @GET
    @Path("polja/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OglasPolje> OglasPolje(@PathParam("id") Integer id) {
        Oglas k = (Oglas) getEntityManager().createNamedQuery("Oglas.findById").setParameter("id", id).getSingleResult();

        return k.getOglasPoljeCollection();
    }

    @GET
    @Path("kategorije")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kategorije> Kategorije() {
        List<Kategorije> kategorije = getEntityManager().createNamedQuery("Kategorije.AllKats").getResultList();
        return kategorije;
    }

    @GET
    @Path("PodKategorije/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kategorije> PodKategorije(@PathParam("id") Integer id) {
        List<Kategorije> kategorije = getEntityManager().createNamedQuery("Kategorije.AllPodKatsForKat").setParameter("idKat", id).getResultList();
        return kategorije;
    }

    @GET
    @Path("PodPodKategorije/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kategorije> PododKategorije(@PathParam("id") Integer id) {
        List<Kategorije> kategorije = getEntityManager().createNamedQuery("Kategorije.AllPodPodKatsForPodKat").setParameter("idPodKat", id).getResultList();
        return kategorije;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Kategorije> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("all")
    @Produces(MediaType.TEXT_PLAIN)
    public String Test() throws JsonProcessingException {

        List<KategorijeJSON> kategorijeRet = new ArrayList<KategorijeJSON>();

        List<Kategorije> kategorije = getEntityManager().createNamedQuery("Kategorije.AllKats").getResultList();

        for (int i = 0; i < kategorije.size(); i++) {
            KategorijeJSON trenutnaKategorija = new KategorijeJSON();
            trenutnaKategorija.setNaziv(kategorije.get(i).getNaziv());
            trenutnaKategorija.setId(kategorije.get(i).getId());
            List<Kategorije> podKategorije = getEntityManager().createNamedQuery("Kategorije.AllPodKatsForKat").setParameter("idKat", kategorije.get(i).getId()).getResultList();
            List<KategorijeJSON> podKats = new ArrayList<KategorijeJSON>();
            for (int j = 0; j < podKategorije.size(); j++) {
                KategorijeJSON trenutnaPodKategorija = new KategorijeJSON();
                trenutnaPodKategorija.setId(podKategorije.get(j).getId());
                trenutnaPodKategorija.setNaziv(podKategorije.get(j).getNaziv());
                List<Kategorije> podPodKategorije = getEntityManager().createNamedQuery("Kategorije.AllPodPodKatsForPodKat").setParameter("idPodKat", podKategorije.get(j).getId()).getResultList();
                List<KategorijeJSON> podPodKats = new ArrayList<KategorijeJSON>();

                for (int n = 0; n < podPodKategorije.size(); n++) {
                    KategorijeJSON trenutnaPodpodKategorija = new KategorijeJSON();
                    trenutnaPodpodKategorija.setId(podPodKategorije.get(n).getId());
                    trenutnaPodpodKategorija.setNaziv(podPodKategorije.get(n).getNaziv());
                    podPodKats.add(trenutnaPodpodKategorija);
                }

                if (podPodKats.size() > 0) {
                    trenutnaPodKategorija.setChildren(podPodKats);
                }
                podKats.add(trenutnaPodKategorija);
            }
            trenutnaKategorija.setChildren(podKats);
            kategorijeRet.add(trenutnaKategorija);
        }

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(kategorijeRet);

        return json;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
