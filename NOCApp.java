import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NOCApp extends JFrame {

    public NOCApp() {

        setTitle("LPG Cylinder Booking Management System");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // customer type
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

        // Cylinder Type
        JLabel cylinderTypeLabel = new JLabel("Cylinder Type:");
        cylinderTypeLabel.setBounds(30, 480, 150, 30);
        add(cylinderTypeLabel);

        String[] cylinderTypes = { "14.2 Kg", "19 Kg", "47.5 Kg" };
        JComboBox<String> cylinderTypeComboBox = new JComboBox<>(cylinderTypes);
        cylinderTypeComboBox.setBounds(200, 480, 200, 30);
        add(cylinderTypeComboBox);

        // Quantity of Ordered Cylinders
        JLabel quantityLabel = new JLabel("Quantity of Order:");
        quantityLabel.setBounds(30, 530, 200, 30);
        add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(200, 530, 200, 30);
        add(quantityField);

        // Weight
        // Weight
        JLabel weightLabel = new JLabel("Weight (Kg):");
        weightLabel.setBounds(30, 580, 150, 30);
        add(weightLabel);

        String[] weight = { "14 kg", "16 Kg", "18 Kg" };
        JComboBox<String> weightComboBox = new JComboBox<>(weight);
        weightComboBox.setBounds(200, 580, 200, 30);
        add(weightComboBox);
    
        // Base Price
        JLabel basePriceLabel = new JLabel("Base Price:");
        basePriceLabel.setBounds(30, 630, 150, 30);
        add(basePriceLabel);

        JTextField basePriceField = new JTextField();
        basePriceField.setBounds(200, 630, 200, 30);
        add(basePriceField);

        // Subsidy Amount (Domestic only)
        JLabel subsidyLabel = new JLabel("Subsidy Amount (Domestic):");
        subsidyLabel.setBounds(30, 680, 200, 30);
        add(subsidyLabel);

        JTextField subsidyField = new JTextField("0.0");
        subsidyField.setBounds(200, 680, 200, 30);
        add(subsidyField);


        //Add Domestic Cylinder
        JButton addDomesticButton = new JButton("Add Domestic Cylinder");
        addDomesticButton.setBounds(460, 30, 200, 35);
        add(addDomesticButton);

        //Add Commercial Cylinder
        JButton addCommercialButton = new JButton("Add Commercial Cylinder");
        addCommercialButton.setBounds(460, 80, 200, 35);
        add(addCommercialButton);

        //Calculate Bulk Discount
        JButton calculateDiscountButton = new JButton("Calculate Bulk Discount");
        calculateDiscountButton.setBounds(460, 130, 200, 35);
        add(calculateDiscountButton);

        //Calculate Price after Subsidy
        JButton calculatePriceButton = new JButton("Calculate Price after Subsidy");
        calculatePriceButton.setBounds(460, 180, 200, 35);
        add(calculatePriceButton);

        //Identify Cylinder Type
        JButton identifyTypeButton = new JButton("Identify Cylinder Type");
        identifyTypeButton.setBounds(460, 230, 200, 35);
        add(identifyTypeButton);

        //Display All
        JButton displayAllButton = new JButton("Display All");
        displayAllButton.setBounds(460, 280, 200, 35);
        add(displayAllButton);

        //Export to File
        JButton exportButton = new JButton("Export to File");
        exportButton.setBounds(460, 330, 200, 35);
        add(exportButton);

        //Load From File
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