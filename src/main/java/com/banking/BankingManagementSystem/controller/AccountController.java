
package com.banking.BankingManagementSystem.controller;

import java.math.BigDecimal;

import com.banking.BankingManagementSystem.model.Account;
import com.banking.BankingManagementSystem.service.AccountService;

public class AccountController {

    private AccountService accountService;

    public AccountController() {

        accountService =
                new AccountService();
    }

    public boolean createAccount(
            Account account) {

        return accountService.createAccount(
                account
        );
    }

    public Account getAccountByEmail(
            String email) {

        return accountService.getAccountByEmail(
                email
        );
    }
    public boolean accountNumberExists(long accountNumber) {

    	return accountService.accountNumberExists(
    	        accountNumber
    	);

    	}

    public boolean depositMoney(
            long accountNumber,
            BigDecimal amount) {

        return accountService.depositMoney(
                accountNumber,
                amount
        );
    }

    public BigDecimal getBalance(
            long accountNumber) {

        return accountService.getBalance(
                accountNumber
        );
    }

    public boolean withdrawMoney(
            long accountNumber,
            BigDecimal amount) {

        return accountService.withdrawMoney(
                accountNumber,
                amount
        );
    }

    public boolean transferMoney(
            long senderAccountNumber,
            long receiverAccountNumber,
            BigDecimal amount) {

        return accountService.transferMoney(
                senderAccountNumber,
                receiverAccountNumber,
                amount
        );
    }

    public boolean verifySecurityPin(
            long accountNumber,
            String enteredPin) {

        return accountService.verifySecurityPin(
                accountNumber,
                enteredPin
        );
    }
}
