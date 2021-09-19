use demo;
create table product(
	id int not null,
    productCode varchar(15),
    productName varchar(45) not null,
    productPrice double,
    productAmount double,
    productDesc varchar(45),
    productStatus bit,
    primary key (id)
);
insert into product
values (1,"SP01","Asus",15000,10,"no desc",0),
		(2,"SP02","Acer",15000,10,"no desc",1),
		(3,"SP03","Dell",15000,10,"no desc",0);
create unique index productCode_index
on product (productCode);
create index composite_index
on product (productName,productPrice);
explain select * from product where productCode="SP01";
explain select * from product where productName="Dell" and productPrice=15000;
CREATE VIEW product_views AS
SELECT productCode, productName, productPrice, productStatus
FROM  product;
select * from product_views;
-- cập nhật view
CREATE OR REPLACE VIEW product_views AS
SELECT productCode, productName, productPrice, productStatus, productDesc
FROM product
WHERE productCode like '%SP%';
select * from product_views;
-- xóa views
DROP VIEW product_views;
-- hiển thị tất cả sp
delimiter //
create procedure  find_all_products()
begin
  select * from product;
end //
delimiter ;
call find_all_products();
drop procedure find_all_products;
-- thêm sản phẩm
delimiter //
create procedure insert_product(in id int,in productCode varchar(15),in productName varchar(45),in productPrice double,
in productAmount double,in productDesc varchar(45),in productStatus bit)
begin
insert into product 
values (id,productCode,productName,productPrice,productAmount,productDesc,productStatus);
end //
delimiter ;
call insert_product(4,"SP04","Lenovo",15000,10,"no desc",1);
select * from product;
-- sửa sản phẩm theo id
delimiter //
create procedure update_product(in Id int,in ProductAmount double,in ProductStatus bit)
begin
update product
set
productAmount=ProductAmount and productStatus=ProductStatus
where id=Id;
end //
delimiter ;
call update_product(4,11,0);
drop procedure update_product;
select * from product;
-- xóa sản phẩm
delimiter //
create procedure delete_product(in Id int)
begin
delete from product
where id=Id;
end //
delimiter ;
call delete_product(4);
select * from product;