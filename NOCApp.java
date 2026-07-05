
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
import java.awt.Color;
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

    public boolean isEligibleForSubsidy(String citizenshipNumber, int quantity) {
        boolean validCitizenship = citizenshipNumber != null
                && citizenshipNumber.trim().length() == 12;
        boolean withinQuota = quantity <= 2;
        return validCitizenship && withinQuota;
    }

    public void identifyCylinderType(String cylinderId) {
        for (LPGCylinder cylinder : cylinders) {

            if (cylinder.getCylinderId().equals(cylinderId)) {

                if (cylinder instanceof DomesticCylinder) {
                    JOptionPane.showMessageDialog(this,
                            "Cylinder Type: Domestic Cylinder");
                } else if (cylinder instanceof CommercialCylinder) {
                    JOptionPane.showMessageDialog(this,
                            "Cylinder Type: Commercial Cylinder");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Unknown Cylinder Type");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(this,
                "Cylinder ID not found.");
    }

    public void displayAll() {
        if (cylinders.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No cylinder records found.");
        }

        for (LPGCylinder cylinder : cylinders) {
            cylinder.display();
        }
    }

    public NOCApp() {

        setTitle("LPG Cylinder Booking Management System");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Cylinder Type
        JLabel cylinderTypeLabel = new JLabel("Customer Type:");
        cylinderTypeLabel.setBounds(30, 30, 150, 30);
        add(cylinderTypeLabel);

        String[] cylinderTypes = { "Select One", "Domestic", "Commercial" };
        JComboBox<String> cylinderTypeCombobox = new JComboBox<>(cylinderTypes);
        cylinderTypeCombobox.setBounds(200, 30, 200, 30);
        add(cylinderTypeCombobox);
        // Customer Name
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(30, 80, 180, 30);
        add(customerNameLabel);

        JTextField customerNameField = new JTextField();
        customerNameField.setBounds(200, 80, 200, 30);
        add(customerNameField);

        // Citizenship Number
        JLabel citizenshipLabel = new JLabel("Citizenship Number:");
        citizenshipLabel.setBounds(30, 130, 200, 30);
        add(citizenshipLabel);

        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(200, 130, 200, 30);
        add(citizenshipField);

        // Organization Name
        JLabel organizationLabel = new JLabel("Organization Name:");
        organizationLabel.setBounds(30, 180, 210, 30);
        add(organizationLabel);

        JTextField organizationField = new JTextField();
        organizationField.setBounds(200, 180, 200, 30);
        add(organizationField);

        // Business License Number
        JLabel businessLicenseLabel = new JLabel("Business License Number:");
        businessLicenseLabel.setBounds(30, 230, 230, 30);
        add(businessLicenseLabel);

        JTextField businessLicenseField = new JTextField();
        businessLicenseField.setBounds(200, 230, 200, 30);
        add(businessLicenseField);

        // Booking ID
        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(30, 280, 150, 30);
        add(bookingIdLabel);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(200, 280, 200, 30);
        add(bookingIdField);

        // Month (JComboBox)
        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setBounds(30, 330, 150, 30);
        add(monthLabel);

        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(200, 330, 200, 30);
        add(monthComboBox);

        // Cylinder ID
        JLabel cylinderIdLabel = new JLabel("Cylinder ID:");
        cylinderIdLabel.setBounds(30, 380, 150, 30);
        add(cylinderIdLabel);

        JTextField cylinderIdField = new JTextField();
        cylinderIdField.setBounds(200, 380, 200, 30);
        add(cylinderIdField);

        // Quantity of Ordered Cylinders
        JLabel quantityLabel = new JLabel("Quantity of Order:");
        quantityLabel.setBounds(30, 430, 150, 30);
        add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(200, 430, 200, 30);
        add(quantityField);

        // Weight
        JLabel weightLabel = new JLabel("Weight (Kg):");
        weightLabel.setBounds(30, 480, 150, 30);
        add(weightLabel);

        Double[] weightList = { 14.0, 16.0, 18.0 };
        JComboBox<Double> weightComboBox = new JComboBox<>(weightList);
        weightComboBox.setBounds(200, 480, 200, 30);
        add(weightComboBox);

        // Base Price
        JLabel basePriceLabel = new JLabel("Base Price:");
        basePriceLabel.setBounds(30, 530, 150, 30);
        add(basePriceLabel);

        JTextField basePriceField = new JTextField();
        basePriceField.setBounds(200, 530, 200, 30);
        add(basePriceField);

        // Subsidy Amount (Domestic only)
        JLabel subsidyLabel = new JLabel("Subsidy Amount:");
        subsidyLabel.setBounds(30, 580, 200, 30);
        add(subsidyLabel);

        JTextField subsidyField = new JTextField("0.0");
        subsidyField.setBounds(200, 580, 200, 30);
        add(subsidyField);

        // Adding listner for cylindertypeCombobox for not giving the access for
        // unecessary thing
        cylinderTypeCombobox.addActionListener(e -> {
            String cylinderType = (String) cylinderTypeCombobox.getSelectedItem();
            if ("Domestic".equals(cylinderType)) {
                organizationField.setEditable(false);
                organizationField.setBackground(Color.LIGHT_GRAY);

                businessLicenseField.setEditable(false);
                businessLicenseField.setBackground(Color.LIGHT_GRAY);

                customerNameField.setEditable(true);
                customerNameField.setBackground(Color.WHITE);

                citizenshipField.setEditable(true);
                citizenshipField.setBackground(Color.WHITE);
            } else if ("Commercial".equals(cylinderType)) {
                organizationField.setEditable(true);
                organizationField.setBackground(Color.WHITE);

                businessLicenseField.setEditable(true);
                businessLicenseField.setBackground(Color.WHITE);

                customerNameField.setEditable(false);
                customerNameField.setBackground(Color.LIGHT_GRAY);

                citizenshipField.setEditable(false);
                citizenshipField.setBackground(Color.LIGHT_GRAY);
            } else if ("Select One".equals(cylinderType)) {
                customerNameField.setEditable(true);
                customerNameField.setBackground(Color.WHITE);

                citizenshipField.setEditable(true);
                citizenshipField.setBackground(Color.WHITE);

                organizationField.setEditable(true);
                organizationField.setBackground(Color.WHITE);

                businessLicenseField.setEditable(true);
                businessLicenseField.setBackground(Color.WHITE);

            }
        });

        // Display Area
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(700, 30, 450, 680);
        add(scrollPane);

        // Add Domestic Cylinder
        JButton addDomesticButton = new JButton("Add Domestic Cylinder");
        addDomesticButton.setBounds(460, 30, 200, 35);
        add(addDomesticButton);

        // domestic add button ko lagi addAvtionListner
        addDomesticButton.addActionListener(e -> {

            String cylinderType = (String) cylinderTypeCombobox.getSelectedItem();
            if (!"Domestic".equalsIgnoreCase(cylinderType)) {
                JOptionPane.showMessageDialog(this,
                        "This button is only for Domestic Cylinder!\n" +
                                "Please select 'Domestic' from the dropdown.",
                        "Invalid Cylinder Type",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String customerName = customerNameField.getText().trim();
            String citizenshipNumber = citizenshipField.getText().trim();
            String bookingId = bookingIdField.getText().trim();
            String bookingMonth = (String) monthComboBox.getSelectedItem();
            String cylinderId = cylinderIdField.getText().trim();
            int quantity = Integer.parseInt(quantityField.getText());
            double weight = (Double) weightComboBox.getSelectedItem();
            double basePrice = Double.parseDouble(basePriceField.getText());
            double subsidyAmount = Double.parseDouble(subsidyField.getText());

            if (!customerName.matches("^[A-Za-z]+ [A-Za-z]+$")) {
                JOptionPane.showMessageDialog(this,
                        "Invalid name format. Please enter first and last name.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (citizenshipNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Citizenship number cannot be empty",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (citizenshipNumber.length() != CITIZENSHIP_LENGTH) {
                JOptionPane.showMessageDialog(this,
                        "Citizenship number must be " + CITIZENSHIP_LENGTH + " digits",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!citizenshipNumber.matches("\\d+")) {
                JOptionPane.showMessageDialog(this,
                        "Citizenship number must contain only digits (0-9)",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (LPGCylinder cylinder : cylinders) {
                if (cylinder.getBookingId().equals(bookingId)) {
                    JOptionPane.showMessageDialog(this,
                            "Booking ID already exists. Please use a unique ID.",
                            "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            for (LPGCylinder cylinder : cylinders) {
                if (cylinder.getCylinderId().equals(cylinderId)) {
                    JOptionPane.showMessageDialog(this,
                            "Cylinder ID already exists. Please use a unique ID.",
                            "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (cylinderId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cylinder ID cannot be empty",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!cylinderId.matches("NOC-\\d{3}")) {
                JOptionPane.showMessageDialog(this,
                        "Invalid Cylinder ID format. Use NOC-001",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Quantity must be greater than 0",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (basePrice <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Base Price must be greater than 0",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (subsidyAmount < 0) {
                JOptionPane.showMessageDialog(this,
                        "Subsidy amount cannot be less than 0",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (subsidyAmount > basePrice) {
                JOptionPane.showMessageDialog(this,
                        "Subsidy amount cannot be greater than base price",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isEligibleForSubsidy(citizenshipNumber, quantity)) {
                JOptionPane.showMessageDialog(this,
                        "Customer is not eligible for subsidy.\nSubsidy will be set to 0.",
                        "Not Eligible", JOptionPane.WARNING_MESSAGE);
                subsidyAmount = 0.0;
            }

            DomesticCylinder domestic = new DomesticCylinder(cylinderId, cylinderType, bookingId, basePrice, weight,
                    bookingMonth, customerName, subsidyAmount, citizenshipNumber, quantity);
            cylinders.add(domestic);

            // adding ti text area
            displayArea.setText("Domestic Cylinder Added Successfully!\n\n");
            displayArea.append("Cylinder ID: " + cylinderId + "\n");
            displayArea.append("Customer: " + customerName + "\n");
            displayArea.append("Citizenship: " + citizenshipNumber + "\n");
            displayArea.append("Booking ID: " + bookingId + "\n");
            displayArea.append("Month: " + bookingMonth + "\n");
            displayArea.append("Quantity: " + quantity + "\n");
            displayArea.append("Weight: " + weight + " kg\n");
            displayArea.append("Base Price: Rs " + basePrice + "\n");
            displayArea.append("Subsidy: Rs " + subsidyAmount + "\n");
            displayArea.append("Final Price: Rs " + domestic.calculateFinalPrice() + "\n");
            displayArea.append("\nTotal Cylinders in System: " + cylinders.size());

            customerNameField.setText("");
            citizenshipField.setText("");
            bookingIdField.setText("");
            cylinderIdField.setText("");
            quantityField.setText("");
            basePriceField.setText("");
            subsidyField.setText("0.0");
            cylinderTypeCombobox.setSelectedIndex(0);

            JOptionPane.showMessageDialog(this,
                    "Domestic Cylinder added successfully!\n\n" +
                            "Final Price: Rs " + domestic.calculateFinalPrice(),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        });

        // Add Commercial Cylinder
        JButton addCommercialButton = new JButton("Add Commercial Cylinder");
        addCommercialButton.setBounds(460, 80, 200, 35);
        add(addCommercialButton);

        // commercial cylinder ko lagi addActionListner

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

        // Identifycylinder tpye ko lagi addAction Listner
        identifyTypeButton.addActionListener(e -> {
            String cylinderId = cylinderIdField.getText().trim();

            identifyCylinderType(cylinderId);

        });

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

        // clearbutton ko lagi addActionListner
        clearButton.addActionListener(e -> {
            customerNameField.setText("");
            citizenshipField.setText("");
            organizationField.setText("");
            businessLicenseField.setText("");
            bookingIdField.setText("");
            cylinderIdField.setText("");
            quantityField.setText("");
            basePriceField.setText("");
            subsidyField.setText("0.0");

        
            cylinderTypeCombobox.setSelectedIndex(0);
            monthComboBox.setSelectedIndex(0);
            weightComboBox.setSelectedIndex(0);

            displayArea.setText("");

            
            customerNameField.requestFocus();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new NOCApp();
    }
}