package clio.Entities;
// Generated 21-ene-2013 0:34:55 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Pc generated by hbm2java
 */
public class Pc  implements java.io.Serializable {


     private Long pcId;
     private Laboratorio laboratorio;
     private String pcNombre;
     private String pcEstado;
     private String pcDescripcion;
     private String pcIp;
     private Integer pcFila;
     private Integer pcColumna;
     private Set<Conexion> conexions = new HashSet<Conexion>(0);

    public Pc() {
    }

    public Pc(Laboratorio laboratorio, String pcNombre, String pcEstado, String pcDescripcion, String pcIp, Integer pcFila, Integer pcColumna, Set<Conexion> conexions) {
       this.laboratorio = laboratorio;
       this.pcNombre = pcNombre;
       this.pcEstado = pcEstado;
       this.pcDescripcion = pcDescripcion;
       this.pcIp = pcIp;
       this.pcFila = pcFila;
       this.pcColumna = pcColumna;
       this.conexions = conexions;
    }
   
    public Long getPcId() {
        return this.pcId;
    }
    
    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }
    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }
    
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
    public String getPcNombre() {
        return this.pcNombre;
    }
    
    public void setPcNombre(String pcNombre) {
        this.pcNombre = pcNombre;
    }
    public String getPcEstado() {
        return this.pcEstado;
    }
    
    public void setPcEstado(String pcEstado) {
        this.pcEstado = pcEstado;
    }
    public String getPcDescripcion() {
        return this.pcDescripcion;
    }
    
    public void setPcDescripcion(String pcDescripcion) {
        this.pcDescripcion = pcDescripcion;
    }
    public String getPcIp() {
        return this.pcIp;
    }
    
    public void setPcIp(String pcIp) {
        this.pcIp = pcIp;
    }
    public Integer getPcFila() {
        return this.pcFila;
    }
    
    public void setPcFila(Integer pcFila) {
        this.pcFila = pcFila;
    }
    public Integer getPcColumna() {
        return this.pcColumna;
    }
    
    public void setPcColumna(Integer pcColumna) {
        this.pcColumna = pcColumna;
    }
    public Set<Conexion> getConexions() {
        return this.conexions;
    }
    
    public void setConexions(Set<Conexion> conexions) {
        this.conexions = conexions;
    }




}


