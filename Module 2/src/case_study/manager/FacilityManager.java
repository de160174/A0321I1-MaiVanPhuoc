package case_study.manager;

import case_study.controllers.FuramaController;
import case_study.models.Facility;
import case_study.services.FacilityServiceImpl;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityManager {
    static LinkedHashMap<Facility,Integer> linkedHashMap=new LinkedHashMap<>();
    public void facilityMenu(){
//        linkedHashMap.put(new Room("buffet sáng"),4);
//        linkedHashMap.put(new House("VIP",3),0);
//        linkedHashMap.put(new Villa("tiêu chuẩn",20,2),0);
        System.out.println("Facility Management ");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance");
        System.out.println("4. Return main menu");
        System.out.println("Enter choice");
        Scanner scanner=new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Display facility");
                System.out.println("1. Display Villa");
                System.out.println("2. Display House");
                System.out.println("3. Display Room");
                System.out.println("4. Return main menu");
                System.out.println("Enter choice");
                int choice1 = scanner.nextInt();
                switch (choice1) {
                    case 1:
                        FacilityServiceImpl.displayVilla();
                        break;
                    case 2:
                        FacilityServiceImpl.displayHouse();
                        break;
                    case 3:
                        FacilityServiceImpl.displayRoom();
                        break;
                    case 4:
                        facilityMenu();
                        break;
                }
                break;
            case 2:
                System.out.println("Add new facility");
                System.out.println("1. Add new Villa");
                System.out.println("2. Add new House");
                System.out.println("3. Add new Room");
                System.out.println("4. Return main menu");
                System.out.println("Enter choice");
                int choice2 = scanner.nextInt();
                switch (choice2){
                    case 1:
                        FacilityServiceImpl.addVilla();
                        break;
                    case 2:
                        FacilityServiceImpl.addHouse();
                        break;
                    case 3:
                        FacilityServiceImpl.addRoom();
                        break;
                    case 4:
                        facilityMenu();
                        break;
                }
                break;
            case 3:
                FacilityServiceImpl.displayRepair(linkedHashMap);
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
