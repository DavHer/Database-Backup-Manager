
package Presentacion;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Principal extends javax.swing.JFrame {

   
    public Principal() {
        initComponents();
        setTitle("Database Backcup Manager");
        Conexion c = new Conexion(this);
        conexionPanel.add(c);
        tabPanel.setEnabledAt(1,false);
    }
    
    public JTabbedPane getTabPanel()
    {
        return tabPanel;
    }

    public JPanel getConexionPanel() {
        return conexionPanel;
    }

    public JPanel getEstrategias() {
        return estrategias;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        conexionPanel = new javax.swing.JPanel();
        estrategias = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanel.addTab("Connection", conexionPanel);

        javax.swing.GroupLayout estrategiasLayout = new javax.swing.GroupLayout(estrategias);
        estrategias.setLayout(estrategiasLayout);
        estrategiasLayout.setHorizontalGroup(
            estrategiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        estrategiasLayout.setVerticalGroup(
            estrategiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        tabPanel.addTab("Estrategies", estrategias);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conexionPanel;
    private javax.swing.JPanel estrategias;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
