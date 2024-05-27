package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import connectDB.ConnectDB;
import entity.DichVu;
import entity.DichVuPhong;
import entity.HoaDon;

public class HoaDonDao {
	ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
	HoaDon hoaDon = new HoaDon();

	public HoaDonDao() {
		dsHoaDon = new ArrayList<HoaDon>();
		hoaDon = new HoaDon();
	}

	// tìm tất cả hóa đơn
	public ArrayList<HoaDon> timTatCaHoaDon() {
		try {
			// code here
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				String khachHang = rs.getString(3);
				LocalDateTime ngayLap = rs.getTimestamp(4).toLocalDateTime();
				String maLSDP = rs.getString(5);
				String maKM = rs.getString(6);
				double tongTien = rs.getDouble(7);
				HoaDon hoaDon = new HoaDon(maHD, nhanVien, khachHang, ngayLap, maLSDP, maKM, tongTien);
				dsHoaDon.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}

// Tìm danh sách hóa đơn với các thông tin như Mã hóa đơn, Tên khách hàng, Ngày lập hóa đơn, Tổng tiền
	public List<Object[]> timDanhSachHoaDon() {
		List<Object[]> danhSachHoaDon = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "SELECT HoaDon.MaHD, KhachHang.TenKhachHang, HoaDon.NgayLapHD, HoaDon.TongTien "
					+ "FROM HoaDon " + "INNER JOIN KhachHang ON HoaDon.MaKH = KhachHang.MaKH";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString(1);
				String tenKH = rs.getString(2);
				LocalDateTime ngayLap = rs.getTimestamp(3).toLocalDateTime();
				double tongTien = rs.getDouble(4);

				Object[] hoaDonInfo = { maHD, tenKH, ngayLap, tongTien };
				danhSachHoaDon.add(hoaDonInfo);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhSachHoaDon;
	}

	// Tìm hóa đơn trong ngày
	public List<HoaDon> timHoaDonTrongNgay(LocalDate ngay) {
		List<HoaDon> danhSachHoaDon = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "SELECT * FROM HoaDon WHERE NgayLapHD >= ? AND NgayLapHD < ?";
			pstmt = con.prepareStatement(sql);

			LocalDateTime ngayBatDau = ngay.atStartOfDay();
			LocalDateTime ngayKetThuc = ngay.plusDays(1).atStartOfDay();

			pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau));
			pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc));

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(rs.getString("MaHD"));
				hoaDon.setMaNhanVien(rs.getString("MaNV"));
				hoaDon.setMaKhachHang(rs.getString("MaKH"));
				hoaDon.setNgayLap(rs.getTimestamp("NgayLapHD").toLocalDateTime());
				hoaDon.setMaLSDP(rs.getString("MaLSDP"));
				hoaDon.setMaKM(rs.getString("MaKM"));
				hoaDon.setTongTien(rs.getDouble("TongTien"));
				danhSachHoaDon.add(hoaDon);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhSachHoaDon;
	}

	// Thêm hóa đơn
	public boolean themHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			String sqlCheck = "SELECT COUNT(*) FROM HoaDon WHERE MaHD = ?";
			pstmt = con.prepareStatement(sqlCheck);
			pstmt.setString(1, hoaDon.getMaHoaDon());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			pstmt.close();
			// Nếu hóa đơn không tồn tại, thực hiện thêm mới
			if (count == 0) {
				// Xử lý ngày lập
				Timestamp ngayLapHD = Timestamp.valueOf(hoaDon.getNgayLap());
				// Thêm hóa đơn vào CSDL
				String sqlInsert1 = "INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM , TongTien, ThueVAT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sqlInsert1);
				pstmt.setString(1, hoaDon.getMaHoaDon());
				pstmt.setString(2, hoaDon.getMaNhanVien());
				pstmt.setString(3, hoaDon.getMaKhachHang());
				pstmt.setTimestamp(4, ngayLapHD);
				pstmt.setString(5, hoaDon.getMaLSDP());
				pstmt.setString(6, hoaDon.getMaKM());
				pstmt.setDouble(7, hoaDon.getTongTien());
				pstmt.setDouble(8, hoaDon.getVAT());
				n = pstmt.executeUpdate();
				pstmt.close();
				return n > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Xóa hóa đơn
	public boolean xoaHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hoaDon.getMaHoaDon());
			n = pstmt.executeUpdate();
			pstmt.close();
			return n > 0;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

//	// Tìm hóa đơn theo mã nhân viên
//	public List<HoaDon> timHoaDonTheoMaNhanVien(String maNhanVien) {
//		List<HoaDon> dsHoaDon = new ArrayList<>();
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			String sql = "SELECT * FROM HoaDon WHERE MaNV = ?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, maNhanVien);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				String maHD = rs.getString("MaHD");
//				String maNV = rs.getString("MaNV");
//				String maKH = rs.getString("MaKH");
//				LocalDateTime ngayLap = rs.getTimestamp("NgayLapHD").toLocalDateTime();
//				double tongTien = rs.getDouble("TongTien");
//				double thueVAT = rs.getDouble("ThueVAT");
//
//				HoaDon hoaDon = new HoaDon(maHD, maNV, maKH, ngayLap);
//				dsHoaDon.add(hoaDon);
//			}
//			rs.close();
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsHoaDon;
//	}

	// Tìm hóa đơn theo mã khách hàng
//	public List<HoaDon> timHoaDonTheoMaKhachHang(String maKhachHang) {
//		List<HoaDon> dsHoaDon = new ArrayList<>();
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			String sql = "SELECT * FROM HoaDon WHERE MaKH = ?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, maKhachHang);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				String maHD = rs.getString("MaHD");
//				String maNV = rs.getString("MaNV");
//				String maKH = rs.getString("MaKH");
//				LocalDateTime ngayLap = rs.getTimestamp("NgayLapHD").toLocalDateTime();
//				double tongTien = rs.getDouble("TongTien");
//				double thueVAT = rs.getDouble("ThueVAT");
//
//				HoaDon hoaDon = new HoaDon(maHD, maNV, maKH, ngayLap);
//				dsHoaDon.add(hoaDon);
//			}
//			rs.close();
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsHoaDon;
//	}

	// Tìm hóa đơn theo ngày lập
//	public List<HoaDon> timHoaDonTheoNgayLap(LocalDate ngayLap) {
//		List<HoaDon> dsHoaDon = new ArrayList<>();
//		try {
//			Connection con = ConnectDB.getInstance().getConnection();
//			String sql = "SELECT * FROM HoaDon WHERE NgayLapHD = ?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setTimestamp(1, Timestamp.valueOf(ngayLap.atStartOfDay()));
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				String maHD = rs.getString("MaHD");
//				String maNV = rs.getString("MaNV");
//				String maKH = rs.getString("MaKH");
//				LocalDateTime ngayLapHD = rs.getTimestamp("NgayLapHD").toLocalDateTime();
//				double tongTien = rs.getDouble("TongTien");
//				double thueVAT = rs.getDouble("ThueVAT");
//
//				HoaDon hoaDon = new HoaDon(maHD, maNV, maKH, ngayLapHD);
//				dsHoaDon.add(hoaDon);
//			}
//			rs.close();
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsHoaDon;
//	}

	// Lấy tên khách hàng từ mã khách hàng trong hóa đơn SELECT k.TenKhachHang FROM
	// HoaDon hd JOIN KhachHang k
//	ON hd.MaKH = k.MaKH WHERE hd.MaHD = 'HD26052024005'
	public String layTenKhachHangTuMaHoaDon(String maHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		String tenKhachHang = "";
		ResultSet rs = null;
		try {
			String sql = "SELECT k.TenKhachHang FROM HoaDon hd JOIN KhachHang k ON hd.MaKH = k.MaKH WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tenKhachHang = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tenKhachHang;
	}

	// Xử lý ngày đặt ngày nhân và ngày trả phòng
	public ArrayList<String> layNgayDatNhanTratuMaHoaDon(String maHoaDon) {
		ArrayList<String> dsngayDatNhanTra = new ArrayList<String>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT tt.NgayDatPhong, tt.NgayNhanPhong , tt.NgayTraPhong FROM HoaDon hd JOIN ChiTietHoaDon cthd ON hd.MaHD = cthd.MaHD JOIN ThongTinDatThuePhong tt ON cthd.MaTTDTP = tt.MaTTDTP WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dsngayDatNhanTra.add(rs.getString(1));
				dsngayDatNhanTra.add(rs.getString(2));
				dsngayDatNhanTra.add(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsngayDatNhanTra;
	}

	public ArrayList<DichVuPhong> layDichPhongSuDung(String maHoaDon) {
		ArrayList<DichVuPhong> dsDichVuPhong = new ArrayList<DichVuPhong>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT dvsd.MaDichVu , dvsd.MaDichVuSuDung , dvsd.MaPhong , dvsd.SoLuong FROM HoaDon hd JOIN ChiTietHoaDon chd ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt ON chd.MaTTDTP = tt.MaTTDTP JOIN DichVuSuDung dvsd ON tt.MaPhong = dvsd.MaPhong WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DichVuPhong dv = new DichVuPhong();
				dv.setMaDichVu(rs.getString(1));
				dv.setMaDichVuSuDung(rs.getString(2));
				dv.setMaPhong(rs.getString(3));
				dv.setSoLuong(rs.getInt(4));
				dsDichVuPhong.add(dv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDichVuPhong;

	}

	// Xử lý lấy danh sách mã phòng đã đặt ArrayList<String> dsMaPhong =
	// hoaDonDao.layMaPhongDaDat("HD27052024001");
//	SELECT tt.MaPhong FROM HoaDon hd JOIN ChiTietHoaDon chd 
//	ON hd.MaHD = chd.MaHD
//	JOIN ThongTinDatThuePhong tt
//	ON chd.MaTTDTP = tt.MaTTDTP
//	WHERE hd.MaHD = 'HD27052024001'
	public ArrayList<String> layMaPhongDaDat(String maHoaDon) {
		ArrayList<String> dsMaPhong = new ArrayList<String>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT tt.MaPhong FROM HoaDon hd JOIN ChiTietHoaDon chd ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt ON chd.MaTTDTP = tt.MaTTDTP WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dsMaPhong.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsMaPhong;
	}

	public int demSoHoaDonTrongNgay(LocalDate ngay) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		int soLuong = 0;
		try {
			String sql = "SELECT COUNT(*) FROM HoaDon WHERE NgayLapHD >= ? AND NgayLapHD < ?";
			pstmt = con.prepareStatement(sql);

			LocalDateTime ngayBatDau = ngay.atStartOfDay();
			LocalDateTime ngayKetThuc = ngay.plusDays(1).atStartOfDay();

			pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau));
			pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc));

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			soLuong = rs.getInt(1);

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return soLuong;
	}
	
	//Tìm tên nhân viên từ mã hóa đơn
//	SELECT nv.HoTenNV FROM HoaDon hd JOIN NhanVien nv 
//	ON hd.MaNV = nv.MaNV
//	WHERE MaHD = 'HD27052024001'
	public String layTenNhanVienTuMaHoaDon(String maHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		String tenNV = "";
		ResultSet rs = null;
		try {
			String sql = "SELECT nv.HoTenNV FROM HoaDon hd JOIN NhanVien nv ON hd.MaNV = nv.MaNV WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tenNV = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tenNV;
	}
	
	// Lấy tiền cọc 
//	SELECT tt.TienDaCoc  FROM HoaDon hd JOIN ChiTietHoaDon chd
//	ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt
//	ON tt.MaTTDTP = chd.MaTTDTP 
//	WHERE hd.MaHD = 'HD27052024001'
	public double layTienCoc(String maHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		double tienCoc = 0;
		ResultSet rs = null;
		try {
			String sql = "SELECT tt.TienDaCoc FROM HoaDon hd JOIN ChiTietHoaDon chd ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt ON tt.MaTTDTP = chd.MaTTDTP WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tienCoc = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tienCoc;
	}

	public static void main(String[] args) {
		// ttesst tìm tên khách hàng với mã hóa đon HD26052024005
		HoaDonDao hoaDonDao = new HoaDonDao();
		String tenKhachHang = hoaDonDao.layTenNhanVienTuMaHoaDon("HD27052024001");
		System.out.println(tenKhachHang);
//		ArrayList<String> dsNgayDaatNhanTra = hoaDonDao.layNgayDatNhanTratuMaHoaDon("HD27052024001");
//		System.out.println(dsNgayDaatNhanTra);
//		System.out.println(tenKhachHang);
//		// test tìm dịch vụ
//		ArrayList<DichVuPhong> dsDichVuPhong = hoaDonDao.layDichPhongSuDung("HD27052024001");
//		for (DichVuPhong dichVuPhong : dsDichVuPhong) {
//			System.out.println(dichVuPhong.getMaDichVu() + " " + dichVuPhong.getMaDichVuSuDung() + " "
//					+ dichVuPhong.getMaPhong() + " " + dichVuPhong.getSoLuong());
//		}
//		// Tesst tìm mã phòng đã đặt
//		ArrayList<String> dsMaPhong = hoaDonDao.layMaPhongDaDat("HD27052024001");
//		System.out.println(dsMaPhong);

	}

}
