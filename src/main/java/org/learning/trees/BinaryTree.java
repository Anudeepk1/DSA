package org.learning.trees;


import java.util.Scanner;

class BT{
    class Node{
        int value;
        Node left;
        Node right;

        Node(){}
        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    Node root = null;

    public void insert(int value){
        if(root == null){
            Node newNode = new Node(value);
            root = newNode;
        } else {
           insert(root, value);
        }
    }


    public void insert(Node node, int value){
        if(node.value > value){
            if(node.left == null){
                Node newNode = new Node(value);
                node.left = newNode;
                return;
            }
            insert(node.left, value);
        } else if(node.value < value){
            if(node.right == null){
                Node newNode = new Node(value);
                node.right = newNode;
                return;
            }
            insert(node.right, value);
        }
    }

}
public class BinaryTree {
    public static void main(String[] args) {
        BT binaryTree = new BT();
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(8);


    }

}
