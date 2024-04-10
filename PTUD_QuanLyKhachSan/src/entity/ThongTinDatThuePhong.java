package entity;

import java.time.LocalDate;

public class ThongTinDatThuePhong {
private String maDatPhong;
private KhachHang khachHang;
private Phong phong;
private LocalDate ngayDatPhong;
private LocalDate ngayNhanPhong;
private LocalDate ngayTraPhong;
private LoaiThue loaiThue;

public String getMaDatPhong() {
	return maDatPhong;
}
public void setMaDatPhong(String maDatPhong) {
	this.maDatPhong = maDatPhong;
}
public KhachHang getKhachHang() {
	return khachHang;
}
public void setKhachHang(KhachHang khachHang) {
	this.khachHang = khachHang;
}
public Phong getPhong() {
	return phong;
}
public void setPhong(Phong phong) {
	this.phong = phong;
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
public LoaiThue getLoaiThue() {
	return loaiThue;
}
public void setLoaiThue(LoaiThue loaiThue) {
	this.loaiThue = loaiThue;
}




public ThongTinDatThuePhong(String maDatPhong) {
	super();
	this.maDatPhong = maDatPhong;
}
public ThongTinDatThuePhong() {
	super();
}
public ThongTinDatThuePhong(String maDatThue, KhachHang kh, Phong phong2, LocalDate ngayDatPhong2,
		LocalDate ngayNhanPhong2, LocalDate ngayTraPhong2, LoaiThue loaiThue2) {
	this.maDatPhong = maDatThue;
	this.khachHang = khachHang;
	this.phong = phong2;
	this.ngayDatPhong = ngayDatPhong2;
	this.ngayNhanPhong = ngayNhanPhong2;
	this.ngayTraPhong = ngayTraPhong2;
	this.loaiThue = loaiThue2;
}


}
