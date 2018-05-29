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
public class MedicalTypeListPojo {
         private ArrayList<MedicalTypePojo> types= new ArrayList<>();

    public ArrayList<MedicalTypePojo> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<MedicalTypePojo> types) {
        this.types = types;
    }
         
         

}
