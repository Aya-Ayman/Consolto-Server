/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.ClinicApi;
import dao.Implementation.clinic.ClinicImpl;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ClinicListPojo;
import pojos.ClinicPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
@Path("/clinic")
public class ClinicApiImplementation implements ClinicApi{

    @POST
    @Path("/insert")
    // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage insertClinic(ClinicPojo clinic) {

        ResponseMessage response = new ResponseMessage();
//        ArrayList<String> phones = new ArrayList();
//        ClinicPojo clinic = new ClinicPojo();
        ClinicImpl clinicObj = new ClinicImpl();

//        double mylongitude = Double.parseDouble(clinic_longitude);
//        double mylatitude = Double.parseDouble(clinic_latitude);
        //Date start = null, end = null;
        //start = java.sql.Date.valueOf(clinic_start_date);
        //end = java.sql.Date.valueOf(clinic_end_date);


//        if (!phone1.isEmpty()) {
//            phones.add(phone1);
//        }
//        if (!phone2.isEmpty()) {
//            phones.add(phone2);
//        }
//        if (!phone3.isEmpty()) {
//            phones.add(phone3);
//        }
//
//        clinic.setLatitude(mylatitude);
//        clinic.setLongitude(mylongitude);
//        clinic.setDoctorNameAr(clinic_doctor_name_ar);
//        clinic.setDoctorNameEn(clinic_doctor_name_en);
//        clinic.setSpecialization(clinic_specialization);
        clinic.setMedicalTypeId(2);
//        clinic.setStartDate(clinic_start_date);
//        clinic.setEndDate(clinic_end_date);
//        clinic.setCloseHour(clinic_close_hour);
//        clinic.setOpenHour(clinic_open_hour);
//        clinic.setAddress(clinic_address);
//        clinic.setRate(clinic_rate);
//        clinic.setPhones(phones);
//        clinic.setImage(urlImage);

//        if (!phone1.isEmpty()) {
//            phones.add(phone1);
//        }
//        if (!phone2.isEmpty()) {
//            phones.add(phone2);
//        }
//        if (!phone3.isEmpty()) {
//            phones.add(phone3);
//        }
//
//        clinic.setLatitude(mylatitude);
//        clinic.setLongitude(mylongitude);
//        clinic.setDoctorNameAr(clinic_doctor_name_ar);
//        clinic.setDoctorNameEn(clinic_doctor_name_en);
//        clinic.setSpecialization(clinic_specialization);
//        clinic.setMedicalTypeId(6);
//        clinic.setStartDate(clinic_start_date);
//        clinic.setEndDate(clinic_end_date);
//        clinic.setCloseHour(clinic_close_hour);
//        clinic.setOpenHour(clinic_open_hour);
//        clinic.setAddress(clinic_address);
//        clinic.setRate(clinic_rate);
//        clinic.setPhones(phones);
//        clinic.setImage(urlImage);
        
        boolean result = clinicObj.addClinic(clinic);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("Clinic Added Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Clinic Failed to be added");
            response.setError("1");
            return response;

        }

    }

    @DELETE
    @Path("/delete/{clinic_id}")
   
    public ResponseMessage deleteClinic(@PathParam("clinic_id") int clinic_id) {
        
        ResponseMessage response = new ResponseMessage();
        ClinicImpl clinicObj = new ClinicImpl();
       
        boolean result = clinicObj.deleteClinic(clinic_id);
        System.out.print("deleteeeeeeeeeeeeeeeeeeeeeeeeApi" + result);
        if (result == true) {
            response.setStatus(true);
            response.setMessage("clinic deleted Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("clinic deletion failed");
            response.setError("1");
            return response;

        }
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ClinicListPojo getAllClinics() {

        ClinicImpl clinicObj = new ClinicImpl();
        ArrayList<ClinicPojo> clinics = new ArrayList();
        ClinicListPojo clinicList = new ClinicListPojo();
        clinics = clinicObj.getAllClinics();
        clinicList.setClinics(clinics);
        return clinicList;
    }
    
    
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
   
    @Override
    public ResponseMessage update(ClinicPojo clinic)
    {
        
      ResponseMessage response = new ResponseMessage();

      ClinicImpl implObject = new ClinicImpl();
      boolean isUpdated = implObject.updateClinic(clinic);
      if(isUpdated==true)
       {
                  

         response.setError("0");
         response.setMessage("clinic is updated");
         response.setStatus(true);
         
       }
     else{
                            

         response.setError("1");
         response.setMessage("clinic is not updated");
         response.setStatus(false);
         }
      return response;   
    }
    
    
    @GET
    @Path("/retrieveCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int retrieveClinicsCount() {

        ClinicImpl clinicObj = new ClinicImpl();
        int count;
        count = clinicObj.retrieveClinicsCount();
        
        return count;
    }
}
