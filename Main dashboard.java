package gui;

import javax.swing.*;
import java.awt.*;

import manager.AppContext;

public class MainDashboard extends JFrame {

    public MainDashboard() {

        setTitle("Valet Parking System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        // Buttons
        JButton btnRegister = new JButton("Register Vehicle");
        JButton btnSearch = new JButton("Search Vehicle");
        JButton btnRetrieve = new JButton("Retrieve Vehicle");
        JButton btnReport = new JButton("View Reports");
        JButton btnExit = new JButton("Exit");

        // Add buttons to frame
        add(btnRegister);
        add(btnSearch);
        add(btnRetrieve);
        add(btnReport);
        add(btnExit);

        // =========================
        // BUTTON ACTIONS
        // =========================

        // Open Register Form
        btnRegister.addActionListener(e -> new RegesterVehicleForm());

        // Open Search Form
        btnSearch.addActionListener(e -> new SearchVehicleForm());

        // Process retrieval queue
        btnRetrieve.addActionListener(e -> {

            String next = AppContext.manager.processRetrieval();

            if (next == null) {
                JOptionPane.showMessageDialog(this,
                        "No vehicles in retrieval queue.");
            } else {

                AppContext.manager.releaseSlot(next);

                JOptionPane.showMessageDialog(this,
                        "Vehicle Retrieved: " + next);
            }
        });

        // View simple report
        btnReport.addActionListener(e -> {

            int total = AppContext.manager.getVehicles().size();

            JOptionPane.showMessageDialog(this,
                    "=== PARKING REPORT ===\n" +
                    "Total Vehicles: " + total + "\n" +
                    "Active Slots in System: " + total
            );
        });

        // Exit system
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(MainDashboard::new);
    }
}