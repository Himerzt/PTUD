
package giaodien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.KhachHangDao;
import dao.LoaiThueDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.Phong;
import entity.ThongTinDatThuePhong;

/**
 *
 * @author Huynguyen
 */
public class DatPhong2 extends javax.swing.JDialog {

	private String[] dsPhongDat;
	private DichVuDao dichVuDao;
	private ThongTinDatThuePhongDao thongTinDatThuePhongDao;
	private KhachHangDao khachHangDao;
	private LoaiThueDao loaiThueDao;
	private PhongDao phongDao;

	/**
	 * Creates new form DatPhong
	 */

	public DatPhong2(List<String> dsTenPhong) {
		dsPhongDat = new String[dsTenPhong.size()];
		int index = 0;
		for (String tenPhong : dsTenPhong) {
			dsPhongDat[index++] = tenPhong;
		}
		ConnectDB.getInstance().getConnection();
		initComponents();
		loadDanhSachPhongDat();
	}

	public String[] layDanhSachPhongDat() {
		return dsPhongDat;
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		dateNgayDat = new giaodien.CustomClass.DateChooser();
		dateNgayTra = new giaodien.CustomClass.DateChooser();
		dateNgayNhan = new giaodien.CustomClass.DateChooser();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		jScrollPane2 = new giaodien.CustomClass.ScrollPaneWin11();
		tableDanhSachPhong = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new giaodien.CustomClass.ScrollPaneWin11();
		tableDV = new javax.swing.JTable();
		jLabel3 = new javax.swing.JLabel();
		panelRound1 = new giaodien.CustomClass.PanelRound();
		jLabel17 = new javax.swing.JLabel();
		txtTenKH = new giaodien.CustomClass.TextFieldShadow();
		txtSoLuongNguoiLon = new giaodien.CustomClass.TextFieldShadow();
		jLabel22 = new javax.swing.JLabel();
		txtCCCD = new giaodien.CustomClass.TextFieldShadow();
		jLabel24 = new javax.swing.JLabel();
		btnThemKhachHang = new giaodien.CustomClass.Button();
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
		btnGiaCoc = new giaodien.CustomClass.Button();
		txtSoLuongTreEm = new giaodien.CustomClass.TextFieldShadow();
		jLabel23 = new javax.swing.JLabel();
		panelRound4 = new giaodien.custom2.PanelRound();
		cbKieuThue = new giaodien.CustomClass.Combobox();
		panelRound2 = new giaodien.CustomClass.PanelRound();
		btnThemDichVu = new giaodien.CustomClass.Button();
		panelRound3 = new giaodien.custom2.PanelRound();
		comboBoxDichVu = new giaodien.CustomClass.Combobox();
		btnDatPhong = new giaodien.CustomClass.Button();
		btnHuy = new giaodien.CustomClass.Button();

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

		tableDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "STT", "Tên phòng", "Loại phòng" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tableDanhSachPhong.setRowHeight(40);
		tableDanhSachPhong.setSelectionBackground(new java.awt.Color(254, 109, 115));
		jScrollPane2.setViewportView(tableDanhSachPhong);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel2.setText("Danh sách dịch vụ");

		tableDV.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "STT", "Tên dịch vụ", "Số lượng", "Phòng", "Đơn giá", "Tổng" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
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

		txtTenKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTenKHActionPerformed();
			}
		});

		txtSoLuongNguoiLon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSoLuongNguoiLonActionPerformed();
			}
		});

		jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel22.setText("Người lớn");

		txtCCCD.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtCCCDActionPerformed();
			}
		});

		jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel24.setText("CCCD/Passport");

		btnThemKhachHang.setText("+");

		jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel25.setText("Kiểu thuê");

		txtCheckIn.setEnabled(false);
		txtCheckIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtCheckInActionPerformed();
			}
		});

		jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel27.setText("Ngày đặt");

		txtNgayNhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtNgayNhanActionPerformed();
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
				btnNgayNhanActionPerformed();
			}
		});

		txtCheckOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtCheckOutActionPerformed();
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
				btnNgayTraActionPerformed();
			}
		});

		txtGiaCoc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtGiaCocActionPerformed();
			}
		});

		jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel31.setText("Giá cọc");

		btnGiaCoc.setText("+");

		txtSoLuongTreEm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSoLuongTreEmActionPerformed();
			}
		});

		jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel23.setText("Trẻ em");

		panelRound4.setBackground(new java.awt.Color(255, 255, 255));
		panelRound4.setRoundBottomLeft(15);
		panelRound4.setRoundBottomRight(15);
		panelRound4.setRoundTopLeft(15);
		panelRound4.setRoundTopRight(15);

		cbKieuThue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày", "Theo giờ", "Qua đêm" }));
		cbKieuThue.setSelectedIndex(-1);
		cbKieuThue.setLabeText("");

		javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
		panelRound4.setLayout(panelRound4Layout);
		panelRound4Layout
				.setHorizontalGroup(
						panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelRound4Layout.createSequentialGroup().addGap(15, 15, 15)
										.addComponent(cbKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(15, Short.MAX_VALUE)));
		panelRound4Layout
				.setVerticalGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelRound4Layout.createSequentialGroup().addGap(0, 0, 0).addComponent(cbKieuThue,
								javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)));

		javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
		panelRound1.setLayout(panelRound1Layout);
		panelRound1Layout.setHorizontalGroup(panelRound1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound1Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(panelRound1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addGroup(panelRound1Layout.createSequentialGroup().addComponent(jLabel28)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(panelRound1Layout.createSequentialGroup().addComponent(jLabel23)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtSoLuongTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(panelRound1Layout.createSequentialGroup()
								.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelRound1Layout.createSequentialGroup().addGap(26, 26, 26)
										.addComponent(jLabel24)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 164,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelRound1Layout.createSequentialGroup().addGap(78, 78, 78)
										.addComponent(jLabel27)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelRound1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel29)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(panelRound1Layout.createSequentialGroup().addGap(53, 53, 53)
										.addGroup(panelRound1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel25).addComponent(jLabel22))
										.addGroup(panelRound1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(panelRound1Layout.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(txtSoLuongNguoiLon,
																javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap(40, Short.MAX_VALUE))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														panelRound1Layout.createSequentialGroup().addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(panelRound4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(44, 44, 44))))
								.addGroup(panelRound1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel31).addGap(18, 18, 18)
										.addComponent(txtGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(44, 44, 44)))));
		panelRound1Layout.setVerticalGroup(panelRound1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound1Layout.createSequentialGroup().addGap(36, 36, 36).addGroup(panelRound1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSoLuongNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelRound1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(panelRound1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel25)
												.addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtSoLuongTreEm, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelRound1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panelRound1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(panelRound1Layout.createSequentialGroup().addGap(13, 13, 13)
										.addGroup(panelRound1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(panelRound1Layout.createSequentialGroup().addComponent(
														btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
														javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(panelRound1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE,
																19, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txtCheckOut,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(panelRound1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(
										btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panelRound1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panelRound1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(37, Short.MAX_VALUE)));

		panelRound2.setPreferredSize(new java.awt.Dimension(312, 72));
		panelRound2.setRoundBottomLeft(20);
		panelRound2.setRoundBottomRight(20);
		panelRound2.setRoundTopLeft(20);
		panelRound2.setRoundTopRight(20);

		btnThemDichVu.setText("Thêm dịch vụ");

		panelRound3.setBackground(new java.awt.Color(255, 255, 255));
		panelRound3.setRoundBottomLeft(15);
		panelRound3.setRoundBottomRight(15);
		panelRound3.setRoundTopLeft(15);
		panelRound3.setRoundTopRight(15);

		comboBoxDichVu.setModel(new javax.swing.DefaultComboBoxModel(loadDanhSachDichVu()));
		comboBoxDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		comboBoxDichVu.setLabeText("");

		btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemKhachHangActionPerformed();
			}
		});

		javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
		panelRound3.setLayout(panelRound3Layout);
		panelRound3Layout
				.setHorizontalGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelRound3Layout.createSequentialGroup().addGap(16, 16, 16)
								.addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(20, Short.MAX_VALUE)));
		panelRound3Layout
				.setVerticalGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelRound3Layout.createSequentialGroup().addGap(0, 0, 0).addComponent(comboBoxDichVu,
								javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
		panelRound2.setLayout(panelRound2Layout);
		panelRound2Layout.setHorizontalGroup(panelRound2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound2Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										panelRound2Layout.createSequentialGroup()
												.addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(20, 20, 20))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										panelRound2Layout.createSequentialGroup()
												.addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
														135, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(64, 64, 64)))));
		panelRound2Layout
				.setVerticalGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelRound2Layout.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE)
								.addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(31, 31, 31)));

		btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemDichVuActionPerformed();
			}
		});

		btnDatPhong.setText("Đặt phòng");
		btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDatPhongActionPerformed();
			}
		});

		btnHuy.setText("Hủy");
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed();
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1081,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel32)
												.addGap(203, 203, 203).addComponent(jLabel2))))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(514, 514, 514)
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGap(24, 24, 24)
																.addComponent(btnDatPhong,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 107,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(btnHuy,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 120,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(panelRound2,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 279,
																		Short.MAX_VALUE)))))))
						.addGap(12, 12, 12)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jLabel1)
						.addGap(18, 18, 18)
						.addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 221,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(40, 40, 40)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel32).addComponent(jLabel2).addComponent(jLabel3))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96,
												Short.MAX_VALUE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGap(30, 30, 30)));

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		dichVuDao = new DichVuDao();
		thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
		khachHangDao = new KhachHangDao();
		loaiThueDao = new LoaiThueDao();
		phongDao = new PhongDao();
		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void txtTenKHActionPerformed() {// GEN-FIRST:event_txtTenKHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTenKHActionPerformed

	private void txtSoLuongNguoiLonActionPerformed() {// GEN-FIRST:event_txtSoLuongNguoiLonActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSoLuongNguoiLonActionPerformed

	private void txtCCCDActionPerformed() {// GEN-FIRST:event_txtCCCDActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtCCCDActionPerformed

	private void txtCheckInActionPerformed() {// GEN-FIRST:event_txtCheckInActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtCheckInActionPerformed
	
	public boolean kiemTraTrungNgayNhan(LocalDate ngayNhan) {
		List<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao.timTatCaThongTinDatThuePhong();
		for (ThongTinDatThuePhong thongTinDatThuePhong : dsTTDTP) {
			if (ngayNhan.isBefore(thongTinDatThuePhong.getNgayTraPhong())
					&& ngayNhan.isAfter(thongTinDatThuePhong.getNgayNhanPhong()))
				return false;
			else if (ngayNhan.equals(thongTinDatThuePhong.getNgayNhanPhong()))
					return false;
		}
		return true;
	}

	private void txtNgayNhanActionPerformed() {// GEN-FIRST:event_txtNgayNhanActionPerformed
		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		if (!kiemTraTrungNgayNhan(ngayNhan)) {
			JOptionPane.showMessageDialog(this, "Ngày nhận phòng bị trùng với lịch đặt phòng khác");
			return;
		} else if (ngayNhan.isBefore(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "Ngày nhận phòng không hợp lệ");
			return;
		}
	}// GEN-LAST:event_txtNgayNhanActionPerformed

	private void btnNgayNhanActionPerformed() {// GEN-FIRST:event_btnNgayNhanActionPerformed
		dateNgayNhan.showPopup();
	}// GEN-LAST:event_btnNgayNhanActionPerformed
	
	public boolean kiemTraTrungNgayTra(LocalDate ngayTra) {
		List<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao.timTatCaThongTinDatThuePhong();
		for (ThongTinDatThuePhong thongTinDatThuePhong : dsTTDTP) {
			if (ngayTra.isBefore(thongTinDatThuePhong.getNgayTraPhong())
					&& ngayTra.isAfter(thongTinDatThuePhong.getNgayNhanPhong())) {
				return false;
			} else if (ngayTra.equals(thongTinDatThuePhong.getNgayTraPhong())) {
				return false;
			}
		}
		return true;
	}

	public boolean kiemTraTrungThoiGianThue(LocalDate ngayNhan, LocalDate ngayTra) {
		List<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao.timTatCaThongTinDatThuePhong();
		for (ThongTinDatThuePhong thongTinDatThuePhong : dsTTDTP) {
			LocalDate ngayNhanCoSan = thongTinDatThuePhong.getNgayNhanPhong();
			LocalDate ngayTraCoSan = thongTinDatThuePhong.getNgayTraPhong();
			// Kiểm tra khoảng thời gian từ ngày nhận đến ngày trả có chứa khoảng thời gian khác có sẵn không
			if (ngayNhan.isBefore(ngayNhanCoSan) && ngayTra.isAfter(ngayTraCoSan))
				return false;
			else if (ngayNhan.isAfter(ngayNhanCoSan) && ngayTra.isBefore(ngayTraCoSan)) 
				return false;
		}
		return true;
	}
	private void txtCheckOutActionPerformed() {// GEN-FIRST:event_txtCheckOutActionPerformed
		LocalDate ngayTra = LocalDate.parse(txtCheckOut.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		if (!kiemTraTrungNgayTra(ngayTra))
			JOptionPane.showMessageDialog(this, "Ngày trả phòng bị trùng với lịch đặt phòng khác");
		else if (!kiemTraTrungThoiGianThue(ngayNhan, ngayTra))
			JOptionPane.showMessageDialog(this, "Thời gian thuê phòng bị trùng với lịch đặt phòng khác");
		else if (ngayTra.isBefore(ngayNhan)) {
			JOptionPane.showMessageDialog(this, "Ngày trả phòng không hợp lệ");
		}
	}// GEN-LAST:event_txtCheckOutActionPerformed

	private void btnNgayTraActionPerformed() {// GEN-FIRST:event_btnNgayTraActionPerformed
		dateNgayTra.showPopup();
	}// GEN-LAST:event_btnNgayTraActionPerformed

	private void txtGiaCocActionPerformed() {// GEN-FIRST:event_txtGiaCocActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtGiaCocActionPerformed

	private void btnDatPhongActionPerformed() {// GEN-FIRST:event_btnDatPhongActionPerformed
		// GEN-FIRST:event_btnDatPhongActionPerformed
		String[] dsPhongDat = layDanhSachPhongDat();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		// Lấy tên trong dsPhongDat, so sánh và lấy thông tin phòng từ CSDL
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}

		new ThongTinDatThuePhongDao();
		khachHangDao.timTheoCCCD(txtCCCD.getText());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate.parse(txtCheckIn.getText(), formatter);
		LocalDate.parse(txtNgayNhan.getText(), formatter);
		LocalDate.parse(txtCheckOut.getText(), formatter);
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
			String.format("%s%s", kieuThue, loaiPhong);
		}

//		if (thongTinDatThuePhongDao.datPhong(dsPhong, khachHang, ngayDat, ngayNhan, maLoaiThue, ngayTra)) {
//			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
//			DatPhong2.this.dispose();
//		} else {
//			JOptionPane.showMessageDialog(this, "Đặt phòng thất bại");
//		}

	}// GEN-LAST:event_btnDatPhongActionPerformed

	private void btnHuyActionPerformed() {// GEN-FIRST:event_btnHuyActionPerformed
		this.setVisible(false);
	}// GEN-LAST:event_btnHuyActionPerformed

	private void txtSoLuongTreEmActionPerformed() {// GEN-FIRST:event_txtSoLuongTreEmActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSoLuongTreEmActionPerformed

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

	// Check CCCD
	public boolean regCCCD_Passport(String cccd_passport) {
		if (cccd_passport.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập CCCD/Passport");
			return false;
		} else {
			// Regex cho mã số CCCD hoặc Visa
			String regex = "^(\\d{12}|\\d{16})$";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(cccd_passport);

			if (!matcher.matches()) {
				JOptionPane.showMessageDialog(this, "CCCD/Passport không hợp lệ");
				return false;
			}
			return true;
		}
	}

	public void loadDanhSachPhongDat() {
		// Hiện danh sách phòng vào bảng
		String[] dsPhongDat = layDanhSachPhongDat();
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

	public double tinhTienCoc() {
		String[] dsPhongDat = layDanhSachPhongDat();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		// Lấy tên trong dsPhongDat, so sánh và lấy thông tin phòng từ CSDL
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}
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

			} else if (ngayDat.isBefore(ngayNhan)) {
				soTienCoc += loaiThueDao.timGiaCocTheoMaThue(maLoaiThue);
			}
		}
		return soTienCoc;
	}

	private void btnThemDichVuActionPerformed() {
		loadDanhSachDichVu();
		DichVuPhong dvPhong = new DichVuPhong();
		int selectedPhong = tableDanhSachPhong.getSelectedRow();
		if (selectedPhong != -1) {
			String tenPhong = tableDanhSachPhong.getValueAt(selectedPhong, 1).toString();
			String maDichVu = comboBoxDichVu.getSelectedItem().toString().split(" ")[0];
			dvPhong.setMaPhong(phongDao.timMaPhongTheoTenPhong(tenPhong));
			dvPhong.setMaDichVu(maDichVu);
			double giaDichVu = dichVuDao.timTheoMaDichVu(maDichVu).getGiaDV();
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
					model.setValueAt(giaMoi, i, 5);
					daThem = true;
					break;
				}
			}
			if (!daThem) {
				Object[] rowData = { model.getRowCount() + 1, comboBoxDichVu.getSelectedItem().toString(), 1, tenPhong,
						dichVuDao.timTheoMaDichVu(maDichVu).getGiaDV(), giaDichVu };
				model.addRow(rowData);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần thêm dịch vụ");
		}
	}// GEN-LAST:event_btnThemDichVuActionPerformed

	private void btnThemKhachHangActionPerformed() {// GEN-FIRST:event_btnThemKhachHangActionPerformed
		KhachHang kh = new KhachHang();
		if (regCCCD_Passport(txtCCCD.getText()) == false)
			return;
		kh.setCccd_passport(txtCCCD.getText());
		// Tìm khách hàng bằng CCCD. Nếu tìm thấy thì tự fill các textfield còn lại, nếu không thì thông báo không tìm thấy
		if (khachHangDao.timTheoCCCD(kh.getCccd_passport()) != null) {
			kh = khachHangDao.timTheoCCCD(kh.getCccd_passport());
			txtTenKH.setText(kh.getHoTenKH());
		} else {
			// Thông báo bằng JOptionpane hỏi có muốn thêm khách hàng vào CSDL không
			JOptionPane.showMessageDialog(this, "Khách hàng hiện chưa được thêm!");
			return;
		}
	}// GEN-LAST:event_btnThemKhachHangActionPerformed

	private String[] loadDanhSachDichVu() {
		DichVuDao dichVuDao = new DichVuDao();
		ArrayList<DichVu> danhSachDV = dichVuDao.timTatCaDichVu();
		String[] tenDV = new String[danhSachDV.size()];
		for (int i = 0; i < danhSachDV.size(); i++) {
			tenDV[i] = String.format("%s %s", danhSachDV.get(i).getMaDV(), danhSachDV.get(i).getTenDV());
		}
		return tenDV;
	}

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
//				List<String> args = new ArrayList<String>();
//				args.add("101");
//				args.add("102");
//				args.add("103");
//				DatPhong2 guiDatPhong = new DatPhong2(args);
//				guiDatPhong.setVisible(true);
//				guiDatPhong.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private giaodien.CustomClass.Button btnDatPhong;
	private giaodien.CustomClass.Button btnGiaCoc;
	private giaodien.CustomClass.Button btnHuy;
	private giaodien.CustomClass.Button btnNgayNhan;
	private giaodien.CustomClass.Button btnNgayTra;
	private giaodien.CustomClass.Button btnThemDichVu;
	private giaodien.CustomClass.Button btnThemKhachHang;
	private giaodien.CustomClass.Combobox cbKieuThue;
	private giaodien.CustomClass.Combobox comboBoxDichVu;
	private giaodien.CustomClass.DateChooser dateNgayDat;
	private giaodien.CustomClass.DateChooser dateNgayNhan;
	private giaodien.CustomClass.DateChooser dateNgayTra;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel2;
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
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private giaodien.CustomClass.PanelRound panelRound1;
	private giaodien.CustomClass.PanelRound panelRound2;
	private giaodien.custom2.PanelRound panelRound3;
	private giaodien.custom2.PanelRound panelRound4;
	private javax.swing.JTable tableDV;
	private javax.swing.JTable tableDanhSachPhong;
	private giaodien.CustomClass.TextFieldShadow txtCCCD;
	private giaodien.CustomClass.TextFieldShadow txtCheckIn;
	private giaodien.CustomClass.TextFieldShadow txtCheckOut;
	private giaodien.CustomClass.TextFieldShadow txtGiaCoc;
	private giaodien.CustomClass.TextFieldShadow txtNgayNhan;
	private giaodien.CustomClass.TextFieldShadow txtSoLuongNguoiLon;
	private giaodien.CustomClass.TextFieldShadow txtSoLuongTreEm;
	private giaodien.CustomClass.TextFieldShadow txtTenKH;
	// End of variables declaration//GEN-END:variables
}
