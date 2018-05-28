/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hagar
 */
public class CompanyPojo {

    private int id;
    private String email;
    private Double latitude;
    private Double longitude;
    private String address;
    private Float packageType;
    private String name;
    private String startDate;
    private String endDate;
    private String ceo;
    private int medicalInsuranceId;
    private ArrayList<String> phones;

     public CompanyPojo(String companyName, String companyEmail, double companyLatitude, double companyLongitude, String companyAddress, float companyPackage, String companyStartDate, String companyEndDate, String companyCEO, int insuranceId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.latitude = latitude;
        this.longitude = companyLongitude;
        this.address = companyAddress;
        this.packageType = companyPackage;
        this.startDate = companyStartDate;
        this.endDate = companyEndDate;
        this.ceo = companyCEO;
        this.medicalInsuranceId = insuranceId;
    }

    public CompanyPojo(int companyId, String companyName, String companyEmail, double companyLatitude, double companyLongitude, String companyAddress, float companyPackage, String companyStartDate, String companyEndDate, String companyCEO, int insuranceId, List<String> companyPhone) {
        this.id = companyId;
        this.name = companyName;
        this.email = companyEmail;
        this.latitude = companyLatitude;
        this.longitude = companyLongitude;
        this.address= companyAddress;
        this.packageType = companyPackage;
        this.startDate = companyStartDate;
        this.endDate = companyEndDate;
        this.ceo = companyCEO;
        this.medicalInsuranceId = insuranceId;
        this.phones = (ArrayList<String>) companyPhone;
    }

    public CompanyPojo (int companyId, String companyName, String companyEmail, double companyLatitude, double companyLongitude, String companyAddress, float companyPackage, String companyStartDate, String companyEndDate, String companyCEO, int insuranceId) {
        this.id = companyId;
        this.name = companyName;
        this.email = companyEmail;
        this.latitude = companyLatitude;
        this.longitude = companyLongitude;
        this.address = companyAddress;
        this.packageType = companyPackage;
        this.startDate = companyStartDate;
        this.endDate = companyEndDate;
        this.ceo = companyCEO;
        this.medicalInsuranceId = insuranceId;
    }

    public CompanyPojo (String name, String email, double latitude, double longitude, String address, float companyPackage, String startDate, String endDate, String ceo, int insuranceId, List companyPhone) {
        this.name = name;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.packageType = companyPackage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ceo = ceo;
        this.medicalInsuranceId = insuranceId;
        this.phones = (ArrayList<String>) companyPhone;
    }

    public CompanyPojo () { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPackageType() {
        return packageType;
    }

    public void setPackageType(Float packageType) {
        this.packageType = packageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public int getMedicalInsuranceId() {
        return medicalInsuranceId;
    }

    public void setMedicalInsuranceId(int medicalInsuranceId) {
        this.medicalInsuranceId = medicalInsuranceId;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }
    
    
   

}
