/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import AccesoADatos.ServicioConexion;
import Presentacion.ConectadoGUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Localizacion {
    
    String nombre;
    String usuario;
    String password;
    String host;
    String port;
    String serviceName;
    
    ConectadoGUI conectado;

    public Localizacion(ConectadoGUI c,String nombre, String usuario, String password, String host, String port, String serviceName) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.host = host;
        this.port = port;
        this.serviceName = serviceName;
        
        conectado = c;
    }
    
    public boolean CrearLink()
    {
        boolean exito = false;
        ServicioConexion sc = new ServicioConexion(conectado.getConexion().user,conectado.getConexion().pass,conectado.getConexion().ip,conectado.getConexion().port,conectado.getConexion().db);
        try {
            exito = sc.crearLink(nombre, usuario, password, host, port, serviceName);
        } catch (GlobalException | NoDataException | SQLException ex) {
            Logger.getLogger(Localizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return exito;
    }
           
}
