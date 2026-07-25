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
    private String customerName;
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
     * @param month                   the month of ordered cylinder
     * @param customerName            name of the customer who ordered the cylinder
     * @param subsidyAmount           the subsidy amount provided for the customer
     * @param citizenshipNumber       the customer's citizenship number
     * @param quantityOfOrderCylinder the number of cylinder ordered
     * 
     */
    public DomesticCylinder(String cylinderId, String cylinderType, String bookingId, double basePrice, String weight, String month, String customerName, double subsidyAmount, String citizenshipNumber, int quantityOfOrderCylinder) {
        super(cylinderId, cylinderType, bookingId, basePrice, weight, month);
        setCustomerName(customerName);
        setCitizenshipNumber(citizenshipNumber);
        setQuantityOfOrderCylinder(quantityOfOrderCylinder);
        setSubsidyAmount(subsidyAmount);
    }

    // Getter methods
    /**
     * Returns the name of customer
     * 
     * @return the name of customer
     */
    public String getCustomerName() {
        return customerName;
    }

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
    public int getQuantityOfOrderCylinder() {
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
     * Sets the customer name.
     * 
     * @param customerName The name of the customer
     */
    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty");
        } else {
            this.customerName = customerName;
        }
    }

    /**
     * Sets the subsidy amount for the domestic cyclinder if customer is
     * eligible
     *
     * @param subsidyAmount the subsidy amount to be asigned
     */
    public void setSubsidyAmount(double subsidyAmount) {
        if (subsidyAmount < 0) {
            System.out.println("Subsidy amount cannot be less than 0.");

        } else if (subsidyAmount > getBasePrice()) {
            System.out.println("Subsidy amount cannot be greater than base price.");

        } else if (!isEligibleForSubsidy()) {
            System.out.println("Customer is not eligble for subsidy.");
        } else {
            this.subsidyAmount = subsidyAmount;
        }
    }

    /**
     * Sets citizenship number of the customer The citizenship number must not
     * be null, empty, and must contian exactly 12 characters.
     *
     * @param citizenshipNumber the citizenship number to be assigned
     *
     */
    public void setCitizenshipNumber(String citizenshipNumber) {
        if (citizenshipNumber == null || citizenshipNumber.trim().isEmpty()) {
            System.out.println("Citizenship cannit be empty!");
        } else if (citizenshipNumber.trim().length() != 12) {
            System.out.println("Citizenship number must be exactly 12 characters.");
        } else {
            this.citizenshipNumber = citizenshipNumber.trim();

        }
    }

    /**
     * sets the quantity of cylinders ordered. Also updates monthly usage and
     * also ensures that a customer cannot order more than 2 cylinders per
     * month.
     *
     * @param quantityOfOrderCylinder number of cylinders being order
     */
    public void setQuantityOfOrderCylinder(int quantityOfOrderCylinder) {
        if (quantityOfOrderCylinder <= 0) {
            System.out.println("Order must be at least 1 cylinder.");
            return;
        }

        if (this.monthlyUsedCylinder + quantityOfOrderCylinder > 2) {
            System.out.println("Cannot exceed more than 2 cylinders per month");
            return;
        }
        this.quantityOfOrderCylinder = quantityOfOrderCylinder;
        this.monthlyUsedCylinder += quantityOfOrderCylinder;
    }

    /**
     * Checks whether the customer is eligible for a subsidy A customer is
     * eligible if they have a valid citizenship number and have used no more
     * than 2 cylinder in a month.
     *
     * @return true if the customer is eligible for a subsidy, otherwise fasle
     */
    public boolean isEligibleForSubsidy() {
        boolean validCitizenship = this.citizenshipNumber != null
                && citizenshipNumber.trim().length() == 12;
        boolean withInQuota = this.monthlyUsedCylinder <= 2;
        return validCitizenship && withInQuota;
    }

    /**
     * validates whether the domestic cylinder contains all
     * required and valid information
     * 
     * @return true if the domestic cylinder contains valid data, otherwise false.
     */

    /**
     * Calculate the final price of the domestic cylinder. If the customer is
     * eligible for subsidy, a discount is applied, otherwise not applied.
     *
     * @return final price after applying quantity and subsidy rules.
     */
    @Override
    public double calculateFinalPrice() {
        double totalPrice = getBasePrice() * this.quantityOfOrderCylinder;

        if (isEligibleForSubsidy()) {
            totalPrice = totalPrice - this.subsidyAmount;
        }
        return totalPrice;
    }

    /**
     * Display all the details of the domestic cylinder
     */
    @Override
    public String display() {
        return "===== Domestic Cylinder Details =====\n" +
                "Cylinder ID: " + getCylinderId() + "\n" +
                "Cylinder Type: " + getCylinderType() + "\n" +
                "Booking ID: " + getBookingId() + "\n" +
                "Base Price: " + getBasePrice() + "\n" +
                "Weight: " + getWeight() + " kg\n" +
                "Citizenship Number: " + citizenshipNumber + "\n" +
                "Quantity Ordered: " + quantityOfOrderCylinder + "\n" +
                "Monthly Usage: " + monthlyUsedCylinder + "\n" +
                "Eligible for Subsidy: " + isEligibleForSubsidy() + "\n" +
                "Subsidy Amount: Rs " + subsidyAmount + "\n" +
                "Final Price: Rs " + calculateFinalPrice() + "\n" +
                "=====================================";
    }
}
