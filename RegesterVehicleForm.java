package gui;

import manager.AppContext;
import model.Vehicle;

import javax.swing.*;
import java.awt.*;

public class RegesterVehicleForm extends JFrame {

    private JTextField txtId = new JTextField();
    private JTextField txtPlate = new JTextField();
    private JTextField txtOwner = new JTextField();
    private JTextField txtSize = new JTextField();

    public RegesterVehicleForm() {

        setTitle("Register Vehicle");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Vehicle ID:"));
        add(txtId);

        add(new JLabel("Plate Number:"));
        add(txtPlate);

        add(new JLabel("Owner Name:"));
        add(txtOwner);

        add(new JLabel("Size (Small/Medium/Large):"));
        add(txtSize);

        JButton btnSave = new JButton("Register");
        add(btnSave);

        btnSave.addActionListener(e -> registerVehicle());

        setVisible(true);
    }

    private void registerVehicle() {

        Vehicle v = new Vehicle(
                txtId.getText(),
                txtPlate.getText(),
                txtOwner.getText(),
                txtSize.getText()
        );

        AppContext.manager.registerVehicle(v);

        JOptionPane.showMessageDialog(this,
                "Vehicle Registered!\nSlot: " + v.getAssignedSlot());

        dispose();
    }
}