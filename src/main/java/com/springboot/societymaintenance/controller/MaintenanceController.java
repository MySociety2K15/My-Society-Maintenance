package com.springboot.societymaintenance.controller;

import com.springboot.societymaintenance.custommodal.BillAndFlatDetails;
import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.MaintenanceBill;
import com.springboot.societymaintenance.model.Society;
import com.springboot.societymaintenance.service.MaintenanceBillService;
import com.springboot.societymaintenance.service.PaymentService;
import com.springboot.societymaintenance.service.SocietyService;
import com.springboot.societymaintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/bill")
public class MaintenanceController {

    @Autowired
    MaintenanceBillService service;

    @Autowired
    UserService userService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    SocietyService societyService;


    @RequestMapping(value = "/allBills", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<MaintenanceBill>> findAllBillsForCurrentMonth() throws RecordNotFoundException {
        List<MaintenanceBill> list = service.findAllBillsForCurrentMonth();
        return new ResponseEntity<List<MaintenanceBill>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping  (value ="/{billId}",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<BillAndFlatDetails> getMaintenanceBillByID(@PathVariable(value = "billId") long billId) throws RecordNotFoundException {
        MaintenanceBill bill= service.getMaintenanceBillByID(billId);

        double totalPayment = paymentService.getTotalMonthPayment(bill.getFlat());

        BillAndFlatDetails billAndFlatDetails = new BillAndFlatDetails();
        billAndFlatDetails.setMaintenanceBill(bill);

        billAndFlatDetails.setTotalCurrentMonthPayment(totalPayment);
        billAndFlatDetails.setFlat(bill.getFlat());

        return new ResponseEntity<BillAndFlatDetails>(billAndFlatDetails, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateBill", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<MaintenanceBill> updateBill(@RequestBody MaintenanceBill bill) throws RecordNotFoundException {
        MaintenanceBill mBill = service.updateBill(bill);
        return new ResponseEntity<MaintenanceBill>(mBill, new HttpHeaders(), HttpStatus.OK);
    }
}