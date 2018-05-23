/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.FormParam;
import org.codehaus.jettison.json.JSONObject;
import pojos.ResponseMessage;
import pojos.ResponseMessageWithId;

/**
 *
 * @author hoda.CO
 */
public interface EmployeeApiInt {
    
    public ResponseMessageWithId login(JSONObject login);
    public ResponseMessage getEmp(JSONObject mail);
    
}
