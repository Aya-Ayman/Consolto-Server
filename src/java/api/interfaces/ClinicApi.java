/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.PathParam;
import pojos.ClinicListPojo;
import pojos.ClinicPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface ClinicApi {

    public ResponseMessage insertClinic(ClinicPojo clinic);

    public ResponseMessage deleteClinic(@PathParam("clinic_id") int clinic_id);

    public ClinicListPojo getAllClinics();

    public ResponseMessage update(ClinicPojo clinic);

}
