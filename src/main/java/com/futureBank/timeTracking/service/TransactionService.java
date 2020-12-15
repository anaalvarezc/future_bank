package com.futureBank.timeTracking.service;

import com.futureBank.timeTracking.entities.Transaction;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TransactionService {
    Transaction saveTime(Transaction transaction);
    void saveCalculateTime(Transaction transaction);
}
