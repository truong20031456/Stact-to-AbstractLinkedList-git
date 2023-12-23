package SimpleTree;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleTree {
    private static Node root; // the root node of the tree

    // a nested class to represent a node in the tree
    private static class Node {
        private int value; // the value stored in the node
        private Node leftchild; // the left child of the node
        private Node rightchild; // the right child of the node

        // a constructor that takes an int value as a parameter
        public Node(int value) {
            this.value = value; // assign the value to the node
            this.leftchild = null; // initialize the left child to null
            this.rightchild = null; // initialize the right child to null
        }
    }

    // a method to insert a value into the tree
    public void insert(int value) {
        Node node = new Node(value); // create a new node with the value

        if (root == null) { // if the tree is empty
            root = node; // assign the node as the root
        } else { // if the tree is not empty
            Node current = root; // start from the root
            while (true) { // loop until the node is inserted
                if (value < current.value) { // if the value is less than the current node's value
                    if (current.leftchild == null) { // if the current node has no left child
                        current.leftchild = node; // assign the node as the left child
                        break; // exit the loop
                    } else { // if the current node has a left child
                        current = current.leftchild; // move to the left child
                    }
                } else if (value > current.value) { // if the value is greater than the current node's value
                    if (current.rightchild == null) { // if the current node has no right child
                        current.rightchild = node; // assign the node as the right child
                        break; // exit the loop
                    } else { // if the current node has a right child
                        current = current.rightchild; // move to the right child
                    }
                } else { // if the value is equal to the current node's value
                    // do nothing, as duplicate values are not allowed in the tree
                    break; // exit the loop
                }
            }
        }
    }
    static  boolean find(int value){
        Node current = root;
        while (current!=null){
            Node node = null;
            if (current.value< value){
                current.leftchild= node; break;
            }
            if (current.value> value){
                current.rightchild=node; break;
            }

            else{
                return true;
            }
           

        }


        return false;
    }

    public  void transversePreOrder(){
        transversePreOrder(root);
    }
    private void transversePreOrder(Node root){
        if(root==null)return;
        System.out.println(root.value);
        transversePreOrder(root.leftchild);
        transversePreOrder(root.rightchild);

    }
    public void traverseInOrder() {
        traverseInOrder(root); // call the method with the root node
    }

    private void traverseInOrder(Node root) {
        if (root == null) return; // base case
        traverseInOrder(root.leftchild); // visit the left subtree
        System.out.println(root.value); // print the value of the current node
        traverseInOrder(root.rightchild); // visit the right subtree
    }

    public void BreadthFirstTraversal() {
        BreadthFirstTraversal(root); // call the method with the root node
    }

    private void BreadthFirstTraversal(Node root) {
        if (root == null) return; // base case
        LinkedList<Node> queue = new LinkedList<Node>(); // create a queue
        queue.add(root); // add the root node to the queue
        while (!queue.isEmpty()) { // loop until the queue is empty
            Node current = queue.poll(); // remove the first node from the queue
            System.out.print(current.value + " "); // print the value of the current node
            if (current.leftchild != null) { // if the current node has a left child
                queue.add(current.leftchild); // add the left child to the queue
            }
            if (current.rightchild != null) { // if the current node has a right child
                queue.add(current.rightchild); // add the right child to the queue
            }
        }
    }
    private void DepthFirstTraversal(Node root){
        if(root==null) return;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while ((!queue.isEmpty())){
            Node current = queue.poll(); // remove the first node from the queue

            if (current.leftchild != null) { // if the current node has a left child
                queue.add(current.leftchild); // add the left child to the queue
            }
            if (current.rightchild != null) { // if the current node has a right child
                queue.add(current.rightchild); // add the right child to the queue
            }
            System.out.print(current.value + " "); // print the value of the current node

        }

    }



    // a main method to test the tree
    public static void main(String[] args) {
        SimpleTree tree = new SimpleTree(); // create a new tree
        tree.insert(5); // insert some values
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);
        tree.insert(3);
        tree.insert(7);
        tree.insert(9);
        tree.traverseInOrder();
        // print the tree in some way, such as in-order traversal
    }


}
