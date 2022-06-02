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
public class classTableModel {
    public DefaultTableModel setTableKhachhang(List<KhachHang> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        KhachHang kh = null;
        for (int i = 0; i < num; i++) {
            kh = listItem.get(i);
            obj = new Object[columns];
            obj[0] = kh.getMaKH();
            obj[1] = (i + 1);
            obj[2] = kh.getHoten();
            obj[3] = kh.isGioitinh()== true ? "Nam" : "Nữ";          
            obj[4] = kh.getDiachi();
            obj[5] = kh.getSDT();
            obj[6] = kh.isTinhtrang();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
