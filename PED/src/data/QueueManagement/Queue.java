
//import javax.swing.JOptionPane;
package data.QueueManagement;

import data.InfoObjetcs.Ticket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queue {
    
    private String name;
    private Node headNode; 
    private Node lastNode; 

    public Queue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getNodesQTY(){
        int nodesQTY = 0;
        if (headNode == null) {
            nodesQTY = 0;
        }else {
            Node auxNode = headNode;
            do {
                nodesQTY ++;
                auxNode = auxNode.getNextNode();
            } while (auxNode != null);
        }
        return nodesQTY;
    }

    // Agrega Tickets al queue ordenado por el ticketID
    public void joinQueue(Ticket newTicket) {
        Node newNode = new Node(newTicket);

        // Inicializa headNode y lastNode si la lista está vacía 
        if (headNode == null) {
            headNode = newNode;
            lastNode = newNode; 
            return;
        }

        // Si el nuevo ID es mayor que el ID en lastNode, se agrega al final
        if (newTicket.getTicketID() > lastNode.getTicket().getTicketID()) {
            lastNode.setNextNode(newNode); // El antiguo lastNode apunta al nuevo nodo
            lastNode = newNode; // lastNode ahora es el nuevo nodo
            return;
        }

        // Si el nuevo ID es menor que el ID en headNode, se agrega al principio
        if (newTicket.getTicketID() < headNode.getTicket().getTicketID()) {
            newNode.setNextNode(headNode); // El nuevo nodo apunta al antiguo headNode
            headNode = newNode; // headNode ahora es el nuevo nodo
            return;
        }

        // Inserción en la posición correcta dentro de la lista
        Node current = headNode;
        while (current.getNextNode() != headNode && current.getNextNode().getTicket().getTicketID() < newTicket.getTicketID()) {
            current = current.getNextNode();
        }
        // Insertar el nuevo nodo en su posición
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);
    }

    // Método para encontrar un nodo en la cola basado en el ID del Ticket
    public Node findInQueue(int id, boolean needPrevNode) {
        
        if ( // Valida las siguientes condiciones con la ondición OR
                headNode == null // Si la lista está vacía
                || id < headNode.getTicket().getTicketID() // Si el ID es menor que headNode
                || id > lastNode.getTicket().getTicketID() // Si el ID es mayor que lastNode 
            ) {
            return null;
        }

        // Búsqueda en la cola
        if (headNode.getTicket().getTicketID() == id) {
            // Si needPrevNode es true establece cual es el nodo previo al nodo que se va a retornar
            if (needPrevNode) {
                headNode.setPreviousNode(null);
            }
            return headNode; // ID encontrado
        } else {
            Node currentNode = headNode;
            do {
                if (currentNode.getNextNode().getTicket().getTicketID() == id) {
                    // Si needPrevNode es true establece cual es el nodo previo al nodo que se va a retornar
                    if (needPrevNode) {
                        currentNode.getNextNode().setPreviousNode(currentNode);
                    }
                    return currentNode.getNextNode(); // ID encontrado
                }
                currentNode = currentNode.getNextNode();
            } while (currentNode.getNextNode() != null);
        }
        return null; // ID no encontrado
    }

    // Método para eliminar un nodo de la cola basado en el ID del Ticket
    public boolean leftQueue(int id) {
        // Utiliza el método findInQueue para buscar el ticket a eliminar
        Node nodeToRemove = findInQueue(id, true);

        // Devuelve false si no encuentra el ID]
        if (nodeToRemove == null) {
            return false;
        }

        // Si el nodo a eliminar es headNode
        if (nodeToRemove == headNode) {
            // Si solo hay un nodo en la lista
            if (headNode == lastNode) {
                headNode = null;
                lastNode = null;
            } else {
                headNode = headNode.getNextNode();
            }
            return true;
        }

        // Buscar el nodo anterior al nodo a eliminar
        Node previous = headNode;
        while (previous.getNextNode() != nodeToRemove) {
            previous = previous.getNextNode();
        }

        // Si el nodo a eliminar es lastNode
        if (nodeToRemove == lastNode) {
            lastNode = nodeToRemove.getPreviousNode();
            lastNode.setNextNode(null);
        } else {
            nodeToRemove.getPreviousNode().setNextNode(nodeToRemove.getNextNode());
        }
        return true; // Nodo eliminado con éxito
    }
    
    public List<String[]> getQueueInfo(){
        List<String[]> queueInfo = new ArrayList<>();
        
        Node auxNode = headNode;
        if (headNode == null) {
            return null;
        }
        do {
            String [] ticket = new String[3];
            ticket[0] = auxNode.getTicket().getTicketID() + "";
            ticket[1] = auxNode.getTicket().getProcedureType();
            ticket[2] = auxNode.getTicket().getClientType() + "";
                    
            queueInfo.add(ticket);
            auxNode = auxNode.getNextNode();
        } while (auxNode != null);
        return queueInfo;
    }
    
    public int getNewTicketID(){
        int newTicketID = 1;
        if (lastNode != null) {
            newTicketID = lastNode.getTicket().getTicketID() + 1;
        }
        return newTicketID;
    }
    

    @Override
    public String toString() {
        
        String r = "";
        Node auxNode = headNode;
        if (headNode == null) {
            r = "Lista vacía";
        }
        do {
            r += auxNode.getTicket().getTicketID() + " --> " + auxNode.getTicket().getClientName() + "\n" ;
            auxNode = auxNode.getNextNode();
        } while (auxNode != null);
        
        return r;
    }
    
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*private Node head;
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
    }*/
