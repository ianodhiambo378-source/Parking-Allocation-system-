package gui;

import manager.AppContext;
import model.Vehicle;

import javax.swing.*;
import java.awt.*;

public class SearchVehicleForm extends JFrame {

    private JTextField txtSearch = new JTextField();

    public SearchVehicleForm() {

        setTitle("Search Vehicle");
        setSize(350, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Enter Vehicle ID:"));
        add(txtSearch);

        JButton btnSearch = new JButton("Search");
        add(btnSearch);

        btnSearch.addActionListener(e -> searchVehicle());

        setVisible(true);
    }

    private void searchVehicle() {

        Vehicle v = AppContext.manager.searchVehicle(txtSearch.getText());

        if (v == null) {
            JOptionPane.showMessageDialog(this, "Vehicle not found!");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Owner: " + v.getOwnerName() +
                    "\nPlate: " + v.getPlateNumber() +
                    "\nSlot: " + v.getAssignedSlot());
        }
    }
}