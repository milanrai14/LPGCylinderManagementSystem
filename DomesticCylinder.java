/**
 * Child class of LPG Cylinder that represent a domestic cylinder for the household usage.
 * This class haldles subsidy-related calculations and store 
 * the cizizenship information requires for domestic cylinder registration.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */
public class DomesticCylinder extends LPGCylinder {
    private double subsidyAmount;
    private String citizenshipNumber;
    private int quantityOfOrderCylinder; //Number of cylinders ordered.
    private int monthlyUsedCylinder = 0;

    /**
     * Initialize a domestic cylinder with LPG Cylinder and customer details.
     * 
     * @param cylinderId the unique identifier of the cylinder
     * @param cylinderType the type of the cylinder
     * @param bookingId the booking ID assigned to the cylinder
     * @param basePrice the base price of the domestic cylinder
     * @param weight the weight of the domestic cylinder in kilograms
     * @param subsidyAmount the subsidy amount provided for the customer
     * @param citizenshipNumber the customer's citizenship number
     * @param quantityOfOrderCylinder the number of cylinder ordered
     * @param montlyUsedCylinder the number of cylinders used in the current months
     */
    public DomesticCylinder(String cylinderId, String cylinderType, String bookingId, double basePrice, double weight, String subsidyAmount, String citizenshipNumber, int quantityOfOrderCylinder, int monthlyUsedCylinder ){
        super(cylinderId, cylinderType, bookingId, basePrice, weight);
    }

    //Getter methods

    /**
     * Retruns the subsidy amount
     * 
     * @return the subsidy amount
     */
    public double getSubsidyAmount(){
        return subsidyAmount;
    }

    /**
     * Return the citizenship number of customer
     * 
     * @return the citizenship number of customer
     */
    public String getCitizenshipNumber(){
        return citizenshipNumber;
    }

    /**
     * Return the number of cylinder ordered by customer
     * 
     * @return quantity of ordered cylinder
     */
    public int getQuantityOfOrderedCylinder(){
        return quantityOfOrderCylinder;
    }

    /**
     * Returns the total cylinder used in a month
     * 
     * @return the total cylinder used in a month
     */
    public int getMonthlyUsedCylinder(){
        return monthlyUsedCylinder;
    }

    //Setter method
    
    /**
     * Sets the subsidy amount for the domestic cyclinder
     * Subsidy is only allowed if the customer has valid 
     * citienship number and a monthly usage of no more than
     * two cylinders.
     * 
     * @param subsidyAmount the subsidy amount to be asigned
     */
    public void setSubsidyAmount(double subsidyAmount){
        if(subsidyAmount <= 0){
            System.out.println("Subsidy amoun must be greater than ");
            return;
        }
        if(this.citizenshipNumber == null  || this.citizenshipNumber.trim().isEmpty() || this.monthlyUsedCylinder > 2 ){
            System.out.println("Subsidy not allowed");
        } else {
            this.subsidyAmount = subsidyAmount;
        }

    }
    
}
