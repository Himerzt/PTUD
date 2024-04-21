package entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
	private static final String PREFIX = "HD";

	@Id
	@Column(name = "maHoaDon")
	private String maHoaDon;

	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang maKhachHang;

	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien maNhanVien;

	@Column(name = "ngayLap")
	private LocalDate ngayLap;

	@Column(name = "ngayNhan")
	private LocalDate ngayNhan;

	@ToString.Exclude
	@OneToMany(mappedBy = "maHoaDon", fetch = FetchType.LAZY)
	private List<ChiTietHoaDon> listChiTiet;

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon, KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKH;
		this.maNhanVien = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
	}

	public HoaDon(String maHoaDon, KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietHoaDon> listChiTietHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKH;
		this.maNhanVien = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTiet = listChiTietHoaDon;
	}

	public HoaDon(KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietHoaDon> listChiTietHoaDon) {
		super();
		this.maHoaDon = PREFIX + generateRandomCode(5);
		this.maKhachHang = maKH;
		this.maNhanVien = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTiet = listChiTietHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon() {
		this.maHoaDon = PREFIX + generateRandomCode(5);
	}

	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public LocalDate getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(LocalDate ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public List<ChiTietHoaDon> getListChiTiet() {
		return listChiTiet;
	}

	public void setListChiTiet(List<ChiTietHoaDon> listChiTiet) {
		this.listChiTiet = listChiTiet;
	}

	public static String generateRandomCode(int length) {
		String characters = "0123456789"; // Các ký tự được chấp nhận
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien
				+ ", ngayLap=" + ngayLap + ", ngayNhan=" + ngayNhan + ", listChiTiet=" + listChiTiet + "]";
	}

}
