/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;

/**
 *
 * @author Mayada Saleh
 */
public class EmployeeListObject {
    
    
    
   private ArrayList<EmployeePojo> EmployeeListObject = new ArrayList<EmployeePojo>();

    public ArrayList<EmployeePojo> getEmployeeListObject() {
        return EmployeeListObject;
    }

    public void setEmployeeListObject(ArrayList<EmployeePojo> EmployeeListObject) {
        this.EmployeeListObject = EmployeeListObject;
    }
}
