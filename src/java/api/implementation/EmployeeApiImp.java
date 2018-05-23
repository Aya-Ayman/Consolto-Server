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
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.EmployeePojo;
import pojos.ResponseMessage;
import pojos.ResponseMessageWithId;

/**
 *
 * @author hoda.CO
 */
@Path("/user")
public class EmployeeApiImp implements EmployeeApiInt {
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessageWithId login(@FormParam("name")String mail,@FormParam("number")String password){
        ResponseMessageWithId response = new ResponseMessageWithId();
        EmployeePojo emp;
       EmployeeDaoInt empdao=new EmployeeDaoImp();
       emp= empdao.retrieveByMailAndPassword(mail, password);
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage getEmp(@FormParam("name")String mail) {
    
    
        ResponseMessage response = new ResponseMessage();
        EmployeePojo emp;
       EmployeeDaoInt empdao=new EmployeeDaoImp();
       emp= empdao.retrieveByMail(mail);
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
}