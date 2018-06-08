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

    public ResponseMessageWithEmployee updateEmployee(@PathParam("id") int employeeId,
            @FormParam("name") String name,
            @FormParam("mail") String mail,
            @FormParam("password") String password,
            @FormParam("address") String address,
            @FormParam("job") String job,
            @FormParam("company_id") int companyID,
            @FormParam("phone1") String phone1,
            @FormParam("phone2") String phone2,
            @FormParam("phone3") String phone3,
            @FormParam("startDate") String startDate,
            @FormParam("endDate") String endDate,
            @FormParam("urlImage") String employeeImage,
            @FormParam("packageType") float packageType
    );

    public ResponseMessage insertEmployee(@FormParam("name") String name, @FormParam("mail") String mail,
            @FormParam("password") String password, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3, @FormParam("address") String address, @FormParam("job") String job,
            @FormParam("company_id") int companyID, @FormParam("startDate") String startDate,
            @FormParam("endDate") String endDate,
            @FormParam("packageType") float packageType, @FormParam("urlImage") String urlImage);

}
