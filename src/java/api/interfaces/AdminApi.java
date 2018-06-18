/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.PathParam;
import pojos.AdminListPojo;
import pojos.AdminPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface AdminApi {
   AdminListPojo retriveAdmins();
    ResponseMessage retriveAdmin(AdminPojo admin);
    ResponseMessage insertAdmin (AdminPojo admin); 
   ResponseMessage delete(@PathParam("id")int id); 
}
