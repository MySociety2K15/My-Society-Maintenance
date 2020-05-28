package com.springboot.societymaintenance.model;

import javax.persistence.*;

@Entity
public class FundMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    private int fltType;
    private double serviceCharge;
    private double sinkingFund;
    private double repairFund;
    private double eduAndTrainingFund;
    private double sublettingFund;
    private double twoWheelerParkingCharge;
    private double fourWheelerParkingCharges;
    private double otherCharges;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFltType() {
        return fltType;
    }

    public void setFltType(int fltType) {
        this.fltType = fltType;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getSinkingFund() {
        return sinkingFund;
    }

    public void setSinkingFund(double sinkingFund) {
        this.sinkingFund = sinkingFund;
    }

    public double getRepairFund() {
        return repairFund;
    }

    public void setRepairFund(double repairFund) {
        this.repairFund = repairFund;
    }

    public double getEduAndTrainingFund() {
        return eduAndTrainingFund;
    }

    public void setEduAndTrainingFund(double eduAndTrainingFund) {
        this.eduAndTrainingFund = eduAndTrainingFund;
    }

    public double getSublettingFund() {
        return sublettingFund;
    }

    public void setSublettingFund(double sublettingFund) {
        this.sublettingFund = sublettingFund;
    }

    public double getTwoWheelerParkingCharge() {
        return twoWheelerParkingCharge;
    }

    public void setTwoWheelerParkingCharge(double twoWheelerParkingCharge) {
        this.twoWheelerParkingCharge = twoWheelerParkingCharge;
    }

    public double getFourWheelerParkingCharges() {
        return fourWheelerParkingCharges;
    }

    public void setFourWheelerParkingCharges(double fourWheelerParkingCharges) {
        this.fourWheelerParkingCharges = fourWheelerParkingCharges;
    }

    public double getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(double otherCharges) {
        this.otherCharges = otherCharges;
    }
}
