/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.service;

import java.util.List;
import thi_hk.Dao.XuatDonhangDao;
import thi_hk.Dao.XuatDonhangDaoImpl;
import thi_hk.Model.XuatDonhang;

/**
 *
 * @author Admin
 */
public class xuatDonhangseviceImpI implements XuatDonHangservice{
    private XuatDonhangDao xdd = null;

    public xuatDonhangseviceImpI() {
        this.xdd = new XuatDonhangDaoImpl();
    }
     @Override
    public List<XuatDonhang> getList() {
        return xdd.getList();
    }
}
