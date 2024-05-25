package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class HoaDon {
	private String maHoaDon;
	private String maNhanVien;
	private String maKhachHang;
	private LocalDate ngayLap;
	private List<ChiTietHoaDon> dsChiTietHoaDon;
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

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public java.util.List<ChiTietHoaDon> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}

	public void setDsChiTietHoaDon(java.util.List<ChiTietHoaDon> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}

	public double getVAT() {
		return VAT;
	}

	public HoaDon(String maHoaDon, String maNhanVien, LocalDate ngayLap, String maKhachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.ngayLap = ngayLap;
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}

	public HoaDon() {
		super();
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maNhanVien=" + maNhanVien + ", maKhachHang=" + maKhachHang
				+ ", ngayLap=" + ngayLap + ", dsChiTietHoaDon=" + dsChiTietHoaDon + ", VAT=" + VAT + "]";
	}

	public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, LocalDate ngayLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.ngayLap = ngayLap;
	}

	
	
}
