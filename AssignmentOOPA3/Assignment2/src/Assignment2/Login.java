package Assignment2;

import javax.swing.*;
import java.awt.*;

public class Login {
    JFrame frame;

    public Login() {
        frame = new JFrame("Login - Clothing Store");
        frame.setSize(750, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Custom panel with gradient background
        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(140, 82, 255);  // Light purple
                Color color2 = new Color(88, 24, 153);   // Dark purple
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        gradientPanel.setLayout(new GridBagLayout()); // Centering layout
        frame.setContentPane(gradientPanel); // Set panel as content pane

        // Layout constraints for centering
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin between components
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Login to Continue");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 0;
        gradientPanel.add(titleLabel, gbc);

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gradientPanel.add(userLabel, gbc);

        JTextField userField = new JTextField(20);
        gbc.gridy = 2;
        gradientPanel.add(userField, gbc);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        gbc.gridy = 3;
        gradientPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(20);
        gbc.gridy = 4;
        gradientPanel.add(passField, gbc);

        // Login Button
        JButton loginButton = new JButton("Login");
        gbc.gridy = 5;
        gradientPanel.add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                frame.dispose(); // Close login
                new GUI2();      // Open GUI2
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.");
            }
        });

        frame.setVisible(true);
    }

}