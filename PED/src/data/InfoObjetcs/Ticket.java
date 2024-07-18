package data.InfoObjetcs;

import java.util.Date;

public class Ticket {

    private int ticketID, clientAge;
    private String clientName, 
            procedureType, // Depósitos , Retiros, Cambio de divisas
            procedureStatus; // P = Atentido  |  NS = No antentido
    private Date creationTime, attentionTime;
    private char clientType; // P = Preferencial | A = Un solo tramite |B = MultiTramite | 
    
    
    // El ticket number se reinicia cada d[ia

    public Ticket(int ticketID, int clientAge, String clientName, String procedureType, String procedureStatus, Date creationTime, Date attentionTime, char clientType) {
        this.ticketID = ticketID;
        this.clientAge = clientAge;
        this.clientName = clientName;
        this.procedureType = procedureType;
        this.procedureStatus = procedureStatus;
        this.creationTime = creationTime;
        this.attentionTime = attentionTime;
        this.clientType = clientType;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(String procedureStatus) {
        this.procedureStatus = procedureStatus;
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

    public char getClientType() {
        return clientType;
    }

    public void setClientType(char clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket{");
        sb.append("ticketID=").append(ticketID);
        sb.append(", clientAge=").append(clientAge);
        sb.append(", clientName=").append(clientName);
        sb.append(", procedureType=").append(procedureType);
        sb.append(", procedureStatus=").append(procedureStatus);
        sb.append(", creationTime=").append(creationTime);
        sb.append(", attentionTime=").append(attentionTime);
        sb.append(", clientType=").append(clientType);
        sb.append('}');
        return sb.toString();
    }

    

}
