/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.controller;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import thi_hk.Model.KhachHang;
import thi_hk.service.CTKhachHangserviceImpI;
import thi_hk.service.CTKhachhangservice;
/**
 *
 * @author Admin
 */
public class CTKhachhangController {
    private JButton btnSubmit;
    private JTextField jtfMaKH;
    private JTextField jtfHoTen;
    private JTextField jtfSoDienThoai;
    private JRadioButton jtfGioiTinhNam;
    private JRadioButton jtfGioiTinhNu;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhtrang;
    private JLabel jlbGhichu;
    
    private KhachHang kh = null;

    private CTKhachhangservice cTKhachhangservice = null;

    public CTKhachhangController(JButton btnSubmit, JTextField jtfMaKH, JTextField jtfHoTen, JTextField jtfSoDienThoai, JRadioButton jtfGioiTinhNam, JRadioButton jtfGioiTinhNu, JTextArea jtaDiaChi, JCheckBox jcbTinhtrang, JLabel jlbGhichu) {
        this.btnSubmit = btnSubmit;
        this.jtfMaKH = jtfMaKH;
        this.jtfHoTen = jtfHoTen;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtfGioiTinhNam = jtfGioiTinhNam;
        this.jtfGioiTinhNu = jtfGioiTinhNu;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhtrang = jcbTinhtrang;
        this.jlbGhichu = jlbGhichu;
        this.cTKhachhangservice = new CTKhachHangserviceImpI();
    }
    public void setView(KhachHang kh) {
        this.kh = kh;
        // set data
        jtfMaKH.setText(kh.getMaKH());
        jtfHoTen.setText(kh.getHoten());
        if (kh.isGioitinh()) {
            jtfGioiTinhNam.setSelected(true);
        } else {
            jtfGioiTinhNu.setSelected(true);
        }
                jtfSoDienThoai.setText(kh.getSDT());
        jtaDiaChi.setText(kh.getDiachi());


        jcbTinhtrang.setSelected(kh.isTinhtrang());
        // set event
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbGhichu.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        kh.setHoten(jtfHoTen.getText().trim());
                        kh.setGioitinh(jtfGioiTinhNam.isSelected());
                        kh.setSDT(jtfSoDienThoai.getText());
                        kh.setDiachi(jtaDiaChi.getText());
                        
                        kh.setTinhtrang(jcbTinhtrang.isSelected());
                        if (showDialog()) {
                            int lastId = cTKhachhangservice.createOrUpdate(kh);
                            if (lastId == 0) {
                                kh.setMaKH(String.valueOf(lastId));
                                jtfMaKH.setText(kh.getMaKH());
                                jlbGhichu.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbGhichu.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(""+ex);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });

    }
    private boolean checkNotNull() {
        return jtfHoTen.getText() != null && !jtfHoTen.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
