
class Queue {
    private int lengthOfTheQueue;
    private Node enqueue;
    private Node dequeue;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    Queue(int value) {
        Node newNode = new Node(value);
        enqueue = newNode;
        dequeue = newNode;
        lengthOfTheQueue = 1;
    }

    protected void getTheValueInFirst() {
        System.out.println("Queued Element: " + enqueue.value);
    }

    protected void getTheValueInLast() {
        System.out.println("Dequeued Element: " + dequeue.value);
    }

    protected void getLength() {
        System.out.println("Length: " + lengthOfTheQueue);
    }

    protected void enqueueElement(int value) {
        Node newNode = new Node(value);
        if(lengthOfTheQueue == 0) {
            enqueue = newNode;
            dequeue = newNode;
            lengthOfTheQueue = 1;
            return ;
        }
        dequeue.next = newNode;
        dequeue = newNode;
        lengthOfTheQueue++;
    }

    protected Node dequeueElement() {
        if(lengthOfTheQueue == 0) {
            return null;
        }
        Node tempNode = enqueue;
        if(lengthOfTheQueue == 1) {
            enqueue = null;
            dequeue = null;
            return tempNode;
        }
        enqueue = tempNode.next;
        tempNode.next = null;
        lengthOfTheQueue--;
        return tempNode;
    }

    protected void printQueue() {
        Node iteratorNode = enqueue;
        while (iteratorNode != null) {
            System.out.println(iteratorNode.value + " " + iteratorNode.next);
            iteratorNode = iteratorNode.next;
        }
    }
}



public class QueueDSA {
    public static void main(String args[]) {
        Queue queueVariable = new Queue(1);
        queueVariable.enqueueElement(2);
        queueVariable.enqueueElement(3);
        queueVariable.enqueueElement(4);
        queueVariable.enqueueElement(5);
        queueVariable.dequeueElement();
        queueVariable.dequeueElement();
        queueVariable.printQueue();
    }
}
