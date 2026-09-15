package com.banking.BankingManagementSystem.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

public class DashboardFrame extends JFrame {

    private JLabel welcomeLabel;

    private JButton openAccountButton;
    private JButton accountDetailsButton;
    private JButton balanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JButton transactionHistoryButton;
    private JButton logoutButton;

    private String fullName;
    private String email;

    // --------------------------------------------------
    // Constructor
    // --------------------------------------------------

    public DashboardFrame(String fullName, String email) {

        this.fullName = fullName;
        this.email = email;

        setTitle("Banking Management System - Dashboard");

        setSize(850, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        // --------------------------------------------------
        // Main Background
        // --------------------------------------------------

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // --------------------------------------------------
        // HEADER
        // --------------------------------------------------

        JPanel headerPanel = new JPanel();

        headerPanel.setLayout(
                new BorderLayout()
        );

        headerPanel.setBackground(
                new Color(30, 55, 90)
        );

        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        18,
                        25,
                        18,
                        25
                )
        );

        // Bank title

        JLabel bankLabel =
                new JLabel(
                        "🏦  MY BANK"
                );

        bankLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        bankLabel.setForeground(
                Color.WHITE
        );

        // Welcome text

        welcomeLabel =
                new JLabel(
                        "Welcome, " + fullName
                );

        welcomeLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        17
                )
        );

        welcomeLabel.setForeground(
                Color.WHITE
        );

        welcomeLabel.setHorizontalAlignment(
                SwingConstants.RIGHT
        );

        headerPanel.add(
                bankLabel,
                BorderLayout.WEST
        );

        headerPanel.add(
                welcomeLabel,
                BorderLayout.EAST
        );

        // --------------------------------------------------
        // TITLE SECTION
        // --------------------------------------------------

        JPanel titlePanel =
                new JPanel();

        titlePanel.setLayout(
                new BorderLayout()
        );

        titlePanel.setBackground(
                new Color(245, 247, 250)
        );

        titlePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        35,
                        15,
                        35
                )
        );

        JLabel dashboardTitle =
                new JLabel(
                        "Banking Dashboard"
                );

        dashboardTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        27
                )
        );

        dashboardTitle.setForeground(
                new Color(30, 40, 55)
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Manage your account and transactions"
                );

        subtitleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        subtitleLabel.setForeground(
                new Color(100, 110, 125)
        );

        titlePanel.add(
                dashboardTitle,
                BorderLayout.NORTH
        );

        titlePanel.add(
                subtitleLabel,
                BorderLayout.CENTER
        );

        // --------------------------------------------------
        // BUTTON PANEL
        // --------------------------------------------------

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setLayout(
                new GridLayout(
                        4,
                        2,
                        18,
                        18
                )
        );

        buttonPanel.setBackground(
                new Color(245, 247, 250)
        );

        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        35,
                        25,
                        35
                )
        );

        // --------------------------------------------------
        // CREATE BUTTONS
        // --------------------------------------------------

        openAccountButton =
                createButton(
                        "💳  Open Bank Account"
                );

        accountDetailsButton =
                createButton(
                        "👤  Account Details"
                );

        balanceButton =
                createButton(
                        "💰  Check Balance"
                );

        depositButton =
                createButton(
                        "➕  Deposit Money"
                );

        withdrawButton =
                createButton(
                        "💸  Withdraw Money"
                );

        transferButton =
                createButton(
                        "🔄  Transfer Money"
                );

        transactionHistoryButton =
                createButton(
                        "📜  Transaction History"
                );

        logoutButton =
                createLogoutButton(
                        "🚪  Logout"
                );

        // --------------------------------------------------
        // ADD BUTTONS
        // --------------------------------------------------

        buttonPanel.add(
                openAccountButton
        );

        buttonPanel.add(
                accountDetailsButton
        );

        buttonPanel.add(
                balanceButton
        );

        buttonPanel.add(
                depositButton
        );

        buttonPanel.add(
                withdrawButton
        );

        buttonPanel.add(
                transferButton
        );

        buttonPanel.add(
                transactionHistoryButton
        );

        buttonPanel.add(
                logoutButton
        );

        // --------------------------------------------------
        // FOOTER
        // --------------------------------------------------

        JPanel footerPanel =
                new JPanel();

        footerPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER
                )
        );

        footerPanel.setBackground(
                new Color(30, 55, 90)
        );

        JLabel footerLabel =
                new JLabel(
                        "Secure Banking Management System  •  Java + JDBC + MySQL"
                );

        footerLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        footerLabel.setForeground(
                Color.WHITE
        );

        footerPanel.add(
                footerLabel
        );

        // --------------------------------------------------
        // CENTER CONTENT
        // --------------------------------------------------

        JPanel centerPanel =
                new JPanel();

        centerPanel.setLayout(
                new BorderLayout()
        );

        centerPanel.setBackground(
                new Color(245, 247, 250)
        );

        centerPanel.add(
                titlePanel,
                BorderLayout.NORTH
        );

        centerPanel.add(
                buttonPanel,
                BorderLayout.CENTER
        );

        // --------------------------------------------------
        // ADD TO FRAME
        // --------------------------------------------------

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                footerPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        // --------------------------------------------------
        // OPEN ACCOUNT
        // --------------------------------------------------

        openAccountButton.addActionListener(e -> {

            OpenAccountFrame openAccountFrame =
                    new OpenAccountFrame(
                            fullName,
                            email
                    );

            openAccountFrame.setVisible(true);
        });

        // --------------------------------------------------
        // ACCOUNT DETAILS
        // --------------------------------------------------

        accountDetailsButton.addActionListener(e -> {

            AccountDetailsFrame accountDetailsFrame =
                    new AccountDetailsFrame(
                            email
                    );

            accountDetailsFrame.setVisible(true);
        });

        // --------------------------------------------------
        // CHECK BALANCE
        // --------------------------------------------------

        balanceButton.addActionListener(e -> {

            BalanceFrame balanceFrame =
                    new BalanceFrame(
                            email
                    );

            balanceFrame.setVisible(true);
        });

        // --------------------------------------------------
        // DEPOSIT
        // --------------------------------------------------

        depositButton.addActionListener(e -> {

            DepositFrame depositFrame =
                    new DepositFrame(
                            email
                    );

            depositFrame.setVisible(true);
        });

        // --------------------------------------------------
        // WITHDRAW
        // --------------------------------------------------

        withdrawButton.addActionListener(e -> {

            WithdrawFrame withdrawFrame =
                    new WithdrawFrame(
                            email
                    );

            withdrawFrame.setVisible(true);
        });

        // --------------------------------------------------
        // TRANSFER
        // --------------------------------------------------

        transferButton.addActionListener(e -> {

            TransferFrame transferFrame =
                    new TransferFrame(
                            email
                    );

            transferFrame.setVisible(true);
        });

        // --------------------------------------------------
        // TRANSACTION HISTORY
        // --------------------------------------------------

        transactionHistoryButton.addActionListener(e -> {

            TransactionHistoryFrame transactionHistoryFrame =
                    new TransactionHistoryFrame(
                            email
                    );

            transactionHistoryFrame.setVisible(true);
        });

        // --------------------------------------------------
        // LOGOUT
        // --------------------------------------------------

        logoutButton.addActionListener(e -> {

            dispose();

            LoginFrame loginFrame =
                    new LoginFrame();

            loginFrame.setVisible(true);
        });
    }

    // ==================================================
    // CREATE NORMAL BUTTON
    // ==================================================

    private JButton createButton(String text) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        button.setForeground(
                new Color(35, 45, 60)
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        215,
                                        220,
                                        228
                                ),
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                15,
                                15,
                                15,
                                15
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
                        300,
                        80
                )
        );

        // Hover effect

        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                new Color(
                                        235,
                                        242,
                                        250
                                )
                        );

                        button.setBorder(
                                BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(
                                                new Color(
                                                        30,
                                                        90,
                                                        150
                                                ),
                                                2
                                        ),
                                        BorderFactory.createEmptyBorder(
                                                14,
                                                14,
                                                14,
                                                14
                                        )
                                )
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                Color.WHITE
                        );

                        button.setBorder(
                                BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(
                                                new Color(
                                                        215,
                                                        220,
                                                        228
                                                ),
                                                1
                                        ),
                                        BorderFactory.createEmptyBorder(
                                                15,
                                                15,
                                                15,
                                                15
                                        )
                                )
                        );
                    }
                }
        );

        return button;
    }

    // ==================================================
    // LOGOUT BUTTON
    // ==================================================

    private JButton createLogoutButton(String text) {

        JButton button =
                createButton(text);

        button.setForeground(
                new Color(
                        180,
                        45,
                        45
                )
        );

        return button;
    }

}