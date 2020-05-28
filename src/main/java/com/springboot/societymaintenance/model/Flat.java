package com.springboot.societymaintenance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Flat  implements  java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLAT_ID", unique = true, nullable = false)
    private Long flatId;
    private String flatNo;
    private String OwnerName;
    private String MobileNo;
    private String emailId;
    private Integer area;
    private int flatType;
    private String wing;
    private Integer floor;
    private int twoWheelers;
    private int fourWheelers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOCIETY_ID", nullable = false)
    @JsonBackReference
    private Society society;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "flat")
    @JsonManagedReference
    private Set<User> user = new HashSet<User>(0);*/

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flat")
    @JsonManagedReference
    private Set<MaintenanceBill> maintenanceBills = new HashSet<MaintenanceBill>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flat")
    @JsonManagedReference
    private Set<Payment> payment = new HashSet<Payment>(0);

    public Flat() {
    }

    public Long getFlatId() {
        return flatId;
    }

    public void setFlatId(Long flatId) {
        this.flatId = flatId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public int getFlatType() {
        return flatType;
    }

    public void setFlatType(int flatType) {
        this.flatType = flatType;
    }

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /*public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }*/

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<MaintenanceBill> getMaintenanceBillDetails() {
        return maintenanceBills;
    }

    public void setMaintenanceBillDetails(Set<MaintenanceBill> maintenanceBills) {
        this.maintenanceBills = maintenanceBills;
    }

    public Set<Payment> getPayment() {
        return payment;
    }

    public void setPayment(Set<Payment> payment) {
        this.payment = payment;
    }

    public int getTwoWheelers() {
        return twoWheelers;
    }

    public void setTwoWheelers(int twoWheelers) {
        this.twoWheelers = twoWheelers;
    }

    public int getFourWheelers() {
        return fourWheelers;
    }

    public void setFourWheelers(int fourWheelers) {
        this.fourWheelers = fourWheelers;
    }

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public long getSocietyId(){return society.getSocietyId();}
    public String getSocietyName(){return society.getSocietyName();}
    public String getSocietyRegNo(){return society.getSocietyRegistrationNo();}
    public String getSocietyAddress(){
        return
                society.getSocietyAddress1()+" "+
                society.getSocietyAddress2()+" "+
                society.getSocietyAddress3()+" "+
                society.getSocietyAddressCity()+" "+
                society.getSocietyAddressPinCode();
    }
}
