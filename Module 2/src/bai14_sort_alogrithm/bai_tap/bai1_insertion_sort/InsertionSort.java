package bai14_sort_alogrithm.bai_tap.bai1_insertion_sort;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter list size: ");
        int size=scanner.nextInt();
        int[] list=new int[size];
        System.out.println("Enter " + list.length + " values:");
        for(int i=0;i<list.length;i++){
            list[i]=scanner.nextInt();
        }
        System.out.println("your list: ");
        for (int i=0;i<list.length;i++){
            System.out.println(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertSortByStep(list);
    }
    public static void insertSortByStep(int [] list){
        for(int i=1;i<list.length;i++){
            int key=list[i];
            int j=i-1;
            while (j>=0&&list[j]>key){
                list[j+1]=list[j];
                j--;
            }
            list[j+1]=key;

            System.out.print("List after the  " + i + "' sort: ");
            for (int k = 0; k < list.length; k++) {
                System.out.print(list[k] + "\t");
            }
            System.out.println();
        }

    }
}
