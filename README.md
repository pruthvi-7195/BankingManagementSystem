# Banking Management System

A desktop-based Banking Management System developed using **Java, Swing, JDBC, and MySQL**. The application provides a secure and user-friendly interface for managing bank accounts and performing common banking operations.

## Features

* User registration and secure login
* BCrypt password and security PIN encryption
* Bank account creation
* Account details viewing
* Balance checking
* Money deposit
* Money withdrawal
* Money transfer between accounts
* Transaction history
* Input validation and error handling
* Secure database operations using JDBC

## Technologies Used

* **Java**
* **Swing**
* **JDBC**
* **MySQL**
* **Maven**
* **BCrypt**
* **Eclipse IDE**
* **Git & GitHub**

## Project Architecture

The application follows a layered architecture:

**GUI → Controller → Service → DAO → Database Connection → MySQL**

### Main Layers

* **GUI** – Provides the user interface using Java Swing.
* **Controller** – Handles communication between the GUI and business logic.
* **Service** – Contains application/business logic.
* **DAO** – Handles database operations using JDBC.
* **Model** – Represents entities such as User, Account, and Transaction.
* **Security** – Handles password and security PIN hashing using BCrypt.
* **Database** – Stores users, accounts, and transaction records in MySQL.

## Banking Operations

The system supports:

1. Register / Login
2. Open Bank Account
3. View Account Details
4. Check Balance
5. Deposit Money
6. Withdraw Money
7. Transfer Money
8. View Transaction History
9. Logout

## Database

The application uses **MySQL** with the following main tables:

* `User`
* `Accounts`
* `Transactions`

Financial amounts are handled using Java's **BigDecimal** to avoid floating-point precision issues.

## Security

* Passwords are stored using **BCrypt hashing**.
* Account security PINs are also stored securely using BCrypt.
* Prepared Statements are used for database operations to help prevent SQL injection.
* Transaction-based operations are used for important money transfers.

## Project Structure

```text
BankingManagementSystem
│
├── src/main/java
│   └── com/banking/BankingManagementSystem
│       ├── controller
│       ├── dao
│       ├── database
│       ├── gui
│       ├── model
│       ├── security
│       └── service
│
├── pom.xml
├── .gitignore
└── README.md
```

## Future Enhancements

* Admin dashboard
* Improved transaction filtering
* Account statement generation
* Profile management
* Enhanced UI themes
* Deployment as a standalone banking application

## Author

**D. Pruthvi**

GitHub: `https://github.com/pruthvi-7195`
