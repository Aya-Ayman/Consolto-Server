/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.company;

import dao.Implementation.employee.EmployeeDaoImp;
import dao.Interfaces.company.CompanyDaoInterface;
import dao.Interfaces.company.CompanyPhoneDaoInterface;
import dao.Interfaces.employee.EmployeeDaoInt;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.CompanyPojo;
import pojos.CompanyResponse;
import pojos.EmployeePojo;


/**
 *
 * @author Aya
 */
public class CompanyDaoImplementation implements CompanyDaoInterface{
    Connection connection = null;
    
    
    @Override
    public CompanyResponse getCompany(int id) {
        CompanyPojo company = new CompanyPojo();
         CompanyResponse companyResponse = new CompanyResponse();
         List<String>phoneList;
        connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String myQuery = "select * from company where company_id = ?";
        
        try {
            ps = connection.prepareStatement(myQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                company.setId(rs.getInt(1));
                company.setEmail(rs.getString(2));
                company.setLatitude(rs.getDouble(3));
                company.setLongitude(rs.getDouble(4));
                company.setAddress(rs.getString(5));
                company.setPackageType(rs.getFloat(6));
                company.setName(rs.getString(7));
                company.setStartDate(rs.getString(8));
                company.setEndDate(rs.getString(9));
                company.setCeo(rs.getString(10));
                company.setMedicalInsuranceId(rs.getInt(11));
         
                CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
                phoneList = companyPhoneObject.getCompanyPhone(company.getId());
                company.setPhones((ArrayList<String>) phoneList);
                companyResponse = new CompanyResponse("company returned", true, "0", company);
                
            }
            else{
               companyResponse = new CompanyResponse("company not returned", false, "1");
            }
        } catch (SQLException ex) {
           companyResponse = new CompanyResponse("company not returned", false, "1");
 
        }
        return companyResponse;
    }
    
    
    
    @Override
    public List<CompanyPojo> getAllCompanies() {
        connection = DBConnection.getConnection();

        List<CompanyPojo>allCompanies = new ArrayList<CompanyPojo>();
       List<String>phoneList;
        Statement s = null;
        ResultSet rs = null;
        String myQuery = "select * from company";
        try {
            s = connection.createStatement();
            rs = s.executeQuery(myQuery);
            while (rs.next()) {
                CompanyPojo company = new CompanyPojo();
                company.setId(rs.getInt(1));
                company.setEmail(rs.getString(2));
                company.setLatitude(rs.getDouble(3));
                company.setLongitude(rs.getDouble(4));
                company.setAddress(rs.getString(5));
                company.setPackageType(rs.getFloat(6));
                company.setName(rs.getString(7));
                company.setStartDate(rs.getString(8));
                company.setEndDate(rs.getString(9));
                company.setCeo(rs.getString(10));
                company.setMedicalInsuranceId(rs.getInt(11));

               CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
                phoneList = companyPhoneObject.getCompanyPhone(company.getId());
                company.setPhones((ArrayList<String>) phoneList);
                allCompanies.add(company);
               }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCompanies;
    }
    
    @Override
    public int getCompanyIdFromMail(String companyMail){
        int companyId = -1;
        connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String myQuery = "select company_id from company where company_email = ?";
        try {
            ps = connection.prepareStatement(myQuery);
            ps.setString(1, companyMail);
            rs= ps.executeQuery();
            while (rs.next()) {
                companyId = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
         return companyId;
    }
    
    
    

    @Override
    public boolean insertCompany(CompanyPojo company) {
        connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        String myQuery = "insert into company(company_email, company_latitude, company_longitude, company_address, company_package_type, company_name, company_start_date, company_end_date, company_ceo, medical_insurance_insurance_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int return_flage1 = 0;

        int companyId = -1 ;
        boolean isInserted=false;
        try {
            ps = connection.prepareStatement(myQuery);    
            ps.setString(1, company.getEmail());
            ps.setDouble(2,company.getLatitude());
            ps.setDouble(3,company.getLongitude());
            ps.setString(4,company.getAddress());
            ps.setFloat(5, company.getPackageType());
            ps.setString(6,company.getName());
            ps.setString(7,company.getStartDate());
            ps.setString(8,company.getEndDate());
            ps.setString(9,company.getCeo());
            ps.setInt(10,company.getMedicalInsuranceId());
            return_flage1 = ps.executeUpdate();
           
            CompanyDaoInterface implObject = new CompanyDaoImplementation();
            companyId = implObject.getCompanyIdFromMail(company.getEmail());
            
            CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
            isInserted = companyPhoneObject.insertCompanyPhone(companyId, company.getPhones());
           
        } catch (SQLException ex) {
            Logger.getLogger(CompanyPojo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_flage1 == 1 && isInserted ;
    }

    
    
    
    
    @Override
    public boolean updateCompany(CompanyPojo company) {
        connection = DBConnection.getConnection();

        PreparedStatement ps = null;
        String myQuery = "UPDATE company SET company_email = ?, company_name=?, company_latitude=?, company_longitude=?, company_address=?, company_package_type=?, company_start_date=?, company_end_date=?, company_ceo=?, medical_insurance_insurance_id=? WHERE company_id=?";
        int return_flage = 0;

          boolean isInserted = false;

        
        try {
            ps = connection.prepareStatement(myQuery);
            
            ps.setString(1, company.getEmail());
            ps.setString(2, company.getName());
            ps.setDouble(3, company.getLatitude());
            ps.setDouble(4, company.getLongitude());
            ps.setString(5,company.getAddress());
            ps.setFloat(6, company.getPackageType());
            ps.setString(7, company.getStartDate());
            ps.setString(8, company.getEndDate());
            ps.setString(9,company.getCeo());
            ps.setInt(10, company.getMedicalInsuranceId());
            ps.setInt(11, company.getId());
            return_flage = ps.executeUpdate();
            
            if(return_flage==1)
            {
              CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
               return_flage = companyPhoneObject.deleteCompanyPhone(company.getId());
               
              if(return_flage != 0)
              {
               isInserted = companyPhoneObject.insertCompanyPhone(company.getId(), company.getPhones());
              }
          }
       
        } catch (SQLException ex) {
            isInserted = false;            
        }
        return isInserted;
    }
    
    
    
    

    @Override
    public boolean deleteCompany(int id) {
            
                connection = DBConnection.getConnection();
                Statement s = null;
                String myQuery2 = "DELETE FROM company WHERE company_id=";
                ArrayList<EmployeePojo> employeeOfCompany;
                int return_flage = 0;
              try{  
                EmployeeDaoInt employeeObject = new EmployeeDaoImp();
                employeeOfCompany= employeeObject.selectAllEmployees(id);
                int size = employeeOfCompany.size();
                int i = 0;
                while(size>0)
                {
                  employeeObject.deleteEmployee(employeeOfCompany.get(i).getEmployeeId());
                  i++;
                  size--;
                }
              }
              catch(SQLException ex){
               Logger.getLogger(CompanyDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("can't delete employees");
            }
                CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
                return_flage = companyPhoneObject.deleteCompanyPhone(id);
              
                try{
                    s = connection.createStatement();
                    return_flage = s.executeUpdate(myQuery2 + id);
                }
                catch(SQLException ex2){
                   return_flage=0;
                }
                
                return return_flage == 1;
            }
            
    
    
}
    
   
