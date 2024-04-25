package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_Dao;
import db.ConnectDB;
import entity.KhachHang;

public class DSKhachHang_Gui extends JPanel implements ActionListener {
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JTextField txtSDT;
	private JTextField txtTen;
	private JTable table;
	private JButton btnXoa;
	private JTextField txtMaKH;
	private JButton btnSua;
	private JTextField txtTimKiem;
	private JButton btnTim;
	private JButton btnLamMoi;
	
	public DSKhachHang_Gui() {
		setSize(1070, 600);
		setVisible(true);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Quản lý khách hàng");
		pnHead.add(lblHead);
		pnMain.add(pnHead);
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(java.awt.Color.BLUE);
		// CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		// Box
		Box b0 = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		// Mã khách hàng
		JLabel lblMaKH = new JLabel("Mã khách hàng: ");
		lblMaKH.setPreferredSize(new Dimension(120, 25));
		txtMaKH = new JTextField(20);
		
		b0.add(Box.createHorizontalStrut(10));
		b0.add(lblMaKH);
		b0.add(txtMaKH);
		pnCenterTop.add(b0);
		pnCenterTop.add(Box.createVerticalStrut(5));
		// Số điện thoại khách hàng
		JLabel lblSDT = new JLabel("Số điện thoại: ");
		lblSDT.setPreferredSize(new Dimension(120, 25));
		txtSDT = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblSDT);
		b1.add(txtSDT);

		// Tên khách hàng
		JLabel lblTen = new JLabel("Tên khách hàng: ");
		lblTen.setPreferredSize(new Dimension(120, 20));
		txtTen = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTen);
		b1.add(txtTen);
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(5));
		pnCenterTop.setBorder(
		BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin khách hàng"));

		// Button
		JPanel pnButton = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnThem.setBackground(new Color(0,160,255));
		btnXoaTrang.setBackground(new Color(0,160,255));
		btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoaTrang.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnButton.add(btnThem);
		pnButton.add(btnXoaTrang);
		pnCenterBot.add(pnButton);
		// Table
		String[] headers = { "Mã khách hàng","Số điện thoại", "Tên khách hàng" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 350));
		pnCenterBot.add(sp);

		pnCenter.add(pnCenterTop);
		pnCenter.add(pnCenterBot);

		pnMain.add(pnCenter);
		// Footer
		JPanel pnFooter = new JPanel();
		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		txtTimKiem = new JTextField(20);
		txtTimKiem.setPreferredSize(new Dimension(getWidth(), 30));
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnTim = new JButton("Tìm");
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(0,160,255));
		btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnXoa.setBackground(new Color(0,160,255));
		btnSua.setBackground(new Color(0,160,255));
		btnTim.setBackground(new Color(0,160,255));
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));

		pnFooter.add(lblTimKiem);
		pnFooter.add(txtTimKiem);
		pnFooter.add(btnTim);
		pnFooter.add(btnLamMoi);
		pnFooter.add(btnSua);
		pnFooter.add(btnXoa);
		pnMain.add(pnFooter);

		add(pnMain);

		// Event
		
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.getSelectedRow();
				txtMaKH.setEditable(false);
				txtMaKH.setText((String) table.getValueAt(row, 0));
				txtSDT.setText((String) table.getValueAt(row, 1));
				txtTen.setText((String) table.getValueAt(row, 2));
			}
		});
		ConnectDB.connect();
		hienTable();
	}

	private void hienTable() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// Lấy dữ liệu từ database
		 List<KhachHang> dsKH = new KhachHang_Dao().readFromTable();
		 for (KhachHang kh : dsKH) {
		 model.addRow(new Object[] { kh.getMaKH(), kh.getSoDienThoai(), kh.getHoTen() });
		 }
	}
       
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
			
		}
		if (o.equals(btnTim)) {
			timKiem();
		}
		if (o.equals(btnThem)) {
			themKhachHang();
		}
		if (o.equals(btnXoa)) {
			xoaKhachHang();
		}
		if (o.equals(btnSua)) {
			suaKhachHang();
		}
		if (o.equals(btnLamMoi)) {
			txtTimKiem.setText("");
			table.clearSelection();
			hienTable();
		}

	}

	private void timKiem() {
		String tim = txtTimKiem.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<KhachHang> dsKH = new KhachHang_Dao().readFromTable();
		for (KhachHang kh : dsKH) {
			if (kh.getMaKH().contains(tim) || kh.getSoDienThoai().contains(tim) || kh.getHoTen().contains(tim)) {
				model.addRow(new Object[] { kh.getMaKH(), kh.getSoDienThoai(), kh.getHoTen() });
			}
		}
		
	}

	private void suaKhachHang() {
		
		String ma = txtMaKH.getText();
		String sdt = txtSDT.getText();
		String ten = txtTen.getText();
		
		if (ma.equals("") || sdt.equals("") || ten.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
		} else {
			// Sửa trong database
			KhachHang kh = new KhachHang(ma, sdt, ten);
			KhachHang_Dao khachHangDao = new KhachHang_Dao();
			boolean suaThanhCong = khachHangDao.updateKhachHang(kh);
			if (suaThanhCong) {
				// Sửa trong table
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				model.setValueAt(sdt, row, 1);
				model.setValueAt(ten, row, 2);
				JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công");
				xoaTrang();
			} else {
				JOptionPane.showMessageDialog(this, "Sửa khách hàng không thành công");
			}
		}
		
	}

	private void xoaTrang() {
		table.clearSelection();
		txtMaKH.setEditable(true);
		txtMaKH.setText("");
		txtSDT.setText("");
		txtTen.setText("");
		txtMaKH.requestFocus();
		
	}

	private void themKhachHang() {
		String ma = txtMaKH.getText();
		String sdt = txtSDT.getText();
		String ten = txtTen.getText();
		if (ma.equals("") || sdt.equals("") || ten.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
		} else {
			// Thêm vào database
			KhachHang kh = new KhachHang(ma, sdt, ten);
			KhachHang_Dao khachHangDao = new KhachHang_Dao();
			khachHangDao.addKhachHang(kh);
			
			// thêm vào table
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { ma, sdt, ten });
			JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
			

		}

	}
	private void xoaKhachHang() {
		
	    int row = table.getSelectedRow();
	    
	    if (row == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa");
	    } else {
	    	String maKH = (String) table.getValueAt(row, 0);
	        String sdt = (String) table.getValueAt(row, 1);
	        String ten = (String) table.getValueAt(row, 2);
	        
	        // Xóa khách hàng trong database
	        KhachHang kh = new KhachHang(maKH, sdt, ten);
	        KhachHang_Dao khachHangDao = new KhachHang_Dao();
	        boolean xoaThanhCong = khachHangDao.deleteKhachHang(kh); // Kiểm tra kết quả xóa từ cơ sở dữ liệu
	        if (xoaThanhCong) {
	            // Xóa khách hàng trong table
	            int choice = JOptionPane.showConfirmDialog(DSKhachHang_Gui.this, "Bạn có chắc chắn muốn xóa dòng này?",
	                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                model.removeRow(row);
	                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công");
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Xóa khách hàng không thành công");
	        }
	    }
	}

}
