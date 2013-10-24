
package Presentacion;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import AccesoADatos.ServicioConexion;
import Logica.Configuracion;
import Logica.ContenedorConfiguracion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;


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
    
    ContenedorConfiguracion configuraciones;
    
    public PrincipalGUI() {
        initComponents();
        getTabPanel().setEnabledAt(2,false);
        setTitle("Database Backcup Manager");
        conexion = new ConexionGUI(this);
        conexionPanel.add(conexion);
        
        estrategias = new EstrategiasGUI(this);
        estrategiasPanel.add(estrategias);
        centreWindow(this);
        //tabPanel.setEnabledAt(1,false);
        
        configuraciones = new ContenedorConfiguracion();
        cargarConfigLocal();
        
    }

    public ContenedorConfiguracion getConfiguraciones() {
        return configuraciones;
    }
    
    public void cargarConfigLocal(){
        
        Configuracion e = configuraciones.getConfigLocal();
                
        localStrategyTF.setText(e.getStrategiesDir());
        localRMANLogTF.setText(e.getRMANLogDir());
        localRMANScriptTF.setText(e.getRMANScriptDir());
        localBackupTF.setText(e.getBackupDir());
    }
    
    public void cargarTabla(){
        
        //borra toda la tabla primero
        for(int i=0;i<((DefaultTableModel)serverNameT.getModel()).getRowCount();){
            ((DefaultTableModel)serverNameT.getModel()).removeRow(i);
        }
        
        ServicioConexion sc = new ServicioConexion(conexion.user,conexion.pass,conexion.ip,conexion.port,conexion.db);
        ArrayList<String> links=new ArrayList();
        try {
            links = sc.listarLinks();
        } catch (GlobalException | NoDataException ex) {
            //Logger.getLogger(ConectadoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //agrega lo que haya en el arraylist
        for(int i=0;i<links.size();i++){
            ((DefaultTableModel)serverNameT.getModel()).addRow(new Object[]{links.get(i)});
        }        
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
        serverNameT = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        serverSaveBoton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        serverStrategiesTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        serverRMANLogTF = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        serverRMANScriptTF = new javax.swing.JTextField();
        serverBackupTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        serverConfigTF = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        localRMANLogTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        localRMANScriptTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        localBackupTF = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        localStrategyTF = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        localSaveBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanel.addTab("Connection", conexionPanel);
        tabPanel.addTab("Estrategies", estrategiasPanel);

        serverNameT.setModel(new javax.swing.table.DefaultTableModel(
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
        serverNameT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                serverNameTMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(serverNameT);

        serverSaveBoton.setText("Save");
        serverSaveBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverSaveBotonActionPerformed(evt);
            }
        });

        jButton7.setText("change");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        serverStrategiesTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverStrategiesTFActionPerformed(evt);
            }
        });

        jLabel5.setText("Strategies Directory:");

        jLabel6.setText("RMAN Log Directory:");

        jButton9.setText("change");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("change");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel7.setText("Backup Directory:");

        jLabel8.setText("RMAN Scripts Directory:");

        jLabel9.setText("Server:");

        jButton11.setText("change");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(serverStrategiesTF, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(39, 39, 39)
                                        .addComponent(serverRMANLogTF))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(serverRMANScriptTF)
                                            .addComponent(serverBackupTF))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9)
                                    .addComponent(jButton10)
                                    .addComponent(jButton11))))
                        .addGap(133, 133, 133))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(serverConfigTF, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(serverSaveBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(serverConfigTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(serverStrategiesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(serverRMANLogTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(serverRMANScriptTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(serverBackupTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(39, 39, 39)
                .addComponent(serverSaveBoton)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Server Configuration", jPanel2);

        jLabel1.setText("RMAN Log Directory:");

        jButton1.setText("change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("change");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("RMAN Scripts Directory:");

        jLabel3.setText("Backup Directory:");

        jButton3.setText("change");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Strategies Directory:");

        jButton4.setText("change");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        localSaveBoton.setText("Save");
        localSaveBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localSaveBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(localSaveBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(localStrategyTF, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(40, 40, 40)
                                        .addComponent(localRMANLogTF))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(localRMANScriptTF)
                                            .addComponent(localBackupTF))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3))))
                        .addGap(141, 141, 141))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(localStrategyTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(localRMANLogTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(localRMANScriptTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(localBackupTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(39, 39, 39)
                .addComponent(localSaveBoton)
                .addContainerGap(206, Short.MAX_VALUE))
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        tabPanel.addTab("Configuration", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tabPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.localRMANLogTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.localRMANScriptTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.localBackupTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.localStrategyTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.serverStrategiesTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.serverRMANLogTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.serverRMANScriptTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void serverNameTMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serverNameTMouseReleased
 
     
        int index = serverNameT.getSelectedRow();
        if(index>=0){
            String server = (String)serverNameT.getModel().getValueAt(index, 0);
            serverConfigTF.setText(server);
            Configuracion c = configuraciones.buscar(server);
            
            if(c!=null){
                
                serverStrategiesTF.setText(c.getStrategiesDir());
                serverRMANLogTF.setText(c.getRMANLogDir());
                serverRMANScriptTF.setText(c.getRMANScriptDir());
                serverBackupTF.setText(c.getBackupDir());
            }
            else{
                serverStrategiesTF.setText("");
                serverRMANLogTF.setText("");
                serverRMANScriptTF.setText("");
                serverBackupTF.setText("");
            }

        }

   
    }//GEN-LAST:event_serverNameTMouseReleased

    private void serverStrategiesTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverStrategiesTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverStrategiesTFActionPerformed

    private void serverSaveBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverSaveBotonActionPerformed
        
        Configuracion c = new Configuracion(serverConfigTF.getText(),serverStrategiesTF.getText(),serverRMANLogTF.getText(),serverRMANScriptTF.getText(),serverBackupTF.getText());
        configuraciones.reemplazar(c);
        configuraciones.guardarArchivo();
        configuraciones.cargarArchivo();
        cargarTabla();
        JOptionPane.showMessageDialog(this, "Server configuration has been saved", "Configuration",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_serverSaveBotonActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal=fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        { 
            this.serverBackupTF.setText(fc.getSelectedFile().getAbsolutePath()); 
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void localSaveBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localSaveBotonActionPerformed
        Configuracion c = new Configuracion("Local",localStrategyTF.getText(),localRMANLogTF.getText(),localRMANScriptTF.getText(),localBackupTF.getText());
        configuraciones.setConfigLocal(c);
        configuraciones.guardarArchivoLocal();
        configuraciones.cargarArchivoLocal();
        cargarConfigLocal();
        JOptionPane.showMessageDialog(this, "Local configuration has been saved", "Configuration",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_localSaveBotonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conexionPanel;
    private javax.swing.JPanel estrategiasPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField localBackupTF;
    private javax.swing.JTextField localRMANLogTF;
    private javax.swing.JTextField localRMANScriptTF;
    private javax.swing.JButton localSaveBoton;
    private javax.swing.JTextField localStrategyTF;
    private javax.swing.JTextField serverBackupTF;
    private javax.swing.JTextField serverConfigTF;
    private javax.swing.JTable serverNameT;
    private javax.swing.JTextField serverRMANLogTF;
    private javax.swing.JTextField serverRMANScriptTF;
    private javax.swing.JButton serverSaveBoton;
    private javax.swing.JTextField serverStrategiesTF;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
