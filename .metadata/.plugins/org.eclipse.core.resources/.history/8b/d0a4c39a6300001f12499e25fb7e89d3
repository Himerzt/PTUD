package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "KhachHang")
public class KhachHang {

	@Id
	@Column(name = "maKhachHang")
	private String maKhachHang;

	@Column(name = "soDienThoai")
	private String soDienThoai;

	@Column(name = "tenKhachHang")
	private String tenKhachHang;

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKhachHang, String soDienThoai, String tenKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", soDienThoai=" + soDienThoai + ", tenKhachHang="
				+ tenKhachHang + "]";
	}

}
