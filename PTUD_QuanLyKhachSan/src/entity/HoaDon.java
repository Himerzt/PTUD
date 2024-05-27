package entity;

import java.time.LocalDateTime;

public class HoaDon {
    private String maHD;
    private String maNV;
    private String maKH;
    private LocalDateTime ngayLapHD;
    private double tongTien;
    private double thueVAT;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public LocalDateTime getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(LocalDateTime ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(double thueVAT) {
        this.thueVAT = thueVAT;
    }

    public HoaDon() {
        super();
    }

    @Override
    public String toString() {
        return "HoaDon [maHD=" + maHD + ", maNV=" + maNV + ", maKH=" + maKH
                + ", ngayLapHD=" + ngayLapHD + ", tongTien=" + tongTien + ", thueVAT=" + thueVAT + "]";
    }

    public HoaDon(String maHD, String maNV, String maKH, LocalDateTime ngayLapHD) {
        super();
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayLapHD = ngayLapHD;
        this.tongTien = tongTien;
        this.thueVAT = thueVAT;
    }
}
