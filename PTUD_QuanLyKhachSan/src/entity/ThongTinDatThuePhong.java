package entity;

import java.time.LocalDate;
import java.util.List;

public class ThongTinDatThuePhong {
	private String maTTDTP;
	private String maKhachHang;
	private String maPhong;
	private LocalDate ngayDatPhong;
	private LocalDate ngayNhanPhong;
	private LocalDate ngayTraPhong;
	private String maLoaiThue;
	private double tienDaCoc;
	public ThongTinDatThuePhong(String maTTDTP, String maKhachHang, String maPhong, LocalDate ngayDatPhong,
			LocalDate ngayNhanPhong, LocalDate ngayTraPhong, String maLoaiThue, double tienDaCoc) {
		super();
		this.maTTDTP = maTTDTP;
		this.maKhachHang = maKhachHang;
		this.maPhong = maPhong;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.maLoaiThue = maLoaiThue;
		this.tienDaCoc = tienDaCoc;
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
	@Override
	public String toString() {
		return "ThongTinDatThuePhong [maTTDTP=" + maTTDTP + ", maKhachHang=" + maKhachHang + ", maPhong=" + maPhong
				+ ", ngayDatPhong=" + ngayDatPhong + ", ngayNhanPhong=" + ngayNhanPhong + ", ngayTraPhong="
				+ ngayTraPhong + ", maLoaiThue=" + maLoaiThue + ", tienDaCoc=" + tienDaCoc + "]";
	}
	


}
