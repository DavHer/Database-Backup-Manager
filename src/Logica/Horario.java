/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;


public class Horario implements Serializable {
    
    String dia;
    String de;
    String hasta;

    public Horario(String dia, String de, String hasta) {
        this.dia = dia;
        this.de = de;
        this.hasta = hasta;
    }

    public String getDe() {
        return de;
    }

    public String getDia() {
        return dia;
    }

    public String getHasta() {
        return hasta;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    @Override
    public String toString() {
        return dia+"&"+de+"&"+hasta+"&";
    }
    
    
}
