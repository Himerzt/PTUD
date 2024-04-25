package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

import dao.NhanVien_Dao;
import dao.TaiKhoan_Dao;
import db.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class DSNhanVien_Gui extends JPanel implements ActionListener, MouseListener {

	private JButton btnXoaRong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JLabel lb1;
	private Component comboBox;

	private JComboBox cbbChucVu;
	private JTextField txtSdtNV;
	private JTextField txtTenNV;
	private JTextField txtMaNV;
	private JTextField txtEmail;
	private NhanVien_Dao dsNV = new NhanVien_Dao();
	private DefaultTableModel modelNhanVien;
	private JTable tableNhanVien;

	private TaiKhoan_Dao dsTK = new TaiKhoan_Dao();
	public DSNhanVien_Gui() {
//				JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//				HEADER
		JPanel pnHead = new JPanel();
		JLabel lbHead = new JLabel("Quản Lý Nhân Viên");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		lbHead.setFont(fo24);
		lbHead.setForeground(Color.blue);
		pnHead.add(lbHead);
//		WEST
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.X_AXIS));

		Box containerBox = Box.createVerticalBox();

//				MÃ NHÂN VIÊN
		Box boxMa = Box.createHorizontalBox();
		JLabel lbMaNV = new JLabel("Mã Nhân Viên:");
		lbMaNV.setPreferredSize(new Dimension(100, -10));
		txtMaNV = new JTextField(20);
		txtMaNV.setPreferredSize(new Dimension(0, 10));
		boxMa.add(Box.createHorizontalStrut(15));
		boxMa.add(lbMaNV);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(txtMaNV);
		boxMa.add(Box.createHorizontalStrut(15));

//				TÊN NHÂN VIÊN
		Box boxTen = Box.createHorizontalBox();
		JLabel lbTenNV = new JLabel("Tên NV: ");
		lbTenNV.setPreferredSize(new Dimension(100, -10));
		txtTenNV = new JTextField(20);
		boxTen.setPreferredSize(new Dimension(0, 10));
		boxTen.add(Box.createHorizontalStrut(15));
		boxTen.add(lbTenNV);
		boxTen.add(Box.createHorizontalStrut(10));
		boxTen.add(txtTenNV);
		boxTen.add(Box.createHorizontalStrut(15));

//		 		SĐT NHÂN VIÊN
		Box boxSDT = Box.createHorizontalBox();
		JLabel lbSdtNV = new JLabel("SĐT NV: ");
		lbSdtNV.setPreferredSize(new Dimension(100, -10));
		txtSdtNV = new JTextField(20);
		txtSdtNV.setPreferredSize(new Dimension(0, 10));
		boxSDT.add(Box.createHorizontalStrut(15));
		boxSDT.add(lbSdtNV);
		boxSDT.add(Box.createHorizontalStrut(10));
		boxSDT.add(txtSdtNV);
		boxSDT.add(Box.createHorizontalStrut(15));

//		CHỨC VỤ
		Box boxChucVu = Box.createHorizontalBox();
		JLabel lbChucVu = new JLabel("Chức Vụ: ");
		lbChucVu.setPreferredSize(new Dimension(100, -10));
		String[] chucVu = { "Nhan vien ban hang", "Nhan vien quan ly" };
		cbbChucVu = new JComboBox<>(chucVu);
//		txtChucVu.setPreferredSize(new Dimension(0, 10));
		boxChucVu.add(Box.createHorizontalStrut(15));
		boxChucVu.add(lbChucVu);
		boxChucVu.add(Box.createHorizontalStrut(10));
		boxChucVu.add(cbbChucVu);
		boxChucVu.add(Box.createHorizontalStrut(15));

//				EMAIL
		Box boxEmail = Box.createHorizontalBox();
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setPreferredSize(new Dimension(100, -10));
		txtEmail = new JTextField(20);
		txtEmail.setPreferredSize(new Dimension(0, 10));
		boxEmail.add(Box.createHorizontalStrut(15));
		boxEmail.add(lbEmail);
		boxEmail.add(Box.createHorizontalStrut(10));
		boxEmail.add(txtEmail);
		boxEmail.add(Box.createHorizontalStrut(15));

//				add Box1 Box2
		containerBox.add(boxMa);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxTen);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxChucVu);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxSDT);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxEmail);
		pnWest.setBorder(BorderFactory.createTitledBorder("Nhap thong tin NV"));
		pnWest.add(containerBox);

//		CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.X_AXIS));

		Box boxTableNhanVien = Box.createVerticalBox();
		String[] headerNhanVien = "Mã NV;Tên NV;Sđt NV;Chức vụ;Email".split(";");
		modelNhanVien = new DefaultTableModel(headerNhanVien, 0);
		tableNhanVien = new JTable(modelNhanVien);
		JScrollPane scrollNhanVien = new JScrollPane();
		scrollNhanVien.setViewportView(tableNhanVien);
		scrollNhanVien.setPreferredSize(new Dimension(700, 450)); // SET CHIỀU CAO TABLE
		tableNhanVien.setRowHeight(20);

		boxTableNhanVien.add(scrollNhanVien);
//		boxTableNhanVien.add(Box.createVerticalStrut(20));
		pnCenter.add(Box.createHorizontalStrut(10));
		pnCenter.add(boxTableNhanVien);

//				FOOTER		
		JPanel pnFoot = new JPanel();

		Box boxC1 = Box.createHorizontalBox();
		boxC1.add(btnThem = new JButton("Thêm"));
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(btnXoaRong = new JButton("Xóa Rỗng"));
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(btnXoa = new JButton("Xóa"));
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(btnSua = new JButton("Sửa"));
		boxC1.add(Box.createHorizontalStrut(10));
		pnFoot.add(boxC1);

		pnMain.add(pnWest, BorderLayout.WEST);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnFoot, BorderLayout.SOUTH);

		add(pnMain);

		// Action
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		ConnectDB.connect();

		hienTable();
	}

	private void hienTable() {
		modelNhanVien.setRowCount(0);
		for (NhanVien n : dsNV.docTuBang()) {
			String[] dataRow = { n.getMaNV(), n.getTenNV(), n.getSdtNV(), n.getChucVu(), n.getEmail() };
			modelNhanVien.addRow(dataRow);
		}
	}

	public boolean check() {

		String regexTen = "^[A-ZÀ-Ỹ][a-zà-ỹ]+( [A-ZÀ-Ỹ][a-zà-ỹ]+)*$";
		String regexSDT = "^0[0-9]{9}$";
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if (txtTenNV.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên không được rỗng!");
			txtTenNV.requestFocus();
			return false;
		} else if (!Pattern.matches(regexTen, txtTenNV.getText())) {
			JOptionPane.showMessageDialog(this, "Tên sai quy tắc!");
			txtTenNV.selectAll();
			txtTenNV.requestFocus();
			return false;
		}
		if (txtSdtNV.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "SĐT không được rỗng!");
			txtSdtNV.requestFocus();
			return false;
		} else if (!Pattern.matches(regexSDT, txtSdtNV.getText())) {
			JOptionPane.showMessageDialog(this, "SĐT phải có dạng 0xxxxxxxxx!");
			txtSdtNV.selectAll();
			txtSdtNV.requestFocus();
			return false;
		}
		if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được rỗng!");
			txtEmail.requestFocus();
			return false;
		} else if (!Pattern.matches(regexEmail, txtEmail.getText())) {
			JOptionPane.showMessageDialog(this, "Định dạng Email không đúng!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		return true;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnThem) {
			String ma = txtMaNV.getText();
			String ten = txtTenNV.getText();
			String email = txtEmail.getText();
			String sdt = txtSdtNV.getText();
			String chucVu = cbbChucVu.getSelectedItem().toString();

			NhanVien n = new NhanVien(ma, ten, sdt, chucVu, email);
//			try {
			String regexMa = "^NV[0-9]{3}$";
			if (txtMaNV.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã không được rỗng!");
				txtMaNV.requestFocus();
			} else if (!Pattern.matches(regexMa, txtMaNV.getText())) {
				JOptionPane.showMessageDialog(this, "Mã phải có dạng NVXXX!");
				txtMaNV.selectAll();
				txtMaNV.requestFocus();
			}
			if (check() == true) {
				if (dsNV.createNhanVien(n)) {
							String taiKhoan = n.getMaNV();
							String matKhau = taiKhoan.substring(2, 5);
							TaiKhoan tk = new TaiKhoan(taiKhoan, matKhau, n);
							dsTK.createTaiKhoan(tk);
					String[] row = { n.getMaNV() + "", n.getTenNV() + "", n.getSdtNV() + "", n.getChucVu() + "",
							n.getEmail() + "", };
					modelNhanVien.addRow(row);
					xoaRong();
				} else {
					JOptionPane.showMessageDialog(null, "Không được thêm mã trùng!");
				}
			}
//			} catch (Exception e2) {
//				JOptionPane.showMessageDialog(null, "Nhập liệu lỗi!");
//			}
		} else if (o == btnXoaRong) {
			xoaRong();
		} else if (o == btnXoa) {
			int row = tableNhanVien.getSelectedRow();
			if (row != -1) {
				String maNV = (String) tableNhanVien.getModel().getValueAt(row, 0);
				int hoiNhac = JOptionPane.showConfirmDialog(this,
						"Chắn chắn xóa?\n*Bạn muốn xóa nhân viên này?",
						"Chú ý", JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION)
					if (dsNV.deleteNhanVien(maNV)) {
//						dsTK.deleteTaiKhoan(maNV);
						modelNhanVien.removeRow(row);
						xoaRong();
					}
			}
		} else if (o == btnSua) {
			try {
				int row = tableNhanVien.getSelectedRow();
				String ma = txtMaNV.getText();
				String ten = txtTenNV.getText();
				String email = txtEmail.getText();
				String sdt = txtSdtNV.getText();
				String chucVu = cbbChucVu.getSelectedItem().toString();
				NhanVien n = new NhanVien(ma, ten, sdt, chucVu, email);
				if (check() == true) {
					if (dsNV.updateNhanVien(n)) {
						modelNhanVien.setValueAt(ma, row, 0);
						modelNhanVien.setValueAt(ten, row, 1);
						modelNhanVien.setValueAt(sdt, row, 2);
						modelNhanVien.setValueAt(chucVu, row, 3);
						modelNhanVien.setValueAt(email, row, 4);
						tableNhanVien.clearSelection();
						xoaRong();
					} else {
						JOptionPane.showMessageDialog(null, "Không!");
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
			}
		}
	}

	public void xoaRong() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtSdtNV.setText("");
		txtEmail.setText("");
		txtMaNV.setEnabled(true);
		cbbChucVu.setSelectedIndex(1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setEnabled(false);
		txtMaNV.setText(tableNhanVien.getValueAt(row, 0).toString());
		txtTenNV.setText(tableNhanVien.getValueAt(row, 1).toString());
		txtSdtNV.setText(tableNhanVien.getValueAt(row, 2).toString());
		String selectedChucVu = tableNhanVien.getValueAt(row, 3).toString();
		cbbChucVu.setSelectedItem(selectedChucVu);
		txtEmail.setText(tableNhanVien.getValueAt(row, 4).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}