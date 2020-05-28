package com.springboot.societymaintenance.constant;

import java.util.HashMap;
import java.util.Map;

public  class Constant {

    public static String getMonth(String monthNum){

        Map<String,String> monthMap = new HashMap<>();
        monthMap.put("1","January");
        monthMap.put("2","February");
        monthMap.put("3","March");
        monthMap.put("4","April");
        monthMap.put("5","May");
        monthMap.put("6","June");
        monthMap.put("7","July");
        monthMap.put("8","August");
        monthMap.put("9","September");
        monthMap.put("10","October");
        monthMap.put("11","November");
        monthMap.put("12","December");

        return monthMap.get(monthNum);

    }

}
