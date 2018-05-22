/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.suggesstion;

import java.util.List;
import pojos.SuggestionPojo;

/**
 *
 * @author Hagar
 */
public interface Suggestion {

    public boolean create(SuggestionPojo suggest);

    public List<SuggestionPojo> retrieve();

}
