/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.SQLException;

/**
 *
 * @author Fernando
 */
public class ServicioConexion extends Servicio {
    
    private String user;
    private String pass;
    private String ip;
    private String port;
    private String db;
    
    
    public ServicioConexion(String user, String pass,String ip, String port, String db)
    {
        this.user = user;
        this.pass = pass;
        this.ip=ip;
        this.port=port;
        this.db=db;
        
    }
    
    public boolean iniciarConexion() throws GlobalException, NoDataException, SQLException{ 
        
        boolean exito = false;
        try {
            conectar(user, pass,ip,port,db); 
            exito = true;
        }
        catch(ClassNotFoundException ex)
        {
            exito = false;
        }
        finally{
            desconectar();
        }
        return exito;
    }
}
