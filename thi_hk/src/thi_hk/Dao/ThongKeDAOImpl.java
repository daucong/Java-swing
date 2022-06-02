/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */    
public class ThongKeDAOImpl implements ThongKeDAO {
    private Connection con = null;
        public ThongKeDAOImpl() {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThongKeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Hoadon> getListHoadon() {
        String sql = "SELECT Ngaylay_hd, COUNT(*) as so_luong FROM Hoadon GROUP BY Ngaylay_hd";
        List<Hoadon> list = new ArrayList<>();
        try {
            PreparedStatement ps =  con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hoadon hd = new Hoadon();
                hd.setNgaylay_hd(rs.getString("Ngaylay_hd"));
                hd.setSoluong(rs.getInt("so_luong"));
                list.add(hd);
             }
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Donhanghoa> getListDonhanghoa() {
        String sql = "select TenSP, Ngay_dathang, Ngay_ketThuc from Donhanghoa WHERE tinh_trang = 1 ";
        
        List<Donhanghoa> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Donhanghoa dhh = new Donhanghoa();
                dhh.setTenSP(rs.getString("TenSP"));
                dhh.setNgap_dathang(rs.getDate("Ngay_dathang"));
                dhh.setNgay_ketThuc(rs.getDate("Ngay_ketThuc"));
                list.add(dhh);
            }
            ps.close();
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}