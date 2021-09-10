package bai3_array_method.thuc_hanh;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double fahrenheit;
        double celsius;
        System.out.println("1.Fahrenheit to Celsius");
        System.out.println("2.Celsius to Fahrenheit");
        System.out.println("0.Exit ");
        System.out.println("Enter your choice ");
        choice=scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Fahrenheit to Celsius");
                fahrenheit=scanner.nextDouble();
                System.out.println(fahrenheitToCelsius(fahrenheit));
                break;
            case 2:
                System.out.println("Celsius to Fahrenheit");
                celsius=scanner.nextDouble();
                System.out.println(celsiusToFahrenheit(celsius));
                break;
            case 0:
                System.exit(0);
        }

    }
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit){
        double celsius=(5.0/9)*(fahrenheit-32);
        return celsius;
    }
}
