package com.springboot.societymaintenance.Data;

import com.springboot.societymaintenance.model.*;
import com.springboot.societymaintenance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SampleData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private FlatRepository flatRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private SocietyRepository sRepo;

    @Autowired
    UpdateFundRepository fundRepo;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        Flat flat = new Flat();
        Society society = new Society();
        society.setSocietyId(1L);
        society.setSocietyName("Palm Island IX Co-Op Housing Society Ltd.");
        society.setSocietyRegistrationNo("MUM/WP/HSG/TC/15649/2016-17/YEAR 2017");
        society.setSocietyAddress1("CTS 1627, Serve No. 169,(Part)");
        society.setSocietyAddress2("Villege Marol Maroshi, Royal Palm Estate,");
        society.setSocietyAddress3("Mayur Nagar, Aarey Colony, Goregaon East");
        society.setSocietyAddressCity("Mumbai");
        society.setSocietyAddressPinCode("400065");
        sRepo.save(society);

        Society s1 = sRepo.getOne(1L);

        //Payment payEntry =new Payment();

        flat.setFlatId(1L);
        flat.setSociety(s1);
        flat.setFlatNo("1002");
        flat.setArea(800);
        flat.setFlatType(2);
        flat.setFloor(5);
        flat.setWing("A");
        flat.setOwnerName("Devendra Patel");
        flat.setMobileNo("1234567890");
        flat.setEmailId("abc@gmail.com");
        flatRepo.save(flat);


        Flat flat2 = new Flat();
        flat2.setSociety(s1);
        flat2.setFlatNo("1001");
        flat2.setArea(600);
        flat2.setFlatType(1);
        flat2.setFloor(5);
        flat2.setWing("A");
        flat2.setOwnerName("Ganesh Gaitonde");
        flat2.setMobileNo("1234567890");
        flat2.setEmailId("efg@gmail.com");
        flatRepo.save(flat2);


        user.setUserId(1L);
        user.setFirstName("Devendra");
        user.setLastName("Patel");
        user.setMobileNumber("9967997944");
        user.setEmail("abc@gmail.com");
        user.setPassword("test");
        user.setStatus(1);
        user.setUserRole(1);
        user.setCreateDate(new Date());
        user.setCreatedBy(1L);
        user.setUpdateDate(new Date());
        user.setUpdatedBy(1L);

        userRepo.save(user);

        FundMaster fundMaster = new FundMaster();
        fundMaster.setId(1L);
        fundMaster.setFltType(1);
        fundMaster.setServiceCharge(1800.00);
        fundMaster.setSinkingFund(150.00);
        fundMaster.setRepairFund(500.00);
        fundMaster.setEduAndTrainingFund(100.00);
        fundMaster.setSublettingFund(0.00);
        fundMaster.setTwoWheelerParkingCharge(300.00);
        fundMaster.setFourWheelerParkingCharges(500.00);
        fundMaster.setOtherCharges(0.00);
        fundRepo.save(fundMaster);

        FundMaster fundMaster1 = new FundMaster();
        fundMaster1.setId(2L);
        fundMaster1.setFltType(2);
        fundMaster1.setServiceCharge(2500.00);
        fundMaster1.setSinkingFund(150.00);
        fundMaster1.setRepairFund(500.00);
        fundMaster1.setEduAndTrainingFund(100.00);
        fundMaster1.setSublettingFund(0.00);
        fundMaster1.setTwoWheelerParkingCharge(300.00);
        fundMaster1.setFourWheelerParkingCharges(500.00);
        fundMaster1.setOtherCharges(0.00);
        fundRepo.save(fundMaster1);


    }
}
