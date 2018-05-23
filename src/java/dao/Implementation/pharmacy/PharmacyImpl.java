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

}
