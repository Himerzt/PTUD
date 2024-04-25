package entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietDonDat")

@NamedQueries({
		@NamedQuery(name = "ChiTietDonDat.findByID", query = "SELECT ctdd FROM ChiTietDonDat cthd WHERE ctdd.maHoaDon = :maHoaDon"),
		@NamedQuery(name = "ChiTietDonDat.deleteOne", query = "DELETE FROM ChiTietDonDat cthd WHERE cthd.maThuoc = :maThuoc"),
		@NamedQuery(name = "", query = ""), })
public class ChiTietDonDat implements Serializable {

	private static final long serialVersionUID = 1254786925698547852L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "maDonDat")
	private DonDat maDonDat;

	@ManyToOne
	@JoinColumn(name = "maThuoc")
	private Thuoc maThuoc;

	@Column(name = "soLuong")
	private int soLuong;

	public ChiTietDonDat() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietDonDat(Thuoc maThuoc, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public ChiTietDonDat(DonDat maDonDat, Thuoc maThuoc, int soLuong) {
		super();
		this.maDonDat = maDonDat;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public DonDat getMaDonDat() {
		return maDonDat;
	}

	public void setMaDonDat(DonDat maDonDat) {
		this.maDonDat = maDonDat;
	}

	public Thuoc getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietDonDat [id=" + id + ", maDonDat=" + maDonDat + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong
				+ "]";
	}

}
