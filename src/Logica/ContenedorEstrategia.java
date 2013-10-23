/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.EstrategiasGUI;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author David-PC
 */
public class ContenedorEstrategia implements Serializable{
    
    ArrayList<Estrategia> estrategias;

    public ContenedorEstrategia() {
        estrategias = new ArrayList();
    }

    public ArrayList<Estrategia> getEstrategias() {
        return estrategias;
    }
    
    public void crearEstrategia(EstrategiasGUI es,String nombre, String file, ArrayList<String> tablespaces, ArrayList<Horario> horarios, boolean fullBackup, boolean archive, boolean estatus,boolean usado, boolean inc, int incr){
        Estrategia e = new Estrategia(nombre,  file,tablespaces, horarios,  fullBackup,  archive,  estatus,usado,inc, incr);
        e.crearRMAN(es);
        estrategias.add(e);
    }
    
}
