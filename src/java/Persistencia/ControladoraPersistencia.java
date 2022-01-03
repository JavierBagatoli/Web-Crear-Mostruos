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

    public Criatura buscarCriatura(int id) {
       return criaturaJPA.findCriatura(id);
    }

    public Cabeza buscarCabeza(String nombreCabeza) {
        List<Cabeza> listaCabezas = cabezaJPA.findCabezaEntities();
        Cabeza cabezaBuscada = null;
        for(Cabeza cabeza : listaCabezas){
            if (cabeza.getNombre().equals(nombreCabeza)){
                return cabeza;
            }
        }
        return cabezaBuscada;
    }

    public Ojo buscarOjo(String nombreOjo) {
        List<Ojo> listaOjos = ojoJPA.findOjoEntities();
        Ojo ojoBuscado = null;
        for(Ojo ojo : listaOjos){
            if (ojo.getNombre().equals(nombreOjo)){
                return ojo;
            }
        }
        return ojoBuscado;
    }

    public Cuerpo buscarCuerpo(String nombreCuerpo) {
        List<Cuerpo> listaCuerpos = cuerpoJPA.findCuerpoEntities();
        Cuerpo cuerpoBuscado = null;
        for(Cuerpo cuerpo : listaCuerpos){
            if (cuerpo.getNombre().equals(nombreCuerpo)){
                return cuerpo;
            }
        }
        return cuerpoBuscado;
    }

    public Brazo buscarBrazo(String nombreBrazo) {
        List<Brazo> listaBrazos = brazoJPA.findBrazoEntities();
        Brazo brazoBuscado = null;
        for(Brazo brazo : listaBrazos){
            if (brazo.getNombre().equals(nombreBrazo)){
                return brazo;
            }
        }
        return brazoBuscado;
    }

    public Pierna buscarPierna(String nombrePierna) {
        List<Pierna> listaPienra = piernaJPA.findPiernaEntities();
        Pierna piernaBuscada= null;
        for(Pierna pierna : listaPienra){
            if (pierna.getPierna().equals(nombrePierna)){
                return pierna;
            }
        }
        return piernaBuscada;
    }

    public void modificarCriatura(Criatura criatura) throws Exception {
        criaturaJPA.edit(criatura);
    }
    
}
