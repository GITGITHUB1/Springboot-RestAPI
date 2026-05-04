package com.raghav.transactions.mapper;

import com.raghav.transactions.dto.TransactionDTO;
import com.raghav.transactions.model.Transaction;

public class TransactionMapper {

    public static TransactionDTO toDTO(Transaction t) {
        return new TransactionDTO(
                t.getId(),
                t.getFromAccountId(),
                t.getToAccountId(),
                t.getAmount(),
                t.getTransactionDate()
        );
    }
}