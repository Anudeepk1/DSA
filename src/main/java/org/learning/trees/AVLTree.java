package org.learning.trees;

import java.util.Currency;

public class AVLTree extends BinarySearchTree{
    
    class Node {
        int value;
        Node left;
        Node right;
        int height;

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
    public void avl(){
        avLL(root);
    }
    public void avLL(Node parent){
       Node pivot = parent.right;
       parent.right = null;
       pivot.left = parent;
       parent.left = pivot.left;
    }

    public void inOrderTraversal(){
        int val = getGreatestNode(root);
        //Left → Root → Right.
        inOrder(root, val);
    }

    public int getGreatestNode(Node node) {
        Node currentNode = node;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.value;
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



    public static void main(String[] args) {
        AVLTree bst = new AVLTree();
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
//        bst.inOrderTraversal();
        bst.avl();
        bst.inOrderTraversal();



    }

}
