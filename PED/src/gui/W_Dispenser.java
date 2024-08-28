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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import presets.CM_Button;

/**
 * @author manuel.mora
 */
public class W_Dispenser extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form W_Login
     */
    
    private App_Settings appSettings;
    private GridBagConstraints gbc;
    private Card_BS_NewBank card_NewBank;
    private Card_BS_PickABank card_PickABank;
    
    public W_Dispenser(App_Settings appSettings) {
        
        this.appSettings = appSettings;
        
        initComponents();
        
        pnl_StatusBar.showPanel(appSettings);
        pnl_Main.showPanel("bg3.png");
        
        setVisible(true);
        setLocationRelativeTo(null);
        
        
        btn_1.addActionListener(this);
        btn_2.addActionListener(this);
        btn_3.addActionListener(this);
        btn_4.addActionListener(this);
        btn_5.addActionListener(this);
        btn_6.addActionListener(this);
        btn_7.addActionListener(this);
        btn_8.addActionListener(this);
        btn_9.addActionListener(this);
        btn_0.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_OK.addActionListener(this);
        
        
        
        repaint();
        revalidate();
        
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        CM_Button button = (CM_Button) e.getSource();
        // Verifica si el botón accionado es un número, si es así lo agrega al tf_ClientID
        if (
            button == btn_1 || button == btn_2 || button == btn_3
            || button == btn_4 || button == btn_5 || button == btn_6
            || button == btn_7 || button == btn_8 || button == btn_9
            || button == btn_0){
            
            tf_clientID.setText(tf_clientID.getText() + button.getText());
            //revalidate();
            //repaint();
        }else if (e.getSource() == btn_delete) {
            // Remueve el último digito de tf_ClienteID
            if (!tf_clientID.equals("")) {
                tf_clientID.setText(tf_clientID.getText().substring(0, tf_clientID.getText().length() - 1));
            }
        }else if (e.getSource() == btn_OK) {
            //Consulta el API del TSE para buscar los datos del cliente y genera el ticket
            String [] clientInformation = appSettings.getApi_Connection().connectAPI("personalInformationByID", tf_clientID.getText());
            
            String clientName = 
                    clientInformation[0] + " " // Primer nombre
                    + clientInformation[1] + " " // Segundo nombre
                    + clientInformation[2] + " "  // Primer apellido
                    + clientInformation[3] ; // Segundo apellido
            
            if (JOptionPane.showConfirmDialog(
                    this,
                    "Su  nombre es : " + clientName + "\nSi esto es correcto presione 'Ok', de lo contrario precione 'Cancel' e intente de nuevo",
                    "Confirmación de identidad",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION)
            {
                // Si se presiona Ok se procede a crear un ticket
                char clientType = 'z';
                switch (cb_clientType.getSelectedItem().toString()) {
                    case "Preferencial":
                        clientType = 'P';
                        break;
                    case "Solo un trámite":
                        clientType = 'A';
                        break;
                    case "Dos o más trámites":
                        clientType = 'B';
                        break;
                }
                appSettings.getQueue().joinQueue(
                        new Ticket(
                                Integer.parseInt(tf_clientID.getText()) , 
                                0, 
                                clientName, 
                                cb_procedureType.getSelectedItem().toString(), 
                                "Pendiente", 
                                new Date(), 
                                null, clientType,appSettings));
                
                
                
            } else { // En caso de presionar cancelar se reinicia el ID del cliente para intentar de nuevo
                tf_clientID.setText("");
            }
            tf_clientID.setText("");
        }
    }
    
    
    //public void 
    
    

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
        lbl_clientType = new javax.swing.JLabel();
        cb_clientType = new presets.CM_ComboBox();
        lbl_procedureType = new javax.swing.JLabel();
        cb_procedureType = new presets.CM_ComboBox();
        separator1 = new javax.swing.JSeparator();
        lbl_clientID = new javax.swing.JLabel();
        tf_clientID = new presets.CM_TextField();
        pnl_numpad = new javax.swing.JPanel();
        btn_1 = new presets.CM_Button();
        btn_2 = new presets.CM_Button();
        btn_3 = new presets.CM_Button();
        btn_4 = new presets.CM_Button();
        btn_5 = new presets.CM_Button();
        btn_6 = new presets.CM_Button();
        btn_7 = new presets.CM_Button();
        btn_8 = new presets.CM_Button();
        btn_9 = new presets.CM_Button();
        btn_delete = new presets.CM_Button();
        btn_0 = new presets.CM_Button();
        btn_OK = new presets.CM_Button();
        filler = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        p_container.setMaximumSize(new java.awt.Dimension(485, 605));
        p_container.setMinimumSize(new java.awt.Dimension(485, 605));
        p_container.setPreferredSize(new java.awt.Dimension(485, 605));
        p_container.setLayout(new java.awt.GridBagLayout());

        lbl_Title.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title.setText("Bienvenido a nuestro sistema");
        lbl_Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_Title.setPreferredSize(new java.awt.Dimension(500, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(lbl_Title, gridBagConstraints);

        lbl_clientType.setText("Trámite");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(lbl_clientType, gridBagConstraints);

        cb_clientType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Depósito", "Retiro", "Cambio de Divisas", "Trámite multiple" }));
        cb_clientType.setMaximumSize(null);
        cb_clientType.setPreferredSize(new java.awt.Dimension(150, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(cb_clientType, gridBagConstraints);

        lbl_procedureType.setText("Cuántos trámites necesita realizar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(lbl_procedureType, gridBagConstraints);

        cb_procedureType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Preferencial", "Solo un trámite", "Dos o más trámites" }));
        cb_procedureType.setMaximumSize(null);
        cb_procedureType.setPreferredSize(new java.awt.Dimension(150, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(cb_procedureType, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(separator1, gridBagConstraints);

        lbl_clientID.setText("Ingrese su número de identificación (Incluyendo todos los ceros):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(lbl_clientID, gridBagConstraints);

        tf_clientID.setFocusable(false);
        tf_clientID.setMaximumSize(null);
        tf_clientID.setMinimumSize(new java.awt.Dimension(550, 36));
        tf_clientID.setPreferredSize(new java.awt.Dimension(550, 36));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        p_container.add(tf_clientID, gridBagConstraints);

        pnl_numpad.setLayout(new java.awt.GridBagLayout());

        btn_1.setForeground(new java.awt.Color(255, 255, 255));
        btn_1.setText("1");
        btn_1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_1, gridBagConstraints);

        btn_2.setForeground(new java.awt.Color(255, 255, 255));
        btn_2.setText("2");
        btn_2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_2, gridBagConstraints);

        btn_3.setForeground(new java.awt.Color(255, 255, 255));
        btn_3.setText("3");
        btn_3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_3, gridBagConstraints);

        btn_4.setForeground(new java.awt.Color(255, 255, 255));
        btn_4.setText("4");
        btn_4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_4, gridBagConstraints);

        btn_5.setForeground(new java.awt.Color(255, 255, 255));
        btn_5.setText("5");
        btn_5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_5, gridBagConstraints);

        btn_6.setForeground(new java.awt.Color(255, 255, 255));
        btn_6.setText("6");
        btn_6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_6, gridBagConstraints);

        btn_7.setForeground(new java.awt.Color(255, 255, 255));
        btn_7.setText("7");
        btn_7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_7, gridBagConstraints);

        btn_8.setForeground(new java.awt.Color(255, 255, 255));
        btn_8.setText("8");
        btn_8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_8, gridBagConstraints);

        btn_9.setForeground(new java.awt.Color(255, 255, 255));
        btn_9.setText("9");
        btn_9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_9, gridBagConstraints);

        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("←");
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_delete, gridBagConstraints);

        btn_0.setForeground(new java.awt.Color(255, 255, 255));
        btn_0.setText("0");
        btn_0.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_0, gridBagConstraints);

        btn_OK.setForeground(new java.awt.Color(255, 255, 255));
        btn_OK.setText("OK");
        btn_OK.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        pnl_numpad.add(btn_OK, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        p_container.add(pnl_numpad, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        p_container.add(filler, gridBagConstraints);

        pnl_Main.add(p_container, java.awt.BorderLayout.EAST);

        getContentPane().add(pnl_Main, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private presets.CM_Button btn_0;
    private presets.CM_Button btn_1;
    private presets.CM_Button btn_2;
    private presets.CM_Button btn_3;
    private presets.CM_Button btn_4;
    private presets.CM_Button btn_5;
    private presets.CM_Button btn_6;
    private presets.CM_Button btn_7;
    private presets.CM_Button btn_8;
    private presets.CM_Button btn_9;
    private presets.CM_Button btn_OK;
    private presets.CM_Button btn_delete;
    private presets.CM_ComboBox cb_clientType;
    private presets.CM_ComboBox cb_procedureType;
    private javax.swing.Box.Filler filler;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_clientID;
    private javax.swing.JLabel lbl_clientType;
    private javax.swing.JLabel lbl_procedureType;
    private javax.swing.JPanel p_container;
    private presets.CM_Panel pnl_Main;
    private presets.CM_StatusBar pnl_StatusBar;
    private javax.swing.JPanel pnl_numpad;
    private javax.swing.JSeparator separator1;
    private presets.CM_TextField tf_clientID;
    // End of variables declaration//GEN-END:variables

    
}
