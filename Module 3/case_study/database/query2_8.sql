-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu 
-- là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
use db_furama;
select * from NhanVien
where ((HoTen like "H%") or (HoTen like "T%") or (HoTen like "K%")) and length(HoTen)<15;
-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from KhachHang
where ((year(now())- year(NgaySinh))>18 and (year(now())- year(NgaySinh))<50) and (DiaChi="Đà Nẵng" or DiaChi="Quảng Trị");
-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select count(IDHopDong) as "so_lan_dat",KhachHang.HoTen from HopDong
inner join KhachHang on HopDong.IDKhachHang=KhachHang.IDKhachHang
where KhachHang.IDLoaiKhach=1
group by KhachHang.HoTen
order by so_lan_dat;

-- Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.IDKhachHang, kh.HoTen, lk.TenLoaiKhach, hd.IDHopDong, dv.TenDichVu, hd.NgayLamHopDong, hd.NgayKetThuc,
(dv.ChiPhiThue+(HopDongChiTiet.SoLuong*DichVuDiKem.Gia)) as "tong_tien"
from KhachHang as kh 
left join LoaiKhach as lk on kh.IDLoaiKhach=lk.IDLoaiKhach
left join HopDong as hd on kh.IDKhachHang=hd.IDKhachHang
left join DichVu as dv on hd.IDDichVu=dv.IDDichVu
left join HopDongChiTiet on hd.IDHopDong=HopDongChiTiet.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem=DichVuDiKem.IDDichVuDiKem;

-- Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các 
-- loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select DichVu.IDDichVu,DichVu.TenDichVu,DichVu.DienTich,DichVu.ChiPhiThue,LoaiDichVu.TenLoaiDichVu
from DichVu
 inner join LoaiDichVu on DichVu.IDLoaiDichVu=LoaiDichVu.IDLoaiDichVu
 left join HopDong on DichVu.IDDichVu=HopDong.IDDichVu
 where DichVu.IDDichVu not in (select IDDichVu from HopDong where NgayLamHopDong > (01-01-2019));
 -- Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ 
 -- đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019
select DichVu.IDDichVu,DichVu.TenDichVu,DichVu.DienTich,DichVu.SoNguoiToiDa,DichVu.ChiPhiThue,LoaiDichVu.TenLoaiDichVu,NgayLamHopDong
from DichVu
inner join LoaiDichVu on DichVu.IDLoaiDichVu=LoaiDichVu.IDLoaiDichVu
 left join HopDong on DichVu.IDDichVu=HopDong.IDDichVu
 where HopDong.IDDichVu in (select IDDichVu from DichVu where year(HopDong.NgayLamHopDong)=2018) and
 HopDong.IDDIchVu not in (select IDDichVu from HopDong where year(HopDong.NgayLamHopDong)=2019);
 -- Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau
 -- cách 1
 select distinct HoTen from KhachHang;
 -- cách 2
 select HoTen from KhachHang
 group by HoTen;
 -- cách 3
  select HoTen from KhachHang
 union
select HoTen from KhachHang;
-- Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
 
 
 
