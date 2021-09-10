package bai11_stack_queue.bai_tap.bai1_reverse_stack;

import java.util.Stack;

public class ReverseStringArray {
    public static void main(String[] args) {
        String string = "tôi là học viên lớp A03";
        String[] strings = string.split(" ");
        System.out.println("string is: " + string);
        Stack<String> stringNew = new Stack<>();
        for (String i : strings) {
            stringNew.push(i);
        }
        string="";
        while (!stringNew.isEmpty()) {
            string += stringNew.pop() + " ";
        }
        System.out.println("string reverse is: " + string);
    }
}
