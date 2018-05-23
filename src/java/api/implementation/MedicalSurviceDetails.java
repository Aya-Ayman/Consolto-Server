/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.MedicalServiceDetailsApi;
import dao.Implementation.clinic.ClinicImpl;
import dao.Implementation.hospital.HospitalImpl;
import dao.Implementation.lab.LabImpl;
import dao.Implementation.pharmacy.PharmacyImpl;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ClinicPojo;
import pojos.HospitalPojo;
import pojos.LabPojo;
import pojos.PharmacyPojo;

/**
 *
 * @author Hagar
 */
@Path("/details")
public class MedicalSurviceDetails implements MedicalServiceDetailsApi {

    @Override
    @GET
    @Path("get/{tid}/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getDetails(@PathParam("tid") int tid, @PathParam("sid") int sid) {

        PharmacyPojo pharmacy = null;
        HospitalPojo hospital = null;
        ClinicPojo clinic = null;
        LabPojo lab = null;

        switch (tid) {
            case 1:
                PharmacyImpl obj = new PharmacyImpl();
                pharmacy = obj.retrieve(sid);
                return pharmacy;

            case 2:
                HospitalImpl obj2 = new HospitalImpl();
                hospital = obj2.retrieve(sid);
                return hospital;
            case 3:
                ClinicImpl obj3 = new ClinicImpl();
                clinic = obj3.retrieve(sid);
                return clinic;
            case 4:
                LabImpl obj4 = new LabImpl();
                lab = obj4.retrieve(sid);
                return lab;
        }
        return null;
    }

}
