/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thi_hk.Model.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class CTKhachHangDAOImpl implements  CTKhachHangDAO {
    private Connection con = null;
        public CTKhachHangDAOImpl() {
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
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoten(rs.getString("Hoten"));
                kh.setGioitinh(rs.getBoolean("Gioitinh"));
                kh.setDiachi(rs.getString("Diachi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setTinhtrang(rs.getBoolean("Tinhtrang"));
                list.add(kh);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public int createOrUpdate(KhachHang kh) {
        try {
            String sql = "update KhachHang set Hoten = ?, Gioitinh = ?, Diachi = ?, SDT = ?, Tinhtrang = ?"
                    +"where MaKH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(6, kh.getMaKH());
                ps.setString(1, kh.getHoten());
                ps.setBoolean(2, kh.isGioitinh());
                ps.setString(3, kh.getDiachi());
                ps.setString(4, kh.getSDT());
                ps.setBoolean(5, kh.isTinhtrang());
                ps.execute();
                ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
