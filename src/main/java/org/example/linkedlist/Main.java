package org.example.linkedlist;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.append(10);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.prepend(7);


        System.out.println("current list: ");
        myLinkedList.printList();

        myLinkedList.delete(5);
        System.out.println("after deleting 5: ");
        myLinkedList.printList();

        System.out.println("after deleting head 7: ");
        myLinkedList.printList();
    }
}
