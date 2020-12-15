package com.futureBank.timeTracking.service;

import com.futureBank.timeTracking.dtos.TransactionDTO;
import org.springframework.validation.annotation.Validated;

@Validated
public interface OperationsService {
    TransactionDTO saveTimeRequest(String operation, String Date);
    TransactionDTO saveTimeResponse(String idTransaction, String Date);
}
