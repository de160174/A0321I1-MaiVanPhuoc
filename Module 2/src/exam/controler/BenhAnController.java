package exam.controler;

import exam.service.BenhAnServiceImpl;

import java.util.Scanner;

public class BenhAnController {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN–");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách bệnh án ");
            System.out.println("4. Thoát ");
            System.out.println("chọn chức năng: ");
            BenhAnServiceImpl benhAnService=new BenhAnServiceImpl();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("--THÊM MỚI BỆNH ÁN–");
                    System.out.println("1. Thêm mới bệnh án thường");
                    System.out.println("2. Thêm mới bệnh án VIP");
                    int choice1 = scanner.nextInt();
                    switch (choice1){
                        case 1:
                            benhAnService.addThuong();
                            break;
                        case 2:
                            benhAnService.addVIP();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("--XÓA BỆNH ÁN–");
                    System.out.println("1. xóa bệnh án thường");
                    System.out.println("2. xóa bệnh án VIP");
                    int choice2 = scanner.nextInt();
                    switch (choice2){
                        case 1:
                            benhAnService.xoaThuong();
                            break;
                        case 2:
                            benhAnService.xoaVIP();
                            break;
                    }
                    break;
                case 3:

                    System.out.println("--XEM BỆNH ÁN–");
                    System.out.println("1. xem bệnh án thường");
                    System.out.println("2. xem bệnh án VIP");
                    int choice3 = scanner.nextInt();
                    switch (choice3){
                        case 1:
                            benhAnService.xemThuong();
                            break;
                        case 2:
                            benhAnService.xemVIP();
                            break;
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng nhập lại!!");
            }
        }
    }
}
