package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.ThongTinNhanPhong;

public class ThongTinNhanPhongDao {

	private List<ThongTinNhanPhong> dsThongTinNhanPhong;
	private ThongTinNhanPhong thongTinNhanPhong;

	public ThongTinNhanPhongDao() {
		dsThongTinNhanPhong = new ArrayList<ThongTinNhanPhong>();
		thongTinNhanPhong = new ThongTinNhanPhong();
	}

	// Tạo thông tin nhận phòng
	public boolean themThongTinNhanPhong(ThongTinNhanPhong thongTinPhongNhan) {
		connectDB.ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		if (dsThongTinNhanPhong.contains(thongTinNhanPhong)) {
			try {
				stmt = con.prepareStatement("insert into ThongTinNhanPhong values(?,?,?,?,?,?)");
				stmt.setString(1, thongTinNhanPhong.getMaTTPN());
				stmt.setString(2, thongTinNhanPhong.getKhachHang().getMaKH());
				stmt.setDate(3, Date.valueOf(thongTinNhanPhong.getNgayNhanPhong()));
				stmt.setDate(4, Date.valueOf(thongTinNhanPhong.getNgayDatPhong()));
				stmt.setString(5, thongTinNhanPhong.getLoaiPhong().getMaLoaiPhong());
				stmt.setInt(6, thongTinNhanPhong.getSoLuongPhong());
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// Tìm thông tin nhận phòng theo mã thông tin nhận phòng
	public ThongTinNhanPhong timThongTinNhanPhongTheoMa(String maTTPN) {
		connectDB.ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select * from ThongTinNhanPhong where maTTPN = ?");
			stmt.setString(1, maTTPN);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thongTinNhanPhong;
	}

	// Sửa thông tin nhận phòng theo mã thông tin nhận phòng
	public boolean suaThongTinNhanPhongTheoMa(String maTTNP) {
		// Tìm thông tin nhận phòng theo mã thông tin nhận phòng
		thongTinNhanPhong = timThongTinNhanPhongTheoMa(maTTNP);
		connectDB.ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update ThongTinNhanPhong set maKH = ?, ngayNhanPhong = ?, ngayDatPhong = ?, maLoaiPhong = ?, soLuongPhong = ? where maTTPN = ?");
			stmt.setString(1, thongTinNhanPhong.getMaTTPN());
			stmt.setString(2, thongTinNhanPhong.getKhachHang().getMaKH());
			stmt.setDate(3, Date.valueOf(thongTinNhanPhong.getNgayNhanPhong()));
			stmt.setDate(4, Date.valueOf(thongTinNhanPhong.getNgayDatPhong()));
			stmt.setString(5, thongTinNhanPhong.getLoaiPhong().getMaLoaiPhong());
			stmt.setInt(6, thongTinNhanPhong.getSoLuongPhong());
			stmt.setString(7, maTTNP);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Tìm thông tin nhận phòng theo tên khách hàng
	public List<ThongTinNhanPhong> timThongTinNhanPhongTheoTen(String tenKhachHang) {
		connectDB.ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String query = "SELECT * FROM ThongTinNhanPhong WHERE tenKhachHang LIKE ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + tenKhachHang + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTTPN = rs.getString(1);
				KhachHang khachHang = new KhachHangDAO().timTheoMaKhachHang(rs.getString(2));
				Date ngayNhanPhong = rs.getDate(3);
				Date ngayDatPhong = rs.getDate(4);
				LoaiPhong maLoaiPhong = new LoaiPhongDao().timTheoMaLoaiPhong(rs.getString(5));
				int soLuongPhong = rs.getInt(6);
				thongTinNhanPhong = new ThongTinNhanPhong(maTTPN, khachHang, ngayNhanPhong.toLocalDate(),
						ngayDatPhong.toLocalDate(), maLoaiPhong, soLuongPhong);
				dsThongTinNhanPhong.add(thongTinNhanPhong);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongTinNhanPhong;
	}
}
