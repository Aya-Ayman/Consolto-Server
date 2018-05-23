/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoda.CO
 */
public class DBConnection {
   
    
    
      public static final String URL= "jdbc:mysql://localhost:3306/medical_insurance_database";
    public static final String USER = "root";
    public static final String PASS = "";

    /**
     * public constructor used to get a connection and return it.
     *
     * @return connection object to the database
     */
    public static Connection getConnection() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DriverManager.getConnection(URL ,USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("RuntimeExceptionError connecting to the database", ex);
        }
    }
    
}
