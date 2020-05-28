package com.springboot.societymaintenance.service;

import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.Society;
import com.springboot.societymaintenance.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SocietyService {

    @Autowired
    SocietyRepository societyRepository;

    public Society getSocietyById(long societyId) throws RecordNotFoundException {

        Optional<Society> society = societyRepository.findById(societyId);
        if(society.isPresent()){
            return society.get();
        }
        else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
