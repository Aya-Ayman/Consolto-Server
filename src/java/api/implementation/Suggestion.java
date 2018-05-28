/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.SuggestionApi;
import dao.Implementation.suggesstion.SuggestionImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ResponsePojo;
import pojos.SuggestionPojo;

/**
 *
 * @author Hagar
 */
@Path("/suggestion")
public class Suggestion implements SuggestionApi {

    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public ResponsePojo addSuggestion(SuggestionPojo suggest) {
        ResponsePojo response = new ResponsePojo();

        SuggestionImpl suggesstion = new SuggestionImpl();
        if (suggesstion.create(suggest) == false) {
            response.setStatus(false);
            response.setMessage("Suggest Already Sent!");
            response.setError(0);
            return response;
        } else {
            response.setStatus(true);
            System.out.println("ya rab 5leek m3ana w mtshmtsh el23da2 feena");
            response.setMessage("Suggest Sent successfully");
            response.setError("0");

            return response;
        }
    }

    @Override
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SuggestionPojo> getAllSuggesstions() {
        SuggestionImpl obj = new SuggestionImpl();
        List suggesstions = obj.retrieve();

        if (!suggesstions.isEmpty()) {
            return suggesstions;
        } else {
            return null;
        }

    }

}
