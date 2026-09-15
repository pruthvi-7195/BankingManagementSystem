package com.banking.BankingManagementSystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
import javax.swing.SwingUtilities;

import com.banking.BankingManagementSystem.controller.LoginController;
import com.banking.BankingManagementSystem.service.UserService;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    private JButton loginButton;
    private JButton registerButton;

    private LoginController loginController;
    private UserService userService;

    public LoginFrame() {

        loginController = new LoginController();
        userService = new UserService();

        setTitle("My Bank - Login");

        setSize(650, 550);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        // ==================================================
        // MAIN PANEL
        // ==================================================

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // ==================================================
        // HEADER
        // ==================================================

        JPanel headerPanel = new JPanel();

        headerPanel.setLayout(
                new GridLayout(2, 1)
        );

        headerPanel.setBackground(
                new Color(30, 55, 90)
        );

        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        20,
                        25,
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

        JLabel welcomeLabel =
                new JLabel(
                        "Secure Banking Management System",
                        SwingConstants.CENTER
                );

        welcomeLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        welcomeLabel.setForeground(
                new Color(
                        220,
                        230,
                        240
                )
        );

        headerPanel.add(bankLabel);
        headerPanel.add(welcomeLabel);

        // ==================================================
        // LOGIN CARD
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
        // LOGIN TITLE
        // ==================================================

        JLabel titleLabel =
                new JLabel(
                        "Welcome Back",
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
        // FORM PANEL
        // ==================================================

        JPanel formPanel =
                new JPanel();

        formPanel.setLayout(
                new GridLayout(
                        4,
                        1,
                        10,
                        10
                )
        );

        formPanel.setBackground(
                Color.WHITE
        );

        JLabel emailLabel =
                new JLabel("Email Address");

        emailLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        emailField =
                new JTextField();

        styleTextField(emailField);

        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        passwordField =
                new JPasswordField();

        styleTextField(passwordField);

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

        loginButton =
                createButton(
                        "🔐  Login"
                );

        registerButton =
                createSecondaryButton(
                        "📝  Create Account"
                );

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        // ==================================================
        // CENTER PANEL
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
                        "Your security is our priority",
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
        // ADD TO MAIN PANEL
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
        // LOGIN ACTION
        // ==================================================

        loginButton.addActionListener(e -> {

            String email =
                    emailField
                            .getText()
                            .trim();

            String password =
                    new String(
                            passwordField
                                    .getPassword()
                    );

            if (email.isEmpty()
                    || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter email and password.",
                        "Login Required",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            boolean success =
                    loginController.login(
                            email,
                            password
                    );

            if (success) {

                String fullName =
                        userService
                                .getFullNameByEmail(
                                        email
                                );

                dispose();

                DashboardFrame dashboardFrame =
                        new DashboardFrame(
                                fullName,
                                email
                        );

                dashboardFrame.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid email or password.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // ==================================================
        // REGISTER ACTION
        // ==================================================

        registerButton.addActionListener(e -> {

            dispose();

            RegisterFrame registerFrame =
                    new RegisterFrame();

            registerFrame.setVisible(true);
        });
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

        field.setPreferredSize(
                new Dimension(
                        300,
                        42
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

    private JButton createButton(
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
                        ),
                        1
                )
        );

        return button;
    }

    // ==================================================
    // MAIN
    // ==================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LoginFrame loginFrame =
                    new LoginFrame();

            loginFrame.setVisible(true);
        });
    }
}