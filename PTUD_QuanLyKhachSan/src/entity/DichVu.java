package entity;

import java.util.Objects;

public class DichVu {
	private String maDV;
	private String tenDV;
	private double giaDV;

	public String getMaDV() {
		return maDV;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 17 * hash + Objects.hashCode(this.maDV);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DichVu other = (DichVu) obj;
		return Objects.equals(this.maDV, other.maDV);
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public double getGiaDV() {
		return giaDV;
	}

	public void setGiaDV(double giaDV) {
		this.giaDV = giaDV;
	}

	public DichVu(String maDV, String tenDV, double giaDV) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.giaDV = giaDV;
	}

	public DichVu() {
		super();
	}

	public DichVu(String maDV) {
		super();
		this.maDV = maDV;
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", giaDV=" + giaDV + "]";
	}
	
	

}
