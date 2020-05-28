package com.springboot.societymaintenance.service;

import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.FundMaster;
import com.springboot.societymaintenance.model.MaintenanceBill;
import com.springboot.societymaintenance.model.User;
import com.springboot.societymaintenance.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MaintenanceBillService {

    @Autowired
    MaintenanceRepository maintenanceRepo;

    @Autowired
    FlatService flatService;

    @Autowired
    PaymentService paymentService;

    public List<MaintenanceBill> getAllMaintenanceBill ()
    {
        List<MaintenanceBill> maintenanceBillList = maintenanceRepo.findAll();

        if(maintenanceBillList.size() > 0) {
            return maintenanceBillList;
        } else {
            return new ArrayList<MaintenanceBill>();
        }
    }

    public List<MaintenanceBill> findAllBillsForCurrentMonth() throws RecordNotFoundException{
         Optional<List<MaintenanceBill>> mBills = maintenanceRepo.findAllBillsforCurrentMonth();

         if(mBills.isPresent()){
             return mBills.get();
         }else
             throw new RecordNotFoundException("No employee record exist for given id");

    }

    public MaintenanceBill getMaintenanceBillByID(long billId) throws RecordNotFoundException
    {
        Optional<MaintenanceBill> maintenanceBill = maintenanceRepo.findMaintenanceBillByBillId(billId);

        if(maintenanceBill.isPresent()) {
            return maintenanceBill.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public MaintenanceBill getLatestMaintenanceBill(Flat flat) throws RecordNotFoundException{
        Optional<List<MaintenanceBill>> mBillList = maintenanceRepo.findLatestByFlatId(flat);

        if(mBillList.isPresent()) {
            return mBillList.get().get(0);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public double getTotalBillForPreviousMonth(int month,int year, Flat flat) {

        if(month == 1) {
            month = 12;
            year = year - 1;
        }else{
            month = month-1;
        }

        double totalBill = 0.0;
        Optional<MaintenanceBill> mBill = maintenanceRepo.getMaintenanceByMonth(month,year,flat);
        MaintenanceBill bill;
        if(mBill.isPresent()){
            bill = mBill.get();
            totalBill = bill.getServiceCharge() +
                    bill.getSinkingFund() +
                    bill.getSublettingCharge() +
                    bill.getEduAndTrainingFund() +
                    bill.getParkingCharges() +
                    bill.getCheckReturnCharges() +
                    bill.getOtherCharges();
        }
        return totalBill;
    }

    public double totalPaymentForPreviousMonth(int month,int year, Flat flat){

        if(month == 1) {
            month = 12;
            year = year - 1;
        }else{
            month = month-1;
        }
        return paymentService.getTotalPreviousMonthPayment(month,year,flat);
    }

    public void updateChargesForCurrentMonth(FundMaster fundMaster){
        try {
            List<Flat> flats = flatService.getAllFlatsByFlatType(fundMaster.getFltType());
            MaintenanceBill mBill;
            Calendar cal = Calendar.getInstance();
            int currentMonth = Integer.parseInt(new SimpleDateFormat("MM").format(cal.getTime()));
            int currentYear = Integer.parseInt(new SimpleDateFormat("YYYY").format(cal.getTime()));
            Optional<MaintenanceBill> mBillFound;
            for(Flat flat : flats){
                //Check if bill already generated of selected month
                mBillFound = maintenanceRepo.getMaintenanceByMonth(currentMonth,currentYear,flat);
                if(mBillFound.isPresent()){
                    mBill = mBillFound.get();
                }else {
                    mBill = new MaintenanceBill();
                    mBill.setFlat(flat);
                    mBill.setCheckReturnCharges(0.0);
                }

                mBill.setMaintenanceMonth(currentMonth);
                mBill.setMaintenanceYear(currentYear);
                mBill.setServiceCharge(fundMaster.getServiceCharge());
                mBill.setEduAndTrainingFund(fundMaster.getEduAndTrainingFund());
                mBill.setRepairFund(fundMaster.getRepairFund());
                mBill.setSinkingFund(fundMaster.getSinkingFund());
                mBill.setSublettingCharge(fundMaster.getSublettingFund());
                mBill.setOtherCharges(fundMaster.getOtherCharges());
                mBill.setParkingCharges(
                        flat.getTwoWheelers()*fundMaster.getTwoWheelerParkingCharge()
                        +flat.getFourWheelers()*fundMaster.getFourWheelerParkingCharges()
                );
                mBill.setPreviousBill(
                        getTotalBillForPreviousMonth(currentMonth,currentYear,flat) -
                        totalPaymentForPreviousMonth(currentMonth,currentYear,flat));
                mBill.setGenerationDate(new Date());
                maintenanceRepo.save(mBill);
            }
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MaintenanceBill updateBill(MaintenanceBill bill){

        MaintenanceBill mBill = maintenanceRepo.getOne(bill.getBillId());
        mBill.setCheckReturnCharges(bill.getCheckReturnCharges());
        mBill.setServiceCharge(bill.getServiceCharge());
        mBill.setSinkingFund(bill.getSinkingFund());
        mBill.setRepairFund(bill.getRepairFund());
        mBill.setSublettingCharge(bill.getSublettingCharge());
        mBill.setEduAndTrainingFund(bill.getEduAndTrainingFund());
        mBill.setOtherCharges(bill.getOtherCharges());
        mBill.setPreviousBill(bill.getPreviousBill());
        mBill.setParkingCharges(bill.getParkingCharges());
        MaintenanceBill updatedBill = maintenanceRepo.save(mBill);

        return updatedBill;
    }

}
