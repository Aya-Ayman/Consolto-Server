/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.employee.controllerServlet;

import api.implementation.EmployeeApiImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.EmployeeListObject;

/**
 *
 * @author Mayada Saleh
 */
public class GetCompanyEmployees extends HttpServlet {

    private EmployeeApiImp employeeImpl;

    @Override

    public void init() {

        employeeImpl = new EmployeeApiImp();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        EmployeeListObject empList = mapper.readValue(new URL("http://localhost:8084/MedicalInsuranceSystem/api/version1/user/getEmployees/companyID=1"), EmployeeListObject.class);
        System.out.println("empListttt = " + empList.getEmployeeListObject().get(0).getEmail());
        if (empList != null) {
            
            request.setAttribute("employeeList", empList.getEmployeeListObject().get(0));
            request.getRequestDispatcher("showCompanyEmployees.jsp").forward(request, response);
       
        } else {
            System.out.println("Company don't have employees");
        }

//        EmployeeListObject returnedEmployees = new EmployeeListObject();
//
//        returnedEmployees = employeeImpl.retriveEmployeesOfCompany(Integer.parseInt(request.getParameter("companyId")));
//
//
//        
//        if (returnedEmployees.getEmployeeListObject().get(0).getEmail() != null) {
//            System.out.println("Get Employee List successs");
//            response.sendRedirect("EmployeeListOfCompany");
//        } else {
//            System.out.println("Error at Select employee List");
//        }
    }

}
