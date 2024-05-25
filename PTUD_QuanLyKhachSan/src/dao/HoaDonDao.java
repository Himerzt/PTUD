package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

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
				String maHoaDon = rs.getString(1);
				String nhanVien = rs.getString(2);
				String khachHang = rs.getString(3);
				LocalDate ngayLap = rs.getDate(4).toLocalDate();
				
				hoaDon = new HoaDon(maHoaDon, nhanVien, khachHang, ngayLap);
				
				dsHoaDon.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}

	// thêm hóa đơn
	public boolean themHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			// Kiểm tra xem hóa đơn có tồn tại trong CSDL không
			String sqlCheck = "SELECT COUNT(*) FROM HoaDon WHERE MaHD = '" + hoaDon.getMaHoaDon() + "'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlCheck);
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			stmt.close();

			// Nếu hóa đơn không tồn tại, thực hiện thêm mới
			if (count == 0) {
				stmt = con.createStatement();
				// Thêm hóa đơn vào CSDL với VAT = 0.1
				String sqlInsert = "INSERT INTO HoaDon VALUES ('" + hoaDon.getMaHoaDon() + "', '"
						+ hoaDon.getMaNhanVien() + "', '" + hoaDon.getMaKhachHang() + "', '" + hoaDon.getNgayLap()
						+ "' , '" + hoaDon.getVAT() + "' )";
				n = stmt.executeUpdate(sqlInsert);				
				stmt.close();
				return n > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	 public boolean themDichVu(DichVu dv) {
//         ConnectDB.getInstance();
//         Connection con = ConnectDB.getConnection();
//         Statement stmt = null;
//         int n = 0;
//         try {
//             // Kiểm tra xem dịch vụ có tồn tại trong CSDL không
//             String sqlCheck = "SELECT COUNT(*) FROM DichVu WHERE maDV = '" + dv.getMaDV() + "'";
//             stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sqlCheck);
//             rs.next();
//             int count = rs.getInt(1);
//             rs.close();
//             stmt.close();
//
//             // Nếu dịch vụ không tồn tại, thực hiện thêm mới
//             if (count == 0) {
//                 stmt = con.createStatement();
//                 String sqlInsert = "INSERT INTO DichVu VALUES ('" + dv.getMaDV() + "', N'" + dv.getTenDV() + "', " + dv.getGiaDV() + ")";
//                 n = stmt.executeUpdate(sqlInsert);
//                 stmt.close();
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return n > 0;
//     }

	// sửa hóa đơn
	public boolean suaHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsHoaDon.contains(hoaDon)) {
			try {
				stmt = con.createStatement();
				String sql = "update HoaDon set nhanVien = '" + hoaDon.getMaNhanVien() + "', ngayLap = '"
						+ hoaDon.getNgayLap() + "', khachHang = '" + hoaDon.getMaKhachHang()
						+ "' where maHoaDon = '" + hoaDon.getMaHoaDon() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// xóa hóa đơn
	public boolean xoaHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsHoaDon.contains(hoaDon)) {
			try {
				stmt = con.createStatement();
				String sql = "delete from HoaDon where maHoaDon = '" + hoaDon.getMaHoaDon() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// tìm hóa đơn theo mã
	public HoaDon timHoaDonTheoMa(String maHoaDon) {
		HoaDon hd = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where maHoaDon = '" + maHoaDon + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);

				NhanVien nv = new NhanVien(nhanVien);
				KhachHang kh = new KhachHang(khachHang);

				hd = new HoaDon(maHoaDon, nhanVien, khachHang, ngayLap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}

	// tìm hóa đơn theo mã nhân viên
	public ArrayList<HoaDon> timHoaDonTheoMaNhanVien(String maNhanVien) {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where nhanVien = '" + maNhanVien + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);
				
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLap);
				
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    return dsHoaDon;}
	// tìm hóa đơn theo mã khách hàng
	public ArrayList<HoaDon> timHoaDonTheoMaKhachHang(String maKhachHang) {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where khachHang = '" + maKhachHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);
				
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLap);
				
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}
	// tìm hóa đơn theo ngày lập
	public ArrayList<HoaDon> timHoaDonTheoNgayLap(LocalDate ngayLap) {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where ngayLap = '" + ngayLap + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap1 = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);

				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLap1);
				
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}
	
	
	public static void main(String[] args) {
		// test tìm tất cả hóa đơn
		HoaDonDao hoaDonDao = new HoaDonDao();
		
		// test thêm hóa đơn
		HoaDon hd = new HoaDon("HD029", "NV001", "KH004", LocalDate.now());
		boolean kq = hoaDonDao.themHoaDon(hd);
		if (kq) {
			System.out.println("Thêm thành công");
		} else {
			System.out.println("Thêm thất bại");
		}
		
		ArrayList<HoaDon> dsHoaDon = hoaDonDao.timTatCaHoaDon();
		for (HoaDon hdz : dsHoaDon) {
			System.out.println(hdz);
		}
	}
}
