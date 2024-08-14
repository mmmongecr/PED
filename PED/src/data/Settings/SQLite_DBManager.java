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
    
    public void setNewBank(){
        
    }
    
    
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
    
    public boolean noSQLInjection(String input){
        
        boolean validation = true;
        
        if (
                input != null // No es vacío 
                && input.length() <= 50 // No es mayor a 50 caracteres
                && input.matches("[a-zA-Z0-9_ ]+") // Solo posee números y letras
            ) {
            return true;
        }else {
            return false;
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
    public synchronized String [][] readRowById(String dbName, String tableName, String id) {
        connectDB(dbName);
        
        String [][] results;
        
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM " + tableName;
            
            // Valida si el parámetro pID tiene información para filtrar
            if (!id.equals("")) {
                int parsedId = Integer.parseInt(id);
                sql += " WHERE id = " + parsedId;
            }
            
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
        return null;
    }

    
    public void createNewDB(String [] bankInfo, String [] adminUser){
        
        // Convierte el nombre del Banco a formato sin espacios para nombrar la DB
        String dbName = bankInfo[0].replace(" ", "_") + ".ped";
        String[][] queryData = null;
        
        File dbFile = new File(dbName);
        connectDB(dbName);

        // Crea la tabla BankInfo
        queryData = new String[][]{
            {"bName", "TEXT"},
            {"bCounters", "INTEGER"},
            {"bDispensers", "INTEGER"},
            {"bDollarSellPrice", "REAL"},
            {"bDollarBuyPrice", "REAL"},
            {"bDollarLastUpdate", "INTEGER"}
        };
        createTable(dbName, "BankInfo", queryData);

        // Crea la tabla Counters
        queryData = new String[][]{
            {"cID", "INTEGER", "PRIMARY KEY", "AUTOINCREMENT"},
            {"cName", "TEXT"},
            {"cStatus", "TEXT"},
            {"uCashierID", "INTEGER"}
        };
        createTable(dbName, "Counters", queryData);

        // Crea la tabla Users
        queryData = new String[][]{
            {"uID", "INTEGER", "PRIMARY KEY", "AUTOINCREMENT"},
            {"uUsername", "TEXT"},
            {"uPassword", "TEXT"},
            {"uName", "TEXT"},
            {"uLastName", "TEXT"},
            {"uType", "TEXT"},
            {"uStatus", "TEXT"},
            {"uLastLogin", "INTEGER"}
        };
        createTable(dbName, "Users", queryData);

        // Crea la tabla Tickets
        queryData = new String[][]{
            {"tID", "INTEGER", "PRIMARY KEY", "AUTOINCREMENT"},
            {"tClientName", "TEXT"},
            {"tClientID", "INTEGER"},
            {"tClientAge", "INTEGER"},
            {"tClientType", "TEXT"},
            {"tCreationDate", "INTEGER"},
            {"tAttentionDate", "INTEGER"},
            {"tProcedureType", "TEXT"},
            {"cCounterID", "INTEGER"},
            {"uCashierID", "INTEGER"},};
        createTable(dbName, "Tickets", queryData);

        // Inserta la información del banco
        queryData = new String[][]{
            {"bName", bankInfo[0]},
            {"bCounters", bankInfo[1]},
            {"bDollarSellPrice", "0"},
            {"bDollarBuyPrice", "0"}
        };
        insertRow(dbName, "BankInfo", queryData);

        // Inserta la información del usuario Admin
        queryData = new String[][]{
            {"uUsername", adminUser[0]},
            {"uPassword", adminUser[1]},
            {"uName", adminUser[2]},
            {"uLastName", adminUser[3]},
            {"uType", "Admin"},
            {"uStatus", "Active"}
        };
        insertRow(dbName, "Users", queryData);

        // Genera la cantidad de cajas establecidos en BankInfo
        for (int i = 1; i <= Integer.parseInt(bankInfo[1]); i++) {
            queryData = new String[][]{
                {"cName", "Caja " + i},
                {"cStatus", "Inactive"},};
            insertRow(dbName, "Users", queryData);
        }
        
        // Crea los usuarios para los dispensadores basado en la cantidad seleccionada
        for (int i = 1; i <= Integer.parseInt(bankInfo[2]) ; i++) {
            queryData = new String[][]{
                {"uUsername", "dispenser" + i},
                {"uPassword", "dispenser" + i},
                {"uName", "Dispenser"},
                {"uLastName", "" + i},
                {"uType", "Dispenser"},
                {"uStatus", "Active"}
            };
            insertRow(dbName, "Users", queryData);
        }
        

        //////////////////////// IDEA
        //// Cuando un cajero se logea tiene que elegir la caja en la que va a trabajar, en ese momento cambia el status de la caja, cuando el usuario se desloguea la caja vuelve a estar inactiva
        // Genera la cantidad de usuarios dispensadores establecidos en BankInfo
        
    }

    //Metodo dinamico para el SELECT
    public synchronized ResultSet dynamicSelect(String dbName, String tableName, String[] columns, String condition) {
        connectDB(dbName);
        ResultSet rs = null;
        try (Statement stmt = conn.createStatement()) {
            StringBuilder sql = new StringBuilder("SELECT ");
            if (columns == null || columns.length == 0) {
                sql.append("*");
            } else {
                for (int i = 0; i < columns.length; i++) {
                    sql.append(columns[i]);
                    if (i < columns.length - 1) {
                        sql.append(", ");
                    }
                }
            }
            sql.append(" FROM ").append(tableName);
            if (condition != null && !condition.isEmpty()) {
                sql.append(" WHERE ").append(condition);
            }
            
            rs = stmt.executeQuery(sql.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }


    //Metodo dinamico para el UPDATE

    public synchronized void dynamicUpdate(String dbName, String tableName, String[][] updates, String condition) {
        connectDB(dbName);
        try (Statement stmt = conn.createStatement()) {
            StringBuilder sql = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
            for (int i = 0; i < updates.length; i++) {
                sql.append(updates[i][0]).append(" = '").append(updates[i][1]).append("'");
                if (i < updates.length - 1) {
                    sql.append(", ");
                }
            }
            if (condition != null && !condition.isEmpty()) {
                sql.append(" WHERE ").append(condition);
            }
            
            stmt.executeUpdate(sql.toString());
            System.out.println("Datos actualizados.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        closeDB();
    }

    // Metodo dinamico con AGRUPACION
    public synchronized ResultSet dynamicSelectWithGroupBy(String dbName, String tableName, String[] columns, String condition, String groupBy) {
        connectDB(dbName);
        ResultSet rs = null;
        try (Statement stmt = conn.createStatement()) {
            StringBuilder sql = new StringBuilder("SELECT ");
            if (columns == null || columns.length == 0) {
                sql.append("*");
            } else {
                for (int i = 0; i < columns.length; i++) {
                    sql.append(columns[i]);
                    if (i < columns.length - 1) {
                        sql.append(", ");
                    }
                }
            }
            sql.append(" FROM ").append(tableName);
            if (condition != null && !condition.isEmpty()) {
                sql.append(" WHERE ").append(condition);
            }
            if (groupBy != null && !groupBy.isEmpty()) {
                sql.append(" GROUP BY ").append(groupBy);
            }
            
            rs = stmt.executeQuery(sql.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    
    



    
}
