package entity;

public class ChucVu {
	private String maChucVu;
	private String tenChucVu;
	private double luongCoBan;
	private double heSoLuong;

	public String getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public ChucVu(String maChucVu, String tenChucVu, double luongCoBan, double heSoLuong) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
		this.luongCoBan = luongCoBan;
		this.heSoLuong = heSoLuong;
	}

	public ChucVu() {
		super();
	}

	public ChucVu(String maChucVu) {
		super();
		this.maChucVu = maChucVu;
	}

	@Override
	public String toString() {
		return "tenChucVu=" + tenChucVu;
	}
	
	

}
