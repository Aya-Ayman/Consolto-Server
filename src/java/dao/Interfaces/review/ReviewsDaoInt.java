/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.review;

import java.util.ArrayList;
import pojos.ReviewsPojo;


/**
 *
 * @author hoda.CO
 */
public interface ReviewsDaoInt {
    
    public boolean create(ReviewsPojo review);
    
    public ArrayList<ReviewsPojo> retrieveAll();
}
