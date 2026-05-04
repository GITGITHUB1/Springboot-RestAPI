package com.raghav.transactions.controller;

import com.raghav.transactions.dto.TransactionDTO;
import com.raghav.transactions.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public TransactionDTO transferFunds(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.transferFunds(transactionDTO);
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionDTO> getTransactionHistory(@PathVariable Long accountId) {
        return transactionService.getTransactionHistory(accountId);
    }
}