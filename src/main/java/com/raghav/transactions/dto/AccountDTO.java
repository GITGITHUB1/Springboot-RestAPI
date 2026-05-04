package com.raghav.transactions.dto;

public class AccountDTO {

    private Long accountId;
    private String accountHolderName;
    private Double balance;

    public AccountDTO() {}

    public AccountDTO(Long accountId, String accountHolderName, Double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}