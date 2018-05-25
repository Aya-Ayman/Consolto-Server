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
import java.util.ArrayList;
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

    @Override
    public boolean addClinic(ClinicPojo clinic) {
        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO clinic (clinic_id,clinic_longitude,clinic_latitude,clinic_address,clinic_specialization,clinic_end_date,clinic_start_date,clinic_open_hour,clinic_close_hour,clinic_rate,clinic_doctor_name_en,clinic_doctor_name_ar,medical_type_medical_type_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, clinic.getClinicId());
            insertPs.setDouble(2, clinic.getClinicLongitude());
            insertPs.setDouble(3, clinic.getClinicLatitude());
            insertPs.setString(4, clinic.getClinicAddress());
            insertPs.setString(5, clinic.getClinicSpecialization());
            insertPs.setDate(6, clinic.getClinicEndDate());
            insertPs.setDate(7, clinic.getClinicStartDate());
            insertPs.setString(8, clinic.getClinicOpenHour());
            insertPs.setString(9, clinic.getClinicCloseHour());
            insertPs.setInt(10, clinic.getClinicRate());
            insertPs.setString(11, clinic.getClinicDoctorNameEn());
            insertPs.setString(12, clinic.getClinicDoctorNameAr());
            insertPs.setInt(13, clinic.getMedicalTypeMedicalTypeId());
            // Blob blob=null;
            // insertPs.setBlob(14, blob);

            int insertflag = insertPs.executeUpdate();

            boolean res = false;
            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT clinic_id FROM clinic WHERE clinic_doctor_name_ar=? OR clinic_doctor_name_en=?");
                getPs.setString(1, clinic.getClinicDoctorNameAr());
                getPs.setString(2, clinic.getClinicDoctorNameEn());

                ResultSet resSet = getPs.executeQuery();

                int id = 0;
                if (resSet.isBeforeFirst()) {
                    resSet.next();
                    id = resSet.getInt(1);
                    System.out.print(id);
                }
                res = phonesObj.addClinicPhones(id, clinic.getClinicPhones());

            }
            return res;

            // System.out.println("insert" + );
        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean deleteClinic(int clinic_id) {

        boolean delete = false;
        int deletePhone;
        int deleteClinic;
        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();
        try (Connection connection = DBConnection.getConnection()) {

            deletePhone = phonesObj.deleteClinicPhones(clinic_id);

            if (deletePhone != 0) {
                PreparedStatement deletePs = connection.prepareStatement("DELETE FROM clinic WHERE clinic_id =?");
                deletePs.setInt(1, clinic_id);
                // deletePs.setInt(2,medical_type_id);
                deleteClinic = deletePs.executeUpdate();
                if (deleteClinic == 1) {
                    delete = true;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);

            delete = false;
        }
        return delete;

    }

    @Override
    public ArrayList<ClinicPojo> getAllClinics() {

        //("INSERT INTO clinic (clinic_id,clinic_longitude,clinic_latitude,clinic_address,clinic_specialization,clinic_end_date,clinic_start_date,clinic_open_hour,clinic_close_hour,clinic_rate,clinic_doctor_name_en,clinic_doctor_name_ar,medical_type_medical_type_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ArrayList<ClinicPojo> clinics = new ArrayList();
        ArrayList<String> phones = new ArrayList();

        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM clinic");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                ClinicPojo clinic = new ClinicPojo();
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
                //  clinic.setClinic_image(retSet.getBlob(14));
                phones = phonesObj.getClinicPhones(retSet.getInt(1));
                clinic.setClinicPhones(phones);
                clinics.add(clinic);

                //System.out.print(retSet.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return clinics;

    }
}
