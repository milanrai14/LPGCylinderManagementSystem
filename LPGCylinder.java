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



}