package org.learning.collection.list.linked_list;

import org.learning.collection.list.List;
import org.learning.linked_lists.singly_linked_list.Node;

public abstract class LinkedList<E> implements List<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size = 0;

    protected static class Node<E>{
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public void print(){
        if(head==null) {
            System.out.println("No elements in the list");
            return;
        }
        Node<E> pointer = head;
        while(pointer != null){
            System.out.print(pointer.data);

            if (pointer.next != null) {
                System.out.print(" -> ");
            }
            pointer = pointer.next;

        }
        System.out.println();
    }

    public void clear(){
        if(head == null){
            System.out.println("List is already empty");
            return;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean contains(E data){
        if(head == null) return false;

        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.data.equals(data))
                return true;

            currentNode = currentNode.next;
        }
        return false;
    }

    public E[] toArray(){
        E[] arr = (E[]) new Object[size];

        if(head == null) return arr;
        else {
            Node currentNode = head;
            for(int i=0 ; i<size ; i++){
                arr[i] = (E) currentNode.data;
            }
            return arr;
        }

    }

    public void subList(int fromIndex, int toIndex) {

    }

    public int size(){
       return size;
    }
}
