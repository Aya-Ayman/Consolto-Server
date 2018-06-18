/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.lab;

import java.util.ArrayList;
import pojos.LabPojo;

/**
 *
 * @author Aya
 */
public class testUpdateLab {
    
    public static void main(String[]args)
{

    LabImpl obj= new LabImpl();
    LabPojo lab= new LabPojo();
    ArrayList<String> phones= new ArrayList<>();
    phones.add("1");
    phones.add("2");
    phones.add("3");
    
    ArrayList<String> specializations= new ArrayList<>();
    specializations.add("special5");
    specializations.add("special6");
    specializations.add("special7");

    
    lab.setAddress("alex");
    lab.setCloseHour("12:00am");
    lab.setOpenHour("12:00pm");
    lab.setNameAr("الشفاء");
    lab.setNameEn("elshefaa");
    lab.setEndDate("12-12-2015");
    lab.setStartDate("12-12-2020");
    lab.setImage("hello");
    lab.setLatitude(2762.4);
    lab.setLongitude(233.4);
    lab.setRate(0);
    lab.setCeo("hadeer");

    lab.setMedicalTypeId(2);
    lab.setLabSpecializations(specializations);
    lab.setLabPhones(phones);
    lab.setId(2);
    
    obj.updateLab(lab);
}
}