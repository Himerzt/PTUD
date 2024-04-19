package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import db.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDon_Dao {
	List<HoaDon> dshd = new ArrayList<HoaDon>();
	Connection con = null;
	PreparedStatement pstmt = null;

	public HoaDon_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dshd = new ArrayList<HoaDon>();
	}

	public List<HoaDon> readFromTable() {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		try {
			String query = "select * from HoaDon";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maHD = rs.getString(1);

				KhachHang_Dao khDao = new KhachHang_Dao();
				String maKH = rs.getString(2);
				KhachHang kh = khDao.findById(maKH);

				NhanVien_Dao nvDao = new NhanVien_Dao();
				String maNV = rs.getString(3);
				NhanVien nv = nvDao.getNhanVien(maNV).get(0);
				Date ngayLap = rs.getDate(4);
				Date ngayNhan = rs.getDate(5);

				HoaDon hd = new HoaDon(maHD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate());

				ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Dao();
				List<ChiTietHoaDon> listCTHD = cthdDao.findByID(maHD);

				hd.setListChiTietHoaDon(listCTHD);

				listHD.add(hd);
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addOne(HoaDon hoaDon) {
		try {
			String query = "INSERT INTO HoaDon VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, hoaDon.getMaHoaDon());
			pstmt.setString(2, hoaDon.getMaKH().getMaKH());
			pstmt.setString(3, hoaDon.getMaNV().getMaNV());
			pstmt.setDate(4, Date.valueOf(hoaDon.getNgayLap()));
			pstmt.setDate(5, Date.valueOf(hoaDon.getNgayNhan()));
			pstmt.executeUpdate();
			pstmt.close();

			ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Dao();
			cthdDao.add(hoaDon);

			dshd.add(hoaDon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	ID
	public HoaDon findByID(String maHoaDon) {
		HoaDon hoaDon = null;
		String query = "select * from HoaDon where maHoaDon = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maHoaDon);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // Di chuyển con trỏ đến dòng đầu tiên của kết quả
				String maHD = rs.getString(1);

				// Khách Hàng
				String maKH = rs.getString(2);
				KhachHang_Dao khachDao = new KhachHang_Dao();
				KhachHang kh = khachDao.findById(maKH);

				// Nhân Viên
				String maNV = rs.getString(3);
				NhanVien_Dao nhanVienDao = new NhanVien_Dao();
				NhanVien nv = nhanVienDao.getNhanVien(maNV).get(0);

				Date ngayLap = rs.getDate(4);
				Date ngayNhan = rs.getDate(5);
				hoaDon = new HoaDon(maHD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate());

				ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Dao();
				List<ChiTietHoaDon> listCTHD = cthdDao.findByID(maHoaDon);

				hoaDon.setListChiTietHoaDon(listCTHD);
			}

			rs.close();
			pstmt.close();

			return hoaDon;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	NHÂN VIÊN
	public List<HoaDon> findByNhanVien(String maNV) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where maNV = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maNV);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	NGÀY LẬP
	public List<HoaDon> findByNgayLap(LocalDate ngayLap) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayLap = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayLap));

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	NGÀY NHẬN
	public List<HoaDon> findByNgayNhan(LocalDate ngayNhan) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayNhan = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayNhan));

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateKhachInHoaDon(String maHD) {
		String query = "Update HoaDon Set maKH = ? Where maHoaDon = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "KH00000");
			pstmt.setString(2, maHD);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateNhanVienInHoaDon(String maHD) {
		String query = "Update HoaDon Set maNV = ? Where maHoaDon = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "NV000");
			pstmt.setString(2, maHD);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	THỐNG KÊ FULL FIELD
	public List<HoaDon> findTKFullField(LocalDate ngayLap, String maNV, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayLap = ? AND maNV = ? AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayLap));
			pstmt.setString(2, maNV);
			pstmt.setString(3, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Thống kê đơn của KH X được lập bởi NV Y theo tháng
	public List<HoaDon> findXYinMonth(LocalDate ngayLap, String maNV, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE MONTH(ngayLap) = ? AND YEAR(ngayLap) = ? AND maNV = ? AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getMonthValue());
			pstmt.setInt(2, ngayLap.getYear());
			pstmt.setString(3, maNV);
			pstmt.setString(4, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Thống kê đơn của KH X được lập bởi NV Y theo năm
	public List<HoaDon> findXYinYear(LocalDate ngayLap, String maNV, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ? AND maNV = ? AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getYear());
			pstmt.setString(2, maNV);
			pstmt.setString(3, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Thống kê đơn của KH X được lập bởi NV Y 
	public List<HoaDon> findXByY(String maNV, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE maNV = ? AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maNV);
			pstmt.setString(2, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	DANH SÁCH
	public List<HoaDon> getDSHD() {
		return dshd;
	}

	public double tinhTongTien(HoaDon hoaDon) {
		double doanhThu = 0.0;
		if (hoaDon.getListChiTietHoaDon() != null) {
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
				double giaBan = chiTietHoaDon.getMaThuoc().getGiaBan();
				int soLuong = chiTietHoaDon.getSoLuong();
				doanhThu += giaBan * soLuong;
			}
		} else
			return 0;
		return doanhThu;
	}

	public double tinhLoiNhuanChoHoaDon(HoaDon hoaDon) {
		double loiNhuan = 0.0;
		if (hoaDon.getListChiTietHoaDon() != null) {
			for (ChiTietHoaDon chiTiet : hoaDon.getListChiTietHoaDon()) {
				double giaNhap = chiTiet.getMaThuoc().getGiaNhap();
				double giaBan = chiTiet.getMaThuoc().getGiaBan();
				int soLuong = chiTiet.getSoLuong();
				loiNhuan += (giaBan - giaNhap) * soLuong;
			}
		} else
			return 0;
		return loiNhuan;
	}

// NHÂN VIÊN

//	Thống kê đơn của NV Y
	public List<HoaDon> findNV(String maNV) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE maNV = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maNV);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Thống kê đơn của NV Y theo năm
	public List<HoaDon> findNVinYear(LocalDate ngayLap, String maNV) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ? AND maNV = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getYear());
			pstmt.setString(2, maNV);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Thống kê đơn của NV Y theo tháng
	public List<HoaDon> findNVinMonth(LocalDate ngayLap, String maNV) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE MONTH(ngayLap) = ? AND YEAR(ngayLap) = ? AND maNV = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getMonthValue());
			pstmt.setInt(2, ngayLap.getYear());
			pstmt.setString(3, maNV);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Thống kê đơn của NV Y theo ngày
	public List<HoaDon> findNVinDay(LocalDate ngayLap, String maNV) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayLap = ?  AND maNV = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayLap));
			pstmt.setString(2, maNV);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

// KHÁCH HÀNG

//	Thống kê đơn của KH X
	public List<HoaDon> findKH(String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//		Thống kê đơn của KH X theo năm
	public List<HoaDon> findKHinYear(LocalDate ngayLap, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ? AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getYear());
			pstmt.setString(2, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//		Thống kê đơn của KH X theo tháng
	public List<HoaDon> findKHinMonth(LocalDate ngayLap, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE MONTH(ngayLap) = ? AND YEAR(ngayLap) = ? AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getMonthValue());
			pstmt.setInt(2, ngayLap.getYear());
			pstmt.setString(3, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//		Thống kê đơn của KH X theo ngày
	public List<HoaDon> findKHinDay(LocalDate ngayLap, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayLap = ?  AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayLap));
			pstmt.setString(2, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//		Thống kê đơn theo năm
	public List<HoaDon> findinYear(LocalDate ngayLap) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getYear());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//		Thống kê đơn theo tháng
	public List<HoaDon> findinMonth(LocalDate ngayLap) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "SELECT * FROM HoaDon WHERE MONTH(ngayLap) = ? AND YEAR(ngayLap) = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ngayLap.getMonthValue());
			pstmt.setInt(2, ngayLap.getYear());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//		Thống kê đơn theo ngày
	public List<HoaDon> findinDay(LocalDate ngayLap) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayLap = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayLap));

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

// Phương thức thống kê top 3 khách hàng có số đơn hàng nhiều nhất
	public List<HoaDon> thongKeKHTiemNang() {
		// Khởi tạo một map để lưu số đơn hàng của mỗi khách hàng
		Map<String, Integer> khachHangCountMap = new HashMap<>();

		// Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
		List<HoaDon> allHoaDon = readFromTable();

		// Đếm số đơn hàng của mỗi khách hàng
		for (HoaDon hoaDon : allHoaDon) {
			String maKH = hoaDon.getMaKH().getMaKH();
			if (!maKH.equals("KH00000"))
				khachHangCountMap.put(maKH, khachHangCountMap.getOrDefault(maKH, 0) + 1);
		}

		// Sắp xếp theo số đơn hàng giảm dần và chọn ra khách hàng tiềm năng có số đơn
		// hàng cao nhất
		Optional<Map.Entry<String, Integer>> topKhachHangEntry = khachHangCountMap.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).findFirst();

		List<HoaDon> topHoaDonList = new ArrayList<>(); // Danh sách hóa đơn của khách hàng tiềm năng có số đơn hàng cao
														// nhất

		// Nếu có khách hàng tiềm năng, tạo danh sách hóa đơn chứa thông tin của khách
		// hàng đó
		if (topKhachHangEntry.isPresent()) {
			String topMaKH = topKhachHangEntry.get().getKey();
			KhachHang_Dao khachHangDao = new KhachHang_Dao();
			KhachHang topKhachHang = khachHangDao.findById(topMaKH);

			// Lọc danh sách hóa đơn theo mã khách hàng tiềm năng
			topHoaDonList = allHoaDon.stream().filter(hoaDon -> hoaDon.getMaKH().getMaKH().equals(topMaKH))
					.collect(Collectors.toList());
		}

		return topHoaDonList;
	}

	public List<HoaDon> thongKeNVChamChi() {
		// Khởi tạo một map để lưu số đơn hàng của mỗi nhân viên
		Map<String, Integer> nhanVienCountMap = new HashMap<>();

		// Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
		List<HoaDon> allHoaDon = readFromTable();

		// Đếm số đơn hàng của mỗi nhân viên
		for (HoaDon hoaDon : allHoaDon) {
			String maNV = hoaDon.getMaNV().getMaNV();
			if (!maNV.equals("NV000"))
				nhanVienCountMap.put(maNV, nhanVienCountMap.getOrDefault(maNV, 0) + 1);
		}

		// Sắp xếp theo số đơn hàng giảm dần và chọn ra top 3 nhân viên lập số đơn nhiều
		// nhất
		Optional<Map.Entry<String, Integer>> topNhanVienEntry = nhanVienCountMap.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).findFirst();

		List<HoaDon> topHoaDonList = new ArrayList<>(); // Danh sách hóa đơn của nhân viên lập số đơn hàng nhiều nhất

		// Nếu có nhân viên lập số đơn hàng nhiều nhất, tạo danh sách hóa đơn của nhân
		// viên đó
		if (topNhanVienEntry.isPresent()) {
			String topMaNV = topNhanVienEntry.get().getKey();

			// Lọc danh sách hóa đơn theo mã của nhân viên lập số đơn hàng nhiều nhất
			topHoaDonList = allHoaDon.stream().filter(hoaDon -> hoaDon.getMaNV().getMaNV().equals(topMaNV))
					.collect(Collectors.toList());
		}

		return topHoaDonList;
	}

	public List<HoaDon> thongKeLoiNhuanCaoNhat() {
		// Khởi tạo một map để lưu lợi nhuận của mỗi đơn hàng
		Map<String, Double> loiNhuanMap = new HashMap<>();

		// Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
		List<HoaDon> allHoaDon = readFromTable();

		// Tính lợi nhuận cho mỗi đơn hàng
		for (HoaDon hoaDon : allHoaDon) {
			double loiNhuan = tinhLoiNhuanChoHoaDon(hoaDon);
			loiNhuanMap.put(hoaDon.getMaHoaDon(), loiNhuan);
		}

		// Sắp xếp theo lợi nhuận giảm dần và chọn ra top 3 đơn hàng có lợi nhuận cao
		// nhất
		List<HoaDon> top3HoaDon = loiNhuanMap.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3).map(e -> findByID(e.getKey()))
				.collect(Collectors.toList());

		return top3HoaDon;
	}

	public boolean checkThuoc(String maThuoc) {
		String query = "SELECT * FROM ChiTietHoaDon WHERE maThuoc = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maThuoc);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
