/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Settings;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


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
                /*
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
                */
                
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
            JOptionPane.showMessageDialog(null,
                    "La información introducida contiene código potencialmente peligroso\n"
                            + "Por favor verifique e ingresar la información de forma correcta", "Peligro de injección SQL", JOptionPane.ERROR_MESSAGE);
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
        String[][] columnsData = null;
        Object[][] queryValues = null;
        
        File dbFile = new File(dbName);
        connectDB(dbName);

        // Crea la tabla BankInfo
        columnsData = new String[][]{
            {"bName", "TEXT"},
            {"bCounters", "INTEGER"},
            {"bDispensers", "INTEGER"},
            {"bDollarSellPrice", "REAL"},
            {"bDollarBuyPrice", "REAL"},
            {"bDollarLastUpdate", "INTEGER"}
        };
        createTable(dbName, "BankInfo", columnsData);
        
        // Inserta la información del banco
        queryValues = new Object[][]{
            {columnsData[0][0], bankInfo[0]},
            {columnsData[1][0], Integer.parseInt(bankInfo[1])},
            {columnsData[2][0], Integer.parseInt(bankInfo[2])},
            {columnsData[3][0], null},
            {columnsData[4][0], null},
            {columnsData[5][0], null}
        };
        insert(dbName, "BankInfo", queryValues);
        

        // Crea la tabla Counters
        columnsData = new String[][]{
            {"cID", "INTEGER", "PRIMARY KEY", "AUTOINCREMENT"},
            {"cName", "TEXT"},
            {"cStatus", "TEXT"},
            {"uCashierID", "INTEGER"},
            {"tCurrentTicketID", "INTEGER"}
        };
        createTable(dbName, "Counters", columnsData);
        
        // Genera la cantidad de cajas establecidos en BankInfo
        for (int i = 1; i <= Integer.parseInt(bankInfo[1]); i++) {
            queryValues = new Object[][]{
                {"cID", null},
                {"cName", "Caja " + i},
                {"cStatus", "Inactive"},
                {"uCashierID", null},
                {"tCurrentTicketID", null}
            };
            insert(dbName, "Counters", queryValues);
        }
        

        // Crea la tabla Users
        columnsData = new String[][]{
            {"uID", "INTEGER", "PRIMARY KEY", "AUTOINCREMENT"},
            {"uUsername", "TEXT"},
            {"uPassword", "TEXT"},
            {"uName", "TEXT"},
            {"uLastName", "TEXT"},
            {"uType", "TEXT"},
            {"uStatus", "TEXT"},
            {"uLastLogin", "INTEGER"}
        };
        createTable(dbName, "Users", columnsData);
        
        // Crea el usuario administrador
        queryValues = new Object[][]{
            {"uID", null},
            {"uUsername", adminUser[0]},
            {"uPassword", adminUser[1]},
            {"uName", adminUser[2]},
            {"uLastName", adminUser[3]},
            {"uType", "Admin"},
            {"uStatus", "Active"},
            {"uLastLogin", null}
        };
        insert(dbName, "Users", queryValues);
        
        // Crea los usuarios para los dispensadores basado en la cantidad seleccionada
        for (int i = 1; i <= Integer.parseInt(bankInfo[2]) ; i++) {
            queryValues = new Object[][]{
                {"uID", null},
                {"uUsername", "dispenser" + i},
                {"uPassword", "dispenser" + i},
                {"uName", "Dispenser"},
                {"uLastName", "" + i},
                {"uType", "Dispenser"},
                {"uStatus", "Active"},
                {"uLastLogin", null}
            };
            insert(dbName, "Users", queryValues);
        }
        
        
        

        

        // Crea la tabla Tickets
        columnsData = new String[][]{
            {"tID", "INTEGER", "PRIMARY KEY", "AUTOINCREMENT"},
            {"tClientName", "TEXT"},
            {"tClientID", "INTEGER"},
            {"tClientAge", "INTEGER"},
            {"tClientType", "TEXT"},
            {"tCreationDate", "INTEGER"},
            {"tAttentionDate", "INTEGER"},
            {"tProcedureType", "TEXT"},
            {"tProcedureStatus", "TEXT"},
            {"cCounterID", "INTEGER"},
            {"uCashierID", "INTEGER"},};
        createTable(dbName, "Tickets", columnsData);

        

        //////////////////////// IDEA
        //// Cuando un cajero se logea tiene que elegir la caja en la que va a trabajar, en ese momento cambia el status de la caja, cuando el usuario se desloguea la caja vuelve a estar inactiva
        // Genera la cantidad de usuarios dispensadores establecidos en BankInfo
        
    }
    

    
    
    public synchronized List<Object> select(String dbName, String tableName, String[] selectColumns, String[][] whereClauses, String[] groupByColumns, String[] orderByColumns) {
        connectDB(dbName);

        // Construcción de la consulta SELECT
        String query = "SELECT ";

        if (selectColumns != null && selectColumns.length > 0) {
            for (int i = 0; i < selectColumns.length; i++) {
                query += selectColumns[i];
                if (i < selectColumns.length - 1) {
                    query += ", ";
                }
            }
        } else {
            query += "* "; // Selecciona todas las columnas si no se especifican
        }

        query += " FROM " + tableName;

        // Construcción de la cláusula WHERE
        if (whereClauses != null && whereClauses.length > 0) {
            query += " WHERE ";
            for (int i = 0; i < whereClauses.length; i++) {
                query += whereClauses[i][0] + " " + whereClauses[i][1] + " '" + whereClauses[i][2] + "'";
                if (i < whereClauses.length - 1) {
                    query += " AND ";
                }
            }
        }

        // Construcción de la cláusula GROUP BY
        if (groupByColumns != null && groupByColumns.length > 0) {
            query += " GROUP BY ";
            for (int i = 0; i < groupByColumns.length; i++) {
                query += groupByColumns[i];
                if (i < groupByColumns.length - 1) {
                    query += ", ";
                }
            }
        }

        // Construcción de la cláusula ORDER BY
        if (orderByColumns != null && orderByColumns.length > 0) {
            query += " ORDER BY ";
            for (int i = 0; i < orderByColumns.length; i++) {
                query += orderByColumns[i];
                if (i < orderByColumns.length - 1) {
                    query += ", ";
                }
            }
        }

        // Lista para almacenar los resultados
        List<Object> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            // Obtener metadatos de las columnas
            int columnCount = rs.getMetaData().getColumnCount();
            System.out.println("cantidad de columnas para " + tableName + " es : " + columnCount);

            String[][] columsMetaData = new String[columnCount][2];
            for (int i = 1; i <= columnCount; i++) {
                columsMetaData[i - 1][0] = rs.getMetaData().getColumnName(i);
                columsMetaData[i - 1][1] = rs.getMetaData().getColumnTypeName(i);
                System.out.println("OUTPUT ----------------------------------- \n"
                        + rs.getMetaData().getColumnName(i) + "     " + rs.getMetaData().getColumnTypeName(i) + " .......");
            }
            results.add(columsMetaData);

            // Obtener los datos
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Column name: " + columsMetaData[i - 1][0] + " \t\tColumn Type: " + columsMetaData[i - 1][1]);
                    try {
                        // Traer los datos de acuerdo al tipo definido en SQL
                        switch (columsMetaData[i - 1][1]) {
                            case "TEXT":
                                row[i - 1] = rs.getString(columsMetaData[i - 1][0]);
                                break;
                            case "INTEGER":
                                row[i - 1] = rs.getInt(columsMetaData[i - 1][0]);
                                break;
                            case "REAL":
                            case "DECIMAL":
                                row[i - 1] = rs.getDouble(columsMetaData[i - 1][0]);
                                break;
                            case "DATE":
                                row[i - 1] = rs.getDate(columsMetaData[i - 1][0]);
                                break;
                            default:
                                row[i - 1] = rs.getObject(columsMetaData[i - 1][0]);
                                break;
                        }

                        System.out.println("data.Settings.SQLite_DBManager.select()       " + row[i - 1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                results.add(row);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeDB();
        }

        return results;
    }


    
    
    
    public synchronized void insert(String dbName, String tableName, Object[][] entries) {
    // Conectar a la base de datos especificada
    
    connectDB(dbName);

    // Construye el INSERT con el nombre de la tabla y las columnas
    StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
    
    // Añade los nombres de las columnas al query
    for (int i = 0; i < entries.length; i++) {
        query.append(entries[i][0]);
        if (i < entries.length - 1) {
            query.append(", ");
        }
    }

    query.append(") VALUES (");

    // Agrega los placeholders para los valores en el query
    for (int i = 0; i < entries.length; i++) {
        query.append("?");
        if (i < entries.length - 1) {
            query.append(", ");
        }
    }
    query.append(")");

    // Añade los valores al query
    try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
        // Asignar los valores al PreparedStatement según su tipo
        for (int i = 0; i < entries.length; i++) {
            Object value = entries[i][1];
            if (value instanceof String) {
                pstmt.setString(i + 1, (String) value);
            } else if (value instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) value);
            } else if (value instanceof Double) {
                pstmt.setDouble(i + 1, (Double) value);
            } else if (value instanceof java.sql.Date) {
                pstmt.setDate(i + 1, (java.sql.Date) value);
            } else {
                pstmt.setObject(i + 1, value); // Por defecto, asignar el valor como Object
            }
        }

        // Ejecuta el insert
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        closeDB();
    }
}

    
    
    
    public synchronized void update(String dbName, String tableName, String[] columns, Object[] values, Object[][] whereClauses) {
        connectDB(dbName);

        String query = "UPDATE " + tableName + " SET ";

        // Construye la parte del SET
        for (int i = 0; i < columns.length; i++) {
            query += columns[i] + " = ?";
            if (i < columns.length - 1) {
                query += ", ";
            }
        }

        // Construye la parte del WHERE
        if (whereClauses != null && whereClauses.length > 0) {
            query += " WHERE ";
            for (int i = 0; i < whereClauses.length; i++) {
                query += whereClauses[i][0] + " " + whereClauses[i][1] + " ?";
                if (i < whereClauses.length - 1) {
                    query += " AND ";
                }
            }
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Asigna valores a los placeholders en el SET
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            // Asigna valores a los placeholders en el WHERE
            if (whereClauses != null && whereClauses.length > 0) {
                for (int i = 0; i < whereClauses.length; i++) {
                    pstmt.setObject(values.length + i + 1, whereClauses[i][2]);
                }
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeDB();
        }
    }


    
        
}
