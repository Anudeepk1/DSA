package org.learning.linked_lists;

import java.util.Scanner;

class Node{
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

class LinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    protected void add(int value){
        Node newNode;
        newNode = new Node();
        newNode.setNode(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    protected void addFirst(int value){
        Node newNode;
        newNode =new Node();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
        size++;


    }

    protected void addAtIndex(int value, int index){
        int current_index = 0;
        int max_index = size-1;
        Node currentNode = head;
        if(index > size ||  index < 0){
            throw new IndexOutOfBoundsException("Index Value exceeded the list size");
        }
        if(index == 0){
            addFirst(value);
            size++;
            return;
        } else if(index == size){
            add(value);
            size++;
            return;
        }
        while (current_index <= max_index){
            if(current_index == index-1){
                Node newNode;
                newNode =new Node();

                newNode.value = value;
                newNode.next = currentNode.next;

                currentNode.next = newNode;
                size++;
                return;
            }
            current_index++;
            currentNode = currentNode.next;
        }
    }

    protected  void printList(){
        if(head==null) {
            System.out.println("No elements in the list");
            return;
        }
        Node pointer = head;
        while(pointer != null){
            System.out.print(pointer.value.intValue());

            if (pointer.next != null) {
                System.out.print(" -> ");
            }
            pointer = pointer.next;

        }
        System.out.println();
    }

    public void size() {
        System.out.println("Size of the list: "+size);
    }

    public void remove() {
        Node currectNode = head;

        if(size == 0){
            System.out.println("Cannot remove elemnts from empty list");
            return;
        } else if(head.equals(tail)){
            head = null;
            tail = null;
            return;
        }
        for(int i=0; i<size-1; i++){
            if(i == size-2){
                currectNode.next = null;
                tail = currectNode;
                size--;
                return;
            }
            currectNode = currectNode.next;


        }
    }

    public boolean isEmpty() {
        if(head == null){
            return true;
        } else {
            return false;
        }
    }

    public void removeFirst() {
        if(head == null){
            System.out.println("List is empty");
        } else {
            Node current_node = head;
            head = head.next;
            current_node = null;
            size--;

        }
    }

    public void clear() {
        if(head == null){
            System.out.println("List is already empty");
            return;
        }
        Node current_node = head;
        while(current_node != null){
            Node newNode = new Node();
            newNode = current_node.next;
            current_node = null;
        }
        head = null;
        tail = null;
        size = 0;

    }

    public void removeAtIndex(int index) {
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Given index does not match with list size");
        }

        if(index ==0){
            removeFirst();
            size--;
            return;
        } else if(index == size -1){
            remove();
            size--;
            return;
        }
        Node current_node = head;
        for(int i=0; i<size; i++){
            if(i == index-1){
                current_node.next = current_node.next.next;
                size--;
                break;
            }
            current_node = current_node.next;
        }

    }
}


public class SinglyLinkedList {

    public static void main(String[] args) {
        Scanner sc = null;
        Integer operation;
        int val;
        int index;

        LinkedList linkedList = new LinkedList();
        do {
            System.out.println("Singly Linked List\n" +
                    "1. add\n" +
                    "2. PrintList\n" +
                    "3. addFirst\n" +
                    "4. addAtIndex\n" +
                    "5. remove\n" +
                    "6. removeFirst\n" +
                    "7. removeAtIndex\n" +
                    "8. get\n" +
                    "9. getFirst\n" +
                    "10. getLast\n" +
                    "11. contains\n" +
                    "12. indexOf\n" +
                    "13. size\n" +
                    "14. isEmpty\n" +
                    "15. clear\n" +
                    "16. reverse\n" +
                    "17. findMiddle\n" +
                    "18. sort\n" +
                    "19. exit");
            sc = new Scanner(System.in);
            operation = sc.nextInt();

            switch (operation){
                case 1: //add
                    System.out.print("Add new node: ");
                    val = sc.nextInt();
                    linkedList.add(val);
                    break;

                case 2:
                    linkedList.printList();
                    break;

                case 3:
                    System.out.println("Add new node At First: ");
                    val = sc.nextInt();
                    linkedList.addFirst(val);
                    break;
                case 4:
                    System.out.println("Add new node at Index: ");
                    val = sc.nextInt();
                    index = sc.nextInt();
                    linkedList.addAtIndex(val, index);
                    break;
                case 5:
                    System.out.println("Remove element from list");
                    linkedList.remove();
                    linkedList.printList();
                    break;
                case 6:
                    System.out.println("Remove First element from the list");
                    linkedList.removeFirst();
                    linkedList.printList();
                case 7:
                    System.out.println("Remove Element at Index from the list");
                     index = sc.nextInt();
                    linkedList.removeAtIndex(index);
                    linkedList.printList();
                case 13:
                    System.out.println("Get List size");
                    linkedList.size();
                    break;
                case 14:
                    boolean isEmpty = linkedList.isEmpty();
                    System.out.println(isEmpty);
                    break;
                case 15:
                    linkedList.clear();
                    break;


            }
        } while (!operation.equals(19) && operation<19);
    }
}
