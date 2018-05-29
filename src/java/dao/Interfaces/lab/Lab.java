/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.lab;

import java.util.ArrayList;
import pojos.LabPojo;

/**
 *
 * @author Hagar
 */
public interface Lab {

    public LabPojo retrieve(int labId);

    public boolean addLab(LabPojo lab);

    public boolean deleteLab(int lab_id);

    public ArrayList<LabPojo> getAllLabs();

}
