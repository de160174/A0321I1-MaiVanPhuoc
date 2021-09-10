package bai1_intro_java.thuc_hanh;

import java.util.Scanner;

public class ptb1 {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        if (a != 0) {
            double result = -b / a;
            System.out.println("result is: " + result);
        }
        if (a == 0) {
            if (b == 0) {
                System.out.println("the equation has infinitely many solutions");
            } else {
                System.out.println("the equation has no solutions");
            }
        }
    }
}
