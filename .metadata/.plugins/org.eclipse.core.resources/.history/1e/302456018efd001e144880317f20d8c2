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
import entity.KhachHang;

public class KhachHang_Dao {
	private List<KhachHang> dsKH;

	public KhachHang_Dao() {
		dsKH = new ArrayList<KhachHang>();
	}

	public List<KhachHang> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return dsKH; // Trả về danh sách trống hoặc xử lý một cách thích hợp
			}
			String query = "select * from KhachHang";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String sdt = rs.getString(2);
				String tenKH = rs.getString(3);
				KhachHang kh = new KhachHang(maKH, sdt, tenKH);
				dsKH.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKH;
	}

	public List<KhachHang> getDSKH() {
		return dsKH;
	}

	// Thêm khách hàng vào database
	public void addKhachHang(KhachHang kh) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			String query = "INSERT INTO KhachHang VALUES ('" + kh.getMaKH() + "', '" + kh.getSoDienThoai() + "', '"
					+ kh.getHoTen() + "')";
			try (Statement stm = con.createStatement()) {
				stm.executeUpdate(query);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Xóa khách hàng trong database
	public boolean deleteKhachHang(KhachHang kh) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			
//			Kiểm tra các đơn hàng có mã KH? -> Update
			HoaDon_Dao hdDao = new HoaDon_Dao();
			List<HoaDon> listHD = hdDao.findKH(kh.getMaKH());
			if(listHD != null) {
				for (HoaDon hoaDon : listHD) {
					hdDao.updateKhachInHoaDon(hoaDon.getMaHoaDon());
				}
			}
			
//			Kiểm tra đơn đặt có mã KH? -> Update
			DonDat_Dao ddDao = new DonDat_Dao();
			List<DonDat> listDD = ddDao.findKH(kh.getMaKH());
			if(listHD != null) {
				for (DonDat donDat : listDD) {
					ddDao.updateKhachInDonDat(donDat.getMaDonDat());
				}
			}
			
			String query = "DELETE FROM KhachHang WHERE maKH = '" + kh.getMaKH() + "'";
			try (Statement stm = con.createStatement()) {
				stm.executeUpdate(query);
				dsKH.remove(kh);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public KhachHang findBySDT(String sdtKH) {
		KhachHang kh = null;
		if (!sdtKH.equals("")) {
			try {
				Connection con = ConnectDB.getInstance().getConnection();
				if (con == null) {
					System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
					return null;
				}
				String query = "SELECT * FROM KhachHang WHERE soDienThoai = ?";
				PreparedStatement stm = con.prepareStatement(query);
				stm.setString(1, sdtKH);
				ResultSet rs = stm.executeQuery(); // Sử dụng executeQuery() mà không có đối số
				if (rs.next()) {
					String maKH = rs.getString(1);
					String tenKH = rs.getString(3);
					kh = new KhachHang(maKH, sdtKH, tenKH);
				}
				return kh;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}

	public KhachHang findById(String maKH) {
		KhachHang kh = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return null;
			}
			String query = "SELECT * FROM KhachHang WHERE maKH = ?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, maKH);
			ResultSet rs = stm.executeQuery(); 
			if (rs.next()) {
				String sdtKH = rs.getString(2);
				String tenKH = rs.getString(3);
				kh = new KhachHang(maKH, sdtKH, tenKH);
			}
			return kh;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public KhachHang findKhachHangBySDT(String sdt) {
		KhachHang kh = null;
        try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return null;
			}
			String query = "SELECT * FROM KhachHang WHERE soDienThoai = ?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, sdt);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(3);
				kh = new KhachHang(maKH, sdt, tenKH);
			}
			return kh;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
        }
    
	}

	public boolean updateKhachHang(KhachHang kh) {
		try {
            Connection con = ConnectDB.getInstance().getConnection();
            if (con == null) {
                System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
                return false;
            }
            String query = "UPDATE KhachHang SET soDienThoai = ?, hoTen = ? WHERE maKH = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, kh.getSoDienThoai());
            stm.setString(2, kh.getHoTen());
            stm.setString(3, kh.getMaKH());
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    
	}
	

}
