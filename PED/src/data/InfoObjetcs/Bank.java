/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.InfoObjetcs;

import data.Settings.App_Settings;
import data.Settings.SQLite_DBManager;
import java.util.Date;

/**
 *
 * @author manuel.mora
 */
public class Bank {
    
    private String bName;
    private int bCounters, bDispensers;  
    private double bDollarSellPrice, bDollarBuyPrice;
    private Date bDollarLastUpdate; 
    private App_Settings app_Settings;
    private SQLite_DBManager dbManager;
    
    public Bank(String bankName){
        new SQLite_DBManager();
        //dbManager.readRowById(bName, "BankInfo", "");
    }
    
            
            // agregar un status para las cajas por si están fuera de servicio
    public void getBankCounters(){
        Thread dateTimeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                
                //dbManager.readRowById(bankName, bankName, bankName);
                
            }
        });
    }
    
    public void setBankCounters(){
        
    }
    
    
    
    
}
