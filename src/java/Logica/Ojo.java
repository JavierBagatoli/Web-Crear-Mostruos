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
public class Ojo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_ojo;
    @Basic
    private String nombre;

    public int getId_ojo() {
        return id_ojo;
    }

    public void setId_ojo(int id_ojo) {
        this.id_ojo = id_ojo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ojo() {
    }

    public Ojo(int id_ojo, String nombre) {
        this.id_ojo = id_ojo;
        this.nombre = nombre;
    }
    
}
