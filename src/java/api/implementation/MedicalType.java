/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.MedicalTypeApi;
import dao.Implementation.medicaltype.MedicalTypeImpl;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.MedicalTypeListPojo;
import pojos.MedicalTypePojo;

/**
 *
 * @author Hagar
 */
@Path("/medicaltype")
public class MedicalType implements MedicalTypeApi {
    
    @Override
    @GET
    @Path("/gettypes")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalTypeListPojo getAllTypes() {
        MedicalTypeImpl type = new MedicalTypeImpl();
        MedicalTypeListPojo list = new MedicalTypeListPojo();
       ArrayList<MedicalTypePojo> types= new ArrayList<>();

         types = type.retrieve();
         list.setTypes(types);

        if (!types.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

}
