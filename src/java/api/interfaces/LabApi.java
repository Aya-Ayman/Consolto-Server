/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.ArrayList;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.LabPojo;
import pojos.ResponsePojo;

/**
 *
 * @author Aya
 */
public interface LabApi {

    public ResponsePojo insertData(@FormParam("lab_name_en") String lab_name_en, @FormParam("lab_open_hour") String lab_open_hour, @FormParam("lab_close_hour") String lab_close_hour, @FormParam("lab_latitude") String lab_latitude, @FormParam("lab_longitude") String lab_longitude, @FormParam("lab_address") String lab_address, @FormParam("lab_start_date") String lab_start_date, @FormParam("lab_end_date") String lab_end_date, @FormParam("lab_rate") int lab_rate, @FormParam("lab_ceo") String lab_ceo, @FormParam("lab_name_ar") String lab_name_ar, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3, @FormParam("c1") String special1, @FormParam("c2") String special2, @FormParam("c3") String special3, @FormParam("c4") String special4, @FormParam("c5") String special5, @FormParam("c6") String special6, @FormParam("c7") String special7, @FormParam("c8") String special8);

    public ResponsePojo deleteLab(@PathParam("lab_id") int lab_id);

    public ArrayList<LabPojo> getLab();

}
