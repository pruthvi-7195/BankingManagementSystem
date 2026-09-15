
package com.banking.BankingManagementSystem.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.banking.BankingManagementSystem.database.DatabaseConnection;
import com.banking.BankingManagementSystem.model.Transaction;

public class TransactionDAO {

    public boolean addTransaction(
            long accountNumber,
            String transactionType,
            BigDecimal amount,
            String description) {

        String sql =
                "INSERT INTO Transactions "
                + "(account_number, transaction_type, "
                + "amount, description) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection connection =
                     DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setLong(1, accountNumber);

            statement.setString(
                    2,
                    transactionType
            );

            statement.setBigDecimal(
                    3,
                    amount
            );

            statement.setString(
                    4,
                    description
            );

            int rows =
                    statement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    public List<Transaction> getTransactionsByAccount(
            long accountNumber) {

        List<Transaction> transactions =
                new ArrayList<>();

        String sql =
                "SELECT * FROM Transactions "
                + "WHERE account_number = ? "
                + "ORDER BY transaction_date DESC";

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

            while (resultSet.next()) {

                Transaction transaction =
                        new Transaction();

                transaction.setTransactionId(
                        resultSet.getInt(
                                "transaction_id"
                        )
                );

                transaction.setAccountNumber(
                        resultSet.getLong(
                                "account_number"
                        )
                );

                transaction.setTransactionType(
                        resultSet.getString(
                                "transaction_type"
                        )
                );

                transaction.setAmount(
                        resultSet.getBigDecimal(
                                "amount"
                        )
                );

                transaction.setDescription(
                        resultSet.getString(
                                "description"
                        )
                );

                Timestamp transactionDate =
                        resultSet.getTimestamp(
                                "transaction_date"
                        );

                transaction.setTransactionDate(
                        transactionDate
                );

                transactions.add(
                        transaction
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return transactions;
    }
}
