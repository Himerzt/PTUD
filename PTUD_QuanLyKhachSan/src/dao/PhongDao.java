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

	public String timMaPhongTheoTenPhong(String tenPhong) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("select maPhong from Phong where soPhong = ?");
			stmt.setString(1, tenPhong);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Phong> timTatCaPhongSapXepTheoSoPhong() {
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Phong order by soPhong");
			while (rs.next()) {
				phong = new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				dsPhong.add(phong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	// thêm phòng
	public boolean themPhong(Phong phong) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into Phong values(?,?,?,?)");
			stmt.setString(1, phong.getMaPhong());
			stmt.setInt(2, phong.getSoPhong());
			stmt.setString(3, phong.getMaLoaiPhong());
			stmt.setString(4, phong.getTrangThai());
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Cập nhật trạng thái phòng theo mã phòng
	public boolean capNhatTrangThaiPhong(String maPhong, String trangThai) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("update Phong set TrangThaiPhong = ? where maPhong = ?");
			stmt.setString(1, trangThai);
			stmt.setString(2, maPhong);
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// sửa phòng
	public boolean suaPhong(Phong phong) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con
					.prepareStatement("update Phong set soPhong = ?, maLoaiPhong = ?, trangThai = ? where maPhong = ?");
			stmt.setInt(1, phong.getSoPhong());
			stmt.setString(2, phong.getMaLoaiPhong());
			stmt.setString(3, phong.getTrangThai());
			stmt.setString(4, phong.getMaPhong());
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (Exception e) {
			e.printStackTrace();
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
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from Phong where maPhong = ?");
			stmt.setString(1, maPhong);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				phong = new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phong;
	}

	// tìm phòng theo số phòng
	public Phong timPhongTheoSoPhong(int soPhong) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from Phong where soPhong = ?");
			stmt.setInt(1, soPhong);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				phong = new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
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
				phong = new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
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
				phong = new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				dsPhong.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	// tìm phòng theo loại phòng, trạng thái
	public ArrayList<Phong> timPhongTheoLoaiPhongTrangThai(String maLoaiPhong, String trangThai) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			stmt = ((Connection) con).prepareStatement("select * from Phong where maLoaiPhong = ? and trangThai = ?");
			stmt.setString(1, maLoaiPhong);
			stmt.setString(2, trangThai);
			rs = stmt.executeQuery();
			while (rs.next()) {
				phong = new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				dsPhong.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	// tìm phòng theo loại phòng, trạng thái, số lượng
	public ArrayList<Phong> timPhongTheoLoaiPhongTrangThaiSoLuong(String maLoaiPhong, String trangThai, int soLuong) {
		connectDB.ConnectDB.getInstance();
		ConnectDB con = (ConnectDB) ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			stmt = ((Connection) con)
					.prepareStatement("select top (?) * from Phong where maLoaiPhong = ? and trangThai = ?");
			stmt.setInt(1, soLuong);
			stmt.setString(2, maLoaiPhong);
			stmt.setString(3, trangThai);
			rs = stmt.executeQuery();
			while (rs.next()) {
				phong = new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
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

	public boolean capNhatTrangThaiDaDat(String maPhong) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("update Phong set trangThai = 'Đã đặt' where maPhong = ?");
			stmt.setString(1, maPhong);
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean capNhatTrangThaiDaThue(String maPhong) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("update Phong set trangThai = 'Đã thuê' where maPhong = ?");
			stmt.setString(1, maPhong);
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String timMaLoaiPhongTheoMaPhong(String maPhong) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("select maLoaiPhong from Phong where maPhong = ?");
			stmt.setString(1, maPhong);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// chuyển ArrayList<String > thành ArrayList<Phong>
	public ArrayList<Phong> chuyenDoi(ArrayList<String> dsMaPhong) {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		for (String maPhong : dsMaPhong) {
			dsPhong.add(timPhongTheoMaPhong(maPhong));
		}
		return dsPhong;
	}
	
	//cập nhật trạng thái phòng
	public boolean capNhatTrangThaiPhong1(String maPhong, String trangThai) {
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement("update Phong set trangThai = ? where maPhong = ?");
			stmt.setString(1, trangThai);
			stmt.setString(2, maPhong);
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// Lấy thông tin phòng đang thuê
//	-- Tìm phòng đang thuê và thông tin khách hàng
//	SELECT p.MaPhong, p.TrangThaiPhong, kh.TenKhachHang, kh.CCCD_Passport FROM Phong p JOIN ThongTinDatThuePhong tt 
//	ON p.MaPhong = tt.MaPhong JOIN KhachHang kh
//	ON tt.MaKhachHang = kh.MaKH WHERE p.TrangThaiPhong = N'Đã thuê'
	public ArrayList<String> layThongTinPhongDangThue() {
		ArrayList<String> dsPhongDangThue = new ArrayList<String>();
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"select p.MaPhong, p.TrangThaiPhong, kh.TenKhachHang, kh.CCCD_Passport from Phong p join ThongTinDatThuePhong tt on p.MaPhong = tt.MaPhong join KhachHang kh on tt.MaKhachHang = kh.MaKH where p.TrangThaiPhong = N'Đã thuê'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dsPhongDangThue.add(
						rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhongDangThue;
	}

}
