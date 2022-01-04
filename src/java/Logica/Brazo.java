package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Brazo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idBrazo;
    @Basic
    private String nombre;
    private String descripcion;
    
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;

    public int getIdBrazo() {
        return idBrazo;
    }

    public void setIdBrazo(int idBrazo) {
        this.idBrazo = idBrazo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Visibilidad getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }

    public Brazo() {
    }

    public Brazo(int idBrazo, String nombre, String descripcion, Firma firma, Visibilidad visibilidad) {
        this.idBrazo = idBrazo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.firma = firma;
        this.visibilidad = visibilidad;
    } 
}
