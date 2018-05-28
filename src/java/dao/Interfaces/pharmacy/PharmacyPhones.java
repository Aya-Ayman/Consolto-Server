/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.pharmacy;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public interface PharmacyPhones {

    public boolean addPharmacyPhones(int pharmacy_id, ArrayList<String> phones);

    public int deletePharmacyPhones(int pharmacy_id);

    public ArrayList<String> getPharmacyPhones(int pharmacy_id);

}
