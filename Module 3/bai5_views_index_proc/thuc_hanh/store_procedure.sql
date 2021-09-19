DELIMITER 
CREATE PROCEDURE findAllCustomers()
BEGIN
  SELECT * FROM customers;
END 
DELIMITER ;
-- gọi procedure
call findAllCustomers();
-- xóa proc
DROP PROCEDURE IF EXISTS `findAllCustomers`;


 