DROP TABLE IF EXISTS products;

CREATE TABLE products(id int AUTO_INCREMENT PRIMARY KEY ,ProductName VARCHAR(50) ,
Price VARCHAR(10),ProductCode VARCHAR(10),ProductExpirationDate  VARCHAR(50),
ProductAvailabilityDate  VARCHAR(50));

INSERT INTO products(ProductName,Price,ProductCode,ProductExpirationDate,ProductAvailabilityDate) values('Student8.5','8.5','015','02/11/2019','01/01/2020'),
('Student6','6','016','03/11/2019','02/01/2020'),('Tourist','15','013','05/11/2019','03/01/2020'),('AD7','13','014','05/11/2020','03/01/2021'),('AS5','15','018','05/11/2020','03/01/2021'),('TP9','15','017','05/11/2020','03/03/2021'),('RT','11','019','05/12/2020','03/12/2021');
COMMIT;