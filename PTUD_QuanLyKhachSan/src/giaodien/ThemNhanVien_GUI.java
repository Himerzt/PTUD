
package giaodien;

import giaodien.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Huynguyen
 */
public class ThemNhanVien_GUI extends javax.swing.JDialog {

        private NhanVienDao nhanVienDao = new NhanVienDao();
        private TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
	public ThemNhanVien_GUI() {
		ConnectDB.getInstance().getConnection();
		initComponents();
	}
        
	@SuppressWarnings("unchecked")
	
        public void themNhanVien(){
    // Lấy dữ liệu từ các ô nhập liệus
    String hoTen = txtHoTenNhanVien.getText().trim();
    String diaChi = txtDiaChi.getText().trim();
    String ngaySinh = txtNgaySinh.getText().trim();
    String gioiTinh = cbGioiTinh.getSelectedItem().toString();
    String soDT = txtSoDienThoai.getText().trim();
    String email = txtEmail.getText().trim();
    String CCCD = txtCCCD.getText().trim();
    String chucVu = cbChucVu.getSelectedItem().toString();
    String ngayVaoLam = txtNgayVaoLam.getText().trim();
    
    // Kiểm tra dữ liệu đầu vào
    if (hoTen.isEmpty() || ngaySinh.isEmpty() ||diaChi.isEmpty()|| gioiTinh.isEmpty() || soDT.isEmpty() || email.isEmpty() || CCCD.isEmpty() || chucVu.isEmpty() || ngayVaoLam.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
        return;
    }
    
    // Tiến hành chuyển đổi ngày tháng về định dạng phù hợp, từ "dd/MM/yyyy" sang "yyyy-MM-dd"
    LocalDate dateNgaySinh = null;
    LocalDate dateNgayVaoLam = null;
    try {
        dateNgaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dateNgayVaoLam = LocalDate.parse(ngayVaoLam, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this, "Định dạng ngày tháng không hợp lệ. Vui lòng nhập theo định dạng dd-MM-yyyy.");
        return;
    }
    
    // Tạo mã nhân viên tự động
    String maChucVu = (chucVu.equals("Nhân viên")) ? "NV" : "QL"; // Mã chức vụ viết tắt
    String soThuTuNV = String.format("%03d", nhanVienDao.demTongSoNhanVien() + 1); // Số thứ tự nhân viên
    String maNV = "SR" + maChucVu + dateNgayVaoLam.format(DateTimeFormatter.ofPattern("ddMMyyyy")) + soThuTuNV;
    
    // Tạo một đối tượng nhân viên mới
    NhanVien newNhanVien = new NhanVien();
    newNhanVien.setMaNV(maNV);
    newNhanVien.setHoTenNV(hoTen);
    newNhanVien.setNgaySinh(dateNgaySinh);
    newNhanVien.setGioiTinh(gioiTinh);
    newNhanVien.setSoDT(soDT);
    newNhanVien.setEmail(email);
    newNhanVien.setCCCD(CCCD);
    newNhanVien.setDiaChi(diaChi);
    newNhanVien.setChucVu(maChucVu);
    newNhanVien.setNgayVaoLam(dateNgayVaoLam);
    
    TaiKhoan newTaiKhoan = new TaiKhoan();
    newTaiKhoan.setMaNhanVien(maNV);
    newTaiKhoan.setTenDangNhap(maNV);
    newTaiKhoan.setMatKhau("123456789");
    // Thực hiện thêm nhân viên vào cơ sở dữ liệu
    boolean isSuccess = nhanVienDao.themNhanVien(newNhanVien) && taiKhoanDao.themTaiKhoan(newTaiKhoan);
    
    // Kiểm tra và thông báo kết quả thêm nhân viên
    if (isSuccess) {
        JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công.");
    } else {
        JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại. Vui lòng kiểm tra lại thông tin.");
    }
}
 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateNgaySinh = new giaodien.CustomClass.DateChooser();
        dateNgayVaoLam = new giaodien.CustomClass.DateChooser();
        jPanel4 = new javax.swing.JPanel();
        txtDiaChi = new giaodien.CustomClass.TextFieldShadow();
        jLabel3 = new javax.swing.JLabel();
        txtNgayVaoLam = new giaodien.CustomClass.TextFieldShadow();
        jLabel4 = new javax.swing.JLabel();
        panelRound4 = new giaodien.custom2.PanelRound();
        cbGioiTinh = new giaodien.CustomClass.Combobox();
        jLabel5 = new javax.swing.JLabel();
        txtHoTenNhanVien = new giaodien.CustomClass.TextFieldShadow();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelRound5 = new giaodien.custom2.PanelRound();
        cbChucVu = new giaodien.CustomClass.Combobox();
        jLabel8 = new javax.swing.JLabel();
        txtSoDienThoai = new giaodien.CustomClass.TextFieldShadow();
        txtEmail = new giaodien.CustomClass.TextFieldShadow();
        txtCCCD = new giaodien.CustomClass.TextFieldShadow();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNgaySinh = new giaodien.CustomClass.TextFieldShadow();
        btnNgaySinh = new giaodien.CustomClass.Button();
        btnNgayVaoLam = new giaodien.CustomClass.Button();
        btnThem = new giaodien.CustomClass.Button();
        btnHuy = new giaodien.CustomClass.Button();

        dateNgaySinh.setForeground(new java.awt.Color(255, 203, 119));
        dateNgaySinh.setTextRefernce(txtNgaySinh);

        dateNgayVaoLam.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayVaoLam.setTextRefernce(txtNgayVaoLam);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Địa chỉ");
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 21));

        txtNgayVaoLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayVaoLamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ngày vào làm");
        jLabel4.setToolTipText("");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 21));

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam ", "Nữ", "Khác" }));
        cbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbGioiTinh.setLabeText("");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Giới tính");
        jLabel5.setToolTipText("");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 21));

        txtHoTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenNhanVienActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Họ tên nhân viên");
        jLabel6.setToolTipText("");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Chức vụ");
        jLabel7.setToolTipText("");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 21));

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(15);
        panelRound5.setRoundBottomRight(15);
        panelRound5.setRoundTopLeft(15);
        panelRound5.setRoundTopRight(15);

        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nhân viên", "Quản lý" }));
        cbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbChucVu.setLabeText("");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbChucVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Số điện thoại");
        jLabel8.setToolTipText("");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 21));

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Ngày sinh");
        jLabel9.setToolTipText("");
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("CCCD");
        jLabel10.setToolTipText("");
        jLabel10.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Email");
        jLabel11.setToolTipText("");
        jLabel11.setPreferredSize(new java.awt.Dimension(120, 21));

        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        btnNgaySinh.setBorder(null);
        btnNgaySinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgaySinh.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgaySinh.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgaySinh.setRadius(20);
        btnNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgaySinhActionPerformed(evt);
            }
        });

        btnNgayVaoLam.setBorder(null);
        btnNgayVaoLam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayVaoLam.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayVaoLam.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayVaoLam.setRadius(20);
        btnNgayVaoLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayVaoLamActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelRound5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25))
                                    .addComponent(txtHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(btnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(btnNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtNgayVaoLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayVaoLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayVaoLamActionPerformed

    private void txtHoTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenNhanVienActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDActionPerformed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void btnNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgaySinhActionPerformed
        dateNgaySinh.showPopup();
    }//GEN-LAST:event_btnNgaySinhActionPerformed

    private void btnNgayVaoLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayVaoLamActionPerformed
        dateNgayVaoLam.showPopup();
    }//GEN-LAST:event_btnNgayVaoLamActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.hide();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        themNhanVien();
    }//GEN-LAST:event_btnThemActionPerformed





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnHuy;
    private giaodien.CustomClass.Button btnNgaySinh;
    private giaodien.CustomClass.Button btnNgayVaoLam;
    private giaodien.CustomClass.Button btnThem;
    private giaodien.CustomClass.Combobox cbChucVu;
    private giaodien.CustomClass.Combobox cbGioiTinh;
    private giaodien.CustomClass.DateChooser dateNgaySinh;
    private giaodien.CustomClass.DateChooser dateNgayVaoLam;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private giaodien.custom2.PanelRound panelRound4;
    private giaodien.custom2.PanelRound panelRound5;
    private giaodien.CustomClass.TextFieldShadow txtCCCD;
    private giaodien.CustomClass.TextFieldShadow txtDiaChi;
    private giaodien.CustomClass.TextFieldShadow txtEmail;
    private giaodien.CustomClass.TextFieldShadow txtHoTenNhanVien;
    private giaodien.CustomClass.TextFieldShadow txtNgaySinh;
    private giaodien.CustomClass.TextFieldShadow txtNgayVaoLam;
    private giaodien.CustomClass.TextFieldShadow txtSoDienThoai;
    // End of variables declaration//GEN-END:variables

}
