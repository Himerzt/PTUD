package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.LoaiPhong;

public class LoaiPhongDao {
	private LoaiPhong loaiPhong;
	
	public LoaiPhongDao() {
		loaiPhong = new LoaiPhong();
	}
	
	/**
	 * Tìm theo mã loại phòng
	 */
	public LoaiPhong timTheoMaLoaiPhong(String maLoaiPhong) {
		try {
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from LoaiPhong where maLoaiPhong = '" + maLoaiPhong + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maLoaiPhong1 = rs.getString(1);
                String tenLoaiPhong = rs.getString(2);
                double giaCocToiThieu = rs.getDouble(3);
                double giaThue = rs.getDouble(4);
                int soGiuong = rs.getInt(5);
                int soNguoiToiDa = rs.getInt(6);
                loaiPhong = new LoaiPhong(maLoaiPhong1, tenLoaiPhong, giaCocToiThieu, giaThue, soGiuong, soNguoiToiDa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiPhong;
	}
}
