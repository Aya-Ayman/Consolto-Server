/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.ArrayList;
import pojos.ResponseMessage;
import pojos.ReviewsPojo;

/**
 *
 * @author hoda.CO
 */
public interface ReviewsApiInt {
     public ResponseMessage setReview(ReviewsPojo review);
      public ArrayList<ReviewsPojo> getAllReviews();
}
