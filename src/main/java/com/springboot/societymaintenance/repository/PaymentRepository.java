package com.springboot.societymaintenance.repository;

import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT e from Payment e where month(e.paymentDate)= month(CURRENT_DATE) and year(e.paymentDate) = year(CURRENT_DATE) AND flat=?1")
    Optional<List<Payment>> findCurrentMonthPayments(Flat flat);

    @Query("SELECT e from Payment e where month(e.paymentDate)= ?1 and year(e.paymentDate) = ?2 AND flat=?3")
    Optional<List<Payment>> findPreviousMonthPayments(int month,int year, Flat flat);
}
