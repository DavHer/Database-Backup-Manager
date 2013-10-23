/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.EstrategiasGUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Estrategia implements Serializable{
    
    private String nombre;
    private String file;
    private ArrayList<String> tablespaces;
    private ArrayList<Horario> horarios;
    private boolean fullBackup;
    private boolean archive;
    private boolean estatus;
    private boolean usado;
    public String server;
    public String inFile;
    public boolean incremental;
    public int inc;
    
    
    public Estrategia(String nombre, String file, ArrayList<String> tablespaces, ArrayList<Horario> horarios, boolean fullBackup, boolean archive, boolean estatus,boolean usado,boolean incremental, int ince) {
        this.nombre = nombre;
        this.file = file;
        this.tablespaces = tablespaces;
        this.horarios = horarios;
        this.fullBackup = fullBackup;
        this.archive = archive;
        this.estatus = estatus;
        this.usado = usado;
        this.incremental = incremental;
        this.inc = ince;
    }
    
    public String concatenarTablespaces(){
        String ret="";
        
        if(getTablespaces().size()>0){
            ret+=getTablespaces().get(0);
            for(int i=1;i<getTablespaces().size();i++){
                ret+=","+getTablespaces().get(i);
            }
        }
        return ret;
    }
    public String concatenarHorarios(){
        String ret="";
        for(int i=0;i<getHorarios().size();i++){
            ret+="#"+getHorarios().get(i).toString()+"\n";
        }        
        return ret;
    }
    public String concatenarEstatus(){
        String ret="#inactivo\n";
        if(isEstatus()){
            ret = "#activo\n";
        }      
        return ret;
    }
    
    public void crearRMAN(EstrategiasGUI es){
        
        String comando="";
        String user = es.getPrincipal().getUser();
        String pass = es.getPrincipal().getPass();
        String db = es.getPrincipal().getCurrentServer();
        
        //Ver si existe
        File f = new File(getFile());
        if(f.exists()) 
        {
            //TODO: comprobar que no se cree sobre un archivo que ya existe
        }
        else{
            if(incremental){
                comando += "incremental level "+inc+" ";
            }
            if(isFullBackup()){
                comando += "database spfile ";
                if(isArchive())
                    comando += "plus archivelog";
            
            }
            else
            {
                comando += "tablespace "+concatenarTablespaces();
                if(isArchive())
                    comando += " plus archivelog ";
            }
            try{
                FileWriter fstream = new FileWriter(getFile(),true);
                BufferedWriter out = new BufferedWriter(fstream);
                server = db;
                //String write = "#Server:"+db+"\n";
                //write += "#"+getNombre()+"\n";
                //write += concatenarHorarios();
                //write += concatenarEstatus();
                //write += usado?"#usado\n":"#nousado\n";
                String write="";
                write += "connect target "+user+"/"+pass+"@"+db+"\n";
                write += "run{backup "+comando+";}";
                inFile = write;
                out.write(write);

                out.close();
            }catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
            
        }
        
    }

    public boolean isUsado() {
        return usado;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the file
     */
    public String getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * @return the tablespaces
     */
    public ArrayList<String> getTablespaces() {
        return tablespaces;
    }

    /**
     * @param tablespaces the tablespaces to set
     */
    public void setTablespaces(ArrayList<String> tablespaces) {
        this.tablespaces = tablespaces;
    }

    /**
     * @return the horarios
     */
    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    /**
     * @param horarios the horarios to set
     */
    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    /**
     * @return the fullBackup
     */
    public boolean isFullBackup() {
        return fullBackup;
    }

    /**
     * @param fullBackup the fullBackup to set
     */
    public void setFullBackup(boolean fullBackup) {
        this.fullBackup = fullBackup;
    }

    /**
     * @return the archive
     */
    public boolean isArchive() {
        return archive;
    }

    /**
     * @param archive the archive to set
     */
    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    /**
     * @return the estatus
     */
    public boolean isEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }




}
