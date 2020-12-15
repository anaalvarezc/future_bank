package com.futureBank.timeTracking.service.impl;

import com.futureBank.timeTracking.dtos.TransactionDTO;
import com.futureBank.timeTracking.entities.Transaction;
import com.futureBank.timeTracking.service.OperationsService;
import com.futureBank.timeTracking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OperationsServiceImpl implements OperationsService {

    @Autowired
    private TransactionService transactionService;

    @Override
    public TransactionDTO saveTimeRequest(String operation, String startDate) {

        try {
            Date date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(startDate);
            Transaction tx = createOrUpdateTransaction(operation,date,null,null);
            return createTransactionDTO(tx);
        } catch (ParseException e) {
            e.printStackTrace();
            TransactionDTO transactionDTO=new TransactionDTO();
            transactionDTO.setStatus("Transaction incomplete");
            return  transactionDTO;
        }

    }

    @Override
    public TransactionDTO saveTimeResponse(String idTx, String endDate) {
        try {
            Date date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(endDate);
            Transaction tx = createOrUpdateTransaction(null,null,date,idTx);
            return createTransactionDTO(tx);
        } catch (ParseException e) {
            e.printStackTrace();
            TransactionDTO transactionDTO=new TransactionDTO();
            transactionDTO.setStatus("Transaction incomplete");
            return  transactionDTO;
        }

    }

    private TransactionDTO createTransactionDTO(Transaction tx){
        TransactionDTO transactionDTO=new TransactionDTO();
        transactionDTO.setId(tx.getId());
        transactionDTO.setCreationDate(tx.getCreationDate());
        transactionDTO.setEndDate(tx.getEndDate());
        transactionDTO.setNotified(tx.getNotified());
        transactionDTO.setOperation(tx.getOperation());
        transactionDTO.setTotalTime(tx.getTotalTime());
        transactionDTO.setStatus("ok");
        return transactionDTO;
    }

    private Transaction createOrUpdateTransaction(String operation, Date startDate, Date endDate, String idTx){

        Transaction tx = new Transaction();
        if (startDate != null) {
            tx.setOperation(operation);
            tx.setCreationDate(startDate);
            tx.setNotified(false);
            Transaction transaction = transactionService.saveTime(tx);
            return transaction;

        } else {
            tx.setEndDate(endDate);
            tx.setId(new BigInteger(idTx));
            transactionService.saveCalculateTime(tx);
            Transaction transaction = transactionService.saveTime(tx);
            return transaction;
        }

    }

}
