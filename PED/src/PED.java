
import data.Settings.App_Settings;
import gui.W_BankSelector;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

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

        
        
        App_Settings sysSettings = new App_Settings();
        W_BankSelector w_BankSelector = new W_BankSelector(sysSettings);
        
        w_BankSelector.setIconImage(Toolkit.getDefaultToolkit().getImage("src/assets/AppIcon.png"));
 
    }
    
}





























/// USAR LISTAS EN LUGAR DE COLAS, DEFINIR PRIORIDAD POR TRAMITE ADEMAS DE LA DISCAPACIDAD, USAR LA PRIORIDAD COMO ORDEN DE LA LISTA