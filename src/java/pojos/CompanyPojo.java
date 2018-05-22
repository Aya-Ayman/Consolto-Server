/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Hagar
 */
public class CompanyPojo {

    private int companyId;
    private String companyEmail;
    private Double companyLatitude;
    private Double companyLongitude;
    private String companyAddress;
    private Float companyPackageType;
    private String companyName;
    private Date companyStartDate;
    private Date companyEndDate;
    private String companyCeo;
    private int medicalInsuranceInsuranceId;
    private ArrayList<String> companyPhones;

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public Double getCompanyLatitude() {
        return companyLatitude;
    }

    public Double getCompanyLongitude() {
        return companyLongitude;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public Float getCompanyPackageType() {
        return companyPackageType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getCompanyStartDate() {
        return companyStartDate;
    }

    public Date getCompanyEndDate() {
        return companyEndDate;
    }

    public String getCompanyCeo() {
        return companyCeo;
    }

    public int getMedicalInsuranceInsuranceId() {
        return medicalInsuranceInsuranceId;
    }

    public ArrayList<String> getCompanyPhones() {
        return companyPhones;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public void setCompanyLatitude(Double companyLatitude) {
        this.companyLatitude = companyLatitude;
    }

    public void setCompanyLongitude(Double companyLongitude) {
        this.companyLongitude = companyLongitude;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setCompanyPackageType(Float companyPackageType) {
        this.companyPackageType = companyPackageType;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyStartDate(Date companyStartDate) {
        this.companyStartDate = companyStartDate;
    }

    public void setCompanyEndDate(Date companyEndDate) {
        this.companyEndDate = companyEndDate;
    }

    public void setCompanyCeo(String companyCeo) {
        this.companyCeo = companyCeo;
    }

    public void setMedicalInsuranceInsuranceId(int medicalInsuranceInsuranceId) {
        this.medicalInsuranceInsuranceId = medicalInsuranceInsuranceId;
    }

    public void setCompanyPhones(ArrayList<String> companyPhones) {
        this.companyPhones = companyPhones;
    }
    

}
