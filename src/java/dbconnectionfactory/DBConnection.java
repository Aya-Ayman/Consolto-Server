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
<<<<<<< HEAD
    

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "admin";
    public static final String PASS = "admin";
=======
   
     public static final String URL = "jdbc:mysql://localhost:3306/medical_insurance_database";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    private static Connection connection;
>>>>>>> 5a2102115f5c2824dbe170cfb860b74fb7f0e136

    public static Connection getConnection() {
        try {
<<<<<<< HEAD
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(URL + "medical_insurance_database", USER, PASS);
=======
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
>>>>>>> 5a2102115f5c2824dbe170cfb860b74fb7f0e136
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
}
