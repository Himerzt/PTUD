package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.DichVuPhong;

public class DichVuPhongDao {
	ArrayList<DichVuPhong> dsDichVu;
	DichVuPhong dvp;
	DichVuDao dvDao = new DichVuDao();
	PhongDao phongDao = new PhongDao();
	LoaiPhongDao loaiPhongDao = new LoaiPhongDao();
	ArrayList<Double> arGia = new ArrayList<>();

	public DichVuPhongDao() {
		this.dsDichVu = new ArrayList<>();
		this.dvp = new DichVuPhong();
	}

	public ArrayList<DichVuPhong> timTatCacDichVuSuDung() {
		dsDichVu = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDichVuSuDung = rs.getString(1);
				String maPhong1 = rs.getString(2);
				String maDichVu = rs.getString(3);
				int soLuong = rs.getInt(4);
				dvp = new DichVuPhong(maDichVuSuDung, maPhong1, maDichVu, soLuong);
				dsDichVu.add(dvp);
			}
		} catch (Exception var8) {
			var8.printStackTrace();
		}

		return this.dsDichVu;
	}

	public ArrayList<DichVuPhong> timTheoMaDichVuSuDung(String maDV) {
		dsDichVu = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung where madichvu = '" + maDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDichVuSuDung = rs.getString(1);
				String maPhong1 = rs.getString(2);
				String maDichVu = rs.getString(3);
				int soLuong = rs.getInt(4);
				dvp = new DichVuPhong(maDichVuSuDung, maPhong1, maDichVu, soLuong);
				dsDichVu.add(dvp);
			}
		} catch (Exception var9) {
			var9.printStackTrace();
		}

		return this.dsDichVu;
	}

	public boolean themDichVuSuDung(DichVuPhong dvp) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			int maDVSD = timTatCacDichVuSuDung().size() + 1;
			String sql = "insert into DichVuSuDung values('" + maDVSD + "','" + dvp.getMaPhong() + "','"
					+ dvp.getMaDichVu() + "'," + dvp.getSoLuong() + ")";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception var5) {
			var5.printStackTrace();
			return false;
		}
	}

	public boolean suaDichVuSuDung(DichVuPhong dvp) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			int soLuong = dvp.getSoLuong();
			String sql = "update DichVuSuDung set soLuong = " + soLuong + " where maPhong = '" + dvp.getMaPhong()
					+ "' and maDichVu = '" + dvp.getMaDichVu() + "'";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception var5) {
			var5.printStackTrace();
			return false;
		}
	}

	public double tinhGiaDichVuCuaMotPhong(String maPhong) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung where maPhong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDichVuSuDung = rs.getString(1);
				String maPhong1 = rs.getString(2);
				String maDichVu = rs.getString(3);
				int soLuong = rs.getInt(4);
				dvp = new DichVuPhong(maDichVuSuDung, maPhong1, maDichVu, soLuong);
				dsDichVu.add(dvp);
			}
		} catch (Exception var11) {
			var11.printStackTrace();
		}

		double giaTong = 0.0;

		for (Double double1 : arGia) {
			giaTong += double1;
		}

		return giaTong;
	}

	// thêm danh sach dih vu phong

	public List<DichVuPhong> timDichVuSuDungTheoMaPhong(String maPhong) {
		dsDichVu = new ArrayList<DichVuPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung where maPhong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVuSuDung = rs.getString(1);
				String maPhong1 = rs.getString(2);
				String maDichVu = rs.getString(3);
				int soLuong = rs.getInt(4);
				dvp = new DichVuPhong(maDichVuSuDung, maPhong1, maDichVu, soLuong);
				dsDichVu.add(dvp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDichVu;
	}

	public DichVu timTheoMaDichVu(String maDV) {
		try {
			Connection con = ConnectDB.getConnection();

			String sql = "Select * from DichVu where madichvu = '" + maDV + "'";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maDV1 = rs.getString(1);
				String tenDV = rs.getString(2);
				double giaDV = rs.getDouble(3);
				DichVu dv = new DichVu(maDV1, tenDV, giaDV);
				return dv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public double tinhTienTheoMaDichVu(String maDV) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung where madichvu = '" + maDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVuSuDung = rs.getString(1);
				String maPhong1 = rs.getString(2);
				String maDichVu = rs.getString(3);
				int soLuong = rs.getInt(4);
				dvp = new DichVuPhong(maDichVuSuDung, maPhong1, maDichVu, soLuong);
				dsDichVu.add(dvp);
			}
		} catch (Exception var11) {
			var11.printStackTrace();
		}
		double giaTong = 0.0;

		for (Double double1 : arGia) {
			giaTong += double1;
		}

		return giaTong;
	}

	// đếm số lượng dịch vụ phòng theo mã phòng
	public int demSoLuongDichVuSuDungTheoMaPhong(String maPhong) {
		int count = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung where maPhong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	// thêm dịch vụ phòng
	public boolean themDichVuPhongTTK(List<DichVuPhong> dsDVP) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			for (DichVuPhong dvp : dsDVP) {
				String sql = "insert into DichVuSuDung values('"
						+ String.format("%s%s", "DVSD", timTatCacDichVuSuDung().size()) + "','" + dvp.getMaPhong()
						+ "','" + dvp.getMaDichVu() + "'," + dvp.getSoLuong() + ")";
				stmt.executeUpdate(sql);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	// thêm dịch vụ phòng
	public boolean themDichVuPhong(DichVuPhong dvp) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			String sql = "insert into DichVuSuDung values('"
					+ String.format("%s%s", "DVSD", timTatCacDichVuSuDung().size()) + "','" + dvp.getMaPhong() + "','"
					+ dvp.getMaDichVu() + "'," + dvp.getSoLuong() + ")";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// sửa dịch vụ phòng
	public boolean suaDichVuPhong(DichVuPhong dvp) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			int soLuong = dvp.getSoLuong();
			String sql = "update DichVuSuDung set soLuong = " + soLuong + " where maPhong = '" + dvp.getMaPhong()
					+ "' and maDV = '" + dvp.getMaDichVu() + "'";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// xóa dịch vụ phòng
	public boolean xoaDichVuPhong(String maPhong, String maDV) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();

			String sql = "delete from DichVuSuDung where maPhong = '" + maPhong + "' and maDichVu = '" + maDV + "'";

			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}


	}

	// demSoLuongDichVuPhongTheoMaPhong
//
//	public int demSoLuongDichVuPhongTheoMaPhong(String maPhong) {
//		int count = 0;
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "Select * from DichVuSuDung where maPhong = '" + maPhong + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			if (rs.next() == false) {
//				count = 0;
//			}
//			else
//			while (rs.next()) {
//				count++;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return count;
//	}

//xoaDichVuPhongTheoMaPhongVaMaDichVu
	public boolean xoaDichVuPhongTheoMaPhongVaMaDichVu(String maPhong, String maDV) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			String sql = "delete from DichVuSuDung where maPhong = '" + maPhong + "' and maDichVu = '" + maDV + "'";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// timDichVuSuDungTheoMaPhongVaMaDichVu
	public DichVuPhong timDichVuSuDungTheoMaPhongVaMaDichVu(String maPhong, String maDV) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung where maPhong = '" + maPhong + "' and maDichVu = '" + maDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maDichVuSuDung = rs.getString(1);
				String maPhong1 = rs.getString(2);
				String maDichVu = rs.getString(3);
				int soLuong = rs.getInt(4);
				dvp = new DichVuPhong(maDichVuSuDung, maPhong1, maDichVu, soLuong);
				return dvp;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return dvp;
	}

	// cập nhật lại ma phong
	public boolean capNhatMaPhong(String maPhongCu, String maPhongMoi) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			String sql = "update DichVuSuDung set maPhong = '" + maPhongMoi + "' where maPhong = '" + maPhongCu + "'";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// tìm tất cả dịch vụ phòng theo mã phòng
	public ArrayList<DichVuPhong> timTatCaDichVuPhongTheoMaPhong(String maPhong) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuSuDung where maPhong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVuSuDung = rs.getString(1);
				String maPhong1 = rs.getString(2);
				String maDichVu = rs.getString(3);
				int soLuong = rs.getInt(4);
				dvp = new DichVuPhong(maDichVuSuDung, maPhong1, maDichVu, soLuong);
				dsDichVu.add(dvp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDichVu;
	}


}

