/**
 * NOCApp is the main GUI application for the Nepal Oil Corporation Cylinder Management System.
 * It provides a graphical interface for managing LPG cylinder bookings with separate panels
 * for Domestic and Commercial customers.
 * 
 * @author Milan Rai
 * @version 2.0.0.0
 */
import java.awt.*;
import javax.swing.*;

public class NOCPanel extends JFrame {
    
    // Panels
    private JPanel domesticPanel;
    private JPanel commercialPanel;
    private JPanel displayPanel;
    private JPanel actionPanel;
    
    // Common components
    private JComboBox<String> cylinderTypeCombobox;
    private JComboBox<String> cylinderTypeCombobox2;
    private JTextField bookingIdField;
    private JTextField bookingIdField2;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> monthComboBox2;
    private JTextField cylinderIdField;
    private JTextField cylinderIdField2;
    private JTextField quantityField;
    private JTextField quantityField2;
    private JComboBox<Double> weightComboBox;
    private JComboBox<Double> weightComboBox2;
    private JTextField basePriceField;
    private JTextField basePriceField2;
    
    // Domestic components
    private JTextField customerNameField;
    private JTextField citizenshipField;
    private JTextField subsidyField;
    
    // Commercial components
    private JTextField organizationField;
    private JTextField businessLicenseField;
    
    // Search and Calculation Input Fields
    private JTextField searchCylinderIdField;
    private JTextField identifyCylinderIdField;
    private JTextField deleteCylinderIdField;
    private JTextField checkSubsidyCylinderIdField;
    private JTextField calculatePriceCylinderIdField;
    private JTextField calculateDiscountQuantityField;
    
    // Display components
    private JTextArea displayArea;
    private JScrollPane scrollPane;
    
    // Action buttons
    private JButton addDomesticButton;
    private JButton addCommercialButton;
    private JButton calculateDiscountButton;
    private JButton calculatePriceButton;
    private JButton identifyTypeButton;
    private JButton displayAllButton;
    private JButton exportButton;
    private JButton loadButton;
    private JButton clearButton;
    private JButton checkSubsidyButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton calculateFinalPriceButton;
    private JButton totalCylindersButton;
    private JButton domesticCountButton;
    private JButton commercialCountButton;

    public NOCPanel() {
        setTitle("LPG Cylinder Booking Management System");
        setSize(1450, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        initializeComponents();
        setupLayout();

        setVisible(true);
    }

    private void initializeComponents() {
        // Initialize Common Components
        String[] cylinderTypes = { "Select One", "Domestic", "Commercial" };
        cylinderTypeCombobox = new JComboBox<>(cylinderTypes);
        cylinderTypeCombobox2 = new JComboBox<>(cylinderTypes);
        
        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        monthComboBox = new JComboBox<>(months);
        monthComboBox2 = new JComboBox<>(months);
        
        Double[] weightList = { 14.0, 16.0, 18.0 };
        weightComboBox = new JComboBox<>(weightList);
        weightComboBox2 = new JComboBox<>(weightList);

        bookingIdField = new JTextField();
        bookingIdField2 = new JTextField();
        cylinderIdField = new JTextField();
        cylinderIdField2 = new JTextField();
        quantityField = new JTextField();
        quantityField2 = new JTextField();
        basePriceField = new JTextField();
        basePriceField2 = new JTextField();

        // Initialize Domestic Components
        customerNameField = new JTextField();
        citizenshipField = new JTextField();
        subsidyField = new JTextField("0.0");

        // Initialize Commercial Components
        organizationField = new JTextField();
        businessLicenseField = new JTextField();

        // Initialize Search and Calculation Fields
        searchCylinderIdField = new JTextField();
        identifyCylinderIdField = new JTextField();
        deleteCylinderIdField = new JTextField();
        checkSubsidyCylinderIdField = new JTextField();
        calculatePriceCylinderIdField = new JTextField();
        calculateDiscountQuantityField = new JTextField();

        // Initialize Display
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        scrollPane = new JScrollPane(displayArea);

        // Initialize Buttons
        addDomesticButton = new JButton("Add Domestic Cylinder");
        addCommercialButton = new JButton("Add Commercial Cylinder");
        calculateDiscountButton = new JButton("Calculate Bulk Discount");
        calculatePriceButton = new JButton("Calculate Price after Subsidy");
        identifyTypeButton = new JButton("Identify Type");
        displayAllButton = new JButton("Display All Records");
        exportButton = new JButton("Export to File");
        loadButton = new JButton("Load From File");
        clearButton = new JButton("Clear All Fields");
        checkSubsidyButton = new JButton("Check Subsidy");
        searchButton = new JButton("Search");
        deleteButton = new JButton("Delete");
        calculateFinalPriceButton = new JButton("Calculate Final Price");
        totalCylindersButton = new JButton("Total Cylinders");
        domesticCountButton = new JButton("Domestic Count");
        commercialCountButton = new JButton("Commercial Count");
    }

    private void setupLayout() {
        // Domestic Panel (Left Top) - Reduced Height from 520 to 430
        domesticPanel = new JPanel(null);
        domesticPanel.setBorder(BorderFactory.createTitledBorder("DOMESTIC CYLINDER BOOKING"));
        domesticPanel.setBounds(10, 10, 380, 430);
        add(domesticPanel);

        // Customer Type
        JLabel typeLabel = new JLabel("Customer Type:");
        typeLabel.setBounds(10, 25, 120, 22);
        domesticPanel.add(typeLabel);
        cylinderTypeCombobox.setBounds(140, 25, 200, 22);
        domesticPanel.add(cylinderTypeCombobox);

        // Domestic components - Reduced height from 25 to 22, spacing from 35 to 30
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(10, 55, 120, 22);
        domesticPanel.add(customerNameLabel);
        customerNameField.setBounds(140, 55, 200, 22);
        domesticPanel.add(customerNameField);

        JLabel citizenshipLabel = new JLabel("Citizenship No:");
        citizenshipLabel.setBounds(10, 85, 120, 22);
        domesticPanel.add(citizenshipLabel);
        citizenshipField.setBounds(140, 85, 200, 22);
        domesticPanel.add(citizenshipField);

        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(10, 115, 120, 22);
        domesticPanel.add(bookingIdLabel);
        bookingIdField.setBounds(140, 115, 200, 22);
        domesticPanel.add(bookingIdField);

        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setBounds(10, 145, 120, 22);
        domesticPanel.add(monthLabel);
        monthComboBox.setBounds(140, 145, 200, 22);
        domesticPanel.add(monthComboBox);

        JLabel cylinderIdLabel = new JLabel("Cylinder ID:");
        cylinderIdLabel.setBounds(10, 175, 120, 22);
        domesticPanel.add(cylinderIdLabel);
        cylinderIdField.setBounds(140, 175, 200, 22);
        domesticPanel.add(cylinderIdField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(10, 205, 120, 22);
        domesticPanel.add(quantityLabel);
        quantityField.setBounds(140, 205, 200, 22);
        domesticPanel.add(quantityField);

        JLabel weightLabel = new JLabel("Weight (Kg):");
        weightLabel.setBounds(10, 235, 120, 22);
        domesticPanel.add(weightLabel);
        weightComboBox.setBounds(140, 235, 200, 22);
        domesticPanel.add(weightComboBox);

        JLabel basePriceLabel = new JLabel("Base Price (Rs):");
        basePriceLabel.setBounds(10, 265, 120, 22);
        domesticPanel.add(basePriceLabel);
        basePriceField.setBounds(140, 265, 200, 22);
        domesticPanel.add(basePriceField);

        JLabel subsidyLabel = new JLabel("Subsidy Amount:");
        subsidyLabel.setBounds(10, 295, 120, 22);
        domesticPanel.add(subsidyLabel);
        subsidyField.setBounds(140, 295, 200, 22);
        domesticPanel.add(subsidyField);

        addDomesticButton.setBounds(70, 325, 240, 35);
        domesticPanel.add(addDomesticButton);

        // Commercial Panel (Left Bottom) - Full functionality
        commercialPanel = new JPanel(null);
        commercialPanel.setBorder(BorderFactory.createTitledBorder("COMMERCIAL CYLINDER BOOKING"));
        commercialPanel.setBounds(10, 450, 380, 410);
        add(commercialPanel);

        // Customer Type
        JLabel typeLabel2 = new JLabel("Customer Type:");
        typeLabel2.setBounds(10, 25, 120, 22);
        commercialPanel.add(typeLabel2);
        cylinderTypeCombobox2.setBounds(140, 25, 200, 22);
        commercialPanel.add(cylinderTypeCombobox2);

        // Commercial components
        JLabel organizationLabel = new JLabel("Organization:");
        organizationLabel.setBounds(10, 55, 120, 22);
        commercialPanel.add(organizationLabel);
        organizationField.setBounds(140, 55, 200, 22);
        commercialPanel.add(organizationField);

        JLabel licenseLabel = new JLabel("License No:");
        licenseLabel.setBounds(10, 85, 120, 22);
        commercialPanel.add(licenseLabel);
        businessLicenseField.setBounds(140, 85, 200, 22);
        commercialPanel.add(businessLicenseField);

        JLabel bookingIdLabel2 = new JLabel("Booking ID:");
        bookingIdLabel2.setBounds(10, 115, 120, 22);
        commercialPanel.add(bookingIdLabel2);
        bookingIdField2.setBounds(140, 115, 200, 22);
        commercialPanel.add(bookingIdField2);

        JLabel monthLabel2 = new JLabel("Month:");
        monthLabel2.setBounds(10, 145, 120, 22);
        commercialPanel.add(monthLabel2);
        monthComboBox2.setBounds(140, 145, 200, 22);
        commercialPanel.add(monthComboBox2);

        JLabel cylinderIdLabel2 = new JLabel("Cylinder ID:");
        cylinderIdLabel2.setBounds(10, 175, 120, 22);
        commercialPanel.add(cylinderIdLabel2);
        cylinderIdField2.setBounds(140, 175, 200, 22);
        commercialPanel.add(cylinderIdField2);

        JLabel quantityLabel2 = new JLabel("Quantity:");
        quantityLabel2.setBounds(10, 205, 120, 22);
        commercialPanel.add(quantityLabel2);
        quantityField2.setBounds(140, 205, 200, 22);
        commercialPanel.add(quantityField2);

        JLabel weightLabel2 = new JLabel("Weight (Kg):");
        weightLabel2.setBounds(10, 235, 120, 22);
        commercialPanel.add(weightLabel2);
        weightComboBox2.setBounds(140, 235, 200, 22);
        commercialPanel.add(weightComboBox2);

        JLabel basePriceLabel2 = new JLabel("Base Price (Rs):");
        basePriceLabel2.setBounds(10, 265, 120, 22);
        commercialPanel.add(basePriceLabel2);
        basePriceField2.setBounds(140, 265, 200, 22);
        commercialPanel.add(basePriceField2);

        addCommercialButton.setBounds(70, 295, 240, 35);
        commercialPanel.add(addCommercialButton);

        // Display Panel (Center)
        displayPanel = new JPanel(null);
        displayPanel.setBorder(BorderFactory.createTitledBorder("DISPLAY AREA"));
        displayPanel.setBounds(410, 10, 550, 850);
        add(displayPanel);

        scrollPane.setBounds(10, 20, 530, 820);
        displayPanel.add(scrollPane);

        // Action Panel (Right)
        actionPanel = new JPanel(null);
        actionPanel.setBorder(BorderFactory.createTitledBorder("ACTION CENTER"));
        actionPanel.setBounds(980, 10, 440, 850);
        add(actionPanel);

        // ===== SECTION 1: IDENTIFY CYLINDER TYPE =====
        JLabel identifyLabel = new JLabel("IDENTIFY CYLINDER TYPE:");
        identifyLabel.setBounds(10, 20, 400, 22);
        identifyLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(identifyLabel);

        JLabel identifyIdLabel = new JLabel("Cylinder ID:");
        identifyIdLabel.setBounds(10, 48, 100, 22);
        actionPanel.add(identifyIdLabel);
        identifyCylinderIdField.setBounds(120, 48, 200, 22);
        actionPanel.add(identifyCylinderIdField);
        identifyTypeButton.setBounds(330, 48, 90, 22);
        actionPanel.add(identifyTypeButton);

        // ===== SECTION 2: SEARCH CYLINDER =====
        JLabel searchLabel = new JLabel("SEARCH CYLINDER:");
        searchLabel.setBounds(10, 85, 400, 22);
        searchLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(searchLabel);

        JLabel searchIdLabel = new JLabel("Cylinder ID:");
        searchIdLabel.setBounds(10, 113, 100, 22);
        actionPanel.add(searchIdLabel);
        searchCylinderIdField.setBounds(120, 113, 200, 22);
        actionPanel.add(searchCylinderIdField);
        searchButton.setBounds(330, 113, 90, 22);
        actionPanel.add(searchButton);

        // ===== SECTION 3: DELETE CYLINDER =====
        JLabel deleteLabel = new JLabel("DELETE CYLINDER:");
        deleteLabel.setBounds(10, 150, 400, 22);
        deleteLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(deleteLabel);

        JLabel deleteIdLabel = new JLabel("Cylinder ID:");
        deleteIdLabel.setBounds(10, 178, 100, 22);
        actionPanel.add(deleteIdLabel);
        deleteCylinderIdField.setBounds(120, 178, 200, 22);
        actionPanel.add(deleteCylinderIdField);
        deleteButton.setBounds(330, 178, 90, 22);
        actionPanel.add(deleteButton);

        // ===== SECTION 4: SUBSIDY CHECK =====
        JLabel subsidyCheckLabel = new JLabel("CHECK SUBSIDY ELIGIBILITY:");
        subsidyCheckLabel.setBounds(10, 215, 400, 22);
        subsidyCheckLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(subsidyCheckLabel);

        JLabel subsidyIdLabel = new JLabel("Cylinder ID:");
        subsidyIdLabel.setBounds(10, 243, 100, 22);
        actionPanel.add(subsidyIdLabel);
        checkSubsidyCylinderIdField.setBounds(120, 243, 200, 22);
        actionPanel.add(checkSubsidyCylinderIdField);
        checkSubsidyButton.setBounds(330, 243, 90, 22);
        actionPanel.add(checkSubsidyButton);

        // ===== SECTION 5: CALCULATE PRICE =====
        JLabel priceLabel = new JLabel("CALCULATE PRICE:");
        priceLabel.setBounds(10, 280, 400, 22);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(priceLabel);

        JLabel priceIdLabel = new JLabel("Cylinder ID:");
        priceIdLabel.setBounds(10, 308, 100, 22);
        actionPanel.add(priceIdLabel);
        calculatePriceCylinderIdField.setBounds(120, 308, 200, 22);
        actionPanel.add(calculatePriceCylinderIdField);
        calculatePriceButton.setBounds(330, 308, 90, 22);
        actionPanel.add(calculatePriceButton);

        calculateFinalPriceButton.setBounds(120, 340, 200, 30);
        actionPanel.add(calculateFinalPriceButton);

        // ===== SECTION 6: BULK DISCOUNT =====
        JLabel discountLabel = new JLabel("BULK DISCOUNT CALCULATION:");
        discountLabel.setBounds(10, 385, 400, 22);
        discountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(discountLabel);

        JLabel discountQuantityLabel = new JLabel("Total Quantity:");
        discountQuantityLabel.setBounds(10, 413, 100, 22);
        actionPanel.add(discountQuantityLabel);
        calculateDiscountQuantityField.setBounds(120, 413, 200, 22);
        actionPanel.add(calculateDiscountQuantityField);
        calculateDiscountButton.setBounds(330, 413, 90, 22);
        actionPanel.add(calculateDiscountButton);

        // ===== SECTION 7: COUNTS =====
        JLabel countLabel = new JLabel("CYLINDER COUNTS:");
        countLabel.setBounds(10, 450, 400, 22);
        countLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(countLabel);

        totalCylindersButton.setBounds(40, 482, 170, 30);
        actionPanel.add(totalCylindersButton);
        domesticCountButton.setBounds(220, 482, 170, 30);
        actionPanel.add(domesticCountButton);
        commercialCountButton.setBounds(40, 522, 170, 30);
        actionPanel.add(commercialCountButton);

        // ===== SECTION 8: DISPLAY & FILE =====
        JLabel displayLabel = new JLabel("DISPLAY & FILE OPERATIONS:");
        displayLabel.setBounds(10, 565, 400, 22);
        displayLabel.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(displayLabel);

        displayAllButton.setBounds(40, 597, 170, 30);
        actionPanel.add(displayAllButton);
        clearButton.setBounds(220, 597, 170, 30);
        actionPanel.add(clearButton);

        exportButton.setBounds(40, 637, 170, 30);
        actionPanel.add(exportButton);
        loadButton.setBounds(220, 637, 170, 30);
        actionPanel.add(loadButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NOCPanel();
        });
    }
}
