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

import chooserDay.DateChooser;
import connectDB.ConnectDB;
import dao.PhongDao;
import dao.TaiKhoanDao;

import javax.swing.JFrame;
import menu.MenuEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

/**
 * @author Huynguyen
 */
public class TrangChuNew2 extends javax.swing.JFrame {

	public TrangChuNew2() throws Exception {

		ConnectDB.getInstance().getConnection();
		setResizable(false);
		initComponents();
		datetime();
		times();
		ganDuLieuPhongVaoTrangChu();
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
					ganDuLieuPhongVaoQuanLyPhong();
					addCheckBoxListeners();
				}

				if (index == 2) {
					pnedUngDung.setSelectedIndex(2);
					loadTableNhanVien();
					eventClickOnTableNhanVien();
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
					loadTableKhachHang();
					eventClickOnTableKhachHang();
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

	}

	;

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
	}

	public void loadTableKhachHang() {

		KhachHangDao khachHangDao = new KhachHangDao();
		ArrayList<KhachHang> dsKhachHang = khachHangDao.timTatCaKhachHang();
		DefaultTableModel model = (DefaultTableModel) TableKhachHang.getModel();

		model.setRowCount(0);

		for (int i = 0; i < dsKhachHang.size(); i++) {
			KhachHang kh = dsKhachHang.get(i);
			Object[] rowData = { i + 1, kh.getMaKH(), kh.getHoTenKH(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSoDT(),
					kh.getCCCD_Visa(), kh.getChiTieu(), kh.getMaHangThanhVien(), kh.getQuocTich() };
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
	}

	;

	@SuppressWarnings("unchecked")

	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGROUPLoaiPhong = new javax.swing.ButtonGroup();
        btnGROUPTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        Menu = new menu.Menu();
        pnedUngDung = new javax.swing.JTabbedPane();
        pnTrangChu = new javax.swing.JPanel();
        pnLayoutSrool = new giaodien.CustomClass.PanelRound();
        scrollPaneWin111 = new ScollBar1.ScrollPaneWin11();
        pnLayOutTrangChu = new javax.swing.JPanel();
        pnBody1 = new javax.swing.JPanel();
        Tang1_TrangChu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        phongTrangChu1 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu1 = new javax.swing.JLabel();
        lblTenPhongTrangChu1 = new javax.swing.JLabel();
        lblTrangThaiTrangChu1 = new javax.swing.JLabel();
        phongTrangChu2 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu2 = new javax.swing.JLabel();
        lblTenPhongTrangChu2 = new javax.swing.JLabel();
        lblTrangThaiTrangChu2 = new javax.swing.JLabel();
        phongTrangChu3 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu3 = new javax.swing.JLabel();
        lblTenPhongTrangChu3 = new javax.swing.JLabel();
        lblTrangThaiTrangChu3 = new javax.swing.JLabel();
        phongTrangChu4 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu4 = new javax.swing.JLabel();
        lblTenPhongTrangChu4 = new javax.swing.JLabel();
        lblTrangThaiTrangChu4 = new javax.swing.JLabel();
        phongTrangChu5 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu5 = new javax.swing.JLabel();
        lblTenPhongTrangChu5 = new javax.swing.JLabel();
        lblTrangThaiTrangChu5 = new javax.swing.JLabel();
        phongTrangChu6 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu6 = new javax.swing.JLabel();
        lblTenPhongTrangChu6 = new javax.swing.JLabel();
        lblTrangThaiTrangChu6 = new javax.swing.JLabel();
        phongTrangChu7 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu7 = new javax.swing.JLabel();
        lblTenPhongTrangChu7 = new javax.swing.JLabel();
        lblTrangThaiTrangChu7 = new javax.swing.JLabel();
        phongTrangChu8 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu8 = new javax.swing.JLabel();
        lblTenPhongTrangChu8 = new javax.swing.JLabel();
        lblTrangThaiTrangChu8 = new javax.swing.JLabel();
        phongTrangChu9 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu9 = new javax.swing.JLabel();
        lblTenPhongTrangChu9 = new javax.swing.JLabel();
        lblTrangThaiTrangChu9 = new javax.swing.JLabel();
        phongTrangChu10 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu10 = new javax.swing.JLabel();
        lblTenPhongTrangChu10 = new javax.swing.JLabel();
        lblTrangThaiTrangChu10 = new javax.swing.JLabel();
        Tang1_TrangChu1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        phongTrangChu11 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu11 = new javax.swing.JLabel();
        lblTenPhongTrangChu11 = new javax.swing.JLabel();
        lblTrangThaiTrangChu11 = new javax.swing.JLabel();
        phongTrangChu12 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu12 = new javax.swing.JLabel();
        lblTenPhongTrangChu12 = new javax.swing.JLabel();
        lblTrangThaiTrangChu12 = new javax.swing.JLabel();
        phongTrangChu13 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu13 = new javax.swing.JLabel();
        lblTenPhongTrangChu13 = new javax.swing.JLabel();
        lblTrangThaiTrangChu13 = new javax.swing.JLabel();
        phongTrangChu14 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu14 = new javax.swing.JLabel();
        lblTenPhongTrangChu14 = new javax.swing.JLabel();
        lblTrangThaiTrangChu14 = new javax.swing.JLabel();
        phongTrangChu15 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu15 = new javax.swing.JLabel();
        lblTenPhongTrangChu15 = new javax.swing.JLabel();
        lblTrangThaiTrangChu15 = new javax.swing.JLabel();
        phongTrangChu16 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu16 = new javax.swing.JLabel();
        lblTenPhongTrangChu16 = new javax.swing.JLabel();
        lblTrangThaiTrangChu16 = new javax.swing.JLabel();
        phongTrangChu17 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu17 = new javax.swing.JLabel();
        lblTenPhongTrangChu17 = new javax.swing.JLabel();
        lblTrangThaiTrangChu17 = new javax.swing.JLabel();
        phongTrangChu18 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu18 = new javax.swing.JLabel();
        lblTenPhongTrangChu18 = new javax.swing.JLabel();
        lblTrangThaiTrangChu18 = new javax.swing.JLabel();
        phongTrangChu19 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu19 = new javax.swing.JLabel();
        lblTenPhongTrangChu19 = new javax.swing.JLabel();
        lblTrangThaiTrangChu19 = new javax.swing.JLabel();
        phongTrangChu20 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu20 = new javax.swing.JLabel();
        lblTenPhongTrangChu20 = new javax.swing.JLabel();
        lblTrangThaiTrangChu20 = new javax.swing.JLabel();
        Tang1_TrangChu2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        phongTrangChu21 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu21 = new javax.swing.JLabel();
        lblTenPhongTrangChu21 = new javax.swing.JLabel();
        lblTrangThaiTrangChu21 = new javax.swing.JLabel();
        phongTrangChu22 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu22 = new javax.swing.JLabel();
        lblTenPhongTrangChu22 = new javax.swing.JLabel();
        lblTrangThaiTrangChu22 = new javax.swing.JLabel();
        phongTrangChu23 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu23 = new javax.swing.JLabel();
        lblTenPhongTrangChu23 = new javax.swing.JLabel();
        lblTrangThaiTrangChu23 = new javax.swing.JLabel();
        phongTrangChu24 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu24 = new javax.swing.JLabel();
        lblTenPhongTrangChu24 = new javax.swing.JLabel();
        lblTrangThaiTrangChu24 = new javax.swing.JLabel();
        phongTrangChu25 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu25 = new javax.swing.JLabel();
        lblTenPhongTrangChu25 = new javax.swing.JLabel();
        lblTrangThaiTrangChu25 = new javax.swing.JLabel();
        phongTrangChu26 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu26 = new javax.swing.JLabel();
        lblTenPhongTrangChu26 = new javax.swing.JLabel();
        lblTrangThaiTrangChu26 = new javax.swing.JLabel();
        phongTrangChu27 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu27 = new javax.swing.JLabel();
        lblTenPhongTrangChu27 = new javax.swing.JLabel();
        lblTrangThaiTrangChu27 = new javax.swing.JLabel();
        phongTrangChu28 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu28 = new javax.swing.JLabel();
        lblTenPhongTrangChu28 = new javax.swing.JLabel();
        lblTrangThaiTrangChu28 = new javax.swing.JLabel();
        phongTrangChu29 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu29 = new javax.swing.JLabel();
        lblTenPhongTrangChu29 = new javax.swing.JLabel();
        lblTrangThaiTrangChu29 = new javax.swing.JLabel();
        phongTrangChu30 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu30 = new javax.swing.JLabel();
        lblTenPhongTrangChu30 = new javax.swing.JLabel();
        lblTrangThaiTrangChu30 = new javax.swing.JLabel();
        Tang1_TrangChu3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        phongTrangChu31 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu31 = new javax.swing.JLabel();
        lblTenPhongTrangChu31 = new javax.swing.JLabel();
        lblTrangThaiTrangChu31 = new javax.swing.JLabel();
        phongTrangChu32 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu32 = new javax.swing.JLabel();
        lblTenPhongTrangChu32 = new javax.swing.JLabel();
        lblTrangThaiTrangChu32 = new javax.swing.JLabel();
        phongTrangChu33 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu33 = new javax.swing.JLabel();
        lblTenPhongTrangChu33 = new javax.swing.JLabel();
        lblTrangThaiTrangChu33 = new javax.swing.JLabel();
        phongTrangChu34 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu34 = new javax.swing.JLabel();
        lblTenPhongTrangChu34 = new javax.swing.JLabel();
        lblTrangThaiTrangChu34 = new javax.swing.JLabel();
        phongTrangChu35 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongTrangChu35 = new javax.swing.JLabel();
        lblTenPhongTrangChu35 = new javax.swing.JLabel();
        lblTrangThaiTrangChu35 = new javax.swing.JLabel();
        pnQuanLyPhong = new javax.swing.JPanel();
        pnLayoutQuanLyPhong = new giaodien.CustomClass.PanelRound();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTimTheoDieuKien = new giaodien.CustomClass.Button();
        btnDatPhong = new giaodien.CustomClass.Button();
        btnHuyDatPhong = new giaodien.CustomClass.Button();
        btnDoiPhong = new giaodien.CustomClass.Button();
        btnTraPhong = new giaodien.CustomClass.Button();
        btnThuePhong = new giaodien.CustomClass.Button();
        btnResetTrangThai = new giaodien.CustomClass.Button();
        pnLayoutQL = new giaodien.CustomClass.PanelRound();
        scrollPaneWin112 = new ScollBar1.ScrollPaneWin11();
        pnBody2 = new javax.swing.JPanel();
        panelRound1 = new giaodien.CustomClass.PanelRound();
        phongQuanLy1 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL1 = new javax.swing.JLabel();
        lblTenPhongQL1 = new javax.swing.JLabel();
        lblTrangThaiQL1 = new javax.swing.JLabel();
        checkBoxPhongQL1 = new checkbox.JCheckBoxCustom();
        phongQuanLy2 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL2 = new javax.swing.JLabel();
        lblTenPhongQL2 = new javax.swing.JLabel();
        lblTrangThaiQL2 = new javax.swing.JLabel();
        checkBoxPhongQL2 = new checkbox.JCheckBoxCustom();
        phongQuanLy3 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL3 = new javax.swing.JLabel();
        lblTenPhongQL3 = new javax.swing.JLabel();
        lblTrangThaiQL3 = new javax.swing.JLabel();
        checkBoxPhongQL3 = new checkbox.JCheckBoxCustom();
        phongQuanLy4 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL4 = new javax.swing.JLabel();
        lblTenPhongQL4 = new javax.swing.JLabel();
        lblTrangThaiQL4 = new javax.swing.JLabel();
        checkBoxPhongQL4 = new checkbox.JCheckBoxCustom();
        phongQuanLy5 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL5 = new javax.swing.JLabel();
        lblTenPhongQL5 = new javax.swing.JLabel();
        lblTrangThaiQL5 = new javax.swing.JLabel();
        checkBoxPhongQL5 = new checkbox.JCheckBoxCustom();
        phongQuanLy6 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL6 = new javax.swing.JLabel();
        lblTenPhongQL6 = new javax.swing.JLabel();
        lblTrangThaiQL6 = new javax.swing.JLabel();
        checkBoxPhongQL6 = new checkbox.JCheckBoxCustom();
        jLabel11 = new javax.swing.JLabel();
        panelRound2 = new giaodien.CustomClass.PanelRound();
        phongQuanLy7 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL7 = new javax.swing.JLabel();
        lblTenPhongQL7 = new javax.swing.JLabel();
        lblTrangThaiQL7 = new javax.swing.JLabel();
        checkBoxPhongQL7 = new checkbox.JCheckBoxCustom();
        phongQuanLy8 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL8 = new javax.swing.JLabel();
        lblTenPhongQL8 = new javax.swing.JLabel();
        lblTrangThaiQL8 = new javax.swing.JLabel();
        checkBoxPhongQL8 = new checkbox.JCheckBoxCustom();
        phongQuanLy9 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL9 = new javax.swing.JLabel();
        lblTenPhongQL9 = new javax.swing.JLabel();
        lblTrangThaiQL9 = new javax.swing.JLabel();
        checkBoxPhongQL9 = new checkbox.JCheckBoxCustom();
        phongQuanLy10 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL10 = new javax.swing.JLabel();
        lblTenPhongQL10 = new javax.swing.JLabel();
        lblTrangThaiQL10 = new javax.swing.JLabel();
        checkBoxPhongQL10 = new checkbox.JCheckBoxCustom();
        btnChonPhongTrongTang1 = new giaodien.CustomClass.Button();
        jLabel17 = new javax.swing.JLabel();
        panelRound3 = new giaodien.CustomClass.PanelRound();
        phongQuanLy11 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL11 = new javax.swing.JLabel();
        lblTenPhongQL11 = new javax.swing.JLabel();
        lblTrangThaiQL11 = new javax.swing.JLabel();
        checkBoxPhongQL11 = new checkbox.JCheckBoxCustom();
        phongQuanLy12 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL12 = new javax.swing.JLabel();
        lblTenPhongQL12 = new javax.swing.JLabel();
        lblTrangThaiQL12 = new javax.swing.JLabel();
        checkBoxPhongQL12 = new checkbox.JCheckBoxCustom();
        phongQuanLy13 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL13 = new javax.swing.JLabel();
        lblTenPhongQL13 = new javax.swing.JLabel();
        lblTrangThaiQL13 = new javax.swing.JLabel();
        checkBoxPhongQL13 = new checkbox.JCheckBoxCustom();
        phongQuanLy14 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL14 = new javax.swing.JLabel();
        lblTenPhongQL14 = new javax.swing.JLabel();
        lblTrangThaiQL14 = new javax.swing.JLabel();
        checkBoxPhongQL14 = new checkbox.JCheckBoxCustom();
        phongQuanLy15 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL15 = new javax.swing.JLabel();
        lblTenPhongQL15 = new javax.swing.JLabel();
        lblTrangThaiQL15 = new javax.swing.JLabel();
        checkBoxPhongQL15 = new checkbox.JCheckBoxCustom();
        phongQuanLy16 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL16 = new javax.swing.JLabel();
        lblTenPhongQL16 = new javax.swing.JLabel();
        lblTrangThaiQL16 = new javax.swing.JLabel();
        checkBoxPhongQL16 = new checkbox.JCheckBoxCustom();
        panelRound4 = new giaodien.CustomClass.PanelRound();
        phongQuanLy17 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL17 = new javax.swing.JLabel();
        lblTenPhongQL17 = new javax.swing.JLabel();
        lblTrangThaiQL17 = new javax.swing.JLabel();
        checkBoxPhongQL17 = new checkbox.JCheckBoxCustom();
        phongQuanLy18 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL18 = new javax.swing.JLabel();
        lblTenPhongQL18 = new javax.swing.JLabel();
        lblTrangThaiQL18 = new javax.swing.JLabel();
        checkBoxPhongQL18 = new checkbox.JCheckBoxCustom();
        phongQuanLy19 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL19 = new javax.swing.JLabel();
        lblTenPhongQL19 = new javax.swing.JLabel();
        lblTrangThaiQL19 = new javax.swing.JLabel();
        checkBoxPhongQL19 = new checkbox.JCheckBoxCustom();
        phongQuanLy20 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL20 = new javax.swing.JLabel();
        lblTenPhongQL20 = new javax.swing.JLabel();
        lblTrangThaiQL20 = new javax.swing.JLabel();
        checkBoxPhongQL20 = new checkbox.JCheckBoxCustom();
        jLabel18 = new javax.swing.JLabel();
        panelRound5 = new giaodien.CustomClass.PanelRound();
        phongQuanLy21 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL21 = new javax.swing.JLabel();
        lblTenPhongQL21 = new javax.swing.JLabel();
        lblTrangThaiQL21 = new javax.swing.JLabel();
        checkBoxPhongQL21 = new checkbox.JCheckBoxCustom();
        phongQuanLy22 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL22 = new javax.swing.JLabel();
        lblTenPhongQL22 = new javax.swing.JLabel();
        lblTrangThaiQL22 = new javax.swing.JLabel();
        checkBoxPhongQL22 = new checkbox.JCheckBoxCustom();
        phongQuanLy23 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL23 = new javax.swing.JLabel();
        lblTenPhongQL23 = new javax.swing.JLabel();
        lblTrangThaiQL23 = new javax.swing.JLabel();
        checkBoxPhongQL23 = new checkbox.JCheckBoxCustom();
        phongQuanLy24 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL24 = new javax.swing.JLabel();
        lblTenPhongQL24 = new javax.swing.JLabel();
        lblTrangThaiQL24 = new javax.swing.JLabel();
        checkBoxPhongQL24 = new checkbox.JCheckBoxCustom();
        phongQuanLy25 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL25 = new javax.swing.JLabel();
        lblTenPhongQL25 = new javax.swing.JLabel();
        lblTrangThaiQL25 = new javax.swing.JLabel();
        checkBoxPhongQL25 = new checkbox.JCheckBoxCustom();
        phongQuanLy26 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL26 = new javax.swing.JLabel();
        lblTenPhongQL26 = new javax.swing.JLabel();
        lblTrangThaiQL26 = new javax.swing.JLabel();
        checkBoxPhongQL26 = new checkbox.JCheckBoxCustom();
        panelRound6 = new giaodien.CustomClass.PanelRound();
        phongQuanLy27 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL27 = new javax.swing.JLabel();
        lblTenPhongQL27 = new javax.swing.JLabel();
        lblTrangThaiQL27 = new javax.swing.JLabel();
        checkBoxPhongQL27 = new checkbox.JCheckBoxCustom();
        phongQuanLy28 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL28 = new javax.swing.JLabel();
        lblTenPhongQL28 = new javax.swing.JLabel();
        lblTrangThaiQL28 = new javax.swing.JLabel();
        checkBoxPhongQL28 = new checkbox.JCheckBoxCustom();
        phongQuanLy29 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL29 = new javax.swing.JLabel();
        lblTenPhongQL29 = new javax.swing.JLabel();
        lblTrangThaiQL29 = new javax.swing.JLabel();
        checkBoxPhongQL29 = new checkbox.JCheckBoxCustom();
        phongQuanLy30 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL30 = new javax.swing.JLabel();
        lblTenPhongQL30 = new javax.swing.JLabel();
        lblTrangThaiQL30 = new javax.swing.JLabel();
        checkBoxPhongQL30 = new checkbox.JCheckBoxCustom();
        panelRound7 = new giaodien.CustomClass.PanelRound();
        phongQuanLy31 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL31 = new javax.swing.JLabel();
        lblTenPhongQL31 = new javax.swing.JLabel();
        lblTrangThaiQL31 = new javax.swing.JLabel();
        checkBoxPhongQL31 = new checkbox.JCheckBoxCustom();
        phongQuanLy32 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL32 = new javax.swing.JLabel();
        lblTenPhongQL32 = new javax.swing.JLabel();
        lblTrangThaiQL32 = new javax.swing.JLabel();
        checkBoxPhongQL32 = new checkbox.JCheckBoxCustom();
        phongQuanLy33 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL33 = new javax.swing.JLabel();
        lblTenPhongQL33 = new javax.swing.JLabel();
        lblTrangThaiQL33 = new javax.swing.JLabel();
        checkBoxPhongQL33 = new checkbox.JCheckBoxCustom();
        phongQuanLy34 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL34 = new javax.swing.JLabel();
        lblTenPhongQL34 = new javax.swing.JLabel();
        lblTrangThaiQL34 = new javax.swing.JLabel();
        checkBoxPhongQL34 = new checkbox.JCheckBoxCustom();
        phongQuanLy35 = new giaodien.CustomClass.PanelRound();
        lblLoaiPhongQL35 = new javax.swing.JLabel();
        lblTenPhongQL35 = new javax.swing.JLabel();
        lblTrangThaiQL35 = new javax.swing.JLabel();
        checkBoxPhongQL35 = new checkbox.JCheckBoxCustom();
        jLabel21 = new javax.swing.JLabel();
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
        jLabel34 = new javax.swing.JLabel();
        cbxGioiTinhKhachHang = new javax.swing.JComboBox<>();
        btnCapNhapKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtQuocTichKhachHang = new javax.swing.JTextField();
        txtHangThanhVien = new javax.swing.JTextField();
        btnXoaTrangKhachHangQL = new javax.swing.JButton();
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
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(1062, 1062, 1062)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jPanel1.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        pnedUngDung.setBackground(new java.awt.Color(255, 153, 102));

        pnBody1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trang chủ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        Tang1_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        phongTrangChu1.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu1.setRoundBottomLeft(20);
        phongTrangChu1.setRoundBottomRight(20);
        phongTrangChu1.setRoundTopLeft(20);
        phongTrangChu1.setRoundTopRight(20);

        lblLoaiPhongTrangChu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu1.setText("Tiêu chuẩn");

        lblTenPhongTrangChu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu1.setText("101TC");

        lblTrangThaiTrangChu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu1.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu1Layout = new javax.swing.GroupLayout(phongTrangChu1);
        phongTrangChu1.setLayout(phongTrangChu1Layout);
        phongTrangChu1Layout.setHorizontalGroup(
            phongTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu1Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu1)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu1Layout.setVerticalGroup(
            phongTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu1)
                .addContainerGap())
        );

        phongTrangChu2.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu2.setRoundBottomLeft(20);
        phongTrangChu2.setRoundBottomRight(20);
        phongTrangChu2.setRoundTopLeft(20);
        phongTrangChu2.setRoundTopRight(20);

        lblLoaiPhongTrangChu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu2.setText("Tiêu chuẩn");

        lblTenPhongTrangChu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu2.setText("101TC");

        lblTrangThaiTrangChu2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu2.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu2Layout = new javax.swing.GroupLayout(phongTrangChu2);
        phongTrangChu2.setLayout(phongTrangChu2Layout);
        phongTrangChu2Layout.setHorizontalGroup(
            phongTrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu2Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu2)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu2Layout.setVerticalGroup(
            phongTrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu2)
                .addContainerGap())
        );

        phongTrangChu3.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu3.setRoundBottomLeft(20);
        phongTrangChu3.setRoundBottomRight(20);
        phongTrangChu3.setRoundTopLeft(20);
        phongTrangChu3.setRoundTopRight(20);

        lblLoaiPhongTrangChu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu3.setText("Tiêu chuẩn");

        lblTenPhongTrangChu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu3.setText("101TC");

        lblTrangThaiTrangChu3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu3.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu3Layout = new javax.swing.GroupLayout(phongTrangChu3);
        phongTrangChu3.setLayout(phongTrangChu3Layout);
        phongTrangChu3Layout.setHorizontalGroup(
            phongTrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu3Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu3)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu3Layout.setVerticalGroup(
            phongTrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu3)
                .addContainerGap())
        );

        phongTrangChu4.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu4.setRoundBottomLeft(20);
        phongTrangChu4.setRoundBottomRight(20);
        phongTrangChu4.setRoundTopLeft(20);
        phongTrangChu4.setRoundTopRight(20);

        lblLoaiPhongTrangChu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu4.setText("Tiêu chuẩn");

        lblTenPhongTrangChu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu4.setText("101TC");

        lblTrangThaiTrangChu4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu4.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu4Layout = new javax.swing.GroupLayout(phongTrangChu4);
        phongTrangChu4.setLayout(phongTrangChu4Layout);
        phongTrangChu4Layout.setHorizontalGroup(
            phongTrangChu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu4Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu4)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu4Layout.setVerticalGroup(
            phongTrangChu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu4)
                .addContainerGap())
        );

        phongTrangChu5.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu5.setRoundBottomLeft(20);
        phongTrangChu5.setRoundBottomRight(20);
        phongTrangChu5.setRoundTopLeft(20);
        phongTrangChu5.setRoundTopRight(20);

        lblLoaiPhongTrangChu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu5.setText("Tiêu chuẩn");

        lblTenPhongTrangChu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu5.setText("101TC");

        lblTrangThaiTrangChu5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu5.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu5Layout = new javax.swing.GroupLayout(phongTrangChu5);
        phongTrangChu5.setLayout(phongTrangChu5Layout);
        phongTrangChu5Layout.setHorizontalGroup(
            phongTrangChu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu5Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu5)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu5Layout.setVerticalGroup(
            phongTrangChu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu5)
                .addContainerGap())
        );

        phongTrangChu6.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu6.setRoundBottomLeft(20);
        phongTrangChu6.setRoundBottomRight(20);
        phongTrangChu6.setRoundTopLeft(20);
        phongTrangChu6.setRoundTopRight(20);

        lblLoaiPhongTrangChu6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu6.setText("Tiêu chuẩn");

        lblTenPhongTrangChu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu6.setText("101TC");

        lblTrangThaiTrangChu6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu6.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu6Layout = new javax.swing.GroupLayout(phongTrangChu6);
        phongTrangChu6.setLayout(phongTrangChu6Layout);
        phongTrangChu6Layout.setHorizontalGroup(
            phongTrangChu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu6Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu6)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu6Layout.setVerticalGroup(
            phongTrangChu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu6)
                .addContainerGap())
        );

        phongTrangChu7.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu7.setRoundBottomLeft(20);
        phongTrangChu7.setRoundBottomRight(20);
        phongTrangChu7.setRoundTopLeft(20);
        phongTrangChu7.setRoundTopRight(20);

        lblLoaiPhongTrangChu7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu7.setText("Tiêu chuẩn");

        lblTenPhongTrangChu7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu7.setText("101TC");

        lblTrangThaiTrangChu7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu7.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu7Layout = new javax.swing.GroupLayout(phongTrangChu7);
        phongTrangChu7.setLayout(phongTrangChu7Layout);
        phongTrangChu7Layout.setHorizontalGroup(
            phongTrangChu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu7Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu7)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu7Layout.setVerticalGroup(
            phongTrangChu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu7)
                .addContainerGap())
        );

        phongTrangChu8.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu8.setRoundBottomLeft(20);
        phongTrangChu8.setRoundBottomRight(20);
        phongTrangChu8.setRoundTopLeft(20);
        phongTrangChu8.setRoundTopRight(20);

        lblLoaiPhongTrangChu8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu8.setText("Tiêu chuẩn");

        lblTenPhongTrangChu8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu8.setText("101TC");

        lblTrangThaiTrangChu8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu8.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu8Layout = new javax.swing.GroupLayout(phongTrangChu8);
        phongTrangChu8.setLayout(phongTrangChu8Layout);
        phongTrangChu8Layout.setHorizontalGroup(
            phongTrangChu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu8Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu8)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu8Layout.setVerticalGroup(
            phongTrangChu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu8)
                .addContainerGap())
        );

        phongTrangChu9.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu9.setRoundBottomLeft(20);
        phongTrangChu9.setRoundBottomRight(20);
        phongTrangChu9.setRoundTopLeft(20);
        phongTrangChu9.setRoundTopRight(20);

        lblLoaiPhongTrangChu9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu9.setText("Tiêu chuẩn");

        lblTenPhongTrangChu9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu9.setText("101TC");

        lblTrangThaiTrangChu9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu9.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu9Layout = new javax.swing.GroupLayout(phongTrangChu9);
        phongTrangChu9.setLayout(phongTrangChu9Layout);
        phongTrangChu9Layout.setHorizontalGroup(
            phongTrangChu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu9Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu9)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu9Layout.setVerticalGroup(
            phongTrangChu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu9)
                .addContainerGap())
        );

        phongTrangChu10.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu10.setRoundBottomLeft(20);
        phongTrangChu10.setRoundBottomRight(20);
        phongTrangChu10.setRoundTopLeft(20);
        phongTrangChu10.setRoundTopRight(20);

        lblLoaiPhongTrangChu10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu10.setText("Tiêu chuẩn");

        lblTenPhongTrangChu10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu10.setText("101TC");

        lblTrangThaiTrangChu10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu10.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu10Layout = new javax.swing.GroupLayout(phongTrangChu10);
        phongTrangChu10.setLayout(phongTrangChu10Layout);
        phongTrangChu10Layout.setHorizontalGroup(
            phongTrangChu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu10Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu10)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu10Layout.setVerticalGroup(
            phongTrangChu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                        .addComponent(phongTrangChu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phongTrangChu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChuLayout = new javax.swing.GroupLayout(Tang1_TrangChu);
        Tang1_TrangChu.setLayout(Tang1_TrangChuLayout);
        Tang1_TrangChuLayout.setHorizontalGroup(
            Tang1_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tang1_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang1_TrangChuLayout.setVerticalGroup(
            Tang1_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Tang1_TrangChu1.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        phongTrangChu11.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu11.setRoundBottomLeft(20);
        phongTrangChu11.setRoundBottomRight(20);
        phongTrangChu11.setRoundTopLeft(20);
        phongTrangChu11.setRoundTopRight(20);

        lblLoaiPhongTrangChu11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu11.setText("Tiêu chuẩn");

        lblTenPhongTrangChu11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu11.setText("101TC");

        lblTrangThaiTrangChu11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu11.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu11Layout = new javax.swing.GroupLayout(phongTrangChu11);
        phongTrangChu11.setLayout(phongTrangChu11Layout);
        phongTrangChu11Layout.setHorizontalGroup(
            phongTrangChu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu11Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu11)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu11Layout.setVerticalGroup(
            phongTrangChu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu11)
                .addContainerGap())
        );

        phongTrangChu12.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu12.setRoundBottomLeft(20);
        phongTrangChu12.setRoundBottomRight(20);
        phongTrangChu12.setRoundTopLeft(20);
        phongTrangChu12.setRoundTopRight(20);

        lblLoaiPhongTrangChu12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu12.setText("Tiêu chuẩn");

        lblTenPhongTrangChu12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu12.setText("101TC");

        lblTrangThaiTrangChu12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu12.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu12Layout = new javax.swing.GroupLayout(phongTrangChu12);
        phongTrangChu12.setLayout(phongTrangChu12Layout);
        phongTrangChu12Layout.setHorizontalGroup(
            phongTrangChu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu12Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu12)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu12Layout.setVerticalGroup(
            phongTrangChu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu12)
                .addContainerGap())
        );

        phongTrangChu13.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu13.setRoundBottomLeft(20);
        phongTrangChu13.setRoundBottomRight(20);
        phongTrangChu13.setRoundTopLeft(20);
        phongTrangChu13.setRoundTopRight(20);

        lblLoaiPhongTrangChu13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu13.setText("Tiêu chuẩn");

        lblTenPhongTrangChu13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu13.setText("101TC");

        lblTrangThaiTrangChu13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu13.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu13Layout = new javax.swing.GroupLayout(phongTrangChu13);
        phongTrangChu13.setLayout(phongTrangChu13Layout);
        phongTrangChu13Layout.setHorizontalGroup(
            phongTrangChu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu13Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu13)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu13Layout.setVerticalGroup(
            phongTrangChu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu13)
                .addContainerGap())
        );

        phongTrangChu14.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu14.setRoundBottomLeft(20);
        phongTrangChu14.setRoundBottomRight(20);
        phongTrangChu14.setRoundTopLeft(20);
        phongTrangChu14.setRoundTopRight(20);

        lblLoaiPhongTrangChu14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu14.setText("Tiêu chuẩn");

        lblTenPhongTrangChu14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu14.setText("101TC");

        lblTrangThaiTrangChu14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu14.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu14Layout = new javax.swing.GroupLayout(phongTrangChu14);
        phongTrangChu14.setLayout(phongTrangChu14Layout);
        phongTrangChu14Layout.setHorizontalGroup(
            phongTrangChu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu14Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu14)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu14Layout.setVerticalGroup(
            phongTrangChu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu14)
                .addContainerGap())
        );

        phongTrangChu15.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu15.setRoundBottomLeft(20);
        phongTrangChu15.setRoundBottomRight(20);
        phongTrangChu15.setRoundTopLeft(20);
        phongTrangChu15.setRoundTopRight(20);

        lblLoaiPhongTrangChu15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu15.setText("Tiêu chuẩn");

        lblTenPhongTrangChu15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu15.setText("101TC");

        lblTrangThaiTrangChu15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu15.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu15Layout = new javax.swing.GroupLayout(phongTrangChu15);
        phongTrangChu15.setLayout(phongTrangChu15Layout);
        phongTrangChu15Layout.setHorizontalGroup(
            phongTrangChu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu15Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu15)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu15Layout.setVerticalGroup(
            phongTrangChu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu15)
                .addContainerGap())
        );

        phongTrangChu16.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu16.setRoundBottomLeft(20);
        phongTrangChu16.setRoundBottomRight(20);
        phongTrangChu16.setRoundTopLeft(20);
        phongTrangChu16.setRoundTopRight(20);

        lblLoaiPhongTrangChu16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu16.setText("Tiêu chuẩn");

        lblTenPhongTrangChu16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu16.setText("101TC");

        lblTrangThaiTrangChu16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu16.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu16Layout = new javax.swing.GroupLayout(phongTrangChu16);
        phongTrangChu16.setLayout(phongTrangChu16Layout);
        phongTrangChu16Layout.setHorizontalGroup(
            phongTrangChu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu16Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu16)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu16Layout.setVerticalGroup(
            phongTrangChu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu16)
                .addContainerGap())
        );

        phongTrangChu17.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu17.setRoundBottomLeft(20);
        phongTrangChu17.setRoundBottomRight(20);
        phongTrangChu17.setRoundTopLeft(20);
        phongTrangChu17.setRoundTopRight(20);

        lblLoaiPhongTrangChu17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu17.setText("Tiêu chuẩn");

        lblTenPhongTrangChu17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu17.setText("101TC");

        lblTrangThaiTrangChu17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu17.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu17Layout = new javax.swing.GroupLayout(phongTrangChu17);
        phongTrangChu17.setLayout(phongTrangChu17Layout);
        phongTrangChu17Layout.setHorizontalGroup(
            phongTrangChu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu17Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu17)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu17Layout.setVerticalGroup(
            phongTrangChu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu17)
                .addContainerGap())
        );

        phongTrangChu18.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu18.setRoundBottomLeft(20);
        phongTrangChu18.setRoundBottomRight(20);
        phongTrangChu18.setRoundTopLeft(20);
        phongTrangChu18.setRoundTopRight(20);

        lblLoaiPhongTrangChu18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu18.setText("Tiêu chuẩn");

        lblTenPhongTrangChu18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu18.setText("101TC");

        lblTrangThaiTrangChu18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu18.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu18Layout = new javax.swing.GroupLayout(phongTrangChu18);
        phongTrangChu18.setLayout(phongTrangChu18Layout);
        phongTrangChu18Layout.setHorizontalGroup(
            phongTrangChu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu18Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu18)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu18Layout.setVerticalGroup(
            phongTrangChu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu18)
                .addContainerGap())
        );

        phongTrangChu19.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu19.setRoundBottomLeft(20);
        phongTrangChu19.setRoundBottomRight(20);
        phongTrangChu19.setRoundTopLeft(20);
        phongTrangChu19.setRoundTopRight(20);

        lblLoaiPhongTrangChu19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu19.setText("Tiêu chuẩn");

        lblTenPhongTrangChu19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu19.setText("101TC");

        lblTrangThaiTrangChu19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu19.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu19Layout = new javax.swing.GroupLayout(phongTrangChu19);
        phongTrangChu19.setLayout(phongTrangChu19Layout);
        phongTrangChu19Layout.setHorizontalGroup(
            phongTrangChu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu19Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu19)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu19Layout.setVerticalGroup(
            phongTrangChu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu19)
                .addContainerGap())
        );

        phongTrangChu20.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu20.setRoundBottomLeft(20);
        phongTrangChu20.setRoundBottomRight(20);
        phongTrangChu20.setRoundTopLeft(20);
        phongTrangChu20.setRoundTopRight(20);

        lblLoaiPhongTrangChu20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu20.setText("Tiêu chuẩn");

        lblTenPhongTrangChu20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu20.setText("101TC");

        lblTrangThaiTrangChu20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu20.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu20Layout = new javax.swing.GroupLayout(phongTrangChu20);
        phongTrangChu20.setLayout(phongTrangChu20Layout);
        phongTrangChu20Layout.setHorizontalGroup(
            phongTrangChu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu20Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu20)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu20Layout.setVerticalGroup(
            phongTrangChu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu20)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                        .addComponent(phongTrangChu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(phongTrangChu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChu1Layout = new javax.swing.GroupLayout(Tang1_TrangChu1);
        Tang1_TrangChu1.setLayout(Tang1_TrangChu1Layout);
        Tang1_TrangChu1Layout.setHorizontalGroup(
            Tang1_TrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tang1_TrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang1_TrangChu1Layout.setVerticalGroup(
            Tang1_TrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Tang1_TrangChu2.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        phongTrangChu21.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu21.setRoundBottomLeft(20);
        phongTrangChu21.setRoundBottomRight(20);
        phongTrangChu21.setRoundTopLeft(20);
        phongTrangChu21.setRoundTopRight(20);

        lblLoaiPhongTrangChu21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu21.setText("Tiêu chuẩn");

        lblTenPhongTrangChu21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu21.setText("101TC");

        lblTrangThaiTrangChu21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu21.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu21Layout = new javax.swing.GroupLayout(phongTrangChu21);
        phongTrangChu21.setLayout(phongTrangChu21Layout);
        phongTrangChu21Layout.setHorizontalGroup(
            phongTrangChu21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu21Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu21)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu21Layout.setVerticalGroup(
            phongTrangChu21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu21)
                .addContainerGap())
        );

        phongTrangChu22.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu22.setRoundBottomLeft(20);
        phongTrangChu22.setRoundBottomRight(20);
        phongTrangChu22.setRoundTopLeft(20);
        phongTrangChu22.setRoundTopRight(20);

        lblLoaiPhongTrangChu22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu22.setText("Tiêu chuẩn");

        lblTenPhongTrangChu22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu22.setText("101TC");

        lblTrangThaiTrangChu22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu22.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu22Layout = new javax.swing.GroupLayout(phongTrangChu22);
        phongTrangChu22.setLayout(phongTrangChu22Layout);
        phongTrangChu22Layout.setHorizontalGroup(
            phongTrangChu22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu22Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu22)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu22Layout.setVerticalGroup(
            phongTrangChu22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu22)
                .addContainerGap())
        );

        phongTrangChu23.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu23.setRoundBottomLeft(20);
        phongTrangChu23.setRoundBottomRight(20);
        phongTrangChu23.setRoundTopLeft(20);
        phongTrangChu23.setRoundTopRight(20);

        lblLoaiPhongTrangChu23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu23.setText("Tiêu chuẩn");

        lblTenPhongTrangChu23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu23.setText("101TC");

        lblTrangThaiTrangChu23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu23.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu23Layout = new javax.swing.GroupLayout(phongTrangChu23);
        phongTrangChu23.setLayout(phongTrangChu23Layout);
        phongTrangChu23Layout.setHorizontalGroup(
            phongTrangChu23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu23Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu23)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu23Layout.setVerticalGroup(
            phongTrangChu23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu23)
                .addContainerGap())
        );

        phongTrangChu24.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu24.setRoundBottomLeft(20);
        phongTrangChu24.setRoundBottomRight(20);
        phongTrangChu24.setRoundTopLeft(20);
        phongTrangChu24.setRoundTopRight(20);

        lblLoaiPhongTrangChu24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu24.setText("Tiêu chuẩn");

        lblTenPhongTrangChu24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu24.setText("101TC");

        lblTrangThaiTrangChu24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu24.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu24Layout = new javax.swing.GroupLayout(phongTrangChu24);
        phongTrangChu24.setLayout(phongTrangChu24Layout);
        phongTrangChu24Layout.setHorizontalGroup(
            phongTrangChu24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu24Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu24)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu24Layout.setVerticalGroup(
            phongTrangChu24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu24)
                .addContainerGap())
        );

        phongTrangChu25.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu25.setRoundBottomLeft(20);
        phongTrangChu25.setRoundBottomRight(20);
        phongTrangChu25.setRoundTopLeft(20);
        phongTrangChu25.setRoundTopRight(20);

        lblLoaiPhongTrangChu25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu25.setText("Tiêu chuẩn");

        lblTenPhongTrangChu25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu25.setText("101TC");

        lblTrangThaiTrangChu25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu25.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu25Layout = new javax.swing.GroupLayout(phongTrangChu25);
        phongTrangChu25.setLayout(phongTrangChu25Layout);
        phongTrangChu25Layout.setHorizontalGroup(
            phongTrangChu25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu25Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu25)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu25Layout.setVerticalGroup(
            phongTrangChu25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu25)
                .addContainerGap())
        );

        phongTrangChu26.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu26.setRoundBottomLeft(20);
        phongTrangChu26.setRoundBottomRight(20);
        phongTrangChu26.setRoundTopLeft(20);
        phongTrangChu26.setRoundTopRight(20);

        lblLoaiPhongTrangChu26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu26.setText("Tiêu chuẩn");

        lblTenPhongTrangChu26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu26.setText("101TC");

        lblTrangThaiTrangChu26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu26.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu26Layout = new javax.swing.GroupLayout(phongTrangChu26);
        phongTrangChu26.setLayout(phongTrangChu26Layout);
        phongTrangChu26Layout.setHorizontalGroup(
            phongTrangChu26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu26Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu26)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu26Layout.setVerticalGroup(
            phongTrangChu26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu26)
                .addContainerGap())
        );

        phongTrangChu27.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu27.setRoundBottomLeft(20);
        phongTrangChu27.setRoundBottomRight(20);
        phongTrangChu27.setRoundTopLeft(20);
        phongTrangChu27.setRoundTopRight(20);

        lblLoaiPhongTrangChu27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu27.setText("Tiêu chuẩn");

        lblTenPhongTrangChu27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu27.setText("101TC");

        lblTrangThaiTrangChu27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu27.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu27Layout = new javax.swing.GroupLayout(phongTrangChu27);
        phongTrangChu27.setLayout(phongTrangChu27Layout);
        phongTrangChu27Layout.setHorizontalGroup(
            phongTrangChu27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu27Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu27)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu27Layout.setVerticalGroup(
            phongTrangChu27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu27)
                .addContainerGap())
        );

        phongTrangChu28.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu28.setRoundBottomLeft(20);
        phongTrangChu28.setRoundBottomRight(20);
        phongTrangChu28.setRoundTopLeft(20);
        phongTrangChu28.setRoundTopRight(20);

        lblLoaiPhongTrangChu28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu28.setText("Tiêu chuẩn");

        lblTenPhongTrangChu28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu28.setText("101TC");

        lblTrangThaiTrangChu28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu28.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu28Layout = new javax.swing.GroupLayout(phongTrangChu28);
        phongTrangChu28.setLayout(phongTrangChu28Layout);
        phongTrangChu28Layout.setHorizontalGroup(
            phongTrangChu28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu28Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu28)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu28Layout.setVerticalGroup(
            phongTrangChu28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu28)
                .addContainerGap())
        );

        phongTrangChu29.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu29.setRoundBottomLeft(20);
        phongTrangChu29.setRoundBottomRight(20);
        phongTrangChu29.setRoundTopLeft(20);
        phongTrangChu29.setRoundTopRight(20);

        lblLoaiPhongTrangChu29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu29.setText("Tiêu chuẩn");

        lblTenPhongTrangChu29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu29.setText("101TC");

        lblTrangThaiTrangChu29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu29.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu29Layout = new javax.swing.GroupLayout(phongTrangChu29);
        phongTrangChu29.setLayout(phongTrangChu29Layout);
        phongTrangChu29Layout.setHorizontalGroup(
            phongTrangChu29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu29Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu29)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu29Layout.setVerticalGroup(
            phongTrangChu29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu29)
                .addContainerGap())
        );

        phongTrangChu30.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu30.setRoundBottomLeft(20);
        phongTrangChu30.setRoundBottomRight(20);
        phongTrangChu30.setRoundTopLeft(20);
        phongTrangChu30.setRoundTopRight(20);

        lblLoaiPhongTrangChu30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu30.setText("Tiêu chuẩn");

        lblTenPhongTrangChu30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu30.setText("101TC");

        lblTrangThaiTrangChu30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu30.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu30Layout = new javax.swing.GroupLayout(phongTrangChu30);
        phongTrangChu30.setLayout(phongTrangChu30Layout);
        phongTrangChu30Layout.setHorizontalGroup(
            phongTrangChu30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu30Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu30)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu30Layout.setVerticalGroup(
            phongTrangChu30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu30)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
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
                        .addComponent(phongTrangChu26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phongTrangChu27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phongTrangChu30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongTrangChu27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongTrangChu30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChu2Layout = new javax.swing.GroupLayout(Tang1_TrangChu2);
        Tang1_TrangChu2.setLayout(Tang1_TrangChu2Layout);
        Tang1_TrangChu2Layout.setHorizontalGroup(
            Tang1_TrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tang1_TrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang1_TrangChu2Layout.setVerticalGroup(
            Tang1_TrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Tang1_TrangChu3.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 4", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        phongTrangChu31.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu31.setRoundBottomLeft(20);
        phongTrangChu31.setRoundBottomRight(20);
        phongTrangChu31.setRoundTopLeft(20);
        phongTrangChu31.setRoundTopRight(20);

        lblLoaiPhongTrangChu31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu31.setText("Tiêu chuẩn");

        lblTenPhongTrangChu31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu31.setText("101TC");

        lblTrangThaiTrangChu31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu31.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu31Layout = new javax.swing.GroupLayout(phongTrangChu31);
        phongTrangChu31.setLayout(phongTrangChu31Layout);
        phongTrangChu31Layout.setHorizontalGroup(
            phongTrangChu31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu31Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu31)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu31Layout.setVerticalGroup(
            phongTrangChu31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu31)
                .addContainerGap())
        );

        phongTrangChu32.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu32.setRoundBottomLeft(20);
        phongTrangChu32.setRoundBottomRight(20);
        phongTrangChu32.setRoundTopLeft(20);
        phongTrangChu32.setRoundTopRight(20);

        lblLoaiPhongTrangChu32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu32.setText("Tiêu chuẩn");

        lblTenPhongTrangChu32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu32.setText("101TC");

        lblTrangThaiTrangChu32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu32.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu32Layout = new javax.swing.GroupLayout(phongTrangChu32);
        phongTrangChu32.setLayout(phongTrangChu32Layout);
        phongTrangChu32Layout.setHorizontalGroup(
            phongTrangChu32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu32Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu32)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu32Layout.setVerticalGroup(
            phongTrangChu32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu32)
                .addContainerGap())
        );

        phongTrangChu33.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu33.setRoundBottomLeft(20);
        phongTrangChu33.setRoundBottomRight(20);
        phongTrangChu33.setRoundTopLeft(20);
        phongTrangChu33.setRoundTopRight(20);

        lblLoaiPhongTrangChu33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu33.setText("Tiêu chuẩn");

        lblTenPhongTrangChu33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu33.setText("101TC");

        lblTrangThaiTrangChu33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu33.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu33Layout = new javax.swing.GroupLayout(phongTrangChu33);
        phongTrangChu33.setLayout(phongTrangChu33Layout);
        phongTrangChu33Layout.setHorizontalGroup(
            phongTrangChu33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu33Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu33)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu33Layout.setVerticalGroup(
            phongTrangChu33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu33)
                .addContainerGap())
        );

        phongTrangChu34.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu34.setRoundBottomLeft(20);
        phongTrangChu34.setRoundBottomRight(20);
        phongTrangChu34.setRoundTopLeft(20);
        phongTrangChu34.setRoundTopRight(20);

        lblLoaiPhongTrangChu34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu34.setText("Tiêu chuẩn");

        lblTenPhongTrangChu34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu34.setText("101TC");

        lblTrangThaiTrangChu34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu34.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu34Layout = new javax.swing.GroupLayout(phongTrangChu34);
        phongTrangChu34.setLayout(phongTrangChu34Layout);
        phongTrangChu34Layout.setHorizontalGroup(
            phongTrangChu34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu34Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu34)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu34Layout.setVerticalGroup(
            phongTrangChu34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThaiTrangChu34)
                .addContainerGap())
        );

        phongTrangChu35.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu35.setRoundBottomLeft(20);
        phongTrangChu35.setRoundBottomRight(20);
        phongTrangChu35.setRoundTopLeft(20);
        phongTrangChu35.setRoundTopRight(20);

        lblLoaiPhongTrangChu35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongTrangChu35.setText("Tiêu chuẩn");

        lblTenPhongTrangChu35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongTrangChu35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongTrangChu35.setText("101TC");

        lblTrangThaiTrangChu35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiTrangChu35.setText("Đang thuê");

        javax.swing.GroupLayout phongTrangChu35Layout = new javax.swing.GroupLayout(phongTrangChu35);
        phongTrangChu35.setLayout(phongTrangChu35Layout);
        phongTrangChu35Layout.setHorizontalGroup(
            phongTrangChu35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongTrangChu35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongTrangChu35Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongTrangChu35)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu35Layout.setVerticalGroup(
            phongTrangChu35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhongTrangChu35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1_TrangChu3Layout = new javax.swing.GroupLayout(Tang1_TrangChu3);
        Tang1_TrangChu3.setLayout(Tang1_TrangChu3Layout);
        Tang1_TrangChu3Layout.setHorizontalGroup(
            Tang1_TrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tang1_TrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1_TrangChu3Layout.setVerticalGroup(
            Tang1_TrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChu3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
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
                .addContainerGap(116, Short.MAX_VALUE))
        );
        pnBody1Layout.setVerticalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tang1_TrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnLayOutTrangChuLayout = new javax.swing.GroupLayout(pnLayOutTrangChu);
        pnLayOutTrangChu.setLayout(pnLayOutTrangChuLayout);
        pnLayOutTrangChuLayout.setHorizontalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addGap(0, 70, Short.MAX_VALUE)
                .addComponent(pnBody1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 83, Short.MAX_VALUE))
        );
        pnLayOutTrangChuLayout.setVerticalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnBody1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        scrollPaneWin111.setViewportView(pnLayOutTrangChu);

        javax.swing.GroupLayout pnLayoutSroolLayout = new javax.swing.GroupLayout(pnLayoutSrool);
        pnLayoutSrool.setLayout(pnLayoutSroolLayout);
        pnLayoutSroolLayout.setHorizontalGroup(
            pnLayoutSroolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1215, Short.MAX_VALUE)
            .addGroup(pnLayoutSroolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnLayoutSroolLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 1203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnLayoutSroolLayout.setVerticalGroup(
            pnLayoutSroolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
            .addGroup(pnLayoutSroolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnLayoutSroolLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayoutSrool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayoutSrool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab1", pnTrangChu);

        funtionPanel.setBackground(new java.awt.Color(254, 249, 239));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tìm phòng theo trạng thái");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tìm phòng theo loại phòng");

        btnTimTheoDieuKien.setText("Tìm");

        btnDatPhong.setText("Đặt phòng");

        btnHuyDatPhong.setText("Hủy đặt phòng");

        btnDoiPhong.setText("Đổi phòng");

        btnTraPhong.setText("Trả phòng");

        btnThuePhong.setText("Thuê phòng");

        btnResetTrangThai.setText("Reset");

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
                    .addGroup(funtionPanelLayout.createSequentialGroup()
                        .addComponent(btnTimTheoDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuyDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThuePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        funtionPanelLayout.setVerticalGroup(
            funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funtionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcurrentdate)
                    .addComponent(radPhongTieuChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radPhongTrong)
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltime)
                    .addComponent(radPhongNangCao)
                    .addComponent(radPhongDangThue)
                    .addComponent(btnDoiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThuePhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPhongCaoCap)
                    .addComponent(radPhongDaDat)
                    .addComponent(lblcurrentTime)
                    .addComponent(btnTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPhongThuongGia)
                    .addComponent(btnTimTheoDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnBody2.setBackground(new java.awt.Color(255, 255, 255));
        pnBody2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        phongQuanLy1.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy1.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy1.setRoundBottomLeft(20);
        phongQuanLy1.setRoundBottomRight(20);
        phongQuanLy1.setRoundTopLeft(20);
        phongQuanLy1.setRoundTopRight(20);

        lblLoaiPhongQL1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL1.setText("Tiêu chuẩn");
        lblLoaiPhongQL1.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL1.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL1.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL1.setText("101TC");

        lblTrangThaiQL1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL1.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy1Layout = new javax.swing.GroupLayout(phongQuanLy1);
        phongQuanLy1.setLayout(phongQuanLy1Layout);
        phongQuanLy1Layout.setHorizontalGroup(
            phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy1Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy1Layout.setVerticalGroup(
            phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy2.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy2.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy2.setRoundBottomLeft(20);
        phongQuanLy2.setRoundBottomRight(20);
        phongQuanLy2.setRoundTopLeft(20);
        phongQuanLy2.setRoundTopRight(20);

        lblLoaiPhongQL2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL2.setText("Tiêu chuẩn");
        lblLoaiPhongQL2.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL2.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL2.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL2.setText("101TC");

        lblTrangThaiQL2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL2.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy2Layout = new javax.swing.GroupLayout(phongQuanLy2);
        phongQuanLy2.setLayout(phongQuanLy2Layout);
        phongQuanLy2Layout.setHorizontalGroup(
            phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy2Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy2Layout.setVerticalGroup(
            phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy3.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy3.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy3.setRoundBottomLeft(20);
        phongQuanLy3.setRoundBottomRight(20);
        phongQuanLy3.setRoundTopLeft(20);
        phongQuanLy3.setRoundTopRight(20);

        lblLoaiPhongQL3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL3.setText("Tiêu chuẩn");
        lblLoaiPhongQL3.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL3.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL3.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL3.setText("101TC");

        lblTrangThaiQL3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL3.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy3Layout = new javax.swing.GroupLayout(phongQuanLy3);
        phongQuanLy3.setLayout(phongQuanLy3Layout);
        phongQuanLy3Layout.setHorizontalGroup(
            phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy3Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy3Layout.setVerticalGroup(
            phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy4.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy4.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy4.setRoundBottomLeft(20);
        phongQuanLy4.setRoundBottomRight(20);
        phongQuanLy4.setRoundTopLeft(20);
        phongQuanLy4.setRoundTopRight(20);

        lblLoaiPhongQL4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL4.setText("Tiêu chuẩn");
        lblLoaiPhongQL4.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL4.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL4.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL4.setText("101TC");

        lblTrangThaiQL4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL4.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy4Layout = new javax.swing.GroupLayout(phongQuanLy4);
        phongQuanLy4.setLayout(phongQuanLy4Layout);
        phongQuanLy4Layout.setHorizontalGroup(
            phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy4Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy4Layout.setVerticalGroup(
            phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy5.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy5.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy5.setRoundBottomLeft(20);
        phongQuanLy5.setRoundBottomRight(20);
        phongQuanLy5.setRoundTopLeft(20);
        phongQuanLy5.setRoundTopRight(20);

        lblLoaiPhongQL5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL5.setText("Tiêu chuẩn");
        lblLoaiPhongQL5.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL5.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL5.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL5.setText("101TC");

        lblTrangThaiQL5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL5.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy5Layout = new javax.swing.GroupLayout(phongQuanLy5);
        phongQuanLy5.setLayout(phongQuanLy5Layout);
        phongQuanLy5Layout.setHorizontalGroup(
            phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy5Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL5, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy5Layout.setVerticalGroup(
            phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy6.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy6.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy6.setRoundBottomLeft(20);
        phongQuanLy6.setRoundBottomRight(20);
        phongQuanLy6.setRoundTopLeft(20);
        phongQuanLy6.setRoundTopRight(20);

        lblLoaiPhongQL6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL6.setText("Tiêu chuẩn");
        lblLoaiPhongQL6.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL6.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL6.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL6.setText("101TC");

        lblTrangThaiQL6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL6.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy6Layout = new javax.swing.GroupLayout(phongQuanLy6);
        phongQuanLy6.setLayout(phongQuanLy6Layout);
        phongQuanLy6Layout.setHorizontalGroup(
            phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy6Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL6, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy6Layout.setVerticalGroup(
            phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tầng 2");

        phongQuanLy7.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy7.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy7.setRoundBottomLeft(20);
        phongQuanLy7.setRoundBottomRight(20);
        phongQuanLy7.setRoundTopLeft(20);
        phongQuanLy7.setRoundTopRight(20);

        lblLoaiPhongQL7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL7.setText("Tiêu chuẩn");
        lblLoaiPhongQL7.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL7.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL7.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL7.setText("101TC");

        lblTrangThaiQL7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL7.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy7Layout = new javax.swing.GroupLayout(phongQuanLy7);
        phongQuanLy7.setLayout(phongQuanLy7Layout);
        phongQuanLy7Layout.setHorizontalGroup(
            phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy7Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL7, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy7Layout.setVerticalGroup(
            phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy8.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy8.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy8.setRoundBottomLeft(20);
        phongQuanLy8.setRoundBottomRight(20);
        phongQuanLy8.setRoundTopLeft(20);
        phongQuanLy8.setRoundTopRight(20);

        lblLoaiPhongQL8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL8.setText("Tiêu chuẩn");
        lblLoaiPhongQL8.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL8.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL8.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL8.setText("101TC");

        lblTrangThaiQL8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL8.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy8Layout = new javax.swing.GroupLayout(phongQuanLy8);
        phongQuanLy8.setLayout(phongQuanLy8Layout);
        phongQuanLy8Layout.setHorizontalGroup(
            phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy8Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL8, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy8Layout.setVerticalGroup(
            phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy9.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy9.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy9.setRoundBottomLeft(20);
        phongQuanLy9.setRoundBottomRight(20);
        phongQuanLy9.setRoundTopLeft(20);
        phongQuanLy9.setRoundTopRight(20);

        lblLoaiPhongQL9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL9.setText("Tiêu chuẩn");
        lblLoaiPhongQL9.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL9.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL9.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL9.setText("101TC");

        lblTrangThaiQL9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL9.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy9Layout = new javax.swing.GroupLayout(phongQuanLy9);
        phongQuanLy9.setLayout(phongQuanLy9Layout);
        phongQuanLy9Layout.setHorizontalGroup(
            phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy9Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL9, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy9Layout.setVerticalGroup(
            phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy10.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy10.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy10.setRoundBottomLeft(20);
        phongQuanLy10.setRoundBottomRight(20);
        phongQuanLy10.setRoundTopLeft(20);
        phongQuanLy10.setRoundTopRight(20);

        lblLoaiPhongQL10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL10.setText("Tiêu chuẩn");
        lblLoaiPhongQL10.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL10.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL10.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL10.setText("101TC");

        lblTrangThaiQL10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL10.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy10Layout = new javax.swing.GroupLayout(phongQuanLy10);
        phongQuanLy10.setLayout(phongQuanLy10Layout);
        phongQuanLy10Layout.setHorizontalGroup(
            phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy10Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL10, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy10Layout.setVerticalGroup(
            phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnChonPhongTrongTang1.setText("Chọn phòng trống");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChonPhongTrongTang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChonPhongTrongTang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(phongQuanLy10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phongQuanLy9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phongQuanLy8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phongQuanLy7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Tầng 1");

        phongQuanLy11.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy11.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy11.setRoundBottomLeft(20);
        phongQuanLy11.setRoundBottomRight(20);
        phongQuanLy11.setRoundTopLeft(20);
        phongQuanLy11.setRoundTopRight(20);

        lblLoaiPhongQL11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL11.setText("Tiêu chuẩn");
        lblLoaiPhongQL11.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL11.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL11.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL11.setText("101TC");

        lblTrangThaiQL11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL11.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy11Layout = new javax.swing.GroupLayout(phongQuanLy11);
        phongQuanLy11.setLayout(phongQuanLy11Layout);
        phongQuanLy11Layout.setHorizontalGroup(
            phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy11Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL11, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy11Layout.setVerticalGroup(
            phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy12.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy12.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy12.setRoundBottomLeft(20);
        phongQuanLy12.setRoundBottomRight(20);
        phongQuanLy12.setRoundTopLeft(20);
        phongQuanLy12.setRoundTopRight(20);

        lblLoaiPhongQL12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL12.setText("Tiêu chuẩn");
        lblLoaiPhongQL12.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL12.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL12.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL12.setText("101TC");

        lblTrangThaiQL12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL12.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy12Layout = new javax.swing.GroupLayout(phongQuanLy12);
        phongQuanLy12.setLayout(phongQuanLy12Layout);
        phongQuanLy12Layout.setHorizontalGroup(
            phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy12Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy12Layout.setVerticalGroup(
            phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy13.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy13.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy13.setRoundBottomLeft(20);
        phongQuanLy13.setRoundBottomRight(20);
        phongQuanLy13.setRoundTopLeft(20);
        phongQuanLy13.setRoundTopRight(20);

        lblLoaiPhongQL13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL13.setText("Tiêu chuẩn");
        lblLoaiPhongQL13.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL13.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL13.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL13.setText("101TC");

        lblTrangThaiQL13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL13.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy13Layout = new javax.swing.GroupLayout(phongQuanLy13);
        phongQuanLy13.setLayout(phongQuanLy13Layout);
        phongQuanLy13Layout.setHorizontalGroup(
            phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy13Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy13Layout.setVerticalGroup(
            phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy14.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy14.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy14.setRoundBottomLeft(20);
        phongQuanLy14.setRoundBottomRight(20);
        phongQuanLy14.setRoundTopLeft(20);
        phongQuanLy14.setRoundTopRight(20);

        lblLoaiPhongQL14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL14.setText("Tiêu chuẩn");
        lblLoaiPhongQL14.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL14.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL14.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL14.setText("101TC");

        lblTrangThaiQL14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL14.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy14Layout = new javax.swing.GroupLayout(phongQuanLy14);
        phongQuanLy14.setLayout(phongQuanLy14Layout);
        phongQuanLy14Layout.setHorizontalGroup(
            phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy14Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy14Layout.setVerticalGroup(
            phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy15.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy15.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy15.setRoundBottomLeft(20);
        phongQuanLy15.setRoundBottomRight(20);
        phongQuanLy15.setRoundTopLeft(20);
        phongQuanLy15.setRoundTopRight(20);

        lblLoaiPhongQL15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL15.setText("Tiêu chuẩn");
        lblLoaiPhongQL15.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL15.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL15.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL15.setText("101TC");

        lblTrangThaiQL15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL15.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy15Layout = new javax.swing.GroupLayout(phongQuanLy15);
        phongQuanLy15.setLayout(phongQuanLy15Layout);
        phongQuanLy15Layout.setHorizontalGroup(
            phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy15Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy15Layout.setVerticalGroup(
            phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy16.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy16.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy16.setRoundBottomLeft(20);
        phongQuanLy16.setRoundBottomRight(20);
        phongQuanLy16.setRoundTopLeft(20);
        phongQuanLy16.setRoundTopRight(20);

        lblLoaiPhongQL16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL16.setText("Tiêu chuẩn");
        lblLoaiPhongQL16.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL16.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL16.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL16.setText("101TC");

        lblTrangThaiQL16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL16.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy16Layout = new javax.swing.GroupLayout(phongQuanLy16);
        phongQuanLy16.setLayout(phongQuanLy16Layout);
        phongQuanLy16Layout.setHorizontalGroup(
            phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy16Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL16, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy16Layout.setVerticalGroup(
            phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy17.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy17.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy17.setRoundBottomLeft(20);
        phongQuanLy17.setRoundBottomRight(20);
        phongQuanLy17.setRoundTopLeft(20);
        phongQuanLy17.setRoundTopRight(20);

        lblLoaiPhongQL17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL17.setText("Tiêu chuẩn");
        lblLoaiPhongQL17.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL17.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL17.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL17.setText("101TC");

        lblTrangThaiQL17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL17.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy17Layout = new javax.swing.GroupLayout(phongQuanLy17);
        phongQuanLy17.setLayout(phongQuanLy17Layout);
        phongQuanLy17Layout.setHorizontalGroup(
            phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy17Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL17, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy17Layout.setVerticalGroup(
            phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy18.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy18.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy18.setRoundBottomLeft(20);
        phongQuanLy18.setRoundBottomRight(20);
        phongQuanLy18.setRoundTopLeft(20);
        phongQuanLy18.setRoundTopRight(20);

        lblLoaiPhongQL18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL18.setText("Tiêu chuẩn");
        lblLoaiPhongQL18.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL18.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL18.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL18.setText("101TC");

        lblTrangThaiQL18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL18.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy18Layout = new javax.swing.GroupLayout(phongQuanLy18);
        phongQuanLy18.setLayout(phongQuanLy18Layout);
        phongQuanLy18Layout.setHorizontalGroup(
            phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy18Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL18, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy18Layout.setVerticalGroup(
            phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy19.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy19.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy19.setRoundBottomLeft(20);
        phongQuanLy19.setRoundBottomRight(20);
        phongQuanLy19.setRoundTopLeft(20);
        phongQuanLy19.setRoundTopRight(20);

        lblLoaiPhongQL19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL19.setText("Tiêu chuẩn");
        lblLoaiPhongQL19.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL19.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL19.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL19.setText("101TC");

        lblTrangThaiQL19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL19.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy19Layout = new javax.swing.GroupLayout(phongQuanLy19);
        phongQuanLy19.setLayout(phongQuanLy19Layout);
        phongQuanLy19Layout.setHorizontalGroup(
            phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy19Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL19, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy19Layout.setVerticalGroup(
            phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy20.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy20.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy20.setRoundBottomLeft(20);
        phongQuanLy20.setRoundBottomRight(20);
        phongQuanLy20.setRoundTopLeft(20);
        phongQuanLy20.setRoundTopRight(20);

        lblLoaiPhongQL20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL20.setText("Tiêu chuẩn");
        lblLoaiPhongQL20.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL20.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL20.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL20.setText("101TC");

        lblTrangThaiQL20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL20.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy20Layout = new javax.swing.GroupLayout(phongQuanLy20);
        phongQuanLy20.setLayout(phongQuanLy20Layout);
        phongQuanLy20Layout.setHorizontalGroup(
            phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy20Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy20Layout.setVerticalGroup(
            phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Tầng 3");

        phongQuanLy21.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy21.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy21.setRoundBottomLeft(20);
        phongQuanLy21.setRoundBottomRight(20);
        phongQuanLy21.setRoundTopLeft(20);
        phongQuanLy21.setRoundTopRight(20);

        lblLoaiPhongQL21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL21.setText("Tiêu chuẩn");
        lblLoaiPhongQL21.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL21.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL21.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL21.setText("101TC");

        lblTrangThaiQL21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL21.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy21Layout = new javax.swing.GroupLayout(phongQuanLy21);
        phongQuanLy21.setLayout(phongQuanLy21Layout);
        phongQuanLy21Layout.setHorizontalGroup(
            phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy21Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy21Layout.setVerticalGroup(
            phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy22.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy22.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy22.setRoundBottomLeft(20);
        phongQuanLy22.setRoundBottomRight(20);
        phongQuanLy22.setRoundTopLeft(20);
        phongQuanLy22.setRoundTopRight(20);

        lblLoaiPhongQL22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL22.setText("Tiêu chuẩn");
        lblLoaiPhongQL22.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL22.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL22.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL22.setText("101TC");

        lblTrangThaiQL22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL22.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy22Layout = new javax.swing.GroupLayout(phongQuanLy22);
        phongQuanLy22.setLayout(phongQuanLy22Layout);
        phongQuanLy22Layout.setHorizontalGroup(
            phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy22Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL22, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy22Layout.setVerticalGroup(
            phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy23.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy23.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy23.setRoundBottomLeft(20);
        phongQuanLy23.setRoundBottomRight(20);
        phongQuanLy23.setRoundTopLeft(20);
        phongQuanLy23.setRoundTopRight(20);

        lblLoaiPhongQL23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL23.setText("Tiêu chuẩn");
        lblLoaiPhongQL23.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL23.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL23.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL23.setText("101TC");

        lblTrangThaiQL23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL23.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy23Layout = new javax.swing.GroupLayout(phongQuanLy23);
        phongQuanLy23.setLayout(phongQuanLy23Layout);
        phongQuanLy23Layout.setHorizontalGroup(
            phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy23Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL23, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy23Layout.setVerticalGroup(
            phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy24.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy24.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy24.setRoundBottomLeft(20);
        phongQuanLy24.setRoundBottomRight(20);
        phongQuanLy24.setRoundTopLeft(20);
        phongQuanLy24.setRoundTopRight(20);

        lblLoaiPhongQL24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL24.setText("Tiêu chuẩn");
        lblLoaiPhongQL24.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL24.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL24.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL24.setText("101TC");

        lblTrangThaiQL24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL24.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy24Layout = new javax.swing.GroupLayout(phongQuanLy24);
        phongQuanLy24.setLayout(phongQuanLy24Layout);
        phongQuanLy24Layout.setHorizontalGroup(
            phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy24Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy24Layout.setVerticalGroup(
            phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy25.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy25.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy25.setRoundBottomLeft(20);
        phongQuanLy25.setRoundBottomRight(20);
        phongQuanLy25.setRoundTopLeft(20);
        phongQuanLy25.setRoundTopRight(20);

        lblLoaiPhongQL25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL25.setText("Tiêu chuẩn");
        lblLoaiPhongQL25.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL25.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL25.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL25.setText("101TC");

        lblTrangThaiQL25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL25.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy25Layout = new javax.swing.GroupLayout(phongQuanLy25);
        phongQuanLy25.setLayout(phongQuanLy25Layout);
        phongQuanLy25Layout.setHorizontalGroup(
            phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy25Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL25, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy25Layout.setVerticalGroup(
            phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy26.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy26.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy26.setRoundBottomLeft(20);
        phongQuanLy26.setRoundBottomRight(20);
        phongQuanLy26.setRoundTopLeft(20);
        phongQuanLy26.setRoundTopRight(20);

        lblLoaiPhongQL26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL26.setText("Tiêu chuẩn");
        lblLoaiPhongQL26.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL26.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL26.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL26.setText("101TC");

        lblTrangThaiQL26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL26.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy26Layout = new javax.swing.GroupLayout(phongQuanLy26);
        phongQuanLy26.setLayout(phongQuanLy26Layout);
        phongQuanLy26Layout.setHorizontalGroup(
            phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy26Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL26, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy26Layout.setVerticalGroup(
            phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy21, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy27.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy27.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy27.setRoundBottomLeft(20);
        phongQuanLy27.setRoundBottomRight(20);
        phongQuanLy27.setRoundTopLeft(20);
        phongQuanLy27.setRoundTopRight(20);

        lblLoaiPhongQL27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL27.setText("Tiêu chuẩn");
        lblLoaiPhongQL27.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL27.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL27.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL27.setText("101TC");

        lblTrangThaiQL27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL27.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy27Layout = new javax.swing.GroupLayout(phongQuanLy27);
        phongQuanLy27.setLayout(phongQuanLy27Layout);
        phongQuanLy27Layout.setHorizontalGroup(
            phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy27Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL27, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy27Layout.setVerticalGroup(
            phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy28.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy28.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy28.setRoundBottomLeft(20);
        phongQuanLy28.setRoundBottomRight(20);
        phongQuanLy28.setRoundTopLeft(20);
        phongQuanLy28.setRoundTopRight(20);

        lblLoaiPhongQL28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL28.setText("Tiêu chuẩn");
        lblLoaiPhongQL28.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL28.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL28.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL28.setText("101TC");

        lblTrangThaiQL28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL28.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy28Layout = new javax.swing.GroupLayout(phongQuanLy28);
        phongQuanLy28.setLayout(phongQuanLy28Layout);
        phongQuanLy28Layout.setHorizontalGroup(
            phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy28Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy28Layout.setVerticalGroup(
            phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy29.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy29.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy29.setRoundBottomLeft(20);
        phongQuanLy29.setRoundBottomRight(20);
        phongQuanLy29.setRoundTopLeft(20);
        phongQuanLy29.setRoundTopRight(20);

        lblLoaiPhongQL29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL29.setText("Tiêu chuẩn");
        lblLoaiPhongQL29.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL29.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL29.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL29.setText("101TC");

        lblTrangThaiQL29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL29.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy29Layout = new javax.swing.GroupLayout(phongQuanLy29);
        phongQuanLy29.setLayout(phongQuanLy29Layout);
        phongQuanLy29Layout.setHorizontalGroup(
            phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy29Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL29, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy29Layout.setVerticalGroup(
            phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy30.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy30.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy30.setRoundBottomLeft(20);
        phongQuanLy30.setRoundBottomRight(20);
        phongQuanLy30.setRoundTopLeft(20);
        phongQuanLy30.setRoundTopRight(20);

        lblLoaiPhongQL30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL30.setText("Tiêu chuẩn");
        lblLoaiPhongQL30.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL30.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL30.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL30.setText("101TC");

        lblTrangThaiQL30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL30.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy30Layout = new javax.swing.GroupLayout(phongQuanLy30);
        phongQuanLy30.setLayout(phongQuanLy30Layout);
        phongQuanLy30Layout.setHorizontalGroup(
            phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy30Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL30, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy30Layout.setVerticalGroup(
            phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy31.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy31.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy31.setRoundBottomLeft(20);
        phongQuanLy31.setRoundBottomRight(20);
        phongQuanLy31.setRoundTopLeft(20);
        phongQuanLy31.setRoundTopRight(20);

        lblLoaiPhongQL31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL31.setText("Tiêu chuẩn");
        lblLoaiPhongQL31.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL31.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL31.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL31.setText("101TC");

        lblTrangThaiQL31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL31.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy31Layout = new javax.swing.GroupLayout(phongQuanLy31);
        phongQuanLy31.setLayout(phongQuanLy31Layout);
        phongQuanLy31Layout.setHorizontalGroup(
            phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy31Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy31Layout.setVerticalGroup(
            phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy32.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy32.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy32.setRoundBottomLeft(20);
        phongQuanLy32.setRoundBottomRight(20);
        phongQuanLy32.setRoundTopLeft(20);
        phongQuanLy32.setRoundTopRight(20);

        lblLoaiPhongQL32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL32.setText("Tiêu chuẩn");
        lblLoaiPhongQL32.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL32.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL32.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL32.setText("101TC");

        lblTrangThaiQL32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL32.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy32Layout = new javax.swing.GroupLayout(phongQuanLy32);
        phongQuanLy32.setLayout(phongQuanLy32Layout);
        phongQuanLy32Layout.setHorizontalGroup(
            phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy32Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL32, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy32Layout.setVerticalGroup(
            phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy33.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy33.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy33.setRoundBottomLeft(20);
        phongQuanLy33.setRoundBottomRight(20);
        phongQuanLy33.setRoundTopLeft(20);
        phongQuanLy33.setRoundTopRight(20);

        lblLoaiPhongQL33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL33.setText("Tiêu chuẩn");
        lblLoaiPhongQL33.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL33.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL33.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL33.setText("101TC");

        lblTrangThaiQL33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL33.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy33Layout = new javax.swing.GroupLayout(phongQuanLy33);
        phongQuanLy33.setLayout(phongQuanLy33Layout);
        phongQuanLy33Layout.setHorizontalGroup(
            phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy33Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL33, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy33Layout.setVerticalGroup(
            phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy34.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy34.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy34.setRoundBottomLeft(20);
        phongQuanLy34.setRoundBottomRight(20);
        phongQuanLy34.setRoundTopLeft(20);
        phongQuanLy34.setRoundTopRight(20);

        lblLoaiPhongQL34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL34.setText("Tiêu chuẩn");
        lblLoaiPhongQL34.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL34.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL34.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL34.setText("101TC");

        lblTrangThaiQL34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL34.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy34Layout = new javax.swing.GroupLayout(phongQuanLy34);
        phongQuanLy34.setLayout(phongQuanLy34Layout);
        phongQuanLy34Layout.setHorizontalGroup(
            phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy34Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL34, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy34Layout.setVerticalGroup(
            phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phongQuanLy35.setBackground(new java.awt.Color(255, 204, 255));
        phongQuanLy35.setPreferredSize(new java.awt.Dimension(146, 93));
        phongQuanLy35.setRoundBottomLeft(20);
        phongQuanLy35.setRoundBottomRight(20);
        phongQuanLy35.setRoundTopLeft(20);
        phongQuanLy35.setRoundTopRight(20);

        lblLoaiPhongQL35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhongQL35.setText("Tiêu chuẩn");
        lblLoaiPhongQL35.setMaximumSize(new java.awt.Dimension(80, 16));
        lblLoaiPhongQL35.setMinimumSize(new java.awt.Dimension(72, 16));
        lblLoaiPhongQL35.setPreferredSize(new java.awt.Dimension(72, 16));

        lblTenPhongQL35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhongQL35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhongQL35.setText("101TC");

        lblTrangThaiQL35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThaiQL35.setText("Đang thuê");

        javax.swing.GroupLayout phongQuanLy35Layout = new javax.swing.GroupLayout(phongQuanLy35);
        phongQuanLy35.setLayout(phongQuanLy35Layout);
        phongQuanLy35Layout.setHorizontalGroup(
            phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phongQuanLy35Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhongQL35, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(checkBoxPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhongQL35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiQL35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongQuanLy35Layout.setVerticalGroup(
            phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongQuanLy35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTenPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThaiQL35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
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
                .addContainerGap(190, Short.MAX_VALUE))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Tầng 3");

        javax.swing.GroupLayout pnBody2Layout = new javax.swing.GroupLayout(pnBody2);
        pnBody2.setLayout(pnBody2Layout);
        pnBody2Layout.setHorizontalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel18)
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel21)
                    .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        pnBody2Layout.setVerticalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(7, 7, 7)
                .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        scrollPaneWin112.setViewportView(pnBody2);

        javax.swing.GroupLayout pnLayoutQLLayout = new javax.swing.GroupLayout(pnLayoutQL);
        pnLayoutQL.setLayout(pnLayoutQLLayout);
        pnLayoutQLLayout.setHorizontalGroup(
            pnLayoutQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLayoutQLLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 1138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnLayoutQLLayout.setVerticalGroup(
            pnLayoutQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayoutQLLayout.createSequentialGroup()
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnLayoutQuanLyPhongLayout = new javax.swing.GroupLayout(pnLayoutQuanLyPhong);
        pnLayoutQuanLyPhong.setLayout(pnLayoutQuanLyPhongLayout);
        pnLayoutQuanLyPhongLayout.setHorizontalGroup(
            pnLayoutQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayoutQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayoutQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(funtionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnLayoutQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnLayoutQuanLyPhongLayout.setVerticalGroup(
            pnLayoutQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLayoutQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnLayoutQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnQuanLyPhongLayout = new javax.swing.GroupLayout(pnQuanLyPhong);
        pnQuanLyPhong.setLayout(pnQuanLyPhongLayout);
        pnQuanLyPhongLayout.setHorizontalGroup(
            pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayoutQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pnQuanLyPhongLayout.setVerticalGroup(
            pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayoutQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab2", pnQuanLyPhong);

        pnLayOutNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnLayOutNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jPanel12.setBackground(new java.awt.Color(254, 249, 239));

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

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác", " " }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Chức vụ");
        jLabel9.setToolTipText("");
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 21));

        cbxChucVuNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên lễ tân", "Nhân viên quản lý", " " }));

        btnCapNhapNhanVien.setBackground(new java.awt.Color(255, 203, 119));
        btnCapNhapNhanVien.setText("Cập nhập nhân viên");
        btnCapNhapNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapNhanVienActionPerformed(evt);
            }
        });

        btnTamChoNghiNhanVien.setBackground(new java.awt.Color(255, 203, 119));
        btnTamChoNghiNhanVien.setText("Tạm cho nghỉ");
        btnTamChoNghiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamChoNghiNhanVienActionPerformed(evt);
            }
        });

        btnThemNhanVien.setBackground(new java.awt.Color(255, 203, 119));
        btnThemNhanVien.setText("Thêm nhân viên");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnXoaTrangNhanVien.setBackground(new java.awt.Color(255, 203, 119));
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
                                .addGap(30, 30, 30))
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
                                .addGap(30, 30, 30))
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
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayVaoLamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                false, false, false, false, false, false, false, false, false
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab3", pnNhanVien);

        pnLayOutDichVu.setBackground(new java.awt.Color(255, 255, 255));
        pnLayOutDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý dịch vụ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jPanel14.setBackground(new java.awt.Color(254, 249, 239));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Mã dịch vụ");
        jLabel6.setToolTipText("");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tên dịch vụ");
        jLabel12.setToolTipText("");
        jLabel12.setPreferredSize(new java.awt.Dimension(120, 21));

        txtDonGiaDichVu.setText("Đơn giá dịch vụ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Đơn giá dịch vụ");
        jLabel16.setToolTipText("");
        jLabel16.setPreferredSize(new java.awt.Dimension(120, 21));

        btnCapNhapDichVu.setBackground(new java.awt.Color(255, 203, 119));
        btnCapNhapDichVu.setText("Cập nhập dịch vụ");
        btnCapNhapDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapDichVuActionPerformed(evt);
            }
        });

        btnThemDichVu.setBackground(new java.awt.Color(255, 203, 119));
        btnThemDichVu.setText("Thêm dịch vụ");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnXoaTrangDichVu.setBackground(new java.awt.Color(255, 203, 119));
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
                false, false, false, false
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDichVuLayout.setVerticalGroup(
            pnDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab4", pnDichVu);

        pnLayOutKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        pnLayOutKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý Khuyến Mãi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jPanel16.setBackground(new java.awt.Color(254, 249, 239));

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

        btnCapNhapKhuyenMai.setBackground(new java.awt.Color(255, 203, 119));
        btnCapNhapKhuyenMai.setText("Cập nhật khuyến mãi");

        btnNgungKhuyenMai.setBackground(new java.awt.Color(255, 203, 119));
        btnNgungKhuyenMai.setText("Kết thúc khuyễn mãi");

        btnThemKhuyenMai.setBackground(new java.awt.Color(255, 203, 119));
        btnThemKhuyenMai.setText("Thêm khuyến mãi");

        btnXoaTrangKhuyenMai.setBackground(new java.awt.Color(255, 203, 119));
        btnXoaTrangKhuyenMai.setText("Xóa trắng");
        btnXoaTrangKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangKhuyenMaiActionPerformed(evt);
            }
        });

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
                                .addGap(30, 30, 30))
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                false, false, false, false, false, false, false
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnKhuyenMaiLayout.setVerticalGroup(
            pnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab5", pnKhuyenMai);

        pnLayOutKhachKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnLayOutKhachKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jPanel18.setBackground(new java.awt.Color(254, 249, 239));

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

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Hạng thành viên");
        jLabel34.setToolTipText("");
        jLabel34.setPreferredSize(new java.awt.Dimension(120, 21));

        cbxGioiTinhKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        btnCapNhapKhachHang.setBackground(new java.awt.Color(255, 203, 119));
        btnCapNhapKhachHang.setText("Cập nhập khách hàng");
        btnCapNhapKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapKhachHangActionPerformed(evt);
            }
        });

        btnThemKhachHang.setBackground(new java.awt.Color(255, 203, 119));
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

        btnXoaTrangKhachHangQL.setBackground(new java.awt.Color(255, 203, 119));
        btnXoaTrangKhachHangQL.setText("Xóa trắng");
        btnXoaTrangKhachHangQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangKhachHangQLActionPerformed(evt);
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
                                .addGap(30, 30, 30))
                            .addComponent(txtCanCuocKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuocTichKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaTrangKhachHangQL)
                        .addGap(18, 18, 18)
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
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnThemKhachHang)
                    .addComponent(btnXoaTrangKhachHangQL))
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
                false, false, false, false, false, false, false, false, false, false
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab6", pnKhachHang);

        jPanel1.add(pnedUngDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 1240, 800));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void txtHangThanhVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtHangThanhVienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtHangThanhVienActionPerformed

	private String taoMaKhachHang() {
		KhachHangDao khDao = new KhachHangDao();
		int stt = khDao.demTongSoKhachHang();
		String maKhachHang = "KH" + String.format("%05d", stt);
		return maKhachHang;
	}

	// NGUYỄN QUỐC HUY chỉnh sửa phương thức kiểm tra tên chuỗi tiếng việt
	private boolean regTen(String ten) {
		String regex = "^[A-Z][a-zA-Z\\p{L}]+(\\s+[A-Za-z\\p{L}]+)*$";
		Pattern pattern = Pattern.compile(regex, Pattern.CANON_EQ);
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

	private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemKhachHangActionPerformed
		String tenKhachHang = txtTenKhachHang.getText();
		// Kiểm tra tên
		if (regTen(tenKhachHang) == false) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không hợp lệ");
			return;
		}
		String gioiTinh = cbxGioiTinhKhachHang.getSelectedItem().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngaySinhKhachHangFormat = LocalDate.parse(txtNgaySinhKhachHang.getText(), formatter);
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
		String quocTich = txtQuocTichKhachHang.getText();
		String maKhachHang = taoMaKhachHang();
		KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, soDienThoai, CCCD_Visa, 0d, "HB",
				quocTich);
		KhachHangDao khDao = new KhachHangDao();
		boolean themKhachHang = khDao.themKhachHang(kh);
		if (themKhachHang) {
			JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
			loadTableKhachHang();
		} else {
			JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại");
		}
	}// GEN-LAST:event_btnThemKhachHangActionPerformed

	private void btnCapNhapKhachHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNhapKhachHangActionPerformed
		String tenKhachHang = txtTenKhachHang.getText();
		// Kiểm tra tên
		if (regTen(tenKhachHang) == false) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không hợp lệ");
			return;
		}
		String gioiTinh = cbxGioiTinhKhachHang.getSelectedItem().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngaySinhKhachHangFormat = LocalDate.parse(txtNgaySinhKhachHang.getText(), formatter);
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
		String quocTich = txtQuocTichKhachHang.getText();
		String maKhachHang = txtMaKhachHang.getText();
		double chiTieu = Double.parseDouble(txtChiTieuKhachHang.getText());
		String maHangThanhVien = txtHangThanhVien.getText();
		KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, soDienThoai, CCCD_Visa, chiTieu, "HB",
				quocTich);
		KhachHangDao khDao = new KhachHangDao();
		boolean capNhapKhachHang = khDao.suaThongTinKhachHang(kh);
		if (capNhapKhachHang) {
			JOptionPane.showMessageDialog(null, "Cập nhập khách hàng thành công");
			loadTableKhachHang();
		} else {
			JOptionPane.showMessageDialog(null, "Cập nhập khách hàng thất bại");
		}
	}// GEN-LAST:event_btnCapNhapKhachHangActionPerformed

	private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDatPhongActionPerformed
//		List<String> dsTenPhong = new ArrayList<>();
//		JCheckBox cks;
//		JLabel tenPhong;
//		for (int i = 0; i < phongQuanLy.size(); i++) {
//			cks = checkBoxPhongQuanLy.get(i);
//			tenPhong = tenPhongQuanLy.get(i);
//			if (cks.isSelected()) {
//				dsTenPhong.add(tenPhong.getText());
//			}
//		}
//
//		DatPhong datPhongFrame = new DatPhong(dsTenPhong);
//		datPhongFrame.setVisible(true);

	}// GEN-LAST:event_btnDatPhongActionPerformed

	private void radPhongTieuChuanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radPhongTieuChuanActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_radPhongTieuChuanActionPerformed

	private void radPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radPhongTrongActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_radPhongTrongActionPerformed

	private void btnTimTheoDieuKienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFindbyPhoneActionPerformed
//		ganDuLieuPhongVaoQuanLyPhong();
//		if (radPhongTieuChuan.isSelected()) {
//			for (int i = 0; i < loaiPhongQuanLy.size(); i++) {
//				JPanel p = phongQuanLy.get(i);
//				JLabel loaiP = loaiPhongQuanLy.get(i);
//				if (!loaiP.getText().equalsIgnoreCase("Tiêu chuẩn")) {
//					p.setVisible(false);
//				}
//			}
//		}  if (radPhongNangCao.isSelected()) {
//			for (int i = 0; i < phongQuanLy.size(); i++) {
//				JPanel p = phongQuanLy.get(i);
//				JLabel loaiP = loaiPhongQuanLy.get(i);
//				if (!loaiP.getText().equalsIgnoreCase("Nâng cao")) {
//					p.setVisible(false);
//				}
//			}
//		} else if (radPhongCaoCap.isSelected()) {
//			for (int i = 0; i < phongQuanLy.size(); i++) {
//				JPanel p = phongQuanLy.get(i);
//				JLabel loaiP = loaiPhongQuanLy.get(i);
//
//				if (!loaiP.getText().equalsIgnoreCase("Cao cấp")) {
//					p.setVisible(false);
//				}
//			}
//		} else if (radPhongThuongGia.isSelected()) {
//			for (int i = 0; i < phongQuanLy.size(); i++) {
//				JPanel p = phongQuanLy.get(i);
//				JLabel loaiP = loaiPhongQuanLy.get(i);
//
//				if (!loaiP.getText().equalsIgnoreCase("Thương gia")) {
//					p.setVisible(false);
//				}
//			}
//		}
//
//		if (radPhongTrong.isSelected()) {
//			for (int i = 0; i < phongQuanLy.size(); i++) {
//				JPanel p = phongQuanLy.get(i);
//				JLabel trangThaiP = trangThaiPhongQuanLy.get(i);
//
//				if (!trangThaiP.getText().equalsIgnoreCase("Trống")) {
//					p.setVisible(false);
//				}
//			}
//		} else if (radPhongDaDat.isSelected()) {
//			for (int i = 0; i < phongQuanLy.size(); i++) {
//				JPanel p = phongQuanLy.get(i);
//				JLabel trangThaiP = trangThaiPhongQuanLy.get(i);
//
//				if (!trangThaiP.getText().equalsIgnoreCase("Đã đặt")) {
//					p.setVisible(false);
//				}
//			}
//		} else if (radPhongDangThue.isSelected()) {
//			for (int i = 0; i < phongQuanLy.size(); i++) {
//				JPanel p = phongQuanLy.get(i);
//				JLabel trangThaiP = trangThaiPhongQuanLy.get(i);
//
//				if (!trangThaiP.getText().equalsIgnoreCase("Đã thuê")) {
//					p.setVisible(false);
//				}
//			}
//		}
	}// GEN-LAST:event_btnFindbyPhoneActionPerformed

	//Them xoa check box nuts reset
	private void btnResetTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetTrangThaiActionPerformed
//		// TODO add your handling code here:
//		ganDuLieuPhongVaoQuanLyPhong();
//		radPhongTieuChuan.setSelected(false);
//		radPhongNangCao.setSelected(false);
//		radPhongCaoCap.setSelected(false);
//		radPhongTrong.setSelected(false);
//		radPhongDangThue.setSelected(false);
//		radPhongDaDat.setSelected(false);
//		btnGROUPLoaiPhong.clearSelection();
//		btnGROUPTrangThai.clearSelection();
//		for (int i = 0; i < checkBoxPhongQuanLy.size(); i++) {
//			checkBoxPhongQuanLy.get(i).setSelected(false);
//		}
		
	}// GEN-LAST:event_btnResetTrangThaiActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton4ActionPerformed

	private void btnNgaySinhNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgaySinhNhanVienActionPerformed
//		dateNgaySinhNhanVien.showPopup();
	}// GEN-LAST:event_btnNgaySinhNhanVienActionPerformed

	private void btnNgayVaoLamNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgayVaoLamNhanVienActionPerformed
//		dateNgayVaoLam.showPopup();
	}// GEN-LAST:event_btnNgayVaoLamNhanVienActionPerformed

	private void btnThoiGianKetThucKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThoiGianKetThucKhuyenMaiActionPerformed
//		dateNgayKetThucKM.showPopup();
	}// GEN-LAST:event_btnThoiGianKetThucKhuyenMaiActionPerformed

	private void btnNgaySinhNhanVien3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgaySinhNhanVien3ActionPerformed
//		dateNgaySinhKhachHang.showPopup();
	}// GEN-LAST:event_btnNgaySinhNhanVien3ActionPerformed

	private void btnThoiGianBatDauKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThoiGianBatDauKhuyenMaiActionPerformed
//		dateNgayBatDauKM.showPopup();
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

	// NGUYEN QUỐC HUY CHỈNH SỬA Ở ĐÂY
	private void btnXoaTrangNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTrangNhanVienActionPerformed
		txtHoTenNhanVien.setText("");
		txtNgaySinhNhanVien.setText("");
		txtSoDienThoaiNhanVien.setText("");
		txtEmailNhanVien1.setText("");
		txtCanCuocCongDanNhanVien.setText("");
		cbxGioiTinh.setSelectedIndex(0);
		cbxChucVuNhanVien.setSelectedIndex(0);
		txtNgayVaoLamNhanVien.setText("");
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
			java.util.logging.Logger.getLogger(TrangChuNew2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TrangChuNew2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TrangChuNew2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TrangChuNew2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuNew2 trangChu = new TrangChuNew2();
					trangChu.setExtendedState(JFrame.MAXIMIZED_BOTH);
					trangChu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					trangChu.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
	}

//    TTK
	private void ganDuLieuPhongVaoTrangChu() {
//		PhongDao phongDao = new PhongDao();
//		ArrayList<Phong> dsPhong = phongDao.timTatCaPhongSapXepTheoSoPhong();
//		for (int i = 0; i < phongTrangChu.size(); i++) {
//			Phong phong = dsPhong.get(i);
//			JPanel phongPanel = phongTrangChu.get(i);
//			JLabel loaiPhong = loaiPhongTrangChu.get(i);
//			JLabel soPhong = tenPhongTrangChu.get(i);
//			JLabel trangThai = trangThaiPhongTrangChu.get(i);
//
//			// Gán thông tin phòng lên label
//			soPhong.setText(Integer.toString(phong.getSoPhong()));
//			if (phong.getMaLoaiPhong().equalsIgnoreCase("tc")) {
//				loaiPhong.setText("Tiêu chuẩn");
//			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("nc")) {
//				loaiPhong.setText("Nâng cao");
//			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("cc")) {
//				loaiPhong.setText("Cao cấp");
//			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("tg")) {
//				loaiPhong.setText("Thương gia");
//			}
//			trangThai.setText(phong.getTrangThai());
//
//			if (trangThai.getText().equalsIgnoreCase("Trống")) {
//				phongPanel.setBackground(Color.green);
//			} else if (trangThai.getText().equalsIgnoreCase("Đã đặt")) {
//				phongPanel.setBackground(Color.red);
//			} else if (trangThai.getText().equalsIgnoreCase("Đã thuê")) {
//				phongPanel.setBackground(Color.yellow);
//			}
//
//			if (phongPanel.isVisible() == false) {
//				phongPanel.show();
//			}
//		}
	}

	private void ganDuLieuPhongVaoQuanLyPhong() {
//		PhongDao phongDao = new PhongDao();
//		ArrayList<Phong> dsPhong = phongDao.timTatCaPhongSapXepTheoSoPhong();
//		for (int i = 0; i < phongQuanLy.size(); i++) {
//			Phong phong = dsPhong.get(i);
//			JPanel phongPanel = phongQuanLy.get(i);
//			JLabel loaiPhong = loaiPhongQuanLy.get(i);
//			JLabel soPhong = tenPhongQuanLy.get(i);
//			JLabel trangThai = trangThaiPhongQuanLy.get(i);
//
//			// Gán thông tin phòng lên label
//			soPhong.setText(Integer.toString(phong.getSoPhong()));
//			if (phong.getMaLoaiPhong().equalsIgnoreCase("tc")) {
//				loaiPhong.setText("Tiêu chuẩn");
//			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("nc")) {
//				loaiPhong.setText("Nâng cao");
//			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("cc")) {
//				loaiPhong.setText("Cao cấp");
//			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("tg")) {
//				loaiPhong.setText("Thương gia");
//			}
//			trangThai.setText(phong.getTrangThai());
//
//			if (trangThai.getText().equalsIgnoreCase("Trống")) {
//				phongPanel.setBackground(Color.green);
//			} else if (trangThai.getText().equalsIgnoreCase("Đã đặt")) {
//				phongPanel.setBackground(Color.red);
//			} else if (trangThai.getText().equalsIgnoreCase("Đã thuê")) {
//				phongPanel.setBackground(Color.yellow);
//			}
//
//			if (phongPanel.isVisible() == false) {
//				phongPanel.show();
//			}
//		}

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.Menu Menu;
    private javax.swing.JTable TableDichVu;
    private javax.swing.JTable TableKhachHang;
    private javax.swing.JTable TableKhuyenMai;
    private javax.swing.JTable TableNhanVien;
    private javax.swing.JPanel Tang1_TrangChu;
    private javax.swing.JPanel Tang1_TrangChu1;
    private javax.swing.JPanel Tang1_TrangChu2;
    private javax.swing.JPanel Tang1_TrangChu3;
    private javax.swing.JButton btnCapNhapDichVu;
    private javax.swing.JButton btnCapNhapKhachHang;
    private javax.swing.JButton btnCapNhapKhuyenMai;
    private javax.swing.JButton btnCapNhapNhanVien;
    private giaodien.CustomClass.Button btnChonPhongTrongTang1;
    private giaodien.CustomClass.Button btnDatPhong;
    private giaodien.CustomClass.Button btnDoiPhong;
    private javax.swing.ButtonGroup btnGROUPLoaiPhong;
    private javax.swing.ButtonGroup btnGROUPTrangThai;
    private giaodien.CustomClass.Button btnHuyDatPhong;
    private javax.swing.JButton btnNgungKhuyenMai;
    private giaodien.CustomClass.Button btnResetTrangThai;
    private javax.swing.JButton btnTamChoNghiNhanVien;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnThemNhanVien;
    private giaodien.CustomClass.Button btnThuePhong;
    private giaodien.CustomClass.Button btnTimTheoDieuKien;
    private giaodien.CustomClass.Button btnTraPhong;
    private javax.swing.JButton btnXoaTrangDichVu;
    private javax.swing.JButton btnXoaTrangKhachHangQL;
    private javax.swing.JButton btnXoaTrangKhuyenMai;
    private javax.swing.JButton btnXoaTrangNhanVien;
    private javax.swing.JComboBox<String> cbxChucVuNhanVien;
    private javax.swing.JComboBox<String> cbxDieuKienApDungKhuyenMai;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JComboBox<String> cbxGioiTinhKhachHang;
    private checkbox.JCheckBoxCustom checkBoxPhongQL1;
    private checkbox.JCheckBoxCustom checkBoxPhongQL10;
    private checkbox.JCheckBoxCustom checkBoxPhongQL11;
    private checkbox.JCheckBoxCustom checkBoxPhongQL12;
    private checkbox.JCheckBoxCustom checkBoxPhongQL13;
    private checkbox.JCheckBoxCustom checkBoxPhongQL14;
    private checkbox.JCheckBoxCustom checkBoxPhongQL15;
    private checkbox.JCheckBoxCustom checkBoxPhongQL16;
    private checkbox.JCheckBoxCustom checkBoxPhongQL17;
    private checkbox.JCheckBoxCustom checkBoxPhongQL18;
    private checkbox.JCheckBoxCustom checkBoxPhongQL19;
    private checkbox.JCheckBoxCustom checkBoxPhongQL2;
    private checkbox.JCheckBoxCustom checkBoxPhongQL20;
    private checkbox.JCheckBoxCustom checkBoxPhongQL21;
    private checkbox.JCheckBoxCustom checkBoxPhongQL22;
    private checkbox.JCheckBoxCustom checkBoxPhongQL23;
    private checkbox.JCheckBoxCustom checkBoxPhongQL24;
    private checkbox.JCheckBoxCustom checkBoxPhongQL25;
    private checkbox.JCheckBoxCustom checkBoxPhongQL26;
    private checkbox.JCheckBoxCustom checkBoxPhongQL27;
    private checkbox.JCheckBoxCustom checkBoxPhongQL28;
    private checkbox.JCheckBoxCustom checkBoxPhongQL29;
    private checkbox.JCheckBoxCustom checkBoxPhongQL3;
    private checkbox.JCheckBoxCustom checkBoxPhongQL30;
    private checkbox.JCheckBoxCustom checkBoxPhongQL31;
    private checkbox.JCheckBoxCustom checkBoxPhongQL32;
    private checkbox.JCheckBoxCustom checkBoxPhongQL33;
    private checkbox.JCheckBoxCustom checkBoxPhongQL34;
    private checkbox.JCheckBoxCustom checkBoxPhongQL35;
    private checkbox.JCheckBoxCustom checkBoxPhongQL4;
    private checkbox.JCheckBoxCustom checkBoxPhongQL5;
    private checkbox.JCheckBoxCustom checkBoxPhongQL6;
    private checkbox.JCheckBoxCustom checkBoxPhongQL7;
    private checkbox.JCheckBoxCustom checkBoxPhongQL8;
    private checkbox.JCheckBoxCustom checkBoxPhongQL9;
    private javax.swing.JPanel funtionPanel;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
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
    private giaodien.CustomClass.PanelRound panelRound1;
    private giaodien.CustomClass.PanelRound panelRound2;
    private giaodien.CustomClass.PanelRound panelRound3;
    private giaodien.CustomClass.PanelRound panelRound4;
    private giaodien.CustomClass.PanelRound panelRound5;
    private giaodien.CustomClass.PanelRound panelRound6;
    private giaodien.CustomClass.PanelRound panelRound7;
    private giaodien.CustomClass.PanelRound phongQuanLy1;
    private giaodien.CustomClass.PanelRound phongQuanLy10;
    private giaodien.CustomClass.PanelRound phongQuanLy11;
    private giaodien.CustomClass.PanelRound phongQuanLy12;
    private giaodien.CustomClass.PanelRound phongQuanLy13;
    private giaodien.CustomClass.PanelRound phongQuanLy14;
    private giaodien.CustomClass.PanelRound phongQuanLy15;
    private giaodien.CustomClass.PanelRound phongQuanLy16;
    private giaodien.CustomClass.PanelRound phongQuanLy17;
    private giaodien.CustomClass.PanelRound phongQuanLy18;
    private giaodien.CustomClass.PanelRound phongQuanLy19;
    private giaodien.CustomClass.PanelRound phongQuanLy2;
    private giaodien.CustomClass.PanelRound phongQuanLy20;
    private giaodien.CustomClass.PanelRound phongQuanLy21;
    private giaodien.CustomClass.PanelRound phongQuanLy22;
    private giaodien.CustomClass.PanelRound phongQuanLy23;
    private giaodien.CustomClass.PanelRound phongQuanLy24;
    private giaodien.CustomClass.PanelRound phongQuanLy25;
    private giaodien.CustomClass.PanelRound phongQuanLy26;
    private giaodien.CustomClass.PanelRound phongQuanLy27;
    private giaodien.CustomClass.PanelRound phongQuanLy28;
    private giaodien.CustomClass.PanelRound phongQuanLy29;
    private giaodien.CustomClass.PanelRound phongQuanLy3;
    private giaodien.CustomClass.PanelRound phongQuanLy30;
    private giaodien.CustomClass.PanelRound phongQuanLy31;
    private giaodien.CustomClass.PanelRound phongQuanLy32;
    private giaodien.CustomClass.PanelRound phongQuanLy33;
    private giaodien.CustomClass.PanelRound phongQuanLy34;
    private giaodien.CustomClass.PanelRound phongQuanLy35;
    private giaodien.CustomClass.PanelRound phongQuanLy4;
    private giaodien.CustomClass.PanelRound phongQuanLy5;
    private giaodien.CustomClass.PanelRound phongQuanLy6;
    private giaodien.CustomClass.PanelRound phongQuanLy7;
    private giaodien.CustomClass.PanelRound phongQuanLy8;
    private giaodien.CustomClass.PanelRound phongQuanLy9;
    private giaodien.CustomClass.PanelRound phongTrangChu1;
    private giaodien.CustomClass.PanelRound phongTrangChu10;
    private giaodien.CustomClass.PanelRound phongTrangChu11;
    private giaodien.CustomClass.PanelRound phongTrangChu12;
    private giaodien.CustomClass.PanelRound phongTrangChu13;
    private giaodien.CustomClass.PanelRound phongTrangChu14;
    private giaodien.CustomClass.PanelRound phongTrangChu15;
    private giaodien.CustomClass.PanelRound phongTrangChu16;
    private giaodien.CustomClass.PanelRound phongTrangChu17;
    private giaodien.CustomClass.PanelRound phongTrangChu18;
    private giaodien.CustomClass.PanelRound phongTrangChu19;
    private giaodien.CustomClass.PanelRound phongTrangChu2;
    private giaodien.CustomClass.PanelRound phongTrangChu20;
    private giaodien.CustomClass.PanelRound phongTrangChu21;
    private giaodien.CustomClass.PanelRound phongTrangChu22;
    private giaodien.CustomClass.PanelRound phongTrangChu23;
    private giaodien.CustomClass.PanelRound phongTrangChu24;
    private giaodien.CustomClass.PanelRound phongTrangChu25;
    private giaodien.CustomClass.PanelRound phongTrangChu26;
    private giaodien.CustomClass.PanelRound phongTrangChu27;
    private giaodien.CustomClass.PanelRound phongTrangChu28;
    private giaodien.CustomClass.PanelRound phongTrangChu29;
    private giaodien.CustomClass.PanelRound phongTrangChu3;
    private giaodien.CustomClass.PanelRound phongTrangChu30;
    private giaodien.CustomClass.PanelRound phongTrangChu31;
    private giaodien.CustomClass.PanelRound phongTrangChu32;
    private giaodien.CustomClass.PanelRound phongTrangChu33;
    private giaodien.CustomClass.PanelRound phongTrangChu34;
    private giaodien.CustomClass.PanelRound phongTrangChu35;
    private giaodien.CustomClass.PanelRound phongTrangChu4;
    private giaodien.CustomClass.PanelRound phongTrangChu5;
    private giaodien.CustomClass.PanelRound phongTrangChu6;
    private giaodien.CustomClass.PanelRound phongTrangChu7;
    private giaodien.CustomClass.PanelRound phongTrangChu8;
    private giaodien.CustomClass.PanelRound phongTrangChu9;
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
    private giaodien.CustomClass.PanelRound pnLayoutQL;
    private giaodien.CustomClass.PanelRound pnLayoutQuanLyPhong;
    private giaodien.CustomClass.PanelRound pnLayoutSrool;
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
    private ScollBar1.ScrollPaneWin11 scrollPaneWin111;
    private ScollBar1.ScrollPaneWin11 scrollPaneWin112;
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
    //HUY add variable declaration
    
    
//    private static void taoDanhSach(){
//        phongsTrangChu = new  ArrayList<>;
//        for (int i = 1; i <= 35; i++) {
//			try {
//				phonsgTrangChu.add((giaodien.CustomClass.PanelRound) getClass().getDeclaredField("phongTrangChu" + i).get(this));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//    }
            
            
	private JFrame DatPhong(List<String> dsTenPhong) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
	public String layHangThanhVien(String maHang) {
		if (maHang.equalsIgnoreCase("HB"))
			return "Hạng Bạc";
		else if (maHang.equalsIgnoreCase("HV"))
			return "Hạng Vàng";
		else if (maHang.equalsIgnoreCase("BK"))
			return "Bạch Kim";
		else if (maHang.equalsIgnoreCase("LB"))
			return "Lục Bảo";
		else
			return "Hạng Kim Cương";
	}
	
	protected void eventClickOnTableKhachHang() {
        TableKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TableKhachHang.getSelectedRow();
                    if (selectedRow != -1) { // Đảm bảo có hàng được chọn
                        txtMaKhachHang.setText((String) TableKhachHang.getValueAt(selectedRow, 1));
                        txtTenKhachHang.setText((String) TableKhachHang.getValueAt(selectedRow, 2));
                        String gioiTinh = (String) TableKhachHang.getValueAt(selectedRow, 3);
                        cbxGioiTinhKhachHang.setSelectedItem(gioiTinh);
                        LocalDate ngaySinh = (LocalDate) TableKhachHang.getValueAt(selectedRow, 4);
                        String ngaySinhStr = String.format("%02d-%02d-%d", ngaySinh.getDayOfMonth(), ngaySinh.getMonthValue(), ngaySinh.getYear());
                        txtNgaySinhKhachHang.setText(ngaySinhStr);
                        txtSoDienThoaiKhachHang.setText((String) TableKhachHang.getValueAt(selectedRow, 5));
                        txtCanCuocKhachHang.setText((String) TableKhachHang.getValueAt(selectedRow, 6));
                        txtChiTieuKhachHang.setText(String.valueOf(TableKhachHang.getValueAt(selectedRow, 7)));
                        String hangThanhVien = layHangThanhVien((String) TableKhachHang.getValueAt(selectedRow, 8));
                        txtHangThanhVien.setText(hangThanhVien);
                        txtQuocTichKhachHang.setText((String) TableKhachHang.getValueAt(selectedRow, 9));
                    }
                }
            }
        });
        
    }
	
	//Nguyễn Quốc Huy thêm event click on table nhân viên
	protected void eventClickOnTableNhanVien() {
		TableNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TableNhanVien.getSelectedRow();
                    if (selectedRow != -1) { // Đảm bảo có hàng được chọn
						txtMaNhanVien.setText((String) TableNhanVien.getValueAt(selectedRow, 1));
						txtHoTenNhanVien.setText((String) TableNhanVien.getValueAt(selectedRow, 2));
						String gioiTinh = (String) TableNhanVien.getValueAt(selectedRow, 3);
						cbxGioiTinh.setSelectedItem(gioiTinh);
						LocalDate ngaySinh = (LocalDate) TableNhanVien.getValueAt(selectedRow, 4);
						String ngaySinhStr = String.format("%02d-%02d-%d", ngaySinh.getDayOfMonth(), ngaySinh.getMonthValue(), ngaySinh.getYear());
						txtNgaySinhNhanVien.setText(ngaySinhStr);
						txtSoDienThoaiNhanVien.setText((String) TableNhanVien.getValueAt(selectedRow, 5));
						txtCanCuocCongDanNhanVien.setText((String) TableNhanVien.getValueAt(selectedRow, 6));
						LocalDate ngayVaoLam = (LocalDate) TableNhanVien.getValueAt(selectedRow, 7);
						String ngayVaoLamStr = String.format("%02d-%02d-%d", ngayVaoLam.getDayOfMonth(), ngayVaoLam.getMonthValue(), ngayVaoLam.getYear());
						txtNgayVaoLamNhanVien.setText(ngayVaoLamStr);
						cbxChucVuNhanVien.setSelectedItem((String) TableNhanVien.getValueAt(selectedRow, 8));
                    }
                }
            }
        });
	}
	
	// Kiểm tra click vào checkbox phòng và enable các button khi chọn xong các check box
	private void kiemTraClickCheckBoxPhong() {
//		int status1 = 0;
//		int status2 = 0;
//		int status3 = 0;
//		int status4 = 0;
//		for (int i = 0; i < checkBoxPhongQuanLy.size(); i++) {
//			JLabel trangThaiP = trangThaiPhongQuanLy.get(i);
//			if (checkBoxPhongQuanLy.get(i).isSelected() && trangThaiP.getText().equalsIgnoreCase("Trống")) {
//				btnDatPhong.setEnabled(true);
//				btnDoiPhong.setEnabled(false);
//				btnTraPhong.setEnabled(false);
//				btnHuyDatPhong.setEnabled(false);
//				status4++;
//				status2++;
//				status3++;
//			} else if (checkBoxPhongQuanLy.get(i).isSelected() && trangThaiP.getText().equalsIgnoreCase("Đã đặt")) {
//				btnDatPhong.setEnabled(false);
//				btnDoiPhong.setEnabled(true);
//				btnTraPhong.setEnabled(false);
//				btnHuyDatPhong.setEnabled(true);
//				status4++;
//				status1++;
//				status3++;
//			} else if (checkBoxPhongQuanLy.get(i).isSelected() && trangThaiP.getText().equalsIgnoreCase("Đã thuê")) {
//				btnDatPhong.setEnabled(false);
//				btnDoiPhong.setEnabled(true);
//				btnHuyDatPhong.setEnabled(false);
//				btnTraPhong.setEnabled(true);
//				status4++;
//				status1++;
//				status2++;
//			} 
//		}
//		
//		
//		if (status1 != 0 && status2 != 0 && status3 != 0) {
//			btnDatPhong.setEnabled(false);
//			btnDoiPhong.setEnabled(false);
//			btnTraPhong.setEnabled(false);
//			btnHuyDatPhong.setEnabled(false);
//		}
//		if (status4 == 0) {
//			btnDatPhong.setEnabled(true);
//			btnDoiPhong.setEnabled(true);
//			btnTraPhong.setEnabled(true);
//			btnHuyDatPhong.setEnabled(true);
//		}
	}
	private void addCheckBoxListeners() {
//	    for (JCheckBox checkBox : checkBoxPhongQuanLy) {
//	        checkBox.addItemListener(e -> kiemTraClickCheckBoxPhong());
//	    }
	}
}