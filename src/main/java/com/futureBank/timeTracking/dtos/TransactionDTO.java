package com.futureBank.timeTracking.dtos;

import java.math.BigInteger;
import java.util.Date;

public class TransactionDTO {
    private BigInteger id;

    private Date creationDate;

    private Date endDate;

    private String operation;

    private BigInteger totalTime;

    private Boolean notified;

    private String status;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigInteger getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(BigInteger totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getNotified() {
        return notified;
    }

    public void setNotified(Boolean notified) {
        this.notified = notified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
