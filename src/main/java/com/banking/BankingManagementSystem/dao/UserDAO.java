
package com.banking.BankingManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.BankingManagementSystem.database.DatabaseConnection;
import com.banking.BankingManagementSystem.model.User;
import com.banking.BankingManagementSystem.security.PasswordUtil;

public class UserDAO {

    public boolean registerUser(User user) {

        String sql =
                "INSERT INTO User "
                + "(full_name, email, password) "
                + "VALUES (?, ?, ?)";

        try (Connection connection =
                     DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    user.getFullName()
            );

            statement.setString(
                    2,
                    user.getEmail()
            );

            // Hash password before storing it
            String hashedPassword =
                    PasswordUtil.hashPassword(
                            user.getPassword()
                    );

            statement.setString(
                    3,
                    hashedPassword
            );

            int rows =
                    statement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    public boolean emailExists(String email) {

        String sql =
                "SELECT user_id "
                + "FROM User "
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

            return resultSet.next();

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    public boolean loginUser(
            String email,
            String password) {

        String sql =
                "SELECT password "
                + "FROM User "
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

                String storedHash =
                        resultSet.getString(
                                "password"
                        );

                // Compare entered password with
                // stored BCrypt hash
                return PasswordUtil.checkPassword(
                        password,
                        storedHash
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
    public String getFullNameByEmail(String email) {

    	String sql =
    	        "SELECT full_name "
    	        + "FROM User "
    	        + "WHERE email = ?";

    	try (Connection connection =
    	             DatabaseConnection.getConnection();
    	     PreparedStatement statement =
    	             connection.prepareStatement(sql)) {

    	    statement.setString(1, email);

    	    ResultSet resultSet =
    	            statement.executeQuery();

    	    if (resultSet.next()) {

    	        return resultSet.getString("full_name");
    	    }

    	} catch (SQLException e) {

    	    e.printStackTrace();
    	}

    	return null;

    	}
}
