/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Logica.Ambiente.Clima;
import Logica.Ambiente.Planeta;
import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
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
    //Metodos de la cabeza
    public List<Cabeza> traerCabezas(){
        return controlPersis.traerCabezas();
    }
    
    //Metodos del Ojo
    public List<Ojo> traerOjos(){
        return controlPersis.traerOjos();
    }
    //Metodos del Cuerpo
    public List<Cuerpo> traerCuerpos(){
        return controlPersis.traerCuerpos();
    }
    //Metodos de Brazo
    
    public List<Brazo> traerBrazos(){
        return controlPersis.traerBrazos();
    }
    
    //Metodos de Pierna
    public List<Pierna> traerPiernas(){
        return controlPersis.traerPiernas();
    }

    //Metodos de Persona
    public void altaPersona(String nombreUsuario, String apellidoUsuario, String emailUsuario, String contraseniaUsuario, Date nacimientoUsuario, String firmaUsuario) {
        Persona persona = new Persona();
        
        Firma firma = new Firma();
        firma.setFirma(firmaUsuario);
        
        persona.setNombre(nombreUsuario);
        persona.setApellido(apellidoUsuario);
        persona.setEmail(emailUsuario);
        persona.setContra(nombreUsuario);
        persona.setFechaNacimiento(nacimientoUsuario);
        persona.setFirma(firma);
        
        controlPersis.altaPersona(persona, firma);
    }

    public void crearPlaneta(String nombrePlaneta, String tamanioPlaneta, int gravedadPlaneta, 
            String recursoPlaneta1, String recursoPlaneta2, String recursoPlaneta3, 
            int visibilidadPlaneta) {
        Planeta planeta = new Planeta();
        planeta.setNombre(nombrePlaneta); 
        planeta.setTamanio(tamanioPlaneta);
        planeta.setGravedad(gravedadPlaneta);
        ArrayList<String> recursosLista = new ArrayList<String>();
        recursosLista.add(recursoPlaneta1);
        recursosLista.add(recursoPlaneta2);
        recursosLista.add(recursoPlaneta3);
        planeta.setRecursosLista(recursosLista);
        
        Visibilidad visibilidadAux = controlPersis.visibilidadBuscar(visibilidadPlaneta);
        planeta.setVisibilidad(visibilidadAux);
        
        controlPersis.crearPlaneta(planeta);
    }

    public void crearClima(String nombreClima, int intervaloTemp1, int intervaloTemp2,
            int IntervaloHume1, int IntervaloHume2, int IntervaloPrep1, int IntervaloPrep2,
            int IntervaloVien1, int IntervaloVien2, int visibilidadClima) {
        Clima clima = new Clima();
        clima.setNombre(nombreClima);
        int vectorTemp[] = {intervaloTemp1, intervaloTemp2};
        clima.setTemperatura(vectorTemp);
        int vectorHume[] = {IntervaloHume1, IntervaloHume2};
        clima.setHumedad(vectorHume);
        int vectorPrep[] = {IntervaloPrep1,IntervaloPrep2};
        clima.setPrecipitaciones(vectorPrep);
        int vectorVien[] = {IntervaloVien1, IntervaloVien2};
        clima.setViento(vectorVien);
        
        Visibilidad visibilidadAux = controlPersis.visibilidadBuscar(visibilidadClima);
        clima.setVisibilidad(visibilidadAux);
        
        controlPersis.crearClima(clima);
    }

    public void crearClima(String nombreClima, int intervaloTemp1, int intervaloTemp2, 
            int IntervaloHume1, int IntervaloHume2, int IntervaloPrep1, int IntervaloPrep2, 
            int IntervaloVien1, int IntervaloVien2, int visibilidadClima, String planeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Planeta> planetaTraer(){
        return controlPersis.planetaTraer();
    }
    
    public List<Visibilidad> visibilidadTraer(){
        return controlPersis.visibilidadTraer();
    }
}
