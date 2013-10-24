/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author David-PC
 */
public class ContenedorConfiguracion {
    
    ArrayList<Configuracion> configuraciones;
    Configuracion configLocal;

    public ContenedorConfiguracion(ArrayList<Configuracion> configuraciones) {
        this.configuraciones = configuraciones;
    }

    public ContenedorConfiguracion() {
        configuraciones = new ArrayList();
        configLocal = new Configuracion();
        cargarArchivo();
        cargarArchivoLocal();
    }

    public Configuracion getConfigLocal() {
        return configLocal;
    }

    public void setConfigLocal(Configuracion configLocal) {
        this.configLocal = configLocal;
    }
    
    

    public ArrayList<Configuracion> getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(ArrayList<Configuracion> configuraciones) {
        this.configuraciones = configuraciones;
    }
    
    public Configuracion buscar(String server){
        
        for(int i=0;i<configuraciones.size();i++){
            if(configuraciones.get(i).getServer().equals(server)){
                return configuraciones.get(i);
            }
        }
        
        return null;
    }
    
    public void cargarArchivo(){
        try
        {
           FileInputStream fileIn = new FileInputStream("configurations.txt");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           ArrayList<Configuracion> confi;
           confi = (ArrayList<Configuracion>) in.readObject();
           if(confi!=null){
               configuraciones = confi;
           }
           in.close();
           fileIn.close();
        }catch(  IOException | ClassNotFoundException i)
        {
           i.printStackTrace();
        }
    }
    
    public void guardarArchivo(){
        try {
            FileOutputStream fileOut = new FileOutputStream("configurations.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(configuraciones);
           
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in configurations.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
    
    public void cargarArchivoLocal(){
        try
        {
           FileInputStream fileIn = new FileInputStream("configLocal.txt");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           Configuracion confi;
           confi = (Configuracion) in.readObject();
           if(confi!=null){
               configLocal = confi;
           }
           in.close();
           fileIn.close();
        }catch(  IOException | ClassNotFoundException i)
        {
           i.printStackTrace();
        }
    }
    
    public void guardarArchivoLocal(){
        try {
            FileOutputStream fileOut = new FileOutputStream("configLocal.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(configLocal);
           
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in configLocal.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
    
    public boolean reemplazar(Configuracion c){
        
        boolean exito = false;
        exito = configuraciones.remove(c);
        configuraciones.add(c);
        
        return exito;
    }
    
}
