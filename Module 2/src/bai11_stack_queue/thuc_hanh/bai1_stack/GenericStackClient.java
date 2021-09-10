package bai11_stack_queue.thuc_hanh.bai1_stack;

import static bai11_stack_queue.thuc_hanh.bai1_stack.MyGenericStack.stackOfIStrings;
import static bai11_stack_queue.thuc_hanh.bai1_stack.MyGenericStack.stackOfIntegers;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }
}
