class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        }
        else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public void pop() {
        if(height == 0) {
            return;
        }
        Node temp = top;
        top = temp.next;
        temp.next = null;
        height--;
    }

    public void peek() {
        System.out.println("Top -> " + top.value);
    }

    public void length() {
        System.out.println("Height -> " + height);
    }

    public void printStack() {
        if(height == 0) {
            System.out.println("Stack is empty");
        }
        while(top != null) {
            System.out.println(top.value);
            top = top.next;
        }
    }

    public void empty() {
        while(top != null) {
            Node temp = top;
            top = temp.next;
            temp.next = null;
        }
        height = 0;
    }
}

public class StackClass {
    public static void main(String[] args) {
        Stack stackVariable = new Stack(5);
        stackVariable.push(4);
        stackVariable.push(3);
        stackVariable.push(2);
        stackVariable.push(1);
        stackVariable.pop();
        stackVariable.peek();
        stackVariable.printStack();
        stackVariable.empty();
        stackVariable.printStack();
        stackVariable.length();
    }
}
