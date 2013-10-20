/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import AccesoADatos.ServicioTablespace;
import Logica.Estrategia;
import Logica.Horario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David-PC
 */
public class CrearEditarEstrategiaGUI extends javax.swing.JFrame {

    /**
     * Creates new form IMEC_Estrategia
     */
    EstrategiasGUI estrategias;
    ArrayList<Horario> horarios;
    
    public CrearEditarEstrategiaGUI(EstrategiasGUI e) {
        initComponents();
        setTitle("Strategy");
        estrategias = e;
        horarios = new ArrayList();
        cargarTabla();
        centreWindow(this);
    }
    
    public void cargarTabla(){
        
        //borra toda la tabla primero
        for(int i=0;i<((DefaultTableModel)tablespaceT.getModel()).getRowCount();){
            ((DefaultTableModel)tablespaceT.getModel()).removeRow(i);
        }
        
        ServicioTablespace sc = new ServicioTablespace(estrategias.principal.getUser(),estrategias.principal.getPass(),estrategias.principal.getIp(),estrategias.principal.getPort(),estrategias.principal.getDb());
        ArrayList<String> tablas=new ArrayList();
        try {
            tablas = sc.listarTablas(estrategias.principal.getCurrentServer());
        } catch (GlobalException | NoDataException ex) {
            //Logger.getLogger(ConectadoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //agrega lo que haya en el arraylist
        for(int i=0;i<tablas.size();i++){
            ((DefaultTableModel)tablespaceT.getModel()).addRow(new Object[]{tablas.get(i),false});
        }        
    }
    
    public void cargarTablaHorarios(){
        
        //borra toda la tabla primero
        for(int i=0;i<((DefaultTableModel)scheduleT.getModel()).getRowCount();){
            ((DefaultTableModel)scheduleT.getModel()).removeRow(i);
        }
        
    
        for(int i=0;i<horarios.size();i++){
            ((DefaultTableModel)scheduleT.getModel()).addRow(new Object[]{horarios.get(i).getDia(),horarios.get(i).getDe(),horarios.get(i).getHasta()});
        }        
    }
    public ArrayList<Horario> getHorarios() {
        return horarios;
    }
    
    public ArrayList<String> getTablespaces(){
        ArrayList<String> ts=new ArrayList();
        for(int i=0;i<tablespaceT.getRowCount();i++){
            boolean check = (boolean)tablespaceT.getValueAt(i, 1);
            if(check){
                ts.add((String)tablespaceT.getValueAt(i, 0));
            }
        }
        return ts;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fileTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fullCB = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablespaceT = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        statusCB = new javax.swing.JComboBox();
        archiveCB = new javax.swing.JCheckBox();
        aceptBoton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        newScheduleBoton = new javax.swing.JButton();
        clearAllBoton = new javax.swing.JButton();
        selectAllBoton = new javax.swing.JButton();
        deleteScheduleBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Strategy name:");

        nameTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTFKeyTyped(evt);
            }
        });

        jLabel2.setText("File name:");

        jLabel3.setText(".rman");

        fullCB.setText("Full Backup");
        fullCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullCBActionPerformed(evt);
            }
        });

        scheduleT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "From", "To"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scheduleT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(scheduleT);

        tablespaceT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tablespaces", "..."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablespaceT);
        tablespaceT.getColumnModel().getColumn(0).setResizable(false);
        tablespaceT.getColumnModel().getColumn(1).setMinWidth(30);
        tablespaceT.getColumnModel().getColumn(1).setPreferredWidth(30);
        tablespaceT.getColumnModel().getColumn(1).setMaxWidth(30);

        jLabel4.setText("Schedule");

        jLabel5.setText("Status");

        statusCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Inactive" }));

        archiveCB.setText("Archive");

        aceptBoton.setText("Acept");
        aceptBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptBotonActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        newScheduleBoton.setText("New");
        newScheduleBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newScheduleBotonActionPerformed(evt);
            }
        });

        clearAllBoton.setText("Clear All");
        clearAllBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllBotonActionPerformed(evt);
            }
        });

        selectAllBoton.setText("Select All");
        selectAllBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllBotonActionPerformed(evt);
            }
        });

        deleteScheduleBoton.setText("Delete");
        deleteScheduleBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteScheduleBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newScheduleBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteScheduleBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectAllBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearAllBoton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fullCB)
                                .addGap(9, 9, 9)
                                .addComponent(archiveCB))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fileTF, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(nameTF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(aceptBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fileTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullCB)
                    .addComponent(archiveCB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteScheduleBoton)
                            .addComponent(newScheduleBoton))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aceptBoton)
                            .addComponent(jButton2))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectAllBoton)
                            .addComponent(clearAllBoton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptBotonActionPerformed
        String file = fileTF.getText()+".rman";
        String name = nameTF.getText();
        String status = (String)statusCB.getSelectedItem();
        boolean statusB = status.equals("Active");
        boolean fullBackup = fullCB.isSelected();
        boolean archive = archiveCB.isSelected();
        
        Estrategia e = new Estrategia(name,file,getTablespaces(),horarios,fullBackup,archive,statusB,false);
        e.crearRMAN(estrategias);
        estrategias.getContenedorEstrategia().getEstrategias().add(e);
        estrategias.filtrarEstrategias();
        estrategias.cargarTabla();
        estrategias.guardarArchivo();
        this.dispose();
      
    }//GEN-LAST:event_aceptBotonActionPerformed

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    private void scheduleTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleTMouseClicked
        
    }//GEN-LAST:event_scheduleTMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fullCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullCBActionPerformed
       tablespaceT.clearSelection();
        if(fullCB.isSelected()){
           for(int i=0;i<tablespaceT.getRowCount();i++){
                tablespaceT.getModel().setValueAt(false,i,1);
            }
           tablespaceT.setEnabled(false);
        }
        else{
           tablespaceT.setEnabled(true);
        }
    }//GEN-LAST:event_fullCBActionPerformed

    private void selectAllBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllBotonActionPerformed
        
        for(int i=0;i<tablespaceT.getRowCount();i++){
            tablespaceT.getModel().setValueAt(true,i,1);
        }
    }//GEN-LAST:event_selectAllBotonActionPerformed

    private void clearAllBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllBotonActionPerformed
        for(int i=0;i<tablespaceT.getRowCount();i++){
            tablespaceT.getModel().setValueAt(false,i,1);
        }
    }//GEN-LAST:event_clearAllBotonActionPerformed

    private void nameTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTFKeyTyped
        
    }//GEN-LAST:event_nameTFKeyTyped

    private void nameTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTFKeyReleased
       String s = nameTF.getText();
       fileTF.setText(s);
    }//GEN-LAST:event_nameTFKeyReleased

    private void newScheduleBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newScheduleBotonActionPerformed
    
        HorarioGUI s = new HorarioGUI(this);
        s.setVisible(true);
    }//GEN-LAST:event_newScheduleBotonActionPerformed

    private void deleteScheduleBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteScheduleBotonActionPerformed
        int index = scheduleT.getSelectedRow();
        if(index>=0){
            String dia = (String)scheduleT.getModel().getValueAt(index,0);
            String de = (String)scheduleT.getModel().getValueAt(index,1);
            String hasta = (String)scheduleT.getModel().getValueAt(index,2);
            
            Horario h = new Horario(dia, de, hasta);
            horarios.remove(h);
        }
        cargarTablaHorarios();
    }//GEN-LAST:event_deleteScheduleBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptBoton;
    private javax.swing.JCheckBox archiveCB;
    private javax.swing.JButton clearAllBoton;
    private javax.swing.JButton deleteScheduleBoton;
    private javax.swing.JTextField fileTF;
    private javax.swing.JCheckBox fullCB;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTF;
    private javax.swing.JButton newScheduleBoton;
    private javax.swing.JTable scheduleT;
    private javax.swing.JButton selectAllBoton;
    private javax.swing.JComboBox statusCB;
    private javax.swing.JTable tablespaceT;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the scheduleT
     */
    public javax.swing.JTable getScheduleT() {
        return scheduleT;
    }
}
