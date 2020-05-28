package com.springboot.societymaintenance.repository;

import com.springboot.societymaintenance.model.FundMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UpdateFundRepository extends JpaRepository<FundMaster, Long> {
    Optional<FundMaster> findFundMasterByFltType(int flatType);
}
