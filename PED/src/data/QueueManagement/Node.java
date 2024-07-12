package data.QueueManagement;

import data.InfoObjetcs.Ticket;



public class Node {
    private Ticket data;
    private Node next;
    //Comentario

    public Node() {
        this.data = null;
        next = null;
    }
    
    public Node(Ticket dato) {
        this.data = dato;
        next = null;
    }

    public Ticket getData() {
        return data;
    }

    public void setDato(Ticket data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return " " + data +"\n";
    }

    
    
    
    
    
}
