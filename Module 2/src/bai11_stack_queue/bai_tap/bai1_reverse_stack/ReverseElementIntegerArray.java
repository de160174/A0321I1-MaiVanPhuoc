package bai11_stack_queue.bai_tap.bai1_reverse_stack;

import java.util.Stack;

public class ReverseElementIntegerArray {
    public static void main(String[] args) {
        Stack<Integer> array=new Stack<>();
        for(int i=0;i<10;i++){
            array.push(i);
        }
        System.out.println("array is: "+array);
        Stack<Integer> arrayNew=new Stack<>();
        for(int i:array){
            arrayNew.push(i);
        }
        for(int i=0;i<array.size();i++){
            array.set(i,arrayNew.pop());
        }
        System.out.println("array reverse is: "+array);
    }
}
