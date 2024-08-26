/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Settings;

import data.InfoObjetcs.Bank;
import data.InfoObjetcs.User;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Manuel Mora Monge
 */
public class App_Settings {
    
    private Bank bank;
    private User currentUser;
    private String [] dollarExchangeRate;
    private SQLite_DBManager sql;
    
    public App_Settings(){
        sql = new SQLite_DBManager();
    }

    
    /**************************
    **    Getter y Setters   **
    ***************************/
    public Bank getCurrentBank() {
        return bank;
    }
    public void setCurrentBank(String bankName) {
        //bank = new Bank();
        //this.bank = bank;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public String[] getDollarExchangeRate() {
        return dollarExchangeRate;
    }
    public void setDollarExchangeRate() {
        // Llama al API de tipo de cambio y trae los valores de compra y venta del dollar
        API_Connection api_Connection = new  API_Connection();
        dollarExchangeRate = api_Connection.connectAPI("currencyExchange", null);
        
        // Prepara el formato de valores
        DecimalFormat formatter = new DecimalFormat("₡#,###.00");
                
        dollarExchangeRate[0] = formatter.format(Double.parseDouble(dollarExchangeRate[0]));
        dollarExchangeRate[1] = formatter.format(Double.parseDouble(dollarExchangeRate[1]));
    }

    public SQLite_DBManager getSql() {
        return sql;
    }
    
    
    
    
    
    /*****************
    **    Methods   **
    ******************/
    
    public String Now(){
        /// Trae la hora actual del sistema en un formato especifico 

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        return "" + dateFormat.format(new Date().getTime());
    }
    
    

    
    public String [] checkBankSites(){
        
        ///  Busca archivos con extensión .pedDB en el directorio actual.
        ///  Devuelve los nombres de los archivos encontrados, o null si no se encontraron archivos.
        
        
        // Obtiene la dirección del programa
        String currentDir = System.getProperty("user.dir");

        // Objeto con todo el directorio actual
        File directory = new File(currentDir);

        // Obtiene la lista de archivos en el directorio actual
        File[] files = directory.listFiles();

        // Lista para guardar los nombres de archivos .pedDB encontrados
        ArrayList<String> pedDBFiles = new ArrayList<>();

        // Recorrer los archivos y filtrar por la extensión .pedDB
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".ped")) {
                    pedDBFiles.add(file.getName());
                }
            }
        }

        // Convertir la lista a un array de Strings
        if (!pedDBFiles.isEmpty()) {
            return pedDBFiles.toArray(new String[0]);
        } else {
            return null; // Devolver null si no se encontraron archivos .pedDB
        }
    }
    
    
    
    
    
}
