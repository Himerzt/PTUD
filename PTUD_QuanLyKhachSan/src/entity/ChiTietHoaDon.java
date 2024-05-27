package entity;

import java.time.LocalDate;

public class ChiTietHoaDon {

    private String maCTHD;
	private String maHD;
	private String maTTDTP;
	public String getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaTTDTP() {
		return maTTDTP;
	}
	public void setMaTTDTP(String maTTDTP) {
		this.maTTDTP = maTTDTP;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [maCTHD=" + maCTHD + ", maHD=" + maHD + ", maTTDTP=" + maTTDTP + "]";
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(String maCTHD, String maHD, String maTTDTP) {
		super();
		this.maCTHD = maCTHD;
		this.maHD = maHD;
		this.maTTDTP = maTTDTP;
	}
    
	
}
