package com.springboot.societymaintenance.service;

import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatService {

    @Autowired
    FlatRepository flatRepository;

    public Flat updateFlat(Flat flat) throws RecordNotFoundException
    {
        Optional<Flat> flatFound = flatRepository.findFlatByFlatNo(flat.getFlatNo());

        if(flatFound.isPresent())
        {
            Flat newEntity = flatFound.get();
            newEntity.setFlatNo(flat.getFlatNo());
            newEntity.setWing(flat.getWing());
            newEntity.setFloor(flat.getFloor());
            newEntity.setSociety(flat.getSociety());
            newEntity.setFlatType(flat.getFlatType());
            newEntity.setArea(flat.getArea());
            newEntity.setTwoWheelers(flat.getTwoWheelers());
            newEntity.setFourWheelers(flat.getFourWheelers());
            newEntity.setOwnerName(flat.getOwnerName());
            newEntity.setEmailId(flat.getEmailId());
            newEntity.setMobileNo(flat.getMobileNo());

            newEntity = flatRepository.save(newEntity);

            return newEntity;
        } else {
            Flat updatedflat = flatRepository.save(flat);
            return updatedflat;
        }
    }

    public Flat getFlatDetails(String flatNo) throws  RecordNotFoundException{

        Optional<Flat> flat = flatRepository.findFlatByFlatNo(flatNo);
        if(flat.isPresent())
            return flat.get();
        else
            throw  new RecordNotFoundException("No Details found for given ID");
    }

    public List<Flat> getAllFlats() throws RecordNotFoundException{
        return flatRepository.findAll();
    }

    public List<Flat> getAllFlatsByFlatType(int flatType) throws RecordNotFoundException{
        Optional<List<Flat>> flats = flatRepository.findAllByFlatType(flatType);
        if(flats.isPresent()){
            return flats.get();
        }else{
            throw new RecordNotFoundException("No Details found for given ID");
        }
    }
}
