package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class HoaDon {
	private String maHoaDon;
	private String maNhanVien;
	private String maKhachHang;
	private LocalDateTime ngayLap;
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

	public double getVAT() {
		return VAT;
	}

	public HoaDon() {
		super();
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maNhanVien=" + maNhanVien + ", maKhachHang=" + maKhachHang
				+ ", ngayLap=" + ngayLap +  ", VAT=" + VAT + "]";
	}

	public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, LocalDateTime ngayLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.ngayLap = ngayLap;
	}

	
	
}
