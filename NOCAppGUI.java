/**
 * NOCApp is the main application class for the Nepal Oil Corporation Cylinder Management System.
 * It provides a command-line interface that allows user to add domestic cylinder
 * commercial cylinder, and diplay all stored cylinder records and calculate and display the final prices.
 * 
 * The application stores all cylinder objects in ArrayList.
 * 
 * @author Milan Rai
 * @version 1.1.1.1
*/
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class NOCAppGUI extends JFrame {

    private ArrayList<LPGCylinder> cylinders = new ArrayList<>();

    private JTextArea outputArea;

    public NOCAppGUI() {

        setTitle("Nepal Oil Corporation Cylinder Management System");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();

        JButton domesticBtn = new JButton("Add Domestic");
        JButton commercialBtn = new JButton("Add Commercial");
        JButton displayBtn = new JButton("Display Cylinders");
        JButton priceBtn = new JButton("Show Final Prices");

        buttonPanel.add(domesticBtn);
        buttonPanel.add(commercialBtn);
        buttonPanel.add(displayBtn);
        buttonPanel.add(priceBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        domesticBtn.addActionListener(e -> addDomesticCylinder());

        commercialBtn.addActionListener(e -> addCommercialCylinder());

        displayBtn.addActionListener(e -> displayAllCylinders());

        priceBtn.addActionListener(e -> showFinalPrices());

        setVisible(true);
    }

    private void addDomesticCylinder() {

        try {

            String cylinderId = JOptionPane.showInputDialog("Cylinder ID");

            String cylinderType = JOptionPane.showInputDialog("Cylinder Type");

            String bookingId = JOptionPane.showInputDialog("Booking ID");

            double basePrice = Double.parseDouble(
                    JOptionPane.showInputDialog("Base Price"));

            double weight = Double.parseDouble(
                    JOptionPane.showInputDialog("Weight"));

            String citizenship = JOptionPane.showInputDialog("Citizenship Number");

            int quantity = Integer.parseInt(
                    JOptionPane.showInputDialog("Quantity"));

            double subsidy = Double.parseDouble(
                    JOptionPane.showInputDialog("Subsidy Amount"));

            DomesticCylinder domestic = new DomesticCylinder(
                    cylinderId,
                    cylinderType,
                    bookingId,
                    basePrice,
                    weight,
                    subsidy,
                    citizenship,
                    quantity);

            if (domestic.isValid()) {
                cylinders.add(domestic);
                JOptionPane.showMessageDialog(this,
                        "Domestic Cylinder Added Successfully");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid Data");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Input");
        }

    }

    private void addCommercialCylinder() {

        try {

            String business = JOptionPane.showInputDialog("Business License");

            String cylinderId = JOptionPane.showInputDialog("Cylinder ID");

            String cylinderType = JOptionPane.showInputDialog("Cylinder Type");

            String bookingId = JOptionPane.showInputDialog("Booking ID");

            double basePrice = Double.parseDouble(
                    JOptionPane.showInputDialog("Base Price"));

            double weight = Double.parseDouble(
                    JOptionPane.showInputDialog("Weight"));

            int quantity = Integer.parseInt(
                    JOptionPane.showInputDialog("Quantity"));

            CommercialCylinder commercial = new CommercialCylinder(
                    cylinderId,
                    cylinderType,
                    bookingId,
                    basePrice,
                    weight,
                    business,
                    quantity);

            if (commercial.isValid()) {
                cylinders.add(commercial);
                JOptionPane.showMessageDialog(this,
                        "Commercial Cylinder Added Successfully");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid Data");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Input");
        }

    }

    private void displayAllCylinders() {

        outputArea.setText("");

        if (cylinders.isEmpty()) {

            outputArea.append("No Cylinder Records Found\n");
            return;

        }

        for (LPGCylinder cylinder : cylinders) {

            outputArea.append("---------------------------------\n");
            outputArea.append("Cylinder ID : "
                    + cylinder.getCylinderId() + "\n");

            outputArea.append("Booking ID : "
                    + cylinder.getBookingId() + "\n");

            outputArea.append("Type : "
                    + cylinder.getCylinderType() + "\n");

            outputArea.append("Weight : "
                    + cylinder.getWeight() + "\n");

            outputArea.append("Base Price : "
                    + cylinder.getBasePrice() + "\n");

            if (cylinder instanceof DomesticCylinder d) {

                outputArea.append("Citizen No : "
                        + d.getCitizenshipNumber() + "\n");

            }

            if (cylinder instanceof CommercialCylinder c) {

                outputArea.append("Business License : "
                        + c.getBusinessLicense() + "\n");

            }

        }

    }

    private void showFinalPrices() {

        outputArea.setText("");

        if (cylinders.isEmpty()) {

            outputArea.append("No Cylinder Records Found\n");
            return;

        }

        outputArea.append("=========== FINAL PRICE REPORT ==========\n\n");

        for (LPGCylinder cylinder : cylinders) {

            outputArea.append("Cylinder ID : "
                    + cylinder.getCylinderId());

            if (cylinder instanceof DomesticCylinder d) {

                outputArea.append(" | Domestic");
                outputArea.append(" | Citizen : "
                        + d.getCitizenshipNumber());

            }

            if (cylinder instanceof CommercialCylinder c) {

                outputArea.append(" | Commercial");
                outputArea.append(" | Business : "
                        + c.getBusinessLicense());

            }

            outputArea.append(" | Final Price : Rs "
                    + cylinder.calculateFinalPrice());

            outputArea.append("\n");

        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new NOCAppSwing());

    }

}