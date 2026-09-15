package com.banking.BankingManagementSystem.controller;

import com.banking.BankingManagementSystem.model.User;
import com.banking.BankingManagementSystem.service.UserService;

public class LoginController {


private UserService userService;

public LoginController() {

    userService =
            new UserService();
}

// Check login credentials

public boolean login(
        String email,
        String password) {

    return userService.loginUser(
            email,
            password
    );
}

// Register new user

public boolean register(
        String fullName,
        String email,
        String password) {

    User user =
            new User(
                    fullName,
                    email,
                    password
            );

    return userService.registerUser(
            user
    );
}


}
