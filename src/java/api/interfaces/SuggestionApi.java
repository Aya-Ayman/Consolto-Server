/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.PathParam;
import pojos.ResponsePojo;
import pojos.SuggesstionListPojo;
import pojos.SuggestionPojo;

/**
 *
 * @author Hagar
 */
public interface SuggestionApi {

    public ResponsePojo addSuggestion(SuggestionPojo suggest);

    public SuggesstionListPojo getAllSuggesstions() ;
	 
     public SuggestionPojo getOneSuggesstion(@PathParam("id") int id);

}
