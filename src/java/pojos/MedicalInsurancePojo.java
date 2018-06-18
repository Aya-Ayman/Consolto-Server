/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;

/**
 *
 * @author Hagar
 */
public class MedicalInsurancePojo {

    private int insuranceId;
    private String insuranceName;
    private String insuranceCeo;
    private String insuranceAddress;
    private Double insuranceLatitude;
    private Double insuranceLongitude;
    private String insuranceEmail;
    private ArrayList<String> medicalInsurancePhones;

    public ArrayList<String> getMedicalInsurancePhones() {
        return medicalInsurancePhones;
    }

    public void setMedicalInsurancePhones(ArrayList<String> medicalInsurancePhones) {
        this.medicalInsurancePhones = medicalInsurancePhones;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public void setInsuranceCeo(String insuranceCeo) {
        this.insuranceCeo = insuranceCeo;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public void setInsuranceLatitude(Double insuranceLatitude) {
        this.insuranceLatitude = insuranceLatitude;
    }

    public void setInsuranceEmail(String insuranceEmail) {
        this.insuranceEmail = insuranceEmail;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public String getInsuranceCeo() {
        return insuranceCeo;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public Double getInsuranceLatitude() {
        return insuranceLatitude;
    }

    public String getInsuranceEmail() {
        return insuranceEmail;
    }

    public Double getInsuranceLongitude() {
        return insuranceLongitude;
    }

    public void setInsuranceLongitude(Double insuranceLongitude) {
        this.insuranceLongitude = insuranceLongitude;
    }
}
