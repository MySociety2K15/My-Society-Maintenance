package com.springboot.societymaintenance.custommodal;

import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.MaintenanceBill;

public class BillAndFlatDetails {

    private MaintenanceBill maintenanceBill;
    private double totalCurrentMonthPayment;
    //private Society society;
    private Flat flat;

    public MaintenanceBill getMaintenanceBill() {
        return maintenanceBill;
    }

    public void setMaintenanceBill(MaintenanceBill maintenanceBill) {
        this.maintenanceBill = maintenanceBill;
    }

    public double getTotalCurrentMonthPayment() {
        return totalCurrentMonthPayment;
    }

    public void setTotalCurrentMonthPayment(double totalCurrentMonthPayment) {
        this.totalCurrentMonthPayment = totalCurrentMonthPayment;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
