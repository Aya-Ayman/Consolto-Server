/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public class ClinicListPojo {
    
       private ArrayList<ClinicPojo> clinics= new ArrayList<>();

    public ArrayList<ClinicPojo> getClinics() {
        return clinics;
    }

    public void setClinics(ArrayList<ClinicPojo> clinics) {
        this.clinics = clinics;
    }

       
}
