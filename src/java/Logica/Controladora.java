/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JavW11trial
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void mostruoGeneradorRapido(String nombreMostruo, String nombreCabeza, String nombreOjo, String nombreCuerpo, String nombreBrazo, String nombrePierna) {
        Ojo ojo = new Ojo();
        ojo.setNombre(nombreOjo);
        
        Cabeza cabeza = new Cabeza();
        cabeza.setNombre(nombreCabeza);
        ArrayList<Ojo> ojos = new ArrayList<Ojo>();
        ojos.add(ojo);
        cabeza.setOjos(ojos);
        
        Brazo brazo = new Brazo();
        brazo.setNombre(nombreBrazo);

        Pierna pierna = new Pierna();
        pierna.setPierna(nombrePierna);
        
        Cuerpo cuerpo = new Cuerpo();
        cuerpo.setNombre(nombreCuerpo);
        ArrayList<Brazo> brazos = new ArrayList<Brazo>();
        brazos.add(brazo);
        ArrayList<Pierna> piernas = new ArrayList<Pierna>();
        piernas.add(pierna);
        cuerpo.setBrazos(brazos);
        cuerpo.setPiernas(piernas);
        
        Criatura criatura = new Criatura();
        criatura.setNombre(nombreMostruo);
        criatura.setCabeza(cabeza);
        criatura.setCuerpo(cuerpo);
        
        controlPersis.mostruoGeneradorRapido(ojo, cabeza, brazo, pierna, cuerpo, criatura);
    }
    
    public List<Criatura> traerCriaturas(){
        return controlPersis.traerCriaturas();
    }

    public Criatura buscarCriatura(int id) {
        try{
            return controlPersis.buscarCriatura(id);
        }catch(Exception e){
            
        }
        return null;
    }
}
