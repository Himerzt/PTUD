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
	ArrayList<DichVuPhong> dsDichVu = new ArrayList();
	DichVuPhong dvp;
	DichVuDao dvDao = new DichVuDao();
	PhongDao phongDao = new PhongDao();
	LoaiPhongDao loaiPhongDao = new LoaiPhongDao();
	ArrayList<Double> arGia = new ArrayList();

	public DichVuPhongDao() {
		this.dsDichVu = new ArrayList();
		this.dvp = new DichVuPhong();
	}

	public ArrayList<DichVuPhong> timTatCacDichVuPhong() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDV = rs.getString(1);
				String maPhong = rs.getString(2);
				int soLuong = rs.getInt(3);
				this.dvp = new DichVuPhong(maDV, maPhong, soLuong);
				this.dsDichVu.add(this.dvp);
			}
		} catch (Exception var8) {
			var8.printStackTrace();
		}

		return this.dsDichVu;
	}

	public ArrayList<DichVuPhong> timTheoMaDichVuPhong(String maDV) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVuPhong where maDV = '" + maDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDV1 = rs.getString(1);
				String maPhong = rs.getString(2);
				int soLuong = rs.getInt(3);
				this.dvp = new DichVuPhong(maDV1, maPhong, soLuong);
				this.dsDichVu.add(this.dvp);
			}
		} catch (Exception var9) {
			var9.printStackTrace();
		}

		return this.dsDichVu;
	}

	public boolean themDichVuPhong(DichVuPhong dvp) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			String var10000 = dvp.getMaPhong();
			String sql = "insert into DichVuPhong values('" + var10000 + "','" + dvp.getMaDichVu() + "',"
					+ dvp.getSoLuong() + ")";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception var5) {
			var5.printStackTrace();
			return false;
		}
	}

	public boolean suaDichVuPhong(DichVuPhong dvp) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			int var10000 = dvp.getSoLuong();
			String sql = "update DichVuPhong set soLuong = " + var10000 + " where maPhong = '" + dvp.getMaPhong()
					+ "' and maDV = '" + dvp.getMaDichVu() + "'";
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
			String sql = "Select * from DichVuPhong where maPhong = '" + maPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDV = rs.getString(1);
				String maPhong1 = rs.getString(2);
				double gia = this.dvDao.timTheoMaDichVu(maDV).getGiaDV();
				int soLuong = rs.getInt(3);
				this.dvp = new DichVuPhong(maDV, maPhong1, soLuong);
				this.arGia.add(gia * (double) soLuong);
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
	public boolean themDanhSachDichVuPhong(ArrayList<String> maPhong, ArrayList<String> dsDichVu,
			ArrayList<Integer> dsSoLuong) {

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			for (int i = 0; i < dsDichVu.size(); i++) {
				String maDVSU = String.format("%s%s", maPhong.get(i), String.valueOf(dsSoLuong.get(i)));
				String sql = "insert into DichVuPhong values('" + maDVSU + "','" + maPhong.get(i) + "','" + dsDichVu.get(i) + "',"
						+ dsSoLuong.get(i) + ")";
				stmt.executeUpdate(sql);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<DichVuPhong> timDichVuPhongTheoMaPhong(ArrayList<String> dsPhong) {
		ArrayList<DichVuPhong> dsDV = new ArrayList<DichVuPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			for (String maPhong : dsPhong) {
				String sql = "Select * from DichVuPhong where maPhong = '" + maPhong + "'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					String maDV = rs.getString(1);
					String maPhong1 = rs.getString(2);
					int soLuong = rs.getInt(3);
					dvp = new DichVuPhong(maDV, maPhong1, soLuong);
					dsDV.add(dvp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDV;
	}

	public DichVu timTheoMaDichVu(String maDV) {
		try {
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from DichVu where maDV = '" + maDV + "'";
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
			String sql = "Select * from DichVuPhong where maDV = '" + maDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV1 = rs.getString(1);
				String maPhong = rs.getString(2);
				double gia = this.dvDao.timTheoMaDichVu(maDV1).getGiaDV();
				int soLuong = rs.getInt(3);
				this.dvp = new DichVuPhong(maDV1, maPhong, soLuong);
				this.arGia.add(gia * (double) soLuong);
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
}
