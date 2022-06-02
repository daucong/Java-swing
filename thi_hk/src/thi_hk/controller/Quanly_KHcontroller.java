/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import thi_hk.Model.KhachHang;
import thi_hk.service.KhachHangservice;
import thi_hk.Model.classTableModel;
import thi_hk.service.KhachHangserviceImpI;
import javax.swing.table.DefaultTableModel;
import thi_hk.view.CTKhachHangJpanel;

/**
 *
 * @author Admin
 */
public class Quanly_KHcontroller {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;

    private classTableModel cTableModel = null;

    private final String[] COLUMNS = {"Mã khách hàng", "STT", "Tên khách hàng",
        "Giới tính", "Địa chỉ", "Số điện thoại", "Trạng thái"};

    private KhachHangservice khService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public Quanly_KHcontroller(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

        this.cTableModel = new classTableModel();

        this.khService = new KhachHangserviceImpI();
    }

    public void setDataToTable() {
        List<KhachHang> listItem = khService.getList();
        DefaultTableModel model = cTableModel.setTableKhachhang(listItem, COLUMNS);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        // design

        table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {       
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                 try {
                     DefaultTableModel model = (DefaultTableModel) table.getModel();
                     int selectedRowIndex = table.getSelectedRow();
                     
                     selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                     
                     KhachHang kh = new KhachHang();
                     kh.setMaKH( model.getValueAt(selectedRowIndex, 0).toString());
                     kh.setHoten(model.getValueAt(selectedRowIndex, 2).toString());
                     kh.setGioitinh(model.getValueAt(selectedRowIndex, 3).toString().equalsIgnoreCase("Nam"));
                     kh.setSDT(model.getValueAt(selectedRowIndex, 5) != null
                             ? model.getValueAt(selectedRowIndex, 5).toString() : null);
                     kh.setDiachi(model.getValueAt(selectedRowIndex, 4) != null
                             ? model.getValueAt(selectedRowIndex, 4).toString() : null);
                     
                     kh.setTinhtrang((boolean) model.getValueAt(selectedRowIndex, 6));
                     
                     CTKhachHangJpanel frame = new CTKhachHangJpanel(kh);
                     frame.setLocationRelativeTo(null);
                     frame.setResizable(false);
                     frame.setTitle("Thông tin học viên");
                     frame.setVisible(true);
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Quanly_KHcontroller.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (SQLException ex) {
                     Logger.getLogger(Quanly_KHcontroller.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
      }

        });
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
     public void setEven(){
         btnAdd.addMouseListener(new MouseAdapter() {
             @Override
            public void mouseClicked(MouseEvent e) {
                 try {
                     CTKhachHangJpanel ct = new CTKhachHangJpanel(new KhachHang());
                     ct.setTitle("Thông tin khách hàng");
                     ct.setLocationRelativeTo(null);
                     ct.setResizable(false);
                     ct.setVisible(true);
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Quanly_KHcontroller.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (SQLException ex) {
                     Logger.getLogger(Quanly_KHcontroller.class.getName()).log(Level.SEVERE, null, ex);
                 }

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
         });
     }
    
}
