/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.CompanyPojo;
import pojos.ResponseMessage;


/**
 *
 * @author Aya
 */
public interface CompanyApiUrlInterface {
  List retrive();
CompanyPojo retriveCompany(@PathParam("id")int id);
ResponseMessage setData (@FormParam("name")String name,@FormParam("email")String email,@FormParam("latitude")String latitude,@FormParam("longitude")String longitude,@FormParam("address")String address,@FormParam("companyPackage")String companyPackage,@FormParam("startDate")String startDate,@FormParam("endDate")String endDate,@FormParam("ceo")String ceo,@FormParam("insuranceId")int insuranceId,@FormParam("phone1")String phone1,@FormParam("phone2")String phone2,@FormParam("phone3")String phone3);
ResponseMessage update(@FormParam("name")String name,@FormParam("email")String email,@FormParam("latitude")String latitude,@FormParam("longitude")String longitude,@FormParam("address")String address,@FormParam("companyPackage")String companyPackage,@FormParam("startDate")String startDate,@FormParam("endDate")String endDate,@FormParam("ceo")String ceo,@FormParam("insuranceId")int insuranceId,@FormParam("phone1")String phone1,@FormParam("phone2")String phone2,@FormParam("phone3")String phone3,@PathParam("id")int id);
 
ResponseMessage delete(@PathParam("id")int id);
}
