package com.futureBank.timeTracking.service.impl;

import com.futureBank.timeTracking.dtos.TransactionDTO;
import com.futureBank.timeTracking.entities.Transaction;
import com.futureBank.timeTracking.service.OperationsService;
import com.futureBank.timeTracking.service.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.text.SimpleDateFormat;


@ContextConfiguration(classes = OperationServiceImplTest.Config.class)
@RunWith(SpringRunner.class)
public class OperationServiceImplTest {

    @Autowired
    private OperationsService operationsService;

    @MockBean
    private TransactionService transactionService;

    @Configuration
    public static class Config {

        @Bean
        public OperationsService operationsService() {
            return new OperationsServiceImpl();
        }
    }

    @Test
    public void saveTimeRequestTest() throws Exception {
        Transaction tx= new Transaction();
        tx.setId(BigInteger.valueOf(1));
        tx.setCreationDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-14 23:18:39"));
        tx.setNotified(false);
        tx.setOperation("consultarCliente");
        Mockito.when(transactionService.saveTime(Mockito.any(Transaction.class))).thenReturn(tx);
        TransactionDTO idTx = operationsService.saveTimeRequest("consultarCliente","2020-12-14 23:07:40");
        Mockito.verify(transactionService, Mockito.times(1)).saveTime(Mockito.any(Transaction.class));
        Assert.assertNotNull(idTx.getCreationDate());
        Assert.assertNotNull(idTx.getOperation());

    }

    @Test
    public void saveTimeResponse() throws Exception {
        Transaction tx= new Transaction();
        tx.setId(BigInteger.valueOf(1));
        tx.setCreationDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-14 23:18:39"));
        tx.setEndDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-14 23:18:59"));
        tx.setNotified(false);
        tx.setOperation("consultarCliente");
        Mockito.when(transactionService.saveTime(Mockito.any(Transaction.class))).thenReturn(tx);
        TransactionDTO idTx =  operationsService.saveTimeResponse("1","2020-12-14 23:18:59");
        Mockito.verify(transactionService, Mockito.times(1)).saveCalculateTime(Mockito.any(Transaction.class));
        Assert.assertNotNull(idTx.getEndDate());
        Assert.assertNull(idTx.getTotalTime());
    }

}
