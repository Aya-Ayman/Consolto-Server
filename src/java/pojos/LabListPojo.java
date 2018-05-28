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
public class LabListPojo {
    
    ArrayList<LabPojo> labs= new ArrayList<LabPojo>();

    public ArrayList<LabPojo> getLabs() {
        return labs;
    }

    public void setLabs(ArrayList<LabPojo> labs) {
        this.labs = labs;
    }
    
    
}
