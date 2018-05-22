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
public class HospitalPojo {

    private int hospitalId;
    private String hospitalNameAr;
    private String hospitalAddress;
    private Double hospitalLongitude;
    private Double hospitalLatitude;
    private Date hospitalStartDate;
    private Date hospitalEndDate;
    private int hospitalRate;
    private String hospitalOpenHour;
    private String hospitalCloseHour;
    private String hospitalCeo;
    private String hospitalNameEn;
    private int medicalTypeId;
    private Blob hospitalImage;
    private ArrayList<String> hospitalPhones;
    private ArrayList<String> hospitalDepartments;

    public ArrayList<String> getHospitalPhones() {
        return hospitalPhones;
    }

    public ArrayList<String> getHospitalDepartments() {
        return hospitalDepartments;
    }

    public void setHospitalPhones(ArrayList<String> hospitalPhones) {
        this.hospitalPhones = hospitalPhones;
    }

    public void setHospitalDepartments(ArrayList<String> hospitalDepartments) {
        this.hospitalDepartments = hospitalDepartments;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setHospitalNameAr(String hospitalNameAr) {
        this.hospitalNameAr = hospitalNameAr;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public void setHospitalLongitude(Double hospitalLongitude) {
        this.hospitalLongitude = hospitalLongitude;
    }

    public void setHospitalLatitude(Double hospitalLatitude) {
        this.hospitalLatitude = hospitalLatitude;
    }

    public void setHospitalStartDate(Date hospitalStartDate) {
        this.hospitalStartDate = hospitalStartDate;
    }

    public void setHospitalEndDate(Date hospitalEndDate) {
        this.hospitalEndDate = hospitalEndDate;
    }

    public void setHospitalRate(int hospitalRate) {
        this.hospitalRate = hospitalRate;
    }

    public void setHospitalOpenHour(String hospitalOpenHour) {
        this.hospitalOpenHour = hospitalOpenHour;
    }

    public void setHospitalCloseHour(String hospitalCloseHour) {
        this.hospitalCloseHour = hospitalCloseHour;
    }

    public void setHospitalCeo(String hospitalCeo) {
        this.hospitalCeo = hospitalCeo;
    }

    public void setHospitalNameEn(String hospitalNameEn) {
        this.hospitalNameEn = hospitalNameEn;
    }

    public void setMedicalTypeId(int medicalTypeId) {
        this.medicalTypeId = medicalTypeId;
    }

    public void setHospitalImage(Blob hospitalImage) {
        this.hospitalImage = hospitalImage;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public String getHospitalNameAr() {
        return hospitalNameAr;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public Double getHospitalLongitude() {
        return hospitalLongitude;
    }

    public Double getHospitalLatitude() {
        return hospitalLatitude;
    }

    public Date getHospitalStartDate() {
        return hospitalStartDate;
    }

    public Date getHospitalEndDate() {
        return hospitalEndDate;
    }

    public int getHospitalRate() {
        return hospitalRate;
    }

    public String getHospitalOpenHour() {
        return hospitalOpenHour;
    }

    public String getHospitalCloseHour() {
        return hospitalCloseHour;
    }

    public String getHospitalCeo() {
        return hospitalCeo;
    }

    public String getHospitalNameEn() {
        return hospitalNameEn;
    }

    public int getMedicalTypeId() {
        return medicalTypeId;
    }

    public Blob getHospitalImage() {
        return hospitalImage;
    }

}
