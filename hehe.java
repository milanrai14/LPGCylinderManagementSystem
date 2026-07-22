import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class hehe {
     JLabel comNameLabel = new JLabel("Customer Name:");
        comNameLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comNameLabel);
        JTextField comNameField = new JTextField();
        comNameField.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comNameField);
        yPos += gap;

        JLabel comCitizenshipLabel = new JLabel("Citizenship Number:");
        comCitizenshipLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comCitizenshipLabel);
        JTextField comCitizenshipField = new JTextField();
        comCitizenshipField.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comCitizenshipField);
        yPos += gap;

        JLabel comBookingLabel = new JLabel("Booking ID:");
        comBookingLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comBookingLabel);
        JTextField comBookingField = new JTextField();
        comBookingField.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comBookingField);
        yPos += gap;

        JLabel comMonthLabel = new JLabel("Month:");
        comMonthLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comMonthLabel);
        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        JComboBox<String> comMonthCombo = new JComboBox<>(months);
        comMonthCombo.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comMonthCombo);
        yPos += gap;

        JLabel comCylinderLabel = new JLabel("Cylinder ID:");
        comCylinderLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comCylinderLabel);
        JTextField comCylinderField = new JTextField();
        comCylinderField.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comCylinderField);
        yPos += gap;

        JLabel comQtyLabel = new JLabel("Quantity of Order:");
        comQtyLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comQtyLabel);
        JTextField comQtyField = new JTextField();
        comQtyField.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comQtyField);
        yPos += gap;

        JLabel comWeightLabel = new JLabel("Weight (Kg):");
        comWeightLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comWeightLabel);
        Double[] weightList = { 14.0, 16.0, 18.0 };
        JComboBox<Double> comWeightCombo = new JComboBox<>(weightList);
        comWeightCombo.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comWeightCombo);
        yPos += gap;

        JLabel comBasePriceLabel = new JLabel("Base Price:");
        comBasePriceLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comBasePriceLabel);
        JTextField comBasePriceField = new JTextField();
        comBasePriceField.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comBasePriceField);
        yPos += gap;

        JLabel comSubsidyLabel = new JLabel("Subsidy Amount:");
        comSubsidyLabel.setBounds(labelX, yPos, 140, 25);
        comesticPanel.add(comSubsidyLabel);
        JTextField comSubsidyField = new JTextField("0.0");
        comSubsidyField.setBounds(fieldX, yPos, fieldWidth, 25);
        comesticPanel.add(comSubsidyField);

        // comestic Buttons at bottom
        JButton addComBtn = new JButton("Add comestic Cylinder");
        addComBtn.setBounds(50, 350, 160, 32);
        // addcomesticBtn.setFont(new Font("Arial", Font.BOLD, 11));
        comercialPanel.add(addcomesticBtn);

        JButton clearcomesticBtn = new JButton("Clear comestic Form");
        clearcomesticBtn.setBounds(230, 350, 160, 32);
        // clearcomesticBtn.setFont(new Font("Arial", Font.BOLD, 11));
        comesticPanel.add(clearcomesticBtn);
}
