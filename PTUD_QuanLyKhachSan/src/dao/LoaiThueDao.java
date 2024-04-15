package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectDB.ConnectDB;
import entity.LoaiThue;

public class LoaiThueDao {
	LoaiThue loaiThue;
	
	public LoaiThueDao() {
		loaiThue = new LoaiThue();
	}
	
	public String timMaLoaiThue(String kieuThue, String maLoaiPhong) {
		String maLoaiThue = "";
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con
					.prepareStatement("select maLoaiThue from LoaiThue where kieuThue = ? and maLoaiPhong = ?");
			stmt.setString(1, kieuThue);
			stmt.setString(2, maLoaiPhong);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				 maLoaiThue = rs.getString("MaLoaiThue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maLoaiThue;
	}
	
	public double timGiaCocTheoMaThue(String maThue) {
		double tienCoc = 0;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stmt = con.prepareStatement("select giaCocToiThieu from LoaiThue where maLoaiThue = ?");
            stmt.setString(1, maThue);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tienCoc = rs.getDouble("giaCocToiThieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienCoc;
	}
}
