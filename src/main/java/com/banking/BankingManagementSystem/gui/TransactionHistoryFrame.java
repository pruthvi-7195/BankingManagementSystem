package com.banking.BankingManagementSystem.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.util.List;

import com.banking.BankingManagementSystem.controller.AccountController;
import com.banking.BankingManagementSystem.model.Account;
import com.banking.BankingManagementSystem.model.Transaction;
import com.banking.BankingManagementSystem.service.TransactionService;

public class TransactionHistoryFrame extends JFrame {

    private JTable transactionTable;
    private DefaultTableModel tableModel;
    private AccountController accountController;
    private TransactionService transactionService;
    private String email;

    public TransactionHistoryFrame(String email) {

        this.email = email;

        accountController =
                new AccountController();

        transactionService =
                new TransactionService();

        setTitle("MY BANK - Transaction History");

        setSize(850, 600);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

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
                        "View your complete transaction history"
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

        // ================= TITLE PANEL =================

        JPanel titlePanel =
                new JPanel(new BorderLayout());

        titlePanel.setBackground(
                new Color(245, 247, 250)
        );

        titlePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 25, 10, 25
                )
        );

        JLabel titleLabel =
                new JLabel(
                        "Transaction History"
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

        JLabel emailLabel =
                new JLabel(
                        "Account: " + email
                );

        emailLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        emailLabel.setForeground(
                new Color(90, 100, 110)
        );

        titlePanel.add(
                titleLabel,
                BorderLayout.WEST
        );

        titlePanel.add(
                emailLabel,
                BorderLayout.EAST
        );

        // ================= TABLE =================

        String[] columns = {

                "ID",
                "Type",
                "Amount",
                "Description",
                "Date"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        transactionTable =
                new JTable(tableModel);

        transactionTable.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        transactionTable.setRowHeight(32);

        transactionTable.setGridColor(
                new Color(225, 230, 235)
        );

        transactionTable.setShowVerticalLines(false);

        transactionTable.setSelectionBackground(
                new Color(220, 230, 240)
        );

        transactionTable.setSelectionForeground(
                Color.BLACK
        );

        // ================= TABLE HEADER =================

        transactionTable.getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                13
                        )
                );

        transactionTable.getTableHeader()
                .setBackground(
                        new Color(30, 55, 90)
                );

        transactionTable.getTableHeader()
                .setForeground(
                        Color.WHITE
                );

        transactionTable.getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                100,
                                35
                        )
                );

        // ================= COLUMN WIDTHS =================

        transactionTable
                .getColumnModel()
                .getColumn(0)
                .setPreferredWidth(50);

        transactionTable
                .getColumnModel()
                .getColumn(1)
                .setPreferredWidth(100);

        transactionTable
                .getColumnModel()
                .getColumn(2)
                .setPreferredWidth(120);

        transactionTable
                .getColumnModel()
                .getColumn(3)
                .setPreferredWidth(280);

        transactionTable
                .getColumnModel()
                .getColumn(4)
                .setPreferredWidth(180);

        // ================= CENTER ALIGNMENT =================

        DefaultTableCellRenderer centerRenderer =
                new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        transactionTable
                .getColumnModel()
                .getColumn(0)
                .setCellRenderer(
                        centerRenderer
                );

        transactionTable
                .getColumnModel()
                .getColumn(1)
                .setCellRenderer(
                        centerRenderer
                );

        transactionTable
                .getColumnModel()
                .getColumn(2)
                .setCellRenderer(
                        centerRenderer
                );

        transactionTable
                .getColumnModel()
                .getColumn(4)
                .setCellRenderer(
                        centerRenderer
                );

        JScrollPane scrollPane =
                new JScrollPane(
                        transactionTable
                );

        scrollPane.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createEmptyBorder(
                                0, 25, 10, 25
                        ),

                        BorderFactory.createLineBorder(
                                new Color(220, 225, 230)
                        )
                )
        );

        // ================= BUTTON PANEL =================

        JButton refreshButton =
                new JButton(
                        "🔄 Refresh"
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

        buttonPanel.setBackground(
                new Color(245, 247, 250)
        );

        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 10, 10, 10
                )
        );

        buttonPanel.add(
                refreshButton
        );

        buttonPanel.add(
                closeButton
        );

        // ================= FOOTER =================

        JLabel footerLabel =
                new JLabel(
                        "🔒 Secure transaction records",
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
                        5, 5, 12, 5
                )
        );

        JPanel bottomPanel =
                new JPanel(new BorderLayout());

        bottomPanel.setBackground(
                new Color(245, 247, 250)
        );

        bottomPanel.add(
                buttonPanel,
                BorderLayout.NORTH
        );

        bottomPanel.add(
                footerLabel,
                BorderLayout.SOUTH
        );

        // ================= ADD COMPONENTS =================

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        JPanel centerPanel =
                new JPanel(new BorderLayout());

        centerPanel.setBackground(
                new Color(245, 247, 250)
        );

        centerPanel.add(
                titlePanel,
                BorderLayout.NORTH
        );

        centerPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        // ================= LOAD DATA =================

        loadTransactions();

        // ================= ACTIONS =================

        refreshButton.addActionListener(
                e -> loadTransactions()
        );

        closeButton.addActionListener(
                e -> dispose()
        );
    }

    // =====================================================
    // LOAD TRANSACTIONS
    // =====================================================

    private void loadTransactions() {

        tableModel.setRowCount(0);

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

        List<Transaction> transactions =
                transactionService
                        .getTransactionsByAccount(
                                account.getAccountNumber()
                        );

        SimpleDateFormat dateFormat =
                new SimpleDateFormat(
                        "dd-MM-yyyy HH:mm:ss"
                );

        for (Transaction transaction :
                transactions) {

            BigDecimal amount =
                    transaction.getAmount();

            String formattedAmount =
                    "₹ "
                    + amount
                            .setScale(2)
                            .toPlainString();

            String formattedDate =
                    transaction.getTransactionDate()
                            != null
                            ? dateFormat.format(
                                    transaction
                                            .getTransactionDate()
                            )
                            : "N/A";

            tableModel.addRow(
                    new Object[] {

                            transaction
                                    .getTransactionId(),

                            transaction
                                    .getTransactionType(),

                            formattedAmount,

                            transaction
                                    .getDescription(),

                            formattedDate
                    }
            );
        }

        if (transactions.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No transactions found for this account.",
                    "Transaction History",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
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
                        130,
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