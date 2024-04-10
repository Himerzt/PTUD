package entity;

public class DichVu {
	private String maDV;
	private String tenDV;
	private double giaDV;

	public String getMaDV() {
		return maDV;
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

}
