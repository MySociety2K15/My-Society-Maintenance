package com.springboot.societymaintenance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {
    @RequestMapping({"/","/dashboard","/updateflat","/updatecharges","/viewallbills","/about"})
    public String index() {
        return "index.html";
    }
}
