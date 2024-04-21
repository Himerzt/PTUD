package entity;

import java.time.LocalDate;

public class ChiTietHoaDon {
	private String maHD;
	private String maTTDTP;
    private String maLSDP;
    private String maDVPSD;
    private String maKM;
    
	public ChiTietHoaDon(String maHD, String maTTDTP, String maLSDP, String maDVPSD, String maKM) {
		super();
		this.maHD = maHD;
		this.maTTDTP = maTTDTP;
		this.maLSDP = maLSDP;
		this.maDVPSD = maDVPSD;
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

	public String getMaDVPSD() {
		return maDVPSD;
	}

	public void setMaDVPSD(String maDVPSD) {
		this.maDVPSD = maDVPSD;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonUpdated [maHD=" + maHD + ", maTTDTP=" + maTTDTP + ", maLSDP=" + maLSDP + ", maDVPSD="
				+ maDVPSD + ", maKM=" + maKM + "]";
	}
}
