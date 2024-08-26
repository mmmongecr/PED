
import data.InfoObjetcs.Ticket;
import data.QueueManagement.Queue;
import data.Settings.API_Connection;
import data.Settings.App_Settings;
import data.Settings.SQLite_DBManager;
import gui.W_BankSelector;
import gui.W_Dispenser;
import gui.W_Login;
import java.util.Calendar;
import java.util.Date;

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
        
        
        SQLite_DBManager sql = new SQLite_DBManager();
        //sql.dinamycQuery("555555555555555555.ped", "ped_Users", new String[]{"*"}, null, null, null);
        Object [] rows = (Object[]) sql.dinamycQuery("555555555555555555.ped", "ped_Users", new String[]{"*"}, null, null, null).get(1);
        System.out.println("CANTIDAD de columnas : " + rows.length);
        System.out.println("Cantidad de Resultados : " + sql.dinamycQuery("555555555555555555.ped", "ped_Users", new String[]{"*"}, null, null, null).size());
        
//        Queue q1 = new Queue();
//        q1.joinQueue(new Ticket(5, 52, "Charlie White", "Consulta", "Completado", new Date(2024, Calendar.AUGUST, 17, 8, 20), new Date(2024, Calendar.AUGUST, 17, 8, 45), 'A'));
//        q1.joinQueue(new Ticket(3, 45, "Alice Johnson", "Consulta", "En Proceso", new Date(2024, Calendar.AUGUST, 19, 14, 0), new Date(2024, Calendar.AUGUST, 21, 12, 30), 'A'));
//        q1.joinQueue(new Ticket(7, 37, "Ethan Blue", "Consulta", "Pendiente", new Date(2024, Calendar.AUGUST, 15, 10, 15), new Date(2024, Calendar.AUGUST, 22, 10, 0), 'A'));
//        q1.joinQueue(new Ticket(4, 29, "Bob Brown", "Cirugía", "Pendiente", new Date(2024, Calendar.AUGUST, 18, 16, 45), new Date(2024, Calendar.AUGUST, 22, 9, 0), 'C'));
//        q1.joinQueue(new Ticket(15, 39, "Michael Brown", "Consulta", "En Proceso", new Date(2024, Calendar.AUGUST, 7, 9, 0), new Date(2024, Calendar.AUGUST, 21, 12, 0), 'A'));
//        q1.joinQueue(new Ticket(2, 34, "Jane Smith", "Examen", "Pendiente", new Date(2024, Calendar.AUGUST, 20, 9, 30), new Date(2024, Calendar.AUGUST, 21, 11, 0), 'B'));
//        q1.joinQueue(new Ticket(6, 40, "Diana Green", "Examen", "En Proceso", new Date(2024, Calendar.AUGUST, 16, 13, 30), new Date(2024, Calendar.AUGUST, 21, 14, 0), 'B'));
//        q1.joinQueue(new Ticket(13, 50, "Kevin Orange", "Consulta", "Pendiente", new Date(2024, Calendar.AUGUST, 9, 12, 15), new Date(2024, Calendar.AUGUST, 22, 9, 30), 'A'));
//        q1.joinQueue(new Ticket(8, 49, "Fiona Black", "Cirugía", "Completado", new Date(2024, Calendar.AUGUST, 14, 11, 0), new Date(2024, Calendar.AUGUST, 14, 13, 0), 'C'));
//        q1.joinQueue(new Ticket(9, 33, "George Red", "Consulta", "En Proceso", new Date(2024, Calendar.AUGUST, 13, 14, 30), new Date(2024, Calendar.AUGUST, 21, 15, 15), 'A'));
//        q1.joinQueue(new Ticket(14, 26, "Laura Violet", "Examen", "Completado", new Date(2024, Calendar.AUGUST, 8, 10, 30), new Date(2024, Calendar.AUGUST, 8, 11, 15), 'B'));
//        q1.joinQueue(new Ticket(1, 25, "John Doe", "Consulta", "Completado", new Date(2024, Calendar.AUGUST, 21, 10, 0), new Date(2024, Calendar.AUGUST, 21, 10, 15), 'A'));
//        q1.joinQueue(new Ticket(11, 31, "Ian Gray", "Consulta", "Completado", new Date(2024, Calendar.AUGUST, 11, 15, 0), new Date(2024, Calendar.AUGUST, 11, 15, 30), 'A'));
//        q1.joinQueue(new Ticket(12, 42, "Judy Pink", "Cirugía", "En Proceso", new Date(2024, Calendar.AUGUST, 10, 13, 0), new Date(2024, Calendar.AUGUST, 21, 16, 0), 'C'));
//        q1.joinQueue(new Ticket(10, 28, "Helen Yellow", "Examen", "Pendiente", new Date(2024, Calendar.AUGUST, 12, 9, 45), new Date(2024, Calendar.AUGUST, 22, 11, 30), 'B'));
//        
//        
//        System.out.println(q1.toString());
//        
//        System.out.println(q1.findInQueue(14, false).getTicket().getClientName());
//        System.out.println(q1.findInQueue(3, false).getTicket().getClientName());
//        System.out.println(q1.findInQueue(7, false).getTicket().getClientName());
//        
//        
//        q1.leftQueue(9);
//        q1.leftQueue(12);
//        q1.leftQueue(5);
//        q1.leftQueue(1);
//        q1.leftQueue(15);
        
        
//        System.out.println(q1.toString());
        


        
        
//        App_Settings sysSettings = new App_Settings();
//        
//        
//        W_BankSelector w_BankSelector = new W_BankSelector(sysSettings);
        //W_Login w_Login = new W_Login(sysSettings);
        
    /*
        API_Connection api_Connection = new  API_Connection();
        
        String[] printable = null;
        
        printable = api_Connection.connectAPI("currencyExchange", null);
        
        System.out.println("currencyExchange");
        for (int i = 0; i < printable.length; i++) {
            System.out.println("\t" + printable[i]);
        }
        
        printable = api_Connection.connectAPI("personalInformationByID", "207510670");
        System.out.println("personalInformationByID");
        for (int i = 0; i < printable.length; i++) {
            System.out.println("\t" + printable[i]);
        }
      */
            
    }
    
}

/// USAR LISTAS EN LUGAR DE COLAS, DEFINIR PRIORIDAD POR TRAMITE ADEMAS DE LA DISCAPACIDAD, USAR LA PRIORIDAD COMO ORDEN DE LA LISTA