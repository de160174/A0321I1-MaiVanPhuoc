package bai10_list.bai_tap.bai2_linked_list;

import bai10_list.bai_tap.bai1_arraylist.MyList;

public class MyLinkedList<E> {
    private class Node{
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }
    public void addFirst(E e){
        //khai báo temp trỏ đén giá trị của head
        Node temp=head;
        //head nhận giá trị node mới
        head=new Node(e);
        head.next=temp;
        numNodes++;
    }
    public void addLast(E e){
        Node temp=head;
        //cho biến temp chạy đén ptu cuối cùng ds
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(e);
        numNodes++;
    }
    public void add(int index,E e){
        Node temp=head;
        Node holder;
        //cho con tro chạy den vi tri index-1
        for(int i=0;i<index-1&&temp.next!=null;i++){
            temp=temp.next;
        }
        //cho holder tham chieu den vi tri index
        holder=temp.next;
        temp.next=new Node(e);
        //node moi se tro den holder
        temp.next.next=holder;
        //tang dl ptu trong ds len 1
        numNodes++;
    }
    public Object get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    public int size(){
        return numNodes;
    }
    public E remove(int index){
        if(index<0||index>numNodes){
            throw new IllegalArgumentException("Error index: "+index);
        }
        Node temp=head;
        Object data;
        //neu index=0 thi tra ve data hien tai
        if(index==0){
            data=temp.data;
            head=head.next;
            numNodes--;
        }else{
            for(int i=0;i<index-1&&temp.next!=null;i++){
                temp=temp.next;
            }
            data=temp.next.data;
            temp.next=temp.next.next;
            numNodes--;
        }
        return (E) data;
    }
    public boolean remove(E e) {
        if (head.data.equals(e)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(e)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp=temp.next;
            }
        }
        return false;
    }
    public MyLinkedList<E> clone(){
        return this;
    }
    public boolean constrain(E e){
        Node temp=head;
        while (temp.next!=null){
            if(temp.data.equals(e)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int indexOf(E e){
        Node temp=head;
        for(int i=0;i<numNodes;i++){
            if (temp.getData().equals(e)){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
}
