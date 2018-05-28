/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Aya
 */
public class CompanyResponse {
    String Message;
    Boolean Status;
    String Error;
    CompanyPojo companyObject;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public CompanyPojo getCompanyObject() {
        return companyObject;
    }

    public void setCompanyObject(CompanyPojo companyObject) {
        this.companyObject = companyObject;
    }
    
    public CompanyResponse(String Message, Boolean Status, String Error, CompanyPojo companyObject) {
        this.Message = Message;
        this.Status = Status;
        this.Error = Error;
        this.companyObject = companyObject;
    }

    public CompanyResponse(String Message, Boolean Status, String Error) {
        this.Message = Message;
        this.Status = Status;
        this.Error = Error;
    }

    public CompanyResponse() {
    }
    
    
    

  
      
}
