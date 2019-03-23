/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

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
import web.Korisnici;

/**
 *
 * @author WinPC
 */
@Stateless
@Path("web.korisnici")
public class KorisniciFacadeREST extends AbstractFacade<Korisnici> {

    @PersistenceContext(unitName = "RentijerBackendPU")
    private EntityManager em;

    public KorisniciFacadeREST() {
        super(Korisnici.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Korisnici entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Korisnici entity) {
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
    public Korisnici find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Korisnici> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Korisnici> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @GET
    @Path("login/{email}/{lozinka}")
    @Produces({MediaType.APPLICATION_JSON})
    public String login(@PathParam("email") String email, @PathParam("lozinka") String lozinka) throws Exception{
         return super.login(email, lozinka);
    }
    @GET
    @Path("register/{email}/{ime}/{prezime}/{lozinka}")
    @Produces({MediaType.APPLICATION_JSON})
    public String register(@PathParam("email") String email, @PathParam("ime") String ime, @PathParam("prezime") String prezime, @PathParam("lozinka") String lozinka){
        Korisnici k = new Korisnici();
        k.setIme(ime);
        k.setPrezime(prezime);
        k.setEmail(email);
        k.setLozinka(lozinka);
        
        return super.register(ime, prezime, email, lozinka);
    }
}
