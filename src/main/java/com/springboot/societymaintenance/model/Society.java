package com.springboot.societymaintenance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Society implements  java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SOCIETY_ID", unique = true, nullable = false)
    private long societyId;
    private String societyName;
    private String societyRegistrationNo;
    private String societyAddress1;
    private String societyAddress2;
    private String societyAddress3;
    private String societyAddressCity;
    private String societyAddressState;
    private String societyAddressPinCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "society")
    @JsonManagedReference
    private Set<Flat> flatList = new HashSet<Flat>(0);

    public long getSocietyId() {
        return societyId;
    }

    public void setSocietyId(long societyId) {
        this.societyId = societyId;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getSocietyRegistrationNo() {
        return societyRegistrationNo;
    }

    public void setSocietyRegistrationNo(String societyRegistrationNo) {
        this.societyRegistrationNo = societyRegistrationNo;
    }

    public String getSocietyAddress1() {
        return societyAddress1;
    }

    public void setSocietyAddress1(String societyAddress1) {
        this.societyAddress1 = societyAddress1;
    }

    public String getSocietyAddress2() {
        return societyAddress2;
    }

    public void setSocietyAddress2(String societyAddress2) {
        this.societyAddress2 = societyAddress2;
    }

    public String getSocietyAddress3() {
        return societyAddress3;
    }

    public void setSocietyAddress3(String societyAddress3) {
        this.societyAddress3 = societyAddress3;
    }

    public String getSocietyAddressCity() {
        return societyAddressCity;
    }

    public void setSocietyAddressCity(String societyAddressCity) {
        this.societyAddressCity = societyAddressCity;
    }

    public String getSocietyAddressState() {
        return societyAddressState;
    }

    public void setSocietyAddressState(String societyAddressState) {
        this.societyAddressState = societyAddressState;
    }

    public String getSocietyAddressPinCode() {
        return societyAddressPinCode;
    }

    public void setSocietyAddressPinCode(String societyAddressPinCode) {
        this.societyAddressPinCode = societyAddressPinCode;
    }

    public Set<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(Set<Flat> flatList) {
        this.flatList = flatList;
    }
}
