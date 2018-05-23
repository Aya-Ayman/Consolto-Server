/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.ReviewsApiInt;
import dao.Implementation.review.ReviewsDaoImp;
import dao.Interfaces.review.ReviewsDaoInt;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ResponseMessage;
import pojos.ReviewsPojo;

/**
 *
 * @author hoda.CO
 */

@Path("/reviews")
public class ReviewsApiImp implements ReviewsApiInt{

    @POST
    @Path("/insert")
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
    public ArrayList<ReviewsPojo> getAllReviews() {
        ResponseMessage response = new ResponseMessage();
        ReviewsDaoInt revv = new ReviewsDaoImp();
        ArrayList<ReviewsPojo> all =revv.retrieveAll();
        return all;
    }
    
}
