/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import pojos.LabListPojo;
import pojos.LabPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Aya
 */
public interface LabApi {
    public ResponseMessage insertData(LabPojo lab);

    public ResponseMessage deleteLab(@PathParam("lab_id") int lab_id);

    public LabListPojo getAllLabs();

    public ResponseMessage update(LabPojo lab);

}
