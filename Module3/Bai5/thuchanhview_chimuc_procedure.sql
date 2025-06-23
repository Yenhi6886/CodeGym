use classicmodels;
select *from customers where customerName = 'Land of Toys Inc.';

explain select *from customers where customerName = 'Land of Toys Inc.';

ALTER TABLE customers ADD INDEX idx_customerName(customerName);
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 

alter table customers add index idx_full_name(contactFirstName,contactLastName);
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';

alter table customers drop index idx_full_name;




DELIMITER //
CREATE PROCEDURE findAllCustomers()
BEGIN
    SELECT * FROM customers;
END //
DELIMITER ;
call findAllCUstomers;

delimiter //
drop procedure if exists `findAllcustomers` //
create procedure findAllcustomers()
begin
select * from customers where customersnumber = 175;
end //
delimiter ;



delimiter //
create procedure getCusById
(in cusNum int (11))
begin
select * from customers where customerNumber = cusNum;
end //
delimiter ;
call getCusById(175);

delimiter //
create procedure getCustomersCOuntByCIty(in in_city varchar(50),out total int)
begin
select count(customerNumber) into total 
from customers
where city = in_city;
end //
delimiter ;
call getCustomersCOuntByCIty('Lyon',@total);
select @total;

delimiter //
create procedure SetCounter( inout counter int, in inc int)
begin
set counter = counter + inc;
end ///
delimiter ;
set @counter = 1;
call setcounter (@counter,1);
call setcounter (@counter,1);
call setcounter (@counter,5);
select @counter;

create view customer_view as
select customerNumber,customerName,phone
from customers;
select * from customer_view;

create or replace view customer_view as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = 'Nantes';
select *from customer_view;
drop view customer_view;