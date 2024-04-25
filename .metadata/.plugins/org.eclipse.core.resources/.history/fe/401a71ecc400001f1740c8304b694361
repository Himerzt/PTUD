package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "DonDat")
@NamedQueries({ @NamedQuery(name = "DonDat.findAll", query = "SELECT dd FROM DonDat dd"),
		@NamedQuery(name = "DonDat.findByMaDonDat", query = "SELECT dd FROM DonDat dd WHERE dd.maDonDat = :maDonDat"),
		@NamedQuery(name = "DonDat.findByMaKhachHang", query = "SELECT dd FROM DonDat dd WHERE dd.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "DonDat.findByMaNhanVien", query = "SELECT dd FROM DonDat dd WHERE dd.maNhanVien = :maNhanVien"),
		@NamedQuery(name = "DonDat.findByNgayLap", query = "SELECT dd FROM DonDat dd WHERE dd.ngayLap = :ngayLap"),
		@NamedQuery(name = "DonDat.findByNgayNhan", query = "SELECT dd FROM DonDat dd WHERE dd.ngayNhan = :ngayNhan"),
		@NamedQuery(name = "DonDat.checkThuoc", query = "SELECT dd FROM DonDat dd JOIN dd.listChiTiet ct WHERE ct.maThuoc = :maThuoc AND dd.ngayNhan = :ngayNhan"),
})
public class DonDat {
	private static final String PREFIX = "DD";

	@Id
	@Column(name = "maDonDat")
	private String maDonDat;

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
	@OneToMany(mappedBy = "maDonDat", fetch = FetchType.LAZY)
	private List<ChiTietDonDat> listChiTiet;

	public DonDat() {
		// TODO Auto-generated constructor stub
	}

	public DonDat(KhachHang maKhachHang, NhanVien maNhanVien, LocalDate ngayLap, LocalDate ngayNhan) {
		super();
		this.maDonDat = PREFIX + generateRandomCode(5);
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
	}

	public DonDat(KhachHang maKhachHang, NhanVien maNhanVien, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietDonDat> listChiTiet) {
		super();
		this.maDonDat = PREFIX + generateRandomCode(5);
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTiet = listChiTiet;
	}

	public DonDat(String maDonDat, KhachHang maKhachHang, NhanVien maNhanVien, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietDonDat> listChiTiet) {
		super();
		this.maDonDat = maDonDat;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTiet = listChiTiet;
	}

	public DonDat(String maDonDat, KhachHang maKhachHang, NhanVien maNhanVien, LocalDate ngayLap, LocalDate ngayNhan) {
		super();
		this.maDonDat = maDonDat;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
	}

	public String getMaDonDat() {
		return maDonDat;
	}

	public void setMaDonDat() {
		this.maDonDat = PREFIX + generateRandomCode(5);
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

	public List<ChiTietDonDat> getListChiTiet() {
		return listChiTiet;
	}

	public void setListChiTiet(List<ChiTietDonDat> listChiTiet) {
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
		return "DonDat [maDonDat=" + maDonDat + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien
				+ ", ngayLap=" + ngayLap + ", ngayNhan=" + ngayNhan + ", listChiTiet=" + listChiTiet + "]";
	}

}
