/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.*;
import Logica.Ambiente.Clima;
import Logica.Ambiente.Planeta;
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
    PersonaJpaController personaJPA = new PersonaJpaController();
    FirmaJpaController firmaJPA = new FirmaJpaController();
    VisibilidadJpaController visibilidadJPA = new VisibilidadJpaController();
    PlanetaJpaController planetaJPA = new PlanetaJpaController();
    ClimaJpaController climaJPA = new ClimaJpaController();
    
    public void mostruoGeneradorRapido(Ojo ojo1, Ojo ojo2, Ojo ojo3, Cabeza cabeza,
            Brazo brazo1, Brazo brazo2, Brazo brazo3, Pierna pierna1,
            Pierna pierna2, Pierna pierna3, Cuerpo cuerpo, Criatura criatura) {     
        
        ojoJPA.create(ojo1);
        ojoJPA.create(ojo2);
        ojoJPA.create(ojo3);
        cabezaJPA.create(cabeza);
        brazoJPA.create(brazo1);
        brazoJPA.create(brazo2);
        brazoJPA.create(brazo3);
        piernaJPA.create(pierna1);
        piernaJPA.create(pierna2);
        piernaJPA.create(pierna3);
        cuerpoJPA.create(cuerpo);
        criaturaJPA.create(criatura);
        
    }
    
    public List<Criatura> traerCriaturas() {
        return criaturaJPA.findCriaturaEntities();
    }

    public Criatura buscarCriatura(int id) {
       return criaturaJPA.findCriatura(id);
    }
    
    public Ojo ojoBuscar(int idOjo){
        return ojoJPA.findOjo(idOjo);
    }
    
    public Cabeza cabezaBuscar(int idCabeza){
        return cabezaJPA.findCabeza(idCabeza);
    }
    
    public Brazo brazoBuscar(int idBrazo){
        return brazoJPA.findBrazo(idBrazo);
    }
    
    public Pierna piernaBuscar(int idPierna){
        return piernaJPA.findPierna(idPierna);
    }
    
    public Cuerpo cuerpoBuscar(int idCuerpo){
        return cuerpoJPA.findCuerpo(idCuerpo);
    }
    /*
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
            if (pierna.getNombrePierna().equals(nombrePierna)){
                return pierna;
            }
        }
        return piernaBuscada;
    }*/

    public void modificarCriatura(Criatura criatura) throws Exception {
        criaturaJPA.edit(criatura);
    }

    public List<Cabeza> traerCabezas() {
        return cabezaJPA.findCabezaEntities();
    }

    public List<Ojo> traerOjos() {
        return ojoJPA.findOjoEntities();
    }

    public List<Cuerpo> traerCuerpos() {
        return cuerpoJPA.findCuerpoEntities();
    }

    public List<Brazo> traerBrazos() {
        return brazoJPA.findBrazoEntities();
    }
    
    public List<Pierna> traerPiernas() {
        return piernaJPA.findPiernaEntities();
    }

    public void altaPersona(Persona persona, Firma firma) {
        firmaJPA.create(firma);
        personaJPA.create(persona);
    }

    public void crearPlaneta(Planeta planeta) {
        planetaJPA.create(planeta);
    }
    
    public List<Planeta> planetaTraer(){
        return planetaJPA.findPlanetaEntities();
    }
    
    //Metodos de Clima
    public void crearClima(Clima clima){
        climaJPA.create(clima);
    }
    
    public Clima climaBusar(int idClima){
        return climaJPA.findClima(idClima);
    }
    
    public List<Clima> climaTraer(){
        return climaJPA.findClimaEntities();
    }
    
    //Metodos de las visibilidades
    public void crearVisibilidades(){
        Visibilidad visibilidadPublica = new Visibilidad();
        Visibilidad visibilidadPrivada = new Visibilidad();
        Visibilidad visibilidadProtegida = new Visibilidad();
        visibilidadPublica.setVisibilidad("Publico");
        visibilidadPrivada.setVisibilidad("Privado");
        visibilidadProtegida.setVisibilidad("Protegido");
        
        visibilidadJPA.create(visibilidadPublica);
        visibilidadJPA.create(visibilidadPrivada);
        visibilidadJPA.create(visibilidadProtegida);
    }
    
    public Visibilidad visibilidadBuscar(int idVisibilidad){
        List<Visibilidad> visibilidadLista = visibilidadJPA.findVisibilidadEntities();
        if (visibilidadLista.isEmpty()){
                crearVisibilidades();}
        
        return visibilidadJPA.findVisibilidad(idVisibilidad);
    }
    
    public List<Visibilidad> visibilidadTraer(){
        List<Visibilidad> visibilidadLista = visibilidadJPA.findVisibilidadEntities();
        if (visibilidadLista.isEmpty()){
                crearVisibilidades();}
        
        return visibilidadJPA.findVisibilidadEntities();
    }

    public List<Persona> personaTraer() {
        return personaJPA.findPersonaEntities();
    }

    public Persona personaBuscar(int idPersona) {
        return personaJPA.findPersona(idPersona);
    }

    public Firma firmaBuscar(int idFirmaUsuario) {
        return firmaJPA.findFirma(idFirmaUsuario);
    }

    public void ojoAlta(Ojo ojo) {
        ojoJPA.create(ojo);
    }

    public void cabezaAlta(Cabeza cabeza) {
        cabezaJPA.create(cabeza);
    }

    public void brazoAlta(Brazo brazo) {
        brazoJPA.create(brazo);
    }

    public void piernaAlta(Pierna pierna) {
        piernaJPA.create(pierna);
    }

    public void cuerpoAlta(Cuerpo cuerpo) {
        cuerpoJPA.create(cuerpo);
    }

    public void criaturaAlta(Criatura criatura) {
        criaturaJPA.create(criatura);
    }
}
