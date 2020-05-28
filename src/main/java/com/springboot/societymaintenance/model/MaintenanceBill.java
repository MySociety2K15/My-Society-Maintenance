package com.springboot.societymaintenance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAINTENANCE_BILLS")
public class MaintenanceBill  implements  java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_ID", unique = true, nullable = false)
    private Long billId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLAT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Flat flat;

    private int maintenanceMonth;
    private int maintenanceYear;
    private Double serviceCharge;
    private Double previousBill;
    private Double sinkingFund;
    private Double repairFund;
    private Double eduAndTrainingFund;
    private Double sublettingCharge;
    private Double checkReturnCharges;
    private Double parkingCharges;
    private Double otherCharges;
            
    
    
    private Date generationDate;

    public MaintenanceBill(){

    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public int getMaintenanceMonth() {
        return maintenanceMonth;
    }

    public void setMaintenanceMonth(int maintenanceMonth) {
        this.maintenanceMonth = maintenanceMonth;
    }


    public Double getPreviousBill() {
        return previousBill;
    }

    public void setPreviousBill(Double previousBill) {
        this.previousBill = previousBill;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getSinkingFund() {
        return sinkingFund;
    }

    public void setSinkingFund(Double sinkingFund) {
        this.sinkingFund = sinkingFund;
    }

    public Double getRepairFund() {
        return repairFund;
    }

    public void setRepairFund(Double repairFund) {
        this.repairFund = repairFund;
    }

    public Double getEduAndTrainingFund() {
        return eduAndTrainingFund;
    }

    public void setEduAndTrainingFund(Double eduAndTrainingFund) {
        this.eduAndTrainingFund = eduAndTrainingFund;
    }

    public Double getSublettingCharge() {
        return sublettingCharge;
    }

    public void setSublettingCharge(Double sublettingCharge) {
        this.sublettingCharge = sublettingCharge;
    }

    public Double getCheckReturnCharges() {
        return checkReturnCharges;
    }

    public void setCheckReturnCharges(Double checkReturnCharges) {
        this.checkReturnCharges = checkReturnCharges;
    }

    public Double getParkingCharges() {
        return parkingCharges;
    }

    public void setParkingCharges(Double parkingCharges) {
        this.parkingCharges = parkingCharges;
    }

    public Double getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(Double otherCharges) {
        this.otherCharges = otherCharges;
    }

    public int getMaintenanceYear() {
        return maintenanceYear;
    }

    public void setMaintenanceYear(int maintenanceYear) {
        this.maintenanceYear = maintenanceYear;
    }

    public String getFlatNumber(){
        return flat.getFlatNo();
    }

    public String getWing() {
        return flat.getWing();
    }

    public int getFlatType(){return flat.getFlatType();}

    public long getFlatId(){return flat.getFlatId();}

    public String getOwnerName() {return flat.getOwnerName();}

    public String getOwnerMobNo() {return flat.getMobileNo();}

    public String getOwnerEmail() {return flat.getEmailId();}
}
