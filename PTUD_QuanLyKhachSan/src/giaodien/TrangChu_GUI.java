package giaodien;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import connectDB.ConnectDB;
import dao.NhanVienDao;
import dao.PhongDao;
import entity.NhanVien;
import entity.Phong;

import javax.swing.JFrame;
import menu.MenuEvent;

/**
 * @author Huynguyen
 */
public class TrangChu_GUI extends javax.swing.JFrame {

	private NhanVien nhanVien;
	private NhanVienDao nhanVienDao;
	private ArrayList<giaodien.CustomClass.PanelRound> phongTrangChu;
	private ArrayList<javax.swing.JLabel> loaiPhongTrangChu;
	private ArrayList<javax.swing.JLabel> tenPhongTrangChu;
	private ArrayList<javax.swing.JLabel> trangThaiPhongTrangChu;

	public TrangChu_GUI(String tenDangNhap) throws Exception {
		nhanVienDao = new NhanVienDao();
		nhanVien = nhanVienDao.timTheoTenDangNhap(tenDangNhap);
		ConnectDB.getInstance().getConnection();
		setResizable(false);
		initComponents();
		phongTrangChu = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				phongTrangChu.add(
						(giaodien.CustomClass.PanelRound) getClass().getDeclaredField("phongTrangChu" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		tenPhongTrangChu = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				tenPhongTrangChu.add((JLabel) getClass().getDeclaredField("lblTenPhongTrangChu" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		loaiPhongTrangChu = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				loaiPhongTrangChu.add((JLabel) getClass().getDeclaredField("lblLoaiPhongTrangChu" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		trangThaiPhongTrangChu = new ArrayList<>();
		for (int i = 1; i <= 35; i++) {
			try {
				trangThaiPhongTrangChu.add((JLabel) getClass().getDeclaredField("lblTrangThaiTrangChu" + i).get(this));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		revalidate();
		repaint();

		loadDanhSachPhong();
		pnedUngDung.addTab("Quản lý phòng", new QuanLyPhong_GUI(nhanVien));
		pnedUngDung.addTab("Quản lý nhân viên", new DanhSachNhanVien_GUI());
		pnedUngDung.addTab("Quản lý dịch vụ", new DichVu_GUI());
		pnedUngDung.addTab("Quản lý khuyến mãi", new KhuyenMai_GUI());
		pnedUngDung.addTab("Quản lý khách hàng", new KhachHang_GUI());
		pnedUngDung.addTab("Quản lý hóa đơn", new DanhSachHoaDon_GUI());
		pnedUngDung.addTab("Quản lý thống kê", new ThongKe_GUI());
		pnedUngDung.addTab("Quản lý phòng thuê", new QuanLyPhongThue_GUI());

		Menu.setEvent(new MenuEvent() {
			@Override
			public void selected(int index, int subIndex) {
				if (index == 8) {
					System.exit(0);

				}
				if (index == 0) {
					pnedUngDung.setSelectedIndex(0);
				}

				if (index == 1) {
					if (subIndex == 1) {
						pnedUngDung.setSelectedIndex(1);
					}
					if (subIndex == 2) {
						pnedUngDung.setSelectedIndex(8);
					}
				}
				if (index == 2) {
					pnedUngDung.setSelectedIndex(2);
				}
				if (index == 3) {
					pnedUngDung.setSelectedIndex(3);
				}
				if (index == 4) {
					pnedUngDung.setSelectedIndex(4);
				}
				if (index == 5) {
					pnedUngDung.setSelectedIndex(5);
				}
				if (index == 6) {
					pnedUngDung.setSelectedIndex(6);
				}
				if (index == 7) {
					pnedUngDung.setSelectedIndex(7);
				} 

			}

		});
	}

	;

	private void loadDanhSachPhong() {
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = phongDao.timTatCaPhongSapXepTheoSoPhong();
		for (int i = 0; i < phongTrangChu.size(); i++) {
			Phong phong = dsPhong.get(i);
			JPanel phongPanel = phongTrangChu.get(i);
			JLabel loaiPhong = loaiPhongTrangChu.get(i);
			JLabel soPhong = tenPhongTrangChu.get(i);
			JLabel trangThai = trangThaiPhongTrangChu.get(i);

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
				phongPanel.show();
			}
		}
	}

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
        scrollPaneWin112 = new giaodien.CustomClass.ScrollPaneWin11();
        pnMenu = new javax.swing.JPanel();
        Menu = new menu.Menu();
        pnHeader = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTenNhanVien = new javax.swing.JLabel();
        pnedUngDung = new javax.swing.JTabbedPane();
        pnTrangChu = new javax.swing.JPanel();
        pnLayoutSrool = new giaodien.CustomClass.PanelRound();
        scrollPaneWin111 = new giaodien.CustomClass.ScrollPaneWin11();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelRound1 = new giaodien.CustomClass.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMenu.setPreferredSize(new java.awt.Dimension(240, 800));

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrollPaneWin112.setViewportView(pnMenu);

        jPanel1.add(scrollPaneWin112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 780));

        pnHeader.setBackground(new java.awt.Color(34, 124, 157));
        pnHeader.setPreferredSize(new java.awt.Dimension(1553, 80));

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-log-out-32.png"))); // NOI18N
        btnLogOut.setPreferredSize(new java.awt.Dimension(36, 36));
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(34, 124, 157));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenNhanVien.setText(nhanVien.getHoTenNV()
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addContainerGap(1171, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(pnHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, -1));

        pnedUngDung.setBackground(new java.awt.Color(255, 153, 102));

        pnLayoutSrool.setForeground(new java.awt.Color(242, 242, 242));

        pnBody1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trang chủ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phongTrangChu1.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu1.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu1.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu1.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu1Layout.setVerticalGroup(
            phongTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu2.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu2.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu2.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu2.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu2Layout.setVerticalGroup(
            phongTrangChu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu3.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu3.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu3.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu3.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu3Layout.setVerticalGroup(
            phongTrangChu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu4.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu4.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu4.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu4.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu4Layout.setVerticalGroup(
            phongTrangChu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu4)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu5.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu5.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu5.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu5.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu5Layout.setVerticalGroup(
            phongTrangChu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu6.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu6.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu6.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu6.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu6Layout.setVerticalGroup(
            phongTrangChu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu6)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu7.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu7.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu7.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu7.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu7Layout.setVerticalGroup(
            phongTrangChu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu7)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu8.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu8.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu8.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu8.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu8Layout.setVerticalGroup(
            phongTrangChu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu8)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu9.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu9.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu9.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu9.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu9Layout.setVerticalGroup(
            phongTrangChu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu9)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu10.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu10.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu10.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu10.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu10Layout.setVerticalGroup(
            phongTrangChu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu10)
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addGap(33, 33, 33)
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

        phongTrangChu11.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu11.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu11.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu11.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu11Layout.setVerticalGroup(
            phongTrangChu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu11)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu12.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu12.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu12.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu12.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu12Layout.setVerticalGroup(
            phongTrangChu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu12)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu13.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu13.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu13.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu13.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu13Layout.setVerticalGroup(
            phongTrangChu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu13)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu14.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu14.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu14.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu14.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu14Layout.setVerticalGroup(
            phongTrangChu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu14)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu15.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu15.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu15.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu15.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu15Layout.setVerticalGroup(
            phongTrangChu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu15)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu16.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu16.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu16.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu16.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu16Layout.setVerticalGroup(
            phongTrangChu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu16)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu17.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu17.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu17.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu17.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu17Layout.setVerticalGroup(
            phongTrangChu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu17)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu18.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu18.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu18.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu18.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu18Layout.setVerticalGroup(
            phongTrangChu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu18)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu19.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu19.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu19.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu19.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu19Layout.setVerticalGroup(
            phongTrangChu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu19)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu20.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu20.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu20.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu20.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu20Layout.setVerticalGroup(
            phongTrangChu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu20)
                .addContainerGap(18, Short.MAX_VALUE))
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

        phongTrangChu21.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu21.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu21.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu21.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu21Layout.setVerticalGroup(
            phongTrangChu21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu21)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu22.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu22.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu22.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu22.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu22Layout.setVerticalGroup(
            phongTrangChu22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu22)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu23.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu23.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu23.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu23.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu23Layout.setVerticalGroup(
            phongTrangChu23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu23)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu24.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu24.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu24.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu24.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu24Layout.setVerticalGroup(
            phongTrangChu24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu24)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu25.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu25.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu25.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu25.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu25Layout.setVerticalGroup(
            phongTrangChu25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu25)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu26.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu26.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu26.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu26.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu26Layout.setVerticalGroup(
            phongTrangChu26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu26)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu27.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu27.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu27.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu27.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu27Layout.setVerticalGroup(
            phongTrangChu27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu27)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu28.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu28.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu28.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu28.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu28Layout.setVerticalGroup(
            phongTrangChu28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu28)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu29.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu29.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu29.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu29.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu29Layout.setVerticalGroup(
            phongTrangChu29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu29)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu30.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu30.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu30.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu30.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu30Layout.setVerticalGroup(
            phongTrangChu30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu30)
                .addContainerGap(18, Short.MAX_VALUE))
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

        phongTrangChu31.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu31.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu31.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu31.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu31Layout.setVerticalGroup(
            phongTrangChu31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu31)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu32.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu32.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu32.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu32.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu32Layout.setVerticalGroup(
            phongTrangChu32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu32)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu33.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu33.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu33.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu33.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu33Layout.setVerticalGroup(
            phongTrangChu33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu33)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu34.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu34.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu34.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu34.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu34Layout.setVerticalGroup(
            phongTrangChu34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu34)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        phongTrangChu35.setBackground(new java.awt.Color(204, 204, 255));
        phongTrangChu35.setMaximumSize(new java.awt.Dimension(146, 93));
        phongTrangChu35.setMinimumSize(new java.awt.Dimension(146, 93));
        phongTrangChu35.setPreferredSize(new java.awt.Dimension(146, 93));
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
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(lblTenPhongTrangChu35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiTrangChu35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phongTrangChu35Layout.setVerticalGroup(
            phongTrangChu35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phongTrangChu35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhongTrangChu35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenPhongTrangChu35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiTrangChu35)
                .addContainerGap(18, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tầng 1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tầng 4");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tầng 2");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tầng 3");

        panelRound1.setBackground(new java.awt.Color(204, 255, 255));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Chú thích : Trạng thái phòng");

        jPanel7.setBackground(java.awt.Color.green);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.setBackground(java.awt.Color.yellow);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPanel11.setBackground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jLabel6.setText("Phòng đang trống");

        jLabel7.setText("Phòng đã được đặt");

        jLabel8.setText("Phòng đang cho thuê");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnBody1Layout = new javax.swing.GroupLayout(pnBody1);
        pnBody1.setLayout(pnBody1Layout);
        pnBody1Layout.setHorizontalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tang1_TrangChu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang1_TrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang1_TrangChu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnBody1Layout.setVerticalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1_TrangChu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(Tang1_TrangChu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLayoutSroolLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnLayoutSroolLayout.setVerticalGroup(
            pnLayoutSroolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayoutSroolLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayoutSrool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayoutSrool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab1", pnTrangChu);

        jPanel1.add(pnedUngDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 1250, 800));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {
		int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		if (choice == JOptionPane.YES_OPTION) {
			try {
				// Mở cửa sổ đăng nhập
				dispose(); // Đóng cửa sổ hiện tại
				DangNhap_GUI dangNhapGui = new DangNhap_GUI();
				dangNhapGui.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.Menu Menu;
    private javax.swing.JPanel Tang1_TrangChu;
    private javax.swing.JPanel Tang1_TrangChu1;
    private javax.swing.JPanel Tang1_TrangChu2;
    private javax.swing.JPanel Tang1_TrangChu3;
    private javax.swing.ButtonGroup btnGROUPLoaiPhong;
    private javax.swing.ButtonGroup btnGROUPTrangThai;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
    private giaodien.CustomClass.PanelRound panelRound1;
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
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnLayOutTrangChu;
    private giaodien.CustomClass.PanelRound pnLayoutSrool;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JTabbedPane pnedUngDung;
    private giaodien.CustomClass.ScrollPaneWin11 scrollPaneWin111;
    private giaodien.CustomClass.ScrollPaneWin11 scrollPaneWin112;
    private javax.swing.JLabel txtTenNhanVien;
    // End of variables declaration//GEN-END:variables

}
