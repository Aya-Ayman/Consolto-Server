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
public class LabPojo {

    private int labId;
    private String labNameEn;
    private String labOpenHour;
    private String labCloseHour;
    private Double labLatitude;
    private Double labLongitude;
    private String labAddress;
    private Date labStartDate;
    private Date labEndDate;
    private int labRate;
    private String labCeo;
    private String labNameAr;
    private int medicalTypeMedicalTypeId;
    private ArrayList<String> labPhones;
    private ArrayList<String> labSpecializations;

    public void setLabPhones(ArrayList<String> labPhones) {
        this.labPhones = labPhones;
    }

    public void setLabSpecializations(ArrayList<String> labSpecializations) {
        this.labSpecializations = labSpecializations;
    }

    public ArrayList<String> getLabPhones() {
        return labPhones;
    }

    public ArrayList<String> getLabSpecializations() {
        return labSpecializations;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public void setLabNameEn(String labNameEn) {
        this.labNameEn = labNameEn;
    }

    public void setLabOpenHour(String labOpenHour) {
        this.labOpenHour = labOpenHour;
    }

    public void setLabCloseHour(String labCloseHour) {
        this.labCloseHour = labCloseHour;
    }

    public void setLabLatitude(Double labLatitude) {
        this.labLatitude = labLatitude;
    }

    public void setLabLongitude(Double labLongitude) {
        this.labLongitude = labLongitude;
    }

    public void setLabAddress(String labAddress) {
        this.labAddress = labAddress;
    }

    public void setLabStartDate(Date labStartDate) {
        this.labStartDate = labStartDate;
    }

    public void setLabEndDate(Date labEndDate) {
        this.labEndDate = labEndDate;
    }

    public void setLabRate(int labRate) {
        this.labRate = labRate;
    }

    public void setLabCeo(String labCeo) {
        this.labCeo = labCeo;
    }

    public void setLabNameAr(String labNameAr) {
        this.labNameAr = labNameAr;
    }

    public void setMedicalTypeMedicalTypeId(int medicalTypeMedicalTypeId) {
        this.medicalTypeMedicalTypeId = medicalTypeMedicalTypeId;
    }

    public int getLabId() {
        return labId;
    }

    public String getLabNameEn() {
        return labNameEn;
    }

    public String getLabOpenHour() {
        return labOpenHour;
    }

    public String getLabCloseHour() {
        return labCloseHour;
    }

    public Double getLabLatitude() {
        return labLatitude;
    }

    public Double getLabLongitude() {
        return labLongitude;
    }

    public String getLabAddress() {
        return labAddress;
    }

    public Date getLabStartDate() {
        return labStartDate;
    }

    public Date getLabEndDate() {
        return labEndDate;
    }

    public int getLabRate() {
        return labRate;
    }

    public String getLabCeo() {
        return labCeo;
    }

    public String getLabNameAr() {
        return labNameAr;
    }

    public int getMedicalTypeMedicalTypeId() {
        return medicalTypeMedicalTypeId;
    }

}
