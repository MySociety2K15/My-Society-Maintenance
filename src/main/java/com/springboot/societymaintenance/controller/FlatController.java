package com.springboot.societymaintenance.controller;


import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {

    @Autowired
    FlatService flatService;

    @RequestMapping(value = "/saveUpdateFlat", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Flat> saveUpdateFlat(@RequestBody Flat flat)
            throws RecordNotFoundException {
        Flat updatedFlat = flatService.updateFlat(flat);
        return new ResponseEntity<Flat>(updatedFlat, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{flatNo}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Flat> getFlat(@PathVariable("flatNo") String flatNo)
            throws RecordNotFoundException{
        Flat flat = flatService.getFlatDetails(flatNo);
        return new ResponseEntity<Flat>(flat, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/allFlats")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Flat>> getAllFlats()
        throws RecordNotFoundException{
        List<Flat> allFlats = flatService.getAllFlats();
        return new ResponseEntity<List<Flat>>(allFlats, new HttpHeaders(), HttpStatus.OK);
    }
}
