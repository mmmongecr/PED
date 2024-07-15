
import data.Settings.API_Connection;
import data.Settings.App_Settings;
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
        
    //    SQLite_DBManager dBManager = new SQLite_DBManager();
    //    dBManager.connectDB("Bank_Of_America.ped");

        
    
        API_Connection api_Connection = new  API_Connection();
        
        String[] printable = null;
        
        printable = api_Connection.connectAPI("currencyExchange", null);
        
        System.out.println("currencyExchange");
        for (int i = 0; i < printable.length; i++) {
            System.out.println("\t" + printable[i]);
        }
        
        printable = api_Connection.connectAPI("personalInformationByID", "207510670");
        System.out.println("personalInformationByID");
        for (int i = 0; i < printable.length; i++) {
            System.out.println("\t" + printable[i]);
        }
        
        
        
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