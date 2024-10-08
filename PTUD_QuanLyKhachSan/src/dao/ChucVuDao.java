package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import connectDB.ConnectDB;
import entity.ChucVu;

public class ChucVuDao {
	ChucVu chucVu;
	
	public ChucVuDao() {
		chucVu = new ChucVu();
	}
	
	// Lấy dữ liệu chức vụ từ database theo mã chức vụ
	public ChucVu getChucVu(String maChucVu) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ChucVu where maChucVu = '" + maChucVu + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maChucVu1 = rs.getString(1);
				String tenChucVu = rs.getString(2);
				double luongCoBan = rs.getDouble(3);
				double heSoLuong = rs.getDouble(4);
				chucVu = new ChucVu(maChucVu1, tenChucVu, luongCoBan, heSoLuong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chucVu;
	}
}
