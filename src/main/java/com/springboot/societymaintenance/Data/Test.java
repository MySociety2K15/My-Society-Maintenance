package com.springboot.societymaintenance.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("YYYY").format(cal.getTime()));
    }
}
