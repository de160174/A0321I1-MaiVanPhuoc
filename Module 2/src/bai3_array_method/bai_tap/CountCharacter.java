package bai3_array_method.bai_tap;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("bạn hãy nhập vào 1 chuỗi");
        String string=scanner.next();
        System.out.println("Bạn nhập kí tự cần kiểm tra");
        char value=scanner.next().charAt(0);
        int count=0;
        for (int i=0;i<string.length();i++){
            if(string.charAt(i)==value){
                count++;
            }
        }
        System.out.println("số lần xuất hiện là "+count);
    }
}
