package bai11_stack_queue.bai_tap.bai4_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Nhập vào số thập phân muốn chuyển sang nhị phân");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input != 0) {
            if(input%2==0){
                stack.push(0);
            }else {
                stack.push(1);
            }
            input=input/2;
        }
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }
}
