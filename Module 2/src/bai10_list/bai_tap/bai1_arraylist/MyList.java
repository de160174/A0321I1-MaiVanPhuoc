package bai10_list.bai_tap.bai1_arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    private static final int DEFAULT_CAPACITY=10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        elements = new Object[capacity];
    }


    public void add(int index,E e) {
        if(index>elements.length){
            throw new IllegalArgumentException("index: "+index);
        }else if(elements.length==size){
            ensureCapacity(5);
        }
        if(elements[index]==null){
            elements[index]=e;
            size++;
        }else {
            for(int i=size+1;i>=index;i--){
                elements[i]=elements[i-1];
            }
            elements[index]=e;
            size++;
        }

    }
    public E remove(int index){
        if(index>=0&&index<size){
            for(int i=0;i<size-1;i++){
                elements[i]=elements[i+1];
            }
            elements[size-1]=null;
            size--;
        }
        return (E) elements;
    }
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
    public int size(){
        return size;
    }
    public MyList<E> clone(){
        return this;
    }
    public boolean contains(E e) {
        return indexOf(e)>=0;
    }
    public int indexOf(E o){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        elements[size]=e;
        size++;
        return true;
    }
    public void ensureCapacity(int minCapacity) {
        int newSize=this.elements.length+minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
