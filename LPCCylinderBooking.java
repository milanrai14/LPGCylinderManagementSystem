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

public class LPCCylinderBooking extends JFrame {
    
    // Common data
    String[] customerTypes = {"Select One", "Domestic", "Commercial"};
    String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    String[] weightList = {"14.2 kg", "16 kg", "18 kg", "19 kg", "47.5 kg"};
    
    public LPCCylinderBooking() {
        setTitle("LPG Cylinder Booking Management System");
        setSize(1400, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Border for main frame
        ((JComponent) getContentPane()).setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            )
        );
        
        setLayout(null);
        
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
        domesticPanel.setBounds(10, 10, 450, 350);
        
        // Domestic Fields
        JLabel custTypeLabel1 = new JLabel("Customer Type:");
        custTypeLabel1.setBounds(20, 30, 150, 25);
        domesticPanel.add(custTypeLabel1);
        
        JComboBox<String> custTypeCombo1 = new JComboBox<>(customerTypes);
        custTypeCombo1.setBounds(180, 30, 200, 25);
        domesticPanel.add(custTypeCombo1);
        
        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(20, 70, 150, 25);
        domesticPanel.add(nameLabel);
        
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 70, 200, 25);
        domesticPanel.add(nameField);
        
        JLabel citizenshipLabel = new JLabel("Citizenship Number:");
        citizenshipLabel.setBounds(20, 110, 150, 25);
        domesticPanel.add(citizenshipLabel);
        
        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(180, 110, 200, 25);
        domesticPanel.add(citizenshipField);
        
        JLabel bookingLabel1 = new JLabel("Booking ID:");
        bookingLabel1.setBounds(20, 150, 150, 25);
        domesticPanel.add(bookingLabel1);
        
        JTextField bookingField1 = new JTextField();
        bookingField1.setBounds(180, 150, 200, 25);
        domesticPanel.add(bookingField1);
        
        JLabel monthLabel1 = new JLabel("Month:");
        monthLabel1.setBounds(20, 190, 150, 25);
        domesticPanel.add(monthLabel1);
        
        JComboBox<String> monthCombo1 = new JComboBox<>(months);
        monthCombo1.setBounds(180, 190, 200, 25);
        domesticPanel.add(monthCombo1);
        
        JLabel cylinderLabel1 = new JLabel("Cylinder ID:");
        cylinderLabel1.setBounds(20, 230, 150, 25);
        domesticPanel.add(cylinderLabel1);
        
        JTextField cylinderField1 = new JTextField();
        cylinderField1.setBounds(180, 230, 200, 25);
        domesticPanel.add(cylinderField1);
        
        JLabel qtyLabel1 = new JLabel("Quantity of Order:");
        qtyLabel1.setBounds(20, 270, 150, 25);
        domesticPanel.add(qtyLabel1);
        
        JTextField qtyField1 = new JTextField();
        qtyField1.setBounds(180, 270, 200, 25);
        domesticPanel.add(qtyField1);
        
        JLabel weightLabel1 = new JLabel("Weight (Kg):");
        weightLabel1.setBounds(20, 310, 150, 25);
        domesticPanel.add(weightLabel1);
        
        JComboBox<String> weightCombo1 = new JComboBox<>(weightList);
        weightCombo1.setBounds(180, 310, 200, 25);
        domesticPanel.add(weightCombo1);
        
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
        commercialPanel.setBounds(470, 10, 450, 350);
        
        // Commercial Fields
        JLabel custTypeLabel2 = new JLabel("Customer Type:");
        custTypeLabel2.setBounds(20, 30, 150, 25);
        commercialPanel.add(custTypeLabel2);
        
        JComboBox<String> custTypeCombo2 = new JComboBox<>(customerTypes);
        custTypeCombo2.setBounds(180, 30, 200, 25);
        commercialPanel.add(custTypeCombo2);
        
        JLabel orgLabel = new JLabel("Organization Name:");
        orgLabel.setBounds(20, 70, 150, 25);
        commercialPanel.add(orgLabel);
        
        JTextField orgField = new JTextField();
        orgField.setBounds(180, 70, 200, 25);
        commercialPanel.add(orgField);
        
        JLabel licenseLabel = new JLabel("Business License No:");
        licenseLabel.setBounds(20, 110, 150, 25);
        commercialPanel.add(licenseLabel);
        
        JTextField licenseField = new JTextField();
        licenseField.setBounds(180, 110, 200, 25);
        commercialPanel.add(licenseField);
        
        JLabel bookingLabel2 = new JLabel("Booking ID:");
        bookingLabel2.setBounds(20, 150, 150, 25);
        commercialPanel.add(bookingLabel2);
        
        JTextField bookingField2 = new JTextField();
        bookingField2.setBounds(180, 150, 200, 25);
        commercialPanel.add(bookingField2);
        
        JLabel monthLabel2 = new JLabel("Month:");
        monthLabel2.setBounds(20, 190, 150, 25);
        commercialPanel.add(monthLabel2);
        
        JComboBox<String> monthCombo2 = new JComboBox<>(months);
        monthCombo2.setBounds(180, 190, 200, 25);
        commercialPanel.add(monthCombo2);
        
        JLabel cylinderLabel2 = new JLabel("Cylinder ID:");
        cylinderLabel2.setBounds(20, 230, 150, 25);
        commercialPanel.add(cylinderLabel2);
        
        JTextField cylinderField2 = new JTextField();
        cylinderField2.setBounds(180, 230, 200, 25);
        commercialPanel.add(cylinderField2);
        
        JLabel qtyLabel2 = new JLabel("Quantity of Order:");
        qtyLabel2.setBounds(20, 270, 150, 25);
        commercialPanel.add(qtyLabel2);
        
        JTextField qtyField2 = new JTextField();
        qtyField2.setBounds(180, 270, 200, 25);
        commercialPanel.add(qtyField2);
        
        JLabel weightLabel2 = new JLabel("Weight (Kg):");
        weightLabel2.setBounds(20, 310, 150, 25);
        commercialPanel.add(weightLabel2);
        
        JComboBox<String> weightCombo2 = new JComboBox<>(weightList);
        weightCombo2.setBounds(180, 310, 200, 25);
        commercialPanel.add(weightCombo2);
        
        add(commercialPanel);
        
        // ===== ACTION BUTTONS PANEL (Top Right) =====
        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Actions",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        actionPanel.setLayout(null);
        actionPanel.setBounds(930, 10, 450, 350);
        
        JButton addDomesticBtn = new JButton("Add Domestic Booking");
        addDomesticBtn.setBounds(50, 40, 200, 35);
        addDomesticBtn.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(addDomesticBtn);
        
        JButton addCommercialBtn = new JButton("Add Commercial Booking");
        addCommercialBtn.setBounds(50, 90, 200, 35);
        addCommercialBtn.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(addCommercialBtn);
        
        JButton clearDomesticBtn = new JButton("Clear Domestic Form");
        clearDomesticBtn.setBounds(50, 140, 200, 35);
        clearDomesticBtn.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(clearDomesticBtn);
        
        JButton clearCommercialBtn = new JButton("Clear Commercial Form");
        clearCommercialBtn.setBounds(50, 190, 200, 35);
        clearCommercialBtn.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(clearCommercialBtn);
        
        JButton clearAllBtn = new JButton("Clear All Forms");
        clearAllBtn.setBounds(50, 240, 200, 35);
        clearAllBtn.setFont(new Font("Arial", Font.BOLD, 12));
        actionPanel.add(clearAllBtn);
        
        add(actionPanel);
        
        // ===== DISPLAY PANEL (Left Bottom) =====
        JPanel displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Booking Records / Display",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        displayPanel.setLayout(null);
        displayPanel.setBounds(10, 370, 680, 420);
        
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setText("=== LPG Cylinder Booking Records ===\n\n" +
                           "Domestic Bookings:\n" +
                           "1. John Doe | 14.2 kg | Jan 2026 | Pending\n" +
                           "2. Jane Smith | 19 kg | Feb 2026 | Confirmed\n\n" +
                           "Commercial Bookings:\n" +
                           "1. ABC Corp | 47.5 kg | Jan 2026 | Delivered\n" +
                           "2. XYZ Ltd | 19 kg | Mar 2026 | Pending\n\n" +
                           "Total Bookings: 4");
        
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(10, 20, 660, 380);
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
        operationPanel.setBounds(700, 370, 680, 420);
        
        // Search Section
        JLabel searchLabel = new JLabel("Search Booking ID:");
        searchLabel.setBounds(20, 30, 150, 25);
        operationPanel.add(searchLabel);
        
        JTextField searchField = new JTextField();
        searchField.setBounds(180, 30, 180, 25);
        operationPanel.add(searchField);
        
        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(380, 30, 100, 25);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(searchBtn);
        
        // Update Section
        JLabel updateLabel = new JLabel("Update Status:");
        updateLabel.setBounds(20, 70, 150, 25);
        operationPanel.add(updateLabel);
        
        JTextField updateField = new JTextField();
        updateField.setBounds(180, 70, 180, 25);
        operationPanel.add(updateField);
        
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(380, 70, 100, 25);
        updateBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(updateBtn);
        
        // Delete Section
        JLabel deleteLabel = new JLabel("Delete Booking ID:");
        deleteLabel.setBounds(20, 110, 150, 25);
        operationPanel.add(deleteLabel);
        
        JTextField deleteField = new JTextField();
        deleteField.setBounds(180, 110, 180, 25);
        operationPanel.add(deleteField);
        
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(380, 110, 100, 25);
        deleteBtn.setFont(new Font("Arial", Font.BOLD, 11));
        operationPanel.add(deleteBtn);
        
        // ===== OPERATION BUTTONS =====
        JPanel opButtonPanel = new JPanel();
        opButtonPanel.setLayout(null);
        opButtonPanel.setBounds(20, 160, 640, 240);
        operationPanel.add(opButtonPanel);
        
        // Row 1: View All
        JButton viewAllBtn = new JButton("View All Bookings");
        viewAllBtn.setBounds(0, 0, 180, 35);
        viewAllBtn.setFont(new Font("Arial", Font.BOLD, 12));
        opButtonPanel.add(viewAllBtn);
        
        JButton printBtn = new JButton("Print Records");
        printBtn.setBounds(190, 0, 180, 35);
        printBtn.setFont(new Font("Arial", Font.BOLD, 12));
        opButtonPanel.add(printBtn);
        
        JButton exportBtn = new JButton("Export to File");
        exportBtn.setBounds(380, 0, 180, 35);
        exportBtn.setFont(new Font("Arial", Font.BOLD, 12));
        opButtonPanel.add(exportBtn);
        
        // Row 2: Load
        JButton loadBtn = new JButton("Load from File");
        loadBtn.setBounds(0, 45, 180, 35);
        loadBtn.setFont(new Font("Arial", Font.BOLD, 12));
        opButtonPanel.add(loadBtn);
        
        JButton clearDisplayBtn = new JButton("Clear Display");
        clearDisplayBtn.setBounds(190, 45, 180, 35);
        clearDisplayBtn.setFont(new Font("Arial", Font.BOLD, 12));
        opButtonPanel.add(clearDisplayBtn);
        
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(380, 45, 180, 35);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 12));
        opButtonPanel.add(refreshBtn);
        
        // Row 3: Exit
        JButton exitBtn = new JButton("Exit Application");
        exitBtn.setBounds(190, 95, 180, 35);
        exitBtn.setFont(new Font("Arial", Font.BOLD, 12));
        opButtonPanel.add(exitBtn);
        
        add(operationPanel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new LPCCylinderBooking();
    }
}