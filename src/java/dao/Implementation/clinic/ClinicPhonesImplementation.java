/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.clinic;

import com.mysql.jdbc.Connection;
import dao.Interfaces.clinic.ClinicPhones;
import dbconnectionfactory.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aya
 */
public class ClinicPhonesImplementation implements ClinicPhones {

    @Override
    public boolean addClinicPhones(int clinic_id, ArrayList<String> phones) {

        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO clinic_phone (phone,clinic_clinic_id) VALUES (?,?)");

            for (int i = 0; i < phones.size(); i++) {
                insertPs.setString(1, phones.get(i));
                insertPs.setInt(2, clinic_id);
                insertPs.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClinicPhonesImplementation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public int deleteClinicPhones(int clinic_id) {
        int deletePhonesCount;

        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement deletePs = connection.prepareStatement("DELETE FROM clinic_phone WHERE clinic_clinic_id =?");
            deletePs.setInt(1, clinic_id);
            deletePhonesCount = deletePs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClinicPhonesImplementation.class.getName()).log(Level.SEVERE, null, ex);
            deletePhonesCount = 0;
        }

        return deletePhonesCount;
    }

    @Override
    public ArrayList<String> getClinicPhones(int clinic_id) {
        ArrayList<String> clinicPhones = new ArrayList();
        //"INSERT INTO hospital (hospital_id,hospital_name,hospital_address,hospital_longitude,hospital_latitude,hospital_start_date,hospital_end_date,hospital_rate,hospital_open_hour,hospital_close_hour,hospital_ceo,hospital_name_en,medical_type_medical_type_id,hospital_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT phone FROM clinic_phone where clinic_clinic_id=?");
            retrievePs.setInt(1, clinic_id);
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                clinicPhones.add(retSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return clinicPhones;

    }
}
