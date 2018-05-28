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
public class HospitalPojo {

    private int id;
    private String nameAr;
    private String address;
    private Double longitude;
    private Double latitude;
    private String startDate;
    private String endDate;
    private float rate;
    private String openHour;
    private String CloseHour;
    private String Ceo;
    private String nameEn;
    private int medicalTypeId;

    private Blob image;
    private ArrayList<String> phones;
    private ArrayList<String> departments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return CloseHour;
    }

    public void setCloseHour(String CloseHour) {
        this.CloseHour = CloseHour;
    }

    public String getCeo() {
        return Ceo;
    }

    public void setCeo(String Ceo) {
        this.Ceo = Ceo;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getMedicalTypeId() {
        return medicalTypeId;
    }

    public void setMedicalTypeId(int medicalTypeId) {
        this.medicalTypeId = medicalTypeId;
    }

    public Blob getImage() {
        return image;
    }

    public void setHospitalImage(Blob image) {
        this.image = image;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public ArrayList<String> getDepartments() {
        return departments;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public void setDepartments(ArrayList<String> departments) {
        this.departments = departments;
    }
    
    

}
