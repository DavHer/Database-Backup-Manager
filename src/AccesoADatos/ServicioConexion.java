/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    String CREARLINK = "CREATE DATABASE LINK ? CONNECT TO ? IDENTIFIED BY ? USING '(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = ?)(PORT = ?))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = ?)))'";
    
    
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
        catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }   
        finally{
            desconectar();
        }
        return exito;
    }
    
     public boolean crearLink(String nombre, String usuario, String password, String host, String port, String serviceName) throws GlobalException, NoDataException, SQLException{ 
        
        boolean exito = false;
        try {
            conectar(user, pass,ip,port,db); 
        }
        catch(ClassNotFoundException ex)
        {
            exito = false;
        }
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try{
            String query = "CREATE DATABASE LINK "+nombre+" CONNECT TO "+usuario+" IDENTIFIED BY "+password+" USING '(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = "+host+" )(PORT = "+port+" ))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = "+serviceName+" )))'";
            stmt = conexion.prepareStatement(query); 
            System.out.println(query);
            stmt.executeQuery();
            exito = true;
        } catch (SQLException e) {
            exito = false;
            e.printStackTrace();
            throw new GlobalException("Sentencia no valida");
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }

        return exito;
    }
}
