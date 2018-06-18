/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public class AdminListPojo {
     ArrayList<AdminPojo> adminList;

    public AdminListPojo(ArrayList<AdminPojo> adminList) {
        this.adminList = adminList;
    }

    public ArrayList<AdminPojo> getAdminList() {
        return adminList;
    }

    public void setAdminList(ArrayList<AdminPojo> adminList) {
        this.adminList = adminList;
    }

    

    
}
