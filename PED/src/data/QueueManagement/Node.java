package data.QueueManagement;

import data.InfoObjetcs.Ticket;


public class Node {
    private Ticket ticket;
    private Node nextNode, previousNode;
    

    public Node() {
        this.ticket = null;
        nextNode = null;
    }
    
    public Node(Ticket ticket) {
        this.ticket = ticket;
        nextNode = null;
        
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setDato(Ticket ticket) {
        this.ticket = ticket;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
    
    

    @Override
    public String toString() {
        return " " + ticket +"\n";
    }

    
    
    
    
    
}
