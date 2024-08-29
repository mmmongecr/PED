/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import data.InfoObjetcs.Ticket;
import data.Settings.App_Settings;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import presets.CM_Button;

/**
 * @author manuel.mora
 */
public class W_Queues extends javax.swing.JFrame {

    /**
     * Creates new form W_Login
     */
    
    private App_Settings appSettings;
    
    public W_Queues(App_Settings appSettings) {
        
        this.appSettings = appSettings;
        
        initComponents();
        
        pnl_StatusBar.showPanel(appSettings);
        pnl_Main.showPanel("bg1.png");
        
        lbl_Title.setText(lbl_Title.getText().replace("###", appSettings.getCurrentUser().getName()));
        
        setVisible(true);
        setLocationRelativeTo(null);
        
        repaint();
        revalidate();
        
        int qtyCounters = appSettings.getCurrentBank().getbCounters();
        System.out.println("\n\n\n\n\n\n\n\n");
        
        
        
        for (int i = 0; i < qtyCounters; i++) {
            List<String[]> tickets = appSettings.getCounter(i).getQueueInfo();
            System.out.println("Caja " + (i+1));

            if (tickets == null || tickets.isEmpty()) { // Verifica si tickets es null o está vacío
                System.out.println("La caja está vacía");
            } else {
                for (int j = 0; j < tickets.size(); j++) {
                    System.out.println(
                            "Numero de tiquete : " + tickets.get(j)[0]
                            + "\tTipo de tiquete : " + tickets.get(j)[1]
                            + // Corrige el índice si es necesario
                            "\tTipo de cliente: " + tickets.get(j)[2] + getName()
                    );
                }
            }
        }
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnl_StatusBar = new presets.CM_StatusBar();
        pnl_Main = new presets.CM_Panel();
        p_container = new javax.swing.JPanel();
        lbl_Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cM_ComboBox1 = new presets.CM_ComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de registro");
        setName("Login"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        setType(java.awt.Window.Type.UTILITY);

        pnl_StatusBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_StatusBar.setMaximumSize(null);
        pnl_StatusBar.setMinimumSize(null);
        pnl_StatusBar.setPreferredSize(new java.awt.Dimension(975, 25));
        getContentPane().add(pnl_StatusBar, java.awt.BorderLayout.SOUTH);

        pnl_Main.setPreferredSize(new java.awt.Dimension(485, 605));
        pnl_Main.setLayout(new java.awt.BorderLayout());

        p_container.setOpaque(false);
        p_container.setLayout(new java.awt.GridBagLayout());

        lbl_Title.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title.setText("Lista de espera");
        lbl_Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_Title.setPreferredSize(new java.awt.Dimension(500, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        p_container.add(lbl_Title, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        p_container.add(jScrollPane1, gridBagConstraints);

        cM_ComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Caja 1", "Caja 2", "Caja 3", "Caja 4", "Caja 5" }));
        cM_ComboBox1.setMaximumSize(null);
        cM_ComboBox1.setPreferredSize(new java.awt.Dimension(300, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        p_container.add(cM_ComboBox1, gridBagConstraints);

        pnl_Main.add(p_container, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnl_Main, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private presets.CM_ComboBox cM_ComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JPanel p_container;
    private presets.CM_Panel pnl_Main;
    private presets.CM_StatusBar pnl_StatusBar;
    // End of variables declaration//GEN-END:variables

    
}
