package com.banking.BankingManagementSystem.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;

import com.banking.BankingManagementSystem.controller.AccountController;
import com.banking.BankingManagementSystem.model.Account;

public class WithdrawFrame extends JFrame {

    private JTextField emailField;

    private JTextField amountField;

    private JPasswordField pinField;

    private AccountController accountController;

    private String email;

    public WithdrawFrame(String email) {

        this.email = email;

        accountController = new AccountController();

        setTitle("MY BANK - Withdraw Money");

        setSize(600, 500);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setResizable(false);

        // Main background

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // ================= HEADER =================

        JPanel headerPanel =
                new JPanel(new BorderLayout());

        headerPanel.setBackground(
                new Color(30, 55, 90)
        );

        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );

        JLabel bankLabel =
                new JLabel("🏦 MY BANK");

        bankLabel.setForeground(
                Color.WHITE
        );

        bankLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Withdraw money securely from your account"
                );

        subtitleLabel.setForeground(
                new Color(220, 230, 240)
        );

        subtitleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        JPanel headerTextPanel =
                new JPanel(new BorderLayout());

        headerTextPanel.setOpaque(false);

        headerTextPanel.add(
                bankLabel,
                BorderLayout.NORTH
        );

        headerTextPanel.add(
                subtitleLabel,
                BorderLayout.SOUTH
        );

        headerPanel.add(
                headerTextPanel,
                BorderLayout.WEST
        );

        // ================= CARD =================

        JPanel cardPanel =
                new JPanel(new GridBagLayout());

        cardPanel.setBackground(
                Color.WHITE
        );

        cardPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 225, 230)
                        ),
                        BorderFactory.createEmptyBorder(
                                25,
                                35,
                                25,
                                35
                        )
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(8, 8, 8, 8);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1.0;

        // ================= TITLE =================

        JLabel titleLabel =
                new JLabel(
                        "Withdraw Money",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        titleLabel.setForeground(
                new Color(30, 55, 90)
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        cardPanel.add(
                titleLabel,
                gbc
        );

        // ================= EMAIL =================

        JLabel emailLabel =
                new JLabel("Logged-in Email");

        emailLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;

        cardPanel.add(
                emailLabel,
                gbc
        );

        emailField =
                new JTextField(email);

        emailField.setEditable(false);

        emailField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        emailField.setBackground(
                new Color(240, 242, 245)
        );

        gbc.gridx = 1;

        cardPanel.add(
                emailField,
                gbc
        );

        // ================= AMOUNT =================

        JLabel amountLabel =
                new JLabel(
                        "Withdrawal Amount (₹)"
                );

        amountLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        cardPanel.add(
                amountLabel,
                gbc
        );

        amountField =
                new JTextField();

        amountField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        gbc.gridx = 1;

        cardPanel.add(
                amountField,
                gbc
        );

        // ================= PIN =================

        JLabel pinLabel =
                new JLabel("Security PIN");

        pinLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 3;

        cardPanel.add(
                pinLabel,
                gbc
        );

        pinField =
                new JPasswordField();

        pinField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        gbc.gridx = 1;

        cardPanel.add(
                pinField,
                gbc
        );

        // ================= BUTTONS =================

        JButton withdrawButton =
                new JButton(
                        "💸 Withdraw Money"
                );

        stylePrimaryButton(
                withdrawButton
        );

        JButton cancelButton =
                new JButton(
                        "✕ Cancel"
                );

        styleSecondaryButton(
                cancelButton
        );

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setOpaque(false);

        buttonPanel.add(
                withdrawButton
        );

        buttonPanel.add(
                cancelButton
        );

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        gbc.insets =
                new Insets(
                        20,
                        8,
                        8,
                        8
                );

        cardPanel.add(
                buttonPanel,
                gbc
        );

        // ================= FOOTER =================

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
                        100,
                        110,
                        120
                )
        );

        footerLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        15,
                        10
                )
        );

        // ================= ADD COMPONENTS =================

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

        // ================= ACTIONS =================

        withdrawButton.addActionListener(
                e -> withdrawMoney()
        );

        cancelButton.addActionListener(
                e -> dispose()
        );
    }

    // =====================================================
    // WITHDRAW MONEY
    // =====================================================

    private void withdrawMoney() {

        String amountText =
                amountField.getText().trim();

        String pin =
                new String(
                        pinField.getPassword()
                ).trim();

        // Amount validation

        if (amountText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the withdrawal amount.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        BigDecimal amount;

        try {

            amount =
                    new BigDecimal(amountText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid amount.",
                    "Invalid Amount",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        if (amount.compareTo(
                BigDecimal.ZERO
        ) <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Withdrawal amount must be greater than zero.",
                    "Invalid Amount",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (amount.scale() > 2) {

            JOptionPane.showMessageDialog(
                    this,
                    "Amount can have maximum 2 decimal places.",
                    "Invalid Amount",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // PIN validation

        if (!pin.matches("\\d{4}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Security PIN must be exactly 4 digits.",
                    "Invalid PIN",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Get account

        Account account =
                accountController.getAccountByEmail(
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

        // Verify PIN

        boolean pinValid =
                accountController.verifySecurityPin(
                        account.getAccountNumber(),
                        pin
                );

        if (!pinValid) {

            JOptionPane.showMessageDialog(
                    this,
                    "Incorrect security PIN.",
                    "Authentication Failed",
                    JOptionPane.ERROR_MESSAGE
            );

            pinField.setText("");

            return;
        }

        // Withdraw

        boolean success =
                accountController.withdrawMoney(
                        account.getAccountNumber(),
                        amount
                );

        if (success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Withdrawal successful!\n\n"
                            + "Account Number: "
                            + account.getAccountNumber()
                            + "\nAmount: ₹"
                            + amount
                                    .setScale(2)
                                    .toPlainString(),
                    "Transaction Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );

            amountField.setText("");

            pinField.setText("");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Withdrawal failed.\n"
                            + "Please check your balance and try again.",
                    "Transaction Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // BUTTON STYLING
    // =====================================================

    private void stylePrimaryButton(
            JButton button) {

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
                        55,
                        90
                )
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        18,
                        10,
                        18
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setPreferredSize(
                new Dimension(
                        180,
                        42
                )
        );
    }

    private void styleSecondaryButton(
            JButton button) {

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
                        55,
                        90
                )
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                30,
                                55,
                                90
                        )
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setPreferredSize(
                new Dimension(
                        120,
                        42
                )
        );
    }
}