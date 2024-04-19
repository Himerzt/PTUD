package entity;

public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private double giaThue;
	private double giaCocToiThieu;
	private int soGiuong;
	private int soNguoiToiDa;

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public double getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}

	public double getGiaCocToiThieu() {
		return giaCocToiThieu;
	}

	public void setGiaCocToiThieu(double giaCocToiThieu) {
		this.giaCocToiThieu = giaCocToiThieu;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}

	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, double giaThue, double giaCocToiThieu, int soGiuong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.giaThue = giaThue;
		this.giaCocToiThieu = giaCocToiThieu;
		this.soGiuong = soGiuong;
	}

	public LoaiPhong() {
		super();
	}

	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}

}
