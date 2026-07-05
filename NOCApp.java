
/**
 * NOCApp is the main GUI application for the Nepal Oil Corporation Cylinder Management System.
 * It provides a graphical interface for managing LPG cylinder bookings including
 * adding domestic/commercial cylinders, calculating discounts and subsidies,
 * displaying records, and file operations.
 * 
 * All cylinder records are stored in an ArrayList collection.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NOCApp extends JFrame {
    final int CITIZENSHIP_LENGTH = 12;
    ArrayList<LPGCylinder> cylinders = new ArrayList<LPGCylinder>();
    // Add this method to NOCApp class
private boolean isEligibleForSubsidy(String citizenshipNumber, int quantity) {
    boolean validCitizenship = citizenshipNumber != null 
            && citizenshipNumber.trim().length() == 12;
    boolean withinQuota = quantity <= 2; // Assuming first order of the month
    return validCitizenship && withinQuota;
}

    public NOCApp() {

        setTitle("LPG Cylinder Booking Management System");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // customer type
        JLabel cylinderTypeLabel = new JLabel("Customer Type:");
        cylinderTypeLabel.setBounds(30, 30, 150, 30);
        add(cylinderTypeLabel);

        String[] cylinderTypes = { "Select One", "Domestic", "Commercial" };
        JComboBox<String> cylinderTypeCombobox = new JComboBox<>(cylinderTypes);
        cylinderTypeCombobox.setBounds(200, 30, 200, 30);
        add(cylinderTypeCombobox);

        // Customer Name (Domestic only)
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(30, 130, 180, 30);
        add(customerNameLabel);

        JTextField customerNameField = new JTextField();
        customerNameField.setBounds(200, 130, 200, 30);
        add(customerNameField);

        // Citizenship Number (Domestic only)
        JLabel citizenshipLabel = new JLabel("Citizenship Number:");
        citizenshipLabel.setBounds(30, 180, 200, 30);
        add(citizenshipLabel);

        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(200, 180, 200, 30);
        add(citizenshipField);

        // Organization Name (Commercial only)
        JLabel organizationLabel = new JLabel("Organization Name:");
        organizationLabel.setBounds(30, 230, 210, 30);
        add(organizationLabel);

        JTextField organizationField = new JTextField();
        organizationField.setBounds(200, 230, 200, 30);
        add(organizationField);

        // Business License Number (Commercial only)
        JLabel businessLabel = new JLabel("Business License Number:");
        businessLabel.setBounds(30, 280, 230, 30);
        add(businessLabel);

        JTextField businessField = new JTextField();
        businessField.setBounds(200, 280, 200, 30);
        add(businessField);

        // Booking ID
        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(30, 330, 150, 30);
        add(bookingIdLabel);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(200, 330, 200, 30);
        add(bookingIdField);

        // Month (JComboBox)
        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setBounds(30, 380, 150, 30);
        add(monthLabel);

        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(200, 380, 200, 30);
        add(monthComboBox);

        // Cylinder ID
        JLabel cylinderIdLabel = new JLabel("Cylinder ID:");
        cylinderIdLabel.setBounds(30, 430, 150, 30);
        add(cylinderIdLabel);

        JTextField cylinderIdField = new JTextField();
        cylinderIdField.setBounds(200, 430, 200, 30);
        add(cylinderIdField);

        // Quantity of Ordered Cylinders
        JLabel quantityLabel = new JLabel("Quantity of Order:");
        quantityLabel.setBounds(30, 480, 150, 30);
        add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(200, 480, 200, 30);
        add(quantityField);

        // Weight
        JLabel weightLabel = new JLabel("Weight (Kg):");
        weightLabel.setBounds(30, 530, 150, 30);
        add(weightLabel);

        String[] weightList = { "14 kg", "16 Kg", "18 Kg" };
        JComboBox<String> weightComboBox = new JComboBox<>(weightList);
        weightComboBox.setBounds(200, 530, 200, 30);
        add(weightComboBox);

        // Base Price
        JLabel basePriceLabel = new JLabel("Base Price:");
        basePriceLabel.setBounds(30, 580, 150, 30);
        add(basePriceLabel);

        JTextField basePriceField = new JTextField();
        basePriceField.setBounds(200, 580, 200, 30);
        add(basePriceField);

        // Subsidy Amount (Domestic only)
        JLabel subsidyLabel = new JLabel("Subsidy Amount:");
        subsidyLabel.setBounds(30, 630, 200, 30);
        add(subsidyLabel);

        JTextField subsidyField = new JTextField("0.0");
        subsidyField.setBounds(200, 630, 200, 30);
        add(subsidyField);

        // Add Domestic Cylinder
        JButton addDomesticButton = new JButton("Add Domestic Cylinder");
        addDomesticButton.setBounds(460, 30, 200, 35);
        add(addDomesticButton);
        

        // Listener register for adding domesticCylinder using lamda expression
        addDomesticButton.addActionListener(e -> {
            String cylinderType = (String) cylinderTypeCombobox.getSelectedItem();
            System.out.println(cylinderType);
            String customerName = customerNameField.getText();
            System.out.println(customerName);
            String citizenshipNumber = citizenshipField.getText();
            System.out.println(citizenshipNumber);
            String bookingId = bookingIdField.getText();
            System.out.println(bookingId);
            String bookingMonth = (String) monthComboBox.getSelectedItem();
            System.out.println(bookingMonth);
            String cylinderId = cylinderIdField.getText();
            System.out.println(cylinderId);
            int quantity = Integer.parseInt(quantityField.getText());
            System.out.println(quantity);
            String weight = (String) weightComboBox.getSelectedItem();
            System.out.println(weight);
            double basePrice = Double.parseDouble(basePriceField.getText());
            System.out.println(basePrice);
            double subsidyAmount = Double.parseDouble(subsidyField.getText());
            System.out.println(subsidyAmount);

            if (!"Domestic".equals(cylinderType)) {
                JOptionPane.showMessageDialog(this,
                        "This button is only for Domestic Cylinder!\n" +
                                "Please select 'Domestic' from the dropdown.",
                        "Invalid Cylinder Type",
                        JOptionPane.ERROR_MESSAGE);
                return;

            }
            if (!customerName.matches("^[A-Za-z]+ [A-Za-z]+$")) {
                System.out.println("Invalid name format. Please enter first and last name.");
                return;
            }

            if (citizenshipNumber == null || citizenshipNumber.trim().isEmpty()) {
                System.out.println("Cannot be null");
            } else if (citizenshipNumber.length() != CITIZENSHIP_LENGTH) {
                System.out.println("Citizenship number must be " + CITIZENSHIP_LENGTH + " digits");
            } else if (!citizenshipNumber.matches("\\d+")) {
                System.out.println("Citizenship number must contain only digits (0-9)");
            } else {
                System.out.println("Valid citizenship number");
            }

            for (LPGCylinder cylinder : cylinders) {
                if (cylinder.getBookingId().equals(bookingId)) {
                    System.out.println("Booking ID already exists. Please use a unique ID.");
                    return;
                }

            }

            for(LPGCylinder cylinder: cylinders){
                if(cylinder.getCylinderId().equals(cylinderId)){
                    System.out.println("Cylinder ID already exists. Please use a unique ID.");
                    return;
                }
            }

            if (cylinderId == null || cylinderId.trim().isEmpty()) {
                System.out.println("Cylinder ID cannot be null or empty");
            } else if (!cylinderId.matches("NOC-\\d{3}")) {
                System.out.println("Invalid Cylinder ID format. Use NOC-001");
            }

            if(quantity <= 0){
                System.out.println("Quantity cannot be less than or equal to 0");
                return;
            }

            if(basePrice <= 0){
                System.out.println("Base Price must be greater than 0'");
                return;
            }


            

            if( subsidyAmount <= 0){
                System.out.println("Subsidy amount cannot be less than 0.");
            } else if (subsidyAmount > basePrice){
                System.out.println("Subsidy amount cannot be greater than base price");
            }

            if(!isEligibleForSubsidy(citizenshipNumber, quantity)){
                System.out.println("No eligible for subsidy admount");
                subsidyAmount = 0.0;
                return;
            }

            DomesticCylinder domestic = new DomesticCylinder(cylinderId, cylinderType, bookingId, basePrice, weight, bookingMonth, customerName, subsidyAmount, citizenshipNumber, quantity);
            cylinders.add(domestic);
            

        });

        // Add Commercial Cylinder
        JButton addCommercialButton = new JButton("Add Commercial Cylinder");
        addCommercialButton.setBounds(460, 80, 200, 35);
        add(addCommercialButton);

        // Calculate Bulk Discount
        JButton calculateDiscountButton = new JButton("Calculate Bulk Discount");
        calculateDiscountButton.setBounds(460, 130, 200, 35);
        add(calculateDiscountButton);

        // Calculate Price after Subsidy
        JButton calculatePriceButton = new JButton("Calculate Price after Subsidy");
        calculatePriceButton.setBounds(460, 180, 200, 35);
        add(calculatePriceButton);

        // Identify Cylinder Type
        JButton identifyTypeButton = new JButton("Identify Cylinder Type");
        identifyTypeButton.setBounds(460, 230, 200, 35);
        add(identifyTypeButton);

        // Display All
        JButton displayAllButton = new JButton("Display All");
        displayAllButton.setBounds(460, 280, 200, 35);
        add(displayAllButton);

        // Export to File
        JButton exportButton = new JButton("Export to File");
        exportButton.setBounds(460, 330, 200, 35);
        add(exportButton);

        // Load From File
        JButton loadButton = new JButton("Load From File");
        loadButton.setBounds(460, 380, 200, 35);
        add(loadButton);

        // Clear
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(460, 430, 200, 35);
        add(clearButton);

        // Display Area
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(700, 30, 450, 680);
        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new NOCApp();
    }
}