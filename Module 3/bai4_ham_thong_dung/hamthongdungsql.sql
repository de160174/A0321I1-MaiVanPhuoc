-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
select * from `table`
where TEN="Huong";
-- Viết câu lệnh lấy ra tổng số tiền của Huong
select count(SOTIEN) as "Tong tien"
from `table`
where TEN="Huong";
-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
select TEN
from `table`
group by (TEN);
