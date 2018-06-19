/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.clinic;

import java.util.ArrayList;
import pojos.ClinicPojo;


/**
 *
 * @author Aya
 */
public class testUpdate {
    
public static void main(String[]args)
{

    ClinicImpl obj= new ClinicImpl();
    ClinicPojo clinic= new ClinicPojo();
    ArrayList<String> phones= new ArrayList<>();
    phones.add("1");
    phones.add("2");
    phones.add("3");

    
    clinic.setAddress("Mansorah");
    clinic.setCloseHour("12:00am");
    clinic.setOpenHour("12:00pm");
    clinic.setDoctorNameAr("ايه");
    clinic.setDoctorNameEn("aya");
    clinic.setEndDate("12-12-2015");
    clinic.setStartDate("12-12-2020");
    clinic.setImage("hello");
    clinic.setLatitude(2762);
    clinic.setLongitude(233);
    clinic.setRate(0);
    clinic.setMedicalTypeId(2);
    clinic.setSpecialization("heart");
    clinic.setPhones(phones);
    clinic.setId(1);
    
    obj.updateClinic(clinic);

}
    
    
}
