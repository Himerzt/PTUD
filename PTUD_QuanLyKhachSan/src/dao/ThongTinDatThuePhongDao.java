package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
	
	public int demSoThongTinDatThuePhong() {
		return dsThongTin.size();
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

	            ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maDatPhong, maKhachHang1, maPhong, ngayDatPhong,
	                    ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
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
			LocalDateTime ngayNhanPhong, LocalDateTime ngayTraPhong, String maLoaiThue, double tienDaCoc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		for (Phong phong2 : phong) {
			try {
				String maDP = String.format("%s%3s", "TTDTP", (demSoThongTinDatThuePhong() + 1));
				stmt = con.createStatement();
				String sql = "insert into ThongTinDatThuePhong values('" + (maDP) + "', '" + kh.getMaKH() + "', '"
						+ phong2.getMaPhong() + "', '" + ngayDatPhong + "', '" + ngayNhanPhong + "', '" + ngayTraPhong
						+ "','" + maLoaiThue + "','" + tienDaCoc + "')";
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
			LocalDateTime ngayNhanPhong, String maLoaiThue, LocalDateTime ngayTraPhong, double tienDaCoc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		for (Phong phong2 : phong) {
			try {
				// Mã đặt phòng là TTDTP + số thứ tự của mã đặt phòng trong danh sách
				String maDP = String.format("%s%s", "TTDTP", (demSoThongTinDatThuePhong() + 1));
				stmt = con.createStatement();
				// Thêm thông tin thuê phòng
				String sql = "insert into ThongTinDatThuePhong values('" + (maDP) + "', '" + kh.getMaKH() + "', '"
						+ phong2.getMaPhong() + "', '" + ngayDatPhong + "', '" + ngayNhanPhong + "', '" + ngayTraPhong
						+ "','" + maLoaiThue + "','" + tienDaCoc + "')";
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
				LocalDateTime ngayDatPhong = rs.getTimestamp(4).toLocalDateTime();
				LocalDateTime ngayNhanPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayTraPhong = rs.getTimestamp(6).toLocalDateTime();
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
				ThongTinDatThuePhong tt = new ThongTinDatThuePhong(maTTDTP, maKhachHang, phong, ngayDatPhong,
						ngayNhanPhong, ngayTraPhong, maLoaiThue, tienDaCoc);
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
				dsThongTin.add(new ThongTinDatThuePhong(maTTDTP, maKhachHang, maPhong, ngayDatPhong, ngayNhanPhong,
						ngayTraPhong, maLoaiThue, tienDaCoc));
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
