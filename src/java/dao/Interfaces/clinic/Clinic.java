/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.clinic;

import java.util.ArrayList;
import pojos.ClinicPojo;

/**
 *
 * @author Hagar
 */
public interface Clinic {

    public ClinicPojo retrieve(int clinicId);

    public boolean addClinic(ClinicPojo clinic);

    public boolean deleteClinic(int clinic_id);

    public ArrayList<ClinicPojo> getAllClinics();
    
     public int retrieveClinicsCount();
}
