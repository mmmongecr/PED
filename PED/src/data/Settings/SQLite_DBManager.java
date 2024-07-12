/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Settings;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Manuel Mora Monge
 */
public class SQLite_DBManager {
    
    private Connection conn;
    
    
    // Método para conectar a la base de datos
    protected void connectDB(String dbName) {
        try {
            File dbFile = new File(dbName);
            boolean dbExists = dbFile.exists();

            // Cargar el driver de SQLite
            Class.forName("org.sqlite.JDBC");
            // Establecer la conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);

            if (!dbExists) {
                System.out.println("Base de datos no encontrada. Creando una nueva base de datos.");
                
                // Define las columnas de la tabla Users
                String[][] userColumns = {
                    {"user_ID", "INTEGER", "PRIMARY KEY", "AUTOINCREMENT"},
                    {"username", "TEXT"},
                    {"name", "TEXT"},
                    {"last_name", "TEXT"},
                    {"user_type", "TEXT"},
                    {"status", "TEXT"},
                    {"last_login", "DATE"}
                };
                createTable(dbName, "ped_Users",userColumns);
                
                // Crea un Admin User por default para el sistema
                String[][] tempUser = {
                    {"username", "adminRoot"},
                    {"name", "Admin"},
                    {"last_name", "Root"},
                    {"user_type", "Admin"},
                    {"status", "Active"}
                };
                insertRow(dbName,"ped_Users",tempUser);
                
                
                // Crea un User Cajero por default para el sistema
                tempUser[0][1] = "manuel.mora";     // "username"
                tempUser[1][1] = "Manuel";          // "name"
                tempUser[2][1] = "Mora";            // "last_name"
                tempUser[3][1] = "Cashier";         // "user_type"
                tempUser[4][1] = "Active";          // "status"
                insertRow(dbName,"ped_Users", tempUser);
                
                // Crea un User Dispensador de tiquetes por default para el sistema
                tempUser[0][1] = "ticket.dispenser01";     // "username"
                tempUser[1][1] = "Dispensador";          // "name"
                tempUser[2][1] = "01";            // "last_name"
                tempUser[3][1] = "TicketDispenser";         // "user_type"
                tempUser[4][1] = "Active";          // "status"
                insertRow(dbName,"ped_Users", tempUser);
   
                
            } else {
                System.out.println("Conexión establecida a la base de datos existente.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    // Método para cerrar la conexión
    public void closeDB() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para crear una tabla
    public synchronized void createTable(String dbName, String tableName, String[][] columns) {
        connectDB(dbName);
        try (Statement stmt = conn.createStatement()) {
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " (");
        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i][0]).append(" ").append(columns[i][1]);
            for (int j = 2; j < columns[i].length; j++) {
                sql.append(" ").append(columns[i][j]);
            }
            if (i < columns.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
        stmt.executeUpdate(sql.toString());
        System.out.println("Tabla creada.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
        closeDB();
}

    // Método para agregar una línea a la tabla
    public synchronized void insertRow(String dbName, String tableName, String[][] values) {
        connectDB(tableName);
        try (Statement stmt = conn.createStatement()) {
            StringBuilder columns = new StringBuilder();
            StringBuilder vals = new StringBuilder();
            for (String[] value : values) {
                columns.append(value[0]).append(", ");
                vals.append("'").append(value[1]).append("', ");
            }
            // Eliminar las comas y espacios adicionales
            columns.setLength(columns.length() - 2);
            vals.setLength(vals.length() - 2);
            String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + vals + ")";
            stmt.executeUpdate(sql);
            System.out.println("Línea insertada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        closeDB();
    }

    // Método para borrar una línea de la tabla por ID
    public synchronized void deleteRowById(String dbName, String tableName, String id) {
        connectDB(dbName);
        try (Statement stmt = conn.createStatement()) {
            int parsedId = Integer.parseInt(id);
            String sql = "DELETE FROM " + tableName + " WHERE id = " + parsedId;
            stmt.executeUpdate(sql);
            System.out.println("Línea borrada.");
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        closeDB();
    }

    // Método para leer todas las líneas de la tabla
    public synchronized void readAllRows(String dbName, String tableName) {
        connectDB(dbName);
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM " + tableName + "";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", ");
                for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + ", ");
                }
                System.out.println();
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        closeDB();
    }

    // Método para leer una línea de la tabla por ID
    public synchronized void readRowById(String dbName, String tableName, String id) {
        connectDB(dbName);
        try (Statement stmt = conn.createStatement()) {
            int parsedId = Integer.parseInt(id);
            String sql = "SELECT * FROM " + tableName + " WHERE id = " + parsedId;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.print("ID: " + rs.getInt("id") + ", ");
                for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + ", ");
                }
                System.out.println();
            } else {
                System.out.println("Registro no encontrado.");
            }
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        closeDB();
    }
    
}
