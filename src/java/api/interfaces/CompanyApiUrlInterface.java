/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.CompanyListPojo;
import pojos.CompanyPojo;
import pojos.CompanyResponse;
import pojos.ResponseMessage;


/**
 *
 * @author Aya
 */
public interface CompanyApiUrlInterface {
  CompanyListPojo retrive();
CompanyResponse retriveCompany(@PathParam("id")int id);
ResponseMessage setData (CompanyPojo companyPojo);
CompanyResponse update(CompanyPojo companyPojo);
 
ResponseMessage delete(@PathParam("id")int id);
}
