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
public class PharmacyListPojo {
    
       private ArrayList<PharmacyPojo> pharmacies= new ArrayList<>();

    public ArrayList<PharmacyPojo> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(ArrayList<PharmacyPojo> pharmacies) {
        this.pharmacies = pharmacies;
    }

       
}
