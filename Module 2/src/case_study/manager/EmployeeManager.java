package case_study.manager;

import case_study.controllers.FuramaController;
import case_study.models.Employee;
import case_study.services.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    public void employeeMenu(){
        System.out.println("Employee Management");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Return main menu");
        System.out.println("Enter choice");
        Scanner scanner=new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                EmployeeServiceImpl.display();
                break;
            case 2:
                EmployeeServiceImpl.add();
                break;
            case 3:
                EmployeeServiceImpl.edit();
                break;
            case 4:
                FuramaController controller=new FuramaController();
                controller.displayMainMenu();
                break;
            default:
                System.err.println("Errol! Enter again");
                break;
        }
    }
}
