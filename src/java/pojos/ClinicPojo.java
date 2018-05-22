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
public class ClinicPojo {

    private int clinicId;
    private double clinicLongitude;
    private double clinicLatitude;
    private String clinicAddress;
    private String clinicSpecialization;
    private Date clinicEndDate;
    private Date clinicStartDate;
    private String clinicOpenHour;
    private String clinicCloseHour;
    private int clinicRate;
    private String clinicDoctorNameEn;
    private String clinicDoctorNameAr;
    private int medicalTypeMedicalTypeId;
    private ArrayList<String> clinicPhones;

   
    public void setClinicPhones(ArrayList<String> clinicPhones) {
        this.clinicPhones = clinicPhones;
    }

    public ArrayList<String> getClinicPhones() {
        return clinicPhones;
    }

    public int getClinicId() {
        return clinicId;
    }

    public double getClinicLongitude() {
        return clinicLongitude;
    }

    public double getClinicLatitude() {
        return clinicLatitude;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public String getClinicSpecialization() {
        return clinicSpecialization;
    }

    public Date getClinicEndDate() {
        return clinicEndDate;
    }

    public Date getClinicStartDate() {
        return clinicStartDate;
    }

    public String getClinicOpenHour() {
        return clinicOpenHour;
    }

    public String getClinicCloseHour() {
        return clinicCloseHour;
    }

    public int getClinicRate() {
        return clinicRate;
    }

    public String getClinicDoctorNameEn() {
        return clinicDoctorNameEn;
    }

    public String getClinicDoctorNameAr() {
        return clinicDoctorNameAr;
    }

    public int getMedicalTypeMedicalTypeId() {
        return medicalTypeMedicalTypeId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public void setClinicLongitude(double clinicLongitude) {
        this.clinicLongitude = clinicLongitude;
    }

    public void setClinicLatitude(double clinicLatitude) {
        this.clinicLatitude = clinicLatitude;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public void setClinicSpecialization(String clinicSpecialization) {
        this.clinicSpecialization = clinicSpecialization;
    }

    public void setClinicEndDate(Date clinicEndDate) {
        this.clinicEndDate = clinicEndDate;
    }

    public void setClinicStartDate(Date clinicStartDate) {
        this.clinicStartDate = clinicStartDate;
    }

    public void setClinicOpenHour(String clinicOpenHour) {
        this.clinicOpenHour = clinicOpenHour;
    }

    public void setClinicCloseHour(String clinicCloseHour) {
        this.clinicCloseHour = clinicCloseHour;
    }

    public void setClinicRate(int clinicRate) {
        this.clinicRate = clinicRate;
    }

    public void setClinicDoctorNameEn(String clinicDoctorNameEn) {
        this.clinicDoctorNameEn = clinicDoctorNameEn;
    }

    public void setClinicDoctorNameAr(String clinicDoctorNameAr) {
        this.clinicDoctorNameAr = clinicDoctorNameAr;
    }

    public void setMedicalTypeMedicalTypeId(int medicalTypeMedicalTypeId) {
        this.medicalTypeMedicalTypeId = medicalTypeMedicalTypeId;
    }

}
