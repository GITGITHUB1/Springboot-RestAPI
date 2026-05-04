package com.raghav.transactions.mapper;

import com.raghav.transactions.dto.AccountDTO;
import com.raghav.transactions.model.Account;

public class AccountMapper {

    public static AccountDTO toDTO(Account acc) {
        return new AccountDTO(
                acc.getId(),
                acc.getAccountHolderName(),
                acc.getBalance()
        );
    }
}