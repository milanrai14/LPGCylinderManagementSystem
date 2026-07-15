/**
 * LPGCylinderBooking is the main GUI application for the Nepal Oil Corporation Cylinder Management System.
 * It provides a graphical interface for managing LPG cylinder bookings.
 *
 * @author Milan Rai
 * @version 1.1.1.1
 */
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
import javax.swing.border.TitledBorder;

public class LPGCylinderBooking extends JFrame {

    public LPGCylinderBooking() {

        setTitle("LPG Cylinder Booking Management System");
        setSize(1400, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Border for main frame
        ((JComponent) getContentPane()).setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
            )
        );
        
        setLayout(null);

        // ============================================================
        // TOP SECTION - Domestic and Commercial Panels (Side by Side)
        // ============================================================
        
        // ===== DOMESTIC CYLINDER PANEL (Left Top) =====
        JPanel domesticPanel = new JPanel();
        domesticPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Domestic Cylinder Booking",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        domesticPanel.setLayout(null);
        domesticPanel.setBounds(10, 10, 450, 380);

        // Domestic Fields
        int yPos = 30;
        int labelX = 20;
        int fieldX = 170;
        int fieldWidth = 230;
        int gap = 35;

        JLabel domNameLabel = new JLabel("Customer Name:");
        domNameLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domNameLabel);
        JTextField domNameField = new JTextField();
        domNameField.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domNameField);
        yPos += gap;

        JLabel domCitizenshipLabel = new JLabel("Citizenship Number:");
        domCitizenshipLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domCitizenshipLabel);
        JTextField domCitizenshipField = new JTextField();
        domCitizenshipField.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domCitizenshipField);
        yPos += gap;

        JLabel domBookingLabel = new JLabel("Booking ID:");
        domBookingLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domBookingLabel);
        JTextField domBookingField = new JTextField();
        domBookingField.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domBookingField);
        yPos += gap;

        JLabel domMonthLabel = new JLabel("Month:");
        domMonthLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domMonthLabel);
        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        JComboBox<String> domMonthCombo = new JComboBox<>(months);
        domMonthCombo.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domMonthCombo);
        yPos += gap;

        JLabel domCylinderLabel = new JLabel("Cylinder ID:");
        domCylinderLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domCylinderLabel);
        JTextField domCylinderField = new JTextField();
        domCylinderField.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domCylinderField);
        yPos += gap;

        JLabel domQtyLabel = new JLabel("Quantity of Order:");
        domQtyLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domQtyLabel);
        JTextField domQtyField = new JTextField();
        domQtyField.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domQtyField);
        yPos += gap;

        JLabel domWeightLabel = new JLabel("Weight (Kg):");
        domWeightLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domWeightLabel);
        Double[] weightList = { 14.0, 16.0, 18.0 };
        JComboBox<Double> domWeightCombo = new JComboBox<>(weightList);
        domWeightCombo.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domWeightCombo);
        yPos += gap;

        JLabel domBasePriceLabel = new JLabel("Base Price:");
        domBasePriceLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domBasePriceLabel);
        JTextField domBasePriceField = new JTextField();
        domBasePriceField.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domBasePriceField);
        yPos += gap;

        JLabel domSubsidyLabel = new JLabel("Subsidy Amount:");
        domSubsidyLabel.setBounds(labelX, yPos, 140, 25);
        domesticPanel.add(domSubsidyLabel);
        JTextField domSubsidyField = new JTextField("0.0");
        domSubsidyField.setBounds(fieldX, yPos, fieldWidth, 25);
        domesticPanel.add(domSubsidyField);

        // Domestic Buttons at bottom
        JButton addDomesticBtn = new JButton("Add Domestic Cylinder");
        addDomesticBtn.setBounds(50, 330, 160, 32);
        addDomesticBtn.setFont(new Font("Arial", Font.BOLD, 11));
        domesticPanel.add(addDomesticBtn);

        JButton clearDomesticBtn = new JButton("Clear Domestic Form");
        clearDomesticBtn.setBounds(230, 330, 160, 32);
        clearDomesticBtn.setFont(new Font("Arial", Font.BOLD, 11));
        domesticPanel.add(clearDomesticBtn);

        add(domesticPanel);

        // ===== COMMERCIAL CYLINDER PANEL (Right Top) =====
        JPanel commercialPanel = new JPanel();
        commercialPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Commercial Cylinder Booking",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        commercialPanel.setLayout(null);
        commercialPanel.setBounds(470, 10, 450, 380);

        // Commercial Fields
        yPos = 30;

        JLabel commOrgLabel = new JLabel("Organization Name:");
        commOrgLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commOrgLabel);
        JTextField commOrgField = new JTextField();
        commOrgField.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commOrgField);
        yPos += gap;

        JLabel commLicenseLabel = new JLabel("Business License No:");
        commLicenseLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commLicenseLabel);
        JTextField commLicenseField = new JTextField();
        commLicenseField.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commLicenseField);
        yPos += gap;

        JLabel commBookingLabel = new JLabel("Booking ID:");
        commBookingLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commBookingLabel);
        JTextField commBookingField = new JTextField();
        commBookingField.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commBookingField);
        yPos += gap;

        JLabel commMonthLabel = new JLabel("Month:");
        commMonthLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commMonthLabel);
        JComboBox<String> commMonthCombo = new JComboBox<>(months);
        commMonthCombo.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commMonthCombo);
        yPos += gap;

        JLabel commCylinderLabel = new JLabel("Cylinder ID:");
        commCylinderLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commCylinderLabel);
        JTextField commCylinderField = new JTextField();
        commCylinderField.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commCylinderField);
        yPos += gap;

        JLabel commQtyLabel = new JLabel("Quantity of Order:");
        commQtyLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commQtyLabel);
        JTextField commQtyField = new JTextField();
        commQtyField.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commQtyField);
        yPos += gap;

        JLabel commWeightLabel = new JLabel("Weight (Kg):");
        commWeightLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commWeightLabel);
        JComboBox<Double> commWeightCombo = new JComboBox<>(weightList);
        commWeightCombo.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commWeightCombo);
        yPos += gap;

        JLabel commBasePriceLabel = new JLabel("Base Price:");
        commBasePriceLabel.setBounds(labelX, yPos, 140, 25);
        commercialPanel.add(commBasePriceLabel);
        JTextField commBasePriceField = new JTextField();
        commBasePriceField.setBounds(fieldX, yPos, fieldWidth, 25);
        commercialPanel.add(commBasePriceField);

        // Commercial Buttons at bottom
        JButton addCommercialBtn = new JButton("Add Commercial Cylinder");
        addCommercialBtn.setBounds(50, 330, 160, 32);
        addCommercialBtn.setFont(new Font("Arial", Font.BOLD, 11));
        commercialPanel.add(addCommercialBtn);

        JButton clearCommercialBtn = new JButton("Clear Commercial Form");
        clearCommercialBtn.setBounds(230, 330, 160, 32);
        clearCommercialBtn.setFont(new Font("Arial", Font.BOLD, 11));
        commercialPanel.add(clearCommercialBtn);

        add(commercialPanel);

        // ============================================================
        // BOTTOM SECTION - Display and Operations
        // ============================================================

        // ===== DISPLAY PANEL (Left Bottom) =====
        JPanel displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Output / Display",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        displayPanel.setLayout(null);
        displayPanel.setBounds(10, 400, 450, 440);

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setText("╔═══════════════════════════════════════════════╗\n" +
                           "║     LPG CYLINDER BOOKING RECORDS             ║\n" +
                           "╠═══════════════════════════════════════════════╣\n" +
                           "║ DOMESTIC BOOKINGS:                           ║\n" +
                           "║  1. John Doe | 14.2 kg | Jan 2026 | Pending ║\n" +
                           "║  2. Jane Smith | 19 kg | Feb 2026 | Confirmed║\n" +
                           "╠═══════════════════════════════════════════════╣\n" +
                           "║ COMMERCIAL BOOKINGS:                         ║\n" +
                           "║  1. ABC Corp | 47.5 kg | Jan 2026 | Delivered║\n" +
                           "║  2. XYZ Ltd | 19 kg | Mar 2026 | Pending    ║\n" +
                           "╠═══════════════════════════════════════════════╣\n" +
                           "║ TOTAL BOOKINGS: 4                           ║\n" +
                           "╚═══════════════════════════════════════════════╝");

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(10, 20, 430, 400);
        displayPanel.add(scrollPane);

        add(displayPanel);

        // ===== OPERATION PANEL (Right Bottom) =====
        JPanel operationPanel = new JPanel();
        operationPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Operation Inputs",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        operationPanel.setLayout(null);
        operationPanel.setBounds(470, 400, 880, 440);

        // Operation Fields - Organized in two columns
        int col1X = 25;
        int col2X = 320;
        int rowY = 30;
        int rowGap = 40;
        int labelW = 130;
        int fieldW = 160;

        // Row 1: Index
        JLabel indexLabel = new JLabel("Index:");
        indexLabel.setBounds(col1X, rowY, labelW, 25);
        operationPanel.add(indexLabel);
        JTextField indexField = new JTextField();
        indexField.setBounds(col1X + labelW + 10, rowY, fieldW, 25);
        operationPanel.add(indexField);
        rowY += rowGap;

        // Row 2: Prompt Text
        JLabel promptLabel = new JLabel("Prompt Text:");
        promptLabel.setBounds(col1X, rowY, labelW, 25);
        operationPanel.add(promptLabel);
        JTextField promptField = new JTextField();
        promptField.setBounds(col1X + labelW + 10, rowY, fieldW + 50, 25);
        operationPanel.add(promptField);
        rowY += rowGap;

        // Row 3: Response Length
        JLabel responseLabel = new JLabel("Response Length (tokens):");
        responseLabel.setBounds(col1X, rowY, labelW + 20, 25);
        operationPanel.add(responseLabel);
        JTextField responseField = new JTextField();
        responseField.setBounds(col1X + labelW + 30, rowY, fieldW, 25);
        operationPanel.add(responseField);
        rowY += rowGap;

        // Row 4: Member Name
        JLabel memberLabel = new JLabel("Member Name:");
        memberLabel.setBounds(col1X, rowY, labelW, 25);
        operationPanel.add(memberLabel);
        JTextField memberField = new JTextField();
        memberField.setBounds(col1X + labelW + 10, rowY, fieldW, 25);
        operationPanel.add(memberField);
        rowY += rowGap;

        // Row 5: Buy Prompts Count
        JLabel buyPromptLabel = new JLabel("Buy Prompts Count:");
        buyPromptLabel.setBounds(col1X, rowY, labelW, 25);
        operationPanel.add(buyPromptLabel);
        JTextField buyPromptField = new JTextField();
        buyPromptField.setBounds(col1X + labelW + 10, rowY, fieldW, 25);
        operationPanel.add(buyPromptField);
        rowY += rowGap;

        // Row 6: Gain Prompt
        JLabel gainPromptLabel = new JLabel("Gain Prompt:");
        gainPromptLabel.setBounds(col1X, rowY, labelW, 25);
        operationPanel.add(gainPromptLabel);
        JTextField gainPromptField = new JTextField();
        gainPromptField.setBounds(col1X + labelW + 10, rowY, fieldW, 25);
        operationPanel.add(gainPromptField);

        // ===== OPERATION BUTTONS (Right Column) =====
        int btnX = 570;
        int btnY = 30;
        int btnW = 140;
        int btnH = 30;
        int btnGap = 38;

        JButton addTeamBtn = new JButton("Add Team Member");
        addTeamBtn.setBounds(btnX, btnY, btnW, btnH);
        addTeamBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(addTeamBtn);
        btnY += btnGap;

        JButton removeTeamBtn = new JButton("Remove Team Member");
        removeTeamBtn.setBounds(btnX, btnY, btnW, btnH);
        removeTeamBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(removeTeamBtn);
        btnY += btnGap;

        JButton checkPlanBtn = new JButton("Check Plan Type");
        checkPlanBtn.setBounds(btnX, btnY, btnW, btnH);
        checkPlanBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(checkPlanBtn);
        btnY += btnGap;

        JButton displayAllBtn = new JButton("Display All");
        displayAllBtn.setBounds(btnX, btnY, btnW, btnH);
        displayAllBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(displayAllBtn);
        btnY += btnGap;

        JButton clearFieldsBtn = new JButton("Clear Fields");
        clearFieldsBtn.setBounds(btnX, btnY, btnW, btnH);
        clearFieldsBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(clearFieldsBtn);
        btnY += btnGap;

        JButton exportBtn = new JButton("Export to File");
        exportBtn.setBounds(btnX, btnY, btnW, btnH);
        exportBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(exportBtn);
        btnY += btnGap;

        JButton loadBtn = new JButton("Load From File");
        loadBtn.setBounds(btnX, btnY, btnW, btnH);
        loadBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(loadBtn);
        btnY += btnGap;

        JButton buyPromptsBtn = new JButton("Buy Prompts");
        buyPromptsBtn.setBounds(btnX, btnY, btnW, btnH);
        buyPromptsBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(buyPromptsBtn);

        // Additional buttons at bottom of operation panel
        JButton viewAllBtn = new JButton("View All Bookings");
        viewAllBtn.setBounds(25, 350, 160, 35);
        viewAllBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(viewAllBtn);

        JButton searchBtn = new JButton("Search by ID");
        searchBtn.setBounds(200, 350, 160, 35);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(searchBtn);

        JButton exitBtn = new JButton("Exit Application");
        exitBtn.setBounds(375, 350, 160, 35);
        exitBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(exitBtn);

        add(operationPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LPGCylinderBooking();
    }
}