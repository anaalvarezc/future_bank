package com.futureBank.timeTracking.entities;


import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "tx_times")
@SequenceGenerator(name="tx_seq",sequenceName = "transaction_seq", allocationSize = 1)
@Data
public class Transaction {

    @Id
    @Column(name = "id_transaction")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tx_seq")
    private BigInteger id;

    @Column(name = "start_date")
    private Date creationDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "operation")
    private String operation;

    @Column(name = "total_time")
    private BigInteger totalTime;

    @Column(name = "notified")
    private Boolean notified;

}
