package entity;

import java.time.LocalDateTime;
import java.util.Map;

public class ChiTietHoaDon {
	private ThongTinNhanPhong phong;
	private HoaDon hoaDon;
	private LocalDateTime ngayDi;
	private KhuyenMai khuyenMai;
	private final double thueVAT = 0.1;
	private double chietKhau;
	private Map<String, Integer> dichVuSuDung;
	private Map<String, Integer> dichVu;

	public ThongTinNhanPhong getPhong() {
		return phong;
	}

	public void setPhong(ThongTinNhanPhong phong) {
		this.phong = phong;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public LocalDateTime getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(LocalDateTime ngayDi) {
		this.ngayDi = ngayDi;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public double getThueVAT() {
		return thueVAT;
	}

	public double getChietKhau() {
		return chietKhau;
	}

	public Map<String, Integer> getDichVu() {
		return dichVu;
	}

	public void setDichVu(Map<String, Integer> dichVu) {
		this.dichVu = dichVu;
	}

	public ChiTietHoaDon(Map<String, Integer> dichVu) {
		super();
		this.dichVu = dichVu;
	}

	public ChiTietHoaDon(ThongTinNhanPhong phong, HoaDon hoaDon, LocalDateTime ngayDi, KhuyenMai khuyenMai,
			Map<String, Integer> dichVu) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDi = ngayDi;
		this.khuyenMai = khuyenMai;
		this.dichVuSuDung = dichVu;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}

}
