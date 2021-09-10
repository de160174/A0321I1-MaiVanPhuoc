package bai3_array_method.bai_tap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int size1;
        int[] array1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("nhập kích thước mảng 1:");
            size1 = scanner.nextInt();
            if (size1 > 20)
                System.out.println("mảng không vượt quá 20 phần tử");
        } while (size1 > 20);
        //nhap gia tri cho phan tu cua mang
        array1 = new int[size1];
        int i = 0;
        while (i < array1.length) {
            System.out.print("nhập phần tử thứ " + (i + 1) + " : ");
            array1[i] = scanner.nextInt();
            i++;
        }
        //in mang
        System.out.print("mảng đã tạo: ");
        for (int j = 0; j < array1.length; j++) {
            System.out.print(array1[j] + "\t");
        }
        //mang2
        int size2;
        int[] array2;
        do {
            System.out.println("nhập kích thước mảng 2:");
            size2 = scanner.nextInt();
            if (size2 > 20)
                System.out.println("mảng không vượt quá 20 phần tử");
        } while (size2 > 20);
        array2 = new int[size2];
        int j = 0;
        while (j < array2.length) {
            System.out.print("nhập phần tử thứ " + (j + 1) + " : ");
            array2[j] = scanner.nextInt();
            j++;
        }
        //in mang
        System.out.print("mảng đã tạo: ");
        for (int k = 0; k < array2.length; k++) {
            System.out.print(array2[k] + "\t");
        }
        //mang 3
        int[] array3=new int[array1.length+array2.length];
        for(int k=0;k<array3.length;k++){
            if(k<array1.length){
                array3[k]=array1[k];
            }else {
                array3[k]=array2[k-size1];
            }
        }
        System.out.print("mảng sau khi gộp: ");
        for (int k = 0; k < array3.length; k++) {
            System.out.print(array3[k] + "\t");
        }
    }
}
