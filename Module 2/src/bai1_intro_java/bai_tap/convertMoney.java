package bai1_intro_java.bai_tap;

import java.util.Scanner;

public class convertMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Convert USD to VND");
        System.out.println("Enter usd: ");
        double usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.println(vnd + "VNĐ");
    }
}
