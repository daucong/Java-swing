/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.service;

import java.util.List;
import thi_hk.Dao.KhachHangDaoImpI;
import thi_hk.Dao.KhachhangDao;
import thi_hk.Model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangserviceImpI implements KhachHangservice{
    private KhachhangDao khDAO = null;

    public KhachHangserviceImpI() {
        this.khDAO = new KhachHangDaoImpI();
    }

    @Override
    public List<KhachHang> getList() {
        return khDAO.getList();
    }
}
