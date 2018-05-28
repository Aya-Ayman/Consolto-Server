/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.lab;

import dao.Interfaces.lab.Lab;
import dbconnectionfactory.DBConnection;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.LabPojo;

/**
 *
 * @author Hagar
 */
public class LabImpl implements Lab {

    @Override
    public LabPojo retrieve(int labId) {
        LabPojo lab = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrieveTypes = connection.prepareStatement("SELECT * FROM lab WHERE lab_id=?");

            retrieveTypes.setInt(1, labId);
            ResultSet retSet = retrieveTypes.executeQuery();

            while (retSet.next()) {

                lab = new LabPojo();
                lab.setId(retSet.getInt(1));
                lab.setNameEn(retSet.getString(2));
                lab.setOpenHour(retSet.getString(3));
                lab.setCloseHour(retSet.getString(4));
                lab.setLatitude(retSet.getDouble(5));
                lab.setLongitude(retSet.getDouble(6));
                lab.setAddress(retSet.getString(7));
                lab.setStartDate(retSet.getString(8));
                lab.setEndDate(retSet.getString(9));
                lab.setRate(retSet.getInt(10));
                lab.setCeo(retSet.getString(11));
                lab.setNameAr(retSet.getString(12));
                lab.setMedicalTypeId(retSet.getInt(13));
                lab.setImage(retSet.getBlob(14));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LabImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lab;

    }

    public boolean addLab(LabPojo lab) {
        LabPhonesImplementation phonesObj = new LabPhonesImplementation();
        LabSpecializationsImplementation specializationsObj = new LabSpecializationsImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO lab (lab_id,lab_name_en,lab_open_hour,lab_close_hour,lab_latitude,lab_longitude,lab_address,lab_start_date,lab_end_date,lab_rate,lab_ceo,lab_name_ar,medical_type_medical_type_id,lab_image)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, lab.getId());
            insertPs.setString(2, lab.getNameEn());
            insertPs.setString(3, lab.getOpenHour());
            insertPs.setString(4, lab.getCloseHour());
            insertPs.setDouble(5, lab.getLatitude());
            insertPs.setDouble(6, lab.getLongitude());
            insertPs.setString(7, lab.getAddress());
            insertPs.setString(8, lab.getStartDate());
            insertPs.setString(9, lab.getEndDate());
            insertPs.setFloat(10, lab.getRate());
            insertPs.setString(11, lab.getCeo());
            insertPs.setString(12, lab.getNameAr());
            insertPs.setInt(13, lab.getMedicalTypeId());
            Blob blob= null;
            insertPs.setBlob(14, blob);

            int insertflag = insertPs.executeUpdate();
            boolean res = false;
            boolean res2 = false;

            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT lab_id FROM lab WHERE lab_name_en=? OR lab_name_ar=?");
                getPs.setString(1, lab.getNameEn());
                getPs.setString(2, lab.getNameAr());
                ResultSet resSet = getPs.executeQuery();

                int id = 0;
                if (resSet.isBeforeFirst()) {
                    resSet.next();
                    id = resSet.getInt(1);
                    System.out.print(id);
                }
                res = phonesObj.addLabPhones(id, lab.getLabPhones());
                res2 = specializationsObj.addLabSpecializations(id, lab.getLabSpecializations());

            }
            return res && res2;

            // System.out.println("insert" + insertPs.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(LabImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deleteLab(int lab_id) {
        //,int medical_type_id
        int deletePhone;
        int deleteSpecializations;
        boolean delete = false;
        int labDelete;
        LabPhonesImplementation phonesObj = new LabPhonesImplementation();
        LabSpecializationsImplementation specializationsObj = new LabSpecializationsImplementation();

        try (Connection connection = DBConnection.getConnection()) {

            deletePhone = phonesObj.deleteLabPhones(lab_id);
            deleteSpecializations = specializationsObj.deleteLabSpecializations(lab_id);
            if (deletePhone != 0 && deleteSpecializations != 0) {
                //and medical_type_medical_type_id=?
                PreparedStatement deletePs = connection.prepareStatement("DELETE FROM lab WHERE lab_id =?");
                deletePs.setInt(1, lab_id);
                //deletePs.setInt(2,medical_type_id);
                labDelete = deletePs.executeUpdate();
                if (labDelete == 1) {
                    delete = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LabImpl.class.getName()).log(Level.SEVERE, null, ex);
            delete = false;
        }

        return delete;
    }

    public ArrayList<LabPojo> getAllLabs() {
        ArrayList<LabPojo> labs = new ArrayList();
        ArrayList<String> phones = new ArrayList();
        ArrayList<String> specializations = new ArrayList();
        LabPhonesImplementation phonesObj = new LabPhonesImplementation();
        LabSpecializationsImplementation specializationsObj = new LabSpecializationsImplementation();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM lab");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {
                LabPojo lab = new LabPojo();
                lab.setId(retSet.getInt(1));
                lab.setNameEn(retSet.getString(2));
                lab.setOpenHour(retSet.getString(3));
                lab.setCloseHour(retSet.getString(4));
                lab.setLatitude(retSet.getDouble(5));
                lab.setLongitude(retSet.getDouble(6));
                lab.setAddress(retSet.getString(7));
                lab.setStartDate(retSet.getString(8));
                lab.setEndDate(retSet.getString(9));
                lab.setRate(retSet.getInt(10));
                lab.setCeo(retSet.getString(11));
                lab.setNameAr(retSet.getString(12));
                lab.setMedicalTypeId(13);

                lab.setImage(retSet.getBlob(14));
                phones = phonesObj.getLabPhones(retSet.getInt(1));
                specializations = specializationsObj.getLabSpecializations(retSet.getInt(1));

                lab.setLabPhones(phones);
                lab.setLabSpecializations(specializations);
                labs.add(lab);

                //System.out.print(retSet.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return labs;

    }

}
