package entity;

import java.util.ArrayList;

import dao.PhongDao;

public class Phong {
	private String maPhong;
	private int soPhong;
	private String maLoaiPhong;
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

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Phong(String maPhong, int soPhong, String maLoaiPhong, String trangThai) {
		super();
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.maLoaiPhong = maLoaiPhong;
		this.trangThai = trangThai;
	}

	public Phong() {
		super();
	}

	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", soPhong=" + soPhong + ", maLoaiPhong=" + maLoaiPhong + ", trangThai="
				+ trangThai + "]";
	}
	
	public static void main(String[] args) {
//		test lay phong tu csdl
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = phongDao.timTatCaPhongSapXepTheoSoPhong();
		for (Phong phong : dsPhong) {
			System.out.println(phong.getSoPhong());
		}
		
	}

	
}
