/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.dao.ConexionDAO;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Manuel
 */
@Named(value = "reporteConexionBean")
@Dependent
public class ReporteConexionBean {
    private String tipoBuscar;
    private String mes;
    private String anio;
    private String termino;
    /**
     * Creates a new instance of ReporteConexionBean
     */
    public ReporteConexionBean() {
    }

    public String getTipoBuscar() {
        return tipoBuscar;
    }

    public void setTipoBuscar(String tipoBuscar) {
        this.tipoBuscar = tipoBuscar;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

}
