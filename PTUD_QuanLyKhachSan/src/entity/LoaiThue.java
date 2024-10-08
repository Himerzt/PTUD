package entity;

public class LoaiThue {
	private String maLoaiThue;
	private String tenLoaiThue;
	private double giaThue;
	private double giaCocToiThieu;
	private String maLoaiPhong;

	public String getMaLoaiThue() {
		return maLoaiThue;
	}

	public void setMaLoaiThue(String maLoaiThue) {
		this.maLoaiThue = maLoaiThue;
	}

	public String getTenLoaiThue() {
		return tenLoaiThue;
	}

	public void setTenLoaiThue(String tenLoaiThue) {
		this.tenLoaiThue = tenLoaiThue;
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

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public LoaiThue(String maLoaiThue, String tenLoaiThue, double giaThue, double giaCocToiThieu, String maLoaiPhong) {
		super();
		this.maLoaiThue = maLoaiThue;
		this.tenLoaiThue = tenLoaiThue;
		this.giaThue = giaThue;
		this.giaCocToiThieu = giaCocToiThieu;
		this.maLoaiPhong = maLoaiPhong;
	}

	public LoaiThue(String maLoaiThue) {
		this.maLoaiThue = maLoaiThue;
	}

	public LoaiThue() {
		super();
	}

}
