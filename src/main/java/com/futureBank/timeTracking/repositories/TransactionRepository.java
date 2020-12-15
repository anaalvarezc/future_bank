package com.futureBank.timeTracking.repositories;

import com.futureBank.timeTracking.entities.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, BigInteger> {

    @Modifying
    @Query(value="update tx_times set total_time = (SELECT EXTRACT(EPOCH FROM (x.end_date - x.start_date)) FROM tx_times x  where x.id_transaction=:id) where id_transaction=:id",nativeQuery = true)
    int updateTxDate (@Param("id") long idTx);

    @Modifying
    @Query(value="update Transaction t set t.endDate = :endDateTx where t.id=:idTx")
    int updateTx (@Param("endDateTx") Date endDate, @Param("idTx") BigInteger idTx);

    @Modifying
    @Query(value="select * from tx_times where (total_time >= 10 and notified <> true) or (start_date+interval'15 seconds') <= current_timestamp and notified <> true",nativeQuery = true)
    List<Transaction> findTx();

    @Modifying
    @Query("update Transaction t set t.notified = true where t.id in :listTx")
    void changeStatus(@Param("listTx") List<BigInteger> transactions);
}
