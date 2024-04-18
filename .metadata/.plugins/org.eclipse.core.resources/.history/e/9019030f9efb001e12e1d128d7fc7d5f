package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.HangThanhVien;

public class HangThanhVienDao {
	HangThanhVien hangThanhVien;
	
	public HangThanhVienDao() {
		hangThanhVien = new HangThanhVien();
	}
	
	// Tìm hạng thành viên theo mã hạng trong database
	public HangThanhVien timHangThanhVienTheoMa(String maHang) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HangThanhVien where maHang = '" + maHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHang1 = rs.getString(1);
				String tenHang = rs.getString(2);
				double tiLeChietKhau = rs.getDouble(3);
				hangThanhVien = new HangThanhVien(maHang1, tenHang, tiLeChietKhau);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HangThanhVien timHangThanhVienTheoChiTieu(double chiTieu) {
		if (chiTieu >= 0d) {
			return timHangThanhVienTheoMa("HB");
		} else if (chiTieu >= 3000000d) {
			return timHangThanhVienTheoMa("HV");
		} else if (chiTieu >= 5000000d) {
			return timHangThanhVienTheoMa("BK");
		} else if (chiTieu >= 10000000d) {
			return timHangThanhVienTheoMa("LB");
		} else {
			return timHangThanhVienTheoMa("KC");
		}
	}
}
