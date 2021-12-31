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

/**
 *
 * @author JavW11trial
 */
@Entity
public class Brazo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_Brazo;
    @Basic
    private String nombre;

    public int getId_Brazo() {
        return id_Brazo;
    }

    public void setId_Brazo(int id_Brazo) {
        this.id_Brazo = id_Brazo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Brazo() {
    }

    public Brazo(int id_Brazo, String nombre) {
        this.id_Brazo = id_Brazo;
        this.nombre = nombre;
    }
    
    
}
