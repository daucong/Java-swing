/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_hk;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QL_spJPanel extends javax.swing.JPanel {
    List<DM_sp> DM_spList = new ArrayList<>();
    List<QL_sp> QL_spList = new ArrayList<>();
    DefaultTableModel tableModel;
        private Connection con = null;
    /**
     * Creates new form QL_spJPanel
     */
    public QL_spJPanel() throws SQLException {
        initComponents();
        tableModel = (DefaultTableModel) tblQuanly_spList.getModel();
        LoadDanhmucDatabase();
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) cbbDanhmucsp.getModel();
        comboBoxModel.removeAllElements();
        for (DM_sp dm_sp : DM_spList) {
            comboBoxModel.addElement(dm_sp.getTenDM());      
        }
        tblQuanly_spList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tblQuanly_spList.getSelectedRow();
                QL_sp ql = QL_spList.get(index);
                txtTensp.setText(ql.getTenSP());
                txtGiasp.setText(String.valueOf(ql.getGia()));
                txtMotasp.setText(ql.getMota());
                btSua.setEnabled(true);
                btXoa.setEnabled(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
          
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        LoadQL_sp();
        show_all();
    }
    private void LoadDanhmucDatabase(){
        DM_spList.clear();
        String url = "net.sourceforge.jtds.jdbc.Driver";
        Statement statement = null;
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = (Connection) DriverManager.getConnection(dbUrl);
            String sql = "select * from Danhmuc_sp";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DM_sp dm_sp = new DM_sp(rs.getInt("id"), rs.getString("TenDM"));
                DM_spList.add(dm_sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(statement !=null){
                try {
                    statement .close();
                } catch (SQLException ex) {
                    Logger.getLogger(DM_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con !=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QL_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private void show_all(){
        tableModel.setRowCount(0);
        for (QL_sp ql_sp : QL_spList) {
            tableModel.addRow(new Object[]{
                ql_sp.getId(),
                ql_sp.getTenSP(),
                ql_sp.getDanhmuc_sp() ,
                ql_sp.getGia(),
                ql_sp.getMota(),
               
            });
            
                    }
    }
    private void  LoadQL_sp(){
        QL_spList.clear();
        String url = "net.sourceforge.jtds.jdbc.Driver";
        Statement statement = null;
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = (Connection) DriverManager.getConnection(dbUrl);
            String sql = "select Quanly_sp.*, Danhmuc_sp.TenDM from Quanly_sp, Danhmuc_sp"+" where Quanly_sp.id = Danhmuc_sp.id";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                QL_sp qlsp = new QL_sp(rs.getInt("id"), rs.getString("TenSP"),  rs.getString("tenDM"), rs.getInt("Giaban"), rs.getString("Mota"));
                QL_spList.add(qlsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(statement !=null){
                try {
                    statement .close();
                } catch (SQLException ex) {
                    Logger.getLogger(DM_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con !=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QL_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTensp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbDanhmucsp = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtGiasp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMotasp = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btTimkiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanly_spList = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin sản phẩm"));

        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setText("Danh mục sản phẩm:");

        jLabel4.setText("Giá sản phẩm:");

        jLabel5.setText("Mô tả sản phẩm:");

        btThem.setBackground(new java.awt.Color(204, 204, 204));
        btThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thi_hk/chucnang/add-button (1).png"))); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(204, 204, 204));
        btSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thi_hk/chucnang/refresh (3).png"))); // NOI18N
        btSua.setText("Sửa");
        btSua.setEnabled(false);
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(204, 204, 204));
        btXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thi_hk/chucnang/delete (2).png"))); // NOI18N
        btXoa.setText("Xóa");
        btXoa.setEnabled(false);
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btTimkiem.setBackground(new java.awt.Color(204, 204, 204));
        btTimkiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thi_hk/chucnang/seo (2).png"))); // NOI18N
        btTimkiem.setText("Tìm kiếm");
        btTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiasp, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDanhmucsp, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMotasp, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btThem)
                        .addGap(65, 65, 65)
                        .addComponent(btSua)
                        .addGap(59, 59, 59)
                        .addComponent(btXoa)
                        .addGap(68, 68, 68)
                        .addComponent(btTimkiem)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbDanhmucsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiasp, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMotasp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblQuanly_spList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "TenSP", "Danhmuc", "Gia", "Mota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblQuanly_spList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        String TenSP = txtTensp.getText().toString();
        String GiaSP = txtGiasp.getText().toString();
        String Mota = txtMotasp.getText().toString();
        int TenDM = cbbDanhmucsp.getSelectedIndex();
        DM_sp dm = DM_spList.get(TenDM);
        String tenDM = dm.getTenDM();
        
        if(TenSP.isEmpty()){
                JOptionPane.showMessageDialog(this, "Nhập tên sản phẩm cần thêm");
            }else{
                InsertQL_sp(TenSP,tenDM, GiaSP, Mota);
        }
        txtTensp.setText("");
        txtGiasp.setText("");
        txtMotasp.setText("");
        LoadQL_sp();
        show_all();
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
        int index = tblQuanly_spList.getSelectedRow();
        QL_sp dm = QL_spList.get(index);
        String url = "net.sourceforge.jtds.jdbc.Driver";
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = (Connection) DriverManager.getConnection(dbUrl);
            String sql = "update Quanly_sp set TenSP = ?, Giaban = ?, Mota = ?" + " where id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, txtTensp.getText().toString());
            preparedStatement.setString(2, txtGiasp.getText().toString());
            preparedStatement.setString(3, txtMotasp.getText().toString());
             preparedStatement.setInt(4, dm.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(preparedStatement !=null){
                try {
                    preparedStatement .close();
                } catch (SQLException ex) {
                    Logger.getLogger(DM_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con !=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DM_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }      
        LoadQL_sp();
        show_all();
        btXoa.setEnabled(false);
        btSua.setEnabled(false);
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        int index = tblQuanly_spList.getSelectedRow();
        QL_sp dm = QL_spList.get(index);
        String url = "net.sourceforge.jtds.jdbc.Driver";
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = (Connection) DriverManager.getConnection(dbUrl);
            String sql = "delete from Quanly_sp where id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, dm.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(preparedStatement !=null){
                try {
                    preparedStatement .close();
                } catch (SQLException ex) {
                    Logger.getLogger(DM_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con !=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DM_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        LoadQL_sp();
        show_all();
        btXoa.setEnabled(false);
        btSua.setEnabled(false);
    }//GEN-LAST:event_btXoaActionPerformed
    public QL_sp findByID(String TenSP) throws Exception{
        String url = "net.sourceforge.jtds.jdbc.Driver";
        PreparedStatement ps = null;
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = (Connection) DriverManager.getConnection(dbUrl);
            String sql = "select * from Quanly_sp where TenSP = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, TenSP);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                QL_sp ql = new QL_sp();
                ql.setTenSP(rs.getString("TenSP"));
                ql.setGia(rs.getInt("Giaban"));
                ql.setMota(rs.getString("Mota"));
                return ql;
            }     
        } catch (SQLException e) {
        }
         return null;
        
    }
    private void btTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimkiemActionPerformed
        // TODO add your handling code here:      
        if(txtTensp.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Tên sản phẩm cần phải nhập để tìm kiếm");
            return;
        }
        try {
            QL_sp ql = findByID(txtTensp.getText());
            if(ql != null){
                txtTensp.setText(ql.getTenSP());
                txtGiasp.setText(String.valueOf(ql.getGia()));
                txtMotasp.setText(ql.getMota());
                
            }else{
                JOptionPane.showMessageDialog(this, "Sản phẩm không tìm thấy");
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Error: "+e.getMessage());
             e.printStackTrace();            
        }
    }//GEN-LAST:event_btTimkiemActionPerformed
    private void InsertQL_sp(String TenSP,String TenDM, String Gia, String mota){
        String url = "net.sourceforge.jtds.jdbc.Driver";
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DAUCONG:1433/BanDoAnVat";
            con = (Connection) DriverManager.getConnection(dbUrl);
            String sql = "insert into Quanly_sp(TenSP,TenDM,Giaban,Mota) values (?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, TenSP);
            preparedStatement.setString(2, TenDM);
            preparedStatement.setString(3, Gia);
            preparedStatement.setString(4, mota);           
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(preparedStatement !=null){
                try {
                    preparedStatement .close();
                } catch (SQLException ex) {
                    Logger.getLogger(DM_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con !=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QL_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QL_spJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_spJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_spJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_spJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QL_spJPanel().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QL_spJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimkiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbbDanhmucsp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQuanly_spList;
    private javax.swing.JTextField txtGiasp;
    private javax.swing.JTextField txtMotasp;
    private javax.swing.JTextField txtTensp;
    // End of variables declaration//GEN-END:variables
}
