package bai3_array_method.bai_tap;

import java.util.Scanner;

public class SumCol {
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
        System.out.println("bạn muốn tính tổng cột thứ mấy");
        int index=scanner.nextInt();
        int sum=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(j==index)
                sum+=array[i][j];
            }
        }
        System.out.println("tổng của cột thứ "+index+" là " +sum);
    }
}
