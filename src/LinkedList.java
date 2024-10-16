import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
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
            Node<T> current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        
        T lastElement;
        if (size == 1) {
            lastElement = head.data;
            head = null;
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            lastElement = current.data;
            previous.next = null;
        }
        size--;
        return lastElement;
    }

    public void addAll(LinkedList<T> otherList) {
        Node<T> current = otherList.head;
        while (current != null) {
            this.add(current.data);
            current = current.next;
        }
    }
}
