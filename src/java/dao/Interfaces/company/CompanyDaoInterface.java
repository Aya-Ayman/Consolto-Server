/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.company;

import java.util.List;
import pojos.CompanyPojo;


/**
 *
 * @author Aya
 */
public interface CompanyDaoInterface {
    
     List<CompanyPojo> getAllCompanies();
    
    boolean insertCompany(CompanyPojo company);

    boolean updateCompany(CompanyPojo company);

    boolean deleteCompany(int id);
    
    CompanyPojo getCompany(int id);
   
    int getCompanyIdFromMail(String companyMail);
    
    
}
