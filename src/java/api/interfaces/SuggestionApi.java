/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.List;
import pojos.ResponsePojo;
import pojos.SuggestionPojo;

/**
 *
 * @author Hagar
 */
public interface SuggestionApi {

    public ResponsePojo addSuggestion(SuggestionPojo suggest);

    public List<SuggestionPojo> getAllSuggesstions();

}
