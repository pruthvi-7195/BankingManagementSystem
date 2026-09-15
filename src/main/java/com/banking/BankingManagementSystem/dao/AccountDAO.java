
package com.banking.BankingManagementSystem.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.BankingManagementSystem.database.DatabaseConnection;
import com.banking.BankingManagementSystem.model.Account;
import com.banking.BankingManagementSystem.security.PasswordUtil;

public class AccountDAO {

    public boolean createAccount(Account account) {

        Connection connection = null;

        try {

            connection =
                    DatabaseConnection.getConnection();

            // Start database transaction
            connection.setAutoCommit(false);

            // Step 1: Create bank account
            String accountSQL =
                    "INSERT INTO Accounts "
                    + "(account_number, full_name, email, balance, security_pin) "
                    + "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement statement =
                         connection.prepareStatement(accountSQL)) {

                statement.setLong(
                        1,
                        account.getAccountNumber()
                );

                statement.setString(
                        2,
                        account.getFullName()
                );

                statement.setString(
                        3,
                        account.getEmail()
                );

                statement.setBigDecimal(
                        4,
                        account.getBalance()
                );

                // Hash security PIN before storing it
                String hashedPin =
                        PasswordUtil.hashPassword(
                                account.getSecurityPin()
                        );

                statement.setString(
                        5,
                        hashedPin
                );

                int rows =
                        statement.executeUpdate();

                if (rows == 0) {

                    connection.rollback();

                    return false;
                }
            }

            // Step 2: Save initial deposit
            // Only create transaction if balance > 0

            if (account.getBalance() != null
                    && account.getBalance()
                             .compareTo(BigDecimal.ZERO) > 0) {

                String transactionSQL =
                        "INSERT INTO Transactions "
                        + "(account_number, transaction_type, "
                        + "amount, description) "
                        + "VALUES (?, ?, ?, ?)";

                try (PreparedStatement statement =
                             connection.prepareStatement(
                                     transactionSQL)) {

                    statement.setLong(
                            1,
                            account.getAccountNumber()
                    );

                    statement.setString(
                            2,
                            "DEPOSIT"
                    );

                    statement.setBigDecimal(
                            3,
                            account.getBalance()
                    );

                    statement.setString(
                            4,
                            "Initial account deposit"
                    );

                    int rows =
                            statement.executeUpdate();

                    if (rows == 0) {

                        connection.rollback();

                        return false;
                    }
                }
            }

            // Step 3: Commit account creation
            // and initial deposit together

            connection.commit();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

            // Undo everything if an error occurs
            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException rollbackException) {

                    rollbackException.printStackTrace();
                }
            }

            return false;

        } finally {

            if (connection != null) {

                try {

                    connection.setAutoCommit(true);

                    connection.close();

                } catch (SQLException closeException) {

                    closeException.printStackTrace();
                }
            }
        }
    }


    public Account getAccountByEmail(String email) {

        String sql =
                "SELECT * FROM Accounts "
                + "WHERE email = ?";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    email
            );

            ResultSet resultSet =
                    statement.executeQuery();

            if (resultSet.next()) {

                Account account =
                        new Account();

                account.setAccountNumber(
                        resultSet.getLong(
                                "account_number"
                        )
                );

                account.setFullName(
                        resultSet.getString(
                                "full_name"
                        )
                );

                account.setEmail(
                        resultSet.getString(
                                "email"
                        )
                );

                account.setBalance(
                        resultSet.getBigDecimal(
                                "balance"
                        )
                );

                account.setSecurityPin(
                        resultSet.getString(
                                "security_pin"
                        )
                );

                return account;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    public boolean depositMoney(
            long accountNumber,
            BigDecimal amount) {

        Connection connection = null;

        try {

            connection =
                    DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            // Step 1: Update account balance

            String balanceSQL =
                    "UPDATE Accounts "
                    + "SET balance = balance + ? "
                    + "WHERE account_number = ?";

            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 balanceSQL)) {

                statement.setBigDecimal(
                        1,
                        amount
                );

                statement.setLong(
                        2,
                        accountNumber
                );

                int rows =
                        statement.executeUpdate();

                if (rows == 0) {

                    connection.rollback();

                    return false;
                }
            }

            // Step 2: Save transaction history

            String transactionSQL =
                    "INSERT INTO Transactions "
                    + "(account_number, transaction_type, "
                    + "amount, description) "
                    + "VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 transactionSQL)) {

                statement.setLong(
                        1,
                        accountNumber
                );

                statement.setString(
                        2,
                        "DEPOSIT"
                );

                statement.setBigDecimal(
                        3,
                        amount
                );

                statement.setString(
                        4,
                        "Money deposited"
                );

                int rows =
                        statement.executeUpdate();

                if (rows == 0) {

                    connection.rollback();

                    return false;
                }
            }

            // Step 3: Commit both operations

            connection.commit();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException rollbackException) {

                    rollbackException.printStackTrace();
                }
            }

            return false;

        } finally {

            if (connection != null) {

                try {

                    connection.setAutoCommit(true);

                    connection.close();

                } catch (SQLException closeException) {

                    closeException.printStackTrace();
                }
            }
        }
    }


    public BigDecimal getBalance(
            long accountNumber) {

        String sql =
                "SELECT balance FROM Accounts "
                + "WHERE account_number = ?";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setLong(
                    1,
                    accountNumber
            );

            ResultSet resultSet =
                    statement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getBigDecimal(
                        "balance"
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    public boolean withdrawMoney(
            long accountNumber,
            BigDecimal amount) {

        Connection connection = null;

        try {

            connection =
                    DatabaseConnection.getConnection();

            // Start database transaction
            connection.setAutoCommit(false);

            // Step 1: Deduct money from account
            // Balance >= amount prevents
            // withdrawal when balance is insufficient.

            String balanceSQL =
                    "UPDATE Accounts "
                    + "SET balance = balance - ? "
                    + "WHERE account_number = ? "
                    + "AND balance >= ?";

            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 balanceSQL)) {

                statement.setBigDecimal(
                        1,
                        amount
                );

                statement.setLong(
                        2,
                        accountNumber
                );

                statement.setBigDecimal(
                        3,
                        amount
                );

                int rows =
                        statement.executeUpdate();

                // Account doesn't exist OR
                // insufficient balance

                if (rows == 0) {

                    connection.rollback();

                    return false;
                }
            }

            // Step 2: Save withdrawal transaction

            String transactionSQL =
                    "INSERT INTO Transactions "
                    + "(account_number, transaction_type, "
                    + "amount, description) "
                    + "VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 transactionSQL)) {

                statement.setLong(
                        1,
                        accountNumber
                );

                statement.setString(
                        2,
                        "WITHDRAW"
                );

                statement.setBigDecimal(
                        3,
                        amount
                );

                statement.setString(
                        4,
                        "Money withdrawn"
                );

                int rows =
                        statement.executeUpdate();

                if (rows == 0) {

                    connection.rollback();

                    return false;
                }
            }

            // Step 3: Commit both operations

            connection.commit();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

            // Undo withdrawal if anything fails

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException rollbackException) {

                    rollbackException.printStackTrace();
                }
            }

            return false;

        } finally {

            if (connection != null) {

                try {

                    connection.setAutoCommit(true);

                    connection.close();

                } catch (SQLException closeException) {

                    closeException.printStackTrace();
                }
            }
        }
    }


    public boolean transferMoney(
            long senderAccountNumber,
            long receiverAccountNumber,
            BigDecimal amount) {

        Connection connection = null;

        try {

            connection =
                    DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            // Step 1: Deduct money from sender

            String withdrawSQL =
                    "UPDATE Accounts "
                    + "SET balance = balance - ? "
                    + "WHERE account_number = ? "
                    + "AND balance >= ?";

            try (PreparedStatement withdrawStatement =
                         connection.prepareStatement(
                                 withdrawSQL)) {

                withdrawStatement.setBigDecimal(
                        1,
                        amount
                );

                withdrawStatement.setLong(
                        2,
                        senderAccountNumber
                );

                withdrawStatement.setBigDecimal(
                        3,
                        amount
                );

                int withdrawRows =
                        withdrawStatement.executeUpdate();

                if (withdrawRows == 0) {

                    connection.rollback();

                    return false;
                }
            }

            // Step 2: Add money to receiver

            String depositSQL =
                    "UPDATE Accounts "
                    + "SET balance = balance + ? "
                    + "WHERE account_number = ?";

            try (PreparedStatement depositStatement =
                         connection.prepareStatement(
                                 depositSQL)) {

                depositStatement.setBigDecimal(
                        1,
                        amount
                );

                depositStatement.setLong(
                        2,
                        receiverAccountNumber
                );

                int depositRows =
                        depositStatement.executeUpdate();

                if (depositRows == 0) {

                    connection.rollback();

                    return false;
                }
            }

            // Step 3: Sender transaction history

            String senderTransactionSQL =
                    "INSERT INTO Transactions "
                    + "(account_number, transaction_type, "
                    + "amount, description) "
                    + "VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 senderTransactionSQL)) {

                statement.setLong(
                        1,
                        senderAccountNumber
                );

                statement.setString(
                        2,
                        "TRANSFER"
                );

                statement.setBigDecimal(
                        3,
                        amount
                );

                statement.setString(
                        4,
                        "Transferred to Account "
                        + receiverAccountNumber
                );

                statement.executeUpdate();
            }

            // Step 4: Receiver transaction history

            String receiverTransactionSQL =
                    "INSERT INTO Transactions "
                    + "(account_number, transaction_type, "
                    + "amount, description) "
                    + "VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 receiverTransactionSQL)) {

                statement.setLong(
                        1,
                        receiverAccountNumber
                );

                statement.setString(
                        2,
                        "TRANSFER"
                );

                statement.setBigDecimal(
                        3,
                        amount
                );

                statement.setString(
                        4,
                        "Received from Account "
                        + senderAccountNumber
                );

                statement.executeUpdate();
            }

            // Step 5: Commit everything

            connection.commit();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException rollbackException) {

                    rollbackException.printStackTrace();
                }
            }

            return false;

        } finally {

            if (connection != null) {

                try {

                    connection.setAutoCommit(true);

                    connection.close();

                } catch (SQLException closeException) {

                    closeException.printStackTrace();
                }
            }
        }
    }

    public boolean accountNumberExists(long accountNumber) {

    	
    	String sql =
    	        "SELECT account_number "
    	        + "FROM Accounts "
    	        + "WHERE account_number = ?";

    	try (Connection connection =
    	             DatabaseConnection.getConnection();
    	     PreparedStatement statement =
    	             connection.prepareStatement(sql)) {

    	    statement.setLong(1, accountNumber);

    	    ResultSet resultSet =
    	            statement.executeQuery();

    	    return resultSet.next();

    	} catch (SQLException e) {

    	    e.printStackTrace();

    	    return false;
    	}
    	

    	}

    public boolean verifySecurityPin(
            long accountNumber,
            String enteredPin) {

        String sql =
                "SELECT security_pin "
                + "FROM Accounts "
                + "WHERE account_number = ?";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setLong(
                    1,
                    accountNumber
            );

            ResultSet resultSet =
                    statement.executeQuery();

            if (resultSet.next()) {

                String storedHash =
                        resultSet.getString(
                                "security_pin"
                        );

                return PasswordUtil.checkPassword(
                        enteredPin,
                        storedHash
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
}
