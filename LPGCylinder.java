/**
 * An abstract class named LPGCylinder, representing an LPG Cylinder.
 * It provides the structure for all the LPG Cylinder subclasses.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */

public abstract class LPGCylinder{
    private String cylinderId;
    private String cylinderType;
    private String bookingId;
    private double basePrice;
    private double weight;
    private int quantity;

    /**
     * Construct an LPGCylinder objects by initializing its ID, type,
     * booking information, base price, weight, and quantity
     * 
     * @param cylinderId Unique number for the identification of cylinder.
     * @param cylinderType the category of the LPG Cylinder
     * @param bookingId the customer's booking reference number
     * @param basePrice the original price before calculation
     * @param weight the cylinder weight in kilograms
     * @param quantity the number of LPG Cylinder booked
     * 
     * 
     */
    public LPGCylinder(String cylinderId, String cylinderType, String bookingId, double basePrice, double weight, int quantity){
        setCylinderId(cylinderId);

    }

    //Getter methods

    /**
     * Returns the cylinder ID
     * 
     * @return the cylinder ID
     */
    public String getCylinderId(){
        return cylinderId;
    }

    /**
     * Returns the booking ID
     * 
     * @return the booking ID
     */
    public String getBookingId(){
        return bookingId;
    }

    /**
     * Returns the cylinder type
     * 
     * @return the cylinder type
     */
    public String getCylinderType(){
        return cylinderType;
    }

    /**
     * Returns the base price of the LPG Cylinder
     * 
     * @return the base price
     */
    public double getBasePrice(){
        return basePrice;
    }

    /**
     * Returns the weight of the LPG Cylinder
     * 
     * @return the weight
     */
    public double getWeight(){
        return weight;
    }

    /**
     * Returns the quantity of booked LPG Cylinder.
     * 
     * @return the quantity of booked LPG Cylinder
     */
    public int getQuantity(){
        return quantity;
    }

    //Setter methods

    /**
     * Sets the unique ID for the LPG Cylinder with validation
     * The cylinder ID must follow format "NOC-001"
     * 
     * @param cylinderId the cylinder ID to be assigned
     */
    public void setCylinderId(String cylinderId){
        if(cylinderId == null || cylinderId.trim().isEmpty()){
            System.out.println("Cylinder ID cannot be null or empty");
        } else if (!cylinderId.matches("NOC-\\d{3}")){
            System.out.println("Invalid Cylinder ID format. Use NOC-001");
        } else {
            this.cylinderId = cylinderId;
        }
    }

    /**
     * Sets the types of LPG Cylinder based on customer usage.
     * Only "Domestic" or "Commercial" cylinder types are allowed.
     * 
     * @param cylinderType the cylinder type to be assigned
     */
    public void setCylinderType(String cylinderType){
        if(cylinderType == null || cylinderType.trim().isEmpty()){
            System.out.println("Cylinder type cannot be empty or null.");
            return;
        }
        cylinderType = cylinderType.trim();

        if(!cylinderType.equalsIgnoreCase("Domestic") && !cylinderType.equalsIgnoreCase("Commercial")){
            System.out.println("Invalid cylinder type. Allowed only: Domestic, Commerical");
            return;
        }
        this.cylinderId = cylinderType;

    }

    /**
     * Sets the base price of the LPG cylinder before calculation.
     * 
     * @param basePrice the original price before calculation
     */
    public void setBasePrice(double basePrice){
        if(basePrice <= 0){
            System.out.println("Base price must be greater than 0");
        } else {
            this.basePrice = basePrice;
        }
    }



}