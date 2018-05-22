/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.MedicalTypeApi;
import dao.Implementation.medicaltype.MedicalTypeImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    public List<MedicalTypePojo> getAllTypes() {
        MedicalTypeImpl type = new MedicalTypeImpl();
        List types = type.retrieve();

        if (!types.isEmpty()) {
            return types;
        } else {
            return null;
        }
    }

}
