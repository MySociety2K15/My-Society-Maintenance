package com.springboot.societymaintenance.repository;

import com.springboot.societymaintenance.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {

    Optional<Flat> findFlatByFlatNo(String flatNo);

    Optional<List<Flat>> findAllByFlatType(int flatType);
}
