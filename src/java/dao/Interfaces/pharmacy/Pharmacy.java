/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.pharmacy;

import java.util.ArrayList;
import pojos.PharmacyPojo;

/**
 *
 * @author Hagar
 */
public interface Pharmacy {

    public PharmacyPojo retrieve(int pharmacyId);

    public boolean addPharmacy(PharmacyPojo pharmacy);

    public boolean deletePharmacy(int pharmacy_id);

    public ArrayList<PharmacyPojo> getAllPharmacies();

}
