package com.raghav.transactions.service;

import com.raghav.transactions.dto.*;
import com.raghav.transactions.mapper.AccountMapper;
import com.raghav.transactions.model.Account;
import com.raghav.transactions.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository repo;

    @Autowired
    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public AccountDTO createAccount(AccountDTO dto) {

        if (dto.getBalance() == null || dto.getBalance() < 0) {
            throw new RuntimeException("Invalid balance");
        }

        Account acc = repo.create(dto.getAccountHolderName(), dto.getBalance());

        return AccountMapper.toDTO(acc);
    }
}