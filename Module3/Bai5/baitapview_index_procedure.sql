create database demo;
use demo;

create table Products (
Id int auto_increment primary key,
productCode varchar(20),
productName varchar(100),
productPrice decimal(10,2),
productAmount int,
productDescription text,
productStatus varchar(50)
);

insert into Products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
values 
('P001', 'Laptop', 1200.00, 10, 'Gaming Laptop', 'Available'),
('P002', 'Phone', 800.00, 20, 'Smartphone', 'Available'),
('P003', 'Tablet', 500.00, 15, 'Android Tablet', 'Out of Stock');

create unique index idx_product_code on Products(productCode);
create index idx_name_price on Products(productName,productPrice);

explain select * from products where productCode = 'P001';
explain select *from products where productname = 'Phone' and productPrice = 800.00;

create view view_product_basic as
select productCode, productName, productPrice, productStatus
from products;
alter view view_product_basic as
select  productCode, productName, productStatus
from products;
drop view view_product_basic;

delimiter //
create procedure getAllProducts()
begin
select * from products;
end //
delimiter ;

delimiter //
create procedure addProduct(
	IN p_code VARCHAR(20),
    IN p_name VARCHAR(100),
    IN p_price DECIMAL(10,2),
    IN p_amount INT,
    IN p_desc TEXT,
    IN p_status VARCHAR(50)
)
begin
insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
values (p_code, p_name, p_price, p_amount, p_desc, p_status);
end //
delimiter ;

delimiter //
create procedure updateProduceById(
	IN p_id INT,
    IN p_name VARCHAR(100),
    IN p_price DECIMAL(10,2),
    IN p_amount INT,
    IN p_desc TEXT,
    IN p_status VARCHAR(50)
)
begin
update products
set productName = p_name,
        productPrice = p_price,
        productAmount = p_amount,
        productDescription = p_desc,
        productStatus = p_status
        where Id = p_id;
end //
delimiter ;

delimiter //
create procedure deleteProductById(in p_id int)
begin
delete from Products where Id = p_id;
end //
delimiter ;