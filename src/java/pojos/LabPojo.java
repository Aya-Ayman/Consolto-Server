/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Hagar
 */
public class LabPojo {

    private int id;
    private String nameEn;
    private String openHour;
    private String closeHour;
    private Double latitude;
    private Double longitude;
    private String address;
    private String startDate;
    private String endDate;
    private float rate;
    private String ceo;
    private String nameAr;
    private int medicalTypeId;
    private Blob image;
    private ArrayList<String> labPhones;
    private ArrayList<String> labSpecializations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
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

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
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

    public void setImage(Blob image) {
        this.image = image;
    }

    public ArrayList<String> getLabPhones() {
        return labPhones;
    }

    public void setLabPhones(ArrayList<String> labPhones) {
        this.labPhones = labPhones;
    }

    public ArrayList<String> getLabSpecializations() {
        return labSpecializations;
    }

    public void setLabSpecializations(ArrayList<String> labSpecializations) {
        this.labSpecializations = labSpecializations;
    }

    
}
