package Logica.Ambiente;

import Logica.Firma;
import Logica.Visibilidad;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Planeta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idPlaneta;
    @Basic
    private String nombre;
    private String descripcion;
    private String tamanio;
    private int gravedad;
    private String sistemaPlanetario;
    private ArrayList<String> recursosLista = new ArrayList<String>();
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;

    public int getIdPlaneta() {
        return idPlaneta;
    }

    public void setIdPlaneta(int idPlaneta) {
        this.idPlaneta = idPlaneta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public String getSistemaPlanetario() {
        return sistemaPlanetario;
    }

    public void setSistemaPlanetario(String sistemaPlanetario) {
        this.sistemaPlanetario = sistemaPlanetario;
    }

    public ArrayList<String> getRecursosLista() {
        return recursosLista;
    }

    public void setRecursosLista(ArrayList<String> recursosLista) {
        this.recursosLista = recursosLista;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Visibilidad getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }

    public Planeta() {
    }

    public Planeta(int idPlaneta, String nombre, String descripcion, String tamanio, int gravedad, String sistemaPlanetario, Firma firma, Visibilidad visibilidad) {
        this.idPlaneta = idPlaneta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.gravedad = gravedad;
        this.sistemaPlanetario = sistemaPlanetario;
        this.firma = firma;
        this.visibilidad = visibilidad;
    }
    
    
}
