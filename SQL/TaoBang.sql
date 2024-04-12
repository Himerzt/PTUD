CREATE TABLE ChucVu (
    MaChucVu NVARCHAR(2) PRIMARY KEY,
    TenChucVu NVARCHAR(10),
    LuongCoBan FLOAT,
    HeSoLuong FLOAT
);

CREATE TABLE TaiKhoan (
	MaNhanVien NVARCHAR(30),
    TenDangNhap NVARCHAR(255) PRIMARY KEY,
    MatKhau NVARCHAR(255)
);

CREATE TABLE NhanVien (
    MaNV NVARCHAR(30) PRIMARY KEY, --SRNV04022024001
    HoTenNV NVARCHAR(255),
    NgaySinhNV DATE,
    GioiTinh NVARCHAR(5),
    SoDienThoai NVARCHAR(15),
    CCCD_Visa NVARCHAR(20),
    DiaChi NVARCHAR(255),
    MaChucVu NVARCHAR(2),
    TenDangNhap NVARCHAR(255),
    SoNgayNghi INT
);

CREATE TABLE HangThanhVien (
    MaHang NVARCHAR(2) PRIMARY KEY,
    TenHang NVARCHAR(255),
    TiLeChietKhau FLOAT
);

CREATE TABLE KhachHang (
    MaKH NVARCHAR(30) PRIMARY KEY,
    TenKhachHang NVARCHAR(255),
    GioiTinh NVARCHAR(5),
    NgaySinhNV DATE,
    SoDienThoai NVARCHAR(15),
    CCCD_Visa NVARCHAR(20),
    DiaChi NVARCHAR(255),
    ChiTieu FLOAT,
    MaHang NVARCHAR(2),
    QuocTich NVARCHAR(255)
);

CREATE TABLE LoaiPhong (
    MaLoaiPhong NVARCHAR(2) PRIMARY KEY,
    TenLoaiPhong NVARCHAR(255),
    SoGiuong INT
);

CREATE TABLE LoaiThue (
    MaLoaiThue NVARCHAR(10) PRIMARY KEY,
    KieuThue NVARCHAR(10),
    GiaThue FLOAT,
	GiaCocToiThieu FLOAT,
    MaLoaiPhong NVARCHAR(2)
);

CREATE TABLE Phong (
    MaPhong NVARCHAR(10) PRIMARY KEY,
    SoPhong INT,
    MaLoaiPhong NVARCHAR(2),
    TrangThaiPhong NVARCHAR(255)
);

CREATE TABLE DichVu (
    MaDV NVARCHAR(10) PRIMARY KEY,
    TenDV NVARCHAR(255),
    GiaDV FLOAT
);

CREATE TABLE KhuyenMai (
    MaKhuyenMai NVARCHAR(10) PRIMARY KEY,
    TenKhuyenMai NVARCHAR(255),
    GiaTriKhuyenMai FLOAT,
    ThoiGianBatDau DATE,
    ThoiGianKetThuc DATE,
    DieuKienApDung FLOAT
);

CREATE TABLE HoaDon (
    MaHD NVARCHAR(30) PRIMARY KEY,
    MaNV NVARCHAR(30),
    MaKH NVARCHAR(30),
    NgayLapHD DATE
);

CREATE TABLE ThongTinNhanPhong (
    MaTTNP NVARCHAR(10) PRIMARY KEY,
    MaKH NVARCHAR(30),
    SoLuongPhong INT
);

CREATE TABLE ThongTinDatThuePhong (
    MaTTDTP NVARCHAR(30) PRIMARY KEY,
    MaKhachHang NVARCHAR(30),
    Phong NVARCHAR(255),
    NgayDatPhong DATE,
    NgayNhanPhong DATE,
    NgayTraPhong DATE,
    LoaiThue NVARCHAR(10),
    DichVuSuDung NVARCHAR(255)
);

CREATE TABLE DichVuSuDung (
    MaPhong NVARCHAR(30) PRIMARY KEY,
    MaDichVu NVARCHAR(10),
    SoLuong INT
);

CREATE TABLE ChiTietHoaDon (
    MaHD NVARCHAR(30),
    MaTTNP NVARCHAR(10),
	MaLSDP NVARCHAR(30),
    MaDichVuPhongSuDung NVARCHAR(30),
    SoNgayThue INT,
    NgayDen DATE,
    NgayDi DATE,
    MaKM NVARCHAR(10),
    ThueVAT FLOAT,
    ChietKhau FLOAT
);

CREATE TABLE LichSuDoiPhong (
    MaLSDP NVARCHAR(30) PRIMARY KEY, 
    MaTTDTP NVARCHAR(30),
    MaPhongCu NVARCHAR(30),
	MaPhongMoi NVARCHAR(30),
	NgayDoiPhong DATE,
	LyDoDoi NVARCHAR(255)
);

-- Tạo quan hệ giữa các bảng
ALTER TABLE NhanVien
ADD FOREIGN KEY (MaChucVu) REFERENCES ChucVu(MaChucVu);

ALTER TABLE NhanVien
ADD FOREIGN KEY (TenDangNhap) REFERENCES TaiKhoan(TenDangNhap);

ALTER TABLE KhachHang
ADD FOREIGN KEY (MaHang) REFERENCES HangThanhVien(MaHang);

ALTER TABLE LoaiThue
ADD FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong);

ALTER TABLE Phong
ADD FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong);

ALTER TABLE ThongTinDatThuePhong
ADD FOREIGN KEY (LoaiThue) REFERENCES LoaiThue(MaLoaiThue);

ALTER TABLE ThongTinDatThuePhong
ADD FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKH);

ALTER TABLE ThongTinDatThuePhong
ADD FOREIGN KEY (LoaiThue) REFERENCES LoaiThue(MaLoaiThue);

ALTER TABLE DichVuSuDung
ADD FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDV);

ALTER TABLE HoaDon
ADD FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);

ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD);

ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaTTNP) REFERENCES ThongTinNhanPhong(MaTTNP);

ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaLSDP) REFERENCES LichSuDoiPhong(MaLSDP);

ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaDichVuPhongSuDung) REFERENCES DichVuSuDung(MaPhong);

ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKhuyenMai);

ALTER TABLE LichSuDoiPhong
ADD FOREIGN KEY (MaTTDTP) REFERENCES ThongTinDatThuePhong(MaTTDTP);
