/**
 * Child class of LPG Cylinder that represent a domestic cylinder for the
 * household usage.
 * This class haldles subsidy-related calculations and store
 * the cizizenship information requires for domestic cylinder registration.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */
public class DomesticCylinder extends LPGCylinder {
    private double subsidyAmount;
    private String citizenshipNumber;
    private int quantityOfOrderCylinder; // Number of cylinders ordered.
    private int monthlyUsedCylinder = 0;

    /**
     * Initialize a domestic cylinder with LPG Cylinder and customer details.
     * 
     * @param cylinderId              the unique identifier of the cylinder
     * @param cylinderType            the type of the cylinder
     * @param bookingId               the booking ID assigned to the cylinder
     * @param basePrice               the base price of the domestic cylinder
     * @param weight                  the weight of the domestic cylinder in
     *                                kilograms
     * @param subsidyAmount           the subsidy amount provided for the customer
     * @param citizenshipNumber       the customer's citizenship number
     * @param quantityOfOrderCylinder the number of cylinder ordered
     * @param montlyUsedCylinder      the number of cylinders used in the current
     *                                months
     */
    public DomesticCylinder(String cylinderId, String cylinderType, String bookingId, double basePrice, double weight,
            String subsidyAmount, String citizenshipNumber, int quantityOfOrderCylinder, int monthlyUsedCylinder) {
        super(cylinderId, cylinderType, bookingId, basePrice, weight);
    }

    // Getter methods

    /**
     * Retruns the subsidy amount
     * 
     * @return the subsidy amount
     */
    public double getSubsidyAmount() {
        return subsidyAmount;
    }

    /**
     * Return the citizenship number of customer
     * 
     * @return the citizenship number of customer
     */
    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    /**
     * Return the number of cylinder ordered by customer
     * 
     * @return quantity of ordered cylinder
     */
    public int getQuantityOfOrderedCylinder() {
        return quantityOfOrderCylinder;
    }

    /**
     * Returns the total cylinder used in a month
     * 
     * @return the total cylinder used in a month
     */
    public int getMonthlyUsedCylinder() {
        return monthlyUsedCylinder;
    }

    // Setter method

    /**
     * Sets the subsidy amount for the domestic cyclinder if 
     * customer is eligible
     * 
     * @param subsidyAmount the subsidy amount to be asigned
     */
    public void setSubsidyAmount(double subsidyAmount) {
        if (subsidyAmount < 0) {
            System.out.println("Subsidy amount cannot be less than 0.");

        } else if(!isEligibleForSubsidy()){
            System.out.println("Customer is not eligble for subsidy.");
            return;
        } else {
            this.subsidyAmount = subsidyAmount;
        }
    }

    /**
     * Sets citizenship number of the customer
     * The citizenship number must not be null, empty,
     * and must contian exactly 12 characters.
     * 
     * @param citizenshipNumber the citizenship number to be assigned
     * 
     */
    public void setCitizenshipNumber(String citizenshipNumber) {
        if (citizenshipNumber == null || citizenshipNumber.trim().isEmpty()) {
            System.out.println("Citizenship cannit be empty!");
        } else if (citizenshipNumber.length() != 12) {
            System.out.println("Citizenship number must be exactly 12 characters.");
        } else {
            this.citizenshipNumber = citizenshipNumber.trim();

        }
    }
    /**
     * Checks whether the customer is eligible for a subsidy
     * A customer is eligible if they have a valid citizenship number
     * and have used no more than 2 cylinder in a month.
     * 
     * @return true if the customer is eligible for a subsidy, otherwise fasle
     */
    public boolean isEligibleForSubsidy() {
        boolean validCitizenship = this.citizenshipNumber != null
                && citizenshipNumber.trim().length() == 12;
        boolean withInQuota = this.monthlyUsedCylinder <= 2;
        return validCitizenship && withInQuota;
    }
}
