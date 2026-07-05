import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NOCApp extends JFrame {

    public NOCApp() {

        setTitle("NEA Electricity Billing System");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Customer Type
        JLabel customerTypeLabel = new JLabel("Customer Type:");
        customerTypeLabel.setBounds(30, 30, 150, 30);
        add(customerTypeLabel);

        String[] customerTypes = { "Select One", "Domestic", "Commercial" };
        JComboBox<String> customerTypeComboBox = new JComboBox<>(customerTypes);
        customerTypeComboBox.setBounds(200, 30, 200, 30);
        add(customerTypeComboBox);

        // Customer ID
        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(30, 80, 150, 30);
        add(customerIdLabel);

        JTextField customerIdField = new JTextField();
        customerIdField.setBounds(200, 80, 200, 30);
        add(customerIdField);

        // Customer Name (Domestic)
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(30, 130, 150, 30);
        add(customerNameLabel);

        JTextField customerNameField = new JTextField();
        customerNameField.setBounds(200, 130, 200, 30);
        add(customerNameField);

        // Organization Name (Commercial)
        JLabel organizationLabel = new JLabel("Organization Name:");
        organizationLabel.setBounds(30, 180, 150, 30);
        add(organizationLabel);

        JTextField organizationField = new JTextField();
        organizationField.setBounds(200, 180, 200, 30);
        add(organizationField);

        // Citizenship Number (Domestic)
        JLabel citizenshipLabel = new JLabel("Citizenship Number:");
        citizenshipLabel.setBounds(30, 230, 150, 30);
        add(citizenshipLabel);

        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(200, 230, 200, 30);
        add(citizenshipField);

        // Business License Number (Commercial)
        JLabel businessLabel = new JLabel("Business License Number:");
        businessLabel.setBounds(30, 280, 170, 30);
        add(businessLabel);

        JTextField businessField = new JTextField();
        businessField.setBounds(200, 280, 200, 30);
        add(businessField);

        // Cylinder ID
        JLabel cylinderIdLabel = new JLabel("Cylinder ID:");
        cylinderIdLabel.setBounds(30, 330, 150, 30);
        add(cylinderIdLabel);

        JTextField cylinderIdField = new JTextField();
        cylinderIdField.setBounds(200, 330, 200, 30);
        add(cylinderIdField);

        // Cylinder Type
        JLabel cylinderTypeLabel = new JLabel("Cylinder Type:");
        cylinderTypeLabel.setBounds(30, 380, 150, 30);
        add(cylinderTypeLabel);

        String[] cylinderTypes = { "14.2 Kg", "19 Kg", "47.5 Kg" };
        JComboBox<String> cylinderTypeComboBox = new JComboBox<>(cylinderTypes);
        cylinderTypeComboBox.setBounds(200, 380, 200, 30);
        add(cylinderTypeComboBox);

        // Booking ID
        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(30, 430, 150, 30);
        add(bookingIdLabel);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(200, 430, 200, 30);
        add(bookingIdField);

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

        JTextField weightField = new JTextField();
        weightField.setBounds(200, 530, 200, 30);
        add(weightField);

        // Base Price
        JLabel basePriceLabel = new JLabel("Base Price:");
        basePriceLabel.setBounds(30, 580, 150, 30);
        add(basePriceLabel);

        JTextField basePriceField = new JTextField();
        basePriceField.setBounds(200, 580, 200, 30);
        add(basePriceField);

        // Subsidy Amount (Domestic)
        JLabel subsidyLabel = new JLabel("Subsidy Amount:");
        subsidyLabel.setBounds(30, 630, 150, 30);
        add(subsidyLabel);

        JTextField subsidyField = new JTextField("0.0");
        subsidyField.setBounds(200, 630, 200, 30);
        add(subsidyField);

        // Buttons - moved closer to input fields
        JButton addDomesticButton = new JButton("Add Domestic");
        addDomesticButton.setBounds(440, 30, 150, 35);
        add(addDomesticButton);

        JButton addCommercialButton = new JButton("Add Commercial");
        addCommercialButton.setBounds(440, 80, 150, 35);
        add(addCommercialButton);

        JButton calculatePriceButton = new JButton("Calculate Price");
        calculatePriceButton.setBounds(440, 130, 150, 35);
        add(calculatePriceButton);

        JButton displayAllButton = new JButton("Display All");
        displayAllButton.setBounds(440, 180, 150, 35);
        add(displayAllButton);

        JButton identifyTypeButton = new JButton("Identify Type");
        identifyTypeButton.setBounds(440, 230, 150, 35);
        add(identifyTypeButton);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.setBounds(440, 280, 150, 35);
        add(clearButton);

        JButton saveButton = new JButton("Save to File");
        saveButton.setBounds(440, 330, 150, 35);
        add(saveButton);

        JButton loadButton = new JButton("Load from File");
        loadButton.setBounds(440, 380, 150, 35);
        add(loadButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(440, 430, 150, 35);
        add(exitButton);

        // Display Area
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(630, 30, 500, 630);
        add(scrollPane);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new NOCApp();
    }
}