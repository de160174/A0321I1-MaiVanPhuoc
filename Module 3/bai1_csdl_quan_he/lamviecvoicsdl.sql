use classicmodels;
--  hiển thị thông tin khách hàng có tên là Atelier Graphique
SELECT * 
FROM customers
where customerName='Atelier Graphique'
limit 0,30;
-- hiển thị thông tin khách hàng có tên là chứa ký tự A
SELECT * 
FROM customers
where customerName like '%A%'
limit 0,30;
-- hiển thị thông tin khách hàng có city ở một trong những vùng Nantes, Las Vegas, Warszawa, NYC.
SELECT * 
FROM customers
where city 
in('Nantes', 'Las Vegas', 'Warszawa', 'NYC')
limit 0,30;