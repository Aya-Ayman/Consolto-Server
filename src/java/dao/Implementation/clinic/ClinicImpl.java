/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.clinic;

import dao.Implementation.review.ReviewsDaoImp;
import dao.Interfaces.clinic.Clinic;
import dbconnectionfactory.DBConnection;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.ClinicPojo;
import pojos.ResultPojo;

/**
 *
 * @author Hagar
 */
public class ClinicImpl implements Clinic {

    @Override
    public ClinicPojo retrieve(int clinicId) {
        ArrayList<String> phones = new ArrayList();
        ReviewsDaoImp obj = new ReviewsDaoImp();

        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();
        ClinicPojo clinic = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM clinic WHERE clinic_id=?");

            retrieveTypes.setInt(1, clinicId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                clinic = new ClinicPojo();
                float rate = obj.reateAverage(retSet.getInt(1), retSet.getInt(13));

                clinic.setId(retSet.getInt(1));
                clinic.setLongitude(retSet.getDouble(2));
                clinic.setLatitude(retSet.getDouble(3));
                clinic.setAddress(retSet.getString(4));
                clinic.setSpecialization(retSet.getString(5));
                clinic.setEndDate(retSet.getString(6));
                clinic.setStartDate(retSet.getString(7));
                clinic.setOpenHour(retSet.getString(8));
                clinic.setCloseHour(retSet.getString(9));
                clinic.setRate(rate);
                clinic.setDoctorNameEn(retSet.getString(11));
                clinic.setDoctorNameAr(retSet.getString(12));
                clinic.setMedicalTypeId(retSet.getInt(13));
                clinic.setImage(retSet.getString(14));
                phones = phonesObj.getClinicPhones(retSet.getInt(1));
                clinic.setPhones(phones);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clinic;

    }

    @Override
    public boolean addClinic(ClinicPojo clinic) {
        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO clinic (clinic_id,clinic_longitude,clinic_latitude,clinic_address,clinic_specialization,clinic_end_date,clinic_start_date,clinic_open_hour,clinic_close_hour,clinic_rate,clinic_doctor_name_en,clinic_doctor_name_ar,medical_type_medical_type_id,clinic_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, clinic.getId());
            insertPs.setDouble(2, clinic.getLongitude());
            insertPs.setDouble(3, clinic.getLatitude());
            insertPs.setString(4, clinic.getAddress());
            insertPs.setString(5, clinic.getSpecialization());
            insertPs.setString(6, clinic.getEndDate());
            insertPs.setString(7, clinic.getStartDate());
            insertPs.setString(8, clinic.getOpenHour());
            insertPs.setString(9, clinic.getCloseHour());
            insertPs.setFloat(10, clinic.getRate());
            insertPs.setString(11, clinic.getDoctorNameEn());
            insertPs.setString(12, clinic.getDoctorNameAr());
            insertPs.setInt(13, clinic.getMedicalTypeId());
            insertPs.setString(14, clinic.getImage());

            int insertflag = insertPs.executeUpdate();

            boolean res = false;
            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT clinic_id FROM clinic WHERE clinic_doctor_name_ar=? OR clinic_doctor_name_en=?");
                getPs.setString(1, clinic.getDoctorNameAr());
                getPs.setString(2, clinic.getDoctorNameEn());

                ResultSet resSet = getPs.executeQuery();

                int id = 0;
                if (resSet.isBeforeFirst()) {
                    resSet.next();
                    id = resSet.getInt(1);
                    System.out.print(id);
                }
                res = phonesObj.addClinicPhones(id, clinic.getPhones());

            }
            return res;

            // System.out.println("insert" + );
        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean deleteClinic(int clinic_id) {

        boolean delete = false;
        int deletePhone;
        int deleteClinic;
        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();
        try (Connection connection = DBConnection.getConnection()) {

            deletePhone = phonesObj.deleteClinicPhones(clinic_id);

            if (deletePhone != 0) {
                PreparedStatement deletePs = connection.prepareStatement("DELETE FROM clinic WHERE clinic_id =?");
                deletePs.setInt(1, clinic_id);
                // deletePs.setInt(2,medical_type_id);
                deleteClinic = deletePs.executeUpdate();
                if (deleteClinic == 1) {
                    delete = true;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);

            delete = false;
        }
        return delete;

    }

    @Override
    public ArrayList<ClinicPojo> getAllClinics() {

        //("INSERT INTO clinic (clinic_id,clinic_longitude,clinic_latitude,clinic_address,clinic_specialization,clinic_end_date,clinic_start_date,clinic_open_hour,clinic_close_hour,clinic_rate,clinic_doctor_name_en,clinic_doctor_name_ar,medical_type_medical_type_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ArrayList<ClinicPojo> clinics = new ArrayList();
        ArrayList<String> phones = new ArrayList();

        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM clinic");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                ClinicPojo clinic = new ClinicPojo();
                clinic.setId(retSet.getInt(1));
                clinic.setLongitude(retSet.getDouble(2));
                clinic.setLatitude(retSet.getDouble(3));
                clinic.setAddress(retSet.getString(4));
                clinic.setSpecialization(retSet.getString(5));
                clinic.setEndDate(retSet.getString(6));
                clinic.setStartDate(retSet.getString(7));
                clinic.setOpenHour(retSet.getString(8));
                clinic.setCloseHour(retSet.getString(9));
                clinic.setRate(retSet.getInt(10));
                clinic.setDoctorNameEn(retSet.getString(11));
                clinic.setDoctorNameAr(retSet.getString(12));
                clinic.setMedicalTypeId(retSet.getInt(13));
                clinic.setImage(retSet.getString(14));
                phones = phonesObj.getClinicPhones(retSet.getInt(1));
                clinic.setPhones(phones);
                clinics.add(clinic);

                //System.out.print(retSet.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return clinics;

    }

    public ArrayList<ResultPojo> searchClinic(String input) {

        ArrayList<ResultPojo> results = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement retrievePs = connection.prepareStatement("SELECT clinic_id , medical_type_medical_type_id FROM clinic where clinic_doctor_name_ar like ? OR clinic_doctor_name_en like ?");
            retrievePs.setString(1, input + "%");
            retrievePs.setString(2, input + "%");

            ResultSet retSet = retrievePs.executeQuery();

            while (retSet.next()) {
                ResultPojo clinic = new ResultPojo();
                clinic.setId(retSet.getInt(1));

                clinic.setTypeId(retSet.getInt(2));

                results.add(clinic);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return results;
    }
    
      
    public boolean updateClinic(ClinicPojo clinic) {
        ClinicPhonesImplementation phonesObj = new ClinicPhonesImplementation();
            boolean isInserted=false;

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement updatePs = connection.prepareStatement("Update clinic SET clinic_longitude=?, clinic_latitude=?, clinic_address=?, clinic_specialization=?, clinic_end_date=? ,clinic_start_date=? ,clinic_open_hour=? ,clinic_close_hour=? ,clinic_rate=? ,clinic_doctor_name_en=? ,clinic_doctor_name_ar=? ,medical_type_medical_type_id=? ,clinic_image=? where clinic_id=?");
            updatePs.setDouble(1, clinic.getLongitude());
            updatePs.setDouble(2, clinic.getLatitude());
            updatePs.setString(3, clinic.getAddress());
            updatePs.setString(4, clinic.getSpecialization());
            updatePs.setString(5, clinic.getEndDate());
            updatePs.setString(6, clinic.getStartDate());
            updatePs.setString(7, clinic.getOpenHour());
            updatePs.setString(8, clinic.getCloseHour());
            updatePs.setFloat(9, clinic.getRate());
            updatePs.setString(10, clinic.getDoctorNameEn());
            updatePs.setString(11, clinic.getDoctorNameAr());
            updatePs.setInt(12, clinic.getMedicalTypeId());
            updatePs.setString(13, clinic.getImage());
            updatePs.setInt(14, clinic.getId());

            int updateflag = updatePs.executeUpdate();

            int isDeleted ;
            if (updateflag == 1) {

              isDeleted=phonesObj.deleteClinicPhones(clinic.getId());
              
              if(isDeleted!=0)
              {
              isInserted=phonesObj.addClinicPhones(clinic.getId(), clinic.getPhones());
              
              }
              

            }
           

            // System.out.println("insert" + );
        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);
            isInserted= false;
        }

        return isInserted;
    }
    
    
    public int retrieveClinicsCount() {
        int count = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement retrieve = connection.prepareStatement("SELECT COUNT(clinic_id) AS count FROM clinic ");
          

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
