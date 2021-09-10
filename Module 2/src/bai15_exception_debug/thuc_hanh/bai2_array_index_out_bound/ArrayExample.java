package bai15_exception_debug.thuc_hanh.bai2_array_index_out_bound;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public int[] createRandom(){
        Random random=new Random();
        int[] arr= new int[100];
        System.out.println("danh sách phần tử của mảng");
        for (int i=0;i<100;i++){
            arr[i]=random.nextInt(100);
            System.out.println(arr[i]+ " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample=new ArrayExample();
        int[] arr=arrayExample.createRandom();
        Scanner scaner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int x = scaner.nextInt();
        try {
            System.out.println("giá trị của phần tử có chỉ số "+x+" là "+arr[x]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }
}
