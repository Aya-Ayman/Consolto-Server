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
public class PharmacyPojo {

    private int pharmacyId;
    private String pharmacyNameEn;
    private Double pharmacyLatitude;
    private Double pharmacyLongitude;
    private Date pharmacyStartDate;
    private Date pharmacyEndDate;
    private int pharmacyRate;
    private String pharmacyAddress;
    private String pharmacyOpenHour;
    private String pharmacyCloseHour;
    private String pharmacyNameAr;
    private int medicalTypeId;
    private ArrayList<String> pharmacyPhones;

    public ArrayList<String> getPharmacyPhones() {
        return pharmacyPhones;
    }

    public void setPharmacyPhones(ArrayList<String> pharmacyPhones) {
        this.pharmacyPhones = pharmacyPhones;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public String getPharmacyNameEn() {
        return pharmacyNameEn;
    }

    public Double getPharmacyLatitude() {
        return pharmacyLatitude;
    }

    public Double getPharmacyLongitude() {
        return pharmacyLongitude;
    }

    public Date getPharmacyStartDate() {
        return pharmacyStartDate;
    }

    public Date getPharmacyEndDate() {
        return pharmacyEndDate;
    }

    public int getPharmacyRate() {
        return pharmacyRate;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public String getPharmacyOpenHour() {
        return pharmacyOpenHour;
    }

    public String getPharmacyCloseHour() {
        return pharmacyCloseHour;
    }

    public String getPharmacyNameAr() {
        return pharmacyNameAr;
    }

    public int getMedicalTypeId() {
        return medicalTypeId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public void setPharmacyNameEn(String pharmacyNameEn) {
        this.pharmacyNameEn = pharmacyNameEn;
    }

    public void setPharmacyLatitude(Double pharmacyLatitude) {
        this.pharmacyLatitude = pharmacyLatitude;
    }

    public void setPharmacyLongitude(Double pharmacyLongitude) {
        this.pharmacyLongitude = pharmacyLongitude;
    }

    public void setPharmacyStartDate(Date pharmacyStartDate) {
        this.pharmacyStartDate = pharmacyStartDate;
    }

    public void setPharmacyEndDate(Date pharmacyEndDate) {
        this.pharmacyEndDate = pharmacyEndDate;
    }

    public void setPharmacyRate(int pharmacyRate) {
        this.pharmacyRate = pharmacyRate;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public void setPharmacyOpenHour(String pharmacyOpenHour) {
        this.pharmacyOpenHour = pharmacyOpenHour;
    }

    public void setPharmacyCloseHour(String pharmacyCloseHour) {
        this.pharmacyCloseHour = pharmacyCloseHour;
    }

    public void setPharmacyNameAr(String pharmacyNameAr) {
        this.pharmacyNameAr = pharmacyNameAr;
    }

    public void setMedicalTypeId(int medicalTypeId) {
        this.medicalTypeId = medicalTypeId;
    }

}
