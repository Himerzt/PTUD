package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChucVu;
import entity.NhanVien;

public class NhanVienDao {
	ArrayList<NhanVien> dsnv;
	NhanVien nv;

	public NhanVienDao() {
		dsnv = new ArrayList<NhanVien>();
		nv = new NhanVien();
	}

	public ArrayList<NhanVien> timTatCaNhanVien() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);

				ChucVu chucVu = new ChucVu(rs.getString(9));
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);

				NhanVien nv = new NhanVien(maNV, hoTenNV, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi, chucVu,
						ngayVaoLam, soNgayNghi);

				dsnv.add(nv);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return dsnv;
	}

	// thêm nhân viên
	public boolean themNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsnv.contains(nv)) {
			try {
				stmt = con.createStatement();
				String sql = "insert into NhanVien values('" + nv.getMaNV() + "', N'" + nv.getHoTenNV() + "', '"
						+ nv.getNgaySinh() + "', N'" + nv.getGioiTinh() + "', '" + nv.getSoDT() + "', '" + nv.getEmail()
						+ "', '" + nv.getCCCD() + "', N'" + nv.getDiaChi() + "', '" + nv.getChucVu().getMaChucVu()
						+ "', '" + nv.getNgayVaoLam() + "', '" + nv.getSoNgayNghi() + "')";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	// sửa nhân viên
	public boolean suaThongTinNhanVien(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		if (!dsnv.contains(nv)) {
			try {
				stmt = con.prepareStatement(
						"update NhanVien set hoTenNV = ?, ngaySinh = ?, gioiTinh = ?, soDT = ?, email = ?, CCCD = ?, diaChi = ?, maChucVu = ?, ngayVaoLam = ?, soNgayNghi = ? where maNV = ?");
				stmt.setString(1, nv.getHoTenNV());
				stmt.setDate(2, java.sql.Date.valueOf(nv.getNgaySinh()));
				stmt.setString(3, nv.getGioiTinh());
				stmt.setString(4, nv.getSoDT());
				stmt.setString(5, nv.getEmail());
				stmt.setString(6, nv.getCCCD());
				stmt.setString(7, nv.getDiaChi());
				stmt.setString(8, nv.getChucVu().getMaChucVu());
				stmt.setDate(9, java.sql.Date.valueOf(nv.getNgayVaoLam()));
				stmt.setInt(10, nv.getSoNgayNghi());
				stmt.setString(11, nv.getMaNV());
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;

		}
		return false;
	}

	// xóa nhân viên
	public boolean xoaNhanVien(String maNV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNV = ?");
			stmt.setString(1, maNV);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// tìm theo maNV
	public NhanVien timNhanVienTheoMa(String maNV) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where maNV = '" + maNV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);

				ChucVu chucVu = new ChucVu(rs.getString(9));
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);

				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi, chucVu, ngayVaoLam,
						soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

// tìm theo tên
	public NhanVien timNhanVienTheoTen(String hoTenNV) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where hoTenNV = '" + hoTenNV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV1 = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);

				ChucVu chucVu = new ChucVu(rs.getString(9));
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);

				nv = new NhanVien(maNV1, hoTenNV1, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi, chucVu, ngayVaoLam,
						soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

	// tìm theo chức vụ
	public NhanVien timNhanVienTheoChucVu(String maChucVu) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where maChucVu = '" + maChucVu + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);
				String chucVu = rs.getString(9);
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi, new ChucVu(maChucVu),
						ngayVaoLam, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

	// tìm theo ngày vào làm
	public NhanVien timNhanVienTheoNgayVaoLam(LocalDate ngayVaoLam) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where ngayVaoLam = '" + ngayVaoLam + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);
				String chucVu = rs.getString(9);
				LocalDate ngayVaoLam1 = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi, new ChucVu(chucVu),
						ngayVaoLam1, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

	// tìm theo chức vụ
	public NhanVien timNhanVienTheoChucVu(ChucVu chucVu) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where maChucVu = '" + chucVu.getMaChucVu() + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);
				String chucVu1 = rs.getString(9);
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi, new ChucVu(chucVu1),
						ngayVaoLam, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

// tìm theo giới tính
	public NhanVien timNhanVienTheoGioiTinh(String gioiTinh) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where gioiTinh = '" + gioiTinh + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh1 = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);
				String chucVu = rs.getString(9);
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh1, soDT, email, CCCD, diaChi, new ChucVu(chucVu),
						ngayVaoLam, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

	// tìm theo số điện thoại
	public NhanVien timNhanVienTheoSoDT(String soDT) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where soDT = '" + soDT + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT1 = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);
				String chucVu = rs.getString(9);
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT1, email, CCCD, diaChi, new ChucVu(chucVu),
						ngayVaoLam, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

	// tìm theo email
	public NhanVien timNhanVienTheoEmail(String email) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where email = '" + email + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email1 = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi = rs.getString(8);
				String chucVu = rs.getString(9);
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT, email1, CCCD, diaChi, new ChucVu(chucVu),
						ngayVaoLam, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

	// tìm theo CCCD
	public NhanVien timNhanVienTheoCCCD(String CCCD) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where CCCD = '" + CCCD + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD1 = rs.getString(7);
				String diaChi = rs.getString(8);
				String chucVu = rs.getString(9);
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT, email, CCCD1, diaChi, new ChucVu(chucVu),
						ngayVaoLam, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

	// tìm theo địa chỉ
	public NhanVien timNhanVienTheoDiaChi(String diaChi) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien where diaChi = '" + diaChi + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				String hoTenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				String gioiTinh = rs.getString(4);
				String soDT = rs.getString(5);
				String email = rs.getString(6);
				String CCCD = rs.getString(7);
				String diaChi1 = rs.getString(8);
				String chucVu = rs.getString(9);
				LocalDate ngayVaoLam = rs.getDate(10).toLocalDate();
				int soNgayNghi = rs.getInt(11);
				nv = new NhanVien(maNV1, hoTenNV, ngaySinh, gioiTinh, soDT, email, CCCD, diaChi1, new ChucVu(chucVu),
						ngayVaoLam, soNgayNghi);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Đóng kết nối
		}
		return nv;
	}

}