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
public class taikhoanserviceiImpl implements taikhoanservice {
    private TaiKhoanDAO taikhoandDao = null;
    public taikhoanserviceiImpl(){
        taikhoandDao = (TaiKhoanDAO) new TaiKhoanDAOImpl(); 

        
    }
  
            public taikhoan login(String tdn, String mk) {
                return taikhoandDao.login(tdn, mk);
            }
}
