package com.futureBank.timeTracking.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "notifications")
@SequenceGenerator(name="nt_seq",sequenceName = "notification_seq", allocationSize = 1)
@Data
public class Notification {

    @Id
    @Column(name = "id_notification")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nt_seq")
    private BigInteger idNotification;

    @Column(name = "id_tx")
    private BigInteger idTx;

    @Column(name = "message")
    private String message;

    @Column(name = "operation")
    private String operation;
}
