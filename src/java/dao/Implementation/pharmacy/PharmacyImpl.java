/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.pharmacy;

import dao.Implementation.clinic.ClinicImpl;
import dao.Implementation.clinic.ClinicPhonesImplementation;
import dao.Implementation.review.ReviewsDaoImp;
import dao.Interfaces.pharmacy.Pharmacy;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.ClinicPojo;
import pojos.PharmacyPojo;
import pojos.ResultPojo;

/**
 *
 * @author Hagar
 */
public class PharmacyImpl implements Pharmacy {

    @Override
    public PharmacyPojo retrieve(int pharmacyId) {
        ReviewsDaoImp obj = new ReviewsDaoImp();
        PharmacyPojo pharmacy = null;
        ArrayList<String> phones = new ArrayList();
        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM pharmacy WHERE pharmacy_id=?");

            retrieveTypes.setInt(1, pharmacyId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                pharmacy = new PharmacyPojo();
                float rate = obj.reateAverage(retSet.getInt(1), retSet.getInt(12));

                pharmacy.setId(retSet.getInt(1));
                pharmacy.setNameEn(retSet.getString(2));
                pharmacy.setLatitude(retSet.getDouble(3));
                pharmacy.setLongitude(retSet.getDouble(4));
                pharmacy.setStartDate(retSet.getString(5));
                pharmacy.setEndDate(retSet.getString(6));
                pharmacy.setRate(rate);
                pharmacy.setAddress(retSet.getString(8));
                pharmacy.setOpenHour(retSet.getString(9));
                pharmacy.setCloseHour(retSet.getString(10));
                pharmacy.setNameAr(retSet.getString(11));
                pharmacy.setMedicalTypeId(retSet.getInt(12));
                pharmacy.setImage(retSet.getString(13));
                phones = phonesObj.getPharmacyPhones(retSet.getInt(1));
                pharmacy.setPharmacyPhones(phones);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PharmacyImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pharmacy;

    }

    @Override
    public boolean addPharmacy(PharmacyPojo pharmacy) {

        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO pharmacy (pharmacy_id,pharmacy_name_en,pharmacy_latitude,pharmacy_longitude,pharmacy_start_date,pharmacy_end_date,pharmacy_rate,pharmacy_address,pharmacy_open_hour,pharmacy_close_hour,pharmacy_name_ar,medical_type_medical_type_id,pharmacy_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, pharmacy.getId());
            insertPs.setString(2, pharmacy.getNameEn());
            insertPs.setDouble(3, pharmacy.getLatitude());
            insertPs.setDouble(4, pharmacy.getLongitude());
            insertPs.setString(5, pharmacy.getStartDate());
            insertPs.setString(6, pharmacy.getEndDate());
            insertPs.setFloat(7, pharmacy.getRate());
            insertPs.setString(8, pharmacy.getAddress());
            insertPs.setString(9, pharmacy.getOpenHour());
            insertPs.setString(10, pharmacy.getCloseHour());
            insertPs.setString(11, pharmacy.getNameAr());
            insertPs.setInt(12, pharmacy.getMedicalTypeId());
            insertPs.setString(13, pharmacy.getImage());
            int insertflag = insertPs.executeUpdate();

            boolean res = false;
            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT pharmacy_id FROM pharmacy WHERE pharmacy_name_ar=? OR pharmacy_name_en=?");
                getPs.setString(1, pharmacy.getNameAr());
                getPs.setString(2, pharmacy.getNameEn());

                ResultSet resSet = getPs.executeQuery();

                int id = 0;
                if (resSet.isBeforeFirst()) {
                    resSet.next();
                    id = resSet.getInt(1);
                    System.out.print(id);
                }
                res = phonesObj.addPharmacyPhones(id, pharmacy.getPharmacyPhones());
            }
            return res;

            //System.out.println("insert" + insertPs.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean deletePharmacy(int pharmacy_id) {
        int deletePhone;
        int deletePharmacy;
        boolean delete = false;
        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {

            deletePhone = phonesObj.deletePharmacyPhones(pharmacy_id);

            if (deletePhone != 0) {

                PreparedStatement deletePs = connection.prepareStatement("DELETE FROM pharmacy WHERE pharmacy_id =? ");
                deletePs.setInt(1, pharmacy_id);
                // deletePs.setInt(2,medical_type_id);

                deletePharmacy = deletePs.executeUpdate();
                if (deletePharmacy == 1) {
                    delete = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyImpl.class.getName()).log(Level.SEVERE, null, ex);
            delete = false;
        }

        return delete;
    }

    @Override
    public ArrayList<PharmacyPojo> getAllPharmacies() {
        //"INSERT INTO pharmacy (pharmacy_id,pharmacy_name_en,pharmacy_latitude,pharmacy_longitude,pharmacy_start_date,pharmacy_end_date,pharmacy_rate,pharmacy_address,pharmacy_open_hour,pharmacy_close_hour,pharmacy_name_ar,medical_type_medical_type_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

        ArrayList<PharmacyPojo> pharmacies = new ArrayList();
        ArrayList<String> phones = new ArrayList();
        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM pharmacy");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                PharmacyPojo pharmacy = new PharmacyPojo();
                pharmacy.setId(retSet.getInt(1));
                pharmacy.setNameEn(retSet.getString(2));
                pharmacy.setLatitude(retSet.getDouble(3));
                pharmacy.setLongitude(retSet.getDouble(4));
                pharmacy.setStartDate(retSet.getString(5));
                pharmacy.setEndDate(retSet.getString(6));
                pharmacy.setRate(retSet.getInt(7));
                pharmacy.setAddress(retSet.getString(8));
                pharmacy.setOpenHour(retSet.getString(9));
                pharmacy.setCloseHour(retSet.getString(10));
                pharmacy.setNameAr(retSet.getString(11));
                pharmacy.setMedicalTypeId(retSet.getInt(12));
                pharmacy.setImage(retSet.getString(13));
                phones = phonesObj.getPharmacyPhones(retSet.getInt(1));
                pharmacy.setPharmacyPhones(phones);
                pharmacies.add(pharmacy);
                //System.out.print(retSet.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return pharmacies;

    }

    public ArrayList<ResultPojo> searchPharmacy(String input) {

        ArrayList<ResultPojo> results = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT pharmacy_id , medical_type_medical_type_id FROM pharmacy where pharmacy_name_en like ? OR pharmacy_name_ar like ?");


            retrievePs.setString(1,input+"%" );
           retrievePs.setString(2,input+"%");
          //  retrievePs.setString(3, "%"+ input+"%");

            retrievePs.setString(1, input + "%");
            retrievePs.setString(2, input + "%");
            //  retrievePs.setString(3, "%"+ input+"%");


            ResultSet retSet = retrievePs.executeQuery();

            while (retSet.next()) {
                ResultPojo pharmacy = new ResultPojo();
                pharmacy.setId(retSet.getInt(1));


                pharmacy.setTypeId(retSet.getInt(2)); //this one
                results.add(pharmacy);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return results;
    }

    
    public boolean updatePharmacy(PharmacyPojo pharmacy) {
                                        System.out.println("updatePharmacy");

        PharmacyPhonesImplementation phonesObj = new PharmacyPhonesImplementation();
            boolean isInserted=false;

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement updatePs = connection.prepareStatement("UPDATE pharmacy SET pharmacy_name_en=?, pharmacy_latitude=? ,pharmacy_longitude=? ,pharmacy_start_date=? ,pharmacy_end_date=? ,pharmacy_rate=? ,pharmacy_address=? ,pharmacy_open_hour=? ,pharmacy_close_hour=? ,pharmacy_name_ar=? ,medical_type_medical_type_id=? ,pharmacy_image=? where pharmacy_id=? ");
            updatePs.setString(1, pharmacy.getNameEn());
            updatePs.setDouble(2, pharmacy.getLatitude());
            updatePs.setDouble(3, pharmacy.getLongitude());
            updatePs.setString(4, pharmacy.getStartDate());
            updatePs.setString(5, pharmacy.getEndDate());
            updatePs.setFloat(6, pharmacy.getRate());
            updatePs.setString(7, pharmacy.getAddress());
            updatePs.setString(8, pharmacy.getOpenHour());
            updatePs.setString(9, pharmacy.getCloseHour());
            updatePs.setString(10, pharmacy.getNameAr());
            updatePs.setInt(11, pharmacy.getMedicalTypeId());
            updatePs.setString(12, pharmacy.getImage());
            updatePs.setInt(13, pharmacy.getId());

            int updateflag = updatePs.executeUpdate();

            int isDeleted ;
            if (updateflag == 1) {

              isDeleted=phonesObj.deletePharmacyPhones(pharmacy.getId());
                                System.out.println("is deleted"+isInserted);

              if(isDeleted!=0)
              {
              isInserted=phonesObj.addPharmacyPhones(pharmacy.getId(), pharmacy.getPharmacyPhones());
                  System.out.println("is inserted"+isInserted);
              }
              

            }
           

            // System.out.println("insert" + );
        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);
            isInserted= false;
        }

        return isInserted;
    }
   
    
     
    public int retrievePharmaciesCount() {
        int count = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement retrieve = connection.prepareStatement("SELECT COUNT(pharmacy_id) AS count FROM pharmacy ");
          

            ResultSet retSet = retrieve.executeQuery();
            while (retSet.next()) {
                count = retSet.getInt("count");  

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
