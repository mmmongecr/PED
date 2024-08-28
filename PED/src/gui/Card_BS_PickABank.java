/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;


import data.Settings.App_Settings;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mmmon
 */
public class Card_BS_PickABank extends javax.swing.JPanel {

    /**
     * Creates new form Card_BS_NewBank
     */
    
    private W_BankSelector parentFrame;
    private JPanel parentPanel;
    
    public Card_BS_PickABank() {
        
    }
    
    public void showCard(String [] banks, JPanel parentPanel, W_BankSelector parentFrame){
        initComponents();
        this.parentFrame = parentFrame;
        this.parentPanel = parentPanel;
        
        for (int i = 0; i < banks.length; i++) {
                banks[i] = banks[i].replace(".ped", "");
                banks[i] = banks[i].replace("_", " ");
            }
        
        cb_BankNames.setModel(new DefaultComboBoxModel(banks){});
        setVisible(true);
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

        lbl_Description = new javax.swing.JLabel();
        lbl_BankNames = new javax.swing.JLabel();
        cb_BankNames = new presets.CM_ComboBox();
        btn_initSystem = new presets.CM_Button();
        btn_newBank = new presets.CM_Button();
        filler_bottom = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler_Top = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jSeparator1 = new javax.swing.JSeparator();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(470, 595));
        setLayout(new java.awt.GridBagLayout());

        lbl_Description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Description.setText("<html>\nPor favor selecciones el banco al que desea ingresar y haga click en el botón iniciar sistema.\n</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        add(lbl_Description, gridBagConstraints);

        lbl_BankNames.setText("<html>Banco: </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lbl_BankNames, gridBagConstraints);

        cb_BankNames.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cb_BankNames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bank1", "Bank2" }));
        cb_BankNames.setMaximumSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cb_BankNames, gridBagConstraints);

        btn_initSystem.setBorder(null);
        btn_initSystem.setForeground(new java.awt.Color(255, 255, 255));
        btn_initSystem.setText("Iniciar sistema");
        btn_initSystem.setMaximumSize(new java.awt.Dimension(305, 40));
        btn_initSystem.setMinimumSize(new java.awt.Dimension(105, 40));
        btn_initSystem.setPreferredSize(new java.awt.Dimension(155, 40));
        btn_initSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_initSystemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(btn_initSystem, gridBagConstraints);

        btn_newBank.setBorder(null);
        btn_newBank.setForeground(new java.awt.Color(255, 255, 255));
        btn_newBank.setText("Nuevo banco");
        btn_newBank.setMaximumSize(new java.awt.Dimension(305, 40));
        btn_newBank.setMinimumSize(new java.awt.Dimension(105, 40));
        btn_newBank.setPreferredSize(new java.awt.Dimension(155, 40));
        btn_newBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newBankActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(btn_newBank, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        add(filler_bottom, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        add(filler_Top, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        add(jSeparator1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_initSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_initSystemActionPerformed
        parentFrame.getAppSettings().setCurrentBank(cb_BankNames.getSelectedItem().toString());
        W_Login login = new W_Login(parentFrame.getAppSettings());
        parentFrame.dispose();
    }//GEN-LAST:event_btn_initSystemActionPerformed

    private void btn_newBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newBankActionPerformed
        parentFrame.changeCard(1, null);
        parentFrame.revalidate();
        parentFrame.repaint();
    }//GEN-LAST:event_btn_newBankActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private presets.CM_Button btn_initSystem;
    private presets.CM_Button btn_newBank;
    private presets.CM_ComboBox cb_BankNames;
    private javax.swing.Box.Filler filler_Top;
    private javax.swing.Box.Filler filler_bottom;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_BankNames;
    private javax.swing.JLabel lbl_Description;
    // End of variables declaration//GEN-END:variables
}
