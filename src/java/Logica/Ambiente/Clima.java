package Logica.Ambiente;

import Logica.Firma;
import Logica.Visibilidad;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Clima implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idClima;
    @Basic
    private String nombre;
    private String descripcion;
    private int temperatura[] = {0,0};
    private int humedad[] = {0,0};
    private int precipitaciones[] = {0,0};
    private int viento[] = {0,0};
    @ManyToOne
    private Firma firma;
    @ManyToOne
    private Visibilidad visibilidad;
    @ManyToOne
    private Planeta planeta;

    public int getIdClima() {
        return idClima;
    }

    public void setIdClima(int idClima) {
        this.idClima = idClima;
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

    public int[] getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int[] temperatura) {
        this.temperatura = temperatura;
    }

    public int[] getHumedad() {
        return humedad;
    }

    public void setHumedad(int[] humedad) {
        this.humedad = humedad;
    }

    public int[] getPrecipitaciones() {
        return precipitaciones;
    }

    public void setPrecipitaciones(int[] precipitaciones) {
        this.precipitaciones = precipitaciones;
    }

    public int[] getViento() {
        return viento;
    }

    public void setViento(int[] viento) {
        this.viento = viento;
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

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public Clima() {
    }

    public Clima(int idClima, String nombre, String descripcion, Firma firma, Visibilidad visibilidad, Planeta planeta) {
        this.idClima = idClima;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.firma = firma;
        this.visibilidad = visibilidad;
        this.planeta = planeta;
    }
}
