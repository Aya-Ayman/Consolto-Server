/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.clinic;

import dao.Interfaces.clinic.Clinic;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.ClinicPojo;

/**
 *
 * @author Hagar
 */
public class ClinicImpl implements Clinic {

    @Override
    public ClinicPojo retrieve(int clinicId) {

        ClinicPojo clinic = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM clinic WHERE clinic_id=?");

            retrieveTypes.setInt(1, clinicId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                clinic = new ClinicPojo();
                clinic.setClinicId(retSet.getInt(1));
                clinic.setClinicLongitude(retSet.getDouble(2));
                clinic.setClinicLatitude(retSet.getDouble(3));
                clinic.setClinicAddress(retSet.getString(4));
                clinic.setClinicSpecialization(retSet.getString(5));
                clinic.setClinicEndDate(retSet.getDate(6));
                clinic.setClinicStartDate(retSet.getDate(7));
                clinic.setClinicOpenHour(retSet.getString(8));
                clinic.setClinicCloseHour(retSet.getString(9));
                clinic.setClinicRate(retSet.getInt(10));
                clinic.setClinicDoctorNameEn(retSet.getString(11));
                clinic.setClinicDoctorNameAr(retSet.getString(12));
                clinic.setMedicalTypeMedicalTypeId(retSet.getInt(13));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clinic;

    }

}
