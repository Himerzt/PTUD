-- Xóa dữ liệu từ tất cả các bảng
DELETE FROM [dbo].[DichVu];
DELETE FROM [dbo].[HangThanhVien];
DELETE FROM [dbo].[LoaiThue];
DELETE FROM [dbo].[LoaiPhong];
DELETE FROM [dbo].[Phong];

-- Insert lại dữ liệu với chữ "N" trước chuỗi tiếng việt cần thêm

-- Dữ liệu Loại thuê
INSERT INTO LoaiThue (MaLoaiThue, KieuThue, GiaThue, MaLoaiPhong)
VALUES
    ('HTC', N'Theo giờ', 60000, 'TC'),
    ('HNC', N'Theo giờ', 100000, 'NC'),
    ('HCC', N'Theo giờ', 150000, 'CC'),
    ('HTG', N'Theo giờ', 225000, 'TG'),
    ('NTC', N'Qua đêm', 360000, 'TC'),
    ('NNC', N'Qua đêm', 560000, 'NC'),
    ('NCC', N'Qua đêm', 800000, 'CC'),
    ('NTG', N'Qua đêm', 1200000, 'TG'),
    ('DTC', N'Theo ngày', 450000, 'TC'),
    ('DNC', N'Theo ngày', 700000, 'NC'),
    ('DCC', N'Theo ngày', 1000000, 'CC'),
    ('DTG', N'Theo ngày', 1500000, 'TG');

-- Dữ liệu Loại Phòng
INSERT INTO LoaiPhong (MaLoaiPhong, TenLoaiPhong, SoGiuong)
VALUES
('TC', N'Tiêu chuẩn', 1),
('NC', N'Nâng cao', 1),
('CC', N'Cao cấp', 2),
('TG', N'Thương gia', 2);

-- Dữ liệu Phòng
INSERT INTO Phong (MaPhong, SoPhong, MaLoaiPhong, TrangThaiPhong)
VALUES
('TC101', 101, 'TC', N'SS'),
('TC102', 102, 'TC', N'SS'),
('TC103', 103, 'TC', N'SS'),
('TC104', 104, 'TC', N'SS'),
('TC105', 105, 'TC', N'SS'),
('TC106', 106, 'TC', N'SS'),
('TC107', 107, 'TC', N'SS'),
('TC108', 108, 'TC', N'SS'),
('TC109', 109, 'TC', N'SS'),
('TC110', 110, 'TC', N'SS'),
('TC201', 201, 'TC', N'SS'),
('TC202', 202, 'TC', N'SS'),
('TC203', 203, 'TC', N'SS'),
('TC204', 204, 'TC', N'SS'),
('TC205', 205, 'TC', N'SS'),
('NC201', 206, 'NC', N'SS'),
('NC202', 207, 'NC', N'SS'),
('NC203', 208, 'NC', N'SS'),
('NC204', 209, 'NC', N'SS'),
('NC205', 210, 'NC', N'SS'),
('NC301', 301, 'NC', N'SS'),
('NC302', 302, 'NC', N'SS'),
('NC303', 303, 'NC', N'SS'),
('NC304', 304, 'NC', N'SS'),
('NC305', 305, 'NC', N'SS'),
('CC301', 306, 'CC', N'SS'),
('CC302', 307, 'CC', N'SS'),
('CC303', 308, 'CC', N'SS'),
('CC304', 309, 'CC', N'SS'),
('CC305', 310, 'CC', N'SS'),
('TG401', 401, 'TG', N'SS'),
('TG402', 402, 'TG', N'SS'),
('CC306', 403, 'CC', N'SS'),
('CC307', 404, 'CC', N'SS'),
('CC308', 405, 'CC', N'SS');

-- Dịch vụ
INSERT INTO DichVu (MaDV, TenDV, GiaDV)
VALUES
('DV001', N'Mini bar', 100000),
('DV002', N'Dịch vụ phòng ăn tối', 200000),
('DV003', N'Dịch vụ giặt là', 150000),
('DV004', N'Dịch vụ massage', 300000),
('DV005', N'Dịch vụ thuê xe', 400000);

-- Hạng thành viên
INSERT INTO [dbo].[HangThanhVien] (MaHang, TenHang, TiLeChietKhau)
VALUES 
('HB', N'Hạng Đồng', 3.75),
('HV', N'Hạng Vàng', 7.5),
('BK', N'Bạc Kim', 11.25),
('LB', N'Lục Bảo', 15),
('KC', N'Kim Cương', 18.75);
