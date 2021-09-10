package bai15_exception_debug.bai_tap;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập cạnh thứ 1: ");
        int x = scanner.nextInt();
        System.out.println("Hãy nhập cạnh thứ 2: ");
        int y = scanner.nextInt();
        System.out.println("Hãy nhập cạnh thứ 3: ");
        int z = scanner.nextInt();

        try {
            Triangle triangle = new Triangle(x, y, z);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }

}
