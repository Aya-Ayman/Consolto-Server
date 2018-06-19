/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

/**
 *
 * @author Aya
 */


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
import pojos.CompanyListPojo;
import pojos.CompanyPojo;
import pojos.CompanyResponse;
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
    public CompanyListPojo retrive(){
        CompanyDaoInterface implObject = new CompanyDaoImplementation();
        companyList = (ArrayList<CompanyPojo>) implObject.getAllCompanies();
        CompanyListPojo companyListObject = new CompanyListPojo(companyList);
        return companyListObject;
    }
    
    
    @GET
    @Path("/getCompany/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public CompanyResponse retriveCompany(@PathParam("id")int id){
        CompanyResponse companyresponse = new CompanyResponse();
        CompanyDaoInterface implObject = new CompanyDaoImplementation();
        companyresponse= implObject.getCompany(id);
        return companyresponse;
    }
    
    
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
 @Override
    public ResponseMessage setData (CompanyPojo companyPojo){
    
   ResponseMessage response = new ResponseMessage();
   List phoneList = new ArrayList<String>();
   if(!companyPojo.getPhones().get(0).isEmpty())
   {    
    phoneList.add(companyPojo.getPhones().get(0));
   }
//   if(!companyPojo.getPhones().get(1).isEmpty())
//   {    
//    phoneList.add(companyPojo.getPhones().get(1));
//   }
//   if(!companyPojo.getPhones().get(2).isEmpty())
//   {    
//    phoneList.add(companyPojo.getPhones().get(2));
//   }
   
//   double doubleLongitude = Double.parseDouble(companyPojo.getLongitude().toString());
//   double doubleLatitude = Double.parseDouble(companyPojo.getLatitude().toString());
//   float packageFloat = Float.parseFloat(companyPojo.getPackageType().toString());

   CompanyDaoInterface implObject = new CompanyDaoImplementation();
    boolean isInserted = implObject.insertCompany(companyPojo);
    if(isInserted==true)
     {
      response.setError("0");
      response.setMessage("company is inserted");
      response.setStatus(true);
     }
  else{
       response.setError("1");
       response.setMessage("company is not inserted");
       response.setStatus(false);
        }
   
   return response;
    
}
           
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public CompanyResponse update(CompanyPojo companyPojo)
    {
        System.out.println("update");
        
      CompanyResponse response = new CompanyResponse();
      List phoneList = new ArrayList<String>();
      if(!companyPojo.getPhones().get(0).isEmpty())
      {    
       phoneList.add(companyPojo.getPhones().get(0));
      }
//        if(!companyPojo.getPhones().get(1).isEmpty())
//      { 
//        phoneList.add(companyPojo.getPhones().get(1));
//      }
//        if(!companyPojo.getPhones().get(2).isEmpty())
//      {   
//        phoneList.add(companyPojo.getPhones().get(2));  
//      }
//        double doubleLongitude = Double.parseDouble(companyPojo.getLongitude().toString());
//       double doubleLatitude = Double.parseDouble(companyPojo.getLatitude().toString());
//        float packageFloat = Float.parseFloat(companyPojo.getPackageType().toString());


      CompanyDaoInterface implObject = new CompanyDaoImplementation();
      boolean isInserted = implObject.updateCompany(companyPojo);
      if(isInserted==true)
       {
                   System.out.println("inside true");

         response.setError("0");
         response.setMessage("company is updated");
         response.setStatus(true);
         response.setCompanyObject(companyPojo);
       }
     else{
                             System.out.println("inside false");

         response.setError("1");
         response.setMessage("company is not updated");
         response.setStatus(false);
         }
      return response;   
    }
    
    
    
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage delete(@PathParam("id")int id)
    {
       ResponseMessage response = new ResponseMessage();
       CompanyDaoInterface implObject = new CompanyDaoImplementation();
       boolean isInserted = implObject.deleteCompany(id);
       if(isInserted==true)
       {
         response.setError("0");
         response.setMessage("company is Deleted");
         response.setStatus(true);
       }
     else{
         response.setError("1");
         response.setMessage("company is not Deleted");
         response.setStatus(false);
         }
      return response;   
    }
  
}
