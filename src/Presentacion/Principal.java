
package Presentacion;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Principal extends javax.swing.JFrame {

   
    Conexion conexion;
    Estrategias estrategias;
    
    public Principal() {
        initComponents();
        setTitle("Database Backcup Manager");
        conexion = new Conexion(this);
        conexionPanel.add(conexion);
        
        estrategias = new Estrategias(this);
        estrategiasPanel.add(estrategias);
        
        //tabPanel.setEnabledAt(1,false);
    }

    public Estrategias getEstrategias() {
        return estrategias;
    }

    public Conexion getConexion() {
        return conexion;
    }
    
    
    public JTabbedPane getTabPanel()
    {
        return tabPanel;
    }

    public JPanel getConexionPanel() {
        return conexionPanel;
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
