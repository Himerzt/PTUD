

USE QuanLyDatPhongKhachSan

SELECT * FROM Phong

SELECT * FROM ThongTinDatThuePhong

SELECT * FROM DichVuSuDung

SELECT * FROM HoaDon

SELECT * FROM ChiTietHoaDon

-- TỔNG  TIỀN , TÊN KHÁCH HÀNG VỚI NGÀY LẬP  , MÃ HÓA ĐƠN





-- TỈ LỆ PHÒNG TRỐNG THEO NGÀY


SELECT * FROM HoaDon hd JOIN ChiTietHoaDon chd 
ON hd.MaHD = chd.MaHD
WHERE NgayLapHD


-- Lấy tên khách hàng từ mã khách hàng trong hóa đơn
SELECT k.TenKhachHang FROM HoaDon hd JOIN KhachHang k  
ON hd.MaKH = k.MaKH WHERE hd.MaHD = 'HD26052024005'