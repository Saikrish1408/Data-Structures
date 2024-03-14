package CircularLinkedList;

public class CircularLinkedListClass {
    private Node head;
    private Node tail;
    int length;


    class Node {
        int value;
        Node nextNode;

        Node(int value) {
            this.value = value;
        }
    }

    CircularLinkedListClass(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public void append(int value) {
        Node node = new Node(value);
        if(length == 0) {
            head = node;
            tail = node;
            length = 1;
        } else {
            tail.nextNode = node;
            tail = node;
            tail.nextNode = head;
            length++;
        }
    }

    public void removeLast() {
        Node temp = head;
        for(int i = 1 ; i <= length ; i++) {
            if(i == (length - 1)) {
                temp.nextNode = temp.nextNode.nextNode;
                break;
            }
            temp = temp.nextNode;
        }
        length--;
    }

    public void removeFirst() {
        Node temp = head;
        for(int i = 1 ; i <= length ; i++) {
            if(i == length) {
                temp.nextNode = temp.nextNode.nextNode;
            }
            temp = temp.nextNode;
        }
    }

    public void prepend(int value) {
        Node node = new Node(value);
        Node temp = head;
        for(int i = 1 ; i <= length ; i++) {
            if(i == length) {
                temp.nextNode = node;
                node.nextNode = head;
                head = node;
            }
            temp = temp.nextNode;
        }
        length++;
    }

    public void deleteAtIndex(int index) {
        Node temp = head;
        for(int i = 1 ; i < index ; i++) {
            temp = temp.nextNode;
        }
        temp.nextNode = temp.nextNode.nextNode;
    }

    public void printCircularList() {
        Node temp = head;
        for(int i = 1 ; i <= length ; i++) {
            if(i < length) {
                System.out.print(temp.value + " -> ");
                temp = temp.nextNode;
            }
            else
                System.out.print(temp.value + " -> " + temp.nextNode.value);
        }
    }
}
