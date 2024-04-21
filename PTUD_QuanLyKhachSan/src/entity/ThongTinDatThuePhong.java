package entity;

import java.time.LocalDate;
import java.util.List;

public class ThongTinDatThuePhong {
	private String maDatPhong;
	private String maKhachHang;
	private List<Phong> dsPhong;
	private LocalDate ngayDatPhong;
	private LocalDate ngayNhanPhong;
	private LocalDate ngayTraPhong;
	private String maLoaiThue;
	private double tienDaCoc;

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

	public List<Phong> getDsPhong() {
		return dsPhong;
	}
	
	public void setDsPhong(List<Phong> dsPhong) {
		this.dsPhong = dsPhong;
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

	public ThongTinDatThuePhong(String maDatPhong, String maKhachHang, List<Phong> dsPhong, LocalDate ngayDatPhong,
			LocalDate ngayNhanPhong, LocalDate ngayTraPhong, String maLoaiThue, double tienDaCoc) {
		super();
		this.maDatPhong = maDatPhong;
		this.maKhachHang = maKhachHang;
        this.dsPhong = dsPhong;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.maLoaiThue = maLoaiThue;
		this.tienDaCoc = tienDaCoc;
	}

	@Override
	public String toString() {
		return "ThongTinDatThuePhong [maDatPhong=" + maDatPhong + ", maKhachHang=" + maKhachHang + ", dsPhong="
				+ dsPhong + ", ngayDatPhong=" + ngayDatPhong + ", ngayNhanPhong=" + ngayNhanPhong + ", ngayTraPhong="
				+ ngayTraPhong + ", maLoaiThue=" + maLoaiThue + ", tienDaCoc=" + tienDaCoc + "]";
	}
}
