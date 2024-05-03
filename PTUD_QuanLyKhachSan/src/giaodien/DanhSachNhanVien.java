package giaodien;

import dao.ChucVuDao;
import dao.DichVuDao;
import dao.HangThanhVienDao;
import dao.KhachHangDao;
import dao.NhanVienDao;

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
import entity.ChucVu;
import entity.DichVu;
import entity.HangThanhVien;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

import javax.swing.JFrame;
import menu.MenuEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

/**
 * @author Huynguyen
 */
public class DanhSachNhanVien extends javax.swing.JFrame {
    private NhanVienDao nhanVienDao = new NhanVienDao();
    public DanhSachNhanVien() throws Exception {

        initComponents();
        loadTableDanhSachNhanVien();
        

    }

    ;

	@SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        DanhSachNhanVien = new javax.swing.JTable();
        btnCapLaiMatKhau = new giaodien.CustomClass.Button();
        txtHoTen = new giaodien.CustomClass.TextFieldShadow();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiem = new giaodien.CustomClass.Button();
        btnCapNhat = new giaodien.CustomClass.Button();
        btnThem = new giaodien.CustomClass.Button();
        panelRound4 = new giaodien.custom2.PanelRound();
        cbChucVu = new giaodien.CustomClass.Combobox();
        btnReset = new giaodien.CustomClass.Button();

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

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        DanhSachNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DanhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Email", "CCCD", "Địa chỉ", "Chức vụ", "Ngày vào làm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DanhSachNhanVien.setRowHeight(40);
        jScrollPane1.setViewportView(DanhSachNhanVien);
        if (DanhSachNhanVien.getColumnModel().getColumnCount() > 0) {
            DanhSachNhanVien.getColumnModel().getColumn(0).setMinWidth(50);
            DanhSachNhanVien.getColumnModel().getColumn(0).setPreferredWidth(50);
            DanhSachNhanVien.getColumnModel().getColumn(0).setMaxWidth(50);
            DanhSachNhanVien.getColumnModel().getColumn(4).setMinWidth(80);
            DanhSachNhanVien.getColumnModel().getColumn(4).setPreferredWidth(80);
            DanhSachNhanVien.getColumnModel().getColumn(4).setMaxWidth(80);
            DanhSachNhanVien.getColumnModel().getColumn(9).setMinWidth(80);
            DanhSachNhanVien.getColumnModel().getColumn(9).setPreferredWidth(80);
            DanhSachNhanVien.getColumnModel().getColumn(9).setMaxWidth(80);
        }

        btnCapLaiMatKhau.setText("Cấp lại mật khẩu");
        btnCapLaiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapLaiMatKhauActionPerformed(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Họ tên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Chức vụ");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quản lý", "Nhân viên" }));
        cbChucVu.setSelectedIndex(-1);
        cbChucVu.setLabeText("");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/reset.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
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
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 1290, 710));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // Nhận dữ liệu từ ô textfield và combobox
    String hoTenCanTim = txtHoTen.getText().trim().toLowerCase(); // Chuyển đổi tên cần tìm sang chữ thường
    String chucVuCanTim = "";
    
    if (cbChucVu.getSelectedIndex() != -1) {
        chucVuCanTim = cbChucVu.getSelectedItem().toString();
        // Chuyển đổi dữ liệu combobox sang định dạng tương ứng với dữ liệu trong cơ sở dữ liệu
        if (chucVuCanTim.equals("Nhân viên")) {
            chucVuCanTim = "NV";
        } else if (chucVuCanTim.equals("Quản lý")) {
            chucVuCanTim = "QL";
        }
    }
    
    // Lấy danh sách nhân viên từ cơ sở dữ liệu
    NhanVienDao nhanVienDao = new NhanVienDao();
    ArrayList<entity.NhanVien> dsNhanVien = nhanVienDao.timTatCaNhanVien();
    
    // Xóa dữ liệu hiện có trong bảng
    DefaultTableModel model = (DefaultTableModel) DanhSachNhanVien.getModel();
    model.setRowCount(0);

    // Duyệt qua danh sách nhân viên và so sánh họ tên và chức vụ
    for (int i = 0; i < dsNhanVien.size(); i++) {
        entity.NhanVien nv = dsNhanVien.get(i);
        String tenNhanVien = nv.getHoTenNV().toLowerCase(); // Chuyển đổi tên nhân viên sang chữ thường
        if ((hoTenCanTim.isEmpty() || tenNhanVien.contains(hoTenCanTim)) && 
            (chucVuCanTim.isEmpty() || nv.getChucVu().equalsIgnoreCase(chucVuCanTim))) {
            // Nếu họ tên và chức vụ khớp khớp, thêm nhân viên vào bảng
            Object[] rowData = {i + 1, nv.getMaNV(), nv.getHoTenNV(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getSoDT(), nv.getEmail(), nv.getCCCD(), nv.getDiaChi(), nv.getChucVu(), nv.getNgayVaoLam()};
            model.addRow(rowData);
        } else if (!hoTenCanTim.isEmpty() && chucVuCanTim.isEmpty() && tenNhanVien.contains(hoTenCanTim)) {
            // Nếu chỉ có họ tên được nhập, thêm nhân viên vào bảng nếu họ tên chứa từ khóa tìm kiếm
            Object[] rowData = {i + 1, nv.getMaNV(), nv.getHoTenNV(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getSoDT(), nv.getEmail(), nv.getCCCD(), nv.getDiaChi(), nv.getChucVu(), nv.getNgayVaoLam()};
            model.addRow(rowData);
        } else if (hoTenCanTim.isEmpty() && !chucVuCanTim.isEmpty() && nv.getChucVu().equalsIgnoreCase(chucVuCanTim)) {
            // Nếu chỉ có chức vụ được chọn, thêm nhân viên vào bảng nếu chức vụ khớp
            Object[] rowData = {i + 1, nv.getMaNV(), nv.getHoTenNV(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getSoDT(), nv.getEmail(), nv.getCCCD(), nv.getDiaChi(), nv.getChucVu(), nv.getNgayVaoLam()};
            model.addRow(rowData);
        }
    }

    }//GEN-LAST:event_btnTimKiemActionPerformed
    
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // Lấy chỉ số hàng được chọn
        int selectedRow = DanhSachNhanVien.getSelectedRow();
        // Kiểm tra xem có hàng nào được chọn không
        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng được chọn
            String maNV = DanhSachNhanVien.getValueAt(selectedRow, 1).toString();
            String hoTen = DanhSachNhanVien.getValueAt(selectedRow, 2).toString();
            String ngaySinh = DanhSachNhanVien.getValueAt(selectedRow, 3).toString();
            String gioiTinh = DanhSachNhanVien.getValueAt(selectedRow, 4).toString();
            String soDT = DanhSachNhanVien.getValueAt(selectedRow, 5).toString();
            String email = DanhSachNhanVien.getValueAt(selectedRow, 6).toString();
            String CCCD = DanhSachNhanVien.getValueAt(selectedRow, 7).toString();
            String diaChi = DanhSachNhanVien.getValueAt(selectedRow, 8).toString();
            String chucVu = DanhSachNhanVien.getValueAt(selectedRow, 9).toString();
            String ngayVaoLam = DanhSachNhanVien.getValueAt(selectedRow, 10).toString();
            
            // Chuyển đổi giá trị chức vụ từ NV và QL sang Nhân viên và Quản lý
            if(chucVu.equals("NV")) {
                chucVu = "Nhân viên";
            } else if(chucVu.equals("QL")) {
                chucVu = "Quản lý";
            }
            // Tạo đối tượng CapNhatNhanVien và truyền dữ liệu
            CapNhatNhanVien capNhatNhanVien = new CapNhatNhanVien();
            capNhatNhanVien.setData(maNV, hoTen, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi, chucVu, ngayVaoLam);
            capNhatNhanVien.setVisible(true);
        } else {
            // Hiển thị thông báo nếu không có hàng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật.");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ThemNhanVien themNhanVien = new ThemNhanVien();
        themNhanVien.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapLaiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapLaiMatKhauActionPerformed
       // Lấy hàng được chọn từ bảng DanhSachNhanVien
    int selectedRow = DanhSachNhanVien.getSelectedRow();

    // Kiểm tra xem có hàng nào được chọn không
    if (selectedRow != -1) {
        // Lấy mã nhân viên từ cột 2 (index 1) của hàng được chọn
        String maNhanVien = DanhSachNhanVien.getValueAt(selectedRow, 1).toString();

        // Lấy tên nhân viên từ cột 3 (index 2) của hàng được chọn
        String tenNhanVien = DanhSachNhanVien.getValueAt(selectedRow, 2).toString();

        // Hiển thị hộp thoại xác nhận với thông tin nhân viên đã chọn
        int option = JOptionPane.showConfirmDialog(null, "Bạn muốn cấp lại mật khẩu cho nhân viên có mã " + maNhanVien + " - " + tenNhanVien + " ?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            // Tạo đối tượng TaiKhoanDao để sử dụng hàm suaTaiKhoan
            TaiKhoanDao taiKhoanDao = new TaiKhoanDao();

            // Tạo đối tượng TaiKhoan mới với mật khẩu mặc định
            TaiKhoan taiKhoan = new  TaiKhoan();
            taiKhoan.setTenDangNhap(maNhanVien);
            taiKhoan.setMatKhau("123456789"); // Mật khẩu mặc định

            // Gọi hàm suaTaiKhoan để cập nhật mật khẩu mới
            boolean capLaiThanhCong = taiKhoanDao.suaTaiKhoan(taiKhoan);

            if (capLaiThanhCong) {
                JOptionPane.showMessageDialog(null, "Đã cấp lại mật khẩu cho nhân viên có mã " + maNhanVien);
            } else {
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Không thể cấp lại mật khẩu cho nhân viên có mã " + maNhanVien);
            }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên từ bảng để cấp lại mật khẩu.");
            }
    }//GEN-LAST:event_btnCapLaiMatKhauActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        loadTableDanhSachNhanVien();
    }//GEN-LAST:event_btnResetActionPerformed
        public void loadTableDanhSachNhanVien() {
        NhanVienDao nhanVienDao = new NhanVienDao();
        ArrayList<entity.NhanVien> dsNhanVien = nhanVienDao.timTatCaNhanVien();
        DefaultTableModel model = (DefaultTableModel) DanhSachNhanVien.getModel();

        model.setRowCount(0);

        for (int i = 0; i < dsNhanVien.size(); i++) {
            entity.NhanVien nv = dsNhanVien.get(i);
            Object[] rowData = {i + 1, nv.getMaNV(), nv.getHoTenNV(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getSoDT(), nv.getEmail(),nv.getCCCD(), nv.getDiaChi(),nv.getChucVu(), nv.getNgayVaoLam()};
            model.addRow(rowData);
        }

    }
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
            java.util.logging.Logger.getLogger(DanhSachNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DanhSachNhanVien trangChu = new DanhSachNhanVien();
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
    private javax.swing.JTable DanhSachNhanVien;
    private menu.Menu Menu;
    private giaodien.CustomClass.Button btnCapLaiMatKhau;
    private giaodien.CustomClass.Button btnCapNhat;
    private giaodien.CustomClass.Button btnReset;
    private giaodien.CustomClass.Button btnThem;
    private giaodien.CustomClass.Button btnTimKiem;
    private giaodien.CustomClass.Combobox cbChucVu;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private giaodien.custom2.PanelRound panelRound4;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    private giaodien.CustomClass.ScrollPaneWin11 scrollPaneWin112;
    private giaodien.CustomClass.TextFieldShadow txtHoTen;
    // End of variables declaration//GEN-END:variables

}
