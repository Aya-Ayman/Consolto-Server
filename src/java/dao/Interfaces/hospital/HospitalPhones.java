/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.hospital;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public interface HospitalPhones {

    public boolean addHospitalPhones(int hospital_id, ArrayList<String> phones);

    public int deleteHospitalPhones(int hospital_id);

    public ArrayList<String> getHospitalPhones(int hospital_id);

}
