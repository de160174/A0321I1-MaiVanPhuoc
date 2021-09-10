package bai3_array_method.bai_tap;

import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("nhập kích thước:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("mảng không vượt quá 20 phần tử");
        } while (size > 20);
        //nhap gia tri cho phan tu cua mang
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("nhập phần tử thứ " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        //in mang
        System.out.print("mảng đã tạo: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int[] arrayNew=new int[array.length+1];
        System.out.println("nhập vào giá trị cần thêm");
        int value=scanner.nextInt();
        System.out.println("nhập vào vị trí được thêm");
        int index=scanner.nextInt();
        if(index<=1&&index>=array.length-1){
            System.out.println("không thêm được!");
        }else {
            for(int j=0;j<index;j++){
                arrayNew[j]=array[j];
            }
            arrayNew[index]=value;
            for(int j=index;j<arrayNew.length-1;j++){
                arrayNew[j+1]=array[j];
            }
            System.out.print("mảng sau khi thêm phần tử: ");
            for (int j = 0; j < arrayNew.length; j++) {
                System.out.print(arrayNew[j] + "\t");
            }

        }
    }
}
