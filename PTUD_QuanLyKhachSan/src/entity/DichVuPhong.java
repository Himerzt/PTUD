package entity;

public class DichVuPhong {
	private String maDichVuSuDung;
	private String maPhong;
	private String maDichVu;
	private int soLuong;

	public DichVuPhong(String maDichVuSuDung) {
		super();
		this.maDichVuSuDung = maDichVuSuDung;
	}

	public DichVuPhong() {
		super();
	}

	public DichVuPhong(String maDichVuSuDung, String maPhong, String maDichVu , int soLuong) {
		super();
		this.maDichVuSuDung = maDichVuSuDung;
		this.maPhong = maPhong;
		this.maDichVu = maDichVu;
		this.soLuong = soLuong;
	}
	
	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMaDichVuSuDung() {
		return maDichVuSuDung;
	}

	public void setMaDichVuSuDung(String maDichVuSuDung) {
		this.maDichVuSuDung = maDichVuSuDung;
	}

}