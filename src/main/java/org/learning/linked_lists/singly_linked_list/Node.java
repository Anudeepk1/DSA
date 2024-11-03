package org.learning.linked_lists.singly_linked_list;

public class Node{
    Integer value;
    Node next;

    Node(){}

    Node(int value){
        this.value = value;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void setNode(Integer value){
        this.value = value;
    }

}
