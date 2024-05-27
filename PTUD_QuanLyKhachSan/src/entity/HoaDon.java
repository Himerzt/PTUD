package entity;

import java.time.LocalDateTime;

public class HoaDon {
	private String maHoaDon;
	private String maNhanVien;
	private String maKhachHang;
	private LocalDateTime ngayLap;
	private String maLSDP;
	private String maKM;
	private double tongTien;
	private final double VAT = 0.1;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getMaLSDP() {
		return maLSDP;
	}
	public void setMaLSDP(String maLSDP) {
		this.maLSDP = maLSDP;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public double getVAT() {
		return VAT;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maNhanVien=" + maNhanVien + ", maKhachHang=" + maKhachHang
				+ ", ngayLap=" + ngayLap + ", maLSDP=" + maLSDP + ", maKM=" + maKM + ", tongTien=" + tongTien + ", VAT="
				+ VAT + "]";
	}
	public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, LocalDateTime ngayLap, String maLSDP,
			String maKM, double tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.ngayLap = ngayLap;
		this.maLSDP = maLSDP;
		this.maKM = maKM;
		this.tongTien = tongTien;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
}
