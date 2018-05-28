/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.HospitalListPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface HospitalApi {

    public ResponseMessage insertHospital(@FormParam("name") String name, @FormParam("name_english") String name_english, @FormParam("address") String address, @FormParam("longitude") String longitude, @FormParam("latitude") String latitude, @FormParam("start_date") String start_date, @FormParam("end_date") String end_date, @FormParam("open_hour") String open_hour, @FormParam("close_hour") String close_hour, @FormParam("rate") int rate, @FormParam("ceo") String ceo, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3, @FormParam("c1") String dept1, @FormParam("c2") String dept2, @FormParam("c3") String dept3, @FormParam("c4") String dept4, @FormParam("c5") String dept5, @FormParam("c6") String dept6, @FormParam("c7") String dept7, @FormParam("c8") String dept8);

    public ResponseMessage deleteHospital(@PathParam("hospital_id") int hospital_id);

    public HospitalListPojo getAllHospitals();

}
