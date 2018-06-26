/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.PharmacyApi;
import dao.Implementation.clinic.ClinicImpl;
import dao.Implementation.pharmacy.PharmacyImpl;
import java.sql.Date;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ClinicPojo;
import pojos.PharmacyListPojo;
import pojos.PharmacyPojo;
import pojos.ResponseMessage;
import pojos.ResponsePojo;

/**
 *
 * @author Aya
 */
@Path("/pharmacy")
public class PharmacyApiImplementation implements PharmacyApi {

    @POST
    @Path("/insert")
    // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage insertPharmacy(PharmacyPojo pharmacy) {
        ResponseMessage response = new ResponseMessage();
//        PharmacyPojo pharmacy = new PharmacyPojo();
//        ArrayList<String> phones = new ArrayList();
        PharmacyImpl pharmacyObj = new PharmacyImpl();

//        double mylongitude = Double.parseDouble(pharmacy_longitude);
//        double mylatitude = Double.parseDouble(pharmacy_latitude);
//        Date start = null, end = null;
//        start = java.sql.Date.valueOf(pharmacy_start_date);
//        end = java.sql.Date.valueOf(pharmacy_end_date);

//        if (!phone1.isEmpty()) {
//            phones.add(phone1);
//        }
//        if (!phone2.isEmpty()) {
//            phones.add(phone2);
//        }
//        if (!phone3.isEmpty()) {
//            phones.add(phone3);
//        }

//        pharmacy.setLatitude(mylatitude);
//        pharmacy.setLongitude(mylongitude);
//        pharmacy.setNameAr(pharmacy_name_ar);
//        pharmacy.setNameEn(pharmacy_name_en);
//        pharmacy.setAddress(pharmacy_address);
//        pharmacy.setOpenHour(pharmacy_open_hour);
//        pharmacy.setCloseHour(pharmacy_close_hour);
//        pharmacy.setRate(pharmacy_rate);
        pharmacy.setMedicalTypeId(3);
//        pharmacy.setPharmacyPhones(phones);
//        pharmacy.setStartDate(pharmacy_start_date);
//        pharmacy.setEndDate(pharmacy_end_date);
//        pharmacy.setImage(urlImage);
        boolean result = pharmacyObj.addPharmacy(pharmacy);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("Pharmacy Added Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Pharmacy Failed to be added");
            response.setError("1");
            return response;

        }

    }

    @DELETE
    ///{type_id}
    @Path("/delete/{pharmacy_id}")
    public ResponseMessage deletePharmacy(@PathParam("pharmacy_id") int pharmacy_id) {
        //,@PathParam("type_id")int type_id
        ResponseMessage response = new ResponseMessage();
        PharmacyImpl pharmacyObj = new PharmacyImpl();

        boolean result = pharmacyObj.deletePharmacy(pharmacy_id);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("pharmacy deleted Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("pharmacy deletion failed");
            response.setError("1");
            return response;
        }
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public PharmacyListPojo getAllPharmacies() {

        PharmacyImpl pharmacyObj = new PharmacyImpl();
        ArrayList<PharmacyPojo> pharmacies = new ArrayList();
        PharmacyListPojo pharmacyList = new PharmacyListPojo();
        pharmacies = pharmacyObj.getAllPharmacies();
        pharmacyList.setPharmacies(pharmacies);
        return pharmacyList;
    }
    
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
   
    public ResponseMessage update(PharmacyPojo pharmacy)
    {
        
      ResponseMessage response = new ResponseMessage();

      PharmacyImpl implObject = new PharmacyImpl();
      boolean isUpdated = implObject.updatePharmacy(pharmacy);
        System.out.println("val = "+isUpdated);
      if(isUpdated==true)
       {
                  

         response.setError("0");
         response.setMessage("pharmacy is updated");
         response.setStatus(true);
         
       }
     else{
                            

         response.setError("1");
         response.setMessage("pharmacy is not updated");
         response.setStatus(false);
         }
      return response;   
    }
    
     @GET
    @Path("/retrieveCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int retrievePharmaciesCount() {

        PharmacyImpl pharmacyObj = new PharmacyImpl();
        int count;
        count = pharmacyObj.retrievePharmaciesCount();
        
        return count;
    }
}
