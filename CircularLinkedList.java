public class CircularLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;


    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }


    public void deleteAtPosition(int position) {
        if (head == null) { // If the list is empty
            System.out.println("The list is empty.");
            return;
        }

        int size = getSize();
        if (position < 1 || position > size) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node current = head;
        Node previous = null;
        int count = 1;


        while (count < position) {
            previous = current;
            current = current.next;
            count++;
        }

        // Delete the node
        previous.next = current.next;


        if (current == tail) {
            tail = previous;
        }
    }


    private int getSize() {
        if (head == null) return 0;
        int size = 1;
        Node current = head;
        while (current.next != head) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Original List:");
        list.display();

        System.out.println("Deleting node at position 3:");
        list.deleteAtPosition(3);
        list.display();

        System.out.println("Deleting node at position 1:");
        list.deleteAtPosition(1);
        list.display();

        System.out.println("Deleting node at position 10 (invalid):");
        list.deleteAtPosition(10);
        list.display();
    }
}