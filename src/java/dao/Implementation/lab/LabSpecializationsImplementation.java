/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.lab;

import com.mysql.jdbc.Connection;
import dao.Interfaces.lab.LabSpecializations;
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
public class LabSpecializationsImplementation implements LabSpecializations {

    public boolean addLabSpecializations(int lab_id, ArrayList<String> specializations) {

        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO lab_specializations (specialization,lab_lab_id) VALUES (?,?)");

            for (int i = 0; i < specializations.size(); i++) {
                insertPs.setString(1, specializations.get(i));
                insertPs.setInt(2, lab_id);
                insertPs.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LabSpecializationsImplementation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int deleteLabSpecializations(int lab_id) {
        int deleteSpecializationsCount;
        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement deletePs = connection.prepareStatement("DELETE FROM lab_specializations WHERE lab_lab_id =?");
            deletePs.setInt(1, lab_id);

            deleteSpecializationsCount = deletePs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LabSpecializationsImplementation.class.getName()).log(Level.SEVERE, null, ex);
            deleteSpecializationsCount = 0;
        }
        return deleteSpecializationsCount;
    }

    public ArrayList<String> getLabSpecializations(int lab_id) {

        ArrayList<String> specializations = new ArrayList();
        //"INSERT INTO hospital (hospital_id,hospital_name,hospital_address,hospital_longitude,hospital_latitude,hospital_start_date,hospital_end_date,hospital_rate,hospital_open_hour,hospital_close_hour,hospital_ceo,hospital_name_en,medical_type_medical_type_id,hospital_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT specialization FROM lab_specializations where lab_lab_id=?");
            retrievePs.setInt(1, lab_id);
            ResultSet retSet = retrievePs.executeQuery();

            while (retSet.next()) {
                specializations.add(retSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return specializations;

    }
    
   
    
    
    
    
}
