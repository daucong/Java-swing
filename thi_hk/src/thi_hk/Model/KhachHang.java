/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.Model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class KhachHang implements Serializable {
    private String MaKH;
    private String Hoten;
    private boolean Gioitinh;
    private String Diachi ;
    private String SDT;
    private boolean Tinhtrang;

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(boolean Tinhtrang) {
        this.Tinhtrang = Tinhtrang;
    }
    
}
