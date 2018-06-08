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
public class ListOfAllResultsPojo {
               private ArrayList<ResultListPojo> allResults= new ArrayList<>();

    public ArrayList<ResultListPojo> getAllResults() {
        return allResults;
    }

    public void setAllResults(ArrayList<ResultListPojo> allResults) {
        this.allResults = allResults;
    }
               
               

}
