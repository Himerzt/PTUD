package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HangThanhVien;
import entity.LoaiPhong;
import entity.Phong;

public class PhongDao {

	ArrayList<Phong> dsPhong = new ArrayList<Phong>();
	Phong phong;

	public PhongDao() {
		dsPhong = new ArrayList<Phong>();
		phong = new Phong();
	}

	public ArrayList<Phong> timTatCaPhong() {
		try (Connection con = ConnectDB.getInstance().getConnection()) {
			String sql = "Select * from Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString(1);
				int soPhong = rs.getInt(2);
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(3));

				String trangThaiPhong = rs.getString(4);

				Phong phong = new Phong(maPhong, soPhong, loaiPhong, trangThaiPhong);
				dsPhong.add(phong);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dsPhong;
	}

	// thêm phòng
	public boolean themPhong(Phong phong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		if (dsPhong.contains(phong)) {
			try {
				stmt = ((Connection) con).prepareStatement("insert into Phong values(?,?,?,?)");
				stmt.setString(1, phong.getMaPhong());
				stmt.setInt(2, phong.getSoPhong());
				stmt.setString(3, phong.getLoaiPhong().getMaLoaiPhong());
				stmt.setString(4, phong.getTrangThai());
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;

	}

	// sửa phòng
	public boolean suaPhong(Phong phong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		if (dsPhong.contains(phong)) {
			try {
				stmt = ((Connection) con).prepareStatement(
						"update Phong set soPhong = ?, maLoaiPhong = ?, trangThai = ? where maPhong = ?");
				stmt.setInt(1, phong.getSoPhong());
				stmt.setString(2, phong.getLoaiPhong().getMaLoaiPhong());
				stmt.setString(3, phong.getTrangThai());
				stmt.setString(4, phong.getMaPhong());
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// xóa phòng
	public boolean xoaPhong(String maPhong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = ((Connection) con).prepareStatement("delete from Phong where maPhong = ?");
			stmt.setString(1, maPhong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// tìm phòng theo mã phòng
	public Phong timPhongTheoMaPhong(String maPhong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ((Connection) con).prepareStatement("select * from Phong where maPhong = ?");
			stmt.setString(1, maPhong);
			rs = stmt.executeQuery();
			if (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(3));
				phong = new Phong(rs.getString(1), rs.getInt(2), loaiPhong, rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phong;
	}

	// tìm phòng theo số phòng
	public Phong timPhongTheoSoPhong(int soPhong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ((Connection) con).prepareStatement("select * from Phong where soPhong = ?");
			stmt.setInt(1, soPhong);
			rs = stmt.executeQuery();
			if (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(3));
				phong = new Phong(rs.getString(1), rs.getInt(2), loaiPhong, rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phong;
	}

	// tìm phòng theo loại phòng
	public ArrayList<Phong> timPhongTheoLoaiPhong(String maLoaiPhong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			stmt = ((Connection) con).prepareStatement("select * from Phong where maLoaiPhong = ?");
			stmt.setString(1, maLoaiPhong);
			rs = stmt.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(3));
				phong = new Phong(rs.getString(1), rs.getInt(2), loaiPhong, rs.getString(4));
				dsPhong.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	// tìm phòng theo trạng thái
	public ArrayList<Phong> timPhongTheoTrangThai(String trangThai) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			stmt = ((Connection) con).prepareStatement("select * from Phong where trangThai = ?");
			stmt.setString(1, trangThai);
			rs = stmt.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(3));
				phong = new Phong(rs.getString(1), rs.getInt(2), loaiPhong, rs.getString(4));
				dsPhong.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}
	// tìm phòng theo loại phòng, trạng thái và số lượng
	public ArrayList<Phong> timPhongTheoLoaiPhongTrangThaiSoLuong(String maLoaiPhong, String trangThai, int soLuongPhong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			stmt = ((Connection) con)
					.prepareStatement("select * from Phong where maLoaiPhong = ? and trangThai = ? limit ?");
			stmt.setString(1, maLoaiPhong);
			stmt.setString(2, trangThai);
			stmt.setInt(3, soLuongPhong);
			rs = stmt.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(3));
				phong = new Phong(rs.getString(1), rs.getInt(2), loaiPhong, rs.getString(4));
				dsPhong.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}
	public int size() {
		return dsPhong.size();
	}

	
	
}
