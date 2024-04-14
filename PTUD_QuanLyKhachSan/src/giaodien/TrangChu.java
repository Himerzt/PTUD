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
import entity.Phong;

import static java.awt.Color.red;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import dao.PhongDao;
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
//                                      loadDuLieuPhonglenGiaoDien();
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

		lblcurrentdate.setText(df);
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
				lblcurrentTime.setText(timeindate);

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
        pnBody1 = new javax.swing.JPanel();
        Tang1_TrangChu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        phongTrangChu1 = new javax.swing.JPanel();
        lblTenPhongTrangChu1 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu1 = new javax.swing.JLabel();
        lblTrangThaiTrangChu1 = new javax.swing.JLabel();
        phongTrangChu2 = new javax.swing.JPanel();
        lblTenPhongTrangChu2 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu2 = new javax.swing.JLabel();
        lblTrangThaiTrangChu2 = new javax.swing.JLabel();
        phongTrangChu3 = new javax.swing.JPanel();
        lblTenPhongTrangChu3 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu3 = new javax.swing.JLabel();
        lblTrangThaiTrangChu3 = new javax.swing.JLabel();
        phongTrangChu4 = new javax.swing.JPanel();
        lblTenPhongTrangChu4 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu4 = new javax.swing.JLabel();
        lblTrangThaiTrangChu4 = new javax.swing.JLabel();
        phongTrangChu5 = new javax.swing.JPanel();
        lblTenPhongTrangChu5 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu5 = new javax.swing.JLabel();
        lblTrangThaiTrangChu5 = new javax.swing.JLabel();
        phongTrangChu6 = new javax.swing.JPanel();
        lblTenPhongTrangChu6 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu6 = new javax.swing.JLabel();
        lblTrangThaiTrangChu6 = new javax.swing.JLabel();
        phongTrangChu7 = new javax.swing.JPanel();
        lblTenPhongTrangChu7 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu7 = new javax.swing.JLabel();
        lblTrangThaiTrangChu7 = new javax.swing.JLabel();
        phongTrangChu8 = new javax.swing.JPanel();
        lblTenPhongTrangChu8 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu8 = new javax.swing.JLabel();
        lblTrangThaiTrangChu8 = new javax.swing.JLabel();
        phongTrangChu9 = new javax.swing.JPanel();
        lblTenPhongTrangChu9 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu9 = new javax.swing.JLabel();
        lblTrangThaiTrangChu9 = new javax.swing.JLabel();
        phongTrangChu10 = new javax.swing.JPanel();
        lblTenPhongTrangChu10 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu10 = new javax.swing.JLabel();
        lblTrangThaiTrangChu10 = new javax.swing.JLabel();
        Tang1_TrangChu1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        phongTrangChu11 = new javax.swing.JPanel();
        lblTenPhongTrangChu11 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu11 = new javax.swing.JLabel();
        lblTrangThaiTrangChu11 = new javax.swing.JLabel();
        phongTrangChu12 = new javax.swing.JPanel();
        lblTenPhongTrangChu12 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu12 = new javax.swing.JLabel();
        lblTrangThaiTrangChu12 = new javax.swing.JLabel();
        phongTrangChu13 = new javax.swing.JPanel();
        lblTenPhongTrangChu13 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu13 = new javax.swing.JLabel();
        lblTrangThaiTrangChu13 = new javax.swing.JLabel();
        phongTrangChu14 = new javax.swing.JPanel();
        lblTenPhongTrangChu14 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu14 = new javax.swing.JLabel();
        lblTrangThaiTrangChu14 = new javax.swing.JLabel();
        phongTrangChu15 = new javax.swing.JPanel();
        lblTenPhongTrangChu15 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu15 = new javax.swing.JLabel();
        lblTrangThaiTrangChu15 = new javax.swing.JLabel();
        phongTrangChu16 = new javax.swing.JPanel();
        lblTenPhongTrangChu16 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu16 = new javax.swing.JLabel();
        lblTrangThaiTrangChu16 = new javax.swing.JLabel();
        phongTrangChu17 = new javax.swing.JPanel();
        lblTenPhongTrangChu17 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu17 = new javax.swing.JLabel();
        lblTrangThaiTrangChu17 = new javax.swing.JLabel();
        phongTrangChu18 = new javax.swing.JPanel();
        lblTenPhongTrangChu18 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu18 = new javax.swing.JLabel();
        lblTrangThaiTrangChu18 = new javax.swing.JLabel();
        phongTrangChu19 = new javax.swing.JPanel();
        lblTenPhongTrangChu19 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu19 = new javax.swing.JLabel();
        lblTrangThaiTrangChu19 = new javax.swing.JLabel();
        phongTrangChu20 = new javax.swing.JPanel();
        lblTenPhongTrangChu20 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu20 = new javax.swing.JLabel();
        lblTrangThaiTrangChu20 = new javax.swing.JLabel();
        Tang1_TrangChu2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        phongTrangChu21 = new javax.swing.JPanel();
        lblTenPhongTrangChu21 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu21 = new javax.swing.JLabel();
        lblTrangThaiTrangChu21 = new javax.swing.JLabel();
        phongTrangChu22 = new javax.swing.JPanel();
        lblTenPhongTrangChu22 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu22 = new javax.swing.JLabel();
        lblTrangThaiTrangChu22 = new javax.swing.JLabel();
        phongTrangChu23 = new javax.swing.JPanel();
        lblTenPhongTrangChu23 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu23 = new javax.swing.JLabel();
        lblTrangThaiTrangChu23 = new javax.swing.JLabel();
        phongTrangChu24 = new javax.swing.JPanel();
        lblTenPhongTrangChu24 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu24 = new javax.swing.JLabel();
        lblTrangThaiTrangChu24 = new javax.swing.JLabel();
        phongTrangChu25 = new javax.swing.JPanel();
        lblTenPhongTrangChu25 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu25 = new javax.swing.JLabel();
        lblTrangThaiTrangChu25 = new javax.swing.JLabel();
        phongTrangChu26 = new javax.swing.JPanel();
        lblTenPhongTrangChu26 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu26 = new javax.swing.JLabel();
        lblTrangThaiTrangChu26 = new javax.swing.JLabel();
        phongTrangChu27 = new javax.swing.JPanel();
        lblTenPhongTrangChu27 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu27 = new javax.swing.JLabel();
        lblTrangThaiTrangChu27 = new javax.swing.JLabel();
        phongTrangChu28 = new javax.swing.JPanel();
        lblTenPhongTrangChu28 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu28 = new javax.swing.JLabel();
        lblTrangThaiTrangChu28 = new javax.swing.JLabel();
        phongTrangChu29 = new javax.swing.JPanel();
        lblTenPhongTrangChu29 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu29 = new javax.swing.JLabel();
        lblTrangThaiTrangChu29 = new javax.swing.JLabel();
        phongTrangChu30 = new javax.swing.JPanel();
        lblTenPhongTrangChu30 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu30 = new javax.swing.JLabel();
        lblTrangThaiTrangChu30 = new javax.swing.JLabel();
        Tang1_TrangChu3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        phongTrangChu31 = new javax.swing.JPanel();
        lblTenPhongTrangChu31 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu31 = new javax.swing.JLabel();
        lblTrangThaiTrangChu31 = new javax.swing.JLabel();
        phongTrangChu32 = new javax.swing.JPanel();
        lblTenPhongTrangChu32 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu32 = new javax.swing.JLabel();
        lblTrangThaiTrangChu32 = new javax.swing.JLabel();
        phongTrangChu33 = new javax.swing.JPanel();
        lblTenPhongTrangChu33 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu33 = new javax.swing.JLabel();
        lblTrangThaiTrangChu33 = new javax.swing.JLabel();
        phongTrangChu34 = new javax.swing.JPanel();
        lblTenPhongTrangChu34 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu34 = new javax.swing.JLabel();
        lblTrangThaiTrangChu34 = new javax.swing.JLabel();
        phongTrangChu35 = new javax.swing.JPanel();
        lblTenPhongTrangChu35 = new javax.swing.JLabel();
        lblLoaiPhongTrangChu35 = new javax.swing.JLabel();
        lblTrangThaiTrangChu35 = new javax.swing.JLabel();
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

        phongTrangChu1.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu1.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu1.setText("101TC");

        lblLoaiPhongTrangChu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu1.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu1.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu1Layout = new javax.swing.GroupLayout(phongTrangChu1);
        phongTrangChu1.setLayout(phongTrangChu1Layout);
        phongTrangChu1Layout.setHorizontalGroup(
            phongTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu1Layout.setVerticalGroup(
            phongTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu1)
                .addContainerGap())
        );

        phongTrangChu2.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu2.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu2.setText("101TC");

        lblLoaiPhongTrangChu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu2.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu2.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu2Layout = new javax.swing.GroupLayout(phongTrangChu2);
        phongTrangChu2.setLayout(phongTrangChu2Layout);
        phongTrangChu2Layout.setHorizontalGroup(
            phongTrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu2, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu2Layout.setVerticalGroup(
            phongTrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu2)
                .addContainerGap())
        );

        phongTrangChu3.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu3.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu3.setText("101TC");

        lblLoaiPhongTrangChu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu3.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu3.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu3Layout = new javax.swing.GroupLayout(phongTrangChu3);
        phongTrangChu3.setLayout(phongTrangChu3Layout);
        phongTrangChu3Layout.setHorizontalGroup(
            phongTrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu3Layout.setVerticalGroup(
            phongTrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu3)
                .addContainerGap())
        );

        phongTrangChu4.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu4.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu4.setText("101TC");

        lblLoaiPhongTrangChu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu4.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu4.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu4Layout = new javax.swing.GroupLayout(phongTrangChu4);
        phongTrangChu4.setLayout(phongTrangChu4Layout);
        phongTrangChu4Layout.setHorizontalGroup(
            phongTrangChu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu4Layout.setVerticalGroup(
            phongTrangChu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu4)
                .addContainerGap())
        );

        phongTrangChu5.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu5.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu5.setText("101TC");

        lblLoaiPhongTrangChu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu5.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu5.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu5Layout = new javax.swing.GroupLayout(phongTrangChu5);
        phongTrangChu5.setLayout(phongTrangChu5Layout);
        phongTrangChu5Layout.setHorizontalGroup(
            phongTrangChu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu5, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu5Layout.setVerticalGroup(
            phongTrangChu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu5)
                .addContainerGap())
        );

        phongTrangChu6.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu6.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu6.setText("101TC");

        lblLoaiPhongTrangChu6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu6.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu6.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu6Layout = new javax.swing.GroupLayout(phongTrangChu6);
        phongTrangChu6.setLayout(phongTrangChu6Layout);
        phongTrangChu6Layout.setHorizontalGroup(
            phongTrangChu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu6, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu6Layout.setVerticalGroup(
            phongTrangChu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu6)
                .addContainerGap())
        );

        phongTrangChu7.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu7.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu7.setText("101TC");

        lblLoaiPhongTrangChu7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu7.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu7.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu7Layout = new javax.swing.GroupLayout(phongTrangChu7);
        phongTrangChu7.setLayout(phongTrangChu7Layout);
        phongTrangChu7Layout.setHorizontalGroup(
            phongTrangChu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu7, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu7Layout.setVerticalGroup(
            phongTrangChu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu7)
                .addContainerGap())
        );

        phongTrangChu8.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu8.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu8.setText("101TC");

        lblLoaiPhongTrangChu8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu8.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu8.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu8Layout = new javax.swing.GroupLayout(phongTrangChu8);
        phongTrangChu8.setLayout(phongTrangChu8Layout);
        phongTrangChu8Layout.setHorizontalGroup(
            phongTrangChu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu8, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu8Layout.setVerticalGroup(
            phongTrangChu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu8)
                .addContainerGap())
        );

        phongTrangChu9.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu9.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu9.setText("101TC");

        lblLoaiPhongTrangChu9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu9.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu9.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu9Layout = new javax.swing.GroupLayout(phongTrangChu9);
        phongTrangChu9.setLayout(phongTrangChu9Layout);
        phongTrangChu9Layout.setHorizontalGroup(
            phongTrangChu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu9, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu9Layout.setVerticalGroup(
            phongTrangChu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu9)
                .addContainerGap())
        );

        phongTrangChu10.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu10.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu10.setText("101TC");

        lblLoaiPhongTrangChu10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu10.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu10.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu10Layout = new javax.swing.GroupLayout(phongTrangChu10);
        phongTrangChu10.setLayout(phongTrangChu10Layout);
        phongTrangChu10Layout.setHorizontalGroup(
            phongTrangChu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu10, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu10Layout.setVerticalGroup(
            phongTrangChu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Tang1_TrangChu1.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongTrangChu11.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu11.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu11.setText("101TC");

        lblLoaiPhongTrangChu11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu11.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu11.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu11Layout = new javax.swing.GroupLayout(phongTrangChu11);
        phongTrangChu11.setLayout(phongTrangChu11Layout);
        phongTrangChu11Layout.setHorizontalGroup(
            phongTrangChu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu11, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu11Layout.setVerticalGroup(
            phongTrangChu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu11)
                .addContainerGap())
        );

        phongTrangChu12.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu12.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu12.setText("101TC");

        lblLoaiPhongTrangChu12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu12.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu12.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu12Layout = new javax.swing.GroupLayout(phongTrangChu12);
        phongTrangChu12.setLayout(phongTrangChu12Layout);
        phongTrangChu12Layout.setHorizontalGroup(
            phongTrangChu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu12, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu12Layout.setVerticalGroup(
            phongTrangChu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu12)
                .addContainerGap())
        );

        phongTrangChu13.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu13.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu13.setText("101TC");

        lblLoaiPhongTrangChu13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu13.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu13.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu13Layout = new javax.swing.GroupLayout(phongTrangChu13);
        phongTrangChu13.setLayout(phongTrangChu13Layout);
        phongTrangChu13Layout.setHorizontalGroup(
            phongTrangChu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu13, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu13Layout.setVerticalGroup(
            phongTrangChu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu13)
                .addContainerGap())
        );

        phongTrangChu14.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu14.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu14.setText("101TC");

        lblLoaiPhongTrangChu14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu14.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu14.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu14Layout = new javax.swing.GroupLayout(phongTrangChu14);
        phongTrangChu14.setLayout(phongTrangChu14Layout);
        phongTrangChu14Layout.setHorizontalGroup(
            phongTrangChu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu14, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu14Layout.setVerticalGroup(
            phongTrangChu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu14)
                .addContainerGap())
        );

        phongTrangChu15.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu15.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu15.setText("101TC");

        lblLoaiPhongTrangChu15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu15.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu15.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu15Layout = new javax.swing.GroupLayout(phongTrangChu15);
        phongTrangChu15.setLayout(phongTrangChu15Layout);
        phongTrangChu15Layout.setHorizontalGroup(
            phongTrangChu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu15, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu15Layout.setVerticalGroup(
            phongTrangChu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu15)
                .addContainerGap())
        );

        phongTrangChu16.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu16.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu16.setText("101TC");

        lblLoaiPhongTrangChu16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu16.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu16.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu16Layout = new javax.swing.GroupLayout(phongTrangChu16);
        phongTrangChu16.setLayout(phongTrangChu16Layout);
        phongTrangChu16Layout.setHorizontalGroup(
            phongTrangChu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu16, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu16Layout.setVerticalGroup(
            phongTrangChu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu16)
                .addContainerGap())
        );

        phongTrangChu17.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu17.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu17.setText("101TC");

        lblLoaiPhongTrangChu17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu17.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu17.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu17Layout = new javax.swing.GroupLayout(phongTrangChu17);
        phongTrangChu17.setLayout(phongTrangChu17Layout);
        phongTrangChu17Layout.setHorizontalGroup(
            phongTrangChu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu17, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu17Layout.setVerticalGroup(
            phongTrangChu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu17)
                .addContainerGap())
        );

        phongTrangChu18.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu18.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu18.setText("101TC");

        lblLoaiPhongTrangChu18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu18.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu18.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu18Layout = new javax.swing.GroupLayout(phongTrangChu18);
        phongTrangChu18.setLayout(phongTrangChu18Layout);
        phongTrangChu18Layout.setHorizontalGroup(
            phongTrangChu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu18, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu18Layout.setVerticalGroup(
            phongTrangChu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu18)
                .addContainerGap())
        );

        phongTrangChu19.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu19.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu19.setText("101TC");

        lblLoaiPhongTrangChu19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu19.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu19.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu19Layout = new javax.swing.GroupLayout(phongTrangChu19);
        phongTrangChu19.setLayout(phongTrangChu19Layout);
        phongTrangChu19Layout.setHorizontalGroup(
            phongTrangChu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu19, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu19Layout.setVerticalGroup(
            phongTrangChu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu19)
                .addContainerGap())
        );

        phongTrangChu20.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu20.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu20.setText("101TC");

        lblLoaiPhongTrangChu20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu20.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu20.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu20Layout = new javax.swing.GroupLayout(phongTrangChu20);
        phongTrangChu20.setLayout(phongTrangChu20Layout);
        phongTrangChu20Layout.setHorizontalGroup(
            phongTrangChu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu20, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu20Layout.setVerticalGroup(
            phongTrangChu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu20)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongTrangChu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChu1Layout = new javax.swing.GroupLayout(Tang1_TrangChu1);
        Tang1_TrangChu1.setLayout(Tang1_TrangChu1Layout);
        Tang1_TrangChu1Layout.setHorizontalGroup(
            Tang1_TrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1_TrangChu1Layout.setVerticalGroup(
            Tang1_TrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang1_TrangChu2.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongTrangChu21.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu21.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu21.setText("101TC");

        lblLoaiPhongTrangChu21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu21.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu21.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu21Layout = new javax.swing.GroupLayout(phongTrangChu21);
        phongTrangChu21.setLayout(phongTrangChu21Layout);
        phongTrangChu21Layout.setHorizontalGroup(
            phongTrangChu21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu21, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu21Layout.setVerticalGroup(
            phongTrangChu21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu21)
                .addContainerGap())
        );

        phongTrangChu22.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu22.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu22.setText("101TC");

        lblLoaiPhongTrangChu22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu22.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu22.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu22Layout = new javax.swing.GroupLayout(phongTrangChu22);
        phongTrangChu22.setLayout(phongTrangChu22Layout);
        phongTrangChu22Layout.setHorizontalGroup(
            phongTrangChu22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu22, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu22Layout.setVerticalGroup(
            phongTrangChu22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu22)
                .addContainerGap())
        );

        phongTrangChu23.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu23.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu23.setText("101TC");

        lblLoaiPhongTrangChu23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu23.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu23.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu23Layout = new javax.swing.GroupLayout(phongTrangChu23);
        phongTrangChu23.setLayout(phongTrangChu23Layout);
        phongTrangChu23Layout.setHorizontalGroup(
            phongTrangChu23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu23, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu23Layout.setVerticalGroup(
            phongTrangChu23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu23)
                .addContainerGap())
        );

        phongTrangChu24.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu24.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu24.setText("101TC");

        lblLoaiPhongTrangChu24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu24.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu24.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu24Layout = new javax.swing.GroupLayout(phongTrangChu24);
        phongTrangChu24.setLayout(phongTrangChu24Layout);
        phongTrangChu24Layout.setHorizontalGroup(
            phongTrangChu24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu24, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu24Layout.setVerticalGroup(
            phongTrangChu24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu24)
                .addContainerGap())
        );

        phongTrangChu25.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu25.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu25.setText("101TC");

        lblLoaiPhongTrangChu25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu25.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu25.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu25Layout = new javax.swing.GroupLayout(phongTrangChu25);
        phongTrangChu25.setLayout(phongTrangChu25Layout);
        phongTrangChu25Layout.setHorizontalGroup(
            phongTrangChu25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu25, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu25Layout.setVerticalGroup(
            phongTrangChu25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu25)
                .addContainerGap())
        );

        phongTrangChu26.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu26.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu26.setText("101TC");

        lblLoaiPhongTrangChu26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu26.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu26.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu26Layout = new javax.swing.GroupLayout(phongTrangChu26);
        phongTrangChu26.setLayout(phongTrangChu26Layout);
        phongTrangChu26Layout.setHorizontalGroup(
            phongTrangChu26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu26, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu26Layout.setVerticalGroup(
            phongTrangChu26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu26)
                .addContainerGap())
        );

        phongTrangChu27.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu27.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu27.setText("101TC");

        lblLoaiPhongTrangChu27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu27.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu27.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu27Layout = new javax.swing.GroupLayout(phongTrangChu27);
        phongTrangChu27.setLayout(phongTrangChu27Layout);
        phongTrangChu27Layout.setHorizontalGroup(
            phongTrangChu27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu27, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu27Layout.setVerticalGroup(
            phongTrangChu27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu27)
                .addContainerGap())
        );

        phongTrangChu28.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu28.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu28.setText("101TC");

        lblLoaiPhongTrangChu28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu28.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu28.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu28Layout = new javax.swing.GroupLayout(phongTrangChu28);
        phongTrangChu28.setLayout(phongTrangChu28Layout);
        phongTrangChu28Layout.setHorizontalGroup(
            phongTrangChu28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu28, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu28Layout.setVerticalGroup(
            phongTrangChu28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu28)
                .addContainerGap())
        );

        phongTrangChu29.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu29.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu29.setText("101TC");

        lblLoaiPhongTrangChu29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu29.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu29.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu29Layout = new javax.swing.GroupLayout(phongTrangChu29);
        phongTrangChu29.setLayout(phongTrangChu29Layout);
        phongTrangChu29Layout.setHorizontalGroup(
            phongTrangChu29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu29, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu29Layout.setVerticalGroup(
            phongTrangChu29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu29)
                .addContainerGap())
        );

        phongTrangChu30.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu30.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu30.setText("101TC");

        lblLoaiPhongTrangChu30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu30.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu30.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu30Layout = new javax.swing.GroupLayout(phongTrangChu30);
        phongTrangChu30.setLayout(phongTrangChu30Layout);
        phongTrangChu30Layout.setHorizontalGroup(
            phongTrangChu30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu30, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu30Layout.setVerticalGroup(
            phongTrangChu30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu30)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongTrangChu21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChu2Layout = new javax.swing.GroupLayout(Tang1_TrangChu2);
        Tang1_TrangChu2.setLayout(Tang1_TrangChu2Layout);
        Tang1_TrangChu2Layout.setHorizontalGroup(
            Tang1_TrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1_TrangChu2Layout.setVerticalGroup(
            Tang1_TrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang1_TrangChu3.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 4", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongTrangChu31.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu31.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu31.setText("101TC");

        lblLoaiPhongTrangChu31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu31.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu31.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu31Layout = new javax.swing.GroupLayout(phongTrangChu31);
        phongTrangChu31.setLayout(phongTrangChu31Layout);
        phongTrangChu31Layout.setHorizontalGroup(
            phongTrangChu31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu31, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu31Layout.setVerticalGroup(
            phongTrangChu31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu31)
                .addContainerGap())
        );

        phongTrangChu32.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu32.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu32.setText("101TC");

        lblLoaiPhongTrangChu32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu32.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu32.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu32Layout = new javax.swing.GroupLayout(phongTrangChu32);
        phongTrangChu32.setLayout(phongTrangChu32Layout);
        phongTrangChu32Layout.setHorizontalGroup(
            phongTrangChu32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu32, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu32Layout.setVerticalGroup(
            phongTrangChu32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu32)
                .addContainerGap())
        );

        phongTrangChu33.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu33.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu33.setText("101TC");

        lblLoaiPhongTrangChu33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu33.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu33.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu33Layout = new javax.swing.GroupLayout(phongTrangChu33);
        phongTrangChu33.setLayout(phongTrangChu33Layout);
        phongTrangChu33Layout.setHorizontalGroup(
            phongTrangChu33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu33, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu33Layout.setVerticalGroup(
            phongTrangChu33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu33)
                .addContainerGap())
        );

        phongTrangChu34.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu34.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu34.setText("101TC");

        lblLoaiPhongTrangChu34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu34.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu34.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu34Layout = new javax.swing.GroupLayout(phongTrangChu34);
        phongTrangChu34.setLayout(phongTrangChu34Layout);
        phongTrangChu34Layout.setHorizontalGroup(
            phongTrangChu34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu34, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu34Layout.setVerticalGroup(
            phongTrangChu34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu34)
                .addContainerGap())
        );

        phongTrangChu35.setBackground(new java.awt.Color(255, 255, 153));
        phongTrangChu35.setPreferredSize(new java.awt.Dimension(109, 85));

        lblTenPhongTrangChu35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu35.setText("101TC");

        lblLoaiPhongTrangChu35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu35.setText("Tiêu chuẩn");

        lblTrangThaiTrangChu35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu35.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu35Layout = new javax.swing.GroupLayout(phongTrangChu35);
        phongTrangChu35.setLayout(phongTrangChu35Layout);
        phongTrangChu35Layout.setHorizontalGroup(
            phongTrangChu35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongTrangChu35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhongTrangChu35, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhongTrangChu35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongTrangChu35Layout.setVerticalGroup(
            phongTrangChu35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblTenPhongTrangChu35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu35)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongTrangChu31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongTrangChu35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChu3Layout = new javax.swing.GroupLayout(Tang1_TrangChu3);
        Tang1_TrangChu3.setLayout(Tang1_TrangChu3Layout);
        Tang1_TrangChu3Layout.setHorizontalGroup(
            Tang1_TrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1_TrangChu3Layout.setVerticalGroup(
            Tang1_TrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnBody1Layout = new javax.swing.GroupLayout(pnBody1);
        pnBody1.setLayout(pnBody1Layout);
        pnBody1Layout.setHorizontalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Tang1_TrangChu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang1_TrangChu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang1_TrangChu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBody1Layout.setVerticalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnLayOutTrangChuLayout = new javax.swing.GroupLayout(pnLayOutTrangChu);
        pnLayOutTrangChu.setLayout(pnLayOutTrangChuLayout);
        pnLayOutTrangChuLayout.setHorizontalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnBody1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnLayOutTrangChuLayout.setVerticalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnBody1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTrangChuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnLayOutTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnLayOutTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab1", pnTrangChu);

        pnBody2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tang1_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        Tang1_QuanLyPhong.setMinimumSize(new java.awt.Dimension(1150, 120));

        phongQuanLy1.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy1.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL1.setText("101TC");

        lblLoaiPhongQL1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL1.setText("Tiêu chuẩn");
        lblLoaiPhongQL1.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL1.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL1.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL1)
                .addContainerGap())
        );

        phongQuanLy2.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy2.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL2.setText("101TC");

        lblLoaiPhongQL2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL2.setText("Tiêu chuẩn");
        lblLoaiPhongQL2.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL2.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL2.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL2)
                .addContainerGap())
        );

        phongQuanLy3.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy3.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL3.setText("101TC");

        lblLoaiPhongQL3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL3.setText("Tiêu chuẩn");
        lblLoaiPhongQL3.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL3.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL3.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL3.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy3Layout = new javax.swing.GroupLayout(phongQuanLy3);
        phongQuanLy3.setLayout(phongQuanLy3Layout);
        phongQuanLy3Layout.setHorizontalGroup(
            phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy3Layout.createSequentialGroup()
                        .addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThaiQL3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy3Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL3)))
                        .addContainerGap())))
        );
        phongQuanLy3Layout.setVerticalGroup(
            phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL3)
                    .addComponent(lblLoaiPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL3)
                .addContainerGap())
        );

        phongQuanLy4.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy4.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL4.setText("101TC");

        lblLoaiPhongQL4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL4.setText("Tiêu chuẩn");
        lblLoaiPhongQL4.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL4.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL4.setPreferredSize(new java.awt.Dimension(72, 16));

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
                    .addGroup(phongQuanLy4Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL4))
                    .addComponent(lblTrangThaiQL4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy4Layout.setVerticalGroup(
            phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL4)
                    .addComponent(lblLoaiPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL4)
                .addContainerGap())
        );

        phongQuanLy5.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy5.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL5.setText("101TC");

        lblLoaiPhongQL5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL5.setText("Thương gia");
        lblLoaiPhongQL5.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL5.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL5.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL5.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy5Layout = new javax.swing.GroupLayout(phongQuanLy5);
        phongQuanLy5.setLayout(phongQuanLy5Layout);
        phongQuanLy5Layout.setHorizontalGroup(
            phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy5Layout.createSequentialGroup()
                        .addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(phongQuanLy5Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBoxPhongQL5))
                            .addComponent(lblTrangThaiQL5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy5Layout.setVerticalGroup(
            phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL5)
                    .addComponent(lblLoaiPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL5)
                .addContainerGap())
        );

        phongQuanLy6.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy6.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL6.setText("101TC");

        lblLoaiPhongQL6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL6.setText("Tiêu chuẩn");
        lblLoaiPhongQL6.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL6.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL6.setPreferredSize(new java.awt.Dimension(72, 16));

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
                    .addComponent(lblLoaiPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL6)
                .addContainerGap())
        );

        phongQuanLy7.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy7.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL7.setText("101TC");

        lblLoaiPhongQL7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL7.setText("Tiêu chuẩn");
        lblLoaiPhongQL7.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL7.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL7.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL7.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy7Layout = new javax.swing.GroupLayout(phongQuanLy7);
        phongQuanLy7.setLayout(phongQuanLy7Layout);
        phongQuanLy7Layout.setHorizontalGroup(
            phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy7Layout.createSequentialGroup()
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
                    .addComponent(lblLoaiPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL7)
                .addContainerGap())
        );

        phongQuanLy8.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy8.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL8.setText("101TC");

        lblLoaiPhongQL8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL8.setText("Tiêu chuẩn");
        lblLoaiPhongQL8.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL8.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL8.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL8.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy8Layout = new javax.swing.GroupLayout(phongQuanLy8);
        phongQuanLy8.setLayout(phongQuanLy8Layout);
        phongQuanLy8Layout.setHorizontalGroup(
            phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy8Layout.createSequentialGroup()
                        .addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThaiQL8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy8Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL8)))
                        .addContainerGap())))
        );
        phongQuanLy8Layout.setVerticalGroup(
            phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL8)
                    .addComponent(lblLoaiPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL8)
                .addContainerGap())
        );

        phongQuanLy9.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy9.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL9.setText("101TC");

        lblLoaiPhongQL9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL9.setText("Tiêu chuẩn");
        lblLoaiPhongQL9.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL9.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL9.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL9)
                .addContainerGap())
        );

        phongQuanLy10.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy10.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL10.setText("101TC");

        lblLoaiPhongQL10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL10.setText("Thương gia");
        lblLoaiPhongQL10.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL10.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL10.setName(""); // NOI18N
        lblLoaiPhongQL10.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL10.setText("Đã đặt");

        javax.swing.GroupLayout phongQuanLy10Layout = new javax.swing.GroupLayout(phongQuanLy10);
        phongQuanLy10.setLayout(phongQuanLy10Layout);
        phongQuanLy10Layout.setHorizontalGroup(
            phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy10Layout.createSequentialGroup()
                        .addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy10Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL10))
                            .addComponent(lblTrangThaiQL10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy10Layout.setVerticalGroup(
            phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL10)
                    .addComponent(lblLoaiPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phongQuanLy10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang1_QuanLyPhong);
        Tang1_QuanLyPhong.setLayout(Tang1_QuanLyPhongLayout);
        Tang1_QuanLyPhongLayout.setHorizontalGroup(
            Tang1_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1_QuanLyPhongLayout.setVerticalGroup(
            Tang1_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang2_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang2_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        Tang2_QuanLyPhong.setMinimumSize(new java.awt.Dimension(1150, 120));

        jPanel11.setMinimumSize(new java.awt.Dimension(1150, 120));

        phongQuanLy11.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy11.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL11.setText("101TC");

        lblLoaiPhongQL11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL11.setText("Tiêu chuẩn");
        lblLoaiPhongQL11.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL11.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL11.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL11)
                .addContainerGap())
        );

        phongQuanLy12.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy12.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL12.setText("101TC");

        lblLoaiPhongQL12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL12.setText("Thương gia");
        lblLoaiPhongQL12.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL12.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL12.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL12.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy12Layout = new javax.swing.GroupLayout(phongQuanLy12);
        phongQuanLy12.setLayout(phongQuanLy12Layout);
        phongQuanLy12Layout.setHorizontalGroup(
            phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy12Layout.createSequentialGroup()
                        .addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThaiQL12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy12Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL12)))
                        .addContainerGap())))
        );
        phongQuanLy12Layout.setVerticalGroup(
            phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL12)
                    .addComponent(lblLoaiPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL12)
                .addContainerGap())
        );

        phongQuanLy13.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy13.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL13.setText("101TC");

        lblLoaiPhongQL13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL13.setText("Nâng cao");
        lblLoaiPhongQL13.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL13.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL13.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL13.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy13Layout = new javax.swing.GroupLayout(phongQuanLy13);
        phongQuanLy13.setLayout(phongQuanLy13Layout);
        phongQuanLy13Layout.setHorizontalGroup(
            phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTrangThaiQL13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(phongQuanLy13Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL13)))
                .addContainerGap())
            .addComponent(lblTenPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phongQuanLy13Layout.setVerticalGroup(
            phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL13)
                    .addComponent(lblLoaiPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL13)
                .addContainerGap())
        );

        phongQuanLy14.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy14.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL14.setText("101TC");

        lblLoaiPhongQL14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL14.setText("Nâng cao");
        lblLoaiPhongQL14.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL14.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL14.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL14.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy14Layout = new javax.swing.GroupLayout(phongQuanLy14);
        phongQuanLy14.setLayout(phongQuanLy14Layout);
        phongQuanLy14Layout.setHorizontalGroup(
            phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy14Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL14))
                    .addComponent(lblTrangThaiQL14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy14Layout.setVerticalGroup(
            phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL14)
                    .addComponent(lblLoaiPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL14)
                .addContainerGap())
        );

        phongQuanLy15.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy15.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL15.setText("101TC");

        lblLoaiPhongQL15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL15.setText("Thương gia");
        lblLoaiPhongQL15.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL15.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL15.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL15.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy15Layout = new javax.swing.GroupLayout(phongQuanLy15);
        phongQuanLy15.setLayout(phongQuanLy15Layout);
        phongQuanLy15Layout.setHorizontalGroup(
            phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy15Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL15))
                    .addComponent(lblTenPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy15Layout.setVerticalGroup(
            phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL15)
                    .addComponent(lblLoaiPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL15)
                .addContainerGap())
        );

        phongQuanLy16.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy16.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL16.setText("101TC");

        lblLoaiPhongQL16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL16.setText("Cao cấp");
        lblLoaiPhongQL16.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL16.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL16.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL16)
                .addContainerGap())
        );

        phongQuanLy17.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy17.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL17.setText("101TC");

        lblLoaiPhongQL17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL17.setText("Tiêu chuẩn");
        lblLoaiPhongQL17.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL17.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL17.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL17.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy17Layout = new javax.swing.GroupLayout(phongQuanLy17);
        phongQuanLy17.setLayout(phongQuanLy17Layout);
        phongQuanLy17Layout.setHorizontalGroup(
            phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy17Layout.createSequentialGroup()
                        .addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy17Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL17))
                            .addComponent(lblTrangThaiQL17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy17Layout.setVerticalGroup(
            phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL17)
                    .addComponent(lblLoaiPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL17)
                .addContainerGap())
        );

        phongQuanLy18.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy18.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL18.setText("101TC");

        lblLoaiPhongQL18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL18.setText("Tiêu chuẩn");
        lblLoaiPhongQL18.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL18.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL18.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL18.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy18Layout = new javax.swing.GroupLayout(phongQuanLy18);
        phongQuanLy18.setLayout(phongQuanLy18Layout);
        phongQuanLy18Layout.setHorizontalGroup(
            phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy18Layout.createSequentialGroup()
                        .addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy18Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL18))
                            .addComponent(lblTrangThaiQL18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy18Layout.setVerticalGroup(
            phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL18)
                    .addComponent(lblLoaiPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL18)
                .addContainerGap())
        );

        phongQuanLy19.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy19.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL19.setText("101TC");

        lblLoaiPhongQL19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL19.setText("Cao cấp");
        lblLoaiPhongQL19.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL19.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL19.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL19.setText("Đang trống");

        javax.swing.GroupLayout phongQuanLy19Layout = new javax.swing.GroupLayout(phongQuanLy19);
        phongQuanLy19.setLayout(phongQuanLy19Layout);
        phongQuanLy19Layout.setHorizontalGroup(
            phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy19Layout.createSequentialGroup()
                        .addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy19Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL19))
                            .addComponent(lblTrangThaiQL19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy19Layout.setVerticalGroup(
            phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL19)
                    .addComponent(lblLoaiPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL19)
                .addContainerGap())
        );

        phongQuanLy20.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy20.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL20.setText("101TC");

        lblLoaiPhongQL20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL20.setText("Tiêu chuẩn");
        lblLoaiPhongQL20.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL20.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL20.setName(""); // NOI18N
        lblLoaiPhongQL20.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL20.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy20Layout = new javax.swing.GroupLayout(phongQuanLy20);
        phongQuanLy20.setLayout(phongQuanLy20Layout);
        phongQuanLy20Layout.setHorizontalGroup(
            phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy20Layout.createSequentialGroup()
                        .addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy20Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL20))
                            .addComponent(lblTrangThaiQL20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy20Layout.setVerticalGroup(
            phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL20)
                    .addComponent(lblLoaiPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL20)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang2_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang2_QuanLyPhong);
        Tang2_QuanLyPhong.setLayout(Tang2_QuanLyPhongLayout);
        Tang2_QuanLyPhongLayout.setHorizontalGroup(
            Tang2_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang2_QuanLyPhongLayout.setVerticalGroup(
            Tang2_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Tang3_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang3_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        Tang3_QuanLyPhong.setMaximumSize(new java.awt.Dimension(1150, 120));
        Tang3_QuanLyPhong.setMinimumSize(new java.awt.Dimension(1150, 120));
        Tang3_QuanLyPhong.setPreferredSize(new java.awt.Dimension(72, 16));

        phongQuanLy21.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy21.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL21.setText("101TC");

        lblLoaiPhongQL21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL21.setText("Tiêu chuẩn");
        lblLoaiPhongQL21.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL21.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL21.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL21.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy21Layout = new javax.swing.GroupLayout(phongQuanLy21);
        phongQuanLy21.setLayout(phongQuanLy21Layout);
        phongQuanLy21Layout.setHorizontalGroup(
            phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy21Layout.createSequentialGroup()
                        .addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTenPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(phongQuanLy21Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addComponent(checkBoxPhongQL21)))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy21Layout.createSequentialGroup()
                        .addComponent(lblTrangThaiQL21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        phongQuanLy21Layout.setVerticalGroup(
            phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL21)
                    .addComponent(lblLoaiPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL21)
                .addContainerGap())
        );

        phongQuanLy22.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy22.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL22.setText("101TC");

        lblLoaiPhongQL22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL22.setText("Nâng cao");
        lblLoaiPhongQL22.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL22.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL22.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        phongQuanLy23.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy23.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL23.setText("101TC");

        lblLoaiPhongQL23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL23.setText("Tiêu chuẩn");
        lblLoaiPhongQL23.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL23.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL23.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL23)
                .addContainerGap())
        );

        phongQuanLy24.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy24.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL24.setText("101TC");

        lblLoaiPhongQL24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL24.setText("Tiêu chuẩn");
        lblLoaiPhongQL24.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL24.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL24.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL24.setText("Đã đặt");

        javax.swing.GroupLayout phongQuanLy24Layout = new javax.swing.GroupLayout(phongQuanLy24);
        phongQuanLy24.setLayout(phongQuanLy24Layout);
        phongQuanLy24Layout.setHorizontalGroup(
            phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy24Layout.createSequentialGroup()
                        .addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTenPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(phongQuanLy24Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addGap(4, 4, 4)
                                .addComponent(checkBoxPhongQL24)))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy24Layout.createSequentialGroup()
                        .addComponent(lblTrangThaiQL24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        phongQuanLy24Layout.setVerticalGroup(
            phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL24)
                    .addComponent(lblLoaiPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL24)
                .addContainerGap())
        );

        phongQuanLy25.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy25.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL25.setText("101TC");

        lblLoaiPhongQL25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL25.setText("Tiêu chuẩn");
        lblLoaiPhongQL25.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL25.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL25.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL25.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy25Layout = new javax.swing.GroupLayout(phongQuanLy25);
        phongQuanLy25.setLayout(phongQuanLy25Layout);
        phongQuanLy25Layout.setHorizontalGroup(
            phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy25Layout.createSequentialGroup()
                        .addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy25Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL25))
                            .addComponent(lblTrangThaiQL25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy25Layout.setVerticalGroup(
            phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL25)
                    .addComponent(lblLoaiPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL25)
                .addContainerGap())
        );

        phongQuanLy26.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy26.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL26.setText("101TC");

        lblLoaiPhongQL26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL26.setText("Nâng cao");
        lblLoaiPhongQL26.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL26.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL26.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL26.setText("Đang trống");

        javax.swing.GroupLayout phongQuanLy26Layout = new javax.swing.GroupLayout(phongQuanLy26);
        phongQuanLy26.setLayout(phongQuanLy26Layout);
        phongQuanLy26Layout.setHorizontalGroup(
            phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy26Layout.createSequentialGroup()
                        .addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy26Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL26))
                            .addComponent(lblTrangThaiQL26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy26Layout.setVerticalGroup(
            phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL26)
                    .addComponent(lblLoaiPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiQL26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy27.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy27.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL27.setText("101TC");

        lblLoaiPhongQL27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL27.setText("Thương gia");
        lblLoaiPhongQL27.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL27.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL27.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiQL27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy28.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy28.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL28.setText("101TC");

        lblLoaiPhongQL28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL28.setText("Cao cấp");
        lblLoaiPhongQL28.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL28.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL28.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL28.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy28Layout = new javax.swing.GroupLayout(phongQuanLy28);
        phongQuanLy28.setLayout(phongQuanLy28Layout);
        phongQuanLy28Layout.setHorizontalGroup(
            phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy28Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL28)
                .addContainerGap())
        );

        phongQuanLy29.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy29.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL29.setText("101TC");

        lblLoaiPhongQL29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL29.setText("Nâng cao");
        lblLoaiPhongQL29.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL29.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL29.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL29.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy29Layout = new javax.swing.GroupLayout(phongQuanLy29);
        phongQuanLy29.setLayout(phongQuanLy29Layout);
        phongQuanLy29Layout.setHorizontalGroup(
            phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenPhongQL29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy29Layout.createSequentialGroup()
                        .addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy29Layout.createSequentialGroup()
                                .addComponent(lblLoaiPhongQL29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxPhongQL29))
                            .addComponent(lblTrangThaiQL29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        phongQuanLy29Layout.setVerticalGroup(
            phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL29)
                    .addComponent(lblLoaiPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL29)
                .addContainerGap())
        );

        phongQuanLy30.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy30.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL30.setText("101TC");

        lblLoaiPhongQL30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL30.setText("Thương gia");
        lblLoaiPhongQL30.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL30.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL30.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL30)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(phongQuanLy28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phongQuanLy30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang3_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang3_QuanLyPhong);
        Tang3_QuanLyPhong.setLayout(Tang3_QuanLyPhongLayout);
        Tang3_QuanLyPhongLayout.setHorizontalGroup(
            Tang3_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang3_QuanLyPhongLayout.setVerticalGroup(
            Tang3_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Tang4_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang4_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 4", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongQuanLy31.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy31.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL31.setText("101TC");

        lblLoaiPhongQL31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL31.setText("Tiêu chuẩn");
        lblLoaiPhongQL31.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL31.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL31.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTrangThaiQL31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL31.setText("Đang trống");

        javax.swing.GroupLayout phongQuanLy31Layout = new javax.swing.GroupLayout(phongQuanLy31);
        phongQuanLy31.setLayout(phongQuanLy31Layout);
        phongQuanLy31Layout.setHorizontalGroup(
            phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrangThaiQL31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phongQuanLy31Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhongQL31))
                    .addComponent(lblTenPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy31Layout.setVerticalGroup(
            phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhongQL31)
                    .addComponent(lblLoaiPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiQL31)
                .addContainerGap())
        );

        phongQuanLy32.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy32.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL32.setText("101TC");

        lblLoaiPhongQL32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL32.setText("Thương gia");
        lblLoaiPhongQL32.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL32.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL32.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL32)
                .addContainerGap())
        );

        phongQuanLy33.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy33.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL33.setText("101TC");

        lblLoaiPhongQL33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL33.setText("Tiêu chuẩn");
        lblLoaiPhongQL33.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL33.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL33.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL33)
                .addContainerGap())
        );

        phongQuanLy34.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy34.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL34.setText("101TC");

        lblLoaiPhongQL34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL34.setText("Tiêu chuẩn");
        lblLoaiPhongQL34.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL34.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL34.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL34)
                .addContainerGap())
        );

        phongQuanLy35.setBackground(new java.awt.Color(255, 255, 153));
        phongQuanLy35.setPreferredSize(new java.awt.Dimension(108, 84));

        lblTenPhongQL35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL35.setText("101TC");

        lblLoaiPhongQL35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL35.setText("Thương gia");
        lblLoaiPhongQL35.setMaximumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL35.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL35.setPreferredSize(new java.awt.Dimension(72, 16));

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
                        .addComponent(lblLoaiPhongQL35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblLoaiPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiQL35)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(612, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(phongQuanLy34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongQuanLy35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang4_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang4_QuanLyPhong);
        Tang4_QuanLyPhong.setLayout(Tang4_QuanLyPhongLayout);
        Tang4_QuanLyPhongLayout.setHorizontalGroup(
            Tang4_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap()
                .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Tang1_QuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tang3_QuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
                        .addComponent(Tang2_QuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Tang4_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        pnBody2Layout.setVerticalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Tang1_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang2_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang3_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                        .addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addComponent(ScrollPaneQuanLyPhong))
                .addContainerGap())
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
					p.setVisible(false);
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
					p.setVisible(false);
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
					p.setVisible(false);
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
					p.setVisible(false);
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
					p.setVisible(false);
				}
			}
		} else if (radPhongDaDat.isSelected()) {
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel trangThaiP = trangThaiQuanLy[i];

				if (trangThaiP.getText().equalsIgnoreCase("Đã đặt")) {
					p.setBackground(red);
				} else {
					p.setVisible(false);
				}
			}
		} else if (radPhongDangThue.isSelected()) {
			for (int i = 0; i < phongQuanLy.length; i++) {
				JPanel p = phongQuanLy[i];
				JLabel trangThaiP = trangThaiQuanLy[i];

				if (trangThaiP.getText().equalsIgnoreCase("Đang thuê")) {
					p.setBackground(red);
				} else {
					p.setVisible(false);
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
        
        private void loadDuLieuPhonglenGiaoDien(){
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
        
            PhongDao daoPhong = new PhongDao();
            List<Phong> listPhong = daoPhong.timTatCaPhong();
			for (int i = 0; i < listPhong.size(); i++) {
				Phong p = listPhong.get(i);
				JPanel phong = phongQuanLy[i];
				JLabel loaiPhong = loaiPhongQuanLy[i];
				JLabel tenPhong = tenPhongQuanLy[i];
				JLabel trangThai = trangThaiQuanLy[i];
				JCheckBox ck = cksQuanLy[i];
				loaiPhong.setText(p.getLoaiPhong().getTenLoaiPhong());
				tenPhong.setText(Integer.toString(p.getSoPhong()));
				trangThai.setText(p.getTrangThai());
				if (trangThai.getText().equalsIgnoreCase("SS")) {
					phong.setBackground(Color.GREEN);
				} else if (trangThai.getText().equalsIgnoreCase("Đã đặt")) {
					phong.setBackground(Color.YELLOW);
				} else if (trangThai.getText().equalsIgnoreCase("Đang thuê")) {
					phong.setBackground(Color.RED);
				}
			}
            
            
        }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header Header;
    private menu.Menu Menu;
    private javax.swing.JScrollPane ScrollPaneQuanLyPhong;
    private javax.swing.JTable TableDichVu;
    private javax.swing.JTable TableKhachHang;
    private javax.swing.JTable TableKhuyenMai;
    private javax.swing.JTable TableNhanVien;
    private javax.swing.JPanel Tang1_QuanLyPhong;
    private javax.swing.JPanel Tang1_TrangChu;
    private javax.swing.JPanel Tang1_TrangChu1;
    private javax.swing.JPanel Tang1_TrangChu2;
    private javax.swing.JPanel Tang1_TrangChu3;
    private javax.swing.JPanel Tang2_QuanLyPhong;
    private javax.swing.JPanel Tang3_QuanLyPhong;
    private javax.swing.JPanel Tang4_QuanLyPhong;
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
    private javax.swing.JLabel lblLoaiPhongTrangChu1;
    private javax.swing.JLabel lblLoaiPhongTrangChu10;
    private javax.swing.JLabel lblLoaiPhongTrangChu11;
    private javax.swing.JLabel lblLoaiPhongTrangChu12;
    private javax.swing.JLabel lblLoaiPhongTrangChu13;
    private javax.swing.JLabel lblLoaiPhongTrangChu14;
    private javax.swing.JLabel lblLoaiPhongTrangChu15;
    private javax.swing.JLabel lblLoaiPhongTrangChu16;
    private javax.swing.JLabel lblLoaiPhongTrangChu17;
    private javax.swing.JLabel lblLoaiPhongTrangChu18;
    private javax.swing.JLabel lblLoaiPhongTrangChu19;
    private javax.swing.JLabel lblLoaiPhongTrangChu2;
    private javax.swing.JLabel lblLoaiPhongTrangChu20;
    private javax.swing.JLabel lblLoaiPhongTrangChu21;
    private javax.swing.JLabel lblLoaiPhongTrangChu22;
    private javax.swing.JLabel lblLoaiPhongTrangChu23;
    private javax.swing.JLabel lblLoaiPhongTrangChu24;
    private javax.swing.JLabel lblLoaiPhongTrangChu25;
    private javax.swing.JLabel lblLoaiPhongTrangChu26;
    private javax.swing.JLabel lblLoaiPhongTrangChu27;
    private javax.swing.JLabel lblLoaiPhongTrangChu28;
    private javax.swing.JLabel lblLoaiPhongTrangChu29;
    private javax.swing.JLabel lblLoaiPhongTrangChu3;
    private javax.swing.JLabel lblLoaiPhongTrangChu30;
    private javax.swing.JLabel lblLoaiPhongTrangChu31;
    private javax.swing.JLabel lblLoaiPhongTrangChu32;
    private javax.swing.JLabel lblLoaiPhongTrangChu33;
    private javax.swing.JLabel lblLoaiPhongTrangChu34;
    private javax.swing.JLabel lblLoaiPhongTrangChu35;
    private javax.swing.JLabel lblLoaiPhongTrangChu4;
    private javax.swing.JLabel lblLoaiPhongTrangChu5;
    private javax.swing.JLabel lblLoaiPhongTrangChu6;
    private javax.swing.JLabel lblLoaiPhongTrangChu7;
    private javax.swing.JLabel lblLoaiPhongTrangChu8;
    private javax.swing.JLabel lblLoaiPhongTrangChu9;
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
    private javax.swing.JLabel lblTenPhongTrangChu1;
    private javax.swing.JLabel lblTenPhongTrangChu10;
    private javax.swing.JLabel lblTenPhongTrangChu11;
    private javax.swing.JLabel lblTenPhongTrangChu12;
    private javax.swing.JLabel lblTenPhongTrangChu13;
    private javax.swing.JLabel lblTenPhongTrangChu14;
    private javax.swing.JLabel lblTenPhongTrangChu15;
    private javax.swing.JLabel lblTenPhongTrangChu16;
    private javax.swing.JLabel lblTenPhongTrangChu17;
    private javax.swing.JLabel lblTenPhongTrangChu18;
    private javax.swing.JLabel lblTenPhongTrangChu19;
    private javax.swing.JLabel lblTenPhongTrangChu2;
    private javax.swing.JLabel lblTenPhongTrangChu20;
    private javax.swing.JLabel lblTenPhongTrangChu21;
    private javax.swing.JLabel lblTenPhongTrangChu22;
    private javax.swing.JLabel lblTenPhongTrangChu23;
    private javax.swing.JLabel lblTenPhongTrangChu24;
    private javax.swing.JLabel lblTenPhongTrangChu25;
    private javax.swing.JLabel lblTenPhongTrangChu26;
    private javax.swing.JLabel lblTenPhongTrangChu27;
    private javax.swing.JLabel lblTenPhongTrangChu28;
    private javax.swing.JLabel lblTenPhongTrangChu29;
    private javax.swing.JLabel lblTenPhongTrangChu3;
    private javax.swing.JLabel lblTenPhongTrangChu30;
    private javax.swing.JLabel lblTenPhongTrangChu31;
    private javax.swing.JLabel lblTenPhongTrangChu32;
    private javax.swing.JLabel lblTenPhongTrangChu33;
    private javax.swing.JLabel lblTenPhongTrangChu34;
    private javax.swing.JLabel lblTenPhongTrangChu35;
    private javax.swing.JLabel lblTenPhongTrangChu4;
    private javax.swing.JLabel lblTenPhongTrangChu5;
    private javax.swing.JLabel lblTenPhongTrangChu6;
    private javax.swing.JLabel lblTenPhongTrangChu7;
    private javax.swing.JLabel lblTenPhongTrangChu8;
    private javax.swing.JLabel lblTenPhongTrangChu9;
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
    private javax.swing.JLabel lblTrangThaiTrangChu1;
    private javax.swing.JLabel lblTrangThaiTrangChu10;
    private javax.swing.JLabel lblTrangThaiTrangChu11;
    private javax.swing.JLabel lblTrangThaiTrangChu12;
    private javax.swing.JLabel lblTrangThaiTrangChu13;
    private javax.swing.JLabel lblTrangThaiTrangChu14;
    private javax.swing.JLabel lblTrangThaiTrangChu15;
    private javax.swing.JLabel lblTrangThaiTrangChu16;
    private javax.swing.JLabel lblTrangThaiTrangChu17;
    private javax.swing.JLabel lblTrangThaiTrangChu18;
    private javax.swing.JLabel lblTrangThaiTrangChu19;
    private javax.swing.JLabel lblTrangThaiTrangChu2;
    private javax.swing.JLabel lblTrangThaiTrangChu20;
    private javax.swing.JLabel lblTrangThaiTrangChu21;
    private javax.swing.JLabel lblTrangThaiTrangChu22;
    private javax.swing.JLabel lblTrangThaiTrangChu23;
    private javax.swing.JLabel lblTrangThaiTrangChu24;
    private javax.swing.JLabel lblTrangThaiTrangChu25;
    private javax.swing.JLabel lblTrangThaiTrangChu26;
    private javax.swing.JLabel lblTrangThaiTrangChu27;
    private javax.swing.JLabel lblTrangThaiTrangChu28;
    private javax.swing.JLabel lblTrangThaiTrangChu29;
    private javax.swing.JLabel lblTrangThaiTrangChu3;
    private javax.swing.JLabel lblTrangThaiTrangChu30;
    private javax.swing.JLabel lblTrangThaiTrangChu31;
    private javax.swing.JLabel lblTrangThaiTrangChu32;
    private javax.swing.JLabel lblTrangThaiTrangChu33;
    private javax.swing.JLabel lblTrangThaiTrangChu34;
    private javax.swing.JLabel lblTrangThaiTrangChu35;
    private javax.swing.JLabel lblTrangThaiTrangChu4;
    private javax.swing.JLabel lblTrangThaiTrangChu5;
    private javax.swing.JLabel lblTrangThaiTrangChu6;
    private javax.swing.JLabel lblTrangThaiTrangChu7;
    private javax.swing.JLabel lblTrangThaiTrangChu8;
    private javax.swing.JLabel lblTrangThaiTrangChu9;
    private javax.swing.JLabel lblcurrentTime;
    private javax.swing.JLabel lblcurrentdate;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbltime;
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
    private javax.swing.JPanel phongTrangChu1;
    private javax.swing.JPanel phongTrangChu10;
    private javax.swing.JPanel phongTrangChu11;
    private javax.swing.JPanel phongTrangChu12;
    private javax.swing.JPanel phongTrangChu13;
    private javax.swing.JPanel phongTrangChu14;
    private javax.swing.JPanel phongTrangChu15;
    private javax.swing.JPanel phongTrangChu16;
    private javax.swing.JPanel phongTrangChu17;
    private javax.swing.JPanel phongTrangChu18;
    private javax.swing.JPanel phongTrangChu19;
    private javax.swing.JPanel phongTrangChu2;
    private javax.swing.JPanel phongTrangChu20;
    private javax.swing.JPanel phongTrangChu21;
    private javax.swing.JPanel phongTrangChu22;
    private javax.swing.JPanel phongTrangChu23;
    private javax.swing.JPanel phongTrangChu24;
    private javax.swing.JPanel phongTrangChu25;
    private javax.swing.JPanel phongTrangChu26;
    private javax.swing.JPanel phongTrangChu27;
    private javax.swing.JPanel phongTrangChu28;
    private javax.swing.JPanel phongTrangChu29;
    private javax.swing.JPanel phongTrangChu3;
    private javax.swing.JPanel phongTrangChu30;
    private javax.swing.JPanel phongTrangChu31;
    private javax.swing.JPanel phongTrangChu32;
    private javax.swing.JPanel phongTrangChu33;
    private javax.swing.JPanel phongTrangChu34;
    private javax.swing.JPanel phongTrangChu35;
    private javax.swing.JPanel phongTrangChu4;
    private javax.swing.JPanel phongTrangChu5;
    private javax.swing.JPanel phongTrangChu6;
    private javax.swing.JPanel phongTrangChu7;
    private javax.swing.JPanel phongTrangChu8;
    private javax.swing.JPanel phongTrangChu9;
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
