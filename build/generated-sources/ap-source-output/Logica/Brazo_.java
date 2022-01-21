package Logica;

import Logica.Firma;
import Logica.Visibilidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Brazo.class)
public class Brazo_ { 

    public static volatile SingularAttribute<Brazo, String> descripcion;
    public static volatile SingularAttribute<Brazo, Integer> idBrazo;
    public static volatile SingularAttribute<Brazo, String> nombre;
    public static volatile SingularAttribute<Brazo, Firma> firma;
    public static volatile SingularAttribute<Brazo, Visibilidad> visibilidad;

}