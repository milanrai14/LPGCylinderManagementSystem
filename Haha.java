import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Haha extends JFrame {
        final int CITIZENSHIP_LENGTH = 12;
        ArrayList<LPGCylinder> cylinders = new ArrayList<LPGCylinder>();

        public boolean validateCylinderAndBookingIds(String cylinderId, String bookingId) {
                if (cylinderId == null || cylinderId.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Cylinder Id cannot be empty");
                        return false;
                }
                if (!cylinderId.matches("NOC-\\d{3}")) {
                        JOptionPane.showMessageDialog(this, "Invalid Cylinder ID Format. Use NOC-000 Format");
                        return false;
                }
                for (LPGCylinder cylinder : cylinders) {
                        if (cylinder.getCylinderId().equals(cylinderId)) {
                                JOptionPane.showMessageDialog(this,
                                                "Cylinder ID already exists. Please use a unique ID.",
                                                "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return false;
                        }
                }

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

        public boolean isEligibleForSubsidy(String cizitenshipNumber, int quantity){
                boolean validCitizenship = cizitenshipNumber != null && cizitenshipNumber.trim().length() == CITIZENSHIP_LENGTH;
                boolean withInQuota = quantity <= 2;
                return validCitizenship && withInQuota;
        }

        public Haha() {
                setTitle("LPG Cylinder Booking Management System");
                setSize(1000, 820);
                setLocationRelativeTo(null);
                getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);

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

                JLabel domCustTypeLabel = new JLabel("Customer Type:");
                domCustTypeLabel.setBounds(20, 30, 140, 25);
                domesticPanel.add(domCustTypeLabel);

                String[] customerTypes = { "Select One", "Domestic", "Comercial" };
                JComboBox<String> domCustTypeCombo = new JComboBox<>(customerTypes);
                domCustTypeCombo.setBounds(170, 30, 230, 25);
                domesticPanel.add(domCustTypeCombo);

                JLabel domNameLabel = new JLabel("Customer Name:");
                domNameLabel.setBounds(20, 65, 140, 25);
                domesticPanel.add(domNameLabel);
                JTextField domNameField = new JTextField();
                domNameField.setBounds(170, 65, 230, 25);
                domesticPanel.add(domNameField);

                JLabel domCitizenshipLabel = new JLabel("Citizenship Number:");
                domCitizenshipLabel.setBounds(20, 100, 140, 25);
                domesticPanel.add(domCitizenshipLabel);
                JTextField domCitizenshipField = new JTextField();
                domCitizenshipField.setBounds(170, 100, 230, 25);
                domesticPanel.add(domCitizenshipField);

                JLabel domBookingLabel = new JLabel("Booking ID:");
                domBookingLabel.setBounds(20, 135, 140, 25);
                domesticPanel.add(domBookingLabel);
                JTextField domBookingField = new JTextField();
                domBookingField.setBounds(170, 135, 230, 25);
                domesticPanel.add(domBookingField);

                JLabel domMonthLabel = new JLabel("Month:");
                domMonthLabel.setBounds(20, 170, 140, 25);
                domesticPanel.add(domMonthLabel);
                String[] months = { "January", "February", "March", "April", "May", "June",
                                "July", "August", "September", "October", "November", "December" };
                JComboBox<String> domMonthCombo = new JComboBox<>(months);
                domMonthCombo.setBounds(170, 170, 230, 25);
                domesticPanel.add(domMonthCombo);

                JLabel domCylinderLabel = new JLabel("Cylinder ID:");
                domCylinderLabel.setBounds(20, 205, 140, 25);
                domesticPanel.add(domCylinderLabel);
                JTextField domCylinderField = new JTextField();
                domCylinderField.setBounds(170, 205, 230, 25);
                domesticPanel.add(domCylinderField);

                JLabel domQtyLabel = new JLabel("Quantity of Order:");
                domQtyLabel.setBounds(20, 240, 140, 25);
                domesticPanel.add(domQtyLabel);
                JTextField domQtyField = new JTextField();
                domQtyField.setBounds(170, 240, 230, 25);
                domesticPanel.add(domQtyField);

                JLabel domWeightLabel = new JLabel("Weight (Kg):");
                domWeightLabel.setBounds(20, 275, 140, 25);
                domesticPanel.add(domWeightLabel);
                Double[] weightList = { 14.0, 16.0, 18.0 };
                JComboBox<Double> domWeightCombo = new JComboBox<>(weightList);
                domWeightCombo.setBounds(170, 275, 230, 25);
                domesticPanel.add(domWeightCombo);

                JLabel domBasePriceLabel = new JLabel("Base Price:");
                domBasePriceLabel.setBounds(20, 310, 140, 25);
                domesticPanel.add(domBasePriceLabel);
                JTextField domBasePriceField = new JTextField();
                domBasePriceField.setBounds(170, 310, 230, 25);
                domesticPanel.add(domBasePriceField);

                JLabel domSubsidyLabel = new JLabel("Subsidy Amount:");
                domSubsidyLabel.setBounds(20, 345, 140, 25);
                domesticPanel.add(domSubsidyLabel);
                JTextField domSubsidyField = new JTextField("0.0");
                domSubsidyField.setBounds(170, 345, 230, 25);
                domesticPanel.add(domSubsidyField);

                // Domestic Buttons
                JButton addDomesticBtn = new JButton("Add Domestic Cylinder");
                addDomesticBtn.setBounds(50, 385, 160, 32);
                domesticPanel.add(addDomesticBtn);

                // Display Area
                JTextArea displayArea = new JTextArea();
                displayArea.setEditable(false);
                displayArea.setLineWrap(true);
                displayArea.setWrapStyleWord(true);

                // Add domestic cylinder register
                addDomesticBtn.addActionListener(e -> {
                        String customerType = (String) domCustTypeCombo.getSelectedItem();
                        if (!"Domestic".equals(customerType)) {
                                JOptionPane.showMessageDialog(this,
                                                "This section is only for Domestic Cylinder! \n"
                                                                + "Please select 'Domestic' from the dropdown",
                                                "Invalid Cylinder Type", JOptionPane.ERROR_MESSAGE);
                        }
                        String customerName = domNameField.getText().trim();
                        String citizenshipNumber = domCitizenshipField.getText().trim();
                        String bookingId = domBookingField.getText().trim();
                        String bookingMonth = (String) domMonthCombo.getSelectedItem();
                        String cylinderId = domCylinderField.getText().trim();
                        int quantity = Integer.parseInt(domQtyField.getText());
                        double weight = (Double) domWeightCombo.getSelectedItem();
                        double basePrice = Double.parseDouble(domBasePriceField.getText());
                        double subsidyAmount = Double.parseDouble(domSubsidyField.getText());

                        if (!customerName.matches("^[A-Za-z]+ [A-Za-z]+$")) {
                                JOptionPane.showMessageDialog(this,
                                                "Invalid name format. Please enter first and last name.",
                                                "Validation Error", JOptionPane.ERROR_MESSAGE);
                                return;
                        }

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

                        if (!validateCylinderAndBookingIds(cylinderId, bookingId)|| !validateQuantityAndBasePrice(quantity, basePrice)) {
                                return;
                        }

                        if(basePrice < subsidyAmount){
                                JOptionPane.showMessageDialog(this, "Subsidy Amount cannot be greater than base price", "validation Error", JOptionPane.ERROR_MESSAGE);
                                return;
                        }
                        
                        if(!isEligibleForSubsidy(citizenshipNumber, quantity)){
                                JOptionPane.showMessageDialog(this, "Customer is not eligible for subsify. \n Subsidy will be set to 0.");
                                subsidyAmount = 0.0;
                        }

                        DomesticCylinder domestic = new DomesticCylinder(cylinderId, cylinderId, bookingId, basePrice, weight, bookingMonth, customerName, subsidyAmount, citizenshipNumber, quantity);
                        cylinders.add(domestic);
                        displayArea.append("\n" + domestic.display());

                });

                JButton clearDomesticBtn = new JButton(
                                "Clear Domestic Form");
                clearDomesticBtn.setBounds(230, 385, 160, 32);
                domesticPanel.add(clearDomesticBtn);

                // COMMERCIAL PANEL
                JPanel commercialPanel = new JPanel();
                commercialPanel.setBorder(
                                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
                                                "Commercial Cylinder Booking", TitledBorder.CENTER, TitledBorder.TOP));
                commercialPanel.setLayout(null);
                commercialPanel.setBounds(510, 10, 450, 430);

                add(commercialPanel);

                // Commercial Fields
                JLabel comCustTypeLabel = new JLabel("Customer Type:");
                comCustTypeLabel.setBounds(20, 30, 140, 25);
                commercialPanel.add(comCustTypeLabel);

                JComboBox<String> comCustTypeCombo = new JComboBox<>(customerTypes);
                comCustTypeCombo.setBounds(170, 30, 230, 25);
                commercialPanel.add(comCustTypeCombo);

                JLabel comNameLabel = new JLabel("Company Name:");
                comNameLabel.setBounds(20, 65, 140, 25);
                commercialPanel.add(comNameLabel);

                JTextField comNameField = new JTextField();
                comNameField.setBounds(170, 65, 230, 25);
                commercialPanel.add(comNameField);

                JLabel comAddressLabel = new JLabel("Company Address:");
                comAddressLabel.setBounds(20, 100, 140, 25);
                commercialPanel.add(comAddressLabel);

                JTextField comAddressField = new JTextField();
                comAddressField.setBounds(170, 100, 230, 25);
                commercialPanel.add(comAddressField);

                JLabel comLicenseLabel = new JLabel("Business License:");
                comLicenseLabel.setBounds(20, 135, 140, 25);
                commercialPanel.add(comLicenseLabel);

                JTextField comLicenseField = new JTextField();
                comLicenseField.setBounds(170, 135, 230, 25);
                commercialPanel.add(comLicenseField);

                JLabel comBookingIdLabel = new JLabel("Booking ID:");
                comBookingIdLabel.setBounds(20, 170, 140, 25);
                commercialPanel.add(comBookingIdLabel);

                JTextField comBookingIdField = new JTextField();
                comBookingIdField.setBounds(170, 170, 230, 25);
                commercialPanel.add(comBookingIdField);

                JLabel comCylinderIdLabel = new JLabel("Cylinder ID:");
                comCylinderIdLabel.setBounds(20, 205, 140, 25);
                commercialPanel.add(comCylinderIdLabel);

                JTextField comCylinderIdField = new JTextField();
                comCylinderIdField.setBounds(170, 205, 230, 25);
                commercialPanel.add(comCylinderIdField);

                JLabel comMonthLabel = new JLabel("Month:");
                comMonthLabel.setBounds(20, 240, 140, 25);
                commercialPanel.add(comMonthLabel);

                JComboBox<String> comMonthCombo = new JComboBox<>(months);
                comMonthCombo.setBounds(170, 240, 230, 25);
                commercialPanel.add(comMonthCombo);

                JLabel comQuantityLabel = new JLabel("Quantity of Cylinders:");
                comQuantityLabel.setBounds(20, 275, 140, 25);
                commercialPanel.add(comQuantityLabel);

                JTextField comQuantityField = new JTextField();
                comQuantityField.setBounds(170, 275, 230, 25);
                commercialPanel.add(comQuantityField);

                JLabel comWeightLabel = new JLabel("Cylinder Weight:");
                comWeightLabel.setBounds(20, 310, 140, 25);
                commercialPanel.add(comWeightLabel);

                JComboBox<Double> comWeightCombo = new JComboBox<>(weightList);
                comWeightCombo.setBounds(170, 310, 230, 25);
                commercialPanel.add(comWeightCombo);

                JLabel comBasePriceLabel = new JLabel("Base Price:");
                comBasePriceLabel.setBounds(20, 345, 140, 25);
                commercialPanel.add(comBasePriceLabel);

                JTextField comBasePriceField = new JTextField();
                comBasePriceField.setBounds(170, 345, 230, 25);
                commercialPanel.add(comBasePriceField);

                JButton addComBtn = new JButton("Add Commercial Cylinder");
                addComBtn.setBounds(40, 385, 170, 35);
                commercialPanel.add(addComBtn);

                JButton clearComBtn = new JButton("Clear Form");
                clearComBtn.setBounds(220, 385, 170, 35);
                commercialPanel.add(clearComBtn);


                JScrollPane scrollPane = new JScrollPane(displayArea);
                scrollPane.setBounds(20, 460, 940, 200);
                scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
                                "Booking Records Display", TitledBorder.CENTER, TitledBorder.TOP));

                add(scrollPane);

                // Action Buttons
                JPanel actionPanel = new JPanel();
                actionPanel.setLayout(null);
                actionPanel.setBounds(20, 680, 940, 80);

                actionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
                                "Actions", TitledBorder.CENTER, TitledBorder.TOP));

                actionPanel.setLayout(null);

                JLabel cylinderIdLabel = new JLabel("Cylinder ID:");
                cylinderIdLabel.setBounds(15, 30, 75, 25);
                actionPanel.add(cylinderIdLabel);

                JTextField cylinderIdField = new JTextField();
                cylinderIdField.setBounds(95, 30, 120, 28);
                actionPanel.add(cylinderIdField);

                JButton bulkDiscountBtn = new JButton("Bulk Discount");
                bulkDiscountBtn.setBounds(225, 28, 130, 30);
                actionPanel.add(bulkDiscountBtn);

                JButton subsidyBtn = new JButton("Price After Subsidy");
                subsidyBtn.setBounds(365, 28, 155, 30);
                actionPanel.add(subsidyBtn);

                JButton displayBtn = new JButton("Display");
                displayBtn.setBounds(530, 28, 90, 30);
                actionPanel.add(displayBtn);

                JButton identifyBtn = new JButton("Identify Type");
                identifyBtn.setBounds(630, 28, 125, 30);
                actionPanel.add(identifyBtn);

                JButton exportBtn = new JButton("Export");
                exportBtn.setBounds(765, 28, 80, 30);
                actionPanel.add(exportBtn);

                JButton loadBtn = new JButton("Load");
                loadBtn.setBounds(850, 28, 75, 30);
                actionPanel.add(loadBtn);

                add(actionPanel);
                setVisible(true);
        }

        public static void main(String[] args) {
                new Haha();
        }
}