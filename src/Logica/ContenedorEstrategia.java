/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.Estrategias;
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
    
    public void crearEstrategia(Estrategias es,String nombre, String file, ArrayList<String> tablespaces, ArrayList<Horario> horarios, boolean fullBackup, boolean archive, boolean estatus){
        Estrategia e = new Estrategia( es, nombre,  file,tablespaces, horarios,  fullBackup,  archive,  estatus);
        e.crearRMAN();
        estrategias.add(e);
    }
    
}
