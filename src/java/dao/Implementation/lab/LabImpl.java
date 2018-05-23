/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.lab;

import dao.Interfaces.lab.Lab;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.LabPojo;

/**
 *
 * @author Hagar
 */
public class LabImpl implements Lab {

    @Override
    public LabPojo retrieve(int labId) {
        LabPojo lab = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM lab WHERE lab_id=?");

            retrieveTypes.setInt(1, labId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                lab = new LabPojo();
                lab.setLabId(retSet.getInt(1));
                lab.setLabNameEn(retSet.getString(2));
                lab.setLabOpenHour(retSet.getString(3));
                lab.setLabCloseHour(retSet.getString(4));
                lab.setLabLatitude(retSet.getDouble(6));
                lab.setLabLongitude(retSet.getDouble(7));
                lab.setLabAddress(retSet.getString(8));
                lab.setLabStartDate(retSet.getDate(9));
                lab.setLabEndDate(retSet.getDate(10));
                lab.setLabRate(retSet.getInt(11));
                lab.setLabCeo(retSet.getString(12));
                lab.setLabNameAr(retSet.getString(13));
                lab.setMedicalTypeMedicalTypeId(retSet.getInt(14));

            }

        } catch (SQLException ex) {
            Logger.getLogger(LabImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lab;

    }

}
