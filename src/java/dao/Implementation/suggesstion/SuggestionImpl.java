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
            insertCartQuery.setInt(1, suggest.getSuggestId());
            insertCartQuery.setString(2, suggest.getDescription());
            insertCartQuery.setInt(3, suggest.getMedicalType());
            insertCartQuery.setDouble(4, suggest.getLatitude());
            insertCartQuery.setDouble(5, suggest.getLongitude());
            insertCartQuery.setString(6, suggest.getAddress());
            insertCartQuery.setString(7, suggest.getContactPhone());
            insertCartQuery.setString(8, suggest.getSupervisor());
            insertCartQuery.setString(9, suggest.getDate());
            insertCartQuery.setString(10, suggest.getMedicalServiceNameAr());
            insertCartQuery.setString(11, suggest.getMedicalServiceNameEn());
            insertCartQuery.setInt(12, suggest.getEmployeeId());

            insertCartQuery.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SuggestionImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    @Override
    public ArrayList<SuggestionPojo> retrieve() {
        ArrayList<SuggestionPojo> allSuggesstions = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM medical_insurance_suggestion");

            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {
                SuggestionPojo suggest = new SuggestionPojo();
                suggest.setSuggestId(retSet.getInt(1));
                suggest.setDescription(retSet.getString(2));
                suggest.setMedicalType(retSet.getInt(3));
                suggest.setLatitude(retSet.getDouble(4));
                suggest.setLongitude(retSet.getDouble(5));
                suggest.setAddress(retSet.getString(6));
                suggest.setContactPhone(retSet.getString(7));
                suggest.setSupervisor(retSet.getString(8));
                suggest.setDate(retSet.getString(9));
                suggest.setMedicalServiceNameAr(retSet.getString(10));
                suggest.setMedicalServiceNameEn(retSet.getString(11));
                suggest.setEmployeeId(retSet.getInt(12));

                allSuggesstions.add(suggest);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SuggestionImpl.class.getName()).log(Level.SEVERE, null, ex);
            allSuggesstions.removeAll(allSuggesstions);
        }
        return allSuggesstions;
    }
    
     @Override
    public SuggestionPojo retrieveOneSuggestion(int id) {

        SuggestionPojo retrievedSuggestion = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM medical_insurance_suggestion WHERE suggest_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                retrievedSuggestion = new SuggestionPojo();
                retrievedSuggestion.setSuggestId(rs.getInt(1));
                retrievedSuggestion.setDescription(rs.getString(2));
                retrievedSuggestion.setMedicalType(rs.getInt(3));
                retrievedSuggestion.setLatitude(rs.getDouble(4));
                retrievedSuggestion.setLongitude(rs.getDouble(5));
                retrievedSuggestion.setAddress(rs.getString(6));
                retrievedSuggestion.setContactPhone(rs.getString(7));
                retrievedSuggestion.setSupervisor(rs.getString(8));
                retrievedSuggestion.setDate(rs.getString(9));
                retrievedSuggestion.setMedicalServiceNameAr(rs.getString(10));
                retrievedSuggestion.setMedicalServiceNameEn(rs.getString(11));
                retrievedSuggestion.setEmployeeId(rs.getInt(12));
            }

           
        
        } catch (Exception ex) {

            System.out.println("Error in Suggestion Selection");
        }

        return retrievedSuggestion;

    }

}
