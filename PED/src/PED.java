
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