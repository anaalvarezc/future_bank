package com.futureBank.timeTracking.service.impl;

import com.futureBank.timeTracking.entities.Transaction;
import com.futureBank.timeTracking.repositories.TransactionRepository;
import com.futureBank.timeTracking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTime(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    @Transactional
    public void saveCalculateTime(Transaction transaction) {
        transactionRepository.updateTx(transaction.getEndDate(),transaction.getId());
        transactionRepository.updateTxDate(transaction.getId().longValue());
    }

}
