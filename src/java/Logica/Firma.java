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
public class Firma implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idFirma;
    @Basic
    private String firma;

    public int getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(int idFirma) {
        this.idFirma = idFirma;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Firma() {
    }

    public Firma(int idFirma, String firma) {
        this.idFirma = idFirma;
        this.firma = firma;
    }
    
    
}
