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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.EmployeePojo;
import pojos.ResponseMessage;
import pojos.ResponseMessageWithEmployee;

/**
 *
 * @author Hagar
 */
public class EmployeeDaoImp implements EmployeeDaoInt {

    Connection con = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pstSelect = null;
    ArrayList<String> employeePhones;

    public void upload() {

        try {
            con = DBConnection.getConnection();

            System.out.println("in upload db");

            pst = con.prepareStatement("LOAD DATA LOCAL INFILE 'C:\\Users\\Aya\\Desktop\\empp.csv' INTO TABLE medical_insurance_database.employee FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n"
                    + "' IGNORE 1 LINES (employee_id,employee_email,employee_name, employee_address, employee_job, employee_password,employee_image,employee_startdate,employee_enddate,employee_packagetype,company_company_id)");
            pst.executeUpdate();
            System.out.println(pst);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    
    
    
    @Override
    public EmployeePojo retrieveByMailAndPassword(String mail, String password) {
        EmployeePojo employee = new EmployeePojo();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM employee WHERE employee_email='" + mail + "' AND employee_password = '" + password + "'");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                employee.setId(retSet.getInt(1));
                employee.setEmail(retSet.getString(2));
                employee.setName(retSet.getString(3));
                employee.setAddress(retSet.getString(4));
                employee.setJob(retSet.getString(5));
                employee.setPassword(retSet.getString(6));
                employee.setImage(retSet.getString(7));
                employee.setStartDate(retSet.getString(8));
                employee.setEndDate(retSet.getString(9));
                employee.setPackageType(retSet.getFloat(10));
                employee.setCompanyId(retSet.getInt(11));
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
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM employee WHERE employee_email='" + mail + "'");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                employee.setId(retSet.getInt(1));
                employee.setEmail(retSet.getString(2));
                employee.setName(retSet.getString(3));
                employee.setAddress(retSet.getString(4));
                employee.setJob(retSet.getString(5));
                employee.setPassword(retSet.getString(6));
                employee.setImage(retSet.getString(7));
                employee.setStartDate(retSet.getString(8));
                employee.setEndDate(retSet.getString(9));
                employee.setPackageType(retSet.getFloat(10));
                employee.setCompanyId(retSet.getInt(11));
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
                retrievedUser.setId(rs.getInt(1));
                retrievedUser.setEmail(rs.getString(2));
                retrievedUser.setName(rs.getString(3));
                retrievedUser.setAddress(rs.getString(4));
                retrievedUser.setJob(rs.getString(5));
                retrievedUser.setPassword(rs.getString(6));
                retrievedUser.setImage(rs.getString(7));
                retrievedUser.setStartDate(rs.getString(8));
                retrievedUser.setEndDate(rs.getString(9));
                retrievedUser.setPackageType(rs.getFloat(10));
                retrievedUser.setCompanyId(rs.getInt(11));
                employeePhones = new ArrayList<>();
                employeePhones.add(rs.getString(12));
                retrievedUser.setPhones(employeePhones);
                allEmployee.add(retrievedUser);
            }

//            for (int i = 0; i < employeeIDS.size(); i++) {
//                pst2 = con.prepareStatement("SELECT * FROM employee_phone WHERE employee_employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                pst2.setInt(1, employeeIDS.get(i));
//                rs2 = pst2.executeQuery();
//                employeePhones = new ArrayList<>();
//
//                while (rs2.next()) {
//                    employeePhones.add(rs2.getString(1));
//                }
//                allEmployee.get(i).setPhones(employeePhones);
//            }

            return allEmployee;

        } catch (Exception ex) {
            System.out.println("Selection Error");
        }
        return null;

    }

    @Override
    public ResponseMessageWithEmployee select(int id) throws SQLException {

        ResponseMessageWithEmployee allResponse = new ResponseMessageWithEmployee();
        ResponseMessage reponseMessage = new ResponseMessage();

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
                retrievedUser.setId(rs.getInt(1));
                retrievedUser.setEmail(rs.getString(2));
                retrievedUser.setName(rs.getString(3));
                retrievedUser.setAddress(rs.getString(4));
                retrievedUser.setJob(rs.getString(5));
                retrievedUser.setPassword(rs.getString(6));
                retrievedUser.setImage(rs.getString(7));
                retrievedUser.setStartDate(rs.getString(8));
                retrievedUser.setEndDate(rs.getString(9));
                retrievedUser.setPackageType(rs.getFloat(10));
                retrievedUser.setCompanyId(rs.getInt(11));
                 employeePhones.add(rs.getString(12));
                retrievedUser.setPhones(employeePhones);
            }

//            pst2 = con.prepareStatement("SELECT * FROM employee_phone WHERE employee_employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            pst2.setInt(1, id);
//            rs2 = pst2.executeQuery();
//
//            while (rs2.next()) {
//                employeePhones.add(rs2.getString(1));
//            }
//            retrievedUser.setPhones(employeePhones);
            allResponse.setEmployeePojo(retrievedUser);

            reponseMessage.setMessage("ReturnedEmployee");
            reponseMessage.setError("0");
            reponseMessage.setStatus(true);
            allResponse.setResponseMessage(reponseMessage);
        } catch (Exception ex) {

            reponseMessage.setMessage("NotReturnedEmployee");
            reponseMessage.setError("1");
            reponseMessage.setStatus(false);
            allResponse.setResponseMessage(reponseMessage);

            System.out.println("Selection Error");
        }

        return allResponse;

    }

    @Override
    public boolean deleteEmployee(int employeeId) throws SQLException {

        ArrayList<Integer> employeeIDS = new ArrayList<>();
        PreparedStatement pstSuggestion = null;
        PreparedStatement pstReviews = null;

        try {
            con = DBConnection.getConnection();

            pst = con.prepareStatement("SELECT * FROM employee WHERE employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, employeeId);
            rs = pst.executeQuery();

            while (rs.next()) {
                employeeIDS.add(rs.getInt(1));
            }
            if (employeeIDS.size() == 0) {
                return false;
            } else {
                pst2 = con.prepareStatement("DELETE FROM EMPLOYEE_PHONE where employee_employee_id = ?");
                pst2.setInt(1, employeeId);
               pst2.executeUpdate();

                pstSuggestion = con.prepareStatement("DELETE FROM medical_insurance_suggestion where employee_employee_id = ?");
                pstSuggestion.setInt(1, employeeId);
                pstSuggestion.executeUpdate();

                pstReviews = con.prepareStatement("DELETE FROM reviews where employee_employee_id = ?");
                pstReviews.setInt(1, employeeId);
                pstReviews.executeUpdate();

                pst = con.prepareStatement("DELETE FROM EMPLOYEE where employee_id = ?");
                pst.setInt(1, employeeId);
                pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Employee delete error");
            return false;

        }
    }

    @Override
    public ResponseMessageWithEmployee update(EmployeePojo emp) throws SQLException {

        ResponseMessageWithEmployee allResponse = new ResponseMessageWithEmployee();
        ResponseMessage reponseMessage = new ResponseMessage();

        try {

            con = DBConnection.getConnection();

//            pst2 = con.prepareStatement("DELETE FROM EMPLOYEE_PHONE where employee_employee_id = ?");
//            pst2.setInt(1, emp.getId());
//            pst2.executeUpdate();
//
//            for (int i = 0; i < emp.getPhones().size(); i++) {
//                System.out.println("start for");
//                pst2 = con.prepareStatement("INSERT INTO employee_phone"
//                        + "(phone,employee_employee_id)"
//                        + " VALUES(?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                pst2.setInt(2, emp.getId());
//                pst2.setString(1, emp.getPhones().get(i));
//                pst2.executeUpdate();
//
//            }

            pst = con.prepareStatement("UPDATE employee SET employee_email = ?, employee_name = ?, employee_address = ?, employee_job= ?, employee_password = ?,  employee_image = ?, employee_startdate = ?, employee_enddate = ?, employee_packagetype = ?, company_company_id = ?, employee_phone_inside = ? WHERE employee_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, emp.getEmail());
            pst.setString(2, emp.getName());
            pst.setString(3, emp.getAddress());
            pst.setString(4, emp.getJob());
            pst.setString(5, emp.getPassword());
            pst.setString(6, emp.getImage());
            pst.setString(7, emp.getStartDate());
            pst.setString(8, emp.getEndDate());
            pst.setFloat(9, emp.getPackageType());
            pst.setInt(10, emp.getCompanyId());
            pst.setInt(12, emp.getId());
            pst.setString(11,emp.getPhones().get(0));
            System.out.println(pst);
            pst.executeUpdate();

            allResponse.setEmployeePojo(emp);

            reponseMessage.setMessage("UpdatedEmployeeSuccessfully");
            reponseMessage.setError("0");
            reponseMessage.setStatus(true);

            allResponse.setResponseMessage(reponseMessage);
        } catch (Exception ex) {

            reponseMessage.setMessage("FailedToUpdateEmployee");
            reponseMessage.setError("1");
            reponseMessage.setStatus(false);
            allResponse.setResponseMessage(reponseMessage);
        }
        return allResponse;
    }

    @Override
    public boolean insert(EmployeePojo emp) throws SQLException {

        try {
            con = DBConnection.getConnection();
            // Employee Insertion
            pst = con.prepareStatement("INSERT INTO EMPLOYEE"
                    + "(employee_email,employee_name,employee_address,employee_job,employee_password,employee_image,employee_startdate,employee_enddate,employee_packagetype,company_company_id,employee_phone_inside)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, emp.getEmail());
            pst.setString(2, emp.getName());
            pst.setString(3, emp.getAddress());
            pst.setString(4, emp.getJob());
            pst.setString(5, emp.getPassword());
            pst.setString(6, emp.getImage());
            pst.setString(7, emp.getStartDate());
            pst.setString(8, emp.getEndDate());
            pst.setFloat(9, emp.getPackageType());
            pst.setInt(10, emp.getCompanyId());
            pst.setString(11,emp.getPhones().get(0));
            pst.executeUpdate();

//            // To Get Employee ID
//            pstSelect = con.prepareStatement("SELECT * FROM employee WHERE employee_email = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            pstSelect.setString(1, emp.getEmail());
//            rs = pstSelect.executeQuery();
//            int employeeID = 0;
//            while (rs.next()) {
//                employeeID = rs.getInt(1);
//            }
//
//            System.out.println("number phonesssss " + emp.getPhones().size());
//            //Employee Phone Insertion
//            for (int i = 0; i < emp.getPhones().size(); i++) {
//                System.out.println("start for");
//                pst2 = con.prepareStatement("INSERT INTO employee_phone"
//                        + "(phone,employee_employee_id)"
//                        + " VALUES(?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                pst2.setInt(2, employeeID);
//                pst2.setString(1, emp.getPhones().get(i));
//                pst2.executeUpdate();
//                System.out.println("counter" + i);
//                System.out.println("end for");
//            }

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public void upload(String path) {

        try {
            con = DBConnection.getConnection();

            System.out.println("in upload db");

            pst = con.prepareStatement("LOAD DATA LOCAL INFILE '"+ path +"' INTO TABLE medical_insurance_database.employee FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n"
                    + "' IGNORE 1 LINES (employee_id,employee_email,employee_name, employee_address, employee_job, employee_password,employee_image,employee_startdate,employee_enddate,employee_packagetype,company_company_id,employee_phone_inside)");
            pst.executeUpdate();
            System.out.println(pst);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

}
