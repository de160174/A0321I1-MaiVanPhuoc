package bai17_io_binary_serialization.bai_tap.bai1_product_binary;

import java.io.*;
import java.util.*;

public class ProductManager {
    static final String PATH ="D:\\BTcodegym\\Module2\\src\\bai17_io_binary_serialization\\bai_tap\\bai1_product_binary\\product.csv";
    static List<Product> list=new LinkedList<>();
    static Scanner scanner=new Scanner(System.in);
    public static void add(){
        System.out.println("Nhập mã sản phẩm");
        String productId=scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String productName=scanner.nextLine();
        System.out.println("Nhập thương hiệu sản phẩm");
        String productBrand=scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double productPrice=scanner.nextDouble();
        scanner.skip("\\R");
        System.out.println("Nhập mô tả sản phẩm");
        String productDesc=scanner.nextLine();
        list.add(new Product(productId,productName,productBrand,productPrice,productDesc));
        write(list,PATH);
        display();
    }
    public static void search(){
        list= (List<Product>) read(PATH);
        System.out.println("nhập tên sản phẩm bạn cần tìm");
        String input=scanner.nextLine();
        for(Product product:list){
            if (product.getProductName().equals(input)){
                System.out.println("có sản phẩm bạn cần "+product);
                return;
            }
        }
        System.out.println("không có sản phẩn bạn cần");
    }
    public static void display(){
        list= (List<Product>) read(PATH);
        for (Product product:list){
            System.out.println(product);
        }
    }
    public static void write(Collection collection, String path){
        File file=new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;

        try {
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(collection);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object read(String path){
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        Object object=null;

        try {
            fileInputStream=new FileInputStream(path);
            objectInputStream=new ObjectInputStream(fileInputStream);
            object=objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
