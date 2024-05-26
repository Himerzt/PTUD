package entity;

import java.time.LocalDate;

public class ChiTietHoaDon {

    private String maCTHD;
	private String maHD;
	private String maTTDTP;
    private String maLSDP;
    private String maKM;
    
	public ChiTietHoaDon(String maHD, String maTTDTP, String maLSDP, String maCTHD, String maKM) {
		super();
		this.maHD = maHD;
		this.maTTDTP = maTTDTP;
		this.maLSDP = maLSDP;
		this.maCTHD = maCTHD;
		this.maKM = maKM;
	}

	public ChiTietHoaDon() {
		super();
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

	public String getMaLSDP() {
		return maLSDP;
	}

	public void setMaLSDP(String maLSDP) {
		this.maLSDP = maLSDP;
	}

	public String getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonUpdated [maHD=" + maHD + ", maTTDTP=" + maTTDTP + ", maLSDP=" + maLSDP + ", maCTHD="
				+ maCTHD + ", maKM=" + maKM + "]";
	}
}
