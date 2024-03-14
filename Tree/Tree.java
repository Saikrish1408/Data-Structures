class BinaryTreeClass{
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return ;
        }
        Node temp = root;
        while(true) {
            if(newNode.value == temp.value) {
                return ;
            } else if(newNode.value < temp.value) {
                if(temp.left == null) {
                    temp.left = newNode;
                    return ;
                }
                temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = newNode;
                    return ;
                }
                temp = temp.right;
            }
        }
    }
    public String contains(int value) {
        if(root == null) return "Value not Found!!!";
        Node tempNode = root;
        while(tempNode != null) {
            if(tempNode.value > value){
                tempNode = tempNode.left;
            } else if(tempNode.value < value){
                tempNode = tempNode.right;
            } else if(tempNode.value == value){
                return "Value found";
            }
        }
        return "Value not found";
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTreeClass treeVariable = new BinaryTreeClass();
        treeVariable.insert(5);
        treeVariable.insert(2);
        treeVariable.insert(6);
        treeVariable.insert(3);
        treeVariable.insert(7);
        treeVariable.insert(4);

        System.out.println(treeVariable.contains(2));
    }
}
