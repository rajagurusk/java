import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourierServiceGUI {

    private JFrame frame;
    private JTextField weightField;
    private JTextField pickupField;
    private JTextField deliveryField;
    private JTextField courierNameField;
    private JButton scheduleButton;

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new CourierServiceGUI();
        }
    });
}

    public CourierServiceGUI() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Courier Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel parcelPanel = new JPanel();
        parcelPanel.setLayout(new GridLayout(3, 2));
        parcelPanel.add(new JLabel("Parcel Details:"));
        parcelPanel.add(new JLabel("Weight:"));
        weightField = new JTextField(10);
        parcelPanel.add(weightField);
        parcelPanel.add(new JLabel("Pickup:"));
        pickupField = new JTextField(10);
        parcelPanel.add(pickupField);
        parcelPanel.add(new JLabel("Delivery:"));
        deliveryField = new JTextField(10);
        parcelPanel.add(deliveryField);

        JPanel courierPanel = new JPanel();
        courierPanel.setLayout(new GridLayout(3, 2));
        courierPanel.add(new JLabel("Courier Information:"));
        courierPanel.add(new JLabel("Name:"));
        courierNameField = new JTextField(10);
        courierPanel.add(courierNameField);
        courierPanel.add(new JLabel("Type:"));
        JLabel courierTypeLabel = new JLabel("Standard");
        courierTypeLabel.setEnabled(false);
        courierPanel.add(courierTypeLabel);

        scheduleButton = new JButton("Schedule Delivery");
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String weight = weightField.getText();
                String pickup = pickupField.getText();
                String delivery = deliveryField.getText();
                String courierName = courierNameField.getText();

                if (weight.isEmpty() || pickup.isEmpty() || delivery.isEmpty() || courierName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(frame, "Delivery scheduled for:\nWeight: " + weight + "\nPickup: " + pickup + "\nDelivery: " + delivery + "\nCourier: " + courierName, "Delivery Scheduled", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.getContentPane().add(parcelPanel, BorderLayout.CENTER);
        frame.getContentPane().add(courierPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(scheduleButton, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
}