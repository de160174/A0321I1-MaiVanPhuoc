package bai10_list.bai_tap.bai2_linked_list;

import bai10_list.bai_tap.bai1_arraylist.MyList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addFirst(6);
        myLinkedList.addFirst(7);
        myLinkedList.addLast(3);
        myLinkedList.add(1, 8);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println("element " + i + ": " + myLinkedList.get(i));
        }
        myLinkedList.remove(2);
        System.out.println("after remove");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println("element " + i + ": " + myLinkedList.get(i));
        }
        MyLinkedList<Integer> clone = myLinkedList.clone();
        System.out.println("Array clone: ");
        for (int i = 0; i < clone.size(); i++) {
            System.out.println("element " + i + ": " + clone.get(i));
        }
    }
}
