package entity;

import jakarta.persistence.*;


@Entity
@Table(name = "ChiTietPhieuNhapThuoc")

public class ChiTietPhieuNhapThuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "maThuoc")
	private Thuoc maThuoc;
	
	@ManyToOne
	@JoinColumn(name = "maPhieuNhap")
	private PhieuNhapThuoc maPhieuNhap;
	
	@Column(name = "soLuong")
	private int soLuong;
	
	@Column(name = "giaNhap")
	private double giaNhap;
	
	@Column(name = "hsd")
	private String hsd;
	
	@Column(name = "donVi")
	private String donVi;
	
	@Column(name = "thanhTien")
	private double thanhTien;
	
	public ChiTietPhieuNhapThuoc() {
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietPhieuNhapThuoc(Thuoc maThuoc, PhieuNhapThuoc maPhieuNhap, int soLuong, double giaNhap, String hsd,
			String donVi, double thanhTien) {
		super();
		this.maThuoc = maThuoc;
		this.maPhieuNhap = maPhieuNhap;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.hsd = hsd;
		this.donVi = donVi;
		this.thanhTien = thanhTien;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Thuoc getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}

	public PhieuNhapThuoc getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(PhieuNhapThuoc maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public String getHsd() {
		return hsd;
	}

	public void setHsd(String hsd) {
		this.hsd = hsd;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhapThuoc [id=" + id + ", maThuoc=" + maThuoc + ", maPhieuNhap=" + maPhieuNhap
				+ ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", hsd=" + hsd + ", donVi=" + donVi + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
	
	
	
}
