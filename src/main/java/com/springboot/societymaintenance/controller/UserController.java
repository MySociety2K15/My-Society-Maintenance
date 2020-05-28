package com.springboot.societymaintenance.controller;

import java.util.Date;
import java.util.List;

import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.User;
import com.springboot.societymaintenance.repository.FlatRepository;
import com.springboot.societymaintenance.repository.UserRepository;
import com.springboot.societymaintenance.service.UserService;
import com.springboot.societymaintenance.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService service;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private FlatRepository flatRepo;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();

        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        User entity = service.getUserById(id);

        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    /*@RequestMapping(value = "/flat", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> getUserByFlatId(@RequestBody Flat flat)
        throws RecordNotFoundException {
        User user = service.getUserByFlat(flat);

        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }*/

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> createOrUpdateEmployee(@RequestBody User user)
            throws RecordNotFoundException {
        User updated = service.createOrUpdateUser(user);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> loginUser(@RequestBody User user)
            throws RecordNotFoundException {
        User entity = service.getUserByEmailID(user);
        System.out.println("entity "+entity.getFirstName());
        String result = "fail";
        if(entity != null)
            result = "success";

        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }
}
