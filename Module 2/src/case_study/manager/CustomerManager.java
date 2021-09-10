package case_study.manager;

import case_study.controllers.FuramaController;
import case_study.models.Customer;
import case_study.services.CustomerServiceImpl;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerManager {
    LinkedList<Customer> linkedList=new LinkedList<>();
    public void customerMenu(){
        System.out.println("Customer Management ");
        System.out.println("1. Display list customers");
        System.out.println("2. Add new customers");
        System.out.println("3. Edit customers");
        System.out.println("4. Return main menu");
        System.out.println("Enter choice");
        Scanner scanner=new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                CustomerServiceImpl.display();
                break;
            case 2:
                CustomerServiceImpl.add(linkedList);
                break;
            case 3:
                CustomerServiceImpl.edit();
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
