package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private String gioiTinh;
	private LocalDate ngaySinh;
	private String soDT;
	private String CCCD_Visa;
	private double chiTieu;
	private String maHangThanhVien;
	private String quocTich;


	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTenKH() {
		return hoTenKH;
	}

	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public KhachHang(String maKH, String hoTenKH, String gioiTinh, LocalDate ngaySinh, String soDT, String cCCD_Visa,
			double chiTieu, String maHangThanhVien, String quocTich) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDT = soDT;
		CCCD_Visa = cCCD_Visa;
		this.chiTieu = chiTieu;
		this.maHangThanhVien = maHangThanhVien;
		this.quocTich = quocTich;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getCCCD_Visa() {
		return CCCD_Visa;
	}

	public void setCCCD_Visa(String cCCD_Visa) {
		CCCD_Visa = cCCD_Visa;
	}

	public double getChiTieu() {
		return chiTieu;
	}

	public void setChiTieu(double chiTieu) {
		this.chiTieu = chiTieu;
	}

	public String getMaHangThanhVien() {
		return maHangThanhVien;
	}
	
	public void setMaHangThanhVien(String maHangThanhVien) {
		this.maHangThanhVien = maHangThanhVien;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public KhachHang() {
		super();
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CCCD_Visa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (!CCCD_Visa.equals(other.CCCD_Visa))
			return false;
		return true;
	}

	
}
