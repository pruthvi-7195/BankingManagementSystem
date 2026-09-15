package com.banking.BankingManagementSystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.banking.BankingManagementSystem.controller.AccountController;
import com.banking.BankingManagementSystem.model.Account;

public class DepositFrame extends JFrame {

    private JTextField emailField;
    private JTextField amountField;

    private JButton depositButton;
    private JButton cancelButton;

    private AccountController accountController;

    private String email;

    public DepositFrame(String email) {

        this.email = email;

        accountController =
                new AccountController();

        setTitle(
                "My Bank - Deposit Money"
        );

        setSize(620, 520);

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
                        "Deposit money securely into your account",
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
                                30,
                                50,
                                30,
                                50
                        )
                )
        );

        // ==================================================
        // TITLE
        // ==================================================

        JLabel titleLabel =
                new JLabel(
                        "Deposit Money",
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
                        4,
                        1,
                        8,
                        8
                )
        );

        formPanel.setBackground(
                Color.WHITE
        );

        // Email

        JLabel emailLabel =
                createLabel(
                        "Logged-in Email"
                );

        emailField =
                new JTextField(
                        email
                );

        emailField.setEditable(
                false
        );

        styleTextField(
                emailField
        );

        // Amount

        JLabel amountLabel =
                createLabel(
                        "Deposit Amount (₹)"
                );

        amountField =
                new JTextField();

        styleTextField(
                amountField
        );

        formPanel.add(
                emailLabel
        );

        formPanel.add(
                emailField
        );

        formPanel.add(
                amountLabel
        );

        formPanel.add(
                amountField
        );

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

        depositButton =
                createPrimaryButton(
                        "💰  Deposit Money"
                );

        cancelButton =
                createSecondaryButton(
                        "✕  Cancel"
                );

        buttonPanel.add(
                depositButton
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
                        22
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
                        "🔒 Secure transaction processing",
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
        // DEPOSIT ACTION
        // ==================================================

        depositButton.addActionListener(e -> {

            String amountText =
                    amountField
                            .getText()
                            .trim();

            // ------------------------------------------
            // Empty validation
            // ------------------------------------------

            if (amountText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter the deposit amount.",
                        "Amount Required",
                        JOptionPane.WARNING_MESSAGE
                );

                amountField.requestFocus();

                return;
            }

            // ------------------------------------------
            // Parse amount
            // ------------------------------------------

            BigDecimal amount;

            try {

                amount =
                        new BigDecimal(
                                amountText
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid amount.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                amountField.requestFocus();

                return;
            }

            // ------------------------------------------
            // Positive amount
            // ------------------------------------------

            if (amount.compareTo(
                    BigDecimal.ZERO
            ) <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Deposit amount must be greater than zero.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                amountField.requestFocus();

                return;
            }

            // ------------------------------------------
            // Decimal validation
            // ------------------------------------------

            if (amount.scale() > 2) {

                JOptionPane.showMessageDialog(
                        this,
                        "Amount can have maximum 2 decimal places.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                amountField.requestFocus();

                return;
            }

            // ------------------------------------------
            // Find account
            // ------------------------------------------

            Account account =
                    accountController
                            .getAccountByEmail(
                                    email
                            );

            if (account == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "No bank account is linked to this email.",
                        "Account Not Found",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // ------------------------------------------
            // Deposit
            // ------------------------------------------

            boolean success =
                    accountController
                            .depositMoney(
                                    account.getAccountNumber(),
                                    amount
                            );

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "✅ Deposit successful!\n\n"
                                + "Account Number: "
                                + account.getAccountNumber()
                                + "\n"
                                + "Amount Deposited: ₹"
                                + amount
                                        .setScale(2)
                                        .toPlainString(),
                        "Deposit Successful",
                        JOptionPane.INFORMATION_MESSAGE
                );

                amountField.setText("");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to process the deposit.\n"
                                + "Please try again.",
                        "Deposit Failed",
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

        button.setFocusPainted(
                false
        );

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

        button.setFocusPainted(
                false
        );

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