/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;

/**
 *
 * @author Hagar
 */
public class ReviewsPojo {

    private int reviewId;
    private int medicalTypeId;
    private int serviceId;
    private String description;
    private Date date;
    private String type;
    private int employeeEmployeeId;
    private int reviewRate;

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setMedicalTypeId(int medicalTypeId) {
        this.medicalTypeId = medicalTypeId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmployeeEmployeeId(int employeeEmployeeId) {
        this.employeeEmployeeId = employeeEmployeeId;
    }

    public void setReviewRate(int reviewRate) {
        this.reviewRate = reviewRate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getMedicalTypeId() {
        return medicalTypeId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getEmployeeEmployeeId() {
        return employeeEmployeeId;
    }

    public int getReviewRate() {
        return reviewRate;
    }

}
