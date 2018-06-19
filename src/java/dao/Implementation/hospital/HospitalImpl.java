/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.hospital;

import dao.Implementation.clinic.ClinicImpl;
import dao.Implementation.clinic.ClinicPhonesImplementation;
import dao.Implementation.review.ReviewsDaoImp;
import dao.Interfaces.hospital.Hospital;
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
import pojos.HospitalPojo;
import pojos.LabPojo;
import pojos.ResultPojo;

/**
 *
 * @author Hagar
 */
public class HospitalImpl implements Hospital {

    @Override
    public HospitalPojo retrieve(int hospitalId) {
              ReviewsDaoImp obj = new  ReviewsDaoImp();

        HospitalPhonesImplementation phonesObj = new HospitalPhonesImplementation();
        HospitalDepartmentsImplementation departmentsObj = new HospitalDepartmentsImplementation();
        ArrayList<String> departments = new ArrayList();

        ArrayList<String> phones = new ArrayList();

        HospitalPojo hospital = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM hospital WHERE hospital_id=?");

            retrieveTypes.setInt(1, hospitalId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                hospital = new HospitalPojo();
           float rate = obj.reateAverage(retSet.getInt(1),retSet.getInt(13));
                hospital.setId(retSet.getInt(1));
                hospital.setNameAr(retSet.getString(2));
                hospital.setAddress(retSet.getString(3));
                hospital.setLongitude(retSet.getDouble(4));
                hospital.setLatitude(retSet.getDouble(5));
                hospital.setStartDate(retSet.getString(6));
                hospital.setEndDate(retSet.getString(7));
                hospital.setRate(rate);
                hospital.setOpenHour(retSet.getString(9));
                hospital.setCloseHour(retSet.getString(10));
                hospital.setCeo(retSet.getString(11));
                hospital.setNameEn(retSet.getString(12));
                hospital.setMedicalTypeId(retSet.getInt(13));
                hospital.setImage(retSet.getString(14));

                phones = phonesObj.getHospitalPhones(retSet.getInt(1));
                departments = departmentsObj.getHospitalDepartments(retSet.getInt(1));

                hospital.setPhones(phones);
                hospital.setDepartments(departments);

            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospital;
    }

    @Override
    public boolean addHospital(HospitalPojo hospital) {

        HospitalDepartmentsImplementation departments = new HospitalDepartmentsImplementation();
        HospitalPhonesImplementation phones = new HospitalPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO hospital (hospital_id,hospital_name,hospital_address,hospital_longitude,hospital_latitude,hospital_start_date,hospital_end_date,hospital_rate,hospital_open_hour,hospital_close_hour,hospital_ceo,hospital_name_en,medical_type_medical_type_id,hospital_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, hospital.getId());
            insertPs.setString(2, hospital.getNameAr());
            insertPs.setString(3, hospital.getAddress());
            insertPs.setDouble(4, hospital.getLongitude());
            insertPs.setDouble(5, hospital.getLatitude());
            insertPs.setString(6, hospital.getStartDate());
            insertPs.setString(7, hospital.getEndDate());
            insertPs.setFloat(8, hospital.getRate());
            insertPs.setString(9, hospital.getOpenHour());
            insertPs.setString(10, hospital.getCloseHour());
            insertPs.setString(11, hospital.getCeo());
            insertPs.setString(12, hospital.getNameEn());
            insertPs.setInt(13, hospital.getMedicalTypeId());
            insertPs.setString(14, hospital.getImage());

            int insertflag = insertPs.executeUpdate();
            boolean res = false;
            boolean res2 = false;
            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT hospital_id FROM hospital WHERE hospital_name=? OR hospital_name_en=?");
                getPs.setString(1, hospital.getNameAr());
                getPs.setString(2, hospital.getNameEn());
                ResultSet resSet = getPs.executeQuery();

                int id = 0;
                if (resSet.isBeforeFirst()) {
                    resSet.next();
                    id = resSet.getInt(1);
                    System.out.print(id);
                }
                res = phones.addHospitalPhones(id, hospital.getPhones());
                res2 = departments.addHospitalDepartments(id, hospital.getDepartments());

            }
            return res && res2;

        } catch (SQLException ex) {
            Logger.getLogger(HospitalImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    @Override
    public boolean deleteHospital(int hospital_id) {

        int deletePhone;
        int deleteDepartments;
        boolean delete = false;
        int deleteHospital;
        HospitalDepartmentsImplementation departmentsObj = new HospitalDepartmentsImplementation();
        HospitalPhonesImplementation phonesObj = new HospitalPhonesImplementation();

        try (Connection connection = DBConnection.getConnection()) {

            deletePhone = phonesObj.deleteHospitalPhones(hospital_id);
            deleteDepartments = departmentsObj.deleteHospitalDepartments(hospital_id);
            if (deletePhone != 0 && deleteDepartments != 0) {

                PreparedStatement deletePs = connection.prepareStatement("DELETE FROM hospital WHERE hospital_id =?");
                deletePs.setInt(1, hospital_id);
                // deletePs.setInt(2,medical_type_id);

                deleteHospital = deletePs.executeUpdate();

                if (deleteHospital == 1) {
                    delete = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalImpl.class.getName()).log(Level.SEVERE, null, ex);
            delete = false;
        }
        return delete;

    }

    @Override
    public ArrayList<HospitalPojo> getAllHospitals() {

        HospitalDepartmentsImplementation departmentsObj = new HospitalDepartmentsImplementation();
        HospitalPhonesImplementation phonesObj = new HospitalPhonesImplementation();

        ArrayList<HospitalPojo> hospitals = new ArrayList();
        //"INSERT INTO hospital (hospital_id,hospital_name,hospital_address,hospital_longitude,hospital_latitude,hospital_start_date,hospital_end_date,hospital_rate,hospital_open_hour,hospital_close_hour,hospital_ceo,hospital_name_en,medical_type_medical_type_id,hospital_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ArrayList<String> phones = new ArrayList();
        ArrayList<String> departments = new ArrayList();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM hospital");

            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                HospitalPojo hos = new HospitalPojo();
                hos.setId(retSet.getInt(1));
                hos.setNameAr(retSet.getString(2));
                hos.setAddress(retSet.getString(3));
                hos.setLongitude(retSet.getDouble(4));
                hos.setLatitude(retSet.getDouble(5));
                hos.setStartDate(retSet.getString(6));
                hos.setEndDate(retSet.getString(7));
                hos.setRate(retSet.getInt(8));
                hos.setOpenHour(retSet.getString(9));
                hos.setCloseHour(retSet.getString(10));
                hos.setCeo(retSet.getString(11));
                hos.setNameEn(retSet.getString(12));
                hos.setMedicalTypeId(retSet.getInt(13));
                hos.setImage(retSet.getString(14));

                phones = phonesObj.getHospitalPhones(retSet.getInt(1));
                departments = departmentsObj.getHospitalDepartments(retSet.getInt(1));

                hos.setPhones(phones);
                hos.setDepartments(departments);

                hospitals.add(hos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return hospitals;

    }
     public ArrayList<ResultPojo> searchHospitalByName(String input) {
        System.out.println("inside searchLabByName");

        ArrayList<ResultPojo> results = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement retrievePs = connection.prepareStatement("SELECT  hospital_id , medical_type_medical_type_id FROM hospital where hospital_name like ? OR hospital_name_en like ?");
            retrievePs.setString(1, input+"%");
            retrievePs.setString(2, input+"%");

            ResultSet retSet = retrievePs.executeQuery();

            while (retSet.next()) {
                 ResultPojo hos = new ResultPojo();
                hos.setId(retSet.getInt(1));
               
                hos.setTypeId(retSet.getInt(2));
                System.out.println("hospital is "+retSet.getInt(2));
                results.add(hos);
 
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return results;
    }
     
     
       public boolean updateHospital(HospitalPojo hospital) {
        HospitalPhonesImplementation phonesObj = new HospitalPhonesImplementation();
        HospitalDepartmentsImplementation departments = new HospitalDepartmentsImplementation();

            boolean isPhonesInserted=false;
            boolean isDepartmentsInserted=false;

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("Update hospital SET hospital_name=? ,hospital_address=? ,hospital_longitude=? ,hospital_latitude=? ,hospital_start_date=? ,hospital_end_date=? ,hospital_rate=? ,hospital_open_hour=? ,hospital_close_hour=? ,hospital_ceo=? ,hospital_name_en= ? ,medical_type_medical_type_id=? ,hospital_image=? where hospital_id=?");
           
            insertPs.setString(1, hospital.getNameAr());
            insertPs.setString(2, hospital.getAddress());
            insertPs.setDouble(3, hospital.getLongitude());
            insertPs.setDouble(4, hospital.getLatitude());
            insertPs.setString(5, hospital.getStartDate());
            insertPs.setString(6, hospital.getEndDate());
            insertPs.setFloat(7, hospital.getRate());
            insertPs.setString(8, hospital.getOpenHour());
            insertPs.setString(9, hospital.getCloseHour());
            insertPs.setString(10, hospital.getCeo());
            insertPs.setString(11, hospital.getNameEn());
            insertPs.setInt(12, hospital.getMedicalTypeId());
            insertPs.setString(13, hospital.getImage());
            insertPs.setInt(14, hospital.getId());

            int updateflag = insertPs.executeUpdate();

            int isPhonesDeleted ;
            int isDepartmentsDeleted;
            if (updateflag == 1) {

              isPhonesDeleted=phonesObj.deleteHospitalPhones(hospital.getId());
              isDepartmentsDeleted=departments.deleteHospitalDepartments(hospital.getId());
              
              if(isPhonesDeleted!=0 && isDepartmentsDeleted!=0)
              {
              isPhonesInserted=phonesObj.addHospitalPhones(hospital.getId(), hospital.getPhones());
              isDepartmentsInserted=departments.addHospitalDepartments(hospital.getId(), hospital.getDepartments());
              }
              

            }
           

            // System.out.println("insert" + );
        } catch (SQLException ex) {
            Logger.getLogger(ClinicImpl.class.getName()).log(Level.SEVERE, null, ex);
            isPhonesInserted= false;
        }

        return isPhonesInserted&&isDepartmentsInserted;
    }
       
       
        
    public int retrieveHospitalsCount() {
        int count = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement retrieve = connection.prepareStatement("SELECT COUNT(hospital_id) AS count FROM hospital ");
          

            ResultSet retSet = retrieve.executeQuery();
            while (retSet.next()) {
                count = retSet.getInt("count");  

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

//    public ArrayList<ResultPojo> searchHospitalByDepartment(String input) {
//
//        ArrayList<ResultPojo> results = new ArrayList<>();
//
//        try (Connection connection = DBConnection.getConnection()) {
//            PreparedStatement retrievePs = connection.prepareStatement("SELECT hospital_id , medical_type_medical_type_id FROM hospital where hospital_id in (SELECT hospital_hospital_id FROM hospital_departments where department like ?)");
//<<<<<<< HEAD
//            retrievePs.setString(1,input+"%");
//=======
//            retrievePs.setString(1, input+"%");
//>>>>>>> 229c069139e01ec12b3e6f2eef7ca15832fdd636
//
//            ResultSet retSet = retrievePs.executeQuery();
//
//            while (retSet.next()) {
//                ResultPojo hos = new ResultPojo();
//                hos.setId(retSet.getInt(1));
//             
//                hos.setTypeId(retSet.getInt(2));
//
//
//                results.add(hos);
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//
//        return results;
//    }

}
