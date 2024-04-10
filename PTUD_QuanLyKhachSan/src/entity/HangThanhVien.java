package entity;

public class HangThanhVien {
	private String maHang;
	private String tenHang;
	private double tiLeChietKhau;

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public double getTiLeChietKhau() {
		return tiLeChietKhau;
	}

	public void setTiLeChietKhau(double tiLeChietKhau) {
		this.tiLeChietKhau = tiLeChietKhau;
	}

	public HangThanhVien(String maHang, String tenHang, double tiLeChietKhau) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.tiLeChietKhau = tiLeChietKhau;
	}

	public HangThanhVien() {
		super();
	}

	public HangThanhVien(String maHang) {
		super();
		this.maHang = maHang;
	}

}
