package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Kategorije;
import web.Korisnici;
import web.OglasPolje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-16T00:17:58")
@StaticMetamodel(Oglas.class)
public class Oglas_ { 

    public static volatile SingularAttribute<Oglas, Kategorije> idPodPodKat;
    public static volatile SingularAttribute<Oglas, Integer> id;
    public static volatile CollectionAttribute<Oglas, OglasPolje> oglasPoljeCollection;
    public static volatile SingularAttribute<Oglas, String> opis;
    public static volatile SingularAttribute<Oglas, Korisnici> idKorisnik;

}