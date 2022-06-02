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
public class Thi_hk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new  Form_chinh().setVisible(true);
        loginJDialog dn = new loginJDialog();
        dn.setTitle("Đăng nhập hệ thống");
        dn.setResizable(false);
        dn.setLocationRelativeTo(null);
        dn.setVisible(true);
    }
    
}
