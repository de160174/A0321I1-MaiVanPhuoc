package bai12_java_collection.bai_tap.bai1_product_management;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    public static void add(ArrayList<Product> list){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id sản phẩm");
        int inputId=scanner.nextInt();
        scanner.nextLine();
        System.out.println("nhập tên sản phẩm");
        String inputName=scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        double inputPrice=scanner.nextInt();
        list.add(new Product(inputId,inputName,inputPrice));
        display(list);
    }
    public static void remove(ArrayList<Product> list){
        System.out.println("nhập id sản phẩm muốn xóa");
        Scanner scanner=new Scanner(System.in);
        int inputId=scanner.nextInt();
        for(int i=0;i<list.size();i++){
            if(i==inputId){
                list.remove(i-1);
            }
        }
        display(list);
    }
    public static void edit(ArrayList<Product> list){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id sản phẩm cần sửa");
        int inputId=scanner.nextInt();
        scanner.nextLine();
        for(Product product:list){
            if(product.getId()==inputId){
                System.out.println("Nhập tên mới của sản phẩm");
                String inputName=scanner.nextLine();
                System.out.println("Nhập giá mới của sản phẩm");
                double inputPrice=scanner.nextInt();
                product.setName(inputName);
                product.setPrice(inputPrice);
                display(list);
            }
        }
    }
    public static void search(ArrayList<Product> list){
        System.out.println("nhập tên sản phẩm bạn muốn tìm kiếm");
        Scanner scanner=new Scanner(System.in);
        String inputName=scanner.nextLine();
        boolean check=false;
        for(Product product:list){
            if(product.getName().equals(inputName)) {
                check = true;
            }
        }
        if(check){
            System.out.println("sản phẩm có trong danh sách");
        }else
            System.out.println("sản phẩm không tồn tại");
    }
    public static void display(ArrayList<Product> list){
        for(Product product:list){
            System.out.println(product);
        }
    }
}
