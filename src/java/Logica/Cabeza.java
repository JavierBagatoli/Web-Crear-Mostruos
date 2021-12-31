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
import javax.persistence.OneToMany;

/**
 *
 * @author JavW11trial
 */
@Entity
public class Cabeza implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_Cabeza;
    @OneToMany
    private ArrayList<Ojo> ojos;
    private String nombre;

    public int getId_Cabeza() {
        return id_Cabeza;
    }

    public void setId_Cabeza(int id_Cabeza) {
        this.id_Cabeza = id_Cabeza;
    }

    public ArrayList<Ojo> getOjos() {
        return ojos;
    }

    public void setOjos(ArrayList<Ojo> ojos) {
        this.ojos = ojos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cabeza() {
    }

    public Cabeza(int id_Cabeza, ArrayList<Ojo> ojos, String nombre) {
        this.id_Cabeza = id_Cabeza;
        this.ojos = ojos;
        this.nombre = nombre;
    }
    
    
}
