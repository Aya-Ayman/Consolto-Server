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
public interface HospitalDepartments {

    public boolean addHospitalDepartments(int hospital_id, ArrayList<String> departments);

    public int deleteHospitalDepartments(int hospital_id);

    public ArrayList<String> getHospitalDepartments(int hospital_id);

}
