package entity;

public class DichVuPhong {
	public String maPhong;
	public String maDichVu;
	public int soLuong;

	public String getMaPhong() {
		return this.maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaDichVu() {
		return this.maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public DichVuPhong(String maPhong, String maDichVu, int soLuong) {
		this.maPhong = maPhong;
		this.maDichVu = maDichVu;
		this.soLuong = soLuong;
	}

	public DichVuPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public DichVuPhong() {
	}

	@Override
	public String toString() {
        return "DichVuPhong [maPhong=" + this.maPhong + ", maDichVu=" + this.maDichVu + ", soLuong=" + this.soLuong
                + "]";
    }
}