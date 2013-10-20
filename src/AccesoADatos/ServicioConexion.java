/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    String OBTENERLINKS = "select db_link from all_db_links where owner!='PUBLIC'";
    
    
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
     
    public ArrayList<String> listarLinks() throws GlobalException, NoDataException{      
        try {
            conectar(user, pass,ip,port,db);      
        }
        catch(ClassNotFoundException ex)
        {
            throw new GlobalException("No se ha localizado el Driver");
        }
        
        catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }      
        
        ResultSet rs=null;
        ArrayList<String> coleccion= new ArrayList();
        Statement stmt = null;
        try{
            stmt = conexion.createStatement();          
            rs = stmt.executeQuery(OBTENERLINKS);
             while (rs.next()) {
                 String aux = rs.getString(1);
                 coleccion.add(aux);
            }
        } catch (SQLException e) {
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
        if (coleccion == null || coleccion.size() == 0) {
            throw new NoDataException("No hay datos");
        }
        return coleccion;
    }
    
    public boolean dropLink(String name) throws GlobalException, NoDataException{      
        try {
            conectar(user, pass,ip,port,db);       
        }
        catch(ClassNotFoundException ex)
        {
            throw new GlobalException("No se ha localizado el Driver");
        }
        
        catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }      
        
        ResultSet rs=null;
        Statement stmt = null;
        try{
            stmt = conexion.createStatement(); 
            String ss = "DROP DATABASE LINK " + name ;
            System.out.println(ss);
            rs = stmt.executeQuery(ss);
             
        } catch (SQLException e) {
            
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
                return true;
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        
    }

}


