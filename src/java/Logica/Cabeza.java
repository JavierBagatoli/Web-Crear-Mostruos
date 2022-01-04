/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Cabeza implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idCabeza;
    private String nombre;
    private String descripcion;
    @OneToMany
    private ArrayList<Ojo> ojos;
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;

    public int getIdCabeza() {
        return idCabeza;
    }

    public void setIdCabeza(int idCabeza) {
        this.idCabeza = idCabeza;
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

    public ArrayList<Ojo> getOjos() {
        return ojos;
    }

    public void setOjos(ArrayList<Ojo> ojos) {
        this.ojos = ojos;
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

    public Cabeza() {
    }

    public Cabeza(int idCabeza, String nombre, String descripcion, ArrayList<Ojo> ojos, Firma firma, Visibilidad visibilidad) {
        this.idCabeza = idCabeza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ojos = ojos;
        this.firma = firma;
        this.visibilidad = visibilidad;
    }

    
}
