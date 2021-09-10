package case_study.services;

import case_study.untils.ReadWrite;
import case_study.models.Customer;
import case_study.untils.validate.ValidateCustomer;
import case_study.untils.validate.exception.CustomerException;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    public static void add(LinkedList<Customer> list){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id khách hàng");
        String inputId=scanner.nextLine();
        String inputType="";
        while (true){
            try {
                System.out.println("nhập loại khách hàng (Diamond, Platinium, Gold, Silver, Member)");
                inputType=scanner.nextLine();
                ValidateCustomer.validateType(inputType);
                break;
            }catch (CustomerException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("nhập địa chỉ khách hàng");
        String inputAddress=scanner.nextLine();
        System.out.println("Nhập tên khách hàng");
        String inputName=scanner.nextLine();
        String inputDate="";
        while (true){
            try {
                System.out.println("Nhập ngày sinh");
                inputDate=scanner.nextLine();
                ValidateCustomer.validateDate(inputDate);
                break;
            }catch (CustomerException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập giới tính");
        Boolean inputGender=scanner.nextBoolean();
        System.out.println("Nhập số CMND");
        int inputIdCard=scanner.nextInt();
        scanner.skip("\\R");
        String inputEmail="";
        while (true){
            try {
                System.out.println("Nhập email khách hàng");
                inputEmail=scanner.nextLine();
                ValidateCustomer.validateEmail(inputDate);
                break;
            }catch (CustomerException e){
                System.err.println(e.getMessage());
            }
        }
        list.add(new Customer(inputName,inputDate,inputGender,inputIdCard,inputEmail,inputId,inputType,inputAddress));
        ReadWrite.writeCustomer(ReadWrite.CUSTOMER_PATH,list,true);
        display();
    }
    public static void edit(){
        LinkedList<Customer> list= ReadWrite.readCustomer(ReadWrite.CUSTOMER_PATH);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id khách hàng cần sửa");
        String inputId=scanner.nextLine();
        for(Customer customer:list){
            if(customer.getCustomerId().equals(inputId)){
                System.out.println("Nhập tên khách hàng");
                String inputName=scanner.nextLine();
                String inputDate="";
                while (true){
                    try {
                        System.out.println("Nhập ngày sinh");
                        inputDate=scanner.nextLine();
                        ValidateCustomer.validateDate(inputDate);
                        break;
                    }catch (CustomerException e){
                        System.err.println(e.getMessage());
                    }
                }
                System.out.println("Nhập giới tính");
                Boolean inputGender=scanner.nextBoolean();
                System.out.println("Nhập số CMND");
                int inputIdCard=scanner.nextInt();
                scanner.skip("\\R");
                String inputEmail="";
                while (true){
                    try {
                        System.out.println("Nhập email khách hàng");
                        inputEmail=scanner.nextLine();
                        ValidateCustomer.validateEmail(inputDate);
                        break;
                    }catch (CustomerException e){
                        System.err.println(e.getMessage());
                    }
                }
                String inputType="";
                while (true){
                    try {
                        System.out.println("nhập loại khách hàng (Diamond, Platinium, Gold, Silver, Member)");
                        inputType=scanner.nextLine();
                        ValidateCustomer.validateType(inputType);
                        break;
                    }catch (CustomerException e){
                        System.err.println(e.getMessage());
                    }
                }
                System.out.println("nhập địa chỉ khách hàng");
                String inputAddress=scanner.nextLine();
                customer.setCustomerType(inputType);
                customer.setCustomerAddress(inputAddress);
                customer.setName(inputName);
                customer.setDate(inputDate);
                customer.setGender(inputGender);
                customer.setIdCard(inputIdCard);
                customer.setEmail(inputEmail);
                ReadWrite.writeCustomer(ReadWrite.CUSTOMER_PATH,list,false);
                display();
            }
        }
    }
    public static void display(){
        LinkedList<Customer> list= ReadWrite.readCustomer(ReadWrite.CUSTOMER_PATH);
        for(Customer customer:list){
            System.out.println(customer.showInfo());
        }
    }
}
