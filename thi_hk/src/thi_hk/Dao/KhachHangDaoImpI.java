/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import thi_hk.Model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangDaoImpI implements KhachhangDao{
    private Connection con = null;
        public KhachHangDaoImpI() {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhachHangDaoImpI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImpI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<KhachHang> getList() {
        String sql = "SELECT * FROM KhachHang";
        List<KhachHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoten(rs.getString("Hoten"));
                kh.setSDT(rs.getString("SDT"));
                kh.setDiachi(rs.getString("Diachi"));
                kh.setGioitinh(rs.getBoolean("Gioitinh"));
                kh.setTinhtrang(rs.getBoolean("Tinhtrang"));
                list.add(kh);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
