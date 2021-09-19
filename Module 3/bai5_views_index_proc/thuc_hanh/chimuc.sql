--  tìm thông tin của Julie King (mã số 175)
SELECT * FROM customers WHERE customerNumber = 175;
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;
--  thêm chỉ mục cho bảng customers
ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;
-- Add index theo cặp như bạn add index cho cặp contactFirstName và contactLastName
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
-- xoá chỉ mục trong bảng
ALTER TABLE customers DROP INDEX idx_full_name;