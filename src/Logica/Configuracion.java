/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;

/**
 *
 * @author David-PC
 */
public class Configuracion implements Serializable{
    
    private String server="Default";
    private String strategiesDir="Default";
    private String RMANLogDir="Default";
    private String RMANScriptDir="Default";
    private String backupDir="Default";

    public Configuracion() {
    }
    
    

    public Configuracion(String server, String strategiesDir, String RMANLogDir, String RMANScriptDir, String backupDir) {
        this.server = server;
        this.strategiesDir = strategiesDir;
        this.RMANLogDir = RMANLogDir;
        this.RMANScriptDir = RMANScriptDir;
        this.backupDir = backupDir;
    }

    @Override
    public boolean equals(Object obj) {
        return this.server.equals(((Configuracion)obj).getServer());
    }
    
    

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the strategiesDir
     */
    public String getStrategiesDir() {
        return strategiesDir;
    }

    /**
     * @param strategiesDir the strategiesDir to set
     */
    public void setStrategiesDir(String strategiesDir) {
        this.strategiesDir = strategiesDir;
    }

    /**
     * @return the RMANLogDir
     */
    public String getRMANLogDir() {
        return RMANLogDir;
    }

    /**
     * @param RMANLogDir the RMANLogDir to set
     */
    public void setRMANLogDir(String RMANLogDir) {
        this.RMANLogDir = RMANLogDir;
    }

    /**
     * @return the RMANScriptDir
     */
    public String getRMANScriptDir() {
        return RMANScriptDir;
    }

    /**
     * @param RMANScriptDir the RMANScriptDir to set
     */
    public void setRMANScriptDir(String RMANScriptDir) {
        this.RMANScriptDir = RMANScriptDir;
    }

    /**
     * @return the backupDir
     */
    public String getBackupDir() {
        return backupDir;
    }

    /**
     * @param backupDir the backupDir to set
     */
    public void setBackupDir(String backupDir) {
        this.backupDir = backupDir;
    }
    
    
    
}
