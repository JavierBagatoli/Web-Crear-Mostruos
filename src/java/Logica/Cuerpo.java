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
    private int id_Persona;
    
    @OneToMany
    private ArrayList<Brazo> brazos;
    
    @OneToMany
    private ArrayList<Pierna> piernas;
    @Basic
    private String nombre;
    
    public Cuerpo() {
    }

    public Cuerpo(String nombre,int id_Persona, ArrayList<Brazo> brazos, ArrayList<Pierna> piernas) {
        this.nombre = nombre;
        this.id_Persona = id_Persona;
        this.brazos = brazos;
        this.piernas = piernas;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
