package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	public double tinhTienTungPhong(String maPhong, String loaiThue) {
		double giaDV = this.dichVuPhongDao.tinhGiaDichVuCuaMotPhong(maPhong);
		KhachHangDao khachHangDao = new KhachHangDao();
		HangThanhVienDao hangThanhVienDao = new HangThanhVienDao();
		double giaPhong = loaiThueDao.timGiaThueTheoLoaiThue(loaiThue);
		double chietkhau = hangThanhVienDao.timHangThanhVienTheoMa(khachHangDao
				.timTheoMaKhachHang(timThongTinDatThuePhongTheoMa(maPhong).getMaKhachHang()).getMaHangThanhVien())
				.getTiLeChietKhau();
		return (giaDV + giaPhong) * (1 - chietkhau);
	}

	public double tinhTienTheoDanhSachPhong(ArrayList<Phong> dsPhong) {
		ThongTinDatThuePhong tt;
		for (Phong phong2 : dsPhong) {
			tt = timThongTinDatThuePhongTheoMaPhong(phong2.getMaPhong());
			tongTien += tinhTienTungPhong(tt.getMaPhong(), tt.getMaLoaiThue());
		}
		return tongTien;
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
						+ "' where maDatPhong = '" + tt.getMaTTDTP() + "'";
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
				String sql = "delete from ThongTinDatThuePhong where maDatPhong = '" + tt.getMaTTDTP() + "'";
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
	
	// Tìm thông tin đặt thuê phòng theo mã khách hàng
	public List<ThongTinDatThuePhong> timThongTinTheoMaKhachHang(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select * from ThongTinDatThuePhong where maKhachHang = '" + maKhachHang + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maDatPhong = rs.getString(1);
				String maKhachHang1 = rs.getString(2);
				String maPhong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maDatPhong, maKhachHang1, maPhong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// Đặt phòng
	public boolean datPhong(ArrayList<Phong> phong, KhachHang kh, LocalDate ngayDatPhong, LocalDate ngayNhanPhong,
			String maLoaiThue, LocalDate ngayTraPhong, double tienDaCoc) {
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
						+ "','" + maLoaiThue + "','" + tienDaCoc + "')";
				stmt.executeUpdate(sql);
				String sql1 = "UPDATE Phong SET trangThaiPhong = N'Đã đặt' WHERE maPhong = '" + phong2.getMaPhong()
						+ "'";
				stmt.executeUpdate(sql1);
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// Thuê phòng
	public boolean thuePhong(ArrayList<Phong> phong, KhachHang kh, LocalDate ngayDatPhong, LocalDate ngayNhanPhong,
			String maLoaiThue, LocalDate ngayTraPhong, double tienDaCoc) {
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
						+ "','" + maLoaiThue + "','" + tienDaCoc + "')";
				stmt.executeUpdate(sql);
				String sql1 = "UPDATE Phong SET trangThaiPhong = N'Đã thuê' WHERE maPhong = '" + phong2.getMaPhong()
						+ "'";
				stmt.executeUpdate(sql1);
				i++;
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
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

	// tìm tất cả thông tin đặt thuê phòng
	public ArrayList<ThongTinDatThuePhong> timTatCaThongTinDatThuePhong() {
		ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// thêm thông tin đặt thuê phòng
	public boolean themThongTinDatThuePhong(ThongTinDatThuePhong tt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "insert into ThongTinDatThuePhong values('" + tt.getMaTTDTP() + "','" + tt.getMaKhachHang()
					+ "','" + tt.getMaPhong() + "','" + tt.getNgayDatPhong() + "','" + tt.getNgayNhanPhong() + "','"
					+ tt.getNgayTraPhong() + "','" + tt.getMaLoaiThue() + "','" + tt.getTienDaCoc() + "')";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// tìm thông tin đặt thuê phòng theo mã
	public ThongTinDatThuePhong timThongTinDatThuePhongTheoMa(String maTTDTP) {
		ThongTinDatThuePhong tt = new ThongTinDatThuePhong();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maTTDTP = '" + maTTDTP + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue, tienDaCoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tt;
	}

	// tìm thông tin đặt thuê phòng theo mã khách hàng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoMaKhachHang(String maKhachHang) {
		ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maKhachHang = '" + maKhachHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String phong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo mã phòng
	public ThongTinDatThuePhong timThongTinDatThuePhongTheoMaPhong(String maPhong) {
		ThongTinDatThuePhong tt = new ThongTinDatThuePhong();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where phong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue, tienDaCoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tt;
	}

	// tìm thông tin đặt thuê phòng theo ngày nhận phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayNhanPhong(LocalDate ngayNhanPhong) {
		ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayNhanPhong = '" + ngayNhanPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo ngày trả phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayTraPhong(LocalDate ngayTraPhong) {
		ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayTraPhong = '" + ngayTraPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo loại thuê
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoLoaiThue(String maLoaiThue) {
		ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maLoaiThue = '" + maLoaiThue + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDate ngayDatPhong = rs.getDate(4).toLocalDate();
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				double tienDaCoc = rs.getDouble(8);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo ngày đặt phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayDatPhong(LocalDate ngayDatPhong) {
		ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayDatPhong = '" + ngayDatPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDate ngayNhanPhong = rs.getDate(5).toLocalDate();
				LocalDate ngayTraPhong = rs.getDate(6).toLocalDate();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// cập nhật thông tin đặt thuê phòng
	public boolean capNhatThongTinDatThuePhong(ThongTinDatThuePhong tt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "update ThongTinDatThuePhong set maKhachHang = '" + tt.getMaKhachHang() + "', phong = '"
					+ tt.getMaPhong() + "', ngayDatPhong = '" + tt.getNgayDatPhong() + "', ngayNhanPhong = '"
					+ tt.getNgayNhanPhong() + "', ngayTraPhong = '" + tt.getNgayTraPhong() + "', maLoaiThue = '"
					+ tt.getMaLoaiThue() + "', tienDaCoc = '" + tt.getTienDaCoc() + "' where maTTDTP = '"
					+ tt.getMaTTDTP() + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// gia hạn phòng sau khi thuê
	public boolean giaHanPhong(ThongTinDatThuePhong tt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "update ThongTinDatThuePhong set ngayTraPhong = '" + tt.getNgayTraPhong()
					+ "' where maTTDTP = '" + tt.getMaTTDTP() + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
