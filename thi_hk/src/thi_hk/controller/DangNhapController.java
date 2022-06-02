/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class DangNhapController {
    private Dialog dialog;
    private JButton btnSubmit;
    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;
    private JLabel lbGhichu;

    private taikhoanservice taiKhoanService = null;

    public DangNhapController(Dialog dialog, JButton btnSubmit,JTextField txtTenDangNhap, JPasswordField txtMatKhau, JLabel lbGhichu) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.txtTenDangNhap = txtTenDangNhap;
        this.txtMatKhau = txtMatKhau;
        this.lbGhichu = lbGhichu;

        taiKhoanService = new taikhoanserviceiImpl();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    if (txtTenDangNhap.getText().length() == 0 || txtMatKhau.getText().length() == 0) {
                        lbGhichu.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        taikhoan taiKhoan = taiKhoanService.login(txtTenDangNhap.getText(), txtMatKhau.getText());
                        if (taiKhoan == null) {
                            lbGhichu.setText("Tên đăng nhập và mật khẩu không đúng!");
                        } else {
                                
                                Form_chinh frame = new Form_chinh() ;
                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                frame.setVisible(true);
                                dialog.dispose();
                            }
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
}
