
package com.banking.BankingManagementSystem.service;

import com.banking.BankingManagementSystem.dao.UserDAO;
import com.banking.BankingManagementSystem.model.User;

public class UserService {

    private UserDAO userDAO;

    public UserService() {

        userDAO =
                new UserDAO();
    }

    public boolean registerUser(User user) {

        return userDAO.registerUser(user);
    }

    public boolean emailExists(String email) {

        return userDAO.emailExists(email);
    }

    public boolean loginUser(
            String email,
            String password) {

        return userDAO.loginUser(
                email,
                password
        );
    }
    public String getFullNameByEmail(String email) {

    	return userDAO.getFullNameByEmail(email);

    	}
}
