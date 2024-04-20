package giaodien;

import dao.ChucVuDao;
import dao.DichVuDao;
import dao.HangThanhVienDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import entity.ChucVu;
import entity.DichVu;
import entity.HangThanhVien;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;

import static java.awt.Color.red;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import giaodien.CustomClass.DateChooser;
import connectDB.ConnectDB;
import dao.PhongDao;
import dao.TaiKhoanDao;
import java.text.ParseException;

import javax.swing.JFrame;
import menu.MenuEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Huynguyen
 */
public class DanhSachHoaDon extends javax.swing.JFrame {
    
    public DanhSachHoaDon() throws Exception {

        initComponents();
        txtNgayLapHoaDon.setText(null);
        

    }

    ;

	@SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateNgayLapHoaDon = new giaodien.CustomClass.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        scrollPaneWin112 = new giaodien.CustomClass.ScrollPaneWin11();
        pnMenu = new javax.swing.JPanel();
        Menu = new menu.Menu();
        pnHeader = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DanhSachHoaDon = new javax.swing.JTable();
        txtHoTen = new giaodien.CustomClass.TextFieldShadow();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNgayLapHoaDon = new giaodien.CustomClass.TextFieldShadow();
        btnTimKiem = new giaodien.CustomClass.Button();
        btnNgayLapHoaDon = new giaodien.CustomClass.Button();
        btnSapXep = new giaodien.CustomClass.Button();

        dateNgayLapHoaDon.setTextRefernce(txtNgayLapHoaDon);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneWin112.setBorder(null);

        pnMenu.setPreferredSize(new java.awt.Dimension(240, 800));
        pnMenu.setLayout(new java.awt.BorderLayout());
        pnMenu.add(Menu, java.awt.BorderLayout.CENTER);

        scrollPaneWin112.setViewportView(pnMenu);

        jPanel1.add(scrollPaneWin112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 710));

        pnHeader.setBackground(new java.awt.Color(34, 124, 157));
        pnHeader.setPreferredSize(new java.awt.Dimension(1553, 80));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-log-out-32.png"))); // NOI18N
        jButton9.setPreferredSize(new java.awt.Dimension(36, 36));

        jPanel5.setBackground(new java.awt.Color(34, 124, 157));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Nhoms2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(1062, 1062, 1062)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(pnHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        DanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên khách hàng", "Ngày lập", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DanhSachHoaDon.setRowHeight(40);
        jScrollPane1.setViewportView(DanhSachHoaDon);
        if (DanhSachHoaDon.getColumnModel().getColumnCount() > 0) {
            DanhSachHoaDon.getColumnModel().getColumn(0).setMinWidth(100);
            DanhSachHoaDon.getColumnModel().getColumn(0).setPreferredWidth(100);
            DanhSachHoaDon.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Họ tên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Ngày lập");

        txtNgayLapHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnNgayLapHoaDon.setBorder(null);
        btnNgayLapHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayLapHoaDon.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayLapHoaDon.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayLapHoaDon.setRadius(20);
        btnNgayLapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayLapHoaDonActionPerformed(evt);
            }
        });

        btnSapXep.setText("Sắp xếp");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(txtNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(43, 43, 43))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 1290, 710));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private DefaultTableModel originalTableModel; 
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
            
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnNgayLapHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayLapHoaDonActionPerformed
        dateNgayLapHoaDon.showPopup();
    }//GEN-LAST:event_btnNgayLapHoaDonActionPerformed
    private int sortState = 0; // Biến đếm trạng thái sắp xếp: 0 là không sắp xếp, 1 là tăng dần, -1 là giảm dần
    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
    DefaultTableModel model = (DefaultTableModel) DanhSachHoaDon.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    DanhSachHoaDon.setRowSorter(sorter);
    sorter.setSortable(4, true); // Cột số 5 (index 4) của bảng
    
    // Xác định hướng sắp xếp dựa trên trạng thái hiện tại
    SortOrder sortOrder = (sortState % 2 == 0) ? SortOrder.ASCENDING : SortOrder.DESCENDING;
    
    // Thiết lập trình sắp xếp
    List<RowSorter.SortKey> sortKeys = new ArrayList<>();
    sortKeys.add(new RowSorter.SortKey(4, sortOrder));
    sorter.setSortKeys(sortKeys);
    
    // Duyệt qua tất cả các hàng và sắp xếp chúng
    List<RowSorter.SortKey> keys = new ArrayList<>();
    keys.add(new RowSorter.SortKey(4, sortOrder));
    sorter.setSortKeys(keys);
    
    // Sắp xếp lại toàn bộ dữ liệu
    sorter.sort();
    
    // Cập nhật trạng thái sắp xếp
    sortState++;
    }//GEN-LAST:event_btnSapXepActionPerformed

    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DanhSachHoaDon trangChu = new DanhSachHoaDon();
                    trangChu.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    trangChu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    trangChu.setVisible(true);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DanhSachHoaDon;
    private menu.Menu Menu;
    private giaodien.CustomClass.Button btnNgayLapHoaDon;
    private giaodien.CustomClass.Button btnSapXep;
    private giaodien.CustomClass.Button btnTimKiem;
    private giaodien.CustomClass.DateChooser dateNgayLapHoaDon;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    private giaodien.CustomClass.ScrollPaneWin11 scrollPaneWin112;
    private giaodien.CustomClass.TextFieldShadow txtHoTen;
    private giaodien.CustomClass.TextFieldShadow txtNgayLapHoaDon;
    // End of variables declaration//GEN-END:variables

}
