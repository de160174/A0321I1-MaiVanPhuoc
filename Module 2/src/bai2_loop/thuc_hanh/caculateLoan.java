package bai2_loop.thuc_hanh;

import java.util.Scanner;

public class caculateLoan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền ");
        double money = scanner.nextDouble();
        System.out.println("Nhập lãi suất ");
        double interest = scanner.nextDouble();
        System.out.println("Nhập số tháng ");
        int month = scanner.nextInt();
        double loan = 0;
        loan += money * (interest / 100) / 12 * month;
        System.out.println("tổng số tiền lãi " + loan);
    }
}
