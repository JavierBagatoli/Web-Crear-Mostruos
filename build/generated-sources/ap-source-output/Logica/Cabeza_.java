package Logica;

import Logica.Firma;
import Logica.Ojo;
import Logica.Visibilidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Cabeza.class)
public class Cabeza_ { 

    public static volatile SingularAttribute<Cabeza, String> descripcion;
    public static volatile SingularAttribute<Cabeza, Integer> idCabeza;
    public static volatile ListAttribute<Cabeza, Ojo> ojos;
    public static volatile SingularAttribute<Cabeza, String> nombre;
    public static volatile SingularAttribute<Cabeza, Firma> firma;
    public static volatile SingularAttribute<Cabeza, Visibilidad> visibilidad;

}