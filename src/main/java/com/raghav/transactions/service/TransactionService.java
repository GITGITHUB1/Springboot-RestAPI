package com.raghav.transactions.service;

import com.raghav.transactions.dto.TransactionDTO;
import com.raghav.transactions.exception.AccountNotFoundException;
import com.raghav.transactions.exception.InsufficientFundsException;
import com.raghav.transactions.exception.SameAccountTransferException;
import com.raghav.transactions.mapper.TransactionMapper;
import com.raghav.transactions.model.Account;
import com.raghav.transactions.model.Transaction;
import com.raghav.transactions.repository.AccountRepository;
import com.raghav.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final AccountRepository accRepo;
    private final TransactionRepository txnRepo;

    @Autowired
    public TransactionService(AccountRepository accRepo, TransactionRepository txnRepo) {
        this.accRepo = accRepo;
        this.txnRepo = txnRepo;
    }

    public TransactionDTO transferFunds(TransactionDTO dto) {

        Account from = accRepo.findById(dto.getFromAccountId())
                .orElseThrow(() -> new AccountNotFoundException(dto.getFromAccountId()));

        Account to = accRepo.findById(dto.getToAccountId())
                .orElseThrow(() -> new AccountNotFoundException(dto.getToAccountId()));

        if (from.getId().equals(to.getId())) {
            throw new SameAccountTransferException();
        }

        if (from.getBalance() < dto.getAmount()) {
            throw new InsufficientFundsException();
        }

        from.setBalance(from.getBalance() - dto.getAmount());
        to.setBalance(to.getBalance() + dto.getAmount());

        accRepo.save(from);
        accRepo.save(to);

        Transaction transaction = txnRepo.save(
                from.getId(),
                to.getId(),
                dto.getAmount()
        );

        return TransactionMapper.toDTO(transaction);
    }

    public List<TransactionDTO> getTransactionHistory(Long accountId) {

        List<Transaction> transactions = txnRepo.findByAccount(accountId);
        List<TransactionDTO> result = new ArrayList<>();

        for (Transaction transaction : transactions) {
            result.add(TransactionMapper.toDTO(transaction));
        }

        return result;
    }
}