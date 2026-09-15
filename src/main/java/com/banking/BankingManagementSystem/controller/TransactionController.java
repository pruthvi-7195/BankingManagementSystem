
package com.banking.BankingManagementSystem.controller;

import java.util.List;

import com.banking.BankingManagementSystem.model.Transaction;
import com.banking.BankingManagementSystem.service.TransactionService;

public class TransactionController {

    private TransactionService transactionService;

    public TransactionController() {

        transactionService = new TransactionService();
    }

    // Add a transaction
    public boolean addTransaction(
            long accountNumber,
            String transactionType,
            double amount,
            String description) {

        return transactionService.addTransaction(
                accountNumber,
                transactionType,
                amount,
                description
        );
    }

    // Get transaction history
    public List<Transaction> getTransactionsByAccount(
            long accountNumber) {

        return transactionService.getTransactionsByAccount(
                accountNumber
        );
    }
}
