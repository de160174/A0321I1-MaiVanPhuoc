package case_study.services;

import case_study.untils.ReadWrite;
import case_study.models.Booking;
import case_study.models.Contract;

import java.util.*;

public class ContractServiceImpl implements ContactService{
    static Queue<Contract> list=new LinkedList<>();
    public static void addContract(){
        Queue<Booking> bookingQueue=new LinkedList<>();
        Set<Booking> bookingSet= new BookingServiceImpl().sendBooking();
        for(Booking booking:bookingSet){
            bookingQueue.add(booking);
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số hợp đồng");
        int inputNum=scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("Nhập id booking");
        String inputBookId=scanner.nextLine();
        System.out.println("Nhập số tiền cọc trước");
        double inputDeposit=scanner.nextDouble();
        System.out.println("nhập tổng số tiền thanh toán");
        double inputAmount=scanner.nextDouble();
        scanner.skip("\\R");
        System.out.println("nhập id khách hàng");
        String inputCusId=scanner.nextLine();
        list.add(new Contract(inputNum,inputBookId,inputDeposit,inputAmount,inputCusId));
        ReadWrite.writeContract(ReadWrite.CONTRACT_PATH,list,true);
        displayConTract();
    }
    public static void editContract(){
        Queue<Contract> list= ReadWrite.readContract(ReadWrite.CONTRACT_PATH);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số hợp đồng cần sửa");
        int inputId=scanner.nextInt();
        for(Contract contract:list){
            if(contract.getContractNumber()==inputId){
                scanner.nextLine();
                System.out.println("Nhập bookingId");
                String inputBookId=scanner.nextLine();
                System.out.println("Nhập số tiền cọc trước");
                double inputDeposit=scanner.nextDouble();
                System.out.println("nhập tổng số tiền thanh toán");
                double inputAmount=scanner.nextDouble();
                scanner.skip("\\R");
                System.out.println("nhập id khách hàng");
                String inputCusId=scanner.nextLine();
                contract.setBookingId(inputBookId);
                contract.setDepositAmount(inputDeposit);
                contract.setTotalAmount(inputAmount);
                contract.setCustomerId(inputCusId);
                ReadWrite.writeContract(ReadWrite.CONTRACT_PATH,list,false);
                displayConTract();
            }
        }
    }
    public static void displayConTract(){
        Queue<Contract> list= ReadWrite.readContract(ReadWrite.CONTRACT_PATH);
        for(Contract contract:list){
            System.out.println(contract.showInfo());
        }
    }
}
