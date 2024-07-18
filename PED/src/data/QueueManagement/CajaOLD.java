package data.QueueManagement;

import data.InfoObjetcs.Ticket;

public class CajaOLD {
    private Node head;
    private Node last;

    public boolean isEmpty() {
        return head == null;
    }

    public void addNode(Ticket data) {
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
                nuevo.setNextNode(head);
                head = nuevo;
            } else {
                previous.setNextNode(nuevo);
                nuevo.setNextNode(current);
            }

            if (nuevo.getNextNode() == null) {
                last = nuevo;
            }
        }
    }

    public void processNode() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
        } else {
            head = head.getNextNode();
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
            current = current.getNextNode();
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        Node aux = head;
        while (aux != null) {
            r.append(aux.toString()).append("\n");
            aux = aux.getNextNode();
        }
        return r.toString();
    }
}