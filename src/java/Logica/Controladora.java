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
    
    public void mostruoGeneradorRapido(String nombreMostruo, String nombreCabeza,
            String nombreOjo1, String nombreOjo2, String nombreOjo3, String nombreCuerpo,
            String nombreBrazo1, String nombreBrazo2, String nombreBrazo3,
            String nombrePierna1, String nombrePierna2, String nombrePierna3,
            int idFirmaUsuario) {
        
        List<Visibilidad> visibilidadesLista = controlPersis.visibilidadTraer();
        Visibilidad visibilidadPublica = null;
        for(Visibilidad visibilidad : visibilidadesLista){
            if (visibilidad.getVisibilidad().equals("Publico")){
                visibilidadPublica = visibilidad;
            }
        }
        Firma firma = firmaBuscar(idFirmaUsuario);
        
        Ojo ojo1 = new Ojo();
        ojo1.setNombre(nombreOjo1);
        ojo1.setFirma(firma);
        ojo1.setVisibilidad(visibilidadPublica);
        Ojo ojo2 = new Ojo();
        ojo2.setNombre(nombreOjo1);
        ojo2.setFirma(firma);
        ojo2.setVisibilidad(visibilidadPublica);
        Ojo ojo3 = new Ojo();
        ojo3.setNombre(nombreOjo1);
        ojo3.setFirma(firma);
        ojo3.setVisibilidad(visibilidadPublica);
        
        Cabeza cabeza = new Cabeza();
        cabeza.setNombre(nombreCabeza);
        cabeza.setFirma(firma);
        cabeza.setVisibilidad(visibilidadPublica);
        
        ArrayList<Ojo> ojos = new ArrayList<Ojo>();
        ojos.add(ojo1);
        ojos.add(ojo2);
        ojos.add(ojo3);
        cabeza.setOjos(ojos);
        
        Brazo brazo1 = new Brazo();
        brazo1.setNombre(nombreBrazo1);
        brazo1.setFirma(firma);
        brazo1.setVisibilidad(visibilidadPublica);
        Brazo brazo2 = new Brazo();
        brazo2.setNombre(nombreBrazo2);
        brazo2.setFirma(firma);
        brazo2.setVisibilidad(visibilidadPublica);
        Brazo brazo3 = new Brazo();
        brazo3.setNombre(nombreBrazo3);
        brazo3.setFirma(firma);
        brazo3.setVisibilidad(visibilidadPublica);

        Pierna pierna1 = new Pierna();
        pierna1.setNombrePierna(nombrePierna1);
        pierna1.setFirma(firma);
        pierna1.setVisibilidad(visibilidadPublica);
        Pierna pierna2 = new Pierna();
        pierna2.setNombrePierna(nombrePierna2);
        pierna2.setFirma(firma);
        pierna2.setVisibilidad(visibilidadPublica);
        Pierna pierna3 = new Pierna();
        pierna3.setNombrePierna(nombrePierna3);
        pierna3.setFirma(firma);
        pierna3.setVisibilidad(visibilidadPublica);
        
        Cuerpo cuerpo = new Cuerpo();
        cuerpo.setNombre(nombreCuerpo);
        cuerpo.setFirma(firma);
        cuerpo.setVisibilidad(visibilidadPublica);
        ArrayList<Brazo> brazos = new ArrayList<Brazo>();
        brazos.add(brazo1);
        ArrayList<Pierna> piernas = new ArrayList<Pierna>();
        piernas.add(pierna1);
        cuerpo.setBrazos(brazos);
        cuerpo.setPiernas(piernas);
        
        Criatura criatura = new Criatura();
        criatura.setNombre(nombreMostruo);
        criatura.setCabeza(cabeza);
        criatura.setCuerpo(cuerpo);
        criatura.setFirma(firma);
        criatura.setVisibilidad(visibilidadPublica); //Corregir error de ortografia
        ArrayList<Criatura> presaDe = new ArrayList<>();
        criatura.setPresaDe(presaDe);
        
        controlPersis.mostruoGeneradorRapido(ojo1, ojo2, ojo3, cabeza, brazo1, brazo2, brazo3, pierna1, pierna2, pierna3, cuerpo, criatura);
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

    public void mostruoEditar(int id, String nombreMostruo, int cabezaCriatura,
            int ojoCriatura, int cuerpoCriatura, int brazoCriatura,
            int piernaCriatura, int depredador1) throws Exception {
        Criatura criatura = controlPersis.buscarCriatura(id);
        criatura.setNombre(nombreMostruo);
        
        Brazo brazo = controlPersis.brazoBuscar(brazoCriatura);
        Pierna pierna = controlPersis.piernaBuscar(piernaCriatura);
        Cuerpo cuerpo = controlPersis.cuerpoBuscar(cuerpoCriatura);
        Ojo ojo = controlPersis.ojoBuscar(ojoCriatura);
        Cabeza cabeza = controlPersis.cabezaBuscar(cabezaCriatura);
        
        
        
        ArrayList<Ojo> listaOjos = new ArrayList<Ojo>();
        listaOjos.add(ojo);
        cabeza.setOjos(listaOjos);
        
        ArrayList<Brazo> listaBrazos = new ArrayList<Brazo>();
        listaBrazos.add(brazo);
        ArrayList<Pierna> listaPiernas = new ArrayList<Pierna>();
        listaPiernas.add(pierna);
        cuerpo.setBrazos(listaBrazos);
        cuerpo.setPiernas(listaPiernas);
        
        /*Ojo ojo;
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
        */
        criatura.setCabeza(cabeza);
        criatura.setCuerpo(cuerpo);
        
        
        Criatura depredador01 = controlPersis.buscarCriatura(depredador1);
        ArrayList<Criatura> presaDe = new ArrayList<>();
        presaDe.add(depredador01);
        criatura.setPresaDe(presaDe);
        
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
    public void altaPersona(String nombreUsuario, String apellidoUsuario, 
            String emailUsuario, String contraseniaUsuario, Date nacimientoUsuario, 
            String firmaUsuario) {
        
        Firma firma = new Firma();
        firma.setFirma(firmaUsuario);
        
        Persona persona = new Persona();
        
        persona.setNombre(nombreUsuario);
        persona.setApellido(apellidoUsuario);
        persona.setEmail(emailUsuario);
        persona.setContra(contraseniaUsuario);
        persona.setFechaNacimiento(nacimientoUsuario);
        persona.setFirma(firma);
                 
        controlPersis.altaPersona(persona, firma);
    }
    
    public int personaLogin(String emailUsuario, String passwordUsuario) {
        int idUsuario = -1; //Usuario no encontrado
        List<Persona> personasLista = controlPersis.personaTraer();
        for(Persona persona : personasLista){
            if (persona.getEmail().equals(emailUsuario) && persona.getContra().equals(passwordUsuario)){
                return persona.getIdPersona();
            }
        }
        return idUsuario;
    }
    public Persona personaBuscar(int idPersona){
        return controlPersis.personaBuscar(idPersona);
    }

    public void crearPlaneta(String nombrePlaneta, String tamanioPlaneta, float gravedadPlaneta, 
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

    private Firma firmaBuscar(int idFirmaUsuario) {
        return controlPersis.firmaBuscar(idFirmaUsuario);
    }

    public void MostruoAlta(String nombreMostruo, String descripcionCriatura,
            String nombreCabeza, short cantidadCabezas, String descripcionCabeza, 
            String nombreOjo1, short cantidadOjos1, String descripcionOjo1, 
            String nombreOjo2, short cantidadOjos2, String descripcionOjo2, 
            String nombreOjo3, short cantidadOjos3, String descripcionOjo3, 
            String nombreCuerpo, String descripcionCuerpo, 
            String nombreBrazo1, short cantidadBrazos1, String descripcionBrazo1, 
            String nombreBrazo2, short cantidadBrazos2, String descripcionBrazo2, 
            String nombreBrazo3, short cantidadBrazos3, String descripcionBrazo3, 
            String nombrePierna1, short cantidadPiernas1, String descripcionPierna1, 
            String nombrePierna2, short cantidadPiernas2, String descripcionPierna2, 
            String nombrePierna3, short cantidadPiernas3, String descripcionPierna3, 
            int idFirmaUsuario) {
        
        List<Visibilidad> visibilidadesLista = controlPersis.visibilidadTraer();
        Visibilidad visibilidadPublica = null;
        for(Visibilidad visibilidad : visibilidadesLista){
            if (visibilidad.getVisibilidad().equals("Publico")){
                visibilidadPublica = visibilidad;
            }
        }
        
        Firma firma = controlPersis.firmaBuscar(idFirmaUsuario);
        
        Criatura criatura = new Criatura();
        criatura.setNombre(nombreMostruo);
        criatura.setDescripcion(descripcionCriatura);
        criatura.setCantidadCabezas(cantidadCabezas);
        criatura.setVisibilidad(visibilidadPublica);
        
        ArrayList<Ojo> listaOjos = new ArrayList<>();
        
        Ojo ojo1 = new Ojo();
        ojo1.setNombre(nombreOjo1);
        ojo1.setDescripcion(descripcionOjo1);
        ojo1.setFirma(firma);
        ojo1.setVisibilidad(visibilidadPublica);
        listaOjos.add(ojo1);
        controlPersis.ojoAlta(ojo1);
        
        if (nombreOjo2 != null){
        Ojo ojo2 = new Ojo();
        ojo2.setNombre(nombreOjo2);
        ojo2.setDescripcion(descripcionOjo2);
        ojo2.setFirma(firma);
        ojo2.setVisibilidad(visibilidadPublica);
        listaOjos.add(ojo2);
        controlPersis.ojoAlta(ojo2);
        }
        
        if (nombreOjo3 != null){
        Ojo ojo3 = new Ojo();
        ojo3.setNombre(nombreOjo3);
        ojo3.setDescripcion(descripcionOjo3);
        ojo3.setFirma(firma);
        ojo3.setVisibilidad(visibilidadPublica);
        listaOjos.add(ojo3);
        controlPersis.ojoAlta(ojo3);
        }
        
        Cabeza cabeza = new Cabeza();
        cabeza.setNombre(nombreCabeza);
        cabeza.setDescripcion(descripcionCabeza);
        cabeza.setCantidadOjos1(cantidadOjos1);
        if (nombreOjo2 != null){    cabeza.setCantidadOjos2(cantidadOjos2);}
        if (nombreOjo3 != null){    cabeza.setCantidadOjos3(cantidadOjos3);}
        cabeza.setOjos(listaOjos);
        cabeza.setFirma(firma);
        cabeza.setVisibilidad(visibilidadPublica);
        controlPersis.cabezaAlta(cabeza);
        
        criatura.setCantidadCabezas(cantidadCabezas);
        criatura.setCabeza(cabeza);
        
        ArrayList<Brazo> listaBrazos = new ArrayList<>();
        
        Brazo brazo1 = new Brazo();
        brazo1.setNombre(nombreBrazo1);
        brazo1.setDescripcion(descripcionBrazo1);
        brazo1.setFirma(firma);
        brazo1.setVisibilidad(visibilidadPublica);
        listaBrazos.add(brazo1);
        controlPersis.brazoAlta(brazo1);
        
        if (nombreBrazo2 != null){
            Brazo brazo2 = new Brazo();
            brazo2.setNombre(nombreBrazo2);
            brazo2.setDescripcion(descripcionBrazo2);
            brazo2.setFirma(firma);
            brazo2.setVisibilidad(visibilidadPublica);
            listaBrazos.add(brazo2);
            controlPersis.brazoAlta(brazo2);
        }
        if (nombreBrazo3 != null){
            Brazo brazo3 = new Brazo();
            brazo3.setNombre(nombreBrazo3);
            brazo3.setDescripcion(descripcionBrazo3);
            brazo3.setFirma(firma);
            brazo3.setVisibilidad(visibilidadPublica);
            listaBrazos.add(brazo3);
            controlPersis.brazoAlta(brazo3);
        }
        
        ArrayList<Pierna> listaPiernas = new ArrayList<>();
        
        Pierna pierna1 = new Pierna();
        pierna1.setNombrePierna(nombrePierna1);
        pierna1.setDescripcion(descripcionPierna1);
        pierna1.setFirma(firma);
        pierna1.setVisibilidad(visibilidadPublica);
        listaPiernas.add(pierna1);
        controlPersis.piernaAlta(pierna1);
        
        if(nombrePierna2 != null){
            Pierna pierna2 = new Pierna();
            pierna2.setNombrePierna(nombrePierna2);
            pierna2.setDescripcion(descripcionPierna2);
            pierna2.setFirma(firma);
            pierna2.setVisibilidad(visibilidadPublica);
            listaPiernas.add(pierna2);
            controlPersis.piernaAlta(pierna2);
        }
        if (nombrePierna3 != null){
        Pierna pierna3 = new Pierna();
            pierna3.setNombrePierna(nombrePierna3);
            pierna3.setDescripcion(descripcionPierna3);
            pierna3.setFirma(firma);
            pierna3.setVisibilidad(visibilidadPublica);
            listaPiernas.add(pierna3);
            controlPersis.piernaAlta(pierna3);
        }
        
        Cuerpo cuerpo = new Cuerpo();
        cuerpo.setDescripcion(descripcionCuerpo);
        cuerpo.setBrazos(listaBrazos);
        cuerpo.setCantidadBrazos1(cantidadBrazos1);
        cuerpo.setCantidadBrazos2(cantidadBrazos2);
        cuerpo.setCantidadBrazos3(cantidadBrazos3);
        cuerpo.setPiernas(listaPiernas);
        cuerpo.setCantidadPiernas1(cantidadPiernas1);
        cuerpo.setCantidadPiernas2(cantidadPiernas2);
        cuerpo.setCantidadPiernas3(cantidadPiernas3);
        cuerpo.setFirma(firma);
        cuerpo.setVisibilidad(visibilidadPublica);
        controlPersis.cuerpoAlta(cuerpo);
        
        criatura.setCuerpo(cuerpo);
        
        criatura.setFirma(firma); 
        controlPersis.criaturaAlta(criatura);
    }
}
