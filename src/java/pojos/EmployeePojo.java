/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Blob;
import java.util.ArrayList;

/**
 *
 * @author Hagar
 */
public class EmployeePojo {

    private int employeeId;
    private String employeeEmail;
    private String employeeName;
    private String employeeAddress;
    private String employeeJob;
    private String employeePassword;
    private String employeeImage;
    private int companyCompanyId;
    private ArrayList<String> employeePhones;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

   

    public void setCompanyCompanyId(int companyCompanyId) {
        this.companyCompanyId = companyCompanyId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }


    public int getCompanyCompanyId() {
        return companyCompanyId;
    }

    public ArrayList<String> getEmployeePhones() {
        return employeePhones;
    }

    public void setEmployeePhones(ArrayList<String> employeePhones) {
        this.employeePhones = employeePhones;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

}
