/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.SuggestionApi;
import dao.Implementation.suggesstion.SuggestionImpl;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ClinicPojo;
import pojos.ResponsePojo;
import pojos.SuggesstionListPojo;
import pojos.SuggestionPojo;
import pojos.ServicesNumber;

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
            response.setMessage("Suggest Sent successfully");
            response.setError(0);

            return response;
        }
    }

    @Override
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public SuggesstionListPojo getAllSuggesstions() {
        SuggestionImpl obj = new SuggestionImpl();
        ArrayList<SuggestionPojo> suggesstions = new ArrayList();
        SuggesstionListPojo suggesstionList = new SuggesstionListPojo();
        suggesstions = obj.retrieve();
        suggesstionList.setSuggestions(suggesstions);
        if (!suggesstions.isEmpty()) {
            return suggesstionList;
        } else {
            return null;
        }

    }

    @Override
    @GET
    @Path("/get/suggestionID={id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SuggestionPojo getOneSuggesstion(@PathParam("id") int id) {
        SuggestionImpl obj = new SuggestionImpl();
        SuggestionPojo suggesstion = new SuggestionPojo();
        suggesstion = obj.retrieveOneSuggestion(id);

        return suggesstion;
    }

    @Override
    @GET
    @Path("/get/suggestionOfMedicalServiceId={id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ServicesNumber reteriveSuggestionsNumberForMedicalService(@PathParam("id") int id) {
        int count = 0;
        SuggestionImpl suggesstion = new SuggestionImpl();
        ServicesNumber number = new ServicesNumber();
        count = suggesstion.reteriveMedicalServiceSuggestionsNumber(id);
        number.setServiceNumbers(count);
        return number;
    }
}
