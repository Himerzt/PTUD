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

public class KhachHangDao {
	ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	KhachHang khachHang;

	public KhachHangDao() {
		dsKH = new ArrayList<KhachHang>();
                khachHang = new KhachHang();
	}
	
	public int demTongSoKhachHang() {
		int dem = 0;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select count(*) from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				dem = rs.getInt(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dem;
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
				String maHangThanhVien = rs.getString(8);
				String quocTich = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, maHangThanhVien, quocTich);
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
				String maHangThanhVien = rs.getString(8);
				String quocTich = rs.getString(9);
				khachHang = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, maHangThanhVien, quocTich);
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
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Insert into KhachHang values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, kh.getMaKH());
			pst.setString(2, kh.getHoTenKH());
			pst.setString(3, kh.getGioiTinh());
			pst.setDate(4, Date.valueOf(kh.getNgaySinh()));
			pst.setString(5, kh.getSoDT());
			pst.setString(6, kh.getCccd_passport());
			pst.setDouble(7, kh.getChiTieu());
			pst.setString(8, kh.getMaHangThanhVien());
			pst.setString(9, kh.getQuocTich());
			pst.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return false;
	}
	
	//Sửa thông tin khách hàng
	public boolean suaThongTinKhachHang(KhachHang kh) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Update KhachHang set TenKhachHang = N'" + kh.getHoTenKH() + "', gioiTinh = N'" + kh.getGioiTinh()
					+ "', ngaySinhKH = '" + kh.getNgaySinh() + "', soDienThoai = '" + kh.getSoDT() + "', CCCD_Passport = '"
					+ kh.getCccd_passport() + "', chiTieu = " + kh.getChiTieu() + ", maHang = '"
					+ kh.getMaHangThanhVien() + "', quocTich = N'" + kh.getQuocTich() + "' where maKH = '"
					+ kh.getMaKH() + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return false;
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
				String maHangThanhVien = rs.getString(8);
				String quocTich = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, maHangThanhVien,quocTich);
				dsKH.add(kh);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dsKH;
	}
	
	// Tìm khách hàng theo CCCD
	public KhachHang timTheoCCCD(String CCCD) {
		KhachHang kh = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang where CCCD_Passport = '" + CCCD + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maKH = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String CCCD_Visa = rs.getString(6);
				double chiTieu = rs.getDouble(7);
				String maHangThanhVien = rs.getString(8);
				String quocTich = rs.getString(9);
				kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, maHangThanhVien, quocTich);
				return kh;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return kh;
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
				String maHangThanhVien = rs.getString(8);
				String quocTich = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, maHangThanhVien,
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
				String maHangThanhVien = rs.getString(8);
				String quocTich1 = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, maHangThanhVien,
						quocTich1);
				dsKH.add(kh);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dsKH;
	}
	
	// tìm khách hàng theo mã khách hàng
	public KhachHang timKhachHangTheoMa(String maKH) {
		KhachHang kh = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang where maKH = '" + maKH + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String CCCD_Visa = rs.getString(6);
				double chiTieu = rs.getFloat(7);
				String maHangThanhVien = rs.getString(8);
				String quocTich = rs.getString(9);
				kh = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, soDT, CCCD_Visa, chiTieu, maHangThanhVien,
						quocTich);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return kh;
	}
}
