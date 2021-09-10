package case_study.untils;

import case_study.models.*;
import case_study.services.BookingComparator;

import java.io.*;
import java.util.*;

public class ReadWrite {
    public static final String VILLA_PATH="src\\case_study\\data\\villa.csv";
    public static final String HOUSE_PATH="src\\case_study\\data\\house.csv";
    public static final String ROOM_PATH="src\\case_study\\data\\room.csv";
    public static final String BOOKING_PATH="src\\case_study\\data\\booking.csv";
    public static final String EMPLOYEE_PATH="src\\case_study\\data\\employee.csv";
    public static final String CONTRACT_PATH="src\\case_study\\data\\contract.csv";
    public static final String CUSTOMER_PATH="src\\case_study\\data\\customer.csv";
    public static void writeVilla(String path,Set<Villa> villaList,boolean check){
        try {
            FileWriter fileWriter=new FileWriter(VILLA_PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Villa villa:villaList){
                bufferedWriter.write(villa.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeHouse(String path, Set<House> houseList, boolean check){
        try {
            FileWriter fileWriter=new FileWriter(HOUSE_PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (House house:houseList){
                bufferedWriter.write(house.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeRoom(String path,Set<Room> roomList,boolean check){
        try {
            FileWriter fileWriter=new FileWriter(ROOM_PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Room room:roomList){
                bufferedWriter.write(room.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeBooking(String path,TreeSet<Booking> bookingList,boolean check){
        try {
            FileWriter fileWriter=new FileWriter(BOOKING_PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Booking booking:bookingList){
                bufferedWriter.write(booking.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeCustomer(String path,List<Customer> customerList,boolean check){
        try {
            FileWriter fileWriter=new FileWriter(CUSTOMER_PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Customer customer:customerList){
                bufferedWriter.write(customer.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeEmployee(String path,List<Employee> employeeList,boolean check){
        try {
            FileWriter fileWriter=new FileWriter(EMPLOYEE_PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Employee employee:employeeList){
                bufferedWriter.write(employee.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeContract(String path, Queue<Contract> contractList, boolean check){
        try {
            FileWriter fileWriter=new FileWriter(CONTRACT_PATH,check);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Contract contract:contractList){
                bufferedWriter.write(contract.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<Villa> readVilla(String Path){
        Set<Villa> villaList=new TreeSet<>();
        try {
            FileReader fileReader=new FileReader(VILLA_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                Villa villa=new Villa(arr[0],Double.parseDouble(arr[1]),Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),arr[4],arr[5],Double.parseDouble(arr[6]),Integer.parseInt(arr[7]));
                villaList.add(villa);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaList;
    }
    public static Set<House> readHouse(String Path){
        Set<House> houseList=new TreeSet<>();
        try {
            FileReader fileReader=new FileReader(HOUSE_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                House house=new House(arr[0],Double.parseDouble(arr[1]),Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),arr[4],arr[5],Integer.parseInt(arr[6]));
                houseList.add(house);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }
    public static Set<Room> readRoom(String Path){
        Set<Room> roomList=new TreeSet<>();
        try {
            FileReader fileReader=new FileReader(ROOM_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                Room room=new Room(arr[0],Double.parseDouble(arr[1]),Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),arr[4],arr[5]);
                roomList.add(room);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomList;
    }
    public static ArrayList<Employee> readEmployee(String Path){
        ArrayList<Employee> employeeList=new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(EMPLOYEE_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                Employee employee=new Employee(arr[0],arr[1],Boolean.parseBoolean(arr[2]),Integer.parseInt(arr[3]),arr[4],arr[5],arr[6],arr[7],Double.parseDouble(arr[8]));
                employeeList.add(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    public static LinkedList<Customer> readCustomer(String Path){
        LinkedList<Customer> customerList=new LinkedList<>();
        try {
            FileReader fileReader=new FileReader(CUSTOMER_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                Customer customer=new Customer(arr[0],arr[1],Boolean.parseBoolean(arr[2]),Integer.parseInt(arr[3]),arr[4],arr[5],arr[6],arr[7] );
                customerList.add(customer);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
    public static Set<Booking> readBooking(String Path){
        Set<Booking> bookingList=new TreeSet<>(new BookingComparator());
        try {
            FileReader fileReader=new FileReader(BOOKING_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                Booking booking=new Booking(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
                bookingList.add(booking);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingList;
    }
    public static Queue<Contract> readContract(String Path){
        Queue<Contract> contractList=new LinkedList<>();
        try {
            FileReader fileReader=new FileReader(CONTRACT_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] arr=line.split(",");
                Contract contract=new Contract(Integer.parseInt(arr[0]),arr[1],Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),arr[4]);
                contractList.add(contract);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}
