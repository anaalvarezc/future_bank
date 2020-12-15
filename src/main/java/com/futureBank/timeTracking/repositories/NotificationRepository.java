package com.futureBank.timeTracking.repositories;

import com.futureBank.timeTracking.entities.Notification;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface NotificationRepository extends CrudRepository<Notification, BigInteger> {
}
