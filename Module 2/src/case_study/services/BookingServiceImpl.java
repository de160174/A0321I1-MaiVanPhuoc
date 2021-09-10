package case_study.services;

import case_study.untils.ReadWrite;
import case_study.models.*;

import java.util.*;

public class BookingServiceImpl implements BookingService{
    static List<Customer> customerList= ReadWrite.readCustomer(ReadWrite.CUSTOMER_PATH);
    static TreeSet<Booking> bookingSet=new TreeSet<>(new BookingComparator());
    public TreeSet<Booking> sendBooking(){
        return bookingSet;
    }
    public static void add(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("danh sách khách hàng");
        for(Customer customer:customerList){
            System.out.println(customer.showInfo());
        }
        System.out.println("chọn mã khách hàng");
        String chooseCus=scanner.nextLine();
//        System.out.println("Service List");
//        for(Booking booking:bookingList){
//            System.out.println(booking.showInfo());
//        }
//        System.out.println("chọn mã dịch vụ");
//        String chooseSer=scanner.nextLine();
        System.out.println("Nhập mã booking");
        String inputId=scanner.nextLine();
        System.out.println("Nhập ngày bắt đầu");
        String inputStart=scanner.nextLine();
        System.out.println("Nhập ngày kết thúc");
        String inputEnd=scanner.nextLine();
        System.out.println("Nhập tên dịch vụ");
        String inputName=scanner.nextLine();
        System.out.println("Nhập loại dịch vụ");
        String inputType=scanner.nextLine();
        bookingSet.add(new Booking(inputId,inputStart,inputEnd,chooseCus,inputName,inputType));
        ReadWrite.writeBooking(ReadWrite.BOOKING_PATH,bookingSet,true);
        display();
    }
    public static void display(){
        Set<Booking> list=ReadWrite.readBooking(ReadWrite.BOOKING_PATH);
        for(Booking booking:list){
            System.out.println(booking.showInfo());
        }
    }
}
