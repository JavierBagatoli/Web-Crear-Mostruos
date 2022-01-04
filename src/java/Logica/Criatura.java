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
    @OneToOne
    private Cuerpo cuerpo;
    @OneToOne
    private Cabeza cabeza;
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibildiad;

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

    public Visibilidad getVisibildiad() {
        return visibildiad;
    }

    public void setVisibildiad(Visibilidad visibildiad) {
        this.visibildiad = visibildiad;
    }

    public Criatura() {
    }

    public Criatura(int idCriatura, String nombre, String descripcion, Cuerpo cuerpo, Cabeza cabeza, Firma firma, Visibilidad visibildiad) {
        this.idCriatura = idCriatura;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cuerpo = cuerpo;
        this.cabeza = cabeza;
        this.firma = firma;
        this.visibildiad = visibildiad;
    }
    
    
}
