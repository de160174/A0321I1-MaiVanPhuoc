package bai3_array_method.bai_tap;

import java.util.Scanner;

public class DelArray {
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

        System.out.println("nhập giá trị cần xóa");
        int value;
        value=scanner.nextInt();
        boolean check=false;
        int index_del;
        for(index_del=0;index_del<array.length;index_del++){
            if(array[index_del]==value){
                System.out.println("giá trị "+value+" có trong mảng và ở vị trí thứ "+index_del);
                check=true;
                break;
            }
        }
        if(check){
            for (int k=index_del;k<array.length-1;k++){
                array[k]=array[k+1];
                array[k+1]=0;
            }
            System.out.print("mảng sau khi xóa: ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");
            }
        }else {
            System.out.println("không có giá trị "+value+" trong mảng");
        }
    }
}
