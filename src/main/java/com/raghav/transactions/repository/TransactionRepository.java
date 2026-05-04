package com.raghav.transactions.repository;

import com.raghav.transactions.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TransactionRepository {

    private List<Transaction> list = new ArrayList<>();
    private Long id = 1L;

    public Transaction save(Long from, Long to, Double amount) {
        Transaction t = new Transaction(id, from, to, amount);
        list.add(t);
        id++;
        return t;
    }

    public List<Transaction> findByAccount(Long accountId) {
        List<Transaction> res = new ArrayList<>();

        for (Transaction t : list) {
            if (t.getFromAccountId().equals(accountId)) {
                res.add(t);
            }
        }
        return res;
    }
}