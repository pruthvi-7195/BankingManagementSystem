package com.banking.BankingManagementSystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.banking.BankingManagementSystem.controller.LoginController;

public class RegisterFrame extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    private JButton registerButton;
    private JButton backButton;

    private LoginController loginController;

    public RegisterFrame() {

        loginController =
                new LoginController();

        setTitle("My Bank - Create Account");

        setSize(650, 600);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        // ==================================================
        // MAIN PANEL
        // ==================================================

        JPanel mainPanel =
                new JPanel();

        mainPanel.setLayout(
                new BorderLayout()
        );

        mainPanel.setBackground(
                new Color(
                        245,
                        247,
                        250
                )
        );

        // ==================================================
        // HEADER
        // ==================================================

        JPanel headerPanel =
                new JPanel();

        headerPanel.setLayout(
                new GridLayout(
                        2,
                        1
                )
        );

        headerPanel.setBackground(
                new Color(
                        30,
                        55,
                        90
                )
        );

        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        22,
                        20,
                        22,
                        20
                )
        );

        JLabel bankLabel =
                new JLabel(
                        "🏦  MY BANK",
                        SwingConstants.CENTER
                );

        bankLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        bankLabel.setForeground(
                Color.WHITE
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Create your secure banking account",
                        SwingConstants.CENTER
                );

        subtitleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitleLabel.setForeground(
                new Color(
                        220,
                        230,
                        240
                )
        );

        headerPanel.add(bankLabel);
        headerPanel.add(subtitleLabel);

        // ==================================================
        // REGISTRATION CARD
        // ==================================================

        JPanel cardPanel =
                new JPanel();

        cardPanel.setLayout(
                new BorderLayout()
        );

        cardPanel.setBackground(
                Color.WHITE
        );

        cardPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        220,
                                        225,
                                        232
                                )
                        ),
                        BorderFactory.createEmptyBorder(
                                25,
                                45,
                                25,
                                45
                        )
                )
        );

        // ==================================================
        // TITLE
        // ==================================================

        JLabel titleLabel =
                new JLabel(
                        "Create Your Account",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        titleLabel.setForeground(
                new Color(
                        30,
                        40,
                        55
                )
        );

        // ==================================================
        // FORM
        // ==================================================

        JPanel formPanel =
                new JPanel();

        formPanel.setLayout(
                new GridLayout(
                        6,
                        1,
                        8,
                        5
                )
        );

        formPanel.setBackground(
                Color.WHITE
        );

        // Name

        JLabel nameLabel =
                createLabel(
                        "Full Name"
                );

        nameField =
                new JTextField();

        styleTextField(
                nameField
        );

        // Email

        JLabel emailLabel =
                createLabel(
                        "Email Address"
                );

        emailField =
                new JTextField();

        styleTextField(
                emailField
        );

        // Password

        JLabel passwordLabel =
                createLabel(
                        "Password"
                );

        passwordField =
                new JPasswordField();

        styleTextField(
                passwordField
        );

        formPanel.add(nameLabel);
        formPanel.add(nameField);

        formPanel.add(emailLabel);
        formPanel.add(emailField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // ==================================================
        // BUTTON PANEL
        // ==================================================

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setLayout(
                new GridLayout(
                        1,
                        2,
                        15,
                        0
                )
        );

        buttonPanel.setBackground(
                Color.WHITE
        );

        registerButton =
                createPrimaryButton(
                        "📝  Create Account"
                );

        backButton =
                createSecondaryButton(
                        "←  Back to Login"
                );

        buttonPanel.add(
                registerButton
        );

        buttonPanel.add(
                backButton
        );

        // ==================================================
        // CENTER
        // ==================================================

        JPanel centerPanel =
                new JPanel();

        centerPanel.setLayout(
                new BorderLayout(
                        0,
                        20
                )
        );

        centerPanel.setBackground(
                Color.WHITE
        );

        centerPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        centerPanel.add(
                formPanel,
                BorderLayout.CENTER
        );

        centerPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        cardPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // ==================================================
        // FOOTER
        // ==================================================

        JLabel footerLabel =
                new JLabel(
                        "🔒 Your information is securely protected",
                        SwingConstants.CENTER
                );

        footerLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        footerLabel.setForeground(
                new Color(
                        110,
                        120,
                        135
                )
        );

        // ==================================================
        // ADD COMPONENTS
        // ==================================================

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                cardPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                footerLabel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        // ==================================================
        // REGISTER ACTION
        // ==================================================

        registerButton.addActionListener(e -> {

            String fullName =
                    nameField
                            .getText()
                            .trim();

            String email =
                    emailField
                            .getText()
                            .trim();

            String password =
                    new String(
                            passwordField
                                    .getPassword()
                    );

            // -----------------------------
            // Name validation
            // -----------------------------

            if (fullName.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your full name.",
                        "Invalid Name",
                        JOptionPane.WARNING_MESSAGE
                );

                nameField.requestFocus();

                return;
            }

            // -----------------------------
            // Email validation
            // -----------------------------

            if (email.isEmpty()
                    || !email.contains("@")
                    || !email.contains(".")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid email address.",
                        "Invalid Email",
                        JOptionPane.WARNING_MESSAGE
                );

                emailField.requestFocus();

                return;
            }

            // -----------------------------
            // Password validation
            // -----------------------------

            if (password.isEmpty()
                    || password.length() < 6) {

                JOptionPane.showMessageDialog(
                        this,
                        "Password must contain at least 6 characters.",
                        "Invalid Password",
                        JOptionPane.WARNING_MESSAGE
                );

                passwordField.requestFocus();

                return;
            }

            // -----------------------------
            // Register
            // -----------------------------

            boolean success =
                    loginController.register(
                            fullName,
                            email,
                            password
                    );

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Account created successfully!\n"
                                + "You can now login.",
                        "Registration Successful",
                        JOptionPane.INFORMATION_MESSAGE
                );

                dispose();

                LoginFrame loginFrame =
                        new LoginFrame();

                loginFrame.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Registration failed.\n"
                                + "The email may already be registered.",
                        "Registration Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // ==================================================
        // BACK BUTTON
        // ==================================================

        backButton.addActionListener(e -> {

            dispose();

            LoginFrame loginFrame =
                    new LoginFrame();

            loginFrame.setVisible(true);
        });
    }

    // ==================================================
    // LABEL
    // ==================================================

    private JLabel createLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(
                new Color(
                        45,
                        55,
                        70
                )
        );

        return label;
    }

    // ==================================================
    // TEXT FIELD STYLE
    // ==================================================

    private void styleTextField(
            JTextField field) {

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        205,
                                        212,
                                        222
                                )
                        ),
                        BorderFactory.createEmptyBorder(
                                8,
                                10,
                                8,
                                10
                        )
                )
        );
    }

    // ==================================================
    // PRIMARY BUTTON
    // ==================================================

    private JButton createPrimaryButton(
            String text) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                new Color(
                        30,
                        80,
                        135
                )
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setMargin(
                new Insets(
                        12,
                        15,
                        12,
                        15
                )
        );

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        12,
                        15,
                        12,
                        15
                )
        );

        return button;
    }

    // ==================================================
    // SECONDARY BUTTON
    // ==================================================

    private JButton createSecondaryButton(
            String text) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(
                new Color(
                        30,
                        80,
                        135
                )
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                30,
                                80,
                                135
                        )
                )
        );

        return button;
    }

}