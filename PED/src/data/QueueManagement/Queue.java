
//import javax.swing.JOptionPane;
package data.QueueManagement;

import data.InfoObjetcs.Ticket;

public class Queue {
    private Node head;
    private Node last;
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public Node getLast() {
        return last;
    }
    public void setLast(Node last) {
        this.last = last;
    }
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
    
    //Encolar es lo mismo que agregar
    public void addNode(Ticket pData){
        Node nuevo = new Node(pData);
        if(isEmpty()){
            head=last=nuevo;
        }else{
            last.setNextNode(nuevo);
            last= nuevo;
        }
    }
    
    public void processNode(){
        if(isEmpty()){
            System.out.println("La cola esta vacia");
        }else{
            //Aqui recupero la info a retornar antes del if
            //Nodo aux = cabeza; aux.setSiguiente()=null;
            if(head==last){
                
                head=last=null;
            }else{
                head=head.getNextNode();
            }
            //return aux;
        }
        
    }
    
    
    public boolean findNode(int x) {
        Node aux = head;
        while (aux != null) {
            if (x == aux.getTicket().getTicketID()) {
                System.out.println("El Valor " + x + " si se encuentra en la pila");
                return true;
            }
            aux = aux.getNextNode();
        }
        System.out.println("El valor " + x + " no se encuentra en la pila");
        return false;
    }
    
    public Node extractNode(int x) {
        Node r = null;
        if(x==this.head.getTicket().getTicketID()){
            r=head;
            this.processNode();
            r.setNextNode(null);
        }else{
            Node aux = head;
            while(aux.getNextNode()!=null){
                if(aux.getNextNode().getTicket().getTicketID()==x){
                    r=aux.getNextNode();
                    aux.setNextNode(aux.getNextNode().getNextNode());
                    r.setNextNode(null);
                    break;
                }
                aux=aux.getNextNode();
            }
        }
        return r;
    }
    
    public Node getBiggest(){
        Node r = head;
        Node aux = this.head;
        while(aux!=null){
            if(r.getTicket().getTicketID()<aux.getTicket().getTicketID()){
                r=aux;
            }
            aux=aux.getNextNode();
        }
        //System.out.println(r+" es el valor mayor");
        return r;
    }
    
    public void sortQueue(){
        //se va almacenar los datos de la cola principal
        Queue temp = new Queue();
        while(head!=null){
            temp.addNode(this.getBiggest().getTicket());
         while(head!=null){
             temp.addNode(this.getBiggest().getTicket());
             var biggestData = this.getBiggest().getTicket();
             this.extractNode(biggestData.getTicketID());
         }
         this.head= temp.getHead();
        }
        this.head= temp.getHead();
        this.last= temp.getLast();   
        
    }
    
    
    @Override
    public String toString() {
        String r = "";
        Node aux = head;
        while(aux != null){
            r+= aux.toString();
            aux= aux.getNextNode();
        }
        return r ;
    }
}
