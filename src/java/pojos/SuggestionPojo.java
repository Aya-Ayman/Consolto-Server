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
    private String suggestText;
    private int suggestMedicalType;
    private Double suggestLocationLatitude;
    private Double suggestLocationLongitude;
    private String locationAddress;
    private String suggestContactPhone;
    private String suggestSupervisor;
    private Date suggestDate;
    private String medicalServiceNameAr;
    private String medicalServiceNameEn;
    private int employeeEmployeeId;

    public void setSuggestId(int suggestId) {
        this.suggestId = suggestId;
    }

    public void setSuggestText(String suggestText) {
        this.suggestText = suggestText;
    }

    public void setSuggestMedicalType(int suggestMedicalType) {
        this.suggestMedicalType = suggestMedicalType;
    }

    public void setSuggestLocationLatitude(Double suggestLocationLatitude) {
        this.suggestLocationLatitude = suggestLocationLatitude;
    }

    public void setSuggestLocationLongitude(Double suggestLocationLongitude) {
        this.suggestLocationLongitude = suggestLocationLongitude;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void setSuggestContactPhone(String suggestContactPhone) {
        this.suggestContactPhone = suggestContactPhone;
    }

    public void setSuggestSupervisor(String suggestSupervisor) {
        this.suggestSupervisor = suggestSupervisor;
    }

    public void setSuggestDate(Date suggestDate) {
        this.suggestDate = suggestDate;
    }

    public void setMedicalServiceNameAr(String medicalServiceNameAr) {
        this.medicalServiceNameAr = medicalServiceNameAr;
    }

    public void setMedicalServiceNameEn(String medicalServiceNameEn) {
        this.medicalServiceNameEn = medicalServiceNameEn;
    }

    public void setEmployeeEmployeeId(int employeeEmployeeId) {
        this.employeeEmployeeId = employeeEmployeeId;
    }

    public int getSuggestId() {
        return suggestId;
    }

    public String getSuggestText() {
        return suggestText;
    }

    public int getSuggestMedicalType() {
        return suggestMedicalType;
    }

    public Double getSuggestLocationLatitude() {
        return suggestLocationLatitude;
    }

    public Double getSuggestLocationLongitude() {
        return suggestLocationLongitude;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getSuggestContactPhone() {
        return suggestContactPhone;
    }

    public String getSuggestSupervisor() {
        return suggestSupervisor;
    }

    public Date getSuggestDate() {
        return suggestDate;
    }

    public String getMedicalServiceNameAr() {
        return medicalServiceNameAr;
    }

    public String getMedicalServiceNameEn() {
        return medicalServiceNameEn;
    }

    public int getEmployeeEmployeeId() {
        return employeeEmployeeId;
    }

}
