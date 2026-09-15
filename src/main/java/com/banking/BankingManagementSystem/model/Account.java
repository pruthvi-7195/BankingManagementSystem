package com.banking.BankingManagementSystem.model;

import java.math.BigDecimal;

public class Account {


private long accountNumber;
private String fullName;
private String email;
private BigDecimal balance;
private String securityPin;

public Account() {
}

public Account(
        long accountNumber,
        String fullName,
        String email,
        BigDecimal balance,
        String securityPin) {

    this.accountNumber = accountNumber;
    this.fullName = fullName;
    this.email = email;
    this.balance = balance;
    this.securityPin = securityPin;
}

public long getAccountNumber() {
    return accountNumber;
}

public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
}

public String getFullName() {
    return fullName;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public BigDecimal getBalance() {
    return balance;
}

public void setBalance(BigDecimal balance) {
    this.balance = balance;
}

public String getSecurityPin() {
    return securityPin;
}

public void setSecurityPin(String securityPin) {
    this.securityPin = securityPin;
}


}
