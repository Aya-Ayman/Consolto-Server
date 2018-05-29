/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.review;


import dao.Interfaces.review.ReviewsDaoInt;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.ReviewsList_Pojo;
import pojos.ReviewsPojo;

/**
 *
 * @author hoda.CO
 */
public class ReviewsDaoImp implements ReviewsDaoInt {

    @Override
    public boolean create(ReviewsPojo review) {
         try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO reviews (medicaltype_id,service_id,description,date,type,employee_employee_id,review_rate)  VALUES(?,?,?,?,?,?,?)");
            System.out.println(review);
            insertPs.setInt(1, review.getMedicalTypeId());
            insertPs.setInt(2, review.getServiceId());
            insertPs.setString(3, review.getDescription());
            insertPs.setString(4,review.getDate());
            insertPs.setString(5, review.getType());
            insertPs.setInt(6,review.getEmployeeEmployeeId());
            insertPs.setFloat(7,review.getReviewRate());
            System.out.println("DB CONNN " + insertPs.executeUpdate());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ReviewsList_Pojo retrieveAll() {
        ArrayList<ReviewsPojo> allreviews = new ArrayList<ReviewsPojo>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement retrieveall = connection.prepareStatement("SELECT * FROM reviews");
            ResultSet retSet = retrieveall.executeQuery();
            while (retSet.next()) {
                ReviewsPojo review = new ReviewsPojo();
                review.setReviewId(retSet.getInt("review_id"));
                review.setMedicalTypeId(retSet.getInt("medicaltype_id"));
                review.setReviewRate(retSet.getFloat("review_rate"));
                review.setServiceId(retSet.getInt("service_id"));
                review.setEmployeeEmployeeId(retSet.getInt("employee_employee_id"));
                review.setDescription(retSet.getString("description"));
                review.setType(retSet.getString("type"));
                review.setDate(retSet.getString("date"));
                allreviews.add(review);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        ReviewsList_Pojo all = new ReviewsList_Pojo();
        all.setList_review(allreviews);
        return all;
    }
}
