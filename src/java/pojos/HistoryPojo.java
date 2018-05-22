/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Hagar
 */
public class HistoryPojo {

    private int historyId;
    private Date historyDate;
    private Blob historyPicture;
    private int employeeEmployeeId;
    private int medicalInsuranceId;
    private String serviceName;

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }

    public void setHistoryPicture(Blob historyPicture) {
        this.historyPicture = historyPicture;
    }

    public void setEmployeeEmployeeId(int employeeEmployeeId) {
        this.employeeEmployeeId = employeeEmployeeId;
    }

    public void setMedicalInsuranceId(int medicalInsuranceId) {
        this.medicalInsuranceId = medicalInsuranceId;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getHistoryId() {
        return historyId;
    }

    public Date getHistoryDate() {
        return historyDate;
    }

    public Blob getHistoryPicture() {
        return historyPicture;
    }

    public int getEmployeeEmployeeId() {
        return employeeEmployeeId;
    }

    public int getMedicalInsuranceId() {
        return medicalInsuranceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    

}
