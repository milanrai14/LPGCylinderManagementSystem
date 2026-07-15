import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NOCAPPJPanel extends JFrame {
    public NOCAPPJPanel() {
        setTitle("LPG Cylinder Booking Management System");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add border to content pane
        ((JComponent) getContentPane()).setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
            )
        );

        setLayout(null);

        // ===== LEFT PANEL: Customer Panel (Domestic) =====
        JPanel customerPanel = new JPanel();
        customerPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Customer Booking Details",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        customerPanel.setLayout(null);
        customerPanel.setBounds(10, 10, 450, 760);

        // Customer Type
        JLabel customerTypeLabel = new JLabel("Customer Type:");
        customerTypeLabel.setBounds(20, 30, 150, 30);
        customerPanel.add(customerTypeLabel);

        String[] customerTypes = { "Select One", "Domestic", "Commercial" };
        JComboBox<String> customerTypeCombo = new JComboBox<>(customerTypes);
        customerTypeCombo.setBounds(180, 30, 200, 30);
        customerPanel.add(customerTypeCombo);

        // Customer Name
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(20, 80, 150, 30);
        customerPanel.add(customerNameLabel);

        JTextField customerNameField = new JTextField();
        customerNameField.setBounds(180, 80, 200, 30);
        customerPanel.add(customerNameField);

        // Citizenship Number
        JLabel citizenshipLabel = new JLabel("Citizenship Number:");
        citizenshipLabel.setBounds(20, 130, 150, 30);
        customerPanel.add(citizenshipLabel);

        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(180, 130, 200, 30);
        customerPanel.add(citizenshipField);

        // Booking ID
        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(20, 180, 150, 30);
        customerPanel.add(bookingIdLabel);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(180, 180, 200, 30);
        customerPanel.add(bookingIdField);

        // Month
        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setBounds(20, 230, 150, 30);
        customerPanel.add(monthLabel);

        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        JComboBox<String> monthCombo = new JComboBox<>(months);
        monthCombo.setBounds(180, 230, 200, 30);
        customerPanel.add(monthCombo);

        // Cylinder ID
        JLabel cylinderIdLabel = new JLabel("Cylinder ID:");
        cylinderIdLabel.setBounds(20, 280, 150, 30);
        customerPanel.add(cylinderIdLabel);

        JTextField cylinderIdField = new JTextField();
        cylinderIdField.setBounds(180, 280, 200, 30);
        customerPanel.add(cylinderIdField);

        // Quantity of Order
        JLabel quantityLabel = new JLabel("Quantity of Order:");
        quantityLabel.setBounds(20, 330, 150, 30);
        customerPanel.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(180, 330, 200, 30);
        customerPanel.add(quantityField);

        // Weight
        JLabel weightLabel = new JLabel("Weight (Kg):");
        weightLabel.setBounds(20, 380, 150, 30);
        customerPanel.add(weightLabel);

        Double[] weightList = { 14.0, 16.0, 18.0 };
        JComboBox<Double> weightCombo = new JComboBox<>(weightList);
        weightCombo.setBounds(180, 380, 200, 30);
        customerPanel.add(weightCombo);

        // Base Price
        JLabel basePriceLabel = new JLabel("Base Price:");
        basePriceLabel.setBounds(20, 430, 150, 30);
        customerPanel.add(basePriceLabel);

        JTextField basePriceField = new JTextField();
        basePriceField.setBounds(180, 430, 200, 30);
        customerPanel.add(basePriceField);

        // Subsidy Amount
        JLabel subsidyLabel = new JLabel("Subsidy Amount:");
        subsidyLabel.setBounds(20, 480, 150, 30);
        customerPanel.add(subsidyLabel);

        JTextField subsidyField = new JTextField("0.0");
        subsidyField.setBounds(180, 480, 200, 30);
        customerPanel.add(subsidyField);

        // Buttons
        JButton addButton = new JButton("Add Booking");
        addButton.setBounds(60, 540, 140, 35);
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        customerPanel.add(addButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(220, 540, 140, 35);
        clearButton.setFont(new Font("Arial", Font.BOLD, 12));
        customerPanel.add(clearButton);

        add(customerPanel);

        // ===== RIGHT PANEL: Commercial Cylinder =====
        JPanel commercialPanel = new JPanel();
        commercialPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Commercial Cylinder Booking",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        commercialPanel.setLayout(null);
        commercialPanel.setBounds(470, 10, 350, 760);

        // Customer Type
        JLabel commCustomerTypeLabel = new JLabel("Customer Type:");
        commCustomerTypeLabel.setBounds(20, 30, 150, 30);
        commercialPanel.add(commCustomerTypeLabel);

        JComboBox<String> commCustomerTypeCombo = new JComboBox<>(customerTypes);
        commCustomerTypeCombo.setBounds(180, 30, 150, 30);
        commercialPanel.add(commCustomerTypeCombo);

        // Organization Name (replaces Customer Name)
        JLabel organizationLabel = new JLabel("Organization Name:");
        organizationLabel.setBounds(20, 80, 150, 30);
        commercialPanel.add(organizationLabel);

        JTextField organizationField = new JTextField();
        organizationField.setBounds(180, 80, 150, 30);
        commercialPanel.add(organizationField);

        // Business License Number (replaces Citizenship)
        JLabel businessLicenseLabel = new JLabel("Business License No:");
        businessLicenseLabel.setBounds(20, 130, 150, 30);
        commercialPanel.add(businessLicenseLabel);

        JTextField businessLicenseField = new JTextField();
        businessLicenseField.setBounds(180, 130, 150, 30);
        commercialPanel.add(businessLicenseField);

        // Booking ID
        JLabel commBookingIdLabel = new JLabel("Booking ID:");
        commBookingIdLabel.setBounds(20, 180, 150, 30);
        commercialPanel.add(commBookingIdLabel);

        JTextField commBookingIdField = new JTextField();
        commBookingIdField.setBounds(180, 180, 150, 30);
        commercialPanel.add(commBookingIdField);

        // Month
        JLabel commMonthLabel = new JLabel("Month:");
        commMonthLabel.setBounds(20, 230, 150, 30);
        commercialPanel.add(commMonthLabel);

        JComboBox<String> commMonthCombo = new JComboBox<>(months);
        commMonthCombo.setBounds(180, 230, 150, 30);
        commercialPanel.add(commMonthCombo);

        // Cylinder ID
        JLabel commCylinderIdLabel = new JLabel("Cylinder ID:");
        commCylinderIdLabel.setBounds(20, 280, 150, 30);
        commercialPanel.add(commCylinderIdLabel);

        JTextField commCylinderIdField = new JTextField();
        commCylinderIdField.setBounds(180, 280, 150, 30);
        commercialPanel.add(commCylinderIdField);

        // Quantity of Order
        JLabel commQuantityLabel = new JLabel("Quantity of Order:");
        commQuantityLabel.setBounds(20, 330, 150, 30);
        commercialPanel.add(commQuantityLabel);

        JTextField commQuantityField = new JTextField();
        commQuantityField.setBounds(180, 330, 150, 30);
        commercialPanel.add(commQuantityField);

        // Weight
        JLabel commWeightLabel = new JLabel("Weight (Kg):");
        commWeightLabel.setBounds(20, 380, 150, 30);
        commercialPanel.add(commWeightLabel);

        JComboBox<Double> commWeightCombo = new JComboBox<>(weightList);
        commWeightCombo.setBounds(180, 380, 150, 30);
        commercialPanel.add(commWeightCombo);

        // Base Price
        JLabel commBasePriceLabel = new JLabel("Base Price:");
        commBasePriceLabel.setBounds(20, 430, 150, 30);
        commercialPanel.add(commBasePriceLabel);

        JTextField commBasePriceField = new JTextField();
        commBasePriceField.setBounds(180, 430, 150, 30);
        commercialPanel.add(commBasePriceField);

        // NO SUBSIDY AMOUNT for Commercial

        // Buttons
        JButton commAddButton = new JButton("Add Booking");
        commAddButton.setBounds(30, 480, 140, 35);
        commAddButton.setFont(new Font("Arial", Font.BOLD, 12));
        commercialPanel.add(commAddButton);

        JButton commClearButton = new JButton("Clear");
        commClearButton.setBounds(180, 480, 140, 35);
        commClearButton.setFont(new Font("Arial", Font.BOLD, 12));
        commercialPanel.add(commClearButton);

        add(commercialPanel);

        // ===== TEXT DISPLAY AREA =====
        JPanel textDisplayPanel = new JPanel();
        textDisplayPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Booking Information Display",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        textDisplayPanel.setLayout(null);
        textDisplayPanel.setBounds(830, 10, 350, 400);

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(10, 20, 330, 360);
        textDisplayPanel.add(scrollPane);

        add(textDisplayPanel);

        // ===== OPERATION PANEL (Input and Buttons) =====
        JPanel operationPanel = new JPanel();
        operationPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Operations",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        operationPanel.setLayout(null);
        operationPanel.setBounds(830, 420, 350, 350);

        // Search Label and Field
        JLabel searchLabel = new JLabel("Search Booking ID:");
        searchLabel.setBounds(20, 30, 130, 30);
        operationPanel.add(searchLabel);

        JTextField searchField = new JTextField();
        searchField.setBounds(160, 30, 160, 30);
        operationPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(20, 80, 100, 35);
        operationPanel.add(searchButton);

        // Update Button
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(130, 80, 100, 35);
        operationPanel.add(updateButton);

        // Delete Button
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(240, 80, 100, 35);
        operationPanel.add(deleteButton);

        // View All Button
        JButton viewAllButton = new JButton("View All Bookings");
        viewAllButton.setBounds(20, 130, 150, 35);
        operationPanel.add(viewAllButton);

        // Print Button
        JButton printButton = new JButton("Print");
        printButton.setBounds(180, 130, 100, 35);
        operationPanel.add(printButton);

        // Clear Display Button
        JButton clearDisplayButton = new JButton("Clear Display");
        clearDisplayButton.setBounds(20, 180, 150, 35);
        operationPanel.add(clearDisplayButton);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(180, 180, 100, 35);
        operationPanel.add(exitButton);

        add(operationPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new NOCAPPJPanel();
    }
}