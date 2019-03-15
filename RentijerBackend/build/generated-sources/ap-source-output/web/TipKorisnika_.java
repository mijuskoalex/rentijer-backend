package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Korisnici;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T12:51:00")
@StaticMetamodel(TipKorisnika.class)
public class TipKorisnika_ { 

    public static volatile SingularAttribute<TipKorisnika, String> vrsta;
    public static volatile CollectionAttribute<TipKorisnika, Korisnici> korisniciCollection;
    public static volatile SingularAttribute<TipKorisnika, Integer> id;

}