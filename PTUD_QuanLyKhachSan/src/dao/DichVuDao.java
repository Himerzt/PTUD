package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;

public class DichVuDao {
	ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
	DichVu dv = new DichVu();

	public DichVuDao() {
		dsDichVu = new ArrayList<DichVu>();
		dv = new DichVu();

	}

	public ArrayList<DichVu> timTatCaDichVu() {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV = rs.getString(1);
				String tenDV = rs.getString(2);
				double giaDV = rs.getDouble(3);
				dv = new DichVu(maDV, tenDV, giaDV);
				dsDichVu.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsDichVu;
	}

	public DichVu timTheoMaDichVu(String maDV) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu where maDV = '" + maDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV1 = rs.getString(1);
				String tenDV = rs.getString(2);
				double giaDV = rs.getDouble(3);
				dv = new DichVu(maDV1, tenDV, giaDV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dv;
	}

	// thêm dịch vụ
	public boolean themDichVu(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsDichVu.contains(dv)) {
			try {
				stmt = con.createStatement();
				String sql = "insert into DichVu values('" + dv.getMaDV() + "','" + dv.getTenDV() + "'," + dv.getGiaDV()
						+ ")";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// sửa dịch vụ
	public boolean suaDichVu(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsDichVu.contains(dv)) {
			try {
				stmt = con.createStatement();
				String sql = "update DichVu set tenDV = '" + dv.getTenDV() + "', giaDV = " + dv.getGiaDV()
						+ " where maDV = '" + dv.getMaDV() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// xóa dịch vụ
	public boolean xoaDichVu(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsDichVu.contains(dv)) {
			try {
				stmt = con.createStatement();
				String sql = "delete from DichVu where maDV = '" + dv.getMaDV() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// tìm kiếm dịch vụ theo tên
	public ArrayList<DichVu> timDichVuTheoTen(String tenDV) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu where tenDV like '%" + tenDV + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV = rs.getString(1);
				String tenDV1 = rs.getString(2);
				double giaDV = rs.getDouble(3);
				dv = new DichVu(maDV, tenDV1, giaDV);
				dsDichVu.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsDichVu;
	}

	// tìm kiếm dịch vụ theo giá
	public ArrayList<DichVu> timDichVuTheoGia(double giaDV) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu where giaDV = " + giaDV;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV = rs.getString(1);
				String tenDV = rs.getString(2);
				double giaDV1 = rs.getDouble(3);
				dv = new DichVu(maDV, tenDV, giaDV1);
				dsDichVu.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsDichVu;
	}

}
