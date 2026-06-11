/**
 * Child class of LPG Cylinder that represent a Commercial Cylinder
 * for business and commercial purpose.
 * It have commercial discount feature according to the quantity of cylinder
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */
public class CommercialCylinder extends LPGCylinder {
    private String businessLicense;
    private int quantity;
    private double commercialDiscount;

    /**
     * Initialize a Commerical cylinder with LPG Cylinder and customer details.
     *
     * @param cylinderId      the unique identifier of the cylinder
     * @param cylinderType    the type of the cylinder
     * @param bookingId       the booking ID assigned to the cylinder
     * @param basePrice       the base price of the commercial cylinder
     * @param weight          the weight of the commercial cylinder in kilograms
     * @param businessLicense the business licecnse of the business or company
     * @param quantity        the number of ordered cylinder
     */
    public CommercialCylinder(String cylinderId, String cylinderType,
            String bookingId, double basePrice, double weight,
            String businessLicense, int quantity) {

        super(cylinderId, cylinderType, bookingId, basePrice, weight);

        this.businessLicense = businessLicense;
        this.quantity = quantity;
    }

    //Getter method

    /**
     * Returns the license of business or company
     * 
     * @return the business license
     */
    public String getBusinessLicense(){
        return businessLicense;
    }

    /**
     * Returns the total number of order cylinder
     * 
     * @return the total quantiy of the cylinder
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Retruns the commercial discount according to quantity
     * 
     * @return the commerical discount
     */
    public double getCommercialDiscount(){
        return commercialDiscount;
    }
    

    //Setter method

    /**
     * Sets the business license number 
     * The license must conaints exactly 6 digits only.
     * 
     * @param businessLicense the business license number to be assigned.
     */
    public void setBusinessLicense(String businessLicense){
        if (businessLicense != null && businessLicense.matches("^[0-9]{6}$")){
            this.businessLicense = businessLicense;
        } else {
            System.out.println("Invalid Business License number. format: 6 digits.");
        }
    }

}
