package org.learning.collection.list.linked_list.singly_linked_list;

import org.learning.collection.list.linked_list.LinkedList;

public class SinglyLinkedList<E> extends LinkedList<E> {

    public void add(E data){
        Node<E> newNode;
        newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(E data){
        Node<E> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void addAtIndex(E val, int index) {

    }

    @Override
    public void remove() {
        if(head == null){
            System.out.println("Cannot remove element from an Empty List");
        } else if(head == tail){
            head = null;
            tail = null;
            size = 0;
        } else {
            Node<E> currentNode = head;
            for(int i=0; i<size-1; i++){
                if(i == size-2){
                    currentNode.next = null;
                    tail = currentNode;
                    size--;
                    return;
                }
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            System.out.println("Cannot remove element from an Empty List");
            return;
        }  else if(head == tail){
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    @Override
    public void removeAtIndex(int index) {
        if(index > size || index < 0){
            System.out.println("Index out of bound");
            return;
        } else if(index == 0) {
            removeFirst();
        } else if(index == size-1){
            remove();
        } else {
            Node<E> currentNode = head;
            for(int i=0 ; i<=index ; i++){
                if(i == index-1){
                    currentNode.next = currentNode.next.next;
                    size--;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
    }
}
