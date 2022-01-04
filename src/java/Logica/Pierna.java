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
public class Pierna implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idPierna;
    @Basic
    private String nombrePierna;
    private String descripcion;
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;

    public int getIdPierna() {
        return idPierna;
    }

    public void setIdPierna(int idPierna) {
        this.idPierna = idPierna;
    }

    public String getNombrePierna() {
        return nombrePierna;
    }

    public void setNombrePierna(String nombrePierna) {
        this.nombrePierna = nombrePierna;
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

    public Pierna() {
    }

    public Pierna(int idPierna, String nombrePierna, String descripcion, Firma firma, Visibilidad visibilidad) {
        this.idPierna = idPierna;
        this.nombrePierna = nombrePierna;
        this.descripcion = descripcion;
        this.firma = firma;
        this.visibilidad = visibilidad;
    }
}
