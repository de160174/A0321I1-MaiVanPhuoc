package bai10_list.thuc_hanh.bai2_basic_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList linkedList=new MyLinkedList(10);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(13);
        linkedList.add(4,9);
        linkedList.add(4,9);
        linkedList.printList();
    }
}
