package com.futureBank.timeTracking.service.impl;

import com.futureBank.timeTracking.entities.Notification;
import com.futureBank.timeTracking.entities.Transaction;
import com.futureBank.timeTracking.repositories.NotificationRepository;
import com.futureBank.timeTracking.repositories.TransactionRepository;
import com.futureBank.timeTracking.service.NotifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotifierServiceImpl  implements NotifierService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Transactional
    @Override
    public void notifierBank() {
        List<Transaction> transactions = transactionRepository.findTx();
        List<BigInteger> txs = new ArrayList<>();
        List<Notification> notifications = new ArrayList<>();
        for(Transaction transaction:transactions){
            txs.add(transaction.getId());
            Notification notification = new Notification();

            if (transaction.getTotalTime()==null) {
                notification.setMessage("Problems with comunication");
            } else {
                notification.setMessage("The notification exceeded normal time of execution");
            }

            notification.setIdTx(transaction.getId());
            notification.setOperation(transaction.getOperation());
            notifications.add(notification);
        }
        transactionRepository.changeStatus(txs);
        notificationRepository.saveAll(notifications);

    }
}
