/**
 * An abstract class named LPGCylinder, representing an LPG Cylinder.
 * It provides the structure for all the LPG Cylinder subclasses.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */

public abstract class LPGCylinder{
    private String cylinderId; // Unique identifier of the cylinder
    private String cylinderType; // type of cylinder.
    private String bookingId; // Booking reference ID associated with the cylinder.
    private double basePrice; // Base price of the cylinder.
    private double weight; // Weight of the cylinder in kilograms.


    /**
     * Construct an LPGCylinder objects by initializing its ID, type,
     * booking information, base price, weight, and quantity
     * 
     * @param cylinderId Unique number for the identification of cylinder.
     * @param cylinderType the category of the LPG Cylinder
     * @param bookingId the customer's booking reference number
     * @param basePrice the original price before calculation
     * @param weight the cylinder weight in kilograms     
     */
    public LPGCylinder(String cylinderId, String cylinderType, String bookingId, double basePrice, double weight){
        setCylinderId(cylinderId);
        setCylinderType(cylinderType);
        setBookingId(bookingId);
        setBasePrice(basePrice);
        setWeight(weight);

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
     * Sets the types of LPG Cylinder based on consumer usage.
     * 
     * @param cylinderType the cylinder type to be assigned
     */
    public void setCylinderType(String cylinderType){
        if(cylinderType == null || cylinderType.trim().isEmpty()){
            System.out.println("Cylinder type cannot be empty or null.");
        } else {
            this.cylinderType = cylinderType.trim();
        }

    }

    /**
     * Sets the booking Id of the LPG Cylinder during the booking process.
     * 
     * @param bookingId the unique booking references ID
     */
    public void setBookingId(String bookingId){
        if(bookingId == null || bookingId.trim().isEmpty()){
            System.out.println("Invalid booking ID. Booking ID cannot be null and empty.");
        } else {
            this.bookingId = bookingId;
        }
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

    /**
     * Sets the weight of the LPG Cylinder in kilograms.
     * 
     * @param weight weight of the cylunder.
     */
    public void setWeight(double weight){
        if(weight <= 0){
            System.out.println("Invalid weight. Weight must be greater than 0 kilograms.");
            return;
        }
        this.weight = weight;
    }

    /**
     * Calcualtes the final price of the LPG Cylinder.
     * This method is abstract and must be implemented by subclasses
     * based on their specific pricing rules.
     * 
     * @return the final calculated price of the cylinder.
     */
    public abstract double calculateFinalPrice();

    /**
     * Display the details of the LPG Cylinder.
     * This is an abstract method that must be implemented by subclasses
     * to show cylinder specific information.
     */
    public abstract void display();


}