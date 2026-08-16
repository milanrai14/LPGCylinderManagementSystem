import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * This GUI application manages LPG cylinder bookings for both domestic and
 * commerical customers.
 * It provides functionality for adding cylinders, applying discounts, and
 * displaying records.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
 */

public class NOCApp extends JFrame {
        /** The standard length for citizenship numbers */
        final int CITIZENSHIP_LENGTH = 12;
        /** ArrayList to store domestic and commerical cylinders records. */
        ArrayList<LPGCylinder> cylinders = new ArrayList<LPGCylinder>();

        /**
         * Validates cylinder ID and booking ID for uniqueness and format compliance
         * 
         * @param cylinderId The cylidner ID to validate
         * @param bookingId  The booking ID to validate
         * @return true if both IDs are valid and unique, otherwise false.
         */
        public boolean validateCylinderAndBookingIds(String cylinderId, String bookingId) {
                if (cylinderId == null || cylinderId.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Cylinder Id cannot be empty");
                        return false;
                }
                if (!cylinderId.matches("NOC-\\d{3}")) {
                        JOptionPane.showMessageDialog(this, "Invalid Cylinder ID Format. Use NOC-000 Format");
                        return false;
                }
                // Check for duplicate cylinder ID
                for (LPGCylinder cylinder : cylinders) {
                        if (cylinder.getCylinderId().equals(cylinderId)) {
                                JOptionPane.showMessageDialog(this,
                                                "Cylinder ID already exists. Please use a unique ID.",
                                                "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return false;
                        }
                }
                // Check for duplicate booking ID
                for (LPGCylinder cylinder : cylinders) {
                        if (cylinder.getBookingId().equals(bookingId)) {
                                JOptionPane.showMessageDialog(this,
                                                "Booking Id already exists. Please use a unique ID.",
                                                "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return false;
                        }
                }
                return true;
        }

        /**
         * Validates that quantity and base price are positive values.
         * 
         * @param quantity  The quantity of the cylinder
         * @param basePrice The base price per cylinder
         * @return true if both values are valid, otherwise false
         */

        public boolean validateQuantityAndBasePrice(int quantity, double basePrice) {
                if (quantity <= 0) {
                        JOptionPane.showMessageDialog(this, "Quantity must be greater than 0", "Validation Error",
                                        JOptionPane.ERROR_MESSAGE);
                        return false;
                }
                if (basePrice <= 0) {
                        JOptionPane.showMessageDialog(this, "Base Price must be greater than 0", "Validation Error",
                                        JOptionPane.ERROR_MESSAGE);
                        return false;
                }
                return true;
        }

        /**
         * Determines if a customer is eligible for subsidy based on citizenship and
         * quantity.
         * 
         * @param cizitenshipNumber The customer's citizenship number
         * @param quantity          The quantity of cylinders ordered
         * @return true if customer is eligible for subsidy, otherwise false
         */
        public boolean isEligibleForSubsidy(String cizitenshipNumber, int quantity) {
                boolean validCitizenship = cizitenshipNumber != null
                                && cizitenshipNumber.trim().length() == CITIZENSHIP_LENGTH;
                boolean withInQuota = quantity <= 2;
                return validCitizenship && withInQuota;
        }

        /**
         * Identifies and displays the type of cylinder for entered cylinder ID.
         * 
         * @param cylinderId
         */
        public void identifyCylinderType(String cylinderId) {
                for (LPGCylinder cylinder : cylinders) {
                        System.out.println("Cylinder ID: " + cylinderId);
                        if (cylinder.getCylinderId().equals(cylinderId)) {
                                if (cylinder instanceof DomesticCylinder) {
                                        JOptionPane.showMessageDialog(this, "Cylinder Type: Domestic Cylinder");
                                } else {
                                        JOptionPane.showMessageDialog(this, "Cylinder Type: Commercial Cylinder");
                                }
                                return;
                        }
                }

                JOptionPane.showMessageDialog(this, "No cylinder with that Cylinder ID.");
        }

        /**
         * Applies bulk discount to a commerical cylinder and displays the Discounted
         * price.
         * 
         * @param cylinderId The cylinder ID to apply bulk discount
         */

        public void bulkDiscount(String cylinderId) {
                for (LPGCylinder cylinder : cylinders) {
                        if (cylinder.getCylinderId().equals(cylinderId)) {
                                if (cylinder instanceof CommercialCylinder) {
                                        CommercialCylinder commerical = (CommercialCylinder) cylinder;
                                        commerical.applyCommercialDiscount();
                                        double totalPrice = commerical.getBasePrice() * commerical.getQuantity();
                                        double discountAmount = totalPrice * commerical.getCommercialDiscount();
                                        JOptionPane.showMessageDialog(this,
                                                        "Organization Name: " + commerical.getOrganizationName() + "\n"
                                                                        + "Total Qunaity: " + commerical.getQuantity()
                                                                        + "\n" + "Discount Amount : Rs "
                                                                        + discountAmount + "\n" + "Final price: Rs "
                                                                        + commerical.calculateFinalPrice(),
                                                        "Bulk Discount", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                        JOptionPane.showMessageDialog(this,
                                                        "This cylinder is not a commercial cylinder.",
                                                        "Ivalid Cylinder ID", JOptionPane.INFORMATION_MESSAGE);
                                }
                                return;
                        }
                }
                JOptionPane.showMessageDialog(this, "No Cylinder with this cylinder Id", "NO cylinder ID",
                                JOptionPane.ERROR_MESSAGE);
        }

        /**
         * Displays subsidy discount details for a domestic cylinder.
         * 
         * @param cylindeId The cylinder ID to apply subsidy amount
         */
        public void subsidyDiscount(String cylindeId) {
                for (LPGCylinder cylinder : cylinders) {
                        if (cylinder instanceof DomesticCylinder) {
                                DomesticCylinder domestic = (DomesticCylinder) cylinder;
                                JOptionPane.showMessageDialog(this, "Customer Name: " + domestic.getCustomerName()
                                                + "\n" + "Total Quanity: " + domestic.getQuantityOfOrderCylinder()
                                                + "\n" + "Discount Amount: " + domestic.getSubsidyAmount() + "\n"
                                                + "Final Price: " + domestic.calculateFinalPrice());

                        } else {
                                JOptionPane.showMessageDialog(this, "This cylinder Id is not domestic cylinder");
                        }
                        return;
                }
                JOptionPane.showMessageDialog(this, "No cylinder with this cylinder Id.");

        }

        /**
         * Checks if a cylinder ID is null or empty
         * 
         * @param cylinderId The cylinder ID to check
         * @return true if the ID is null or empty, false otherwise
         */

        public boolean isCylinderIdEmpty(String cylinderId) {
                if (cylinderId.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Cylinder ID Cannot be Null or empty");
                        return true;
                }
                return false;
        }

        /**
         * Constructor of NOCApp.
         * Initializes the GUI components, sets uop event listners, and displays the
         * application window.
         */
        public NOCApp() {
                setTitle("Nepal Oil Corporation Management System");
                setSize(1000, 820);
                setLocationRelativeTo(null);
                getRootPane().setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3),
                                "Nepal Oil Corporation Management System", TitledBorder.CENTER, TitledBorder.TOP));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);
                setResizable(false);

                /**
                 * Creating JPanel, which contains all components related to domestic cylinder
                 * management, including input fields, action buttons.
                 */
                JPanel domesticPanel = new JPanel();
                domesticPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
                                "Domestic Cylinder Booking", TitledBorder.CENTER, TitledBorder.TOP));
                domesticPanel.setLayout(null);
                domesticPanel.setBounds(20, 10, 450, 430);
                add(domesticPanel);

                // Customer Type Lable and ComboBox
                JLabel domCustTypeLabel = new JLabel("Customer Type:");
                domCustTypeLabel.setBounds(20, 30, 140, 25);
                domesticPanel.add(domCustTypeLabel);
                String[] customerTypes = { "Select One", "Domestic", "Commercial" };
                JComboBox<String> domCustTypeCombo = new JComboBox<>(customerTypes);
                domCustTypeCombo.setBounds(170, 30, 230, 25);
                domesticPanel.add(domCustTypeCombo);

                // Customer Name
                JLabel domNameLabel = new JLabel("Customer Name:");
                domNameLabel.setBounds(20, 65, 140, 25);
                domesticPanel.add(domNameLabel);
                JTextField domNameField = new JTextField();
                domNameField.setBounds(170, 65, 230, 25);
                domesticPanel.add(domNameField);

                // Citizenship Number
                JLabel domCitizenshipLabel = new JLabel("Citizenship Number:");
                domCitizenshipLabel.setBounds(20, 100, 140, 25);
                domesticPanel.add(domCitizenshipLabel);
                JTextField domCitizenshipField = new JTextField();
                domCitizenshipField.setBounds(170, 100, 230, 25);
                domesticPanel.add(domCitizenshipField);

                // Booking ID
                JLabel domBookingLabel = new JLabel("Booking ID:");
                domBookingLabel.setBounds(20, 135, 140, 25);
                domesticPanel.add(domBookingLabel);
                JTextField domBookingField = new JTextField();
                domBookingField.setBounds(170, 135, 230, 25);
                domesticPanel.add(domBookingField);

                // Month Selection
                JLabel domMonthLabel = new JLabel("Month:");
                domMonthLabel.setBounds(20, 170, 140, 25);
                domesticPanel.add(domMonthLabel);
                String[] months = { "January", "February", "March", "April", "May", "June",
                                "July", "August", "September", "October", "November", "December" };
                JComboBox<String> domMonthCombo = new JComboBox<>(months);
                domMonthCombo.setBounds(170, 170, 230, 25);
                domesticPanel.add(domMonthCombo);

                // Cylinder ID
                JLabel domCylinderLabel = new JLabel("Cylinder ID:");
                domCylinderLabel.setBounds(20, 205, 140, 25);
                domesticPanel.add(domCylinderLabel);
                JTextField domCylinderField = new JTextField();
                domCylinderField.setBounds(170, 205, 230, 25);
                domesticPanel.add(domCylinderField);

                // Quantity of Order
                JLabel domQtyLabel = new JLabel("Quantity of Order:");
                domQtyLabel.setBounds(20, 240, 140, 25);
                domesticPanel.add(domQtyLabel);
                JTextField domQtyField = new JTextField();
                domQtyField.setBounds(170, 240, 230, 25);
                domesticPanel.add(domQtyField);

                // Weight selection
                JLabel domWeightLabel = new JLabel("Weight (Kg):");
                domWeightLabel.setBounds(20, 275, 140, 25);
                domesticPanel.add(domWeightLabel);
                String[] weightList = { "14.0", "16.0", "18.0" };
                JComboBox<String> domWeightCombo = new JComboBox<>(weightList);
                domWeightCombo.setBounds(170, 275, 230, 25);
                domesticPanel.add(domWeightCombo);

                // Base price
                JLabel domBasePriceLabel = new JLabel("Base Price:");
                domBasePriceLabel.setBounds(20, 310, 140, 25);
                domesticPanel.add(domBasePriceLabel);
                JTextField domBasePriceField = new JTextField();
                domBasePriceField.setBounds(170, 310, 230, 25);
                domesticPanel.add(domBasePriceField);

                // Subsidy Amount
                JLabel domSubsidyLabel = new JLabel("Subsidy Amount:");
                domSubsidyLabel.setBounds(20, 345, 140, 25);
                domesticPanel.add(domSubsidyLabel);
                JTextField domSubsidyField = new JTextField("0.0");
                domSubsidyField.setBounds(170, 345, 230, 25);
                domesticPanel.add(domSubsidyField);

                // Domestic Buttons
                JButton addDomesticBtn = new JButton("Add Domestic");
                addDomesticBtn.setBounds(50, 385, 160, 32);
                domesticPanel.add(addDomesticBtn);

                // Display Area
                JTextArea displayArea = new JTextArea();
                displayArea.setEditable(false);
                displayArea.setLineWrap(true);
                displayArea.setWrapStyleWord(true);

                /**
                 * Action Listener for adding a domestic cylinder
                 * Validates all input fields and creates a new DomesticCylinder object.
                 */
                addDomesticBtn.addActionListener(e -> {
                        String customerType = (String) domCustTypeCombo.getSelectedItem();
                        if (!"Domestic".equalsIgnoreCase(customerType)) {
                                JOptionPane.showMessageDialog(this,
                                                "This button is only for Domestic Cylinder!\n"
                                                                + "Please select 'Domestic' from the dropdown.",
                                                "Invalid Cylinder Type",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }

                        try {
                                String customerName = domNameField.getText().trim();
                                String citizenshipNumber = domCitizenshipField.getText().trim();
                                String bookingId = domBookingField.getText().trim();
                                String bookingMonth = (String) domMonthCombo.getSelectedItem();
                                String cylinderId = domCylinderField.getText().trim();
                                int quantity = Integer.parseInt(domQtyField.getText());
                                String weight = (String) domWeightCombo.getSelectedItem();
                                double basePrice = Double.parseDouble(domBasePriceField.getText());
                                double subsidyAmount = Double.parseDouble(domSubsidyField.getText());

                                // Validate customer name format
                                if (!customerName.matches("^[A-Za-z]+ [A-Za-z]+$")) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Invalid name format. Please enter first and last name.",
                                                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                // validate citizenship number
                                if (citizenshipNumber.isEmpty()) {
                                        JOptionPane.showMessageDialog(this, "Citizenship number cannot be empty",
                                                        "Invalid Citizenship", JOptionPane.ERROR_MESSAGE);
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

                                // Validate IDs and pricing
                                if (!validateCylinderAndBookingIds(cylinderId, bookingId)
                                                || !validateQuantityAndBasePrice(quantity, basePrice)) {
                                        return;
                                }

                                // Domestic customers can order at most 2 cylinders
                                if (quantity > 2) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Domestic Customer cannot order and used more than 2 cylinder per month",
                                                        "'Validation Error", JOptionPane.ERROR_MESSAGE);
                                        return;

                                }

                                if (basePrice < subsidyAmount) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Subsidy Amount cannot be greater than base price",
                                                        "validation Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                // Check subsidy eligibility
                                if (!isEligibleForSubsidy(citizenshipNumber, quantity)) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Customer is not eligible for subsify. \n Subsidy will be set to 0.");
                                        return;
                                }

                                // Create and add domestic cylinder
                                DomesticCylinder domestic = new DomesticCylinder(cylinderId, customerType, bookingId,
                                                basePrice,
                                                weight, bookingMonth, customerName, subsidyAmount, citizenshipNumber,
                                                quantity);

                                cylinders.add(domestic);
                                System.out.println("Cylinder Domesti: " + domestic.getCylinderId());
                                JOptionPane.showMessageDialog(this, "Domestic Cylinder ordered Successfully!",
                                                "Success",
                                                JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
                        } catch (NullPointerException ex) {
                                JOptionPane.showMessageDialog(this, "Input field cannot be empty.");
                        }

                });

                // Clear Form Button for Domestic Panel
                JButton clearDomesticBtn = new JButton(
                                "Clear Form");
                clearDomesticBtn.setBounds(230, 385, 160, 32);
                domesticPanel.add(clearDomesticBtn);

                /**
                 * Action listner to clear all input fields in the domestic panel
                 */
                clearDomesticBtn.addActionListener(e -> {
                        domCustTypeCombo.setSelectedIndex(0);
                        domNameField.setText(" ");
                        domCitizenshipField.setText(" ");
                        domBookingField.setText("");
                        domCylinderField.setText(" ");
                        domMonthCombo.setSelectedIndex(0);
                        domWeightCombo.setSelectedIndex(0);
                        domQtyField.setText("");
                        domBasePriceField.setText(" ");
                        domSubsidyField.setText("0.0");
                });

                /**
                 * Creating JPanel for commercial cylinder management,
                 * including input fields and action buttons.
                 */
                JPanel commercialPanel = new JPanel();
                commercialPanel.setBorder(
                                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
                                                "Commercial Cylinder Booking", TitledBorder.CENTER, TitledBorder.TOP));
                commercialPanel.setLayout(null);
                commercialPanel.setBounds(510, 10, 450, 430);

                add(commercialPanel);

                // Commercial Customer Type and ComboBox
                JLabel comCustTypeLabel = new JLabel("Customer Type:");
                comCustTypeLabel.setBounds(20, 30, 140, 25);
                commercialPanel.add(comCustTypeLabel);
                JComboBox<String> comCustTypeCombo = new JComboBox<>(customerTypes);
                comCustTypeCombo.setBounds(170, 30, 230, 25);
                commercialPanel.add(comCustTypeCombo);

                // Company Name
                JLabel comCompanyLabel = new JLabel("Company Name:");
                comCompanyLabel.setBounds(20, 65, 140, 25);
                commercialPanel.add(comCompanyLabel);
                JTextField comCompanyField = new JTextField();
                comCompanyField.setBounds(170, 65, 230, 25);
                commercialPanel.add(comCompanyField);

                // Company Address
                JLabel comAddressLabel = new JLabel("Company Address:");
                comAddressLabel.setBounds(20, 100, 140, 25);
                commercialPanel.add(comAddressLabel);
                JTextField comAddressField = new JTextField();
                comAddressField.setBounds(170, 100, 230, 25);
                commercialPanel.add(comAddressField);

                // Business License
                JLabel comLicenseLabel = new JLabel("Business License:");
                comLicenseLabel.setBounds(20, 135, 140, 25);
                commercialPanel.add(comLicenseLabel);
                JTextField comLicenseField = new JTextField();
                comLicenseField.setBounds(170, 135, 230, 25);
                commercialPanel.add(comLicenseField);

                // Booking ID
                JLabel comBookingIdLabel = new JLabel("Booking ID:");
                comBookingIdLabel.setBounds(20, 170, 140, 25);
                commercialPanel.add(comBookingIdLabel);
                JTextField comBookingIdField = new JTextField();
                comBookingIdField.setBounds(170, 170, 230, 25);
                commercialPanel.add(comBookingIdField);

                // Cylinder ID
                JLabel comCylinderIdLabel = new JLabel("Cylinder ID:");
                comCylinderIdLabel.setBounds(20, 205, 140, 25);
                commercialPanel.add(comCylinderIdLabel);
                JTextField comCylinderIdField = new JTextField();
                comCylinderIdField.setBounds(170, 205, 230, 25);
                commercialPanel.add(comCylinderIdField);

                // Month Selection
                JLabel comMonthLabel = new JLabel("Month:");
                comMonthLabel.setBounds(20, 240, 140, 25);
                commercialPanel.add(comMonthLabel);
                JComboBox<String> comMonthCombo = new JComboBox<>(months);
                comMonthCombo.setBounds(170, 240, 230, 25);
                commercialPanel.add(comMonthCombo);

                // Quantity
                JLabel comQuantityLabel = new JLabel("Quantity of Cylinders:");
                comQuantityLabel.setBounds(20, 275, 140, 25);
                commercialPanel.add(comQuantityLabel);
                JTextField comQuantityField = new JTextField();
                comQuantityField.setBounds(170, 275, 230, 25);
                commercialPanel.add(comQuantityField);

                // Weight selection
                JLabel comWeightLabel = new JLabel("Cylinder Weight:");
                comWeightLabel.setBounds(20, 310, 140, 25);
                commercialPanel.add(comWeightLabel);
                JComboBox<String> comWeightCombo = new JComboBox<>(weightList);
                comWeightCombo.setBounds(170, 310, 230, 25);
                commercialPanel.add(comWeightCombo);

                // Base price
                JLabel comBasePriceLabel = new JLabel("Base Price:");
                comBasePriceLabel.setBounds(20, 345, 140, 25);
                commercialPanel.add(comBasePriceLabel);
                JTextField comBasePriceField = new JTextField();
                comBasePriceField.setBounds(170, 345, 230, 25);
                commercialPanel.add(comBasePriceField);

                // Add Comercial Button
                JButton addComBtn = new JButton("Add Commercial");
                addComBtn.setBounds(40, 385, 170, 35);
                commercialPanel.add(addComBtn);
                /**
                 * Action listener for adding a commercial cylinder.
                 * Validates all input fields and creates a new CommercialCylinder object.
                 */
                addComBtn.addActionListener(e -> {
                        try {
                                String customerType = (String) comCustTypeCombo.getSelectedItem();
                                if (!"Commercial".equals(customerType)) {
                                        JOptionPane.showMessageDialog(this,
                                                        "This section is only for Commerical Cylinder! \n"
                                                                        + "Please select 'Commercial' from the dropdown",
                                                        "Invalid Cylinder Type", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                String companyName = comCompanyField.getText();
                                String companyAddress = comAddressField.getText();
                                String comLicense = comLicenseField.getText();
                                String comBooking = comBookingIdField.getText();
                                String comCylinderId = comCylinderIdField.getText();
                                String comMonth = (String) comMonthCombo.getSelectedItem();
                                int quantity = Integer.parseInt(comQuantityField.getText());
                                String comWeight = (String) comWeightCombo.getSelectedItem();
                                double basePrice = Double.parseDouble(comBasePriceField.getText());

                                // Validate business License
                                if (comLicense == null && !comLicense.matches("^[0-9]{6}$")) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Invalid Company License Number. Format: 6 digits",
                                                        "Validation Errot", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                // Validate IDs and pricing
                                if (!validateCylinderAndBookingIds(comCylinderId, comBooking)) {
                                        return;
                                }
                                if (!validateQuantityAndBasePrice(quantity, basePrice)) {
                                        return;
                                }

                                // Create and add comercial cylinder
                                CommercialCylinder cylinder = new CommercialCylinder(comCylinderId, customerType,
                                                comBooking,
                                                basePrice, comWeight, comMonth, companyName, companyAddress, comLicense,
                                                quantity);
                                cylinders.add(cylinder);
                                JOptionPane.showMessageDialog(this, "Commercial Cylinder ordered successfully!",
                                                "Suceess",
                                                JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException eX) {
                                JOptionPane.showMessageDialog(this, "Please enter the valid numeric values");
                        } catch (NullPointerException ex) {
                                JOptionPane.showMessageDialog(this, "Input field cannot be empty");
                        }

                });

                // Clear for button for commercial panel
                JButton clearComBtn = new JButton("Clear Form");
                clearComBtn.setBounds(220, 385, 170, 35);
                commercialPanel.add(clearComBtn);
                /**
                 * Action listener to clear all input fields in the commercial panel.
                 */
                clearComBtn.addActionListener(e -> {
                        comCustTypeCombo.setSelectedIndex(0);
                        comCompanyField.setText("");
                        comAddressField.setText("");
                        comLicenseField.setText("");
                        comBookingIdField.setText("");
                        comCylinderIdField.setText("");
                        comMonthCombo.setSelectedIndex(0);
                        comQuantityField.setText("0");
                        comWeightCombo.setSelectedIndex(0);
                        comBasePriceField.setText("");

                });

                // Scrollable Display Area for records
                JScrollPane scrollPane = new JScrollPane(displayArea);
                scrollPane.setBounds(20, 460, 940, 200);
                scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
                                "Booking Records Display", TitledBorder.CENTER, TitledBorder.TOP));

                add(scrollPane);

                /**
                 * Action Buttons Panel
                 * Contains buttons for various operations: Bulk Discount, Subsidy, Display,
                 * Identify, Export, Load
                 */
                JPanel actionPanel = new JPanel();
                actionPanel.setLayout(null);
                actionPanel.setBounds(20, 680, 940, 80);

                actionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
                                "Actions", TitledBorder.CENTER, TitledBorder.TOP));

                actionPanel.setLayout(null);

                // Bulk Discount Button
                JButton bulkDiscountBtn = new JButton("Bulk Discount");
                bulkDiscountBtn.setBounds(15, 28, 130, 30);
                actionPanel.add(bulkDiscountBtn);

                /**
                 * Action listener for applying bulk discount to commercial cylinders.
                 */
                bulkDiscountBtn.addActionListener(e -> {
                        String cylinderId = JOptionPane.showInputDialog(this, "Enter Cylinder ID for Bulk Discount:", "Bulk Discount", JOptionPane.INFORMATION_MESSAGE);
                        if (cylinderId != null && !cylinderId.trim().isEmpty()) {
                                bulkDiscount(cylinderId.trim());
                        } else {
                                JOptionPane.showMessageDialog(this, "Please enter a Cylinder ID", "Invalid", JOptionPane.ERROR_MESSAGE);

                        }
                });

                // Subsidy Button - Changed to "Subsidy Amount"
                JButton subsidyBtn = new JButton("Subsidy Amount");
                subsidyBtn.setBounds(155, 28, 155, 30);
                actionPanel.add(subsidyBtn);

                /**
                 * Action listener for displaying subsidy details for domestic cylinders.
                 */
                subsidyBtn.addActionListener(e -> {
                        String cylinderId = JOptionPane.showInputDialog(this, "Enter Cylinder ID for Subsidy Amount:", "Subsidy Amount", JOptionPane.INFORMATION_MESSAGE);
                        if (cylinderId != null && !cylinderId.trim().isEmpty()) {
                                subsidyDiscount(cylinderId.trim());
                        } else {
                                JOptionPane.showMessageDialog(this, "Please enter a Cylinder ID");

                        }
                });

                // Display Button
                JButton displayBtn = new JButton("Display");
                displayBtn.setBounds(320, 28, 90, 30);
                actionPanel.add(displayBtn);

                /**
                 * Action listener to display all cylinder records.
                 */
                displayBtn.addActionListener(e -> {
                        if (cylinders.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "No cylinder records", "No Cylinder",JOptionPane.ERROR_MESSAGE);
                                return;
                        }
                        for (LPGCylinder cylinder : cylinders) {
                                displayArea.append(cylinder.display());
                        }
                });

                // Identify buttton
                JButton identifyBtn = new JButton("Identify");
                identifyBtn.setBounds(420, 28, 100, 30);
                actionPanel.add(identifyBtn);

                /**
                 * Action listener to identify cylinder type.
                 */
                identifyBtn.addActionListener(e -> {
                        String cylinderId = JOptionPane.showInputDialog(this, "Enter Cylinder ID to Identify Type:","Identify Cylinder", JOptionPane.INFORMATION_MESSAGE);
                        if (cylinderId != null && !cylinderId.trim().isEmpty()) {
                                identifyCylinderType(cylinderId.trim());
                        } else {
                                JOptionPane.showMessageDialog(this, "please enter a Cylinder ID", "Invalid", JOptionPane.ERROR_MESSAGE);
                        }
                });

                // Export button
                JButton exportBtn = new JButton("Export");
                exportBtn.setBounds(530, 28, 80, 30);
                actionPanel.add(exportBtn);

                /**
                 * Action listener for Export button
                 */
                exportBtn.addActionListener(e -> {
                        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Cylinders.txt"))) {
                                for(LPGCylinder cylinder: cylinders){
                                        if(cylinder instanceof DomesticCylinder){
                                                writer.write("\n===Domestic Cylinder");
                                        } else if( cylinder instanceof CommercialCylinder){
                                                writer.write("Commercical cylinfrt");
                                        }
                                }
                                JOptionPane.showMessageDialog(this, "Cylinder exported successfully.");
                            
                        } catch (IOException ex) {
                                JOptionPane.showMessageDialog(this, "An error occured while exporting cylinders.");

                        }
                });

                // Load Button
                JButton loadBtn = new JButton("Load");
                loadBtn.setBounds(620, 28, 80, 30);
                actionPanel.add(loadBtn);

                /**
                 * Action listener for Load button
                 */
                loadBtn.addActionListener(e -> {
                        JFileChooser fileChooser = new JFileChooser();
                        int result = fileChooser.showOpenDialog(this);
                        if(result == JFileChooser.APPROVE_OPTION){
                                File selectedFile = fileChooser.getSelectedFile();
                                
                        }
                });

                // Clear Button
                JButton clearBtn = new JButton("Clear");
                clearBtn.setBounds(710, 28, 80, 30);
                actionPanel.add(clearBtn);

                /**
                 * Action listener for Clear button
                 */
                clearBtn.addActionListener(e -> {
                        displayArea.setText("");
                        JOptionPane.showMessageDialog(this, "Display area cleared");
                });

                // Save Button
                JButton saveBtn = new JButton("Save");
                saveBtn.setBounds(800, 28, 80, 30);
                actionPanel.add(saveBtn);

                /**
                 * Action listener for Save button
                 */
                saveBtn.addActionListener(e -> {
                        JFileChooser fileChooser = new JFileChooser();
                        int result = fileChooser.showSaveDialog(this);
                        if(result == JFileChooser.APPROVE_OPTION){
                                File file = fileChooser.getSelectedFile();
                                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                                        oos.writeObject(cylinders);
                                        JOptionPane.showMessageDialog(this, "Data Saved Successfully");
                                        
                                } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(this, "Error haha");
                                        System.out.println(ex.getMessage());
                                }
                        }

                });

                add(actionPanel);
                setVisible(true);
        }

        public static void main(String[] args) {
                new NOCApp();
        }
}
