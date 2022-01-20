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
    private short cantidadBrazos1;
    private short cantidadBrazos2;
    private short cantidadBrazos3;
    private short cantidadPiernas1;
    private short cantidadPiernas2;
    private short cantidadPiernas3;
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

    public short getCantidadBrazos1() {
        return cantidadBrazos1;
    }

    public void setCantidadBrazos1(short cantidadBrazos1) {
        this.cantidadBrazos1 = cantidadBrazos1;
    }

    public short getCantidadBrazos2() {
        return cantidadBrazos2;
    }

    public void setCantidadBrazos2(short cantidadBrazos2) {
        this.cantidadBrazos2 = cantidadBrazos2;
    }

    public short getCantidadBrazos3() {
        return cantidadBrazos3;
    }

    public void setCantidadBrazos3(short cantidadBrazos3) {
        this.cantidadBrazos3 = cantidadBrazos3;
    }

    public short getCantidadPiernas1() {
        return cantidadPiernas1;
    }

    public void setCantidadPiernas1(short cantidadPiernas1) {
        this.cantidadPiernas1 = cantidadPiernas1;
    }

    public short getCantidadPiernas2() {
        return cantidadPiernas2;
    }

    public void setCantidadPiernas2(short cantidadPiernas2) {
        this.cantidadPiernas2 = cantidadPiernas2;
    }

    public short getCantidadPiernas3() {
        return cantidadPiernas3;
    }

    public void setCantidadPiernas3(short cantidadPiernas3) {
        this.cantidadPiernas3 = cantidadPiernas3;
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

    public Cuerpo(int idCuerpo, String nombre, String descripcion, short cantidadBrazos1, short cantidadBrazos2, short cantidadBrazos3, short cantidadPiernas1, short cantidadPiernas2, short cantidadPiernas3, ArrayList<Brazo> brazos, ArrayList<Pierna> piernas, Firma firma, Visibilidad visibilidad) {
        this.idCuerpo = idCuerpo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadBrazos1 = cantidadBrazos1;
        this.cantidadBrazos2 = cantidadBrazos2;
        this.cantidadBrazos3 = cantidadBrazos3;
        this.cantidadPiernas1 = cantidadPiernas1;
        this.cantidadPiernas2 = cantidadPiernas2;
        this.cantidadPiernas3 = cantidadPiernas3;
        this.brazos = brazos;
        this.piernas = piernas;
        this.firma = firma;
        this.visibilidad = visibilidad;
    }

    
    
    
}
