/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.ArrayList;
import javax.ws.rs.PathParam;
import pojos.ResponseMessage;
import pojos.ReviewsList_Pojo;
import pojos.ReviewsPojo;
import pojos.ServicesNumber;

/**
 *
 * @author hoda.CO
 */
public interface ReviewsApiInt {

    public ResponseMessage setReview(ReviewsPojo review);

    public ReviewsList_Pojo getAllReviews();

    public ReviewsList_Pojo getOneReview(@PathParam("typeid") int type_id, @PathParam("serviceid") int service_id);

    public ServicesNumber reteriveReviewssNumberForMedicalService(@PathParam("id") int id);

}
