use db_furama;
-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(NgayLamHopDong) as "thang",count(KhachHang.IDKhachHang) as "so_lan_dat",
sum(DichVu.ChiPhiThue+(HopDongChiTiet.SoLuong*DichVuDiKem.Gia)) as "doanh_thu"
from HopDong 
inner join KhachHang on HopDong.IDKhachHang=KhachHang.IDKhachHang
inner join DichVu on HopDong.IDDichVu=DichVu.IDDichVu
inner join HopDongChiTiet on HopDong.IDHopDong=HopDongChiTiet.IDHopDong
inner join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem=DichVuDiKem.IDDichVuDiKem
where year(NgayLamHopDong)=2020
group by thang;
-- 10. Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet)
select HopDong.IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc,count(HopDongChiTiet.IDHopDongChiTiet) as "so_luong_dich_vu_di_kem"
from HopDong inner join HopDongChiTiet on HopDong.IDHopDong=HopDongChiTiet.IDHopDong
group by HopDong.IDHopDong;
-- 11. Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dvdk.*,kh.HoTen from DichVuDiKem as dvdk
left join HopDongChiTiet as hdct on dvdk.IDDichVuDiKem=hdct.IDDichVuDiKem
inner join HopDong as hd on hdct.IDHopDong=hd.IDHopDong
inner join KhachHang as kh on hd.IDKhachHang=kh.IDKhachHang
where kh.IDLoaiKhach=1 and (kh.DiaChi="Vinh" or kh.DiaChi="Quảng Ngãi");
-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết),
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019
select hd.IDHopDong,nv.HoTen as "ho_ten_nv", kh.HoTen as "ho_ten_kh", kh.SDT as "sdt_kh", dv.TenDichVu,count(hdct.IDHopDongChiTiet) as "so_luong_dich_vu_di_kem",hd.TienDatCoc
from HopDong as hd 
inner join NhanVien as nv on hd.IDNhanVien=nv.IDNhanVien
inner join KhachHang as kh on hd.IDKhachHang=kh.IDKhachHang
inner join DichVu as dv on hd.IDDichVu=dv.IDDichVu
inner join HopDongChiTiet as hdct on hd.IDHopDong=hdct.IDHopDong
where not exists(select hd.IDHopDong where NgayLamHopDong between "2020-01-01" and "2020-06-31")
and exists(select hd.IDHopDong where NgayLamHopDong between "2020-10-01" and "2020-12-31")
group by IDHopDong;
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.*, KhachHang.HoTen from DichVuDiKem as dvdk
left join HopDongChiTiet as hdct on dvdk.IDDichVuDiKem=hdct.IDDichVuDiKem
inner join HopDong on hdct.IDHopDong=HopDong.IDHopDong
inner join KhachHang on HopDong.IDKhachHang=KhachHang.IDKhachHang
where  HopDong.IDKhachHang in (select KhachHang.IDKhachHang);
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select hd.IDHopDong, ldv.TenLoaiDichVu, dvdk.TenDichVuDiKem, count(hdct.IDDichVuDiKem) as so_lan_sd
from HopDong as hd 
inner join HopDongChiTiet as hdct on hd.IDHopDong=hdct.IDHopDong
inner join DichVuDiKem as dvdk on hdct.IDDichVuDiKem=dvdk.IDDichVuDiKem
inner join DichVu as dv on hd.IDDichVu=dv.IDDichVu
inner join LoaiDichVu as ldv on dv.IDLoaiDichVu=ldv.IDLoaiDichVu
group by hdct.IDDichVuDiKem
having so_lan_sd=1;
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019
select nv.IDNhanVien, HoTen, td.TrinhDo, bp.TenBoPhan, SDT, DiaChi
from NhanVien as nv 
inner join TrinhDo as td on nv.IDTrinhDo=td.IDTrinhDo
inner join BoPhan as bp on nv.IDBoPhan=bp.IDBoPhan
inner join HopDong as hd on hd.IDNhanVien=nv.IDNhanVien
where year(hd.NgayLamHopDong) between "2019" and "2020"
group by hd.IDNhanVien
having count(hd.IDNhanVien)<3;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
delete from NhanVien
where NhanVien.IDNhanVien not in (select IDNhanVien from HopDong where year(NgayLamHopDong) between "2017" and "2021");
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng 
-- đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
update KhachHang 
inner join HopDong as hd on KhachHang.IDKhachHang=hd.IDKhachHang
inner join DichVu on hd.IDDichVu=DichVu.IDDichVu
inner join HopDongChiTiet as hdct on hdct.IDHopDong=hd.IDHopDong
inner join DichVuDiKem as dvdk on dvdk.IDDichVuDiKem=hdct.IDDichVuDiKem
set IDLoaiKhach=1
where (DichVu.ChiPhiThue+(hdct.SoLuong*dvdk.Gia))>20000 and year(NgayLamHopDong)=2019;
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
delete from KhachHang
where KhachHang.IDKhachHang in (select IDKhachHang from HopDong where NgayLamHopDong< "2016-01-01");
-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi
create temporary table temp(select dvdk.IDDichVuDiKem,count(hdct.IDDichVuDiKem) as "so_lan_sd" from DichVuDiKem as dvdk 
inner join HopDongChiTiet as hdct on dvdk.IDDichVuDiKem=hdct.IDDichVuDiKem
group by  dvdk.IDDichVuDiKem
having so_lan_sd>10);
-- drop temporary table temp
-- select * from temp
update DichVuDiKem as dvdk
set Gia=Gia*2
where dvdk.IDDichVuDiKem in (select temp.IDDichVuDiKem from temp);
-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm
--  ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi
select IDNhanVien, HoTen, Email, SDT, NgaySinh, DiaChi
from NhanVien
union
select IDKhachHang, HoTen, Email, SDT, NgaySinh, DiaChi
from KhachHang;
-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng 
-- cho 1 hoặc nhiều Khách hàng bất kỳ với ngày lập hợp đồng là “12/12/2019”
create view V_NHANVIEN as 
select nv.* from NhanVien as nv 
inner join HopDong as hd on nv.IDNhanVien=hd.IDNhanVien
where hd.NgayLamHopDong="2019-12-12" and nv.DiaChi="Huế";
select * from V_NHANVIEN;
-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
update V_NHANVIEN
set DiaChi="Liên Chiểu"
where DiaChi="Huế";
-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
DELIMITER //
create procedure Sp_1(in IDKhachHang int) 
begin
delete from KhachHang where KhachHang.IDKhachHang=IDKhachHang;
end // 
DELIMITER ;
call Sp_1(11);
-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan
DELIMITER //
create procedure Sp_2()
begin
 insert into HopDong
 value(12,10,10,2,'2020-11-05','2021-02-10',10000);
end // 
DELIMITER ;
call Sp_2();
-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database
set @count=0
DELIMITER //
create trigger Tr_1
after delete on HopDong
for each row
begin
  set @count=(select count(IDHopDong) from HopDong);
end // 
DELIMITER ;
delete from HopDong where IDHopDong=13;
select @count;
