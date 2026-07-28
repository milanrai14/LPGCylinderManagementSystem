/**
 * Child class of LPG Cylinder that represent a Commercial Cylinder
 * for business and commercial purpose.
 * It have commercial discount feature according to the quantity of cylinder
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */
public class CommercialCylinder extends LPGCylinder {
    private String organizationName;
    private String address;
    private String businessLicense;
    private int quantity;
    private double commercialDiscount = 0.0;
    

    /**
     * Initialize a Commerical cylinder with LPG Cylinder and customer details.
     * 
     * @param cylinderId      the unique identifier of the cylinder
     * @param cylinderType    the type of the cylinder
     * @param bookingId       the booking ID assigned to the cylinder
     * @param basePrice       the base price of the commercial cylinder
     * @param weight          the weight of the commercial cylinder in kilograms
     * @param organization    the name of the organization who ordered the cylinder
     * @param address         the address of the organization
     * @param businessLicense the business licecnse of the business or company
     * @param quantity        the number of ordered cylinder
     * 
     */
    public CommercialCylinder(String cylinderId, String cylinderType, String bookingId, double basePrice, String weight,
            String month, String organizationName, String address, String businessLicense, int quantity) {

        super(cylinderId, cylinderType, bookingId, basePrice, weight, month);
        setOrganizationName(organizationName);
        setAddress(address);
        setBusinessLicense(businessLicense);
        setQuantity(quantity);
    }

    // Getter method

    /**
     * Returns the name of the organization
     * 
     * @return the name of organization
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Return the address of the organization
     * 
     * @return address of organization
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the license of business or company
     * 
     * @return the business license
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * Returns the total number of order cylinder
     * 
     * @return the total quantiy of the cylinder
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Retruns the commercial discount according to quantity
     * 
     * @return the commerical discount
     */
    public double getCommercialDiscount() {
        return commercialDiscount;
    }


    // Setter method

    /**
     * Sets the organization name with the validation
     * 
     * @param organizationName
     */
    public void setOrganizationName(String organizationName) {
        if (organizationName == null || organizationName.trim().isEmpty()) {
            System.out.println("Organization name cannot be empty");
            return;
        }
        this.organizationName = organizationName.trim();
    }

    /**
     * sets the address of the organization
     * 
     * @param address
     */
    public void setAddress(String address) {
        if (!address.trim().isEmpty()) {
            this.address = address.trim();
        }
    }

    /**
     * Sets the business license number
     * The license must conaints exactly 6 digits only.
     * 
     * @param businessLicense the business license number to be assigned.
     */
    public void setBusinessLicense(String businessLicense) {
        if (businessLicense != null && businessLicense.matches("^[0-9]{6}$")) {
            this.businessLicense = businessLicense;
        } else {
            System.out.println("Invalid Business License number. format: 6 digits.");
        }
    }

    /**
     * Sets quantity of cylinder ordered.
     * Also updates the total number of cylinders ordered.
     * 
     * @param quantity the number of cylinders to be ordered
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Order must be greater than 0.");
        } else {
            this.quantity = quantity;
        }

    }

    /**
     * Applying commercial discount based on the quantity
     * of cylinders ordered.
     * If quantity is 10 or more, a 5% discount will apply.
     * If quantity is 5 to 9, a 3% discount will apply
     * Otherwise, no discount apply
     */
    public void applyCommercialDiscount() {
        if (this.quantity >= 10) {
            this.commercialDiscount = 0.05; // 5 percent discount
        } else if (this.quantity >= 5) {
            this.commercialDiscount = 0.03; // 3 percent discount
        } else {
            this.commercialDiscount = 0.0;
        }
    }

    /**
     * Checks whether the commercial cylinder object contains
     * valid and complete information.
     *
     * @return true if all required fields contain valid values,
     *         otherwise false
     */

    /**
     * Calculates the final price after applying commercial discount.
     * 
     * @return final price of the order
     */
    @Override
    public double calculateFinalPrice() {
        applyCommercialDiscount();
        double totalPrice = this.quantity * getBasePrice();
        double finalPrice = totalPrice - (totalPrice * this.commercialDiscount);
        return finalPrice;
    }

    /**
     * Displays all details of the commercial cylinder including
     * business information, quantity, discount, and final price.
     * 
     * @return the details of the Commercial Cylinder.
     */
    @Override

    public String display() {
        applyCommercialDiscount();
        double finalPrice = calculateFinalPrice();
        return "===== Commercial Cylinder Details =====\n" +
                "Cylinder ID: " + getCylinderId() + "\n" +
                "Cylinder Type: " + getCylinderType() + "\n" +
                "Booking ID: " + getBookingId() + "\n" +
                "Base Price: Rs " + getBasePrice() + "\n" +
                "Weight: " + getWeight() + " kg\n" +
                "Business License: " + businessLicense + "\n" +
                "Quantity Ordered: " + quantity + "\n" +
                "Commercial Discount: " + (commercialDiscount * 100) + "%\n" +
                "Final Price: Rs " + finalPrice + "\n" +
                "=======================================";
    }

}
