/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.hospital;

import com.mysql.jdbc.Connection;
import dao.Interfaces.hospital.HospitalDepartments;
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
public class HospitalDepartmentsImplementation implements HospitalDepartments {

    @Override
    public boolean addHospitalDepartments(int hospital_id, ArrayList<String> departments) {

        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO hospital_departments (department,hospital_hospital_id) VALUES (?,?)");

            for (int i = 0; i < departments.size(); i++) {
                insertPs.setString(1, departments.get(i));
                insertPs.setInt(2, hospital_id);
                insertPs.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HospitalDepartmentsImplementation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public int deleteHospitalDepartments(int hospital_id) {
        int deleteDepartmentsCount;
        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement deletePs = connection.prepareStatement("DELETE FROM hospital_departments WHERE hospital_hospital_id =?");
            deletePs.setInt(1, hospital_id);

            deleteDepartmentsCount = deletePs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HospitalDepartmentsImplementation.class.getName()).log(Level.SEVERE, null, ex);
            deleteDepartmentsCount = 0;
        }
        return deleteDepartmentsCount;
    }

    @Override
    public ArrayList<String> getHospitalDepartments(int hospital_id) {

        ArrayList<String> departments = new ArrayList();
        //"INSERT INTO hospital (hospital_id,hospital_name,hospital_address,hospital_longitude,hospital_latitude,hospital_start_date,hospital_end_date,hospital_rate,hospital_open_hour,hospital_close_hour,hospital_ceo,hospital_name_en,medical_type_medical_type_id,hospital_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        try (Connection connection = (Connection) DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT department FROM hospital_departments where hospital_hospital_id=?");
            retrievePs.setInt(1, hospital_id);
            ResultSet retSet = retrievePs.executeQuery();

            while (retSet.next()) {
                departments.add(retSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return departments;

    }
}
