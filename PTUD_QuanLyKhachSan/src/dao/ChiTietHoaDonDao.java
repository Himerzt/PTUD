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

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class ChiTietHoaDonDao {
	
	ArrayList<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
	ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
	
	// Tìm tât cả chi tiết hóa đơn
	public ArrayList<ChiTietHoaDon> timTatCaChiTietHoaDon() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from ChiTietHoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maChiTietHoaDon = rs.getString(1);
				String maHoaDon = rs.getString(2);
				String maTTDTP = rs.getString(3);
				
				chiTietHoaDon = new ChiTietHoaDon(maChiTietHoaDon, maHoaDon, maTTDTP);
				

				dsChiTietHoaDon.add(chiTietHoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsChiTietHoaDon;
	}
	
	// Thêm chi tiết hóa đơn
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		try {
			// Kiểm tra xem chi tiết hóa đơn có tồn tại trong CSDL không
			String sqlCheck = "SELECT COUNT(*) FROM ChiTietHoaDon WHERE MaCTHD = '"
					+ chiTietHoaDon.getMaCTHD()+ "'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlCheck);
			rs.next();
			if (rs.getInt(1) == 0) {
				String sql = "INSERT INTO ChiTietHoaDon VALUES('" + chiTietHoaDon.getMaCTHD() + "', '"
						+ chiTietHoaDon.getMaHD() + "', '" + chiTietHoaDon.getMaTTDTP() + "')";
				stmt = con.createStatement();
				n = stmt.executeUpdate(sql);
				return n > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	// đếm tổng sô chi tiết hóa đơn trong ngày
	public int demTongSoChiTietHoaDonTrongNgay(LocalDate date) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int soLuong = 0;
		try {
//			SELECT * FROM HoaDon hd JOIN ChiTietHoaDon chd 
//			ON hd.MaHD = chd.MaHD
//			WHERE NgayLapHD
			String sql = "SELECT COUNT(*) FROM HoaDon hd JOIN ChiTietHoaDon chd ON hd.MaHD = chd.MaHD WHERE NgayLapHD >= ? AND NgayLapHD < ? ";
			pstmt = con.prepareStatement(sql);
			LocalDateTime ngayBatDau = date.atStartOfDay();
			LocalDateTime ngayKetThuc = date.plusDays(1).atStartOfDay();
			pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau));
			pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc));
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			soLuong = rs.getInt(1);
			rs.close();
			pstmt.close();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soLuong;
	}
}
