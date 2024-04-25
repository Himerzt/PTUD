package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien")
public class NhanVien {

	@Id
	@Column(name = "maNhanVien")
	private String maNhanVien;

	@Column(name = "tenNhanVien")
	private String tenNhanVien;

	@Column(name = "soDienThoai")
	private String soDienThoai;

	@Column(name = "chucVu")
	private String chucVu;

	@Column(name = "email")
	private String email;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoai, String chucVu, String email) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.chucVu = chucVu;
		this.email = email;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", soDienThoai=" + soDienThoai
				+ ", chucVu=" + chucVu + ", email=" + email + "]";
	}

}
