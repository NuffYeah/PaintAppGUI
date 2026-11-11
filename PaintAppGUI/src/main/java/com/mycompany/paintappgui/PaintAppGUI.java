/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paintappgui;

/**
 *
 * @author napht
 */
import javax.swing.*;

public class PaintAppGUI extends JFrame {
     private JLabel lengthLabel, widthLabel, heightLabel, wallAreaLabel, tinsLabel, costLabel, vatLabel, changeLabel;
    private JTextField lengthField, widthField, heightField, amountTenderedField;
    private JButton calculateButton;

    public PaintAppGUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PaintApp");
        setSize(400, 300);
        setLayout(new java.awt.FlowLayout());

        // Components
        lengthLabel = new JLabel("Length:");
        add(lengthLabel);

        lengthField = new JTextField(10);
        add(lengthField);

        widthLabel = new JLabel("Width:");
        add(widthLabel);

        widthField = new JTextField(10);
        add(widthField);

        heightLabel = new JLabel("Height:");
        add(heightLabel);

        heightField = new JTextField(10);
        add(heightField);

        calculateButton = new JButton("Calculate");
        add(calculateButton);

        wallAreaLabel = new JLabel("Wall Area:");
        add(wallAreaLabel);

        tinsLabel = new JLabel("Tins Needed:");
        add(tinsLabel);

        costLabel = new JLabel("Total Cost:");
        add(costLabel);

        vatLabel = new JLabel("VAT:");
        add(vatLabel);

        amountTenderedField = new JTextField(10);
        add(amountTenderedField);

        changeLabel = new JLabel("Change:");
        add(changeLabel);

        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
    }

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        

        double length = Double.parseDouble(lengthField.getText());
        double width = Double.parseDouble(widthField.getText());
        double height = Double.parseDouble(heightField.getText());

        double wallArea = calculateWallArea(length, width, height);
        int tinsNeeded = calculateTinsOfPaint(wallArea);
        double totalCost = calculateTotalCost(tinsNeeded);

       
        double amountTendered = Double.parseDouble(amountTenderedField.getText());

         double change = calculateChange(amountTendered, totalCost);
    displayChange(change);
}


    public double calculateWallArea(double length, double width, double height) {
       
        double area = 2 * (length * height + width * height);
        
        wallAreaLabel.setText("Wall Area: " + area + " square meters");
        return area;
    }

    public int calculateTinsOfPaint(double wallArea) {
        // Assuming a tin covers 10 square meters
        int tinsNeeded = (int) Math.ceil(wallArea / 10.0);
       
        tinsLabel.setText("Tins Needed: " + tinsNeeded);
        return tinsNeeded;
    }

    public double calculateTotalCost(int tinsNeeded) {
        // Assuming a tin costs R30
        double costPerTin = 30.0;
        double totalCost = tinsNeeded * costPerTin;

        // Calculate VAT (15%)
        double vat = 0.15 * totalCost;

        
        costLabel.setText("Total Cost: R" + totalCost);
        vatLabel.setText("VAT: R" + vat);

        return totalCost;
    }

    public double calculateChange(double amountTendered, double totalCost) {
        double change = amountTendered - totalCost;

        
        changeLabel.setText("Change: R" + change);

        return change;
    }

private void displayChange(double change) {
    changeLabel.setText("Change: R" + change);
}
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PaintAppGUI().setVisible(true));
    }
}
