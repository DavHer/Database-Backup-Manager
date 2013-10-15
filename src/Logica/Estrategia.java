/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.Estrategias;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Estrategia implements Serializable{
    
    String nombre;
    String file;
    ArrayList<String> tablespaces;
    ArrayList<Horario> horarios;
    boolean fullBackup;
    boolean archive;
    boolean estatus;
    
    Estrategias estrategias;
    
    public Estrategia(Estrategias es,String nombre, String file, ArrayList<String> tablespaces, ArrayList<Horario> horarios, boolean fullBackup, boolean archive, boolean estatus) {
        this.nombre = nombre;
        this.file = file;
        this.tablespaces = tablespaces;
        this.horarios = horarios;
        this.fullBackup = fullBackup;
        this.archive = archive;
        this.estatus = estatus;
        
        estrategias = es;
    }
    
    public String concatenarTablespaces(){
        String ret="";
        
        if(tablespaces.size()>0){
            ret+=tablespaces.get(0);
            for(int i=1;i<tablespaces.size();i++){
                ret+=","+tablespaces.get(i);
            }
        }
        return ret;
    }
    public String concatenarHorarios(){
        String ret="";
        for(int i=0;i<horarios.size();i++){
            ret+="#"+horarios.get(i).toString()+"\n";
        }        
        return ret;
    }
    public String concatenarEstatus(){
        String ret="#inactivo";
        if(estatus){
            ret = "#activo";
        }      
        return ret;
    }
    
    public void crearRMAN(){
        
        String comando="";
        String user = estrategias.getPrincipal().getConexion().user;
        String pass = estrategias.getPrincipal().getConexion().pass;
        String db = estrategias.getPrincipal().getConexion().db;
        
        //Ver si existe
        File f = new File(file);
        if(f.exists()) 
        {
            //TODO: comprobar que no se cree sobre un archivo que ya existe
        }
        else{
            if(fullBackup){
                comando = "backup database spfile";
                if(archive)
                    comando += " plus archivelog";
            
            }
            else
            {
                comando = "backup tablespace "+concatenarTablespaces();
                if(archive)
                    comando += " plus archivelog";
            }
            try{
                FileWriter fstream = new FileWriter(file,true);
                BufferedWriter out = new BufferedWriter(fstream);
                String write = "#"+nombre+"\n";
                write += concatenarHorarios();
                write += concatenarEstatus();
                write += "connect target "+user+"/"+pass+"@"+db+"\n";
                write += "run{"+comando+"}";
                out.write(write);

                out.close();
            }catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
            
        }
        
    }
    public static void main(String[] args){
        
        Estrategia e = new Estrategia(null,null,"estra.rman",null,null,false,false,false);
        e.crearRMAN();
    }
}
