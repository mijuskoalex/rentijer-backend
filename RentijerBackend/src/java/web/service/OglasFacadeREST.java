/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import JSONObjects.LandingJSON;
import JSONObjects.OglasJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Collections;
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
@Path("oglasi")
public class OglasFacadeREST extends AbstractFacade<Oglas> {

    @PersistenceContext(unitName = "RentijerBackendPU")
    private EntityManager em;

    public OglasFacadeREST() {
        super(Oglas.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Oglas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Oglas entity) {
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
    public Oglas find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<OglasPolje> getAll() {
        Oglas k = new Oglas();
        if (getEntityManager().createNamedQuery("Oglas.findAll").getResultList().size() == 0) {
            k.setOglasPoljeCollection(Collections.EMPTY_LIST);
        } else {
            Collection<OglasPolje> cop = getEntityManager().createNamedQuery("Oglas.findAll").getResultList();
            k.setOglasPoljeCollection(cop);
        }
        return k.getOglasPoljeCollection();
    }

    @GET
    @Path("landing")
    @Produces({MediaType.APPLICATION_JSON})
    public String GetLandingData() throws JsonProcessingException {

        List<LandingJSON> kategorijeRet = new ArrayList<LandingJSON>();

        List<Kategorije> kategorije = getEntityManager().createNamedQuery("Kategorije.AllKats").getResultList();

        for (int i = 0; i < kategorije.size(); i++) {
            LandingJSON trenutnaKategorija = new LandingJSON();
            trenutnaKategorija.setNaziv(kategorije.get(i).getNaziv());
            trenutnaKategorija.setId(kategorije.get(i).getId());
            List<Oglas> oglasi = getEntityManager().createNamedQuery("Oglas.findByIdKat").setParameter("id", kategorije.get(i).getId()).getResultList();
            List<OglasJSON> oglJson = new ArrayList<OglasJSON>();
            for (int j = 0; j < oglasi.size(); j++) {
                OglasJSON temp = new OglasJSON(oglasi.get(j));
                oglJson.add(temp);
            }
            System.out.println(oglJson);
            trenutnaKategorija.setOglasi(oglJson);
            kategorijeRet.add(trenutnaKategorija);
        }

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(kategorijeRet);
        System.out.println(json);

        return json;
    }

    @GET
    @Path("kategorija/{kategorija}")
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<OglasPolje> findBykat(@PathParam("kategorija") Integer kategorija) {
        Oglas k = new Oglas();
        if (getEntityManager().createNamedQuery("Oglas.findByIdPodPodKat").setParameter("id", kategorija).getResultList().size() == 0) {
            k.setOglasPoljeCollection(Collections.EMPTY_LIST);
        } else {
            Collection<OglasPolje> cop = getEntityManager().createNamedQuery("Oglas.findByIdPodPodKat").setParameter("id", kategorija).getResultList();
            k.setOglasPoljeCollection(cop);
        }
        return k.getOglasPoljeCollection();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Oglas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
