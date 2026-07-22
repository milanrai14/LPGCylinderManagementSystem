import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Haha extends JFrame {
    public Haha() {

        setTitle("LPG Cylinder Booking Management System");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ==================== DOMESTIC PANEL ====================
        JPanel domesticPanel = new JPanel();
        domesticPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Domestic Cylinder Booking",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        domesticPanel.setLayout(null);
        domesticPanel.setBounds(10, 10, 450, 400);

        // Domestic Fields - All exact positions
        JLabel domNameLabel = new JLabel("Customer Name:");
        domNameLabel.setBounds(20, 30, 140, 25);
        domesticPanel.add(domNameLabel);
        JTextField domNameField = new JTextField();
        domNameField.setBounds(170, 30, 230, 25);
        domesticPanel.add(domNameField);

        JLabel domCitizenshipLabel = new JLabel("Citizenship Number:");
        domCitizenshipLabel.setBounds(20, 65, 140, 25);
        domesticPanel.add(domCitizenshipLabel);
        JTextField domCitizenshipField = new JTextField();
        domCitizenshipField.setBounds(170, 65, 230, 25);
        domesticPanel.add(domCitizenshipField);

        JLabel domBookingLabel = new JLabel("Booking ID:");
        domBookingLabel.setBounds(20, 100, 140, 25);
        domesticPanel.add(domBookingLabel);
        JTextField domBookingField = new JTextField();
        domBookingField.setBounds(170, 100, 230, 25);
        domesticPanel.add(domBookingField);

        JLabel domMonthLabel = new JLabel("Month:");
        domMonthLabel.setBounds(20, 135, 140, 25);
        domesticPanel.add(domMonthLabel);
        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        JComboBox<String> domMonthCombo = new JComboBox<>(months);
        domMonthCombo.setBounds(170, 135, 230, 25);
        domesticPanel.add(domMonthCombo);

        JLabel domCylinderLabel = new JLabel("Cylinder ID:");
        domCylinderLabel.setBounds(20, 170, 140, 25);
        domesticPanel.add(domCylinderLabel);
        JTextField domCylinderField = new JTextField();
        domCylinderField.setBounds(170, 170, 230, 25);
        domesticPanel.add(domCylinderField);

        JLabel domQtyLabel = new JLabel("Quantity of Order:");
        domQtyLabel.setBounds(20, 205, 140, 25);
        domesticPanel.add(domQtyLabel);
        JTextField domQtyField = new JTextField();
        domQtyField.setBounds(170, 205, 230, 25);
        domesticPanel.add(domQtyField);

        JLabel domWeightLabel = new JLabel("Weight (Kg):");
        domWeightLabel.setBounds(20, 240, 140, 25);
        domesticPanel.add(domWeightLabel);
        Double[] weightList = { 14.0, 16.0, 18.0 };
        JComboBox<Double> domWeightCombo = new JComboBox<>(weightList);
        domWeightCombo.setBounds(170, 240, 230, 25);
        domesticPanel.add(domWeightCombo);

        JLabel domBasePriceLabel = new JLabel("Base Price:");
        domBasePriceLabel.setBounds(20, 275, 140, 25);
        domesticPanel.add(domBasePriceLabel);
        JTextField domBasePriceField = new JTextField();
        domBasePriceField.setBounds(170, 275, 230, 25);
        domesticPanel.add(domBasePriceField);

        JLabel domSubsidyLabel = new JLabel("Subsidy Amount:");
        domSubsidyLabel.setBounds(20, 310, 140, 25);
        domesticPanel.add(domSubsidyLabel);
        JTextField domSubsidyField = new JTextField("0.0");
        domSubsidyField.setBounds(170, 310, 230, 25);
        domesticPanel.add(domSubsidyField);

        // Domestic Buttons
        JButton addDomesticBtn = new JButton("Add Domestic Cylinder");
        addDomesticBtn.setBounds(50, 350, 160, 32);
        domesticPanel.add(addDomesticBtn);

        JButton clearDomesticBtn = new JButton("Clear Domestic Form");
        clearDomesticBtn.setBounds(230, 350, 160, 32);
        domesticPanel.add(clearDomesticBtn);
        add(domesticPanel);

        // ==================== COMMERCIAL PANEL ====================
        JPanel commercialPanel = new JPanel();
        commercialPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Commercial Cylinder Booking",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        commercialPanel.setLayout(null);
        commercialPanel.setBounds(500, 10, 450, 400);  // ← CHANGED: Moved to the right
        add(commercialPanel);

        // Commercial Fields - All exact positions
        JLabel comNameLabel = new JLabel("Customer Name:");
        comNameLabel.setBounds(20, 30, 140, 25);
        commercialPanel.add(comNameLabel);
        JTextField comNameField = new JTextField();
        comNameField.setBounds(170, 30, 230, 25);
        commercialPanel.add(comNameField);

        JLabel comCitizenshipLabel = new JLabel("Citizenship Number:");
        comCitizenshipLabel.setBounds(20, 65, 140, 25);
        commercialPanel.add(comCitizenshipLabel);
        JTextField comCitizenshipField = new JTextField();
        comCitizenshipField.setBounds(170, 65, 230, 25);
        commercialPanel.add(comCitizenshipField);

        JLabel comBookingLabel = new JLabel("Booking ID:");
        comBookingLabel.setBounds(20, 100, 140, 25);
        commercialPanel.add(comBookingLabel);
        JTextField comBookingField = new JTextField();
        comBookingField.setBounds(170, 100, 230, 25);
        commercialPanel.add(comBookingField);

        JLabel comMonthLabel = new JLabel("Month:");
        comMonthLabel.setBounds(20, 135, 140, 25);
        commercialPanel.add(comMonthLabel);
        JComboBox<String> comMonthCombo = new JComboBox<>(months);
        comMonthCombo.setBounds(170, 135, 230, 25);
        commercialPanel.add(comMonthCombo);

        JLabel comCylinderLabel = new JLabel("Cylinder ID:");
        comCylinderLabel.setBounds(20, 170, 140, 25);
        commercialPanel.add(comCylinderLabel);
        JTextField comCylinderField = new JTextField();
        comCylinderField.setBounds(170, 170, 230, 25);
        commercialPanel.add(comCylinderField);

        JLabel comQtyLabel = new JLabel("Quantity of Order:");
        comQtyLabel.setBounds(20, 205, 140, 25);
        commercialPanel.add(comQtyLabel);
        JTextField comQtyField = new JTextField();
        comQtyField.setBounds(170, 205, 230, 25);
        commercialPanel.add(comQtyField);

        JLabel comWeightLabel = new JLabel("Weight (Kg):");
        comWeightLabel.setBounds(20, 240, 140, 25);
        commercialPanel.add(comWeightLabel);
        JComboBox<Double> comWeightCombo = new JComboBox<>(weightList);
        comWeightCombo.setBounds(170, 240, 230, 25);
        commercialPanel.add(comWeightCombo);

        JLabel comBasePriceLabel = new JLabel("Base Price:");
        comBasePriceLabel.setBounds(20, 275, 140, 25);
        commercialPanel.add(comBasePriceLabel);
        JTextField comBasePriceField = new JTextField();
        comBasePriceField.setBounds(170, 275, 230, 25);
        commercialPanel.add(comBasePriceField);

        JLabel comSubsidyLabel = new JLabel("Subsidy Amount:");
        comSubsidyLabel.setBounds(20, 310, 140, 25);
        commercialPanel.add(comSubsidyLabel);
        JTextField comSubsidyField = new JTextField("0.0");
        comSubsidyField.setBounds(170, 310, 230, 25);
        commercialPanel.add(comSubsidyField);

        // Commercial Buttons
        JButton addComBtn = new JButton("Add Commercial Cylinder");
        addComBtn.setBounds(50, 350, 160, 32);
        commercialPanel.add(addComBtn);

        JButton clearComBtn = new JButton("Clear Commercial Form");
        clearComBtn.setBounds(230, 350, 160, 32);
        commercialPanel.add(clearComBtn);
        add(commercialPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Haha();
    }
}