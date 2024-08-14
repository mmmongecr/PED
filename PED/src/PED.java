
import java.sql.ResultSet;
import java.sql.SQLException;

import data.App_Settings;
import data.SQLite_DBManager;
import gui.W_BankSelector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Manuel Mora Monge
 */
public class PED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        setLookAndFeel();
        
        App_Settings sysSettings = new App_Settings();
        
        
        
        
//        Thread t_statusBar = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                while (true) {                    
//                    sysSettings.getSystemInfo();
//                }
//            }
//        });
        
        W_BankSelector w_BankSelector = new W_BankSelector(sysSettings);
        //W_Login w_Login = new W_Login(sysSettings);
        
        SQLite_DBManager dBManager = new SQLite_DBManager();
        dBManager.connectDB("Bank_Of_America.ped");

        // Llamada a dynamicSelect
    String[] columns = {"username", "name", "last_login"};
    String condition = "status = 'Active'";
    ResultSet rs = dBManager.dynamicSelect("Bank_Of_America.ped", "ped_Users", columns, condition);
    
    try {
        while (rs != null && rs.next()) {
            System.out.println("Username: " + rs.getString("username"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Last Login: " + rs.getString("last_login"));
            System.out.println("----------------------------");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    // Llamada a dynamicUpdate
    String[][] updates = {{"status", "Inactive"}};
    dBManager.dynamicUpdate("Bank_Of_America.ped", "ped_Users", updates, "username = 'manuel.mora'");

    // Llamada a dynamicSelectWithGroupBy
    String[] groupColumns = {"user_type", "COUNT(*) as user_count"};
    String groupCondition = "status = 'Active'";
    String groupBy = "user_type";
    ResultSet rsGroup = dBManager.dynamicSelectWithGroupBy("Bank_Of_America.ped", "ped_Users", groupColumns, groupCondition, groupBy);
    
    try {
        while (rsGroup != null && rsGroup.next()) {
            System.out.println("User Type: " + rsGroup.getString("user_type"));
            System.out.println("User Count: " + rsGroup.getInt("user_count"));
            System.out.println("----------------------------");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    
    dBManager.closeDB();
}
    
    public static void setLookAndFeel(){
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLarfDark".equals(info.getName())) {
                //if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
}












/// USAR LISTAS EN LUGAR DE COLAS, DEFINIR PRIORIDAD POR TRAMITE ADEMAS DE LA DISCAPACIDAD, USAR LA PRIORIDAD COMO ORDEN DE LA LISTA