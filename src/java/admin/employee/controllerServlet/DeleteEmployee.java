/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.employee.controllerServlet;

import api.implementation.EmployeeApiImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.ResponseMessage;

/**
 *
 * @author Mayada Saleh
 */
public class DeleteEmployee extends HttpServlet {

    private EmployeeApiImp employeeImpl;

    @Override

    public void init() {

        employeeImpl = new EmployeeApiImp();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResponseMessage returnedResponse = new ResponseMessage();

        returnedResponse = employeeImpl.deleteEmployee(Integer.parseInt(request.getParameter("employeeId")));

        if (returnedResponse.getStatus()) {
            System.out.println("deleted successs");
            response.sendRedirect("HomeServlet");
        } else {
            System.out.println("Error at delete employee");
        }
    }

}
