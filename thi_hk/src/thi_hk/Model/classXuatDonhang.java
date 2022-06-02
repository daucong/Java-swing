/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.Model;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class classXuatDonhang {
    public DefaultTableModel setTableDonHang(List<XuatDonhang> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() ;
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        XuatDonhang xdh = null;
        for (int i = 0; i < num; i++) {
            xdh = listItem.get(i);
            obj = new Object[columns];
            obj[0] = xdh.getID();
            obj[1] = xdh.getMaDH();
            obj[2] = xdh.getMaKH();
            obj[3] = xdh.getHoten();       
            obj[4] = xdh.getTenSP();
            obj[5] = xdh.getSoluong();
            obj[6] = xdh.getGiaban();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
