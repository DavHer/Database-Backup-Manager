/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Horario;

/**
 *
 * @author David-PC
 */
public class HorarioGUI extends javax.swing.JFrame {

    
    CrearEditarEstrategiaGUI imec;
    String dia;
    int diaC;
    
    public HorarioGUI(CrearEditarEstrategiaGUI imec, int d) {
        initComponents();
        setTitle("Shedule");
        this.imec = imec;
        diaC = d;
        switch(d){
            case 0: dia = "Monday";
                break;
            case 1:dia = "Thuesday";
                break;
            case 2:dia = "Wednesday";
                break;
            case 3:dia = "Thursday";
                break;
            case 4:dia = "Friday";
                break;
            case 5:dia = "Saturday";
                break;
            case 6:dia = "Sunday";
                break;
            default:dia = "Monday";
                
        }
        
        diaLabel.setText(dia);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        diaLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        minutoDeSP = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        horaDeSP = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        minutoHastaSP = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        horaHastaSP = new javax.swing.JSpinner();
        aceptBoton = new javax.swing.JButton();
        cancelBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Day:");

        diaLabel.setText("dia..");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hours (24)"));

        jLabel3.setText("From:");

        minutoDeSP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel4.setText(":");

        horaDeSP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));

        jLabel5.setText(":");

        minutoHastaSP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel6.setText("To:");

        horaHastaSP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(horaDeSP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minutoDeSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(horaHastaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minutoHastaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(minutoDeSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(horaDeSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(minutoHastaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(horaHastaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aceptBoton.setText("Acept");
        aceptBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptBotonActionPerformed(evt);
            }
        });

        cancelBoton.setText("Cancel");
        cancelBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diaLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(aceptBoton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(diaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptBoton)
                    .addComponent(cancelBoton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptBotonActionPerformed
        int horaDe = (int)horaDeSP.getModel().getValue();
        int horaHasta = (int)horaHastaSP.getModel().getValue();
        int minutoDe = (int)minutoDeSP.getModel().getValue();
        int minutoHasta = (int)minutoHastaSP.getModel().getValue();
        
        imec.getHorarios().add(new Horario(dia, horaDe+":"+minutoDe,horaHasta+":"+minutoHasta));
        imec.getScheduleT().getModel().setValueAt(horaDe+":"+minutoDe+"\n"+horaHasta+":"+minutoHasta, 0, diaC);
        
        this.dispose();
    }//GEN-LAST:event_aceptBotonActionPerformed

    private void cancelBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBotonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptBoton;
    private javax.swing.JButton cancelBoton;
    private javax.swing.JLabel diaLabel;
    private javax.swing.JSpinner horaDeSP;
    private javax.swing.JSpinner horaHastaSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner minutoDeSP;
    private javax.swing.JSpinner minutoHastaSP;
    // End of variables declaration//GEN-END:variables
}
