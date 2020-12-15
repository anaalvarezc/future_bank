package com.futureBank.timeTracking.controller;


import com.futureBank.timeTracking.dtos.TransactionDTO;
import com.futureBank.timeTracking.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/timeTracker")
public class TimeTrackingController {

    @Autowired
    private OperationsService operationsService;

    @RequestMapping(value = "/save/{operation}/{startDate}",method = RequestMethod.POST)
    @ResponseBody
    public TransactionDTO saveTimeRequest(@PathVariable String operation,
                                          @PathVariable String startDate){

            return operationsService.saveTimeRequest(operation,startDate);

    }

    @RequestMapping(value = "/updateTransaction/{idTx}/{endDate}",method = RequestMethod.POST)
    @ResponseBody
    public TransactionDTO saveTimeResponse(@PathVariable String idTx,
                                           @PathVariable String endDate){


        return operationsService.saveTimeResponse(idTx,endDate);
    }

}
