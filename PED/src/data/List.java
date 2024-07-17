
package data;
import javax.swing.JOptionPane;

public class List {
    private Node cabeza;
    
    public void insertar(User pUser){
        Node
        nuevo=new Node (pUser);
        if(cabeza==null){
            cabeza=nuevo;
        }else if(cabeza.getData().getId()>pUser.getID()){
            cabeza=nuevo;
        }else if(cabeza.getNext()==null){
            cabeza.setNext(nuevo);
        }else{
            
            Node aux=cabeza;
                    aux=cabeza;
            while(aux.getNext()!=null&&
                    aux.getNext().getData().getId()<pUser.getID()){
                aux=aux.getNext();
            }
            aux.setNext(aux.getNext());
            aux.setNext(nuevo);
        }
    }
    
    public void eliminar(int pId){
        if(cabeza==null){
            JOptionPane.showMessageDialog(null, "ERROR: lista vacia");
        }else if(cabeza.getData().getId()>pId){
            JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
        }else if(cabeza.getData().getId()==pId){
            cabeza=cabeza.getNext();
        }else{
            Node aux=cabeza;
                    aux=cabeza;
            while(aux.getNext()!=null&&
                    aux.getNext().getData().getId()<pId){
                aux=aux.getNext();
            }
            
            if(aux.getNext()==null){
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }else if(aux.getNext().getData().getId()==pId){
                aux.setNext(aux.getNext().getNext());
            }else{
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }
        }
    }
    
    public void consulta(int pId){
        if(cabeza==null){
            JOptionPane.showMessageDialog(null, "ERROR: lista vacia");
        }else if(cabeza.getData().getId()>pId){
            JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
        }else if(cabeza.getData().getId()==pId){
            JOptionPane.showMessageDialog(null, cabeza);
        }else{
            Node
                    aux=cabeza;
            while(aux.getNext()!=null&&
                    aux.getNext().getData().getId()<pId){
                aux=aux.getNext();
            }
            
            if(aux.getNext()==null){
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }else if(aux.getNext().getData().getId()==pId){
                JOptionPane.showMessageDialog(null, aux.getNext());
            }else{
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }
        }
    }
    
    public void modifica(int pId){
        if(cabeza==null){
            JOptionPane.showMessageDialog(null, "ERROR: lista vacia");
        }else if(cabeza.getData().getId()>pId){
            JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
        }else if(cabeza.getData().getId()==pId){
            String newName=JOptionPane.showInputDialog(cabeza+"\nIngrese el nuevo nombre");
            cabeza.getData().setName(newName);
        }else{
            Node
                    aux=cabeza;
            while(aux.getNext()!=null&&
                    aux.getNext().getData().getId()<pId){
                aux=aux.getNext();
            }
            
            if(aux.getNext()==null){
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }else if(aux.getNext().getData().getId()==pId){
                String newName=JOptionPane.showInputDialog(aux.getNext()+"\nIngrese el nuevo nombre");
                aux.getNext().getData().setName(newName);
            }else{
                JOptionPane.showMessageDialog(null, "Mensaje: elemento no esta en lista");
            }
        }
    }

    @Override
    public String toString() {
        String r="Lista:{\n";
        Node
                aux=cabeza;
        while(aux!=null){
            r+=aux+"\n";
            aux=aux.getNext();
        }
        r+="}";
        return r;
    }
}

