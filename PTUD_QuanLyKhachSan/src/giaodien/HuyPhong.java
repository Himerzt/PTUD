
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;

/**
 *
 * @author Huynguyen
 */
public class HuyPhong extends javax.swing.JDialog {

	private List<DichVuPhong> danhSachDichVu;
	private String[] dsPhongDat;
	List<String> dsTenPhong;

	/**
	 * Creates new form DatPhong
	 */
	public HuyPhong() {
		ConnectDB.getInstance().getConnection();
		initComponents();
	}

	public HuyPhong(List<String> dsTenPhong) {
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
		jLabel22 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		txtTenKH = new javax.swing.JTextField();
		txtQuocTich = new javax.swing.JTextField();
		txtNgaySinh = new javax.swing.JTextField();
		txtSoDienThoai = new javax.swing.JTextField();
		txtCCCD = new javax.swing.JTextField();
		txtGiaCoc = new javax.swing.JTextField();
		cbBoxGioiTinh = new javax.swing.JComboBox<>();
		cbKieuThue = new javax.swing.JComboBox<>();
		jLabel32 = new javax.swing.JLabel();
		jScrollPane2 = new ScollBar1.ScrollPaneWin11();
		tableDanhSachPhong = new javax.swing.JTable();
		btnHuy = new javax.swing.JButton();
		btnDatPhong = new javax.swing.JButton();

		dateNgaySinh.setForeground(new java.awt.Color(255, 203, 119));
		dateNgaySinh.setTextRefernce(txtNgaySinh);

		dateNgayDat.setForeground(new java.awt.Color(255, 203, 119));

		dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));

		dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		jLabel1.setText("Hủy đặt phòng");

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

		jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel22.setText("Số điện thoại");

		jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel24.setText("Kiểu thuê");

		jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel25.setText("CCCD/VISA");

		jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel27.setText("Giá cọc");

		txtTenKH.setText("Tên khách hàng");

		txtQuocTich.setText("Quốc Tịch");

		txtSoDienThoai.setText("Số điện thoại");

		txtCCCD.setText("Căn cước");

		cbBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

		cbKieuThue
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo ngày", "Theo giờ", "Qua đêm" }));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(jLabel25, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(jLabel20))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtTenKH, 200, 200, 200)
						.addComponent(txtCCCD, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
						.addComponent(txtQuocTich, 200, 200, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(jLabel22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jLabel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(jLabel24, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cbKieuThue, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtSoDienThoai, Alignment.TRAILING)
						.addComponent(txtNgaySinh, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addGap(19)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jLabel27, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGap(11)
							.addComponent(jLabel19)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(txtGiaCoc, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(cbBoxGioiTinh, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addGap(20))))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(17)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtQuocTich, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel20))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGap(3)
							.addComponent(cbBoxGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel22)
								.addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaCoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCCCD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbKieuThue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		jPanel2.setLayout(jPanel2Layout);

		jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel32.setText("Danh sách phòng");

		tableDanhSachPhong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "T\u00EAn ph\u00F2ng", "Lo\u1EA1i ph\u00F2ng" }));
		tableDanhSachPhong.setRowHeight(40);
		tableDanhSachPhong.setSelectionBackground(new java.awt.Color(254, 109, 115));
		jScrollPane2.setViewportView(tableDanhSachPhong);
		
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
		
		// Tính giá cọc mỗi khi chọn kiểu thuê
		cbKieuThue.addActionListener(e -> setGiaCoc());


		btnDatPhong.setText("Đặt phòng");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 884, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
							.addComponent(btnDatPhong)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addComponent(jLabel32))
					.addContainerGap())
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(jLabel32)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(265)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDatPhong, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		getContentPane().add(jPanel1, BorderLayout.SOUTH);
		loadDanhSachPhongDat();
		pack();
	}// </editor-fold>//GEN-END:initComponents

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
		String loaiPhong = "";
		String maLoaiThue = "";
		double soTienCoc = 0;
		
		// Tính tiền cọc
//		for (Phong phong : dsPhong) {
//			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
//			maLoaiThue = loaiThueDao.timMaLoaiThue(cbKieuThue.getSelectedItem().toString(), loaiPhong);
//			if (ngayDat.equals(ngayNhan)) {
//				return soTienCoc = 0;
//				
//			}
//			else if (ngayDat.isBefore(ngayNhan)) {
//				soTienCoc += loaiThueDao.timGiaCocTheoMaThue(maLoaiThue);
//			}
//		}
		return soTienCoc;
	}

	private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDatPhongActionPerformed
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
		LoaiThueDao loaiThueDao = new LoaiThueDao();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		LocalDate ngayDat = LocalDate.parse(txtCheckIn.getText(), formatter);
//		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), formatter);
//		LocalDate ngayTra = LocalDate.parse(txtCheckOut.getText(), formatter);
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
//			HuyPhong.this.dispose();
//		} else {
//			JOptionPane.showMessageDialog(this, "Đặt phòng thất bại");
//		}

	}// GEN-LAST:event_btnDatPhongActionPerformed

	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
		// TODO add your handling code here:
		this.hide();
	}// GEN-LAST:event_btnHuyActionPerformed

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
			java.util.logging.Logger.getLogger(HuyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(HuyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(HuyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(HuyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
//				List<String> args = new ArrayList<String>();
//				args.add("101");
//				args.add("102");
//				args.add("103");
//				DatPhong guiDatPhong = new DatPhong(args);
//				guiDatPhong.setVisible(true);
//				guiDatPhong.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDatPhong;
	private javax.swing.JButton btnHuy;
	private javax.swing.JComboBox<String> cbBoxGioiTinh;
	private javax.swing.JComboBox<String> cbKieuThue;
	private chooserDay.DateChooser dateNgayDat;
	private chooserDay.DateChooser dateNgayNhan;
	private chooserDay.DateChooser dateNgaySinh;
	private chooserDay.DateChooser dateNgayTra;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableDanhSachPhong;
	private javax.swing.JTextField txtCCCD;
	private javax.swing.JTextField txtGiaCoc;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtQuocTich;
	private javax.swing.JTextField txtSoDienThoai;
	private javax.swing.JTextField txtTenKH;
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
