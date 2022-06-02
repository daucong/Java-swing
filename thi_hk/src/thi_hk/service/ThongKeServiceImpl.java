/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.service;

import java.util.List;
import thi_hk.Donhanghoa;
import thi_hk.Hoadon;
import thi_hk.ThongKeDAO;
import thi_hk.ThongKeDAOImpl;

/**
 *
 * @author Admin
 */
public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl() {
        thongKeDAO = new ThongKeDAOImpl();
    }

    @Override
    public List<Hoadon> getListHoadon() {
        return thongKeDAO.getListHoadon();
    }

    @Override
    public List<Donhanghoa> getListDonhanghoa() {
        return thongKeDAO.getListDonhanghoa();
    }

}