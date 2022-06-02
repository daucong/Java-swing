/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.service;

import java.util.List;
import thi_hk.Dao.CTKhachHangDAO;
import thi_hk.Dao.CTKhachHangDAOImpl;
import thi_hk.Model.KhachHang;

/**
 *
 * @author Admin
 */
public class CTKhachHangserviceImpI implements CTKhachhangservice{
    private CTKhachHangDAO ctkhdao = null;

    public CTKhachHangserviceImpI() {
        this.ctkhdao = new CTKhachHangDAOImpl();
    }

     @Override
    public List<KhachHang> getList() {
        return ctkhdao.getList();
    }

    @Override
    public int createOrUpdate(KhachHang kh) {
        return ctkhdao.createOrUpdate(kh);
    }
}
