package com.springboot.societymaintenance.service;

import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.FundMaster;
import com.springboot.societymaintenance.model.MaintenanceBill;
import com.springboot.societymaintenance.repository.MaintenanceRepository;
import com.springboot.societymaintenance.repository.UpdateFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFundService {

    @Autowired
    UpdateFundRepository updateFundRepository;

    @Autowired
    MaintenanceBillService maintenanceBillService ;

    public FundMaster updateFunds(FundMaster fundMaster) throws RecordNotFoundException
    {
        Optional<FundMaster> fundMasterFound = updateFundRepository.findFundMasterByFltType(fundMaster.getFltType());

        FundMaster UpdateEntity = new FundMaster();

        if(fundMasterFound.isPresent())
        {
            UpdateEntity = fundMasterFound.get();
            UpdateEntity.setServiceCharge(fundMaster.getServiceCharge());
            UpdateEntity.setOtherCharges(fundMaster.getOtherCharges());
            UpdateEntity.setTwoWheelerParkingCharge(fundMaster.getTwoWheelerParkingCharge());
            UpdateEntity.setFourWheelerParkingCharges(fundMaster.getFourWheelerParkingCharges());
            UpdateEntity.setSublettingFund(fundMaster.getSublettingFund());
            UpdateEntity.setRepairFund(fundMaster.getRepairFund());
            UpdateEntity.setEduAndTrainingFund(fundMaster.getEduAndTrainingFund());
            UpdateEntity.setFltType(fundMaster.getFltType());

            UpdateEntity = updateFundRepository.save(UpdateEntity);
        } else {
            UpdateEntity = updateFundRepository.save(fundMaster);
        }
        //Generate bills after updating the master charge table
        maintenanceBillService.updateChargesForCurrentMonth(UpdateEntity);

        return UpdateEntity;
    }

    public FundMaster getFundMaster(int flatType) throws RecordNotFoundException{
        Optional<FundMaster> fundMaster = updateFundRepository.findFundMasterByFltType(flatType);
        if(fundMaster.isPresent()){
            return fundMaster.get();
        }else
            throw new RecordNotFoundException("No Details found for given ID");
    }

}
