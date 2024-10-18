/**
 * Represents a linked list that holds Seminar objects.
 * 
 * This class provides methods to manage a list of seminars, including adding,
 * retrieving, removing, and printing them.
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class LinkedList {
    private Node head; // The head node of the linked list
    private int size; // The number of nodes in the linked list

    private static class Node {
        private Seminar data;
        // The seminar data held by this node
        private Node next;
        // The reference to the next node in the list

        Node(Seminar data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructs an empty LinkedList.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }


    /**
     * Adds a seminar to the linked list in sorted order based on seminar ID.
     *
     * @param seminar
     *            the Seminar object to be added
     */
    public void add(Seminar seminar) {
        Node newNode = new Node(seminar);
        if (head == null || head.data.id() > seminar.id()) {
            newNode.next = head;
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null && current.next.data.id() <= seminar
                .id()) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }


    /**
     * Retrieves the seminar at the specified index.
     *
     * @param index
     *            the index of the seminar to retrieve
     * @return the Seminar object at the specified index
     * @throws IndexOutOfBoundsException
     *             if the index is out of range
     */
    public Seminar get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    /**
     * Returns the number of seminars in the linked list.
     *
     * @return the size of the linked list
     */
    public int size() {
        return size;
    }


    /**
     * Checks if the linked list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Removes the seminar at the specified index.
     *
     * @param i
     *            the index of the seminar to remove
     * @throws IndexOutOfBoundsException
     *             if the index is out of range
     */
    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: "
                + size);
        }

        if (i == 0) {
            head = head.next;
        }
        else {
            Node current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }


    /**
     * Prints the IDs of the seminars in the linked list.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data.id() + " ");
            current = current.next;
        }
        System.out.println();
    }
}
