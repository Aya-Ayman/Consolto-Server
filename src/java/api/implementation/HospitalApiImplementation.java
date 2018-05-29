/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.HospitalApi;
import dao.Implementation.hospital.HospitalImpl;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.HospitalListPojo;
import pojos.HospitalPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
@Path("/hospital")
public class HospitalApiImplementation implements HospitalApi {

    @POST
    @Path("/insert")
    //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage insertHospital(@FormParam("name") String name, @FormParam("name_english") String name_english, @FormParam("address") String address, @FormParam("longitude") String longitude, @FormParam("latitude") String latitude, @FormParam("start_date") String start_date, @FormParam("end_date") String end_date, @FormParam("open_hour") String open_hour, @FormParam("close_hour") String close_hour, @FormParam("rate") int rate, @FormParam("ceo") String ceo, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3, @FormParam("c1") String dept1, @FormParam("c2") String dept2, @FormParam("c3") String dept3, @FormParam("c4") String dept4, @FormParam("c5") String dept5, @FormParam("c6") String dept6, @FormParam("c7") String dept7, @FormParam("c8") String dept8) {
        ResponseMessage response = new ResponseMessage();
        HospitalPojo hospital = new HospitalPojo();
        ArrayList<String> phones = new ArrayList();
        ArrayList<String> departments = new ArrayList();
        HospitalImpl hospitalObj = new HospitalImpl();
        double mylongitude = Double.parseDouble(longitude);
        double mylatitude = Double.parseDouble(latitude);
        //Date start = null, end = null;
        //start = java.sql.Date.valueOf(start_date);
        //end = java.sql.Date.valueOf(end_date);

        if (!phone1.isEmpty()) {
            phones.add(phone1);
        }
        if (!phone2.isEmpty()) {
            phones.add(phone2);
        }
        if (!phone3.isEmpty()) {
            phones.add(phone3);
        }
        if (dept1 != null) {
            departments.add(dept1);
        }
        if (dept2 != null) {
            departments.add(dept2);
        }
        if (dept3 != null) {
            departments.add(dept3);
        }
        if (dept4 != null) {
            departments.add(dept4);
        }
        if (dept5 != null) {
            departments.add(dept5);
        }
        if (dept6 != null) {
            departments.add(dept6);
        }
        if (dept7 != null) {
            departments.add(dept7);
        }
        if (dept8 != null) {
            departments.add(dept8);
        }

        hospital.setAddress(address);
        hospital.setCeo(ceo);
        hospital.setLatitude(mylatitude);
        hospital.setLongitude(mylongitude);
        hospital.setNameAr(name);
        hospital.setNameEn(name_english);
        hospital.setRate(rate);
        hospital.setEndDate(end_date);
        hospital.setStartDate(start_date);
        hospital.setMedicalTypeId(1);
        hospital.setCloseHour(close_hour);
        hospital.setOpenHour(open_hour);
        hospital.setPhones(phones);
        hospital.setDepartments(departments);

        boolean insertResult = hospitalObj.addHospital(hospital);

        if (insertResult == true) {
            response.setStatus(true);
            response.setMessage("Hospital Added Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Hospital Failed to be added");
            response.setError("1");
            return response;
        }

    }

    @DELETE
    @Path("/delete/{hospital_id}")
    ///{type_id}
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage deleteHospital(@PathParam("hospital_id") int hospital_id) {
        //,@PathParam("type_id")int type_id
        ResponseMessage response = new ResponseMessage();
        HospitalImpl hospitalObj = new HospitalImpl();
        boolean result = hospitalObj.deleteHospital(hospital_id);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("hospital deleted Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("hospital deletion failed");
            response.setError("1");
            return response;

        }
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public HospitalListPojo getAllHospitals() {

        HospitalImpl hospitalObj = new HospitalImpl();
        HospitalListPojo hospitalsList = new HospitalListPojo();
        ArrayList<HospitalPojo> hospitals = new ArrayList();
        hospitals = hospitalObj.getAllHospitals();
        hospitalsList.setHospitals(hospitals);
        return hospitalsList;
    }

}
