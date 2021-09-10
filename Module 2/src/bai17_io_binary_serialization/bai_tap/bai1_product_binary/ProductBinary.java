package bai17_io_binary_serialization.bai_tap.bai1_product_binary;

import java.util.LinkedList;
import java.util.Scanner;

public class ProductBinary {
    public static void main(String[] args) {
        while (true){
            System.out.println("Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Display Product");
            System.out.println("3. Search Product ");
            System.out.println("4. Exit ");
            System.out.println("Enter your choice ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    ProductManager.add();
                    break;
                case 2:
                    ProductManager.display();
                    break;
                case 3:
                    ProductManager.search();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter again!!");
            }
        }
    }
}
