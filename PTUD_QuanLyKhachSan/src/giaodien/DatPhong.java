
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
import dao.KhachHangDao;
import dao.LoaiPhongDao;
import dao.LoaiThueDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;

/**
 *
 * @author Huynguyen
 */
public class DatPhong extends javax.swing.JDialog {

	private List<DichVuPhong> danhSachDichVu;
	private String[] dsPhongDat;
	List<String> dsTenPhong;

	/**
	 * Creates new form DatPhong
	 */
	public DatPhong() {
		ConnectDB.getInstance().getConnection();
		initComponents();
	}

	public DatPhong(List<String> dsTenPhong) {
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
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		dateNgaySinh = new chooserDay.DateChooser();
		dateNgayDat = new chooserDay.DateChooser();
		dateNgayTra = new chooserDay.DateChooser();
		dateNgayNhan = new chooserDay.DateChooser();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		btnNgayTra = new giaodien.CustomClass.Button();
		btnNgaySinh = new giaodien.CustomClass.Button();
		btnNgayDat = new giaodien.CustomClass.Button();
		txtTenKH = new javax.swing.JTextField();
		txtQuocTich = new javax.swing.JTextField();
		txtHangThanhVien = new javax.swing.JTextField();
		txtTenPhong = new javax.swing.JTextField();
		txtCheckIn = new javax.swing.JTextField();
		txtNgaySinh = new javax.swing.JTextField();
		txtSoDienThoai = new javax.swing.JTextField();
		txtCCCD = new javax.swing.JTextField();
		txtLoaiPhong = new javax.swing.JTextField();
		txtCheckOut = new javax.swing.JTextField();
		txtDiaChi = new javax.swing.JTextField();
		txtGiaCoc = new javax.swing.JTextField();
		cbBoxGioiTinh = new javax.swing.JComboBox<>();
		btnThemKhachHang = new javax.swing.JButton();
		cbKieuThue = new javax.swing.JComboBox<>();
		jLabel33 = new javax.swing.JLabel();
		txtNgayNhan = new javax.swing.JTextField();
		btnNgayNhan = new giaodien.CustomClass.Button();
		jLabel32 = new javax.swing.JLabel();
		jScrollPane2 = new ScollBar1.ScrollPaneWin11();
		tableDanhSachPhong = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new ScollBar1.ScrollPaneWin11();
		tableDV = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		comboBoxDichVu = new javax.swing.JComboBox<>();
		btnThemDichVu = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		btnHuy = new javax.swing.JButton();
		btnDatPhong = new javax.swing.JButton();

		dateNgaySinh.setForeground(new java.awt.Color(255, 203, 119));
		dateNgaySinh.setTextRefernce(txtNgaySinh);

		dateNgayDat.setForeground(new java.awt.Color(255, 203, 119));
		dateNgayDat.setTextRefernce(txtCheckIn);

		dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));
		dateNgayTra.setTextRefernce(txtCheckOut);

		dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));
		dateNgayNhan.setTextRefernce(txtNgayNhan);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		jLabel1.setText("Đặt phòng");

		jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

		jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel17.setText("Tên khách hàng");

		jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel18.setText("Ngày sinh");

		jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel19.setText("Giới tính");

		jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel20.setText("Quốc tịch");

		jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel21.setText("Địa chỉ");

		jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel22.setText("Số điện thoại");

		jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel23.setText("Hạng thành viên");

		jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel24.setText("Kiểu thuê");

		jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel25.setText("CCCD/VISA");

		jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel26.setText("Tên phòng");

		jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel27.setText("Giá cọc");

		jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel28.setText("Loại phòng");

		jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel30.setText("Ngày trả ");

		jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel31.setText("Ngày đặt");

		btnNgayTra.setBorder(null);
		btnNgayTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
		btnNgayTra.setBorderColor(new java.awt.Color(255, 255, 255));
		btnNgayTra.setColorOver(new java.awt.Color(204, 204, 204));
		btnNgayTra.setRadius(10);
		btnNgayTra.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNgayTraActionPerformed(evt);
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

		btnNgayDat.setBorder(null);
		btnNgayDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
		btnNgayDat.setBorderColor(new java.awt.Color(255, 255, 255));
		btnNgayDat.setColorOver(new java.awt.Color(204, 204, 204));
		btnNgayDat.setRadius(20);
		btnNgayDat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNgayDatActionPerformed(evt);
			}
		});

		txtTenKH.setText("Tên khách hàng");

		txtQuocTich.setText("Quốc Tịch");

		txtHangThanhVien.setText("Hạng thành viên");
		txtHangThanhVien.setEnabled(false);

		txtTenPhong.setText("Tên phòng");

		txtSoDienThoai.setText("Số điện thoại");

		txtCCCD.setText("Căn cước");

		txtLoaiPhong.setText("Loại Phòng");

		txtCheckOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtCheckOutActionPerformed(evt);
			}
		});

		txtDiaChi.setText("Địa chỉ");

		cbBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

		btnThemKhachHang.setText("+");
		btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemKhachHangActionPerformed(evt);
			}
		});

		cbKieuThue
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo ngày", "Theo giờ", "Qua đêm" }));

		jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel33.setText("Ngày nhận");

		txtNgayNhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtNgayNhanActionPerformed(evt);
			}
		});

		btnNgayNhan.setBorder(null);
		btnNgayNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
		btnNgayNhan.setBorderColor(new java.awt.Color(255, 255, 255));
		btnNgayNhan.setColorOver(new java.awt.Color(204, 204, 204));
		btnNgayNhan.setRadius(10);
		btnNgayNhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNgayNhanActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtTenPhong, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(txtHangThanhVien).addComponent(txtQuocTich).addComponent(txtTenKH)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup()
												.addComponent(txtCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, 170,
														Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(42, 42, 42)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(txtSoDienThoai).addComponent(txtLoaiPhong)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
														.createSequentialGroup()
														.addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE,
																170, Short.MAX_VALUE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnNgaySinh,
																javax.swing.GroupLayout.PREFERRED_SIZE, 24,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
														.createSequentialGroup().addComponent(txtCCCD)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnThemKhachHang)))
										.addGap(36, 36, 36)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 83,
														Short.MAX_VALUE)
												.addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(txtDiaChi)
												.addComponent(txtGiaCoc, javax.swing.GroupLayout.DEFAULT_SIZE, 200,
														Short.MAX_VALUE)
												.addComponent(cbBoxGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING,
														0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(cbKieuThue, javax.swing.GroupLayout.Alignment.TRAILING, 0,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25,
												Short.MAX_VALUE)
										.addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(22, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cbBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel20).addComponent(jLabel22).addComponent(jLabel21)
										.addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtHangThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnThemKhachHang))
								.addComponent(cbKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(btnNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(35, Short.MAX_VALUE)));

		jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel32.setText("Danh sách phòng");

		tableDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "STT", "Tên phòng", "Loại phòng", "Kiểu thuê", "Ngày đặt", "Ngày nhận", "Ngày trả" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

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

		}, new String[] { "STT", "Tên dịch vụ", "Số lượng", "Phòng", "Giá" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class,
					java.lang.Object.class, java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tableDV.setRowHeight(40);
		jScrollPane1.setViewportView(tableDV);

		jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

		comboBoxDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		comboBoxDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(loadDanhSachDichVu()));

		btnThemDichVu.setText("Thêm dịch vụ");
		btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemDichVuActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 298,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnThemDichVu)
						.addContainerGap(9, Short.MAX_VALUE)));

		jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel3.setText("Thêm dịch vụ phòng");

		btnHuy.setText("Hủy");
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});

		btnDatPhong.setText("Đặt phòng");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel32))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(45, 45, 45))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE))
										.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 108,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel32)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jLabel3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
		loadDanhSachPhongDat();
		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void txtCheckOutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCheckOutActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtCheckOutActionPerformed

	private void txtNgayNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNgayNhanActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtNgayNhanActionPerformed

	private void btnNgayNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgayNhanActionPerformed
		dateNgayNhan.showPopup();
	}// GEN-LAST:event_btnNgayNhanActionPerformed

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
			Object[] rowData = { model.getRowCount() + 1, phong.getSoPhong(), loaiPhong,
					cbKieuThue.getSelectedItem().toString(), txtCheckIn.getText(), txtNgayNhan.getText(),
					txtCheckOut.getText() };
			model.addRow(rowData);
		}
	}

	private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDatPhongActionPerformed
		String[] dsPhongDat = layDanhSachPhongDat();
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		// Lấy tên trong dsPhongDat, so sánh và lấy thông tin phòng từ CSDL
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}

		// Hiện danh sách phòng vào bảng
		DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
		String loaiPhong = "";
		for (Phong phong : dsPhong) {
			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
			Object[] rowData = { model.getRowCount() + 1, phong.getSoPhong(), loaiPhong,
					cbKieuThue.getSelectedItem().toString(), txtCheckIn.getText(), txtNgayNhan.getText(),
					txtCheckOut.getText() };
			model.addRow(rowData);
		}

		// Khởi tạo thông tin đặt phòng
		ThongTinDatThuePhongDao thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
		KhachHangDao khachHangDao = new KhachHangDao();
		LoaiThueDao loaiThueDao = new LoaiThueDao();
		KhachHang khachHang = khachHangDao.timTheoCCCD(txtCCCD.getText());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngayDat = LocalDate.parse(txtCheckIn.getText(), formatter);
		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), formatter);
		LocalDate ngayTra = LocalDate.parse(txtCheckOut.getText(), formatter);
		String maLoaiThue = loaiThueDao.timMaLoaiThue(cbKieuThue.getSelectedItem().toString(), loaiPhong);
		// Tính tiền cọc
		if (ngayDat.equals(ngayNhan))
			txtGiaCoc.setText("0");
		else if (ngayDat.isBefore(ngayNhan)) {
			double soTienCoc = loaiThueDao.timGiaCocTheoMaThue(maLoaiThue) * dsPhong.size();
			txtGiaCoc.setText(Double.toString(soTienCoc));
		}

		if (thongTinDatThuePhongDao.datPhong(dsPhong, khachHang, ngayDat, ngayNhan, maLoaiThue, ngayTra)) {
			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
			DatPhong.this.hide();
		} else {
			JOptionPane.showMessageDialog(this, "Đặt phòng thất bại");
		}

	}// GEN-LAST:event_btnDatPhongActionPerformed

	private void btnNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgaySinhActionPerformed
		// TODO add your handling code here:
		dateNgaySinh.showPopup();
	}// GEN-LAST:event_btnNgaySinhActionPerformed

	private void btnNgayDatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgayDatActionPerformed
		// TODO add your handling code here:
		dateNgayDat.showPopup();
	}// GEN-LAST:event_btnNgayDatActionPerformed

	private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemDichVuActionPerformed
		// TODO add your handling code here:

		loadDanhSachDichVu();
		double giadichVu = 0;
		String chossedItem = comboBoxDichVu.getSelectedItem().toString();
		// Lấy model hiện tại từ tableDV
		DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
		// Duyệt qua các hàng trong model để kiểm tra nếu dịch vụ đã tồn tại
		for (int i = 0; i < model.getRowCount(); i++) {
			String serviceName = model.getValueAt(i, 1).toString();
			if (chossedItem.equalsIgnoreCase(serviceName)) {
				int currentQuantity = Integer.parseInt(model.getValueAt(i, 2).toString());
				model.setValueAt(currentQuantity + 1, i, 2);
				tableDV.setModel(model);
			}
		}
		String giaDichVuStr = Double.toString(giadichVu);
		Object[] rowData = { model.getRowCount() + 1, chossedItem, 1, txtTenPhong.getText(), giaDichVuStr };
		model.addRow(rowData);

		// Cập nhật lại model
		tableDV.setModel(model);
	}// GEN-LAST:event_btnThemDichVuActionPerformed

	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
		// TODO add your handling code here:
		this.hide();
	}// GEN-LAST:event_btnHuyActionPerformed

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

	private void btnNgayTraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgayTraActionPerformed
		dateNgayTra.showPopup();

	}// GEN-LAST:event_btnNgayTraActionPerformed

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
			java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DatPhong guiDatPhong = new DatPhong();
				guiDatPhong.setVisible(true);
				guiDatPhong.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDatPhong;
	private javax.swing.JButton btnHuy;
	private giaodien.CustomClass.Button btnNgayDat;
	private giaodien.CustomClass.Button btnNgayNhan;
	private giaodien.CustomClass.Button btnNgaySinh;
	private giaodien.CustomClass.Button btnNgayTra;
	private javax.swing.JButton btnThemDichVu;
	private javax.swing.JButton btnThemKhachHang;
	private javax.swing.JComboBox<String> cbBoxGioiTinh;
	private javax.swing.JComboBox<String> cbKieuThue;
	private javax.swing.JComboBox<String> comboBoxDichVu;
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
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableDV;
	private javax.swing.JTable tableDanhSachPhong;
	private javax.swing.JTextField txtCCCD;
	private javax.swing.JTextField txtCheckIn;
	private javax.swing.JTextField txtCheckOut;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtGiaCoc;
	private javax.swing.JTextField txtHangThanhVien;
	private javax.swing.JTextField txtLoaiPhong;
	private javax.swing.JTextField txtNgayNhan;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtQuocTich;
	private javax.swing.JTextField txtSoDienThoai;
	private javax.swing.JTextField txtTenKH;
	private javax.swing.JTextField txtTenPhong;
	// End of variables declaration//GEN-END:variables

	private static String[] loadDanhSachDichVu() {
		DichVuDao dvDao = new DichVuDao();
		ArrayList<DichVu> danhSachDV = dvDao.timTatCaDichVu();
		String[] tenDV = new String[danhSachDV.size()];
		for (int i = 0; i < danhSachDV.size(); i++) {
			tenDV[i] = danhSachDV.get(i).getTenDV();
		}
		return tenDV;
	}
}
