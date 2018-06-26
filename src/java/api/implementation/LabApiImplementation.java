/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.LabApi;
import dao.Implementation.hospital.HospitalImpl;
import dao.Implementation.lab.LabImpl;
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
import pojos.LabListPojo;
import pojos.LabPojo;
import pojos.ResponseMessage;
import pojos.ResponsePojo;

/**
 *
 * @author Aya
 */
@Path("/lab")
public class LabApiImplementation implements LabApi {

    @POST
    @Path("/insert")
    //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage insertData(LabPojo lab) {
        ResponseMessage response = new ResponseMessage();
        
//        ArrayList<String> phones = new ArrayList();
//        ArrayList<String> specializations = new ArrayList();
//        LabPojo lab = new LabPojo();
        LabImpl labObj = new LabImpl();
//
//        double mylongitude = Double.parseDouble(lab_longitude);
//        double mylatitude = Double.parseDouble(lab_latitude);
        //Date start = null, end = null;
        //start = java.sql.Date.valueOf(lab_start_date);
        //end = java.sql.Date.valueOf(lab_end_date);

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
//        if (special1 != null) {
//            specializations.add(special1);
//        }
//        if (special2 != null) {
//            specializations.add(special2);
//        }
//        if (special3 != null) {
//            specializations.add(special3);
//        }
//        if (special4 != null) {
//            specializations.add(special4);
//        }
//        if (special5 != null) {
//            specializations.add(special5);
//        }
//        if (special6 != null) {
//            specializations.add(special6);
//        }
//        if (special7 != null) {
//            specializations.add(special7);
//        }
//        if (special8 != null) {
//            specializations.add(special8);
//        }
//
//        lab.setAddress(lab_address);
//        lab.setCeo(lab_ceo);
//        lab.setRate(lab_rate);
//        lab.setLatitude(mylatitude);
//        lab.setLongitude(mylongitude);
//        lab.setStartDate(lab_start_date);
//        lab.setEndDate(lab_end_date);
//        lab.setNameAr(lab_name_ar);
//        lab.setNameEn(lab_name_en);
//        lab.setOpenHour(lab_open_hour);
//        lab.setCloseHour(lab_close_hour);
        lab.setMedicalTypeId(4);
//        lab.setLabPhones(phones);
//        lab.setLabSpecializations(specializations);
//        lab.setImage(urlImage);
        boolean result = labObj.addLab(lab);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("Lab Added Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Lab Failed to be added");
            response.setError("1");
            return response;

        }

    }

    @DELETE
    ///{type_id}
    @Path("/delete/{lab_id}")
    public ResponseMessage deleteLab(@PathParam("lab_id") int lab_id) {
        //,@PathParam("type_id")int type_id
        ResponseMessage response = new ResponseMessage();
        LabImpl labObj = new LabImpl();

        boolean result = labObj.deleteLab(lab_id);

        if (result == true) {
            response.setStatus(true);
            response.setMessage("lab deleted Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("lab deletion failed");
            response.setError("1");
            return response;

        }
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public LabListPojo getAllLabs() {

        LabImpl labObj = new LabImpl();
        ArrayList<LabPojo> labs = new ArrayList();
        LabListPojo labList= new LabListPojo();
        labs = labObj.getAllLabs();
        labList.setLabs(labs);
        return labList;
    }
    
    
  @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
   
    @Override
    public ResponseMessage update(LabPojo lab)
    {
        
      ResponseMessage response = new ResponseMessage();

      LabImpl implObject = new LabImpl();
      boolean isUpdated = implObject.updateLab(lab);
      if(isUpdated==true)
       {
                  
         response.setError("0");
         response.setMessage("lab is updated");
         response.setStatus(true);
         
       }
     else{
                            
         response.setError("1");
         response.setMessage("lab is not updated");
         response.setStatus(false);
         }
      return response;   
    }
    
    @GET
    @Path("/retrieveCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int retrieveLabsCount() {

        LabImpl labObj = new LabImpl();
        int count;
        count = labObj.retrieveLabsCount();
        
        return count;
    }
}
