/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Manuel Mora Monge
 */
public class App_Settings {
    
    private String currentSite;
    private User currentUser;
    
    
    public App_Settings() {
    }

    public String getCurrentSite() {
        return currentSite;
    }

    public void setCurrentSite(String currentSite) {
        this.currentSite = currentSite;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    
    public String Now(){
        
        // Define el formato de fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        return "" + dateFormat.format(new Date().getTime());
    }
    
    

    //  Busca archivos con extensión .pedDB en el directorio actual.
    //  @return Array de Strings con los nombres de los archivos encontrados, o null si no se encontraron archivos.
    public String [] checkBankSites(){    
        
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
