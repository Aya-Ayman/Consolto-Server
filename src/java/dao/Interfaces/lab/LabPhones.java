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
public interface LabPhones {

    public boolean addLabPhones(int lab_id, ArrayList<String> phones);

    public int deleteLabPhones(int lab_id);

    public ArrayList<String> getLabPhones(int lab_id);

}
