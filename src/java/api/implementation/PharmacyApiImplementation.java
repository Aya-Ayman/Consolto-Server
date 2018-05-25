/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.PharmacyApi;
import dao.Implementation.pharmacy.PharmacyImpl;
import java.sql.Date;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.PharmacyPojo;
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
    public ResponsePojo insertPharmacy(@FormParam("pharmacy_name_en") String pharmacy_name_en, @FormParam("pharmacy_latitude") String pharmacy_latitude, @FormParam("pharmacy_longitude") String pharmacy_longitude, @FormParam("pharmacy_start_date") String pharmacy_start_date, @FormParam("pharmacy_end_date") String pharmacy_end_date, @FormParam("pharmacy_rate") int pharmacy_rate, @FormParam("pharmacy_address") String pharmacy_address, @FormParam("pharmacy_open_hour") String pharmacy_open_hour, @FormParam("pharmacy_close_hour") String pharmacy_close_hour, @FormParam("pharmacy_name_ar") String pharmacy_name_ar, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3) {
        ResponsePojo response = new ResponsePojo();
        PharmacyPojo pharmacy = new PharmacyPojo();
        ArrayList<String> phones = new ArrayList();
        PharmacyImpl pharmacyObj = new PharmacyImpl();

        double mylongitude = Double.parseDouble(pharmacy_longitude);
        double mylatitude = Double.parseDouble(pharmacy_latitude);
        Date start = null, end = null;
        start = java.sql.Date.valueOf(pharmacy_start_date);
        end = java.sql.Date.valueOf(pharmacy_end_date);

        if (!phone1.isEmpty()) {
            phones.add(phone1);
        }
        if (!phone2.isEmpty()) {
            phones.add(phone2);
        }
        if (!phone3.isEmpty()) {
            phones.add(phone3);
        }

        pharmacy.setPharmacyLatitude(mylatitude);
        pharmacy.setPharmacyLongitude(mylongitude);
        pharmacy.setPharmacyNameAr(pharmacy_name_ar);
        pharmacy.setPharmacyNameEn(pharmacy_name_en);
        pharmacy.setPharmacyAddress(pharmacy_address);
        pharmacy.setPharmacyOpenHour(pharmacy_open_hour);
        pharmacy.setPharmacyCloseHour(pharmacy_close_hour);
        pharmacy.setPharmacyRate(pharmacy_rate);
        pharmacy.setMedicalTypeId(3);
        pharmacy.setPharmacyPhones(phones);
        pharmacy.setPharmacyStartDate(start);
        pharmacy.setPharmacyEndDate(end);

        boolean result = pharmacyObj.addPharmacy(pharmacy);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("Pharmacy Added Successfully");
            response.setError("No Error");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Pharmacy Failed to be added");
            response.setError(" Error");
            return response;

        }

    }

    @DELETE
    ///{type_id}
    @Path("/delete/{pharmacy_id}")
    public ResponsePojo deletePharmacy(@PathParam("pharmacy_id") int pharmacy_id) {
        //,@PathParam("type_id")int type_id
        ResponsePojo response = new ResponsePojo();
        PharmacyImpl pharmacyObj = new PharmacyImpl();

        boolean result = pharmacyObj.deletePharmacy(pharmacy_id);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("pharmacy deleted Successfully");
            response.setError("No Error");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("pharmacy deletion failed");
            response.setError(" Error");
            return response;
        }
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PharmacyPojo> getPharmacy() {

        PharmacyImpl pharmacyObj = new PharmacyImpl();
        ArrayList<PharmacyPojo> pharmacies = new ArrayList();
        pharmacies = pharmacyObj.getAllPharmacies();
        return pharmacies;
    }
}
