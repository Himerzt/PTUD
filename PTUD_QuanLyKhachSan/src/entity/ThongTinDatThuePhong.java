package entity;

import java.time.LocalDate;

public class ThongTinDatThuePhong {
	private String maDatPhong;
	private String maKhachHang;
	private String maPhong;
	private LocalDate ngayDatPhong;
	private LocalDate ngayNhanPhong;
	private LocalDate ngayTraPhong;
	private String maLoaiThue;

	public String getMaDatPhong() {
		return maDatPhong;
	}

	public void setMaDatPhong(String maDatPhong) {
		this.maDatPhong = maDatPhong;
	}

	public LocalDate getNgayDatPhong() {
		return ngayDatPhong;
	}

	public void setNgayDatPhong(LocalDate ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}

	public LocalDate getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(LocalDate ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public LocalDate getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(LocalDate ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	public ThongTinDatThuePhong(String maDatPhong) {
		super();
		this.maDatPhong = maDatPhong;
	}

	public ThongTinDatThuePhong() {
		super();
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaLoaiThue() {
		return maLoaiThue;
	}

	public void setMaLoaiThue(String maLoaiThue) {
		this.maLoaiThue = maLoaiThue;
	}

	public ThongTinDatThuePhong(String maDatPhong, String maKhachHang, String maPhong, LocalDate ngayDatPhong,
			LocalDate ngayNhanPhong, LocalDate ngayTraPhong, String maLoaiThue) {
		super();
		this.maDatPhong = maDatPhong;
		this.maKhachHang = maKhachHang;
		this.maPhong = maPhong;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.maLoaiThue = maLoaiThue;
	}
	
	@Override
	public String toString() {
		return "ThongTinDatThuePhong [maDatPhong=" + maDatPhong + ", maKhachHang=" + maKhachHang + ", maPhong="
				+ maPhong + ", ngayDatPhong=" + ngayDatPhong + ", ngayNhanPhong=" + ngayNhanPhong + ", ngayTraPhong="
				+ ngayTraPhong + ", maLoaiThue=" + maLoaiThue + "]";
	}
	
	

}
