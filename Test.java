import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test extends JFrame {

    public Test() {

        setTitle("NEA Electricity Billing System");
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

                JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(30, 80, 150, 30);
        add(customerIdLabel);

        JTextField customerIdField = new JTextField();
        customerIdField.setBounds(200, 80, 200, 30);
        customerIdField.setEnabled(false);

        add(customerIdField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }

}