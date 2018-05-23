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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}