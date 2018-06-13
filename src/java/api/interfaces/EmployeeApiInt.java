/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.sql.Blob;
import java.util.ArrayList;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import org.codehaus.jettison.json.JSONObject;
import pojos.EmployeeListObject;
import pojos.EmployeePojo;
import pojos.ResponseMessage;
import pojos.ResponseMessageWithEmployee;
import pojos.ResponseMessageWithId;

/**
 *
 * @author hoda.CO
 */
public interface EmployeeApiInt {

    public ResponseMessageWithId login(JSONObject login);

    public ResponseMessage getEmp(JSONObject mail);

///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    public EmployeeListObject retriveEmployeesOfCompany(@PathParam("id") int id);

    public ResponseMessageWithEmployee retriveEmployee(@PathParam("id") int id);

    public ResponseMessage deleteEmployee(@PathParam("id") int employeeId);

    public ResponseMessageWithEmployee updateEmployee(EmployeePojo employeeObject);

    public ResponseMessage insertEmployee(EmployeePojo employeeObject);

}
