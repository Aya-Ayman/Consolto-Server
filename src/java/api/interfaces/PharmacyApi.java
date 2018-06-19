/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.PharmacyListPojo;
import pojos.PharmacyPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface PharmacyApi {

    public ResponseMessage insertPharmacy(@FormParam("pharmacy_name_en") String pharmacy_name_en, @FormParam("pharmacy_latitude") String pharmacy_latitude, @FormParam("pharmacy_longitude") String pharmacy_longitude, @FormParam("pharmacy_start_date") String pharmacy_start_date, @FormParam("pharmacy_end_date") String pharmacy_end_date, @FormParam("pharmacy_rate") float pharmacy_rate, @FormParam("pharmacy_address") String pharmacy_address, @FormParam("pharmacy_open_hour") String pharmacy_open_hour, @FormParam("pharmacy_close_hour") String pharmacy_close_hour, @FormParam("pharmacy_name_ar") String pharmacy_name_ar, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3,@FormParam("urlImage") String urlImage);

    public ResponseMessage deletePharmacy(@PathParam("pharmacy_id") int pharmacy_id);

    public PharmacyListPojo getAllPharmacies();

    public ResponseMessage update(PharmacyPojo pharmacy);
    
    public int retrievePharmaciesCount();

}
