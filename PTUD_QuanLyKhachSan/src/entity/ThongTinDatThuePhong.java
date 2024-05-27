package entity;

import java.time.LocalDateTime;
import java.util.List;

public class ThongTinDatThuePhong {
	private String maTTDTP;
	private String maKhachHang;
	private String maPhong;
	private LocalDateTime ngayDatPhong;
	private LocalDateTime ngayNhanPhong;
	private LocalDateTime ngayTraPhong;
	private String maLoaiThue;
	private double tienDaCoc;
	private String trangThai;

	public ThongTinDatThuePhong(String maTTDTP, String maKhachHang, String maPhong, LocalDateTime ngayDatPhong,
			LocalDateTime ngayNhanPhong, LocalDateTime ngayTraPhong, String maLoaiThue, double tienDaCoc,
			String trangThai) {
		super();
		this.maTTDTP = maTTDTP;
		this.maKhachHang = maKhachHang;
		this.maPhong = maPhong;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.maLoaiThue = maLoaiThue;
		this.tienDaCoc = tienDaCoc;
		this.trangThai = trangThai;
	}

	public ThongTinDatThuePhong() {
		super();
	}

	public ThongTinDatThuePhong(String maTTDTP) {
		super();
		this.maTTDTP = maTTDTP;
	}

	public String getMaTTDTP() {
		return maTTDTP;
	}

	public void setMaTTDTP(String maTTDTP) {
		this.maTTDTP = maTTDTP;
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

	public LocalDateTime getNgayDatPhong() {
		return ngayDatPhong;
	}

	public void setNgayDatPhong(LocalDateTime ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}

	public LocalDateTime getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(LocalDateTime ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public LocalDateTime getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(LocalDateTime ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	public String getMaLoaiThue() {
		return maLoaiThue;
	}

	public void setMaLoaiThue(String maLoaiThue) {
		this.maLoaiThue = maLoaiThue;
	}

	public double getTienDaCoc() {
		return tienDaCoc;
	}

	public void setTienDaCoc(double tienDaCoc) {
		this.tienDaCoc = tienDaCoc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "ThongTinDatThuePhong [maTTDTP=" + maTTDTP + ", maKhachHang=" + maKhachHang + ", maPhong=" + maPhong
				+ ", ngayDatPhong=" + ngayDatPhong + ", ngayNhanPhong=" + ngayNhanPhong + ", ngayTraPhong="
				+ ngayTraPhong + ", maLoaiThue=" + maLoaiThue + ", tienDaCoc=" + tienDaCoc + ", trangThai=" + trangThai
				+ "]";
	}

}
