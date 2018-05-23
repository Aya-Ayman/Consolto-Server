/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.suggesstion;

import dao.Interfaces.suggesstion.Suggestion;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.SuggestionPojo;

/**
 *
 * @author Hagar
 */
public class SuggestionImpl implements Suggestion {

    @Override
    public boolean create(SuggestionPojo suggest) {

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement insertCartQuery = connection.prepareStatement("INSERT INTO medical_insurance_suggestion (suggest_id , suggest_text,suggest_medical_type,suggest_location_latitude,suggest_location_longitude,location_address,suggest_contact_phone,suggest_supervisor,suggest_date,medical_service_name_ar,medical_service_name_en,employee_employee_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            insertCartQuery.setString(2, suggest.getSuggestText());
            insertCartQuery.setInt(3, suggest.getSuggestMedicalType());
            insertCartQuery.setDouble(4, suggest.getSuggestLocationLatitude());
            insertCartQuery.setDouble(5, suggest.getSuggestLocationLongitude());
            insertCartQuery.setString(6, suggest.getLocationAddress());
            insertCartQuery.setString(7, suggest.getSuggestContactPhone());
            insertCartQuery.setString(8, suggest.getSuggestSupervisor());
            insertCartQuery.setDate(9, suggest.getSuggestDate());
            insertCartQuery.setString(10, suggest.getMedicalServiceNameAr());
            insertCartQuery.setString(11, suggest.getMedicalServiceNameEn());
            insertCartQuery.setInt(12, suggest.getEmployeeEmployeeId());

            insertCartQuery.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SuggestionImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    @Override
    public List<SuggestionPojo> retrieve() {
        List<SuggestionPojo> allSuggesstions = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM medical_insurance_suggestion");

            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {
                SuggestionPojo suggest = new SuggestionPojo();
                suggest.setSuggestId(retSet.getInt(1));
                suggest.setSuggestText(retSet.getString(2));
                suggest.setSuggestMedicalType(retSet.getInt(3));
                suggest.setSuggestLocationLatitude(retSet.getDouble(4));
                suggest.setSuggestLocationLongitude(retSet.getDouble(5));
                suggest.setLocationAddress(retSet.getString(6));
                suggest.setSuggestContactPhone(retSet.getString(7));
                suggest.setSuggestSupervisor(retSet.getString(8));
                suggest.setSuggestDate(retSet.getDate(9));
                suggest.setMedicalServiceNameAr(retSet.getString(10));
                suggest.setMedicalServiceNameEn(retSet.getString(11));
                suggest.setEmployeeEmployeeId(retSet.getInt(12));

                allSuggesstions.add(suggest);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SuggestionImpl.class.getName()).log(Level.SEVERE, null, ex);
            allSuggesstions.removeAll(allSuggesstions);
        }
        return allSuggesstions;
    }

}
