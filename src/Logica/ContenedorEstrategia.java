/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.EstrategiasGUI;
import java.util.ArrayList;

/**
 *
 * @author David-PC
 */
public class ContenedorEstrategia {
    
    ArrayList<Estrategia> estrategias;

    public ContenedorEstrategia() {
        estrategias = new ArrayList();
    }

    public ArrayList<Estrategia> getEstrategias() {
        return estrategias;
    }
    
    public void crearEstrategia(EstrategiasGUI es,String nombre, String file, ArrayList<String> tablespaces, ArrayList<Horario> horarios, boolean fullBackup, boolean archive, boolean estatus,boolean usado){
        Estrategia e = new Estrategia( es, nombre,  file,tablespaces, horarios,  fullBackup,  archive,  estatus,usado);
        e.crearRMAN();
        estrategias.add(e);
    }
    
}
