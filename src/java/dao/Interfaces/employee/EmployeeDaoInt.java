/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.employee;

import pojos.EmployeePojo;

/**
 *
 * @author hoda.CO
 */
public interface EmployeeDaoInt {
    
    public EmployeePojo retrieveByMailAndPassword(String mail, String password);
    
    public EmployeePojo retrieveByMail(String mail);
    
}
