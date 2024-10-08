package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.DichVuPhong;

public class DichVuDao {
	ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
	DichVu dv = new DichVu();
	DichVuDao dvDao;
	DichVuPhong dvp;
	ArrayList<Double> arGia = new ArrayList<Double>();

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
	
	public void loadDanhSachDichVuVaoBang() {
		dsDichVu = timTatCaDichVu();
		
	}

	// thêm dịch vụ
        public boolean themDichVu(DichVu dv) {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            Statement stmt = null;
            int n = 0;
            try {
                // Kiểm tra xem dịch vụ có tồn tại trong CSDL không
                String sqlCheck = "SELECT COUNT(*) FROM DichVu WHERE maDV = '" + dv.getMaDV() + "'";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sqlCheck);
                rs.next();
                int count = rs.getInt(1);
                rs.close();
                stmt.close();

                // Nếu dịch vụ không tồn tại, thực hiện thêm mới
                if (count == 0) {
                    stmt = con.createStatement();
                    String sqlInsert = "INSERT INTO DichVu VALUES ('" + dv.getMaDV() + "', N'" + dv.getTenDV() + "', " + dv.getGiaDV() + ")";
                    n = stmt.executeUpdate(sqlInsert);
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }


	// sửa dịch vụ
        public boolean suaDichVu(DichVu dv) {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            Statement stmt = null;
            int n = 0;
            try {
                // Kiểm tra xem dịch vụ có tồn tại trong CSDL không
                String sqlCheck = "SELECT COUNT(*) FROM DichVu WHERE maDV = '" + dv.getMaDV() + "'";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sqlCheck);
                rs.next();
                int count = rs.getInt(1);
                rs.close();
                stmt.close();

                // Nếu dịch vụ tồn tại, thực hiện cập nhật
                if (count > 0) {
                    stmt = con.createStatement();
                    String sqlUpdate = "UPDATE DichVu SET tenDV = '" + dv.getTenDV() + "', giaDV = " + dv.getGiaDV()
                            + " WHERE maDV = '" + dv.getMaDV() + "'";
                    n = stmt.executeUpdate(sqlUpdate);
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
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
	
	public double tinhGiaDichVuCuaMotPhong(String maPhong) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from DichVuPhong where maPhong = '" + maPhong + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                String maDV = rs.getString(1);
                String maPhong1 = rs.getString(2);
                double gia = dvDao.timTheoMaDichVu(maDV).getGiaDV();
                int soLuong = rs.getInt(3);
//                dvp = new DichVuPhong(maDV, maPhong1, soLuong);
                arGia.add(gia * (double)soLuong);
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        double giaTong = 0.0;

        for (double double1 : arGia) {
			giaTong += double1;
		}

        return giaTong;
    }
	
	public ArrayList<DichVu> timDichVuTheoTenDV(ArrayList<String> tenDV) {
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		for (DichVu dichVu : dsDV) {
			
		
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu where tenDV = '" + tenDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV = rs.getString(1);
				String tenDV1 = rs.getString(2);
				double giaDV = rs.getDouble(3);
				dv = new DichVu(maDV, tenDV1, giaDV);
				dsDV.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return dsDV;
	}
	
	// tim kiem dich vu theo ma dich vu
	public DichVu timDichVuTheoMaDV(String maDV) {
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
	
	
	// tìm kiếm dịch vụ theo tên
	public ArrayList<DichVu> timDichVuTheoTenDV(String tenDV) {
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
	
	// tìm dịch vụ theo tên dịch vụ
	public DichVu timDichVuTheoTen1(String tenDV) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu where tenDV = '" + tenDV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV = rs.getString(1);
				String tenDV1 = rs.getString(2);
				double giaDV = rs.getDouble(3);
				dv = new DichVu(maDV, tenDV1, giaDV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dv;
	}
}
