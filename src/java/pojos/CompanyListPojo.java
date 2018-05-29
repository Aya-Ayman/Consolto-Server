/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aya
 */
public class CompanyListPojo {
    
    ArrayList<CompanyPojo> companiesList;

    public CompanyListPojo(ArrayList<CompanyPojo> companiesList) {
        this.companiesList = companiesList;
    }

    public ArrayList<CompanyPojo> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(ArrayList<CompanyPojo> companiesList) {
        this.companiesList = companiesList;
    }
    
}
