package entity;

public class Phong {
	private String maPhong;
	private int soPhong;
	private LoaiPhong loaiPhong;
	private String trangThai;

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Phong(String maPhong, int soPhong, LoaiPhong loaiPhong, String trangThai) {
		super();
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
	}

	public Phong() {
		super();
	}

	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}

}
