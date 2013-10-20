/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import AccesoADatos.ServicioConexion;
import AccesoADatos.ServicioTablespace;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David-PC
 */
public class ConectadoGUI extends javax.swing.JPanel {

    private ConexionGUI conexion;
    
    public ConectadoGUI(ConexionGUI p) {
        conexion = p;
        initComponents();
        cargarTabla();
        serverTF.setText(conexion.principal.getCurrentServer());
        usuarioLabel.setText(conexion.user);
        currentDBLabel.setText(conexion.db);
    }
    
    public void cargarTabla(){
        
        //borra toda la tabla primero
        for(int i=0;i<((DefaultTableModel)serverTable.getModel()).getRowCount();){
            ((DefaultTableModel)serverTable.getModel()).removeRow(i);
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
            ((DefaultTableModel)serverTable.getModel()).addRow(new Object[]{links.get(i)});
        }        
    }

    /**
     * @return the conexion
     */
    public ConexionGUI getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(ConexionGUI conexion) {
        this.conexion = conexion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        serverTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        desconectBoton = new javax.swing.JButton();
        deleteBoton = new javax.swing.JButton();
        editBoton = new javax.swing.JButton();
        newBoton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablespaceTable = new javax.swing.JTable();
        selectBoton = new javax.swing.JButton();
        currentCheck = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        serverTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        currentDBLabel = new javax.swing.JLabel();

        jLabel1.setText("Connect to");

        serverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Server Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        serverTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serverTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(serverTable);

        jLabel2.setText("User connected as:");

        usuarioLabel.setText("usuario");

        desconectBoton.setText("Disconnect");
        desconectBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconectBotonActionPerformed(evt);
            }
        });

        deleteBoton.setText("Delete");
        deleteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBotonActionPerformed(evt);
            }
        });

        editBoton.setText("Edit");
        editBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBotonActionPerformed(evt);
            }
        });

        newBoton.setText("New");
        newBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBotonActionPerformed(evt);
            }
        });

        jLabel3.setText("Database View");

        tablespaceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tablespaces"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablespaceTable);

        selectBoton.setText("Select");
        selectBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBotonActionPerformed(evt);
            }
        });

        currentCheck.setText("Use current location");
        currentCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentCheckActionPerformed(evt);
            }
        });

        jLabel5.setText("Server");

        serverTF.setEditable(false);
        serverTF.setText("Unknow");

        jLabel4.setText("Current Database:");

        currentDBLabel.setText("db");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(selectBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(newBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(editBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usuarioLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(currentDBLabel)))
                                .addGap(18, 18, 18)
                                .addComponent(desconectBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(currentCheck)))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 337, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverTF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usuarioLabel)
                    .addComponent(desconectBoton)
                    .addComponent(jLabel5)
                    .addComponent(serverTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(currentDBLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentCheck)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBoton)
                    .addComponent(editBoton)
                    .addComponent(newBoton)
                    .addComponent(selectBoton))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBotonActionPerformed
        ServersGUI l = new ServersGUI(this);
        l.setVisible(true);
    }//GEN-LAST:event_newBotonActionPerformed

    private void editBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBotonActionPerformed

    private void serverTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serverTableMouseClicked
        currentCheck.setSelected(false);
        try {
            int index = serverTable.getSelectedRow();
            if(index>=0){
                String server = (String)serverTable.getModel().getValueAt(index, 0);
            
                ServicioTablespace st = new ServicioTablespace(conexion.user,conexion.pass,conexion.ip,conexion.port,conexion.db);
                ArrayList<String> lista = st.listarTablas(server);
                
                for(int i=0;i<((DefaultTableModel)tablespaceTable.getModel()).getRowCount();){
                    ((DefaultTableModel)tablespaceTable.getModel()).removeRow(i);
                }
                for(int i=0;i<lista.size();i++){
                    ((DefaultTableModel)tablespaceTable.getModel()).addRow(new Object[]{lista.get(i)});
                }
            }
             
            
        } catch (GlobalException | NoDataException ex) {
            Logger.getLogger(ConectadoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_serverTableMouseClicked

    private void currentCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentCheckActionPerformed
        serverTable.clearSelection();
        if(currentCheck.isSelected()){
            try {       
            ServicioTablespace st = new ServicioTablespace(conexion.user,conexion.pass,conexion.ip,conexion.port,conexion.db);
            ArrayList<String> lista = st.listarTablas(conexion.db);
            
            for(int i=0;i<lista.size();i++){
                ((DefaultTableModel)tablespaceTable.getModel()).addRow(new Object[]{lista.get(i)});
            } 
            
            } catch (GlobalException | NoDataException ex) {
                Logger.getLogger(ConectadoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            serverTable.clearSelection();
            for(int i=0;i<((DefaultTableModel)tablespaceTable.getModel()).getRowCount();){
                ((DefaultTableModel)tablespaceTable.getModel()).removeRow(i);
            }
        }
        
    }//GEN-LAST:event_currentCheckActionPerformed

    private void selectBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBotonActionPerformed
        
        int index = serverTable.getSelectedRow();
        if(index>=0){
            String server = (String)serverTable.getModel().getValueAt(index, 0);
            conexion.principal.setCurrentServer(server);
            serverTF.setText(server);
            conexion.principal.estrategias.getServerTF().setText(server);
            conexion.principal.estrategias.cargarArchivo();
            conexion.principal.estrategias.filtrarEstrategias();
            conexion.principal.estrategias.cargarTabla();
            conexion.principal.getTabPanel().setEnabledAt(1,true);
        }
        if(currentCheck.isSelected()){
            conexion.principal.setCurrentServer(conexion.db);
            serverTF.setText(conexion.db);
            conexion.principal.estrategias.getServerTF().setText(conexion.db);
            conexion.principal.estrategias.cargarArchivo();
            conexion.principal.estrategias.filtrarEstrategias();
            conexion.principal.estrategias.cargarTabla();
            conexion.principal.getTabPanel().setEnabledAt(1,true);
        }
    }//GEN-LAST:event_selectBotonActionPerformed

    private void desconectBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconectBotonActionPerformed
        
        ConexionGUI con =new ConexionGUI(conexion.principal);
        JPanel conPanel = conexion.principal.getConexionPanel();
        conPanel.removeAll();
        conPanel.add(con);
        conPanel.validate();
    }//GEN-LAST:event_desconectBotonActionPerformed

    private void deleteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBotonActionPerformed
        int index = serverTable.getSelectedRow();
        if(index>=0&&!currentCheck.isSelected()){
            String server = (String)serverTable.getModel().getValueAt(index, 0);
            ServicioConexion sc = new ServicioConexion(conexion.user, conexion.pass, conexion.ip, conexion.port, conexion.db);
            boolean exito = false;
            try {
                Object[] options = {"Yes", "No"};
                int op = JOptionPane.showOptionDialog(this, "Do you want to delete server " + server + "?", "Delete Server", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

                if (op == 0) {
                    exito = sc.dropLink(server);
                    cargarTabla();
                } 
            } catch (    GlobalException | NoDataException ex) {
                exito = false;
                Logger.getLogger(ConectadoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(exito){
                JOptionPane.showMessageDialog(this, "The server "+server+" has been deleted");
            }
        }
    }//GEN-LAST:event_deleteBotonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox currentCheck;
    private javax.swing.JLabel currentDBLabel;
    private javax.swing.JButton deleteBoton;
    private javax.swing.JButton desconectBoton;
    private javax.swing.JButton editBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newBoton;
    private javax.swing.JButton selectBoton;
    private javax.swing.JTextField serverTF;
    private javax.swing.JTable serverTable;
    private javax.swing.JTable tablespaceTable;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
