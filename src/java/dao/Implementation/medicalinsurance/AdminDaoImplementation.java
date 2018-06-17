/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.medicalinsurance;

import dao.Interfaces.medicalinsurance.AdminDaoInterface;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.AdminPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public class AdminDaoImplementation implements AdminDaoInterface{
    Connection connection = null;
    
    
    @Override
    public List<AdminPojo> getAllAdmins(){
     connection = DBConnection.getConnection();

        List<AdminPojo>allAdmins = new ArrayList<AdminPojo>();
        Statement s = null;
        ResultSet rs = null;
        String myQuery = "select * from admin";
        try {
            s = connection.createStatement();
            rs = s.executeQuery(myQuery);
            while (rs.next()) {
                AdminPojo admin = new AdminPojo(myQuery, myQuery, 0);
                admin.setId(rs.getInt(1));
                admin.setUsername(rs.getString(2));
                admin.setPassword(rs.getString(3));
                admin.setMedical_insurance_id(rs.getInt(4));
      
                allAdmins.add(admin);
               }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allAdmins;
}
    
    @Override
    public boolean insertAdmin(AdminPojo admin){
     connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        String myQuery = "insert into admin(username, password, medical_insurance_insurance_id) values(?, ?, ?)";
        int return_flage1 = 0;
     
        try {
            ps = connection.prepareStatement(myQuery);    
            ps.setString(1,admin.getUsername());
            ps.setString(2,admin.getPassword());
            ps.setInt(3,1);
            return_flage1 = ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(AdminPojo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_flage1 == 1;
    
    
    }

    @Override
    public boolean deleteAdmin(int id) {
       
        connection = DBConnection.getConnection();
                Statement s = null;
                String myQuery2 = "DELETE FROM admin WHERE id=";
                int return_flage = 0; 
        
                try{
                    s = connection.createStatement();
                    return_flage = s.executeUpdate(myQuery2 + id);
                }
                catch(SQLException ex2){
                   return_flage=0;
                }
                
                return return_flage == 1;
   }
            
    


    @Override
    public ResponseMessage getAdmin(AdminPojo admin) {
        int companyId = -1;
        connection = DBConnection.getConnection();
        ResponseMessage response = new ResponseMessage();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String myQuery = "select * from admin where username = ? AND password = ?";
        try {
            ps = connection.prepareStatement(myQuery);
            System.out.println("prepared statement is"+ps);
            ps.setString(1, admin.getUsername());
            ps.setString(2,admin.getPassword());
            rs= ps.executeQuery();
            while (rs.next()) {
                companyId = rs.getInt(1);
            }
             if(companyId > 0)
             {
                response.setError("0");
                response.setMessage("exist");
                response.setStatus(true);
             }
             else{
                  response.setError("1");
           response.setMessage("not exist");
            response.setStatus(false);
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
         return response; 
    }
}