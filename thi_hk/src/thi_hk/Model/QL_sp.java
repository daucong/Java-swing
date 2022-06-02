/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk;

/**
 *
 * @author Admin
 */
public class QL_sp {
    int id;
    String TenSP;
    int Gia;
    String Mota;
    String Danhmuc_sp ;

    public QL_sp(){
        
    }
    public QL_sp(int id, String TenSP, String Danhmuc_sp, int Gia, String Mota ) {
        this.id = id;
        this.TenSP = TenSP;
        this.Danhmuc_sp = Danhmuc_sp;
        this.Gia = Gia;
        this.Mota = Mota;
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public String getDanhmuc_sp() {
        return Danhmuc_sp;
    }

    public void setDanhmuc_sp(String Danhmuc_sp) {
        this.Danhmuc_sp = Danhmuc_sp;
    }
    
}
