/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Hagar
 */
public class MedicalTypePojo {

    private int medicalTypeId;
    private String medicalTypeNameAr;
    private String medicalTypeNameEn;

    public void setMedicalTypeId(int medicalTypeId) {
        this.medicalTypeId = medicalTypeId;
    }

    public void setMedicalTypeNameAr(String medicalTypeNameAr) {
        this.medicalTypeNameAr = medicalTypeNameAr;
    }

    public void setMedicalTypeNameEn(String medicalTypeNameEn) {
        this.medicalTypeNameEn = medicalTypeNameEn;
    }


    public int getMedicalTypeId() {
        return medicalTypeId;
    }

    public String getMedicalTypeNameAr() {
        return medicalTypeNameAr;
    }

    public String getMedicalTypeNameEn() {
        return medicalTypeNameEn;
    }


}
