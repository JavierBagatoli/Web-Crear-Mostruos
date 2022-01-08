package Logica.Ambiente;

import Logica.Ambiente.Planeta;
import Logica.Firma;
import Logica.Visibilidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Clima.class)
public class Clima_ { 

    public static volatile SingularAttribute<Clima, String> descripcion;
    public static volatile SingularAttribute<Clima, int[]> viento;
    public static volatile SingularAttribute<Clima, int[]> precipitaciones;
    public static volatile SingularAttribute<Clima, Planeta> planeta;
    public static volatile SingularAttribute<Clima, Integer> idClima;
    public static volatile SingularAttribute<Clima, int[]> temperatura;
    public static volatile SingularAttribute<Clima, int[]> humedad;
    public static volatile SingularAttribute<Clima, String> nombre;
    public static volatile SingularAttribute<Clima, Firma> firma;
    public static volatile SingularAttribute<Clima, Visibilidad> visibilidad;

}