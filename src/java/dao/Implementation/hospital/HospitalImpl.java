/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.hospital;

import dao.Interfaces.hospital.Hospital;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.HospitalPojo;

/**
 *
 * @author Hagar
 */
public class HospitalImpl implements Hospital {

    @Override
    public HospitalPojo retrieve(int hospitalId) {

        HospitalPojo hospital = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM hospital WHERE hospital_id=?");

            retrieveTypes.setInt(1, hospitalId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                hospital = new HospitalPojo();
                hospital.setHospitalId(retSet.getInt(1));
                hospital.setHospitalNameAr(retSet.getString(2));
                hospital.setHospitalAddress(retSet.getString(3));
                hospital.setHospitalLongitude(retSet.getDouble(4));
                hospital.setHospitalLatitude(retSet.getDouble(5));
                hospital.setHospitalStartDate(retSet.getDate(6));
                hospital.setHospitalEndDate(retSet.getDate(7));
                hospital.setHospitalRate(retSet.getInt(8));
                hospital.setHospitalOpenHour(retSet.getString(9));
                hospital.setHospitalCloseHour(retSet.getString(10));
                hospital.setHospitalCeo(retSet.getString(11));
                hospital.setHospitalNameEn(retSet.getString(12));
                hospital.setMedicalTypeId(retSet.getInt(13));
                hospital.setHospitalImage(retSet.getString(14));

            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospital;
    }

}
