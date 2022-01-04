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
        pierna.setNombrePierna(nombrePierna);
        
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

    public void mostruoEditar(int id, String nombreMostruo, String nombreCabeza, String nombreOjo, String nombreCuerpo, String nombreBrazo, String nombrePierna) throws Exception {
        Criatura criatura = controlPersis.buscarCriatura(id);
        criatura.setNombre(nombreMostruo);
        
        ArrayList<Ojo> listaOjos = new ArrayList<Ojo>();
        Ojo ojo;
        Ojo ojoBuscado = controlPersis.buscarOjo(nombreOjo);
        if (ojoBuscado != null){
            ojo = ojoBuscado;
        }else{
            ojo = new Ojo();
            ojo.setNombre(nombreOjo);
            
        }
        listaOjos.clear();
        listaOjos.add(ojo);
        
        Cabeza cabeza;
        if (controlPersis.buscarCabeza(nombreCabeza) != null){
            cabeza = controlPersis.buscarCabeza(nombreCabeza);
            cabeza.setOjos(listaOjos);
        }else{
            cabeza = new Cabeza();
            cabeza.setNombre(nombreCabeza);
            cabeza.setOjos(listaOjos);
        }
        
        ArrayList<Brazo> listaBrazos = new ArrayList<Brazo>();
        Brazo brazo;
        Brazo brazoBusqueda = controlPersis.buscarBrazo(nombreBrazo);
        if (brazoBusqueda != null){
            brazo = brazoBusqueda;
        }else{
            brazo = new Brazo();
            brazo.setNombre(nombreBrazo);
        }
        listaBrazos.clear();
        listaBrazos.add(brazo);
        
        ArrayList<Pierna> listaPiernas = new ArrayList<Pierna>();
        Pierna pierna;
        Pierna piernaBusqueda = controlPersis.buscarPierna(nombrePierna);
        if (piernaBusqueda != null){
            pierna = piernaBusqueda;
        }else{
            pierna = new Pierna();
            pierna.setNombrePierna(nombrePierna);
        }
        listaPiernas.clear();
        listaPiernas.add(pierna);
        
        
        Cuerpo cuerpo;
        Cuerpo cuerpoBuscado = controlPersis.buscarCuerpo(nombreCuerpo);
        if (cuerpoBuscado != null){
            cuerpo = cuerpoBuscado;
            cuerpo.setBrazos(listaBrazos);
            cuerpo.setPiernas(listaPiernas);
        }else{
            cuerpo = new Cuerpo();
            cuerpo.setNombre(nombreCuerpo);
            cuerpo.setBrazos(listaBrazos);
            cuerpo.setPiernas(listaPiernas);
        }
        
        criatura.setCabeza(cabeza);
        criatura.setCuerpo(cuerpo);
        
        controlPersis.modificarCriatura(criatura);
    }
}
