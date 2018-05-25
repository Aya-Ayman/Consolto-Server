/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.hospital;

import dao.Interfaces.hospital.Hospital;
import dbconnectionfactory.DBConnection;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                hospital.setHospitalLatitude(retSet.getDouble(6));
                hospital.setHospitalStartDate(retSet.getDate(7));
                hospital.setHospitalEndDate(retSet.getDate(8));
                hospital.setHospitalRate(retSet.getInt(9));
                hospital.setHospitalOpenHour(retSet.getString(10));
                hospital.setHospitalCloseHour(retSet.getString(11));
                hospital.setHospitalCeo(retSet.getString(12));
                hospital.setHospitalNameEn(retSet.getString(13));
                hospital.setMedicalTypeId(retSet.getInt(14));
                hospital.setHospitalImage(retSet.getBlob(15));

            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospital;
    }

    @Override
    public boolean addHospital(HospitalPojo hospital) {

        HospitalDepartmentsImplementation departments = new HospitalDepartmentsImplementation();
        HospitalPhonesImplementation phones = new HospitalPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            // System.out.println(hospital.getHospitalNameAr());
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO hospital (hospital_id,hospital_name,hospital_address,hospital_longitude,hospital_latitude,hospital_start_date,hospital_end_date,hospital_rate,hospital_open_hour,hospital_close_hour,hospital_ceo,hospital_name_en,medical_type_medical_type_id,hospital_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, hospital.getHospitalId());
            insertPs.setString(2, hospital.getHospitalNameAr());
            insertPs.setString(3, hospital.getHospitalAddress());
            insertPs.setDouble(4, hospital.getHospitalLongitude());
            insertPs.setDouble(5, hospital.getHospitalLatitude());
            insertPs.setDate(6, hospital.getHospitalStartDate());
            insertPs.setDate(7, hospital.getHospitalEndDate());
            insertPs.setInt(8, hospital.getHospitalRate());
            insertPs.setString(9, hospital.getHospitalOpenHour());
            insertPs.setString(10, hospital.getHospitalCloseHour());
            insertPs.setString(11, hospital.getHospitalCeo());
            insertPs.setString(12, hospital.getHospitalNameEn());
            insertPs.setInt(13, hospital.getMedicalTypeId());
            Blob blob = null;
            insertPs.setBlob(14, blob);

            int insertflag = insertPs.executeUpdate();
            boolean res = false;
            boolean res2 = false;
            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT hospital_id FROM hospital WHERE hospital_name=? OR hospital_name_en=?");
                getPs.setString(1, hospital.getHospitalNameAr());
                getPs.setString(2, hospital.getHospitalNameEn());
                ResultSet resSet = getPs.executeQuery();

                int id = 0;
                if (resSet.isBeforeFirst()) {
                    resSet.next();
                    id = resSet.getInt(1);
                    System.out.print(id);
                }
                res = phones.addHospitalPhones(id, hospital.getHospitalPhones());
                res2 = departments.addHospitalDepartments(id, hospital.getHospitalDepartments());

            }
            return res && res2;

        } catch (SQLException ex) {
            Logger.getLogger(HospitalImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    @Override
    public boolean deleteHospital(int hospital_id) {

        int deletePhone;
        int deleteDepartments;
        boolean delete = false;
        int deleteHospital;
        HospitalDepartmentsImplementation departmentsObj = new HospitalDepartmentsImplementation();
        HospitalPhonesImplementation phonesObj = new HospitalPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {

            deletePhone = phonesObj.deleteHospitalPhones(hospital_id);
            deleteDepartments = departmentsObj.deleteHospitalDepartments(hospital_id);
            if (deletePhone != 0 && deleteDepartments != 0) {

                PreparedStatement deletePs = connection.prepareStatement("DELETE FROM hospital WHERE hospital_id =?");
                deletePs.setInt(1, hospital_id);
                // deletePs.setInt(2,medical_type_id);

                deleteHospital = deletePs.executeUpdate();

                if (deleteHospital == 1) {
                    delete = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalImpl.class.getName()).log(Level.SEVERE, null, ex);
            delete = false;
        }
        return delete;

    }

    @Override
    public ArrayList<HospitalPojo> getAllHospitals() {

        HospitalDepartmentsImplementation departmentsObj = new HospitalDepartmentsImplementation();
        HospitalPhonesImplementation phonesObj = new HospitalPhonesImplementation();

        ArrayList<HospitalPojo> hospitals = new ArrayList();
        //"INSERT INTO hospital (hospital_id,hospital_name,hospital_address,hospital_longitude,hospital_latitude,hospital_start_date,hospital_end_date,hospital_rate,hospital_open_hour,hospital_close_hour,hospital_ceo,hospital_name_en,medical_type_medical_type_id,hospital_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ArrayList<String> phones = new ArrayList();
        ArrayList<String> departments = new ArrayList();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM hospital");

            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                HospitalPojo hos = new HospitalPojo();
                hos.setHospitalId(retSet.getInt(1));
                hos.setHospitalNameAr(retSet.getString(2));
                hos.setHospitalAddress(retSet.getString(3));
                hos.setHospitalLongitude(retSet.getDouble(4));
                hos.setHospitalLatitude(retSet.getDouble(5));
                hos.setHospitalStartDate(retSet.getDate(6));
                hos.setHospitalEndDate(retSet.getDate(7));
                hos.setHospitalRate(retSet.getInt(8));
                hos.setHospitalOpenHour(retSet.getString(9));
                hos.setHospitalCloseHour(retSet.getString(10));
                hos.setHospitalCeo(retSet.getString(11));
                hos.setHospitalNameEn(retSet.getString(12));
                hos.setMedicalTypeId(retSet.getInt(13));
                hos.setHospitalImage(retSet.getBlob(14));

                phones = phonesObj.getHospitalPhones(retSet.getInt(1));
                //System.out.print(retSet.getInt(1));
                departments = departmentsObj.getHospitalDepartments(retSet.getInt(1));

                hos.setHospitalPhones(phones);
                hos.setHospitalDepartments(departments);

                hospitals.add(hos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return hospitals;

    }

}
