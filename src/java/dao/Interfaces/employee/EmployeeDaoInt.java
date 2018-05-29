/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.employee;

import java.sql.SQLException;
import java.util.ArrayList;
import pojos.EmployeePojo;
import pojos.ResponseMessageWithEmployee;

/**
 *
 * @author hoda.CO
 */
public interface EmployeeDaoInt {

    public EmployeePojo retrieveByMailAndPassword(String mail, String password);

    public EmployeePojo retrieveByMail(String mail);

    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////
    public ArrayList<EmployeePojo> selectAllEmployees(int id) throws SQLException;

    public ResponseMessageWithEmployee select(int id) throws SQLException;

    public boolean deleteEmployee(int employeeId) throws SQLException;

    public ResponseMessageWithEmployee update(EmployeePojo emp) throws SQLException;

    public boolean insert(EmployeePojo emp) throws SQLException;

}
