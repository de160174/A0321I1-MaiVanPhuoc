package bai12_java_collection.bai_tap.bai1_product_management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "toyota", 150));
        list.add(new Product(2, "bmw", 250));
        list.add(new Product(3, "tesla", 370));
        list.add(new Product(4, "mercedes", 270));
        list.add(new Product(5, "hyundai", 300));
        while (true){
            System.out.println("QUẢN LÝ SẢN PHẨM: \n" +
                    "1. Thêm sản phẩm \n" +
                    "2. Sửa thông tin sản phẩm \n" +
                    "3. Xoá sản phẩm \n" +
                    "4. Hiển thị danh sách sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm \n" +
                    "6. Sắp xếp sản phẩm tăng dần theo giá \n" +
                    "7. Thoát chương trình \n" +
                    "************************************** \n"+
                    "chọn một chức năng");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ProductManager.add(list);
                    break;
                case 2:
                    ProductManager.edit(list);
                    break;
                case 3:
                    ProductManager.remove(list);
                    break;
                case 4:
                    ProductManager.display(list);
                    break;
                case 5:
                    ProductManager.search(list);
                    break;
                case 6:
                    Collections.sort(list,new ComparatorAge());
                    ProductManager.display(list);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn lại!!!");
            }
        }

    }
}
