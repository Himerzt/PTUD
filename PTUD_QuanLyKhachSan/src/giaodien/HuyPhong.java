
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
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
		jLabel25 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		txtTenKH = new javax.swing.JTextField();
		txtQuocTich = new javax.swing.JTextField();
		txtNgaySinh = new javax.swing.JTextField();
		txtSoDienThoai = new javax.swing.JTextField();
		txtCCCD = new javax.swing.JTextField();
		txtTienCoc = new javax.swing.JTextField();
		cbBoxGioiTinh = new javax.swing.JComboBox<>();
		jLabel32 = new javax.swing.JLabel();
		jScrollPane2 = new ScollBar1.ScrollPaneWin11();
		tableDanhSachPhong = new javax.swing.JTable();
		btnHuy = new javax.swing.JButton();
		btnHuyDatPhong = new javax.swing.JButton();

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

		jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel25.setText("CCCD/VISA");

		jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel27.setText("Tiền cọc");

		txtTenKH.setText("Tên khách hàng");

		txtQuocTich.setText("Quốc Tịch");

		txtSoDienThoai.setText("Số điện thoại");

		txtCCCD.setText("Căn cước");

		cbBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));


		
		JButton btnCCCD = new JButton("+");
		
		JLabel lblTienTra = new JLabel();
		lblTienTra.setText("Tiền hoàn trả");
		lblTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTienTra.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		txtTienHoanTra = new JTextField();
		txtTienHoanTra.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		jLabel19_1 = new JLabel();
		jLabel19_1.setText("Lý do hủy");
		jLabel19_1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel19_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		cbxLyDo = new JComboBox<String>();
		cbxLyDo.setModel(new DefaultComboBoxModel(new String[] {"Thay đổi kế hoạch", "Thay đổi kế hoạch du lịch", "Tìm được ưu đãi tốt hơn", "Có việc đột xuất"}));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jLabel25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel20, Alignment.TRAILING)
						.addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTenKH, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
								.addComponent(txtQuocTich, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
							.addComponent(txtCCCD, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCCCD)))
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGap(22)
							.addComponent(jLabel22, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(jLabel19_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jLabel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(cbxLyDo, 0, 199, Short.MAX_VALUE)
						.addComponent(txtSoDienThoai, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(txtNgaySinh, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
					.addGap(4)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
							.addComponent(jLabel27, Alignment.TRAILING)
							.addGroup(jPanel2Layout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblTienTra, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
						.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(cbBoxGioiTinh, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTienCoc, 260, 260, 260)
						.addComponent(txtTienHoanTra, 260, 260, 260))
					.addGap(24))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(30)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbBoxGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel20)
						.addComponent(txtQuocTich, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel19_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxLyDo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTienCoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCCCD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCCCD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel22)
						.addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTienTra, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTienHoanTra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(49))
		);
		jPanel2.setLayout(jPanel2Layout);

		jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel32.setText("Danh sách phòng");

		tableDanhSachPhong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "T\u00EAn ph\u00F2ng", "Lo\u1EA1i ph\u00F2ng" }));
		tableDanhSachPhong.setRowHeight(40);
		tableDanhSachPhong.setSelectionBackground(new java.awt.Color(254, 109, 115));
		jScrollPane2.setViewportView(tableDanhSachPhong);
		
		btnHuyDatPhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyDatPhongActionPerformed(evt);
			}
		});

		btnHuy.setText("Hủy");
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});


		btnHuyDatPhong.setText("Hủy đặt phòng");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 937, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnHuy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnHuyDatPhong, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addComponent(jPanel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
						.addComponent(jLabel32)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(btnHuyDatPhong, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		getContentPane().add(jPanel1, BorderLayout.SOUTH);
//		loadDanhSachPhongDat();
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

//	public void loadDanhSachPhongDat() {
//		// Hiện danh sách phòng vào bảng
//		String[] dsPhongDat = layDanhSachPhongDat();
//		PhongDao phongDao = new PhongDao();
//		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
//		for (String tenPhong : dsPhongDat) {
//			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
//		}
//		DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
//		String loaiPhong = "";
//		for (Phong phong : dsPhong) {
//			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
//			Object[] rowData = { model.getRowCount() + 1, phong.getSoPhong(), loaiPhong };
//			model.addRow(rowData);
//		}
//	}
	
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
		
		
		return soTienCoc;
	}

//	NÚT HỦY ĐẶT PHÒNG
	private void btnHuyDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDatPhongActionPerformed
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
				new HuyPhong().setVisible(true);
			}
		});

	}

	
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnHuyDatPhong;
	private javax.swing.JButton btnHuy;
	private javax.swing.JComboBox<String> cbBoxGioiTinh;
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
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableDanhSachPhong;
	private javax.swing.JTextField txtCCCD;
	private javax.swing.JTextField txtTienCoc;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtQuocTich;
	private javax.swing.JTextField txtSoDienThoai;
	private javax.swing.JTextField txtTenKH;
	private JTextField txtTienHoanTra;
	private JLabel jLabel19_1;
	private JComboBox<String> cbxLyDo;
	// End of variables declaration//GEN-END:variables
	
	

	
}
