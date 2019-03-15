package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.OglasPolje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-16T00:17:58")
@StaticMetamodel(Polja.class)
public class Polja_ { 

    public static volatile SingularAttribute<Polja, String> naziv;
    public static volatile SingularAttribute<Polja, Integer> id;
    public static volatile CollectionAttribute<Polja, OglasPolje> oglasPoljeCollection;

}