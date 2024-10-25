package org.learning.trees;


import java.util.Scanner;

class BST{
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

    public void delete(int value){
        if(root == null) {
            System.out.println("No Element to delete");
            return;
        } else {
            delete(root, value);
        }

    }

    public void delete(Node node, int value){
        if(node.value > value){
            delete(node.left, value);
        } else if(node.value < value){
            delete(node.right, value);
        } else if (node.value == value){
            node = null;
            return;
        }
    }

    public void postOrderTraversal(){
       postOrder(root);
    }

    public void postOrder(Node node){
        //left => right => root
        if(node.left != null){
            postOrder(node.left);
        }
        if(node.right != null){
            postOrder(node.right);
        }
        System.out.print(node.value);
        if(node != root) System.out.print(" -> ");
    }

}
public class BinarySearchTree {
    public static void main(String[] args) {
        BST binaryTree = new BST();
        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(4);
        binaryTree.insert(7);
        binaryTree.insert(5);
        binaryTree.insert(12);
        binaryTree.postOrderTraversal();


    }

}
