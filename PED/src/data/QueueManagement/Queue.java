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
            last.setNext(nuevo);
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
                head=head.getNext();
            }
            //return aux;
        }
        
    }
    
    
    public boolean findNode(int x) {
        Node aux = head;
        while (aux != null) {
            if (x == aux.getData().getId()) {
                System.out.println("El Valor " + x + " si se encuentra en la pila");
                return true;
            }
            aux = aux.getNext();
        }
        System.out.println("El valor " + x + " no se encuentra en la pila");
        return false;
    }
    
    public Node extractNode(int x) {
        Node r = null;
        if(x==this.head.getData().getId()){
            r=head;
            this.processNode();
            r.setNext(null);
        }else{
            Node aux = head;
            while(aux.getNext()!=null){
                if(aux.getNext().getData().getId()==x){
                    r=aux.getNext();
                    aux.setNext(aux.getNext().getNext());
                    r.setNext(null);
                    break;
                }
                aux=aux.getNext();
            }
        }
        return r;
    }
    
    public Node getBiggest(){
        Node r = head;
        Node aux = this.head;
        while(aux!=null){
            if(r.getData().getId()<aux.getData().getId()){
                r=aux;
            }
            aux=aux.getNext();
        }
        //System.out.println(r+" es el valor mayor");
        return r;
    }
    
    public void sortQueue(){
        //se va almacenar los datos de la cola principal
        Queue temp = new Queue();
        while(head!=null){
            temp.addNode(this.getBiggest().getData());
         while(head!=null){
             temp.addNode(this.getBiggest().getData());
             var biggestData = this.getBiggest().getData();
             this.extractNode(biggestData.getId());
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
            aux= aux.getNext();
        }
        return r ;
    }
}
