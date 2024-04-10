package entity;

import java.time.LocalDate;

public class ThongTinNhanPhong {
	private String maTTPN;
	private KhachHang khachHang;
	private LocalDate ngayNhanPhong;
	private LocalDate ngayDatPhong;
	private LoaiPhong loaiPhong;
	private int soLuongPhong;

	public String getMaTTPN() {
		return maTTPN;
	}

	public void setMaTTPN(String maTTPN) {
		this.maTTPN = maTTPN;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public LocalDate getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(LocalDate ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public LocalDate getNgayDatPhong() {
		return ngayDatPhong;
	}

	public void setNgayDatPhong(LocalDate ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getSoLuongPhong() {
		return soLuongPhong;
	}

	public void setSoLuongPhong(int soLuongPhong) {
		this.soLuongPhong = soLuongPhong;
	}

	public ThongTinNhanPhong(String maTTPN, KhachHang khachHang, LocalDate ngayNhanPhong,
			LocalDate ngayDatPhong, LoaiPhong loaiPhong, int soLuongPhong) {
		super();
		this.maTTPN = maTTPN;
		this.khachHang = khachHang;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayDatPhong = ngayDatPhong;
		this.loaiPhong = loaiPhong;
		this.soLuongPhong = soLuongPhong;
	}

	public ThongTinNhanPhong() {
		super();
	}

	public ThongTinNhanPhong(String maTTPN) {
		super();
		this.maTTPN = maTTPN;
	}

}
