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
import entity.DichVuPhong;
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
	
	// Lấy tên khách hàng từ mã khách hàng trong hóa đơn SELECT k.TenKhachHang FROM HoaDon hd JOIN KhachHang k  
//	ON hd.MaKH = k.MaKH WHERE hd.MaHD = 'HD26052024005'
	public String layTenKhachHangTuMaHoaDon(String maHoaDon) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement pstmt = null;
	    String tenKhachHang = "";
	    ResultSet rs = null;
	    try {
	        String sql = "SELECT k.TenKhachHang FROM HoaDon hd JOIN KhachHang k ON hd.MaKH = k.MaKH WHERE hd.MaHD = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, maHoaDon);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            tenKhachHang = rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return tenKhachHang;
	}
	
	// Xử lý ngày đặt ngày nhân và ngày trả phòng
	public ArrayList<String> layNgayDatNhanTratuMaHoaDon(String maHoaDon) {
		ArrayList<String> dsngayDatNhanTra = new ArrayList<String>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT tt.NgayDatPhong, tt.NgayNhanPhong , tt.NgayTraPhong FROM HoaDon hd JOIN ChiTietHoaDon cthd ON hd.MaHD = cthd.MaHD JOIN ThongTinDatThuePhong tt ON cthd.MaTTDTP = tt.MaTTDTP WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dsngayDatNhanTra.add(rs.getString(1));
				dsngayDatNhanTra.add(rs.getString(2));
				dsngayDatNhanTra.add(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsngayDatNhanTra;
	}

	public ArrayList<DichVuPhong> layDichPhongSuDung(String maHoaDon){
		ArrayList<DichVuPhong> dsDichVuPhong = new ArrayList<DichVuPhong>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT dvsd.MaDichVu , dvsd.MaDichVuSuDung , dvsd.MaPhong , dvsd.SoLuong FROM HoaDon hd JOIN ChiTietHoaDon chd ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt ON chd.MaTTDTP = tt.MaTTDTP JOIN DichVuSuDung dvsd ON tt.MaPhong = dvsd.MaPhong WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DichVuPhong dv = new DichVuPhong();
				dv.setMaDichVu(rs.getString(1));
				dv.setMaDichVuSuDung(rs.getString(2));
				dv.setMaPhong(rs.getString(3));
				dv.setSoLuong(rs.getInt(4));
				dsDichVuPhong.add(dv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDichVuPhong;
		
	}
	
	
	// Xử lý lấy danh sách mã phòng đã đặt ArrayList<String> dsMaPhong = hoaDonDao.layMaPhongDaDat("HD27052024001");
//	SELECT tt.MaPhong FROM HoaDon hd JOIN ChiTietHoaDon chd 
//	ON hd.MaHD = chd.MaHD
//	JOIN ThongTinDatThuePhong tt
//	ON chd.MaTTDTP = tt.MaTTDTP
//	WHERE hd.MaHD = 'HD27052024001'
	public ArrayList<String> layMaPhongDaDat(String maHoaDon) {
		ArrayList<String> dsMaPhong = new ArrayList<String>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT tt.MaPhong FROM HoaDon hd JOIN ChiTietHoaDon chd ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt ON chd.MaTTDTP = tt.MaTTDTP WHERE hd.MaHD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, maHoaDon);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dsMaPhong.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsMaPhong;
	}
 	
	
	public static void main(String[] args) {
		// ttesst tìm tên khách hàng với mã hóa đon HD26052024005
		HoaDonDao hoaDonDao = new HoaDonDao();
		String tenKhachHang = hoaDonDao.layTenKhachHangTuMaHoaDon("HD27052024001");
		ArrayList<String> dsNgayDaatNhanTra = hoaDonDao.layNgayDatNhanTratuMaHoaDon("HD27052024001");
		System.out.println(dsNgayDaatNhanTra);
		System.out.println(tenKhachHang);
		// test tìm dịch vụ 
		ArrayList<DichVuPhong> dsDichVuPhong = hoaDonDao.layDichPhongSuDung("HD27052024001");
		for (DichVuPhong dichVuPhong : dsDichVuPhong) {
			System.out.println(dichVuPhong.getMaDichVu() + " " + dichVuPhong.getMaDichVuSuDung() + " " + dichVuPhong.getMaPhong() + " " + dichVuPhong.getSoLuong());
		}
		// Tesst tìm mã phòng đã đặt
		ArrayList<String> dsMaPhong = hoaDonDao.layMaPhongDaDat("HD27052024001");
		System.out.println(dsMaPhong);
		
	}
}
