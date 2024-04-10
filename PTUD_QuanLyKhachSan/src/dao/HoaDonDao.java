package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDonDao {
	ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
	HoaDon hoaDon = new HoaDon();

	public HoaDonDao() {
		dsHoaDon = new ArrayList<HoaDon>();
		hoaDon = new HoaDon();

	}

// tìm tất cả hóa đơn
	public ArrayList<HoaDon> timTatCaHoaDon() {
		try {
			// code here
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);

				NhanVien nv = new NhanVien(nhanVien);
				KhachHang kh = new KhachHang(khachHang);

				hoaDon = new HoaDon(maHoaDon, nv, ngayLap, kh);
				dsHoaDon.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}

	// thêm hóa đơn
	public boolean themHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsHoaDon.contains(hoaDon)) {
			try {
				stmt = con.createStatement();
				String sql = "insert into HoaDon values('" + hoaDon.getMaHoaDon() + "','"
						+ hoaDon.getNhanVien().getMaNV() + "','" + hoaDon.getNgayLap() + "','"
						+ hoaDon.getKhachHang().getMaKH() + "')";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// sửa hóa đơn
	public boolean suaHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsHoaDon.contains(hoaDon)) {
			try {
				stmt = con.createStatement();
				String sql = "update HoaDon set nhanVien = '" + hoaDon.getNhanVien().getMaNV() + "', ngayLap = '"
						+ hoaDon.getNgayLap() + "', khachHang = '" + hoaDon.getKhachHang().getMaKH()
						+ "' where maHoaDon = '" + hoaDon.getMaHoaDon() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// xóa hóa đơn
	public boolean xoaHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsHoaDon.contains(hoaDon)) {
			try {
				stmt = con.createStatement();
				String sql = "delete from HoaDon where maHoaDon = '" + hoaDon.getMaHoaDon() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// tìm hóa đơn theo mã
	public HoaDon timHoaDonTheoMa(String maHoaDon) {
		HoaDon hd = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where maHoaDon = '" + maHoaDon + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);

				NhanVien nv = new NhanVien(nhanVien);
				KhachHang kh = new KhachHang(khachHang);

				hd = new HoaDon(maHD, nv, ngayLap, kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}

	// tìm hóa đơn theo mã nhân viên
	public ArrayList<HoaDon> timHoaDonTheoMaNhanVien(String maNhanVien) {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where nhanVien = '" + maNhanVien + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);

				NhanVien nv = new NhanVien(nhanVien);
				KhachHang kh = new KhachHang(khachHang);

				HoaDon hd = new HoaDon(maHD, nv, ngayLap, kh);
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    return dsHoaDon;}
	// tìm hóa đơn theo mã khách hàng
	public ArrayList<HoaDon> timHoaDonTheoMaKhachHang(String maKhachHang) {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where khachHang = '" + maKhachHang + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);

				NhanVien nv = new NhanVien(nhanVien);
				KhachHang kh = new KhachHang(khachHang);

				HoaDon hd = new HoaDon(maHD, nv, ngayLap, kh);
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}
	// tìm hóa đơn theo ngày lập
	public ArrayList<HoaDon> timHoaDonTheoNgayLap(LocalDate ngayLap) {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon where ngayLap = '" + ngayLap + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				LocalDate ngayLap1 = rs.getDate(3).toLocalDate();
				String khachHang = rs.getString(4);

				NhanVien nv = new NhanVien(nhanVien);
				KhachHang kh = new KhachHang(khachHang);

				HoaDon hd = new HoaDon(maHD, nv, ngayLap1, kh);
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}
}
