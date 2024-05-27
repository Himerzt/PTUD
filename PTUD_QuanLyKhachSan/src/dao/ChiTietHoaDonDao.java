package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
				String maLSDP = rs.getString(4);
			    String maKhuyenMai = rs.getString(5);
			    
			    chiTietHoaDon = new ChiTietHoaDon(maChiTietHoaDon, maHoaDon, maTTDTP, maLSDP, maKhuyenMai);

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
						+ chiTietHoaDon.getMaHD() + "', '" + chiTietHoaDon.getMaTTDTP() + "', '"
						+ chiTietHoaDon.getMaLSDP() + "', '" + chiTietHoaDon.getMaKM() + "')";
				stmt = con.createStatement();
				n = stmt.executeUpdate(sql);
				return n > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	
	public static void main(String[] args) {
		// Test themChiTietHoaDon
		ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon("CTHD001", "HD001", "TTDTP001", "LSDP001", "KM001");
		System.out.println(chiTietHoaDonDao.themChiTietHoaDon(chiTietHoaDon));
	}
}
