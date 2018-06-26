/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.hospital;

import java.util.ArrayList;
import pojos.HospitalPojo;

/**
 *
 * @author Hagar
 */
public interface Hospital {

    public HospitalPojo retrieve(int hospitalId);

    public boolean addHospital(HospitalPojo hospital);

    public boolean deleteHospital(int hospital_id);

    public ArrayList<HospitalPojo> getAllHospitals();

     public int retrieveHospitalsCount();
}
