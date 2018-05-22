/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.List;
import pojos.MedicalTypePojo;

/**
 *
 * @author Hagar
 */
public interface MedicalTypeApi {

    public List<MedicalTypePojo> getAllTypes();

}
