/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Mayada Saleh
 */
public class ResponseMessageWithEmployee {
    
    ResponseMessage responseMessage = new ResponseMessage();
    EmployeePojo employeePojo = new EmployeePojo();

    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }

    public EmployeePojo getEmployeePojo() {
        return employeePojo;
    }

    public void setEmployeePojo(EmployeePojo employeePojo) {
        this.employeePojo = employeePojo;
    }
    
    
    
    
}
