/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public class HospitalListPojo {
    
   private ArrayList<HospitalPojo> hospitals= new ArrayList<>();

    public ArrayList<HospitalPojo> getHospitals() {
        return hospitals;
    }

    public void setHospitals(ArrayList<HospitalPojo> hospitals) {
        this.hospitals = hospitals;
    }
   
   
}
