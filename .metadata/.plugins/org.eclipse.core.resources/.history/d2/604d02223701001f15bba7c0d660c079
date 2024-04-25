package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ManHinhNV_GUI extends JFrame {

	final JMenuBar menuBar;
	private CardLayout cardLayout;
	private JPanel cardPanel;

	public static void main(String[] args) {
		new ManHinhNV_GUI();
	}

	public ManHinhNV_GUI() {
		super("Hệ Thống Quản Lý Hiệu Thuốc");
		setSize(1800, 1080);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setResizable(false);

		setJMenuBar(menuBar = new JMenuBar());

//		Add vào card
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

//		CÁC TAB		
//		Trang Chủ 
		cardPanel.add(new TrangChu_Gui(), "Trang Chủ");
		
//		Khách hàng
		cardPanel.add(new DSKhachHang_Gui(), "Quản Lý Khách Hàng");
		cardPanel.add(new TimKhachHang_Gui(), "Tìm Kiếm Khách Hàng");
		
//		Hóa Đơn
		cardPanel.add(new LapDonThuoc_Gui(), "Lập Đơn Thuốc");
		cardPanel.add(new DSDonDat_Gui(), "Danh Sách Đơn Đặt");
		cardPanel.add(new DSHoaDon_Gui(), "Danh Sách Hóa Đơn");
		
//		Thuốc
		cardPanel.add(new DSThuoc_Gui(), "Quản Lý Thuốc");
		cardPanel.add(new TimThuoc_Gui(), "Tìm Kiếm Thuốc");
		cardPanel.add(new NhapThuoc_Gui(), "Nhập Thuốc");
		cardPanel.add(new DanhSachPhieuNhapThuoc_Gui(), "Danh sách phiếu nhập thuốc");
		cardPanel.add(new ThemNCC_Gui(), "Thêm Nhà Cung Cấp");
		
//		Hệ thống
		cardPanel.add(new DoiMatKhau_Gui(), "Đổi Mật Khẩu");
		
//		GUI
		showMenu();
		showGUI();
		
		setContentPane(cardPanel);
		
	}

	public void showMenu() {

//		Tạo Menu và Icon
		JMenu trangChuMenu = new JMenu("Trang Chủ");
		trangChuMenu.setPreferredSize(new Dimension(163, 50));
		ImageIcon iconTrangChu = new ImageIcon("src//Icon//home.png");
		Image imageTrangChu = iconTrangChu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconTrangChu = new ImageIcon(imageTrangChu);
		trangChuMenu.setIcon(iconTrangChu);
		
		JMenu heThong = new JMenu("<html><body>Hệ Thống <b>&#x25BC;</b></body></html>");
		heThong.setPreferredSize(new Dimension(163, 50));
		ImageIcon iconHeThong = new ImageIcon("src//Icon//heThong.png");
		Image imageHeThong = iconHeThong.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconHeThong = new ImageIcon(imageHeThong);
		heThong.setIcon(iconHeThong);

//		JMenu qlNhanVien = new JMenu("<html><body>Nhân Viên <b>&#x25BC;</b></body></html>");
//		qlNhanVien.setPreferredSize(new Dimension(185, 50));
//		ImageIcon iconNhanVien = new ImageIcon("src//Icon//nhanvien.png");
//		Image imageNhanVien = iconNhanVien.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		iconNhanVien = new ImageIcon(imageNhanVien);
//		qlNhanVien.setIcon(iconNhanVien);

		JMenu qlThuoc = new JMenu("<html><body>Thuốc <b>&#x25BC;</b></body></html>");
		qlThuoc.setPreferredSize(new Dimension(165, 50));
		ImageIcon iconThuoc = new ImageIcon("src//Icon//thuoc.png");
		Image imageThuoc = iconThuoc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconThuoc = new ImageIcon(imageThuoc);
		qlThuoc.setIcon(iconThuoc);

		JMenu qlHoaDon = new JMenu("<html><body>Hóa Đơn <b>&#x25BC;</b></body></html>");
		qlHoaDon.setPreferredSize(new Dimension(180, 50));
		ImageIcon iconHoaDon = new ImageIcon("src//Icon//hoadon.png");
		Image imageHoaDon = iconHoaDon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconHoaDon = new ImageIcon(imageHoaDon);
		qlHoaDon.setIcon(iconHoaDon);

		JMenu qlKhachHang = new JMenu("<html><body>Khách Hàng <b>&#x25BC;</b></body></html>");
		qlKhachHang.setPreferredSize(new Dimension(190, 50));
		ImageIcon iconKH = new ImageIcon("src//Icon//khach.png");
		Image imageKH = iconKH.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconKH = new ImageIcon(imageKH);
		qlKhachHang.setIcon(iconKH);

//		JMenu qlThongKe = new JMenu("<html><body>Thống Kê <b>&#x25BC;</b></body></html>");
//		qlThongKe.setPreferredSize(new Dimension(210, 50));
//		ImageIcon iconThongKe = new ImageIcon("src//Icon//thongke.png");
//		Image imageThongKe = iconThongKe.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		iconThongKe = new ImageIcon(imageThongKe);
//		qlThongKe.setIcon(iconThongKe);

//		MENU ITEM
//		Menu Item đổi mật khẩu
		JMenuItem doiMatKhau = new JMenuItem("Đổi Mật Khẩu");
		ImageIcon iconChange = new ImageIcon("src//Icon//doiMK.png");
		Image imageChange = iconChange.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconChange = new ImageIcon(imageChange);
		doiMatKhau.setIcon(iconChange);
		
//		Menu Item Đăng Xuất
		JMenuItem dangXuat = new JMenuItem("Đăng Xuất");
//		ICON ĐĂNG XUẤT
		ImageIcon iconDX = new ImageIcon("src//Icon//dangXuat.png");
		Image imageDX = iconDX.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconDX = new ImageIcon(imageDX);
		dangXuat.setIcon(iconDX);

//		Menu Item Thoát
		JMenuItem thoat = new JMenuItem("Thoát");
//		ICON Thoát
		ImageIcon iconThoat = new ImageIcon("src//Icon//exit.png");
		Image imageThoat = iconThoat.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconThoat = new ImageIcon(imageThoat);
		thoat.setIcon(iconThoat);
		
//		Menu Item Danh Sách Khách Hàng
		JMenuItem dsKhach = new JMenuItem("Quản Lý Khách Hàng");
		ImageIcon iconDSKH = new ImageIcon("src//Icon//dsHD.png");
		Image imageDSKH = iconDSKH.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconDSKH = new ImageIcon(imageDSKH);
		dsKhach.setIcon(iconDSKH);
		
//		Menu Item Tìm Kiếm Khách Hàng
		JMenuItem timKhach = new JMenuItem("Tìm Kiếm Khách Hàng");
		ImageIcon iconTim = new ImageIcon("src//Icon//iconTim.png");
		Image imageTim = iconTim.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconTim = new ImageIcon(imageTim);
		timKhach.setIcon(iconTim);

//		Menu Item Danh Sách Nhân Viên
		JMenuItem dsNhanVien = new JMenuItem("Quản Lý Nhân Viên");
		ImageIcon iconQL = new ImageIcon("src//Icon//iconQL.png");
		Image imageQL = iconQL.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconQL = new ImageIcon(imageQL);
		dsNhanVien.setIcon(iconQL);
		
//		Menu Item Tìm Kiếm Nhân Viên
		JMenuItem timNhanVien = new JMenuItem("Tìm Kiếm Nhân Viên");
		timNhanVien.setIcon(iconTim);
		
//		Menu Item Danh Sách Thuốc
		JMenuItem dsThuoc = new JMenuItem("Quản Lý Thuốc");
		ImageIcon iconDSThuoc = new ImageIcon("src//Icon//dsThuoc.png");
		Image imageDSThuoc = iconDSThuoc.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconDSThuoc = new ImageIcon(imageDSThuoc);
		dsThuoc.setIcon(iconDSThuoc);
		
//		Menu Item Tìm Kiếm Thuốc
		JMenuItem timThuoc = new JMenuItem("Tìm Kiếm Thuốc");
		timThuoc.setIcon(iconTim);
		
//		Menu Iten Nhập thuốc
		JMenuItem nhapThuoc = new JMenuItem("Nhập Thuốc");
		ImageIcon iconNhapThuoc = new ImageIcon("src//Icon//nhapThuoc.png");
		Image imageNhapThuoc = iconNhapThuoc.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconNhapThuoc = new ImageIcon(imageNhapThuoc);
		nhapThuoc.setIcon(iconNhapThuoc);
		
//		Menu Item Danh sách phiếu nhập thuốc
		JMenuItem dsPhieuNhapThuoc = new JMenuItem("Danh sách phiếu nhập thuốc");
		ImageIcon iconPhieuNhapThuoc = new ImageIcon("src//Icon//phieuNhap.png");
		Image imagePhieuNhapThuoc = iconPhieuNhapThuoc.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconPhieuNhapThuoc = new ImageIcon(imagePhieuNhapThuoc);
		dsPhieuNhapThuoc.setIcon(iconPhieuNhapThuoc);
		
		
//		Menu Item Thêm Nhà Cung Cấp
		JMenuItem themNCC = new JMenuItem("Thêm Nhà Cung Cấp");
		ImageIcon iconThemNCC = new ImageIcon("src//Icon//themNCC.jpg");
		Image imageThemNCC = iconThemNCC.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconThemNCC = new ImageIcon(imageThemNCC);
		themNCC.setIcon(iconThemNCC);
		
		
		
//		Menu Item Hóa Đơn
//		JMenuItem lapHoaDon = new JMenuItem("Lập Hóa Đơn");
		ImageIcon iconDonDat = new ImageIcon("src//Icon//gioHang.png");
		Image imageDonDat = iconDonDat.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconDonDat = new ImageIcon(imageDonDat);
//		lapHoaDon.setIcon(iconLap);
		
		JMenuItem timHoaDon = new JMenuItem("Danh Sách Hóa Đơn");
		timHoaDon.setIcon(iconQL);

		JMenuItem dsDonDat = new JMenuItem("Danh Sách Đơn Đặt");
		dsDonDat.setIcon(iconDonDat);

		JMenuItem lapDonDat = new JMenuItem("Lập Đơn Thuốc");
		ImageIcon iconLap = new ImageIcon("src//Icon//lapHD.png");
		Image imageLap = iconLap.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		iconLap = new ImageIcon(imageLap);
		lapDonDat.setIcon(iconLap);

//		Menu Item Thống Kê
//		JMenuItem xemThongKe = new JMenuItem("Xem Thống Kê");
//		ImageIcon iconXemTK = new ImageIcon("src//Icon//xemTK.png");
//		Image imageXemTK = iconXemTK.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
//		iconXemTK = new ImageIcon(imageXemTK);
//		xemThongKe.setIcon(iconXemTK);

		
//		ADD MENU ITEM VÀO MENU
//		add Menu Item Hệ Thống
		heThong.add(doiMatKhau);
		doiMatKhau.setPreferredSize(new Dimension(160, 50));
		
		heThong.add(dangXuat);
		dangXuat.setPreferredSize(new Dimension(160, 50));

		heThong.add(thoat);
		thoat.setPreferredSize(new Dimension(160, 50));

//		add Menu Item Khách Hàng
		qlKhachHang.add(dsKhach);
		dsKhach.setPreferredSize(new Dimension(180, 50));
		
		qlKhachHang.add(timKhach);
		timKhach.setPreferredSize(new Dimension(180, 50));
		
		
//		add Menu Item Nhân Viên
//		qlNhanVien.add(dsNhanVien);
//		dsNhanVien.setPreferredSize(new Dimension(180, 50));
//		
//		qlNhanVien.add(timNhanVien);
//		timNhanVien.setPreferredSize(new Dimension(180, 50));
		
//		add Menu Item Thuốc
		qlThuoc.add(dsThuoc);
		dsThuoc.setPreferredSize(new Dimension(165, 50));
		
		qlThuoc.add(timThuoc);
		timThuoc.setPreferredSize(new Dimension(165, 50));
		
		qlThuoc.add(nhapThuoc);
		nhapThuoc.setPreferredSize(new Dimension(165, 50));
		
		qlThuoc.add(dsPhieuNhapThuoc);
		dsPhieuNhapThuoc.setPreferredSize(new Dimension(165, 50));
		
		qlThuoc.add(themNCC);
		themNCC.setPreferredSize(new Dimension(165, 50));
		
		
//		add Menu Item Hóa Đơn
		qlHoaDon.add(lapDonDat);
		lapDonDat.setPreferredSize(new Dimension(180, 50));
		
		qlHoaDon.add(timHoaDon);
		timHoaDon.setPreferredSize(new Dimension(180, 50));

		qlHoaDon.add(dsDonDat);
		dsDonDat.setPreferredSize(new Dimension(180, 50));
		
//		qlHoaDon.add(lapHoaDon);
//		lapHoaDon.setPreferredSize(new Dimension(180, 50));

//		add Menu Item Thống Kê
//		qlThongKe.add(xemThongKe);
//		xemThongKe.setPreferredSize(new Dimension(195, 50));

////		Set Phím Tắt
//		trangChuMenu.setMnemonic(KeyEvent.VK_A);
//		qlNhanVien.setMnemonic(KeyEvent.VK_N);
//		qlKhachHang.setMnemonic(KeyEvent.VK_K);
//		qlHoaDon.setMnemonic(KeyEvent.VK_H);
//		qlDonDat.setMnemonic(KeyEvent.VK_D);
//		qlThuoc.setMnemonic(KeyEvent.VK_T);
//		tkKetCa.setMnemonic(KeyEvent.VK_E); // End
//		xemThongKe.setMnemonic(KeyEvent.VK_X);

//		ADD JMENU
		menuBar.add(trangChuMenu);
		menuBar.add(new JLabel("|"));
//		menuBar.add(qlNhanVien);
//		menuBar.add(new JLabel("|"));
		menuBar.add(qlThuoc);
		menuBar.add(new JLabel("|"));
		menuBar.add(qlHoaDon);
		menuBar.add(new JLabel("|"));
		menuBar.add(qlKhachHang);
		menuBar.add(new JLabel("|"));
//		menuBar.add(qlThongKe);
//		menuBar.add(new JLabel("|"));
		menuBar.add(heThong);
//		END MENU

//		TRANG CHỦ
		trangChuMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Trang Chủ");
			}
		});
		
//		HỆ THỐNG
		doiMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Đổi Mật Khẩu");
				
			}
		});
		
		dangXuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Đăng Xuất", "Xác nhận đăng xuất ?", JOptionPane.YES_NO_OPTION);
				if(res==JOptionPane.YES_OPTION)
					new DangNhap_Gui();
			}
		});

		thoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

//		NHÂN VIÊN
		dsNhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Quản Lý Nhân Viên");
			}
		});
		
		timNhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Tìm Kiếm Nhân Viên");
			}
		});

//		KHÁCH HÀNG
		dsKhach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Quản Lý Khách Hàng");
			}
		});
		
		timKhach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Tìm Kiếm Khách Hàng");
			}
		});

//		THUỐC
		dsThuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Quản Lý Thuốc");
			}
		});
		
		timThuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Tìm Kiếm Thuốc");
			}
		});
		
		nhapThuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Nhập Thuốc");
			}
		});
		
		dsPhieuNhapThuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Danh sách phiếu nhập thuốc");
			}
		});
		
		themNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Thêm Nhà Cung Cấp");
            }
        });

//		HÓA ĐƠN		
		timHoaDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Danh Sách Hóa Đơn");
			}
		});

		dsDonDat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Danh Sách Đơn Đặt");
			}
		});

		lapDonDat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Lập Đơn Thuốc");
			}
		});

//		Thống Kê
//		xemThongKe.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(cardPanel, "Xem Thống Kê");
//			}
//		});

//		GUI
		
		
//		END
		setJMenuBar(menuBar);
		setVisible(true);
	}
	
	private void showGUI() {
		JPanel pn = new JPanel();
		JLabel lb = new JLabel("CHÀO MỪNG ĐẾN VỚI NHÀ THUỐC");
		pn.add(lb);
		add(pn);
		
		setVisible(true);
	}
}
