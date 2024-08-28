/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Settings;

import data.InfoObjetcs.Bank;
import data.InfoObjetcs.User;
import data.QueueManagement.Queue;
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
    private SQLite_DBManager sql;
    private API_Connection api_Connection;
    private Queue queue;
    
    public App_Settings(){
        sql = new SQLite_DBManager();
        api_Connection = new  API_Connection();
    }

    
    /**************************
    **    Getter y Setters   **
    ***************************/
    public Bank getCurrentBank() {
        return bank;
    }
    public void setCurrentBank(String bankName) {
        bank = new Bank(bankName, this);
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    

    public API_Connection getApi_Connection() {
        return api_Connection;
    }
    
    

    public SQLite_DBManager getSql() {
        return sql;
    }

    public Queue getQueue() {
        return queue;
    }
    
    
    
    
    
    
    
    /*****************
    **    Methods   **
    ******************/
    
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
