package dev.playground.training.ds;

/**
 * DoublyLinkedList
 */
public class LinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        T data;
        Node prev, next;

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public LinkedList(Node head, Node tail, int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addAtBeginnig(T data) {
        Node newNode = new Node(data, null, null);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtEnd(T data) {
        Node newNode = new Node(data, null, null);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }


    public void addAtPosition(T data, int position) {
        Node newNode = new Node(data, null, null);

        if (position == 1) {
            addAtBeginnig(data);
        } else {
            Node current = head;
            int currentPos = 1;

            while (current != null && currentPos < position) {
                current = current.next;
                currentPos++;
            }

            if (current == null) {
                addAtEnd(data);
            } else {
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            }

        }

    }

}
