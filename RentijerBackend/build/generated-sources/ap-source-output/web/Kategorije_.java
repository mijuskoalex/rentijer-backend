package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Oglas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-17T01:15:24")
@StaticMetamodel(Kategorije.class)
public class Kategorije_ { 

    public static volatile SingularAttribute<Kategorije, Integer> idKat;
    public static volatile SingularAttribute<Kategorije, String> naziv;
    public static volatile SingularAttribute<Kategorije, Integer> id;
    public static volatile SingularAttribute<Kategorije, Integer> idPodKat;
    public static volatile CollectionAttribute<Kategorije, Oglas> oglasCollection;

}