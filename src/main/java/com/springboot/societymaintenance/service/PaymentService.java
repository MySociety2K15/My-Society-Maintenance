package com.springboot.societymaintenance.service;

import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.Payment;
import com.springboot.societymaintenance.model.User;
import com.springboot.societymaintenance.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository payRepo;

    public Payment savePayment(Payment payment) throws RecordNotFoundException
    {
        payment = payRepo.save(payment);
        return payment;
    }

    public double getTotalMonthPayment(Flat flat) throws RecordNotFoundException
    {
        double totalMonthPayment = 0.0;
        Optional<List<Payment>> records =  payRepo.findCurrentMonthPayments(flat);

        if(records.isPresent()){
            List<Payment> payments= records.get();
            for(Payment payment:payments){
                totalMonthPayment = totalMonthPayment + payment.getAmount();
            }
            return totalMonthPayment;
        }else{
            return 0.0;
        }
    }

    public double getTotalPreviousMonthPayment(int month, int year, Flat flat) {
        double totalMonthPayment = 0.0;
        Optional<List<Payment>> records =  payRepo.findPreviousMonthPayments(month,year,flat);

        if(records.isPresent()){
            List<Payment> payments= records.get();
            for(Payment payment:payments){
                totalMonthPayment = totalMonthPayment + payment.getAmount();
            }
            return totalMonthPayment;
        }else{
            return 0.0;
        }
    }

}



