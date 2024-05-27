

USE QuanLyDatPhongKhachSan

SELECT * FROM Phong

SELECT * FROM ThongTinDatThuePhong

SELECT * FROM DichVuSuDung

SELECT * FROM HoaDon

SELECT * FROM ChiTietHoaDon

SELECT * FROM KhuyenMai

-- TỔNG  TIỀN , TÊN KHÁCH HÀNG VỚI NGÀY LẬP  , MÃ HÓA ĐƠN





-- TỈ LỆ PHÒNG TRỐNG THEO NGÀY


SELECT * FROM HoaDon hd JOIN ChiTietHoaDon chd 
ON hd.MaHD = chd.MaHD
WHERE NgayLapHD


-- Lấy tên khách hàng từ mã khách hàng trong hóa đơn
SELECT  hd.MaHD, k.TenKhachHang  FROM HoaDon hd JOIN KhachHang k  
ON hd.MaKH = k.MaKH WHERE hd.MaHD = 'HD27052024001'

-- Xử lý ngày đến ngày đi

SELECT tt.NgayDatPhong, tt.NgayNhanPhong , tt.NgayTraPhong FROM HoaDon hd
JOIN ChiTietHoaDon cthd 
ON hd.MaHD = cthd.MaHD
JOIN ThongTinDatThuePhong tt
ON cthd.MaTTDTP = tt.MaTTDTP
WHERE hd.MaHD = 'HD27052024001'


-- Xử lý thông tin chi tiết hóa đơn ứng với mã TTDPTTP
-- Phân 1 -- PHÒNG
SELECT tt.MaPhong FROM HoaDon hd JOIN ChiTietHoaDon chd 
ON hd.MaHD = chd.MaHD
JOIN ThongTinDatThuePhong tt
ON chd.MaTTDTP = tt.MaTTDTP

-- Phần 2 -- DỊCH VỤ

SELECT dvsd.MaDichVu , dvsd.MaDichVuSuDung , dvsd.MaPhong , dvsd.SoLuong FROM HoaDon hd JOIN ChiTietHoaDon chd
ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt 
ON chd.MaTTDTP = tt.MaTTDTP JOIN DichVuSuDung dvsd
ON tt.MaPhong = dvsd.MaPhong

-- Lấy tên nhân viên từ hóa đơn 
SELECT nv.HoTenNV FROM HoaDon hd JOIN NhanVien nv 
ON hd.MaNV = nv.MaNV
WHERE MaHD = 'HD27052024001'


-- Lấy tiền cọc
SELECT tt.TienDaCoc  FROM HoaDon hd JOIN ChiTietHoaDon chd
ON hd.MaHD = chd.MaHD JOIN ThongTinDatThuePhong tt
ON tt.MaTTDTP = chd.MaTTDTP 
WHERE hd.MaHD = 'HD27052024001'


-- Tìm phòng đang thuê và thông tin khách hàng
SELECT p.MaPhong, p.TrangThaiPhong, kh.TenKhachHang, kh.CCCD_Passport FROM Phong p JOIN ThongTinDatThuePhong tt 
ON p.MaPhong = tt.MaPhong JOIN KhachHang kh
ON tt.MaKhachHang = kh.MaKH WHERE p.TrangThaiPhong = N'Đã thuê'