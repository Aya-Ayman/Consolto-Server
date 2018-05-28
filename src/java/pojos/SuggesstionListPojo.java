/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;

/**
 *
 * @author Hagar
 */
public class SuggesstionListPojo {
     private ArrayList<SuggestionPojo> suggestions= new ArrayList<>();

    public ArrayList<SuggestionPojo> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(ArrayList<SuggestionPojo> suggestions) {
        this.suggestions = suggestions;
    }
     
     
     
}
