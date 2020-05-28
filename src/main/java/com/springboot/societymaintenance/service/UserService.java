package com.springboot.societymaintenance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.User;
import com.springboot.societymaintenance.repository.UserRepository;
import com.springboot.societymaintenance.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<User> getAllUsers()
    {
        List<User> userList = userRepo.findAll();

        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> user = userRepo.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    /*public User getUserByFlat(Flat flat) throws RecordNotFoundException
    {
        Optional<User> user = userRepo.findUserByFlat(flat);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }*/

    public User getUserByEmailID(User user) throws RecordNotFoundException
    {
        Optional<User> userResponse = userRepo.findByEmailAndPassword(user.getEmail(),user.getPassword());

        if(userResponse.isPresent()) {
            return userResponse.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public User createOrUpdateUser(User entity) throws RecordNotFoundException
    {
        Optional<User> user = userRepo.findById(entity.getUserId());

        if(user.isPresent())
        {
            User newEntity = user.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setMobileNumber(entity.getMobileNumber());
            newEntity.setPassword("test2");
            newEntity.setStatus(entity.getStatus());
            newEntity.setUserRole(entity.getUserRole());

            newEntity = userRepo.save(newEntity);

            return newEntity;
        } else {
            entity = userRepo.save(entity);

            return entity;
        }
    }

    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> employee = userRepo.findById(id);

        if(employee.isPresent())
        {
            userRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("No User record exist for given id");
        }
    }
}
