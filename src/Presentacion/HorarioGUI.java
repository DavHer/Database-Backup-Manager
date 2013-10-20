/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Horario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author David-PC
 */
public class HorarioGUI extends javax.swing.JFrame {

    
    CrearEditarEstrategiaGUI imec;
    String dia;
    int diaC;
    
    public HorarioGUI(CrearEditarEstrategiaGUI imec) {
        initComponents();
        setTitle("Shedule");
        this.imec = imec;
        centreWindow(this);
        
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
        Date date2 = new Date();
        SpinnerDateModel sm2 = new SpinnerDateModel(date2, null, null, Calendar.MINUTE);
        fromSpinner.setModel(sm);
        toSpinner.setModel(sm2);
        
        JSpinner.DateEditor de = new JSpinner.DateEditor(fromSpinner, "HH:mm");
        de.getTextField().setEditable( false );
        fromSpinner.setEditor(de);
        
        JSpinner.DateEditor de2 = new JSpinner.DateEditor(toSpinner, "HH:mm");
        de.getTextField().setEditable( false );
        toSpinner.setEditor(de2);

        System.out.println("Spinner:      "+((JSpinner.DateEditor)fromSpinner.getEditor()).getFormat().format(fromSpinner.getValue()));
                
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelBoton = new javax.swing.JButton();
        aceptBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        diaCB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        fromSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        toSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancelBoton.setText("Cancel");
        cancelBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBotonActionPerformed(evt);
            }
        });

        aceptBoton.setText("Acept");
        aceptBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptBotonActionPerformed(evt);
            }
        });

        jLabel1.setText("Day:");

        diaCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday", "Thuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        jLabel2.setText("From:");

        jLabel3.setText("To:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aceptBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(diaCB, 0, 102, Short.MAX_VALUE)
                            .addComponent(fromSpinner)
                            .addComponent(toSpinner))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(diaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fromSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(toSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptBoton)
                    .addComponent(cancelBoton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBotonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBotonActionPerformed

    private void aceptBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptBotonActionPerformed
        
        String from = ((JSpinner.DateEditor)fromSpinner.getEditor()).getFormat().format(fromSpinner.getValue());
        String to = ((JSpinner.DateEditor)toSpinner.getEditor()).getFormat().format(toSpinner.getValue());
        
        imec.horarios.add(new Horario((String)diaCB.getSelectedItem(), from,to));
        imec.cargarTablaHorarios();
        this.dispose();
    }//GEN-LAST:event_aceptBotonActionPerformed
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptBoton;
    private javax.swing.JButton cancelBoton;
    private javax.swing.JComboBox diaCB;
    private javax.swing.JSpinner fromSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner toSpinner;
    // End of variables declaration//GEN-END:variables
}
