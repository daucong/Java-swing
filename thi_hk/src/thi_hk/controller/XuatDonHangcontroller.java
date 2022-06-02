/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk.controller;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import thi_hk.Model.XuatDonhang;
import thi_hk.Model.classXuatDonhang;
import thi_hk.service.XuatDonHangservice;
import thi_hk.service.xuatDonhangseviceImpI;
import thi_hk.view.DonhangJfame;
/**
 *
 * @author Admin
 */
public class XuatDonHangcontroller {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;

    private classXuatDonhang cxDonhang = null;

    private final String[] COLUMNS = {"ID", "MaDH", "MaKH",
        "Họ tên KH", "Tên SP", "Số lượng", "Giá bán"};

    private XuatDonHangservice xdhService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public XuatDonHangcontroller(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

        this.cxDonhang = new classXuatDonhang()                                                                                                                                                                                                                                             ;

        this.xdhService = new xuatDonhangseviceImpI();
    }

    public void setDataToTable() {
        List<XuatDonhang> listItem = xdhService.getList();
        DefaultTableModel model = cxDonhang.setTableDonHang(listItem, COLUMNS);
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
        table.addMouseListener(new MouseAdapter() {
             @Override
        public void mouseClicked(MouseEvent e) {    
            DonhangJfame fr  = new DonhangJfame();
                    fr.setLocationRelativeTo(null);
                    fr.setResizable(false);
                    fr.setTitle("Thông tin đơn hàng");
                    fr.setVisible(true);
        }
        });
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XSSFWorkbook workbook= new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Khách hàng");
                XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH KHÁCH HÀNG");

            row = sheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("ID");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã DH");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã KH");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Họ tên khách hàng");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên sản phẩm");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số lượng");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Giá bán");           
            List<XuatDonhang> listItem = xdhService.getList(); 
            if(listItem!=null){
                    try {
                        int s= listItem.size();
                        for (int i = 0; i < s; i++) {
                            XuatDonhang dh = listItem.get(i);
                            row = sheet.createRow((short) 4 + i);
                            row.setHeight((short) 400);
                            row.createCell(0).setCellValue(dh.getID());
                            row.createCell(1).setCellValue(dh.getMaDH());
                            row.createCell(2).setCellValue(dh.getMaKH());
                            row.createCell(3).setCellValue(dh.getHoten());
                            row.createCell(4).setCellValue(dh.getTenSP());
                            row.createCell(5).setCellValue(dh.getSoluong());
                            row.createCell(6).setCellValue(dh.getGiaban());
                        }
                        
                        File f =new File("D:/Donhang.xlsx");
                        FileOutputStream fis = new FileOutputStream(f);
                        workbook.write(fis);
                        fis.close();
                        
                    } catch (IOException ex) {
                        Logger.getLogger(XuatDonHangcontroller.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            }
                
        });
        
    }
    
}
