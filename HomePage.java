package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomePage {
    JFrame frame;

    public HomePage() {
        frame = new JFrame("Welcome to Clothing Store");
        frame.setSize(750, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Panel with gradient background
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(186, 123, 247);
                Color color2 = new Color(98, 0, 234);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(new GridBagLayout());
        frame.setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        JLabel titleLabel = new JLabel("Welcome to the Clothing Store", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 0;
        panel.add(titleLabel, gbc);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 1;
        panel.add(loginButton, gbc);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 2;
        panel.add(exitButton, gbc);

        // Login action
        loginButton.addActionListener((ActionEvent e) -> {
            frame.dispose(); // Close home page
            new Login();     // Open login screen
        });

        // Exit action
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);  // Exit program
        });

        frame.setVisible(true);
    }
}
