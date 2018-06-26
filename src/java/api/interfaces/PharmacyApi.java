/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.PharmacyListPojo;
import pojos.PharmacyPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface PharmacyApi {

    public ResponseMessage insertPharmacy(PharmacyPojo pharmacy);

    public ResponseMessage deletePharmacy(@PathParam("pharmacy_id") int pharmacy_id);

    public PharmacyListPojo getAllPharmacies();

    public ResponseMessage update(PharmacyPojo pharmacy);
    
    public int retrievePharmaciesCount();

}
