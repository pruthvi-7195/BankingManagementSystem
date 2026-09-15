package com.banking.BankingManagementSystem.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class BalanceFrame extends JFrame {

    private JLabel balanceLabel;
    private JLabel accountLabel;
    private AccountController accountController;
    private String email;

    public BalanceFrame(String email) {

        this.email = email;

        accountController = new AccountController();

        setTitle("MY BANK - Account Balance");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        bankLabel.setForeground(Color.WHITE);

        bankLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        JLabel subtitleLabel =
                new JLabel(
                        "View your current account balance"
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

        cardPanel.setBackground(Color.WHITE);

        cardPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 225, 230)
                        ),
                        BorderFactory.createEmptyBorder(
                                30, 40, 30, 40
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
                        "Account Balance",
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

        JLabel emailTitle =
                new JLabel(
                        "Logged-in Email"
                );

        emailTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        cardPanel.add(
                emailTitle,
                gbc
        );

        JLabel emailLabel =
                new JLabel(email);

        emailLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        gbc.gridx = 1;

        cardPanel.add(
                emailLabel,
                gbc
        );

        // ================= ACCOUNT NUMBER =================

        JLabel accountTitle =
                new JLabel(
                        "Account Number"
                );

        accountTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        cardPanel.add(
                accountTitle,
                gbc
        );

        accountLabel =
                new JLabel(
                        "Loading..."
                );

        accountLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        gbc.gridx = 1;

        cardPanel.add(
                accountLabel,
                gbc
        );

        // ================= BALANCE =================

        JLabel balanceTitle =
                new JLabel(
                        "Available Balance"
                );

        balanceTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 3;

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
                        24
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

        // ================= BUTTONS =================

        JButton refreshButton =
                new JButton(
                        "🔄 Refresh Balance"
                );

        stylePrimaryButton(
                refreshButton
        );

        JButton closeButton =
                new JButton(
                        "✕ Close"
                );

        styleSecondaryButton(
                closeButton
        );

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setOpaque(false);

        buttonPanel.add(
                refreshButton
        );

        buttonPanel.add(
                closeButton
        );

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        gbc.insets =
                new Insets(
                        25, 10, 10, 10
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

        // ================= LOAD BALANCE =================

        loadBalance();

        // ================= ACTIONS =================

        refreshButton.addActionListener(
                e -> loadBalance()
        );

        closeButton.addActionListener(
                e -> dispose()
        );
    }

    // =====================================================
    // LOAD BALANCE
    // =====================================================

    private void loadBalance() {

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

            accountLabel.setText(
                    "Not Available"
            );

            balanceLabel.setText(
                    "₹ 0.00"
            );

            return;
        }

        accountLabel.setText(
                String.valueOf(
                        account.getAccountNumber()
                )
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
    // PRIMARY BUTTON STYLE
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
                new Color(30, 55, 90)
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 18, 10, 18
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setPreferredSize(
                new Dimension(
                        175,
                        42
                )
        );
    }

    // =====================================================
    // SECONDARY BUTTON STYLE
    // =====================================================

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
}