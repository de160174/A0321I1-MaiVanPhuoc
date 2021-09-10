package bai2_loop.bai_tap;

import java.util.Scanner;

public class Prime20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số");
        int number = scanner.nextInt();
        int count = 0;
        int N = 2;
        String result = "";
        while (count < number) {
            boolean check = true;
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result += N + " ";
                count++;
            }
            N++;
        }
        System.out.println(number+ " số nguyên tố đầu tiên " + result);
    }
}
