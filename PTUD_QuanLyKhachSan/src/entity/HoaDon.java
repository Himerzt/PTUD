package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HoaDon {
	private String maHoaDon;
	private NhanVien nhanVien;
	private LocalDate ngayLap;
	private KhachHang khachHang;

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}



	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public HoaDon(String maHoaDon, NhanVien nhanVien, LocalDate ngayLap, KhachHang khachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.nhanVien = nhanVien;
		this.ngayLap = ngayLap;
		this.khachHang = khachHang;
	}

	public HoaDon() {
		super();
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

}
