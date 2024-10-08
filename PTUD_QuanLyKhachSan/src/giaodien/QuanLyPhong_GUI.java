/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package giaodien;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import dao.PhongDao;
import entity.NhanVien;
import entity.Phong;
import java.awt.Dimension;

/**
 *
 * @author Huynguyen
 */
public class QuanLyPhong_GUI extends javax.swing.JPanel {
	private String tenphong;
	/**
	 * Creates new form QuanLyPhong2
	 */
	public QuanLyPhong_GUI() {
		initComponents();
	}

	private NhanVien nv;
    /**
     * Creates new form QuanLyPhong2
     */
    public QuanLyPhong_GUI(NhanVien n) {
        initComponents();
        this.nv = n;
//		Gán thời gian cho Jlabel
		datetime();
		times();

//		TTK - Thêm phongQuanLy i chạy từ 1 đến 35 vào list
		phongQuanLy = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				phongQuanLy.add(
						(giaodien.CustomClass.PanelRound) getClass().getDeclaredField("phongQuanLy" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		loaiPhongQuanLy = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				loaiPhongQuanLy.add((JLabel) getClass().getDeclaredField("lblLoaiPhongQL" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		tenPhongQuanLy = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				tenPhongQuanLy.add((JLabel) getClass().getDeclaredField("lblTenPhongQL" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		trangThaiPhongQuanLy = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				trangThaiPhongQuanLy.add((JLabel) getClass().getDeclaredField("lblTrangThaiQL" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		checkBoxPhongQuanLy = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				checkBoxPhongQuanLy.add((giaodien.CustomClass.JCheckBoxCustom) getClass()
						.getDeclaredField("checkBoxPhongQL" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		loadDanhSachPhong();
		addCheckBoxListeners();
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

	private void kiemTraClickCheckBoxPhong() {
		int status1 = 0;
		int status2 = 0;
		int status3 = 0;
		int status4 = 0;
		for (int i = 0; i < checkBoxPhongQuanLy.size(); i++) {
			JLabel trangThaiP = trangThaiPhongQuanLy.get(i);
			if (checkBoxPhongQuanLy.get(i).isSelected() && trangThaiP.getText().equalsIgnoreCase("Trống")) {
				btnDatPhong.setEnabled(true);
				btnThuePhong.setEnabled(true);
				btnDoiPhong.setEnabled(false);
				btnTraPhong.setEnabled(false);
				btnHuyDatPhong.setEnabled(false);
				status2++;
				status3++;
				status4++;
			} else if (checkBoxPhongQuanLy.get(i).isSelected() && trangThaiP.getText().equalsIgnoreCase("Đã đặt")) {
				btnDatPhong.setEnabled(true);
				btnThuePhong.setEnabled(true);
				btnDoiPhong.setEnabled(false);
				btnTraPhong.setEnabled(false);
				btnHuyDatPhong.setEnabled(true);
				status1++;
				status3++;
				status4++;
			} else if (checkBoxPhongQuanLy.get(i).isSelected() && trangThaiP.getText().equalsIgnoreCase("Đã thuê")) {
				btnDatPhong.setEnabled(true);
				btnThuePhong.setEnabled(false);
				btnDoiPhong.setEnabled(true);
				btnHuyDatPhong.setEnabled(true);
				btnTraPhong.setEnabled(true);
				status1++;
				status2++;
				status4++;
			}
		}

		if (status1 != 0 && status2 != 0 && status3 != 0) {
			btnDatPhong.setEnabled(true);
			btnThuePhong.setEnabled(false);
			btnDoiPhong.setEnabled(false);
			btnTraPhong.setEnabled(false);
			btnHuyDatPhong.setEnabled(false);
		}
		if (status4 == 0) {
			btnDatPhong.setEnabled(true);
			btnThuePhong.setEnabled(true);
			btnDoiPhong.setEnabled(true);
			btnTraPhong.setEnabled(true);
			btnHuyDatPhong.setEnabled(true);
		}
	}

	private void addCheckBoxListeners() {
		for (giaodien.CustomClass.JCheckBoxCustom checkBox : checkBoxPhongQuanLy) {
			checkBox.addItemListener(e -> kiemTraClickCheckBoxPhong());
		}
	}

	public void loadDanhSachPhong() {
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = phongDao.timTatCaPhongSapXepTheoSoPhong();
		for (int i = 0; i < phongQuanLy.size(); i++) {
			Phong phong = dsPhong.get(i);
			JPanel phongPanel = phongQuanLy.get(i);
			JLabel loaiPhong = loaiPhongQuanLy.get(i);
			JLabel soPhong = tenPhongQuanLy.get(i);
			JLabel trangThai = trangThaiPhongQuanLy.get(i);

			// Gán thông tin phòng lên label
			soPhong.setText(Integer.toString(phong.getSoPhong()));
			if (phong.getMaLoaiPhong().equalsIgnoreCase("tc")) {
				loaiPhong.setText("Tiêu chuẩn");
			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("nc")) {
				loaiPhong.setText("Nâng cao");
			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("cc")) {
				loaiPhong.setText("Cao cấp");
			} else if (phong.getMaLoaiPhong().equalsIgnoreCase("tg")) {
				loaiPhong.setText("Thương gia");
			}
			trangThai.setText(phong.getTrangThai());

			if (trangThai.getText().equalsIgnoreCase("Trống")) {
				phongPanel.setBackground(Color.green);
			} else if (trangThai.getText().equalsIgnoreCase("Đã đặt")) {
				phongPanel.setBackground(Color.yellow);
			} else if (trangThai.getText().equalsIgnoreCase("Đã thuê")) {
				phongPanel.setBackground(Color.red);
			}

			if (phongPanel.isVisible() == false) {
				phongPanel.setVisible(true);
			}
		}

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		btnGroupLoaiPhong = new javax.swing.ButtonGroup();
		btnGroupTrangThai = new javax.swing.ButtonGroup();
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
		btnNhanPhong = new giaodien.CustomClass.Button();
		btnThemDichVu = new giaodien.CustomClass.Button();
		pnLayoutQL = new giaodien.CustomClass.PanelRound();
		scrollPaneWin112 = new giaodien.CustomClass.ScrollPaneWin11();
		pnBody2 = new javax.swing.JPanel();
		panelRound1 = new giaodien.CustomClass.PanelRound();
		phongQuanLy1 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL1 = new javax.swing.JLabel();
		lblTenPhongQL1 = new javax.swing.JLabel();
		lblTrangThaiQL1 = new javax.swing.JLabel();
		checkBoxPhongQL1 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy2 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL2 = new javax.swing.JLabel();
		lblTenPhongQL2 = new javax.swing.JLabel();
		lblTrangThaiQL2 = new javax.swing.JLabel();
		checkBoxPhongQL2 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy3 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL3 = new javax.swing.JLabel();
		lblTenPhongQL3 = new javax.swing.JLabel();
		lblTrangThaiQL3 = new javax.swing.JLabel();
		checkBoxPhongQL3 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy4 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL4 = new javax.swing.JLabel();
		lblTenPhongQL4 = new javax.swing.JLabel();
		lblTrangThaiQL4 = new javax.swing.JLabel();
		checkBoxPhongQL4 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy5 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL5 = new javax.swing.JLabel();
		lblTenPhongQL5 = new javax.swing.JLabel();
		lblTrangThaiQL5 = new javax.swing.JLabel();
		checkBoxPhongQL5 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy6 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL6 = new javax.swing.JLabel();
		lblTenPhongQL6 = new javax.swing.JLabel();
		lblTrangThaiQL6 = new javax.swing.JLabel();
		checkBoxPhongQL6 = new giaodien.CustomClass.JCheckBoxCustom();
		jLabel11 = new javax.swing.JLabel();
		panelRound2 = new giaodien.CustomClass.PanelRound();
		phongQuanLy7 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL7 = new javax.swing.JLabel();
		lblTenPhongQL7 = new javax.swing.JLabel();
		lblTrangThaiQL7 = new javax.swing.JLabel();
		checkBoxPhongQL7 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy8 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL8 = new javax.swing.JLabel();
		lblTenPhongQL8 = new javax.swing.JLabel();
		lblTrangThaiQL8 = new javax.swing.JLabel();
		checkBoxPhongQL8 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy9 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL9 = new javax.swing.JLabel();
		lblTenPhongQL9 = new javax.swing.JLabel();
		lblTrangThaiQL9 = new javax.swing.JLabel();
		checkBoxPhongQL9 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy10 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL10 = new javax.swing.JLabel();
		lblTenPhongQL10 = new javax.swing.JLabel();
		lblTrangThaiQL10 = new javax.swing.JLabel();
		checkBoxPhongQL10 = new giaodien.CustomClass.JCheckBoxCustom();
		btnChonPhongTrongTang1 = new giaodien.CustomClass.Button();
		btnChonPhongThueTang1 = new giaodien.CustomClass.Button();
		jLabel17 = new javax.swing.JLabel();
		panelRound3 = new giaodien.CustomClass.PanelRound();
		phongQuanLy11 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL11 = new javax.swing.JLabel();
		lblTenPhongQL11 = new javax.swing.JLabel();
		lblTrangThaiQL11 = new javax.swing.JLabel();
		checkBoxPhongQL11 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy12 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL12 = new javax.swing.JLabel();
		lblTenPhongQL12 = new javax.swing.JLabel();
		lblTrangThaiQL12 = new javax.swing.JLabel();
		checkBoxPhongQL12 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy13 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL13 = new javax.swing.JLabel();
		lblTenPhongQL13 = new javax.swing.JLabel();
		lblTrangThaiQL13 = new javax.swing.JLabel();
		checkBoxPhongQL13 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy14 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL14 = new javax.swing.JLabel();
		lblTenPhongQL14 = new javax.swing.JLabel();
		lblTrangThaiQL14 = new javax.swing.JLabel();
		checkBoxPhongQL14 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy15 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL15 = new javax.swing.JLabel();
		lblTenPhongQL15 = new javax.swing.JLabel();
		lblTrangThaiQL15 = new javax.swing.JLabel();
		checkBoxPhongQL15 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy16 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL16 = new javax.swing.JLabel();
		lblTenPhongQL16 = new javax.swing.JLabel();
		lblTrangThaiQL16 = new javax.swing.JLabel();
		checkBoxPhongQL16 = new giaodien.CustomClass.JCheckBoxCustom();
		panelRound4 = new giaodien.CustomClass.PanelRound();
		phongQuanLy17 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL17 = new javax.swing.JLabel();
		lblTenPhongQL17 = new javax.swing.JLabel();
		lblTrangThaiQL17 = new javax.swing.JLabel();
		checkBoxPhongQL17 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy18 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL18 = new javax.swing.JLabel();
		lblTenPhongQL18 = new javax.swing.JLabel();
		lblTrangThaiQL18 = new javax.swing.JLabel();
		checkBoxPhongQL18 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy19 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL19 = new javax.swing.JLabel();
		lblTenPhongQL19 = new javax.swing.JLabel();
		lblTrangThaiQL19 = new javax.swing.JLabel();
		checkBoxPhongQL19 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy20 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL20 = new javax.swing.JLabel();
		lblTenPhongQL20 = new javax.swing.JLabel();
		lblTrangThaiQL20 = new javax.swing.JLabel();
		checkBoxPhongQL20 = new giaodien.CustomClass.JCheckBoxCustom();
		btnChonPhongThueTang2 = new giaodien.CustomClass.Button();
		btnChonPhongTrongTang2 = new giaodien.CustomClass.Button();
		jLabel18 = new javax.swing.JLabel();
		panelRound5 = new giaodien.CustomClass.PanelRound();
		phongQuanLy21 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL21 = new javax.swing.JLabel();
		lblTenPhongQL21 = new javax.swing.JLabel();
		lblTrangThaiQL21 = new javax.swing.JLabel();
		checkBoxPhongQL21 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy22 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL22 = new javax.swing.JLabel();
		lblTenPhongQL22 = new javax.swing.JLabel();
		lblTrangThaiQL22 = new javax.swing.JLabel();
		checkBoxPhongQL22 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy23 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL23 = new javax.swing.JLabel();
		lblTenPhongQL23 = new javax.swing.JLabel();
		lblTrangThaiQL23 = new javax.swing.JLabel();
		checkBoxPhongQL23 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy24 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL24 = new javax.swing.JLabel();
		lblTenPhongQL24 = new javax.swing.JLabel();
		lblTrangThaiQL24 = new javax.swing.JLabel();
		checkBoxPhongQL24 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy25 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL25 = new javax.swing.JLabel();
		lblTenPhongQL25 = new javax.swing.JLabel();
		lblTrangThaiQL25 = new javax.swing.JLabel();
		checkBoxPhongQL25 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy26 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL26 = new javax.swing.JLabel();
		lblTenPhongQL26 = new javax.swing.JLabel();
		lblTrangThaiQL26 = new javax.swing.JLabel();
		checkBoxPhongQL26 = new giaodien.CustomClass.JCheckBoxCustom();
		panelRound6 = new giaodien.CustomClass.PanelRound();
		phongQuanLy27 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL27 = new javax.swing.JLabel();
		lblTenPhongQL27 = new javax.swing.JLabel();
		lblTrangThaiQL27 = new javax.swing.JLabel();
		checkBoxPhongQL27 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy28 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL28 = new javax.swing.JLabel();
		lblTenPhongQL28 = new javax.swing.JLabel();
		lblTrangThaiQL28 = new javax.swing.JLabel();
		checkBoxPhongQL28 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy29 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL29 = new javax.swing.JLabel();
		lblTenPhongQL29 = new javax.swing.JLabel();
		lblTrangThaiQL29 = new javax.swing.JLabel();
		checkBoxPhongQL29 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy30 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL30 = new javax.swing.JLabel();
		lblTenPhongQL30 = new javax.swing.JLabel();
		lblTrangThaiQL30 = new javax.swing.JLabel();
		checkBoxPhongQL30 = new giaodien.CustomClass.JCheckBoxCustom();
		btnChonPhongTrongTang3 = new giaodien.CustomClass.Button();
		btnChonPhongThueTang3 = new giaodien.CustomClass.Button();
		panelRound7 = new giaodien.CustomClass.PanelRound();
		phongQuanLy31 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL31 = new javax.swing.JLabel();
		lblTenPhongQL31 = new javax.swing.JLabel();
		lblTrangThaiQL31 = new javax.swing.JLabel();
		checkBoxPhongQL31 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy32 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL32 = new javax.swing.JLabel();
		lblTenPhongQL32 = new javax.swing.JLabel();
		lblTrangThaiQL32 = new javax.swing.JLabel();
		checkBoxPhongQL32 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy33 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL33 = new javax.swing.JLabel();
		lblTenPhongQL33 = new javax.swing.JLabel();
		lblTrangThaiQL33 = new javax.swing.JLabel();
		checkBoxPhongQL33 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy34 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL34 = new javax.swing.JLabel();
		lblTenPhongQL34 = new javax.swing.JLabel();
		lblTrangThaiQL34 = new javax.swing.JLabel();
		checkBoxPhongQL34 = new giaodien.CustomClass.JCheckBoxCustom();
		phongQuanLy35 = new giaodien.CustomClass.PanelRound();
		lblLoaiPhongQL35 = new javax.swing.JLabel();
		lblTenPhongQL35 = new javax.swing.JLabel();
		lblTrangThaiQL35 = new javax.swing.JLabel();
		checkBoxPhongQL35 = new giaodien.CustomClass.JCheckBoxCustom();
		btnChonPhongThueTang4 = new giaodien.CustomClass.Button();
		btnChonPhongTrongTang4 = new giaodien.CustomClass.Button();
		jLabel21 = new javax.swing.JLabel();
		panelRound8 = new giaodien.CustomClass.PanelRound();
		jLabel5 = new javax.swing.JLabel();
		jPanel7 = new javax.swing.JPanel();
		jPanel10 = new javax.swing.JPanel();
		jPanel11 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();

		funtionPanel.setBackground(new java.awt.Color(254, 249, 239));
		funtionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý phòng",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

		lbldate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		lbldate.setText("Date");

		lbltime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		lbltime.setText("Time");

		lblcurrentdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		lblcurrentdate.setText("currentDate");

		lblcurrentTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		lblcurrentTime.setText("currentTime");

		radPhongTieuChuan.setBackground(new java.awt.Color(254, 249, 239));
		btnGroupLoaiPhong.add(radPhongTieuChuan);
		radPhongTieuChuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		radPhongTieuChuan.setText("Phòng tiêu chuẩn");

		radPhongNangCao.setBackground(new java.awt.Color(254, 249, 239));
		btnGroupLoaiPhong.add(radPhongNangCao);
		radPhongNangCao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		radPhongNangCao.setText("Phòng nâng cao");

		radPhongCaoCap.setBackground(new java.awt.Color(254, 249, 239));
		btnGroupLoaiPhong.add(radPhongCaoCap);
		radPhongCaoCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		radPhongCaoCap.setText("Phòng cao cấp");

		radPhongThuongGia.setBackground(new java.awt.Color(254, 249, 239));
		btnGroupLoaiPhong.add(radPhongThuongGia);
		radPhongThuongGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		radPhongThuongGia.setText("Phòng thương gia");

		radPhongTrong.setBackground(new java.awt.Color(254, 249, 239));
		btnGroupTrangThai.add(radPhongTrong);
		radPhongTrong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		radPhongTrong.setText("Phòng trống");

		radPhongDaDat.setBackground(new java.awt.Color(254, 249, 239));
		btnGroupTrangThai.add(radPhongDaDat);
		radPhongDaDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		radPhongDaDat.setText("Phòng đã đặt");

		radPhongDangThue.setBackground(new java.awt.Color(254, 249, 239));
		btnGroupTrangThai.add(radPhongDangThue);
		radPhongDangThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		radPhongDangThue.setText("Phòng đang thuê");

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel1.setText("Tìm phòng theo trạng thái");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel2.setText("Tìm phòng theo loại phòng");

		btnTimTheoDieuKien.setText("Tìm");
		btnTimTheoDieuKien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimTheoDieuKienActionPerformed(evt);
			}
		});

		btnDatPhong.setText("Đặt phòng");
		btnDatPhong.setPreferredSize(new Dimension(120, 30));
		btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDatPhongActionPerformed(evt);
			}
		});

		btnHuyDatPhong.setText("Hủy đặt phòng");
		btnHuyDatPhong.setPreferredSize(new Dimension(120, 30));
		btnHuyDatPhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyDatPhongActionPerformed(evt);
			}
		});

		btnDoiPhong.setText("Đổi phòng");
		btnDoiPhong.setPreferredSize(new Dimension(120, 30));
		btnDoiPhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDoiPhongActionPerformed(evt);
			}
		});

		btnTraPhong.setText("Trả phòng");
		btnTraPhong.setPreferredSize(new Dimension(120, 30));
		btnTraPhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTraPhongActionPerformed(evt);
			}
		});

		btnThuePhong.setText("Thuê phòng");
		btnThuePhong.setPreferredSize(new Dimension(120, 30));
		btnThuePhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThuePhongActionPerformed(evt);
			}
		});

		btnResetTrangThai.setText("Reset");
		btnResetTrangThai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResetTrangThaiActionPerformed(evt);
			}
		});

		btnNhanPhong.setText("Nhận phòng");
		btnNhanPhong.setPreferredSize(new Dimension(120, 30));
		btnNhanPhong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNhanPhongActionPerformed(evt);
			}
		});

		btnThemDichVu.setText("Thêm dịch vụ");
		btnThemDichVu.setPreferredSize(new Dimension(120, 30));
		btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemDichVuActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout funtionPanelLayout = new javax.swing.GroupLayout(funtionPanel);
		funtionPanel.setLayout(funtionPanelLayout);
		funtionPanelLayout.setHorizontalGroup(funtionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(funtionPanelLayout.createSequentialGroup().addGroup(funtionPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(funtionPanelLayout.createSequentialGroup().addGap(66, 66, 66)
								.addGroup(funtionPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblcurrentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblcurrentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(funtionPanelLayout.createSequentialGroup().addContainerGap().addComponent(lbldate,
								javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(funtionPanelLayout.createSequentialGroup().addContainerGap().addComponent(lbltime,
								javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funtionPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnDoiPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(35, 35, 35).addComponent(btnTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(5, 5, 5)
						.addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(funtionPanelLayout.createSequentialGroup().addGroup(funtionPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(radPhongTieuChuan)
										.addComponent(radPhongNangCao, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radPhongThuongGia).addComponent(jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 266,
												javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(115, 115, 115)
										.addGroup(funtionPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(radPhongDangThue)
												.addComponent(radPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE,
														141, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1)
												.addComponent(radPhongDaDat, javax.swing.GroupLayout.PREFERRED_SIZE,
														141, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(funtionPanelLayout.createSequentialGroup()
														.addComponent(btnTimTheoDieuKien,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(btnResetTrangThai,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(funtionPanelLayout.createSequentialGroup().addGroup(funtionPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(funtionPanelLayout.createSequentialGroup()
												.addComponent(radPhongCaoCap, javax.swing.GroupLayout.PREFERRED_SIZE,
														146, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(271, 271, 271))
										.addGroup(funtionPanelLayout.createSequentialGroup().addGap(29, 29, 29)
												.addComponent(btnHuyDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
														130, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(34, 34, 34)
												.addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
														127, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(42, 42, 42)))
										.addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(47, 47, 47)
										.addComponent(btnThuePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(43, 43, 43)))));
		funtionPanelLayout.setVerticalGroup(funtionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funtionPanelLayout.createSequentialGroup()
						.addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(funtionPanelLayout.createSequentialGroup().addContainerGap()
										.addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblcurrentdate)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lbltime)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblcurrentTime)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										funtionPanelLayout.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
												.addGroup(funtionPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2).addComponent(jLabel1))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(funtionPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(radPhongTieuChuan,
																javax.swing.GroupLayout.PREFERRED_SIZE, 25,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(radPhongTrong))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(funtionPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(radPhongNangCao).addComponent(radPhongDangThue))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(funtionPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(radPhongCaoCap).addComponent(radPhongDaDat))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(funtionPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(radPhongThuongGia)
														.addComponent(btnTimTheoDieuKien,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btnResetTrangThai,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
						.addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(funtionPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnThemDichVu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(funtionPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnThuePhong, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(btnHuyDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(funtionPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDoiPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(20, 20, 20)));

		pnBody2.setBackground(new java.awt.Color(255, 255, 255));
		pnBody2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		panelRound1.setBackground(new java.awt.Color(255, 255, 255));
		panelRound1.setMaximumSize(new java.awt.Dimension(918, 105));
		panelRound1.setMinimumSize(new java.awt.Dimension(918, 105));

		phongQuanLy1.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy1.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy1.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy1Layout.setHorizontalGroup(phongQuanLy1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy1Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy1Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL1, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy1Layout.setVerticalGroup(phongQuanLy1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy1Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL1).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy2.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy2.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy2.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy2Layout.setHorizontalGroup(phongQuanLy2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy2Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy2Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL2, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL2, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy2Layout.setVerticalGroup(phongQuanLy2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy2Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL2, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL2).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy3.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy3.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy3.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy3Layout.setHorizontalGroup(phongQuanLy3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy3Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy3Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL3, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL3, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL3, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy3Layout.setVerticalGroup(phongQuanLy3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy3Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL3, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL3).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy4.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy4.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy4.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy4Layout.setHorizontalGroup(phongQuanLy4Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy4Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy4Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL4, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy4Layout.setVerticalGroup(phongQuanLy4Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy4Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL4, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL4).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy5.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy5.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy5.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy5Layout.setHorizontalGroup(phongQuanLy5Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy5Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy5Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy5Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL5, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL5, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL5, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy5Layout.setVerticalGroup(phongQuanLy5Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy5Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL5, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL5).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy6.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy6.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy6.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy6Layout.setHorizontalGroup(phongQuanLy6Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy6Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy6Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy6Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL6, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL6, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL6, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy6Layout.setVerticalGroup(phongQuanLy6Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy6Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL6, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL6).addContainerGap(15, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
		panelRound1.setLayout(panelRound1Layout);
		panelRound1Layout
				.setHorizontalGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelRound1Layout.createSequentialGroup().addContainerGap()
								.addComponent(phongQuanLy1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		panelRound1Layout.setVerticalGroup(panelRound1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound1Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phongQuanLy6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel11.setText("Tầng 2");

		panelRound2.setBackground(new java.awt.Color(255, 255, 255));
		panelRound2.setMaximumSize(new java.awt.Dimension(918, 105));
		panelRound2.setMinimumSize(new java.awt.Dimension(918, 105));
		panelRound2.setPreferredSize(new java.awt.Dimension(918, 105));

		phongQuanLy7.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy7.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy7.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy7Layout.setHorizontalGroup(phongQuanLy7Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy7Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy7Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy7Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL7, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL7, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL7, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy7Layout.setVerticalGroup(phongQuanLy7Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy7Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL7, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL7).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy8.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy8.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy8.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy8Layout.setHorizontalGroup(phongQuanLy8Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy8Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy8Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy8Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL8, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL8, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL8, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy8Layout.setVerticalGroup(phongQuanLy8Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy8Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL8, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL8).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy9.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy9.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy9.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy9Layout.setHorizontalGroup(phongQuanLy9Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy9Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy9Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy9Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL9, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL9, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL9, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy9Layout.setVerticalGroup(phongQuanLy9Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy9Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL9, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL9).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy10.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy10.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy10.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy10Layout.setHorizontalGroup(phongQuanLy10Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy10Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy10Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy10Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL10, javax.swing.GroupLayout.DEFAULT_SIZE, 97,
										Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addComponent(checkBoxPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL10, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL10, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy10Layout.setVerticalGroup(phongQuanLy10Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy10Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL10, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL10).addContainerGap(15, Short.MAX_VALUE)));

		btnChonPhongTrongTang1.setText("Chọn phòng trống");
		btnChonPhongTrongTang1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongTrongTang1ActionPerformed(evt);
			}
		});

		btnChonPhongThueTang1.setText("Chọn phòng thuê");
		btnChonPhongThueTang1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongThueTang1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
		panelRound2.setLayout(panelRound2Layout);
		panelRound2Layout.setHorizontalGroup(panelRound2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound2Layout.createSequentialGroup().addContainerGap()
						.addComponent(phongQuanLy7, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy9, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy10, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnChonPhongTrongTang1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnChonPhongThueTang1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		panelRound2Layout.setVerticalGroup(panelRound2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound2Layout.createSequentialGroup().addContainerGap().addGroup(panelRound2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(phongQuanLy10, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(phongQuanLy9, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(phongQuanLy8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(phongQuanLy7, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
								.addComponent(btnChonPhongTrongTang1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnChonPhongThueTang1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(17, 17, 17)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel17.setText("Tầng 1");

		panelRound3.setBackground(new java.awt.Color(255, 255, 255));
		panelRound3.setMaximumSize(new java.awt.Dimension(918, 105));
		panelRound3.setMinimumSize(new java.awt.Dimension(918, 105));

		phongQuanLy11.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy11.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy11.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy11Layout.setHorizontalGroup(phongQuanLy11Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy11Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy11Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy11Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL11, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL11, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL11, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy11Layout.setVerticalGroup(phongQuanLy11Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy11Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL11, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL11).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy12.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy12.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy12.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy12Layout.setHorizontalGroup(phongQuanLy12Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy12Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy12Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy12Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL12, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL12, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy12Layout.setVerticalGroup(phongQuanLy12Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy12Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL12, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL12).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy13.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy13.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy13.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy13Layout.setHorizontalGroup(phongQuanLy13Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy13Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy13Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy13Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL13, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL13, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy13Layout.setVerticalGroup(phongQuanLy13Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy13Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL13, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL13).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy14.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy14.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy14.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy14Layout.setHorizontalGroup(phongQuanLy14Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy14Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy14Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy14Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL14, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL14, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy14Layout.setVerticalGroup(phongQuanLy14Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy14Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL14, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL14).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy15.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy15.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy15.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy15Layout.setHorizontalGroup(phongQuanLy15Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy15Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy15Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy15Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL15, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL15, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy15Layout.setVerticalGroup(phongQuanLy15Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy15Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL15, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL15).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy16.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy16.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy16.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy16Layout.setHorizontalGroup(phongQuanLy16Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy16Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy16Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy16Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL16, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL16, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL16, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy16Layout.setVerticalGroup(phongQuanLy16Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy16Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL16, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL16).addContainerGap(15, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
		panelRound3.setLayout(panelRound3Layout);
		panelRound3Layout
				.setHorizontalGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelRound3Layout.createSequentialGroup().addContainerGap()
								.addComponent(phongQuanLy11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy14, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy16, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelRound3Layout.setVerticalGroup(panelRound3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound3Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phongQuanLy16, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy15, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy14, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy13, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy12, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panelRound4.setBackground(new java.awt.Color(255, 255, 255));
		panelRound4.setMaximumSize(new java.awt.Dimension(918, 105));
		panelRound4.setMinimumSize(new java.awt.Dimension(918, 105));
		panelRound4.setPreferredSize(new java.awt.Dimension(918, 105));

		phongQuanLy17.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy17.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy17.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy17Layout.setHorizontalGroup(phongQuanLy17Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy17Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy17Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy17Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL17, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL17, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL17, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy17Layout.setVerticalGroup(phongQuanLy17Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy17Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL17, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL17).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy18.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy18.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy18.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy18Layout.setHorizontalGroup(phongQuanLy18Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy18Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy18Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy18Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL18, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL18, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL18, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy18Layout.setVerticalGroup(phongQuanLy18Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy18Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL18, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL18).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy19.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy19.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy19.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy19Layout.setHorizontalGroup(phongQuanLy19Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy19Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy19Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy19Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL19, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL19, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL19, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy19Layout.setVerticalGroup(phongQuanLy19Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy19Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL19, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL19).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy20.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy20.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy20.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy20Layout.setHorizontalGroup(phongQuanLy20Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy20Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy20Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy20Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE, 97,
										Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addComponent(checkBoxPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL20, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL20, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy20Layout.setVerticalGroup(phongQuanLy20Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy20Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL20, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL20).addContainerGap(15, Short.MAX_VALUE)));

		btnChonPhongThueTang2.setText("Chọn phòng thuê");
		btnChonPhongThueTang2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongThueTang2ActionPerformed(evt);
			}
		});

		btnChonPhongTrongTang2.setText("Chọn phòng trống");
		btnChonPhongTrongTang2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongTrongTang2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
		panelRound4.setLayout(panelRound4Layout);
		panelRound4Layout.setHorizontalGroup(panelRound4Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound4Layout.createSequentialGroup().addContainerGap()
						.addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnChonPhongTrongTang2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnChonPhongThueTang2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		panelRound4Layout.setVerticalGroup(panelRound4Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound4Layout.createSequentialGroup().addContainerGap().addGroup(panelRound4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(panelRound4Layout.createSequentialGroup().addGap(20, 20, 20)
								.addComponent(btnChonPhongTrongTang2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnChonPhongThueTang2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel18.setText("Tầng 3");

		panelRound5.setBackground(new java.awt.Color(255, 255, 255));
		panelRound5.setMaximumSize(new java.awt.Dimension(918, 105));
		panelRound5.setMinimumSize(new java.awt.Dimension(918, 105));

		phongQuanLy21.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy21.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy21.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy21Layout.setHorizontalGroup(phongQuanLy21Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy21Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy21Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy21Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL21, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL21, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy21Layout.setVerticalGroup(phongQuanLy21Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy21Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL21, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL21).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy22.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy22.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy22.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy22Layout.setHorizontalGroup(phongQuanLy22Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy22Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy22Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy22Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL22, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL22, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL22, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy22Layout.setVerticalGroup(phongQuanLy22Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy22Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL22, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL22).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy23.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy23.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy23.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy23Layout.setHorizontalGroup(phongQuanLy23Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy23Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy23Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy23Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL23, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL23, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL23, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy23Layout.setVerticalGroup(phongQuanLy23Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy23Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL23, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL23).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy24.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy24.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy24.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy24Layout.setHorizontalGroup(phongQuanLy24Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy24Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy24Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblTenPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(phongQuanLy24Layout.createSequentialGroup()
								.addGroup(phongQuanLy24Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(phongQuanLy24Layout.createSequentialGroup()
												.addComponent(lblLoaiPhongQL24, javax.swing.GroupLayout.DEFAULT_SIZE,
														94, Short.MAX_VALUE)
												.addGap(21, 21, 21).addComponent(checkBoxPhongQL24,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(lblTrangThaiQL24, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()))));
		phongQuanLy24Layout.setVerticalGroup(phongQuanLy24Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy24Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL24, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL24).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy25.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy25.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy25.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy25Layout.setHorizontalGroup(phongQuanLy25Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy25Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy25Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy25Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL25, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL25, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL25, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy25Layout.setVerticalGroup(phongQuanLy25Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy25Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL25, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL25).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy26.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy26.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy26.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy26Layout.setHorizontalGroup(phongQuanLy26Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy26Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy26Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy26Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL26, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL26, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL26, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy26Layout.setVerticalGroup(phongQuanLy26Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy26Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL26, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL26).addContainerGap(15, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
		panelRound5.setLayout(panelRound5Layout);
		panelRound5Layout
				.setHorizontalGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelRound5Layout.createSequentialGroup().addContainerGap()
								.addComponent(phongQuanLy21, javax.swing.GroupLayout.PREFERRED_SIZE, 143,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy22, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy23, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy24, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy25, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(phongQuanLy26, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelRound5Layout.setVerticalGroup(panelRound5Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound5Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phongQuanLy26, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy25, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy24, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy23, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy22, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy21, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panelRound6.setBackground(new java.awt.Color(255, 255, 255));
		panelRound6.setMaximumSize(new java.awt.Dimension(918, 105));
		panelRound6.setMinimumSize(new java.awt.Dimension(918, 105));
		panelRound6.setPreferredSize(new java.awt.Dimension(918, 105));

		phongQuanLy27.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy27.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy27.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy27Layout.setHorizontalGroup(phongQuanLy27Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy27Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy27Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy27Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL27, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL27, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL27, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy27Layout.setVerticalGroup(phongQuanLy27Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy27Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL27, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL27).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy28.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy28.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy28.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy28Layout.setHorizontalGroup(phongQuanLy28Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy28Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy28Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy28Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL28, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL28, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy28Layout.setVerticalGroup(phongQuanLy28Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy28Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL28, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL28).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy29.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy29.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy29.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy29Layout.setHorizontalGroup(phongQuanLy29Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy29Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy29Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy29Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL29, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL29, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL29, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy29Layout.setVerticalGroup(phongQuanLy29Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy29Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL29, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL29).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy30.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy30.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy30.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy30Layout.setHorizontalGroup(phongQuanLy30Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy30Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy30Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy30Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL30, javax.swing.GroupLayout.DEFAULT_SIZE, 97,
										Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addComponent(checkBoxPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL30, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL30, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy30Layout.setVerticalGroup(phongQuanLy30Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy30Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL30, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL30).addContainerGap(15, Short.MAX_VALUE)));

		btnChonPhongTrongTang3.setText("Chọn phòng trống");
		btnChonPhongTrongTang3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongTrongTang3ActionPerformed(evt);
			}
		});

		btnChonPhongThueTang3.setText("Chọn phòng thuê");
		btnChonPhongThueTang3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongThueTang3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
		panelRound6.setLayout(panelRound6Layout);
		panelRound6Layout.setHorizontalGroup(panelRound6Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound6Layout.createSequentialGroup().addContainerGap()
						.addComponent(phongQuanLy27, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy30, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnChonPhongTrongTang3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnChonPhongThueTang3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		panelRound6Layout.setVerticalGroup(panelRound6Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound6Layout.createSequentialGroup().addGroup(panelRound6Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addGroup(panelRound6Layout.createSequentialGroup().addContainerGap().addGroup(panelRound6Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phongQuanLy30, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy27, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound6Layout.createSequentialGroup()
								.addGap(24, 24, 24)
								.addComponent(btnChonPhongTrongTang3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnChonPhongThueTang3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panelRound7.setBackground(new java.awt.Color(255, 255, 255));
		panelRound7.setMaximumSize(new java.awt.Dimension(918, 105));
		panelRound7.setMinimumSize(new java.awt.Dimension(918, 105));
		panelRound7.setPreferredSize(new java.awt.Dimension(918, 105));

		phongQuanLy31.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy31.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy31.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy31Layout.setHorizontalGroup(phongQuanLy31Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy31Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy31Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy31Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL31, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL31, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy31Layout.setVerticalGroup(phongQuanLy31Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy31Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL31, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL31).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy32.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy32.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy32.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy32Layout.setHorizontalGroup(phongQuanLy32Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy32Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy32Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy32Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL32, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL32, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL32, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy32Layout.setVerticalGroup(phongQuanLy32Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy32Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL32, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL32).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy33.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy33.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy33.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy33Layout.setHorizontalGroup(phongQuanLy33Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy33Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy33Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy33Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL33, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL33, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL33, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy33Layout.setVerticalGroup(phongQuanLy33Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy33Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL33, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL33).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy34.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy34.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy34.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy34Layout.setHorizontalGroup(phongQuanLy34Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy34Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy34Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy34Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL34, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL34, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL34, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy34Layout.setVerticalGroup(phongQuanLy34Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy34Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL34, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL34).addContainerGap(15, Short.MAX_VALUE)));

		phongQuanLy35.setBackground(new java.awt.Color(255, 204, 255));
		phongQuanLy35.setMaximumSize(new java.awt.Dimension(146, 93));
		phongQuanLy35.setMinimumSize(new java.awt.Dimension(146, 93));
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
		phongQuanLy35Layout.setHorizontalGroup(phongQuanLy35Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy35Layout.createSequentialGroup().addContainerGap().addGroup(phongQuanLy35Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(phongQuanLy35Layout.createSequentialGroup()
								.addComponent(lblLoaiPhongQL35, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE)
								.addGap(27, 27, 27)
								.addComponent(checkBoxPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongQL35, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangThaiQL35, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap()));
		phongQuanLy35Layout.setVerticalGroup(phongQuanLy35Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(phongQuanLy35Layout.createSequentialGroup().addContainerGap()
						.addGroup(phongQuanLy35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTenPhongQL35, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblTrangThaiQL35).addContainerGap(15, Short.MAX_VALUE)));

		btnChonPhongThueTang4.setText("Chọn phòng thuê");
		btnChonPhongThueTang4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongThueTang4ActionPerformed(evt);
			}
		});

		btnChonPhongTrongTang4.setText("Chọn phòng trống");
		btnChonPhongTrongTang4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonPhongTrongTang4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
		panelRound7.setLayout(panelRound7Layout);
		panelRound7Layout.setHorizontalGroup(panelRound7Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound7Layout.createSequentialGroup().addContainerGap()
						.addComponent(phongQuanLy31, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy32, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy33, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy34, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phongQuanLy35, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnChonPhongTrongTang4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnChonPhongThueTang4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		panelRound7Layout.setVerticalGroup(panelRound7Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound7Layout.createSequentialGroup().addContainerGap().addGroup(panelRound7Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(panelRound7Layout.createSequentialGroup()
								.addComponent(btnChonPhongTrongTang4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnChonPhongThueTang4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18))
						.addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phongQuanLy35, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy34, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy33, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy32, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phongQuanLy31, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel21.setText("Tầng 4");

		javax.swing.GroupLayout pnBody2Layout = new javax.swing.GroupLayout(pnBody2);
		pnBody2.setLayout(pnBody2Layout);
		pnBody2Layout.setHorizontalGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnBody2Layout.createSequentialGroup().addGap(95, 95, 95)
						.addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel11)
								.addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel18).addComponent(jLabel21).addComponent(jLabel17)
								.addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(126, Short.MAX_VALUE)));
		pnBody2Layout.setVerticalGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnBody2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel17)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel11)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel18)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel21)
						.addGap(7, 7, 7)
						.addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(215, Short.MAX_VALUE)));

		scrollPaneWin112.setViewportView(pnBody2);

		javax.swing.GroupLayout pnLayoutQLLayout = new javax.swing.GroupLayout(pnLayoutQL);
		pnLayoutQL.setLayout(pnLayoutQLLayout);
		pnLayoutQLLayout
				.setHorizontalGroup(
						pnLayoutQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnLayoutQLLayout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE,
														1138, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap()));
		pnLayoutQLLayout.setVerticalGroup(pnLayoutQLLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnLayoutQLLayout.createSequentialGroup()
						.addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
						.addContainerGap()));

		panelRound8.setBackground(new java.awt.Color(204, 255, 255));
		panelRound8.setRoundBottomLeft(10);
		panelRound8.setRoundBottomRight(10);
		panelRound8.setRoundTopLeft(10);
		panelRound8.setRoundTopRight(10);

		jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jLabel5.setText("Chú thích : Trạng thái phòng");

		jPanel7.setBackground(java.awt.Color.green);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));

		jPanel10.setBackground(java.awt.Color.yellow);

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE));

		jPanel11.setBackground(java.awt.Color.red);

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 65, Short.MAX_VALUE));
		jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE));

		jLabel6.setText("Phòng đang trống");

		jLabel7.setText("Phòng đã được đặt");

		jLabel8.setText("Phòng đang cho thuê");

		javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
		panelRound8.setLayout(panelRound8Layout);
		panelRound8Layout.setHorizontalGroup(panelRound8Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound8Layout.createSequentialGroup().addGap(204, 204, 204).addGroup(panelRound8Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5)
						.addGroup(panelRound8Layout.createSequentialGroup()
								.addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(65, 65, 65)
								.addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(58, 58, 58)
								.addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelRound8Layout.setVerticalGroup(panelRound8Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound8Layout.createSequentialGroup().addContainerGap().addGroup(panelRound8Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(panelRound8Layout.createSequentialGroup().addComponent(jLabel5)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelRound8Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)))
						.addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(11, Short.MAX_VALUE)));

		javax.swing.GroupLayout pnLayoutQuanLyPhongLayout = new javax.swing.GroupLayout(pnLayoutQuanLyPhong);
		pnLayoutQuanLyPhong.setLayout(pnLayoutQuanLyPhongLayout);
		pnLayoutQuanLyPhongLayout.setHorizontalGroup(pnLayoutQuanLyPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnLayoutQuanLyPhongLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnLayoutQuanLyPhongLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnLayoutQuanLyPhongLayout.createSequentialGroup()
										.addComponent(pnLayoutQL, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(funtionPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		pnLayoutQuanLyPhongLayout.setVerticalGroup(
				pnLayoutQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						pnLayoutQuanLyPhongLayout.createSequentialGroup().addContainerGap()
								.addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnLayoutQL, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout pnQuanLyPhongLayout = new javax.swing.GroupLayout(pnQuanLyPhong);
		pnQuanLyPhong.setLayout(pnQuanLyPhongLayout);
		pnQuanLyPhongLayout
				.setHorizontalGroup(pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnQuanLyPhongLayout.createSequentialGroup().addContainerGap()
								.addComponent(pnLayoutQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnQuanLyPhongLayout
				.setVerticalGroup(
						pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnQuanLyPhongLayout.createSequentialGroup().addContainerGap()
										.addComponent(pnLayoutQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 709,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(50, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 1201, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(pnQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 765, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(pnQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
	}// </editor-fold>//GEN-END:initComponents

	private void btnNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNhanPhongActionPerformed
		NhanPhong_GUI nhanPhongDiaLog = new NhanPhong_GUI();
		nhanPhongDiaLog.setVisible(true);
	}// GEN-LAST:event_btnNhanPhongActionPerformed

	private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemDichVuActionPerformed
		// TODO add your handling code here:
		JCheckBox cks;
		JLabel tenPhong;
		String tenphongDoi = "";
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			tenPhong = tenPhongQuanLy.get(i);
			if (cks.isSelected()) {
				tenphongDoi = tenPhong.getText();

			}
		}

		ThemDichVuPhong_GUI thuePhongFrame = new ThemDichVuPhong_GUI(tenphongDoi);
		thuePhongFrame.setVisible(true);
		// reset checkbox
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			if (cks.isSelected()) {
				cks.setSelected(false);
			}
		}

	}// GEN-LAST:event_btnThemDichVuActionPerformed

	private void btnTimTheoDieuKienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFindbyPhoneActionPerformed
		loadDanhSachPhong();
		if (radPhongTieuChuan.isSelected()) {
			for (int i = 0; i < loaiPhongQuanLy.size(); i++) {
				JPanel p = phongQuanLy.get(i);
				JLabel loaiP = loaiPhongQuanLy.get(i);
				if (!loaiP.getText().equalsIgnoreCase("Tiêu chuẩn")) {
					p.setVisible(false);
				}
			}
		}
		if (radPhongNangCao.isSelected()) {
			for (int i = 0; i < phongQuanLy.size(); i++) {
				JPanel p = phongQuanLy.get(i);
				JLabel loaiP = loaiPhongQuanLy.get(i);
				if (!loaiP.getText().equalsIgnoreCase("Nâng cao")) {
					p.setVisible(false);
				}
			}
		} else if (radPhongCaoCap.isSelected()) {
			for (int i = 0; i < phongQuanLy.size(); i++) {
				JPanel p = phongQuanLy.get(i);
				JLabel loaiP = loaiPhongQuanLy.get(i);

				if (!loaiP.getText().equalsIgnoreCase("Cao cấp")) {
					p.setVisible(false);
				}
			}
		} else if (radPhongThuongGia.isSelected()) {
			for (int i = 0; i < phongQuanLy.size(); i++) {
				JPanel p = phongQuanLy.get(i);
				JLabel loaiP = loaiPhongQuanLy.get(i);

				if (!loaiP.getText().equalsIgnoreCase("Thương gia")) {
					p.setVisible(false);
				}
			}
		}

		if (radPhongTrong.isSelected()) {
			for (int i = 0; i < phongQuanLy.size(); i++) {
				JPanel p = phongQuanLy.get(i);
				JLabel trangThaiP = trangThaiPhongQuanLy.get(i);

				if (!trangThaiP.getText().equalsIgnoreCase("Trống")) {
					p.setVisible(false);
				}
			}
		} else if (radPhongDaDat.isSelected()) {
			for (int i = 0; i < phongQuanLy.size(); i++) {
				JPanel p = phongQuanLy.get(i);
				JLabel trangThaiP = trangThaiPhongQuanLy.get(i);

				if (!trangThaiP.getText().equalsIgnoreCase("Đã đặt")) {
					p.setVisible(false);
				}
			}
		} else if (radPhongDangThue.isSelected()) {
			for (int i = 0; i < phongQuanLy.size(); i++) {
				JPanel p = phongQuanLy.get(i);
				JLabel trangThaiP = trangThaiPhongQuanLy.get(i);

			}
		}
	}

/////// oidoioi
	private void btnHuyDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyDatPhongActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnHuyDatPhongActionPerformed

	private void btnDoiPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDoiPhongActionPerformed
		// TODO add your handling code here:
		JCheckBox cks;
		JLabel tenPhong;
		String tenphongDoi = "";
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			tenPhong = tenPhongQuanLy.get(i);
			if (cks.isSelected()) {
				tenphongDoi = tenPhong.getText();

			}
		}

		DoiPhongDangThue_GUI thuePhongFrame = new DoiPhongDangThue_GUI(tenphongDoi);
		thuePhongFrame.setVisible(true);
		// reset checkbox
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			if (cks.isSelected()) {
				cks.setSelected(false);
			}
		}

	}
	// GEN-LAST:event_btnDoiPhongActionPerformed
//=======

	// GEN-LAST:event_btnFindbyPhoneActionPerformed

	private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDatPhongActionPerformed
		List<String> dsTenPhong = new ArrayList<>();
		JCheckBox cks;
		JLabel tenPhong;
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			tenPhong = tenPhongQuanLy.get(i);
			if (cks.isSelected()) {
				dsTenPhong.add(tenPhong.getText());
			}
		}

		if (dsTenPhong.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
//>>>>>>> b01a81a34a4f8c5b67c852476876f4be707bd397:PTUD_QuanLyKhachSan/src/giaodien/QuanLyPhong_GUI.java

		DatPhong_GUI datPhongFrame = new DatPhong_GUI(dsTenPhong);
		datPhongFrame.setVisible(true);
		// reset checkbox
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			if (cks.isSelected()) {
				cks.setSelected(false);
			}
		}

	}

//    private void btnHuyDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyDatPhongActionPerformed
//        new HuyDatPhong_GUI().setVisible(true);
//    }// GEN-LAST:event_btnHuyDatPhongActionPerformed
//
//    private void btnDoiPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDoiPhongActionPerformed
//
//    }// GEN-LAST:event_btnDoiPhongActionPerformed

	private void btnTraPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraPhongActionPerformed
		// Lưu thông tin phòng đã chọn
		List<String> dsTenPhong = new ArrayList<>();
		for (int i = 0; i < phongQuanLy.size(); i++) {
			JCheckBox cks = checkBoxPhongQuanLy.get(i);
			JLabel tenPhong = tenPhongQuanLy.get(i);
			if (cks.isSelected()) {
				dsTenPhong.add(tenPhong.getText());
			}
		}
		if (dsTenPhong.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		TraPhong_GUI traPhongFrame = new TraPhong_GUI(dsTenPhong, nv);

		traPhongFrame.setVisible(true);
		// reset checkbox
		for (int i = 0; i < phongQuanLy.size(); i++) {
			JCheckBox cks = checkBoxPhongQuanLy.get(i);
			if (cks.isSelected()) {
				cks.setSelected(false);
			}
		}

	}// GEN-LAST:event_btnTraPhongActionPerformed

	private void btnThuePhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThuePhongActionPerformed
		List<String> dsTenPhong = new ArrayList<>();
		JCheckBox cks;
		JLabel tenPhong;
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			tenPhong = tenPhongQuanLy.get(i);
			if (cks.isSelected()) {
				dsTenPhong.add(tenPhong.getText());
			}
		}

		if (dsTenPhong.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		ThuePhong_GUI thuePhongFrame = new ThuePhong_GUI(dsTenPhong);
		thuePhongFrame.setVisible(true);
		// reset checkbox
		for (int i = 0; i < phongQuanLy.size(); i++) {
			cks = checkBoxPhongQuanLy.get(i);
			if (cks.isSelected()) {
				cks.setSelected(false);
			}
		}
	}// GEN-LAST:event_btnThuePhongActionPerformed

	private void btnResetTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetTrangThaiActionPerformed
		// TODO add your handling code here:
		loadDanhSachPhong();
		radPhongTieuChuan.setSelected(false);
		radPhongNangCao.setSelected(false);
		radPhongCaoCap.setSelected(false);
		radPhongTrong.setSelected(false);
		radPhongDangThue.setSelected(false);
		radPhongDaDat.setSelected(false);
		for (int i = 0; i < checkBoxPhongQuanLy.size(); i++) {
			checkBoxPhongQuanLy.get(i).setSelected(false);
		}

	}// GEN-LAST:event_btnResetTrangThaiActionPerformed

	private void btnChonPhongTrongTang1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongTrongTang1ActionPerformed
		for (int i = 0; i < 10; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Trống")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongTrongTang1ActionPerformed

	private void btnChonPhongThueTang1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongThueTang1ActionPerformed
		for (int i = 0; i < 10; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Đã thuê")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongThueTang1ActionPerformed

	private void btnChonPhongThueTang2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongThueTang2ActionPerformed
		for (int i = 10; i < 20; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Đã thuê")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongThueTang2ActionPerformed

	private void btnChonPhongTrongTang2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongTrongTang2ActionPerformed
		for (int i = 10; i < 20; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Trống")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongTrongTang2ActionPerformed

	private void btnChonPhongTrongTang3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongTrongTang3ActionPerformed
		for (int i = 20; i < 30; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Trống")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongTrongTang3ActionPerformed

	private void btnChonPhongThueTang3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongThueTang3ActionPerformed
		for (int i = 20; i < 30; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Đã thuê")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongThueTang3ActionPerformed

	private void btnChonPhongThueTang4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongThueTang4ActionPerformed
		for (int i = 30; i < 35; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Đã thuê")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongThueTang4ActionPerformed

	private void btnChonPhongTrongTang4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonPhongTrongTang4ActionPerformed
		for (int i = 30; i < 35; i++) {
			JLabel trangThai = trangThaiPhongQuanLy.get(i);
			if (trangThai.getText().equalsIgnoreCase("Trống")) {
				checkBoxPhongQuanLy.get(i).setSelected(true);
			}
		}
	}// GEN-LAST:event_btnChonPhongTrongTang4ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private giaodien.CustomClass.Button btnChonPhongThueTang1;
	private giaodien.CustomClass.Button btnChonPhongThueTang2;
	private giaodien.CustomClass.Button btnChonPhongThueTang3;
	private giaodien.CustomClass.Button btnChonPhongThueTang4;
	private giaodien.CustomClass.Button btnChonPhongTrongTang1;
	private giaodien.CustomClass.Button btnChonPhongTrongTang2;
	private giaodien.CustomClass.Button btnChonPhongTrongTang3;
	private giaodien.CustomClass.Button btnChonPhongTrongTang4;
	private giaodien.CustomClass.Button btnDatPhong;
	private giaodien.CustomClass.Button btnDoiPhong;
	private javax.swing.ButtonGroup btnGroupLoaiPhong;
	private javax.swing.ButtonGroup btnGroupTrangThai;
	private giaodien.CustomClass.Button btnHuyDatPhong;
	private giaodien.CustomClass.Button btnNhanPhong;
	private giaodien.CustomClass.Button btnResetTrangThai;
	private giaodien.CustomClass.Button btnThemDichVu;
	private giaodien.CustomClass.Button btnThuePhong;
	private giaodien.CustomClass.Button btnTimTheoDieuKien;
	private giaodien.CustomClass.Button btnTraPhong;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL1;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL10;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL11;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL12;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL13;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL14;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL15;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL16;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL17;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL18;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL19;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL2;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL20;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL21;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL22;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL23;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL24;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL25;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL26;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL27;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL28;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL29;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL3;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL30;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL31;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL32;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL33;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL34;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL35;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL4;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL5;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL6;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL7;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL8;
	private giaodien.CustomClass.JCheckBoxCustom checkBoxPhongQL9;
	private javax.swing.JPanel funtionPanel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel7;
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
	private giaodien.CustomClass.PanelRound panelRound1;
	private giaodien.CustomClass.PanelRound panelRound2;
	private giaodien.CustomClass.PanelRound panelRound3;
	private giaodien.CustomClass.PanelRound panelRound4;
	private giaodien.CustomClass.PanelRound panelRound5;
	private giaodien.CustomClass.PanelRound panelRound6;
	private giaodien.CustomClass.PanelRound panelRound7;
	private giaodien.CustomClass.PanelRound panelRound8;
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
	private javax.swing.JPanel pnBody2;
	private giaodien.CustomClass.PanelRound pnLayoutQL;
	private giaodien.CustomClass.PanelRound pnLayoutQuanLyPhong;
	private javax.swing.JPanel pnQuanLyPhong;
	private javax.swing.JRadioButton radPhongCaoCap;
	private javax.swing.JRadioButton radPhongDaDat;
	private javax.swing.JRadioButton radPhongDangThue;
	private javax.swing.JRadioButton radPhongNangCao;
	private javax.swing.JRadioButton radPhongThuongGia;
	private javax.swing.JRadioButton radPhongTieuChuan;
	private javax.swing.JRadioButton radPhongTrong;
	private giaodien.CustomClass.ScrollPaneWin11 scrollPaneWin112;
	private ArrayList<javax.swing.JPanel> phongQuanLy;
	private ArrayList<javax.swing.JLabel> loaiPhongQuanLy;
	private ArrayList<javax.swing.JLabel> tenPhongQuanLy;
	private ArrayList<javax.swing.JLabel> trangThaiPhongQuanLy;
	private ArrayList<giaodien.CustomClass.JCheckBoxCustom> checkBoxPhongQuanLy;
	// End of variables declaration//GEN-END:variables
}
