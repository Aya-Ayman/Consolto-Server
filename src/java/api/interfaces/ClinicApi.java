/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.ArrayList;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.ClinicListPojo;
import pojos.ClinicPojo;
import pojos.ResponseMessage;
import pojos.ResponsePojo;

/**
 *
 * @author Aya
 */
public interface ClinicApi {

    public ResponseMessage insertClinic(@FormParam("clinic_longitude") String clinic_longitude, @FormParam("clinic_latitude") String clinic_latitude, @FormParam("clinic_address") String clinic_address, @FormParam("clinic_specialization") String clinic_specialization, @FormParam("clinic_end_date") String clinic_end_date, @FormParam("clinic_start_date") String clinic_start_date, @FormParam("clinic_open_hour") String clinic_open_hour, @FormParam("clinic_close_hour") String clinic_close_hour, @FormParam("clinic_rate") int clinic_rate, @FormParam("clinic_doctor_name_en") String clinic_doctor_name_en, @FormParam("clinic_doctor_name_ar") String clinic_doctor_name_ar, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("phone3") String phone3);

    public ResponseMessage deleteClinic(@PathParam("clinic_id") int clinic_id);

    public ClinicListPojo getAllClinics();

}
