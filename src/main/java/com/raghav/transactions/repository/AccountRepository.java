package com.raghav.transactions.repository;

import com.raghav.transactions.model.Account;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AccountRepository {

    private Map<Long, Account> map = new HashMap<>();
    private Long id = 1L;

    public Account create(String name, Double balance) {
        Account acc = new Account(id, name, balance);
        map.put(id, acc);
        id++;
        return acc;
    }

    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public void save(Account acc) {
        map.put(acc.getId(), acc);
    }
}
