package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVuPhong;
import entity.LichSuDoiPhong;

public class LichSuDoiPhongDao {
ArrayList<LichSuDoiPhong> listLichSuDoiPhong;
LichSuDoiPhong  lichSuDoiPhong;

public LichSuDoiPhongDao() {
	listLichSuDoiPhong = new ArrayList<LichSuDoiPhong>();
	lichSuDoiPhong = new LichSuDoiPhong();
	
}

// tìm tất cả lịch sử đổi phòng
public ArrayList<LichSuDoiPhong> timTatCaLichSuDoiPhong(){
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from LichSuDoiPhong";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			String maLSDP = rs.getString(1);
			String maTTDTP = rs.getString(2);
			String maPhongCu = rs.getString(3);
			String maPhongMoi = rs.getString(4);
			LocalDate ngayDoiPhong = rs.getDate(5).toLocalDate();
			String lyDo = rs.getString(6);
			lichSuDoiPhong = new LichSuDoiPhong(maLSDP, maTTDTP, maPhongCu, maPhongMoi, ngayDoiPhong, lyDo);
			listLichSuDoiPhong.add(lichSuDoiPhong);
		}
	} catch (Exception var8) {
		var8.printStackTrace();
	}

	return listLichSuDoiPhong;
}


// thêm lịch sử đổi phòng
public boolean themLichSuDoiPhong(LichSuDoiPhong lichSuDoiPhong) {
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into LichSuDoiPhong values(?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, lichSuDoiPhong.getMaLSDP());
		stmt.setString(2, lichSuDoiPhong.getMaTTDTP());
		stmt.setString(3, lichSuDoiPhong.getMaPhongCu());
		stmt.setString(4, lichSuDoiPhong.getMaPhongMoi());
		stmt.setDate(5, Date.valueOf(lichSuDoiPhong.getNgayDoi()));
		stmt.setString(6, lichSuDoiPhong.getLyDo());
		int rs = stmt.executeUpdate();
		if (rs > 0) {
			return true;
		}
	} catch (Exception var8) {
		var8.printStackTrace();
	}

	return false;
}
// tìm lịch sử đôi phòng theo mã lịch sử đổi phòng
public LichSuDoiPhong timLichSuDoiPhongTheoMaLSDP(String maLSDP) {
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from LichSuDoiPhong where maLSDP = '" + maLSDP + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String maLSDP1 = rs.getString(1);
			String maTTDTP = rs.getString(2);
			String maPhongCu = rs.getString(3);
			String maPhongMoi = rs.getString(4);
			LocalDate ngayDoiPhong = rs.getDate(5).toLocalDate();
			String lyDo = rs.getString(6);
			lichSuDoiPhong = new LichSuDoiPhong(maLSDP1, maTTDTP, maPhongCu, maPhongMoi, ngayDoiPhong, lyDo);
		}
	} catch (Exception var8) {
		var8.printStackTrace();
	}

	return lichSuDoiPhong;
}

// tìm lịch sử đôi phòng theo mã phòng cũ
public LichSuDoiPhong timLichSuDoiPhongTheoMaPhongCu(String maPhongCu) {
    try {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "Select * from LichSuDoiPhong where maPhongCu = '" + maPhongCu + "'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String maLSDP = rs.getString(1);
            String maTTDTP = rs.getString(2);
            String maPhongCu1 = rs.getString(3);
            String maPhongMoi = rs.getString(4);
            LocalDate ngayDoiPhong = rs.getDate(5).toLocalDate();
            String lyDo = rs.getString(6);
            lichSuDoiPhong = new LichSuDoiPhong(maLSDP, maTTDTP, maPhongCu1, maPhongMoi, ngayDoiPhong, lyDo);
        }
    } catch (Exception var8) {
        var8.printStackTrace();
    }

    return lichSuDoiPhong;}

// tìm lịch sử đôi phòng theo mã phòng mới
public LichSuDoiPhong timLichSuDoiPhongTheoMaPhongMoi(String maPhongMoi) {
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from LichSuDoiPhong where maPhongMoi = '" + maPhongMoi + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String maLSDP = rs.getString(1);
			String maTTDTP = rs.getString(2);
			String maPhongCu = rs.getString(3);
			String maPhongMoi1 = rs.getString(4);
			LocalDate ngayDoiPhong = rs.getDate(5).toLocalDate();
			String lyDo = rs.getString(6);
			lichSuDoiPhong = new LichSuDoiPhong(maLSDP, maTTDTP, maPhongCu, maPhongMoi1, ngayDoiPhong, lyDo);
		}
	} catch (Exception var8) {
		var8.printStackTrace();
	}

	return lichSuDoiPhong;
}

// đếm lịch sử đổi phòng theo mã phòng cũ
public int demLichSuDoiPhongTheoMaPhongCu(String maPhongCu) {
	int count = 0;
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select count(*) from LichSuDoiPhong where maPhongCu = '" + maPhongCu + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			count = rs.getInt(1);
		}
	} catch (Exception var8) {
		var8.printStackTrace();
	}

	return count;
}
}
