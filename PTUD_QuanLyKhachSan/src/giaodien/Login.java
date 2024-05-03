
package giaodien;

import java.awt.Color;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import dao.TaiKhoanDao;
import entity.TaiKhoan;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends javax.swing.JFrame implements Serializable {

	public Login() throws SQLException {
		initComponents();
		ConnectDB.getInstance().getConnection();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		Right = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		Left = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		btnDangNhap = new giaodien.CustomClass.Button();
		btnDoiMatKhau = new giaodien.CustomClass.Button();
		txtMatKhau = new giaodien.CustomClass.PasswordField();
		txtTenDangNhap = new giaodien.CustomClass.TextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("LOGIN");
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
		jPanel1.setLayout(null);

		Right.setBackground(new java.awt.Color(106, 247, 154));
		Right.setMinimumSize(new java.awt.Dimension(400, 500));
		Right.setPreferredSize(new java.awt.Dimension(400, 500));

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/tien-sanh-khach-san.jpg"))); // NOI18N
		jLabel5.setMaximumSize(new java.awt.Dimension(800, 500));
		jLabel5.setMinimumSize(new java.awt.Dimension(800, 500));
		jLabel5.setPreferredSize(new java.awt.Dimension(800, 500));

		javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
		Right.setLayout(RightLayout);
		RightLayout.setHorizontalGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						RightLayout.createSequentialGroup().addGap(0, 0, 0)
								.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
								.addContainerGap()));
		RightLayout.setVerticalGroup(
				RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jPanel1.add(Right);
		Right.setBounds(0, 0, 400, 500);

		Left.setBackground(new java.awt.Color(255, 255, 255));
		Left.setPreferredSize(new java.awt.Dimension(400, 500));

		jLabel1.setBackground(new java.awt.Color(23, 195, 178));
		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(23, 195, 178));
		jLabel1.setText("ĐĂNG NHẬP");

		jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
		jLabel6.setText("StaRail Hotel  Management");

		btnDangNhap.setBackground(new java.awt.Color(23, 195, 178));
		btnDangNhap.setBorder(null);
		btnDangNhap.setText("ĐĂNG NHẬP");
		btnDangNhap.setBorderColor(new java.awt.Color(23, 195, 178));
		btnDangNhap.setColorOver(new java.awt.Color(0, 255, 204));
		btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		btnDangNhap.setRadius(20);
		btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnDangNhapMouseExited(evt);
			}
		});
		btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDangNhapActionPerformed(evt);
			}
		});

		btnDoiMatKhau.setBackground(new java.awt.Color(254, 109, 115));
		btnDoiMatKhau.setBorder(null);
		btnDoiMatKhau.setText("ĐỔI MẬT KHẨU");
		btnDoiMatKhau.setBorderColor(new java.awt.Color(254, 109, 115));
		btnDoiMatKhau.setColorOver(new java.awt.Color(255, 102, 102));
		btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		btnDoiMatKhau.setRadius(20);
		btnDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnDoiMatKhauMouseExited(evt);
			}
		});
		btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDoiMatKhauActionPerformed(evt);
			}
		});

		txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
		txtMatKhau.setLabelText("Mật khẩu");
		txtMatKhau.setLineColor(new java.awt.Color(23, 195, 178));

		txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
		txtTenDangNhap.setLabelText("Tên đăng nhập");
		txtTenDangNhap.setLineColor(new java.awt.Color(23, 195, 178));

		javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
		Left.setLayout(LeftLayout);
		LeftLayout.setHorizontalGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						LeftLayout.createSequentialGroup().addGap(0, 29, Short.MAX_VALUE).addComponent(jLabel6)
								.addGap(25, 25, 25))
				.addGroup(LeftLayout.createSequentialGroup().addGroup(LeftLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(LeftLayout.createSequentialGroup().addGap(119, 119, 119).addComponent(jLabel1))
						.addGroup(LeftLayout.createSequentialGroup().addGap(76, 76, 76).addGroup(
								LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDoiMatKhau, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		LeftLayout.setVerticalGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(LeftLayout.createSequentialGroup().addContainerGap(33, Short.MAX_VALUE).addComponent(jLabel6)
						.addGap(37, 37, 37).addComponent(jLabel1).addGap(35, 35, 35)
						.addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(37, 37, 37)
						.addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)
						.addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28).addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(53, 53, 53)));

		jPanel1.add(Left);
		Left.setBounds(400, 0, 400, 500);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		jPanel1.getAccessibleContext().setAccessibleName("");

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void btnDangNhapMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnDangNhapMouseExited
		btnDangNhap.setBackground(new Color(23, 195, 178));
	}// GEN-LAST:event_btnDangNhapMouseExited

	private void btnDoiMatKhauMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnDoiMatKhauMouseExited
		btnDoiMatKhau.setBackground(new Color(254, 109, 115));
	}// GEN-LAST:event_btnDoiMatKhauMouseExited

	private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDoiMatKhauActionPerformed
		// TODO add your handling code here:
		try {
			ChangePassword changePasswordFrame = new ChangePassword();
			changePasswordFrame.setVisible(true);
			changePasswordFrame.pack();
			changePasswordFrame.setLocationRelativeTo(null);
			this.dispose();
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}// GEN-LAST:event_btnDoiMatKhauActionPerformed

	private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDangNhapActionPerformed

		try {
			// Lấy thông tin từ các trường nhập liệu
			String tenDangNhap = txtTenDangNhap.getText();
			String matKhau = new String(txtMatKhau.getPassword());

			// Kiểm tra xác thực đăng nhập
			if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
				// Hiển thị thông báo nếu các trường đăng nhập trống
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập và mật khẩu.");
			} else {
				// Tạo đối tượng TaiKhoanDao để xác thực đăng nhập
				TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
				boolean dangNhapThanhCong = taiKhoanDao.xacThucDangNhap(tenDangNhap, matKhau);

				if (dangNhapThanhCong) {
					// Đăng nhập thành công

					// Thực hiện các hành động sau khi đăng nhập thành công, ví dụ chuyển sang màn
					// hình mới
					// Ở đây tôi sẽ chỉ đóng cửa sổ đăng nhập, bạn có thể thay đổi theo nhu cầu của
					// mình
					dispose(); // Đóng cửa sổ hiện tại

					// Mở màn hình mới hoặc thực hiện các hành động khác ở đây
					TrangChu_Updated trangChu_Updated = new TrangChu_Updated();
					trangChu_Updated.setVisible(true); // Hiển thị cửa sổ mới
				} else {
					// Đăng nhập thất bại
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu.");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}// GEN-LAST:event_btnDangNhapActionPerformed

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel Left;
	private javax.swing.JPanel Right;
	private giaodien.CustomClass.Button btnDangNhap;
	private giaodien.CustomClass.Button btnDoiMatKhau;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private giaodien.CustomClass.PasswordField txtMatKhau;
	private giaodien.CustomClass.TextField txtTenDangNhap;
	// End of variables declaration//GEN-END:variables

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			try {
				new Login().setVisible(true);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
	}
}
