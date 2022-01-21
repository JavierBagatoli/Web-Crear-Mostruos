package Logica;

import Logica.Cabeza;
import Logica.Cuerpo;
import Logica.Firma;
import Logica.Visibilidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Criatura.class)
public class Criatura_ { 

    public static volatile SingularAttribute<Criatura, String> descripcion;
    public static volatile SingularAttribute<Criatura, Visibilidad> visibildiad;
    public static volatile SingularAttribute<Criatura, Integer> idCriatura;
    public static volatile SingularAttribute<Criatura, Cabeza> cabeza;
    public static volatile SingularAttribute<Criatura, String> nombre;
    public static volatile SingularAttribute<Criatura, Firma> firma;
    public static volatile SingularAttribute<Criatura, Cuerpo> cuerpo;

}