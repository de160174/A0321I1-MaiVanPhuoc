package case_study.manager;

import case_study.controllers.FuramaController;
import case_study.services.BookingServiceImpl;
import case_study.services.ContractServiceImpl;
import case_study.services.FacilityServiceImpl;

import java.util.*;

public class BookingManager {
    public void bookingMenu(){
        System.out.println("Booking Management ");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new contracts");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contracts");
        System.out.println("6. Return main menu");
        System.out.println("Enter choice");
        Scanner scanner=new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                BookingServiceImpl.add();
                break;
            case 2:
                BookingServiceImpl.display();
                break;
            case 3:
                ContractServiceImpl.addContract();
                break;
            case 4:
                ContractServiceImpl.displayConTract();
                break;
            case 5:
                ContractServiceImpl.editContract();
                break;
            case 6:
                FuramaController controller=new FuramaController();
                controller.displayMainMenu();
                break;
            default:
                System.err.println("Errol! Enter again");
                break;
        }
    }
}
