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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.EmployeePojo;

/**
 *
 * @author Hagar
 */

public class EmployeeDaoImp implements EmployeeDaoInt{

    
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pstSelect = null;
    ArrayList<String> employeePhones;
    
    
    
    
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
 
    
    ////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    @Override
    public ArrayList<EmployeePojo> selectAllEmployees(int id) throws SQLException {

        ArrayList<EmployeePojo> allEmployee = new ArrayList<>();
        EmployeePojo retrievedUser = null;
        ArrayList<Integer> employeeIDS = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM employee WHERE company_company_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                employeeIDS.add(rs.getInt(1));

                retrievedUser = new EmployeePojo();
                retrievedUser.setEmployeeId(rs.getInt(1));
                retrievedUser.setEmployeeEmail(rs.getString(2));
                retrievedUser.setEmployeeName(rs.getString(3));
                retrievedUser.setEmployeeAddress(rs.getString(4));
                retrievedUser.setEmployeeJob(rs.getString(5));
                retrievedUser.setEmployeePassword(rs.getString(6));
                retrievedUser.setEmployeeImage(rs.getString(7));
                retrievedUser.setCompanyCompanyId(rs.getInt(8));

                allEmployee.add(retrievedUser);
            }

            for (int i = 0; i < employeeIDS.size(); i++) {
                pst2 = con.prepareStatement("SELECT * FROM employee_phone WHERE employee_employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pst2.setInt(1, employeeIDS.get(i));
                rs2 = pst2.executeQuery();
                employeePhones = new ArrayList<>();

                while (rs2.next()) {
                    employeePhones.add(rs2.getString(1));
                }
                allEmployee.get(i).setEmployeePhones(employeePhones);
            }

            return allEmployee;

        } catch (Exception ex) {
            System.out.println("Selection Error");
        }
        return null;

    }


@Override
    public EmployeePojo select(int id) throws SQLException {
        employeePhones = new ArrayList<>();
        EmployeePojo retrievedUser = null;

        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM employee WHERE employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, id);
            rs = pst.executeQuery();
            // retrievedUser.setPhones(employeePhones);

            while (rs.next()) {
                retrievedUser = new EmployeePojo();
                retrievedUser.setEmployeeId(rs.getInt(1));
                retrievedUser.setEmployeeEmail(rs.getString(2));
                retrievedUser.setEmployeeName(rs.getString(3));
                retrievedUser.setEmployeeAddress(rs.getString(4));
                retrievedUser.setEmployeeJob(rs.getString(5));
                retrievedUser.setEmployeePassword(rs.getString(6));
                retrievedUser.setEmployeeImage(rs.getString(7));
                retrievedUser.setCompanyCompanyId(rs.getInt(8));
            }

            System.out.println("iddddddddd" + id);
            pst2 = con.prepareStatement("SELECT * FROM employee_phone WHERE employee_employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst2.setInt(1, id);
            rs2 = pst2.executeQuery();
            //     System.out.println("phonessss" + rs2.getString(1));

            while (rs2.next()) {
                employeePhones.add(rs2.getString(1));
            }
            retrievedUser.setEmployeePhones(employeePhones);

        } catch (Exception ex) {
            System.out.println("Selection Error");
        }
        return retrievedUser;

    }    
    
    
    
    @Override
    public boolean deleteEmployee(int employeeId) throws SQLException {

        try {
            con = DBConnection.getConnection();

            pst2 = con.prepareStatement("DELETE FROM EMPLOYEE_PHONE where employee_employee_id = ?");
            pst2.setInt(1, employeeId);
            pst2.executeUpdate();

            pst = con.prepareStatement("DELETE FROM EMPLOYEE where employee_id = ?");
            pst.setInt(1, employeeId);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Employee delete error ");
            return false;

        }
    }

    
    
    @Override
    public boolean update(EmployeePojo emp) throws SQLException {

        try {

            con = DBConnection.getConnection();

            pst2 = con.prepareStatement("DELETE FROM EMPLOYEE_PHONE where employee_employee_id = ?");
            pst2.setInt(1, emp.getEmployeeId());
            pst2.executeUpdate();

            for (int i = 0; i < emp.getEmployeePhones().size(); i++) {
                System.out.println("start for");
                pst2 = con.prepareStatement("INSERT INTO employee_phone"
                        + "(phone,employee_employee_id)"
                        + " VALUES(?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pst2.setInt(2, emp.getEmployeeId());
                pst2.setString(1, emp.getEmployeePhones().get(i));
                pst2.executeUpdate();

            }

            pst = con.prepareStatement("UPDATE employee SET employee_email = ?, employee_name = ?,employee_address = ?,employee_job= ?, employee_password = ?,employee_image= ?, company_company_id = ? WHERE employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            System.out.println("namee" + emp.getEmployeeName());
            System.out.println("mail" + emp.getEmployeeEmail());

            pst.setString(1, emp.getEmployeeEmail());
            pst.setString(2, emp.getEmployeeName());
            pst.setString(3, emp.getEmployeeAddress());
            pst.setString(4, emp.getEmployeeJob());
            pst.setString(5, emp.getEmployeePassword());
            pst.setString(6, emp.getEmployeeImage());
            pst.setInt(7, emp.getCompanyCompanyId());
            pst.setInt(8, emp.getEmployeeId());

            pst.executeUpdate();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    @Override
    public boolean insert(EmployeePojo emp) throws SQLException {

        try {
            con = DBConnection.getConnection();
            // Employee Insertion
            pst = con.prepareStatement("INSERT INTO EMPLOYEE"
                    + "(employee_email,employee_name,employee_address,employee_job,employee_password,employee_image,company_company_id)"
                    + " VALUES(?,?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, emp.getEmployeeEmail());
            pst.setString(2, emp.getEmployeeName());
            pst.setString(3, emp.getEmployeeAddress());
            pst.setString(4, emp.getEmployeeJob());
            pst.setString(5, emp.getEmployeePassword());
            pst.setString(6, emp.getEmployeeImage());
            pst.setInt(7, emp.getCompanyCompanyId());
            pst.executeUpdate();

            // To Get Employee ID
            pstSelect = con.prepareStatement("SELECT * FROM employee WHERE employee_email = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstSelect.setString(1, emp.getEmployeeEmail());
            rs = pstSelect.executeQuery();
            int employeeID = 0;
            while (rs.next()) {
                employeeID = rs.getInt(1);
            }

            System.out.println("number phonesssss " + emp.getEmployeePhones().size());
            //Employee Phone Insertion
            for (int i = 0; i < emp.getEmployeePhones().size(); i++) {
                System.out.println("start for");
                pst2 = con.prepareStatement("INSERT INTO employee_phone"
                        + "(phone,employee_employee_id)"
                        + " VALUES(?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pst2.setInt(2, employeeID);
                pst2.setString(1, emp.getEmployeePhones().get(i));
                pst2.executeUpdate();
                System.out.println("counter" + i);
                System.out.println("end for");
            }

            return true;
        } catch (Exception ex) {
            System.out.println("Insertion Error");
            return false;
        }

    }

}
