package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.LoaiThue;
import entity.Phong;
import entity.TaiKhoan;
import entity.ThongTinDatThuePhong;
import java.time.LocalDate;

public class ThongTinDatThuePhongDao {

	ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<ThongTinDatThuePhong>();
	ThongTinDatThuePhong tt = new ThongTinDatThuePhong();
	DichVuPhongDao dichVuPhongDao = new DichVuPhongDao();
	PhongDao phongDao = new PhongDao();
	LoaiThueDao loaiThueDao = new LoaiThueDao();
	double tongTien = 0;

	public ThongTinDatThuePhongDao() {
		dsThongTin = timTatCaThongTinDatThuePhong();
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

	// xóa thông tin đặt thuê theo mã khách hàng
	public boolean xoaThongTinDatThueTheoMaKhachHang(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "delete from ThongTinDatThuePhong where maKhachHang = '" + maKhachHang + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xóa thông tin đặt thuê theo mã đặt phòng
	public boolean xoaThongTinDatThueTheoMa(String maTTDT) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "delete from ThongTinDatThuePhong where maTTDTP = '" + maTTDT + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	// Chỉnh sửa trạng thái thông tin đặt thuê phòng theo mã khách hàng
	public boolean capNhatTrangThaiTheoMaKhachHang(String maKhachHang, String trangThai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "update ThongTinDatThuePhong set trangThai = N'" + trangThai + "' where maKhachHang = '"
					+ maKhachHang + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	// Chỉnh sửa trạng thái thông tin đặt thuê phòng theo mã đặt phòng
	public boolean capNhatNgayNhanTheoMaKhachHang(String maKH, LocalDateTime ngayNhan) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			Timestamp ngayNhanTs = Timestamp.valueOf(ngayNhan);
			String sql = "update ThongTinDatThuePhong set ngayNhanPhong = '" + ngayNhanTs + "' where maKhachHang = '"
					+ maKH + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Cập nhật là số tiền cọc theo mã khách hàng
	public boolean capNhatTienCocTheoMaKhachHang(String maKhachHang, double tienDaCoc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "update ThongTinDatThuePhong set tienDaCoc = '" + tienDaCoc + "' where maKhachHang = '"
					+ maKhachHang + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
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
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM ThongTinDatThuePhong WHERE maKhachHang = '" + maKhachHang + "'";
			System.out.println("SQL Query: " + sql); // In ra truy vấn SQL để kiểm tra
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maDatPhong = rs.getString(1);
				String maKhachHang1 = rs.getString(2);
				String maPhong = rs.getString(3);

				Timestamp ngayDatPhongTs = rs.getTimestamp(4);
				LocalDateTime ngayDatPhong = (ngayDatPhongTs != null) ? ngayDatPhongTs.toLocalDateTime() : null;

				Timestamp ngayNhanPhongTs = rs.getTimestamp(5);
				LocalDateTime ngayNhanPhong = (ngayNhanPhongTs != null) ? ngayNhanPhongTs.toLocalDateTime() : null;

				Timestamp ngayTraPhongTs = rs.getTimestamp(6);
				LocalDateTime ngayTraPhong = (ngayTraPhongTs != null) ? ngayTraPhongTs.toLocalDateTime() : null;

				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);

				String trangThai = rs.getString(9);

				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maDatPhong, maKhachHang1, maPhong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc, trangThai);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Số lượng thông tin đặt thuê phòng tìm được: " + dsThongTin.size());
		return dsThongTin;
	}

	// Đặt phòng
	public boolean datPhong(ArrayList<Phong> phong, KhachHang kh, LocalDateTime ngayDatPhong,
			LocalDateTime ngayNhanPhong, LocalDateTime ngayTraPhong, String maLoaiThue, double tienDaCoc,
			String trangThai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		for (Phong phong2 : phong) {
			try {
				String maDP = String.format("%s%s", "TTDTP", (timTatCaThongTinDatThuePhong().size() + 1));
				System.out.println("Mã đặt phòng: " + maDP);
				stmt = con.createStatement();
				Timestamp ngayDatPhongTs = Timestamp.valueOf(ngayDatPhong);
				Timestamp ngayNhanPhongTs = Timestamp.valueOf(ngayNhanPhong);
				Timestamp ngayTraPhongTs = Timestamp.valueOf(ngayTraPhong);
				String sql = "insert into ThongTinDatThuePhong values('" + (maDP) + "', '" + kh.getMaKH() + "', '"
						+ phong2.getMaPhong() + "', '" + ngayDatPhongTs + "', '" + ngayNhanPhongTs + "', '"
						+ ngayTraPhongTs + "','" + maLoaiThue + "','" + tienDaCoc + "', N'" + trangThai + "')";
				stmt.executeUpdate(sql);
				String sql1 = "UPDATE Phong SET trangThaiPhong = N'Đã đặt' WHERE maPhong = '" + phong2.getMaPhong()
						+ "'";
				stmt.executeUpdate(sql1);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	// Thuê phòng
	public boolean thuePhong(ArrayList<Phong> phong, KhachHang kh, LocalDateTime ngayDatPhong,
			LocalDateTime ngayNhanPhong, String maLoaiThue, LocalDateTime ngayTraPhong, double tienDaCoc,
			String trangThai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		for (Phong phong2 : phong) {
			try {
				String maDP = String.format("%s%s", "TTDTP", (timTatCaThongTinDatThuePhong().size() + 1));
				System.out.println("Mã đặt phòng: " + maDP);
				stmt = con.createStatement();
				// Chuyển đổi LocalDateTime sang Timestamp
				Timestamp ngayDatPhongTs = Timestamp.valueOf(ngayDatPhong);
				Timestamp ngayNhanPhongTs = Timestamp.valueOf(ngayNhanPhong);
				Timestamp ngayTraPhongTs = Timestamp.valueOf(ngayTraPhong);

				// Thêm thông tin thuê phòng
				String sql = "insert into ThongTinDatThuePhong values('" + maDP + "', '" + kh.getMaKH() + "', '"
						+ phong2.getMaPhong() + "', '" + ngayDatPhongTs + "', '" + ngayNhanPhongTs + "', '"
						+ ngayTraPhongTs + "','" + maLoaiThue + "','" + tienDaCoc + "', N'" + trangThai + "')";
				stmt.executeUpdate(sql);

				// Cập nhật trạng thái phòng
				String sql1 = "UPDATE Phong SET trangThaiPhong = N'Đã thuê' WHERE maPhong = '" + phong2.getMaPhong()
						+ "'";
				stmt.executeUpdate(sql1);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
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

	// tìm tất cả thông tin đặt thuê phòng
	public ArrayList<ThongTinDatThuePhong> timTatCaThongTinDatThuePhong() {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc, trangThai);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
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
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
						maLoaiThue, tienDaCoc, trangThai);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tt;
	}

	// tìm thông tin đặt thuê phòng theo mã khách hàng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoMaKhachHang(String maKhachHang) {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maKhachHang = '" + maKhachHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String phong = rs.getString(3);
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc, trangThai);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// Tìm thông tin phòng theo mã khách hàng
	public ArrayList<Phong> timPhongTheoMaKhachHang(String maKhachHang) {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maKhachHang = '" + maKhachHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString(3);
				Phong phong = phongDao.timPhongTheoMaPhong(maPhong);
				dsPhong.add(phong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	// tìm thông tin đặt thuê phòng theo mã phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoMaPhong(String maPhong) {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where MaPhong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				dsThongTin.add(new ThongTinDatThuePhong(maTTDTP, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong,
						ngayTraPhong, maLoaiThue, tienDaCoc, trangThai));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo ngày nhận phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayNhanPhong(LocalDateTime ngayNhanPhong) {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayNhanPhong = '" + ngayNhanPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc, trangThai);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo ngày trả phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayTraPhong(LocalDateTime ngayTraPhong) {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayTraPhong = '" + ngayTraPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc, trangThai);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo loại thuê
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoLoaiThue(String maLoaiThue) {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where maLoaiThue = '" + maLoaiThue + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc, trangThai);
				dsThongTin.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThongTin;
	}

	// tìm thông tin đặt thuê phòng theo ngày đặt phòng
	public ArrayList<ThongTinDatThuePhong> timThongTinDatThuePhongTheoNgayDatPhong(LocalDateTime ngayDatPhong) {
		dsThongTin = new ArrayList<ThongTinDatThuePhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ThongTinDatThuePhong where ngayDatPhong = '" + ngayDatPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTTDTP = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String phong = rs.getString(3);
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
				String maLoaiThue = rs.getString(7);
				double tienDaCoc = rs.getDouble(8);
				String trangThai = rs.getString(9);
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc, trangThai);
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
public int demSoLuongPhongTheoNgay(int ngay, int thang, int nam) {
        int soLuong = 0;
        try {
            // Chuyển đổi ngày, tháng, năm thành LocalDateTime
            LocalDateTime ngayNhanPhong = LocalDateTime.of(nam, thang, ngay, 0, 0);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
        }

	// cập nhật ngày trả phòng thông tin truyền vào là mã ttdtp và ngày trả phòng
	public boolean capNhatNgayTraPhong(ThongTinDatThuePhong maTTDTP, LocalDate ngayTraPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "update ThongTinDatThuePhong set ngayTraPhong = '" + ngayTraPhong + "' where maTTDTP = '"
					+ maTTDTP + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	
	
	
	
	// cập nhật thông tin đặt thuê phòng với mã phòng thay đổi
	public boolean capNhatThongTinDatThuePhong(String maTTDTP, String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			stmt = con.createStatement();
			String sql = "update ThongTinDatThuePhong set phong = '" + maPhong + "' where maTTDTP = '" + maTTDTP + "'";
			n = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
// tìm thongtindatthuephong theo mã phòng
	public ThongTinDatThuePhong timThongTinDatThuePhongTheoMaPhong1(String maPhong) {
        ThongTinDatThuePhong tt = new ThongTinDatThuePhong();
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from ThongTinDatThuePhong where maPhong = '" + maPhong + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maTTDTP = rs.getString(1);
                String maKhachHang = rs.getString(2);
                LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
                String maLoaiThue = rs.getString(7);
                double tienDaCoc = rs.getDouble(8);
                String trangThai = rs.getString(9);
                tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong, ngayTraPhong,
                        maLoaiThue, tienDaCoc, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tt;
    }


	

//            // Kết nối CSDL
//            Connection con = ConnectDB.getInstance().getConnection();
//
//            // Tạo câu truy vấn SQL
//            String sql = "SELECT COUNT(*) AS SoLuongPhong " +
//                         "FROM ThongTinDatThuePhong " +
//                         "WHERE CAST(NgayNhanPhong AS DATE) <= ? " +
//                         "AND CAST(NgayTraPhong AS DATE) >= ?";
//
//            // Tạo PreparedStatement
//            PreparedStatement pstmt = con.prepareStatement(sql);
//
//            // Đặt các tham số cho câu truy vấn
//            pstmt.setTimestamp(1, Timestamp.valueOf(ngayNhanPhong));
//            pstmt.setTimestamp(2, Timestamp.valueOf(ngayNhanPhong));
//
//            // Thực thi câu truy vấn
//            ResultSet rs = pstmt.executeQuery();
//
//            // Đọc kết quả
//            if (rs.next()) {
//                soLuong = rs.getInt("SoLuongPhong");
//            }
//
//            // Đóng kết nối và tài nguyên
//            rs.close();
//            pstmt.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return soLuong;
//    }
public int demSoLuongPhongTheoThangNam(int thang, int nam) {
    int soLuong = 0;
    try {
        // Chuyển đổi tháng và năm thành LocalDate
        LocalDate ngayBatDau = LocalDate.of(nam, thang, 1);
        LocalDate ngayKetThuc = ngayBatDau.plusMonths(1).minusDays(1); // Lấy ngày cuối cùng của tháng

        // Kết nối CSDL
        Connection con = ConnectDB.getInstance().getConnection();

        // Tạo câu truy vấn SQL
        String sql = "SELECT COUNT(*) AS SoLuongPhong " +
                     "FROM ThongTinDatThuePhong " +
                     "WHERE CAST(NgayNhanPhong AS DATE) BETWEEN ? AND ? " +
                     "AND CAST(NgayTraPhong AS DATE) BETWEEN ? AND ?";

        // Tạo PreparedStatement
        PreparedStatement pstmt = con.prepareStatement(sql);

        // Đặt các tham số cho câu truy vấn
        pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau.atStartOfDay()));
        pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc.atTime(23, 59, 59)));
        pstmt.setTimestamp(3, Timestamp.valueOf(ngayBatDau.atStartOfDay()));
        pstmt.setTimestamp(4, Timestamp.valueOf(ngayKetThuc.atTime(23, 59, 59)));

        // Thực thi câu truy vấn
        ResultSet rs = pstmt.executeQuery();

        // Đọc kết quả
        if (rs.next()) {
            soLuong = rs.getInt("SoLuongPhong");
        }

        // Đóng kết nối và tài nguyên
        rs.close();
        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return soLuong;
}

	public int demSoLuongPhongTheoNam(int nam) {
    int soLuong = 0;
    try {
        // Chuyển đổi năm thành LocalDate
        LocalDate ngayBatDau = LocalDate.of(nam, 1, 1);
        LocalDate ngayKetThuc = ngayBatDau.plusYears(1).minusDays(1); // Lấy ngày cuối cùng của năm

        // Kết nối CSDL
        Connection con = ConnectDB.getInstance().getConnection();

        // Tạo câu truy vấn SQL
        String sql = "SELECT COUNT(*) AS SoLuongPhong " +
                     "FROM ThongTinDatThuePhong " +
                     "WHERE CAST(NgayNhanPhong AS DATE) BETWEEN ? AND ? " +
                     "AND CAST(NgayTraPhong AS DATE) BETWEEN ? AND ?";

        // Tạo PreparedStatement
        PreparedStatement pstmt = con.prepareStatement(sql);

        // Đặt các tham số cho câu truy vấn
        pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau.atStartOfDay()));
        pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc.atTime(23, 59, 59)));
        pstmt.setTimestamp(3, Timestamp.valueOf(ngayBatDau.atStartOfDay()));
        pstmt.setTimestamp(4, Timestamp.valueOf(ngayKetThuc.atTime(23, 59, 59)));

        // Thực thi câu truy vấn
        ResultSet rs = pstmt.executeQuery();

        // Đọc kết quả
        if (rs.next()) {
            soLuong = rs.getInt("SoLuongPhong");
        }

        // Đóng kết nối và tài nguyên
        rs.close();
        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return soLuong;
}

}
