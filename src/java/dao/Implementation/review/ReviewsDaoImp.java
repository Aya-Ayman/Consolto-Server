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
     public float reateAverage(int serviceId, int medicalTypeId) {
        float average = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement retrieveall = connection.prepareStatement("SELECT AVG(review_rate) AS average FROM reviews where service_id=? AND medicaltype_id=?");
            retrieveall.setInt(1, serviceId);
            retrieveall.setInt(2, medicalTypeId);
                System.out.println("serviceId is "+ serviceId);
                System.out.println("medicalTypeId is "+ medicalTypeId);

            ResultSet retSet = retrieveall.executeQuery();
            while (retSet.next()) {
                average = retSet.getFloat("average");  

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return average;
    }

    @Override
    public ReviewsList_Pojo retrieveOneReview(int type_id, int service_id) {
        ArrayList<ReviewsPojo> allreviews = new ArrayList<ReviewsPojo>();
         
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM reviews WHERE medicaltype_id = ? AND service_id= ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, type_id);
            pst.setInt(2, service_id);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReviewsPojo retrievedReview = new ReviewsPojo();
                retrievedReview.setReviewId(rs.getInt(1));
                retrievedReview.setMedicalTypeId(rs.getInt(2));
                retrievedReview.setServiceId(rs.getInt(3));
                retrievedReview.setDescription(rs.getString(4));
                retrievedReview.setDate(rs.getString(5));
                retrievedReview.setType(rs.getString(6));
                retrievedReview.setEmployeeEmployeeId(rs.getInt(7));
                retrievedReview.setReviewRate(rs.getFloat(8)); 
                allreviews.add(retrievedReview);
            }      
        } catch (Exception ex) {

            System.out.println("Error in Suggestion Selection");
        }
        ReviewsList_Pojo all = new ReviewsList_Pojo();
        all.setList_review(allreviews);
        return all;
    }

    @Override
    public int reteriveMedicalServiceReviewssNumber(int id) {
int count = 0;
        try {
            Connection con = null;
            ResultSet rs = null;
            PreparedStatement pst = null;

            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT COUNT(review_id) as reviewsNumbers,medicaltype_id FROM reviews WHERE medicaltype_id=? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                count = rs.getInt("reviewsNumbers");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;



    }

    }
