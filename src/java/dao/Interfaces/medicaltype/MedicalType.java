/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.medicaltype;

import java.util.List;
import pojos.MedicalTypePojo;

/**
 *
 * @author Hagar
 */
public interface MedicalType {

    public boolean create(MedicalTypePojo type);

    public MedicalTypePojo retrieve(int typeId);

    public List<MedicalTypePojo> retrieve();

    public boolean update(MedicalTypePojo type);

    public boolean delete(MedicalTypePojo type);

}
