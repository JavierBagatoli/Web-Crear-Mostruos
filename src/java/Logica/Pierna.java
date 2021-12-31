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
public class Pierna implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_Pierna;
    @Basic
    private String Pierna;

    public int getId_Pierna() {
        return id_Pierna;
    }

    public void setId_Pierna(int id_Pierna) {
        this.id_Pierna = id_Pierna;
    }
    
    public String getPierna() {
        return Pierna;
    }

    public void setPierna(String Pierna) {
        this.Pierna = Pierna;
    }

    public Pierna() {
    }

    public Pierna(int id_Pierna, String Pierna) {
        this.id_Pierna = id_Pierna;
        this.Pierna = Pierna;
    }
    
    
}
