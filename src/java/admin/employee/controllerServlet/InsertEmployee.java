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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.EmployeePojo;
import pojos.ResponseMessage;

/**
 *
 * @author Mayada Saleh
 */
public class InsertEmployee extends HttpServlet {

    private EmployeeApiImp employeeImpl;

    @Override

    public void init() {

        employeeImpl = new EmployeeApiImp();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        //ResponseMessage returnedResponse = new ResponseMessage();
      //  returnedResponse = employeeImpl.insertEmployee(newEmployee);

      //  if (returnedResponse.getStatus()) {

            System.out.println("user inserted successfully");
           
          
            response.sendRedirect("http://localhost:8084/MedicalInsuranceSystem/api/version1/user/insertEmployee");
            
            
          //  RequestDispatcher disp = request.getRequestDispatcher("http://localhost:8084/MedicalInsuranceSystem/api/version1/user/getEmployee/employeeID=3");
          //  disp.forward(request, response);
           // response.sendRedirect("HomeServlet");
        //} else {
            System.out.println("error in insertimg user");

        //}

    }
}
