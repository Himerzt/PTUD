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
import entity.HoaDon;

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
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLap = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");
                double thueVAT = rs.getDouble("ThueVAT");

                HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayLap);
                dsHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }
// Tìm danh sách hóa đơn với các thông tin như Mã hóa đơn, Tên khách hàng, Ngày lập hóa đơn, Tổng tiền
public List<Object[]> timDanhSachHoaDon() {
    List<Object[]> danhSachHoaDon = new ArrayList<>();
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();
    PreparedStatement pstmt = null;

    try {
        String sql = "SELECT HoaDon.MaHD, KhachHang.TenKhachHang, HoaDon.NgayLapHD, HoaDon.TongTien " +
                     "FROM HoaDon " +
                     "INNER JOIN KhachHang ON HoaDon.MaKH = KhachHang.MaKH";
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String maHD = rs.getString(1);
            String tenKH = rs.getString(2);
            LocalDateTime ngayLap = rs.getTimestamp(3).toLocalDateTime();
            double tongTien = rs.getDouble(4);

            Object[] hoaDonInfo = {maHD, tenKH, ngayLap, tongTien};
            danhSachHoaDon.add(hoaDonInfo);
        }

        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return danhSachHoaDon;
}

    // Tìm hóa đơn trong ngày
    public List<HoaDon> timHoaDonTrongNgay(LocalDate ngay) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM HoaDon WHERE NgayLapHD >= ? AND NgayLapHD < ?";
            pstmt = con.prepareStatement(sql);

            LocalDateTime ngayBatDau = ngay.atStartOfDay();
            LocalDateTime ngayKetThuc = ngay.plusDays(1).atStartOfDay();

            pstmt.setTimestamp(1, Timestamp.valueOf(ngayBatDau));
            pstmt.setTimestamp(2, Timestamp.valueOf(ngayKetThuc));

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLap = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");
                double thueVAT = rs.getDouble("ThueVAT");

                HoaDon hoaDon = new HoaDon(maHD, maNV, maKH, ngayLap);
                danhSachHoaDon.add(hoaDon);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }

    // Thêm hóa đơn
    public boolean themHoaDon(HoaDon hoaDon) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            String sqlCheck = "SELECT COUNT(*) FROM HoaDon WHERE MaHD = ?";
            pstmt = con.prepareStatement(sqlCheck);
            pstmt.setString(1, hoaDon.getMaHD());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            pstmt.close();

            if (count == 0) {
                String sqlInsert = "INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, TongTien, ThueVAT) VALUES (?, ?, ?, ?, ?, ?)";
                pstmt = con.prepareStatement(sqlInsert);
                pstmt.setString(1, hoaDon.getMaHD());
                pstmt.setString(2, hoaDon.getMaNV());
                pstmt.setString(3, hoaDon.getMaKH());
                pstmt.setTimestamp(4, Timestamp.valueOf(hoaDon.getNgayLapHD()));
                pstmt.setDouble(5, hoaDon.getTongTien());
                pstmt.setDouble(6, hoaDon.getThueVAT());

                n = pstmt.executeUpdate();
                pstmt.close();
                return n > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Sửa hóa đơn
    public boolean suaHoaDon(HoaDon hoaDon) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            String sql = "UPDATE HoaDon SET MaNV = ?, MaKH = ?, NgayLapHD = ?, TongTien = ?, ThueVAT = ? WHERE MaHD = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, hoaDon.getMaNV());
            pstmt.setString(2, hoaDon.getMaKH());
            pstmt.setTimestamp(3, Timestamp.valueOf(hoaDon.getNgayLapHD()));
            pstmt.setDouble(4, hoaDon.getTongTien());
            pstmt.setDouble(5, hoaDon.getThueVAT());
            pstmt.setString(6, hoaDon.getMaHD());

            n = pstmt.executeUpdate();
            pstmt.close();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa hóa đơn
    public boolean xoaHoaDon(HoaDon hoaDon) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, hoaDon.getMaHD());

            n = pstmt.executeUpdate();
            pstmt.close();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Tìm hóa đơn theo mã
    public HoaDon timHoaDonTheoMa(String maHoaDon) {
        HoaDon hd = null;
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon WHERE MaHD = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maHoaDon);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLap = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");
                double thueVAT = rs.getDouble("ThueVAT");

                hd = new HoaDon(maHD, maNV, maKH, ngayLap);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hd;
    }

    // Tìm hóa đơn theo mã nhân viên
    public List<HoaDon> timHoaDonTheoMaNhanVien(String maNhanVien) {
        List<HoaDon> dsHoaDon = new ArrayList<>();
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon WHERE MaNV = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maNhanVien);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLap = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");
                double thueVAT = rs.getDouble("ThueVAT");

                HoaDon hoaDon = new HoaDon(maHD, maNV, maKH, ngayLap);
                dsHoaDon.add(hoaDon);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    // Tìm hóa đơn theo mã khách hàng
    public List<HoaDon> timHoaDonTheoMaKhachHang(String maKhachHang) {
        List<HoaDon> dsHoaDon = new ArrayList<>();
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon WHERE MaKH = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maKhachHang);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLap = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");
                double thueVAT = rs.getDouble("ThueVAT");

                HoaDon hoaDon = new HoaDon(maHD, maNV, maKH, ngayLap);
                dsHoaDon.add(hoaDon);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    // Tìm hóa đơn theo ngày lập
    public List<HoaDon> timHoaDonTheoNgayLap(LocalDate ngayLap) {
        List<HoaDon> dsHoaDon = new ArrayList<>();
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon WHERE NgayLapHD = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setTimestamp(1, Timestamp.valueOf(ngayLap.atStartOfDay()));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLapHD = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");
                double thueVAT = rs.getDouble("ThueVAT");

                HoaDon hoaDon = new HoaDon(maHD, maNV, maKH, ngayLapHD);
                dsHoaDon.add(hoaDon);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    // Đếm số hóa đơn trong ngày
    public int demSoHoaDonTrongNgay(LocalDate ngay) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        int soLuong = 0;

        try {
            String sql = "SELECT COUNT(*) FROM HoaDon WHERE NgayLapHD = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setTimestamp(1, Timestamp.valueOf(ngay.atStartOfDay()));
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
    public double tinhTongHoaDonTheoNgay(int ngay, int thang, int nam) {
    double tongDoanhThu = 0;
    try {
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "SELECT SUM(TongTien) FROM HoaDon WHERE DAY(NgayLapHD) = ? AND MONTH(NgayLapHD) = ? AND YEAR(NgayLapHD) = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, ngay);
        pstmt.setInt(2, thang);
        pstmt.setInt(3, nam);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            tongDoanhThu = rs.getDouble(1);
        }
        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tongDoanhThu;
}

public double tinhTongHoaDonTheoThang(int thang, int nam) {
    double tongDoanhThu = 0;
    try {
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "SELECT SUM(TongTien) FROM HoaDon WHERE MONTH(NgayLapHD) = ? AND YEAR(NgayLapHD) = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, thang);
        pstmt.setInt(2, nam);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            tongDoanhThu = rs.getDouble(1);
        }
        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tongDoanhThu;
}

public double tinhTongHoaDonTheoNam(int nam) {
    double tongDoanhThu = 0;
    try {
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "SELECT SUM(TongTien) FROM HoaDon WHERE YEAR(NgayLapHD) = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, nam);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            tongDoanhThu = rs.getDouble(1);
        }
        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tongDoanhThu;
}
public int demSoLuongKhachHangTrongNgay(int ngay, int thang, int nam) {
    int soLuong = 0;
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();
    PreparedStatement pstmt = null;

    try {
        String sql = "SELECT COUNT(DISTINCT MaKH) AS SoLuong " +
                     "FROM HoaDon " +
                     "WHERE DAY(NgayLapHD) = ? AND MONTH(NgayLapHD) = ? AND YEAR(NgayLapHD) = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, ngay);
        pstmt.setInt(2, thang);
        pstmt.setInt(3, nam);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            soLuong = rs.getInt("SoLuong");
        }

        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return soLuong;
}
public int demSoLuongKhachHangTrongThang(int thang, int nam) {
    int soLuong = 0;
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();
    PreparedStatement pstmt = null;

    try {
        String sql = "SELECT COUNT(DISTINCT MaKH) AS SoLuong " +
                     "FROM HoaDon " +
                     "WHERE MONTH(NgayLapHD) = ? AND YEAR(NgayLapHD) = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, thang);
        pstmt.setInt(2, nam);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            soLuong = rs.getInt("SoLuong");
        }

        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return soLuong;
}
public int demSoLuongKhachHangTrongNam(int nam) {
    int soLuong = 0;
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();
    PreparedStatement pstmt = null;

    try {
        String sql = "SELECT COUNT(DISTINCT MaKH) AS SoLuong " +
                     "FROM HoaDon " +
                     "WHERE YEAR(NgayLapHD) = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, nam);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            soLuong = rs.getInt("SoLuong");
        }

        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return soLuong;
}
public List<Integer> layDanhSachNamHoaDon() {
    List<Integer> danhSachNam = new ArrayList<>();
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();
    PreparedStatement pstmt = null;

    try {
        String sql = "SELECT DISTINCT YEAR(NgayLapHD) AS Nam FROM HoaDon";
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int nam = rs.getInt("Nam");
            danhSachNam.add(nam);
        }

        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return danhSachNam;
}

}
