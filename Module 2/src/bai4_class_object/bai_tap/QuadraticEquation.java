package bai4_class_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getDiscriminant(){
        return b*b-4*a*c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();
        QuadraticEquation equation=new QuadraticEquation(a,b,c);
        if(equation.getDiscriminant()>0){
            double r1=(-b+Math.sqrt(equation.getDiscriminant()))/(2*a);
            double r2=(-b-Math.sqrt(equation.getDiscriminant()))/(2*a);
            System.out.println("phương trinh có 2 nghiệm phân biệt là "+r1+" và "+r2);

        }else if(equation.getDiscriminant()==0){
            double r=-b/(2*a);
            System.out.println("phương trinh có nghiệm kép là "+r);
        }else {
            System.out.println("phương trinh vô nghiệm");
        }
    }
}
