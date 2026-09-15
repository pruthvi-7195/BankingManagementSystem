package com.banking.BankingManagementSystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.banking.BankingManagementSystem.controller.AccountController;
import com.banking.BankingManagementSystem.model.Account;

public class OpenAccountFrame extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField depositField;
    private JPasswordField pinField;

    private JButton openButton;
    private JButton cancelButton;

    private AccountController accountController;

    private String fullName;
    private String email;

    public OpenAccountFrame(
            String fullName,
            String email) {

        this.fullName = fullName;
        this.email = email;

        accountController =
                new AccountController();

        setTitle(
                "My Bank - Open Bank Account"
        );

        setSize(650, 600);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
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
                        20,
                        20,
                        20,
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
                        27
                )
        );

        bankLabel.setForeground(
                Color.WHITE
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Open your personal bank account",
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
        // CARD
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
                        "Open Bank Account",
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
                        8,
                        1,
                        6,
                        4
                )
        );

        formPanel.setBackground(
                Color.WHITE
        );

        // Full name

        JLabel nameLabel =
                createLabel(
                        "Full Name"
                );

        nameField =
                new JTextField(
                        fullName
                );

        nameField.setEditable(false);

        styleTextField(
                nameField
        );

        // Email

        JLabel emailLabel =
                createLabel(
                        "Email Address"
                );

        emailField =
                new JTextField(
                        email
                );

        emailField.setEditable(false);

        styleTextField(
                emailField
        );

        // Initial deposit

        JLabel depositLabel =
                createLabel(
                        "Initial Deposit (₹)"
                );

        depositField =
                new JTextField();

        styleTextField(
                depositField
        );

        // Security PIN

        JLabel pinLabel =
                createLabel(
                        "4-Digit Security PIN"
                );

        pinField =
                new JPasswordField();

        styleTextField(
                pinField
        );

        formPanel.add(nameLabel);
        formPanel.add(nameField);

        formPanel.add(emailLabel);
        formPanel.add(emailField);

        formPanel.add(depositLabel);
        formPanel.add(depositField);

        formPanel.add(pinLabel);
        formPanel.add(pinField);

        // ==================================================
        // BUTTONS
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

        openButton =
                createPrimaryButton(
                        "💳  Open Account"
                );

        cancelButton =
                createSecondaryButton(
                        "✕  Cancel"
                );

        buttonPanel.add(
                openButton
        );

        buttonPanel.add(
                cancelButton
        );

        // ==================================================
        // CENTER
        // ==================================================

        JPanel centerPanel =
                new JPanel();

        centerPanel.setLayout(
                new BorderLayout(
                        0,
                        18
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
                        "🔒 Your account information is securely protected",
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
        // OPEN ACCOUNT ACTION
        // ==================================================

        openButton.addActionListener(e -> {

            String initialDepositText =
                    depositField
                            .getText()
                            .trim();

            String securityPin =
                    new String(
                            pinField
                                    .getPassword()
                    );

            // ------------------------------------------
            // Deposit validation
            // ------------------------------------------

            if (initialDepositText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter the initial deposit.",
                        "Deposit Required",
                        JOptionPane.WARNING_MESSAGE
                );

                depositField.requestFocus();

                return;
            }

            BigDecimal initialDeposit;

            try {

                initialDeposit =
                        new BigDecimal(
                                initialDepositText
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid amount.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                depositField.requestFocus();

                return;
            }

            if (initialDeposit.compareTo(
                    BigDecimal.ZERO) < 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Initial deposit cannot be negative.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (initialDeposit.scale() > 2) {

                JOptionPane.showMessageDialog(
                        this,
                        "Amount can have maximum 2 decimal places.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // ------------------------------------------
            // PIN validation
            // ------------------------------------------

            if (!securityPin.matches("\\d{4}")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Security PIN must contain exactly 4 digits.",
                        "Invalid PIN",
                        JOptionPane.WARNING_MESSAGE
                );

                pinField.requestFocus();

                return;
            }

            // ------------------------------------------
            // Existing account check
            // ------------------------------------------

            Account existingAccount =
                    accountController
                            .getAccountByEmail(
                                    email
                            );

            if (existingAccount != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "A bank account already exists for this email.",
                        "Account Already Exists",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // ------------------------------------------
            // Generate unique account number
            // ------------------------------------------

            Random random =
                    new Random();

            long accountNumber;

            do {

                accountNumber =
                        1000000000L
                        + random.nextInt(
                                900000000
                        );

            } while (
                    accountController
                            .accountNumberExists(
                                    accountNumber
                            )
            );

            // ------------------------------------------
            // Create Account
            // ------------------------------------------

            Account account =
                    new Account(
                            accountNumber,
                            fullName,
                            email,
                            initialDeposit,
                            securityPin
                    );

            boolean success =
                    accountController
                            .createAccount(
                                    account
                            );

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "🎉 Bank account created successfully!\n\n"
                                + "Account Number: "
                                + accountNumber
                                + "\n"
                                + "Initial Deposit: ₹"
                                + initialDeposit
                                        .setScale(2)
                                        .toPlainString(),
                        "Account Created",
                        JOptionPane.INFORMATION_MESSAGE
                );

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to create the bank account.\n"
                                + "Please try again.",
                        "Account Creation Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // ==================================================
        // CANCEL
        // ==================================================

        cancelButton.addActionListener(e -> {

            dispose();

        });
    }

    // ==================================================
    // LABEL STYLE
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