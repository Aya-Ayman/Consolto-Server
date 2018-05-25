/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.pharmacy;

import dao.Interfaces.pharmacy.Pharmacy;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.PharmacyPojo;

/**
 *
 * @author Hagar
 */
public class PharmacyImpl implements Pharmacy {

    @Override
    public PharmacyPojo retrieve(int pharmacyId) {
        PharmacyPojo pharmacy = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM pharmacy WHERE pharmacy_id=?");

            retrieveTypes.setInt(1, pharmacyId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                pharmacy = new PharmacyPojo();
                pharmacy.setPharmacyId(retSet.getInt(1));
                pharmacy.setPharmacyNameEn(retSet.getString(2));
                pharmacy.setPharmacyLatitude(retSet.getDouble(3));
                pharmacy.setPharmacyLongitude(retSet.getDouble(4));
                pharmacy.setPharmacyStartDate(retSet.getDate(6));
                pharmacy.setPharmacyEndDate(retSet.getDate(7));
                pharmacy.setPharmacyRate(retSet.getInt(8));
                pharmacy.setPharmacyAddress(retSet.getString(9));
                pharmacy.setPharmacyOpenHour(retSet.getString(10));
                pharmacy.setPharmacyCloseHour(retSet.getString(11));
                pharmacy.setPharmacyNameAr(retSet.getString(12));
                pharmacy.setMedicalTypeId(retSet.getInt(13));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PharmacyImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pharmacy;

    }

    @Override
    public boolean addPharmacy(PharmacyPojo pharmacy) {

        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO pharmacy (pharmacy_id,pharmacy_name_en,pharmacy_latitude,pharmacy_longitude,pharmacy_start_date,pharmacy_end_date,pharmacy_rate,pharmacy_address,pharmacy_open_hour,pharmacy_close_hour,pharmacy_name_ar,medical_type_medical_type_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, pharmacy.getPharmacyId());
            insertPs.setString(2, pharmacy.getPharmacyNameEn());
            insertPs.setDouble(3, pharmacy.getPharmacyLatitude());
            insertPs.setDouble(4, pharmacy.getPharmacyLongitude());
            insertPs.setDate(5, pharmacy.getPharmacyStartDate());
            insertPs.setDate(6, pharmacy.getPharmacyEndDate());
            insertPs.setInt(7, pharmacy.getPharmacyRate());
            insertPs.setString(8, pharmacy.getPharmacyAddress());
            insertPs.setString(9, pharmacy.getPharmacyOpenHour());
            insertPs.setString(10, pharmacy.getPharmacyCloseHour());
            insertPs.setString(11, pharmacy.getPharmacyNameAr());
            insertPs.setInt(12, pharmacy.getMedicalTypeId());

            int insertflag = insertPs.executeUpdate();

            boolean res = false;
            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT pharmacy_id FROM pharmacy WHERE pharmacy_name_ar=? OR pharmacy_name_en=?");
                getPs.setString(1, pharmacy.getPharmacyNameAr());
                getPs.setString(2, pharmacy.getPharmacyNameEn());

                ResultSet resSet = getPs.executeQuery();

                int id = 0;
                if (resSet.isBeforeFirst()) {
                    resSet.next();
                    id = resSet.getInt(1);
                    System.out.print(id);
                }
                res = phonesObj.addPharmacyPhones(id, pharmacy.getPharmacyPhones());
            }
            return res;

            //System.out.println("insert" + insertPs.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean deletePharmacy(int pharmacy_id) {
        int deletePhone;
        int deletePharmacy;
        boolean delete = false;
        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {

            deletePhone = phonesObj.deletePharmacyPhones(pharmacy_id);

            if (deletePhone != 0) {

                PreparedStatement deletePs = connection.prepareStatement("DELETE FROM pharmacy WHERE pharmacy_id =? ");
                deletePs.setInt(1, pharmacy_id);
                // deletePs.setInt(2,medical_type_id);

                deletePharmacy = deletePs.executeUpdate();
                if (deletePharmacy == 1) {
                    delete = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyImpl.class.getName()).log(Level.SEVERE, null, ex);
            delete = false;
        }

        return delete;
    }

    @Override
    public ArrayList<PharmacyPojo> getAllPharmacies() {
        //"INSERT INTO pharmacy (pharmacy_id,pharmacy_name_en,pharmacy_latitude,pharmacy_longitude,pharmacy_start_date,pharmacy_end_date,pharmacy_rate,pharmacy_address,pharmacy_open_hour,pharmacy_close_hour,pharmacy_name_ar,medical_type_medical_type_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

        ArrayList<PharmacyPojo> pharmacies = new ArrayList();
        ArrayList<String> phones = new ArrayList();
        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM pharmacy");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                PharmacyPojo pharmacy = new PharmacyPojo();
                pharmacy.setPharmacyId(retSet.getInt(1));
                pharmacy.setPharmacyNameEn(retSet.getString(2));
                pharmacy.setPharmacyLatitude(retSet.getDouble(3));
                pharmacy.setPharmacyLongitude(retSet.getDouble(4));
                pharmacy.setPharmacyStartDate(retSet.getDate(5));
                pharmacy.setPharmacyEndDate(retSet.getDate(6));
                pharmacy.setPharmacyRate(retSet.getInt(7));
                pharmacy.setPharmacyAddress(retSet.getString(8));
                pharmacy.setPharmacyOpenHour(retSet.getString(9));
                pharmacy.setPharmacyCloseHour(retSet.getString(10));
                pharmacy.setPharmacyNameAr(retSet.getString(11));
                pharmacy.setMedicalTypeId(retSet.getInt(12));
                //  clinic.setClinic_image(retSet.getBlob(14));
                phones = phonesObj.getPharmacyPhones(retSet.getInt(1));
                pharmacy.setPharmacyPhones(phones);
                pharmacies.add(pharmacy);
                //System.out.print(retSet.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return pharmacies;

    }

}
