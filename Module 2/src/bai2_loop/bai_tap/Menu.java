package bai2_loop.bai_tap;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Print the rectangle");
                System.out.println("Nhập chiều dài");
                int chieuDai = scanner.nextInt();
                System.out.println("Nhập chiều rộng");
                int chieuRong = scanner.nextInt();
                for (int i = 0; i < chieuRong; i++) {
                    for (int j = 0; j < chieuDai; j++) {
                        System.out.print("*");
                    }
                    System.out.println(" ");
                }
                break;
            case 2:
                int choice1;
                System.out.println("Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right");
                System.out.println("1. top-left");
                System.out.println("2. top-right");
                System.out.println("3. bottom-left");
                System.out.println("4. bottom-right");
                System.out.println("5. Exit");
                System.out.println("Enter choice");
                choice1 = scanner.nextInt();
                switch (choice1) {
                    case 1:
                        System.out.println("Print the square triangle: top-left");
                        System.out.println("Nhập chiều cao");
                        int chieuCao = scanner.nextInt();
                        for (int i = 0; i < chieuCao; i++) {
                            for (int j = 0; j < chieuCao; j++) {
                                if (i <= j) {
                                    System.out.print("*");
                                }
                            }
                            System.out.println("");
                        }
                        break;
                    case 2:
                        System.out.println("Print the square triangle: top-right");
                        System.out.println("Nhập chiều cao");
                        int chieuCao2 = scanner.nextInt();
                        for (int i = 0; i <= chieuCao2; i++) {
                            for (int j = 0; j <= chieuCao2; j++) {
                                if (i >= j) {
                                    System.out.print(" ");
                                } else {
                                    System.out.print("*");
                                }
                            }
                            System.out.println("");
                        }
                        break;
                    case 3:
                        System.out.println("Print the square triangle: bottom-left");
                        System.out.println("Nhập chiều cao");
                        int chieuCao3 = scanner.nextInt();
                        for (int i = 0; i < chieuCao3; i++) {
                            for (int j = 0; j < chieuCao3; j++) {
                                if (i >= j) {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                        }
                        break;
                    case 4:
                        System.out.println("Print the square triangle: bottom-right");
                        System.out.println("Nhập chiều cao");
                        int chieuCao4 = scanner.nextInt();
                        for (int i = 0; i <= chieuCao4; i++) {
                            for (int j = 0; j <= chieuCao4; j++) {
                                if (j <= chieuCao4 - i) {
                                    System.out.print(" ");
                                } else {
                                    System.out.print("*");
                                }
                            }
                            System.out.println("");
                        }
                        break;
                    case 5:
                        System.exit(5);
                }
                break;
            case 3:
                System.out.println("Print isosceles triangle");
                System.out.println("Nhập chiều cao");
                int chieuCao5 = scanner.nextInt();
                for (int i = 1; i <= chieuCao5 * 2 - 1; i++) {
                    for (int j = 1; j <= i; j++) {
                        if (j <= chieuCao5 * 2 - i - 1) {
                            System.out.print(" ");
                        } else {
                            System.out.print("*");
                        }
                    }
                    System.out.println("");
                }
                break;
            case 4:
                System.exit(4);
            default:
                System.out.println("No choice!");
                break;
        }
    }


}
