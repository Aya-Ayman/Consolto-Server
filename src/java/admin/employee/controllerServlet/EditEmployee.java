/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.employee.controllerServlet;

import api.implementation.EmployeeApiImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.EmployeePojo;
import pojos.ResponseMessageWithEmployee;














//
//import org.apache.http.*;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.*;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.InputStreamEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;




/**
 *
 * @author Mayada Saleh
 */
public class EditEmployee extends HttpServlet {

    private EmployeeApiImp employeeImpl;

    @Override

    public void init() {

        employeeImpl = new EmployeeApiImp();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       
        
       
//   String url="http://your.server.com/path/to/app?par1=yxc&par2=abc";
//   HttpGet get=new HttpGet(url);
//   httpClient = HttpClients.createDefault();
//   // optional configuration
//   RequestConfig config=RequestConfig.custom().setSocketTimeout(socketTimeoutSec * 1000).build();
//    // more configuration
//
//    get.setConfig(config);
//
//    CloseableHttpResponse internResponse = httpClient.execute(get);
//
//    int internResponseStatus = internResponse.getStatusLine().getStatusCode();
//
//    InputStream respIn = internResponseEntity.getContent();
//    String contentType = internResponseEntity.getContentType().getValue();
//
//    // consume the response
//        
//        
        
     



        
        Integer employeeID = Integer.valueOf(request.getParameter("employeeId"));
        String employeeName = request.getParameter("name");
        String employeeEmail = request.getParameter("mail");
        String employeepassword = request.getParameter("password");
        String employeePhone1 = request.getParameter("phone1");
        String employeephone2 = request.getParameter("phone2");
        String employeePhone3 = request.getParameter("phone3");
        String employeeStartDate = request.getParameter("start_date");
        String employeeEndDate = request.getParameter("end_date");
        String employeeaddress = request.getParameter("address");
        String employeeJob = request.getParameter("job");
        Integer employeeCompanyID = Integer.valueOf(request.getParameter("company_id"));
        String employeeImageURL = request.getParameter("urlImage");
        Float employeePackageType = Float.valueOf(request.getParameter("packageType"));

        ArrayList<String> phones = new ArrayList<>();
        phones.add(employeePhone1);
        phones.add(employeephone2);
        phones.add(employeePhone3);

        System.out.println(employeeName);

        EmployeePojo newEmployee = new EmployeePojo();

        newEmployee.setEmail(employeeEmail);
        newEmployee.setName(employeeName);
        newEmployee.setPassword(employeepassword);
        newEmployee.setPhones(phones);
        newEmployee.setStartDate(employeeStartDate);
        newEmployee.setEndDate(employeeEndDate);
        newEmployee.setAddress(employeeaddress);
        newEmployee.setJob(employeeJob);
        newEmployee.setCompanyId(employeeCompanyID);
        newEmployee.setImage(employeeImageURL);
        newEmployee.setPackageType(employeePackageType);

        HttpSession userSession2 = request.getSession();

        EmployeePojo l = (EmployeePojo) userSession2.getAttribute("logedInUser");
        ResponseMessageWithEmployee returnedResponse = new ResponseMessageWithEmployee();
       
        
        returnedResponse = employeeImpl.updateEmployee(newEmployee);

        
        
        if (returnedResponse.getResponseMessage().getStatus()) {

            System.out.println("user updated successfully");
            response.sendRedirect("HomeServlet");

        } else {
            System.out.println("error in update user");

        }

    }
}
