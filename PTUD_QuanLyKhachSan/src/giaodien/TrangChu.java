package giaodien;

import dao.ChucVuDao;
import dao.DichVuDao;
import dao.HangThanhVienDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import entity.ChucVu;
import entity.DichVu;
import entity.HangThanhVien;
import entity.KhachHang;
import entity.NhanVien;

import static java.awt.Color.red;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import menu.MenuEvent;

/**
 * @author Huynguyen
 */
public class TrangChu extends javax.swing.JFrame {

	public TrangChu() throws Exception {

		ConnectDB.getInstance().getConnection();
//        setUndecorated(true);
//        setAlwaysOnTop(true);
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = (int) tk.getScreenSize().getWidth();
		int y = (int) tk.getScreenSize().getHeight();
		setSize(x, y);
		initComponents();
		datetime();
		times();

		Menu.setEvent(new MenuEvent() {
			@Override
			public void selected(int index, int subIndex) {
				if (index == 6) {
					System.exit(0);
				}

				if (index == 0) {
					pnedUngDung.setSelectedIndex(0);
				}

				if (index == 1) {
					pnedUngDung.setSelectedIndex(1);
				}

				if (index == 2) {
					pnedUngDung.setSelectedIndex(2);
				}
				if (index == 3) {
					pnedUngDung.setSelectedIndex(3);
					loadTableDichVu();
					enventClickOnTableDichVu();
				}

				if (index == 4) {
					pnedUngDung.setSelectedIndex(4);
				}
				if (index == 5) {
					pnedUngDung.setSelectedIndex(5);
				}

			}

		});

	}

	/**
	 * Khởi tạo ngày hiện tại để in lên ngày **
	 * *****************************************
	 */
	public void datetime() {
		Date d = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
		String df = format.format(d);

		// lbl_current_date.setText(df);
	}

	/**
	 * Khởi tạo giờ hiện tại để in lên giờ **
	 * *****************************************
	 */
	public void times() {
		Timer time;

		time = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Date d = new Date();

				SimpleDateFormat dformat;
				dformat = new SimpleDateFormat("hh:mm:ss a");

				String timeindate = dformat.format(d);
				// lbl_time.setText(timeindate);

			}
		});

		time.start();
	}

	/**
	 * Load thông tin dịch vụ lên bảng dịch vụ hiện có trong pnDichVu**
	 * *****************************************************************
	 */
	public void loadTableDichVu() {

		DichVuDao dichVuDao = new DichVuDao();
		ArrayList<DichVu> dsDichVu = dichVuDao.timTatCaDichVu();
		DefaultTableModel model = (DefaultTableModel) TableDichVu.getModel();

		model.setRowCount(0);

		for (int i = 0; i < dsDichVu.size(); i++) {
			DichVu dv = dsDichVu.get(i);
			Object[] rowData = { i + 1, dv.getMaDV(), dv.getTenDV(), dv.getGiaDV() };
			model.addRow(rowData);
		}

	};

	/**
	 * Load thông tin nhân viên lên bảng nhân viên hiện có trong pnNhanVien**
	 * *****************************************************************
	 */
	public void loadTableNhanVien() {

		NhanVienDao nhanVienDao = new NhanVienDao();
		ArrayList<NhanVien> dsNhanVien = nhanVienDao.timTatCaNhanVien();
		DefaultTableModel model = (DefaultTableModel) TableNhanVien.getModel();

		model.setRowCount(0);

		for (int i = 0; i < dsNhanVien.size(); i++) {
			NhanVien nv = dsNhanVien.get(i);
			Object[] rowData = { i + 1, nv.getMaNV(), nv.getHoTenNV(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getSoDT(),
					nv.getEmail(), nv.getCCCD(), nv.getDiaChi(), nv.getChucVu().getTenChucVu(), nv.getNgayVaoLam() };
			model.addRow(rowData);
		}
	};

	/**
	 * Lắng nghe sự kiện khi người dùng chọn một dòng trong bảng**
	 * *****************************************************************
	 */
	public void enventClickOnTableDichVu() {
		TableDichVu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = TableDichVu.getSelectedRow();
					if (selectedRow != -1) { // Đảm bảo có hàng được chọn
						txtMaDichVu.setText((String) TableDichVu.getValueAt(selectedRow, 1));
						txtTenDichVu.setText((String) TableDichVu.getValueAt(selectedRow, 2));
						txtDonGiaDichVu.setText(String.valueOf(TableDichVu.getValueAt(selectedRow, 3)));
					}
				}
			}
		});
	};

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGROUPLoaiPhong = new javax.swing.ButtonGroup();
        btnGROUPTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        Header = new component.Header();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        Menu = new menu.Menu();
        pnedUngDung = new javax.swing.JTabbedPane();
        pnTrangChu = new javax.swing.JPanel();
        pnLayOutTrangChu = new javax.swing.JPanel();
        ScrollPaneTrangChu = new javax.swing.JScrollPane();
        pnBody1 = new javax.swing.JPanel();
        Tang1_TrangChu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        phong2 = new javax.swing.JPanel();
        lblTenPhong2 = new javax.swing.JLabel();
        lblLoaiPhong2 = new javax.swing.JLabel();
        lblTrangThai2 = new javax.swing.JLabel();
        phong3 = new javax.swing.JPanel();
        lblTenPhong3 = new javax.swing.JLabel();
        lblLoaiPhong3 = new javax.swing.JLabel();
        lblTrangThai3 = new javax.swing.JLabel();
        phong4 = new javax.swing.JPanel();
        lblTenPhong4 = new javax.swing.JLabel();
        lblLoaiPhong4 = new javax.swing.JLabel();
        lblTrangThai4 = new javax.swing.JLabel();
        phong5 = new javax.swing.JPanel();
        lblTenPhong5 = new javax.swing.JLabel();
        lblLoaiPhong5 = new javax.swing.JLabel();
        lblTrangThai5 = new javax.swing.JLabel();
        phong6 = new javax.swing.JPanel();
        lblTenPhong6 = new javax.swing.JLabel();
        lblLoaiPhong6 = new javax.swing.JLabel();
        lblTrangThai6 = new javax.swing.JLabel();
        phong9 = new javax.swing.JPanel();
        lblTenPhong9 = new javax.swing.JLabel();
        lblLoaiPhong9 = new javax.swing.JLabel();
        lblTrangThai9 = new javax.swing.JLabel();
        phong10 = new javax.swing.JPanel();
        lblTenPhong10 = new javax.swing.JLabel();
        lblLoaiPhong10 = new javax.swing.JLabel();
        lblTrangThai10 = new javax.swing.JLabel();
        phong11 = new javax.swing.JPanel();
        lblTenPhong11 = new javax.swing.JLabel();
        lblLoaiPhong11 = new javax.swing.JLabel();
        lblTrangThai11 = new javax.swing.JLabel();
        phong13 = new javax.swing.JPanel();
        lblTenPhong13 = new javax.swing.JLabel();
        lblLoaiPhong13 = new javax.swing.JLabel();
        lblTrangThai13 = new javax.swing.JLabel();
        phong14 = new javax.swing.JPanel();
        lblTenPhong14 = new javax.swing.JLabel();
        lblLoaiPhong14 = new javax.swing.JLabel();
        lblTrangThai14 = new javax.swing.JLabel();
        Tang2_TrangChu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        phong17 = new javax.swing.JPanel();
        lblTenPhong17 = new javax.swing.JLabel();
        lblLoaiPhong17 = new javax.swing.JLabel();
        lblTrangThai17 = new javax.swing.JLabel();
        phong18 = new javax.swing.JPanel();
        lblTenPhong18 = new javax.swing.JLabel();
        lblLoaiPhong18 = new javax.swing.JLabel();
        lblTrangThai18 = new javax.swing.JLabel();
        phong19 = new javax.swing.JPanel();
        lblTenPhong19 = new javax.swing.JLabel();
        lblLoaiPhong19 = new javax.swing.JLabel();
        lblTrangThai19 = new javax.swing.JLabel();
        phong20 = new javax.swing.JPanel();
        lblTenPhong20 = new javax.swing.JLabel();
        lblLoaiPhong20 = new javax.swing.JLabel();
        lblTrangThai20 = new javax.swing.JLabel();
        phong21 = new javax.swing.JPanel();
        lblTenPhong21 = new javax.swing.JLabel();
        lblLoaiPhong21 = new javax.swing.JLabel();
        lblTrangThai21 = new javax.swing.JLabel();
        phong24 = new javax.swing.JPanel();
        lblTenPhong24 = new javax.swing.JLabel();
        lblLoaiPhong24 = new javax.swing.JLabel();
        lblTrangThai24 = new javax.swing.JLabel();
        phong25 = new javax.swing.JPanel();
        lblTenPhong25 = new javax.swing.JLabel();
        lblLoaiPhong25 = new javax.swing.JLabel();
        lblTrangThai25 = new javax.swing.JLabel();
        phong26 = new javax.swing.JPanel();
        lblTenPhong26 = new javax.swing.JLabel();
        lblTrangThai26 = new javax.swing.JLabel();
        phong27 = new javax.swing.JPanel();
        lblTenPhong27 = new javax.swing.JLabel();
        lblLoaiPhong27 = new javax.swing.JLabel();
        lblTrangThai27 = new javax.swing.JLabel();
        lblLoaiPhong26 = new javax.swing.JLabel();
        phong28 = new javax.swing.JPanel();
        lblTenPhong28 = new javax.swing.JLabel();
        lblLoaiPhong28 = new javax.swing.JLabel();
        lblTrangThai28 = new javax.swing.JLabel();
        Tang3_TrangChu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        phong31 = new javax.swing.JPanel();
        lblTenPhong31 = new javax.swing.JLabel();
        lblLoaiPhong31 = new javax.swing.JLabel();
        lblTrangThai31 = new javax.swing.JLabel();
        phong32 = new javax.swing.JPanel();
        lblTenPhong32 = new javax.swing.JLabel();
        lblLoaiPhong32 = new javax.swing.JLabel();
        lblTrangThai32 = new javax.swing.JLabel();
        phong33 = new javax.swing.JPanel();
        lblTenPhong33 = new javax.swing.JLabel();
        lblLoaiPhong33 = new javax.swing.JLabel();
        lblTrangThai33 = new javax.swing.JLabel();
        phong34 = new javax.swing.JPanel();
        lblTenPhong34 = new javax.swing.JLabel();
        lblLoaiPhong34 = new javax.swing.JLabel();
        lblTrangThai34 = new javax.swing.JLabel();
        phong35 = new javax.swing.JPanel();
        lblTenPhong35 = new javax.swing.JLabel();
        lblLoaiPhong35 = new javax.swing.JLabel();
        lblTrangThai35 = new javax.swing.JLabel();
        phong38 = new javax.swing.JPanel();
        lblTenPhong38 = new javax.swing.JLabel();
        lblLoaiPhong38 = new javax.swing.JLabel();
        lblTrangThai38 = new javax.swing.JLabel();
        phong39 = new javax.swing.JPanel();
        lblTenPhong39 = new javax.swing.JLabel();
        lblLoaiPhong39 = new javax.swing.JLabel();
        lblTrangThai39 = new javax.swing.JLabel();
        phong40 = new javax.swing.JPanel();
        lblTenPhong40 = new javax.swing.JLabel();
        lblLoaiPhong40 = new javax.swing.JLabel();
        lblTrangThai40 = new javax.swing.JLabel();
        phong41 = new javax.swing.JPanel();
        lblTenPhong41 = new javax.swing.JLabel();
        lblLoaiPhong41 = new javax.swing.JLabel();
        lblTrangThai41 = new javax.swing.JLabel();
        phong42 = new javax.swing.JPanel();
        lblTenPhong42 = new javax.swing.JLabel();
        lblLoaiPhong42 = new javax.swing.JLabel();
        lblTrangThai42 = new javax.swing.JLabel();
        Tang4_TrangChu = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        phong36 = new javax.swing.JPanel();
        lblTenPhong36 = new javax.swing.JLabel();
        lblLoaiPhong36 = new javax.swing.JLabel();
        lblTrangThai36 = new javax.swing.JLabel();
        phong37 = new javax.swing.JPanel();
        lblTenPhong37 = new javax.swing.JLabel();
        lblLoaiPhong37 = new javax.swing.JLabel();
        lblTrangThai37 = new javax.swing.JLabel();
        phong48 = new javax.swing.JPanel();
        lblTenPhong48 = new javax.swing.JLabel();
        lblLoaiPhong48 = new javax.swing.JLabel();
        lblTrangThai48 = new javax.swing.JLabel();
        phong49 = new javax.swing.JPanel();
        lblTenPhong49 = new javax.swing.JLabel();
        lblLoaiPhong49 = new javax.swing.JLabel();
        lblTrangThai49 = new javax.swing.JLabel();
        phong50 = new javax.swing.JPanel();
        lblTenPhong50 = new javax.swing.JLabel();
        lblLoaiPhong50 = new javax.swing.JLabel();
        lblTrangThai50 = new javax.swing.JLabel();
        pnQuanLyPhong = new javax.swing.JPanel();
        ScrollPaneQuanLyPhong = new javax.swing.JScrollPane();
        pnBody2 = new javax.swing.JPanel();
        Tang1_QuanLyPhong = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        phongQuanLy1 = new javax.swing.JPanel();
        lblTenPhongQL1 = new javax.swing.JLabel();
        lblLoaiPhongQL1 = new javax.swing.JLabel();
        lblTrangThaiQL1 = new javax.swing.JLabel();
        checkBoxPhongQL1 = new javax.swing.JCheckBox();
        phongQuanLy2 = new javax.swing.JPanel();
        lblTenPhongQL2 = new javax.swing.JLabel();
        lblLoaiPhongQL2 = new javax.swing.JLabel();
        lblTrangThaiQL2 = new javax.swing.JLabel();
        checkBoxPhongQL2 = new javax.swing.JCheckBox();
        phongQuanLy3 = new javax.swing.JPanel();
        lblTenPhongQL3 = new javax.swing.JLabel();
        lblLoaiPhongQL3 = new javax.swing.JLabel();
        lblTrangThaiQL3 = new javax.swing.JLabel();
        checkBoxPhongQL3 = new javax.swing.JCheckBox();
        phongQuanLy4 = new javax.swing.JPanel();
        lblTenPhongQL4 = new javax.swing.JLabel();
        lblLoaiPhongQL4 = new javax.swing.JLabel();
        lblTrangThaiQL4 = new javax.swing.JLabel();
        checkBoxPhongQL4 = new javax.swing.JCheckBox();
        phongQuanLy5 = new javax.swing.JPanel();
        lblTenPhongQL5 = new javax.swing.JLabel();
        lblLoaiPhongQL5 = new javax.swing.JLabel();
        lblTrangThaiQL5 = new javax.swing.JLabel();
        checkBoxPhongQL5 = new javax.swing.JCheckBox();
        phongQuanLy6 = new javax.swing.JPanel();
        lblTenPhongQL6 = new javax.swing.JLabel();
        lblLoaiPhongQL6 = new javax.swing.JLabel();
        lblTrangThaiQL6 = new javax.swing.JLabel();
        checkBoxPhongQL6 = new javax.swing.JCheckBox();
        phongQuanLy7 = new javax.swing.JPanel();
        lblTenPhongQL7 = new javax.swing.JLabel();
        lblLoaiPhongQL7 = new javax.swing.JLabel();
        lblTrangThaiQL7 = new javax.swing.JLabel();
        checkBoxPhongQL7 = new javax.swing.JCheckBox();
        phongQuanLy8 = new javax.swing.JPanel();
        lblTenPhongQL8 = new javax.swing.JLabel();
        lblLoaiPhongQL8 = new javax.swing.JLabel();
        lblTrangThaiQL8 = new javax.swing.JLabel();
        checkBoxPhongQL8 = new javax.swing.JCheckBox();
        phongQuanLy9 = new javax.swing.JPanel();
        lblTenPhongQL9 = new javax.swing.JLabel();
        lblLoaiPhongQL9 = new javax.swing.JLabel();
        lblTrangThaiQL9 = new javax.swing.JLabel();
        checkBoxPhongQL9 = new javax.swing.JCheckBox();
        phongQuanLy10 = new javax.swing.JPanel();
        lblTenPhongQL10 = new javax.swing.JLabel();
        lblLoaiPhongQL10 = new javax.swing.JLabel();
        lblTrangThaiQL10 = new javax.swing.JLabel();
        checkBoxPhongQL10 = new javax.swing.JCheckBox();
        Tang2_QuanLyPhong = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        phongQuanLy11 = new javax.swing.JPanel();
        lblTenPhongQL11 = new javax.swing.JLabel();
        lblLoaiPhongQL11 = new javax.swing.JLabel();
        lblTrangThaiQL11 = new javax.swing.JLabel();
        checkBoxPhongQL11 = new javax.swing.JCheckBox();
        phongQuanLy12 = new javax.swing.JPanel();
        lblTenPhongQL12 = new javax.swing.JLabel();
        lblLoaiPhongQL12 = new javax.swing.JLabel();
        lblTrangThaiQL12 = new javax.swing.JLabel();
        checkBoxPhongQL12 = new javax.swing.JCheckBox();
        phongQuanLy13 = new javax.swing.JPanel();
        lblTenPhongQL13 = new javax.swing.JLabel();
        lblLoaiPhongQL13 = new javax.swing.JLabel();
        lblTrangThaiQL13 = new javax.swing.JLabel();
        checkBoxPhongQL13 = new javax.swing.JCheckBox();
        phongQuanLy14 = new javax.swing.JPanel();
        lblTenPhongQL14 = new javax.swing.JLabel();
        lblLoaiPhongQL14 = new javax.swing.JLabel();
        lblTrangThaiQL14 = new javax.swing.JLabel();
        checkBoxPhongQL14 = new javax.swing.JCheckBox();
        phongQuanLy15 = new javax.swing.JPanel();
        lblTenPhongQL15 = new javax.swing.JLabel();
        lblLoaiPhongQL15 = new javax.swing.JLabel();
        lblTrangThaiQL15 = new javax.swing.JLabel();
        checkBoxPhongQL15 = new javax.swing.JCheckBox();
        phongQuanLy16 = new javax.swing.JPanel();
        lblTenPhongQL16 = new javax.swing.JLabel();
        lblLoaiPhongQL16 = new javax.swing.JLabel();
        lblTrangThaiQL16 = new javax.swing.JLabel();
        checkBoxPhongQL16 = new javax.swing.JCheckBox();
        phongQuanLy17 = new javax.swing.JPanel();
        lblTenPhongQL17 = new javax.swing.JLabel();
        lblLoaiPhongQL17 = new javax.swing.JLabel();
        lblTrangThaiQL17 = new javax.swing.JLabel();
        checkBoxPhongQL17 = new javax.swing.JCheckBox();
        phongQuanLy18 = new javax.swing.JPanel();
        lblTenPhongQL18 = new javax.swing.JLabel();
        lblLoaiPhongQL18 = new javax.swing.JLabel();
        lblTrangThaiQL18 = new javax.swing.JLabel();
        checkBoxPhongQL18 = new javax.swing.JCheckBox();
        phongQuanLy19 = new javax.swing.JPanel();
        lblTenPhongQL19 = new javax.swing.JLabel();
        lblLoaiPhongQL19 = new javax.swing.JLabel();
        lblTrangThaiQL19 = new javax.swing.JLabel();
        checkBoxPhongQL19 = new javax.swing.JCheckBox();
        phongQuanLy20 = new javax.swing.JPanel();
        lblTenPhongQL20 = new javax.swing.JLabel();
        lblLoaiPhongQL20 = new javax.swing.JLabel();
        lblTrangThaiQL20 = new javax.swing.JLabel();
        checkBoxPhongQL20 = new javax.swing.JCheckBox();
        Tang3_QuanLyPhong = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        phongQuanLy21 = new javax.swing.JPanel();
        lblTenPhongQL21 = new javax.swing.JLabel();
        lblLoaiPhongQL21 = new javax.swing.JLabel();
        lblTrangThaiQL21 = new javax.swing.JLabel();
        checkBoxPhongQL21 = new javax.swing.JCheckBox();
        phongQuanLy22 = new javax.swing.JPanel();
        lblTenPhongQL22 = new javax.swing.JLabel();
        lblLoaiPhongQL22 = new javax.swing.JLabel();
        lblTrangThaiQL22 = new javax.swing.JLabel();
        checkBoxPhongQL22 = new javax.swing.JCheckBox();
        phongQuanLy23 = new javax.swing.JPanel();
        lblTenPhongQL23 = new javax.swing.JLabel();
        lblLoaiPhongQL23 = new javax.swing.JLabel();
        lblTrangThaiQL23 = new javax.swing.JLabel();
        checkBoxPhongQL23 = new javax.swing.JCheckBox();
        phongQuanLy24 = new javax.swing.JPanel();
        lblTenPhongQL24 = new javax.swing.JLabel();
        lblLoaiPhongQL24 = new javax.swing.JLabel();
        lblTrangThaiQL24 = new javax.swing.JLabel();
        checkBoxPhongQL24 = new javax.swing.JCheckBox();
        phongQuanLy25 = new javax.swing.JPanel();
        lblTenPhongQL25 = new javax.swing.JLabel();
        lblLoaiPhongQL25 = new javax.swing.JLabel();
        lblTrangThaiQL25 = new javax.swing.JLabel();
        checkBoxPhongQL25 = new javax.swing.JCheckBox();
        phongQuanLy26 = new javax.swing.JPanel();
        lblTenPhongQL26 = new javax.swing.JLabel();
        lblLoaiPhongQL26 = new javax.swing.JLabel();
        lblTrangThaiQL26 = new javax.swing.JLabel();
        checkBoxPhongQL26 = new javax.swing.JCheckBox();
        phongQuanLy27 = new javax.swing.JPanel();
        lblTenPhongQL27 = new javax.swing.JLabel();
        lblLoaiPhongQL27 = new javax.swing.JLabel();
        lblTrangThaiQL27 = new javax.swing.JLabel();
        checkBoxPhongQL27 = new javax.swing.JCheckBox();
        phongQuanLy28 = new javax.swing.JPanel();
        lblTenPhongQL28 = new javax.swing.JLabel();
        lblLoaiPhongQL28 = new javax.swing.JLabel();
        lblTrangThaiQL28 = new javax.swing.JLabel();
        checkBoxPhongQL28 = new javax.swing.JCheckBox();
        phongQuanLy29 = new javax.swing.JPanel();
        lblTenPhongQL29 = new javax.swing.JLabel();
        lblLoaiPhongQL29 = new javax.swing.JLabel();
        lblTrangThaiQL29 = new javax.swing.JLabel();
        checkBoxPhongQL29 = new javax.swing.JCheckBox();
        phongQuanLy30 = new javax.swing.JPanel();
        lblTenPhongQL30 = new javax.swing.JLabel();
        lblLoaiPhongQL30 = new javax.swing.JLabel();
        lblTrangThaiQL30 = new javax.swing.JLabel();
        checkBoxPhongQL30 = new javax.swing.JCheckBox();
        Tang4_QuanLyPhong = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        phongQuanLy31 = new javax.swing.JPanel();
        lblTenPhongQL31 = new javax.swing.JLabel();
        lblLoaiPhongQL31 = new javax.swing.JLabel();
        lblTrangThaiQL31 = new javax.swing.JLabel();
        checkBoxPhongQL31 = new javax.swing.JCheckBox();
        phongQuanLy32 = new javax.swing.JPanel();
        lblTenPhongQL32 = new javax.swing.JLabel();
        lblLoaiPhongQL32 = new javax.swing.JLabel();
        lblTrangThaiQL32 = new javax.swing.JLabel();
        checkBoxPhongQL32 = new javax.swing.JCheckBox();
        phongQuanLy33 = new javax.swing.JPanel();
        lblTenPhongQL33 = new javax.swing.JLabel();
        lblLoaiPhongQL33 = new javax.swing.JLabel();
        lblTrangThaiQL33 = new javax.swing.JLabel();
        checkBoxPhongQL33 = new javax.swing.JCheckBox();
        phongQuanLy34 = new javax.swing.JPanel();
        lblTenPhongQL34 = new javax.swing.JLabel();
        lblLoaiPhongQL34 = new javax.swing.JLabel();
        lblTrangThaiQL34 = new javax.swing.JLabel();
        checkBoxPhongQL34 = new javax.swing.JCheckBox();
        phongQuanLy35 = new javax.swing.JPanel();
        lblTenPhongQL35 = new javax.swing.JLabel();
        lblLoaiPhongQL35 = new javax.swing.JLabel();
        lblTrangThaiQL35 = new javax.swing.JLabel();
        checkBoxPhongQL35 = new javax.swing.JCheckBox();
        funtionPanel = new javax.swing.JPanel();
        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lblcurrentdate = new javax.swing.JLabel();
        lblcurrentTime = new javax.swing.JLabel();
        radPhongTieuChuan = new javax.swing.JRadioButton();
        radPhongNangCao = new javax.swing.JRadioButton();
        radPhongCaoCap = new javax.swing.JRadioButton();
        radPhongThuongGia = new javax.swing.JRadioButton();
        radPhongTrong = new javax.swing.JRadioButton();
        radPhongDaDat = new javax.swing.JRadioButton();
        radPhongDangThue = new javax.swing.JRadioButton();
        btnTimTheoDieuKien = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnResetTrangThai = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnNhanVien = new javax.swing.JPanel();
        pnLayOutNhanVien = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtNgayVaoLamNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoTenNhanVien = new javax.swing.JTextField();
        txtSoDienThoaiNhanVien = new javax.swing.JTextField();
        txtNgaySinhNhanVien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCanCuocCongDanNhanVien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnNgaySinhNhanVien = new giaodien.CustomClass.Button();
        btnNgayVaoLamNhanVien = new giaodien.CustomClass.Button();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxChucVuNhanVien = new javax.swing.JComboBox<>();
        btnCapNhapNhanVien = new javax.swing.JButton();
        btnTamChoNghiNhanVien = new javax.swing.JButton();
        btnThemNhanVien = new javax.swing.JButton();
        btnXoaTrangNhanVien = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtEmailNhanVien1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableNhanVien = new javax.swing.JTable();
        pnDichVu = new javax.swing.JPanel();
        pnLayOutDichVu = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaDichVu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTenDichVu = new javax.swing.JTextField();
        txtDonGiaDichVu = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnCapNhapDichVu = new javax.swing.JButton();
        btnThemDichVu = new javax.swing.JButton();
        btnXoaTrangDichVu = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableDichVu = new javax.swing.JTable();
        pnKhuyenMai = new javax.swing.JPanel();
        pnLayOutKhuyenMai = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        txtNgayBatDauKhuyenMai = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTenKhuyenMai = new javax.swing.JTextField();
        txtNgayKetThucKhuyenMai = new javax.swing.JTextField();
        txtGiaTriKhuyenMai = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnThoiGianKetThucKhuyenMai = new giaodien.CustomClass.Button();
        btnThoiGianBatDauKhuyenMai = new giaodien.CustomClass.Button();
        btnCapNhapKhuyenMai = new javax.swing.JButton();
        btnNgungKhuyenMai = new javax.swing.JButton();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnXoaTrangKhuyenMai = new javax.swing.JButton();
        cbxDieuKienApDungKhuyenMai = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableKhuyenMai = new javax.swing.JTable();
        pnKhachHang = new javax.swing.JPanel();
        pnLayOutKhachKhachHang = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtChiTieuKhachHang = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoaiKhachHang = new javax.swing.JTextField();
        txtNgaySinhKhachHang = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCanCuocKhachHang = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        btnNgaySinhNhanVien3 = new giaodien.CustomClass.Button();
        jLabel34 = new javax.swing.JLabel();
        cbxGioiTinhKhachHang = new javax.swing.JComboBox<>();
        btnCapNhapKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtQuocTichKhachHang = new javax.swing.JTextField();
        txtHangThanhVien = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableKhachHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnHeader.setBackground(new java.awt.Color(34, 124, 157));
        pnHeader.setPreferredSize(new java.awt.Dimension(1553, 80));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-log-out-32.png"))); // NOI18N
        jButton9.setPreferredSize(new java.awt.Dimension(36, 36));

        jPanel5.setBackground(new java.awt.Color(34, 124, 157));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(pnHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, -1));

        pnMenu.setPreferredSize(new java.awt.Dimension(240, 800));

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        jPanel1.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        pnedUngDung.setBackground(new java.awt.Color(255, 153, 102));

        pnBody1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trang chủ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        Tang1_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong2.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong2.setText("101TC");

        lblLoaiPhong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong2.setText("Tiêu chuẩn");

        lblTrangThai2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai2.setText("Đang thuê");

        javax.swing.GroupLayout phong2Layout = new javax.swing.GroupLayout(phong2);
        phong2.setLayout(phong2Layout);
        phong2Layout.setHorizontalGroup(
            phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong2Layout.setVerticalGroup(
            phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai2)
                .addContainerGap())
        );

        phong3.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong3.setText("102NC");

        lblLoaiPhong3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong3.setText("Nâng cao");

        lblTrangThai3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai3.setText("Đang trống");

        javax.swing.GroupLayout phong3Layout = new javax.swing.GroupLayout(phong3);
        phong3.setLayout(phong3Layout);
        phong3Layout.setHorizontalGroup(
            phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong3Layout.setVerticalGroup(
            phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai3)
                .addContainerGap())
        );

        phong4.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong4.setText("103CC");

        lblLoaiPhong4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong4.setText("Cao cấp");

        lblTrangThai4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai4.setText("Đã đặt");

        javax.swing.GroupLayout phong4Layout = new javax.swing.GroupLayout(phong4);
        phong4.setLayout(phong4Layout);
        phong4Layout.setHorizontalGroup(
            phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong4Layout.setVerticalGroup(
            phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai4)
                .addContainerGap())
        );

        phong5.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong5.setText("109TC");

        lblLoaiPhong5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong5.setText("Thương gia");

        lblTrangThai5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai5.setText("Đang thuê");

        javax.swing.GroupLayout phong5Layout = new javax.swing.GroupLayout(phong5);
        phong5.setLayout(phong5Layout);
        phong5Layout.setHorizontalGroup(
            phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong5Layout.setVerticalGroup(
            phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai5)
                .addContainerGap())
        );

        phong6.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong6.setText("102TC");

        lblLoaiPhong6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong6.setText("Tiêu chuẩn");

        lblTrangThai6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai6.setText("Trạng thái");

        javax.swing.GroupLayout phong6Layout = new javax.swing.GroupLayout(phong6);
        phong6.setLayout(phong6Layout);
        phong6Layout.setHorizontalGroup(
            phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai6, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong6Layout.setVerticalGroup(
            phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai6)
                .addContainerGap())
        );

        phong9.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong9.setText("Tên phòng");

        lblLoaiPhong9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong9.setText("Loại phòng");

        lblTrangThai9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai9.setText("Trạng thái");

        javax.swing.GroupLayout phong9Layout = new javax.swing.GroupLayout(phong9);
        phong9.setLayout(phong9Layout);
        phong9Layout.setHorizontalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong9, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(phong9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong9Layout.setVerticalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phong10.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong10.setText("Tên phòng");

        lblLoaiPhong10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong10.setText("Loại phòng");

        lblTrangThai10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai10.setText("Trạng thái");

        javax.swing.GroupLayout phong10Layout = new javax.swing.GroupLayout(phong10);
        phong10.setLayout(phong10Layout);
        phong10Layout.setHorizontalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong10, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong10Layout.setVerticalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai10)
                .addContainerGap())
        );

        phong11.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong11.setText("Tên phòng");

        lblLoaiPhong11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong11.setText("Loại phòng");

        lblTrangThai11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai11.setText("Trạng thái");

        javax.swing.GroupLayout phong11Layout = new javax.swing.GroupLayout(phong11);
        phong11.setLayout(phong11Layout);
        phong11Layout.setHorizontalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong11, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(phong11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong11Layout.setVerticalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phong13.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong13.setText("Tên phòng");

        lblLoaiPhong13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong13.setText("Loại phòng");

        lblTrangThai13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai13.setText("Trạng thái");

        javax.swing.GroupLayout phong13Layout = new javax.swing.GroupLayout(phong13);
        phong13.setLayout(phong13Layout);
        phong13Layout.setHorizontalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong13, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(phong13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong13Layout.setVerticalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phong14.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong14.setText("Tên phòng");

        lblLoaiPhong14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong14.setText("Loại phòng");

        lblTrangThai14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai14.setText("Trạng thái");

        javax.swing.GroupLayout phong14Layout = new javax.swing.GroupLayout(phong14);
        phong14.setLayout(phong14Layout);
        phong14Layout.setHorizontalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong14, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong14Layout.setVerticalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai14)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(phong14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChuLayout = new javax.swing.GroupLayout(Tang1_TrangChu);
        Tang1_TrangChu.setLayout(Tang1_TrangChuLayout);
        Tang1_TrangChuLayout.setHorizontalGroup(
            Tang1_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1_TrangChuLayout.setVerticalGroup(
            Tang1_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Tang2_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang2_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong17.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong17.setText("Tên phòng");

        lblLoaiPhong17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong17.setText("Loại phòng");

        lblTrangThai17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai17.setText("Trạng thái");

        javax.swing.GroupLayout phong17Layout = new javax.swing.GroupLayout(phong17);
        phong17.setLayout(phong17Layout);
        phong17Layout.setHorizontalGroup(
            phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong17, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong17Layout.setVerticalGroup(
            phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai17)
                .addContainerGap())
        );

        phong18.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong18.setText("Tên phòng");

        lblLoaiPhong18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong18.setText("Loại phòng");

        lblTrangThai18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai18.setText("Trạng thái");

        javax.swing.GroupLayout phong18Layout = new javax.swing.GroupLayout(phong18);
        phong18.setLayout(phong18Layout);
        phong18Layout.setHorizontalGroup(
            phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong18, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong18Layout.setVerticalGroup(
            phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai18)
                .addContainerGap())
        );

        phong19.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong19.setText("Tên phòng");

        lblLoaiPhong19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong19.setText("Loại phòng");

        lblTrangThai19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai19.setText("Trạng thái");

        javax.swing.GroupLayout phong19Layout = new javax.swing.GroupLayout(phong19);
        phong19.setLayout(phong19Layout);
        phong19Layout.setHorizontalGroup(
            phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong19, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong19Layout.setVerticalGroup(
            phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai19)
                .addContainerGap())
        );

        phong20.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong20.setText("Tên phòng");

        lblLoaiPhong20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong20.setText("Loại phòng");

        lblTrangThai20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai20.setText("Trạng thái");

        javax.swing.GroupLayout phong20Layout = new javax.swing.GroupLayout(phong20);
        phong20.setLayout(phong20Layout);
        phong20Layout.setHorizontalGroup(
            phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong20, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong20Layout.setVerticalGroup(
            phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTenPhong20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai20)
                .addContainerGap())
        );

        phong21.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong21.setText("Tên phòng");

        lblLoaiPhong21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong21.setText("Loại phòng");

        lblTrangThai21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai21.setText("Trạng thái");

        javax.swing.GroupLayout phong21Layout = new javax.swing.GroupLayout(phong21);
        phong21.setLayout(phong21Layout);
        phong21Layout.setHorizontalGroup(
            phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong21, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong21Layout.setVerticalGroup(
            phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai21)
                .addContainerGap())
        );

        phong24.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong24.setText("Tên phòng");

        lblLoaiPhong24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong24.setText("Loại phòng");

        lblTrangThai24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai24.setText("Trạng thái");

        javax.swing.GroupLayout phong24Layout = new javax.swing.GroupLayout(phong24);
        phong24.setLayout(phong24Layout);
        phong24Layout.setHorizontalGroup(
            phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong24, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong24Layout.setVerticalGroup(
            phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTrangThai24)
                .addContainerGap())
        );

        phong25.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong25.setText("Tên phòng");

        lblLoaiPhong25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong25.setText("Loại phòng");

        lblTrangThai25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai25.setText("Trạng thái");

        javax.swing.GroupLayout phong25Layout = new javax.swing.GroupLayout(phong25);
        phong25.setLayout(phong25Layout);
        phong25Layout.setHorizontalGroup(
            phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong25, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong25Layout.setVerticalGroup(
            phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai25)
                .addContainerGap())
        );

        phong26.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong26.setText("Tên phòng");

        lblTrangThai26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai26.setText("Trạng thái");

        javax.swing.GroupLayout phong26Layout = new javax.swing.GroupLayout(phong26);
        phong26.setLayout(phong26Layout);
        phong26Layout.setHorizontalGroup(
            phong26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangThai26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblTenPhong26, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong26Layout.setVerticalGroup(
            phong26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong26Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTenPhong26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai26)
                .addContainerGap())
        );

        phong27.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong27.setText("Tên phòng");

        lblLoaiPhong27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong27.setText("Loại phòng");

        lblTrangThai27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai27.setText("Trạng thái");

        lblLoaiPhong26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong26.setText("Loại phòng");

        javax.swing.GroupLayout phong27Layout = new javax.swing.GroupLayout(phong27);
        phong27.setLayout(phong27Layout);
        phong27Layout.setHorizontalGroup(
            phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong26, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong27, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(lblTrangThai27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong27Layout.setVerticalGroup(
            phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoaiPhong27)
                    .addComponent(lblLoaiPhong26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai27)
                .addContainerGap())
        );

        phong28.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong28.setText("Tên phòng");

        lblLoaiPhong28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong28.setText("Loại phòng");

        lblTrangThai28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai28.setText("Trạng thái");

        javax.swing.GroupLayout phong28Layout = new javax.swing.GroupLayout(phong28);
        phong28.setLayout(phong28Layout);
        phong28Layout.setHorizontalGroup(
            phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong28, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong28Layout.setVerticalGroup(
            phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai28)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(phong17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(phong24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang2_TrangChuLayout = new javax.swing.GroupLayout(Tang2_TrangChu);
        Tang2_TrangChu.setLayout(Tang2_TrangChuLayout);
        Tang2_TrangChuLayout.setHorizontalGroup(
            Tang2_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        Tang2_TrangChuLayout.setVerticalGroup(
            Tang2_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tang3_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang3_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong31.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong31.setText("Tên phòng");

        lblLoaiPhong31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong31.setText("Loại phòng");

        lblTrangThai31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai31.setText("Trạng thái");

        javax.swing.GroupLayout phong31Layout = new javax.swing.GroupLayout(phong31);
        phong31.setLayout(phong31Layout);
        phong31Layout.setHorizontalGroup(
            phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong31, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong31Layout.setVerticalGroup(
            phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai31)
                .addContainerGap())
        );

        phong32.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong32.setText("Tên phòng");

        lblLoaiPhong32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong32.setText("Loại phòng");

        lblTrangThai32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai32.setText("Trạng thái");

        javax.swing.GroupLayout phong32Layout = new javax.swing.GroupLayout(phong32);
        phong32.setLayout(phong32Layout);
        phong32Layout.setHorizontalGroup(
            phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong32, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong32Layout.setVerticalGroup(
            phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai32)
                .addContainerGap())
        );

        phong33.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong33.setText("Tên phòng");

        lblLoaiPhong33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong33.setText("Loại phòng");

        lblTrangThai33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai33.setText("Trạng thái");

        javax.swing.GroupLayout phong33Layout = new javax.swing.GroupLayout(phong33);
        phong33.setLayout(phong33Layout);
        phong33Layout.setHorizontalGroup(
            phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong33, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong33Layout.setVerticalGroup(
            phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai33)
                .addContainerGap())
        );

        phong34.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong34.setText("Tên phòng");

        lblLoaiPhong34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong34.setText("Loại phòng");

        lblTrangThai34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai34.setText("Trạng thái");

        javax.swing.GroupLayout phong34Layout = new javax.swing.GroupLayout(phong34);
        phong34.setLayout(phong34Layout);
        phong34Layout.setHorizontalGroup(
            phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong34, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong34Layout.setVerticalGroup(
            phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai34)
                .addContainerGap())
        );

        phong35.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong35.setText("Tên phòng");

        lblLoaiPhong35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong35.setText("Loại phòng");

        lblTrangThai35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai35.setText("Trạng thái");

        javax.swing.GroupLayout phong35Layout = new javax.swing.GroupLayout(phong35);
        phong35.setLayout(phong35Layout);
        phong35Layout.setHorizontalGroup(
            phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong35, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong35Layout.setVerticalGroup(
            phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTrangThai35)
                .addContainerGap())
        );

        phong38.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong38.setText("Tên phòng");

        lblLoaiPhong38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong38.setText("Loại phòng");

        lblTrangThai38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai38.setText("Trạng thái");

        javax.swing.GroupLayout phong38Layout = new javax.swing.GroupLayout(phong38);
        phong38.setLayout(phong38Layout);
        phong38Layout.setHorizontalGroup(
            phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong38, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong38Layout.setVerticalGroup(
            phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTenPhong38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai38)
                .addContainerGap())
        );

        phong39.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong39.setText("Tên phòng");

        lblLoaiPhong39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong39.setText("Loại phòng");

        lblTrangThai39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai39.setText("Trạng thái");

        javax.swing.GroupLayout phong39Layout = new javax.swing.GroupLayout(phong39);
        phong39.setLayout(phong39Layout);
        phong39Layout.setHorizontalGroup(
            phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong39, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong39Layout.setVerticalGroup(
            phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai39)
                .addContainerGap())
        );

        phong40.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong40.setText("Tên phòng");

        lblLoaiPhong40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong40.setText("Loại phòng");

        lblTrangThai40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai40.setText("Trạng thái");

        javax.swing.GroupLayout phong40Layout = new javax.swing.GroupLayout(phong40);
        phong40.setLayout(phong40Layout);
        phong40Layout.setHorizontalGroup(
            phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong40, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong40Layout.setVerticalGroup(
            phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai40)
                .addContainerGap())
        );

        phong41.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong41.setText("Tên phòng");

        lblLoaiPhong41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong41.setText("Loại phòng");

        lblTrangThai41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai41.setText("Trạng thái");

        javax.swing.GroupLayout phong41Layout = new javax.swing.GroupLayout(phong41);
        phong41.setLayout(phong41Layout);
        phong41Layout.setHorizontalGroup(
            phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong41, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong41Layout.setVerticalGroup(
            phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai41)
                .addContainerGap())
        );

        phong42.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong42.setText("Tên phòng");

        lblLoaiPhong42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong42.setText("Loại phòng");

        lblTrangThai42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai42.setText("Trạng thái");

        javax.swing.GroupLayout phong42Layout = new javax.swing.GroupLayout(phong42);
        phong42.setLayout(phong42Layout);
        phong42Layout.setHorizontalGroup(
            phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong42, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong42Layout.setVerticalGroup(
            phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai42)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang3_TrangChuLayout = new javax.swing.GroupLayout(Tang3_TrangChu);
        Tang3_TrangChu.setLayout(Tang3_TrangChuLayout);
        Tang3_TrangChuLayout.setHorizontalGroup(
            Tang3_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang3_TrangChuLayout.setVerticalGroup(
            Tang3_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Tang4_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang4_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tầng 4", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong36.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong36.setText("Tên phòng");

        lblLoaiPhong36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong36.setText("Loại phòng");

        lblTrangThai36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai36.setText("Trạng thái");

        javax.swing.GroupLayout phong36Layout = new javax.swing.GroupLayout(phong36);
        phong36.setLayout(phong36Layout);
        phong36Layout.setHorizontalGroup(
            phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong36, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong36Layout.setVerticalGroup(
            phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai36)
                .addContainerGap())
        );

        phong37.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong37.setText("Tên phòng");

        lblLoaiPhong37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong37.setText("Loại phòng");

        lblTrangThai37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai37.setText("Trạng thái");

        javax.swing.GroupLayout phong37Layout = new javax.swing.GroupLayout(phong37);
        phong37.setLayout(phong37Layout);
        phong37Layout.setHorizontalGroup(
            phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong37, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong37Layout.setVerticalGroup(
            phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai37)
                .addContainerGap())
        );

        phong48.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong48.setText("Tên phòng");

        lblLoaiPhong48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong48.setText("Loại phòng");

        lblTrangThai48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai48.setText("Trạng thái");

        javax.swing.GroupLayout phong48Layout = new javax.swing.GroupLayout(phong48);
        phong48.setLayout(phong48Layout);
        phong48Layout.setHorizontalGroup(
            phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong48, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong48Layout.setVerticalGroup(
            phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai48)
                .addContainerGap())
        );

        phong49.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong49.setText("Tên phòng");

        lblLoaiPhong49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong49.setText("Loại phòng");

        lblTrangThai49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai49.setText("Trạng thái");

        javax.swing.GroupLayout phong49Layout = new javax.swing.GroupLayout(phong49);
        phong49.setLayout(phong49Layout);
        phong49Layout.setHorizontalGroup(
            phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong49, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong49Layout.setVerticalGroup(
            phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai49)
                .addContainerGap())
        );

        phong50.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong50.setText("Tên phòng");

        lblLoaiPhong50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong50.setText("Loại phòng");

        lblTrangThai50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai50.setText("Trạng thái");

        javax.swing.GroupLayout phong50Layout = new javax.swing.GroupLayout(phong50);
        phong50.setLayout(phong50Layout);
        phong50Layout.setHorizontalGroup(
            phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong50, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong50Layout.setVerticalGroup(
            phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTrangThai50)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(phong36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang4_TrangChuLayout = new javax.swing.GroupLayout(Tang4_TrangChu);
        Tang4_TrangChu.setLayout(Tang4_TrangChuLayout);
        Tang4_TrangChuLayout.setHorizontalGroup(
            Tang4_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang4_TrangChuLayout.setVerticalGroup(
            Tang4_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tang4_TrangChuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnBody1Layout = new javax.swing.GroupLayout(pnBody1);
        pnBody1.setLayout(pnBody1Layout);
        pnBody1Layout.setHorizontalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tang3_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang2_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang4_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pnBody1Layout.setVerticalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang2_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang3_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang4_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ScrollPaneTrangChu.setViewportView(pnBody1);

        javax.swing.GroupLayout pnLayOutTrangChuLayout = new javax.swing.GroupLayout(pnLayOutTrangChu);
        pnLayOutTrangChu.setLayout(pnLayOutTrangChuLayout);
        pnLayOutTrangChuLayout.setHorizontalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnLayOutTrangChuLayout.setVerticalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnTrangChuLayout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(pnLayOutTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
            .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnTrangChuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnLayOutTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnedUngDung.addTab("tab1", pnTrangChu);

        pnBody2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tang1_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongQuanLy1.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL1.setText("101TC");

        lblLoaiPhongQL1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL1.setText("Tiêu chuẩn");

        lblTrangThaiQL1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL1.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy1Layout = new javax.swing.GroupLayout(phongQuanLy1);
        phongQuanLy1.setLayout(phongQuanLy1Layout);
        phongQuanLy1Layout.setHorizontalGroup(
            phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy1Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL1)))
                .addContainerGap())
        );
        phongQuanLy1Layout.setVerticalGroup(
            phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL1)
                    .addComponent(lblLoaiPhongQL1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL1)
                .addContainerGap())
        );

        phongQuanLy2.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL2.setText("101TC");

        lblLoaiPhongQL2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL2.setText("Tiêu chuẩn");

        lblTrangThaiQL2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL2.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy2Layout = new javax.swing.GroupLayout(phongQuanLy2);
        phongQuanLy2.setLayout(phongQuanLy2Layout);
        phongQuanLy2Layout.setHorizontalGroup(
            phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy2Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL2)))
                .addContainerGap())
        );
        phongQuanLy2Layout.setVerticalGroup(
            phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL2)
                    .addComponent(lblLoaiPhongQL2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL2)
                .addContainerGap())
        );

        phongQuanLy3.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL3.setText("101TC");

        lblLoaiPhongQL3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL3.setText("Tiêu chuẩn");

        lblTrangThaiQL3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL3.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy3Layout = new javax.swing.GroupLayout(phongQuanLy3);
        phongQuanLy3.setLayout(phongQuanLy3Layout);
        phongQuanLy3Layout.setHorizontalGroup(
            phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy3Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL3)))
                .addContainerGap())
        );
        phongQuanLy3Layout.setVerticalGroup(
            phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL3)
                    .addComponent(lblLoaiPhongQL3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL3)
                .addContainerGap())
        );

        phongQuanLy4.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL4.setText("101TC");

        lblLoaiPhongQL4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL4.setText("Tiêu chuẩn");

        lblTrangThaiQL4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL4.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy4Layout = new javax.swing.GroupLayout(phongQuanLy4);
        phongQuanLy4.setLayout(phongQuanLy4Layout);
        phongQuanLy4Layout.setHorizontalGroup(
            phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy4Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL4)))
                .addContainerGap())
        );
        phongQuanLy4Layout.setVerticalGroup(
            phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL4)
                    .addComponent(lblLoaiPhongQL4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL4)
                .addContainerGap())
        );

        phongQuanLy5.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL5.setText("101TC");

        lblLoaiPhongQL5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL5.setText("Thương gia");

        lblTrangThaiQL5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL5.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy5Layout = new javax.swing.GroupLayout(phongQuanLy5);
        phongQuanLy5.setLayout(phongQuanLy5Layout);
        phongQuanLy5Layout.setHorizontalGroup(
            phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy5Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL5, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL5)))
                .addContainerGap())
        );
        phongQuanLy5Layout.setVerticalGroup(
            phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL5)
                    .addComponent(lblLoaiPhongQL5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL5)
                .addContainerGap())
        );

        phongQuanLy6.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL6.setText("101TC");

        lblLoaiPhongQL6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL6.setText("Tiêu chuẩn");

        lblTrangThaiQL6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL6.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy6Layout = new javax.swing.GroupLayout(phongQuanLy6);
        phongQuanLy6.setLayout(phongQuanLy6Layout);
        phongQuanLy6Layout.setHorizontalGroup(
            phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy6Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL6)))
                .addContainerGap())
        );
        phongQuanLy6Layout.setVerticalGroup(
            phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkBoxPhongQL6)
                    .addComponent(lblLoaiPhongQL6))
                .addGap(13, 13, 13)
                .addComponent(lblTenPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL6)
                .addContainerGap())
        );

        phongQuanLy7.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL7.setText("101TC");

        lblLoaiPhongQL7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL7.setText("Tiêu chuẩn");

        lblTrangThaiQL7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL7.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy7Layout = new javax.swing.GroupLayout(phongQuanLy7);
        phongQuanLy7.setLayout(phongQuanLy7Layout);
        phongQuanLy7Layout.setHorizontalGroup(
            phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy7Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL7)))
                .addContainerGap())
        );
        phongQuanLy7Layout.setVerticalGroup(
            phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL7)
                    .addComponent(lblLoaiPhongQL7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL7)
                .addContainerGap())
        );

        phongQuanLy8.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL8.setText("101TC");

        lblLoaiPhongQL8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL8.setText("Tiêu chuẩn");

        lblTrangThaiQL8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL8.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy8Layout = new javax.swing.GroupLayout(phongQuanLy8);
        phongQuanLy8.setLayout(phongQuanLy8Layout);
        phongQuanLy8Layout.setHorizontalGroup(
            phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy8Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL8)))
                .addContainerGap())
        );
        phongQuanLy8Layout.setVerticalGroup(
            phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL8)
                    .addComponent(lblLoaiPhongQL8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL8)
                .addContainerGap())
        );

        phongQuanLy9.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL9.setText("101TC");

        lblLoaiPhongQL9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL9.setText("Tiêu chuẩn");

        lblTrangThaiQL9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL9.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy9Layout = new javax.swing.GroupLayout(phongQuanLy9);
        phongQuanLy9.setLayout(phongQuanLy9Layout);
        phongQuanLy9Layout.setHorizontalGroup(
            phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy9Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL9, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL9)))
                .addContainerGap())
        );
        phongQuanLy9Layout.setVerticalGroup(
            phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL9)
                    .addComponent(lblLoaiPhongQL9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL9)
                .addContainerGap())
        );

        phongQuanLy10.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL10.setText("101TC");

        lblLoaiPhongQL10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL10.setText("Thương gia");

        lblTrangThaiQL10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL10.setText("Đã đặt");

        javax.swing.GroupLayout phongQuanLy10Layout = new javax.swing.GroupLayout(phongQuanLy10);
        phongQuanLy10.setLayout(phongQuanLy10Layout);
        phongQuanLy10Layout.setHorizontalGroup(
            phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy10Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL10, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL10)))
                .addContainerGap())
        );
        phongQuanLy10Layout.setVerticalGroup(
            phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL10)
                    .addComponent(lblLoaiPhongQL10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phongQuanLy1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phongQuanLy2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phongQuanLy3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phongQuanLy6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang1_QuanLyPhong);
        Tang1_QuanLyPhong.setLayout(Tang1_QuanLyPhongLayout);
        Tang1_QuanLyPhongLayout.setHorizontalGroup(
            Tang1_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang1_QuanLyPhongLayout.setVerticalGroup(
            Tang1_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Tang2_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang2_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongQuanLy11.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL11.setText("101TC");

        lblLoaiPhongQL11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL11.setText("Tiêu chuẩn");

        lblTrangThaiQL11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL11.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy11Layout = new javax.swing.GroupLayout(phongQuanLy11);
        phongQuanLy11.setLayout(phongQuanLy11Layout);
        phongQuanLy11Layout.setHorizontalGroup(
            phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy11Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL11, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL11)))
                .addContainerGap())
        );
        phongQuanLy11Layout.setVerticalGroup(
            phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL11)
                    .addComponent(lblLoaiPhongQL11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL11)
                .addContainerGap())
        );

        phongQuanLy12.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL12.setText("101TC");

        lblLoaiPhongQL12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL12.setText("Thương gia");

        lblTrangThaiQL12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL12.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy12Layout = new javax.swing.GroupLayout(phongQuanLy12);
        phongQuanLy12.setLayout(phongQuanLy12Layout);
        phongQuanLy12Layout.setHorizontalGroup(
            phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy12Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL12)))
                .addContainerGap())
        );
        phongQuanLy12Layout.setVerticalGroup(
            phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL12)
                    .addComponent(lblLoaiPhongQL12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL12)
                .addContainerGap())
        );

        phongQuanLy13.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL13.setText("101TC");

        lblLoaiPhongQL13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL13.setText("Nâng cao");

        lblTrangThaiQL13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL13.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy13Layout = new javax.swing.GroupLayout(phongQuanLy13);
        phongQuanLy13.setLayout(phongQuanLy13Layout);
        phongQuanLy13Layout.setHorizontalGroup(
            phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy13Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL13)))
                .addContainerGap())
        );
        phongQuanLy13Layout.setVerticalGroup(
            phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL13)
                    .addComponent(lblLoaiPhongQL13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL13)
                .addContainerGap())
        );

        phongQuanLy14.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL14.setText("101TC");

        lblLoaiPhongQL14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL14.setText("Nâng cao");

        lblTrangThaiQL14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL14.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy14Layout = new javax.swing.GroupLayout(phongQuanLy14);
        phongQuanLy14.setLayout(phongQuanLy14Layout);
        phongQuanLy14Layout.setHorizontalGroup(
            phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy14Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL14)))
                .addContainerGap())
        );
        phongQuanLy14Layout.setVerticalGroup(
            phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL14)
                    .addComponent(lblLoaiPhongQL14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL14)
                .addContainerGap())
        );

        phongQuanLy15.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL15.setText("101TC");

        lblLoaiPhongQL15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL15.setText("Thương gia");

        lblTrangThaiQL15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL15.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy15Layout = new javax.swing.GroupLayout(phongQuanLy15);
        phongQuanLy15.setLayout(phongQuanLy15Layout);
        phongQuanLy15Layout.setHorizontalGroup(
            phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy15Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL15)))
                .addContainerGap())
        );
        phongQuanLy15Layout.setVerticalGroup(
            phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL15)
                    .addComponent(lblLoaiPhongQL15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL15)
                .addContainerGap())
        );

        phongQuanLy16.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL16.setText("101TC");

        lblLoaiPhongQL16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL16.setText("Cao cấp");

        lblTrangThaiQL16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL16.setText("Đặt đặt");

        javax.swing.GroupLayout phongQuanLy16Layout = new javax.swing.GroupLayout(phongQuanLy16);
        phongQuanLy16.setLayout(phongQuanLy16Layout);
        phongQuanLy16Layout.setHorizontalGroup(
            phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy16Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL16, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL16)))
                .addContainerGap())
        );
        phongQuanLy16Layout.setVerticalGroup(
            phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL16)
                    .addComponent(lblLoaiPhongQL16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL16)
                .addContainerGap())
        );

        phongQuanLy17.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL17.setText("101TC");

        lblLoaiPhongQL17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL17.setText("Tiêu chuẩn");

        lblTrangThaiQL17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL17.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy17Layout = new javax.swing.GroupLayout(phongQuanLy17);
        phongQuanLy17.setLayout(phongQuanLy17Layout);
        phongQuanLy17Layout.setHorizontalGroup(
            phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy17Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL17, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL17)))
                .addContainerGap())
        );
        phongQuanLy17Layout.setVerticalGroup(
            phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL17)
                    .addComponent(lblLoaiPhongQL17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL17)
                .addContainerGap())
        );

        phongQuanLy18.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL18.setText("101TC");

        lblLoaiPhongQL18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL18.setText("Tiêu chuẩn");

        lblTrangThaiQL18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL18.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy18Layout = new javax.swing.GroupLayout(phongQuanLy18);
        phongQuanLy18.setLayout(phongQuanLy18Layout);
        phongQuanLy18Layout.setHorizontalGroup(
            phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy18Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL18, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL18)))
                .addContainerGap())
        );
        phongQuanLy18Layout.setVerticalGroup(
            phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL18)
                    .addComponent(lblLoaiPhongQL18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL18)
                .addContainerGap())
        );

        phongQuanLy19.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL19.setText("101TC");

        lblLoaiPhongQL19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL19.setText("Cao cấp");

        lblTrangThaiQL19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL19.setText("Đang trống");

        javax.swing.GroupLayout phongQuanLy19Layout = new javax.swing.GroupLayout(phongQuanLy19);
        phongQuanLy19.setLayout(phongQuanLy19Layout);
        phongQuanLy19Layout.setHorizontalGroup(
            phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy19Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL19, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL19)))
                .addContainerGap())
        );
        phongQuanLy19Layout.setVerticalGroup(
            phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL19)
                    .addComponent(lblLoaiPhongQL19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL19)
                .addContainerGap())
        );

        phongQuanLy20.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL20.setText("101TC");

        lblLoaiPhongQL20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL20.setText("Tiêu chuẩn");

        lblTrangThaiQL20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL20.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy20Layout = new javax.swing.GroupLayout(phongQuanLy20);
        phongQuanLy20.setLayout(phongQuanLy20Layout);
        phongQuanLy20Layout.setHorizontalGroup(
            phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy20Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL20)))
                .addContainerGap())
        );
        phongQuanLy20Layout.setVerticalGroup(
            phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL20)
                    .addComponent(lblLoaiPhongQL20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL20)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(phongQuanLy16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang2_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang2_QuanLyPhong);
        Tang2_QuanLyPhong.setLayout(Tang2_QuanLyPhongLayout);
        Tang2_QuanLyPhongLayout.setHorizontalGroup(
            Tang2_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang2_QuanLyPhongLayout.setVerticalGroup(
            Tang2_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Tang3_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang3_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongQuanLy21.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL21.setText("101TC");

        lblLoaiPhongQL21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL21.setText("Tiêu chuẩn");

        lblTrangThaiQL21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL21.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy21Layout = new javax.swing.GroupLayout(phongQuanLy21);
        phongQuanLy21.setLayout(phongQuanLy21Layout);
        phongQuanLy21Layout.setHorizontalGroup(
            phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy21Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL21)))
                .addContainerGap())
        );
        phongQuanLy21Layout.setVerticalGroup(
            phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL21)
                    .addComponent(lblLoaiPhongQL21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL21)
                .addContainerGap())
        );

        phongQuanLy22.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL22.setText("101TC");

        lblLoaiPhongQL22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL22.setText("Nâng cao");

        lblTrangThaiQL22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL22.setText("Đã đặt");

        javax.swing.GroupLayout phongQuanLy22Layout = new javax.swing.GroupLayout(phongQuanLy22);
        phongQuanLy22.setLayout(phongQuanLy22Layout);
        phongQuanLy22Layout.setHorizontalGroup(
            phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy22Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL22, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL22)))
                .addContainerGap())
        );
        phongQuanLy22Layout.setVerticalGroup(
            phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL22)
                    .addComponent(lblLoaiPhongQL22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL22)
                .addContainerGap())
        );

        phongQuanLy23.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL23.setText("101TC");

        lblLoaiPhongQL23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL23.setText("Tiêu chuẩn");

        lblTrangThaiQL23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL23.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy23Layout = new javax.swing.GroupLayout(phongQuanLy23);
        phongQuanLy23.setLayout(phongQuanLy23Layout);
        phongQuanLy23Layout.setHorizontalGroup(
            phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy23Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL23, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL23)))
                .addContainerGap())
        );
        phongQuanLy23Layout.setVerticalGroup(
            phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL23)
                    .addComponent(lblLoaiPhongQL23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL23)
                .addContainerGap())
        );

        phongQuanLy24.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL24.setText("101TC");

        lblLoaiPhongQL24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL24.setText("Tiêu chuẩn");

        lblTrangThaiQL24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL24.setText("Đã đặt");

        javax.swing.GroupLayout phongQuanLy24Layout = new javax.swing.GroupLayout(phongQuanLy24);
        phongQuanLy24.setLayout(phongQuanLy24Layout);
        phongQuanLy24Layout.setHorizontalGroup(
            phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy24Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL24)))
                .addContainerGap())
        );
        phongQuanLy24Layout.setVerticalGroup(
            phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL24)
                    .addComponent(lblLoaiPhongQL24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL24)
                .addContainerGap())
        );

        phongQuanLy25.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL25.setText("101TC");

        lblLoaiPhongQL25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL25.setText("Tiêu chuẩn");

        lblTrangThaiQL25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL25.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy25Layout = new javax.swing.GroupLayout(phongQuanLy25);
        phongQuanLy25.setLayout(phongQuanLy25Layout);
        phongQuanLy25Layout.setHorizontalGroup(
            phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy25Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL25, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL25)))
                .addContainerGap())
        );
        phongQuanLy25Layout.setVerticalGroup(
            phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL25)
                    .addComponent(lblLoaiPhongQL25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL25)
                .addContainerGap())
        );

        phongQuanLy26.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL26.setText("101TC");

        lblLoaiPhongQL26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL26.setText("Nâng cao");

        lblTrangThaiQL26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL26.setText("Đang trống");

        javax.swing.GroupLayout phongQuanLy26Layout = new javax.swing.GroupLayout(phongQuanLy26);
        phongQuanLy26.setLayout(phongQuanLy26Layout);
        phongQuanLy26Layout.setHorizontalGroup(
            phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy26Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL26, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL26)))
                .addContainerGap())
        );
        phongQuanLy26Layout.setVerticalGroup(
            phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL26)
                    .addComponent(lblLoaiPhongQL26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL26)
                .addContainerGap())
        );

        phongQuanLy27.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL27.setText("101TC");

        lblLoaiPhongQL27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL27.setText("Thương gia");

        lblTrangThaiQL27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL27.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy27Layout = new javax.swing.GroupLayout(phongQuanLy27);
        phongQuanLy27.setLayout(phongQuanLy27Layout);
        phongQuanLy27Layout.setHorizontalGroup(
            phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy27Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL27, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL27)))
                .addContainerGap())
        );
        phongQuanLy27Layout.setVerticalGroup(
            phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL27)
                    .addComponent(lblLoaiPhongQL27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL27)
                .addContainerGap())
        );

        phongQuanLy28.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL28.setText("101TC");

        lblLoaiPhongQL28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL28.setText("Cao cấp");

        lblTrangThaiQL28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL28.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy28Layout = new javax.swing.GroupLayout(phongQuanLy28);
        phongQuanLy28.setLayout(phongQuanLy28Layout);
        phongQuanLy28Layout.setHorizontalGroup(
            phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy28Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL28)))
                .addContainerGap())
        );
        phongQuanLy28Layout.setVerticalGroup(
            phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL28)
                    .addComponent(lblLoaiPhongQL28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL28)
                .addContainerGap())
        );

        phongQuanLy29.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL29.setText("101TC");

        lblLoaiPhongQL29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL29.setText("Nâng cao");

        lblTrangThaiQL29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL29.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy29Layout = new javax.swing.GroupLayout(phongQuanLy29);
        phongQuanLy29.setLayout(phongQuanLy29Layout);
        phongQuanLy29Layout.setHorizontalGroup(
            phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy29Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL29, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL29)))
                .addContainerGap())
        );
        phongQuanLy29Layout.setVerticalGroup(
            phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL29)
                    .addComponent(lblLoaiPhongQL29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL29)
                .addContainerGap())
        );

        phongQuanLy30.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL30.setText("101TC");

        lblLoaiPhongQL30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL30.setText("Thương gia");

        lblTrangThaiQL30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL30.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy30Layout = new javax.swing.GroupLayout(phongQuanLy30);
        phongQuanLy30.setLayout(phongQuanLy30Layout);
        phongQuanLy30Layout.setHorizontalGroup(
            phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy30Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL30, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL30)))
                .addContainerGap())
        );
        phongQuanLy30Layout.setVerticalGroup(
            phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL30)
                    .addComponent(lblLoaiPhongQL30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL30)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(phongQuanLy30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(phongQuanLy26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang3_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang3_QuanLyPhong);
        Tang3_QuanLyPhong.setLayout(Tang3_QuanLyPhongLayout);
        Tang3_QuanLyPhongLayout.setHorizontalGroup(
            Tang3_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang3_QuanLyPhongLayout.setVerticalGroup(
            Tang3_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang4_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang4_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 4", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongQuanLy31.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL31.setText("101TC");

        lblLoaiPhongQL31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL31.setText("Tiêu chuẩn");

        lblTrangThaiQL31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL31.setText("Đang trống");

        javax.swing.GroupLayout phongQuanLy31Layout = new javax.swing.GroupLayout(phongQuanLy31);
        phongQuanLy31.setLayout(phongQuanLy31Layout);
        phongQuanLy31Layout.setHorizontalGroup(
            phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy31Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL31)))
                .addContainerGap())
        );
        phongQuanLy31Layout.setVerticalGroup(
            phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL31)
                    .addComponent(lblLoaiPhongQL31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL31)
                .addContainerGap())
        );

        phongQuanLy32.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL32.setText("101TC");

        lblLoaiPhongQL32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL32.setText("Thương gia");

        lblTrangThaiQL32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL32.setText("Đã đặt");

        javax.swing.GroupLayout phongQuanLy32Layout = new javax.swing.GroupLayout(phongQuanLy32);
        phongQuanLy32.setLayout(phongQuanLy32Layout);
        phongQuanLy32Layout.setHorizontalGroup(
            phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy32Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL32, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL32)))
                .addContainerGap())
        );
        phongQuanLy32Layout.setVerticalGroup(
            phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL32)
                    .addComponent(lblLoaiPhongQL32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL32)
                .addContainerGap())
        );

        phongQuanLy33.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL33.setText("101TC");

        lblLoaiPhongQL33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL33.setText("Tiêu chuẩn");

        lblTrangThaiQL33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL33.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy33Layout = new javax.swing.GroupLayout(phongQuanLy33);
        phongQuanLy33.setLayout(phongQuanLy33Layout);
        phongQuanLy33Layout.setHorizontalGroup(
            phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy33Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL33, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL33)))
                .addContainerGap())
        );
        phongQuanLy33Layout.setVerticalGroup(
            phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL33)
                    .addComponent(lblLoaiPhongQL33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL33)
                .addContainerGap())
        );

        phongQuanLy34.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL34.setText("101TC");

        lblLoaiPhongQL34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL34.setText("Tiêu chuẩn");

        lblTrangThaiQL34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL34.setText("Đã đặt");

        javax.swing.GroupLayout phongQuanLy34Layout = new javax.swing.GroupLayout(phongQuanLy34);
        phongQuanLy34.setLayout(phongQuanLy34Layout);
        phongQuanLy34Layout.setHorizontalGroup(
            phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy34Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL34, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL34)))
                .addContainerGap())
        );
        phongQuanLy34Layout.setVerticalGroup(
            phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL34)
                    .addComponent(lblLoaiPhongQL34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL34)
                .addContainerGap())
        );

        phongQuanLy35.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhongQL35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongQL35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL35.setText("101TC");

        lblLoaiPhongQL35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhongQL35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL35.setText("Thương gia");

        lblTrangThaiQL35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiQL35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL35.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy35Layout = new javax.swing.GroupLayout(phongQuanLy35);
        phongQuanLy35.setLayout(phongQuanLy35Layout);
        phongQuanLy35Layout.setHorizontalGroup(
            phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenPhongQL35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy35Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL35, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL35)))
                .addContainerGap())
        );
        phongQuanLy35Layout.setVerticalGroup(
            phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL35)
                    .addComponent(lblLoaiPhongQL35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL35)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(phongQuanLy31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang4_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang4_QuanLyPhong);
        Tang4_QuanLyPhong.setLayout(Tang4_QuanLyPhongLayout);
        Tang4_QuanLyPhongLayout.setHorizontalGroup(
            Tang4_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang4_QuanLyPhongLayout.setVerticalGroup(
            Tang4_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnBody2Layout = new javax.swing.GroupLayout(pnBody2);
        pnBody2.setLayout(pnBody2Layout);
        pnBody2Layout.setHorizontalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tang1_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Tang4_QuanLyPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tang3_QuanLyPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tang2_QuanLyPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBody2Layout.setVerticalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Tang1_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang2_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang3_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang4_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ScrollPaneQuanLyPhong.setViewportView(pnBody2);

        funtionPanel.setBackground(new java.awt.Color(204, 255, 204));
        funtionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý phòng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbldate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldate.setText("Date");

        lbltime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltime.setText("Time");

        lblcurrentdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcurrentdate.setText("currentDate");

        lblcurrentTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcurrentTime.setText("currentTime");

        btnGROUPLoaiPhong.add(radPhongTieuChuan);
        radPhongTieuChuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongTieuChuan.setText("Phòng tiêu chuẩn");
        radPhongTieuChuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPhongTieuChuanActionPerformed(evt);
            }
        });

        btnGROUPLoaiPhong.add(radPhongNangCao);
        radPhongNangCao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongNangCao.setText("Phòng nâng cao");

        btnGROUPLoaiPhong.add(radPhongCaoCap);
        radPhongCaoCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongCaoCap.setText("Phòng cao cấp");

        btnGROUPLoaiPhong.add(radPhongThuongGia);
        radPhongThuongGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongThuongGia.setText("Phòng thương gia");

        btnGROUPTrangThai.add(radPhongTrong);
        radPhongTrong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongTrong.setText("Phòng trống");
        radPhongTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPhongTrongActionPerformed(evt);
            }
        });

        btnGROUPTrangThai.add(radPhongDaDat);
        radPhongDaDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongDaDat.setText("Phòng đã đặt");

        btnGROUPTrangThai.add(radPhongDangThue);
        radPhongDangThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongDangThue.setText("Phòng đang thuê");

        btnTimTheoDieuKien.setText("Tìm");
        btnTimTheoDieuKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTheoDieuKienActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tìm phòng theo trạng thái");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tìm phòng theo loại phòng");

        btnResetTrangThai.setText("Reset");
        btnResetTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTrangThaiActionPerformed(evt);
            }
        });

        jButton1.setText("Trả phòng");

        jButton2.setText("Đổi phòng");

        jButton3.setText("Hủy đặt phòng");

        jButton4.setText("Đặt phòng");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout funtionPanelLayout = new javax.swing.GroupLayout(funtionPanel);
        funtionPanel.setLayout(funtionPanelLayout);
        funtionPanelLayout.setHorizontalGroup(
            funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funtionPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcurrentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcurrentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radPhongTieuChuan)
                    .addComponent(radPhongNangCao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radPhongThuongGia)
                    .addComponent(radPhongCaoCap, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radPhongDangThue)
                    .addComponent(radPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(radPhongDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimTheoDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResetTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        funtionPanelLayout.setVerticalGroup(
            funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funtionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcurrentdate)
                    .addComponent(radPhongTieuChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radPhongTrong)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltime)
                    .addComponent(radPhongNangCao)
                    .addComponent(radPhongDangThue)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPhongCaoCap)
                    .addComponent(radPhongDaDat)
                    .addComponent(lblcurrentTime)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPhongThuongGia)
                    .addComponent(btnResetTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimTheoDieuKien))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnQuanLyPhongLayout = new javax.swing.GroupLayout(pnQuanLyPhong);
        pnQuanLyPhong.setLayout(pnQuanLyPhongLayout);
        pnQuanLyPhongLayout.setHorizontalGroup(
            pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPaneQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnQuanLyPhongLayout.setVerticalGroup(
            pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab2", pnQuanLyPhong);

        pnLayOutNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mã nhân viên");
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Giới tính");
        jLabel4.setToolTipText("");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ngày vào làm");
        jLabel5.setToolTipText("");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaNhanVien.setText("Mã nhân viên");
        txtMaNhanVien.setEnabled(false);

        txtNgayVaoLamNhanVien.setText("Ngày vào làm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Họ tên nhân viên");
        jLabel7.setToolTipText("");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Số điện thoại");
        jLabel8.setToolTipText("");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 21));

        txtHoTenNhanVien.setText("Họ tên nhân viên");

        txtSoDienThoaiNhanVien.setText("Số điện thoại nhân viên");

        txtNgaySinhNhanVien.setText("Ngày sinh nhân viên");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Ngày sinh");
        jLabel13.setToolTipText("");
        jLabel13.setPreferredSize(new java.awt.Dimension(120, 21));

        txtCanCuocCongDanNhanVien.setText("Căn cước công dân");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("CCCD");
        jLabel14.setToolTipText("");
        jLabel14.setPreferredSize(new java.awt.Dimension(120, 21));

        btnNgaySinhNhanVien.setBorder(null);
        btnNgaySinhNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgaySinhNhanVien.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgaySinhNhanVien.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgaySinhNhanVien.setRadius(20);
        btnNgaySinhNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgaySinhNhanVienActionPerformed(evt);
            }
        });

        btnNgayVaoLamNhanVien.setBorder(null);
        btnNgayVaoLamNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayVaoLamNhanVien.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayVaoLamNhanVien.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayVaoLamNhanVien.setRadius(20);
        btnNgayVaoLamNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayVaoLamNhanVienActionPerformed(evt);
            }
        });

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác", " " }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Chức vụ");
        jLabel9.setToolTipText("");
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 21));

        cbxChucVuNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên lễ tân", "Nhân viên quản lý", " " }));

        btnCapNhapNhanVien.setText("Cập nhập nhân viên");
        btnCapNhapNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapNhanVienActionPerformed(evt);
            }
        });

        btnTamChoNghiNhanVien.setText("Tạm cho nghỉ");
        btnTamChoNghiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamChoNghiNhanVienActionPerformed(evt);
            }
        });

        btnThemNhanVien.setText("Thêm nhân viên");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnXoaTrangNhanVien.setText("Xóa trắng");
        btnXoaTrangNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangNhanVienActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Email");
        jLabel15.setToolTipText("");
        jLabel15.setPreferredSize(new java.awt.Dimension(120, 21));

        txtEmailNhanVien1.setText("Email nhân viên");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(txtNgayVaoLamNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgayVaoLamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTenNhanVien)
                            .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(cbxChucVuNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(txtNgaySinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCanCuocCongDanNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailNhanVien1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaTrangNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(btnTamChoNghiNhanVien)))
                .addGap(65, 65, 65))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNgaySinhNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanCuocCongDanNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxChucVuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayVaoLamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNgayVaoLamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTamChoNghiNhanVien)
                    .addComponent(btnCapNhapNhanVien)
                    .addComponent(btnThemNhanVien)
                    .addComponent(btnXoaTrangNhanVien))
                .addGap(21, 21, 21))
        );

        TableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Ngày vào làm", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TableNhanVien);

        javax.swing.GroupLayout pnLayOutNhanVienLayout = new javax.swing.GroupLayout(pnLayOutNhanVien);
        pnLayOutNhanVien.setLayout(pnLayOutNhanVienLayout);
        pnLayOutNhanVienLayout.setHorizontalGroup(
            pnLayOutNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        pnLayOutNhanVienLayout.setVerticalGroup(
            pnLayOutNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab3", pnNhanVien);

        pnLayOutDichVu.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý dịch vụ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Mã dịch vụ");
        jLabel6.setToolTipText("");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaDichVu.setText("Mã dịch vụ");
        txtMaDichVu.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tên dịch vụ");
        jLabel12.setToolTipText("");
        jLabel12.setPreferredSize(new java.awt.Dimension(120, 21));

        txtTenDichVu.setText("Tên dịch vụ");

        txtDonGiaDichVu.setText("Đơn giá dịch vụ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Đơn giá dịch vụ");
        jLabel16.setToolTipText("");
        jLabel16.setPreferredSize(new java.awt.Dimension(120, 21));

        btnCapNhapDichVu.setText("Cập nhập dịch vụ");
        btnCapNhapDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapDichVuActionPerformed(evt);
            }
        });

        btnThemDichVu.setText("Thêm dịch vụ");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnXoaTrangDichVu.setText("Xóa trắng");
        btnXoaTrangDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDonGiaDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemDichVu)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapDichVu)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTrangDichVu)))
                .addGap(65, 65, 65))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCapNhapDichVu)
                            .addComponent(btnThemDichVu)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTrangDichVu))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        TableDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Đơn giá dịch vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TableDichVu);
        if (TableDichVu.getColumnModel().getColumnCount() > 0) {
            TableDichVu.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        javax.swing.GroupLayout pnLayOutDichVuLayout = new javax.swing.GroupLayout(pnLayOutDichVu);
        pnLayOutDichVu.setLayout(pnLayOutDichVuLayout);
        pnLayOutDichVuLayout.setHorizontalGroup(
            pnLayOutDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        pnLayOutDichVuLayout.setVerticalGroup(
            pnLayOutDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnDichVuLayout = new javax.swing.GroupLayout(pnDichVu);
        pnDichVu.setLayout(pnDichVuLayout);
        pnDichVuLayout.setHorizontalGroup(
            pnDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnDichVuLayout.setVerticalGroup(
            pnDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab4", pnDichVu);

        pnLayOutKhuyenMai.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý Khuyến Mãi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Mã khuyến mãi");
        jLabel19.setToolTipText("");
        jLabel19.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Thơi gian bắt đầu");
        jLabel20.setToolTipText("");
        jLabel20.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaKhuyenMai.setText("Mã khuyến mãi");

        txtNgayBatDauKhuyenMai.setText("Bắt đầu khuyến mãi");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Tên khuyến mãi");
        jLabel22.setToolTipText("");
        jLabel22.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Thời gian kết thúc");
        jLabel23.setToolTipText("");
        jLabel23.setPreferredSize(new java.awt.Dimension(120, 21));

        txtTenKhuyenMai.setText("Tên khuyến mãi");

        txtNgayKetThucKhuyenMai.setText("Kết thúc khuyến mãi");

        txtGiaTriKhuyenMai.setText("Giá trị khuyến mãi");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Giá trị khuyễn mãi");
        jLabel24.setToolTipText("");
        jLabel24.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Điều kiện áp dụng");
        jLabel25.setToolTipText("");
        jLabel25.setPreferredSize(new java.awt.Dimension(120, 21));

        btnThoiGianKetThucKhuyenMai.setBorder(null);
        btnThoiGianKetThucKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnThoiGianKetThucKhuyenMai.setBorderColor(new java.awt.Color(255, 255, 255));
        btnThoiGianKetThucKhuyenMai.setColorOver(new java.awt.Color(204, 204, 204));
        btnThoiGianKetThucKhuyenMai.setRadius(20);
        btnThoiGianKetThucKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiGianKetThucKhuyenMaiActionPerformed(evt);
            }
        });

        btnThoiGianBatDauKhuyenMai.setBorder(null);
        btnThoiGianBatDauKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnThoiGianBatDauKhuyenMai.setBorderColor(new java.awt.Color(255, 255, 255));
        btnThoiGianBatDauKhuyenMai.setColorOver(new java.awt.Color(204, 204, 204));
        btnThoiGianBatDauKhuyenMai.setRadius(20);
        btnThoiGianBatDauKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiGianBatDauKhuyenMaiActionPerformed(evt);
            }
        });

        btnCapNhapKhuyenMai.setText("Cập nhập khuyến mãi");

        btnNgungKhuyenMai.setText("Cho ngừng khuyễn mãi");

        btnThemKhuyenMai.setText("Thêm khuyến mãi");

        btnXoaTrangKhuyenMai.setText("Xóa trắng");

        cbxDieuKienApDungKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng hạng Vàng", "Khách hàng hạng Đồng", "Khách hàng hạng Kim Cương", "Loại phòng thương gia", "Loại phòng tiêu chuẩn", "Tổng hóa đơn trên 500.000VNĐ" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txtNgayBatDauKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThoiGianBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txtNgayKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThoiGianKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenKhuyenMai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaTriKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(cbxDieuKienApDungKhuyenMai, 0, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaTrangKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnNgungKhuyenMai)))
                .addGap(65, 65, 65))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThoiGianKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTriKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxDieuKienApDungKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThoiGianBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNgungKhuyenMai)
                    .addComponent(btnCapNhapKhuyenMai)
                    .addComponent(btnThemKhuyenMai)
                    .addComponent(btnXoaTrangKhuyenMai))
                .addGap(21, 21, 21))
        );

        TableKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Giá trị khuyến mãi", "Thời gian bắt đầu", "Thời gian kết thúc", "Điều kiện áp dụng", "Nhân viên tạo khuyến mãi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TableKhuyenMai);

        javax.swing.GroupLayout pnLayOutKhuyenMaiLayout = new javax.swing.GroupLayout(pnLayOutKhuyenMai);
        pnLayOutKhuyenMai.setLayout(pnLayOutKhuyenMaiLayout);
        pnLayOutKhuyenMaiLayout.setHorizontalGroup(
            pnLayOutKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        pnLayOutKhuyenMaiLayout.setVerticalGroup(
            pnLayOutKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnKhuyenMaiLayout = new javax.swing.GroupLayout(pnKhuyenMai);
        pnKhuyenMai.setLayout(pnKhuyenMaiLayout);
        pnKhuyenMaiLayout.setHorizontalGroup(
            pnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnKhuyenMaiLayout.setVerticalGroup(
            pnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab5", pnKhuyenMai);

        pnLayOutKhachKhachHang.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutKhachKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Mã khách hàng");
        jLabel27.setToolTipText("");
        jLabel27.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Giới tính");
        jLabel28.setToolTipText("");
        jLabel28.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Chi tiêu");
        jLabel29.setToolTipText("");
        jLabel29.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaKhachHang.setText("Mã khách hàng");
        txtMaKhachHang.setEnabled(false);

        txtChiTieuKhachHang.setText("5000000");
        txtChiTieuKhachHang.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Tên khách hàng");
        jLabel30.setToolTipText("");
        jLabel30.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Số điện thoại");
        jLabel31.setToolTipText("");
        jLabel31.setPreferredSize(new java.awt.Dimension(120, 21));

        txtTenKhachHang.setText("Tên khách hàng");

        txtSoDienThoaiKhachHang.setText("Số điện thoại");
        txtSoDienThoaiKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiKhachHangActionPerformed(evt);
            }
        });

        txtNgaySinhKhachHang.setText("Ngày sinh");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Ngày sinh");
        jLabel32.setToolTipText("");
        jLabel32.setPreferredSize(new java.awt.Dimension(120, 21));

        txtCanCuocKhachHang.setText("Căn cước");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("CCCD/VISA");
        jLabel33.setToolTipText("");
        jLabel33.setPreferredSize(new java.awt.Dimension(120, 21));

        btnNgaySinhNhanVien3.setBorder(null);
        btnNgaySinhNhanVien3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgaySinhNhanVien3.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgaySinhNhanVien3.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgaySinhNhanVien3.setRadius(20);
        btnNgaySinhNhanVien3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgaySinhNhanVien3ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Hạng thành viên");
        jLabel34.setToolTipText("");
        jLabel34.setPreferredSize(new java.awt.Dimension(120, 21));

        cbxGioiTinhKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        btnCapNhapKhachHang.setText("Cập nhập khách hàng");
        btnCapNhapKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapKhachHangActionPerformed(evt);
            }
        });

        btnThemKhachHang.setText("Thêm khách hàng");
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Quốc tịch");
        jLabel35.setToolTipText("");
        jLabel35.setPreferredSize(new java.awt.Dimension(120, 21));

        txtQuocTichKhachHang.setText("Quốc tịch");

        txtHangThanhVien.setText("Hạng thành viên");
        txtHangThanhVien.setEnabled(false);
        txtHangThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHangThanhVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtChiTieuKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHangThanhVien, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhachHang)
                            .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(cbxGioiTinhKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addComponent(txtNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgaySinhNhanVien3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCanCuocKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuocTichKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemKhachHang)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapKhachHang)))
                .addGap(65, 65, 65))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNgaySinhNhanVien3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanCuocKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxGioiTinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuocTichKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHangThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChiTieuKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhapKhachHang)
                    .addComponent(btnThemKhachHang))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        TableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "Ngày sinh", "Số điện thoại", "CCCD", "Chi tiêu", "Hạng thành viên", "Quốc tịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TableKhachHang);

        javax.swing.GroupLayout pnLayOutKhachKhachHangLayout = new javax.swing.GroupLayout(pnLayOutKhachKhachHang);
        pnLayOutKhachKhachHang.setLayout(pnLayOutKhachKhachHangLayout);
        pnLayOutKhachKhachHangLayout.setHorizontalGroup(
            pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhachKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        pnLayOutKhachKhachHangLayout.setVerticalGroup(
            pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhachKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab6", pnKhachHang);

        jPanel1.add(pnedUngDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 1280, 840));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHangThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHangThanhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHangThanhVienActionPerformed
    
    private String taoMaKhachHang() {
    	KhachHangDao khDao = new KhachHangDao();
    	int stt = khDao.demTongSoKhachHang();
    	String maKhachHang = "KH" + String.format("%05d", stt);
    	return maKhachHang;
    }
    
    private boolean regTen(String ten) {
		String regex = "^[A-Z][a-zA-Z]+\\s[A-Za-z]+$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ten);

		return matcher.matches();
	}

	private boolean regSoDienThoai(String soDienThoai) {
		String regex = "^0\\d{9}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(soDienThoai);

		return matcher.matches();
	}
	
	public boolean regCCCD_Visa(String cccd_visa) {
		 // Regex cho mã số CCCD hoặc Visa
        String regex = "^(\\d{12}|\\d{16})$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cccd_visa);
        
        return matcher.matches();
	}
	
	private boolean regEmail(String email) {
		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
	}

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
    	String tenKhachHang = txtTenKhachHang.getText();
    	// Kiểm tra tên
		if (regTen(tenKhachHang) == false) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không hợp lệ");
			return;
		}
    	String gioiTinh = cbxGioiTinhKhachHang.getSelectedItem().toString();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngaySinhKhachHangFormat = LocalDate.parse(txtNgaySinhNhanVien.getText(), formatter);
		LocalDate ngaySinh = LocalDate.of(ngaySinhKhachHangFormat.getYear(), ngaySinhKhachHangFormat.getMonth(),
				ngaySinhKhachHangFormat.getDayOfMonth());
		String soDienThoai = txtSoDienThoaiKhachHang.getText();
		// Kiểm tra số điện thoại
		if (regSoDienThoai(soDienThoai) == false) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			return;
		}
		String CCCD_Visa = txtCanCuocKhachHang.getText();
		// Kiểm tra CCCD / Visa
		if (regCCCD_Visa(CCCD_Visa) == false) {
			JOptionPane.showMessageDialog(null, "CCCD / Visa không hợp lệ");
			return;
		}
		double chiTieu = 0;
		HangThanhVienDao htvDao = new HangThanhVienDao();
		HangThanhVien hangTV = htvDao.timHangThanhVienTheoChiTieu(chiTieu);
		String quocTich = txtQuocTichKhachHang.getText();
		String maKhachHang = taoMaKhachHang();
		KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, soDienThoai, CCCD_Visa, chiTieu, hangTV, quocTich);
		KhachHangDao khDao = new KhachHangDao();
		boolean themKhachHang = khDao.themKhachHang(kh);
		if (themKhachHang) {
			JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại");
		}
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void btnCapNhapKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhapKhachHangActionPerformed

	private void radPhongTieuChuanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radPhongTieuChuanActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_radPhongTieuChuanActionPerformed

	private void radPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radPhongTrongActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_radPhongTrongActionPerformed

	private void btnTimTheoDieuKienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFindbyPhoneActionPerformed
		// TODO add your handling code here:
		JPanel[] phongQuanLy = { phongQuanLy1, phongQuanLy2, phongQuanLy3, phongQuanLy4, phongQuanLy5, phongQuanLy6, phongQuanLy7
                                , phongQuanLy8, phongQuanLy9, phongQuanLy10, phongQuanLy11, phongQuanLy12, phongQuanLy13, phongQuanLy14
                                , phongQuanLy15, phongQuanLy16, phongQuanLy17, phongQuanLy18, phongQuanLy19, phongQuanLy20, phongQuanLy21
                                , phongQuanLy22, phongQuanLy23, phongQuanLy24, phongQuanLy25, phongQuanLy26, phongQuanLy27, phongQuanLy28
                                , phongQuanLy29, phongQuanLy30, phongQuanLy31, phongQuanLy32, phongQuanLy33, phongQuanLy34, phongQuanLy35};

		JLabel[] loaiPhongQuanLy = { lblLoaiPhongQL1, lblLoaiPhongQL2, lblLoaiPhongQL3, lblLoaiPhongQL4, lblLoaiPhongQL5, lblLoaiPhongQL6, lblLoaiPhongQL7
                                , lblLoaiPhongQL8, lblLoaiPhongQL9, lblLoaiPhongQL10, lblLoaiPhongQL11, lblLoaiPhongQL12, lblLoaiPhongQL13, lblLoaiPhongQL14
                                , lblLoaiPhongQL15, lblLoaiPhongQL16, lblLoaiPhongQL17, lblLoaiPhongQL18, lblLoaiPhongQL19, lblLoaiPhongQL20, lblLoaiPhongQL21
                                , lblLoaiPhongQL22, lblLoaiPhongQL23, lblLoaiPhongQL24, lblLoaiPhongQL25, lblLoaiPhongQL26, lblLoaiPhongQL27, lblLoaiPhongQL28
                                , lblLoaiPhongQL29, lblLoaiPhongQL30, lblLoaiPhongQL31, lblLoaiPhongQL32, lblLoaiPhongQL33, lblLoaiPhongQL34, lblLoaiPhongQL35};

		JLabel[] tenPhongQuanLy = { lblTenPhongQL1, lblTenPhongQL2, lblTenPhongQL3, lblTenPhongQL4, lblTenPhongQL5, lblTenPhongQL6, lblTenPhongQL7
                                , lblTenPhongQL8, lblTenPhongQL9, lblTenPhongQL10, lblTenPhongQL11, lblTenPhongQL12, lblTenPhongQL13, lblTenPhongQL14
                                , lblTenPhongQL15, lblTenPhongQL16, lblTenPhongQL17, lblTenPhongQL18, lblTenPhongQL19, lblTenPhongQL20, lblTenPhongQL21
                                , lblTenPhongQL22, lblTenPhongQL23, lblTenPhongQL24, lblTenPhongQL25, lblTenPhongQL26, lblTenPhongQL27, lblTenPhongQL28
                                , lblTenPhongQL29, lblTenPhongQL30, lblTenPhongQL31, lblTenPhongQL32, lblTenPhongQL33, lblTenPhongQL34, lblTenPhongQL35};

		JLabel[] trangThaiQuanLy = { lblTrangThaiQL1, lblTrangThaiQL2, lblTrangThaiQL3, lblTrangThaiQL4, lblTrangThaiQL5, lblTrangThaiQL6, lblTrangThaiQL7
                                , lblTrangThaiQL8, lblTrangThaiQL9, lblTrangThaiQL10, lblTrangThaiQL11, lblTrangThaiQL12, lblTrangThaiQL13, lblTrangThaiQL14
                                , lblTrangThaiQL15, lblTrangThaiQL16, lblTrangThaiQL17, lblTrangThaiQL18, lblTrangThaiQL19, lblTrangThaiQL20, lblTrangThaiQL21
                                , lblTrangThaiQL22, lblTrangThaiQL23, lblTrangThaiQL24, lblTrangThaiQL25, lblTrangThaiQL26, lblTrangThaiQL27, lblTrangThaiQL28
                                , lblTrangThaiQL29, lblTrangThaiQL30, lblTrangThaiQL31, lblTrangThaiQL32, lblTrangThaiQL33, lblTrangThaiQL34, lblTrangThaiQL35};

		JCheckBox[] cksQuanLy = {  checkBoxPhongQL1, checkBoxPhongQL2, checkBoxPhongQL3, checkBoxPhongQL4, checkBoxPhongQL5, checkBoxPhongQL6, checkBoxPhongQL7
                                , checkBoxPhongQL8, checkBoxPhongQL9, checkBoxPhongQL10, checkBoxPhongQL11, checkBoxPhongQL12, checkBoxPhongQL13, checkBoxPhongQL14
                                , checkBoxPhongQL15, checkBoxPhongQL16, checkBoxPhongQL17, checkBoxPhongQL18, checkBoxPhongQL19, checkBoxPhongQL20, checkBoxPhongQL21
                                , checkBoxPhongQL22, checkBoxPhongQL23, checkBoxPhongQL24, checkBoxPhongQL25, checkBoxPhongQL26, checkBoxPhongQL27, checkBoxPhongQL28
                                , checkBoxPhongQL29, checkBoxPhongQL30, checkBoxPhongQL31, checkBoxPhongQL32, checkBoxPhongQL33, checkBoxPhongQL34, checkBoxPhongQL35};

		if (radPhongTieuChuan.isSelected()) {
			HienThiTatCaPhong();
			for (int i = 0; i < loaiPhongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel loaiP = loaiPhongQuanLy[i];

				if (loaiP.getText().equalsIgnoreCase("Tiêu chuẩn")) {
					p.setBackground(red);
				} else {
					p.hide();
				}
			}
		} else if (radPhongNangCao.isSelected()) {
			HienThiTatCaPhong();
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel loaiP = loaiPhongQuanLy[i];

				if (loaiP.getText().equalsIgnoreCase("Nâng cao")) {
					p.setBackground(red);
				} else {
					p.hide();
				}
			}
		} else if (radPhongCaoCap.isSelected()) {
			HienThiTatCaPhong();
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel loaiP = loaiPhongQuanLy[i];

				if (loaiP.getText().equalsIgnoreCase("Cao cấp")) {
					p.setBackground(red);
				} else {
					p.hide();
				}
			}
		} else if (radPhongThuongGia.isSelected()) {
			HienThiTatCaPhong();
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel loaiP = loaiPhongQuanLy[i];

				if (loaiP.getText().equalsIgnoreCase("Thương gia")) {
					p.setBackground(red);
				} else {
					p.hide();
				}
			}
		}

		if (radPhongTrong.isSelected()) {
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel trangThaiP = trangThaiQuanLy[i];

				if (trangThaiP.getText().equalsIgnoreCase("Đang trống")) {
					p.setBackground(red);
				} else {
					p.hide();
				}
			}
		} else if (radPhongDaDat.isSelected()) {
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel trangThaiP = trangThaiQuanLy[i];

				if (trangThaiP.getText().equalsIgnoreCase("Đã đặt")) {
					p.setBackground(red);
				} else {
					p.hide();
				}
			}
		} else if (radPhongDangThue.isSelected()) {
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel trangThaiP = trangThaiQuanLy[i];

				if (trangThaiP.getText().equalsIgnoreCase("Đang thuê")) {
					p.setBackground(red);
				} else {
					p.hide();
				}
			}
		}
	}// GEN-LAST:event_btnFindbyPhoneActionPerformed

	private void btnResetTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetTrangThaiActionPerformed
		// TODO add your handling code here:
		HienThiTatCaPhong();
		radPhongTieuChuan.setSelected(false);
		radPhongNangCao.setSelected(false);
		radPhongCaoCap.setSelected(false);
		radPhongTrong.setSelected(false);
		radPhongDangThue.setSelected(false);
		radPhongDaDat.setSelected(false);
		btnGROUPLoaiPhong.clearSelection();
		btnGROUPTrangThai.clearSelection();
	}// GEN-LAST:event_btnResetTrangThaiActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton4ActionPerformed

	private void btnNgaySinhNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgaySinhNhanVienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnNgaySinhNhanVienActionPerformed

	private void btnNgayVaoLamNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgayVaoLamNhanVienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnNgayVaoLamNhanVienActionPerformed

	private void btnThoiGianKetThucKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThoiGianKetThucKhuyenMaiActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnThoiGianKetThucKhuyenMaiActionPerformed

	private void btnNgaySinhNhanVien3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgaySinhNhanVien3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnNgaySinhNhanVien3ActionPerformed

	private void btnThoiGianBatDauKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThoiGianBatDauKhuyenMaiActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnThoiGianBatDauKhuyenMaiActionPerformed

	private void txtSoDienThoaiKhachHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSoDienThoaiKhachHangActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSoDienThoaiKhachHangActionPerformed

	private void btnXoaTrangDichVuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTrangDichVuActionPerformed
		// TODO add your handling code here:
		txtMaDichVu.setText("");
		txtTenDichVu.setText("");
		txtDonGiaDichVu.setText("");
	}// GEN-LAST:event_btnXoaTrangDichVuActionPerformed

	/**
	 * Code nút cập nhập dịch vụ**
	 * *****************************************************************
	 */
	private void btnCapNhapDichVuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNhapDichVuActionPerformed
		String maDichVu = txtMaDichVu.getText();
		String tenDichVu = txtTenDichVu.getText();
		double donGiaDichVu = Double.parseDouble(txtDonGiaDichVu.getText());
		DichVu dv = new DichVu(maDichVu, tenDichVu, donGiaDichVu);
		DichVuDao dvdao = new DichVuDao();

		boolean capNhapThanhCong = dvdao.suaDichVu(dv);
		if (capNhapThanhCong) {
			JOptionPane.showMessageDialog(this, "Cập nhập dịch vụ thành công");
		} else {
			JOptionPane.showMessageDialog(this, "Cập nhập dịch vụ KHÔNG thành công");
		}
		loadTableDichVu();
	}// GEN-LAST:event_btnCapNhapDichVuActionPerformed

	private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemDichVuActionPerformed
		// TODO add your handling code here:
		String maDichVu = txtMaDichVu.getText();
		String tenDichVu = txtTenDichVu.getText();
		double donGiaDichVu = Double.parseDouble(txtDonGiaDichVu.getText());
		DichVu dv = new DichVu(maDichVu, tenDichVu, donGiaDichVu);
		DichVuDao dvdao = new DichVuDao();
		boolean themThanhCong = dvdao.themDichVu(dv);
		if (themThanhCong) {
			JOptionPane.showMessageDialog(this, "Đã thêm dịch vụ thành công");
		} else {
			JOptionPane.showMessageDialog(this, "Thêm dịch vụ không thành công");
		}

		loadTableDichVu();
	}// GEN-LAST:event_btnThemDichVuActionPerformed

	private String taoMaNhanVien(String tenChucVu, LocalDate ngayVaoLam) {
		NhanVienDao nvDao = new NhanVienDao();
		String ngayVaoLamStr = ngayVaoLam.toString().replace("-", "");
		String maChucVu = null;
		if (tenChucVu.equalsIgnoreCase("Nhân viên lễ tân")) {
			maChucVu = "NV";
		} else if (tenChucVu.equalsIgnoreCase("Nhân viên quản lý")) {
			maChucVu = "QL";
		}
		int stt = nvDao.demTongSoNhanVien() + 1;
		String sttStr = String.format("%03d", stt);
		String maNhanVien = "SR" + maChucVu + ngayVaoLamStr + sttStr;
		return maNhanVien;
	}
	
	
	private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemNhanVienActionPerformed
		// TODO add your handling code here:
		// Kiểm tra tên
		String tenNhanVien = txtHoTenNhanVien.getText();
		if (!regTen(tenNhanVien)) {
			JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
			return;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngaySinhNhanVienFormat = LocalDate.parse(txtNgaySinhNhanVien.getText(), formatter);
		LocalDate ngaySinh = LocalDate.of(ngaySinhNhanVienFormat.getYear(), ngaySinhNhanVienFormat.getMonth(),
				ngaySinhNhanVienFormat.getDayOfMonth());
		// Kiểm tra ngày sinh có trên 18 tuổi hay chưa
		if (ngaySinh.plusYears(18).isAfter(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "Chưa đủ 18 tuổi");
			return;
		}
		String gioiTinh = cbxGioiTinh.getSelectedItem().toString();
		String soDienThoai = txtSoDienThoaiNhanVien.getText();
		// Kiểm tra sđt
		if (!regSoDienThoai(soDienThoai)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
			return;
		}
		String email = txtEmailNhanVien1.getText();
		// Kiểm tra email
		if (!regEmail(email)) {
			JOptionPane.showMessageDialog(this, "Email không hợp lệ");
			return;
		}
		String CCCD_Visa = txtCanCuocCongDanNhanVien.getText();
		// Kiểm tra CCCD
		if (!regCCCD_Visa(CCCD_Visa)) {
			JOptionPane.showMessageDialog(this, "CCCD/Visa không hợp lệ");
			return;
		}
		String diaChi = txtCanCuocCongDanNhanVien.getText();
		String maChucVu = null;
		ChucVu chucVu = null;
		ChucVuDao cvDao = new ChucVuDao();
		if (cbxChucVuNhanVien.getSelectedItem().toString().equalsIgnoreCase("Nhân viên lễ tân")) {
			maChucVu = "NV";
			chucVu = cvDao.getChucVu(maChucVu);
		} else if (cbxChucVuNhanVien.getSelectedItem().toString().equalsIgnoreCase("Nhân viên quản lý")) {
			maChucVu = "QL";
			chucVu = cvDao.getChucVu(maChucVu);
		}
		LocalDate ngayVaoLamFormat = LocalDate.parse(txtNgayVaoLamNhanVien.getText(), formatter);
		LocalDate ngayVaoLam = LocalDate.of(ngayVaoLamFormat.getYear(), ngayVaoLamFormat.getMonth(),
				ngayVaoLamFormat.getDayOfMonth());
		// Ngày vào làm không được sau ngày hiện tại
		if (ngayVaoLam.isAfter(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "Ngày vào làm không được sau ngày hiện tại");
			return;
		}
		String maNhanVien = taoMaNhanVien(cbxChucVuNhanVien.getSelectedItem().toString(), ngayVaoLam);
		NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soDienThoai, email, CCCD_Visa, diaChi,
				chucVu, ngayVaoLam);
		NhanVienDao nvdao = new NhanVienDao();
		boolean themThanhCong = nvdao.themNhanVien(nv);
		if (themThanhCong) {
			JOptionPane.showMessageDialog(this, "Đã thêm nhân viên thành công");
			loadTableNhanVien();
		} else {
			JOptionPane.showMessageDialog(this, "Thêm nhân viên không thành công");
		}
		loadTableNhanVien();
	}// GEN-LAST:event_btnThemNhanVienActionPerformed

	private void btnCapNhapNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNhapNhanVienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnCapNhapNhanVienActionPerformed

	private void btnXoaTrangNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTrangNhanVienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnXoaTrangNhanVienActionPerformed

	private void btnTamChoNghiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTamChoNghiNhanVienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTamChoNghiNhanVienActionPerformed

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
			java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TrangChu().setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
	}

	private void HienThiTatCaPhong() {
		JPanel[] phongQuanLy = { phongQuanLy1, phongQuanLy2, phongQuanLy3, phongQuanLy4, phongQuanLy5, phongQuanLy6, phongQuanLy7
                                , phongQuanLy8, phongQuanLy9, phongQuanLy10, phongQuanLy11, phongQuanLy12, phongQuanLy13, phongQuanLy14
                                , phongQuanLy15, phongQuanLy16, phongQuanLy17, phongQuanLy18, phongQuanLy19, phongQuanLy20, phongQuanLy21
                                , phongQuanLy22, phongQuanLy23, phongQuanLy24, phongQuanLy25, phongQuanLy26, phongQuanLy27, phongQuanLy28
                                , phongQuanLy29, phongQuanLy30, phongQuanLy31, phongQuanLy32, phongQuanLy33, phongQuanLy34, phongQuanLy35};
		for (int i = 0; i < phongQuanLy.length; i++) {
			JPanel p = phongQuanLy[i];
			p.show();
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header Header;
    private menu.Menu Menu;
    private javax.swing.JScrollPane ScrollPaneQuanLyPhong;
    private javax.swing.JScrollPane ScrollPaneTrangChu;
    private javax.swing.JTable TableDichVu;
    private javax.swing.JTable TableKhachHang;
    private javax.swing.JTable TableKhuyenMai;
    private javax.swing.JTable TableNhanVien;
    private javax.swing.JPanel Tang1_QuanLyPhong;
    private javax.swing.JPanel Tang1_TrangChu;
    private javax.swing.JPanel Tang2_QuanLyPhong;
    private javax.swing.JPanel Tang2_TrangChu;
    private javax.swing.JPanel Tang3_QuanLyPhong;
    private javax.swing.JPanel Tang3_TrangChu;
    private javax.swing.JPanel Tang4_QuanLyPhong;
    private javax.swing.JPanel Tang4_TrangChu;
    private javax.swing.JButton btnCapNhapDichVu;
    private javax.swing.JButton btnCapNhapKhachHang;
    private javax.swing.JButton btnCapNhapKhuyenMai;
    private javax.swing.JButton btnCapNhapNhanVien;
    private javax.swing.ButtonGroup btnGROUPLoaiPhong;
    private javax.swing.ButtonGroup btnGROUPTrangThai;
    private giaodien.CustomClass.Button btnNgaySinhNhanVien;
    private giaodien.CustomClass.Button btnNgaySinhNhanVien3;
    private giaodien.CustomClass.Button btnNgayVaoLamNhanVien;
    private javax.swing.JButton btnNgungKhuyenMai;
    private javax.swing.JButton btnResetTrangThai;
    private javax.swing.JButton btnTamChoNghiNhanVien;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnThemNhanVien;
    private giaodien.CustomClass.Button btnThoiGianBatDauKhuyenMai;
    private giaodien.CustomClass.Button btnThoiGianKetThucKhuyenMai;
    private javax.swing.JButton btnTimTheoDieuKien;
    private javax.swing.JButton btnXoaTrangDichVu;
    private javax.swing.JButton btnXoaTrangKhuyenMai;
    private javax.swing.JButton btnXoaTrangNhanVien;
    private javax.swing.JComboBox<String> cbxChucVuNhanVien;
    private javax.swing.JComboBox<String> cbxDieuKienApDungKhuyenMai;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JComboBox<String> cbxGioiTinhKhachHang;
    private javax.swing.JCheckBox checkBoxPhongQL1;
    private javax.swing.JCheckBox checkBoxPhongQL10;
    private javax.swing.JCheckBox checkBoxPhongQL11;
    private javax.swing.JCheckBox checkBoxPhongQL12;
    private javax.swing.JCheckBox checkBoxPhongQL13;
    private javax.swing.JCheckBox checkBoxPhongQL14;
    private javax.swing.JCheckBox checkBoxPhongQL15;
    private javax.swing.JCheckBox checkBoxPhongQL16;
    private javax.swing.JCheckBox checkBoxPhongQL17;
    private javax.swing.JCheckBox checkBoxPhongQL18;
    private javax.swing.JCheckBox checkBoxPhongQL19;
    private javax.swing.JCheckBox checkBoxPhongQL2;
    private javax.swing.JCheckBox checkBoxPhongQL20;
    private javax.swing.JCheckBox checkBoxPhongQL21;
    private javax.swing.JCheckBox checkBoxPhongQL22;
    private javax.swing.JCheckBox checkBoxPhongQL23;
    private javax.swing.JCheckBox checkBoxPhongQL24;
    private javax.swing.JCheckBox checkBoxPhongQL25;
    private javax.swing.JCheckBox checkBoxPhongQL26;
    private javax.swing.JCheckBox checkBoxPhongQL27;
    private javax.swing.JCheckBox checkBoxPhongQL28;
    private javax.swing.JCheckBox checkBoxPhongQL29;
    private javax.swing.JCheckBox checkBoxPhongQL3;
    private javax.swing.JCheckBox checkBoxPhongQL30;
    private javax.swing.JCheckBox checkBoxPhongQL31;
    private javax.swing.JCheckBox checkBoxPhongQL32;
    private javax.swing.JCheckBox checkBoxPhongQL33;
    private javax.swing.JCheckBox checkBoxPhongQL34;
    private javax.swing.JCheckBox checkBoxPhongQL35;
    private javax.swing.JCheckBox checkBoxPhongQL4;
    private javax.swing.JCheckBox checkBoxPhongQL5;
    private javax.swing.JCheckBox checkBoxPhongQL6;
    private javax.swing.JCheckBox checkBoxPhongQL7;
    private javax.swing.JCheckBox checkBoxPhongQL8;
    private javax.swing.JCheckBox checkBoxPhongQL9;
    private javax.swing.JPanel funtionPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblLoaiPhong10;
    private javax.swing.JLabel lblLoaiPhong11;
    private javax.swing.JLabel lblLoaiPhong13;
    private javax.swing.JLabel lblLoaiPhong14;
    private javax.swing.JLabel lblLoaiPhong17;
    private javax.swing.JLabel lblLoaiPhong18;
    private javax.swing.JLabel lblLoaiPhong19;
    private javax.swing.JLabel lblLoaiPhong2;
    private javax.swing.JLabel lblLoaiPhong20;
    private javax.swing.JLabel lblLoaiPhong21;
    private javax.swing.JLabel lblLoaiPhong24;
    private javax.swing.JLabel lblLoaiPhong25;
    private javax.swing.JLabel lblLoaiPhong26;
    private javax.swing.JLabel lblLoaiPhong27;
    private javax.swing.JLabel lblLoaiPhong28;
    private javax.swing.JLabel lblLoaiPhong3;
    private javax.swing.JLabel lblLoaiPhong31;
    private javax.swing.JLabel lblLoaiPhong32;
    private javax.swing.JLabel lblLoaiPhong33;
    private javax.swing.JLabel lblLoaiPhong34;
    private javax.swing.JLabel lblLoaiPhong35;
    private javax.swing.JLabel lblLoaiPhong36;
    private javax.swing.JLabel lblLoaiPhong37;
    private javax.swing.JLabel lblLoaiPhong38;
    private javax.swing.JLabel lblLoaiPhong39;
    private javax.swing.JLabel lblLoaiPhong4;
    private javax.swing.JLabel lblLoaiPhong40;
    private javax.swing.JLabel lblLoaiPhong41;
    private javax.swing.JLabel lblLoaiPhong42;
    private javax.swing.JLabel lblLoaiPhong48;
    private javax.swing.JLabel lblLoaiPhong49;
    private javax.swing.JLabel lblLoaiPhong5;
    private javax.swing.JLabel lblLoaiPhong50;
    private javax.swing.JLabel lblLoaiPhong6;
    private javax.swing.JLabel lblLoaiPhong9;
    private javax.swing.JLabel lblLoaiPhongQL1;
    private javax.swing.JLabel lblLoaiPhongQL10;
    private javax.swing.JLabel lblLoaiPhongQL11;
    private javax.swing.JLabel lblLoaiPhongQL12;
    private javax.swing.JLabel lblLoaiPhongQL13;
    private javax.swing.JLabel lblLoaiPhongQL14;
    private javax.swing.JLabel lblLoaiPhongQL15;
    private javax.swing.JLabel lblLoaiPhongQL16;
    private javax.swing.JLabel lblLoaiPhongQL17;
    private javax.swing.JLabel lblLoaiPhongQL18;
    private javax.swing.JLabel lblLoaiPhongQL19;
    private javax.swing.JLabel lblLoaiPhongQL2;
    private javax.swing.JLabel lblLoaiPhongQL20;
    private javax.swing.JLabel lblLoaiPhongQL21;
    private javax.swing.JLabel lblLoaiPhongQL22;
    private javax.swing.JLabel lblLoaiPhongQL23;
    private javax.swing.JLabel lblLoaiPhongQL24;
    private javax.swing.JLabel lblLoaiPhongQL25;
    private javax.swing.JLabel lblLoaiPhongQL26;
    private javax.swing.JLabel lblLoaiPhongQL27;
    private javax.swing.JLabel lblLoaiPhongQL28;
    private javax.swing.JLabel lblLoaiPhongQL29;
    private javax.swing.JLabel lblLoaiPhongQL3;
    private javax.swing.JLabel lblLoaiPhongQL30;
    private javax.swing.JLabel lblLoaiPhongQL31;
    private javax.swing.JLabel lblLoaiPhongQL32;
    private javax.swing.JLabel lblLoaiPhongQL33;
    private javax.swing.JLabel lblLoaiPhongQL34;
    private javax.swing.JLabel lblLoaiPhongQL35;
    private javax.swing.JLabel lblLoaiPhongQL4;
    private javax.swing.JLabel lblLoaiPhongQL5;
    private javax.swing.JLabel lblLoaiPhongQL6;
    private javax.swing.JLabel lblLoaiPhongQL7;
    private javax.swing.JLabel lblLoaiPhongQL8;
    private javax.swing.JLabel lblLoaiPhongQL9;
    private javax.swing.JLabel lblTenPhong10;
    private javax.swing.JLabel lblTenPhong11;
    private javax.swing.JLabel lblTenPhong13;
    private javax.swing.JLabel lblTenPhong14;
    private javax.swing.JLabel lblTenPhong17;
    private javax.swing.JLabel lblTenPhong18;
    private javax.swing.JLabel lblTenPhong19;
    private javax.swing.JLabel lblTenPhong2;
    private javax.swing.JLabel lblTenPhong20;
    private javax.swing.JLabel lblTenPhong21;
    private javax.swing.JLabel lblTenPhong24;
    private javax.swing.JLabel lblTenPhong25;
    private javax.swing.JLabel lblTenPhong26;
    private javax.swing.JLabel lblTenPhong27;
    private javax.swing.JLabel lblTenPhong28;
    private javax.swing.JLabel lblTenPhong3;
    private javax.swing.JLabel lblTenPhong31;
    private javax.swing.JLabel lblTenPhong32;
    private javax.swing.JLabel lblTenPhong33;
    private javax.swing.JLabel lblTenPhong34;
    private javax.swing.JLabel lblTenPhong35;
    private javax.swing.JLabel lblTenPhong36;
    private javax.swing.JLabel lblTenPhong37;
    private javax.swing.JLabel lblTenPhong38;
    private javax.swing.JLabel lblTenPhong39;
    private javax.swing.JLabel lblTenPhong4;
    private javax.swing.JLabel lblTenPhong40;
    private javax.swing.JLabel lblTenPhong41;
    private javax.swing.JLabel lblTenPhong42;
    private javax.swing.JLabel lblTenPhong48;
    private javax.swing.JLabel lblTenPhong49;
    private javax.swing.JLabel lblTenPhong5;
    private javax.swing.JLabel lblTenPhong50;
    private javax.swing.JLabel lblTenPhong6;
    private javax.swing.JLabel lblTenPhong9;
    private javax.swing.JLabel lblTenPhongQL1;
    private javax.swing.JLabel lblTenPhongQL10;
    private javax.swing.JLabel lblTenPhongQL11;
    private javax.swing.JLabel lblTenPhongQL12;
    private javax.swing.JLabel lblTenPhongQL13;
    private javax.swing.JLabel lblTenPhongQL14;
    private javax.swing.JLabel lblTenPhongQL15;
    private javax.swing.JLabel lblTenPhongQL16;
    private javax.swing.JLabel lblTenPhongQL17;
    private javax.swing.JLabel lblTenPhongQL18;
    private javax.swing.JLabel lblTenPhongQL19;
    private javax.swing.JLabel lblTenPhongQL2;
    private javax.swing.JLabel lblTenPhongQL20;
    private javax.swing.JLabel lblTenPhongQL21;
    private javax.swing.JLabel lblTenPhongQL22;
    private javax.swing.JLabel lblTenPhongQL23;
    private javax.swing.JLabel lblTenPhongQL24;
    private javax.swing.JLabel lblTenPhongQL25;
    private javax.swing.JLabel lblTenPhongQL26;
    private javax.swing.JLabel lblTenPhongQL27;
    private javax.swing.JLabel lblTenPhongQL28;
    private javax.swing.JLabel lblTenPhongQL29;
    private javax.swing.JLabel lblTenPhongQL3;
    private javax.swing.JLabel lblTenPhongQL30;
    private javax.swing.JLabel lblTenPhongQL31;
    private javax.swing.JLabel lblTenPhongQL32;
    private javax.swing.JLabel lblTenPhongQL33;
    private javax.swing.JLabel lblTenPhongQL34;
    private javax.swing.JLabel lblTenPhongQL35;
    private javax.swing.JLabel lblTenPhongQL4;
    private javax.swing.JLabel lblTenPhongQL5;
    private javax.swing.JLabel lblTenPhongQL6;
    private javax.swing.JLabel lblTenPhongQL7;
    private javax.swing.JLabel lblTenPhongQL8;
    private javax.swing.JLabel lblTenPhongQL9;
    private javax.swing.JLabel lblTrangThai10;
    private javax.swing.JLabel lblTrangThai11;
    private javax.swing.JLabel lblTrangThai13;
    private javax.swing.JLabel lblTrangThai14;
    private javax.swing.JLabel lblTrangThai17;
    private javax.swing.JLabel lblTrangThai18;
    private javax.swing.JLabel lblTrangThai19;
    private javax.swing.JLabel lblTrangThai2;
    private javax.swing.JLabel lblTrangThai20;
    private javax.swing.JLabel lblTrangThai21;
    private javax.swing.JLabel lblTrangThai24;
    private javax.swing.JLabel lblTrangThai25;
    private javax.swing.JLabel lblTrangThai26;
    private javax.swing.JLabel lblTrangThai27;
    private javax.swing.JLabel lblTrangThai28;
    private javax.swing.JLabel lblTrangThai3;
    private javax.swing.JLabel lblTrangThai31;
    private javax.swing.JLabel lblTrangThai32;
    private javax.swing.JLabel lblTrangThai33;
    private javax.swing.JLabel lblTrangThai34;
    private javax.swing.JLabel lblTrangThai35;
    private javax.swing.JLabel lblTrangThai36;
    private javax.swing.JLabel lblTrangThai37;
    private javax.swing.JLabel lblTrangThai38;
    private javax.swing.JLabel lblTrangThai39;
    private javax.swing.JLabel lblTrangThai4;
    private javax.swing.JLabel lblTrangThai40;
    private javax.swing.JLabel lblTrangThai41;
    private javax.swing.JLabel lblTrangThai42;
    private javax.swing.JLabel lblTrangThai48;
    private javax.swing.JLabel lblTrangThai49;
    private javax.swing.JLabel lblTrangThai5;
    private javax.swing.JLabel lblTrangThai50;
    private javax.swing.JLabel lblTrangThai6;
    private javax.swing.JLabel lblTrangThai9;
    private javax.swing.JLabel lblTrangThaiQL1;
    private javax.swing.JLabel lblTrangThaiQL10;
    private javax.swing.JLabel lblTrangThaiQL11;
    private javax.swing.JLabel lblTrangThaiQL12;
    private javax.swing.JLabel lblTrangThaiQL13;
    private javax.swing.JLabel lblTrangThaiQL14;
    private javax.swing.JLabel lblTrangThaiQL15;
    private javax.swing.JLabel lblTrangThaiQL16;
    private javax.swing.JLabel lblTrangThaiQL17;
    private javax.swing.JLabel lblTrangThaiQL18;
    private javax.swing.JLabel lblTrangThaiQL19;
    private javax.swing.JLabel lblTrangThaiQL2;
    private javax.swing.JLabel lblTrangThaiQL20;
    private javax.swing.JLabel lblTrangThaiQL21;
    private javax.swing.JLabel lblTrangThaiQL22;
    private javax.swing.JLabel lblTrangThaiQL23;
    private javax.swing.JLabel lblTrangThaiQL24;
    private javax.swing.JLabel lblTrangThaiQL25;
    private javax.swing.JLabel lblTrangThaiQL26;
    private javax.swing.JLabel lblTrangThaiQL27;
    private javax.swing.JLabel lblTrangThaiQL28;
    private javax.swing.JLabel lblTrangThaiQL29;
    private javax.swing.JLabel lblTrangThaiQL3;
    private javax.swing.JLabel lblTrangThaiQL30;
    private javax.swing.JLabel lblTrangThaiQL31;
    private javax.swing.JLabel lblTrangThaiQL32;
    private javax.swing.JLabel lblTrangThaiQL33;
    private javax.swing.JLabel lblTrangThaiQL34;
    private javax.swing.JLabel lblTrangThaiQL35;
    private javax.swing.JLabel lblTrangThaiQL4;
    private javax.swing.JLabel lblTrangThaiQL5;
    private javax.swing.JLabel lblTrangThaiQL6;
    private javax.swing.JLabel lblTrangThaiQL7;
    private javax.swing.JLabel lblTrangThaiQL8;
    private javax.swing.JLabel lblTrangThaiQL9;
    private javax.swing.JLabel lblcurrentTime;
    private javax.swing.JLabel lblcurrentdate;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbltime;
    private javax.swing.JPanel phong10;
    private javax.swing.JPanel phong11;
    private javax.swing.JPanel phong13;
    private javax.swing.JPanel phong14;
    private javax.swing.JPanel phong17;
    private javax.swing.JPanel phong18;
    private javax.swing.JPanel phong19;
    private javax.swing.JPanel phong2;
    private javax.swing.JPanel phong20;
    private javax.swing.JPanel phong21;
    private javax.swing.JPanel phong24;
    private javax.swing.JPanel phong25;
    private javax.swing.JPanel phong26;
    private javax.swing.JPanel phong27;
    private javax.swing.JPanel phong28;
    private javax.swing.JPanel phong3;
    private javax.swing.JPanel phong31;
    private javax.swing.JPanel phong32;
    private javax.swing.JPanel phong33;
    private javax.swing.JPanel phong34;
    private javax.swing.JPanel phong35;
    private javax.swing.JPanel phong36;
    private javax.swing.JPanel phong37;
    private javax.swing.JPanel phong38;
    private javax.swing.JPanel phong39;
    private javax.swing.JPanel phong4;
    private javax.swing.JPanel phong40;
    private javax.swing.JPanel phong41;
    private javax.swing.JPanel phong42;
    private javax.swing.JPanel phong48;
    private javax.swing.JPanel phong49;
    private javax.swing.JPanel phong5;
    private javax.swing.JPanel phong50;
    private javax.swing.JPanel phong6;
    private javax.swing.JPanel phong9;
    private javax.swing.JPanel phongQuanLy1;
    private javax.swing.JPanel phongQuanLy10;
    private javax.swing.JPanel phongQuanLy11;
    private javax.swing.JPanel phongQuanLy12;
    private javax.swing.JPanel phongQuanLy13;
    private javax.swing.JPanel phongQuanLy14;
    private javax.swing.JPanel phongQuanLy15;
    private javax.swing.JPanel phongQuanLy16;
    private javax.swing.JPanel phongQuanLy17;
    private javax.swing.JPanel phongQuanLy18;
    private javax.swing.JPanel phongQuanLy19;
    private javax.swing.JPanel phongQuanLy2;
    private javax.swing.JPanel phongQuanLy20;
    private javax.swing.JPanel phongQuanLy21;
    private javax.swing.JPanel phongQuanLy22;
    private javax.swing.JPanel phongQuanLy23;
    private javax.swing.JPanel phongQuanLy24;
    private javax.swing.JPanel phongQuanLy25;
    private javax.swing.JPanel phongQuanLy26;
    private javax.swing.JPanel phongQuanLy27;
    private javax.swing.JPanel phongQuanLy28;
    private javax.swing.JPanel phongQuanLy29;
    private javax.swing.JPanel phongQuanLy3;
    private javax.swing.JPanel phongQuanLy30;
    private javax.swing.JPanel phongQuanLy31;
    private javax.swing.JPanel phongQuanLy32;
    private javax.swing.JPanel phongQuanLy33;
    private javax.swing.JPanel phongQuanLy34;
    private javax.swing.JPanel phongQuanLy35;
    private javax.swing.JPanel phongQuanLy4;
    private javax.swing.JPanel phongQuanLy5;
    private javax.swing.JPanel phongQuanLy6;
    private javax.swing.JPanel phongQuanLy7;
    private javax.swing.JPanel phongQuanLy8;
    private javax.swing.JPanel phongQuanLy9;
    private javax.swing.JPanel pnBody1;
    private javax.swing.JPanel pnBody2;
    private javax.swing.JPanel pnDichVu;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnKhuyenMai;
    private javax.swing.JPanel pnLayOutDichVu;
    private javax.swing.JPanel pnLayOutKhachKhachHang;
    private javax.swing.JPanel pnLayOutKhuyenMai;
    private javax.swing.JPanel pnLayOutNhanVien;
    private javax.swing.JPanel pnLayOutTrangChu;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnQuanLyPhong;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JTabbedPane pnedUngDung;
    private javax.swing.JRadioButton radPhongCaoCap;
    private javax.swing.JRadioButton radPhongDaDat;
    private javax.swing.JRadioButton radPhongDangThue;
    private javax.swing.JRadioButton radPhongNangCao;
    private javax.swing.JRadioButton radPhongThuongGia;
    private javax.swing.JRadioButton radPhongTieuChuan;
    private javax.swing.JRadioButton radPhongTrong;
    private javax.swing.JTextField txtCanCuocCongDanNhanVien;
    private javax.swing.JTextField txtCanCuocKhachHang;
    private javax.swing.JTextField txtChiTieuKhachHang;
    private javax.swing.JTextField txtDonGiaDichVu;
    private javax.swing.JTextField txtEmailNhanVien1;
    private javax.swing.JTextField txtGiaTriKhuyenMai;
    private javax.swing.JTextField txtHangThanhVien;
    private javax.swing.JTextField txtHoTenNhanVien;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgayBatDauKhuyenMai;
    private javax.swing.JTextField txtNgayKetThucKhuyenMai;
    private javax.swing.JTextField txtNgaySinhKhachHang;
    private javax.swing.JTextField txtNgaySinhNhanVien;
    private javax.swing.JTextField txtNgayVaoLamNhanVien;
    private javax.swing.JTextField txtQuocTichKhachHang;
    private javax.swing.JTextField txtSoDienThoaiKhachHang;
    private javax.swing.JTextField txtSoDienThoaiNhanVien;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenKhuyenMai;
    // End of variables declaration//GEN-END:variables
}
