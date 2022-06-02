/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
   public class TaiKhoanDAOImpl implements TaiKhoanDAO {
    private Connection con = null;
           public TaiKhoanDAOImpl() {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public taikhoan login(String tdn, String mk) {
        String sql = "select * from login where username like? and password like?";
        taikhoan taiKhoan = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new taikhoan();
                taiKhoan.setUsername(rs.getString("username"));
                taiKhoan.setPassword(rs.getString("password"));
                return taiKhoan;
            }
           
        } catch (Exception e) {
        }
        return null;
    }
} 

