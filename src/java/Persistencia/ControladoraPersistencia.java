/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JavW11trial
 */
public class ControladoraPersistencia {
    BrazoJpaController brazoJPA = new BrazoJpaController();
    CabezaJpaController cabezaJPA = new CabezaJpaController();
    CuerpoJpaController cuerpoJPA = new CuerpoJpaController();
    CriaturaJpaController criaturaJPA = new CriaturaJpaController();
    OjoJpaController ojoJPA = new OjoJpaController();
    PiernaJpaController piernaJPA = new PiernaJpaController();
    
    public void mostruoGeneradorRapido(Ojo ojo, Cabeza cabeza, Brazo brazo, Pierna pierna, Cuerpo cuerpo, Criatura criatura) {     
        ojoJPA.create(ojo);
        cabezaJPA.create(cabeza);
        brazoJPA.create(brazo);
        piernaJPA.create(pierna);
        cuerpoJPA.create(cuerpo);
        criaturaJPA.create(criatura);
        
    }

    public List<Criatura> traerCriaturas() {
        return criaturaJPA.findCriaturaEntities();
    }
    
}
