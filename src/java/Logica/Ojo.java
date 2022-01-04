/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JavW11trial
 */
@Entity
public class Ojo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idOjo;
    @Basic
    private String nombre;
    private String descripcion;
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;

    public int getIdOjo() {
        return idOjo;
    }

    public void setIdOjo(int idOjo) {
        this.idOjo = idOjo;
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

    public Ojo() {
    }

    public Ojo(int idOjo, String nombre, String descripcion, Firma firma, Visibilidad visibilidad) {
        this.idOjo = idOjo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.firma = firma;
        this.visibilidad = visibilidad;
    }
}
