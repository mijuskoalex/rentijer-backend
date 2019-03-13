package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Oglas;
import web.TipKorisnika;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-13T13:58:22")
@StaticMetamodel(Korisnici.class)
public class Korisnici_ { 

    public static volatile SingularAttribute<Korisnici, String> ime;
    public static volatile SingularAttribute<Korisnici, String> prezime;
    public static volatile SingularAttribute<Korisnici, String> lozinka;
    public static volatile SingularAttribute<Korisnici, TipKorisnika> idTip;
    public static volatile SingularAttribute<Korisnici, String> brojTelefona;
    public static volatile SingularAttribute<Korisnici, Integer> id;
    public static volatile CollectionAttribute<Korisnici, Oglas> oglasCollection;
    public static volatile SingularAttribute<Korisnici, String> email;

}