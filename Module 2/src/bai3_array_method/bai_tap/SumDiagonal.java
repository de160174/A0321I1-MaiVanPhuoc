package bai3_array_method.bai_tap;

import java.util.Scanner;

public class SumDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ma trận vuông có số cột và số dòng bằng nhau");
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
        int cheo1=0;
        for (int i = 0; i < row; i++) {
                if(i==i)
                    cheo1+=array[i][i];

        }
        System.out.println("tổng đường chéo chính thứ 1 là " +cheo1);

        int cheo2=0;
        for (int i = 0;i <row; i++) {
            for (int j = 0; j <col ; j++) {
                if(array.length-1-i==j)
                    cheo2+=array[i][j];
            }
        }
        System.out.println("tổng đường chéo chính thứ 2 là " +cheo2);


    }
}
