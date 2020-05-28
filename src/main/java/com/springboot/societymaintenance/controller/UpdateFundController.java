package com.springboot.societymaintenance.controller;

import com.springboot.societymaintenance.exception.RecordNotFoundException;
import com.springboot.societymaintenance.model.FundMaster;
import com.springboot.societymaintenance.service.UpdateFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funds")
public class UpdateFundController {

    @Autowired
    UpdateFundService updateFundService;

    @RequestMapping(value = "/saveUpdateFunds", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<FundMaster> saveUpdateFunds(@RequestBody FundMaster fundMaster)
            throws RecordNotFoundException {
        FundMaster updatedfund = updateFundService.updateFunds(fundMaster);
        return new ResponseEntity<FundMaster>(updatedfund, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{flatType}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<FundMaster> getFundMaster(@PathVariable("flatType") int flatType)
            throws RecordNotFoundException{
        FundMaster fundMaster = updateFundService.getFundMaster(flatType);
        return new ResponseEntity<FundMaster>(fundMaster, new HttpHeaders(), HttpStatus.OK);
    }

}
