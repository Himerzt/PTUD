package entity;

public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private int soGiuong;
	private int soNguoiToiDa;

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}

	public int getSoNguoiToiDa() {
		return soNguoiToiDa;
	}

	public void setSoNguoiToiDa(int soNguoiToiDa) {
		this.soNguoiToiDa = soNguoiToiDa;
	}

	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, int soGiuong, int soNguoiToiDa) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.soGiuong = soGiuong;
		this.soNguoiToiDa = soNguoiToiDa;
	}

	public LoaiPhong() {
		super();
	}

	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}

	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", soGiuong=" + soGiuong
				+ ", soNguoiToiDa=" + soNguoiToiDa + "]";
	}

}
