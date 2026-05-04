# Springboot-RestAPI
# Banking Transactions API

## Project Overview

This project is a RESTful Banking Transactions API developed using Spring Boot.  
It allows users to create accounts, transfer funds between accounts, and retrieve transaction history.

The application follows a layered architecture and uses in-memory data storage instead of a database.

---

## Technologies Used

- Java 17  
- Spring Boot  
- Spring Web  
- Maven  
- In-memory storage (HashMap, ArrayList)  

---

## Architecture

The project follows a three-layer architecture:

1. Controller Layer  
   Handles incoming HTTP requests and returns responses.

2. Service Layer  
   Contains business logic such as account creation, validation, and fund transfer.

3. Repository Layer  
   Stores and retrieves data using in-memory collections.

---

## Features

- Create account with an initial balance  
- Transfer funds between accounts  
- Retrieve transaction history  
- Global exception handling  
- Auto-generated IDs for accounts and transactions  
- Timestamp generation for each transaction  

---

## Data Storage

No database is used in this application.

- Accounts are stored using a HashMap  
- Transactions are stored using an ArrayList  

Note: All data is lost when the application restarts.

---

## API Endpoints

### 1. Create Account

Method: POST  
Endpoint: /api/accounts  

Request Body:

json id="1a2b3c" {   "accountHolderName": "Raghav",   "balance": 1000 } 

Response:

json id="4d5e6f" {   "accountId": 1,   "accountHolderName": "Raghav",   "balance": 1000.0 } 

---

### 2. Transfer Funds

Method: POST  
Endpoint: /api/transactions/transfer  

Request Body:

json id="7g8h9i" {   "fromAccountId": 1,   "toAccountId": 2,   "amount": 200 } 

Response:

json id="0j1k2l" {   "transactionId": 1,   "fromAccountId": 1,   "toAccountId": 2,   "amount": 200.0,   "transactionDate": "2026-05-04T10:30:00" } 

---

### 3. Get Transaction History

Method: GET  
Endpoint: /api/transactions/account/{accountId}  

Example:

GET /api/transactions/account/1

Response:

json id="3m4n5o" [   {     "transactionId": 1,     "fromAccountId": 1,     "toAccountId": 2,     "amount": 200.0,     "transactionDate": "2026-05-04T10:30:00"   } ] 

---

## Error Handling

### Account Not Found

json id="6p7q8r" {   "error": "Account not found: 99" } 

### Insufficient Funds

json id="9s0t1u" {   "error": "Insufficient funds" } 

### Same Account Transfer

json id="2v3w4x" {   "error": "Cannot transfer to the same account" } 

---

## How to Run the Application

### Prerequisites

- Java 17 installed  
- Maven installed  

---

### Steps

1. Clone the repository:

git clone <your-repository-link>

2. Navigate to the project directory:

cd productlists

3. Run the application:

mvn spring-boot:run

4. The application will start on:

http://localhost:8080

---

## How to Test the APIs

You can test the APIs using Postman or any REST client.

Recommended testing sequence:

1. Create the first account  
2. Create the second account  
3. Perform a fund transfer  
4. Retrieve transaction history  
5. Test error scenarios such as invalid account ID and insufficient funds  

---

## Assumptions

- No database is used; all data is stored in memory  
- Account IDs and transaction IDs are auto-generated  
- Balance cannot be negative  
- Transfer amount must be greater than zero  
- Same account transfer is not allowed  
- Transactions are immutable and cannot be updated or deleted  
- Transaction history returns transactions where the account is the sender  

---

## Author

Raghav
