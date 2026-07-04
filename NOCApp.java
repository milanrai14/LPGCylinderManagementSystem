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
    ArrayList<LPGCylinder> cylinders = new ArrayList<LPGCylinder>();


    public NOCApp() {

        setTitle("NEA Electricity Billing System");
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Customer Type
        JLabel customerTypeLabel = new JLabel("Customer Type:");
        customerTypeLabel.setBounds(30, 30, 150, 30);
        add(customerTypeLabel);

        String[] types = { "Select One", "Residential", "Commercial" };
        JComboBox<String> customerTypeComboBox = new JComboBox<>(types);
        customerTypeComboBox.setBounds(200, 30, 200, 30);
        add(customerTypeComboBox);

        // Customer ID
        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(30, 80, 150, 30);
        add(customerIdLabel);

        JTextField customerIdField = new JTextField();
        customerIdField.setBounds(200, 80, 200, 30);
        add(customerIdField);

        // Customer Name
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(30, 130, 150, 30);
        add(customerNameLabel);

        JTextField customerNameField = new JTextField();
        customerNameField.setBounds(200, 130, 200, 30);
        add(customerNameField);

        // Units Consumed
        JLabel unitsLabel = new JLabel("Units Consumed:");
        unitsLabel.setBounds(30, 180, 150, 30);
        add(unitsLabel);

        JTextField unitsField = new JTextField();
        unitsField.setBounds(200, 180, 200, 30);
        add(unitsField);

        // Rate Per Unit
        JLabel rateLabel = new JLabel("Rate Per Unit:");
        rateLabel.setBounds(30, 230, 150, 30);
        add(rateLabel);

        JTextField rateField = new JTextField();
        rateField.setBounds(200, 230, 200, 30);
        add(rateField);

        // Citizenship Number
        JLabel citizenshipLabel = new JLabel("Citizenship Number:");
        citizenshipLabel.setBounds(30, 280, 150, 30);
        add(citizenshipLabel);

        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(200, 280, 200, 30);

        add(citizenshipField);

        // Subsidy Amount
        JLabel subsidyLabel = new JLabel("Subsidy Amount:");
        subsidyLabel.setBounds(30, 330, 150, 30);
        add(subsidyLabel);

        JTextField subsidyField = new JTextField("0.0");
        subsidyField.setBounds(200, 330, 200, 30);
        add(subsidyField);

        // Business Registration Number
        JLabel businessLabel = new JLabel("Business Registration Number:");
        businessLabel.setBounds(30, 380, 180, 30);
        add(businessLabel);

        JTextField businessField = new JTextField();
        businessField.setBounds(220, 380, 180, 30);
        add(businessField);

        // Display Area
        JTextArea displayArea = new JTextArea();
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(30, 450, 500, 300);
        add(scrollPane);

        // Buttons
        JButton addResidentialButton = new JButton("Add Residential Customer");
        addResidentialButton.setBounds(600, 30, 220, 40);
        add(addResidentialButton);

        // Listener register gareeko using lamda expression
        addResidentialButton.addActionListener(e -> {
            String customerType = (String) customerTypeComboBox.getSelectedItem();
            System.out.println(customerType);
            String customerId = customerIdField.getText();
            System.out.println(customerId);
            String customerName = customerNameField.getText();
            System.out.println(customerName);
            String units = unitsField.getText();
            System.out.println(units);
            String rate = rateField.getText();
            System.out.println(rate);

            if (!"Residential".equals(customerType)) {
                JOptionPane.showMessageDialog(null,
                        "This button is only for Residential customers!\n" +
                                "Please select 'Residential' from the dropdown.",
                        "Invalid Customer Type",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (customerId.trim().isEmpty() || units.trim().isEmpty() || rate.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter the valid requirement", "Invalid Entry",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null,
                    "Customer added successfully!\n" +
                            "Type: " + customerType + "\n" +
                            "ID: " + customerId + "\n" +
                            "Name: " + customerName + "\n" +
                            "Units: " + units + "\n" +
                            "Rate: " + rate,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            displayArea.append("Customer Added Successfully\n");
            displayArea.append("--------------------------------------\n");
            displayArea.append("Type: " + customerType + "\n");
            displayArea.append("ID: " + customerId + "\n");
            displayArea.append("Name: " + customerName + "\n");
            displayArea.append("Units: " + units + "\n");
            displayArea.append("Rate: " + rate + "\n");
            displayArea.append("--------------------------------------\n");

        });

        JButton addCommercialButton = new JButton("Add Commercial Customer");
        addCommercialButton.setBounds(600, 80, 220, 40);
        add(addCommercialButton);

        // Listner register for commercial
        addCommercialButton.addActionListener(e -> {
            String customerType = (String) customerTypeComboBox.getSelectedItem();
            System.out.println(customerType);
            String customerId = customerIdField.getText();
            System.out.println(customerId);
            String customerName = customerNameField.getText();
            System.out.println(customerName);
            String units = unitsField.getText();
            System.out.println(units);
            String rate = rateField.getText();
            System.out.println(rate);

            if (!"Commercial".equals(customerType)) {
                JOptionPane.showMessageDialog(null,
                        "This button is only for Commerical customers!\n" +
                                "Please select 'Residential' from the dropdown.",
                        "Invalid Customer Type",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (customerId.trim().isEmpty() || units.trim().isEmpty() || rate.trim().isEmpty()
                    || customerName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter the valid requirement", "Invalid Entry",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null,
                    "Customer added successfully!\n" +
                            "Type: " + customerType + "\n" +
                            "ID: " + customerId + "\n" +
                            "Name: " + customerName + "\n" +
                            "Units: " + units + "\n" +
                            "Rate: " + rate,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        JButton calculateButton = new JButton("Calculate Bill");
        calculateButton.setBounds(600, 130, 220, 40);
        add(calculateButton);

        // Listner of calculation
        calculateButton.addActionListener(e -> {

        });

        JButton displayAllButton = new JButton("Display All Customers");
        displayAllButton.setBounds(600, 180, 220, 40);
        add(displayAllButton);

        JButton identifyTypeButton = new JButton("Identify Customer Type");
        identifyTypeButton.setBounds(600, 230, 220, 40);
        add(identifyTypeButton);

        JButton clearFieldsButton = new JButton("Clear Fields");
        clearFieldsButton.setBounds(600, 280, 220, 40);
        add(clearFieldsButton);

        JButton saveButton = new JButton("Save to File");
        saveButton.setBounds(600, 330, 220, 40);
        add(saveButton);

        JButton loadButton = new JButton("Load from File");
        loadButton.setBounds(600, 380, 220, 40);
        add(loadButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new NOCApp();
    }
}