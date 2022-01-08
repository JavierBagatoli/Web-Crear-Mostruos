package Logica.Ambiente;

import Logica.Firma;
import Logica.Visibilidad;
import java.util.ArrayList;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Planeta.class)
public class Planeta_ { 

    public static volatile SingularAttribute<Planeta, String> descripcion;
    public static volatile SingularAttribute<Planeta, Integer> idPlaneta;
    public static volatile SingularAttribute<Planeta, Integer> gravedad;
    public static volatile SingularAttribute<Planeta, String> tamanio;
    public static volatile SingularAttribute<Planeta, String> sistemaPlanetario;
    public static volatile SingularAttribute<Planeta, ArrayList> recursosLista;
    public static volatile SingularAttribute<Planeta, String> nombre;
    public static volatile SingularAttribute<Planeta, Firma> firma;
    public static volatile SingularAttribute<Planeta, Visibilidad> visibilidad;

}