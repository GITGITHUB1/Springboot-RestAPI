package com.raghav.transactions.dto;

import java.time.LocalDateTime;

public class TransactionDTO {

    private Long transactionId;
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
    private LocalDateTime transactionDate;

    public TransactionDTO() {}

    public TransactionDTO(Long transactionId, Long fromAccountId, Long toAccountId,
                          Double amount, LocalDateTime transactionDate) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }

    public Long getFromAccountId() { return fromAccountId; }
    public void setFromAccountId(Long fromAccountId) { this.fromAccountId = fromAccountId; }

    public Long getToAccountId() { return toAccountId; }
    public void setToAccountId(Long toAccountId) { this.toAccountId = toAccountId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
}
