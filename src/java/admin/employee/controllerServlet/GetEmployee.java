/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.employee.controllerServlet;

import api.implementation.EmployeeApiImp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.EmployeeListObject;
import pojos.EmployeePojo;
import pojos.ResponseMessageWithEmployee;

/**
 *
 * @author Mayada Saleh
 */
public class GetEmployee extends HttpServlet {

//    private EmployeeApiImp employeeImpl;
//
//    @Override
//
//    public void init() {
//
//        employeeImpl = new EmployeeApiImp();
//
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//
//        ResponseMessageWithEmployee returnedResponse = new ResponseMessageWithEmployee();
//
//      
//        Integer idd = Integer.parseInt(request.getParameter("employeeId"));
//        System.out.println("hhhhhhhhhhhhhhhhh"+idd);
//        

        ObjectMapper mapper = new ObjectMapper();
        ResponseMessageWithEmployee empPojo = mapper.readValue(new URL("http://localhost:8084/MedicalInsuranceSystem/api/version1/user/getEmployee/employeeID=3"), ResponseMessageWithEmployee.class);
        System.out.println("empPojooo = " + empPojo.getEmployeePojo().getEmail());

        if (empPojo.getResponseMessage().getStatus()){
        request.setAttribute("employeePojo", empPojo.getEmployeePojo());
        request.getRequestDispatcher("showEmployee.jsp").forward(request, response);
        }
        else{
            System.out.println("Error in reterieve employee");
        }

        //  response.sendRedirect("http://localhost:8084/MedicalInsuranceSystem/api/version1/user/getEmployee/employeeID=idd");
//        if (returnedResponse.getResponseMessage().getStatus()) {
//            System.out.println("Get Employee successs");
//            response.sendRedirect("EmployeeProfile");
//        } else {
//            System.out.println("Error at Select employee");
//        }
    }

}
