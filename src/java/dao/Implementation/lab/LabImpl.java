/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation.lab;

import dao.Interfaces.lab.Lab;
import dbconnectionfactory.DBConnection;
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
                lab.setLabId(retSet.getInt(1));
                lab.setLabNameEn(retSet.getString(2));
                lab.setLabOpenHour(retSet.getString(3));
                lab.setLabCloseHour(retSet.getString(4));
                lab.setLabLatitude(retSet.getDouble(6));
                lab.setLabLongitude(retSet.getDouble(7));
                lab.setLabAddress(retSet.getString(8));
                lab.setLabStartDate(retSet.getDate(9));
                lab.setLabEndDate(retSet.getDate(10));
                lab.setLabRate(retSet.getInt(11));
                lab.setLabCeo(retSet.getString(12));
                lab.setLabNameAr(retSet.getString(13));
                lab.setMedicalTypeMedicalTypeId(retSet.getInt(14));

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
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO lab (lab_id,lab_name_en,lab_open_hour,lab_close_hour,lab_latitude,lab_longitude,lab_address,lab_start_date,lab_end_date,lab_rate,lab_ceo,lab_name_ar,medical_type_medical_type_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertPs.setInt(1, lab.getLabId());
            insertPs.setString(2, lab.getLabNameEn());
            insertPs.setString(3, lab.getLabOpenHour());
            insertPs.setString(4, lab.getLabCloseHour());
            insertPs.setDouble(5, lab.getLabLatitude());
            insertPs.setDouble(6, lab.getLabLongitude());
            insertPs.setString(7, lab.getLabAddress());
            insertPs.setDate(8, lab.getLabStartDate());
            insertPs.setDate(9, lab.getLabEndDate());
            insertPs.setInt(10, lab.getLabRate());
            insertPs.setString(11, lab.getLabCeo());
            insertPs.setString(12, lab.getLabNameAr());
            insertPs.setInt(13, lab.getMedicalTypeMedicalTypeId());
            // Blob blob= null;
            //insertPs.setBlob(14, blob);

            int insertflag = insertPs.executeUpdate();
            boolean res = false;
            boolean res2 = false;

            if (insertflag == 1) {
                PreparedStatement getPs = connection.prepareStatement("SELECT lab_id FROM lab WHERE lab_name_en=? OR lab_name_ar=?");
                getPs.setString(1, lab.getLabNameEn());
                getPs.setString(2, lab.getLabNameAr());
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
                lab.setLabId(retSet.getInt(1));
                lab.setLabNameEn(retSet.getString(2));
                lab.setLabOpenHour(retSet.getString(3));
                lab.setLabCloseHour(retSet.getString(4));
                lab.setLabLatitude(retSet.getDouble(5));
                lab.setLabLongitude(retSet.getDouble(6));
                lab.setLabAddress(retSet.getString(7));
                lab.setLabStartDate(retSet.getDate(8));
                lab.setLabEndDate(retSet.getDate(9));
                lab.setLabRate(retSet.getInt(10));
                lab.setLabCeo(retSet.getString(11));
                lab.setLabNameAr(retSet.getString(12));
                lab.setMedicalTypeMedicalTypeId(13);

                //lab.setLab_image(retSet.getBlob(14));
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
