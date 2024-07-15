package data.InfoObjetcs;

import java.util.Date;

public class Ticket {

    private int ticketID, clientAge;
    private String clientName, 
            procedureType; // Depósitos , Retiros, Cambio de divisas
    private Date creationTime, attentionTime;
    private char clientType; // P = Preferencial | A = Un solo tramite |B = MultiTramite | 
    private Ticket previousTicket,nextTicket1;
    
    
    // El ticket number se reinicia cada d[ia

    public Ticket(int id, String name, int age, String procedure, char type) {
        this.ticketID = id;
        this.clientName = name;
        this.clientAge = age;
        this.creationTime = new Date();
        this.attentionTime = null;
        this.procedureType = procedure;
        this.clientType = type;
    }


    public int getTicketID() {
        return ticketID;
    }

    
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }


    public String getClientName() {
        return clientName;
    }

    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public int getClientAge() {
        return clientAge;
    }
    

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }


    public Date getCreationTime() {
        return creationTime;
    }

    
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }


    public Date getAttentionTime() {
        return attentionTime;
    }

    
    public void setAttentionTime(Date attentionTime) {
        this.attentionTime = attentionTime;
    }


    public String getProcedureType() {
        return procedureType;
    }

    
    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }


    public char getClientType() {
        return clientType;
    }


    public void setClientType(char clientType) {
        this.clientType = clientType;
    }


    @Override
    public String toString() {
        return "Tiquete [id=" + ticketID + ", name=" + clientName + ", age=" + clientAge + ", creationTime=" + creationTime
                + ", attentionTime=" + attentionTime + ", procedure=" + procedureType + ", type=" + clientType + "]";
    }  

}
