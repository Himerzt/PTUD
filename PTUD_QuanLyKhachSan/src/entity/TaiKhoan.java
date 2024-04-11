package entity;

public class TaiKhoan {
	private String maNhanVien;
	private String tenDangNhap;
	private String matKhau;
	public TaiKhoan(String maNhanVien, String tenDangNhap, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public TaiKhoan(String tenDangNhap) {
		super();
		this.tenDangNhap = tenDangNhap;
	}
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maNhanVien=" + maNhanVien + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + "]";
	}
	
	
	

}
