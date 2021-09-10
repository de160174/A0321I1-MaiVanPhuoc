package bai3_array_method.bai_tap;

import java.util.Scanner;

public class FindMaxArray2d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số dòng của mảng: ");
        int row = scanner.nextInt();
        System.out.println("Nhập vào số cột của mảng: ");
        int col = scanner.nextInt();
        int[][]array=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhập phần tử thứ [" + i + " , " + j + " ]: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
        int max=array[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(array[i][j]>max){
                    max=array[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất của mảng là "+max);
    }
}
