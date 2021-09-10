package case_study.services;

import case_study.untils.ReadWrite;
import case_study.models.*;
import case_study.untils.validate.ValidateService;
import case_study.untils.validate.exception.ServiceException;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FacilityServiceImpl implements FacilityService{
    static Scanner scanner=new Scanner(System.in);
    public static void addRoom(){
        LinkedHashMap<Room,Integer> list=new LinkedHashMap<>();
        String inputName="";
        while (true){
            try {
                System.out.println("Nhập tên dịch vụ");
                inputName=scanner.nextLine();
                ValidateService.nameService(inputName);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích sử dụng");
        Double inputArea=scanner.nextDouble();
        System.out.println("Nhập chi phí thuê");
        Double inputPrice=scanner.nextDouble();
        System.out.println("Nhập số lượng người tối đa");
        int inputMax=scanner.nextInt();
        scanner.nextLine();
        String inputType="";
        while (true){
            try {
                System.out.println("Nhập kiểu thuê (theo năm, tháng, ngày, giờ)");
                inputType=scanner.nextLine();
                ValidateService.checkRentType(inputType);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập tên dịch vụ miễn phí đi kèm");
        String inputFree=scanner.nextLine();
        list.put(new Room(inputName,inputArea,inputPrice,inputMax,inputType,inputFree),0);
        ReadWrite.writeRoom(ReadWrite.ROOM_PATH,list.keySet(),true);
        displayRoom();
    }
    public static void addHouse(){
        LinkedHashMap<House,Integer> list=new LinkedHashMap<>();
        String inputName="";
        while (true){
            try {
                System.out.println("Nhập tên dịch vụ");
                inputName=scanner.nextLine();
                ValidateService.nameService(inputName);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích sử dụng");
        Double inputArea=scanner.nextDouble();
        System.out.println("Nhập chi phí thuê");
        Double inputPrice=scanner.nextDouble();
        System.out.println("Nhập số lượng người tối đa");
        int inputMax=scanner.nextInt();
        scanner.nextLine();
        String inputType="";
        while (true){
            try {
                System.out.println("Nhập kiểu thuê (theo năm, tháng, ngày, giờ)");
                inputType=scanner.nextLine();
                ValidateService.checkRentType(inputType);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        String inputStandard="";
        while (true){
            try {
                System.out.println("Nhập tiêu chuẩn phòng");
                inputStandard=scanner.nextLine();
                ValidateService.checkRoomStandard(inputStandard);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập số tầng");
        int inputFloor=scanner.nextInt();
        list.put(new House(inputName,inputArea,inputPrice,inputMax,inputType,inputStandard,inputFloor),0);
        ReadWrite.writeHouse(ReadWrite.HOUSE_PATH,list.keySet(),true);
        displayHouse();
    }
    public static void addVilla(){
        LinkedHashMap<Villa,Integer> list=new LinkedHashMap<>();
        String inputName="";
        while (true){
            try {
                System.out.println("Nhập tên dịch vụ");
                inputName=scanner.nextLine();
                ValidateService.nameService(inputName);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích sử dụng");
        Double inputArea=scanner.nextDouble();
        System.out.println("Nhập chi phí thuê");
        Double inputPrice=scanner.nextDouble();
        System.out.println("Nhập số lượng người tối đa");
        int inputMax=scanner.nextInt();
        scanner.nextLine();
        String inputType="";
        while (true){
            try {
                System.out.println("Nhập kiểu thuê (theo năm, tháng, ngày, giờ)");
                inputType=scanner.nextLine();
                ValidateService.checkRentType(inputType);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        String inputStandard="";
        while (true){
            try {
                System.out.println("Nhập tiêu chuẩn phòng");
                inputStandard=scanner.nextLine();
                ValidateService.checkRoomStandard(inputStandard);
                break;
            }catch (ServiceException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích hồ bơi");
        double inputAreaPool=scanner.nextDouble();
        System.out.println("Nhập số tầng");
        int inputFloor=scanner.nextInt();
        list.put(new Villa(inputName,inputArea,inputPrice,inputMax,inputType,inputStandard,inputAreaPool,inputFloor),0);
        ReadWrite.writeVilla(ReadWrite.VILLA_PATH,list.keySet(),true);
        displayVilla();
    }
    public static void displayHouse(){
        Set<House> houseSet=(TreeSet<House>)ReadWrite.readHouse(ReadWrite.HOUSE_PATH);
        for (House key:houseSet){
            System.out.println(key.showInfo());
        }
    }
    public static void displayRoom(){
        Set<Room> roomSet=(TreeSet<Room>)ReadWrite.readRoom(ReadWrite.ROOM_PATH);
        for (Room key:roomSet){
                System.out.println(key.showInfo());
        }
    }
    public static void displayVilla(){
        Set<Villa> villaSet=(TreeSet<Villa>)ReadWrite.readVilla(ReadWrite.VILLA_PATH);
        for (Villa key:villaSet){
            System.out.println(key.showInfo());
        }
    }
    public static void displayRepair(LinkedHashMap<Facility,Integer> linkedHashMap){
        boolean check=false;
        Set<Facility> keySet=linkedHashMap.keySet();
        for (Facility key:keySet){
            if(linkedHashMap.get(key)>=5){
                System.out.println(key + " " + linkedHashMap.get(key));
                check=true;
            }
        }
        if(!check){
            System.out.println("không có dịch vụ cần bảo dưỡng");
        }
    }
}
