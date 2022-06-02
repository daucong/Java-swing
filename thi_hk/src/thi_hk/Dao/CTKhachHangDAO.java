/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.Dao;

import java.util.List;
import thi_hk.Model.KhachHang;

/**
 *
 * @author Admin
 */
public interface CTKhachHangDAO {
    public List<KhachHang> getList();

    public int createOrUpdate(KhachHang kh);
}
