/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.employee;

import dao.Interfaces.employee.EmployeeDaoInt;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.EmployeePojo;

/**
 *
 * @author Hagar
 */
public class EmployeeDaoImp implements EmployeeDaoInt{

    @Override
    public EmployeePojo retrieveByMailAndPassword(String mail, String password) {
        EmployeePojo employee = new EmployeePojo();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM employee WHERE employee_email='" + mail + "' AND employee_password = '" + password + "'");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                employee.setEmployeeId(retSet.getInt(1));
                employee.setEmployeeEmail(retSet.getString(2));
                employee.setEmployeeName(retSet.getString(3));
                employee.setEmployeeAddress(retSet.getString(4));
                employee.setEmployeeJob(retSet.getString(5));
                employee.setEmployeePassword(retSet.getString(6));
                employee.setCompanyCompanyId(retSet.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            employee = null;
            System.out.println("NOT FOUND ");     
        }
        return employee;
    }

    @Override
    public EmployeePojo retrieveByMail(String mail) {
        EmployeePojo employee = new EmployeePojo();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM employee WHERE employee_email='" + mail+"'");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                employee.setEmployeeId(retSet.getInt(1));
                employee.setEmployeeEmail(retSet.getString(2));
                employee.setEmployeeName(retSet.getString(3));
                employee.setEmployeeAddress(retSet.getString(4));
                employee.setEmployeeJob(retSet.getString(5));
                employee.setEmployeePassword(retSet.getString(6));
                employee.setCompanyCompanyId(retSet.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            employee = null;
            System.out.println("NOT FOUND ");     
        }
        return employee;
    }
    
}
