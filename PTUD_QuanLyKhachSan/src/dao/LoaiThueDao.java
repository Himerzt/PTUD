package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public LoaiThue timLoaiThueTheoTenLoaiThueVaMaLoaiPhong(String tenLoaiThue, String maLoaiPhong) {
		try (Connection con = ConnectDB.getInstance().getConnection()) {
			String sql = "Select * from LoaiThue where kieuThue like '%" + tenLoaiThue + "%' and maLoaiPhong = '"
					+ maLoaiPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoaiThue = rs.getString(1);
				String tenLoaiThue1 = rs.getString(2);
				double giaThue = rs.getDouble(3);
				String maLoaiPhong1 = rs.getString(5);
				double giaCocToiThieu = rs.getDouble(4);
				loaiThue = new LoaiThue(maLoaiThue, tenLoaiThue1, giaThue, giaCocToiThieu, maLoaiPhong1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loaiThue;
	}
}
