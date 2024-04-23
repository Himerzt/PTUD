package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoanDao {
	ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
	TaiKhoan tk;

	public TaiKhoanDao() {
		dsTaiKhoan = new ArrayList<TaiKhoan>();
		tk = new TaiKhoan();
	}

// tìm tất cả tài khoản
	public ArrayList<TaiKhoan> timTatCaTaiKhoan() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String tenDangNhap = rs.getString(1);
				String matKhau = rs.getString(2);

				tk = new TaiKhoan(tenDangNhap, matKhau);
				dsTaiKhoan.add(tk);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}

// thêm tài khoản
	public boolean themTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;

			try {
				stmt = con.createStatement();
				String sql = "insert into TaiKhoan values('" + tk.getMaNhanVien() + "','" + tk.getTenDangNhap() + "','" + tk.getMatKhau() + "')";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		
	}

	// xóa tài khoản
	public boolean xoaTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
		if (dsTaiKhoan.contains(tk)) {
			try {
				stmt = con.createStatement();
				String sql = "delete from TaiKhoan where tenDangNhap = '" + tk.getTenDangNhap() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}

	// sửa tài khoản
	public boolean suaTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stmt = null;
		int n = 0;
			try {
				stmt = con.createStatement();
				String sql = "update TaiKhoan set matKhau = '" + tk.getMatKhau() + "' where tenDangNhap = '" + tk.getTenDangNhap() + "'";
				n = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
	}

	// tìm tài khoản theo tên đăng nhập
	public TaiKhoan timTaiKhoanTheoTenDangNhap(String tenDangNhap) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from TaiKhoan where tenDangNhap = '" + tenDangNhap + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String matKhau = rs.getString(2);
				tk = new TaiKhoan(tenDangNhap, matKhau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tk;
	}
        public boolean xacThucDangNhap(String tenDangNhap, String matKhau) {
    try {
        Connection con = ConnectDB.getInstance().getConnection();

        // Tạo câu truy vấn SQL
        String sql = "SELECT * FROM TaiKhoan WHERE tenDangNhap = '" + tenDangNhap + "'";

        // Tạo một câu lệnh truy vấn
        Statement stmt = con.createStatement();

        // Thực thi truy vấn và lấy kết quả
        ResultSet rs = stmt.executeQuery(sql);

        // Kiểm tra xem có bản ghi nào được trả về không
        if (rs.next()) {
            // Lấy mật khẩu từ cơ sở dữ liệu
            String matKhauDB = rs.getString("matKhau");

            // Kiểm tra xem mật khẩu có khớp không
            if (matKhauDB.equals(matKhau)) {
                return true; // Mật khẩu khớp, đăng nhập thành công
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Mật khẩu không khớp hoặc tài khoản không tồn tại
}


}