package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Visibilidad implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idVisibilidad;
    @Basic
    @ManyToOne
    private String visibilidad;

    public int getIdVisibilidad() {
        return idVisibilidad;
    }

    public void setIdVisibilidad(int idVisibilidad) {
        this.idVisibilidad = idVisibilidad;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public Visibilidad() {
    }

    public Visibilidad(int idVisibilidad, String visibilidad) {
        this.idVisibilidad = idVisibilidad;
        this.visibilidad = visibilidad;
    }
    
}
