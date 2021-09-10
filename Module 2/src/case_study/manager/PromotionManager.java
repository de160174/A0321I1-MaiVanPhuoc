package case_study.manager;

import case_study.controllers.FuramaController;
import case_study.models.Booking;
import case_study.services.PromotionServiceImpl;

import java.util.Scanner;
import java.util.TreeSet;

public class PromotionManager {
    static TreeSet<Booking> tree=new TreeSet<>();
    public void promotionMenu(){
        tree.add(new Booking("B1","10/10/2020","05/12/2021","C1","Villa","VIP"));
        tree.add(new Booking("B3","10/10/2020","05/04/2019","C3","Room","business"));
        System.out.println("Promotion Management");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.println("Enter choice");
        Scanner scanner=new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                PromotionServiceImpl.displayUse(tree);
                break;
            case 2:
            case 3:
                FuramaController controller=new FuramaController();
                controller.displayMainMenu();
                break;
            default:
                System.err.println("Errol! Enter again");
                break;
        }
    }
}
