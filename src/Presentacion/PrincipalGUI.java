
package Presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFileChooser;
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
    
    private String currentServer="Unknow";
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

    /**
     * @return the currentServer
     */
    public String getCurrentServer() {
        return currentServer;
    }

    /**
     * @param currentServer the currentServer to set
     */
    public void setCurrentServer(String currentServer) {
        this.currentServer = currentServer;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        conexionPanel = new javax.swing.JPanel();
        estrategiasPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fileTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanel.addTab("Connection", conexionPanel);
        tabPanel.addTab("Estrategies", estrategiasPanel);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Server Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Server Configuration", jPanel2);

        jLabel1.setText("jLabel1");

        jButton1.setText("change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileTF, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(146, 146, 146))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(385, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Local", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jTabbedPane1)
        );

        tabPanel.addTab("Configuration", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.fileTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conexionPanel;
    private javax.swing.JPanel estrategiasPanel;
    private javax.swing.JTextField fileTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
