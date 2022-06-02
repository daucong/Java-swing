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
import thi_hk.Model.XuatDonhang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class XuatDonhangDaoImpl implements XuatDonhangDao{
    private Connection con = null;
        public XuatDonhangDaoImpl() {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XuatDonhangDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(XuatDonhangDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<XuatDonhang> getList() {
        String sql = "SELECT * FROM DonHang";
        List<XuatDonhang> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                XuatDonhang dh = new XuatDonhang();
                dh.setID(rs.getInt("ID"));
                dh.setMaDH(rs.getString("MaDH"));
                dh.setMaKH(rs.getString("MaKH"));
                dh.setHoten(rs.getString("HotenKH"));
                dh.setTenSP(rs.getString("TenSP"));
                dh.setSoluong(rs.getInt("Soluong"));
                dh.setGiaban(rs.getInt("Giaban"));
                list.add(dh);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
