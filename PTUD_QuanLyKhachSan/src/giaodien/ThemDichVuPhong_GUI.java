/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package giaodien;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.DichVuPhongDao;
import dao.KhachHangDao;
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
public class ThemDichVuPhong_GUI extends javax.swing.JDialog {

	private DichVu dichvu;
	private DichVuPhongDao dichVuPhongDao;
	private String soPhongHienTai;
	private Phong phong;
	private PhongDao phongDao;
	private KhachHang khachHang;
	private KhachHangDao khachHangDao;
	private ThongTinDatThuePhong thongTinDatThuePhong;
	private ThongTinDatThuePhongDao thongTinDatThuePhongDao;

	/**
     * Creates new form ThemDichVuPhongDialog
<<<<<<< HEAD:PTUD_QuanLyKhachSan/src/giaodien/ThemDichVuPhongDialog_GUI.java
     */




    public ThemDichVuPhong_GUI(String soPhongHienTai) {
        this.soPhongHienTai = soPhongHienTai;
        ConnectDB.getInstance().getConnection();
        initComponents();
    }
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		txtTenPhongHienTai = new giaodien.CustomClass.TextFieldShadow();
		txtSoDienThoaiKhachHang = new giaodien.CustomClass.TextFieldShadow();
		txtMaKhachHang = new giaodien.CustomClass.TextFieldShadow();
		txtTenKhachHang = new giaodien.CustomClass.TextFieldShadow();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new giaodien.CustomClass.ScrollPaneWin11();
		tableDV = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		comboBoxDichVu = new javax.swing.JComboBox<>();
		btnThemDichVu = new javax.swing.JButton();
		btnThemDichVu1 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		txtSoLuong = new giaodien.CustomClass.TextFieldShadow();
		jLabel3 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		jLabel1.setText("Thêm dịch vụ phòng");

		jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

		jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel17.setText("Mã phòng hiện tại");

		jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel18.setText("Mã khách hàng");

		jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel19.setText("Tên khách hàng");

		jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel21.setText("Số điện thoại");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel17).addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE,
										118, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtTenPhongHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, 205,
										Short.MAX_VALUE)
								.addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(21, 21, 21)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jLabel18)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel19)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenPhongHienTai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel21)
								.addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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
   // thêm dịch vụ vào comboBox
		
		// load dữ liệu vào bảng

		loadLenBang();

		tableDV.setRowHeight(40);
		jScrollPane1.setViewportView(tableDV);

		jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

		comboBoxDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		// load tenDV vao comboBox
		comboBoxDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(loadDanhSachDichVu()));
//        comboBoxDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Quầy bar","Ăn Sáng" , "Ăn Tối", "Giặt ủi", "Thuê Xe Moto Tự Lái", "Đưa đón sân bay", "Thuê xe ô tô tự lái" , "Spa", "Phòng tập thể dục"}));

		btnThemDichVu.setText("Thêm dịch vụ");
		btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemDichVuActionPerformed(evt);
			}
		});

		btnThemDichVu1.setText("Xóa dịch vụ");
		btnThemDichVu1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemDichVu1ActionPerformed(evt);
			}
		});

		jLabel4.setText("Nhập số lượng");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnThemDichVu1))
						.addComponent(comboBoxDichVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThemDichVu).addComponent(btnThemDichVu1))
						.addContainerGap()));
//
		jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel3.setText("Thêm dịch vụ phòng");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
																179, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(31, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(24, 24, 24)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jLabel3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(15, 15, 15)));
		setALL();
//=======
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThemDichVuPhongDialog_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThemDichVuPhongDialog_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThemDichVuPhongDialog_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThemDichVuPhongDialog_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ThemDichVuPhongDialog_GUI dialog = new ThemDichVuPhongDialog_GUI(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });

//>>>>>>> b01a81a34a4f8c5b67c852476876f4be707bd397:PTUD_QuanLyKhachSan/src/giaodien/ThemDichVuPhongDialog_GUI.java

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(9, 9, 9)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jPanel1,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
		setALL();
	}// </editor-fold>//GEN-END:initComponents

	private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemDichVuActionPerformed
		// TODO add your handling code here:
		try {

			dichVuPhongDao1 = new DichVuPhongDao();
			if (txtSoLuong.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng dịch vụ");
				return;
			}

			String maDV = null;

			String tenDV = (String) comboBoxDichVu.getSelectedItem();
			maDV = tenDV.substring(0, 5);
			int soluong = txtSoLuong.getText().isEmpty() ? 0 : Integer.parseInt(txtSoLuong.getText());

			String phong = txtTenPhongHienTai.getText();

			DichVuDao dichvuDao = new DichVuDao();
			double gia = dichvuDao.timDichVuTheoMaDV(maDV).getGiaDV();

			double giaTong = gia * soluong;

			DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
			model.addRow(new Object[] { model.getRowCount() + 1, tenDV, soluong, phong, giaTong });

			String maPhong = txtTenPhongHienTai.getText();

			DichVuPhong dvp = new DichVuPhong(maPhong, maDV, soluong);

			dichVuPhongDao1.themDichVuPhong(dvp);

			JOptionPane.showMessageDialog(null, "Thêm dịch vụ thành công");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Thêm dịch vụ thất bại");
		}
	}// GEN-LAST:event_btnThemDichVuActionPerformed

	private void btnThemDichVu1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemDichVu1ActionPerformed
		// TODO add your handling code here

		// xóa dịch vụ từ bảng khi chọn vào bảng
		DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
		int selectedRow = tableDV.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ cần xóa");
			return;
		}
		String maDV = (String) model.getValueAt(selectedRow, 1);
		String maPhong = (String) model.getValueAt(selectedRow, 3);
		int soLuong = (int) model.getValueAt(selectedRow, 2);
		DichVuDao dichvuDao = new DichVuDao();
		double gia = dichvuDao.timDichVuTheoMaDV(maDV).getGiaDV();
		double giaTong = gia * soLuong;
		model.removeRow(selectedRow);
		dichVuPhongDao1 = new DichVuPhongDao();
		dichVuPhongDao1.xoaDichVuPhongTheoMaPhongVaMaDichVu(maPhong, maDV);

	}// GEN-LAST:event_btnThemDichVu1ActionPerformed

	/**
	 * @param args the command line arguments
	 */

	// xóa dịch vụ
	private void btnXoaDichVu1ActionPerformed(java.awt.event.ActionEvent evt) {
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
			java.util.logging.Logger.getLogger(ThemDichVuVaoPhong_GUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ThemDichVuVaoPhong_GUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ThemDichVuVaoPhong_GUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ThemDichVuVaoPhong_GUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ThemDichVuVaoPhong_GUI dialog = new ThemDichVuVaoPhong_GUI(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});

	}

	private String[] loadDanhSachDichVu() {
		DichVuDao dichVuDao = new DichVuDao();
		ArrayList<DichVu> danhSachDV = dichVuDao.timTatCaDichVu();
		String[] tenDV = new String[danhSachDV.size()];
		for (int i = 0; i < danhSachDV.size(); i++) {
			tenDV[i] = String.format("%s %s", danhSachDV.get(i).getMaDV(), danhSachDV.get(i).getTenDV());
		}
		return tenDV;
	}

	private void loadLenBang() {
		DichVuPhongDao dichVuDao = new DichVuPhongDao();
		DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
		phong = new Phong();
		phongDao = new PhongDao();
		phong = phongDao.timPhongTheoSoPhong(Integer.parseInt(soPhongHienTai));

		ArrayList<DichVuPhong> danhSachDV = dichVuDao.timTatCaDichVuPhongTheoMaPhong(phong.getMaPhong());
		DichVu dichVu = new DichVu();
		DichVuDao dichVuDao1 = new DichVuDao();
		for (DichVuPhong dv : danhSachDV) {
			double gia = dichVuDao1.timDichVuTheoMaDV(dv.getMaDichVu()).getGiaDV();
			String ten = dichVuDao1.timDichVuTheoMaDV(dv.getMaDichVu()).getTenDV();
			double giatong = gia * dv.getSoLuong();

			model.addRow(new Object[] { model.getRowCount() + 1, ten, dv.getSoLuong(), dv.getMaPhong(), giatong });

		}
	}

	public void setALL() {
		txtTenPhongHienTai.setText(soPhongHienTai);
		phong = new Phong();
		phongDao = new PhongDao();
		khachHang = new KhachHang();
		khachHangDao = new KhachHangDao();
		thongTinDatThuePhong = new ThongTinDatThuePhong();
		thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();

		int number = Integer.parseInt(soPhongHienTai);
		phong = phongDao.timPhongTheoSoPhong(number);
		thongTinDatThuePhong = thongTinDatThuePhongDao.timThongTinDatThuePhongTheoMaPhong1(phong.getMaPhong());
		khachHang = khachHangDao.timKhachHangTheoMa(thongTinDatThuePhong.getMaKhachHang());

		txtTenKhachHang.setText(khachHang.getHoTenKH());
		txtMaKhachHang.setText(khachHang.getMaKH());
		txtSoDienThoaiKhachHang.setText(khachHang.getSoDT());
		txtTenPhongHienTai.setText(phong.getMaPhong());
		

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnThemDichVu;
	private javax.swing.JButton btnThemDichVu1;
	private javax.swing.JComboBox<String> comboBoxDichVu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tableDV;
	private giaodien.CustomClass.TextFieldShadow txtMaKhachHang;
	private giaodien.CustomClass.TextFieldShadow txtSoDienThoaiKhachHang;
	private giaodien.CustomClass.TextFieldShadow txtSoLuong;
	private giaodien.CustomClass.TextFieldShadow txtTenKhachHang;
	private giaodien.CustomClass.TextFieldShadow txtTenPhongHienTai;
	private String tenDV = null;
	private DichVuPhongDao dichVuPhongDao1;
	// End of variables declaration//GEN-END:variables
}
