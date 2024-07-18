
package data.QueueManagement;
import data.InfoObjetcs.Ticket;
import javax.swing.JOptionPane;

public class Caja {

    private Node headNode;
    
    public void joinQueue(Ticket pTicket) {
        Node newNode = new Node(pTicket);
        if (headNode == null) {
            headNode = newNode;
        } else if (headNode.getTicket().getTicketID() > pTicket.getTicketID()) {
            headNode = newNode;
        } else if (headNode.getNextNode() == null) {
            headNode.setNextNode(newNode);
        } else {

            Node aux = headNode;
            aux = headNode;
            while (aux.getNextNode() != null
                    && aux.getNextNode().getTicket().getTicketID() < pTicket.getTicketID()) {
                aux = aux.getNextNode();
            }
            aux.setNextNode(aux.getNextNode());
            aux.setNextNode(newNode);
        }
    }
    
    public int leftQueue(int pId) {
        int state = 0;

        if (headNode == null) {
            state = 3;
        } else if (headNode.getTicket().getTicketID() > pId) {
            state = 2;
        } else if (headNode.getTicket().getTicketID() == pId) {
            headNode = headNode.getNextNode();
        } else {
            Node aux = headNode;
            while (aux.getNextNode() != null
                    && aux.getNextNode().getTicket().getTicketID() < pId) {
                aux = aux.getNextNode();
            }
            if (aux.getNextNode() == null) {
                state = 2;
            } else if (aux.getNextNode().getTicket().getTicketID() == pId) {
                aux.setNextNode(aux.getNextNode().getNextNode());
            } else {
                state = 2;
            }
        }
        // 1 = Ticket eliminado
        // 2 = Ticket no se encuentra en la fila
        // 3 = Fila vacía
        return state;
    }
    
    public Node consulta(int pId){
        
        // Verifica si la lista está vacía o si el ID que se busca es menos que 
        if(headNode==null  || headNode.getTicket().getTicketID()>pId){
            return null;
        }else if(){
            
        }else if(headNode.getTicket().getTicketID()==pId){
            state = 1;
            JOptionPane.showMessageDialog(null, headNode);
        }else{
            Node
                    aux=headNode;
            while(aux.getNextNode()!=null&&
                    aux.getNextNode().getTicket().getTicketID()<pId){
                aux=aux.getNextNode();
            }
            
            if(aux.getNextNode()==null){
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }else if(aux.getNextNode().getTicket().getTicketID()==pId){
                JOptionPane.showMessageDialog(null, aux.getNextNode());
            }else{
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }
        }
        
        // 1 = Ticket eliminado
        // 2 = Ticket no se encuentra en la fila
        // 3 = Fila vacía
        return state;
    }
    
    public void modifica(int pId){
        if(headNode==null){
            JOptionPane.showMessageDialog(null, "ERROR: lista vacia");
        }else if(headNode.getTicket().getTicketID()>pId){
            JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
        }else if(headNode.getTicket().getTicketID()==pId){
            String newName=JOptionPane.showInputDialog(headNode+"\nIngrese el nuevo nombre");
            headNode.getTicket().setName(newName);
        }else{
            Node
                    aux=headNode;
            while(aux.getNextNode()!=null&&
                    aux.getNextNode().getTicket().getTicketID()<pId){
                aux=aux.getNextNode();
            }
            
            if(aux.getNextNode()==null){
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }else if(aux.getNextNode().getTicket().getTicketID()==pId){
                String newName=JOptionPane.showInputDialog(aux.getNextNode()+"\nIngrese el nuevo nombre");
                aux.getNextNode().getTicket().setName(newName);
            }else{
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }
        }
    }

    @Override
    public String toString() {
        String r="Lista:{\n";
        Node
                aux=headNode;
        while(aux!=null){
            r+=aux+"\n";
            aux=aux.getNextNode();
        }
        r+="}";
        return r;
    }
}

