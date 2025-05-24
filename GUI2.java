package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class GUI2 extends Customer {
    JFrame frame;
    ArrayList<Clothes> itemList = new ArrayList<>();

    public GUI2() {
        super("", "", "");  // Initialize Customer with empty fields

        frame = new JFrame("Clothing Store Receipt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(770, 800); // Frame size fixed to show scroll pane nicely
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        ImageIcon image = new ImageIcon(GUI2.class.getResource("/Assignment2/cart.png"));
        frame.setIconImage(image.getImage());

        // Main panel to hold all components, with null layout for absolute positioning
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setPreferredSize(new Dimension(750, 750));  // Increase this if you add more components

        // Top header panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(203, 195, 227));
        panel.setBounds(0, 0, 750, 130);
        panel.setLayout(null);
        mainPanel.add(panel);

        JLabel label = new JLabel("CLOTHING STORE RECEIPT", JLabel.CENTER);
        label.setBounds(0, 60, 750, 30);
        label.setFont(new Font("Monaco", Font.BOLD, 26));
        panel.add(label);

        // Membership Checkbox to allow customer details
        JCheckBox membershipCheckBox = new JCheckBox("Customer has Membership");
        membershipCheckBox.setBounds(150, 150, 250, 30);
        membershipCheckBox.setBackground(Color.WHITE);
        mainPanel.add(membershipCheckBox);

        // Customer Information Fields (Initially disabled)
        JTextField nameField = new JTextField();
        nameField.setBounds(250, 200, 250, 40);
        nameField.setEnabled(false);
        mainPanel.add(nameField);

        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(150, 200, 100, 40);
        nameLabel.setEnabled(false);
        mainPanel.add(nameLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(250, 250, 250, 40);
        emailField.setEnabled(false);
        mainPanel.add(emailField);

        JLabel emailLabel = new JLabel("Customer Email:");
        emailLabel.setBounds(150, 250, 100, 40);
        emailLabel.setEnabled(false);
        mainPanel.add(emailLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(250, 300, 250, 40);
        phoneField.setEnabled(false);
        mainPanel.add(phoneField);

        JLabel phoneLabel = new JLabel("Customer Phone:");
        phoneLabel.setBounds(150, 300, 100, 40);
        phoneLabel.setEnabled(false);
        mainPanel.add(phoneLabel);

        // Input fields for item details
        JTextField brandField = new JTextField();
        brandField.setBounds(250, 350, 250, 40);
        mainPanel.add(brandField);

        JLabel brandLabel = new JLabel("Clothing Brand:");
        brandLabel.setBounds(150, 350, 100, 40);
        mainPanel.add(brandLabel);

        JComboBox<String> colourComboBox = new JComboBox<>(new String[]{"White", "Black", "Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Pink"});
        colourComboBox.setBounds(250, 400, 100, 40);
        mainPanel.add(colourComboBox);

        JLabel colourLabel = new JLabel("Item Colour:");
        colourLabel.setBounds(150, 400, 100, 40);
        mainPanel.add(colourLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(250, 450, 250, 40);
        mainPanel.add(priceField);

        JLabel priceLabel = new JLabel("Price (RM):");
        priceLabel.setBounds(150, 450, 100, 40);
        mainPanel.add(priceLabel);

        JComboBox<String> sizeComboBox = new JComboBox<>(new String[]{"S", "M", "L", "XL"});
        sizeComboBox.setBounds(250, 500, 100, 40);
        mainPanel.add(sizeComboBox);

        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(150, 500, 100, 40);
        mainPanel.add(sizeLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(250, 550, 250, 40);
        mainPanel.add(quantityField);

        JLabel quantityLabel = new JLabel("Item Quantity:");
        quantityLabel.setBounds(150, 550, 100, 40);
        mainPanel.add(quantityLabel);

        JCheckBox discountCheckBox = new JCheckBox("Apply 40% Discount");
        discountCheckBox.setBounds(250, 600, 200, 30);
        discountCheckBox.setBackground(Color.WHITE);
        mainPanel.add(discountCheckBox);

        JLabel statusLabel = new JLabel("Items added: 0");
        statusLabel.setBounds(250, 640, 200, 30);
        mainPanel.add(statusLabel);

        // Add item button
        JButton addItemButton = new JButton("Add Item");
        addItemButton.setBounds(250, 670, 150, 30);
        mainPanel.add(addItemButton);

        // Pay button
        JButton payButton = new JButton("Pay");
        payButton.setBounds(500, 660, 150, 40);
        mainPanel.add(payButton);

        // Add action listeners as before
        addItemButton.addActionListener(e -> {
            String brand = brandField.getText().trim();
            String priceText = priceField.getText().trim();
            String quantityText = quantityField.getText().trim();

            if (brand.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all required fields.");
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                int quantity = Integer.parseInt(quantityText);

                Clothes item = new Clothes(
                    brand,
                    Objects.requireNonNull(colourComboBox.getSelectedItem()).toString(),
                    price,
                    Objects.requireNonNull(sizeComboBox.getSelectedItem()).toString().charAt(0),
                    quantity,
                    discountCheckBox.isSelected()
                );

                itemList.add(item);
                statusLabel.setText("Items added: " + itemList.size());

                // Clear fields
                brandField.setText("");
                priceField.setText("");
                quantityField.setText("");
                discountCheckBox.setSelected(false);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number format for price or quantity.");
            }
        });

        membershipCheckBox.addActionListener(e -> {
            boolean isMember = membershipCheckBox.isSelected();
            nameField.setEnabled(isMember);
            emailField.setEnabled(isMember);
            phoneField.setEnabled(isMember);
            nameLabel.setEnabled(isMember);
            emailLabel.setEnabled(isMember);
            phoneLabel.setEnabled(isMember);
        });

        payButton.addActionListener(e -> {
            if (itemList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No items added!");
                return;
            }

            if (membershipCheckBox.isSelected()) {
                String customerName = nameField.getText().trim();
                String customerEmail = emailField.getText().trim();
                String customerPhone = phoneField.getText().trim();

                if (customerName.isEmpty() || customerEmail.isEmpty() || customerPhone.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in customer details.");
                    return;
                }

                // Update inherited customer fields
                setName(customerName);
                setEmail(customerEmail);
                setPhoneNum(customerPhone);
            }

            double grandTotal = 0;
            StringBuilder receiptBuilder = new StringBuilder();
            receiptBuilder.append("      CLOTHING STORE RECEIPT\n");
            receiptBuilder.append("-------------------------------------\n");

            if (membershipCheckBox.isSelected()) {
                receiptBuilder.append("Customer Name: " + getName() + "\n");
                receiptBuilder.append("Customer Email: " + getEmail() + "\n");
                receiptBuilder.append("Customer Phone: " + getPhoneNum() + "\n");
                receiptBuilder.append("-------------------------------------\n");
            } else {
                receiptBuilder.append("Non-Membership\n");
            }

            for (int i = 0; i < itemList.size(); i++) {
                Clothes item = itemList.get(i);
                double itemTotal = item.getTotal();
                grandTotal += itemTotal;

                receiptBuilder.append(String.format("Item %d:\n", i + 1));
                receiptBuilder.append(String.format("Brand     : %s\n", item.brand));
                receiptBuilder.append(String.format("Color     : %s\n", item.colour));
                receiptBuilder.append(String.format("Size      : %s\n", item.size));
                receiptBuilder.append(String.format("Price     : RM %.2f\n", item.price));
                receiptBuilder.append(String.format("Quantity  : %d\n", item.quantity));
                if (item.discount) {
                    receiptBuilder.append("Discount  : 40% OFF\n");
                }
                receiptBuilder.append(String.format("Subtotal  : RM %.2f\n", itemTotal));
                receiptBuilder.append("-------------------------------------\n");
            }

            receiptBuilder.append(String.format("Grand Total: RM %.2f\n", grandTotal));
            receiptBuilder.append("*************************************\n");
            receiptBuilder.append("    Thank you for shopping with us!\n");
            receiptBuilder.append("*************************************\n");
            receiptBuilder.append(" You have received a 25% off voucher\n");
            receiptBuilder.append("       for the next purchase!\n\n");
            receiptBuilder.append("   SOFTWARE BY: NADIA & RIDZUAN\n");
            receiptBuilder.append("   CONTACT: contact@nrcode.com\n");

            // Show receipt in a new frame with JScrollPane
            JFrame receiptFrame = new JFrame("Receipt");
            receiptFrame.setSize(400, 600);
            receiptFrame.setLocationRelativeTo(null); // center on screen
            receiptFrame.getContentPane().setBackground(new Color(255, 255, 240));

            JTextArea receiptArea = new JTextArea(receiptBuilder.toString());
            receiptArea.setEditable(false);
            receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

            JScrollPane receiptScrollPane = new JScrollPane(receiptArea);
            receiptScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            receiptScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            receiptScrollPane.setPreferredSize(new Dimension(380, 560));

            receiptFrame.add(receiptScrollPane);
            receiptFrame.pack();
            receiptFrame.setVisible(true);
        });

        // Wrap the mainPanel inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBounds(0, 0, 750, 600);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
