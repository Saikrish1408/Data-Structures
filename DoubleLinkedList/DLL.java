package DoubleLinkedList;

class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node previous;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    DoubleLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node tempNode = head;
        System.out.print("Printing the List: ");
        while(tempNode != null) {
            System.out.print(" " + tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
            length = 1;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            length++;
        }
    }

    public void removeLast() {
        if(length == 0) return;
        if(length == 1) {
            head = null;
            tail = null;
            return;
        }
        Node temp = tail;
        tail = temp.previous;
        tail.next = null;
        temp.previous = null;
        length--;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = null;
            tail = null;
            length = 1;
            return;
        }
        Node temp = head;
        head = newNode;
        newNode.next = temp;
        temp.previous = newNode;
        length++;
    }

    public void removeFirst() {
        if(length == 0)
            return;
        if(length == 1) {
            head = null;
            tail = null;
            length = 0;
            return ;
        }
        Node temp = head;
        head = temp.next;
        temp.next = null;
        temp.previous = null;
        length--;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        if(index < (length / 2)) {
            Node tempNode = head;
            for(int i = 0 ; i < index ; i++) {
                tempNode = tempNode.next;
            }
            return tempNode;
        }
        else {
            Node tempNode = tail;
            for(int i = (length-1) ; i > index ; i--) {
                tempNode = tempNode.previous;
            }
            return tempNode;
        }
    }

    public String set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return "Updated";
        }
        return "Not Updated";
    }

    public void insert(int index, int value) {
        Node newNode = new Node(value);
        if(index == 0) {
            prepend(value);
            return ;
        }
        if(index == length) {
            append(value);
            return ;
        }
        Node before = get(index - 1);
        Node after = before.next;
        after.previous = newNode;
        before.next = newNode;
        newNode.next = after;
        newNode.previous = before;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= length) {
            return false;
        }
        if (index == 0) {
            removeFirst();
            return true;
        }
        else if(index == (length - 1)) {
            removeLast();
            return true;
        }
        Node targettedNode = get(index);
        targettedNode.next.previous = targettedNode.previous;
        targettedNode.previous.next = targettedNode.next;
        targettedNode.next = null;
        targettedNode.previous = null;
        length--;
        return true;
    }
    public void getHead() {
        System.out.println("Head Value: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail Value: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length of the Double Linked List: " + length);
    }

    public void reversePrinting() {
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.previous;
        }
    }
}

public class DLL {
    public static void main(String[] args) {
        DoubleLinkedList node1 = new DoubleLinkedList(1);
        node1.append(2);
        node1.append(3);
        node1.append(4);
        node1.append(5);
        node1.reversePrinting();
    }
}
