/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.AdminApi;
import dao.Implementation.medicalinsurance.AdminDaoImplementation;
import dao.Interfaces.medicalinsurance.AdminDaoInterface;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.AdminListPojo;
import pojos.AdminPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */

@Path("/admin")

public class AdminApiImplementation implements AdminApi{
    static ArrayList<AdminPojo> adminList;
 
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public AdminListPojo retriveAdmins() {
       AdminDaoInterface implObject = new AdminDaoImplementation();
        adminList = (ArrayList<AdminPojo>) implObject.getAllAdmins();
        AdminListPojo adminListObject = new AdminListPojo(adminList);
        return adminListObject;
    }

    @POST
    @Path("/checkAdmin")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage retriveAdmin(AdminPojo admin) {
      AdminDaoInterface implObject = new AdminDaoImplementation();
      ResponseMessage response = new ResponseMessage();
        response =implObject.getAdmin(admin);
        return response;
    }

    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage insertAdmin(AdminPojo admin) {
      ResponseMessage response = new ResponseMessage();
      AdminDaoInterface implObject = new AdminDaoImplementation();
    boolean isInserted = implObject.insertAdmin(admin);
    if(isInserted==true)
     {
      response.setError("0");
      response.setMessage("admin is inserted");
      response.setStatus(true);
     }
  else{
       response.setError("1");
       response.setMessage("admin is not inserted");
       response.setStatus(false);
        }
   
   return response; 
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage delete(int id) {
        ResponseMessage response = new ResponseMessage();
        AdminDaoInterface implObject = new AdminDaoImplementation();
       boolean isInserted = implObject.deleteAdmin(id);
       if(isInserted==true)
       {
         response.setError("0");
         response.setMessage("admin is Deleted");
         response.setStatus(true);
       }
     else{
         response.setError("1");
         response.setMessage("admin is not Deleted");
         response.setStatus(false);
         }
      return response; 
    }
    
}
