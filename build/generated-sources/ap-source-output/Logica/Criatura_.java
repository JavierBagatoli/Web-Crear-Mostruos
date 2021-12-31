package Logica;

import Logica.Cabeza;
import Logica.Cuerpo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-31T09:52:27")
@StaticMetamodel(Criatura.class)
public class Criatura_ { 

    public static volatile SingularAttribute<Criatura, Integer> id_Criatura;
    public static volatile SingularAttribute<Criatura, Cabeza> cabeza;
    public static volatile SingularAttribute<Criatura, String> nombre;
    public static volatile SingularAttribute<Criatura, Cuerpo> cuerpo;

}