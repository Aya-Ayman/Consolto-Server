/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.PathParam;
import pojos.HospitalListPojo;
import pojos.HospitalPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface HospitalApi {

    public ResponseMessage insertHospital(HospitalPojo hospital);

    public ResponseMessage deleteHospital(@PathParam("hospital_id") int hospital_id);

    public HospitalListPojo getAllHospitals();

    public ResponseMessage update(HospitalPojo hospital);

}
