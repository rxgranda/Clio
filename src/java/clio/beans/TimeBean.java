/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Manuel
 */
@Named(value = "timeBean")
@Dependent
public class TimeBean {

    int anioInicio = Integer.parseInt("2011");
    int anioFin = Integer.parseInt(yearNow());

    /**
     * Creates a new instance of TimeBean
     */
    public String timeNow() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy_h-mm-ss_a");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public String monthNow() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public String yearNow() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public String intToMes(String numMes) {
        String stringMes;
        switch (Integer.parseInt(numMes)) {
            case 1:
                stringMes = "Enero";
                break;
            case 2:
                stringMes = "Febrero";
                break;
            case 3:
                stringMes = "Marzo";
                break;
            case 4:
                stringMes = "Abril";
                break;
            case 5:
                stringMes = "Mayo";
                break;
            case 6:
                stringMes = "Junio";
                break;
            case 7:
                stringMes = "Julio";
                break;
            case 8:
                stringMes = "Agosto";
                break;
            case 9:
                stringMes = "Septiembre";
                break;
            case 10:
                stringMes = "Octubre";
                break;
            case 11:
                stringMes = "Noviembre";
                break;
            case 12:
                stringMes = "Diciembre";
                break;
            default:
                stringMes = "Mes Invalido";
                break;
        }
        return stringMes;
    }

    public List<String> getListaTerminos() {
        List<String> listaTerminos = new ArrayList<String>();
        do {
            anioInicio++;
            if ((anioInicio != anioFin)) {
                listaTerminos.add("Primer Término " + anioInicio);
                listaTerminos.add("Segundo Término " + anioInicio);
            }
            if ((anioInicio == anioFin) && (Integer.parseInt(monthNow()) > 5)) {
                listaTerminos.add("Primer Término " + anioInicio);
            }
            if ((anioInicio == anioFin) && (Integer.parseInt(monthNow()) > 9)) {
                listaTerminos.add("Segundo Término " + anioInicio);
            }

        } while (anioInicio != anioFin);
        return listaTerminos;
    }

    public List<String> getListMeses() {
        List<String> listMeses = new ArrayList<String>();
        listMeses.add("Enero");
        listMeses.add("Febrero");
        listMeses.add("Marzo");
        listMeses.add("April");
        listMeses.add("Mayo");
        listMeses.add("Junio");
        listMeses.add("Julio");
        listMeses.add("Agosto");
        listMeses.add("Septiembre");
        listMeses.add("Octubre");
        listMeses.add("Noviembre");
        listMeses.add("Diciembre");
        
                return listMeses;
    }
    
    public List<String> getListAnios() {
        List<String> listAnios = new ArrayList<String>();
        do {
            listAnios.add("" + anioInicio);
            anioInicio++;
        } while (anioInicio <= anioFin);
        return listAnios;
    }

}
