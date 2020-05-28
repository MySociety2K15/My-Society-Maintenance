package com.springboot.societymaintenance.repository;

import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.MaintenanceBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MaintenanceRepository extends JpaRepository<MaintenanceBill, Long> {

    Optional<MaintenanceBill> findMaintenanceBillByBillId(long billId);

    @Query("SELECT m FROM MaintenanceBill m where flat = ?1 order by generationDate desc")
    Optional<List<MaintenanceBill>> findLatestByFlatId(Flat flat);

    @Query("SELECT m FROM MaintenanceBill m where maintenanceMonth = ?1 and maintenanceYear =?2 and flat = ?3")
    Optional<MaintenanceBill> getMaintenanceByMonth(int month,int year,Flat flat);

    @Query("SELECT m FROM MaintenanceBill m where maintenanceMonth = month(CURRENT_DATE) and maintenanceYear =year(CURRENT_DATE)")
    Optional<List<MaintenanceBill>> findAllBillsforCurrentMonth();
}
