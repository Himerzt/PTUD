package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhuyenMai;

public class KhuyenMaiDao {

	ArrayList<KhuyenMai> dsKhuyenMai = new ArrayList<KhuyenMai>();
	KhuyenMai khuyenMai;
  public KhuyenMaiDao() {
	  dsKhuyenMai = new ArrayList<KhuyenMai>();
	  khuyenMai = new KhuyenMai();
	  
  }
	
  // tìm tất cả khuyến mãi
	public ArrayList<KhuyenMai> timTatCaKhuyenMai() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhuyenMai";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				double giaTriKhuyenMai = rs.getDouble(3);
				LocalDate thoiGianBatDau = rs.getDate(4).toLocalDate();
				LocalDate thoiGianKetThuc = rs.getDate(5).toLocalDate();
				double dieuKienApDung = rs.getDouble(6);
				khuyenMai = new KhuyenMai(maKM, tenKM, giaTriKhuyenMai, thoiGianBatDau, thoiGianKetThuc, dieuKienApDung);
				
				dsKhuyenMai.add(khuyenMai);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsKhuyenMai;
	}
	
	// thêm khuyến mãi
	public boolean themKhuyenMai(KhuyenMai khuyenMai) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        int n = 0;
        if(dsKhuyenMai.contains(khuyenMai)) {
            try {
                stmt = con.createStatement();
                String sql = "insert into KhuyenMai values('"+khuyenMai.getMaKM()+"','"+khuyenMai.getTenKM()+"',"+khuyenMai.getGiaTriKM()+",'"+khuyenMai.getThoiGianBatDau()+"','"+khuyenMai.getThoiGianKetThuc()+"',"+khuyenMai.getDieuKienApDung()+")";
                n = stmt.executeUpdate(sql);
            } catch (SQLException e) {
            	e.printStackTrace();
            }
            
            return n>0;
            
        }
        return false;
            }
	
	// sửa khuyến mãi
	public boolean suaKhuyenMai(KhuyenMai khuyenMai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsKhuyenMai.contains(khuyenMai)) {
			try {
				stmt = con.createStatement();
				String sql = "update KhuyenMai set tenKM = '" + khuyenMai.getTenKM() + "', giaTriKM = "
						+ khuyenMai.getGiaTriKM() + ", thoiGianBatDau = '" + khuyenMai.getThoiGianBatDau()
						+ "', thoiGianKetThuc = '" + khuyenMai.getThoiGianKetThuc() + "', dieuKienApDung = "
						+ khuyenMai.getDieuKienApDung() + " where maKM = '" + khuyenMai.getMaKM() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return n > 0;

		}
		return false;
	}
	
	// xóa khuyến mãi
	public boolean xoaKhuyenMai(KhuyenMai khuyenMai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsKhuyenMai.contains(khuyenMai)) {
			try {
				stmt = con.createStatement();
				String sql = "delete from KhuyenMai where maKM = '" + khuyenMai.getMaKM() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return n > 0;

		}
		return false;
	}
	
	// tìm khuyến mãi theo mã khuyến mãi
	public KhuyenMai timKhuyenMaiTheoMa(String maKM) {
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from KhuyenMai where maKM = '" + maKM + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maKM1 = rs.getString(1);
                String tenKM = rs.getString(2);
                double giaTriKhuyenMai = rs.getDouble(3);
                LocalDate thoiGianBatDau = rs.getDate(4).toLocalDate();
                LocalDate thoiGianKetThuc = rs.getDate(5).toLocalDate();
                double dieuKienApDung = rs.getDouble(6);
                khuyenMai = new KhuyenMai(maKM1, tenKM, giaTriKhuyenMai, thoiGianBatDau, thoiGianKetThuc, dieuKienApDung);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        	
        }
        return khuyenMai;}
	
	// tìm khuyến mãi theo tên khuyến mãi
	public KhuyenMai timKhuyenMaiTheoTen(String tenKM) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhuyenMai where tenKM = '" + tenKM + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKM = rs.getString(1);
				String tenKM1 = rs.getString(2);
				double giaTriKhuyenMai = rs.getDouble(3);
				LocalDate thoiGianBatDau = rs.getDate(4).toLocalDate();
				LocalDate thoiGianKetThuc = rs.getDate(5).toLocalDate();
				double dieuKienApDung = rs.getDouble(6);
				khuyenMai = new KhuyenMai(maKM, tenKM1, giaTriKhuyenMai, thoiGianBatDau, thoiGianKetThuc,
						dieuKienApDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return khuyenMai;
	}
	
	// tìm khuyến mãi theo thời gian bắt đầu
	public KhuyenMai timKhuyenMaiTheoThoiGianBatDau(LocalDate thoiGianBatDau) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhuyenMai where thoiGianBatDau = '" + thoiGianBatDau + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				double giaTriKhuyenMai = rs.getDouble(3);
				LocalDate thoiGianBatDau1 = rs.getDate(4).toLocalDate();
				LocalDate thoiGianKetThuc = rs.getDate(5).toLocalDate();
				double dieuKienApDung = rs.getDouble(6);
				khuyenMai = new KhuyenMai(maKM, tenKM, giaTriKhuyenMai, thoiGianBatDau1, thoiGianKetThuc,
						dieuKienApDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return khuyenMai;
	}
	// tìm khuyến mãi theo thời gian kết thúc
	public KhuyenMai timKhuyenMaiTheoThoiGianKetThuc(LocalDate thoiGianKetThuc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhuyenMai where thoiGianKetThuc = '" + thoiGianKetThuc + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				double giaTriKhuyenMai = rs.getDouble(3);
				LocalDate thoiGianBatDau = rs.getDate(4).toLocalDate();
				LocalDate thoiGianKetThuc1 = rs.getDate(5).toLocalDate();
				double dieuKienApDung = rs.getDouble(6);
				khuyenMai = new KhuyenMai(maKM, tenKM, giaTriKhuyenMai, thoiGianBatDau, thoiGianKetThuc1,
						dieuKienApDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return khuyenMai;
	}
	
	// tìm khuyến mãi theo điều kiện áp dụng
	public KhuyenMai timKhuyenMaiTheoDieuKienApDung(double dieuKienApDung) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhuyenMai where dieuKienApDung = " + dieuKienApDung + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				double giaTriKhuyenMai = rs.getDouble(3);
				LocalDate thoiGianBatDau = rs.getDate(4).toLocalDate();
				LocalDate thoiGianKetThuc = rs.getDate(5).toLocalDate();
				double dieuKienApDung1 = rs.getDouble(6);
				khuyenMai = new KhuyenMai(maKM, tenKM, giaTriKhuyenMai, thoiGianBatDau, thoiGianKetThuc,
						dieuKienApDung1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return khuyenMai;
	}
	// tìm khuyến mãi theo giá trị khuyến mãi
	public KhuyenMai timKhuyenMaiTheoGiaTriKM(double giaTriKM) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhuyenMai where giaTriKM = " + giaTriKM + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				double giaTriKhuyenMai = rs.getDouble(3);
				LocalDate thoiGianBatDau = rs.getDate(4).toLocalDate();
				LocalDate thoiGianKetThuc = rs.getDate(5).toLocalDate();
				double dieuKienApDung = rs.getDouble(6);
				khuyenMai = new KhuyenMai(maKM, tenKM, giaTriKhuyenMai, thoiGianBatDau, thoiGianKetThuc,
						dieuKienApDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return khuyenMai;
	}
	
}
