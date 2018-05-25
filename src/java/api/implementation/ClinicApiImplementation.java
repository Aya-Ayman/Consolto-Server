/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.ClinicApi;
import dao.Implementation.clinic.ClinicImpl;
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
import pojos.ClinicPojo;
import pojos.ResponsePojo;

/**
 *
 * @author Aya
 */
@Path("/clinic")
public class ClinicApiImplementation implements ClinicApi {

    @POST
    @Path("/insert")
    // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePojo insertClinic(@FormParam("clinic_longitude") String clinic_longitude, @FormParam("clinic_latitude") String clinic_latitude, @FormParam("clinic_address") String clinic_address, @FormParam("clinic_specialization") String clinic_specialization, @FormParam("clinic_end_date") String clinic_end_date, @FormParam("clinic_start_date") String clinic_start_date, @FormParam("clinic_open_hour") String clinic_open_hour, @FormParam("clinic_close_hour") String clinic_close_hour, @FormParam("clinic_rate") int clinic_rate, @FormParam("clinic_doctor_name_en") String clinic_doctor_name_en, @FormParam("clinic_doctor_name_ar") String clinic_doctor_name_ar, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3) {

        ResponsePojo response = new ResponsePojo();
        ArrayList<String> phones = new ArrayList();
        ClinicPojo clinic = new ClinicPojo();
        ClinicImpl clinicObj = new ClinicImpl();

        double mylongitude = Double.parseDouble(clinic_longitude);
        double mylatitude = Double.parseDouble(clinic_latitude);
        Date start = null, end = null;
        start = java.sql.Date.valueOf(clinic_start_date);
        end = java.sql.Date.valueOf(clinic_end_date);

        if (!phone1.isEmpty()) {
            phones.add(phone1);
        }
        if (!phone2.isEmpty()) {
            phones.add(phone2);
        }
        if (!phone3.isEmpty()) {
            phones.add(phone3);
        }

        clinic.setClinicLatitude(mylatitude);
        clinic.setClinicLongitude(mylongitude);
        clinic.setClinicDoctorNameAr(clinic_doctor_name_ar);
        clinic.setClinicDoctorNameEn(clinic_doctor_name_en);
        clinic.setClinicSpecialization(clinic_specialization);
        clinic.setMedicalTypeMedicalTypeId(2);
        clinic.setClinicStartDate(start);
        clinic.setClinicEndDate(end);
        clinic.setClinicCloseHour(clinic_close_hour);
        clinic.setClinicOpenHour(clinic_open_hour);
        clinic.setClinicAddress(clinic_address);
        clinic.setClinicRate(clinic_rate);
        clinic.setClinicPhones(phones);

        boolean result = clinicObj.addClinic(clinic);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("Clinic Added Successfully");
            response.setError("No Error");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Clinic Failed to be added");
            response.setError(" Error");
            return response;

        }

    }

    @DELETE
    @Path("/delete/{clinic_id}")
    ///{type_id}
    public ResponsePojo deleteClinic(@PathParam("clinic_id") int clinic_id) {
        //@PathParam("type_id")int type_id
        ResponsePojo response = new ResponsePojo();
        ClinicImpl clinicObj = new ClinicImpl();
        //int i=clinicObj.deleteClinic(clinic_id);
        boolean result = clinicObj.deleteClinic(clinic_id);
        System.out.print("deleteeeeeeeeeeeeeeeeeeeeeeeeApi" + result);
        if (result == true) {
            response.setStatus(true);
            //response
            response.setMessage("clinic deleted Successfully");
            response.setError("No Error");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("clinic deletion failed");
            response.setError(" Error");
            return response;

        }
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ClinicPojo> getClinic() {

        ClinicImpl clinicObj = new ClinicImpl();
        ArrayList<ClinicPojo> clinics = new ArrayList();
        clinics = clinicObj.getAllClinics();
        return clinics;
    }
}
