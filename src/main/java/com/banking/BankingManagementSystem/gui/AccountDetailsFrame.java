package com.banking.BankingManagementSystem.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

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

public class AccountDetailsFrame extends JFrame {

    private AccountController accountController;
    private String email;

    private JLabel accountNumberLabel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel balanceLabel;

    public AccountDetailsFrame(String email) {

        this.email = email;

        accountController =
                new AccountController();

        setTitle("MY BANK - Account Details");
        setSize(600, 520);
        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );
        setLocationRelativeTo(null);
        setResizable(false);

        // ================= MAIN PANEL =================

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
                        20, 30, 20, 30
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
                        "View your bank account information"
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
                                30, 45, 30, 45
                        )
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        10, 10, 10, 10
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1.0;

        // ================= TITLE =================

        JLabel titleLabel =
                new JLabel(
                        "Account Details",
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

        // ================= ACCOUNT NUMBER =================

        JLabel accountTitle =
                createFieldTitle(
                        "Account Number"
                );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        cardPanel.add(
                accountTitle,
                gbc
        );

        accountNumberLabel =
                createValueLabel(
                        "Loading..."
                );

        gbc.gridx = 1;

        cardPanel.add(
                accountNumberLabel,
                gbc
        );

        // ================= FULL NAME =================

        JLabel nameTitle =
                createFieldTitle(
                        "Full Name"
                );

        gbc.gridx = 0;
        gbc.gridy = 2;

        cardPanel.add(
                nameTitle,
                gbc
        );

        nameLabel =
                createValueLabel(
                        "Loading..."
                );

        gbc.gridx = 1;

        cardPanel.add(
                nameLabel,
                gbc
        );

        // ================= EMAIL =================

        JLabel emailTitle =
                createFieldTitle(
                        "Email Address"
                );

        gbc.gridx = 0;
        gbc.gridy = 3;

        cardPanel.add(
                emailTitle,
                gbc
        );

        emailLabel =
                createValueLabel(
                        "Loading..."
                );

        gbc.gridx = 1;

        cardPanel.add(
                emailLabel,
                gbc
        );

        // ================= BALANCE =================

        JLabel balanceTitle =
                createFieldTitle(
                        "Current Balance"
                );

        gbc.gridx = 0;
        gbc.gridy = 4;

        cardPanel.add(
                balanceTitle,
                gbc
        );

        balanceLabel =
                new JLabel(
                        "₹ 0.00"
                );

        balanceLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        balanceLabel.setForeground(
                new Color(30, 55, 90)
        );

        gbc.gridx = 1;

        cardPanel.add(
                balanceLabel,
                gbc
        );

        // ================= CLOSE BUTTON =================

        JButton closeButton =
                new JButton(
                        "✕ Close"
                );

        styleButton(closeButton);

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setOpaque(false);

        buttonPanel.add(
                closeButton
        );

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;

        gbc.insets =
                new Insets(
                        25, 10, 5, 10
                );

        cardPanel.add(
                buttonPanel,
                gbc
        );

        // ================= FOOTER =================

        JLabel footerLabel =
                new JLabel(
                        "🔒 Your account information is securely displayed",
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
                new Color(100, 110, 120)
        );

        footerLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 15, 10
                )
        );

        // ================= ADD PANELS =================

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

        // ================= LOAD ACCOUNT =================

        loadAccountDetails();

        // ================= ACTION =================

        closeButton.addActionListener(
                e -> dispose()
        );
    }

    // =====================================================
    // LOAD ACCOUNT DETAILS
    // =====================================================

    private void loadAccountDetails() {

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

            accountNumberLabel.setText(
                    "Not Available"
            );

            nameLabel.setText(
                    "Not Available"
            );

            emailLabel.setText(
                    email
            );

            balanceLabel.setText(
                    "₹ 0.00"
            );

            return;
        }

        accountNumberLabel.setText(
                String.valueOf(
                        account.getAccountNumber()
                )
        );

        nameLabel.setText(
                account.getFullName()
        );

        emailLabel.setText(
                account.getEmail()
        );

        BigDecimal balance =
                account.getBalance();

        if (balance == null) {

            balance =
                    BigDecimal.ZERO;
        }

        balanceLabel.setText(
                "₹ "
                + balance
                        .setScale(2)
                        .toPlainString()
        );
    }

    // =====================================================
    // FIELD TITLE
    // =====================================================

    private JLabel createFieldTitle(
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
                new Color(50, 60, 70)
        );

        return label;
    }

    // =====================================================
    // VALUE LABEL
    // =====================================================

    private JLabel createValueLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        label.setForeground(
                new Color(80, 90, 100)
        );

        return label;
    }

    // =====================================================
    // BUTTON STYLE
    // =====================================================

    private void styleButton(
            JButton button) {

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(
                new Color(30, 55, 90)
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(30, 55, 90)
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

    // ================= TEST MAIN =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AccountDetailsFrame frame =
                    new AccountDetailsFrame(
                            "test@example.com"
                    );

            frame.setVisible(true);
        });
    }
}