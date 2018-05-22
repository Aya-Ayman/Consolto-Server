/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hagar
 */
public class DBConnection {
    

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "admin";
    public static final String PASS = "admin";

    /**
     * public constructor used to get a connection and return it.
     *
     * @return connection object to the database
     */
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(URL + "medical_insurance_database", USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("RuntimeExceptionError connecting to the database", ex);
        }
    }
    
}
