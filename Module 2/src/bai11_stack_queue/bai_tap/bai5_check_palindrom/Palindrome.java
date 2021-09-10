package bai11_stack_queue.bai_tap.bai5_check_palindrom;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("nhập vào chuỗi để kiểm tra");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine().toLowerCase();
        Queue queue=new LinkedList();
        for(int i=input.length()-1;i>=0;i--){
            queue.add(input.charAt(i));
        }
        String reverseString="";
        while (!queue.isEmpty()){
            reverseString+=queue.poll();
        }
        if(input.equals(reverseString)){
            System.out.println("là chuỗi đối xứng");
        }else
            System.out.println("không phải chuỗi đối xứng");
    }
}
