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
import javax.persistence.OneToOne;

/**
 *
 * @author JavW11trial
 */
@Entity
public class Criatura implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_Criatura;
    @Basic
    private String nombre;
    @OneToOne
    private Cuerpo cuerpo;
    @OneToOne
    private Cabeza cabeza;
    

    public Criatura() {
    }

    public Criatura(int id_Criatura,Cuerpo cuerpo, Cabeza cabeza, String nombre) {
        this.id_Criatura = id_Criatura;
        this.cuerpo = cuerpo;
        this.cabeza = cabeza;
        this.nombre = nombre;
    }

    public int getId_Criatura() {
        return id_Criatura;
    }

    public void setId_Criatura(int id_Criatura) {
        this.id_Criatura = id_Criatura;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
