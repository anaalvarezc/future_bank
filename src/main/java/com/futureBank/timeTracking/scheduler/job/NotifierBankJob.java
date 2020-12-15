package com.futureBank.timeTracking.scheduler.job;

import com.futureBank.timeTracking.service.NotifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class NotifierBankJob {

    @Autowired
    private NotifierService notifierService;

    @Scheduled(cron = "0 0/2 * * * ?")
    public void scheduleJobWithCron() {
        notifierService.notifierBank();
    }
}
