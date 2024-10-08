﻿CREATE DATABASE QuanLyDatPhongKhachSan

USE QuanLyDatPhongKhachSan

CREATE TABLE ChucVu (
    MaChucVu NVARCHAR(2) PRIMARY KEY,
    TenChucVu NVARCHAR(10),
    LuongCoBan FLOAT,
    HeSoLuong FLOAT
); --check

CREATE TABLE TaiKhoan (
	MaNV NVARCHAR(30) PRIMARY KEY,
    TenDangNhap NVARCHAR(30) ,
    MatKhau NVARCHAR(255)
); --check

CREATE TABLE NhanVien (
    MaNV NVARCHAR(30) PRIMARY KEY, --SRNV04022024001
    HoTenNV NVARCHAR(255),
    NgaySinhNV DATE,
    GioiTinh NVARCHAR(5),
    SoDienThoai NVARCHAR(15),
	Email NVARCHAR(255),
    CCCD NVARCHAR(20),
    DiaChi NVARCHAR(255),
    MaChucVu NVARCHAR(2),
	NgayVaoLam DATE
); --check

CREATE TABLE HangThanhVien (
    MaHang NVARCHAR(2) PRIMARY KEY,
    TenHang NVARCHAR(255),
    TiLeChietKhau FLOAT
); --check

CREATE TABLE KhachHang (
    MaKH NVARCHAR(30) PRIMARY KEY,
    TenKhachHang NVARCHAR(255),
    GioiTinh NVARCHAR(5),
    NgaySinhKH DATE,
    SoDienThoai NVARCHAR(15),
    CCCD_Passport NVARCHAR(30),
    ChiTieu FLOAT,
    MaHang NVARCHAR(2),
    QuocTich NVARCHAR(255)
); --check

CREATE TABLE LoaiPhong (
    MaLoaiPhong NVARCHAR(2) PRIMARY KEY,
    TenLoaiPhong NVARCHAR(255),
    SoGiuong INT,
	SoNguoiToiDa INT
); --check

CREATE TABLE LoaiThue (
    MaLoaiThue NVARCHAR(10) PRIMARY KEY,
    KieuThue NVARCHAR(30),
    GiaThue FLOAT,
	GiaCocToiThieu FLOAT,
    MaLoaiPhong NVARCHAR(2)
); --check

CREATE TABLE Phong (
    MaPhong NVARCHAR(10) PRIMARY KEY,
    SoPhong INT,
    MaLoaiPhong NVARCHAR(2),
    TrangThaiPhong NVARCHAR(255)
); --check

CREATE TABLE DichVu (
    MaDV NVARCHAR(10) PRIMARY KEY,
    TenDV NVARCHAR(255),
    GiaDV FLOAT
); --check

--Điều kiện áp dụng khuyến mãi string
CREATE TABLE KhuyenMai (
    MaKhuyenMai NVARCHAR(10) PRIMARY KEY,
    TenKhuyenMai NVARCHAR(255),
    GiaTriKhuyenMai FLOAT,
    ThoiGianBatDau DATE,
    ThoiGianKetThuc DATE,
    DieuKienApDung INT
); --check

CREATE TABLE HoaDon (
    MaHD NVARCHAR(30) PRIMARY KEY,
    MaNV NVARCHAR(30),
    MaKH NVARCHAR(30),
    NgayLapHD DATETIME,
	MaLSDP NVARCHAR(30),
    MaKM NVARCHAR(10),
	TongTien FLOAT,
    ThueVAT FLOAT
); --check

CREATE TABLE ThongTinDatThuePhong (
    MaTTDTP NVARCHAR(30) PRIMARY KEY,
    MaKhachHang NVARCHAR(30),
    MaPhong NVARCHAR(10),
    NgayDatPhong DATETIME,
    NgayNhanPhong DATETIME,
    NgayTraPhong DATETIME,
    LoaiThue NVARCHAR(10),
	TienDaCoc FLOAT,
	TrangThai NVARCHAR(30)
); --check

CREATE TABLE DichVuSuDung (
	MaDichVuSuDung NVARCHAR(10) PRIMARY KEY,
    MaPhong NVARCHAR(10),
    MaDichVu NVARCHAR(10),
    SoLuong INT
); --check

CREATE TABLE ChiTietHoaDon (
	MaCTHD NVARCHAR(30) PRIMARY KEY,
    MaHD NVARCHAR(30),
    MaTTDTP NVARCHAR(30),
); --check

CREATE TABLE LichSuDoiPhong (
    MaLSDP NVARCHAR(30) PRIMARY KEY, 
    MaTTDTP NVARCHAR(30),
    MaPhongCu NVARCHAR(10),
	MaPhongMoi NVARCHAR(10),
	NgayDoiPhong DATETIME,
	LyDoDoi NVARCHAR(255)
); --

-- Thêm khóa
ALTER TABLE TaiKhoan
ADD CONSTRAINT FK_TaiKhoan_NhanVien
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);

-- Thêm khóa ngoại từ bảng NhanVien đến bảng ChucVu
ALTER TABLE NhanVien
ADD CONSTRAINT FK_NhanVien_ChucVu
FOREIGN KEY (MaChucVu) REFERENCES ChucVu(MaChucVu);

-- Thêm khóa ngoại từ bảng LoaiThue đến bảng LoaiPhong
ALTER TABLE LoaiThue
ADD CONSTRAINT FK_LoaiThue_LoaiPhong
FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong);

-- Thêm khóa ngoại từ bảng Phong đến bảng LoaiPhong
ALTER TABLE Phong
ADD CONSTRAINT FK_Phong_LoaiPhong
FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong);

-- Thêm khóa ngoại từ bảng Phong đến bảng ThongTinDatThuePhong
ALTER TABLE ThongTinDatThuePhong
ADD CONSTRAINT FK_ThongTinDatThuePhong_Phong
FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong);

-- Thêm khóa ngoại từ bảng ThongTinDatThuePhong đến bảng KhachHang
ALTER TABLE ThongTinDatThuePhong
ADD CONSTRAINT FK_ThongTinDatThuePhong_KhachHang
FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKH);

-- Thêm khóa ngoại từ bảng ThongTinDatThuePhong đến bảng LoaiThue
ALTER TABLE ThongTinDatThuePhong
ADD CONSTRAINT FK_ThongTinDatThuePhong_LoaiThue
FOREIGN KEY (LoaiThue) REFERENCES LoaiThue(MaLoaiThue);

-- Thêm khóa ngoại từ bảng DichVuSuDung đến bảng Phong
ALTER TABLE DichVuSuDung
ADD CONSTRAINT FK_DichVuSuDung_Phong
FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong);

-- Thêm khóa ngoại từ bảng DichVuSuDung đến bảng DichVu
ALTER TABLE DichVuSuDung
ADD CONSTRAINT FK_DichVuSuDung_DichVu
FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDV);

-- Thêm khóa ngoại từ bảng HoaDon đến bảng KhuyenMai
ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhuyenMai
FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKhuyenMai);

-- Thêm khóa ngoại từ bảng KhachHang đến bảng HangThanhVien
ALTER TABLE KhachHang
ADD CONSTRAINT FK_KhachHang_HangThanhVien
FOREIGN KEY (MaHang) REFERENCES HangThanhVien(MaHang);

-- Thêm khóa ngoại từ bảng ChiTietHoaDon đến bảng HoaDon
ALTER TABLE ChiTietHoaDon
ADD CONSTRAINT FK_ChiTietHoaDon_HoaDon
FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD);

-- Thêm khóa ngoại từ bảng HoaDon đến bảng NhanVien
ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_NhanVien
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);

-- Thêm khóa ngoại từ bảng HoaDon đến bảng KhachHang
ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH);

-- Thêm khóa ngoại từ bảng LichSuDoiPhong đến bảng ThongTinDatThuePhong
ALTER TABLE LichSuDoiPhong
ADD CONSTRAINT FK_LichSuDoiPhong_ThongTinDatThuePhong
FOREIGN KEY (MaTTDTP) REFERENCES ThongTinDatThuePhong(MaTTDTP);

-- Thêm khóa ngoại từ bảng LichSuDoiPhong đến bảng Phong
ALTER TABLE LichSuDoiPhong
ADD CONSTRAINT FK_LichSuDoiPhong_Phong
FOREIGN KEY (MaPhongMoi) REFERENCES Phong(MaPhong);

-- Thêm khóa ngoại từ bảng HoaDon đến bảng LichSuDoiPhong
ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_LichSuDoiPhong
FOREIGN KEY (MaLSDP) REFERENCES LichSuDoiPhong(MaLSDP);

-- Thêm khóa ngoại từ bảng ChiTietHoaDon đến bảng ThongTinDatThuePhong
ALTER TABLE ChiTietHoaDon
ADD CONSTRAINT FK_ChiTietHoaDon_ThongTinDatThuePhong
FOREIGN KEY (MaTTDTP) REFERENCES ThongTinDatThuePhong(MaTTDTP);

-- Dữ liệu Loại Phòng
INSERT INTO LoaiPhong (MaLoaiPhong, TenLoaiPhong, SoGiuong, SoNguoiToiDa)
VALUES
('TC', N'Tiêu chuẩn', 1, 1),
('NC', N'Nâng cao', 1, 2),
('CC', N'Cao cấp', 2, 3),
('TG', N'Thương gia', 2, 4);

-- Dữ liệu Loại thuê
INSERT INTO LoaiThue (MaLoaiThue, KieuThue, GiaThue, MaLoaiPhong)
VALUES
    ('NTC', N'Qua đêm', 360000, 'TC'),
    ('NNC', N'Qua đêm', 560000, 'NC'),
    ('NCC', N'Qua đêm', 800000, 'CC'),
    ('NTG', N'Qua đêm', 1200000, 'TG'),
    ('DTC', N'Theo ngày', 450000, 'TC'),
    ('DNC', N'Theo ngày', 700000, 'NC'),
    ('DCC', N'Theo ngày', 1000000, 'CC'),
    ('DTG', N'Theo ngày', 1500000, 'TG');

UPDATE LoaiThue
SET giaCocToiThieu = 0.3 * GiaThue;

-- Dữ liệu Phòng
INSERT INTO Phong (MaPhong, SoPhong, MaLoaiPhong, TrangThaiPhong)
VALUES
('TC101', 101, 'TC', N'Trống'),
('TC102', 102, 'TC', N'Trống'),
('TC103', 103, 'TC', N'Trống'),
('TC104', 104, 'TC', N'Trống'),
('TC105', 105, 'TC', N'Trống'),
('TC106', 106, 'TC', N'Trống'),
('TC107', 107, 'TC', N'Trống'),
('TC108', 108, 'TC', N'Trống'),
('TC109', 109, 'TC', N'Trống'),
('TC110', 110, 'TC', N'Trống'),
('TC201', 201, 'TC', N'Trống'),
('TC202', 202, 'TC', N'Trống'),
('TC203', 203, 'TC', N'Trống'),
('TC204', 204, 'TC', N'Trống'),
('TC205', 205, 'TC', N'Trống'),
('NC201', 206, 'NC', N'Trống'),
('NC202', 207, 'NC', N'Trống'),
('NC203', 208, 'NC', N'Trống'),
('NC204', 209, 'NC', N'Trống'),
('NC205', 210, 'NC', N'Trống'),
('NC301', 301, 'NC', N'Trống'),
('NC302', 302, 'NC', N'Trống'),
('NC303', 303, 'NC', N'Trống'),
('NC304', 304, 'NC', N'Trống'),
('NC305', 305, 'NC', N'Trống'),
('CC301', 306, 'CC', N'Trống'),
('CC302', 307, 'CC', N'Trống'),
('CC303', 308, 'CC', N'Trống'),
('CC304', 309, 'CC', N'Trống'),
('CC305', 310, 'CC', N'Trống'),
('TG401', 401, 'TG', N'Trống'),
('TG402', 402, 'TG', N'Trống'),
('CC306', 403, 'CC', N'Trống'),
('CC307', 404, 'CC', N'Trống'),
('CC308', 405, 'CC', N'Trống');

-- Dịch vụ
INSERT INTO DichVu (MaDV, TenDV, GiaDV)
VALUES
('DV001', N'Quầy bar', 120000),
('DV002', N'Dịch vụ ăn tối tại phòng', 200000),
('DV003', N'Dịch vụ giặt ủi quần áo', 130000),
('DV004', N'Dịch vụ đưa đón tại sân bay', 320000),
('DV005', N'Dịch vụ thuê xe máy tự lái', 350000),
('DV006', N'Dịch vụ thuê xe ô tô tự lái', 500000),
('DV007', N'Dịch vụ ăn sáng tại phòng', 180000),
('DV008', N'Dịch vụ spa', 250000),
('DV009', N'Dịch vụ phòng tập thể dục', 180000);

-- Hạng thành viên
DELETE FROM [dbo].[HangThanhVien]
INSERT INTO [dbo].[HangThanhVien] (MaHang, TenHang, TiLeChietKhau)
VALUES 
('HB', N'Hạng Bạc', 0.0375),
('HV', N'Hạng Vàng', 0.075),
('BK', N'Bạch Kim', 0.1125),
('LB', N'Lục Bảo', 0.15),
('KC', N'Kim Cương', 0.1875);

-- Thêm dữ liệu vào bảng ChucVu
INSERT INTO ChucVu (MaChucVu, TenChucVu, LuongCoBan, HeSoLuong)
VALUES 
('NV', 'Nhân viên', 6000000, 1.5),
('QL', 'Quản lý', 10000000, 1.75);

-- Tạo 10 khách hàng với chi tiêu tương ứng
INSERT INTO [dbo].[KhachHang] (MaKH, TenKhachHang, GioiTinh, NgaySinhKH, SoDienThoai, CCCD_Passport, ChiTieu, MaHang, QuocTich)
VALUES 
('KH001', N'Nguyễn Văn Anh', N'Nam', '1990-01-01', '0123456789', '123456789012', 5000000, 'HB', N'Việt Nam'),
('KH002', N'Nguyễn Thị Bích', N'Nữ', '1995-02-15', '0123456788', '123456789013', 10000000, 'HV', N'Việt Nam'),
('KH003', N'Phạm Văn Cường', N'Nam', '1985-03-20', '0123456787', '123456789014', 15000000, 'BK', N'Việt Nam'),
('KH004', N'Lê Thị Diệu', N'Nữ', '1992-04-10', '0123456786', '123456789015', 25000000, 'LB', N'Việt Nam'),
('KH005', N'Trần Văn Đức', N'Nam', '1988-05-05', '0123456785', '123456789016', 35000000, 'KC', N'Việt Nam'),
('KH006', N'Hoàng Thị Hà', N'Nữ', '1993-06-18', '0123456784', '123456789017', 5000000, 'HB', N'Việt Nam'),
('KH007', N'Đỗ Văn Hải', N'Nam', '1987-07-12', '0123456783', '123456789018', 10000000, 'HV', N'Việt Nam'),
('KH008', N'Vũ Thị Hoa', N'Nữ', '1991-08-25', '0123456782', '123456789019', 15000000, 'BK', N'Việt Nam'),
('KH009', N'Nguyễn Văn Khoa', N'Nam', '1989-09-30', '0123456781', '123456789020', 25000000, 'LB', N'Việt Nam'),
('KH010', N'Trần Thị Lan', N'Nữ', '1994-10-14', '0123456780', '123456789021', 35000000, 'KC', N'Việt Nam'),
('KH011', N'Lê Văn Minh', N'Nam', '1986-11-11', '0123456779', '123456789022', 20000000, 'HB', N'Việt Nam'),
('KH012', N'Trần Thị Ngọc', N'Nữ', '1990-12-05', '0123456778', '123456789023', 30000000, 'HV', N'Việt Nam'),
('KH013', N'Nguyễn Văn Nghĩa', N'Nam', '1984-01-22', '0123456777', '123456789024', 15000000, 'BK', N'Việt Nam'),
('KH014', N'Phạm Thị Bình', N'Nữ', '1992-02-28', '0123456776', '123456789025', 25000000, 'LB', N'Việt Nam'),
('KH015', N'Vũ Văn Sơn', N'Nam', '1989-03-18', '0123456775', '123456789026', 35000000, 'KC', N'Việt Nam'),
('KH016', N'Hoàng Văn Tùng', N'Nam', '1983-04-19', '0123456774', '123456789027', 5000000, 'HB', N'Việt Nam'),
('KH017', N'Phan Thị Mai', N'Nữ', '1991-05-25', '0123456773', '123456789028', 10000000, 'HV', N'Việt Nam'),
('KH018', N'Nguyễn Văn Nam', N'Nam', '1990-06-30', '0123456772', '123456789029', 15000000, 'BK', N'Việt Nam'),
('KH019', N'Hoàng Thị Thu', N'Nữ', '1988-07-14', '0123456771', '123456789030', 25000000, 'LB', N'Việt Nam'),
('KH020', N'Lê Văn Hoàng', N'Nam', '1987-08-23', '0123456770', '123456789031', 35000000, 'KC', N'Việt Nam');

-- Tạo 10 nhân viên
INSERT INTO [dbo].[NhanVien] (MaNV, HoTenNV, NgaySinhNV, GioiTinh, SoDienThoai, Email, CCCD, DiaChi, MaChucVu, NgayVaoLam)
VALUES 
('NV001', N'Trần Văn An', '1990-01-01', N'Nam', '0123456790', 'tranvana@email.com', '123456789123', N'Hà Nội', 'NV', '2022-01-01'),
('NV002', N'Nguyễn Thị Bình', '1995-02-15', N'Nữ', '0123456789', 'nguyenthib@email.com', '123456789124', N'Hồ Chí Minh', 'NV', '2021-12-01'),
('NV003', N'Phạm Văn Cường', '1985-03-20', N'Nam', '0123456788', 'phamvanc@email.com', '123456789125', N'Đà Nẵng', 'QL', '2020-11-01'),
('NV004', N'Lê Thị Diễm', '1992-04-10', N'Nữ', '0123456787', 'lethid@email.com', '123456789126', N'Hải Phòng', 'NV', '2019-10-01'),
('NV005', N'Trần Văn Đức', '1988-05-05', N'Nam', '0123456786', 'trand@email.com', '123456789127', N'Cần Thơ', 'NV', '2018-09-01'),
('NV006', N'Hoàng Thị Hà', '1993-06-18', N'Nữ', '0123456785', 'hoangthih@email.com', '123456789128', N'Bình Dương', 'QL', '2017-08-01'),
('NV007', N'Đỗ Văn Hùng', '1987-07-12', N'Nam', '0123456784', 'dovan@email.com', '123456789129', N'Đà Lạt', 'NV', '2016-07-01'),
('NV008', N'Vũ Thị Hoa', '1991-08-25', N'Nữ', '0123456783', 'vuthih@email.com', '123456789130', N'Hải Dương', 'QL', '2015-06-01'),
('NV009', N'Nguyễn Văn Khánh', '1989-09-30', N'Nam', '0123456782', 'nguyenvank@email.com', '123456789131', N'Bình Định', 'NV', '2014-05-01'),
('NV010', N'Trần Thị Lan', '1994-10-14', N'Nữ', '0123456781', 'tranthil@email.com', '123456789132', N'Hà Tĩnh', 'QL', '2013-04-01');

-- Tạo Tài khoản
INSERT INTO [dbo].[TaiKhoan] (MaNV, TenDangNhap, MatKhau)
VALUES 
('NV001', 'NV001', '123456789')

INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD001', 'NV001', 'KH001', '2024-05-01', NULL, null, 500000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD002', 'NV001', 'KH002', '2024-05-01', NULL, null, 400000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD003', 'NV001', 'KH003', '2024-05-01', NULL, null, 300000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD004', 'NV001', 'KH003', '2024-05-02', NULL, null, 300000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD005', 'NV002', 'KH004', '2024-05-03', NULL, NULL, 600000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD006', 'NV002', 'KH005', '2024-05-03', NULL, NULL, 450000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD007', 'NV002', 'KH006', '2024-05-04', NULL, NULL, 550000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD008', 'NV002', 'KH007', '2024-05-04', NULL, NULL, 480000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD009', 'NV002', 'KH008', '2024-05-05', NULL, NULL, 520000, 0.05);
INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, MaLSDP, MaKM, TongTien, ThueVAT)
VALUES ('HD010', 'NV003', 'KH009', '2024-05-05', NULL, NULL, 700000, 0.05);

-- Chèn dữ liệu mẫu vào bảng ThongTinDatThuePhong
INSERT INTO ThongTinDatThuePhong (MaTTDTP, MaKhachHang, MaPhong, NgayDatPhong, NgayNhanPhong, NgayTraPhong, LoaiThue, TienDaCoc)
VALUES 
    ('TTDTP001', 'KH001', 'TC101', '2024-05-25 08:00:00', '2024-05-25 12:00:00', '2024-05-27 12:00:00', 'NTC', 1000000),
    ('TTDTP002', 'KH002', 'TC102', '2024-05-26 09:00:00', '2024-05-26 12:00:00', '2024-05-28 12:00:00', 'NNC', 1500000),
    ('TTDTP003', 'KH003', 'NC201', '2024-05-27 10:00:00', '2024-05-27 12:00:00', '2024-05-29 12:00:00', 'NCC', 2000000),
    ('TTDTP004', 'KH004', 'CC301', '2024-05-28 11:00:00', '2024-05-28 12:00:00', '2024-05-30 12:00:00', 'NTG', 2500000);


