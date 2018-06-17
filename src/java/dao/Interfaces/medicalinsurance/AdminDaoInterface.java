/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.medicalinsurance;

import java.util.List;
import pojos.AdminPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface AdminDaoInterface {
        
     List<AdminPojo> getAllAdmins();
    
    boolean insertAdmin(AdminPojo admin);

    boolean deleteAdmin(int id);
    
    ResponseMessage getAdmin(AdminPojo admin);
 
}
