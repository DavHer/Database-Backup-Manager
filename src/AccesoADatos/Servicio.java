/*
 * Servicio.java
 *
 * Created on 25 de abril de 2007, 03:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AccesoADatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Servicio {

    protected Connection conexion= null;
    
    public Servicio() {
        
    }
    
    protected void conectar(String user, String pass,String ip, String port, String db) throws SQLException,ClassNotFoundException 
    {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":"+port+":"+db+"",user,pass);
            
    }
    protected void desconectar() throws SQLException{
        if(!conexion.isClosed())
        {
            conexion.close();
        }
    }

    private Connection getJdbcMydbsource() throws NamingException {
        Context c = new InitialContext();
        try {
            return ((DataSource) c.lookup("jdbc/Mydbsource")).getConnection();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}