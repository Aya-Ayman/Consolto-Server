/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Aya
 */
public class AdminPojo {
    private int id;
    private String username;
    private String password;
    private int medical_insurance_id;

    public AdminPojo(String username, String password, int medical_insurance_id) {
        this.username = username;
        this.password = password;
        this.medical_insurance_id = medical_insurance_id;
    }

    public AdminPojo() {
    }

    public AdminPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMedical_insurance_id() {
        return medical_insurance_id;
    }

    public void setMedical_insurance_id(int medical_insurance_id) {
        this.medical_insurance_id = medical_insurance_id;
    }
    
    
    
}
