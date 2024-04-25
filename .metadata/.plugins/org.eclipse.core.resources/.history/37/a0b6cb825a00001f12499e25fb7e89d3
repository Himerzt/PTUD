package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietDonDat")
public class ChiTietDonDat {

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

	public ChiTietDonDat(DonDat maDonDat, Thuoc maThuoc, int soLuong) {
		super();
		this.maDonDat = maDonDat;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public DonDat getMaDonDat() {
		return maDonDat;
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
