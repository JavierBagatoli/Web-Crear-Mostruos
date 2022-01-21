package Logica;

import Logica.Firma;
import Logica.Visibilidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Ojo.class)
public class Ojo_ { 

    public static volatile SingularAttribute<Ojo, String> descripcion;
    public static volatile SingularAttribute<Ojo, String> nombre;
    public static volatile SingularAttribute<Ojo, Firma> firma;
    public static volatile SingularAttribute<Ojo, Integer> idOjo;
    public static volatile SingularAttribute<Ojo, Visibilidad> visibilidad;

}