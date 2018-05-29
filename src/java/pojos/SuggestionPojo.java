/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;

/**
 *
 * @author Hagar
 */
public class SuggestionPojo {

    private int suggestId;
    private String description;
    private int medicalType;
    private Double Latitude;
    private Double Longitude;
    private String address;
    private String contactPhone;
    private String supervisor;
    private String date;
    private String medicalServiceNameAr;
    private String medicalServiceNameEn;
    private int employeeId;

    public int getSuggestId() {
        return suggestId;
    }

    public String getDescription() {
        return description;
    }

    public int getMedicalType() {
        return medicalType;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getDate() {
        return date;
    }

    public String getMedicalServiceNameAr() {
        return medicalServiceNameAr;
    }

    public String getMedicalServiceNameEn() {
        return medicalServiceNameEn;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setSuggestId(int suggestId) {
        this.suggestId = suggestId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMedicalType(int medicalType) {
        this.medicalType = medicalType;
    }

    public void setLatitude(Double Latitude) {
        this.Latitude = Latitude;
    }

    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMedicalServiceNameAr(String medicalServiceNameAr) {
        this.medicalServiceNameAr = medicalServiceNameAr;
    }

    public void setMedicalServiceNameEn(String medicalServiceNameEn) {
        this.medicalServiceNameEn = medicalServiceNameEn;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }



}
