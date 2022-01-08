package Logica;

import Logica.Firma;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-01-06T08:28:54")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, Firma> firma;
    public static volatile SingularAttribute<Persona, Integer> idPersona;
    public static volatile SingularAttribute<Persona, String> email;
    public static volatile SingularAttribute<Persona, String> contra;

}