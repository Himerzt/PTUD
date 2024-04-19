package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.DonDat;
import entity.HoaDon;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_Dao {
	List<entity.NhanVien> dsnv;

	public NhanVien_Dao() {
		dsnv = new ArrayList<entity.NhanVien>();
	}

	public List<entity.NhanVien> docTuBang() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select* from NhanVien";
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String sdt = rs.getString(3);
				String chucVu = rs.getString(4);
				String email = rs.getString(5);
				NhanVien nv = new NhanVien(maNV, tenNV, sdt, chucVu, email);
				dsnv.add(nv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}

	public List<entity.NhanVien> getNhanVien(String manv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		List<NhanVien> listNV = new ArrayList<>();
		try {
			String sql = "Select* from NhanVien where maNV = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, manv);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String sdt = rs.getString(3);
				String chucVu = rs.getString(4);
				String email = rs.getString(5);

				NhanVien nv = new NhanVien(maNV, tenNV, sdt, chucVu, email);
				listNV.add(nv);
			}
			return listNV;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNV;
	}

	public boolean createNhanVien(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			// Kiểm tra xem Mã nhân viên đã tồn tại hay chưa
			if (maNhanVienDaTonTai(nv.getMaNV())) {
				return false;
			}

			// Nếu Mã nhân viên chưa tồn tại, tiến hành thêm mới
			stmt = con.prepareStatement("insert into NhanVien values(?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getSdtNV());
			stmt.setString(4, nv.getChucVu());
			stmt.setString(5, nv.getEmail());
			n = stmt.executeUpdate();
			if(n > 0) {
				TaiKhoan tk = new TaiKhoan(nv.getEmail(), nv.getSdtNV(), nv);
				TaiKhoan_Dao tkDao = new TaiKhoan_Dao();
				if(tkDao.createTaiKhoan(tk)) n+=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean maNhanVienDaTonTai(String maNV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT COUNT(*) FROM NhanVien WHERE MaNV = ?");
			stmt.setString(1, maNV);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // Trả về true nếu Mã nhân viên đã tồn tại, ngược lại trả về false
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // Trả về false nếu có lỗi xảy ra hoặc không tìm thấy kết quả
	}

	public boolean updateNhanVien(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update NhanVien set  tenNV = ?, sdtNV = ?, chucVu = ?, email = ? WHERE maNV = ?");

			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getSdtNV());
			stmt.setString(3, nv.getChucVu());
			stmt.setString(4, nv.getEmail());
			stmt.setString(5, nv.getMaNV());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean deleteNhanVien(String maNV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmtnv = null;
//		PreparedStatement stmthd = null;
		PreparedStatement stmttk = null;
		int n = 0;
		try {
			con.setAutoCommit(false);
			
//			Kiểm tra các đơn hàng có mã NV? -> Update
			HoaDon_Dao hdDao = new HoaDon_Dao();
			List<HoaDon> listHD = hdDao.findKH(maNV);
			if(listHD != null) {
				for (HoaDon hoaDon : listHD) {
					hdDao.updateKhachInHoaDon(hoaDon.getMaHoaDon());
				}
			}
			
//			Kiểm tra đơn đặt có mã NV? -> Update
			DonDat_Dao ddDao = new DonDat_Dao();
			List<DonDat> listDD = ddDao.findKH(maNV);
			if(listHD != null) {
				for (DonDat donDat : listDD) {
					ddDao.updateKhachInDonDat(donDat.getMaDonDat());
				}
			}

			stmtnv = con.prepareStatement("DELETE FROM NhanVien WHERE maNV = ?");
			stmtnv.setString(1, maNV);
			n = stmtnv.executeUpdate();

//	        stmtddh = con.prepareStatement("DELETE FROM HoaDon WHERE maNV = ?");
//	        stmtddh.setString(1, maNV);
//	        n += stmtddh.executeUpdate();

			stmttk = con.prepareStatement("DELETE FROM TaiKhoan WHERE maNV = ?");
			stmttk.setString(1, maNV);
			n += stmttk.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return n > 0;
	}

	
}
