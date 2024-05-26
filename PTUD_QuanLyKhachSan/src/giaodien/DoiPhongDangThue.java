
package giaodien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.DichVuPhongDao;
import dao.KhachHangDao;
import dao.LoaiPhongDao;
import dao.LoaiThueDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.Phong;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Huynguyen
 */
public class DoiPhongDangThue extends javax.swing.JDialog {

	private List<DichVuPhong> danhSachDichVu;
	private String[] dsPhongDat;
	List<String> dsTenPhong;
        String maPhongDoi;

	/**
	 * Creates new form DatPhong
	 */
	public DoiPhongDangThue() {
		ConnectDB.getInstance().getConnection();
		initComponents();
	}

	public DoiPhongDangThue(List<String> dsTenPhong) {
		dsPhongDat = new String[dsTenPhong.size()];
		int index = 0;
		for (String tenPhong : dsTenPhong) {
			dsPhongDat[index++] = tenPhong;
		}
		ConnectDB.getInstance().getConnection();
		initComponents();
	}
        
        public DoiPhongDangThue(String maPhongDoi) {
		this.maPhongDoi = maPhongDoi;
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateNgaySinh = new giaodien.CustomClass.DateChooser();
        dateNgayDat = new giaodien.CustomClass.DateChooser();
        dateNgayTra = new giaodien.CustomClass.DateChooser();
        dateNgayNhan = new giaodien.CustomClass.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new giaodien.CustomClass.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTenPhongHienTai = new giaodien.CustomClass.TextFieldShadow();
        txtSoDienThoaiKhachHang = new giaodien.CustomClass.TextFieldShadow();
        txtMaKhachHang = new giaodien.CustomClass.TextFieldShadow();
        txtTenKhachHang = new giaodien.CustomClass.TextFieldShadow();
        jLabel4 = new javax.swing.JLabel();
        pnLayoutQL = new giaodien.CustomClass.PanelRound();
        scrollPaneWin112 = new giaodien.CustomClass.ScrollPaneWin11();
        pnBody2 = new javax.swing.JPanel();
        panelRound3 = new giaodien.CustomClass.PanelRound();
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
        jLabel20 = new javax.swing.JLabel();
        panelRound4 = new giaodien.CustomClass.PanelRound();
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
        panelRound5 = new giaodien.CustomClass.PanelRound();
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
        jLabel22 = new javax.swing.JLabel();
        panelRound6 = new giaodien.CustomClass.PanelRound();
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
        panelRound7 = new giaodien.CustomClass.PanelRound();
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
        panelRound8 = new giaodien.CustomClass.PanelRound();
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
        jLabel23 = new javax.swing.JLabel();
        button1 = new giaodien.CustomClass.Button();
        button2 = new giaodien.CustomClass.Button();
        panelRound9 = new giaodien.CustomClass.PanelRound();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTenPhongHienTai1 = new giaodien.CustomClass.TextFieldShadow();
        txtSoDienThoaiKhachHang1 = new giaodien.CustomClass.TextFieldShadow();
        txtMaKhachHang1 = new giaodien.CustomClass.TextFieldShadow();
        txtTenKhachHang1 = new giaodien.CustomClass.TextFieldShadow();
        jLabel2 = new javax.swing.JLabel();

        dateNgaySinh.setForeground(new java.awt.Color(255, 203, 119));

        dateNgayDat.setForeground(new java.awt.Color(255, 203, 119));

        dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));

        dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Đổi phòng đang thuê");

        panelRound1.setPreferredSize(new java.awt.Dimension(1047, 238));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

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

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenPhongHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenPhongHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Thông tin phòng đang thuê");

        pnLayoutQL.setPreferredSize(new java.awt.Dimension(1080, 326));

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

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
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
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(310, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Tầng 1");

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

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
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
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Tầng 3");

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

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
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
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phongQuanLy27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phongQuanLy30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
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
                .addContainerGap(155, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phongQuanLy35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongQuanLy31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Tầng 4");

        javax.swing.GroupLayout pnBody2Layout = new javax.swing.GroupLayout(pnBody2);
        pnBody2.setLayout(pnBody2Layout);
        pnBody2Layout.setHorizontalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel20)
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnBody2Layout.setVerticalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(7, 7, 7)
                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        scrollPaneWin112.setViewportView(pnBody2);

        javax.swing.GroupLayout pnLayoutQLLayout = new javax.swing.GroupLayout(pnLayoutQL);
        pnLayoutQL.setLayout(pnLayoutQLLayout);
        pnLayoutQLLayout.setHorizontalGroup(
            pnLayoutQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLayoutQLLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnLayoutQLLayout.setVerticalGroup(
            pnLayoutQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayoutQLLayout.createSequentialGroup()
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        button1.setText("Đổi phòng");

        button2.setText("Hủy");

        panelRound9.setPreferredSize(new java.awt.Dimension(1047, 238));
        panelRound9.setRoundBottomLeft(20);
        panelRound9.setRoundBottomRight(20);
        panelRound9.setRoundTopLeft(20);
        panelRound9.setRoundTopRight(20);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Mã phòng đổi");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Mã khách hàng");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Ghi chú");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Số điện thoại");

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenPhongHienTai1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoaiKhachHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound9Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKhachHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenPhongHienTai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoaiKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thông tin phòng sau khi đổi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnLayoutQL, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnLayoutQL, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
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
			java.util.logging.Logger.getLogger(DoiPhongDangThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DoiPhongDangThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DoiPhongDangThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DoiPhongDangThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				List<String> args = new ArrayList<String>();
				args.add("101");
				args.add("102");
				args.add("103");
				DoiPhongDangThue guiDatPhong = new DoiPhongDangThue(args);
				guiDatPhong.setVisible(true);
				guiDatPhong.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button button1;
    private giaodien.CustomClass.Button button2;
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
    private giaodien.CustomClass.DateChooser dateNgayDat;
    private giaodien.CustomClass.DateChooser dateNgayNhan;
    private giaodien.CustomClass.DateChooser dateNgaySinh;
    private giaodien.CustomClass.DateChooser dateNgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
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
    private giaodien.CustomClass.PanelRound panelRound1;
    private giaodien.CustomClass.PanelRound panelRound2;
    private giaodien.CustomClass.PanelRound panelRound3;
    private giaodien.CustomClass.PanelRound panelRound4;
    private giaodien.CustomClass.PanelRound panelRound5;
    private giaodien.CustomClass.PanelRound panelRound6;
    private giaodien.CustomClass.PanelRound panelRound7;
    private giaodien.CustomClass.PanelRound panelRound8;
    private giaodien.CustomClass.PanelRound panelRound9;
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
    private giaodien.CustomClass.ScrollPaneWin11 scrollPaneWin112;
    private giaodien.CustomClass.TextFieldShadow txtMaKhachHang;
    private giaodien.CustomClass.TextFieldShadow txtMaKhachHang1;
    private giaodien.CustomClass.TextFieldShadow txtSoDienThoaiKhachHang;
    private giaodien.CustomClass.TextFieldShadow txtSoDienThoaiKhachHang1;
    private giaodien.CustomClass.TextFieldShadow txtTenKhachHang;
    private giaodien.CustomClass.TextFieldShadow txtTenKhachHang1;
    private giaodien.CustomClass.TextFieldShadow txtTenPhongHienTai;
    private giaodien.CustomClass.TextFieldShadow txtTenPhongHienTai1;
    // End of variables declaration//GEN-END:variables

	private static String[] loadDanhSachDichVu() {
		DichVuDao dvDao = new DichVuDao();
		ArrayList<DichVu> danhSachDV = dvDao.timTatCaDichVu();
		String[] tenDV = new String[danhSachDV.size()];
		for (int i = 0; i < danhSachDV.size(); i++) {
			tenDV[i] = String.format("%s %s", danhSachDV.get(i).getMaDV(), danhSachDV.get(i).getTenDV());
		}
		return tenDV;
	}
}
