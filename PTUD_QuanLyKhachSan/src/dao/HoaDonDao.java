package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.DichVu;
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
				String maHD = rs.getString(1);
				String nhanVien = rs.getString(2);
				String khachHang = rs.getString(3);
				LocalDateTime ngayLap = rs.getTimestamp(4).toLocalDateTime();
				String maLSDP = rs.getString(5);
				String maKM = rs.getString(6);
				double tongTien = rs.getDouble(7);
				HoaDon hoaDon = new HoaDon(maHD, nhanVien, khachHang, ngayLap, maLSDP, maKM, tongTien);
				dsHoaDon.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}
	
	// Tìm tất cả hóa đơn có trong ngày
	public List<HoaDon> timHoaDonTrongNgay(LocalDate ngay) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;

        try {
            // Câu lệnh SQL để tìm hóa đơn trong ngày
            String sql = "SELECT * FROM HoaDon WHERE NgayLapHD >= ? AND NgayLapHD < ?";
            pstmt = con.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số
            LocalDateTime ngayBatDau = ngay.atStartOfDay();
            LocalDateTime ngayKetThuc = ngay.plusDays(1).atStartOfDay();

            pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau));
            pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc));

            // Thực thi câu lệnh và xử lý kết quả
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHD"));
                hoaDon.setMaNhanVien(rs.getString("MaNV"));
                hoaDon.setMaKhachHang(rs.getString("MaKH"));
                hoaDon.setNgayLap(rs.getTimestamp("NgayLapHD").toLocalDateTime());
                hoaDon.setMaLSDP(rs.getString("MaLSDP"));
                hoaDon.setMaKM(rs.getString("MaKM"));
                hoaDon.setTongTien(rs.getDouble("TongTien"));        
                danhSachHoaDon.add(hoaDon);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }


	// thêm hóa đơn
	public boolean themHoaDon(HoaDon hoaDon) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement pstmt = null;
	    int n = 0;
	    try {
	        // Kiểm tra xem hóa đơn có tồn tại trong CSDL không
	        String sqlCheck = "SELECT COUNT(*) FROM HoaDon WHERE MaHD = ?";
	        pstmt = con.prepareStatement(sqlCheck);
	        pstmt.setString(1, hoaDon.getMaHoaDon());
	        ResultSet rs = pstmt.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);
	        rs.close();
	        pstmt.close();

	        // Nếu hóa đơn không tồn tại, thực hiện thêm mới
	        if (count == 0) {
	            // Xử lý ngày lập
	            Timestamp ngayLapHD = Timestamp.valueOf(hoaDon.getNgayLap());
	            // Thêm hóa đơn vào CSDL
	            String sqlInsert = "INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM , TongTien, ThueVAT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            pstmt = con.prepareStatement(sqlInsert);
	            pstmt.setString(1, hoaDon.getMaHoaDon());
	            pstmt.setString(2, hoaDon.getMaNhanVien());
	            pstmt.setString(3, hoaDon.getMaKhachHang());
	            pstmt.setTimestamp(4, ngayLapHD);
	            pstmt.setString(5, hoaDon.getMaLSDP());
	            pstmt.setString(6, hoaDon.getMaKM());
	            pstmt.setDouble(7, hoaDon.getTongTien());
	            pstmt.setDouble(8, hoaDon.getVAT());

	            n = pstmt.executeUpdate();
	            pstmt.close();
	            return n > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
//	 public boolean themDichVu(DichVu dv) {
//         ConnectDB.getInstance();
//         Connection con = ConnectDB.getConnection();
//         Statement stmt = null;
//         int n = 0;
//         try {
//             // Kiểm tra xem dịch vụ có tồn tại trong CSDL không
//             String sqlCheck = "SELECT COUNT(*) FROM DichVu WHERE maDV = '" + dv.getMaDV() + "'";
//             stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sqlCheck);
//             rs.next();
//             int count = rs.getInt(1);
//             rs.close();
//             stmt.close();
//
//             // Nếu dịch vụ không tồn tại, thực hiện thêm mới
//             if (count == 0) {
//                 stmt = con.createStatement();
//                 String sqlInsert = "INSERT INTO DichVu VALUES ('" + dv.getMaDV() + "', N'" + dv.getTenDV() + "', " + dv.getGiaDV() + ")";
//                 n = stmt.executeUpdate(sqlInsert);
//                 stmt.close();
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return n > 0;
//     }

	// sửa hóa đơn
	public boolean suaHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsHoaDon.contains(hoaDon)) {
			try {
				stmt = con.createStatement();
				String sql = "update HoaDon set nhanVien = '" + hoaDon.getMaNhanVien() + "', ngayLap = '"
						+ hoaDon.getNgayLap() + "', khachHang = '" + hoaDon.getMaKhachHang()
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

	
	// Đếm số hóa đơn trong ngày
	public int demSoHoaDonTrongNgay(LocalDate ngay) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		int soLuong = 0;

		try {
			// Câu lệnh SQL để đếm số hóa đơn trong ngày
			String sql = "SELECT COUNT(*) FROM HoaDon WHERE NgayLapHD >= ? AND NgayLapHD < ?";
			pstmt = con.prepareStatement(sql);

			// Thiết lập giá trị cho các tham số
			LocalDateTime ngayBatDau = ngay.atStartOfDay();
			LocalDateTime ngayKetThuc = ngay.plusDays(1).atStartOfDay();

			pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau));
			pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc));

			// Thực thi câu lệnh và xử lý kết quả
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			soLuong = rs.getInt(1);

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return soLuong;
	}
	
	
	public static void main(String[] args) {
		// test tìm tất cả hóa đơn
		HoaDonDao hoaDonDao = new HoaDonDao();
		
//		// test thêm hóa đơn

		HoaDon hd = new HoaDon("HD023", "NV001", "KH004", LocalDateTime.now(), null , "KM001", 1000000);
		
		boolean kq = hoaDonDao.themHoaDon(hd);
		
		if (kq) {
			System.out.println("Thêm thành công");
		} else {
			System.out.println("Thêm thất bại");
		}
		
		// test tìm hóa đơn trong ngày
		List<HoaDon> dsHoaDon = hoaDonDao.timHoaDonTrongNgay(LocalDate.now());
		for (HoaDon hoaDon : dsHoaDon) {
			System.out.println(hoaDon);
		}
		
		// test đếm số hóa đơn trong ngày
		int soLuong = hoaDonDao.demSoHoaDonTrongNgay(LocalDate.now());
		System.out.println("Số lượng hóa đơn trong ngày: " + soLuong);
	}
}
