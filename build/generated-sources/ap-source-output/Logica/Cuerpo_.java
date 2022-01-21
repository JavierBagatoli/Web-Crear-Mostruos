package Logica;

import Logica.Brazo;
import Logica.Firma;
import Logica.Pierna;
import Logica.Visibilidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Cuerpo.class)
public class Cuerpo_ { 

    public static volatile SingularAttribute<Cuerpo, String> descripcion;
    public static volatile ListAttribute<Cuerpo, Pierna> piernas;
    public static volatile ListAttribute<Cuerpo, Brazo> brazos;
    public static volatile SingularAttribute<Cuerpo, Integer> idCuerpo;
    public static volatile SingularAttribute<Cuerpo, String> nombre;
    public static volatile SingularAttribute<Cuerpo, Firma> firma;
    public static volatile SingularAttribute<Cuerpo, Visibilidad> visibilidad;

}