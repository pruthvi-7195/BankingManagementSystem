
package com.banking.BankingManagementSystem.service;

import java.math.BigDecimal;

import com.banking.BankingManagementSystem.dao.AccountDAO;
import com.banking.BankingManagementSystem.model.Account;

public class AccountService {

    private AccountDAO accountDAO;

    public AccountService() {

        accountDAO =
                new AccountDAO();
    }

    public boolean createAccount(
            Account account) {

        return accountDAO.createAccount(
                account
        );
    }

    public Account getAccountByEmail(
            String email) {

        return accountDAO.getAccountByEmail(
                email
        );
    }
    
    
    	public boolean accountNumberExists(long accountNumber) {

    	
    	return accountDAO.accountNumberExists(
    	        accountNumber
    	);
    	

    	}

    	

    public boolean depositMoney(
            long accountNumber,
            BigDecimal amount) {

        return accountDAO.depositMoney(
                accountNumber,
                amount
        );
    }

    public BigDecimal getBalance(
            long accountNumber) {

        return accountDAO.getBalance(
                accountNumber
        );
    }

    public boolean withdrawMoney(
            long accountNumber,
            BigDecimal amount) {

        return accountDAO.withdrawMoney(
                accountNumber,
                amount
        );
    }

    public boolean transferMoney(
            long senderAccountNumber,
            long receiverAccountNumber,
            BigDecimal amount) {

        return accountDAO.transferMoney(
                senderAccountNumber,
                receiverAccountNumber,
                amount
        );
    }

    public boolean verifySecurityPin(
            long accountNumber,
            String enteredPin) {

        return accountDAO.verifySecurityPin(
                accountNumber,
                enteredPin
        );
    }
}
