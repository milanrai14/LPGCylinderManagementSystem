/**
 * NOCApp is the main application class for the Nepal Oil Corporation Cylinder Management System.
 * It provides a command-line interface that allows user to add domestic cylinder
 * commercial cylinder, and diplay all stored cylinder records and calculate and display the final prices.
 * 
 * The application stores all cylinder objects in ArrayList.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
*/
import java.util.ArrayList;
import java.util.Scanner;

public class NOCApp {

    Scanner sc = new Scanner(System.in);
    ArrayList<LPGCylinder> cylinders = new ArrayList<LPGCylinder>();

    public static void main(String[] args) {
        NOCApp app = new NOCApp();
        app.startApplication();
    }

    public void startApplication() {

        int choice;

        do {
            System.out.println("==========================================");
            System.out.println("    Nepal Oil Corporation Management");
            System.out.println("==========================================");
            System.out.println("1. Add Domestic Cylinder");
            System.out.println("2. Add Commercial Cylinder");
            System.out.println("3. Display All Cylinders");
            System.out.println("4. Show Final Prices");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                     addDomesticCylinder();
                     break;
                case 2:
                    addCommercialCylinder();
                    break;
                case 3:
                    displayAllCylinders();
                    break;
                case 4: 
                    showFinalPrices();
                    break;
                case 5:
                    System.out.println("Thank you for using NOC System.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    
    public void addDomesticCylinder() {

        System.out.println("=========== Domestic Cylinder Entry ===========");

        System.out.print("Cylinder ID: ");
        String cylinderId = sc.nextLine();

        System.out.println("Cylinder Type: ");
        String cylinderType = sc.nextLine();

        System.out.print("Booking ID: ");
        String bookingId = sc.nextLine();

        System.out.print("Base Price: ");
        double basePrice = sc.nextDouble();

        System.out.print("Weight: ");
        double weight = sc.nextDouble();
        sc.nextLine();

        System.out.print("Citizenship Number: ");
        String citizenshipNumber = sc.nextLine();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Subsidy Amount: ");
        double subsidyAmount = sc.nextDouble();
        sc.nextLine();

        DomesticCylinder domestic = new DomesticCylinder(cylinderId, cylinderType, bookingId, basePrice, weight, subsidyAmount, citizenshipNumber, quantity
        );

        if(domestic.isValid()){
            cylinders.add(domestic);
            System.out.println("Domestic cylinder added successfully.");
        } else {
            System.out.println("Invalid data type");
        }
    }


    public void addCommercialCylinder() {

        System.out.println("=========== Commercial Cylinder Entry ===========");

        System.out.print("Business License: ");
        String businessLicense = sc.nextLine();

        System.out.print("Cylinder ID: ");
        String cylinderId = sc.nextLine();

        System.out.println("Cylinder Type: ");
        String cylinderType = sc.nextLine();

        System.out.print("Booking ID: ");
        String bookingId = sc.nextLine();

        System.out.print("Base Price: ");
        double basePrice = sc.nextDouble();

        System.out.print("Weight: ");
        double weight = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        CommercialCylinder commercial = new CommercialCylinder(cylinderId, cylinderType, bookingId, basePrice, weight, businessLicense, quantity);

        if(commercial.isValid()){
            cylinders.add(commercial);
            System.out.println("Commercial Cylinder Added Successfully!");
        } else {
            System.out.println("Commercial Cylinder not saved due to invalid data.");
        }
    }


    public void displayAllCylinders() {

        if (cylinders.isEmpty()) {
            System.out.println("No cylinder records found.");
            return;
        }

        for (LPGCylinder cylinder : cylinders) {
            cylinder.display();
            System.out.println();
        }
    }

    
    public void showFinalPrices() {

        if (cylinders.isEmpty()) {
            System.out.println("No cylinder records found.");
            return;
        }

        System.out.println("============= FINAL PRICE REPORT =============");

        for (LPGCylinder cylinder : cylinders) {

            System.out.print("Cylinder ID: " + cylinder.getCylinderId());

            if (cylinder instanceof DomesticCylinder d) {
                System.out.print(" | Type: Domestic");
                System.out.print(" | Citizen: " + d.getCitizenshipNumber());
            }

            if (cylinder instanceof CommercialCylinder c) {
                System.out.print(" | Type: Commercial");
                System.out.print(" | Business: " + c.getBusinessLicense());
            }

            System.out.println(" | Final Price: Rs " + cylinder.calculateFinalPrice());
        }
    }
}