package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HangThanhVien;
import entity.KhachHang;

public class KhachHangDAO {
	ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	KhachHang khachHang;

	public KhachHangDAO() {
		dsKH = new ArrayList<KhachHang>();
      khachHang = new KhachHang();
	}
	
	
	public ArrayList<KhachHang> timTatCaKhachHang(){
		try (Connection con = ConnectDB.getInstance().getConnection()) {
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maKH = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String CCCD_Visa = rs.getString(6);
				double chiTieu = rs.getDouble(7);
				HangThanhVien hangThanhVien = new HangThanhVien(rs.getString(8));
				String quocTich = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, hangThanhVien, quocTich);
				dsKH.add(kh);
			} 
		} catch(SQLException ex) {
			ex.printStackTrace();
			//Đóng kết nối
		}
		return dsKH;
	}
	
	
	public KhachHang timTheoMaKhachHang(String maKH) {
		try {
			ConnectDB.getInstance();
			Connection con = null;
			try {
				con = ConnectDB.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql = "Select * from KhachHang where maKH = '" + maKH + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String CCCD_Visa = rs.getString(6);
				double chiTieu = rs.getDouble(7);
				HangThanhVien hangThanhVien = new HangThanhVien(rs.getString(8));
				String quocTich = rs.getString(9);
				khachHang = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, hangThanhVien,quocTich);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return khachHang;
	}
	
	//Thêm khách hàng
	public boolean themKhachHang(KhachHang kh) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stml = null;
			 Date ngaySinhSQL = Date.valueOf(kh.getNgaySinh());
			int n = 0;
//			if (kh.getMaKH() != null) {
				String sql = "Insert into KhachHang values(?,?,?,?,?,?,?,?,?)";
				stml = con.prepareStatement(sql);
				stml.setString(1, kh.getMaKH());
				stml.setString(2, kh.getHoTenKH());
				stml.setString(3, kh.getGioiTinh());
				stml.setDate(4, ngaySinhSQL);
				stml.setString(5, kh.getSoDT());
				stml.setString(6, kh.getCCCD_Visa());
				stml.setDouble(7, kh.getChiTieu());
				stml.setString(8, kh.getHangThanhVien().getMaHang());
				stml.setString(9, kh.getQuocTich());
				n = stml.executeUpdate();
			
			if (n > 0) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return false;
	}
	
	//Sửa thông tin khách hàng
	public void suaThongTinKhachHang(KhachHang kh) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Update KhachHang set hoTenKH = N'" + kh.getHoTenKH() + "', gioiTinh = N'" + kh.getGioiTinh()
					+ "', ngaySinh = '" + kh.getNgaySinh() + "', soDT = '" + kh.getSoDT() + "', CCCD_Visa = '"
					+ kh.getCCCD_Visa() + "', chiTieu = " + kh.getChiTieu() + ", maHang = '"
					+ kh.getHangThanhVien().getMaHang() + "', quocTich = N'" + kh.getQuocTich() + "' where maKH = '"
					+ kh.getMaKH() + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
	}
	
	//Xóa khách hàng
	public void xoaKhachHang(String maKH) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Delete from KhachHang where maKH = '" + maKH + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
	}
	
	// tim kiem khach hang theo ten
	public ArrayList<KhachHang> timTheoTenKhachHang(String tenKH) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang where tenKhachHang like N'%" + tenKH + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String CCCD_Visa = rs.getString(6);
				double chiTieu = rs.getDouble(7);
				HangThanhVien hangThanhVien = new HangThanhVien(rs.getString(8));
				String quocTich = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, hangThanhVien,quocTich);
				dsKH.add(kh);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dsKH;
	}
	
	// tìm kiếm khách hàng theo hạng thành viên
	public ArrayList<KhachHang> timKhachHangTheoHangThanhVien(String maHang) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang where maHang = '" + maHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String CCCD_Visa = rs.getString(6);
				double chiTieu = rs.getFloat(7);
				HangThanhVien hangThanhVien = new HangThanhVien(rs.getString(8));
				String quocTich = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, hangThanhVien,
						quocTich);
				dsKH.add(kh);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dsKH;
	}
	
	// tìm kiếm khách hàng theo quốc tịch
	public ArrayList<KhachHang> timKhachHangTheoQuocTich(String quocTich) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang where quocTich = N'" + quocTich + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String CCCD_Visa = rs.getString(6);
				double chiTieu = rs.getFloat(7);
				HangThanhVien hangThanhVien = new HangThanhVien(rs.getString(8));
				String quocTich1 = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, hangThanhVien,
						quocTich1);
				dsKH.add(kh);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dsKH;
	}
}
