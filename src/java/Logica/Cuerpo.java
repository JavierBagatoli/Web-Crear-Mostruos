/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author JavW11trial
 */
@Entity
public class Cuerpo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idCuerpo;
    @Basic
    private String nombre;
    private String descripcion;
    @OneToMany
    private ArrayList<Brazo> brazos;
    @OneToMany
    private ArrayList<Pierna> piernas;
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;

    public int getIdCuerpo() {
        return idCuerpo;
    }

    public void setIdCuerpo(int idCuerpo) {
        this.idCuerpo = idCuerpo;
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

    public ArrayList<Brazo> getBrazos() {
        return brazos;
    }

    public void setBrazos(ArrayList<Brazo> brazos) {
        this.brazos = brazos;
    }

    public ArrayList<Pierna> getPiernas() {
        return piernas;
    }

    public void setPiernas(ArrayList<Pierna> piernas) {
        this.piernas = piernas;
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

    public Cuerpo() {
    }

    public Cuerpo(int idCuerpo, String nombre, String descripcion, ArrayList<Brazo> brazos, ArrayList<Pierna> piernas, Firma firma, Visibilidad visibilidad) {
        this.idCuerpo = idCuerpo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.brazos = brazos;
        this.piernas = piernas;
        this.firma = firma;
        this.visibilidad = visibilidad;
    }
    
    
}
