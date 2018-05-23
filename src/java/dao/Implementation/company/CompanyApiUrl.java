/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.company;

/**
 *
 * @author Aya
 */


import api.implementation.*;
import dao.Implementation.company.CompanyDaoImplementation;
import dao.Interfaces.company.CompanyDaoInterface;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.CompanyPojo;
import pojos.ResponseMessage;



@Path("/company")

public class CompanyApiUrl implements api.interfaces.CompanyApiUrlInterface{
 static ArrayList<CompanyPojo> companyList;
    
    static{
        
        companyList=new ArrayList<CompanyPojo>();
        System.out.println("cons...");
    }
 
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    
 @Override
    public List retrive(){
        CompanyDaoInterface implObject = new CompanyDaoImplementation();
        companyList = (ArrayList<CompanyPojo>) implObject.getAllCompanies();
        return companyList;
    }
    
    
    @GET
    @Path("/getCompany/{id}")
    @Produces(MediaType.APPLICATION_JSON)
 @Override
    public CompanyPojo retriveCompany(@PathParam("id")int id){
        CompanyPojo company = new CompanyPojo();
        CompanyDaoInterface implObject = new CompanyDaoImplementation();
        company = implObject.getCompany(id);
        return company;
    }
    
    
    
//    @POST
//    @Path("/insert")
//    public Response setData(Company company)
//    {
//        Response response = new Response();
//        CompanyDaoImplementation implObject = new CompanyDaoImplementation();
//        boolean isInserted = implObject.insertCompany(company);
//        //System.out.println(isInserted);
//        if(isInserted==true)
//        {
//          response.setError(200);
//          response.setMessage("company is inserted");
//          response.setStatus(true);
//        }
//        else{
//            response.setError(404);
//          response.setMessage("company is not inserted");
//          response.setStatus(false);
//        }
//        return response;
//    }
    
    
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
 @Override
    public ResponseMessage setData (@FormParam("name")String name,@FormParam("email")String email,@FormParam("latitude")String latitude,@FormParam("longitude")String longitude,@FormParam("address")String address,@FormParam("companyPackage")String companyPackage,@FormParam("startDate")String startDate,@FormParam("endDate")String endDate,@FormParam("ceo")String ceo,@FormParam("insuranceId")int insuranceId,@FormParam("phone1")String phone1,@FormParam("phone2")String phone2,@FormParam("phone3")String phone3){
    
   ResponseMessage response = new ResponseMessage();
   List phoneList = new ArrayList<String>();
   if(!phone1.isEmpty())
   {    
    phoneList.add(phone1);
   }
   if(!phone2.isEmpty())
   {    
    phoneList.add(phone2);
   }
   if(!phone3.isEmpty())
   {    
    phoneList.add(phone3);
   }
   
   double doubleLongitude = Double.parseDouble(longitude);
   double doubleLatitude = Double.parseDouble(latitude);
   float packageFloat = Float.parseFloat(companyPackage);
   Date startdateDate = null,enddateDate=null;
  // DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
   startdateDate = java.sql.Date.valueOf(startDate);
   enddateDate = java.sql.Date.valueOf(endDate);
 
   
   CompanyPojo company = new CompanyPojo(name, email,doubleLatitude , doubleLongitude, address, packageFloat,startdateDate,enddateDate, ceo, insuranceId,phoneList);
   CompanyDaoInterface implObject = new CompanyDaoImplementation();
    boolean isInserted = implObject.insertCompany(company);
    if(isInserted==true)
     {
      response.setError("200");
      response.setMessage("company is inserted");
      response.setStatus(true);
     }
  else{
       response.setError("404");
       response.setMessage("company is not inserted");
       response.setStatus(false);
        }
   
   return response;
    
}
    
    
    
    
//    @POST
//    @Path("/insertJson")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces("text/html")
//    public Response setData(student st)
//    {
//          String result = "student saved : " + st;
//        return Response.status(201).entity(result).build();
//    }
//    
//        
    @PUT
    @Path("/update/{id}")
    @Override
    public ResponseMessage update(@FormParam("name")String name,@FormParam("email")String email,@FormParam("latitude")String latitude,@FormParam("longitude")String longitude,@FormParam("address")String address,@FormParam("companyPackage")String companyPackage,@FormParam("startDate")String startDate,@FormParam("endDate")String endDate,@FormParam("ceo")String ceo,@FormParam("insuranceId")int insuranceId,@FormParam("phone1")String phone1,@FormParam("phone2")String phone2,@FormParam("phone3")String phone3,@PathParam("id")int id)
    {
      ResponseMessage response = new ResponseMessage();
      List phoneList = new ArrayList<String>();
      if(!phone1.isEmpty())
      {    
       phoneList.add(phone1);
      }
        if(!phone2.isEmpty())
      { 
        phoneList.add(phone2);
      }
        if(!phone3.isEmpty())
      {   
        phoneList.add(phone3);  
      }
        double doubleLongitude = Double.parseDouble(longitude);
       double doubleLatitude = Double.parseDouble(latitude);
        float packageFloat = Float.parseFloat(companyPackage);
       Date startdateDate = null,enddateDate=null;
   DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
   startdateDate = java.sql.Date.valueOf(startDate);
   enddateDate = java.sql.Date.valueOf(endDate);
        
      CompanyPojo company = new CompanyPojo(id, name, email, doubleLatitude, doubleLongitude, address, packageFloat, startdateDate, enddateDate, ceo, insuranceId,phoneList);
      CompanyDaoInterface implObject = new CompanyDaoImplementation();
      boolean isInserted = implObject.updateCompany(company);
      if(isInserted==true)
       {
         response.setError("200");
         response.setMessage("company is updated");
         response.setStatus(true);
       }
     else{
         response.setError("404");
         response.setMessage("company is not updated");
         response.setStatus(false);
         }
      return response;   
    }
    
    
    
    
    @DELETE
    @Path("/delete/{id}")
    @Override
    public ResponseMessage delete(@PathParam("id")int id)
    {
       ResponseMessage response = new ResponseMessage();
       CompanyDaoInterface implObject = new CompanyDaoImplementation();
       boolean isInserted = implObject.deleteCompany(id);
       if(isInserted==true)
       {
         response.setError("200");
         response.setMessage("company is Deleted");
         response.setStatus(true);
       }
     else{
         response.setError("404");
         response.setMessage("company is not Deleted");
         response.setStatus(false);
         }
      return response;   
    }
    

    
    
}
