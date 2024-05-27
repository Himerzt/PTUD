package entity;

import java.time.LocalDate;

public class LichSuDoiPhong {
	private String maLSDP;
	private String maTTDTP;
	private String maPhongCu;
	private String maPhongMoi;
	private LocalDate ngayDoi;
	private String lyDo;
	public LichSuDoiPhong(String maLSDP, String maTTDTP, String maPhongCu, String maPhongMoi, LocalDate ngayDoi,
			String lyDo) {
		super();
		this.maLSDP = maLSDP;
		this.maTTDTP = maTTDTP;
		this.maPhongCu = maPhongCu;
		this.maPhongMoi = maPhongMoi;
		this.ngayDoi = ngayDoi;
		this.lyDo = lyDo;
	}
	public String getMaLSDP() {
		return maLSDP;
	}
	public void setMaLSDP(String maLSDP) {
		this.maLSDP = maLSDP;
	}
	public String getMaTTDTP() {
		return maTTDTP;
	}
	public void setMaTTDTP(String maTTDTP) {
		this.maTTDTP = maTTDTP;
	}
	public String getMaPhongCu() {
		return maPhongCu;
	}
	public void setMaPhongCu(String maPhongCu) {
		this.maPhongCu = maPhongCu;
	}
	public String getMaPhongMoi() {
		return maPhongMoi;
	}
	public void setMaPhongMoi(String maPhongMoi) {
		this.maPhongMoi = maPhongMoi;
	}
	public LocalDate getNgayDoi() {
		return ngayDoi;
	}
	public void setNgayDoi(LocalDate ngayDoi) {
		this.ngayDoi = ngayDoi;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public LichSuDoiPhong(String maLSDP) {
		super();
		this.maLSDP = maLSDP;
	}
	public LichSuDoiPhong() {
		// TODO Auto-generated constructor stub
	}
	
	

}
