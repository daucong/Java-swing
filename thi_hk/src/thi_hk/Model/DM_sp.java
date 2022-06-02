/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk;

/**
 *
 * @author Admin
 */
public class DM_sp {
    int id;
    String TenDM;

    public DM_sp(int id, String TenDM) {
        this.id = id;
        this.TenDM = TenDM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }
    
}
