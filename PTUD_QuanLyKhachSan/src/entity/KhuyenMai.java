package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class KhuyenMai {
	private String maKM;
	private String tenKM;
	private double giaTriKM;
	private LocalDate thoiGianBatDau;
	private LocalDate thoiGianKetThuc;
	private double dieuKienApDung;

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public Double getGiaTriKM() {
		return giaTriKM;
	}

	public void setGiaTriKM(Double giaTriKM) {
		this.giaTriKM = giaTriKM;
	}

	public LocalDate getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public LocalDate getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public double getDieuKienApDung() {
		return dieuKienApDung;
	}

	public void setDieuKienApDung(double dieuKienApDung) {
		this.dieuKienApDung = dieuKienApDung;
	}

	

	public KhuyenMai(String maKM, String tenKM, Double giaTriKM, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc,
			double dieuKienApDung) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.giaTriKM = giaTriKM;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.dieuKienApDung = dieuKienApDung;
	}

	public KhuyenMai() {
		super();
	}

	public KhuyenMai(String maKM) {
		super();
		this.maKM = maKM;
	}

}
