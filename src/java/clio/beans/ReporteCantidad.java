/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Manuel
 */
@Named(value = "reporteCantidad")
@Dependent
public class ReporteCantidad {

    int cantidad, mes;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Creates a new instance of ReporteCantidad
     */
    public ReporteCantidad() {
    }
}
