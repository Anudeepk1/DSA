package org.learning.trees;


import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

class BST {
    class Node {
        int value;
        Node left;
        Node right;

        Node() {
        }

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    Node root = null;

    public void insert(int value) {
        if (root == null) {
            Node newNode = new Node(value);
            root = newNode;
        } else {
            insert(root, value);
        }
    }


    public void insert(Node node, int value) {
        if (node.value > value) {
            if (node.left == null) {
                Node newNode = new Node(value);
                node.left = newNode;
                return;
            }
            insert(node.left, value);
        } else if (node.value < value) {
            if (node.right == null) {
                Node newNode = new Node(value);
                node.right = newNode;
                return;
            }
            insert(node.right, value);
        }
    }

    public void delete(int value) {
        if (root == null) {
            System.out.println("No Element to delete");
            return;
        } else {
            delete(root, value);
        }

    }

    public void delete(Node node, int value) {
        if (node.value > value) {
            delete(node.left, value);
        } else if (node.value < value) {
            delete(node.right, value);
        } else if (node.value == value) {
            node = null;
            return;
        }
    }

    public int getGreatest() {
        int val = getGreatestNode(root);
        return val;
    }

    public int getGreatestNode(Node node) {
        Node currentNode = node;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.value;
    }

    public void height(){
        int val = getHeight(root);
        System.out.println(val);
    }

    public int getHeight(Node node){
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) +1 ;
    }


    public void preOrderTraversal() {
        int val = getGreatestNode(root);
        //root , left , right
        preOrder(root, val);
    }

    public void preOrder(Node node, int val) {
        System.out.print(node.value);
        if (node.value != val) System.out.print(" -> ");

        if (node.left != null) {
            preOrder(node.left, val);

        }
        if (node.right != null) {
            preOrder(node.right, val);
        }

    }


    public void inOrderTraversal(){
        int val = getGreatestNode(root);
        //Left → Root → Right.
        inOrder(root, val);
    }

    public void inOrder(Node node, int val){

        if(node.left != null){
            inOrder(node.left, val);
        }
        System.out.print(node.value);
        if(node.value != val) System.out.print(" -> ");
        if(node.right != null){
            inOrder(node.right, val);
        }

    }

    public void postOrderTraversal() {
        //left , right , root
        postOrder(root);
        System.out.println();
    }

    public void postOrder(Node node) {
        //left => right => root
        if (node.left != null) {
            postOrder(node.left);

        }
        if (node.right != null) {
            postOrder(node.right);

        }
        System.out.print(node.value);
        if (node != root) System.out.print(" -> ");
    }

    public void search(){}

    public void isBalanced(){}

    public void findMin(){}

    public void levelOrderTraversal(){
        //breath first search
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.print(currentNode.value);

            if(currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);

            if(!queue.isEmpty()) System.out.print(" => ");
        }
        System.out.println();
    }




}

public class BinarySearchTree {
    public static void main(String[] args) {
        BST binaryTree = new BST();
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(10);
        binaryTree.insert(3);
        binaryTree.insert(5);
        binaryTree.insert(8);
        binaryTree.insert(12);
        System.out.println("Get Greatest Node");
        int val = binaryTree.getGreatest();
        System.out.println(val);
        System.out.println("postOrder");
        binaryTree.postOrderTraversal();

        System.out.println("preOrder");
        binaryTree.preOrderTraversal();
        System.out.println();
        System.out.println("Inorder");
        binaryTree.inOrderTraversal();
        System.out.println();
        System.out.println("Level Order");
        binaryTree.levelOrderTraversal();
        System.out.println("Height");
        binaryTree.height();


    }

}
