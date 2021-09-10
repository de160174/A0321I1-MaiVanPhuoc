package bai3_array_method.thuc_hanh;

import java.util.Scanner;

public class FindValue {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter name: ");
        String input=scanner.nextLine();
        boolean check=false;
        for(int i=0;i<students.length;i++){
            if(students[i].equals(input)){
                System.out.println("Position of the students in the list " + input + " is: " + (i + 1));
                check=true;
                break;
            }
        }
        if(!check){
            System.out.println("not found! "+input);
        }
    }
}
