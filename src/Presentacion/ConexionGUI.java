/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import AccesoADatos.ServicioConexion;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class ConexionGUI extends javax.swing.JPanel {

    public String user=null;
    public String pass=null;
    public String ip;
    public String port;
    public String db;
    public JPanel panel;
    
    public PrincipalGUI principal;
    
    public ConexionGUI(PrincipalGUI p) {
        principal = p;
        initComponents();
        imagenLabel.setText("");
        imagenLabel.setIcon(new ImageIcon("src/Recursos/db_image.png"));
        asCB.setEnabled(false);
        principal.getTabPanel().setEnabledAt(1,false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkMode = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ipTF = new javax.swing.JTextField();
        asCB = new javax.swing.JComboBox();
        portTF = new javax.swing.JTextField();
        conectBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dbTF = new javax.swing.JTextField();
        exitBoton = new javax.swing.JButton();
        passTF = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        imagenLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(949, 457));

        checkMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkModeActionPerformed(evt);
            }
        });

        jLabel3.setText("IP");

        jLabel4.setText("Port");

        jLabel6.setText("as");

        ipTF.setText("localhost");
        ipTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipTFActionPerformed(evt);
            }
        });

        asCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "sysdba", "sysoper" }));

        portTF.setText("1521");
        portTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTFActionPerformed(evt);
            }
        });

        conectBoton.setText("Connect");
        conectBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectBotonActionPerformed(evt);
            }
        });

        jLabel1.setText("User");

        userTF.setText("system");
        userTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        dbTF.setText("XE");
        dbTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbTFActionPerformed(evt);
            }
        });

        exitBoton.setText("Exit");
        exitBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBotonActionPerformed(evt);
            }
        });

        passTF.setText("root");
        passTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passTFKeyReleased(evt);
            }
        });

        jLabel5.setText("Data Base");

        imagenLabel.setText("Image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(conectBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ipTF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dbTF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passTF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(asCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkMode))
                            .addComponent(portTF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(imagenLabel)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(asCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkMode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ipTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(portTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dbTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conectBoton)
                    .addComponent(exitBoton))
                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ipTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipTFActionPerformed

    private void userTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTFActionPerformed

    private void conectBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectBotonActionPerformed
        if(userTF.getText().equals("") && passTF.getText().equals("") && ipTF.getText().equals("")
            && portTF.getText().equals("") && dbTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Empty spaces", "warning",1);
        }
        else{

            principal.setUser(user = userTF.getText());
            if(asCB.isEnabled()){
                user +=" as "+(String)asCB.getSelectedItem();
            }
            principal.setPass(pass = passTF.getText());
            principal.setIp(ip = ipTF.getText());
            principal.setPort(port = portTF.getText());
            principal.setDb(db = dbTF.getText());
            boolean exito = false;
            ServicioConexion sc = new ServicioConexion(user,pass,ip,port,db);
             try {
                exito = sc.iniciarConexion();
            } catch (Exception ex) {
                Logger.getLogger(ConexionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(exito){

                ConectadoGUI con = new ConectadoGUI(this);
                JPanel conPanel = principal.getConexionPanel();
                conPanel.removeAll();
                conPanel.add(con);
                conPanel.validate();
                
            }else{
                JOptionPane.showMessageDialog(this, "Can not connect to the database", "warning",1);
            }

        }
    }//GEN-LAST:event_conectBotonActionPerformed

    private void portTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portTFActionPerformed

    private void checkModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkModeActionPerformed

        boolean enable = asCB.isEnabled();

        if(enable)
        asCB.setEnabled(false);
        else
        asCB.setEnabled(true);
    }//GEN-LAST:event_checkModeActionPerformed

    private void exitBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBotonActionPerformed
        principal.dispose();
    }//GEN-LAST:event_exitBotonActionPerformed

    private void dbTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbTFActionPerformed

    private void passTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passTFKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.conectBoton.doClick();
        }
    }//GEN-LAST:event_passTFKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox asCB;
    private javax.swing.JCheckBox checkMode;
    private javax.swing.JButton conectBoton;
    private javax.swing.JTextField dbTF;
    private javax.swing.JButton exitBoton;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JTextField ipTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passTF;
    private javax.swing.JTextField portTF;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
