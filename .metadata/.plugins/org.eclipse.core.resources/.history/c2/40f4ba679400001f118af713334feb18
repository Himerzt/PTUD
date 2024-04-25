package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.NhanVien_Dao;
//import dao.ThongKe_Dao;
import db.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class XemThongKe_Gui extends JPanel implements ActionListener {
	private JPanel pnlMain;
	private JPanel pnlHead;
	private JLabel lbHead;
	private JPanel pnlCenter;
	private Box boxContainer;
	private Box boxBoLoc;
	private Box boxBoLoc1;
	private Box boxThang;
	private JComboBox cbbThang;
	private Box boxNgay;
	private JTextField textNgay;
	private JLabel lbNgay;
	private Box boxBoLoc2;
	private Box boxKhachHang;
	private JButton btnKhachHang;
	private JComboBox cbbKhachHang;
	private Box boxNhanVien;
	private JButton btnNhanVien;
	private JComboBox cbbNhanVien;
	private Box boxSapXep;
	private JButton btnSapXep;
	private JComboBox cbbSapXep;
	private Box boxTable;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private Box boxNam;
	private JButton btnNam;
	private JComboBox cbbNam;
	private JLabel lbThang;
	private JLabel lbNam;
	private JComboBox cbbNgay;
	private JButton btnXoaRong;
	private Box boxBtn;
	private JButton btnXemThongKe;

//	private ThongKe_Dao dsTK = new ThongKe_Dao();
	private HoaDon_Dao dsHD = new HoaDon_Dao();
	private Box boxBoLocBtn;
	private JLabel lblKhachHang;
	private JLabel lblNhanVien;
	private JLabel lblThongKe;
	private JPanel pnlBottom;
	private JLabel lblTongTien;
	private Box boxTong;
	private JTextField txtTongTien;
	private JLabel lblTongLoi;
	private JTextField txtTongLoi;
	private JButton btnIn;

	public XemThongKe_Gui() {

//		JPANEL
		pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());

//		HEADER
		pnlHead = new JPanel();
		lbHead = new JLabel("Thống Kê Doanh Thu");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		lbHead.setFont(fo24);
		lbHead.setForeground(Color.blue);
		pnlHead.add(lbHead);

//		CENTER
		pnlCenter = new JPanel();

		boxContainer = Box.createVerticalBox();
		boxBoLoc = Box.createVerticalBox();

//		Bộ lọc 1 (theo thời gian)		
		boxBoLoc1 = Box.createHorizontalBox();

//      Xem theo năm
		boxNam = Box.createHorizontalBox();
		lbNam = new JLabel("Xem theo năm: ");
		lbNam.setPreferredSize(new Dimension(100, 30));
		// Tạo mảng chứa
		cbbNam = new JComboBox<>();
		cbbNam.setPreferredSize(new Dimension(100, 30));
		boxNam.add(lbNam);
		boxNam.add(Box.createHorizontalStrut(5));
		boxNam.add(cbbNam);

//		Xem theo tháng
		boxThang = Box.createHorizontalBox();
		lbThang = new JLabel("Xem theo tháng: ");
		// Tạo mảng chứa tên các tháng
		String[] months = { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbbThang = new JComboBox<>(months);
		lbThang.setPreferredSize(new Dimension(100, 30));
		cbbThang.setPreferredSize(new Dimension(100, 30));
		boxThang.add(lbThang);
		boxThang.add(Box.createHorizontalStrut(5));
		boxThang.add(cbbThang);

// 		Xem theo ngày (nhập ngày tháng năm)
		boxNgay = Box.createHorizontalBox();
		lbNgay = new JLabel("Xem theo ngày: ");
		cbbNgay = new JComboBox<>();
		lbNgay.setPreferredSize(new Dimension(100, 30));
		cbbNgay.setPreferredSize(new Dimension(100, 30));
		boxNgay.add(lbNgay);
		boxNgay.add(Box.createHorizontalStrut(5));
		boxNgay.add(cbbNgay);

		boxBoLoc1.add(Box.createHorizontalStrut(20));
		boxBoLoc1.add(boxNam);
		boxBoLoc1.add(Box.createHorizontalStrut(20));
		boxBoLoc1.add(boxThang);
		boxBoLoc1.add(Box.createHorizontalStrut(20));
		boxBoLoc1.add(boxNgay);
		boxBoLoc1.add(Box.createHorizontalStrut(20));

//		Bộ lọc 2 (theo đối tượng)		
		boxBoLoc2 = Box.createHorizontalBox();

//		Xem theo Khách hàng
		boxKhachHang = Box.createHorizontalBox();
		lblKhachHang = new JLabel("Mã khách hàng:");
		lblKhachHang.setPreferredSize(new Dimension(100, 30));
		cbbKhachHang = new JComboBox<>();
		cbbKhachHang.setPreferredSize(new Dimension(100, 30));
		boxKhachHang.add(lblKhachHang);
		boxKhachHang.add(boxBoLoc1.add(Box.createHorizontalStrut(5)));
		boxKhachHang.add(cbbKhachHang);

//      Xem theo Nhân viên
		boxNhanVien = Box.createHorizontalBox();
		lblNhanVien = new JLabel("Mã nhân viên:");
		lblNhanVien.setPreferredSize(new Dimension(100, 30));
		cbbNhanVien = new JComboBox<>();
		cbbNhanVien.setPreferredSize(new Dimension(100, 30));
//		btnNhanVien.setMaximumSize(new Dimension(50, 30));
		boxNhanVien.add(lblNhanVien);
		boxNhanVien.add(boxBoLoc1.add(Box.createHorizontalStrut(5)));
		boxNhanVien.add(cbbNhanVien);

// 		Sắp xếp theo đối tượng đã chọn
		boxSapXep = Box.createHorizontalBox();
		lblThongKe = new JLabel("Thống kê theo:");
		lblThongKe.setPreferredSize(new Dimension(100, 30));
		// Tạo mảng chứa tên các đối tượng
		String[] doiTuongSapXep = { "Đơn hàng", "Lợi nhuận cao nhất", "NV chăm chỉ", "KH tiềm năng" };
		cbbSapXep = new JComboBox<>(doiTuongSapXep);
		cbbSapXep.setPreferredSize(new Dimension(100, 30));
//		btnSapXep.setMaximumSize(new Dimension(50, 30));
		boxSapXep.add(lblThongKe);
		boxSapXep.add(boxBoLoc1.add(Box.createHorizontalStrut(5)));
		boxSapXep.add(cbbSapXep);

		boxBoLoc2.add(Box.createHorizontalStrut(20));
		boxBoLoc2.add(boxKhachHang);
		boxBoLoc2.add(Box.createHorizontalStrut(20));
		boxBoLoc2.add(boxNhanVien);
		boxBoLoc2.add(Box.createHorizontalStrut(20));
		boxBoLoc2.add(boxSapXep);
		boxBoLoc2.add(Box.createHorizontalStrut(20));

//		BUTTON BO LOC
		boxBoLocBtn = Box.createHorizontalBox();
		boxBtn = Box.createHorizontalBox();
		btnXemThongKe = new JButton("Xem Thống Kê");
		btnXemThongKe.setBackground(new Color(0,160,255));
		btnXemThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBackground(new Color(0,160,255));
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		boxBtn.add(btnXemThongKe);
		boxBtn.add(Box.createHorizontalStrut(20));
		boxBtn.add(btnXoaRong);
		boxBoLocBtn.add(boxBtn);

		boxBoLoc.add(Box.createVerticalStrut(10));
		boxBoLoc.add(boxBoLoc1);
		boxBoLoc.add(Box.createVerticalStrut(20));
		boxBoLoc.add(boxBoLoc2);
		boxBoLoc.add(Box.createVerticalStrut(20));
		boxBoLoc.add(boxBoLocBtn);
		boxBoLoc.add(Box.createVerticalStrut(20));

		boxTable = Box.createVerticalBox();
		String[] header = "Hóa đơn ;Khách Hàng ;Nhân viên ;Ngày lập; Ngày nhận; Doanh thu; Lợi thuận".split(";");
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(model));
		scroll.setPreferredSize(new Dimension(500, 350)); // SET CHIỀU CAO TABLE
		table.setRowHeight(20);
		boxTable.add(scroll);

		boxContainer.add(boxBoLoc);
		boxContainer.add(boxTable);
		boxBoLoc.setBorder(BorderFactory.createTitledBorder("Bộ lọc"));
		pnlCenter.add(boxContainer);

//		BOTTOM
		pnlBottom = new JPanel();
		boxTong = Box.createHorizontalBox();
		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setPreferredSize(new Dimension(70, 30));
		txtTongTien = new JTextField(15);
		txtTongTien.setEditable(false);

		lblTongLoi = new JLabel("Tổng lợi nhuận:");
		lblTongLoi.setPreferredSize(new Dimension(100, 30));
		txtTongLoi = new JTextField(15);
		txtTongLoi.setEditable(false);

		btnIn = new JButton("In thống kê");
		btnIn.setBackground(new Color(0,160,255));
		btnIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIn.setPreferredSize(new Dimension(100, 35));
		
		boxTong.add(lblTongTien);
		boxTong.add(txtTongTien);
		boxTong.add(Box.createHorizontalStrut(20));
		boxTong.add(lblTongLoi);
		boxTong.add(txtTongLoi);
		boxTong.add(Box.createHorizontalStrut(20));
		boxTong.add(btnIn);
		pnlBottom.add(boxTong);

//		MAIN
		pnlMain.add(pnlHead, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlBottom, BorderLayout.SOUTH);

		add(pnlMain);

// 		ACTION
		btnXoaRong.addActionListener(this);
		btnXemThongKe.addActionListener(this);
		btnIn.addActionListener(this);
		
		ConnectDB.connect();
		hienTable();
		cbbThang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy chỉ số của tháng được chọn
				int selectedMonthIndex = cbbThang.getSelectedIndex();

				// Xác định số ngày tương ứng với tháng được chọn
				int daysInMonth = getDaysInMonth(selectedMonthIndex);

				// Xóa các mục cũ trong Combobox của ngày
				cbbNgay.removeAllItems();
				cbbNgay.addItem("");
				// Thêm các mục mới vào Combobox của ngày
				for (int i = 1; i <= daysInMonth; i++) {

					cbbNgay.addItem(String.valueOf(i));
				}
			}
		});
	}

//	 Trong phương thức hienTable()
	public void hienTable() {
		List<HoaDon> danhSachHoaDon = dsHD.readFromTable();

		// Xóa các dòng hiện tại trên bảng trước khi cập nhật dữ liệu mới
		model.setRowCount(0);
		// Khởi tạo danh sách để lưu trữ các mã khách hàng và mã nhân viên
		Set<String> maKhachHangSet = new HashSet<>();
		Set<String> maNhanVienSet = new HashSet<>();
		// Khởi tạo một Set để lưu trữ các năm đã xuất hiện
		Set<Integer> namSet = new HashSet<>();

		double tongTien = 0;
		double tongLoi = 0;

		// Duyệt qua từng hóa đơn trong danh sách
		for (HoaDon hoaDon : danhSachHoaDon) {
			// Lấy năm từ ngày lập hóa đơn
			int nam = hoaDon.getNgayLap().getYear();
			// Lấy mã khách hàng và mã nhân viên từ hóa đơn
			String maKhachHang = hoaDon.getMaKH().getMaKH();
			String maNhanVien = hoaDon.getMaNV().getMaNV();

			// Thêm năm vào Set
			namSet.add(nam);
			// Thêm mã khách hàng và mã nhân viên vào danh sách (nếu chưa có)
			maKhachHangSet.add(maKhachHang);
			maNhanVienSet.add(maNhanVien);

			// Tính doanh thu và lợi nhuận cho hóa đơn hiện tại
			double doanhThu = dsHD.tinhTongTien(hoaDon);
			double loiNhuan = dsHD.tinhLoiNhuanChoHoaDon(hoaDon);

			// Tạo một mảng chứa các giá trị của hàng
			Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
					hoaDon.getNgayLap().toString(), hoaDon.getNgayNhan().toString(), doanhThu, loiNhuan };

			// Thêm hàng vào bảng
			model.addRow(rowData);

			tongTien += dsHD.tinhTongTien(hoaDon);
			tongLoi += dsHD.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

		// Xóa các mục cũ trong Combobox của năm
		cbbNam.removeAllItems();
		cbbNam.addItem("");
		// Xóa các lựa chọn cũ trong Combobox của Khách hàng và Nhân viên
		cbbKhachHang.removeAllItems();
		cbbNhanVien.removeAllItems();
		cbbKhachHang.addItem("");
		cbbNhanVien.addItem("");

		// Thêm các năm từ Set vào Combobox của năm
		for (int nam : namSet) {
			cbbNam.addItem(String.valueOf(nam));
		}
		// Thêm các mã khách hàng vào Combobox của Khách hàng
		for (String maKH : maKhachHangSet) {
			cbbKhachHang.addItem(maKH);
		}

		// Thêm các mã nhân viên vào Combobox của Nhân viên
		for (String maNV : maNhanVienSet) {
			cbbNhanVien.addItem(maNV);
		}
	}

	private int getDaysInMonth(int monthIndex) {
		// Tháng 2 (index = 2) có 28 hoặc 29 ngày tùy theo năm nhuận
		if (monthIndex == 2) {
			int selectedYear = Integer.parseInt(cbbNam.getSelectedItem().toString());
			if (isLeapYear(selectedYear)) {
				return 29;
			} else {
				return 28;
			}
		}
		// Các tháng khác có số ngày như sau:
		else if (monthIndex == 4 || monthIndex == 6 || monthIndex == 9 || monthIndex == 11) {
			return 30;
		} else {
			return 31;
		}
	}

	// Phương thức để kiểm tra năm nhuận
	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnXemThongKe) {
			checkThongKe();
		}
		if (e.getSource() == btnXoaRong) {
			// Xóa rỗng Combobox của năm
			cbbNam.setSelectedIndex(-1);

			// Xóa rỗng Combobox của tháng
			cbbThang.setSelectedIndex(0);

			// Xóa rỗng Combobox của ngày
			cbbNgay.setSelectedIndex(-1);

			// Xóa rỗng Combobox của Khách hàng
			cbbKhachHang.setSelectedIndex(-1);

			// Xóa rỗng Combobox của Nhân viên
			cbbNhanVien.setSelectedIndex(-1);

			// Xóa rỗng Combobox của Sắp xếp
			cbbSapXep.setSelectedIndex(0);
		}
		if (e.getSource() == btnIn) {
			inThongKeRaExcel();
		}

	}
	private void inThongKeRaExcel() {
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("ThongKe");

	    // Tạo hàng header
	    Row headerRow = sheet.createRow(0);
	    for (int i = 0; i < model.getColumnCount(); i++) {
	        Cell cell = headerRow.createCell(i);
	        cell.setCellValue(model.getColumnName(i));
	    }

	    // Thêm dữ liệu từ bảng vào file Excel
	    for (int i = 0; i < model.getRowCount(); i++) {
	        Row row = sheet.createRow(i + 1);
	        for (int j = 0; j < model.getColumnCount(); j++) {
	            row.createCell(j).setCellValue(model.getValueAt(i, j).toString());
	        }
	    }

	    // Lưu workbook vào một file Excel
	    try (FileOutputStream outputStream = new FileOutputStream("thongke.xlsx")) {
	        workbook.write(outputStream);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void checkThongKe() {
		String checkNam = cbbNam.getSelectedItem() != null ? cbbNam.getSelectedItem().toString() : "";
		String checkThang = cbbThang.getSelectedItem() != null ? cbbThang.getSelectedItem().toString() : "";
		String checkNgay = cbbNgay.getSelectedItem() != null ? cbbNgay.getSelectedItem().toString() : "";
		String checkMaKH = cbbKhachHang.getSelectedItem() != null ? cbbKhachHang.getSelectedItem().toString() : "";
		String checkMaNV = cbbNhanVien.getSelectedItem() != null ? cbbNhanVien.getSelectedItem().toString() : "";
		String checkTypeThongKe = cbbSapXep.getSelectedItem() != null ? cbbSapXep.getSelectedItem().toString() : "";

		if (checkNam.equals("") && checkMaKH.equals("") && checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {
			thongKeDon();
		} else if (!checkNam.equals("") && !checkThang.equals("") && !checkNgay.equals("") && !checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeFullField();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));

		} else if (!checkNam.equals("") && !checkThang.equals("") && checkNgay.equals("") && !checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeXYinMonth();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));

		} else if (!checkNam.equals("") && checkThang.equals("") && checkNgay.equals("") && !checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeXYinYear();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (checkNam.equals("") && checkThang.equals("") && checkNgay.equals("") && !checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeXY();

		} else if (!checkNam.equals("") && !checkThang.equals("") && !checkNgay.equals("") && !checkMaKH.equals("")
				&& checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeKHinDay();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && !checkThang.equals("") && checkNgay.equals("") && !checkMaKH.equals("")
				&& checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeKHinMonth();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && checkThang.equals("") && checkNgay.equals("") && !checkMaKH.equals("")
				&& checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeKHinYear();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (checkNam.equals("") && checkThang.equals("") && checkNgay.equals("") && !checkMaKH.equals("")
				&& checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeKH();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && !checkThang.equals("") && !checkNgay.equals("") && checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeNVinDay();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && !checkThang.equals("") && checkNgay.equals("") && checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeNVinMonth();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && checkThang.equals("") && checkNgay.equals("") && checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeNVinYear();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (checkNam.equals("") && checkThang.equals("") && checkNgay.equals("") && checkMaKH.equals("")
				&& !checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeNV();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && !checkThang.equals("") && !checkNgay.equals("") && checkMaKH.equals("")
				&& checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeDonInNgay();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && !checkThang.equals("") && checkNgay.equals("") && checkMaKH.equals("")
				&& checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeDonInMonth();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (!checkNam.equals("") && checkThang.equals("") && checkNgay.equals("") && checkMaKH.equals("")
				&& checkMaNV.equals("") && checkTypeThongKe.equals("Đơn hàng")) {

			thongKeDonInYear();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (checkTypeThongKe.equals("Lợi nhuận cao nhất")) {

			thongKeLoiNhuanCaoNhat();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (checkTypeThongKe.equals("NV chăm chỉ")) {

			thongKeNVChamChi();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		} else if (checkTypeThongKe.equals("KH tiềm năng")) {

			thongKeKHTiemNang();
			txtTongTien.setText(String.valueOf(tinhTongDoanhThu()));
			txtTongLoi.setText(String.valueOf(tinhTongLoiNhuan()));
		}

	}
	private double tinhTongDoanhThu() {
	    double tongDoanhThu = 0;
	    // Duyệt qua từng dòng trong bảng
	    for (int i = 0; i < model.getRowCount(); i++) {
	        // Lấy giá trị ở cột "Doanh thu" từ mỗi dòng và cộng vào tổng doanh thu
	        tongDoanhThu += Double.parseDouble(model.getValueAt(i, 5).toString());
	    }
	    return tongDoanhThu;
	}

	private double tinhTongLoiNhuan() {
	    double tongLoiNhuan = 0;
	    // Duyệt qua từng dòng trong bảng
	    for (int i = 0; i < model.getRowCount(); i++) {
	        // Lấy giá trị ở cột "Lợi nhuận" từ mỗi dòng và cộng vào tổng lợi nhuận
	        tongLoiNhuan += Double.parseDouble(model.getValueAt(i, 6).toString());
	    }
	    return tongLoiNhuan;
	}

//	Top 3 Khách có số đơn nhiều nhất
	private void thongKeKHTiemNang() {
		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.thongKeKHTiemNang();

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}

//	Top 3 Nhân viên lập số đơn nhiều nhất
	private void thongKeNVChamChi() {
		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.thongKeNVChamChi();

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}

//	Top 3 Đơn hàng có lợi nhuận cao nhất
	private void thongKeLoiNhuanCaoNhat() {
		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.thongKeLoiNhuanCaoNhat();

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}

//  Khách Hàng X và Nhân Viên Y

//	Thống kê đơn của KH X được lập bởi NV Y theo ngày
	private void thongKeFullField() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
		int ngay = Integer.parseInt(cbbNgay.getSelectedItem().toString());
		String maNV = cbbNhanVien.getSelectedItem().toString();
		String maKH = cbbKhachHang.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, thang, ngay);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findTKFullField(date, maNV, maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}

//	Thống kê đơn của KH X được lập bởi NV Y theo tháng
	private void thongKeXYinMonth() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
		String maNV = cbbNhanVien.getSelectedItem().toString();
		String maKH = cbbKhachHang.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, thang, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findXYinMonth(date, maNV, maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}

//	Thống kê đơn của KH X được lập bởi NV Y theo năm
	private void thongKeXYinYear() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		String maNV = cbbNhanVien.getSelectedItem().toString();
		String maKH = cbbKhachHang.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, 1, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findXYinYear(date, maNV, maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}
	
//	Thống kê đơn của KH X được lập bởi NV Y 
	private void thongKeXY() {
		String maNV = cbbNhanVien.getSelectedItem().toString();
		String maKH = cbbKhachHang.getSelectedItem().toString();

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findXByY(maNV, maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}

//	Khách Hàng

//	Thống kê đơn của KH theo ngày
	private void thongKeKHinDay() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
		int ngay = Integer.parseInt(cbbNgay.getSelectedItem().toString());
		String maKH = cbbKhachHang.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, thang, ngay);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findKHinDay(date, maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê đơn của KH theo tháng
	private void thongKeKHinMonth() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
		String maKH = cbbKhachHang.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, thang, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findKHinMonth(date, maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê đơn của KH theo năm
	private void thongKeKHinYear() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		String maKH = cbbKhachHang.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, 1, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findKHinYear(date, maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));
	}

//	Thống kê tất cả đơn của KH
	private void thongKeKH() {
		String maKH = cbbKhachHang.getSelectedItem().toString();

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findKH(maKH);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Nhân Viên

//	Thống kê đơn Nhân Viên lập theo ngày
	private void thongKeNVinDay() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
		int ngay = Integer.parseInt(cbbNgay.getSelectedItem().toString());
		String maNV = cbbNhanVien.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, thang, ngay);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findNVinDay(date, maNV);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê đơn Nhân Viên lập theo tháng
	private void thongKeNVinMonth() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
		String maNV = cbbNhanVien.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, thang, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findNVinMonth(date, maNV);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê đơn Nhân Viên lập theo năm
	private void thongKeNVinYear() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		String maNV = cbbNhanVien.getSelectedItem().toString();

		LocalDate date = LocalDate.of(nam, 1, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findNVinYear(date, maNV);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê tất cả đơn Nhân Viên đã lập
	private void thongKeNV() {
		String maNV = cbbNhanVien.getSelectedItem().toString();

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findNV(maNV);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Đơn hàng

//	Thống kê đơn theo ngày
	private void thongKeDonInNgay() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
		int ngay = Integer.parseInt(cbbNgay.getSelectedItem().toString());

		LocalDate date = LocalDate.of(nam, thang, ngay);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findinDay(date);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê đơn theo tháng
	private void thongKeDonInMonth() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());

		LocalDate date = LocalDate.of(nam, thang, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findinMonth(date);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê đơn theo năm
	private void thongKeDonInYear() {
		int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());

		LocalDate date = LocalDate.of(nam, 1, 1);

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.findinYear(date);

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}

//	Thống kê tất cả các đơn
	private void thongKeDon() {

		HoaDon_Dao hdDao = new HoaDon_Dao();
		List<HoaDon> listHD = hdDao.readFromTable();

		if (listHD != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (HoaDon hoaDon : listHD) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
						hoaDon.getNgayLap(), hoaDon.getNgayNhan(), hdDao.tinhTongTien(hoaDon),
						hdDao.tinhLoiNhuanChoHoaDon(hoaDon) };
				model.addRow(rowData);
			}
		}

		double tongTien = 0;
		double tongLoi = 0;
		for (HoaDon hoaDon : listHD) {
			tongTien += hdDao.tinhTongTien(hoaDon);
			tongLoi += hdDao.tinhLoiNhuanChoHoaDon(hoaDon);
		}

		txtTongTien.setText(String.valueOf(tongTien));
		txtTongLoi.setText(String.valueOf(tongLoi));

	}
}
