/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import SendMailImp.SendMail;
import api.interfaces.EmployeeApiInt;
import dao.Implementation.employee.EmployeeDaoImp;
import dao.Interfaces.employee.EmployeeDaoInt;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import pojos.EmployeePojo;
import pojos.ResponseMessage;
import pojos.ResponseMessageWithId;

/**
 *
 * @author hoda.CO
 */
@Path("/user")
public class EmployeeApiImp implements EmployeeApiInt {
    
        static EmployeeDaoImp impl = new EmployeeDaoImp();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessageWithId login(JSONObject login){
        ResponseMessageWithId response = new ResponseMessageWithId();
        EmployeePojo emp;
         String email=null;
         String password=null;
        try {
            email = (String) login.get("mail");
            password = (String) login.get("password");
        } catch (JSONException ex) {
            Logger.getLogger(EmployeeApiImp.class.getName()).log(Level.SEVERE, null, ex);
        }
       EmployeeDaoInt empdao=new EmployeeDaoImp();
       emp= empdao.retrieveByMailAndPassword(email, password);
       if (emp.getEmployeeId()== 0)
       {
           response.setMessage("user not found");
           response.setStatus(false);
           response.setError("404");
           return response;
       }else
               {
            response.setMessage("user found");
           response.setStatus(true);
           response.setError("200");
           response.setId(emp.getEmployeeId());
           return response;
               }
    }
   
    @POST
    @Path("/forget")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage getEmp(JSONObject mail) {
      ResponseMessage response = new ResponseMessage();
      EmployeePojo emp;
            String email=null;
        try {
            email = (String) mail.get("mail");
            
        } catch (JSONException ex) {
            Logger.getLogger(EmployeeApiImp.class.getName()).log(Level.SEVERE, null, ex);
        }
            EmployeeDaoInt empdao=new EmployeeDaoImp();
            emp= empdao.retrieveByMail(email);
            if (emp.getEmployeeId()== 0)
            {
                response.setMessage("user not found");
                response.setStatus(false);
                response.setError("404");
                return response;
            }else
            {
                response.setMessage("Check Your Mail");
                response.setStatus(true);
                response.setError("200");
                SendMail send = new SendMail();
                send.sendmail(emp.getEmployeeEmail(),emp.getEmployeePassword());
                return response;
            }
    }
    
    
    
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

    
     @GET
    @Path("/get/company/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ArrayList<EmployeePojo> retriveEmployeesOfCompany(@PathParam("id") int id) {

        ArrayList<EmployeePojo> returnedEmp = new ArrayList<EmployeePojo>();

        try {
            returnedEmp = impl.selectAllEmployees(id);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeApiImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnedEmp;
    }
    
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public EmployeePojo retriveEmployee(@PathParam("id") int id) {
        EmployeePojo returnedEmp = new EmployeePojo();

        try {
            returnedEmp = impl.select(id);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeApiImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnedEmp;
    }
    
     @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage deleteEmployee(@PathParam("id") int employeeId
    ) {
        Boolean deleteStatus = false;
        ResponseMessage returnedResponse = new ResponseMessage();

        try {
            deleteStatus = impl.deleteEmployee(employeeId);
            if (deleteStatus) {
                returnedResponse.setError("No Error");
                returnedResponse.setMessage("Deletion Done");
                returnedResponse.setStatus(true);

            } else {
                returnedResponse.setError("Error");
                returnedResponse.setMessage("Error in Deletion");
                returnedResponse.setStatus(false);
            }

        } catch (Exception ex) {
            System.out.println("Errorrrrr at Delete @ api");
            returnedResponse.setError("Error");
            returnedResponse.setMessage("Error in Deletion");
            returnedResponse.setStatus(false);
        }

        return returnedResponse;
    }
    
    
     @PUT
    @Path("/put/{id}")
//    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Override
    public ResponseMessage updateEmployee(@PathParam("id") int employeeId,
            @FormParam("name") String name,
            @FormParam("mail") String mail,
            @FormParam("password") String password,
            @FormParam("address") String address,
            @FormParam("job") String job,
            @FormParam("company_id") int companyID,
            @FormParam("phone1") String phone1,
            @FormParam("phone2") String phone2,
            @FormParam("phone3") String phone3,
            @FormParam("employee_image") String employeeImage
    ) {

        ResponseMessage returnedResponse = new ResponseMessage();
        Boolean updateStatus = false;
        ArrayList<String> insertedPhones = new ArrayList<>();

        EmployeePojo updatedEmployee = new EmployeePojo();
        updatedEmployee.setEmployeeId(employeeId);
        updatedEmployee.setEmployeeName(name);
        updatedEmployee.setEmployeeEmail(mail);
        updatedEmployee.setEmployeeAddress(address);
        updatedEmployee.setEmployeeJob(job);
        updatedEmployee.setEmployeePassword(password);
        updatedEmployee.setCompanyCompanyId(companyID);

        if (!phone1.isEmpty()) {
            insertedPhones.add(phone1);
        }
        if (!phone2.isEmpty()) {
            insertedPhones.add(phone2);
        }
        if (!phone3.isEmpty()) {
            insertedPhones.add(phone3);
        }
        updatedEmployee.setEmployeePhones(insertedPhones);

        try {
            updateStatus = impl.update(updatedEmployee);

            if (updateStatus) {
                returnedResponse.setError("No Error");
                returnedResponse.setMessage("Update Done");
                returnedResponse.setStatus(true);

            } else {
                returnedResponse.setError("Error");
                returnedResponse.setMessage("Error in Update");
                returnedResponse.setStatus(false);
            }

        } catch (Exception ex) {

            returnedResponse.setError("Error");
            returnedResponse.setMessage("Error in Update");
            returnedResponse.setStatus(false);
            System.out.println("Errorrrrr at update api");
        }
        return returnedResponse;
    }
    
    @POST
    @Path("/insert")
   //  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage insertEmployee(@FormParam("name") String name, @FormParam("mail") String mail,
            @FormParam("password") String password, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3, @FormParam("address") String address, @FormParam("job") String job,
            @FormParam("employee_image") String employeeImage,@FormParam("company_id") int companyID) {

        ArrayList<String> insertedPhones = new ArrayList<>();
        Boolean checkInsertion = false;
        ResponseMessage returnedResponse = new ResponseMessage();
        EmployeePojo insertedEmployee = new EmployeePojo();

        insertedEmployee.setEmployeeName(name);
        insertedEmployee.setEmployeeEmail(mail);
        insertedEmployee.setEmployeeAddress(address);
        insertedEmployee.setEmployeeJob(job);
        insertedEmployee.setEmployeePassword(password);
        insertedEmployee.setCompanyCompanyId(companyID);
        insertedEmployee.setEmployeeImage(employeeImage);

        if (!phone1.isEmpty()) {
            insertedPhones.add(phone1);
        }
        if (!phone2.isEmpty()) {
            insertedPhones.add(phone2);
        }
        if (!phone3.isEmpty()) {
            insertedPhones.add(phone3);
        }
        insertedEmployee.setEmployeePhones(insertedPhones);

        try {
            checkInsertion = impl.insert(insertedEmployee);

            if (checkInsertion) {
                returnedResponse.setError("No Error");
                returnedResponse.setMessage("Insertion Done");
                returnedResponse.setStatus(true);

            } else {
                returnedResponse.setError("Error");
                returnedResponse.setMessage("Error in Insertion");
                returnedResponse.setStatus(false);
            }

        } catch (Exception ex) {
            System.out.println("Errorrrrr at insert api");
            returnedResponse.setError("Error");
            returnedResponse.setMessage("Error in Insertion");
            returnedResponse.setStatus(false);
        }
        //    list.add(insertedEmployee);
        //    System.out.println(list.get(0).getName());

        return returnedResponse;
    }
}