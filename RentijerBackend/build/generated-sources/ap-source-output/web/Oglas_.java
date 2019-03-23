package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Kategorije;
import web.Korisnici;
import web.OglasPolje;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-23T00:35:41")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-17T01:15:24")
>>>>>>> 2c05f27ce9bba18f318a41f4082b1b5735c9530f
@StaticMetamodel(Oglas.class)
public class Oglas_ { 

    public static volatile SingularAttribute<Oglas, Kategorije> idPodPodKat;
    public static volatile SingularAttribute<Oglas, Integer> id;
    public static volatile CollectionAttribute<Oglas, OglasPolje> oglasPoljeCollection;
    public static volatile SingularAttribute<Oglas, String> opis;
    public static volatile SingularAttribute<Oglas, Korisnici> idKorisnik;

}