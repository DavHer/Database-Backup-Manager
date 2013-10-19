
package Presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class PrincipalGUI extends javax.swing.JFrame {

   
    ConexionGUI conexion;
    EstrategiasGUI estrategias;
    private String user=null;
    private String pass=null;
    private String ip;
    private String port;
    private String db;
    
    private String userRemote=null;
    private String passRemote=null;
    private String ipRemote;
    private String portRemote;
    private String dbRemote;
    
    
    public PrincipalGUI() {
        initComponents();
        setTitle("Database Backcup Manager");
        conexion = new ConexionGUI(this);
        conexionPanel.add(conexion);
        
        estrategias = new EstrategiasGUI(this);
        estrategiasPanel.add(estrategias);
        centreWindow(this);
        //tabPanel.setEnabledAt(1,false);
    }
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public EstrategiasGUI getEstrategias() {
        return estrategias;
    }

    public ConexionGUI getConexion() {
        return conexion;
    }
    
    
    public JTabbedPane getTabPanel()
    {
        return tabPanel;
    }

    public JPanel getConexionPanel() {
        return conexionPanel;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the db
     */
    public String getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(String db) {
        this.db = db;
    }

    /**
     * @return the userRemote
     */
    public String getUserRemote() {
        return userRemote;
    }

    /**
     * @param userRemote the userRemote to set
     */
    public void setUserRemote(String userRemote) {
        this.userRemote = userRemote;
    }

    /**
     * @return the passRemote
     */
    public String getPassRemote() {
        return passRemote;
    }

    /**
     * @param passRemote the passRemote to set
     */
    public void setPassRemote(String passRemote) {
        this.passRemote = passRemote;
    }

    /**
     * @return the ipRemote
     */
    public String getIpRemote() {
        return ipRemote;
    }

    /**
     * @param ipRemote the ipRemote to set
     */
    public void setIpRemote(String ipRemote) {
        this.ipRemote = ipRemote;
    }

    /**
     * @return the portRemote
     */
    public String getPortRemote() {
        return portRemote;
    }

    /**
     * @param portRemote the portRemote to set
     */
    public void setPortRemote(String portRemote) {
        this.portRemote = portRemote;
    }

    /**
     * @return the dbRemote
     */
    public String getDbRemote() {
        return dbRemote;
    }

    /**
     * @param dbRemote the dbRemote to set
     */
    public void setDbRemote(String dbRemote) {
        this.dbRemote = dbRemote;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        conexionPanel = new javax.swing.JPanel();
        estrategiasPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanel.addTab("Connection", conexionPanel);
        tabPanel.addTab("Estrategies", estrategiasPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conexionPanel;
    private javax.swing.JPanel estrategiasPanel;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
