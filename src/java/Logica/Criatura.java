/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author JavW11trial
 */
@Entity
public class Criatura implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idCriatura;
    @Basic
    private String nombre;
    private String descripcion;
    private short ferocidad;
    private short cantidadCabezas;                           
    @OneToOne
    private Cuerpo cuerpo;
    @OneToOne
    private Cabeza cabeza;
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;
    @OneToMany
    private ArrayList<Criatura> presaDe = new ArrayList<>();

    public int getIdCriatura() {
        return idCriatura;
    }

    public void setIdCriatura(int idCriatura) {
        this.idCriatura = idCriatura;
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

    public int getFerocidad() {
        return ferocidad;
    }

    public void setFerocidad(short ferocidad) {
        this.ferocidad = ferocidad;
    }

    public short getCantidadCabezas() {
        return cantidadCabezas;
    }

    public void setCantidadCabezas(short cantidadCabezas) {
        this.cantidadCabezas = cantidadCabezas;
    }

    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Cabeza getCabeza() {
        return cabeza;
    }

    public void setCabeza(Cabeza cabeza) {
        this.cabeza = cabeza;
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

    public List<Criatura> getPresaDe() {
        return presaDe;
    }

    public void setPresaDe(ArrayList<Criatura> presaDe) {
        this.presaDe = presaDe;
    }

    public Criatura() {
    }

    public Criatura(int idCriatura, String nombre, String descripcion, short ferocidad, short cantidadCabezas, Cuerpo cuerpo, Cabeza cabeza, Firma firma, Visibilidad visibilidad) {
        this.idCriatura = idCriatura;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ferocidad = ferocidad;
        this.cantidadCabezas = cantidadCabezas;
        this.cuerpo = cuerpo;
        this.cabeza = cabeza;
        this.firma = firma;
        this.visibilidad = visibilidad;
    }


}
