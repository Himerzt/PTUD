
package giaodien;

import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.Phong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.DichVuPhongDao;
import dao.KhachHangDao;
import dao.LoaiPhongDao;
import dao.LoaiThueDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
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

/**
 *
 * @author Huynguyen
 */
public class DatPhong2 extends javax.swing.JDialog {

	private List<DichVuPhong> danhSachDichVu;
	private String[] dsPhongDat;
	List<String> dsTenPhong;

	/**
	 * Creates new form DatPhong
	 */
	public DatPhong2() {
		ConnectDB.getInstance().getConnection();
		initComponents();
	}

	public DatPhong2(List<String> dsTenPhong) {
		dsPhongDat = new String[dsTenPhong.size()];
		int index = 0;
		for (String tenPhong : dsTenPhong) {
			dsPhongDat[index++] = tenPhong;
		}
		ConnectDB.getInstance().getConnection();
		initComponents();
	}

	public String[] layDanhSachPhongDat() {
		return dsPhongDat;
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateNgaySinh = new chooserDay.DateChooser();
        dateNgayDat = new chooserDay.DateChooser();
        dateNgayTra = new chooserDay.DateChooser();
        dateNgayNhan = new chooserDay.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new ScollBar1.ScrollPaneWin11();
        tableDanhSachPhong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new ScollBar1.ScrollPaneWin11();
        tableDV = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        panelRound1 = new giaodien.CustomClass.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTenKH = new giaodien.CustomClass.TextFieldShadow();
        txtNgaySinh = new giaodien.CustomClass.TextFieldShadow();
        cbBoxGioiTinh = new combobox.Combobox();
        jLabel20 = new javax.swing.JLabel();
        txtQuocTich = new giaodien.CustomClass.TextFieldShadow();
        txtSoDienThoai = new giaodien.CustomClass.TextFieldShadow();
        jLabel21 = new javax.swing.JLabel();
        txtSoLuongKhach = new giaodien.CustomClass.TextFieldShadow();
        jLabel22 = new javax.swing.JLabel();
        txtHangThanhVien = new giaodien.CustomClass.TextFieldShadow();
        jLabel23 = new javax.swing.JLabel();
        txtCCCD = new giaodien.CustomClass.TextFieldShadow();
        jLabel24 = new javax.swing.JLabel();
        button1 = new giaodien.CustomClass.Button();
        cbKieuThue = new combobox.Combobox();
        jLabel25 = new javax.swing.JLabel();
        txtCheckIn = new giaodien.CustomClass.TextFieldShadow();
        jLabel27 = new javax.swing.JLabel();
        txtNgayNhan = new giaodien.CustomClass.TextFieldShadow();
        jLabel28 = new javax.swing.JLabel();
        btnNgayNhan = new giaodien.CustomClass.Button();
        txtCheckOut = new giaodien.CustomClass.TextFieldShadow();
        jLabel29 = new javax.swing.JLabel();
        btnNgayTra = new giaodien.CustomClass.Button();
        txtGiaCoc = new giaodien.CustomClass.TextFieldShadow();
        jLabel31 = new javax.swing.JLabel();
        txtGiaPhong = new giaodien.CustomClass.TextFieldShadow();
        jLabel33 = new javax.swing.JLabel();
        panelRound2 = new giaodien.CustomClass.PanelRound();
        comboBoxDichVu = new combobox.Combobox();
        btnThemDichVu = new giaodien.CustomClass.Button();
        btnDatPhong = new giaodien.CustomClass.Button();
        btnHuy = new giaodien.CustomClass.Button();

        dateNgaySinh.setForeground(new java.awt.Color(255, 203, 119));
        dateNgaySinh.setTextRefernce(txtNgaySinh);

        dateNgayDat.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayDat.setTextRefernce(txtCheckIn);

        dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayTra.setTextRefernce(txtCheckOut);

        dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayNhan.setTextRefernce(txtNgayNhan);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Đặt phòng");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Danh sách phòng");

        tableDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên phòng", "Loại phòng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDanhSachPhong.setRowHeight(40);
        tableDanhSachPhong.setSelectionBackground(new java.awt.Color(254, 109, 115));
        jScrollPane2.setViewportView(tableDanhSachPhong);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh sách dịch vụ");

        tableDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên dịch vụ", "Số lượng", "Phòng", "Đơn giá", "Tổng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDV.setRowHeight(40);
        jScrollPane1.setViewportView(tableDV);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Thêm dịch vụ phòng");

        panelRound1.setPreferredSize(new java.awt.Dimension(1047, 238));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Tên khách hàng");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Ngày sinh");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Giới tính");

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        cbBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ", "Khác" }));
        cbBoxGioiTinh.setSelectedIndex(-1);
        cbBoxGioiTinh.setLabeText("");
        cbBoxGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBoxGioiTinhActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Quốc tịch");

        txtQuocTich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuocTichActionPerformed(evt);
            }
        });

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Số điện thoại");

        txtSoLuongKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongKhachActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Số lượng khách");

        txtHangThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHangThanhVienActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Hạng thành viên");

        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("CCCD/Passport");

        button1.setText("+");

        cbKieuThue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày", "Theo giờ", "Qua đêm" }));
        cbKieuThue.setSelectedIndex(-1);
        cbKieuThue.setLabeText("");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Kiểu thuê");

        txtCheckIn.setEnabled(false);
        txtCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckInActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Ngày đặt");

        txtNgayNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayNhanActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Ngày nhận");

        btnNgayNhan.setBorder(null);
        btnNgayNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayNhan.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayNhan.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayNhan.setRadius(20);
        btnNgayNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayNhanActionPerformed(evt);
            }
        });

        txtCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckOutActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Ngày trả");

        btnNgayTra.setBorder(null);
        btnNgayTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayTra.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayTra.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayTra.setRadius(20);
        btnNgayTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayTraActionPerformed(evt);
            }
        });

        txtGiaCoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaCocActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Giá cọc");

        txtGiaPhong.setEnabled(false);
        txtGiaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaPhongActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Giá phòng");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHangThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound1Layout.createSequentialGroup()
                                            .addGap(51, 51, 51)
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(149, 149, 149))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cbKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSoLuongKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtHangThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jLabel25)))))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        panelRound2.setPreferredSize(new java.awt.Dimension(312, 72));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        comboBoxDichVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ăn sáng", "Ăn trưa", "Ăn chiều", "Giặt quần áo", "Đưa đón khách", "Thêm giường", "Thêm gối", "Thêm chăn", "Nước ngọt", "Nước suối", "Gọi món tại phòng" }));
        comboBoxDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxDichVu.setLabeText("");

        btnThemDichVu.setText("Thêm dịch vụ");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        btnDatPhong.setText("Đặt phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(314, 314, 314))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void cbBoxGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBoxGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBoxGioiTinhActionPerformed

    private void txtQuocTichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuocTichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuocTichActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void txtSoLuongKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongKhachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongKhachActionPerformed

    private void txtHangThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHangThanhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHangThanhVienActionPerformed

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDActionPerformed

    private void txtCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckInActionPerformed

    private void txtNgayNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayNhanActionPerformed

    private void btnNgayNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayNhanActionPerformed
        dateNgayNhan.showPopup();
    }//GEN-LAST:event_btnNgayNhanActionPerformed

    private void txtCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckOutActionPerformed

    private void btnNgayTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayTraActionPerformed
       dateNgayTra.showPopup();
    }//GEN-LAST:event_btnNgayTraActionPerformed

    private void txtGiaCocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaCocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaCocActionPerformed

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        // GEN-FIRST:event_btnDatPhongActionPerformed
		String[] dsPhongDat = layDanhSachPhongDat();
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		// Lấy tên trong dsPhongDat, so sánh và lấy thông tin phòng từ CSDL
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}

		// Khởi tạo thông tin đặt phòng
		ThongTinDatThuePhongDao thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
		KhachHangDao khachHangDao = new KhachHangDao();
		KhachHang khachHang = khachHangDao.timTheoCCCD(txtCCCD.getText());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngayDat = LocalDate.parse(txtCheckIn.getText(), formatter);
		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), formatter);
		LocalDate ngayTra = LocalDate.parse(txtCheckOut.getText(), formatter);
		String maLoaiThue = "";
		String loaiPhong = "";
		String kieuThue = "";
		if (cbKieuThue.getSelectedItem().toString().equals("Theo ngày")) {
			kieuThue = "D";
		} else if (cbKieuThue.getSelectedItem().toString().equals("Theo giờ")) {
			kieuThue = "H";
		} else {
			kieuThue = "N";
		}
		
		for (Phong phong : dsPhong) {
			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
			if (loaiPhong.equalsIgnoreCase("Tiêu chuẩn"))
				loaiPhong = "TC";
			else if (loaiPhong.equalsIgnoreCase("Cao cấp"))
				loaiPhong = "CC";
			else if (loaiPhong.equalsIgnoreCase("Nâng cao"))
				loaiPhong = "NC";
			else
				loaiPhong = "TG";
			maLoaiThue = String.format("%s%s", kieuThue, loaiPhong);
		}

//		if (thongTinDatThuePhongDao.datPhong(dsPhong, khachHang, ngayDat, ngayNhan, maLoaiThue, ngayTra)) {
//			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
//			DatPhong2.this.dispose();
//		} else {
//			JOptionPane.showMessageDialog(this, "Đặt phòng thất bại");
//		}

    }//GEN-LAST:event_btnDatPhongActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.hide();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtGiaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaPhongActionPerformed

	public String layTenLoaiPhong(String maLoai) {
		if (maLoai.equalsIgnoreCase("tc"))
			return "Tiêu chuẩn";
		else if (maLoai.equalsIgnoreCase("cc"))
			return "Cao cấp";
		else if (maLoai.equalsIgnoreCase("nc"))
			return "Nâng cao";
		else
			return "Thương gia";
	}

	public void loadDanhSachPhongDat() {
		// Hiện danh sách phòng vào bảng
		String[] dsPhongDat = layDanhSachPhongDat();
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}
		DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
		String loaiPhong = "";
		for (Phong phong : dsPhong) {
			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
			Object[] rowData = { model.getRowCount() + 1, phong.getSoPhong(), loaiPhong };
			model.addRow(rowData);
		}
	}
	
	public double setGiaCoc() {
		String[] dsPhongDat = layDanhSachPhongDat();
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		// Lấy tên trong dsPhongDat, so sánh và lấy thông tin phòng từ CSDL
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}
		LoaiThueDao loaiThueDao = new LoaiThueDao();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngayDat = LocalDate.parse(txtCheckIn.getText(), formatter);
		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), formatter);
		String loaiPhong = "";
		String maLoaiThue = "";
		double soTienCoc = 0;
		
		// Tính tiền cọc
		for (Phong phong : dsPhong) {
			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
			maLoaiThue = loaiThueDao.timMaLoaiThue(cbKieuThue.getSelectedItem().toString(), loaiPhong);
			if (ngayDat.equals(ngayNhan)) {
				return soTienCoc = 0;
				
			}
			else if (ngayDat.isBefore(ngayNhan)) {
				soTienCoc += loaiThueDao.timGiaCocTheoMaThue(maLoaiThue);
			}
		}
		return soTienCoc;
	}

	private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {                                              
	    loadDanhSachDichVu();
	    PhongDao phongDao = new PhongDao();
	    DichVuDao dvDao = new DichVuDao();
	    DichVuPhongDao dvPhongDao = new DichVuPhongDao();
	    DichVuPhong dvPhong = new DichVuPhong();
	    int selectedPhong = tableDanhSachPhong.getSelectedRow();
	    if (selectedPhong != -1) {
	        String tenPhong = tableDanhSachPhong.getValueAt(selectedPhong, 1).toString();
	        String maDichVu = comboBoxDichVu.getSelectedItem().toString().split(" ")[0];
	        dvPhong.setMaPhong(phongDao.timMaPhongTheoTenPhong(tenPhong));
	        dvPhong.setMaDichVu(maDichVu);
	        double giaDichVu = dvDao.timTheoMaDichVu(maDichVu).getGiaDV();
	        DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
	        // Kiểm tra và tăng giá trị cột số lượng nếu trùng tên phòng và mã dịch vụ
	        boolean daThem = false;
	        for (int i = 0; i < model.getRowCount(); i++) {
	            String tenPhongTrongBang = model.getValueAt(i, 3).toString();
	            String maDichVuTrongBang = model.getValueAt(i, 1).toString().split(" ")[0];
	            if (tenPhong.equals(tenPhongTrongBang) && maDichVu.equals(maDichVuTrongBang)) {
	                int soLuongHienTai = Integer.parseInt(model.getValueAt(i, 2).toString());
	                int soLuongMoi = soLuongHienTai + 1;
	                model.setValueAt(soLuongMoi, i, 2);
	                dvPhong.setSoLuong(soLuongMoi);
	                // Cập nhật lại giá dịch vụ
	                double giaMoi = giaDichVu * soLuongMoi;
	                model.setValueAt(giaMoi, i, 4);
	                daThem = true;
	                break;
	            }
	        }
	        if (!daThem) {
	            Object[] rowData = { model.getRowCount() + 1, comboBoxDichVu.getSelectedItem().toString(), 1, tenPhong, giaDichVu};
	            model.addRow(rowData);
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần thêm dịch vụ");
	    }
	}// GEN-LAST:event_btnThemDichVuActionPerformed

	private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemKhachHangActionPerformed
		KhachHang kh = new KhachHang();
		KhachHangDao khDAO = new KhachHangDao();
		kh.setCCCD_Visa(txtCCCD.getText());
		// Tìm khách hàng bằng CCCD. Nếu tìm thấy thì tự fill các textfield còn lại, nếu
		// không thì thông báo hỏi có thêm khách hàng vào CSDL hay không
		if (khDAO.timTheoCCCD(kh.getCCCD_Visa()) != null) {
			kh = khDAO.timTheoCCCD(kh.getCCCD_Visa());
			txtTenKH.setText(kh.getHoTenKH());
			txtNgaySinh.setText(kh.getNgaySinh().toString());
			txtSoDienThoai.setText(kh.getSoDT());
			txtQuocTich.setText(kh.getQuocTich());
			txtHangThanhVien.setText(kh.getMaHangThanhVien());
		} else {
			// Thông báo bằng JOptionpane hỏi có muốn thêm khách hàng vào CSDL không
			JOptionPane.showConfirmDialog(this, "Khách hàng không tồn tại. Bạn có muốn thêm khách hàng vào CSDL không?",
					"Xác nhận", JOptionPane.YES_NO_OPTION);
			if (JOptionPane.YES_OPTION == 0) {
				// Mở form thêm khách hàng

				// Thêm khách hàng vào CSDL

				// Sau khi thêm xong thì fill các textfield còn lại
			}
		}

	}// GEN-LAST:event_btnThemKhachHangActionPerformed
	/**
	 * @param args the command line arguments
	 */
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
			java.util.logging.Logger.getLogger(DatPhong2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DatPhong2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DatPhong2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DatPhong2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				List<String> args = new ArrayList<String>();
				args.add("101");
				args.add("102");
				args.add("103");
				DatPhong2 guiDatPhong = new DatPhong2(args);
				guiDatPhong.setVisible(true);
				guiDatPhong.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnDatPhong;
    private giaodien.CustomClass.Button btnHuy;
    private giaodien.CustomClass.Button btnNgayNhan;
    private giaodien.CustomClass.Button btnNgayTra;
    private giaodien.CustomClass.Button btnThemDichVu;
    private giaodien.CustomClass.Button button1;
    private combobox.Combobox cbBoxGioiTinh;
    private combobox.Combobox cbKieuThue;
    private combobox.Combobox comboBoxDichVu;
    private chooserDay.DateChooser dateNgayDat;
    private chooserDay.DateChooser dateNgayNhan;
    private chooserDay.DateChooser dateNgaySinh;
    private chooserDay.DateChooser dateNgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private giaodien.CustomClass.PanelRound panelRound1;
    private giaodien.CustomClass.PanelRound panelRound2;
    private javax.swing.JTable tableDV;
    private javax.swing.JTable tableDanhSachPhong;
    private giaodien.CustomClass.TextFieldShadow txtCCCD;
    private giaodien.CustomClass.TextFieldShadow txtCheckIn;
    private giaodien.CustomClass.TextFieldShadow txtCheckOut;
    private giaodien.CustomClass.TextFieldShadow txtGiaCoc;
    private giaodien.CustomClass.TextFieldShadow txtGiaPhong;
    private giaodien.CustomClass.TextFieldShadow txtHangThanhVien;
    private giaodien.CustomClass.TextFieldShadow txtNgayNhan;
    private giaodien.CustomClass.TextFieldShadow txtNgaySinh;
    private giaodien.CustomClass.TextFieldShadow txtQuocTich;
    private giaodien.CustomClass.TextFieldShadow txtSoDienThoai;
    private giaodien.CustomClass.TextFieldShadow txtSoLuongKhach;
    private giaodien.CustomClass.TextFieldShadow txtTenKH;
    // End of variables declaration//GEN-END:variables

	private static String[] loadDanhSachDichVu() {
		DichVuDao dvDao = new DichVuDao();
		ArrayList<DichVu> danhSachDV = dvDao.timTatCaDichVu();
		String[] tenDV = new String[danhSachDV.size()];
		for (int i = 0; i < danhSachDV.size(); i++) {
			tenDV[i] = String.format("%s %s", danhSachDV.get(i).getMaDV(), danhSachDV.get(i).getTenDV());
		}
		return tenDV;
	}
}
