/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interfaces.lab;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public interface LabSpecializations {

    public boolean addLabSpecializations(int lab_id, ArrayList<String> specializations);

    public int deleteLabSpecializations(int lab_id);

    public ArrayList<String> getLabSpecializations(int lab_id);

}
