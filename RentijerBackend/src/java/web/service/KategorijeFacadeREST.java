/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

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
    public List<Oglas> kategirije( @PathParam("id") Integer id) {
        return super.findByKat(id);
    }
    
    @GET
    @Path("polja/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OglasPolje> OglasPolje( @PathParam("id") Integer id) {
        Oglas k = (Oglas)getEntityManager().createNamedQuery("Oglas.findById").setParameter("id", id).getSingleResult();
        
        return k.getOglasPoljeCollection();
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
