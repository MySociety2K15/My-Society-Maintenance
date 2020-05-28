package com.springboot.societymaintenance.repository;

import com.springboot.societymaintenance.model.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocietyRepository  extends JpaRepository<Society, Long> {
}
