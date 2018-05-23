/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.company;

import java.util.List;

/**
 *
 * @author Aya
 */
public interface CompanyPhoneDaoInterface {
     public List<String> getCompanyPhone(int id);
    public boolean insertCompanyPhone (int companyId,List<String> phoneList);
     int deleteCompanyPhone (int companyId);
}
