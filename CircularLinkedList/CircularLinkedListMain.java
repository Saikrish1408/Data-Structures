package CircularLinkedList;

public class CircularLinkedListMain {
    public static void main(String[] args) {
        CircularLinkedListClass circularList = new CircularLinkedListClass(1);
        circularList.append(2);
        circularList.append(3);
        circularList.append(4);
        circularList.append(5);
//        circularList.removeLast();
//        circularList.removeFirst();
//        circularList.prepend(0);
//        circularList.prepend(-1);
        circularList.deleteAtIndex(3); // 0 Based Indexing
        circularList.printCircularList();
    }
}
