package com.springboot.societymaintenance.controller;


import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.MaintenanceBill;
import com.springboot.societymaintenance.model.Payment;
import com.springboot.societymaintenance.service.MaintenanceBillService;
import com.springboot.societymaintenance.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @Autowired
    MaintenanceBillService mService;

    @RequestMapping(value = "/savePayment", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Payment> createPaymentEntry(@RequestBody Payment payment)
            throws RecordNotFoundException {

        //MaintenanceBill mBill = mService.getLatestMaintenanceBill(payment.getFlat());
        //mBill.setPreviousBill(mBill.getCurrentBill()-payment.getAmount());

        Payment updatedPayment = service.savePayment(payment);
        return new ResponseEntity<Payment>(updatedPayment, new HttpHeaders(), HttpStatus.OK);
    }
}
