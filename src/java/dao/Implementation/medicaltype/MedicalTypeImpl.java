/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.medicaltype;

import dao.Interfaces.medicaltype.MedicalType;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.MedicalTypePojo;

/**
 *
 * @author Hagar
 */
public class MedicalTypeImpl implements MedicalType {

    @Override
    public boolean create(MedicalTypePojo type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicalTypePojo retrieve(int typeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MedicalTypePojo> retrieve() {
        ArrayList<MedicalTypePojo> allTypes = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM medical_type");

            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {
                MedicalTypePojo medicalType = new MedicalTypePojo();
                medicalType = new MedicalTypePojo();
                medicalType.setMedicalTypeId(retSet.getInt(1));
                medicalType.setMedicalTypeNameAr(retSet.getString(2));
                medicalType.setMedicalTypeNameEn(retSet.getString(3));
             //   medicalType.setMedicalInsuranceId(retSet.getInt(4));

                allTypes.add(medicalType);
            }
            System.out.println(allTypes);

        } catch (SQLException ex) {
            Logger.getLogger(MedicalTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
            allTypes.removeAll(allTypes);
        }
        return allTypes;

    }

    @Override
    public boolean update(MedicalTypePojo type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(MedicalTypePojo type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
