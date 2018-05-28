/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.clinic;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public interface ClinicPhones {

    public boolean addClinicPhones(int clinic_id, ArrayList<String> phones);

    public int deleteClinicPhones(int clinic_id);

    public ArrayList<String> getClinicPhones(int clinic_id);

}
