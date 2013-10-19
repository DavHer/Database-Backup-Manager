/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author David-PC
 */
public class ServicioTablespace extends Servicio{
    
    private String user;
    private String pass;
    private String ip;
    private String port;
    private String db;
    
    String OBTENERLINKS = "select db_link from all_db_links where owner!='PUBLIC'";
    private static String GET_TABLES_USER = "select TABLE_NAME,OWNER from all_tables where owner!='SYS' and owner!='SYSTEM' and owner!='OUTLN' and owner!='TSMSYS' and owner!='DBSNMP' and owner!='CTXSYS' and owner!='XDB' and owner!='MDSYS' and owner!='HR' and owner!='FLOWS_FILES' and owner!='FLOWS_020100'";
    private static String GET_ALL_TABLES = "select TABLE_NAME from all_tables";

    
    public ServicioTablespace(String user, String pass,String ip, String port, String db)
    {
        this.user = user;
        this.pass = pass;
        this.ip=ip;
        this.port=port;
        this.db=db;
        
    }
    public Collection listarTablas() throws GlobalException, NoDataException{      
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
        ArrayList coleccion= new ArrayList();
        Statement stmt = null;
        try{
            stmt = conexion.createStatement();      
            rs = stmt.executeQuery(GET_TABLES_USER);
             while (rs.next()) {
                 String aux = rs.getString("table_name");
                 coleccion.add(aux);
                 aux=rs.getString("owner");
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
    
}
