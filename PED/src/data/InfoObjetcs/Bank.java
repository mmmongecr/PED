/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.InfoObjetcs;

import data.Settings.API_Connection;
import data.Settings.App_Settings;
import data.Settings.SQLite_DBManager;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manuel.mora
 */
public class Bank {
    
    private String bName, dbName;
    private int bCounters, bDispensers;  
    private double bDollarSellPrice, bDollarBuyPrice;
    private Date bDollarLastUpdate; 
    private App_Settings app_Settings;
    
    public Bank(String bankName, App_Settings app_Settings){
       
        this.app_Settings = app_Settings;
        bankName = bankName.replace( " ", "_") + ".ped";
        dbName = bankName;
        setDollarExchangeRate();
        refreshBankInfo();
        
    }
    
    public void refreshBankInfo(){
        
        
        //  Consulta la base de datos para traer los valores guardados
        List <Object> sqlResultObjects = app_Settings.getSql().select(dbName, "BankInfo", null, null, null, null);
        Object[] bankConfig = (Object[]) sqlResultObjects.getLast();
        
        
        bName = bankConfig[0] + "";
        bCounters = Integer.parseInt(bankConfig[1].toString()) ;
        bDispensers = Integer.parseInt(bankConfig[2].toString());
        bDollarSellPrice = Double.parseDouble(bankConfig[3].toString()) ;
        bDollarBuyPrice = Double.parseDouble(bankConfig[4].toString()) ;
        bDollarLastUpdate = new Date(Integer.parseInt(bankConfig[2].toString()));
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public int getbCounters() {
        return bCounters;
    }

    public void setbCounters(int bCounters) {
        this.bCounters = bCounters;
        app_Settings.getSql().update(dbName, "BankInfo", new String[]{"bCounters"}, new Object[]{bCounters}, null);
        
    }

    public int getbDispensers() {
        return bDispensers;
    }

    public void setbDispensers(int bDispensers) {
        this.bDispensers = bDispensers;
        app_Settings.getSql().update(dbName, "BankInfo", new String[]{"bDispensers"}, new Object[]{bDispensers}, null);
    }

    public String getbDollarSellPrice() {
        
        // Prepara el formato de valores
        DecimalFormat formatter = new DecimalFormat("₡#,###.00");
        return formatter.format(bDollarSellPrice);
    }

    public void setbDollarSellPrice(double bDollarSellPrice) {
        this.bDollarSellPrice = bDollarSellPrice;
        app_Settings.getSql().update(dbName, "BankInfo", new String[]{"bDollarSellPrice"}, new Object[]{bDollarSellPrice}, null);
        
    }

    public String getbDollarBuyPrice() {
        
        // Prepara el formato de valores
        DecimalFormat formatter = new DecimalFormat("₡#,###.00");
        return formatter.format(bDollarBuyPrice);
    }

    public void setbDollarBuyPrice(double bDollarBuyPrice) {
        this.bDollarBuyPrice = bDollarBuyPrice;
        app_Settings.getSql().update(dbName, "BankInfo", new String[]{"bDollarBuyPrice"}, new Object[]{bDollarBuyPrice}, null);
    }

    public Date getbDollarLastUpdate() {
        return bDollarLastUpdate;
    }

    public void setbDollarLastUpdate(Date bDollarLastUpdate) {
        this.bDollarLastUpdate = bDollarLastUpdate;
    }

    public App_Settings getApp_Settings() {
        return app_Settings;
    }

    public void setApp_Settings(App_Settings app_Settings) {
        this.app_Settings = app_Settings;
    }
    
    public void setDollarExchangeRate() {
        // Llama al API de tipo de cambio y trae los valores de compra y venta del dollar
        API_Connection api_Connection = new  API_Connection();
        String [] dollarExchangeRate = api_Connection.connectAPI("currencyExchange", null);
        
        bDollarSellPrice = Double.parseDouble(dollarExchangeRate[0]);
        setbDollarSellPrice(Double.parseDouble(dollarExchangeRate[0]));
        bDollarBuyPrice = Double.parseDouble(dollarExchangeRate[1]);
        setbDollarBuyPrice(Double.parseDouble(dollarExchangeRate[1]));
    }
     
    
}
