package case_study.services;

import case_study.untils.ReadWrite;
import case_study.models.Employee;
import case_study.untils.validate.ValidateEmp;
import case_study.untils.validate.exception.EmployeeException;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    public static void add(){
        ArrayList<Employee> list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id nhân viên");
        String inputId=scanner.nextLine();
        System.out.println("Nhập tên nhân viên");
        String inputName=scanner.nextLine();
        String inputDate="";
        while (true){
            try {
                System.out.println("Nhập ngày sinh");
                inputDate=scanner.nextLine();
                ValidateEmp.validateDate(inputDate);
                break;
            }catch (EmployeeException e){
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
                System.out.println("Nhập email nhân viên");
                inputEmail=scanner.nextLine();
                ValidateEmp.validateEmail(inputEmail);
                break;
            }catch (EmployeeException e){
                System.err.println(e.getMessage());
            }
        }
        String inputLevel="";
        while (true){
            try {
                System.out.println("nhập trình độ nhân viên (Trung cấp, Cao đẳng, Đại học và sau đại học)");
                inputLevel=scanner.nextLine();
                ValidateEmp.validateLevel(inputLevel);
                break;
            }catch (EmployeeException e){
                System.err.println(e.getMessage());
            }
        }
        String inputPosition="";
        while (true){
            try {
                System.out.println("nhập vị trí nhân viên (Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc)");
                inputPosition=scanner.nextLine();
                ValidateEmp.validatePosition(inputPosition);
                break;
            }catch (EmployeeException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("nhập lương nhân viên");
        double inputSalary=scanner.nextDouble();
        list.add(new Employee(inputName,inputDate,inputGender,inputIdCard,inputEmail,inputId,inputLevel,inputPosition,inputSalary));
        ReadWrite.writeEmployee(ReadWrite.EMPLOYEE_PATH,list,true);
        display();
    }
    public static void edit(){
        ArrayList<Employee> list=ReadWrite.readEmployee(ReadWrite.EMPLOYEE_PATH);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id nhân viên cần sửa");
        String inputId=scanner.nextLine();
        for(Employee employee:list){
            if(employee.getEmployeeId().equals(inputId)){
                System.out.println("Nhập tên nhân viên");
                String inputName=scanner.nextLine();
                String inputDate="";
                while (true){
                    try {
                        System.out.println("Nhập ngày sinh");
                        inputDate=scanner.nextLine();
                        ValidateEmp.validateDate(inputDate);
                        break;
                    }catch (EmployeeException e){
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
                        System.out.println("Nhập email nhân viên");
                        inputEmail=scanner.nextLine();
                        ValidateEmp.validateEmail(inputEmail);
                        break;
                    }catch (EmployeeException e){
                        System.err.println(e.getMessage());
                    }
                }
                String inputLevel="";
                while (true){
                    try {
                        System.out.println("nhập trình độ nhân viên (Trung cấp, Cao đẳng, Đại học và sau đại học)");
                        inputLevel=scanner.nextLine();
                        ValidateEmp.validateLevel(inputLevel);
                        break;
                    }catch (EmployeeException e){
                        System.err.println(e.getMessage());
                    }
                }
                String inputPosition="";
                while (true){
                    try {
                        System.out.println("nhập vị trí nhân viên (Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc)");
                        inputPosition=scanner.nextLine();
                        ValidateEmp.validatePosition(inputPosition);
                        break;
                    }catch (EmployeeException e){
                        System.err.println(e.getMessage());
                    }
                }
                System.out.println("nhập lương nhân viên");
                double inputSalary=scanner.nextDouble();
                employee.setName(inputName);
                employee.setDate(inputDate);
                employee.setGender(inputGender);
                employee.setIdCard(inputIdCard);
                employee.setEmail(inputEmail);
                employee.setLevel(inputLevel);
                employee.setPosition(inputPosition);
                employee.setSalary(inputSalary);
                ReadWrite.writeEmployee(ReadWrite.EMPLOYEE_PATH,list,false);
                display();
            }
        }
    }
    public static void display(){
        ArrayList<Employee> list=ReadWrite.readEmployee(ReadWrite.EMPLOYEE_PATH);
        for(Employee employee:list){
            System.out.println(employee.showInfo());
        }
    }
}
