package data;

public class Caja {
    private Node head;
    private Node last;

    public boolean isEmpty() {
        return head == null;
    }

    public void addNode(Tiquete data) {
        Node nuevo = new Node(data);
        if (isEmpty()) {
            head = last = nuevo;
        } else {
            Node current = head;
            Node previous = null;

//            while (current != null && current.getData().getPrioridad() >= data.getPrioridad()) {
//                previous = current;
//                current = current.getNext();
//            }

            if (previous == null) {
                nuevo.setNext(head);
                head = nuevo;
            } else {
                previous.setNext(nuevo);
                nuevo.setNext(current);
            }

            if (nuevo.getNext() == null) {
                last = nuevo;
            }
        }
    }

    public void processNode() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
        } else {
            head = head.getNext();
            if (head == null) {
                last = null;
            }
        }
    }

    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        Node aux = head;
        while (aux != null) {
            r.append(aux.toString()).append("\n");
            aux = aux.getNext();
        }
        return r.toString();
    }
}