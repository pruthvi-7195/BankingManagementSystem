
package com.banking.BankingManagementSystem.service;

import java.math.BigDecimal;
import java.util.List;

import com.banking.BankingManagementSystem.dao.TransactionDAO;
import com.banking.BankingManagementSystem.model.Transaction;

public class TransactionService {

    private TransactionDAO transactionDAO;

    public TransactionService() {
        transactionDAO = new TransactionDAO();
    }

    public boolean addTransaction(
            long accountNumber,
            String transactionType,
            BigDecimal amount,
            String description) {

        return transactionDAO.addTransaction(
                accountNumber,
                transactionType,
                amount,
                description
        );
    }

    public List<Transaction> getTransactionsByAccount(
            long accountNumber) {

        return transactionDAO.getTransactionsByAccount(
                accountNumber
        );
    }
}
