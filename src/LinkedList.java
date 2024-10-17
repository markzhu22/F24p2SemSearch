public class LinkedList {
    private Node head;
    private int size;

    private static class Node {
        Seminar data;
        Node next;

        Node(Seminar data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(Seminar seminar) {
        Node newNode = new Node(seminar);
        if (head == null || head.data.id() > seminar.id()) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data.id() <= seminar.id()) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public Seminar get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        
        if (i == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data.id() + " ");
            current = current.next;
        }
        System.out.println();
    }
}
