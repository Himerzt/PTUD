package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.LoaiThue;
import entity.Phong;
import entity.TaiKhoan;
import entity.ThongTinDatThuePhong;

public class ThongTinDatThuePhongDao {

	ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
	ThongTinDatThuePhong tt = new ThongTinDatThuePhong();
	DichVuPhongDao dichVuPhongDao = new DichVuPhongDao();
	PhongDao phongDao = new PhongDao();
	LoaiThueDao loaiThueDao = new LoaiThueDao();
	
	double tongTien = 0;

	public ThongTinDatThuePhongDao() {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		tt = new ThongTinDatThuePhong();
	}

	// tìm tất cả phòng đặt thuê
	public ArrayList<ThongTinDatThuePhong> timTatCaThongTinDatThuePhong() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDatThue = rs.getString(1);

				String maKhachHang = rs.getString(2);
				String maPhong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);

				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maDatThue, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue);

				dsThongTin.add(tt);
//			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsThongTin;

	}

	// thêm thông tin đặt thuê
	public boolean themThongTinDatThuePhong(ThongTinDatThuePhong tt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsThongTin.contains(tt)) {
			try {
				stmt = con.createStatement();
				String sql = "insert into ThongTinDatThuePhong values('" + tt.getMaDatPhong() + "','"
						+ tt.getMaKhachHang() + "','" + tt.getMaPhong() + "','"
						+ tt.getNgayDatPhong() + "','" + tt.getNgayNhanPhong() + "','" + tt.getNgayTraPhong() + "','"
						+ tt.getMaLoaiThue() + "')";
				n = stmt.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	// tìm thông tin đặt thuê theo mã
	public ThongTinDatThuePhong timThongTinDatThuePhongTheoMa(String maDatThue) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maTTDTP = '" + maDatThue + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKhachHang = rs.getString(2);
				String maPhong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				tt = new ThongTinDatThuePhong(maDatThue, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tt;
	}

	// tìm danh sách thông tin đặt thuê theo mã khách hàng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoMaKhachHang(String maKhachHang) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maKhachHang = '" + maKhachHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDatThue = rs.getString(1);
				String maPhong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				tt = new ThongTinDatThuePhong(maDatThue, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return dsThongTin;
	}

	public double tinhTienTungPhong(String maPhong, String loaiThue) {
		double giaDV = this.dichVuPhongDao.tinhGiaDichVuCuaMotPhong(maPhong);
		KhachHangDao khachHangDao = new KhachHangDao();
		HangThanhVienDao hangThanhVienDao = new HangThanhVienDao();
		String loaiPhong = this.phongDao.timMaLoaiPhongTheoMaPhong(maPhong);
		double giaPhong = this.loaiThueDao.timLoaiThueTheoTenLoaiThueVaMaLoaiPhong(loaiPhong, loaiThue).getGiaThue();
		double chietkhau = hangThanhVienDao
				.timHangThanhVienTheoMa(khachHangDao
						.timTheoMaKhachHang(timThongTinDatThuePhongTheoMa(maPhong).getMaKhachHang()).getMaHangThanhVien())
				.getTiLeChietKhau();

		return (giaDV + giaPhong) * (1 - chietkhau);
	}

	public double tinhTienTheoDanhSachPhong(ArrayList<Phong> dsPhong) {

		ThongTinDatThuePhong tt;
		for (Phong phong2 : dsPhong) {

			tt = timThongTinDatThuePhongTheoMaPhong(phong2.getMaPhong());
			tongTien += tinhTienTungPhong(phong2.getMaPhong(), tt.getMaLoaiThue());
		}

		return tongTien;
	}

	// tìm thông tin đặt thuê theo mã phòng
	public ThongTinDatThuePhong timThongTinDatThuePhongTheoMaPhong(String maPhong) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where Phong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDatThue = rs.getString(1);
				String maKhachHang = rs.getString(2);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				tt = new ThongTinDatThuePhong(maDatThue, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong,
						ngayTraPhong, maLoaiThue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tt;
	}

	// tìm thông tin đặt thuê theo ngày nhận phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayNhanPhong(LocalDate ngayNhanPhong) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayNhanPhong = '" + ngayNhanPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDatThue = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String maPhong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				tt = new ThongTinDatThuePhong(maDatThue, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê theo ngày trả phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayTraPhong(LocalDate ngayTraPhong) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayTraPhong = '" + ngayTraPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDatThue = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String maPhong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				String maLoaiThue = rs.getString(7);
				tt = new ThongTinDatThuePhong(maDatThue, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê theo loại thuê
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoLoaiThue(String maLoaiThue) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maLoaiThue = '" + maLoaiThue + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDatThue = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String maPhong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				KhachHang kh = new KhachHang(maKhachHang);
				Phong phong = new Phong(maPhong);
				LoaiThue loaiThue = new LoaiThue(maLoaiThue);
				tt = new ThongTinDatThuePhong(maDatThue, kh.getMaKH(), phong.getMaLoaiPhong(), ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						loaiThue.getMaLoaiThue());
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê theo ngày đặt phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayDatPhong(LocalDate ngayDatPhong) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayDatPhong = '" + ngayDatPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDatThue = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String maPhong = rs.getString(3);
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				KhachHang kh = new KhachHang(maKhachHang);
				Phong phong = new Phong(maPhong);
				LoaiThue loaiThue = new LoaiThue(maLoaiThue);
				tt = new ThongTinDatThuePhong(maDatThue, kh.getMaKH(), phong.getMaLoaiPhong(), ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, loaiThue.getMaLoaiThue());
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	/////////// thêm danh sách phòng đặt
	ArrayList<Phong> dsPhong = new ArrayList<Phong>();

	public ArrayList<ThongTinDatThuePhong> themDanhSachPhongDat(String maLoaiPhong, String trangThai, int soLuong,
			String maKH, LocalDate ngayDat, LocalDate ngayNhan, LocalDate ngayTra, String maLoaiThue) {
		dsPhong = phongDao.timPhongTheoLoaiPhongTrangThaiSoLuong(maLoaiPhong, trangThai, soLuong);
		ArrayList<ThongTinDatThuePhong> ds = new ArrayList<ThongTinDatThuePhong>();
		ThongTinDatThuePhong bdtp = new ThongTinDatThuePhong();

		int i = 0;
		for (Phong phong : dsPhong) {
			bdtp = new ThongTinDatThuePhong(maKH + i, new KhachHang(maKH).getMaKH(), phong.getMaLoaiPhong(), ngayDat,
					ngayNhan, ngayTra, maLoaiThue);
			ds.add(bdtp);
			i++;
		}

		return ds;

	}

	// thêm danh sách phòng thuê

	public ArrayList<ThongTinDatThuePhong> themDanhSachPhongThue(String maLoaiPhong, String trangThai, int soLuong,
			String maKH, LocalDate ngayNhan, LocalDate ngayTra, String maLoaiThue) {
		dsPhong = phongDao.timPhongTheoLoaiPhongTrangThaiSoLuong(maLoaiPhong, trangThai, soLuong);
		ArrayList<ThongTinDatThuePhong> ds = new ArrayList<ThongTinDatThuePhong>();
		ThongTinDatThuePhong bdtp = new ThongTinDatThuePhong();

		int i = 0;
		for (Phong phong : dsPhong) {
			bdtp = new ThongTinDatThuePhong(maKH + 'i', new KhachHang(maKH).getMaKH(), phong.getMaLoaiPhong(), null, ngayNhan, ngayTra,
					maLoaiThue);
			ds.add(bdtp);
			i++;
		}

		return ds;

	}

	// Thue NHIỀU PHÒNG
	public boolean ThueNhieuPhong(ArrayList<ThongTinDatThuePhong> dsDatThuePhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		Statement stmts = null;
		int n = 0;
		for (ThongTinDatThuePhong bangDatThuePhong : dsDatThuePhong) {
			if (dsDatThuePhong.contains(bangDatThuePhong)) {
				try {
					stmt = con.createStatement();
					stmts = con.createStatement();
					String sql = "insert into BangDatThuePhong values('" + bangDatThuePhong.getMaDatPhong() + "','"
							+ bangDatThuePhong.getMaKhachHang() + "','"
							+ bangDatThuePhong.getMaPhong() + "','" + bangDatThuePhong.getNgayDatPhong()
							+ "','" + bangDatThuePhong.getNgayNhanPhong() + "','" + bangDatThuePhong.getNgayTraPhong()
							+ "','" + bangDatThuePhong.getMaLoaiThue() + "',')";
					String sqls = "update Phong set trangThai = 'Đã Thuê' where maPhong = '"
							+ bangDatThuePhong.getMaPhong() + "'";
					n = stmt.executeUpdate(sql);
					stmts.executeUpdate(sqls);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return n > 0;
	}

// cập nhật nhận phòng
	public boolean capNhatNgayNhanPhong(ThongTinDatThuePhong tt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsThongTin.contains(tt)) {
			try {
				stmt = con.createStatement();
				String sql = "update ThongTinDatThuePhong set ngayNhanPhong = '" + tt.getNgayNhanPhong()
						+ "' where maDatPhong = '" + tt.getMaDatPhong() + "'";
				n = stmt.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	// gia hạn phòng sau khi thuê
	public boolean capNhatNgayTraPhong(ThongTinDatThuePhong tt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsThongTin.contains(tt)) {
			try {
				stmt = con.createStatement();
				String sql = "update ThongTinDatThuePhong set ngayTraPhong = '" + tt.getNgayTraPhong()
						+ "' where maDatPhong = '" + tt.getMaDatPhong() + "'";
				n = stmt.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	// xóa thông tin đặt thuê
	public boolean xoaThongTinDatThuePhong(ThongTinDatThuePhong tt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsThongTin.contains(tt)) {
			try {
				stmt = con.createStatement();
				String sql = "delete from ThongTinDatThuePhong where maDatPhong = '" + tt.getMaDatPhong() + "'";
				n = stmt.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

// tính tổng tiền dịch vụ
	public double tinhTongTienDichVu(String maDatPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		double tongTien = 0;
		try {
			stmt = con.createStatement();

			String sqls =

					"SELECT dp.maDVPhong, dp.maPhongThue, SUM(dp.soLuong * dv.GiaThue) AS TongTien FROM DichVuPhong dp JOIN DichVu dv ON dp.maDV = dv.maDV WHERE dp.maDatPhong = '"
							+ maDatPhong + "' GROUP BY dp.maDVPhong, dp.maPhongThue;";
			ResultSet rs = stmt.executeQuery(sqls);
			while (rs.next()) {
				tongTien = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongTien;
	}

	// thanh toán
	public boolean thanhToan(String maDatPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "update ThongTinDatThuePhong set trangThai = 'Đã thanh toán' where maDatPhong = '" + maDatPhong
					+ "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return n > 0;
	}

	public ArrayList<Phong> timphongTheoDanhSachMa(ArrayList<String> soPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (String str : soPhong) {
			// Chuyển đổi từ String sang Integer và thêm vào ArrayList<Integer>
			intList.add(Integer.parseInt(str));
		}

		for (int a : intList) {
			try {
				stmt = con.createStatement();
				String sql = "select * from Phong where soPhong = '" + a + "'";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String maPhong = rs.getString(1);
					int mama = rs.getInt(2);
					String maLoaiPhong = rs.getString(3);
					String trangThai = rs.getString(4);

					Phong phong = new Phong(maPhong, mama, maLoaiPhong, trangThai);
					dsPhong.add(phong);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return null;
	}

	// đặt phòng
	public boolean datPhong(ArrayList<Phong> phong, KhachHang kh, LocalDate ngayDatPhong, LocalDate ngayNhanPhong,
			String maLoaiThue, LocalDate ngayTraPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int i = 1;
		for (Phong phong2 : phong) {
			try {
				String maDP = String.format("%s%s", kh.getMaKH(), i);
				stmt = con.createStatement();
				String sql = "insert into ThongTinDatThuePhong values('" + (maDP) + "', '" + kh.getMaKH() + "', '"
						+ phong2.getMaPhong() + "', '" + ngayDatPhong + "', '" + ngayNhanPhong + "', '" + ngayTraPhong
						+ "','" + maLoaiThue + "')";
				String sql1 = "UPDATE Phong SET trangThaiPhong = N'Đã đặt' WHERE maPhong = '" + phong2.getMaPhong()
						+ "'";
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql1);
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public ArrayList<String> layDanhSachPhongTheoMaKhachHang(String maKH) {
		ArrayList<String> dsPhong = new ArrayList<String>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maKhachHang = '" + maKH + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString(3);
				dsPhong.add(maPhong);
			}
			return dsPhong;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

}
