/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.InfoObjetcs;

import data.Settings.SQLite_DBManager;

/**
 *
 * @author manuel.mora
 */
public class Bank {
    
    private String bankName;
            
            // agregar un status para las cajas por si están fuera de servicio
    public void getBankCounters(){
        Thread dateTimeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                SQLite_DBManager dbManager = new SQLite_DBManager();
                dbManager.readRowById(bankName, bankName, bankName);
                
            }
        });
    }
    
    public void setBankCounters(){
        
    }
    
    
    
    
}
