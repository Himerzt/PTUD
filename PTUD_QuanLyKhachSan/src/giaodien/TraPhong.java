/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package giaodien;

import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.Phong;
import entity.ThongTinDatThuePhong;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.DichVuPhongDao;
import dao.KhachHangDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

/**
 *
 * @author Huynguyen
 */
public class TraPhong extends javax.swing.JDialog {
	private List<DichVuPhong> danhSachDichVu;
	private String[] dsPhongDat;
	List<String> dsTenPhong;

	/**
	 * Creates new form DatPhong
	 */
	public TraPhong() {
		initComponents();
	}

	public TraPhong(List<String> dsTenPhong) {
		dsPhongDat = new String[dsTenPhong.size()];
		int index = 0;
		for (String tenPhong : dsTenPhong) {
			dsPhongDat[index++] = tenPhong;
		}
		ConnectDB.getInstance().getConnection();
		initComponents();
		loadDanhSachDichVu();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
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
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtHangThanhVienKH = new javax.swing.JTextField();
        txtHangThanhVienKH.setEnabled(false);
        txtSodienthoaiKH = new javax.swing.JTextField();
        txtCheckIn = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtChietKhau = new javax.swing.JTextField();
        txtChietKhau.setEnabled(false);
        txtThue = new javax.swing.JTextField();
        txtThue.setEnabled(false);
        txtCheckOut = new javax.swing.JTextField();
        txtTraTruoc = new javax.swing.JTextField();
        txtTraTruoc.setEditable(false);
        txtTongHoaDon = new javax.swing.JTextField();
        txtTongHoaDon.setEditable(false);
        txtTienCanThu = new javax.swing.JTextField();
        txtTienCanThu.setEditable(false);
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new giaodien.CustomClass.ScrollPaneWin11();
        tableDanhSachPhong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new giaodien.CustomClass.ScrollPaneWin11();
        tableDV = new javax.swing.JTable();
        btnHuy = new javax.swing.JButton();
        btnTraPhong = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		jLabel1.setText("Trả phòng");

		jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("CCCD");
        
		jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel18.setText("Ngày sinh");

		jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel19.setText("Tổng tiền");

		jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel20.setText("Hạng thành viên");

		jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel21.setText("Đã trả trước");

		jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel22.setText("Chiết khấu");

		jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel23.setText("Số điện thoại");

		jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel24.setText("Tiền cần thu");

		jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel25.setText("Thuế VAT");

		jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel30.setText("Ngày trả ");

		jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel31.setText("Ngày đặt");

        txtCCCD.setText("CCCD");

		txtHangThanhVienKH.setText("Hạng thành viên");

		txtSodienthoaiKH.setText("Số điện thoại");

		txtCheckIn.setText("Ngày đặt phòng");

		txtNgaySinh.setText("Ngày sinh");

		txtThue.setText("10%");

		txtCheckOut.setText("Ngày trả phòng");

		txtTraTruoc.setText("Giá trị hóa đơn đã trả trước");

		txtTongHoaDon.setText("Tổng giá trị hóa đơn");

        txtTienCanThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienCanThu.setText("Tống số tiền cần thu thêm");
        
        JButton btnCCCD = new JButton("+");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(17)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(17))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel30, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        					.addGap(18)))
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(txtCheckOut)
        				.addComponent(txtSodienthoaiKH, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        				.addComponent(txtHangThanhVienKH, Alignment.LEADING)
        				.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        					.addComponent(txtCCCD)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnCCCD)))
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(42)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel31, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(txtCheckIn)
        				.addComponent(txtChietKhau, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        				.addComponent(txtNgaySinh)
        				.addComponent(txtThue))
        			.addGap(36)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel24, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtTienCanThu, 200, 200, 200)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(txtTraTruoc, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        					.addComponent(txtTongHoaDon)))
        			.addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(17)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtCCCD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtTongHoaDon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(btnCCCD))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(40)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel20)
        						.addComponent(jLabel22)
        						.addComponent(jLabel21)
        						.addComponent(txtHangThanhVienKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtChietKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtTraTruoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtSodienthoaiKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtThue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel31, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtCheckIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtCheckOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(txtTienCanThu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

		jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel32.setText("Danh sách phòng");

		tableDanhSachPhong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "T\u00EAn ph\u00F2ng", "Lo\u1EA1i ph\u00F2ng" }));
		tableDanhSachPhong.setRowHeight(40);
		tableDanhSachPhong.setSelectionBackground(new java.awt.Color(254, 109, 115));
		jScrollPane2.setViewportView(tableDanhSachPhong);
		if (tableDanhSachPhong.getColumnModel().getColumnCount() > 0) {
			tableDanhSachPhong.getColumnModel().getColumn(0).setMaxWidth(60);
		}

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel2.setText("Danh sách dịch vụ");

		tableDV.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Phòng", "Giá" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.Object.class, java.lang.String.class,
					java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tableDV.setRowHeight(40);
		jScrollPane1.setViewportView(tableDV);
		if (tableDV.getColumnModel().getColumnCount() > 0) {
			tableDV.getColumnModel().getColumn(0).setMaxWidth(60);
		}

		btnHuy.setText("Hủy");
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});


        btnTraPhong.setText("Trả phòng");
        btnTraPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhongActionPerformed(evt);
            }
        });
        
		btnCCCD.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCCCDActionPerformed(evt);
			}
		});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel32)
        							.addGap(242))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        							.addGap(18)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btnTraPhong, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel2)
        							.addPreferredGap(ComponentPlacement.RELATED, 536, Short.MAX_VALUE)))))
        			.addGap(17))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
        			.addGap(76)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel32)
        						.addComponent(jLabel2))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
        						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(btnTraPhong, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
        			.addGap(37))
        );
        jPanel1.setLayout(jPanel1Layout);

		getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	protected void btnCCCDActionPerformed(ActionEvent evt) {
		String cccd = txtCCCD.getText();
		KhachHangDao khDao = new KhachHangDao();
		KhachHang kh = khDao.timTheoCCCD(cccd);
		if (kh != null) {
			txtCCCD.setText(kh.getHoTenKH());
			txtNgaySinh.setText(kh.getNgaySinh().toString());
			txtSodienthoaiKH.setText(kh.getSoDT());
			String hangTV = "";
			double chietKhau = 0;
			if (kh.getMaHangThanhVien().equalsIgnoreCase("hb")) {
				hangTV = "Hạng Bạc";
				chietKhau = 0.0375;
			} else if (kh.getMaHangThanhVien().equalsIgnoreCase("hv")) {
				hangTV = "Hạng Vàng";
				chietKhau = 0.075;
			} else if (kh.getMaHangThanhVien().equalsIgnoreCase("kc")) {
				hangTV = "Hạng Kim Cương";
				chietKhau = 0.1875;
			} else if (kh.getMaHangThanhVien().equalsIgnoreCase("lb")) {
				hangTV = "Hạng Lục Bảo";
				chietKhau = 0.15;
			} else {
				hangTV = "Hạng Bạch Kim";
                chietKhau = 0.1125;				
			}
			txtHangThanhVienKH.setText(hangTV);
			txtChietKhau.setText(String.valueOf(chietKhau));
		}
		ThongTinDatThuePhongDao thongTinDao = new ThongTinDatThuePhongDao();
		ArrayList<ThongTinDatThuePhong> dsThongTin = thongTinDao.timThongTinDatThuePhongTheoMaKhachHang(kh.getMaKH());
		ArrayList<String> dsPhong = new ArrayList<>();
		dsPhong = thongTinDao.layDanhSachPhongTheoMaKhachHang(kh.getMaKH());
		ArrayList<Phong> dsPhongCD = new ArrayList<>();
		PhongDao phongDao = new PhongDao();;
		dsPhongCD = phongDao.chuyenDoi(dsPhong);
		for (ThongTinDatThuePhong thongTin : dsThongTin) {
			dsPhong.add(thongTin.getMaPhong());
		}
		// Lấy ngày đặt phòng và ngày trả phòng

		txtCheckIn.setText(dsThongTin.get(1).getNgayDatPhong().toString());
		txtCheckOut.setText(dsThongTin.get(1).getNgayTraPhong().toString());
		
		// Hiển thị danh sách phòng vào table tableDanhSachPhong
		String loaiPhong = "";
		DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
		model.setRowCount(0);
		int i = 0;
		for (Phong phong : dsPhongCD) {
            if (phong.getMaLoaiPhong().equalsIgnoreCase("tc")) {
                loaiPhong = "Tiêu chuẩn";
            } else if (phong.getMaLoaiPhong().equalsIgnoreCase("nc")) {
                loaiPhong = "Nâng cao";
            } else if (phong.getMaLoaiPhong().equalsIgnoreCase("cc")) {
                loaiPhong = "Cao cấp";
            } else {
                loaiPhong = "Thương gia";
            }
            model.addRow(new Object[] {i+1, phong.getSoPhong(), loaiPhong });
            i++;
		}
		
		// Hiển thị danh sách dịch vụ vào table tableDV
		DefaultTableModel modelDV = (DefaultTableModel) tableDV.getModel();
		modelDV.setRowCount(0);
		DichVuPhongDao dvDao = new DichVuPhongDao();
		danhSachDichVu = dvDao.timDichVuPhongTheoMaPhong(dsPhong);
		int j = 0;
		for (DichVuPhong dv : danhSachDichVu) {
			System.out.println(dv.getMaDichVu());
			String maDV = dv.getMaDichVu();
			String tenDV = dvDao.timTheoMaDichVu(maDV).getTenDV();
			int soLuong = dv.getSoLuong();
			String maPhong = dv.getMaPhong();
			double gia = dvDao.tinhTienTheoMaDichVu(maDV);
			modelDV.addRow(new Object[] { j + 1, maDV, tenDV, soLuong, maPhong, gia });
			j++;
		}
		
		// Tính tiền phòng
		double tongTienPhong = thongTinDao.tinhTienTheoDanhSachPhong(dsPhongCD);
		txtTraTruoc.setText(String.valueOf(dsThongTin.get(1).getTienDaCoc()));
		txtTongHoaDon.setText(String.valueOf(tongTienPhong));
		txtTienCanThu.setText(String.valueOf(tongTienPhong - Double.parseDouble(txtTraTruoc.getText())));
	}

	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
		// TODO add your handling code here:
		this.setVisible(false);//update
	}// GEN-LAST:event_btnHuyActionPerformed

	private void btnTraPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDatPhongActionPerformed
		// TODO add your handling code here:
//         Tạo một đối tượng mới của HoaDonThanhToan
		HoaDonThanhToan hoaDonThanhToan = new HoaDonThanhToan();

		// Đặt phương thức để đóng cửa sổ khi người dùng đóng cửa sổ mới
		hoaDonThanhToan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Hiển thị cửa sổ mới
		hoaDonThanhToan.setVisible(true);
	}// GEN-LAST:event_btnDatPhongActionPerformed

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
			java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TraPhong().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnTraPhong;
	private javax.swing.JButton btnHuy;
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
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableDV;
	private javax.swing.JTable tableDanhSachPhong;
	private javax.swing.JTextField txtCCCD;
	private javax.swing.JTextField txtCheckIn;
	private javax.swing.JTextField txtCheckOut;
	private javax.swing.JTextField txtChietKhau;
	private javax.swing.JTextField txtHangThanhVienKH;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtSodienthoaiKH;
	private javax.swing.JTextField txtThue;
	private javax.swing.JTextField txtTienCanThu;
	private javax.swing.JTextField txtTongHoaDon;
	private javax.swing.JTextField txtTraTruoc;
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
