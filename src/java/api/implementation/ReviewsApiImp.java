/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.ReviewsApiInt;
import dao.Implementation.review.ReviewsDaoImp;
import dao.Implementation.suggesstion.SuggestionImpl;
import dao.Interfaces.review.ReviewsDaoInt;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ResponseMessage;
import pojos.ReviewsList_Pojo;
import pojos.ReviewsPojo;
import pojos.ServicesNumber;
import pojos.SuggestionPojo;

/**
 *
 * @author hoda.CO
 */

@Path("/reviews")
public class ReviewsApiImp implements ReviewsApiInt{

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage setReview(ReviewsPojo review) {
        ResponseMessage response = new ResponseMessage();
        ReviewsDaoInt revv = new ReviewsDaoImp();
        Boolean stat =revv.create(review);
        if (stat)
        {
           response.setMessage("review added");
           response.setStatus(true);
           response.setError("200");
           return response;
        }else
        {
           response.setMessage("review not added");
           response.setStatus(false);
           response.setError("404");
           return response;
        }
    }
    
    @GET
    @Path("/retrieve")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ReviewsList_Pojo getAllReviews() {
        ReviewsDaoInt revv = new ReviewsDaoImp();
        ReviewsList_Pojo all =revv.retrieveAll();
        return all;
    }
 
    @GET
    @Path("/get/typeid={typeid}/serviceid={serviceid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ReviewsList_Pojo getOneReview(@PathParam("typeid") int type_id,@PathParam("serviceid") int service_id){
         ReviewsDaoInt obj = new ReviewsDaoImp();
        ReviewsList_Pojo all  = obj.retrieveOneReview(type_id, service_id);
        return all;
    }

    @Override
     @GET
    @Path("/get/reviewOfMedicalServiceId={id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ServicesNumber reteriveReviewssNumberForMedicalService(@PathParam("id") int id) {

        int count = 0;
        ReviewsDaoImp review = new ReviewsDaoImp();
        ServicesNumber number = new ServicesNumber();
        count = review.reteriveMedicalServiceReviewssNumber(id);
        number.setServiceNumbers(count);
        return number;
    }
    }
